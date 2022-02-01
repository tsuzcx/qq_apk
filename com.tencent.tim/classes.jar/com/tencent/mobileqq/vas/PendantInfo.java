package com.tencent.mobileqq.vas;

import abgk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import anlm;
import aqft;
import aqgm;
import aqhq;
import aqiw;
import aqql;
import aqva;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import wja;
import wnu;
import wnu.a;

public class PendantInfo
  implements wnu.a
{
  static int ebK = 1000;
  static int ebL = 20;
  public static int ebM = 1;
  public static int ebN = 2;
  public static int ebO = 3;
  public static int ebP = 4;
  public static int ebQ = 5;
  public static int ebR = 6;
  public static int ebS = 7;
  public static int ebT = -2147483648;
  public static int ebU = 100;
  public static int ebV = 2147483647;
  public static int ebW = 3;
  static ConcurrentHashMap<Long, Integer> je = new ConcurrentHashMap();
  final List<Long> IX = new LinkedList();
  aqva a;
  public AnimationLruCache a;
  public a a;
  public long atD;
  public MqqHandler b;
  protected Object bN;
  String[] cA;
  public boolean cVH = false;
  private String cvU;
  String cvV = null;
  public Bitmap dD;
  public int ebX;
  int ebY;
  protected Context mContext;
  public int mCurFrameIndex = -1;
  public boolean mDecodeNextFrameEnd = true;
  private int mFrameCount;
  public boolean mIsPause;
  public int mRepeatCount = ebW;
  int mType;
  Map<String, Long> ol = new ConcurrentHashMap();
  
  public PendantInfo(long paramLong)
  {
    this.jdField_a_of_type_Aqva = null;
    this.atD = paramLong;
    this.ebX = -1;
    this.ebY = -1;
    this.mType = -1;
    this.cA = null;
    this.mContext = BaseApplicationImpl.getContext();
    this.b = new aqql(this, Looper.getMainLooper(), null);
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_Aqva = ((aqva)localQQAppInterface.getManager(47));
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache = new AnimationLruCache(ebL);
  }
  
  static boolean a(Message paramMessage, long paramLong)
  {
    Bundle localBundle = paramMessage.getData();
    if (localBundle == null)
    {
      localBundle = new Bundle();
      localBundle.putLong("targetId", paramLong);
      paramMessage.setData(localBundle);
      return true;
    }
    try
    {
      localBundle.putLong("targetId", paramLong);
      return true;
    }
    catch (ClassCastException paramMessage)
    {
      QLog.e("PendantInfo", 1, "pendant can not display because of system error!");
    }
    return false;
  }
  
  private QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  void Vv(String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = paramString.indexOf("\"interval\":");
      if (i == -1) {
        break label110;
      }
      int j = paramString.indexOf(",", i + 10);
      if (j == -1) {
        break label110;
      }
      paramString = paramString.substring(i + 11, j);
      if (paramString == null) {
        break label110;
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString.trim());
        if (-2147483648 != i)
        {
          this.ebY = i;
          je.put(Long.valueOf(this.atD), Integer.valueOf(this.ebY));
          return;
        }
      }
      catch (Exception paramString)
      {
        i = -2147483648;
        continue;
        this.ebY = ebU;
        l(1, 7, 0L);
        return;
      }
      label110:
      i = -2147483648;
    }
  }
  
  int a(File paramFile, int paramInt)
  {
    int i;
    if (paramFile == null)
    {
      i = -1;
      return i;
    }
    Integer localInteger = (Integer)aqgm.iW.get(Long.valueOf(this.atD));
    int j;
    Object localObject1;
    int k;
    String str;
    if ((paramFile.exists()) && ((localInteger == null) || (-1 == this.mType)))
    {
      j = -2147483648;
      localObject1 = aqhq.fileToBytes(paramFile);
      if (localObject1 != null)
      {
        localObject1 = new String((byte[])localObject1);
        k = ((String)localObject1).indexOf("\"type\":");
        i = j;
        if (k != -1)
        {
          int m = ((String)localObject1).indexOf(",", k + 6);
          i = j;
          if (m != -1)
          {
            str = ((String)localObject1).substring(k + 7, m);
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt(str.trim());
        i = j;
        if (QLog.isColorLevel())
        {
          i = j;
          QLog.d("PendantInfo", 2, "pendant type=" + j);
        }
        i = j;
        this.mType = j;
        i = j;
        aqgm.iW.put(Long.valueOf(this.atD), Integer.valueOf(j));
        i = j;
        j = ((String)localObject1).indexOf("\"isDiy\":");
        if (j != -1)
        {
          k = ((String)localObject1).indexOf(",", j + 7);
          if (k != -1) {
            str = ((String)localObject1).substring(j + 8, k);
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          j = Integer.parseInt(str.trim());
          if (QLog.isColorLevel()) {
            QLog.d("PendantInfo", 2, "pendant isDiy=" + j);
          }
          aqgm.iX.put(Long.valueOf(this.atD), Integer.valueOf(j));
          if (i != -2147483648) {
            continue;
          }
          paramFile.delete();
          l(1, 7, 0L);
          if ((-1 == this.ebY) && (paramInt == 2))
          {
            if (!je.containsKey(Long.valueOf(this.atD))) {
              continue;
            }
            this.ebY = ((Integer)je.get(Long.valueOf(this.atD))).intValue();
            if (QLog.isColorLevel()) {
              QLog.d("PendantInfo", 2, "parsePendantConfig, read interval from cache=" + this.ebY + ", id=" + this.atD);
            }
          }
          i = paramInt;
          if (localInteger == null) {
            break;
          }
          i = paramInt;
          if (localInteger.intValue() != 0) {
            break;
          }
          i = paramInt;
          if (paramInt != 2) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PendantInfo", 2, "static pendant, abort dynamic request");
          }
          this.ebX = 5;
          this.cvU = aqgm.m(this.atD, this.ebX);
          localObject1 = wja.b();
          if (this.ebX != 2) {
            continue;
          }
          paramFile = "dynamic_pendant";
          this.cvV = (paramFile + "_" + this.atD + "_" + this.ebX);
          return this.ebX;
        }
        catch (Exception localException2)
        {
          l(1, 7, 0L);
        }
        localException1 = localException1;
        l(1, 7, 0L);
        continue;
        continue;
        localInteger = (Integer)aqgm.iW.get(Long.valueOf(this.atD));
        continue;
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (!paramFile.exists()) {}
        }
        try
        {
          localObject2 = aqhq.readFileToString(paramFile);
          Vv((String)localObject2);
        }
        catch (IOException localIOException)
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("PendantInfo", 2, "parsePendantConfig, read config file exception: " + paramFile + ", " + MsfSdkUtils.getStackTraceString(localIOException));
          localObject2 = localObject1;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject3 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("PendantInfo", 2, "parsePendantConfig, read config file oom: " + paramFile);
          localObject3 = localObject1;
          continue;
        }
        paramFile = "static_pendant";
        continue;
      }
      localObject1 = null;
      i = -2147483648;
      continue;
      localObject1 = null;
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  protected Bitmap a(int paramInt1, Object paramObject, int paramInt2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: iload_1
    //   7: iconst_2
    //   8: if_icmpne +638 -> 646
    //   11: aload_2
    //   12: ifnonnull +10 -> 22
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 107	com/tencent/mobileqq/vas/PendantInfo:mDecodeNextFrameEnd	Z
    //   20: aconst_null
    //   21: areturn
    //   22: new 384	android/graphics/BitmapFactory$Options
    //   25: dup
    //   26: invokespecial 385	android/graphics/BitmapFactory$Options:<init>	()V
    //   29: astore 11
    //   31: aload_2
    //   32: checkcast 386	[Ljava/lang/String;
    //   35: checkcast 386	[Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: iload_3
    //   41: iconst_1
    //   42: iadd
    //   43: aload_2
    //   44: arraylength
    //   45: irem
    //   46: aaload
    //   47: astore 10
    //   49: aload 11
    //   51: sipush 320
    //   54: putfield 389	android/graphics/BitmapFactory$Options:inDensity	I
    //   57: aload 11
    //   59: invokestatic 208	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   62: invokevirtual 393	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   65: invokevirtual 399	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   68: getfield 404	android/util/DisplayMetrics:densityDpi	I
    //   71: putfield 407	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   74: aload 11
    //   76: getfield 389	android/graphics/BitmapFactory$Options:inDensity	I
    //   79: aload 11
    //   81: getfield 407	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   84: if_icmpge +13 -> 97
    //   87: aload 11
    //   89: aload 11
    //   91: getfield 407	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   94: putfield 389	android/graphics/BitmapFactory$Options:inDensity	I
    //   97: new 409	java/io/FileInputStream
    //   100: dup
    //   101: aload 10
    //   103: invokespecial 411	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   106: astore 9
    //   108: getstatic 416	android/os/Build$VERSION:SDK_INT	I
    //   111: bipush 11
    //   113: if_icmple +655 -> 768
    //   116: aload 11
    //   118: getfield 389	android/graphics/BitmapFactory$Options:inDensity	I
    //   121: aload 11
    //   123: getfield 407	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   126: if_icmpgt +642 -> 768
    //   129: new 384	android/graphics/BitmapFactory$Options
    //   132: dup
    //   133: invokespecial 385	android/graphics/BitmapFactory$Options:<init>	()V
    //   136: astore 8
    //   138: aload 8
    //   140: iconst_1
    //   141: putfield 419	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   144: new 421	java/io/BufferedInputStream
    //   147: dup
    //   148: new 409	java/io/FileInputStream
    //   151: dup
    //   152: aload 10
    //   154: invokespecial 411	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   157: invokespecial 424	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   160: astore_2
    //   161: aload_2
    //   162: astore 5
    //   164: aload_2
    //   165: astore 4
    //   167: aload_2
    //   168: aconst_null
    //   169: aload 8
    //   171: invokestatic 430	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   174: pop
    //   175: aload_2
    //   176: astore 5
    //   178: aload_2
    //   179: astore 4
    //   181: aload_0
    //   182: getfield 432	com/tencent/mobileqq/vas/PendantInfo:dD	Landroid/graphics/Bitmap;
    //   185: ifnull +124 -> 309
    //   188: aload_2
    //   189: astore 5
    //   191: aload_2
    //   192: astore 4
    //   194: aload_0
    //   195: getfield 432	com/tencent/mobileqq/vas/PendantInfo:dD	Landroid/graphics/Bitmap;
    //   198: aload 8
    //   200: getfield 435	android/graphics/BitmapFactory$Options:outWidth	I
    //   203: aload 8
    //   205: getfield 438	android/graphics/BitmapFactory$Options:outHeight	I
    //   208: invokestatic 443	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:b	(Landroid/graphics/Bitmap;II)Z
    //   211: ifeq +98 -> 309
    //   214: aload_2
    //   215: astore 5
    //   217: aload_2
    //   218: astore 4
    //   220: aload 11
    //   222: aload_0
    //   223: getfield 432	com/tencent/mobileqq/vas/PendantInfo:dD	Landroid/graphics/Bitmap;
    //   226: putfield 446	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   229: aload_2
    //   230: astore 5
    //   232: aload_2
    //   233: astore 4
    //   235: aload 11
    //   237: iconst_1
    //   238: putfield 449	android/graphics/BitmapFactory$Options:inMutable	Z
    //   241: aload_2
    //   242: astore 5
    //   244: aload_2
    //   245: astore 4
    //   247: aload 11
    //   249: iconst_1
    //   250: putfield 452	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   253: aload_2
    //   254: astore 5
    //   256: aload_2
    //   257: astore 4
    //   259: new 421	java/io/BufferedInputStream
    //   262: dup
    //   263: aload 9
    //   265: invokespecial 424	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   268: aconst_null
    //   269: aload 11
    //   271: invokestatic 455	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   274: astore 8
    //   276: aload 8
    //   278: astore 4
    //   280: aload_2
    //   281: astore 5
    //   283: aload 5
    //   285: ifnull +8 -> 293
    //   288: aload 5
    //   290: invokevirtual 458	java/io/BufferedInputStream:close	()V
    //   293: aload 9
    //   295: invokevirtual 461	java/io/InputStream:close	()V
    //   298: aload 4
    //   300: areturn
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 464	java/io/IOException:printStackTrace	()V
    //   306: aload 4
    //   308: areturn
    //   309: aload_2
    //   310: astore 5
    //   312: aload_2
    //   313: astore 4
    //   315: aload 11
    //   317: aconst_null
    //   318: putfield 446	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   321: goto -92 -> 229
    //   324: astore_2
    //   325: ldc 196
    //   327: iconst_1
    //   328: new 295	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 466
    //   338: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_2
    //   342: invokestatic 372	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   345: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload 7
    //   356: astore 4
    //   358: goto -75 -> 283
    //   361: astore 5
    //   363: aconst_null
    //   364: astore_2
    //   365: ldc 196
    //   367: iconst_1
    //   368: new 295	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   375: ldc_w 468
    //   378: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 5
    //   383: invokestatic 372	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   386: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload 11
    //   397: aconst_null
    //   398: putfield 446	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   401: aload 11
    //   403: iconst_0
    //   404: putfield 449	android/graphics/BitmapFactory$Options:inMutable	Z
    //   407: new 421	java/io/BufferedInputStream
    //   410: dup
    //   411: aload 9
    //   413: invokespecial 424	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   416: aconst_null
    //   417: aload 11
    //   419: invokestatic 455	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   422: astore 4
    //   424: aload 4
    //   426: astore 6
    //   428: ldc 196
    //   430: iconst_1
    //   431: new 295	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 470
    //   441: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 10
    //   446: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: aload_0
    //   456: getfield 432	com/tencent/mobileqq/vas/PendantInfo:dD	Landroid/graphics/Bitmap;
    //   459: ifnull +51 -> 510
    //   462: ldc 196
    //   464: iconst_1
    //   465: new 295	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 472
    //   475: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_0
    //   479: getfield 432	com/tencent/mobileqq/vas/PendantInfo:dD	Landroid/graphics/Bitmap;
    //   482: invokevirtual 477	android/graphics/Bitmap:getWidth	()I
    //   485: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: ldc_w 479
    //   491: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_0
    //   495: getfield 432	com/tencent/mobileqq/vas/PendantInfo:dD	Landroid/graphics/Bitmap;
    //   498: invokevirtual 482	android/graphics/Bitmap:getHeight	()I
    //   501: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: aload 6
    //   512: astore 4
    //   514: aload_2
    //   515: astore 5
    //   517: aload 6
    //   519: ifnull -236 -> 283
    //   522: ldc 196
    //   524: iconst_1
    //   525: new 295	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 484
    //   535: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 6
    //   540: invokevirtual 477	android/graphics/Bitmap:getWidth	()I
    //   543: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: ldc_w 479
    //   549: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload 6
    //   554: invokevirtual 482	android/graphics/Bitmap:getHeight	()I
    //   557: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload 6
    //   568: astore 4
    //   570: aload_2
    //   571: astore 5
    //   573: goto -290 -> 283
    //   576: astore 4
    //   578: ldc 196
    //   580: iconst_1
    //   581: new 295	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 486
    //   591: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload 4
    //   596: invokestatic 372	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   599: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: goto -180 -> 428
    //   611: astore 4
    //   613: ldc 196
    //   615: iconst_1
    //   616: new 295	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   623: ldc_w 488
    //   626: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload 4
    //   631: invokestatic 372	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   634: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: goto -215 -> 428
    //   646: new 384	android/graphics/BitmapFactory$Options
    //   649: dup
    //   650: invokespecial 385	android/graphics/BitmapFactory$Options:<init>	()V
    //   653: astore 4
    //   655: aload_2
    //   656: checkcast 14	com/tencent/mobileqq/vas/PendantInfo$b
    //   659: astore_2
    //   660: aload 4
    //   662: sipush 320
    //   665: putfield 389	android/graphics/BitmapFactory$Options:inDensity	I
    //   668: aload 4
    //   670: invokestatic 208	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   673: invokevirtual 393	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   676: invokevirtual 399	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   679: getfield 404	android/util/DisplayMetrics:densityDpi	I
    //   682: putfield 407	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   685: aload 4
    //   687: getfield 389	android/graphics/BitmapFactory$Options:inDensity	I
    //   690: aload 4
    //   692: getfield 407	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   695: if_icmpge +13 -> 708
    //   698: aload 4
    //   700: aload 4
    //   702: getfield 407	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   705: putfield 389	android/graphics/BitmapFactory$Options:inDensity	I
    //   708: new 421	java/io/BufferedInputStream
    //   711: dup
    //   712: new 409	java/io/FileInputStream
    //   715: dup
    //   716: aload_2
    //   717: getfield 491	com/tencent/mobileqq/vas/PendantInfo$b:src	Ljava/lang/String;
    //   720: invokespecial 411	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   723: invokespecial 424	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   726: aconst_null
    //   727: aload 4
    //   729: invokestatic 455	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   732: astore_2
    //   733: aload_2
    //   734: areturn
    //   735: astore_2
    //   736: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   739: ifeq -719 -> 20
    //   742: ldc 196
    //   744: iconst_2
    //   745: ldc_w 493
    //   748: invokestatic 496	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aconst_null
    //   752: areturn
    //   753: astore 5
    //   755: aload 4
    //   757: astore_2
    //   758: goto -393 -> 365
    //   761: astore_2
    //   762: aconst_null
    //   763: astore 5
    //   765: goto -440 -> 325
    //   768: aconst_null
    //   769: astore_2
    //   770: goto -517 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	773	0	this	PendantInfo
    //   0	773	1	paramInt1	int
    //   0	773	2	paramObject	Object
    //   0	773	3	paramInt2	int
    //   165	404	4	localObject1	Object
    //   576	19	4	localOutOfMemoryError	OutOfMemoryError
    //   611	19	4	localException	Exception
    //   653	103	4	localOptions1	android.graphics.BitmapFactory.Options
    //   162	149	5	localObject2	Object
    //   361	21	5	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   515	57	5	localObject3	Object
    //   753	1	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   763	1	5	localObject4	Object
    //   1	566	6	localObject5	Object
    //   4	351	7	localObject6	Object
    //   136	141	8	localObject7	Object
    //   106	306	9	localFileInputStream	java.io.FileInputStream
    //   47	398	10	str	String
    //   29	389	11	localOptions2	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   288	293	301	java/io/IOException
    //   293	298	301	java/io/IOException
    //   167	175	324	java/lang/OutOfMemoryError
    //   181	188	324	java/lang/OutOfMemoryError
    //   194	214	324	java/lang/OutOfMemoryError
    //   220	229	324	java/lang/OutOfMemoryError
    //   235	241	324	java/lang/OutOfMemoryError
    //   247	253	324	java/lang/OutOfMemoryError
    //   259	276	324	java/lang/OutOfMemoryError
    //   315	321	324	java/lang/OutOfMemoryError
    //   108	161	361	java/lang/IllegalArgumentException
    //   407	424	576	java/lang/OutOfMemoryError
    //   407	424	611	java/lang/Exception
    //   708	733	735	java/lang/OutOfMemoryError
    //   167	175	753	java/lang/IllegalArgumentException
    //   181	188	753	java/lang/IllegalArgumentException
    //   194	214	753	java/lang/IllegalArgumentException
    //   220	229	753	java/lang/IllegalArgumentException
    //   235	241	753	java/lang/IllegalArgumentException
    //   247	253	753	java/lang/IllegalArgumentException
    //   259	276	753	java/lang/IllegalArgumentException
    //   315	321	753	java/lang/IllegalArgumentException
    //   108	161	761	java/lang/OutOfMemoryError
  }
  
  public Drawable a(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.ebX = paramInt1;
    StringBuilder localStringBuilder = wja.b();
    Object localObject;
    if (this.ebX == 2)
    {
      localObject = "dynamic_pendant";
      this.cvV = ((String)localObject + "_" + this.atD + "_" + this.ebX);
      localObject = (Drawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(paramLong));
      if ((TextUtils.isEmpty(paramString)) || (paramInt2 <= 0)) {
        break label205;
      }
      if ((localObject != null) && ((localObject instanceof abgk))) {
        break label256;
      }
      localObject = paramString + "_" + paramInt2;
      paramString = new abgk(BaseApplicationImpl.getApplication().getResources());
      paramString.Bv((String)localObject);
      paramString.a(this);
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.put(Long.valueOf(paramLong), paramString);
    }
    label256:
    for (;;)
    {
      ThreadManager.post(new PendantInfo.2(this, paramInt1, paramLong, paramString), 8, null, true);
      return paramString;
      localObject = "static_pendant";
      break;
      label205:
      if ((localObject == null) || ((localObject instanceof abgk)))
      {
        paramString = new wnu(BaseApplicationImpl.getApplication().getResources());
        paramString.a(this);
        this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.put(Long.valueOf(paramLong), paramString);
      }
      else
      {
        paramString = (String)localObject;
      }
    }
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean, long paramLong)
  {
    if (paramDrawable == null) {}
    for (;;)
    {
      return;
      try
      {
        eeZ();
        this.mRepeatCount = 0;
        if ((paramDrawable instanceof wnu)) {
          ((wnu)paramDrawable).xy(this.cvU);
        }
        paramDrawable = this.b.obtainMessage(16);
        if (paramBoolean) {
          paramLong = ebQ;
        }
        if (!a(paramDrawable, paramLong)) {
          continue;
        }
        this.b.sendMessage(paramDrawable);
      }
      finally {}
    }
  }
  
  public void a(View paramView, int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    if (anlm.ayn()) {
      if (QLog.isColorLevel()) {
        QLog.i("PendantInfo", 2, "setDrawable, SimpleUIMode is open now");
      }
    }
    do
    {
      return;
      this.cvU = aqgm.m(this.atD, paramInt1);
      paramString = a(paramInt1, paramLong, paramString, paramInt2);
      if ((paramView instanceof BaseChatItemLayout))
      {
        ((BaseChatItemLayout)paramView).setPendantImage(paramString);
        return;
      }
    } while (!(paramView instanceof ImageView));
    ((ImageView)paramView).setImageDrawable(paramString);
  }
  
  public void a(wnu paramwnu, long paramLong)
  {
    if ((paramwnu == null) || (this.cA == null)) {}
    label151:
    label172:
    for (;;)
    {
      return;
      paramwnu.c(this.cA, this.ebY);
      this.bN = this.cA;
      this.mFrameCount = this.cA.length;
      boolean bool;
      if ((!this.cVH) && (this.mRepeatCount > 3))
      {
        bool = true;
        if (paramLong != ebS) {
          break label151;
        }
        this.cVH = false;
        this.mRepeatCount = ebV;
        mc(ebS);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label172;
        }
        QLog.d("PendantInfo", 2, "setPngsDrawable repeatCount:" + this.mRepeatCount + ",targetID:" + paramLong + ",pendantInMarket:" + bool);
        return;
        bool = false;
        break;
        if (!bool)
        {
          this.mRepeatCount = ebW;
          mc(ebQ);
        }
      }
    }
  }
  
  boolean aFw()
  {
    Pair localPair = (Pair)BaseApplicationImpl.sImageCache.get(this.cvV);
    return (localPair != null) && (localPair.first != null);
  }
  
  public Bitmap aQ()
  {
    if (this.cvV == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PendantInfo", 4, "getPendantBitmap cache key equal null");
      }
      StringBuilder localStringBuilder = wja.b();
      if (this.ebX == 2)
      {
        localObject = "dynamic_pendant";
        this.cvV = ((String)localObject + "_" + this.atD + "_" + this.ebX);
      }
    }
    else
    {
      if (BaseApplicationImpl.sImageCache == null) {
        break label137;
      }
    }
    label137:
    for (Object localObject = (Pair)BaseApplicationImpl.sImageCache.get(this.cvV);; localObject = null)
    {
      if ((localObject == null) || (((Pair)localObject).first == null)) {
        break label142;
      }
      return ((BitmapDrawable)((Drawable.ConstantState)((Pair)localObject).first).newDrawable(BaseApplicationImpl.getApplication().getResources())).getBitmap();
      localObject = "static_pendant";
      break;
    }
    label142:
    return null;
  }
  
  void aZ(long paramLong, int paramInt)
  {
    if (paramInt == 2) {}
    synchronized (this.IX)
    {
      if (this.IX.contains(Long.valueOf(this.atD)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PendantInfo", 2, "downloadPendantDrawable pendant " + this.atD + " is downloading");
        }
        return;
      }
      this.IX.add(Long.valueOf(this.atD));
      if (QLog.isColorLevel()) {
        QLog.d("PendantInfo", 2, "downloadPendantDrawable pendant " + this.atD + " add to list");
      }
      ??? = getQQAppInterface();
      if (??? != null)
      {
        ((VasQuickUpdateManager)((QQAppInterface)???).getManager(184)).downloadItem(4L, aqgm.l(this.atD, paramInt), "PendantInfo");
        this.ol.put(aqgm.l(this.atD, paramInt), Long.valueOf(paramLong));
        return;
      }
    }
  }
  
  public void aj(Bitmap paramBitmap)
  {
    int i = aqft.getBitmapSize(paramBitmap);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramBitmap);
    localBitmapDrawable.setTargetDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics());
    StringBuilder localStringBuilder;
    if (this.cvV == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PendantInfo", 4, "setPendantBitmap cache key equal null");
      }
      localStringBuilder = wja.b();
      if (this.ebX != 2) {
        break label138;
      }
    }
    label138:
    for (paramBitmap = "dynamic_pendant";; paramBitmap = "static_pendant")
    {
      this.cvV = (paramBitmap + "_" + this.atD + "_" + this.ebX);
      BaseApplicationImpl.sImageCache.put(this.cvV, new Pair(localBitmapDrawable.getConstantState(), Integer.valueOf(i)));
      return;
    }
  }
  
  void aw(int paramInt, long paramLong)
  {
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      File localFile = new File(aqgm.m(this.atD, 4));
      if (!localFile.exists())
      {
        ((VasQuickUpdateManager)localQQAppInterface.getManager(184)).downloadItem(4L, aqgm.l(this.atD, 4), "PendantInfo");
        this.ol.put(aqgm.l(this.atD, 4), Long.valueOf(paramInt));
        return;
      }
      paramInt = a(localFile, paramInt);
    } while (paramInt <= -1);
    aZ(paramLong, paramInt);
  }
  
  void ba(long paramLong, int paramInt)
  {
    long l = ebQ;
    if (this.ol.containsKey(aqgm.l(this.atD, paramInt))) {
      l = ((Long)this.ol.get(aqgm.l(this.atD, paramInt))).longValue();
    }
    File localFile;
    if ((2 == paramInt) && (this.mType == 1))
    {
      ??? = new File(aqgm.m(paramLong, paramInt));
      if (((File)???).exists())
      {
        localFile = new File(aqgm.m(paramLong, 8));
        if (!aqva.a((File)???, localFile, true)) {
          break label228;
        }
        eeX();
        ??? = this.b.obtainMessage(20);
        if (a((Message)???, l)) {
          this.b.sendMessage((Message)???);
        }
      }
    }
    label228:
    do
    {
      synchronized (this.IX)
      {
        if (this.IX.contains(Long.valueOf(paramLong)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PendantInfo", 2, "onDoneDownloadImage remove " + paramLong + " from list");
          }
          this.IX.remove(Long.valueOf(paramLong));
        }
        while (!QLog.isColorLevel())
        {
          return;
          if (((File)???).exists()) {
            ((File)???).delete();
          }
          if (!localFile.exists()) {
            break;
          }
          localFile.delete();
          break;
        }
        QLog.d("PendantInfo", 2, "onDoneDownloadImage remove " + paramLong + " fail, list not contain");
      }
      ??? = this.b.obtainMessage(19);
    } while (!a((Message)???, ebQ));
    this.b.sendMessage((Message)???);
  }
  
  public int ce(int paramInt)
  {
    if (paramInt == this.mFrameCount - 1)
    {
      this.mRepeatCount -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  public void clearCache()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.clear();
    recyle();
  }
  
  public void d(View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt, paramLong, "", 0);
  }
  
  /* Error */
  void eeX()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 134	com/tencent/mobileqq/vas/PendantInfo:cA	[Ljava/lang/String;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 126	com/tencent/mobileqq/vas/PendantInfo:atD	J
    //   18: bipush 8
    //   20: invokestatic 342	aqgm:m	(JI)Ljava/lang/String;
    //   23: astore_3
    //   24: aload_3
    //   25: invokestatic 728	aqhq:fileExists	(Ljava/lang/String;)Z
    //   28: ifeq -17 -> 11
    //   31: aload_3
    //   32: invokestatic 732	aqhq:ag	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   35: astore 4
    //   37: aload 4
    //   39: invokevirtual 737	java/util/ArrayList:size	()I
    //   42: ifle -31 -> 11
    //   45: aload_0
    //   46: aload 4
    //   48: invokevirtual 737	java/util/ArrayList:size	()I
    //   51: anewarray 220	java/lang/String
    //   54: putfield 134	com/tencent/mobileqq/vas/PendantInfo:cA	[Ljava/lang/String;
    //   57: new 295	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   64: astore 4
    //   66: aload 4
    //   68: aload_3
    //   69: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: getstatic 740	java/io/File:separator	Ljava/lang/String;
    //   75: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 4
    //   81: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_3
    //   85: iconst_0
    //   86: istore_1
    //   87: aload_0
    //   88: getfield 134	com/tencent/mobileqq/vas/PendantInfo:cA	[Ljava/lang/String;
    //   91: arraylength
    //   92: istore_2
    //   93: iload_1
    //   94: iload_2
    //   95: if_icmpge -84 -> 11
    //   98: aload_0
    //   99: getfield 134	com/tencent/mobileqq/vas/PendantInfo:cA	[Ljava/lang/String;
    //   102: iload_1
    //   103: invokestatic 349	wja:b	()Ljava/lang/StringBuilder;
    //   106: aload_3
    //   107: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload_1
    //   111: iconst_1
    //   112: iadd
    //   113: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: ldc_w 742
    //   119: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aastore
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_1
    //   130: goto -37 -> 93
    //   133: astore_3
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_3
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	PendantInfo
    //   86	44	1	i	int
    //   92	4	2	j	int
    //   6	101	3	localObject1	Object
    //   133	4	3	localObject2	Object
    //   35	45	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	133	finally
    //   14	85	133	finally
    //   87	93	133	finally
    //   98	126	133	finally
  }
  
  public void eeY()
  {
    this.cVH = true;
  }
  
  public void eeZ()
  {
    try
    {
      if (((this.bN instanceof b)) && (aFw()))
      {
        if ((this.bN != null) && (((b)this.bN).src != null) && (((b)this.bN).src.equals(this.cvU))) {
          return;
        }
        if (this.mIsPause) {}
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$a != null)
      {
        Message localMessage = this.b.obtainMessage(16);
        if (!a(localMessage, ebQ)) {
          return;
        }
        this.b.sendMessage(localMessage);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("PendantInfo", 1, "decodeBigImage, e=" + MsfSdkUtils.getStackTraceString(localException));
      return;
    }
    this.bN = new b(this.cvU);
    this.mRepeatCount = 0;
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$a = new a(this.bN, ebQ);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.ebY;
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$a.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.mCurFrameIndex), Long.valueOf(this.ebX) });
  }
  
  public Bitmap getCurrentBitmap()
  {
    return aQ();
  }
  
  void l(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("PendantInfo", 2, "download pendant report actionResult=" + paramInt1 + ",pendantId=" + this.atD + ",type=" + paramInt2);
      }
      int i = aqiw.getSystemNetwork(this.mContext);
      if (paramLong < 3600000L) {
        VasWebviewUtil.reportVasStatus("AvatarPendant", "download", String.valueOf(this.atD), 0, 0, paramInt1, i, String.valueOf(paramLong), String.valueOf(paramInt2));
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void mb(long paramLong)
  {
    File localFile = new File(aqgm.m(this.atD, 4));
    int i = 1;
    if (this.ol.containsKey(aqgm.l(this.atD, 4))) {
      i = ((Long)this.ol.get(aqgm.l(this.atD, 4))).intValue();
    }
    i = a(localFile, i);
    if (i > -1) {
      aZ(paramLong, i);
    }
  }
  
  public void mc(long paramLong)
  {
    long l1;
    long l2;
    if ((this.mDecodeNextFrameEnd) && (!this.mIsPause))
    {
      this.mDecodeNextFrameEnd = false;
      l1 = SystemClock.uptimeMillis();
      l2 = this.ebY;
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$a = new a(this.cA, paramLong);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$a.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.mCurFrameIndex), Long.valueOf(this.ebX) });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PendantInfo", 1, "decodeBigImage, e=" + MsfSdkUtils.getStackTraceString(localException));
    }
  }
  
  public void recyle()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$a.cancel(false);
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$a = null;
    }
    this.mDecodeNextFrameEnd = true;
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.mIsPause = paramBoolean;
    try
    {
      Message localMessage = this.b.obtainMessage(18);
      if (a(localMessage, ebQ)) {
        this.b.sendMessageDelayed(localMessage, ebK);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PendantInfo", 2, "bundle exception" + localException.getMessage());
    }
  }
  
  public class AnimationLruCache
    extends AvatarPendantManager.LruLinkedHashMap<Long, Drawable>
  {
    static final long serialVersionUID = 1L;
    
    public AnimationLruCache(int paramInt)
    {
      super();
    }
    
    public void clear()
    {
      Iterator localIterator = values().iterator();
      while (localIterator.hasNext())
      {
        Drawable localDrawable = (Drawable)localIterator.next();
        localDrawable.setCallback(null);
        if ((localDrawable instanceof wnu)) {
          ((wnu)localDrawable).recycle();
        }
      }
      super.clear();
    }
    
    protected boolean removeEldestEntry(Map.Entry<Long, Drawable> paramEntry)
    {
      if (size() > this.maxCapacity)
      {
        paramEntry = (Drawable)paramEntry.getValue();
        paramEntry.setCallback(null);
        if ((paramEntry instanceof wnu)) {
          ((wnu)paramEntry).recycle();
        }
        return true;
      }
      return false;
    }
  }
  
  public class a
    extends AsyncTask<Long, Void, Void>
  {
    long atF;
    Object source;
    
    public a(Object paramObject, long paramLong)
    {
      this.source = paramObject;
      this.atF = paramLong;
    }
    
    protected Void a(Long... paramVarArgs)
    {
      try
      {
        long l1 = paramVarArgs[0].longValue();
        long l2 = paramVarArgs[1].longValue();
        long l3 = paramVarArgs[2].longValue();
        paramVarArgs = PendantInfo.this.a((int)l3, this.source, (int)l2);
        if ((paramVarArgs != null) && (!isCancelled()))
        {
          l2 = SystemClock.uptimeMillis();
          Message localMessage = PendantInfo.this.b.obtainMessage(17);
          if (PendantInfo.a(localMessage, this.atF))
          {
            localMessage.obj = paramVarArgs;
            if (l2 < l1) {
              PendantInfo.this.b.sendMessageDelayed(localMessage, l1 - l2);
            } else {
              PendantInfo.this.b.sendMessage(localMessage);
            }
          }
        }
      }
      catch (Throwable paramVarArgs)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("PendantInfo", 4, "", paramVarArgs);
        }
        PendantInfo.this.mDecodeNextFrameEnd = true;
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      PendantInfo.this.a = null;
    }
  }
  
  class b
  {
    String src;
    
    public b(String paramString)
    {
      this.src = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo
 * JD-Core Version:    0.7.0.1
 */