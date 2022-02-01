import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class awrl
{
  private static awrl.a a = new awrl.a(Looper.getMainLooper());
  private static volatile long aBv;
  private static aqju bh;
  private static final String[] jf = { "TroopFileDetailBrowserActivity", "FMActivity", "FileBrowserActivity", "ChatHistoryFileActivity", "FileAssistantActivity" };
  
  private static boolean E(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getClass().getName();
      arrayOfString = jf;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if ((!TextUtils.isEmpty(paramActivity)) && (paramActivity.contains(str))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean aNr()
  {
    if (aBv == 0L) {}
    long l;
    do
    {
      return true;
      l = SystemClock.uptimeMillis();
    } while (aBv + 4000L < l);
    return false;
  }
  
  public static void eEQ()
  {
    Message localMessage = a.obtainMessage();
    localMessage.what = 3001;
    a.sendMessage(localMessage);
  }
  
  public static void h(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer("https://jump.weiyun.com?from=3092");
    if (paramString != null) {
      localStringBuffer.append("&aid=").append(paramString);
    }
    paramString = new Intent();
    paramString.setClass(BaseApplication.getContext(), QQBrowserActivity.class);
    paramString.putExtra("url", localStringBuffer.toString());
    if (paramBoolean)
    {
      paramActivity.startActivityForResult(paramString, 2000);
      return;
    }
    paramActivity.startActivity(paramString);
  }
  
  public static void i(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    paramString = String.format("https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&aid=%s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.setClass(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    if (paramBoolean)
    {
      paramActivity.startActivityForResult(localIntent, 2000);
      return;
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static boolean nT(int paramInt)
  {
    return (nV(paramInt)) || (nU(paramInt));
  }
  
  public static boolean nU(int paramInt)
  {
    return (paramInt == 1053) || (paramInt == 22081);
  }
  
  public static boolean nV(int paramInt)
  {
    return (paramInt == 1127) || (paramInt == 22000);
  }
  
  public static void u(Activity paramActivity, int paramInt)
  {
    if (nT(paramInt)) {
      v(paramActivity, paramInt);
    }
  }
  
  public static void v(Activity paramActivity, int paramInt)
  {
    QLog.d("OpenWeiyunVipHelper", 2, "showLimitDialog");
    a.removeMessages(3000);
    Message localMessage = a.obtainMessage();
    localMessage.what = 3000;
    localMessage.obj = paramActivity;
    localMessage.arg1 = paramInt;
    a.sendMessageDelayed(localMessage, 1000L);
  }
  
  private static void w(Activity paramActivity, int paramInt)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramActivity != BaseActivity.sTopActivity))
    {
      paramActivity = BaseActivity.sTopActivity;
      if ((paramActivity != null) && (!paramActivity.isFinishing()) && (E(paramActivity))) {
        break label44;
      }
    }
    label44:
    while (((bh != null) && (bh.isShowing())) || (!aNr()))
    {
      return;
      break;
    }
    String str1;
    if (nU(paramInt))
    {
      str1 = BaseApplicationImpl.getContext().getString(2131693873);
      if (!nU(paramInt)) {
        break label161;
      }
    }
    label161:
    for (String str2 = BaseApplicationImpl.getContext().getString(2131693866);; str2 = BaseApplicationImpl.getContext().getString(2131693869))
    {
      bh = aqha.a(paramActivity, 230, str1, str2, 2131693871, 2131693872, new awrm(paramInt, paramActivity), new awrn());
      bh.setOnDismissListener(new awro());
      bh.show();
      return;
      str1 = BaseApplicationImpl.getContext().getString(2131693874);
      break;
    }
  }
  
  static class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3000: 
        awrl.x((Activity)paramMessage.obj, paramMessage.arg1);
        return;
      }
      awrl.a(null);
      awrl.access$202(SystemClock.uptimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrl
 * JD-Core Version:    0.7.0.1
 */