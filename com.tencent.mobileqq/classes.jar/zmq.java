import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.qphone.base.util.QLog;

public class zmq
  implements Runnable
{
  public zmq(IndividualRedPacketManager paramIndividualRedPacketManager) {}
  
  public void run()
  {
    this.a.a(true);
    if (QLog.isColorLevel()) {
      QLog.d(IndividualRedPacketManager.b(), 2, "AIO_BG_WIDTH:" + this.a.b);
    }
    this.a.a().e();
    this.a.a().d();
    this.a.a().c();
    this.a.a();
    if (this.a.j > 0)
    {
      IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = this.a.a().a(String.valueOf(this.a.j), true);
      if ((localRedPacketTemplateInfo == null) || (localRedPacketTemplateInfo.a == null) || (localRedPacketTemplateInfo.b == null) || (localRedPacketTemplateInfo.c == null)) {
        this.a.a().a(16L, String.valueOf(this.a.j), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zmq
 * JD-Core Version:    0.7.0.1
 */