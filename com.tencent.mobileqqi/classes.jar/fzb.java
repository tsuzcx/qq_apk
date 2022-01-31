import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.qphone.base.util.QLog;

public class fzb
  extends FMObserver
{
  public fzb(OnlineFileSessionCenter paramOnlineFileSessionCenter) {}
  
  protected void a(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileProgressDirectDone sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      return;
      localOnlineFileSessionWorker = this.a.a(paramLong);
      if (localOnlineFileSessionWorker == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileProgressDirectDone");
        return;
      }
      localOnlineFileSessionWorker.h();
    } while (!localOnlineFileSessionWorker.c());
    this.a.c(paramLong);
  }
  
  protected void b(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileRecvButSenderReplayTimeOut sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      return;
      localOnlineFileSessionWorker = this.a.a(paramLong);
      if (localOnlineFileSessionWorker == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileRecvButSenderReplayTimeOut");
        return;
      }
      localOnlineFileSessionWorker.j();
    } while (!localOnlineFileSessionWorker.c());
    this.a.c(paramLong);
  }
  
  protected void c(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileQueryUpProgressTimeOut sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      return;
      localOnlineFileSessionWorker = this.a.a(paramLong);
      if (localOnlineFileSessionWorker == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileQueryUpProgressTimeOut");
        return;
      }
      localOnlineFileSessionWorker.l();
    } while (!localOnlineFileSessionWorker.c());
    this.a.c(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fzb
 * JD-Core Version:    0.7.0.1
 */