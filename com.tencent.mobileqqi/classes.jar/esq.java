import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity;

public class esq
  extends Handler
{
  public esq(QvipSpecialSoundActivity paramQvipSpecialSoundActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return;
        QvipSpecialSoundActivity.b(this.a);
        QvipSpecialSoundActivity.a(this.a).removeMessages(2);
      } while (((Boolean)paramMessage.obj).booleanValue());
      QvipSpecialSoundActivity.a(this.a, this.a.getString(2131562062));
      return;
    case 1: 
      QvipSpecialSoundActivity.a(this.a).setText(this.a.getString(2131562762));
      return;
    }
    QvipSpecialSoundActivity.c(this.a);
    QvipSpecialSoundActivity.a(this.a, this.a.getString(2131562882));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esq
 * JD-Core Version:    0.7.0.1
 */