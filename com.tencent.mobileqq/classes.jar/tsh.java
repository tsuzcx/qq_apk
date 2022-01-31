import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.PlaybackThread;

public class tsh
  implements tse
{
  public tsh(MediaPlayer paramMediaPlayer) {}
  
  public void a(tsc paramtsc)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a()) && (!this.a.e) && (this.a.jdField_a_of_type_Tsa.b() < 2000000L) && (!this.a.jdField_a_of_type_Tsa.b()))
    {
      this.a.e = true;
      this.a.jdField_a_of_type_Tsi.sendMessage(this.a.jdField_a_of_type_Tsi.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsh
 * JD-Core Version:    0.7.0.1
 */