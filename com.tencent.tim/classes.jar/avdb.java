import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class avdb
{
  private static AtomicLong M;
  private static Boolean W;
  public static String bhi;
  private static TelephonyManager c;
  public static AtomicInteger cr;
  public static AtomicInteger cs;
  private static String imei = "";
  private static Field q;
  private static String qimei = "";
  private static final Random sRandom = new Random();
  private static ThreadLocal<char[]> t;
  
  static
  {
    bhi = "";
    M = new AtomicLong(-1L);
    cr = new AtomicInteger(0);
    cs = new AtomicInteger(0);
    W = Boolean.valueOf(true);
    t = new avdc();
  }
  
  public static void a(AppInterface paramAppInterface, avcu paramavcu)
  {
    if (paramAppInterface == null)
    {
      QLog.e("VipComicReportUtils", 2, "reportDC01327 error cause app == null");
      return;
    }
    Object localObject = paramAppInterface.getApp();
    if (localObject == null)
    {
      QLog.e("VipComicReportUtils", 2, "reportDC01327 error cause context == null");
      return;
    }
    paramAppInterface = getNetType();
    gj((Context)localObject);
    localObject = paramavcu.W();
    b(null, "dc01327", Arrays.asList(new String[] { "", "android", "201", Build.VERSION.RELEASE, "3.4.4", "", "android", paramAppInterface, bhi, paramavcu.FK(), "", paramavcu.Fy(), "", paramavcu.Fz(), paramavcu.FA(), "", paramavcu.FC(), localObject[1], localObject[2], localObject[3], localObject[4], localObject[5], localObject[6], localObject[7], localObject[8], "", "", "", paramavcu.FG(), "", paramavcu.FJ(), paramavcu.FB(), paramavcu.FD(), paramavcu.FE(), paramavcu.FH(), paramavcu.getDuration(), paramavcu.FI(), paramavcu.FF(), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", localObject[0], localObject[9], paramavcu.getGuid() }));
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if ((paramString1 == null) || (paramContext == null)) {
      return;
    }
    String str = getNetType();
    gj(paramContext);
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    arrayOfString[4] = "";
    arrayOfString[5] = "";
    arrayOfString[6] = "";
    arrayOfString[7] = "";
    arrayOfString[8] = "";
    arrayOfString[9] = "";
    int i = 0;
    while ((i < arrayOfString.length) && (i < paramVarArgs.length))
    {
      arrayOfString[i] = paramVarArgs[i];
      i += 1;
    }
    arrayOfString[5] = getQimei();
    paramString1 = Arrays.asList(new String[] { "1", paramString1, getImei(paramContext), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", "", "", "", paramString2, "", "", paramString3, paramString4, paramString5, "", "", "3.4.4", "", "", "", "", "", "android", str, bhi, "", arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfString[4], arrayOfString[5], arrayOfString[6], arrayOfString[7], arrayOfString[8] });
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      b(paramAppInterface, "dc00145", paramString1);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String... paramVarArgs)
  {
    if (paramAppInterface == null) {}
    String str;
    BaseApplication localBaseApplication;
    do
    {
      return;
      str = paramAppInterface.getCurrentAccountUin();
      localBaseApplication = paramAppInterface.getApp();
    } while ((str == null) || (localBaseApplication == null));
    int j = jqc.getNetWorkType();
    if (j >= 0)
    {
      i = j;
      if (j < acbn.dQ.length) {}
    }
    else
    {
      i = 0;
    }
    Object localObject2 = acbn.dQ[i];
    if (TextUtils.isEmpty(bhi))
    {
      localObject1 = localBaseApplication.getResources().getDisplayMetrics();
      bhi = ((DisplayMetrics)localObject1).widthPixels + "*" + ((DisplayMetrics)localObject1).heightPixels;
    }
    Object localObject1 = new String[10];
    localObject1[0] = "";
    localObject1[1] = "";
    localObject1[2] = "";
    localObject1[3] = "";
    localObject1[4] = "";
    localObject1[5] = "";
    localObject1[6] = "";
    localObject1[7] = "";
    localObject1[8] = "";
    localObject1[9] = "";
    int i = 0;
    while ((i < localObject1.length) && (i < paramVarArgs.length))
    {
      localObject1[i] = paramVarArgs[i];
      i += 1;
    }
    localObject1[5] = getQimei();
    if ((TextUtils.isEmpty(localObject1[7])) && (!TextUtils.isEmpty(avcv.cJy))) {
      localObject1[7] = avcv.cJy;
    }
    if (TextUtils.isEmpty(avcv.actionId))
    {
      paramVarArgs = "";
      paramString5 = Arrays.asList(new String[] { "1", str, getImei(localBaseApplication), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", paramVarArgs, paramString9, "", "", paramString1, paramString5, "", paramString2, paramString3, paramString4, "", "", "3.4.4", "", "", paramString10, "", "", "android", localObject2, bhi, "", localObject1[0], localObject1[1], localObject1[2], localObject1[3], localObject1[4], localObject1[5], localObject1[6], localObject1[7], localObject1[8], paramString7, paramString8, paramString6, "", "" });
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uin:").append(str).append(",").append("imei:").append(getImei(localBaseApplication)).append(",").append("domain:android,").append("domain_id:201,").append("biz_id:8001,").append("biz_subid:8001001,").append("obj_ownerid:").append(paramVarArgs).append(",").append("objPos:").append(paramString9).append(",").append("pageId:").append(paramString1).append(",").append("operObjType:").append(paramString2).append(",").append("operObjId:").append(paramString3).append(",").append("retId:").append(paramString4).append(",").append("sesId:").append(paramString10).append(",").append("ext1: ,").append("ext2:").append(localObject1[0]).append(",").append("ext3:").append(localObject1[1]).append(",").append("ext4:").append(localObject1[2]).append(",").append("ext5:").append(localObject1[3]).append(",").append("ext6:").append(localObject1[4]).append(",").append("ext7:").append(localObject1[5]).append(",").append("ext8:").append(localObject1[6]).append(",").append("ext9:").append(localObject1[7]).append(",").append("ext10:").append(localObject1[8]).append(",").append("land_page_id:").append(paramString7).append(",").append("detailpage_from:").append(paramString8).append(",").append("algo_id:").append(paramString6);
        QLog.d("VipComicReportUtils", 2, "dc DC00145_3 detail : " + ((StringBuilder)localObject2).toString());
      }
      if (!"3025".equals(paramString1)) {
        break label1094;
      }
      paramString1 = avcv.a.a();
      paramString1.ak("is_new", 22, "302598765432001");
      label1059:
      paramString1 = paramString1.bx(paramString5);
      if (!(paramAppInterface instanceof QQAppInterface)) {
        break label1101;
      }
    }
    label1094:
    label1101:
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      b(paramAppInterface, "dc00145", paramString1);
      return;
      paramVarArgs = avcv.actionId;
      break;
      paramString1 = avcv.a;
      break label1059;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs)
  {
    if (paramAppInterface == null) {
      return;
    }
    a(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramAppInterface.getApp(), paramString1, paramString2, paramString3, paramString4, paramVarArgs);
  }
  
  public static StringBuilder b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (W.booleanValue())
      {
        q = StringBuilder.class.getSuperclass().getDeclaredField("value");
        q.setAccessible(true);
        W = Boolean.valueOf(false);
      }
      if (q != null) {
        q.set(localStringBuilder, t.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      localStringBuilder = b();
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)paramList.get(i));
        if (i < j - 1) {
          localStringBuilder.append("|");
        }
        i += 1;
      }
      paramList = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.d("VipComicReportUtils", 2, "dcId=" + paramString + ";detail=" + paramList);
      }
      annx.o(paramQQAppInterface, paramString, paramList);
    }
    while (!QLog.isColorLevel())
    {
      StringBuilder localStringBuilder;
      int j;
      int i;
      return;
    }
    QLog.d("VipComicReportUtils", 2, "params is null, dcId=" + paramString + ";detail=" + "");
  }
  
  public static String getImei(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (TextUtils.isEmpty(imei)) {
      if (c == null) {
        c = (TelephonyManager)paramContext.getSystemService("phone");
      }
    }
    try
    {
      imei = auri.getIMEI("2240ca");
      if (TextUtils.isEmpty(imei)) {
        imei = getQimei();
      }
      if (imei == null)
      {
        QLog.e("VipComicReportUtils", 1, "getImei finally encounter error and return empty");
        imei = "";
      }
      return imei;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.e("VipComicReportUtils", 1, "telephonyManager.getDeviceId encounter error", paramContext);
      }
    }
  }
  
  private static String getNetType()
  {
    int j = jqc.getNetWorkType();
    int i;
    if (j >= 0)
    {
      i = j;
      if (j < acbn.dQ.length) {}
    }
    else
    {
      i = 0;
    }
    return acbn.dQ[i];
  }
  
  public static String getQimei()
  {
    if (TextUtils.isEmpty(qimei)) {}
    try
    {
      QLog.d("VipComicReportUtils", 1, "getQimei: try get QIMei from UserAction.getQIMEI!");
      qimei = UserAction.getQIMEI();
      if (qimei == null) {
        qimei = "";
      }
      return qimei;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("VipComicReportUtils", 1, "getQimei error", localThrowable);
      }
    }
  }
  
  private static void gj(Context paramContext)
  {
    if (TextUtils.isEmpty(bhi))
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      bhi = paramContext.widthPixels + "*" + paramContext.heightPixels;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avdb
 * JD-Core Version:    0.7.0.1
 */