package com.tencent.mobileqq.shortvideo;

import acbn;
import aeah;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.format.Formatter;
import anft;
import anlb;
import annq;
import annq.a;
import anot;
import aoop;
import aoqr;
import aqhq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import plr;
import pog;
import wja;

public class ShortVideoUtils
  implements anft
{
  private static AtomicInteger bO;
  private static volatile boolean cFD;
  public static boolean cFE = true;
  public static boolean cFF = true;
  public static boolean cFG;
  private static boolean cFH = true;
  public static boolean cFI;
  private static boolean cFJ;
  public static boolean cFK;
  public static boolean cFL;
  private static final String cdJ = aoqr.oz(acbn.SDCARD_PATH);
  private static int dFy;
  private static int dFz;
  private static String[] gC = { "GT-N7108" };
  private static int[] ni;
  
  static
  {
    bO = new AtomicInteger(0);
    dFy = 2;
    dFz = 1;
    ni = new int[] { 1, 97, 125 };
    ThreadManager.getSubThreadHandler().post(new ShortVideoUtils.1());
  }
  
  public static void B(AppInterface paramAppInterface)
  {
    try
    {
      if ((VideoEnvironment.p(paramAppInterface)) && (!awI()))
      {
        VideoEnvironment.a("AVCodec", null, true);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "LoadExtractedShortVideoSo:status_end=" + VideoEnvironment.Jq());
        }
      }
      return;
    }
    catch (Throwable paramAppInterface)
    {
      do
      {
        paramAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("ShortVideoUtils", 2, "Load libAVCodec.so failure.", paramAppInterface);
    }
  }
  
  public static boolean C(File paramFile)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramFile != null)
    {
      bool2 = bool1;
      if (paramFile.exists())
      {
        if (paramFile.isFile()) {
          break label39;
        }
        bool2 = bool1;
      }
    }
    label39:
    long l1;
    label141:
    do
    {
      int i;
      do
      {
        Object localObject;
        do
        {
          do
          {
            return bool2;
            l1 = System.currentTimeMillis();
            localObject = v(paramFile);
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoUtils", 2, "isSupportProgressive(), moovInfoStr: " + (String)localObject + ", filePath:" + paramFile.getAbsolutePath());
            }
            bool2 = bool1;
          } while (TextUtils.isEmpty((CharSequence)localObject));
          localObject = ((String)localObject).split("\\|");
          bool2 = bool1;
        } while (TextUtils.isEmpty(localObject[0]));
        i = -1;
        try
        {
          int j = Integer.parseInt(localObject[0]);
          i = j;
        }
        catch (Exception localException)
        {
          long l2;
          float f;
          break label141;
        }
        bool2 = bool1;
      } while (i <= 0);
      l2 = paramFile.length();
      f = i / (float)l2;
      bool1 = bool3;
      if (f > 0.0F)
      {
        bool1 = bool3;
        if (f < 0.5F) {
          bool1 = true;
        }
      }
      l2 = System.currentTimeMillis();
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoUtils", 2, "isSupportProgressive(), ratio: " + f + ", result: " + bool1 + ", cost:" + (l2 - l1));
    return bool1;
  }
  
  public static int Jn()
  {
    if (!cFI)
    {
      dPv();
      cFI = true;
    }
    return dFy;
  }
  
  public static void PH(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putBoolean("short_video_ae_pitu_takesame_switch", paramBoolean);
    localEditor.apply();
  }
  
  public static int[] Y()
  {
    return ni;
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    int i = 0;
    paramString = b(paramMessageForShortVideo, paramString);
    int j = paramMessageForShortVideo.videoFileStatus;
    switch (j)
    {
    }
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        bool2 = bool1;
        if (aqhq.fileExistsAndNotEmpty(paramString)) {
          bool2 = false;
        }
      }
      paramMessageForShortVideo = nq(paramMessageForShortVideo.getMd5());
      localObject = new File(paramMessageForShortVideo);
      if (((File)localObject).exists()) {
        break;
      }
      ((File)localObject).mkdirs();
      aqhq.UD(paramMessageForShortVideo + ".nomedia");
      return paramString;
    }
    Object localObject = ((File)localObject).list();
    String str;
    if ((localObject != null) && (localObject.length > 0))
    {
      int k = localObject.length;
      for (;;)
      {
        if (i >= k) {
          break label384;
        }
        str = localObject[i];
        if ((!str.endsWith(".tmp")) && (!str.equals(".nomedia"))) {
          break;
        }
        i += 1;
      }
    }
    label384:
    for (paramMessageForShortVideo = paramMessageForShortVideo + str;; paramMessageForShortVideo = null)
    {
      if ((bool2) && (paramMessageForShortVideo != null) && (!new File(paramString).exists()))
      {
        long l1 = System.currentTimeMillis();
        if (paramMessageForShortVideo.equals(paramString)) {
          return paramString;
        }
        aqhq.copyFile(paramMessageForShortVideo, paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "copy " + paramMessageForShortVideo + " to " + paramString);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "getShortVideoSavePath-----time: = " + (l2 - l1) + ", videoStatus:" + ff(j) + ", needCopy=" + bool2);
        }
      }
      return paramString;
    }
  }
  
  public static String a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    paramString1 = new StringBuilder(nq(paramString1));
    paramString1.append(paramString2);
    paramString1.append(Math.abs(paramLong));
    paramString1.append(".");
    paramString1.append(paramString3);
    return paramString1.toString();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, Context paramContext)
  {
    annq.a locala = new annq.a();
    locala.roomid = paramString;
    switch (paramSessionInfo.cZ)
    {
    default: 
      if (paramString == "0X8008E53")
      {
        locala.ceV = "2";
        label67:
        if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForShortVideo))) {
          break label257;
        }
        paramString = (MessageForShortVideo)paramMessageRecord;
        locala.ceU = String.valueOf(paramString.videoFileTime * 1000);
        switch (paramString.busiType)
        {
        default: 
          label124:
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoUtils", 1, new Object[] { Long.valueOf(paramMessageRecord.uniseq) });
          }
          label150:
          if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) {}
          break;
        }
      }
      break;
    }
    for (locala.ceY = "1";; locala.ceY = "2")
    {
      annq.a(paramAppInterface.getAccount(), "dc01178", paramSessionInfo.aTl, locala);
      return;
      locala.ceW = "1";
      break;
      locala.ceW = "2";
      break;
      locala.ceW = "3";
      break;
      locala.ceV = "1";
      break label67;
      locala.ceX = "1";
      break label124;
      locala.ceX = "2";
      break label124;
      label257:
      locala.ceU = "0";
      locala.ceX = "3";
      break label150;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    String str2;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 4;
      double d1 = paramLong1 / 1000.0D;
      double d2 = paramLong2 / 1000.0D;
      str1 = String.format("%.2f", new Object[] { Double.valueOf(d1) });
      str2 = String.format("%.2f", new Object[] { Double.valueOf(d2) });
      str2 = str1 + ";" + str2;
      if (paramInt1 != 2) {
        break;
      }
    }
    for (String str1 = paramString;; str1 = "")
    {
      anot.a(paramQQAppInterface, "dc00898", "", paramString, "0X8009AA6", "0X8009AA6", paramInt1, 0, String.valueOf(paramInt2), String.valueOf(paramInt3), str2, str1);
      return;
      paramInt1 = 1;
      break;
      paramInt1 = 2;
      break;
      paramInt1 = 3;
      break;
    }
  }
  
  public static int[] a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap == null ！");
      }
    }
    do
    {
      return null;
      if (!paramBitmap.isRecycled()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap isRecycled !");
    return null;
    return a(new int[] { paramBitmap.getWidth(), paramBitmap.getHeight() });
  }
  
  public static int[] a(int[] paramArrayOfInt)
  {
    float f2 = 2.0F;
    int i = 160;
    int j = 80;
    if (paramArrayOfInt == null) {
      return null;
    }
    int k = paramArrayOfInt[0];
    int m = paramArrayOfInt[1];
    if ((k == 0) || (m == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, w or h == 0 !");
      }
      return null;
    }
    float f1;
    if (m > k)
    {
      f1 = m / k;
      if (f1 <= 2.0F) {
        break label129;
      }
      f1 = f2;
      label76:
      if (m <= k) {
        break label152;
      }
      if (m <= 160) {
        break label132;
      }
    }
    for (;;)
    {
      label91:
      k = (int)(i / f1);
      if (k < 80) {}
      for (;;)
      {
        return new int[] { j, i };
        f1 = k / m;
        break;
        label129:
        break label76;
        label132:
        if (m >= 100) {
          break label213;
        }
        i = 100;
        break label91;
        j = k;
      }
      label152:
      if (k > 160) {}
      for (;;)
      {
        label160:
        k = (int)(i / f1);
        if (k < 80) {}
        for (;;)
        {
          k = i;
          i = j;
          j = k;
          break;
          if (k >= 100) {
            break label207;
          }
          i = 100;
          break label160;
          j = k;
        }
        label207:
        i = k;
      }
      label213:
      i = m;
    }
  }
  
  public static int aL(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return paramInt2;
    }
    if (paramInt1 >= 100) {
      return 100;
    }
    return (int)((100 - paramInt2) * paramInt1 / 100.0F + paramInt2);
  }
  
  public static native int adjustMoovPosition(String paramString1, String paramString2);
  
  public static boolean awI()
  {
    return VideoEnvironment.awT();
  }
  
  public static boolean awJ()
  {
    Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 3) {
      return false;
    }
    return localObject[2].equals("1");
  }
  
  public static boolean awK()
  {
    boolean bool = false;
    String[] arrayOfString = gC;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str)) {
        bool = true;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "isInFullScreenBlackList(), result=" + bool);
    }
    return bool;
  }
  
  public static boolean awL()
  {
    if (!cFG) {}
    try
    {
      Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 5) {
        cFH = localObject[5].equals("1");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo e:" + localException.toString());
        }
      }
    }
    cFG = true;
    return cFH;
  }
  
  public static boolean awM()
  {
    if (!cFJ) {
      cFJ = true;
    }
    try
    {
      Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "supportShortVideoMergePhoto:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 10)
      {
        int i = Integer.valueOf(localObject[10]).intValue();
        if ((i >= 0) && (i <= 1)) {
          dFz = i;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "supportShortVideoMergePhoto e:" + localException.toString());
        }
      }
    }
    return dFz == 1;
  }
  
  public static boolean awN()
  {
    boolean bool1 = awM();
    boolean bool2 = aeah.afY();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "supportShortVideoMergePhoto dpc:" + dFz + " choiceQC:" + bool2);
    }
    return (!bool1) || (!bool2);
  }
  
  public static boolean awO()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getBoolean("short_video_ae_pitu_takesame_switch", false);
  }
  
  public static String b(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    if (paramMessageForShortVideo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(nq(paramMessageForShortVideo.getMd5()));
      localStringBuilder.append(paramMessageForShortVideo.frienduin);
      localStringBuilder.append(Math.abs(paramMessageForShortVideo.uniseq));
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String bw(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(zJ());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String bx(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(zK());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  @TargetApi(9)
  public static String by(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(cdJ);
      localStringBuilder.append("shortvideo");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getShortVideoCompressPath: sourcePath=" + paramString1 + "/n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  @TargetApi(9)
  public static String bz(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(cdJ);
      localStringBuilder.append("shortvideo");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append("_raw");
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getShortVideoCompressPath: sourcePath=" + paramString1 + "/n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static SharedPreferences c(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + BaseApplicationImpl.sProcessId, 0);
  }
  
  public static String c(MessageForShortVideo paramMessageForShortVideo)
  {
    return a(paramMessageForShortVideo, "mp4") + "." + MD5.toMD5(paramMessageForShortVideo.uuid) + ".tmp";
  }
  
  public static String c(File paramFile, String paramString)
  {
    if ((paramFile == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    String str = anlb.w(paramFile);
    paramFile = new StringBuilder(acbn.SDCARD_IMG_CAMERA);
    paramFile.append(paramString);
    paramFile.append(str);
    paramFile.append(".mp4");
    paramString = new File(acbn.SDCARD_IMG_CAMERA);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramFile.toString();
  }
  
  public static void cO(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "deleteDownloadTempFile, exclude :" + paramString + ",compareModifiedTime : " + paramBoolean);
    }
    Object localObject = new File(zK());
    if (!((File)localObject).exists()) {}
    File[] arrayOfFile;
    for (;;)
    {
      return;
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          arrayOfFile = localObject[i].listFiles();
          if (arrayOfFile != null) {
            break label109;
          }
          i += 1;
        }
      }
    }
    label109:
    int m = arrayOfFile.length;
    int j = 0;
    label116:
    File localFile;
    if (j < m)
    {
      localFile = arrayOfFile[j];
      if (!localFile.getName().equals(paramString)) {
        break label147;
      }
    }
    for (;;)
    {
      j += 1;
      break label116;
      break;
      label147:
      if ((localFile.isFile()) && (localFile.getName().contains(".tmp"))) {
        if (paramBoolean)
        {
          long l = localFile.lastModified();
          if (604800000L <= System.currentTimeMillis() - l) {
            localFile.delete();
          }
        }
        else
        {
          localFile.delete();
        }
      }
    }
  }
  
  public static void cP(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putBoolean("short_video_hotpic_show_ptv_" + paramString, paramBoolean);
    localEditor.apply();
  }
  
  public static void cQ(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putBoolean("short_video_hotpic_show_pic_" + paramString, paramBoolean);
    localEditor.apply();
  }
  
  public static String d(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return "";
    }
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      if (paramMessageForShortVideo.sendRawVideo) {
        return bz(paramMessageForShortVideo.videoFileName, "tmp");
      }
      return by(paramMessageForShortVideo.videoFileName, "tmp");
    }
    return c(paramMessageForShortVideo);
  }
  
  public static void d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    annq.a locala = new annq.a();
    locala.ceU = paramString3;
    locala.roomid = "0X8008E53";
    switch (paramInt)
    {
    }
    for (;;)
    {
      locala.ceV = "2";
      locala.ceX = paramString4;
      locala.ceY = paramString5;
      annq.a(paramString1, "dc01178", paramString2, locala);
      return;
      locala.ceW = "1";
      continue;
      locala.ceW = "2";
      continue;
      locala.ceW = "3";
    }
  }
  
  public static int[] d(int paramInt1, int paramInt2)
  {
    int j;
    int k;
    label13:
    int i;
    int m;
    if (paramInt1 > 0)
    {
      j = paramInt1;
      if (paramInt2 <= 0) {
        break label237;
      }
      k = paramInt2;
      i = (int)(BaseChatItemLayout.bNT + 0.5D);
      m = aoop.KS();
      if (m < 135) {
        break label361;
      }
      m = wja.dp2px(m, BaseApplicationImpl.getApplication().getResources());
      if (m >= i) {
        break label361;
      }
      i = m;
    }
    label82:
    label91:
    label361:
    for (;;)
    {
      m = wja.dp2px(305.0F, BaseApplicationImpl.getApplication().getResources());
      String str;
      if (i > m)
      {
        i = m;
        if (j < k) {
          break label247;
        }
        m = 1;
        if (m == 0) {
          break label307;
        }
        if (j / k <= 1.555556F) {
          break label253;
        }
        str = "landscape close to 16:9";
        j = (int)(i * 9.0F / 16.0F + 0.5D);
        k = i;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "adjustSize " + str + " maxPixel:" + i + " ow:" + paramInt1 + " oh:" + paramInt2 + " w:" + k + " h:" + j);
        }
        return new int[] { k, j };
        j = 100;
        break;
        label237:
        k = 100;
        break label13;
        break label82;
        label247:
        m = 0;
        break label91;
        label253:
        if (j / k > 1.166667F)
        {
          str = "landscape close to 4:3";
          j = (int)(i * 3.0F / 4.0F + 0.5D);
          k = i;
        }
        else
        {
          str = "landscape close to 1:1";
          j = i;
          k = i;
          continue;
          if (k / j > 1.3F)
          {
            str = "portrait close to 10:16";
            k = (int)(i * 10.0F / 16.0F + 0.5D);
            j = i;
          }
          else
          {
            str = "portrait close to 1:1";
            j = i;
            k = i;
          }
        }
      }
    }
  }
  
  public static void dPu()
  {
    cO("", false);
  }
  
  private static void dPv()
  {
    try
    {
      Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getDefaultShortVideoStrategy:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 6)
      {
        localObject = localObject[6].split("_");
        if (localObject.length >= 2)
        {
          int i = Integer.valueOf(localObject[0]).intValue();
          if ((i >= 0) && (i <= 2)) {
            bO = new AtomicInteger(i);
          }
          i = Integer.valueOf(localObject[1]).intValue();
          if ((i >= 0) && (i <= 60)) {
            dFy = i;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo e:" + localException.toString());
    }
  }
  
  @Deprecated
  public static String e(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      do
      {
        return null;
        String str = a(paramMessageForShortVideo, "mp4");
        if (aqhq.fileExistsAndNotEmpty(str)) {
          return str;
        }
      } while (!paramMessageForShortVideo.isSendFromLocal());
      paramMessageForShortVideo = paramMessageForShortVideo.videoFileName;
    } while (!aqhq.fileExistsAndNotEmpty(paramMessageForShortVideo));
    return paramMessageForShortVideo;
  }
  
  public static int ef(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getInt("short_video_hotpic_cfg_version_" + paramString, 0);
  }
  
  public static int eg(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getInt("short_video_hotpic_ptv_version_" + paramString, 0);
  }
  
  public static int eh(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getInt("short_video_hotpic_pic_version_" + paramString, 0);
  }
  
  public static String f(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSend()) {
      return paramMessageForShortVideo.selfuin;
    }
    if ((paramMessageForShortVideo.istroop == 1) || (paramMessageForShortVideo.istroop == 3000)) {
      return paramMessageForShortVideo.senderuin;
    }
    return paramMessageForShortVideo.frienduin;
  }
  
  public static void fU(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putInt("short_video_hotpic_ptv_version_" + paramString, paramInt);
    localEditor.apply();
  }
  
  public static void fV(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putInt("short_video_hotpic_pic_version_" + paramString, paramInt);
    localEditor.apply();
  }
  
  public static void fW(String paramString, int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
      return;
      if (paramInt == 1) {
        paramInt = 2;
      } else if (paramInt == 3000) {
        paramInt = 3;
      } else {
        paramInt = 4;
      }
    }
  }
  
  public static String fe(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
    default: 
      return " [TYPE_NONE " + paramInt + " ]";
    case 6: 
      return " [TYPE_VIDEO_C2C] ";
    case 7: 
      return " [TYPE_VIDEO_THUMB_C2C] ";
    case 17: 
      return " [TYPE_VIDEO_DISUSS]";
    case 18: 
      return " [TYPE_VIDEO_THUMB_DISUSS] ";
    case 9: 
      return " [TYPE_VIDEO_TROOP]";
    case 16: 
      return " [TYPE_VIDEO_THUMB_TROOP] ";
    }
    return " [TYPE_VIDEO_FORWARD] ";
  }
  
  public static String ff(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " [STATUS_UNKNOW " + paramInt + "]";
    case 2004: 
      return " [STATUS_RECV_CANCEL] ";
    case 2005: 
      return " [STATUS_RECV_ERROR] ";
    case 2003: 
      return " [STATUS_RECV_FINISHED] ";
    case 2002: 
      return " [STATUS_RECV_PROCESS] ";
    case 2001: 
      return " [STATUS_RECV_START] ";
    case 2008: 
      return " [STATUS_RECV_PREPARED] ";
    case 2000: 
      return " [STATUS_RECV_REQUEST] ";
    case 999: 
      return " [STATUS_SEND_PREPARE] ";
    case 1000: 
      return " [STATUS_SEND_REQUEST] ";
    case 1001: 
      return " [STATUS_SEND_START] ";
    case 1004: 
      return " [STATUS_SEND_CANCEL] ";
    case 1002: 
      return " [STATUS_SEND_PROCESS] ";
    case 1003: 
      return " [STATUS_SEND_FINISHED] ";
    case 1007: 
      return " [STATUS_UPLOAD_FINISHED] ";
    case 1005: 
      return " [STATUS_SEND_ERROR] ";
    case 5001: 
      return " [STATUS_FILE_UNSAFE] ";
    }
    return " [STATUS_FILE_EXPIRED] ";
  }
  
  public static String fg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " shortvideo_cmd_unknow ";
    case 2: 
      return " shortvideo_cmd_download ";
    case 0: 
      return " shortvideo_cmd_send ";
    case 1: 
      return " shortvideo_cmd_resend ";
    case 3: 
      return " shortvideo_cmd_forward ";
    }
    return " shortvideo_cmd_reforward ";
  }
  
  public static String fh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Others";
    case 1: 
      return "WIFI";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    }
    return "4G";
  }
  
  public static String g(Context paramContext, long paramLong)
  {
    String str = Formatter.formatShortFileSize(paramContext, paramLong);
    int i = str.length();
    paramContext = str;
    if (i > 3) {
      paramContext = str.substring(0, i - 1);
    }
    return paramContext.replace(" ", "");
  }
  
  public static AtomicInteger g()
  {
    if (!cFI)
    {
      dPv();
      cFI = true;
    }
    return bO;
  }
  
  public static String getCameraPath()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      str = acbn.SDCARD_IMG_VIDEO_GN9000L;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getCameraPath: commonPath=" + str);
      }
      return str;
      if ((str.contains("MX4")) || (str.contains("MX6")) || (str.contains("MX5")) || (str.contains("M355")) || (str.contains("M571C"))) {
        str = acbn.SDCARD_IMG_VIDEO;
      } else if (str.contains("M040")) {
        str = acbn.SDCARD_IMG_VIDEO_RUBBISH_MX040;
      } else if ((str.contains("VIVO X7")) || (str.contains("VIVO X6A")) || (str.contains("VIVO XPLAY6")) || (str.contains("VIVO X5PRO")) || (str.contains("VIVO X9 PLUS")) || (str.contains("VIVO Y51A")) || (str.contains("VIVO X9I")) || (str.contains("VIVO X9")) || (str.contains("VIVO X6D"))) {
        str = acbn.SDCARD_IMG_VIDEO_VIVO_X7;
      } else {
        str = acbn.SDCARD_IMG_CAMERA;
      }
    }
  }
  
  public static long getDuration(String paramString)
  {
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "Path:" + paramString + ", not exits!");
      }
      return -1L;
    }
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.prepare();
      int i = localMediaPlayer.getDuration();
      long l = i;
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getDuration", paramString);
      }
      return -1L;
    }
    finally
    {
      localMediaPlayer.release();
    }
  }
  
  @TargetApi(14)
  public static long getDurationOfVideo(String paramString)
  {
    if (!aqhq.fileExists(paramString)) {
      return 0L;
    }
    return pog.getDurationOfVideo(paramString);
  }
  
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString)
  {
    return getVideoThumbnail(paramContext, paramString, 640);
  }
  
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString, int paramInt)
  {
    return getVideoThumbnail(paramContext, paramString, paramInt, -1L);
  }
  
  /* Error */
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: iload_2
    //   7: istore 6
    //   9: iload_2
    //   10: ifgt +8 -> 18
    //   13: sipush 640
    //   16: istore 6
    //   18: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   21: lstore 9
    //   23: new 963	android/media/MediaMetadataRetriever
    //   26: dup
    //   27: invokespecial 964	android/media/MediaMetadataRetriever:<init>	()V
    //   30: astore 13
    //   32: aload 13
    //   34: aload_1
    //   35: invokevirtual 965	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   38: aload 13
    //   40: lload_3
    //   41: invokevirtual 969	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   44: astore_0
    //   45: aload 13
    //   47: invokevirtual 970	android/media/MediaMetadataRetriever:release	()V
    //   50: aload_0
    //   51: ifnonnull +79 -> 130
    //   54: aload 12
    //   56: astore 11
    //   58: aload 11
    //   60: areturn
    //   61: astore_0
    //   62: aload 13
    //   64: invokevirtual 970	android/media/MediaMetadataRetriever:release	()V
    //   67: aconst_null
    //   68: astore_0
    //   69: goto -19 -> 50
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_0
    //   75: goto -25 -> 50
    //   78: astore_0
    //   79: aload 13
    //   81: invokevirtual 970	android/media/MediaMetadataRetriever:release	()V
    //   84: aconst_null
    //   85: astore_0
    //   86: goto -36 -> 50
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_0
    //   92: goto -42 -> 50
    //   95: astore_0
    //   96: ldc 118
    //   98: iconst_1
    //   99: ldc_w 972
    //   102: aload_0
    //   103: invokestatic 937	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload 13
    //   108: invokevirtual 970	android/media/MediaMetadataRetriever:release	()V
    //   111: aconst_null
    //   112: astore_0
    //   113: goto -63 -> 50
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_0
    //   119: goto -69 -> 50
    //   122: astore_0
    //   123: aload 13
    //   125: invokevirtual 970	android/media/MediaMetadataRetriever:release	()V
    //   128: aload_0
    //   129: athrow
    //   130: aload_0
    //   131: invokevirtual 456	android/graphics/Bitmap:getWidth	()I
    //   134: istore 7
    //   136: aload_0
    //   137: invokevirtual 459	android/graphics/Bitmap:getHeight	()I
    //   140: istore_2
    //   141: iload 7
    //   143: iload_2
    //   144: invokestatic 975	java/lang/Math:max	(II)I
    //   147: istore 8
    //   149: iload 8
    //   151: iload 6
    //   153: if_icmple +187 -> 340
    //   156: iload 6
    //   158: i2f
    //   159: iload 8
    //   161: i2f
    //   162: fdiv
    //   163: fstore 5
    //   165: iload 7
    //   167: i2f
    //   168: fload 5
    //   170: fmul
    //   171: invokestatic 979	java/lang/Math:round	(F)I
    //   174: istore 6
    //   176: iload_2
    //   177: i2f
    //   178: fload 5
    //   180: fmul
    //   181: invokestatic 979	java/lang/Math:round	(F)I
    //   184: istore_2
    //   185: aload_0
    //   186: iload 6
    //   188: iload_2
    //   189: iconst_1
    //   190: invokestatic 983	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   193: astore_0
    //   194: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   197: lstore_3
    //   198: aload_0
    //   199: ifnull +95 -> 294
    //   202: aload_0
    //   203: astore 11
    //   205: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq -150 -> 58
    //   211: ldc 118
    //   213: iconst_2
    //   214: new 120	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 985
    //   224: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_0
    //   228: invokevirtual 456	android/graphics/Bitmap:getWidth	()I
    //   231: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 987
    //   237: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: invokevirtual 459	android/graphics/Bitmap:getHeight	()I
    //   244: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 989
    //   250: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_1
    //   254: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 217
    //   259: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: lload_3
    //   263: lload 9
    //   265: lsub
    //   266: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   269: ldc_w 991
    //   272: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_0
    //   282: areturn
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 992	java/lang/OutOfMemoryError:printStackTrace	()V
    //   288: aload 11
    //   290: astore_0
    //   291: goto -97 -> 194
    //   294: aload_0
    //   295: astore 11
    //   297: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq -242 -> 58
    //   303: ldc 118
    //   305: iconst_2
    //   306: new 120	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 994
    //   316: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_1
    //   320: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 446	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload_0
    //   330: areturn
    //   331: astore 13
    //   333: goto -283 -> 50
    //   336: astore_1
    //   337: goto -209 -> 128
    //   340: goto -146 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	paramContext	Context
    //   0	343	1	paramString	String
    //   0	343	2	paramInt	int
    //   0	343	3	paramLong	long
    //   163	16	5	f	float
    //   7	180	6	i	int
    //   134	32	7	j	int
    //   147	13	8	k	int
    //   21	243	9	l	long
    //   1	295	11	localObject1	Object
    //   4	51	12	localObject2	Object
    //   30	94	13	localMediaMetadataRetriever	MediaMetadataRetriever
    //   331	1	13	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   32	45	61	java/lang/IllegalArgumentException
    //   62	67	72	java/lang/RuntimeException
    //   32	45	78	java/lang/RuntimeException
    //   79	84	89	java/lang/RuntimeException
    //   32	45	95	java/lang/OutOfMemoryError
    //   106	111	116	java/lang/RuntimeException
    //   32	45	122	finally
    //   96	106	122	finally
    //   185	194	283	java/lang/OutOfMemoryError
    //   45	50	331	java/lang/RuntimeException
    //   123	128	336	java/lang/RuntimeException
  }
  
  public static Bitmap h(Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap == null)
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        localObject = a(paramBitmap);
        if (localObject != null) {
          break label234;
        }
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        float f1;
        float f2;
        Canvas localCanvas;
        RectF localRectF;
        Paint localPaint;
        localObject = paramBitmap;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "resizeThumb ==> dstW:" + k + ", dstH:" + m);
      }
      f1 = k / i;
      f2 = m / j;
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f1, f2);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localCanvas = new Canvas((Bitmap)localObject);
      localRectF = new RectF(0.0F, 0.0F, k, m);
      localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      localPaint.setAntiAlias(true);
      localCanvas.drawBitmap(paramBitmap, null, localRectF, localPaint);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      return localObject;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ShortVideoUtils", 2, "resizeThumb, OutOfMemoryError ", localOutOfMemoryError);
      return paramBitmap;
      label234:
      int k = localObject[0];
      int m = localObject[1];
      if (i == k)
      {
        localObject = paramBitmap;
        if (j == m) {
          break;
        }
      }
    }
  }
  
  public static void hp(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("uin may be null, uin=" + paramString1);
    }
    c("sp_user_cache_data").edit().putString("recent_poi_" + paramString1, paramString2).apply();
  }
  
  public static URL j(String paramString)
  {
    try
    {
      paramString = new URL("shortvideothumb", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static URL k(String paramString)
  {
    try
    {
      paramString = new URL("shortvideoforpicthumb", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean m(AppInterface paramAppInterface)
  {
    if (awI()) {}
    do
    {
      return true;
      B(paramAppInterface);
    } while (awI());
    return false;
  }
  
  @SuppressLint({"InlinedApi"})
  public static int[] n(String paramString)
  {
    int[] arrayOfInt = new int[3];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    int[] tmp13_9 = tmp9_5;
    tmp13_9[2] = 0;
    tmp13_9;
    for (;;)
    {
      try
      {
        if (!VersionUtils.isIceScreamSandwich()) {
          return arrayOfInt;
        }
        localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(paramString);
        String str2 = localMediaMetadataRetriever.extractMetadata(18);
        String str3 = localMediaMetadataRetriever.extractMetadata(19);
        String str4 = localMediaMetadataRetriever.extractMetadata(9);
        str1 = "";
        if (Build.VERSION.SDK_INT >= 17) {
          str1 = localMediaMetadataRetriever.extractMetadata(24);
        }
        arrayOfInt[0] = Integer.valueOf(str2).intValue();
        arrayOfInt[1] = Integer.valueOf(str3).intValue();
        arrayOfInt[2] = Math.round(Integer.valueOf(str4).intValue() / 1000.0F);
        if (TextUtils.isEmpty(str1)) {
          continue;
        }
        i = Integer.parseInt(str1);
        if (i == 90) {
          continue;
        }
        if (i != 270) {}
      }
      catch (Exception paramString)
      {
        MediaMetadataRetriever localMediaMetadataRetriever;
        String str1;
        if (!QLog.isColorLevel()) {
          return arrayOfInt;
        }
        QLog.e(".troop.troop_file_video", 2, "getVideoResolution exp", paramString);
        return arrayOfInt;
        int i = arrayOfInt[0];
        arrayOfInt[0] = arrayOfInt[1];
        arrayOfInt[1] = i;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_file_video", 2, "getVideoResolution: w=" + arrayOfInt[0] + ", h=" + arrayOfInt[1] + ", dr=" + arrayOfInt[2] + ", rt=" + str1 + ", p=" + paramString);
      }
      localMediaMetadataRetriever.release();
      return arrayOfInt;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
    }
    return arrayOfInt;
  }
  
  public static String nq(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(cdJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String nr(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QQ视频");
    localStringBuilder.append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String ns(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("uin may be null, uin=" + paramString);
    }
    return c("sp_user_cache_data").getString("recent_poi_" + paramString, null);
  }
  
  public static boolean pc(String paramString)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!cFD) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    long l1 = System.currentTimeMillis();
    String str1 = "";
    String str2 = paramString + ".tmp";
    if (adjustMoovPosition(paramString, str2) != 0)
    {
      paramString = " adjustMoovPosition failure";
      bool1 = bool3;
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoUtils", 2, "moveMoovAtom() result = " + bool1 + ", step = " + paramString + ", cost = " + (l2 - l1) + "ms");
      return bool1;
      String str3 = paramString + ".back";
      aqhq.rename(paramString, str3);
      if (!aqhq.rename(str2, paramString))
      {
        aqhq.rename(str3, paramString);
        paramString = " rename failure";
        bool1 = bool3;
      }
      else
      {
        bool1 = true;
        paramString = str1;
      }
    }
  }
  
  public static boolean pd(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getBoolean("short_video_hotpic_show_ptv_" + paramString, false);
  }
  
  public static boolean pe(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getBoolean("short_video_hotpic_show_pic_" + paramString, false);
  }
  
  /* Error */
  @TargetApi(16)
  public static boolean pf(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 1138	android/media/MediaExtractor
    //   5: dup
    //   6: invokespecial 1139	android/media/MediaExtractor:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: aload_0
    //   14: invokevirtual 1140	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   17: iconst_0
    //   18: istore_1
    //   19: iload_3
    //   20: istore_2
    //   21: iload_1
    //   22: aload 4
    //   24: invokevirtual 1143	android/media/MediaExtractor:getTrackCount	()I
    //   27: if_icmpge +34 -> 61
    //   30: aload 4
    //   32: iload_1
    //   33: invokevirtual 1147	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   36: ldc_w 1149
    //   39: invokevirtual 1153	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: ldc_w 1155
    //   47: invokevirtual 1158	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +18 -> 68
    //   53: aload_0
    //   54: ldc_w 1160
    //   57: invokevirtual 513	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: aload 4
    //   63: invokevirtual 1161	android/media/MediaExtractor:release	()V
    //   66: iload_2
    //   67: ireturn
    //   68: iload_1
    //   69: iconst_1
    //   70: iadd
    //   71: istore_1
    //   72: goto -53 -> 19
    //   75: astore_0
    //   76: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +13 -> 92
    //   82: ldc 118
    //   84: iconst_2
    //   85: ldc_w 1163
    //   88: aload_0
    //   89: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload 4
    //   94: invokevirtual 1161	android/media/MediaExtractor:release	()V
    //   97: iconst_0
    //   98: ireturn
    //   99: astore_0
    //   100: aload 4
    //   102: invokevirtual 1161	android/media/MediaExtractor:release	()V
    //   105: aload_0
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   18	54	1	i	int
    //   20	47	2	bool1	boolean
    //   1	19	3	bool2	boolean
    //   9	92	4	localMediaExtractor	android.media.MediaExtractor
    // Exception table:
    //   from	to	target	type
    //   11	17	75	java/lang/Exception
    //   21	61	75	java/lang/Exception
    //   11	17	99	finally
    //   21	61	99	finally
    //   76	92	99	finally
  }
  
  public static void q(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramMessageForShortVideo.getMd5())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoUtils", 2, "deleteCacheFileByMessage, md5 == null! ");
    return;
    aqhq.deleteFile(a(paramMessageForShortVideo, "mp4"));
  }
  
  public static String r(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    Object localObject = anlb.w(paramFile);
    paramFile = new StringBuilder(acbn.SDCARD_IMG_CAMERA);
    paramFile.append((String)localObject);
    paramFile.append(".mp4");
    localObject = new File(acbn.SDCARD_IMG_CAMERA);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramFile.toString();
  }
  
  public static String s(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = anlb.w(paramFile);
    return plr.atc + paramFile + ".mp4";
  }
  
  public static String stringForTime(long paramLong)
  {
    int k = (int)paramLong / 1000;
    int i = k % 60;
    int j = k / 60 % 60;
    k /= 3600;
    if (k > 0) {
      return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }).toString();
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }).toString();
  }
  
  public static String t(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = anlb.w(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(cdJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String u(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = anlb.w(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(cdJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("audio");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String v(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: iconst_0
    //   4: istore_1
    //   5: iconst_4
    //   6: newarray byte
    //   8: astore 10
    //   10: iconst_4
    //   11: newarray byte
    //   13: astore 12
    //   15: lconst_0
    //   16: lstore 5
    //   18: bipush 8
    //   20: invokestatic 1201	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   23: astore 13
    //   25: new 1203	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 1206	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore 9
    //   35: iconst_0
    //   36: istore_2
    //   37: iload_1
    //   38: bipush 100
    //   40: if_icmpge +292 -> 332
    //   43: aload 9
    //   45: astore_0
    //   46: aload 9
    //   48: aload 10
    //   50: invokevirtual 1212	java/io/InputStream:read	([B)I
    //   53: istore_3
    //   54: iload_3
    //   55: ifgt +41 -> 96
    //   58: aload 9
    //   60: ifnull +8 -> 68
    //   63: aload 9
    //   65: invokevirtual 1215	java/io/InputStream:close	()V
    //   68: new 120	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   75: iload_2
    //   76: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: ldc_w 1217
    //   82: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: lload 5
    //   87: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_0
    //   94: aload_0
    //   95: areturn
    //   96: aload 9
    //   98: astore_0
    //   99: aload 13
    //   101: iconst_4
    //   102: newarray byte
    //   104: invokevirtual 1221	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   107: pop
    //   108: aload 9
    //   110: astore_0
    //   111: aload 13
    //   113: aload 10
    //   115: invokevirtual 1221	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   118: pop
    //   119: aload 9
    //   121: astore_0
    //   122: aload 13
    //   124: invokevirtual 1225	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   127: pop
    //   128: aload 9
    //   130: astore_0
    //   131: aload 13
    //   133: invokevirtual 1228	java/nio/ByteBuffer:getLong	()J
    //   136: lstore 7
    //   138: aload 9
    //   140: astore_0
    //   141: iload_3
    //   142: aload 9
    //   144: aload 12
    //   146: invokevirtual 1212	java/io/InputStream:read	([B)I
    //   149: iadd
    //   150: istore 4
    //   152: iload 4
    //   154: istore_3
    //   155: lload 7
    //   157: lstore 5
    //   159: lload 7
    //   161: lconst_1
    //   162: lcmp
    //   163: ifne +172 -> 335
    //   166: aload 9
    //   168: astore_0
    //   169: bipush 8
    //   171: newarray byte
    //   173: astore 14
    //   175: aload 9
    //   177: astore_0
    //   178: iload 4
    //   180: aload 9
    //   182: aload 14
    //   184: invokevirtual 1212	java/io/InputStream:read	([B)I
    //   187: iadd
    //   188: istore_3
    //   189: aload 9
    //   191: astore_0
    //   192: aload 13
    //   194: invokevirtual 1231	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   197: pop
    //   198: aload 9
    //   200: astore_0
    //   201: aload 13
    //   203: aload 14
    //   205: invokevirtual 1221	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   208: pop
    //   209: aload 9
    //   211: astore_0
    //   212: aload 13
    //   214: invokevirtual 1225	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   217: pop
    //   218: aload 9
    //   220: astore_0
    //   221: aload 13
    //   223: invokevirtual 1228	java/nio/ByteBuffer:getLong	()J
    //   226: lstore 5
    //   228: goto +107 -> 335
    //   231: aload 9
    //   233: astore_0
    //   234: aload 9
    //   236: lload 5
    //   238: iload_3
    //   239: i2l
    //   240: lsub
    //   241: invokevirtual 1234	java/io/InputStream:skip	(J)J
    //   244: pop2
    //   245: iload_2
    //   246: i2l
    //   247: lload 5
    //   249: ladd
    //   250: l2i
    //   251: istore_2
    //   252: aload 9
    //   254: astore_0
    //   255: aload 13
    //   257: invokevirtual 1231	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   260: pop
    //   261: iload_1
    //   262: iconst_1
    //   263: iadd
    //   264: istore_1
    //   265: goto -228 -> 37
    //   268: astore 10
    //   270: aconst_null
    //   271: astore 9
    //   273: aload 9
    //   275: astore_0
    //   276: aload 10
    //   278: invokevirtual 934	java/lang/Exception:printStackTrace	()V
    //   281: aload 11
    //   283: astore_0
    //   284: aload 9
    //   286: ifnull -192 -> 94
    //   289: aload 9
    //   291: invokevirtual 1215	java/io/InputStream:close	()V
    //   294: aconst_null
    //   295: areturn
    //   296: astore_0
    //   297: aconst_null
    //   298: areturn
    //   299: astore 9
    //   301: aconst_null
    //   302: astore_0
    //   303: aload_0
    //   304: ifnull +7 -> 311
    //   307: aload_0
    //   308: invokevirtual 1215	java/io/InputStream:close	()V
    //   311: aload 9
    //   313: athrow
    //   314: astore_0
    //   315: goto -247 -> 68
    //   318: astore_0
    //   319: goto -8 -> 311
    //   322: astore 9
    //   324: goto -21 -> 303
    //   327: astore 10
    //   329: goto -56 -> 273
    //   332: goto -274 -> 58
    //   335: aload 12
    //   337: iconst_0
    //   338: baload
    //   339: i2c
    //   340: bipush 109
    //   342: if_icmpne -111 -> 231
    //   345: aload 12
    //   347: iconst_1
    //   348: baload
    //   349: i2c
    //   350: bipush 111
    //   352: if_icmpne -121 -> 231
    //   355: aload 12
    //   357: iconst_2
    //   358: baload
    //   359: i2c
    //   360: bipush 111
    //   362: if_icmpne -131 -> 231
    //   365: aload 12
    //   367: iconst_3
    //   368: baload
    //   369: i2c
    //   370: bipush 118
    //   372: if_icmpne -141 -> 231
    //   375: goto -317 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramFile	File
    //   4	261	1	i	int
    //   36	216	2	j	int
    //   53	186	3	k	int
    //   150	38	4	m	int
    //   16	232	5	l1	long
    //   136	24	7	l2	long
    //   33	257	9	localFileInputStream	java.io.FileInputStream
    //   299	13	9	localObject1	Object
    //   322	1	9	localObject2	Object
    //   8	106	10	arrayOfByte1	byte[]
    //   268	9	10	localException1	Exception
    //   327	1	10	localException2	Exception
    //   1	281	11	localObject3	Object
    //   13	353	12	arrayOfByte2	byte[]
    //   23	233	13	localByteBuffer	java.nio.ByteBuffer
    //   173	31	14	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	35	268	java/lang/Exception
    //   289	294	296	java/lang/Exception
    //   25	35	299	finally
    //   63	68	314	java/lang/Exception
    //   307	311	318	java/lang/Exception
    //   46	54	322	finally
    //   99	108	322	finally
    //   111	119	322	finally
    //   122	128	322	finally
    //   131	138	322	finally
    //   141	152	322	finally
    //   169	175	322	finally
    //   178	189	322	finally
    //   192	198	322	finally
    //   201	209	322	finally
    //   212	218	322	finally
    //   221	228	322	finally
    //   234	245	322	finally
    //   255	261	322	finally
    //   276	281	322	finally
    //   46	54	327	java/lang/Exception
    //   99	108	327	java/lang/Exception
    //   111	119	327	java/lang/Exception
    //   122	128	327	java/lang/Exception
    //   131	138	327	java/lang/Exception
    //   141	152	327	java/lang/Exception
    //   169	175	327	java/lang/Exception
    //   178	189	327	java/lang/Exception
    //   192	198	327	java/lang/Exception
    //   201	209	327	java/lang/Exception
    //   212	218	327	java/lang/Exception
    //   221	228	327	java/lang/Exception
    //   234	245	327	java/lang/Exception
    //   255	261	327	java/lang/Exception
  }
  
  public static SharedPreferences z()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_ptu_template_sdk_sp_" + BaseApplicationImpl.sProcessId, 0);
  }
  
  public static String zJ()
  {
    StringBuilder localStringBuilder = new StringBuilder(zK());
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    Object localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = localStringBuilder.toString() + ".nomedia";
    if (!new File((String)localObject).exists()) {
      aqhq.UD((String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public static String zK()
  {
    StringBuilder localStringBuilder = new StringBuilder(cdJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String zL()
  {
    String str = getCameraPath();
    StringBuilder localStringBuilder2 = new StringBuilder(str);
    File localFile = new File(localStringBuilder2.toString());
    StringBuilder localStringBuilder1 = localStringBuilder2;
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    for (localStringBuilder1 = localStringBuilder2;; localStringBuilder1 = new StringBuilder(str))
    {
      localStringBuilder1.append(anlb.Ab()).append(".mp4");
      if (!new File(localStringBuilder1.toString()).exists()) {
        return localStringBuilder1.toString();
      }
    }
  }
  
  public static class VideoFileSaveRunnable
    implements Runnable
  {
    MqqHandler b;
    boolean cFM;
    boolean cFN = false;
    String cdK;
    String mVideoPath;
    
    public VideoFileSaveRunnable(String paramString1, MqqHandler paramMqqHandler, String paramString2, boolean paramBoolean)
    {
      this.mVideoPath = paramString1;
      this.b = paramMqqHandler;
      this.cdK = paramString2;
      this.cFM = paramBoolean;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aload_0
      //   4: getfield 26	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
      //   7: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   10: ifne +13 -> 23
      //   13: aload_0
      //   14: getfield 26	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
      //   17: invokestatic 50	aqhq:fileExists	(Ljava/lang/String;)Z
      //   20: ifne +47 -> 67
      //   23: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   26: ifeq +31 -> 57
      //   29: ldc 58
      //   31: iconst_2
      //   32: new 60	java/lang/StringBuilder
      //   35: dup
      //   36: invokespecial 61	java/lang/StringBuilder:<init>	()V
      //   39: ldc 63
      //   41: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   44: aload_0
      //   45: getfield 26	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
      //   48: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   51: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   54: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   57: aload_0
      //   58: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   61: iconst_1
      //   62: invokevirtual 81	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
      //   65: pop
      //   66: return
      //   67: new 83	java/io/File
      //   70: dup
      //   71: aload_0
      //   72: getfield 26	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
      //   75: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
      //   78: astore 6
      //   80: invokestatic 91	com/tencent/util/VersionUtils:isrFroyo	()Z
      //   83: ifeq +74 -> 157
      //   86: getstatic 96	android/os/Environment:DIRECTORY_MOVIES	Ljava/lang/String;
      //   89: invokestatic 100	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
      //   92: astore_2
      //   93: aload_2
      //   94: invokevirtual 103	java/io/File:mkdirs	()Z
      //   97: pop
      //   98: aload_0
      //   99: getfield 24	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:cFN	Z
      //   102: ifeq +69 -> 171
      //   105: aload_0
      //   106: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:cdK	Ljava/lang/String;
      //   109: astore_3
      //   110: new 83	java/io/File
      //   113: dup
      //   114: aload_2
      //   115: aload_3
      //   116: invokespecial 106	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   119: astore_3
      //   120: aload_0
      //   121: getfield 32	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:cFM	Z
      //   124: ifne +58 -> 182
      //   127: aload_3
      //   128: invokevirtual 109	java/io/File:exists	()Z
      //   131: ifeq +51 -> 182
      //   134: aload_0
      //   135: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   138: iconst_3
      //   139: aload_0
      //   140: getfield 26	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
      //   143: invokevirtual 113	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   146: astore_2
      //   147: aload_0
      //   148: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   151: aload_2
      //   152: invokevirtual 117	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
      //   155: pop
      //   156: return
      //   157: new 83	java/io/File
      //   160: dup
      //   161: getstatic 122	acbn:beb	Ljava/lang/String;
      //   164: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
      //   167: astore_2
      //   168: goto -75 -> 93
      //   171: aload_0
      //   172: getfield 30	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:cdK	Ljava/lang/String;
      //   175: invokestatic 126	com/tencent/mobileqq/shortvideo/ShortVideoUtils:nr	(Ljava/lang/String;)Ljava/lang/String;
      //   178: astore_3
      //   179: goto -69 -> 110
      //   182: new 128	java/io/FileOutputStream
      //   185: dup
      //   186: aload_3
      //   187: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   190: astore 4
      //   192: new 133	java/io/FileInputStream
      //   195: dup
      //   196: aload 6
      //   198: invokespecial 134	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   201: astore_2
      //   202: ldc 135
      //   204: newarray byte
      //   206: astore 5
      //   208: aload_2
      //   209: aload 5
      //   211: invokevirtual 139	java/io/FileInputStream:read	([B)I
      //   214: istore_1
      //   215: iload_1
      //   216: iconst_m1
      //   217: if_icmpeq +73 -> 290
      //   220: aload 4
      //   222: aload 5
      //   224: iconst_0
      //   225: iload_1
      //   226: invokevirtual 143	java/io/FileOutputStream:write	([BII)V
      //   229: aload 4
      //   231: invokevirtual 146	java/io/FileOutputStream:flush	()V
      //   234: goto -26 -> 208
      //   237: astore 5
      //   239: aload 4
      //   241: astore_3
      //   242: aload 5
      //   244: astore 4
      //   246: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   249: ifeq +13 -> 262
      //   252: ldc 58
      //   254: iconst_2
      //   255: ldc 148
      //   257: aload 4
      //   259: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   262: aload_0
      //   263: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   266: iconst_1
      //   267: invokevirtual 81	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
      //   270: pop
      //   271: aload_3
      //   272: ifnull +7 -> 279
      //   275: aload_3
      //   276: invokevirtual 154	java/io/FileOutputStream:close	()V
      //   279: aload_2
      //   280: ifnull -214 -> 66
      //   283: aload_2
      //   284: invokevirtual 155	java/io/FileInputStream:close	()V
      //   287: return
      //   288: astore_2
      //   289: return
      //   290: aload_0
      //   291: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   294: iconst_2
      //   295: aload_3
      //   296: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   299: invokevirtual 113	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   302: astore_3
      //   303: aload_0
      //   304: getfield 28	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   307: aload_3
      //   308: invokevirtual 117	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
      //   311: pop
      //   312: aload 4
      //   314: ifnull +8 -> 322
      //   317: aload 4
      //   319: invokevirtual 154	java/io/FileOutputStream:close	()V
      //   322: aload_2
      //   323: ifnull -257 -> 66
      //   326: aload_2
      //   327: invokevirtual 155	java/io/FileInputStream:close	()V
      //   330: return
      //   331: astore_2
      //   332: return
      //   333: astore_3
      //   334: aconst_null
      //   335: astore_2
      //   336: aconst_null
      //   337: astore 4
      //   339: aload 4
      //   341: ifnull +8 -> 349
      //   344: aload 4
      //   346: invokevirtual 154	java/io/FileOutputStream:close	()V
      //   349: aload_2
      //   350: ifnull +7 -> 357
      //   353: aload_2
      //   354: invokevirtual 155	java/io/FileInputStream:close	()V
      //   357: aload_3
      //   358: athrow
      //   359: astore_3
      //   360: goto -38 -> 322
      //   363: astore_3
      //   364: goto -85 -> 279
      //   367: astore 4
      //   369: goto -20 -> 349
      //   372: astore_2
      //   373: goto -16 -> 357
      //   376: astore_3
      //   377: aconst_null
      //   378: astore_2
      //   379: goto -40 -> 339
      //   382: astore_3
      //   383: goto -44 -> 339
      //   386: astore 5
      //   388: aload_3
      //   389: astore 4
      //   391: aload 5
      //   393: astore_3
      //   394: goto -55 -> 339
      //   397: astore 4
      //   399: aconst_null
      //   400: astore_2
      //   401: aload 5
      //   403: astore_3
      //   404: goto -158 -> 246
      //   407: astore 5
      //   409: aconst_null
      //   410: astore_2
      //   411: aload 4
      //   413: astore_3
      //   414: aload 5
      //   416: astore 4
      //   418: goto -172 -> 246
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	421	0	this	VideoFileSaveRunnable
      //   214	12	1	i	int
      //   92	192	2	localObject1	Object
      //   288	39	2	localIOException1	java.io.IOException
      //   331	1	2	localIOException2	java.io.IOException
      //   335	19	2	localObject2	Object
      //   372	1	2	localIOException3	java.io.IOException
      //   378	33	2	localObject3	Object
      //   109	199	3	localObject4	Object
      //   333	25	3	localObject5	Object
      //   359	1	3	localIOException4	java.io.IOException
      //   363	1	3	localIOException5	java.io.IOException
      //   376	1	3	localObject6	Object
      //   382	7	3	localObject7	Object
      //   393	21	3	localObject8	Object
      //   190	155	4	localObject9	Object
      //   367	1	4	localIOException6	java.io.IOException
      //   389	1	4	localObject10	Object
      //   397	15	4	localException1	Exception
      //   416	1	4	localException2	Exception
      //   1	222	5	arrayOfByte	byte[]
      //   237	6	5	localException3	Exception
      //   386	16	5	localObject11	Object
      //   407	8	5	localException4	Exception
      //   78	119	6	localFile	File
      // Exception table:
      //   from	to	target	type
      //   202	208	237	java/lang/Exception
      //   208	215	237	java/lang/Exception
      //   220	234	237	java/lang/Exception
      //   290	312	237	java/lang/Exception
      //   283	287	288	java/io/IOException
      //   326	330	331	java/io/IOException
      //   182	192	333	finally
      //   317	322	359	java/io/IOException
      //   275	279	363	java/io/IOException
      //   344	349	367	java/io/IOException
      //   353	357	372	java/io/IOException
      //   192	202	376	finally
      //   202	208	382	finally
      //   208	215	382	finally
      //   220	234	382	finally
      //   290	312	382	finally
      //   246	262	386	finally
      //   262	271	386	finally
      //   182	192	397	java/lang/Exception
      //   192	202	407	java/lang/Exception
    }
  }
  
  public static class a
  {
    public static int bVw = 18;
    public static boolean bhN;
    public static boolean bhO = true;
    
    public static void initConfig()
    {
      Object localObject;
      if (!bhN)
      {
        localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.ShortVideoPlayInAIO.name(), null);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.ShortVideoPlayConfig", 2, "initConfig(), videoPlayConfig=" + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("\\|");
          if ((localObject != null) && (localObject.length >= 2))
          {
            if (!TextUtils.isEmpty(localObject[0])) {
              bhO = localObject[0].equals("1");
            }
            if (TextUtils.isEmpty(localObject[1])) {}
          }
        }
      }
      try
      {
        bVw = Integer.parseInt(localObject[1]);
        bhN = true;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.ShortVideoPlayConfig", 2, "initVideoPlayConfig(), sReadFromDPC=" + bhN + ", sAutoPlayInAIO:" + bhO + ", sRequestedFPS:" + bVw);
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bVw = 18;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */