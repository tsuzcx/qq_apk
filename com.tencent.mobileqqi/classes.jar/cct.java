import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;

public class cct
  implements Runnable
{
  public cct(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_Int == 1) && (BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).getBoolean(this.a.a.jdField_a_of_type_JavaLangString, false))) {}
    try
    {
      long l1 = Long.parseLong(this.a.a.jdField_a_of_type_JavaLangString);
      long l2 = Long.parseLong(this.a.b.a());
      TroopNotificationHelper.a(this.a.b, 0, l1, l1, l2, "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", (short)34, true);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cct
 * JD-Core Version:    0.7.0.1
 */