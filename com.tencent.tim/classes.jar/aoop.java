import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class aoop
{
  public static int AIO_IMAGE_MAX_SIZE;
  public static int AIO_IMAGE_MIN_SIZE;
  public static final Drawable TRANSLUCENT;
  public static final Drawable TRANSPARENT;
  public static File aW;
  private static boolean cNL;
  private static boolean cNM;
  public static int dQS;
  private static int dQT;
  private static int dQU;
  private static int dQV;
  private static int dQW;
  private static int dQX;
  private static int dQY;
  private static int dQZ;
  private static int dRa;
  private static int dRb;
  public static Bitmap.Config f;
  public static Bitmap.Config mConfig = Bitmap.Config.ARGB_8888;
  private static int mTargetDensity;
  
  static
  {
    f = Bitmap.Config.RGB_565;
    dQS = 921600;
    dQT = 45;
    dQU = 135;
    dQV = 45;
    dQW = 135;
    dQX = dQT;
    dQY = dQU;
    dQZ = dQV;
    dRa = dQW;
    AIO_IMAGE_MIN_SIZE = 45;
    AIO_IMAGE_MAX_SIZE = 135;
    dRb = -1;
    TRANSPARENT = new ColorDrawable(0);
    TRANSLUCENT = new ColorDrawable(1073741824);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    AIO_IMAGE_MIN_SIZE = (int)aqho.convertDpToPixel(localBaseApplication, 45.0F);
    AIO_IMAGE_MAX_SIZE = (int)aqho.convertDpToPixel(localBaseApplication, 135.0F);
    mTargetDensity = localBaseApplication.getResources().getDisplayMetrics().densityDpi;
  }
  
  public static Drawable D(int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get(String.valueOf(paramInt));
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = aqcu.decodeResource(BaseApplicationImpl.getContext().getResources(), paramInt);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put(String.valueOf(paramInt), localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static int G(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return dRa;
    }
    return dQY;
  }
  
  public static int H(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return dQZ;
    }
    return dQX;
  }
  
  public static int I(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return dQW;
    }
    return dQU;
  }
  
  public static int J(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return dQV;
    }
    return dQT;
  }
  
  public static int KS()
  {
    dWu();
    return dRb;
  }
  
  public static URLDrawable a(akxw paramakxw, int paramInt)
  {
    return a(paramakxw, paramInt, null, null);
  }
  
  public static URLDrawable a(akxw paramakxw, int paramInt, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    boolean bool2 = true;
    if (paramakxw == null) {
      return null;
    }
    paramString = URLDrawable.getDrawable(a(paramakxw, paramInt, paramString), paramURLDrawableOptions);
    paramString.setTag(paramakxw);
    if (paramakxw.isSendFromLocal()) {}
    for (;;)
    {
      return paramString;
      if (!akxk.cuU) {
        break;
      }
      paramString.setAutoDownload(true);
    }
    boolean bool3 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131697129), "qqsetting_auto_receive_pic_key", true);
    boolean bool1 = bool2;
    if (aqiw.getNetworkType(BaseApplication.getContext()) != 1) {
      if (!bool3) {
        break label102;
      }
    }
    label102:
    for (bool1 = bool2;; bool1 = false)
    {
      paramString.setAutoDownload(bool1);
      break;
    }
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
    throws IllegalArgumentException
  {
    try
    {
      paramDrawable1 = getDrawable(new URL(paramString), paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, paramFloat);
      return paramDrawable1;
    }
    catch (MalformedURLException paramDrawable1)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  private static String a(akxh paramakxh)
  {
    if (paramakxh == null) {
      return null;
    }
    switch (paramakxh.uinType)
    {
    default: 
      return null;
    case 0: 
    case 1000: 
    case 1001: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1020: 
    case 1023: 
    case 1024: 
    case 10002: 
    case 10004: 
    case 10008: 
      return "C2C";
    case 1: 
      return "Troup";
    }
    return "Disscussion";
  }
  
  private static String a(akxh paramakxh, int paramInt)
  {
    int i;
    String str;
    if (paramInt == 65537)
    {
      i = 1;
      str = null;
      if (paramInt != 65537) {
        break label67;
      }
      str = "chatthumb";
      label22:
      switch (paramakxh.uinType)
      {
      }
    }
    label67:
    do
    {
      return str;
      i = 0;
      break;
      if (paramInt == 1)
      {
        str = "chatimg";
        break label22;
      }
      if (paramInt != 131075) {
        break label22;
      }
      str = "chatraw";
      break label22;
      return "favimage";
    } while (paramakxh.subVersion >= 3);
    if (i != 0) {
      return "lbsthumb";
    }
    return "lbsimg";
  }
  
  public static URL a(akxl paramakxl, int paramInt, String paramString)
  {
    if (paramakxl == null) {
      return null;
    }
    String str1 = paramakxl.md5;
    label48:
    String str2;
    if ((str1 != null) && (!"null".equals(str1)) && (!"".equals(str1)))
    {
      if (paramakxl.isMixed) {
        paramInt = 1;
      }
      if (paramString == null) {
        break label185;
      }
      str2 = str1;
      if (str1 != null) {}
    }
    for (;;)
    {
      try
      {
        str1 = "holyshit_" + System.currentTimeMillis();
        str2 = str1;
        if (QLog.isColorLevel())
        {
          QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramakxl.toString());
          str2 = str1;
        }
        if (paramString == null) {
          break label201;
        }
        paramakxl = new URL(paramString, null, str2);
        return paramakxl;
      }
      catch (MalformedURLException paramakxl)
      {
        label185:
        paramakxl.printStackTrace();
        return null;
      }
      if ((paramakxl.uinType == 8000) && (paramInt == 65537))
      {
        if (anof.ayA())
        {
          str1 = paramakxl.bUH;
          break;
        }
        str1 = paramakxl.thumbMsgUrl;
        break;
      }
      str1 = paramakxl.uuid;
      break;
      paramString = a(paramakxl, paramInt);
      break label48;
      label201:
      paramakxl = null;
    }
  }
  
  public static URL a(akxw paramakxw, int paramInt)
  {
    return a(paramakxw, paramInt, null);
  }
  
  public static URL a(akxw paramakxw, int paramInt, String paramString)
  {
    if (paramakxw == null) {
      return null;
    }
    if (paramakxw.isSendFromLocal()) {
      return a(paramakxw.getPicUploadInfo(), paramInt, paramString);
    }
    return a(paramakxw.getPicDownloadInfo(), paramInt, paramString);
  }
  
  public static URL a(akxy paramakxy, int paramInt, String paramString)
  {
    if (paramakxy == null) {
      return null;
    }
    if (paramakxy.subVersion < 4) {}
    for (String str2 = a(paramakxy);; str2 = null)
    {
      String str3 = a(paramakxy, paramInt);
      if ((paramakxy.uinType == 8000) && (paramInt == 65537)) {}
      for (String str1 = paramakxy.thumbPath;; str1 = "") {
        for (;;)
        {
          if (str1 != null) {}
          try
          {
            if (("".equals(str1)) && (QLog.isColorLevel())) {
              QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramakxy.toString());
            }
            if (paramString != null)
            {
              paramakxy = new URL(paramString, str2, str1);
              return paramakxy;
              if ((paramakxy.md5 != null) && (!"".equals(paramakxy.md5)))
              {
                str1 = paramakxy.md5;
                continue;
              }
              if ((paramakxy.localUUID != null) && (!"".equals(paramakxy.localUUID)))
              {
                str1 = paramakxy.localUUID;
                continue;
              }
              if ((paramakxy.localPath != null) && (!"".equals(paramakxy.localPath))) {
                str1 = paramakxy.localPath;
              }
            }
            else
            {
              if (str3 == null) {
                break;
              }
              paramakxy = new URL(str3, str2, str1);
              return paramakxy;
            }
          }
          catch (MalformedURLException paramakxy)
          {
            paramakxy.printStackTrace();
            return null;
          }
        }
      }
    }
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString, boolean paramBoolean)
  {
    String str = paramURLDrawable.getURL().toString();
    if ((paramURLDrawable.getStatus() != 1) && (aoiz.hasFile(str))) {}
    try
    {
      paramURLDrawable.downloadImediatly();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("URLDrawableHelper", 2, "downloadImediatly decode OOM,currentAccountUin=" + paramString + ",d.getURL=" + paramURLDrawable.getURL());
    }
  }
  
  public static boolean a(Context paramContext, akxw paramakxw, int paramInt)
  {
    return aoiz.getFile(a(paramakxw, paramInt).toString()) != null;
  }
  
  public static Drawable aS()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://CommonFailedDrawable_sticker");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = aqcu.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845413);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.sImageCache.put("static://CommonFailedDrawable_sticker", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static Bitmap aj()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonProgress");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = aqcu.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130839650);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://CommonProgress", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Drawable am()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonLoadingDrawable");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = aqcu.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130838156);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://CommonLoadingDrawable", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static URLDrawable b(akxw paramakxw, int paramInt)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(a(paramakxw, 65537));
    localURLDrawable.setTargetDensity(mTargetDensity);
    int i;
    URL localURL;
    if (localURLDrawable.getStatus() == 1)
    {
      i = 1;
      localURL = a(paramakxw, paramInt);
      if (i == 0) {
        break label69;
      }
    }
    label69:
    for (localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, localURLDrawable, null, true);; localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, true))
    {
      localURLDrawable.setTargetDensity(mTargetDensity);
      localURLDrawable.setTag(paramakxw);
      return localURLDrawable;
      i = 0;
      break;
    }
  }
  
  public static URL b(String paramString, int paramInt)
  {
    String str = "chatimg";
    if (paramInt == 65537) {
      str = "chatthumb";
    }
    for (;;)
    {
      try
      {
        paramString = new URL(str, null, paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
      }
      if (paramInt == 1) {
        str = "chatimg";
      } else if (paramInt == 131075) {
        str = "chatraw";
      }
    }
    return null;
  }
  
  public static boolean bD(Context paramContext)
  {
    boolean bool1 = AppNetConnInfo.isMobileConn();
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131697129), "qqsetting_auto_receive_pic_key", true);
    return (bool1) && (!bool2);
  }
  
  public static boolean bE(Context paramContext)
  {
    return SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131697129), "qqsetting_auto_receive_pic_key", true);
  }
  
  public static void cdE()
  {
    for (;;)
    {
      try
      {
        boolean bool = cNL;
        if (bool) {
          return;
        }
        String[] arrayOfString = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_pic_thumb_size.name(), "135|135").split("\\|");
        if (arrayOfString.length == 2)
        {
          i = Integer.valueOf(arrayOfString[0]).intValue();
          if ((i >= 45) && (i <= 198)) {
            dQU = i;
          }
          i = Integer.valueOf(arrayOfString[1]).intValue();
          if ((i >= 45) && (i <= 198)) {
            dQW = i;
          }
        }
        float f1 = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density;
        dQY = (int)(dQU * f1);
        dRa = (int)(dQW * f1);
        dQX = (int)(dQT * f1);
        dQZ = (int)(f1 * dQV);
        if (dQY == 0)
        {
          i = dQU;
          dQY = i;
          if (dRa != 0) {
            break label267;
          }
          i = dQW;
          dRa = i;
          if (dQX != 0) {
            break label274;
          }
          i = dQT;
          dQX = i;
          if (dQZ != 0) {
            break label281;
          }
          i = dQV;
          dQZ = i;
          cNL = true;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("URLDrawableHelper", 2, dQY + "|" + dRa);
          continue;
        }
        i = dQY;
      }
      finally {}
      continue;
      label267:
      int i = dRa;
      continue;
      label274:
      i = dQX;
      continue;
      label281:
      i = dQZ;
    }
  }
  
  /* Error */
  public static void dWu()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 512	aoop:cNM	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 462	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   18: getstatic 515	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:aio_config	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   21: invokevirtual 471	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   24: ldc_w 517
    //   27: invokevirtual 477	com/tencent/mobileqq/app/DeviceProfileManager:aJ	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: ldc_w 479
    //   33: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: arraylength
    //   39: istore_0
    //   40: iload_0
    //   41: ifle +15 -> 56
    //   44: aload_2
    //   45: iconst_0
    //   46: aaload
    //   47: invokestatic 488	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   50: invokevirtual 491	java/lang/Integer:intValue	()I
    //   53: putstatic 71	aoop:dRb	I
    //   56: iconst_1
    //   57: putstatic 512	aoop:cNM	Z
    //   60: invokestatic 311	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq -52 -> 11
    //   66: ldc_w 313
    //   69: iconst_2
    //   70: new 234	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 519
    //   80: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: getstatic 71	aoop:dRb	I
    //   86: invokevirtual 503	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 508	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto -84 -> 11
    //   98: astore_2
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_2
    //   103: athrow
    //   104: astore_2
    //   105: invokestatic 311	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +13 -> 121
    //   111: ldc_w 313
    //   114: iconst_2
    //   115: ldc_w 521
    //   118: invokestatic 508	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: iconst_m1
    //   122: putstatic 71	aoop:dRb	I
    //   125: goto -69 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	2	0	i	int
    //   6	2	1	bool	boolean
    //   36	9	2	arrayOfString	String[]
    //   98	5	2	localObject	Object
    //   104	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	7	98	finally
    //   15	40	98	finally
    //   44	56	98	finally
    //   56	95	98	finally
    //   105	121	98	finally
    //   121	125	98	finally
    //   44	56	104	java/lang/Exception
  }
  
  public static int eI(String paramString)
  {
    return aqhu.getExifOrientation(paramString);
  }
  
  public static URLDrawable getDrawable(String paramString)
    throws IllegalArgumentException
  {
    return a(paramString, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    return a(paramString, paramInt1, paramInt2, null, null, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
    throws IllegalArgumentException
  {
    return a(paramString, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
    throws IllegalArgumentException
  {
    return a(paramString, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL)
  {
    return getDrawable(paramURL, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, null, null, false, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable2;
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    localURLDrawableOptions.mGifRoundCorner = paramFloat;
    return URLDrawable.getDrawable(paramURL, localURLDrawableOptions);
  }
  
  public static URLDrawable getDrawable(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramURL, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static Drawable getFailedDrawable()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonFailedDrawable");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = aqcu.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130838159);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://CommonFailedDrawable", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static boolean isMobileNet()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static int n(String paramString, boolean paramBoolean)
  {
    int i = 65537;
    if ("chatthumb".equals(paramString)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatImageDownloader", 2, "getFileSizeType protocol:" + paramString + ",output_type:" + i);
      }
      return i;
      if ("chatimg".equals(paramString))
      {
        if (paramBoolean) {
          i = 1;
        } else {
          i = 131075;
        }
      }
      else if ("chatraw".equals(paramString)) {
        i = 131075;
      }
    }
  }
  
  public static class a
    implements URLDrawable.URLDrawableListener
  {
    public void onLoadCanceled(URLDrawable paramURLDrawable) {}
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
    
    public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoop
 * JD-Core Version:    0.7.0.1
 */