import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;

public class wqv
  implements ude
{
  public wqv(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void a_(ucz paramucz)
  {
    try
    {
      if (QQPlayerService.a()) {
        QQPlayerService.c(this.a.getActivity());
      }
      return;
    }
    catch (Exception paramucz)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubscribeVideoDetailFragment", 2, "QQPlayerService.stopPlayMusic exception!", paramucz);
      }
      paramucz.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqv
 * JD-Core Version:    0.7.0.1
 */