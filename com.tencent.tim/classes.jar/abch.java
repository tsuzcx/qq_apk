import android.os.Message;
import com.tencent.mobileqq.activity.tim.timme.TimLeba;
import mqq.os.MqqHandler;

public class abch
  extends MqqHandler
{
  public abch(TimLeba paramTimLeba) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (TimLeba.a(this.this$0) == null);
    TimLeba.a(this.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abch
 * JD-Core Version:    0.7.0.1
 */