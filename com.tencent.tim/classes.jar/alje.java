import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class alje
{
  private BaseChatPie c;
  private QQAppInterface mApp;
  private Context mContext;
  private String mJumpUrl;
  private SessionInfo mSessionInfo;
  
  public alje(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public alje(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
  }
  
  private boolean atE()
  {
    return (this.mJumpUrl.toLowerCase().startsWith("http://")) || (this.mJumpUrl.toLowerCase().startsWith("https://"));
  }
  
  private boolean atF()
  {
    return this.mJumpUrl.toLowerCase().startsWith("mqq://jubao.qq.com");
  }
  
  private boolean atG()
  {
    return this.mJumpUrl.toLowerCase().startsWith("mqq://");
  }
  
  private void dGp()
  {
    if ((this.mContext == null) || (this.mSessionInfo == null) || (this.mApp == null)) {}
    String str1;
    do
    {
      return;
      str1 = this.mSessionInfo.aTl;
    } while (TextUtils.isEmpty(str1));
    try
    {
      String str2 = stj.encrypt(str1, stj.cm(2));
      if (QLog.isColorLevel()) {
        QLog.i("HttpMqqJumper", 2, "openMoreOptions uin:" + str1 + " uinCode:" + str2);
      }
      Object localObject1 = this.mApp.b().a(this.mSessionInfo.aTl, this.mSessionInfo.cZ, -1L, this.mSessionInfo.topicId, false);
      Object localObject2 = new ArrayList();
      if (localObject1 != null) {
        ((List)localObject2).addAll((Collection)localObject1);
      }
      localObject1 = stj.a(str1, this.mApp.getCurrentAccountUin(), 25004, 10, (List)localObject2);
      localObject2 = ((String)localObject1).replaceAll(str1, str2);
      Bundle localBundle = stj.a(this.mSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.i("HttpMqqJumper", 2, "openMoreOptions safetyReport reportMsgOrg: " + (String)localObject1 + "  reportMsg: " + (String)localObject2);
      }
      stj.a(this.c.mActivity, str1, str2, null, null, this.mApp.getCurrentAccountUin(), 25004, (String)localObject2, localBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HttpMqqJumper", 1, "openMoreOptions safetyReport error" + localThrowable.getMessage());
    }
  }
  
  public alje a(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    return this;
  }
  
  public alje a(SessionInfo paramSessionInfo)
  {
    this.mSessionInfo = paramSessionInfo;
    return this;
  }
  
  public alje a(String paramString)
  {
    this.mJumpUrl = paramString;
    return this;
  }
  
  public void bfC()
  {
    if ((this.mContext == null) || (TextUtils.isEmpty(this.mJumpUrl))) {
      return;
    }
    Object localObject;
    label94:
    do
    {
      do
      {
        for (;;)
        {
          localObject = null;
          if (atF())
          {
            this.mJumpUrl = this.mJumpUrl.replace("mqq://", "https://");
            dGp();
          }
          while (localObject != null)
          {
            this.mContext.startActivity((Intent)localObject);
            return;
            if (!atE()) {
              break label94;
            }
            localObject = new Intent(this.mContext, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", this.mJumpUrl);
          }
        }
        if (!atG()) {
          break;
        }
      } while (this.mApp == null);
      localObject = aqik.c(this.mApp, this.mContext, this.mJumpUrl);
    } while (localObject == null);
    ((aqhv)localObject).edJ();
    ((aqhv)localObject).ace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alje
 * JD-Core Version:    0.7.0.1
 */