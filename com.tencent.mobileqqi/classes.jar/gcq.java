import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;

public class gcq
  implements Runnable
{
  public gcq(QQPlayerService paramQQPlayerService, QQPlayerService.QQPlayerCallback paramQQPlayerCallback, SongInfo paramSongInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback.onPlaySongChanged(this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gcq
 * JD-Core Version:    0.7.0.1
 */