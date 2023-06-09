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

public class Post implements Item{
    private ArrayList<String> topics=new ArrayList<>();
    private String text;


    public ArrayList<String> getTopicsListCopy() {
        ArrayList<String> tempTopic=new ArrayList<>();
        tempTopic.addAll(topics);
        return tempTopic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void addTopic(String s){
        topics.add(s);
    }
    @Override
    public String getType(){
        return "Post";
    }
    @Override
    public String toString(){
        return getTopicsListCopy().toString()+"\n"+getText()+getType();
    }

    public static void main(String[] args) {
        Post p=new Post();
        ArrayList<String>s=new ArrayList<>();
        p.addTopic("Hello");
        p.addTopic("I");
        p.addTopic("am Philo");
        p.setText("My acc");
        p.addTopic("lllllllllll");

        System.out.println(p);
    }
}
