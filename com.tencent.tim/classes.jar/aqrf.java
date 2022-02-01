import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqrf
{
  public static String VIPTYPE = "type";
  private static Long ak = Long.valueOf(0L);
  public static String cws = "sendUin";
  public static String cwt = "openMonth";
  public static String cwu = "aid";
  public static String cwv = "offerId";
  public static String cww = "serviceName";
  public static String cwx = "serviceCode";
  public static String cwy = "callbacksn";
  public static String cwz = "payUrl";
  
  public static String a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|").append(paramInt1).append("|").append(paramInt2).append("|").append(paramInt3).append("|").append(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("VasH5PayUtil", 2, "getOpenVipParam result = " + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  private static StringBuilder a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ("SVHHZLH".equals(paramString2))
    {
      long l = 16781315L;
      if (paramBoolean3) {
        l = 0x1001003 | 0x80000;
      }
      localObject = "https://h5.qzone.qq.com/vip/payBigDialog/{openUin}/{openMonth}?_wv={wv}&_wwv=13&_proxy=1&aid={aid}".replace("{openUin}", "0");
      if (paramInt > 0) {}
      for (paramString2 = String.valueOf(paramInt);; paramString2 = "0")
      {
        paramString1 = new StringBuilder(((String)localObject).replace("{openMonth}", paramString2).replace("{aid}", paramString1).replace("{wv}", String.valueOf(l)));
        return paramString1;
      }
    }
    Object localObject = new StringBuilder("https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=");
    ((StringBuilder)localObject).append(paramString1);
    if ("CJCLUBT".equals(paramString2)) {
      if (paramBoolean2) {
        ((StringBuilder)localObject).append("&type=!svip");
      }
    }
    for (;;)
    {
      paramString1 = (String)localObject;
      if (paramInt <= 0) {
        break;
      }
      if (!paramBoolean1) {
        break label198;
      }
      ((StringBuilder)localObject).append("&month=!" + paramInt);
      return localObject;
      ((StringBuilder)localObject).append("&type=svip");
      continue;
      if ("LTMCLUB".equals(paramString2)) {
        ((StringBuilder)localObject).append("&type=vip");
      }
    }
    label198:
    ((StringBuilder)localObject).append("&month=" + paramInt);
    return localObject;
  }
  
  private static StringBuilder a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&type=" + paramString2);
    localStringBuilder.append("&month=" + paramString3);
    return localStringBuilder;
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (System.currentTimeMillis() - ak.longValue() > 1000L)
    {
      ak = Long.valueOf(System.currentTimeMillis());
      paramString1 = a(paramString1, paramString2, paramString3);
      paramString2 = new Intent(paramActivity, QQVasH5PayBrowserActivity.class);
      paramString2.putExtra("url", paramString1.toString());
      paramActivity.startActivityForResult(paramString2, paramInt);
    }
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder;
    if (System.currentTimeMillis() - ak.longValue() > 1000L)
    {
      ak = Long.valueOf(System.currentTimeMillis());
      localStringBuilder = new StringBuilder();
      if (!TextUtils.isEmpty(paramString4)) {
        break label189;
      }
      localStringBuilder.append("https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=");
      if (!TextUtils.isEmpty(paramString1)) {
        localStringBuilder.append(paramString1);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        localStringBuilder.append("&type=" + paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localStringBuilder.append("&sendServiceUin=" + paramString3);
      }
      if (paramInt > 0) {
        localStringBuilder.append("&month=" + paramInt);
      }
      paramString1 = new Intent(paramContext, QQVasH5PayBrowserActivity.class);
      paramString1.putExtra("url", localStringBuilder.toString());
      paramContext.startActivity(paramString1);
      return;
      label189:
      localStringBuilder.append(paramString4);
      if ((!TextUtils.isEmpty(paramString1)) && (!paramString4.contains("aid="))) {
        if (paramString4.contains("?")) {
          localStringBuilder.append("&aid=" + paramString1);
        } else {
          localStringBuilder.append("?aid=" + paramString1);
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2, "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    a(paramContext, paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2, paramString3, "", false, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (System.currentTimeMillis() - ak.longValue() > 1000L)
    {
      ak = Long.valueOf(System.currentTimeMillis());
      paramString1 = a(paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2, paramBoolean4);
      if (!TextUtils.isEmpty(paramString3)) {
        paramString1.append("&disableChannel=" + paramString3);
      }
      if (paramBoolean3) {
        paramString1.append("&disableMobile=1");
      }
      if (!TextUtils.isEmpty(paramString4))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasH5PayUtil", 2, "openH5Pay callback = " + paramString4);
        }
        paramString1.append("&return_url=" + paramString4);
      }
      paramString2 = new Intent(paramContext, QQVasH5PayBrowserActivity.class);
      paramString2.putExtra("url", paramString1.toString());
      paramContext.startActivity(paramString2);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((!TextUtils.isEmpty(paramString5)) && ((paramString5.equals("svipdiyCardH5Pay")) || (paramString5.equals("vipdiyCardH5Pay"))))
    {
      a(paramContext, paramString1, paramString3, paramInt, false, false, "hfpay");
      return;
    }
    a(paramContext, paramString1, paramString3, paramInt, false, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramString1, paramString3, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramBundle == null)) {
      return;
    }
    paramQQAppInterface = paramBundle.getString(cwu);
    String str1 = paramBundle.getString(VIPTYPE);
    int i = paramBundle.getInt(cwt);
    String str2 = paramBundle.getString(cws);
    paramBundle.getString(cwv);
    paramBundle.getString(cww);
    paramBundle.getString(cwx);
    paramBundle.getString(cwy);
    a(paramContext, paramQQAppInterface, str1, i, str2, paramBundle.getString(cwz));
  }
  
  public static void cU(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQVasH5PayBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void o(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VasH5PayUtil", 2, "openClubPayWithParam param is empty");
      return;
    }
    if (paramContext == null)
    {
      QLog.e("VasH5PayUtil", 2, "openClubPayWithParam context is null");
      return;
    }
    Object localObject = paramString.split("\\|");
    if (localObject.length != 5)
    {
      QLog.e("VasH5PayUtil", 2, "openClubPayWithParam param not correct: " + localObject);
      return;
    }
    paramString = localObject[0];
    String str1 = localObject[1];
    CharSequence localCharSequence = localObject[2];
    String str2 = localObject[3];
    localObject = localObject[4];
    boolean bool1;
    boolean bool2;
    if (str1.equals("1"))
    {
      bool1 = true;
      if (!str2.equals("1")) {
        break label209;
      }
      bool2 = true;
    }
    for (;;)
    {
      if (!TextUtils.isDigitsOnly(localCharSequence))
      {
        QLog.e("VasH5PayUtil", 2, "openClubPayWithParam param openMonth not correct: " + localCharSequence);
        return;
        if (str1.equals("0"))
        {
          bool1 = false;
          break;
        }
        QLog.e("VasH5PayUtil", 2, "openClubPayWithParam param hardType not correct: " + str1);
        return;
        label209:
        if (str2.equals("0"))
        {
          bool2 = false;
        }
        else
        {
          QLog.e("VasH5PayUtil", 2, "openClubPayWithParam param hardMonth not correct: " + str2);
          return;
        }
      }
    }
    a(paramContext, (String)localObject, paramString, Integer.parseInt(localCharSequence), bool2, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrf
 * JD-Core Version:    0.7.0.1
 */