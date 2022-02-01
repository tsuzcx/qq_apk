import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.PlaybackThread;

public class xrm
  implements xrj
{
  public xrm(MediaPlayer paramMediaPlayer) {}
  
  public void a(xrh paramxrh)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a()) && (!this.a.e) && (this.a.jdField_a_of_type_Xrf.b() < 2000000L) && (!this.a.jdField_a_of_type_Xrf.b()))
    {
      this.a.e = true;
      this.a.jdField_a_of_type_Xrn.sendMessage(this.a.jdField_a_of_type_Xrn.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrm
 * JD-Core Version:    0.7.0.1
 */