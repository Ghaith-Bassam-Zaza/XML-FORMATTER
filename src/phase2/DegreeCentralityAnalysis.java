/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phase2;

import Phase1.User;
import java.util.ArrayList;

/**
 *
 * @author SHEREF ZEDAN
 */
public class DegreeCentralityAnalysis  {
    private ArrayList<User> users ;
    private ArrayList<User> topUsers ;
    private  ArrayList<Float> centralityResults ;
    public DegreeCentralityAnalysis(ArrayList<User> users) {
        this.users = users;
        topUsers = new ArrayList<>() ; 
    }
// returns the users with the highest degree centrality 
   
    public ArrayList<User> getUsersWithHighestCentrality() {
       int maxFollowersIndex = 0; 
       float totalUsers = users.size() -1 ;
        for(int i = 1 ; i < users.size() ; i++)
        { 
            centralityResults.add(users.get(i).getFollowersListSize() / totalUsers);
            if( users.get(i).getFollowersListSize() >  users.get(maxFollowersIndex).getFollowersListSize())
            { 
                maxFollowersIndex = i;
            }
            else if(users.get(i).getFollowersListSize() ==  users.get(maxFollowersIndex).getFollowersListSize())
                topUsers.add(users.get(i));
        }
        topUsers.add(users.get(maxFollowersIndex)) ;
        return topUsers ;
    }
//returns normalized degree centrality for all users . 
    
    public ArrayList<Float> getCentrality() {
       return centralityResults ;
    }
    
}
