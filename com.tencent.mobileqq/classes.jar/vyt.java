import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.controller.QidianHandler;
import org.json.JSONObject;

public class vyt
  implements Runnable
{
  public vyt(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    QidianHandler localQidianHandler = (QidianHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
    if (!this.a.aj) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("app", "QD");
      if (this.a.j != null) {
        ((JSONObject)localObject).put("assignType", Long.parseLong(this.a.j));
      }
      if (this.a.k != null) {
        ((JSONObject)localObject).put("assignKey", Long.parseLong(this.a.k));
      }
      if (this.a.l != null) {
        ((JSONObject)localObject).put("ext", this.a.l);
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        String str4;
        int i = 1;
        continue;
        localObject = ((JSONObject)localObject).toString();
      }
    }
    str1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    str2 = this.a.i;
    str3 = this.a.h;
    str4 = this.a.m;
    if (i != 0)
    {
      localObject = null;
      localQidianHandler.a(str1, str2, str3, str4, (String)localObject);
      this.a.a().runOnUiThread(new vyu(this));
      localQidianHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyt
 * JD-Core Version:    0.7.0.1
 */