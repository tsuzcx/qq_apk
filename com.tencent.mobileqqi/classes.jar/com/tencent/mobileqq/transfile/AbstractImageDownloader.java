package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.BaseStrategy;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;

public abstract class AbstractImageDownloader
  extends AbsDownloader
{
  public static int a = 0;
  public static final String a = "c2c_file";
  public static int b = 0;
  public static final String b = "group_file";
  public static final String c = "discuss_file";
  private static final String e = "big_img_decode";
  private static int jdField_f_of_type_Int = 0;
  private static final String jdField_f_of_type_JavaLangString = "big_img_decode_long";
  private static int jdField_g_of_type_Int = 0;
  private static final String jdField_g_of_type_JavaLangString = "big_img_decode_slice";
  private static final int h = 88000;
  private static final int i = 0;
  private static final int j = -1;
  private static final int k = 1;
  private static final int l = 2;
  private static final int m = 3;
  private static final int n = 4;
  private static final int o = 5;
  private static final int p = 6;
  private static int q = URLDrawableHelper.f;
  private static int r = URLDrawableHelper.g;
  protected BaseApplicationImpl a;
  protected String d;
  
  static
  {
    jdField_a_of_type_Int = 0;
    b = 0;
    f = 1048576;
    g = f * 2;
  }
  
  public AbstractImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.d = paramString;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
  }
  
  public static int a(Application paramApplication, int paramInt)
  {
    float f1 = 1.0F;
    if (paramInt > 150) {
      f1 = paramInt / 100;
    }
    float f2 = paramApplication.getResources().getDisplayMetrics().density;
    if (f2 <= 1.5D) {
      return (int)(f1 * 9.0F);
    }
    if (f2 <= 2.0D) {
      return (int)(f1 * 9.0F);
    }
    return (int)(f1 * 4.0F);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    int i2 = 1;
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      if (paramOptions.outWidth * paramOptions.outHeight > 5000000)
      {
        if (QLog.isColorLevel()) {
          QLog.d("URLDrawableHelper", 2, "calculateInSampleSize options.outWidth*options.outHeight=" + paramOptions.outWidth * paramOptions.outHeight);
        }
        i2 = 2;
      }
    }
    int i3;
    int i4;
    label94:
    do
    {
      return i2;
      i3 = paramOptions.outHeight;
      i4 = paramOptions.outWidth;
      if (i3 > paramInt2) {
        break;
      }
      i2 = i1;
    } while (i4 <= paramInt1);
    int i5 = Math.round(i3 / paramInt2);
    i2 = Math.round(i4 / paramInt1);
    if (i5 > i2) {}
    for (;;)
    {
      i2 = i1;
      if (i5 < 2) {
        break;
      }
      i4 /= 2;
      i3 /= 2;
      i1 *= 2;
      break label94;
      i5 = i2;
    }
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    int i2;
    int i3;
    int i1;
    float f2;
    label409:
    label547:
    label554:
    label557:
    float f3;
    for (;;)
    {
      float f1;
      try
      {
        i2 = paramBitmap.getWidth();
        i3 = paramBitmap.getHeight();
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        Bitmap localBitmap;
        Canvas localCanvas;
        if ((i2 < q) || (i3 < q))
        {
          if (i2 < i3)
          {
            f1 = q / i2;
            i2 = q;
            i3 = (int)(i3 * f1 + 0.5F);
            i1 = i3;
            if (i3 <= r) {
              break label554;
            }
            i1 = r;
            break label554;
            localBitmap = Bitmap.createBitmap(i2, i1, Bitmap.Config.ARGB_8888);
            localBitmap.setDensity(160);
            localCanvas = new Canvas(localBitmap);
            localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, i2, i1), 12.0F, 12.0F, localPaint);
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            localCanvas.scale(f1, f1);
            localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
            return localBitmap;
          }
          f1 = q / i3;
          i2 = (int)(i2 * f1 + 0.5F);
          i1 = i2;
          if (i2 > r) {
            i1 = r;
          }
          i3 = q;
          i2 = i1;
          i1 = i3;
          continue;
        }
        if ((i2 < r) && (i3 < r))
        {
          localBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
          localBitmap.setDensity(160);
          localCanvas = new Canvas(localBitmap);
          localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, i2, i3), 12.0F, 12.0F, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
          return localBitmap;
        }
        if (i2 > i3)
        {
          f1 = r / i2;
          if (i2 > i3)
          {
            f2 = q / i3;
            break label557;
            if (f1 >= f2) {
              break label547;
            }
            if (i2 <= i3) {
              break label601;
            }
            i1 = (int)(r / localObject + 0.5F);
            break;
            f1 = 12.0F / localObject;
            localBitmap = Bitmap.createBitmap(i2, i1, Bitmap.Config.ARGB_8888);
            localBitmap.setDensity(160);
            localCanvas = new Canvas(localBitmap);
            localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, i2, i1), f1, f1, localPaint);
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
            return localBitmap;
          }
        }
        else
        {
          f1 = r / i3;
          continue;
        }
        f2 = q / i2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject;
        label523:
        return paramBitmap;
      }
      i2 = r;
      i2 = (int)(i2 / localObject + 0.5F);
      break label580;
      i1 = i3;
      continue;
      continue;
      if (f1 <= f2) {
        break label595;
      }
      f3 = f1;
    }
    for (;;)
    {
      if (i2 <= i3) {
        break label523;
      }
      i2 = i3;
      label580:
      i3 = i1;
      i1 = i2;
      i2 = i3;
      break label409;
      label595:
      f3 = f2;
      break;
      label601:
      i1 = i2;
    }
  }
  
  public static String a(Exception paramException)
  {
    int i1 = 8;
    if (paramException == null) {
      return "Exception e is null,holy shit";
    }
    Object localObject = paramException.getMessage();
    StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      localObject = new StringBuilder(":");
      int i2 = arrayOfStackTraceElement.length;
      if (i2 > 8) {}
      for (;;)
      {
        ((StringBuilder)localObject).append("\n");
        i2 = 0;
        while (i2 < i1)
        {
          ((StringBuilder)localObject).append(arrayOfStackTraceElement[i2].toString()).append("\n");
          i2 += 1;
        }
        i1 = i2;
      }
      return paramException.toString() + ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void a(Application paramApplication, String paramString, int paramInt, boolean paramBoolean)
  {
    int i1 = 0;
    paramInt *= 4;
    try
    {
      if (paramInt < f)
      {
        paramInt = i1;
        if (!paramBoolean) {
          break label185;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramApplication = (QQAppInterface)((BaseApplicationImpl)paramApplication).getAppRuntime(paramString);
        paramString = new HashMap();
        paramString.put("param_FailCode", Integer.toString(paramInt + 88050));
        StatisticCollector.a(BaseApplication.getContext()).a(paramApplication.a(), "report_aio_photo_size", false, 0L, 0L, paramString, "");
        return;
        paramInt /= g;
        if (paramInt >= 10)
        {
          if (paramBoolean) {}
          for (paramInt = 17;; paramInt = 16) {
            break;
          }
        }
        if (paramInt >= 8)
        {
          if (paramBoolean) {}
          for (paramInt = 15;; paramInt = 14) {
            break;
          }
        }
        if (paramInt >= 6)
        {
          if (paramBoolean) {}
          for (paramInt = 13;; paramInt = 12) {
            break;
          }
        }
        if (paramBoolean) {}
        for (paramInt = paramInt * 2 + 3;; paramInt = paramInt * 2 + 2) {
          break;
        }
      }
    }
    catch (AccountNotMatchException paramApplication) {}
  }
  
  private void a(DownloadParams paramDownloadParams)
  {
    MessageForPic localMessageForPic;
    Object localObject;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramDownloadParams.tag;
      localObject = localMessageForPic.selfuin;
    }
    try
    {
      localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime((String)localObject);
      ((QQAppInterface)localObject).a().a.a(localMessageForPic, localMessageForPic.size);
      ((QQAppInterface)localObject).a().d();
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      a(paramDownloadParams, "payPicFlow", "FAIL,exceptionmsg:" + localAccountNotMatchException);
    }
  }
  
  private void a(DownloadParams paramDownloadParams, File paramFile, String paramString1, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean) {
      if (QLog.isColorLevel()) {
        a(paramDownloadParams, "DecodeFile", "DecodeFile SUCCESS,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    a(paramDownloadParams, "DecodeFile", "DecodeFile FAIL,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
  }
  
  public static void a(AbstractImageDownloader.ReportData paramReportData, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, FileMsg.StepBaseInfo paramStepBaseInfo1, FileMsg.StepBaseInfo paramStepBaseInfo2, FileMsg.StepTransInfo paramStepTransInfo)
  {
    System.currentTimeMillis();
    long l1;
    if (paramStepTransInfo != null)
    {
      l1 = paramStepTransInfo.jdField_e_of_type_Long;
      if (paramStepTransInfo == null) {
        break label42;
      }
    }
    label42:
    for (long l2 = paramStepTransInfo.f;; l2 = 0L)
    {
      if (!RichMediaStrategy.c(paramInt2)) {
        break label48;
      }
      return;
      l1 = 0L;
      break;
    }
    label48:
    HashMap localHashMap = new HashMap();
    String str2;
    String str1;
    if (!BaseTransProcessor.a(paramInt2, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt2));
      if ((paramInt2 == -9527) || (paramInt2 == 9311) || (paramInt2 == 9044) || (paramInt2 == 9350) || (paramInt2 == 9351))
      {
        localHashMap.put(BaseTransProcessor.L, paramString);
        str2 = "";
        if ((!paramBoolean) || (paramStepBaseInfo1 != null) || (paramStepBaseInfo2 != null) || (paramStepTransInfo != null)) {
          break label474;
        }
        str1 = "1_-1_0_0_0;2_-1_0_0_0;3_-1_0_0_0";
        label153:
        if (QLog.isColorLevel()) {
          QLog.d("reportResult", 2, "parmStep: " + str1);
        }
        localHashMap.put("param_step", str1);
        localHashMap.put("param_uuid", paramReportData.f);
        localHashMap.put("flow", String.valueOf(l1));
        localHashMap.put("msgTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramReportData.jdField_a_of_type_Long * 1000L)));
        localHashMap.put("client_exist", String.valueOf(paramReportData.jdField_a_of_type_Boolean));
        if (paramStepBaseInfo2 != null) {
          localHashMap.put("param_RequestUrl", paramStepBaseInfo2.b());
        }
        if (paramStepTransInfo != null) {
          localHashMap.put("param_HttpTran", paramStepTransInfo.b());
        }
        if (paramStepTransInfo != null)
        {
          localHashMap.put("param_retry", String.valueOf(paramStepTransInfo.b));
          if (!paramStepTransInfo.jdField_a_of_type_Boolean) {
            break label555;
          }
          localHashMap.put("serverip", paramStepTransInfo.c);
          localHashMap.put("param_Server", paramStepTransInfo.c);
        }
        label374:
        if (!paramBoolean) {
          break label623;
        }
        if ((!paramReportData.c.equals("actC2CPicDownloadV1")) && (!paramReportData.c.equals("actC2CPicSmallDownV1"))) {
          break label607;
        }
        localHashMap.put("param_toUin", paramReportData.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramReportData.c, true, paramInt1, l1, localHashMap, "");
      return;
      localHashMap.put("param_errorDesc", paramString);
      break;
      paramInt2 = -9527;
      localHashMap.put("param_errorDesc", paramString);
      break;
      label474:
      str1 = str2;
      if (paramStepBaseInfo1 == null) {
        break label153;
      }
      str1 = str2;
      if (paramStepBaseInfo2 == null) {
        break label153;
      }
      str1 = str2;
      if (paramStepTransInfo == null) {
        break label153;
      }
      str1 = paramStepBaseInfo1.a(1) + ";" + paramStepBaseInfo2.a(2) + ";" + paramStepTransInfo.a(3);
      break label153;
      label555:
      localHashMap.put("serverip", paramStepTransInfo.d);
      localHashMap.put("param_Server", paramStepTransInfo.d);
      if (paramInt2 != -9527) {
        break label374;
      }
      localHashMap.put("param_rspHeader", paramStepTransInfo.jdField_e_of_type_JavaLangString);
      break label374;
      label607:
      localHashMap.put("param_grpUin", paramReportData.jdField_a_of_type_JavaLangString);
    }
    label623:
    if (paramInt2 == 9301) {
      localHashMap.put("param_connecttrycount", paramString);
    }
    if ((paramReportData.g != null) && (!paramReportData.g.equals(""))) {
      localHashMap.put("param_MsgTime", paramReportData.g);
    }
    long l3 = paramInt1;
    if ((paramReportData.c.equals("actC2CPicDownloadV1")) || (paramReportData.c.equals("actC2CPicSmallDownV1")))
    {
      localHashMap.put("param_toUin", paramReportData.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramReportData.jdField_e_of_type_JavaLangString);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramReportData.c, false, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("param_grpUin", paramReportData.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramReportData.jdField_e_of_type_JavaLangString);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
  }
  
  /* Error */
  protected static void a(java.io.OutputStream paramOutputStream, File paramFile, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 494	java/io/File:length	()J
    //   4: lstore 6
    //   6: new 496	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 499	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_1
    //   15: lconst_0
    //   16: lstore 4
    //   18: sipush 8192
    //   21: newarray byte
    //   23: astore 8
    //   25: aload_1
    //   26: aload 8
    //   28: invokevirtual 503	java/io/FileInputStream:read	([B)I
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_m1
    //   34: if_icmpeq +81 -> 115
    //   37: aload_0
    //   38: aload 8
    //   40: iconst_0
    //   41: iload_3
    //   42: invokevirtual 509	java/io/OutputStream:write	([BII)V
    //   45: aload_0
    //   46: invokevirtual 512	java/io/OutputStream:flush	()V
    //   49: lload 4
    //   51: iload_3
    //   52: i2l
    //   53: ladd
    //   54: lstore 4
    //   56: aload_2
    //   57: lload 4
    //   59: l2f
    //   60: lload 6
    //   62: l2f
    //   63: fdiv
    //   64: ldc_w 513
    //   67: fmul
    //   68: f2i
    //   69: invokeinterface 518 2 0
    //   74: goto -49 -> 25
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull +41 -> 120
    //   82: aload_0
    //   83: invokevirtual 519	java/io/IOException:getMessage	()Ljava/lang/String;
    //   86: ldc_w 521
    //   89: invokevirtual 525	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   92: ifeq +28 -> 120
    //   95: new 527	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   98: dup
    //   99: sipush 9040
    //   102: ldc2_w 528
    //   105: aload_0
    //   106: invokevirtual 519	java/io/IOException:getMessage	()Ljava/lang/String;
    //   109: iconst_0
    //   110: iconst_0
    //   111: invokespecial 532	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   114: athrow
    //   115: aload_1
    //   116: invokevirtual 535	java/io/FileInputStream:close	()V
    //   119: return
    //   120: new 527	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   123: dup
    //   124: sipush 9301
    //   127: ldc2_w 536
    //   130: aload_0
    //   131: invokevirtual 519	java/io/IOException:getMessage	()Ljava/lang/String;
    //   134: iconst_0
    //   135: iconst_0
    //   136: invokespecial 532	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramOutputStream	java.io.OutputStream
    //   0	140	1	paramFile	File
    //   0	140	2	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   31	21	3	i1	int
    //   16	42	4	l1	long
    //   4	57	6	l2	long
    //   23	16	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	15	77	java/io/IOException
    //   18	25	77	java/io/IOException
    //   25	32	77	java/io/IOException
    //   37	49	77	java/io/IOException
    //   56	74	77	java/io/IOException
    //   115	119	77	java/io/IOException
  }
  
  private void a(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof DownloadParams))
    {
      localObject = (DownloadParams)paramObject;
      if ((((DownloadParams)localObject).tag instanceof PicUiInterface))
      {
        paramObject = (PicUiInterface)((DownloadParams)localObject).tag;
        localObject = ((DownloadParams)localObject).url.getProtocol();
        if (paramObject.isSendFromLocal())
        {
          i1 = RichMediaUtil.a(URLDrawableHelper.a((String)localObject, false));
          paramObject = paramObject.getPicUploadInfo();
          RichMediaUtil.a(paramObject.b, false, i1, String.valueOf(paramObject.jdField_a_of_type_Long), paramString1, paramString2);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i1;
      return;
      paramObject = paramObject.getPicDownloadInfo();
      if (paramObject.f == 1) {}
      for (boolean bool = true;; bool = false)
      {
        i1 = RichMediaUtil.a(URLDrawableHelper.a((String)localObject, bool));
        RichMediaUtil.a(paramObject.b, false, i1, String.valueOf(paramObject.jdField_a_of_type_Long), paramString1, paramString2);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("obj").append(paramObject);
    ((StringBuilder)localObject).append(" \tstep:").append(paramString1);
    ((StringBuilder)localObject).append(" \tcontent:").append(paramString2);
    QLog.d("Q.richmedia.", 2, ((StringBuilder)localObject).toString());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, String paramString, boolean paramBoolean5)
  {
    if (paramInt2 == 3)
    {
      paramInt2 = paramInt1 - 1;
      if (paramInt1 != 1) {
        break label49;
      }
      a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 0, paramString, paramInt2);
      a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 0, paramString, paramInt2);
    }
    label49:
    do
    {
      for (;;)
      {
        return;
        if (!paramBoolean5) {
          break;
        }
        if (!paramBoolean1) {
          if (paramBoolean3)
          {
            a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", -1, paramString, paramInt2);
            if (!paramBoolean2) {
              break label152;
            }
            a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 3, paramString, paramInt2);
          }
        }
        for (;;)
        {
          if (!paramBoolean2) {
            break label168;
          }
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_slice", 0, paramString, paramInt2);
          return;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 2, paramString, paramInt2);
          break;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 1, paramString, paramInt2);
          break;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 4, paramString, paramInt2);
        }
      }
      if (paramBoolean1) {
        a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 5, paramString, paramInt2);
      }
      if (paramBoolean2) {
        a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 6, paramString, paramInt2);
      }
    } while (!paramBoolean4);
    label152:
    label168:
    a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_slice", 6, paramString, paramInt2);
  }
  
  public void a(Application paramApplication, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        paramApplication = ((QQAppInterface)((BaseApplicationImpl)paramApplication).getAppRuntime(paramString2)).a();
      }
      catch (AccountNotMatchException paramApplication)
      {
        return;
      }
      paramString2 = new HashMap();
      paramString2.put("param_FailCode", Integer.toString(paramInt2 * 7 + paramInt1 + 88000));
      StatisticCollector.a(BaseApplication.getContext()).a(paramApplication, paramString1, bool, 0L, 0L, paramString2, "");
      return;
      boolean bool = false;
      continue;
      paramApplication = paramString2;
      if (paramInt2 == 0) {
        bool = true;
      }
    }
  }
  
  /* Error */
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: aload_0
    //   7: aload_2
    //   8: ldc_w 328
    //   11: new 119	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 595
    //   21: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: getfield 291	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   28: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 325	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_2
    //   38: getfield 598	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   41: astore 16
    //   43: aload_2
    //   44: getfield 543	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   47: astore 15
    //   49: aload 15
    //   51: invokevirtual 548	java/net/URL:getProtocol	()Ljava/lang/String;
    //   54: astore_3
    //   55: ldc_w 600
    //   58: aload_3
    //   59: invokevirtual 452	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifne +1320 -> 1382
    //   65: ldc_w 602
    //   68: aload_3
    //   69: invokevirtual 452	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifeq +1316 -> 1388
    //   75: goto +1307 -> 1382
    //   78: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +45 -> 126
    //   84: aload_0
    //   85: aload_2
    //   86: ldc_w 328
    //   89: new 119	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 604
    //   99: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   106: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 344
    //   112: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 16
    //   117: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 325	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   126: new 102	android/graphics/BitmapFactory$Options
    //   129: dup
    //   130: invokespecial 605	android/graphics/BitmapFactory$Options:<init>	()V
    //   133: astore 17
    //   135: aload 17
    //   137: getstatic 607	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/Bitmap$Config;
    //   140: putfield 610	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   143: aload 17
    //   145: sipush 160
    //   148: putfield 613	android/graphics/BitmapFactory$Options:inDensity	I
    //   151: aload 17
    //   153: sipush 160
    //   156: putfield 616	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   159: aload 17
    //   161: sipush 160
    //   164: putfield 619	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   167: aload 17
    //   169: iconst_1
    //   170: putfield 622	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   173: aload_1
    //   174: invokestatic 628	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   177: ifeq +97 -> 274
    //   180: iload 4
    //   182: ifne +92 -> 274
    //   185: aload_0
    //   186: aload_2
    //   187: invokespecial 630	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;)V
    //   190: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +45 -> 238
    //   196: aload_0
    //   197: aload_2
    //   198: ldc_w 328
    //   201: new 119	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 632
    //   211: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   218: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 344
    //   224: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 16
    //   229: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 325	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_1
    //   239: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   242: aload 17
    //   244: invokestatic 637	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   247: pop
    //   248: aload 17
    //   250: getfield 105	android/graphics/BitmapFactory$Options:outWidth	I
    //   253: sipush 1024
    //   256: if_icmpgt +18 -> 274
    //   259: aload 17
    //   261: getfield 108	android/graphics/BitmapFactory$Options:outHeight	I
    //   264: istore 5
    //   266: iload 5
    //   268: sipush 1024
    //   271: if_icmple +1123 -> 1394
    //   274: iload 4
    //   276: ifeq +219 -> 495
    //   279: aload 17
    //   281: iconst_0
    //   282: putfield 622	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   285: aload_1
    //   286: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   289: aload 17
    //   291: invokestatic 637	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   294: astore_3
    //   295: aload_3
    //   296: ifnull +57 -> 353
    //   299: aload_0
    //   300: aload_3
    //   301: invokespecial 639	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   304: astore 15
    //   306: aload_3
    //   307: aload 15
    //   309: invokevirtual 642	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   312: ifne +7 -> 319
    //   315: aload_3
    //   316: invokevirtual 645	android/graphics/Bitmap:recycle	()V
    //   319: new 647	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator
    //   322: dup
    //   323: aload_1
    //   324: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   327: invokespecial 648	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:<init>	(Ljava/lang/String;)V
    //   330: aload 15
    //   332: invokevirtual 649	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   335: astore_3
    //   336: aload_0
    //   337: aload_2
    //   338: aload_1
    //   339: aload 16
    //   341: aload 17
    //   343: iconst_1
    //   344: iconst_1
    //   345: ldc_w 651
    //   348: invokespecial 653	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   351: aload_3
    //   352: areturn
    //   353: aload_1
    //   354: invokevirtual 656	java/io/File:delete	()Z
    //   357: pop
    //   358: aload_0
    //   359: aload_2
    //   360: aload_1
    //   361: aload 16
    //   363: aload 17
    //   365: iconst_1
    //   366: iconst_0
    //   367: ldc_w 658
    //   370: invokespecial 653	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   373: new 491	java/io/IOException
    //   376: dup
    //   377: ldc_w 658
    //   380: invokespecial 659	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   383: athrow
    //   384: astore_3
    //   385: aload_0
    //   386: aload_2
    //   387: aload_1
    //   388: aload 16
    //   390: aload 17
    //   392: iconst_1
    //   393: iconst_0
    //   394: new 119	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   401: ldc_w 661
    //   404: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_3
    //   408: invokevirtual 662	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   411: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokespecial 653	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   420: aload_3
    //   421: athrow
    //   422: astore 15
    //   424: aload 15
    //   426: invokestatic 664	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   429: astore_3
    //   430: aload_3
    //   431: ifnull +12 -> 443
    //   434: aload_3
    //   435: astore_1
    //   436: aload_3
    //   437: invokevirtual 666	java/lang/String:length	()I
    //   440: ifne +9 -> 449
    //   443: aload 15
    //   445: invokevirtual 238	java/lang/Exception:toString	()Ljava/lang/String;
    //   448: astore_1
    //   449: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq +40 -> 492
    //   455: aload_0
    //   456: getfield 72	com/tencent/mobileqq/transfile/AbstractImageDownloader:d	Ljava/lang/String;
    //   459: iconst_2
    //   460: aload_1
    //   461: invokestatic 668	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload_0
    //   465: aload_2
    //   466: ldc_w 328
    //   469: new 119	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   476: ldc_w 670
    //   479: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_1
    //   483: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokespecial 325	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload 15
    //   494: athrow
    //   495: aload_0
    //   496: aload_2
    //   497: invokespecial 630	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;)V
    //   500: aload 17
    //   502: iconst_1
    //   503: putfield 622	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   506: aload_1
    //   507: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   510: aload 17
    //   512: invokestatic 637	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   515: pop
    //   516: aload 17
    //   518: getfield 108	android/graphics/BitmapFactory$Options:outHeight	I
    //   521: ifeq +11 -> 532
    //   524: aload 17
    //   526: getfield 105	android/graphics/BitmapFactory$Options:outWidth	I
    //   529: ifne +34 -> 563
    //   532: aload_1
    //   533: invokevirtual 656	java/io/File:delete	()Z
    //   536: pop
    //   537: aload_0
    //   538: aload_2
    //   539: aload_1
    //   540: aload 16
    //   542: aload 17
    //   544: iconst_1
    //   545: iconst_0
    //   546: ldc_w 672
    //   549: invokespecial 653	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   552: new 491	java/io/IOException
    //   555: dup
    //   556: ldc_w 672
    //   559: invokespecial 659	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   562: athrow
    //   563: aload 17
    //   565: aload 17
    //   567: aload_2
    //   568: getfield 675	com/tencent/image/DownloadParams:reqWidth	I
    //   571: aload_2
    //   572: getfield 678	com/tencent/image/DownloadParams:reqHeight	I
    //   575: invokestatic 680	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   578: putfield 335	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   581: aload 17
    //   583: getfield 105	android/graphics/BitmapFactory$Options:outWidth	I
    //   586: istore 6
    //   588: aload 17
    //   590: getfield 108	android/graphics/BitmapFactory$Options:outHeight	I
    //   593: istore 7
    //   595: aload 17
    //   597: iconst_0
    //   598: putfield 622	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   601: iconst_0
    //   602: istore 9
    //   604: aconst_null
    //   605: astore_3
    //   606: iconst_1
    //   607: istore 5
    //   609: aload 15
    //   611: invokevirtual 548	java/net/URL:getProtocol	()Ljava/lang/String;
    //   614: ldc_w 682
    //   617: invokevirtual 452	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   620: ifne +63 -> 683
    //   623: aload 15
    //   625: invokevirtual 548	java/net/URL:getProtocol	()Ljava/lang/String;
    //   628: ldc_w 684
    //   631: invokevirtual 452	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   634: ifne +49 -> 683
    //   637: aload 15
    //   639: invokevirtual 548	java/net/URL:getProtocol	()Ljava/lang/String;
    //   642: ldc_w 686
    //   645: invokevirtual 452	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   648: ifne +35 -> 683
    //   651: aload 15
    //   653: invokevirtual 548	java/net/URL:getProtocol	()Ljava/lang/String;
    //   656: ldc_w 688
    //   659: invokevirtual 452	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   662: ifne +21 -> 683
    //   665: aload 15
    //   667: invokevirtual 548	java/net/URL:getProtocol	()Ljava/lang/String;
    //   670: ldc_w 690
    //   673: invokevirtual 452	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   676: istore 10
    //   678: iload 10
    //   680: ifeq +696 -> 1376
    //   683: iconst_3
    //   684: istore 4
    //   686: iload 5
    //   688: iload 4
    //   690: if_icmpgt +681 -> 1371
    //   693: aload_1
    //   694: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   697: aload 17
    //   699: invokestatic 637	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   702: astore 15
    //   704: aload 15
    //   706: astore_3
    //   707: aload_3
    //   708: ifnonnull +258 -> 966
    //   711: iload 9
    //   713: istore 10
    //   715: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   718: ifeq +60 -> 778
    //   721: iload 9
    //   723: istore 10
    //   725: aload_0
    //   726: aload_2
    //   727: ldc_w 328
    //   730: new 119	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 692
    //   740: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 16
    //   745: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: ldc_w 694
    //   751: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: iload 5
    //   756: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: ldc_w 696
    //   762: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: aload_1
    //   766: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   769: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokespecial 325	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   778: iload 9
    //   780: istore 10
    //   782: new 145	java/lang/OutOfMemoryError
    //   785: dup
    //   786: new 119	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   793: ldc_w 692
    //   796: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload 16
    //   801: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: ldc_w 694
    //   807: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: iload 5
    //   812: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   815: ldc_w 696
    //   818: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: aload_1
    //   822: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   825: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokespecial 697	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   834: athrow
    //   835: astore 15
    //   837: iload 10
    //   839: istore 9
    //   841: aload_3
    //   842: ifnull +7 -> 849
    //   845: aload_3
    //   846: invokevirtual 645	android/graphics/Bitmap:recycle	()V
    //   849: aload 15
    //   851: ifnull +456 -> 1307
    //   854: aload 15
    //   856: invokevirtual 662	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   859: astore 15
    //   861: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   864: ifeq +81 -> 945
    //   867: aload_0
    //   868: aload_2
    //   869: ldc_w 328
    //   872: new 119	java/lang/StringBuilder
    //   875: dup
    //   876: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   879: ldc_w 699
    //   882: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: iload 5
    //   887: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   890: ldc_w 332
    //   893: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload 17
    //   898: getfield 335	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   901: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   904: ldc_w 337
    //   907: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: aload_1
    //   911: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   914: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: ldc_w 344
    //   920: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: aload 16
    //   925: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: ldc_w 701
    //   931: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload 15
    //   936: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   942: invokespecial 325	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   945: iload 5
    //   947: iconst_1
    //   948: iadd
    //   949: istore 5
    //   951: aload 17
    //   953: aload 17
    //   955: getfield 335	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   958: iconst_2
    //   959: imul
    //   960: putfield 335	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   963: goto -277 -> 686
    //   966: iload 9
    //   968: istore 10
    //   970: getstatic 706	android/os/Build$VERSION:SDK_INT	I
    //   973: bipush 11
    //   975: if_icmplt +329 -> 1304
    //   978: iload 9
    //   980: istore 10
    //   982: aload_3
    //   983: invokestatic 712	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   986: istore 11
    //   988: iload 11
    //   990: ifeq +314 -> 1304
    //   993: iload 9
    //   995: istore 10
    //   997: new 708	com/tencent/image/SliceBitmap
    //   1000: dup
    //   1001: aload_3
    //   1002: invokespecial 713	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   1005: astore 15
    //   1007: iconst_1
    //   1008: istore 9
    //   1010: aload_3
    //   1011: invokevirtual 645	android/graphics/Bitmap:recycle	()V
    //   1014: aload_0
    //   1015: aload_2
    //   1016: aload_1
    //   1017: aload 16
    //   1019: aload 17
    //   1021: iload 5
    //   1023: iconst_1
    //   1024: ldc_w 715
    //   1027: invokespecial 653	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1030: aload 15
    //   1032: astore_3
    //   1033: iconst_1
    //   1034: istore 9
    //   1036: aload_3
    //   1037: ifnull +276 -> 1313
    //   1040: iconst_1
    //   1041: istore 10
    //   1043: aload_0
    //   1044: aload_2
    //   1045: aload_1
    //   1046: aload 16
    //   1048: aload 17
    //   1050: iload 5
    //   1052: iload 10
    //   1054: ldc_w 281
    //   1057: invokespecial 653	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1060: aload_2
    //   1061: getfield 291	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1064: ifnull +172 -> 1236
    //   1067: aload_2
    //   1068: getfield 291	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1071: instanceof 293
    //   1074: ifeq +162 -> 1236
    //   1077: aload_2
    //   1078: getfield 291	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1081: checkcast 293	com/tencent/mobileqq/data/MessageForPic
    //   1084: astore_1
    //   1085: aload_1
    //   1086: getfield 296	com/tencent/mobileqq/data/MessageForPic:selfuin	Ljava/lang/String;
    //   1089: astore 15
    //   1091: aload_1
    //   1092: invokevirtual 716	com/tencent/mobileqq/data/MessageForPic:isSendFromLocal	()Z
    //   1095: istore 14
    //   1097: aload_3
    //   1098: ifnull +221 -> 1319
    //   1101: iconst_1
    //   1102: istore 10
    //   1104: iload 6
    //   1106: iload 7
    //   1108: imul
    //   1109: istore 8
    //   1111: iload 8
    //   1113: getstatic 717	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_Int	I
    //   1116: if_icmple +209 -> 1325
    //   1119: iconst_1
    //   1120: istore 11
    //   1122: goto +274 -> 1396
    //   1125: getstatic 50	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1128: ifeq +9 -> 1137
    //   1131: getstatic 52	com/tencent/mobileqq/transfile/AbstractImageDownloader:b	I
    //   1134: ifne +35 -> 1169
    //   1137: aload_0
    //   1138: getfield 74	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1141: invokevirtual 718	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1144: invokevirtual 87	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1147: getfield 721	android/util/DisplayMetrics:widthPixels	I
    //   1150: putstatic 50	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1153: aload_0
    //   1154: getfield 74	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1157: invokevirtual 718	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1160: invokevirtual 87	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1163: getfield 724	android/util/DisplayMetrics:heightPixels	I
    //   1166: putstatic 52	com/tencent/mobileqq/transfile/AbstractImageDownloader:b	I
    //   1169: getstatic 50	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1172: getstatic 52	com/tencent/mobileqq/transfile/AbstractImageDownloader:b	I
    //   1175: if_icmple +162 -> 1337
    //   1178: getstatic 50	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1181: istore 6
    //   1183: iload 8
    //   1185: getstatic 725	com/tencent/mobileqq/transfile/URLDrawableHelper:b	I
    //   1188: if_icmpgt +157 -> 1345
    //   1191: iload 6
    //   1193: sipush 1000
    //   1196: if_icmple +149 -> 1345
    //   1199: iconst_1
    //   1200: istore 13
    //   1202: aload_0
    //   1203: iload 11
    //   1205: iload 12
    //   1207: iload 13
    //   1209: iload 9
    //   1211: iload 5
    //   1213: iload 4
    //   1215: aload 15
    //   1217: iload 10
    //   1219: invokespecial 727	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(ZZZZIILjava/lang/String;Z)V
    //   1222: aload_0
    //   1223: aload_0
    //   1224: getfield 74	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1227: aload 15
    //   1229: iload 8
    //   1231: iload 14
    //   1233: invokespecial 729	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/app/Application;Ljava/lang/String;IZ)V
    //   1236: aload_3
    //   1237: ifnonnull +114 -> 1351
    //   1240: new 491	java/io/IOException
    //   1243: dup
    //   1244: ldc_w 731
    //   1247: invokespecial 659	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1250: athrow
    //   1251: astore 15
    //   1253: iload 9
    //   1255: istore 10
    //   1257: aload_0
    //   1258: aload_2
    //   1259: ldc_w 328
    //   1262: new 119	java/lang/StringBuilder
    //   1265: dup
    //   1266: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1269: ldc_w 733
    //   1272: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: aload 15
    //   1277: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1280: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokespecial 325	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1289: iload 9
    //   1291: istore 10
    //   1293: new 145	java/lang/OutOfMemoryError
    //   1296: dup
    //   1297: ldc_w 735
    //   1300: invokespecial 697	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   1303: athrow
    //   1304: goto -268 -> 1036
    //   1307: aconst_null
    //   1308: astore 15
    //   1310: goto -449 -> 861
    //   1313: iconst_0
    //   1314: istore 10
    //   1316: goto -273 -> 1043
    //   1319: iconst_0
    //   1320: istore 10
    //   1322: goto -218 -> 1104
    //   1325: iconst_0
    //   1326: istore 11
    //   1328: goto +68 -> 1396
    //   1331: iconst_0
    //   1332: istore 12
    //   1334: goto -209 -> 1125
    //   1337: getstatic 52	com/tencent/mobileqq/transfile/AbstractImageDownloader:b	I
    //   1340: istore 6
    //   1342: goto -159 -> 1183
    //   1345: iconst_0
    //   1346: istore 13
    //   1348: goto -146 -> 1202
    //   1351: aload_3
    //   1352: areturn
    //   1353: astore 15
    //   1355: goto -514 -> 841
    //   1358: astore 15
    //   1360: goto -519 -> 841
    //   1363: astore 15
    //   1365: iconst_1
    //   1366: istore 9
    //   1368: goto -115 -> 1253
    //   1371: aconst_null
    //   1372: astore_3
    //   1373: goto -337 -> 1036
    //   1376: iconst_1
    //   1377: istore 4
    //   1379: goto -693 -> 686
    //   1382: iconst_1
    //   1383: istore 4
    //   1385: goto -1307 -> 78
    //   1388: iconst_0
    //   1389: istore 4
    //   1391: goto -1313 -> 78
    //   1394: aconst_null
    //   1395: areturn
    //   1396: iload 6
    //   1398: sipush 2048
    //   1401: if_icmpgt +11 -> 1412
    //   1404: iload 7
    //   1406: sipush 2048
    //   1409: if_icmple -78 -> 1331
    //   1412: iconst_1
    //   1413: istore 12
    //   1415: goto -290 -> 1125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1418	0	this	AbstractImageDownloader
    //   0	1418	1	paramFile	File
    //   0	1418	2	paramDownloadParams	DownloadParams
    //   0	1418	3	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   180	1210	4	i1	int
    //   264	948	5	i2	int
    //   586	816	6	i3	int
    //   593	817	7	i4	int
    //   1109	121	8	i5	int
    //   602	765	9	bool1	boolean
    //   676	645	10	bool2	boolean
    //   986	341	11	bool3	boolean
    //   1205	209	12	bool4	boolean
    //   1200	147	13	bool5	boolean
    //   1095	137	14	bool6	boolean
    //   47	284	15	localObject1	Object
    //   422	244	15	localException1	Exception
    //   702	3	15	localBitmap	Bitmap
    //   835	20	15	localOutOfMemoryError1	OutOfMemoryError
    //   859	369	15	localObject2	Object
    //   1251	25	15	localException2	Exception
    //   1308	1	15	localObject3	Object
    //   1353	1	15	localOutOfMemoryError2	OutOfMemoryError
    //   1358	1	15	localOutOfMemoryError3	OutOfMemoryError
    //   1363	1	15	localException3	Exception
    //   41	1006	16	str	String
    //   133	916	17	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   279	295	384	java/lang/OutOfMemoryError
    //   299	319	384	java/lang/OutOfMemoryError
    //   319	351	384	java/lang/OutOfMemoryError
    //   353	384	384	java/lang/OutOfMemoryError
    //   37	75	422	java/lang/Exception
    //   78	126	422	java/lang/Exception
    //   126	180	422	java/lang/Exception
    //   185	238	422	java/lang/Exception
    //   238	266	422	java/lang/Exception
    //   279	295	422	java/lang/Exception
    //   299	319	422	java/lang/Exception
    //   319	351	422	java/lang/Exception
    //   353	384	422	java/lang/Exception
    //   385	422	422	java/lang/Exception
    //   495	532	422	java/lang/Exception
    //   532	563	422	java/lang/Exception
    //   563	601	422	java/lang/Exception
    //   609	678	422	java/lang/Exception
    //   693	704	422	java/lang/Exception
    //   715	721	422	java/lang/Exception
    //   725	778	422	java/lang/Exception
    //   782	835	422	java/lang/Exception
    //   845	849	422	java/lang/Exception
    //   854	861	422	java/lang/Exception
    //   861	945	422	java/lang/Exception
    //   951	963	422	java/lang/Exception
    //   970	978	422	java/lang/Exception
    //   982	988	422	java/lang/Exception
    //   1043	1097	422	java/lang/Exception
    //   1111	1119	422	java/lang/Exception
    //   1125	1137	422	java/lang/Exception
    //   1137	1169	422	java/lang/Exception
    //   1169	1183	422	java/lang/Exception
    //   1183	1191	422	java/lang/Exception
    //   1202	1236	422	java/lang/Exception
    //   1240	1251	422	java/lang/Exception
    //   1257	1289	422	java/lang/Exception
    //   1293	1304	422	java/lang/Exception
    //   1337	1342	422	java/lang/Exception
    //   715	721	835	java/lang/OutOfMemoryError
    //   725	778	835	java/lang/OutOfMemoryError
    //   782	835	835	java/lang/OutOfMemoryError
    //   970	978	835	java/lang/OutOfMemoryError
    //   982	988	835	java/lang/OutOfMemoryError
    //   997	1007	835	java/lang/OutOfMemoryError
    //   1257	1289	835	java/lang/OutOfMemoryError
    //   1293	1304	835	java/lang/OutOfMemoryError
    //   997	1007	1251	java/lang/Exception
    //   1010	1030	1353	java/lang/OutOfMemoryError
    //   693	704	1358	java/lang/OutOfMemoryError
    //   1010	1030	1363	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbstractImageDownloader
 * JD-Core Version:    0.7.0.1
 */