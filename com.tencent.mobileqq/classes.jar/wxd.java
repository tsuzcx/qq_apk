import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class wxd
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public wxd(TribeVideoPlugin paramTribeVideoPlugin, wxl paramwxl) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(6, wxl.a(this.jdField_a_of_type_Wxl));
      paramTVK_IMediaPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramTVK_IMediaPlayer.obj = wxl.a(this.jdField_a_of_type_Wxl);
      paramTVK_IMediaPlayer.what = 6;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramTVK_IMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wxd
 * JD-Core Version:    0.7.0.1
 */