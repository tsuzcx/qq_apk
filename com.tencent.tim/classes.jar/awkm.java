import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class awkm
{
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("TianshuAdUtils", 2, "url empty");
    }
    do
    {
      return;
      if (MiniAppLauncher.isMiniAppUrl(paramString))
      {
        MiniAppLauncher.startMiniApp(paramContext, paramString, paramInt, null);
        return;
      }
      if ((!paramString.startsWith("mqqapi://")) || (paramQQAppInterface == null)) {
        break;
      }
      paramQQAppInterface = aqik.c(paramQQAppInterface, paramContext, paramString);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.ace();
    return;
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramString);
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    awmu localawmu = new awmu();
    long l = System.currentTimeMillis() / 1000L;
    localawmu.mTraceId = (String.valueOf(paramQQAppInterface.getCurrentAccountUin()) + '_' + l);
    localawmu.mActionId = paramInt;
    localawmu.eBB = 1;
    localawmu.cNR = String.valueOf(paramString1);
    localawmu.aBn = l;
    localawmu.eBX = 1;
    localawmu.mAppId = "tianshu.31";
    localawmu.mModuleId = "";
    localawmu.cRJ = paramString2;
    awmt.a().a(localawmu);
  }
  
  public static List<awmr> hC()
  {
    ArrayList localArrayList = new ArrayList();
    awmr localawmr = new awmr();
    localawmr.eBW = 1;
    localawmr.eBV = 339;
    localArrayList.add(localawmr);
    localawmr = new awmr();
    localawmr.eBW = 1;
    localawmr.eBV = 340;
    localArrayList.add(localawmr);
    localawmr = new awmr();
    localawmr.eBW = 1;
    localawmr.eBV = 341;
    localArrayList.add(localawmr);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awkm
 * JD-Core Version:    0.7.0.1
 */