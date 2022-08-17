package rikkei.academy.service.song;

import rikkei.academy.config.Config;
import rikkei.academy.model.Song;

import java.util.List;

public class SongSeviceIMPL implements ISongSevice {
    public static final String PATH_SONG = "C:\\Users\\WINDOWS\\Desktop\\MD2-Singer-Song-master\\MD2-Singer-Song-master\\src\\rikkei\\academy\\database\\song.txt";
    public static List<Song> songList = new Config<Song>().readFile(PATH_SONG);
    @Override
    public List findAll() {
        new Config<Song>().writeFile(PATH_SONG,songList);
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }

    @Override
    public Song findByID(int id) {
        return null;
    }


    @Override
    public void deleteById(int id) {

    }
}
