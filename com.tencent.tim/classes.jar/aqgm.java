import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.AvatarPendantUtil.1;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public final class aqgm
{
  public static final ArrayList<String> CJ;
  private static long asI = -1L;
  public static volatile boolean cTV;
  public static String csT;
  public static final String csU;
  public static String csV;
  public static int dZe;
  public static ConcurrentHashMap<Long, Integer> iW = new ConcurrentHashMap();
  public static ConcurrentHashMap<Long, Integer> iX = new ConcurrentHashMap();
  
  static
  {
    csT = "https://i.gtimg.cn/qqshow/admindata/comdata/AndroidIconZip/icon.zip";
    csU = acbn.SDCARD_PATH + "avatarPendantIcons";
    csV = csU + "/icon";
    CJ = new ArrayList();
    dZe = 5000;
  }
  
  public static void UC(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (CJ)
    {
      if (CJ.contains(paramString)) {
        return;
      }
    }
    CJ.add(paramString);
  }
  
  public static float a(Paint paramPaint, Rect paramRect, String paramString)
  {
    int i = paramRect.width();
    float f2;
    if (i <= 0)
    {
      f2 = 0.0F;
      return f2;
    }
    paramPaint = new TextPaint(paramPaint);
    float f1 = paramRect.height();
    paramPaint.setTextSize(f1);
    for (;;)
    {
      if (paramPaint.measureText(paramString) <= i)
      {
        f2 = f1;
        if (Math.ceil(paramPaint.getFontMetrics().descent - paramPaint.getFontMetrics().ascent) <= paramRect.height()) {
          break;
        }
      }
      f2 = f1;
      if (f1 <= 0.0F) {
        break;
      }
      f1 -= 1.0F;
      paramPaint.setTextSize(f1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, ahyj paramahyj)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, entrance=" + paramString1 + ", uin=" + paramString2 + ", context=" + paramContext + ", app=" + paramQQAppInterface);
      }
    }
    do
    {
      long l;
      do
      {
        do
        {
          return;
        } while (paramQQAppInterface == null);
        paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13);
        if (paramQQAppInterface == null) {
          break;
        }
        l = paramContext.getSharedPreferences(String.format("sp_pendant_market_open_time_%s", new Object[] { paramString2 }), 0).getLong(paramString1, 0L);
      } while (System.currentTimeMillis() - l >= 604800000L);
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, startWebProcess");
      }
      paramQQAppInterface.a(-1, new aqgn(paramahyj));
      return;
    } while (!QLog.isColorLevel());
    QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, web process alive aready");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Intent localIntent;
    int i;
    altq localaltq;
    int j;
    label120:
    int k;
    label134:
    int m;
    label148:
    int n;
    label162:
    int i1;
    label176:
    int i2;
    if (paramAllInOne != null)
    {
      localIntent = new Intent(paramContext, AvatarPendantActivity.class);
      localIntent.putExtra("AllInOne", paramAllInOne);
      anec localanec = (anec)paramQQAppInterface.getManager(12);
      i = localanec.ee("100005.100006");
      if ((i == 1) || (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantUtil", 2, "Clear pendant red flag");
        }
        localIntent.putExtra("key_update_flag", true);
        localaltq = (altq)paramQQAppInterface.getManager(36);
        localaltq.OS("100005.100006");
        if (localanec.ee("100005.100003") == -1) {
          break label439;
        }
        j = 1;
        if (localanec.ee("100005.100002") == -1) {
          break label445;
        }
        k = 1;
        if (localanec.ee("100005.100001") == -1) {
          break label451;
        }
        m = 1;
        if (localanec.ee("100005.100018") == -1) {
          break label457;
        }
        n = 1;
        if (localanec.ee("100005.100020") == -1) {
          break label463;
        }
        i1 = 1;
        if (localanec.ee("100005.100021") == -1) {
          break label469;
        }
        i2 = 1;
        label190:
        if (!((ku)paramQQAppInterface.getManager(42)).cy) {
          break label489;
        }
        if (localanec.ee("100005.100011") == -1) {
          break label475;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label219:
      if ((j == 0) && (k == 0) && (m == 0) && (n == 0) && (i == 0) && (i1 == 0) && (i2 == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantUtil", 2, "Clear parent red flag");
        }
        localaltq.OS("100005");
      }
      if (paramAllInOne == null)
      {
        localIntent.putExtra("hide_left_button", false);
        localIntent.putExtra("show_right_close_button", false);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtra("url", aqqj.o(paramContext, "pendant", ""));
        localIntent.putExtra("business", 512L);
        if (!paramBoolean) {
          break label481;
        }
      }
      label439:
      label445:
      label451:
      label457:
      label463:
      label469:
      label475:
      label481:
      for (i = 40202;; i = 40201)
      {
        localIntent.putExtra("individuation_url_type", i);
        VasWebviewUtil.insertVasWbPluginToIntent(512L, localIntent);
        localIntent.putExtra("isShowAd", false);
        paramContext.startActivity(localIntent);
        anot.a(paramQQAppInterface, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
        return;
        localIntent = new Intent(paramContext, QQBrowserActivity.class);
        break;
        j = 0;
        break label120;
        k = 0;
        break label134;
        m = 0;
        break label148;
        n = 0;
        break label162;
        i1 = 0;
        break label176;
        i2 = 0;
        break label190;
        i = 0;
        break label219;
      }
      label489:
      i = 0;
    }
  }
  
  public static void bg(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((aqrb)paramQQAppInterface.getBusinessHandler(71)).a(new String[] { paramString }, new int[] { 27235 });
  }
  
  public static boolean cT(long paramLong)
  {
    Integer localInteger = (Integer)iW.get(Long.valueOf(paramLong));
    if (localInteger == null) {
      return true;
    }
    if (localInteger.intValue() == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean cU(long paramLong)
  {
    Integer localInteger = (Integer)iX.get(Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantUtil", 2, "isDiy=" + localInteger);
    }
    if (localInteger == null) {
      return true;
    }
    if ((localInteger.intValue() == 1) || (localInteger.intValue() == 2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "saveMarketOpenTime, entrance=" + paramString1 + ", uin=" + paramString2 + ", context=" + paramContext);
      }
    }
    do
    {
      return;
      paramContext = paramContext.getSharedPreferences(String.format("sp_pendant_market_open_time_%s", new Object[] { paramString2 }), 0);
    } while (paramContext == null);
    paramContext.edit().putLong(paramString1, paramLong).commit();
  }
  
  public static void edF()
  {
    File localFile = new File(acbn.SDCARD_PATH + "avatarPendantDefaultHead");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(acbn.bmK);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
  }
  
  public static void ez(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (CJ.size() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, size=" + CJ.size());
    }
    long l = 0L;
    boolean bool2;
    label66:
    boolean bool1;
    if (CJ.size() >= 5)
    {
      bool2 = true;
      if (asI == -1L) {
        break label227;
      }
      l = System.currentTimeMillis() - asI;
      if (l < dZe) {
        break label175;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, thresholdReached=" + bool2 + ", intervalReached=" + bool1);
      }
      if ((!bool2) && (!bool1) && (cTV))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, condition unavailable, abort");
        return;
        bool2 = false;
        break label66;
        label175:
        bool1 = false;
        continue;
      }
      paramQQAppInterface = new AvatarPendantUtil.1(paramQQAppInterface);
      if ((bool2) || (bool1))
      {
        ThreadManagerV2.excute(paramQQAppInterface, 128, null, false);
        return;
      }
      cTV = true;
      ThreadManager.getUIHandler().postDelayed(paramQQAppInterface, dZe - l);
      return;
      label227:
      bool1 = true;
    }
  }
  
  public static String l(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("pendant.");
    localStringBuilder.append(paramLong);
    switch (paramInt)
    {
    case 3: 
    default: 
      localStringBuilder.append(".other.zip");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(".xydata.js");
      continue;
      localStringBuilder.append(".other.zip");
      continue;
      localStringBuilder.append(".aio_50.png");
    }
  }
  
  public static String m(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(acbn.bmK).append(paramLong).append(File.separator);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("aio_50.png");
      continue;
      localStringBuilder.append("aio_file.zip");
      continue;
      localStringBuilder.append("aio_file");
      continue;
      localStringBuilder.append("preview_50.png");
      continue;
      localStringBuilder.append("market_dynamic_50.gif");
      continue;
      localStringBuilder.append("thumb_nail_50.png");
      continue;
      localStringBuilder.append("config.json");
      continue;
      localStringBuilder.append("avatarfit.png");
    }
  }
  
  public static void m(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    a(paramQQAppInterface, paramContext, true, null);
  }
  
  public static String n(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipFaceAddon_").append(paramLong).append(File.separator);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return afgc.insertMtype("VIP_avatar", localStringBuilder.toString());
      localStringBuilder.append("aio_50.png");
      continue;
      localStringBuilder.append("aio_file.zip");
      continue;
      localStringBuilder.append("list_50.png");
      continue;
      localStringBuilder.append("preview_50.gif");
      continue;
      localStringBuilder.append("thumb_nail_50.png");
      continue;
      localStringBuilder.append("xydata.js");
      continue;
      localStringBuilder.append("avatarfit.png");
    }
  }
  
  public static String pp(String paramString)
  {
    return acbn.bmK + "font_info/" + paramString + File.separator + paramString + ".ttf";
  }
  
  public static String pq(String paramString)
  {
    return acbn.bmK + "font_info/" + paramString + "/";
  }
  
  public static String pr(String paramString)
  {
    return acbn.bmK + "sticker_info/" + paramString + ".png";
  }
  
  public static boolean rm(String paramString)
  {
    return new File(pp(paramString)).exists();
  }
  
  public static boolean rn(String paramString)
  {
    paramString = paramString.replace("faceAddon.sticker.", "");
    return new File(acbn.bmK + "sticker_info", paramString).exists();
  }
  
  public static String x(File paramFile)
  {
    String str2 = "";
    String str1 = str2;
    if (paramFile != null)
    {
      str1 = str2;
      if (!paramFile.exists()) {}
    }
    try
    {
      paramFile = new String(aqhq.fileToBytes(paramFile));
      int i = paramFile.indexOf("\"seriesID\":");
      str1 = str2;
      if (i != -1)
      {
        int j = paramFile.indexOf(",", i + 10);
        str1 = str2;
        if (j != -1) {
          str1 = paramFile.substring(i + 11, j);
        }
      }
      return str1;
    }
    catch (Exception paramFile) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgm
 * JD-Core Version:    0.7.0.1
 */