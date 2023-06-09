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

public class User implements Item {

    private int ID;
    private String name;
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<User> followers = new ArrayList<>();

    public User(int ID, String name) {

        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Post> getPostsListCopy() {
        ArrayList<Post> postsTemp = new ArrayList<>();
        postsTemp.addAll(posts);
        return postsTemp;
    }
    public int getFollowersListSize()
        {
            return followers.size();
        }
    public ArrayList<User> getFollowersListCopy() {
        ArrayList<User> followersTemp =new ArrayList<>();
        followersTemp.addAll(followers);
        return followersTemp;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void addFollower(User user) {
        followers.add(user);
    }


    @Override
    public String getType() {
        return "User";
    }

    @Override
    public String toString() {
        String s = "ID: " + getID() + "\n"
                + "Name: " + getName() + "\n"
                + "Posts: " + getPostsListCopy().toString() + "\n";
        s += "Following: \n";
        for (int i = 0; i < followers.size(); i++) {
            s += "Name: " + followers.get(i).getName() + "\n" + "ID: " + followers.get(i).getID() + "\n";
        }
        return s;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }
    
    public int getFollowersCount(){
        return followers.size();
    }

    public static void main(String[] args) {
        User philo = new User(1,"philo");
        User samy = new User(2,"samia");
        User sa = new User(3,"sa");
        philo.addFollower(samy);
        philo.addFollower(sa);
        Post p = new Post();
        p.setText("i love egypt");
        p.addTopic("i ");
        p.addTopic("Love");
        philo.getPostsListCopy();
        p.addTopic("ssssssssssssss");
        philo.addPost(p);
        System.out.println(philo);
    }
}
