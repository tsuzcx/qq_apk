import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;

public class aivz
  extends accn
{
  public aivz(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onCardDownload isSuccess=%s data=%s", new Object[] { Boolean.valueOf(paramBoolean), paramObject }));
    }
    if ((LoginWelcomeManager.a(this.this$0) == null) || ((paramBoolean) && (paramObject != null))) {}
    for (;;)
    {
      try
      {
        Object localObject = LoginWelcomeManager.a(this.this$0).getBundle("request");
        String str = ((Bundle)localObject).getString("uin");
        long l1 = Long.parseLong(LoginWelcomeManager.a(this.this$0).getCurrentAccountUin());
        long l2 = Long.parseLong(str);
        localObject = ((Bundle)localObject).getString("authSig");
        LoginWelcomeManager.a(this.this$0).addObserver(this.this$0.b);
        acms localacms = (acms)LoginWelcomeManager.a(this.this$0).getBusinessHandler(20);
        paramObject = localacms.a((Card)paramObject);
        localacms.a(str, paramObject, 1, null, (String)localObject, localacms.b(paramObject, l1, l2), null);
        LoginWelcomeManager.a(this.this$0).removeObserver(LoginWelcomeManager.a(this.this$0));
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("LoginWelcomeManager", 1, "onCardDownload fail.", paramObject);
        continue;
      }
      this.this$0.duU();
    }
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    int i = 1;
    QLog.d("LoginWelcomeManager", 1, String.format("mCardObserver.onUpdateAvatar isSuccess=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    if (TextUtils.equals(LoginWelcomeManager.a(this.this$0).getCurrentAccountUin(), paramString)) {
      if (LoginWelcomeManager.a(this.this$0) != null)
      {
        paramString = LoginWelcomeManager.a(this.this$0).getBundle("request");
        if (paramString != null) {
          if (!paramBoolean) {
            break label130;
          }
        }
      }
    }
    for (;;)
    {
      paramString.putInt("result", i);
      paramString.putString("path", LoginWelcomeManager.a(this.this$0));
      LoginWelcomeManager.a(this.this$0, null);
      this.this$0.duU();
      LoginWelcomeManager.a(this.this$0).removeObserver(LoginWelcomeManager.a(this.this$0));
      return;
      label130:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivz
 * JD-Core Version:    0.7.0.1
 */