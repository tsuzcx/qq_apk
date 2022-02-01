import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.TroopFileDetailBrowserActivity;

public class atyw
  extends atsn
{
  public atyw(TroopFileDetailBrowserActivity paramTroopFileDetailBrowserActivity) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      if ((paramString != null) && (paramString.length() > 0)) {
        audx.JI(paramString);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.a.b == null) || (this.a.app == null));
        if (this.a.b.fR() == paramLong) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("FMObserver<FileAssistant>", 4, "difference nSessionId");
      return;
    } while (this.a.app.a().c(paramLong) != null);
    QLog.e("FMObserver<FileAssistant>", 1, "OnTroopFileCopyToC2cDisc->,but entity is null SessionId[" + paramLong + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atyw
 * JD-Core Version:    0.7.0.1
 */