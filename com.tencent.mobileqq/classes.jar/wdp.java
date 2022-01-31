import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;

public class wdp
  implements Runnable
{
  public wdp(VideoStatusTipsBar paramVideoStatusTipsBar) {}
  
  public void run()
  {
    VideoStatusTipsBar.a(this.a).a().e(true);
    this.a.a("RefreshMultiStateRunnable", VideoStatusTipsBar.a(this.a).jdField_a_of_type_Int, VideoStatusTipsBar.a(this.a).jdField_a_of_type_JavaLangString, 0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wdp
 * JD-Core Version:    0.7.0.1
 */