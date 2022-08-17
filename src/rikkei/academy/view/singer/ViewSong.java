package rikkei.academy.view.singer;

import rikkei.academy.config.Config;
import rikkei.academy.controller.SingerController;
import rikkei.academy.controller.SongController;
import rikkei.academy.model.Singer;
import rikkei.academy.model.Song;

import java.util.ArrayList;
import java.util.List;

public class ViewSong {
    private SongController songController = new SongController();
    private List<Song> songList = songController.showlistSong();
    private SingerController singerController = new SingerController();
    private List<Singer> singerList = singerController.showListSinger();
    public ViewSong(){
        System.out.println("-----------SONG MANAGE------------");
        System.out.println("1. Create Song");
        System.out.println("2. Show List Song");
        System.out.println("3. Detail Song");
        System.out.println("4. Update Song");
        System.out.println("5. Delete Song");
        System.out.println("6. Sort Song");
        int chooseSinger = Config.scanner().nextInt();
        switch (chooseSinger) {
            case 1:
               formCreateSong();
                break;
            case 2:
                formShowListSong();
                break;
//            case 3:
//                formDetailSinger();
//                break;
//            case 4:
//                formEditSinger();
//                break;
//            case 5:
//                formDeleteSinger();
//                break;
//            case 6:
//                formShowListSingerAfterSort();
//                break;
        }
    }
    private void formCreateSong(){
        int idSong;
        if(songList.size()==0){
            idSong = 1;
        } else {
            idSong = songList.get(songList.size()-1).getId()+1;
        }
        System.out.println("Enter the name Song: ");
        String name = Config.scanner().nextLine();
        List<Singer> listSelect = new ArrayList<>();
        selecSinger(listSelect);
        Song song = new Song(idSong,name,0,0,listSelect);
        songController.createSong(song);
        songController.showlistSong();
        System.out.println("CREATA SONG SUCCESS");
        showListSong();

    }
    private void formShowListSong(){
        showListSong();
        System.out.println("Enter any key ti continue-enter quit to exit select singer ");
        String exitSelect = Config.scanner().nextLine();
        if (exitSelect.equalsIgnoreCase("quit")){
            new ViewSong();
        }

    }

    private void showListSong() {
        System.out.println("=====ID=======NAME======LISTEN======LINE======");
        for (int i = 0; i < songList.size(); i++) {
            System.out.println(songList.get(i).getId()+"===="+songList.get(i).getName()+"===="+songList.get(i).getListen()
            +"===="+songList.get(i).getLike()+"==="+songList.get(i).getSingerList());

        }
    }

    private List<Singer> selecSinger(List<Singer> listSelect) {
//        while (true){
            System.out.println("======ID=====NAME=====");
            System.out.println("====ID====NAME=====");
            for (int i = 0; i < singerList.size(); i++) {
                System.out.println("===="+singerList.get(i).getId()+"===="+singerList.get(i).getName());
            }
            System.out.println("Enter the id of Singer to select: ");
            int idSinger = Config.scanner().nextInt();
            Singer singer = singerController.detailSinger(idSinger);
            listSelect.add(singer);
            System.out.println("Enter any key ti continue-enter quit to exit select singer ");
            String exitSelect = Config.scanner().nextLine();
            if (exitSelect.equalsIgnoreCase("quit")){
                return listSelect;
            }selecSinger(listSelect);
//        }
        return listSelect;
    }

}



