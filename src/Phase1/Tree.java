/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Phase1;

/**
 *
 * @author SHEREF ZEDAN
 */
import java.util.ArrayList;
import java.util.Stack;

//to print json
//philopateer Moheb
public class Tree {
    private TreeNode root;
    private XMLChecker xmlChecker;
    private int counter;
    private String[]Tags;
    private String[]words;
    private StringBuilder Json_Text;
    private Stack<String> indent;

    private void setRoot(TreeNode root) {
        this.root = root;
    }

    public Tree(XMLChecker xmlChecker) {
        this.xmlChecker = xmlChecker;
        counter = 0;
        Json_Text=new StringBuilder();
        indent=new Stack<>();
    }

    public TreeNode makeNode(String name,String data){
        TreeNode treeNode=new TreeNode();
        treeNode.setName(name);
        treeNode.setData(data);
        return treeNode;

    }


    //O(n*n) //n element ,n childs we make recursion at each element worst case
    public ArrayList<TreeNode> PutItInTree(TreeNode node,int index) {
        ArrayList<TreeNode>childerns=new ArrayList<>();
        for (int i=index;i<Tags.length;i++){
            if (Tags[i] != "Visited"){
                String closingtagname = Tags[i].substring(2, Tags[i].length() - 1);
                String nameTemp = node.getName().substring(1, node.getName().length() - 1);
                TreeNode n= new TreeNode();
                String p = Tags[i].substring(0, 2);
                if(!nameTemp.equals(closingtagname)){
                    if (!p.equals("</")) {
                        String temp = Tags[i].substring(1, Tags[i].length() - 1);
                        String temp2 = Tags[i + 1].substring(2, Tags[i + 1].length() - 1);

                        if (temp.equals(temp2)) {//<id></id>?id==id? to check equality of tags
                            Tags[i] = "Visited";
                            TreeNode treeNodeTemp=makeNode(temp, words[counter]);
                            treeNodeTemp.setIsparent(false);
                            node.setIsparent(false);
                            childerns.add(treeNodeTemp);
                            counter++;
                        } else {
                            n.setName(Tags[i]);
                            Tags[i] = "Visited";
                            n.setChilds(PutItInTree(n,index+1));
                            childerns.add(n);
                            node.setChilds(childerns);
                        }
                    }
                    else {
                        Tags[i]="Visited";
                    }
                }
                else{
                    Tags[i]="Visited";
                    childerns.get(childerns.size()-1).setLastChild(true);
                    return childerns;
                }
            }

        }
        childerns.get(childerns.size()-1).setLastChild(true);
        return childerns;
        }


    public void TreeReady(){
        Tags = xmlChecker.getTags();
        words = new String[xmlChecker.getWords().length];
        int j = 0;
        for (int i = 0; i < xmlChecker.getWords().length; i++) {
            if (xmlChecker.getWords()[i] != "") {
                words[j++] = xmlChecker.getWords()[i];
            }
        }
        root =new TreeNode();
        int i;
        for( i=0;i<Tags.length;i++){
            if(XMLChecker.isCommentTag(Tags[i])||XMLChecker.isPreprocessorTag(Tags[i])){
                Tags[i]="Visited";
                continue;
            }
            else{
                root.setName(Tags[i]);
                break;
            }
        }
        root.setChilds(PutItInTree(root,i));
        root.getChilds().get(root.getChilds().size()-1).setLastChild(true);
    }

    public boolean isNumeric(String s){
        try {
            Integer num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public StringBuilder printToJson(TreeNode node){
        ArrayList<TreeNode>nodes=node.getChilds();
        for (int i=0;i<nodes.size();i++){
            if(nodes.get(i).getChilds().size()==0){
                if(indent.isEmpty()){//most recently added
                    Json_Text.append("{\n");
                    indent.push("    ");
                }
                if(isNumeric(nodes.get(i).getData())) {
                    Json_Text.append(indent.peek() + "\"" + nodes.get(i).getName() + "\": " + nodes.get(i).getData());
                }
                else{
                    if(nodes.get(i).getData().length()>30){
                        Json_Text.append(indent.peek() + "\"" + nodes.get(i).getName() + "\": " + "[\n");
                        indent.push(indent.peek()+"   ");
                        Json_Text.append(indent.peek()+"\""+nodes.get(i).getData()+"\"");
                        indent.pop();
                        Json_Text.append("\n"+indent.peek()+"]");
                    }
                    else {
                        Json_Text.append(indent.peek() + "\"" + nodes.get(i).getName() + "\": " + "\"" + nodes.get(i).getData() + "\"");
                    }
                }
                if(nodes.size()>1&&i!=(nodes.size()-1)){
                    Json_Text.append(",\n");
                }
            }
            else {
                if(indent.isEmpty()){
                    Json_Text.append("{\n");
                    indent.push("    ");

                }
                if(nodes.get(i).Isparent()) {
                    Json_Text.append(indent.peek() + "\"" + nodes.get(i).getName().substring(1, nodes.get(i).getName().length() - 1) + "\": [\n");
                }
                else{
                    Json_Text.append(indent.peek() + "\"" + nodes.get(i).getName().substring(1, nodes.get(i).getName().length() - 1) + "\": {\n");
                }
                    String indention = indent.peek() + "    ";
                    indent.push(indention);
                    Json_Text = printToJson(nodes.get(i));

                    indent.pop();

            }
        }
        if(node.getName()!="root") {
            if (node.Isparent()) {
                if (node.isLastChild()) {
                    Json_Text.append("\n" + indent.peek() + "]");
                } else {
                    Json_Text.append("\n" + indent.peek() + "],\n");
                }
            } else {
                if (node.isLastChild()) {
                    Json_Text.append("\n" + indent.peek() + "}");
                } else {
                    Json_Text.append("\n" + indent.peek() + "},\n");

                }
            }
        }
        return Json_Text;
    }
    public StringBuilder Print(){
        root.setName("root");
        printToJson(root);
        Json_Text.append("\n}\n");
        return Json_Text;

    }

    public TreeNode getRoot() {
        return root;
    }

    boolean isEmpty(){
        return root==null;
    }

}