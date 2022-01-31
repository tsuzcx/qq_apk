import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class cmz
  implements Handler.Callback
{
  public cmz(SelectMemberActivity paramSelectMemberActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 1))
    {
      this.a.s = 2;
      this.a.finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cmz
 * JD-Core Version:    0.7.0.1
 */