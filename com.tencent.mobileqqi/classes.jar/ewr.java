import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareActivity;

public class ewr
  extends Handler
{
  public ewr(QvipSpecialCareActivity paramQvipSpecialCareActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    QvipSpecialCareActivity.b(this.a);
    QvipSpecialCareActivity.a(this.a, this.a.getString(2131562882));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewr
 * JD-Core Version:    0.7.0.1
 */