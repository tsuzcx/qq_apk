import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import java.util.ArrayList;

public class bjp
  extends Handler
{
  public bjp(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        SetTroopAdminsActivity.a(this.a);
        SetTroopAdminsActivity.a(this.a).clear();
        SetTroopAdminsActivity.a(this.a).addAll((ArrayList)paramMessage.obj);
        SetTroopAdminsActivity.a(this.a).notifyDataSetChanged();
        SetTroopAdminsActivity.a(this.a);
      } while (SetTroopAdminsActivity.b(this.a));
      SetTroopAdminsActivity.c(this.a);
      return;
    }
    SetTroopAdminsActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjp
 * JD-Core Version:    0.7.0.1
 */