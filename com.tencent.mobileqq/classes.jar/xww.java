import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.qphone.base.util.QLog;

public class xww
  implements Runnable
{
  public xww(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void run()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.a.app.a(20);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.b(Long.valueOf(this.a.c));
      localTroopHandler.a(Long.valueOf(this.a.c));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SelectMemberActivity", 2, "NumberFormatException : mGroupCode = " + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xww
 * JD-Core Version:    0.7.0.1
 */