import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.EditTagActivity;

public class cjt
  extends Handler
{
  public cjt(EditTagActivity paramEditTagActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.setResult(-1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cjt
 * JD-Core Version:    0.7.0.1
 */