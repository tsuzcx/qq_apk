import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;

public class wdj
  implements tql
{
  public wdj(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void a_(tqg paramtqg)
  {
    try
    {
      if (QQPlayerService.a()) {
        QQPlayerService.c(this.a.getActivity());
      }
      return;
    }
    catch (Exception paramtqg)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubscribeVideoDetailFragment", 2, "QQPlayerService.stopPlayMusic exception!", paramtqg);
      }
      paramtqg.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wdj
 * JD-Core Version:    0.7.0.1
 */