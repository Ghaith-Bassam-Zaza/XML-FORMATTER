/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phase2;

/**
 *
 * @author SHEREF ZEDAN
 */
import Phase1.Post;
import Phase1.PostEmptyException;
import Phase1.User;
import java.util.ArrayList;

public  class PostSearch {
    private  ArrayList<Post> searchResults ;

    public PostSearch() {
        searchResults = new ArrayList<>() ;
    }

    private static void  toLowerCase(ArrayList<String> topics)
    { 
        for(var i : topics)
            i = i.toLowerCase();
    }
    public  void searchForPost(User[] users , String key )
    { 
        for(int i = 0 ; i < users.length ; i++)
        { 
            ArrayList<Post> postList = users[i].getPostsListCopy() ;
          
            for(int j = 0 ; j < postList.size() ; j++)
            { 
                ArrayList<String> topics = postList.get(j).getTopicsListCopy();
                toLowerCase(topics);
                if(topics.contains(key) || postList.get(j).getText().toLowerCase().contains(key))
                { 
                     searchResults.add(postList.get(j));
                }
                                   
            }
        }
    }
    
    public  ArrayList<Post> getPosts()
    { 
        if(searchResults == null)
            throw new PostEmptyException("No search results\nThere are no posts with the matching keyword\n");
        return searchResults ;
    }
    
}