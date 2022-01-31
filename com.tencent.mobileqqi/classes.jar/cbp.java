import android.app.Dialog;
import com.tencent.mobileqq.activity.ChatHistory;

class cbp
  extends Thread
{
  cbp(cbo paramcbo) {}
  
  public void run()
  {
    ChatHistory.a(this.a.a, this.a.a.b, this.a.a.a);
    this.a.a.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbp
 * JD-Core Version:    0.7.0.1
 */