import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.PlaybackThread;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.a;

public class qly
  implements qlv.b
{
  public qly(MediaPlayer paramMediaPlayer) {}
  
  public void b(qlv paramqlv)
  {
    if ((this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.isPaused()) && (!this.this$0.aEk) && (this.this$0.jdField_a_of_type_Qlt.getCachedDuration() < 2000000L) && (!this.this$0.jdField_a_of_type_Qlt.hasCacheReachedEndOfStream()))
    {
      this.this$0.aEk = true;
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qly
 * JD-Core Version:    0.7.0.1
 */