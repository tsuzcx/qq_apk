import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;

public class cam
  implements Runnable
{
  public cam(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if ((TroopChatPie.F(this.a).jdField_a_of_type_Int == 1) && (BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).getBoolean(TroopChatPie.G(this.a).jdField_a_of_type_JavaLangString, false))) {}
    try
    {
      long l1 = Long.parseLong(TroopChatPie.H(this.a).jdField_a_of_type_JavaLangString);
      long l2 = Long.parseLong(TroopChatPie.k(this.a).a());
      TroopNotificationHelper.a(TroopChatPie.l(this.a), 0, l1, l1, l2, "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", (short)34, true, false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cam
 * JD-Core Version:    0.7.0.1
 */