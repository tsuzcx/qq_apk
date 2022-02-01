import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acui
  extends acuk
{
  public acui(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    try
    {
      String str = toBase64Decode((String)this.attrs.get("url"));
      if ((TextUtils.isEmpty((CharSequence)this.attrs.get("appid"))) || (TextUtils.isEmpty((CharSequence)this.attrs.get("openid"))))
      {
        QLog.e("IdentifierWebJumpAction", 1, "identification with illegal params");
        return true;
      }
      anot.a(this.app, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.attrs.get("appid"), "");
      aiao.aoH();
      Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.context.startActivity(localIntent);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("IdentifierWebJumpAction", 1, "doAction error: " + localException.getMessage());
      Ge("IdentifierWebJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acui
 * JD-Core Version:    0.7.0.1
 */