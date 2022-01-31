import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.EditTagActivity;

public class cju
  extends Handler
{
  public cju(EditTagActivity paramEditTagActivity) {}
  
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
 * Qualified Name:     cju
 * JD-Core Version:    0.7.0.1
 */