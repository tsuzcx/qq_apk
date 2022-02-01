import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.PlaybackThread;

public class xvh
  implements xve
{
  public xvh(MediaPlayer paramMediaPlayer) {}
  
  public void a(xvc paramxvc)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a()) && (!this.a.e) && (this.a.jdField_a_of_type_Xva.b() < 2000000L) && (!this.a.jdField_a_of_type_Xva.b()))
    {
      this.a.e = true;
      this.a.jdField_a_of_type_Xvi.sendMessage(this.a.jdField_a_of_type_Xvi.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvh
 * JD-Core Version:    0.7.0.1
 */