import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.PlaybackThread;

public class ufd
  implements ufa
{
  public ufd(MediaPlayer paramMediaPlayer) {}
  
  public void a(uey paramuey)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a()) && (!this.a.e) && (this.a.jdField_a_of_type_Uew.b() < 2000000L) && (!this.a.jdField_a_of_type_Uew.b()))
    {
      this.a.e = true;
      this.a.jdField_a_of_type_Ufe.sendMessage(this.a.jdField_a_of_type_Ufe.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufd
 * JD-Core Version:    0.7.0.1
 */