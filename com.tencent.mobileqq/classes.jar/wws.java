import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.PlaybackThread;

public class wws
  implements wwp
{
  public wws(MediaPlayer paramMediaPlayer) {}
  
  public void a(wwn paramwwn)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a()) && (!this.a.e) && (this.a.jdField_a_of_type_Wwl.b() < 2000000L) && (!this.a.jdField_a_of_type_Wwl.b()))
    {
      this.a.e = true;
      this.a.jdField_a_of_type_Wwt.sendMessage(this.a.jdField_a_of_type_Wwt.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wws
 * JD-Core Version:    0.7.0.1
 */