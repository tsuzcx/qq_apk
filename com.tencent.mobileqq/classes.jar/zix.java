import android.content.SharedPreferences;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class zix
  implements Runnable
{
  public zix(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    long l1 = this.a.a.getLong("key_req_last_login_time", 0L);
    long l2 = this.a.a.getLong("key_req_login_interval", 86400000L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append("checkLastLogin, lastReqTime = ").append(l1);
      ((StringBuilder)localObject).append(", current = ").append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(", interval = ").append(l2);
      ((StringBuilder)localObject).append(", isRequesting = ").append(PhoneContactManagerImp.d(this.a));
      QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if ((PhoneContactManagerImp.d(this.a)) || (!this.a.c()) || (Math.abs(System.currentTimeMillis() - l1) < l2)) {
      return;
    }
    PhoneContactManagerImp.a(this.a, true);
    Object localObject = new NewIntent(PhoneContactManagerImp.a(this.a).getApplication(), ContactBindServlet.class);
    ((NewIntent)localObject).putExtra("req_type", 32);
    l1 = this.a.a.getLong("key_login_info_timestamp", 0L);
    ((NewIntent)localObject).putExtra("next_flag", 0);
    ((NewIntent)localObject).putExtra("time_stamp", l1);
    ((NewIntent)localObject).putExtra("unique_phone_no", this.a.a());
    PhoneContactManagerImp.a(this.a).startServlet((NewIntent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zix
 * JD-Core Version:    0.7.0.1
 */