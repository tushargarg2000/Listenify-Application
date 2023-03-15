package listenify;

import java.util.*;

public class Main {

    public static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Album album = new Album("Old Hindi Songs","Arijit Singh");

        album.addSongToAlbum("Pathaan",4.5);
        album.addSongToAlbum("Channa mereya",3.5);
        album.addSongToAlbum("Naina",5.0);

        albums.add(album);

        album = new Album("New Songs","Prateek Kuhad");

        album.addSongToAlbum("Kasoor",4.5);
        album.addSongToAlbum("Tum mile",3.5);
        album.addSongToAlbum("Baarishein",4.5);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addSongToPlayList("Pathaan",playList_1);
        albums.get(0).addSongToPlayList("Naina",playList_1);
        albums.get(1).addSongToPlayList("Kasoor",playList_1);
        albums.get(1).addSongToPlayList("Baarishein",playList_1);

        //print the playList that has been added
        play(playList_1);
    }
    public static void play(LinkedList<Song> playList){

        ListIterator<Song> listIterator = playList.listIterator();

        //Validation checks
        if(playList.size()==0){
            return ;
        }

        Scanner sc = new Scanner(System.in);

        printMenu();

        System.out.println("Now playing "+listIterator.next());

        boolean forward = true;

        boolean quit = false;

        while(quit==false){

            int choice = sc.nextInt();
            switch (choice){
                case 0:
                    quit = true;
                    break;

                case 1:
                    if(forward==false)
                    {
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println(listIterator.next().toString());
                    }else{
                        System.out.println("you are at the last song");
                    }
                    //To play the next Song
                    break;
                case 2:
                    if(forward==true){ //already towards the right of the last printed value
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous().toString());
                    }else{
                        System.out.println("You are already at the first Song");
                    }
                    //To the previous Song
                    break;
                case 3:
                    if(forward==true){ //I am on RHS : print the previous song
                        System.out.println(listIterator.previous().toString());
                        forward = false;
                    }else{ //forward is false and I am on the LHS
                        System.out.println(listIterator.next().toString());
                        forward = true;
                    }
                    //Replay the current song
                    break;
                case 4:
                    printAllSongs(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    //Delete a song
                    if (playList.size() > 0)
                    {
                        System.out.println(listIterator.previous().toString() + " has been removed from the playlist.");
                        listIterator.remove();
                        if (playList.size()>0 && listIterator.hasPrevious())
                        {
                            System.out.println("Now playing " + listIterator.next().toString());
                        }
                        else if (playList.size()>0 && listIterator.hasNext())
                        {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }
                    } else
                    {
                        System.out.println("The playlist is already empty.");
                    }
                    break;
            }



        }

    }
    private static void printAllSongs(LinkedList<Song> songs){

        //Try for each loop
        ListIterator<Song> listIterator = songs.listIterator();

        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }


}