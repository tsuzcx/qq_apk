import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.trick.TrickHelper;

public class ehz
  extends Handler
{
  public ehz(TrickHelper paramTrickHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.a(false);
      return;
    } while (!GuardManager.a.b());
    TrickHelper.a(this.a);
    GuardManager.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ehz
 * JD-Core Version:    0.7.0.1
 */