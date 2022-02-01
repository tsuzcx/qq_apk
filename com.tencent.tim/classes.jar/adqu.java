import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.Random;

public class adqu
{
  private static boolean bQt;
  public static int cJi;
  public static int cJj = 1;
  public static int cJk = 2;
  public static int cJl = 3;
  public static int cJm = 4;
  public static int cJn;
  public static int cJo = 1;
  public static int cJp = 2;
  public static int cJq = 3;
  
  public static void GL(String paramString)
  {
    a(null, paramString, 0, 0, 0, 0, "", "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    anot.b(paramQQAppInterface, "CliOper", "", "", "0X800776F", paramString1, paramInt1, 1, paramInt2, Integer.toString(paramInt3), Integer.toString(paramInt4), paramString2, paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!ArkAppMgr.isValidAppName(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ArkAppCenter.r("ArkApp.DataReport", String.format("platformEventReport, invalid args, app-name=%s, op-name=%s", new Object[] { paramString1, paramString2 }));
      return;
    }
    if (!"HTTPTaskResult".equals(paramString2)) {
      ArkAppCenter.r("ArkApp.DataReport", String.format("platformEventReport, app=%s, op-name=%s, entry=%d, result=%d, r1=%d, r2=%d, r3=%s, r4=%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), paramString3, paramString4 }));
    }
    annr.a(paramQQAppInterface, paramString1, "__platform__", paramString2, paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramString3, paramString4);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    for (;;)
    {
      a(paramQQAppInterface, paramString2, paramString1, 0, paramInt3, 0L, paramInt1, paramInt2, paramString3, "");
      return;
    }
  }
  
  public static void cTQ()
  {
    if (bQt) {}
    do
    {
      return;
      bQt = true;
    } while (ArkEnvironmentManager.getInstance().isHardwareAcceleration());
    a(null, "ark.lib.software.rendering", 0, 0, 0, 0, "", "");
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((!ArkAppMgr.isValidAppName(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ArkAppCenter.r("ArkApp.DataReport", String.format("appInsideClickReport, invalid args, app=%s, opName=%s, entry=%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
      return;
    }
    ArkAppCenter.r("ArkApp.DataReport", String.format("appInsideClickReport, app=%s, op-name=%s, entry=%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    annr.a(paramQQAppInterface, paramString1, "__app__", paramString2, 0L, paramInt, 0L, 0L, 0L, "", "");
  }
  
  public static void h(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (new Random().nextInt(1000) >= 10) {
      return;
    }
    a(paramQQAppInterface, paramString1, "UnsafeURLAccess", 0, paramInt, 0L, 0L, 0L, paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqu
 * JD-Core Version:    0.7.0.1
 */