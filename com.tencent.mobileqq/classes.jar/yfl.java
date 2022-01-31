import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;

public class yfl
  implements vrw
{
  public yfl(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void a(vrr paramvrr)
  {
    try
    {
      if (QQPlayerService.a()) {
        QQPlayerService.c(this.a.getActivity());
      }
      return;
    }
    catch (Exception paramvrr)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubscribeVideoDetailFragment", 2, "QQPlayerService.stopPlayMusic exception!", paramvrr);
      }
      paramvrr.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfl
 * JD-Core Version:    0.7.0.1
 */