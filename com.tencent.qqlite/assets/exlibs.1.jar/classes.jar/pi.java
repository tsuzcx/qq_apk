import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import mqq.observer.AccountObserver;

class pi
  extends AccountObserver
{
  pi(ph paramph, String paramString1, String paramString2) {}
  
  public void onUpdateSid(String paramString)
  {
    Object localObject;
    String str;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = "http://w.mail.qq.com/cgi-bin/login?target=mobileqqwrite&fwd=mq&fun=from3g&uin=" + this.jdField_a_of_type_JavaLangString + "&3g_sid=" + paramString + "&to=" + this.b;
      str = ((String)localObject).toLowerCase();
      if (!str.startsWith("www.")) {
        break label141;
      }
      paramString = "http://" + (String)localObject;
    }
    for (;;)
    {
      localObject = new Intent(this.jdField_a_of_type_Ph.a, QQBrowserDelegationActivity.class);
      ((Intent)localObject).putExtra("url", paramString);
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject).putExtra("injectrecommend", false);
      this.jdField_a_of_type_Ph.a.startActivity((Intent)localObject);
      return;
      label141:
      if (str.startsWith("https:"))
      {
        paramString = "https" + ((String)localObject).substring(5);
      }
      else
      {
        paramString = (String)localObject;
        if (str.startsWith("http:")) {
          paramString = "http" + ((String)localObject).substring(4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pi
 * JD-Core Version:    0.7.0.1
 */