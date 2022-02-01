import android.net.Uri;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class aqts
  extends aquy
{
  public aqts(PathTraceManager paramPathTraceManager, String paramString1, String paramString2) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("PathTraceManager", 1, "voice down");
    }
    paramaquz = new File(this.cxa);
    try
    {
      jqp.b(paramaquz, PathTraceManager.a(this.this$0));
      i = 1;
    }
    catch (IOException paramaquz)
    {
      for (;;)
      {
        QLog.i("PathTraceManager", 1, "unzip fail");
        int i = 0;
      }
    }
    if (i != 0)
    {
      QLog.d("PathTraceManager", 1, "unzip success");
      if (this.cxb != null) {
        aqge.a(Uri.fromFile(new File(PathTraceManager.a(this.this$0), this.cxb + ".mp3")), false, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqts
 * JD-Core Version:    0.7.0.1
 */