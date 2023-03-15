package listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    public String albumName;

    public String artistName;

    public List<Song> songList;

    //Initialize the songList
    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSongInAlbum(String title){

        //Iterate over the arrayList and match
        //each Songs title with title
        for(Song song:songList){

            if((song.title).equals(title)){
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String title,double duration){
        //Check if the song is already present we will not add
        //otherwise we will create a new Song and add it to the songList;

        if(findSongInAlbum(title)==true){
            return "Song is already present";
        }else{
            //I need to create a Song Object and then add it to songList
            Song newSong = new Song(title,duration);
            songList.add(newSong);
            return "New Song has been added sucessfully";
        }
    }

    public String addSongToPlayList(int trackNo, LinkedList<Song> playList){

            //TrackNo is a no in the songList

            //TrackNo : 1,2,3,4,5......
            //indices : 0,1,2,3,4.....
            int index = trackNo -1;

            //Checking for validity of index
            if(index>=0 && index<this.songList.size()){

                Song song = this.songList.get(index);
                playList.add(song);

                return "Song added to the playList";
            }
            return "Invalid track No";
    }

    public String addSongToPlayList(String title,LinkedList<Song> playList){

        //I need to find out that Song with that title
        //and put it in the playlist

        //Iterate over the songList:
        for(Song song : songList){

            if(song.title==title){
                playList.add(song);
                return "Song has been added successfully";
            }
        }
        return "Song does not exist";
    }

}
