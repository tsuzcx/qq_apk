import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class ylv
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public ylv(TribeVideoPlugin paramTribeVideoPlugin, yme paramyme) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (paramTVK_IMediaPlayer.getCurrentPostion() == 0L) {
      azmj.b(null, "dc00899", "BizTechReport", ((BaseActivity)TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin)).getCurrentAccountUin(), "tribe_video", "video_prepared_time", 0, 0, Long.toString(System.currentTimeMillis() - yme.a(this.jdField_a_of_type_Yme)), Integer.toString(bdee.b(TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin))), "", "");
    }
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(5, yme.a(this.jdField_a_of_type_Yme));
      paramTVK_IMediaPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramTVK_IMediaPlayer.obj = yme.a(this.jdField_a_of_type_Yme);
      paramTVK_IMediaPlayer.what = 5;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramTVK_IMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ylv
 * JD-Core Version:    0.7.0.1
 */