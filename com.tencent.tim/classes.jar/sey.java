import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class sey
  extends pem
{
  public sey(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    try
    {
      if (QQPlayerService.isPlaying()) {
        QQPlayerService.eG(this.this$0.getActivity());
      }
      return;
    }
    catch (Exception paramISuperPlayer)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubscribeVideoDetailFragment", 2, "QQPlayerService.stopPlayMusic exception!", paramISuperPlayer);
      }
      paramISuperPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sey
 * JD-Core Version:    0.7.0.1
 */