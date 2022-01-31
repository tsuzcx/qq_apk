import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;

public class cdd
  extends Handler
{
  public cdd(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a.clearFocus();
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.e();
      return;
    case 1: 
      this.a.a((String)paramMessage.obj);
      return;
    case 2: 
      this.a.k();
      return;
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cdd
 * JD-Core Version:    0.7.0.1
 */