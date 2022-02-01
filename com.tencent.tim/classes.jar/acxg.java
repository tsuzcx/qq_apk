import android.content.Context;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acxg
  extends acuk
{
  public acxg(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void cOI()
  {
    String str = getAttribute("buddyuin");
    if (!str.isEmpty())
    {
      long l = Long.parseLong(str);
      if (QLog.isColorLevel()) {
        QLog.d("TroopOneWayAction", 2, "grayTip,openTroopWithCommonFriendsFragment:" + l);
      }
      TroopWithCommonFriendsFragment.zo(str);
      TroopWithCommonFriendsFragment.ac(this.context, 1);
      anot.a(null, "dc00898", "", "", "0X800AD20", "0X800AD20", 0, 0, "0", "0", "", "");
    }
  }
  
  public boolean ace()
  {
    try
    {
      cOI();
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("TroopOneWayAction", 1, "doAction error: " + localException.getMessage());
      Ge("TroopOneWayAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxg
 * JD-Core Version:    0.7.0.1
 */