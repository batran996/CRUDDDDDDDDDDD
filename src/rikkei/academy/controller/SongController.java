package rikkei.academy.controller;

import rikkei.academy.model.Song;
import rikkei.academy.service.song.ISongSevice;
import rikkei.academy.service.song.SongSeviceIMPL;

import java.util.List;

public class SongController {
    public ISongSevice songSevice = new SongSeviceIMPL();
    public List<Song>showlistSong(){
         return songSevice.findAll();
    }
    public void createSong(Song song){
        songSevice.save(song);
    }
}
