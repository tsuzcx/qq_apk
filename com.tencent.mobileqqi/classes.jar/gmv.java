import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;

public class gmv
  implements Runnable
{
  public gmv(C2CPicUploadProcessor paramC2CPicUploadProcessor) {}
  
  public void run()
  {
    switch (C2CPicUploadProcessor.a(this.a))
    {
    default: 
      return;
    case 0: 
      C2CPicUploadProcessor.a(this.a, "<BDH_LOG> sendFileNotBlockCallThread() BUT current status is INIT");
      return;
    case 2: 
      C2CPicUploadProcessor.a(this.a, "<BDH_LOG> sendFileNotBlockCallThread() resume HTTP channel");
      this.a.r();
      return;
    }
    if (C2CPicUploadProcessor.a(this.a) != null)
    {
      C2CPicUploadProcessor.a(this.a, "<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
      this.a.a.a().resumeTransactionTask(C2CPicUploadProcessor.a(this.a));
      return;
    }
    C2CPicUploadProcessor.a(this.a, "<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel, but trans == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gmv
 * JD-Core Version:    0.7.0.1
 */