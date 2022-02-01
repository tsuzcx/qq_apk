import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class yxe
{
  protected static HashMap<String, structmsg.StructMsg> hj;
  
  public static Drawable a(aqdf paramaqdf, String paramString, int paramInt)
  {
    if ((paramaqdf == null) || (paramString == null) || (paramInt == -1)) {
      return null;
    }
    if (paramaqdf.isPausing()) {
      paramaqdf.resume();
    }
    Bitmap localBitmap2 = paramaqdf.b(paramInt, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      paramaqdf.i(paramString, paramInt, true);
      if (paramInt != 4) {
        break label68;
      }
    }
    label68:
    for (localBitmap1 = aqhu.aL();; localBitmap1 = aqhu.G()) {
      return new BitmapDrawable(localBitmap1);
    }
  }
  
  public static final structmsg.StructMsg a(String paramString)
  {
    if ((hj != null) && (hj.containsKey(paramString))) {
      return (structmsg.StructMsg)hj.get(paramString);
    }
    return null;
  }
  
  public static final void a(String paramString, structmsg.StructMsg paramStructMsg)
  {
    if (hj == null) {
      hj = new HashMap(3);
    }
    hj.put(paramString, paramStructMsg);
  }
  
  public static void bg(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
      } while (localSharedPreferences == null);
      localSharedPreferences.edit().putBoolean("isFirstLogin" + paramString, paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationUtils", 2, "setIsAccountFirstLogin uin=" + paramString + " firstLogin=" + paramBoolean);
  }
  
  public static void bj(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
    int i = paramQQAppInterface.getInt("share_key_pay2joinTroop_request_num", 0);
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putInt("share_key_pay2joinTroop_request_num", i + 1);
    paramQQAppInterface.commit();
  }
  
  public static void bk(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit();
    paramQQAppInterface.putInt("share_key_pay2joinTroop_request_num", 0);
    paramQQAppInterface.commit();
  }
  
  public static final void bm(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://qun.qq.com/qunpay/qunfee/pay.html?gc=%s&source=joingroup&_wv=1031", new Object[] { paramString }));
    paramContext.startActivity(localIntent);
  }
  
  public static void cmD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationUtils", 2, "clearAccountLoginInfoSp");
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().clear().commit();
  }
  
  public static final void cmE()
  {
    if (hj != null) {
      hj.clear();
    }
  }
  
  public static int fx(int paramInt)
  {
    switch (paramInt)
    {
    case 82: 
    default: 
      return 0;
    case 1: 
    case 13: 
    case 22: 
    case 60: 
      return 2;
    }
    return 1;
  }
  
  public static boolean ik(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return bool1;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
      } while (localSharedPreferences == null);
      bool2 = localSharedPreferences.getBoolean("isFirstLogin" + paramString, true);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationUtils", 2, "isAccountFirstLogin uin=" + paramString + " result=" + bool2);
    return bool2;
  }
  
  public static int u(QQAppInterface paramQQAppInterface)
  {
    int i = 0 + anze.a().af(paramQQAppInterface) + ackn.F(paramQQAppInterface);
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotificationUtils", 4, "getTroopNotificationUnreadNum:" + i);
    }
    return i;
  }
  
  public static int v(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getInt("share_key_pay2joinTroop_request_num", 0);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt);
    
    public abstract void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxe
 * JD-Core Version:    0.7.0.1
 */