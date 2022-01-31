import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.PlaybackThread;

public class ufa
  implements uex
{
  public ufa(MediaPlayer paramMediaPlayer) {}
  
  public void a(uev paramuev)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a()) && (!this.a.e) && (this.a.jdField_a_of_type_Uet.b() < 2000000L) && (!this.a.jdField_a_of_type_Uet.b()))
    {
      this.a.e = true;
      this.a.jdField_a_of_type_Ufb.sendMessage(this.a.jdField_a_of_type_Ufb.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufa
 * JD-Core Version:    0.7.0.1
 */