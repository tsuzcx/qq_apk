import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class wxc
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public wxc(TribeVideoPlugin paramTribeVideoPlugin, wxl paramwxl) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (paramTVK_IMediaPlayer.getCurrentPostion() == 0L) {
      axqy.b(null, "dc00899", "BizTechReport", ((BaseActivity)TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin)).getCurrentAccountUin(), "tribe_video", "video_prepared_time", 0, 0, Long.toString(System.currentTimeMillis() - wxl.a(this.jdField_a_of_type_Wxl)), Integer.toString(bbfj.b(TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin))), "", "");
    }
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(5, wxl.a(this.jdField_a_of_type_Wxl));
      paramTVK_IMediaPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramTVK_IMediaPlayer.obj = wxl.a(this.jdField_a_of_type_Wxl);
      paramTVK_IMediaPlayer.what = 5;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramTVK_IMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wxc
 * JD-Core Version:    0.7.0.1
 */