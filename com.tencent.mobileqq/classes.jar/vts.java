import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.PlaybackThread;

public class vts
  implements vtp
{
  public vts(MediaPlayer paramMediaPlayer) {}
  
  public void a(vtn paramvtn)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a()) && (!this.a.e) && (this.a.jdField_a_of_type_Vtl.b() < 2000000L) && (!this.a.jdField_a_of_type_Vtl.b()))
    {
      this.a.e = true;
      this.a.jdField_a_of_type_Vtt.sendMessage(this.a.jdField_a_of_type_Vtt.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vts
 * JD-Core Version:    0.7.0.1
 */