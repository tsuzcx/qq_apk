import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;

public class zyy
  implements MediaPlayer.OnPreparedListener
{
  public zyy(RedPacketKSongFragment paramRedPacketKSongFragment, boolean paramBoolean) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "playSong onPrepared");
    }
    RedPacketKSongFragment.a(this.this$0, true);
    aqge.m(this.this$0.getActivity(), true);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.stop(true);
    }
    paramMediaPlayer.start();
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.hk(this.buG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyy
 * JD-Core Version:    0.7.0.1
 */