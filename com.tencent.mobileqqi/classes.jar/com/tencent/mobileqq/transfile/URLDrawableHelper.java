package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicBaseInfo;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class URLDrawableHelper
{
  public static final float a = 12.0F;
  public static int a = 0;
  public static Bitmap.Config a;
  public static Bitmap a;
  public static Drawable a;
  public static File a;
  public static final String a = "URLDrawableHelper";
  static List a;
  public static int b = 0;
  public static Drawable b;
  public static final int c = 99;
  public static Drawable c;
  public static final int d = 99;
  public static final Drawable d;
  public static final int e = -921103;
  public static int f;
  public static int g;
  private static int h;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    jdField_b_of_type_Int = 921600;
    d = new ColorDrawable(0);
    Context localContext = BaseApplicationImpl.getContext();
    try
    {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = localContext.getResources().getDrawable(2130837648);
      jdField_b_of_type_AndroidGraphicsDrawableDrawable = localContext.getResources().getDrawable(2130837650);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130837853);
          h = localContext.getResources().getDisplayMetrics().densityDpi;
          f = 40;
          g = 100;
          jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
          return;
          localThrowable1 = localThrowable1;
          if (QLog.isColorLevel()) {
            QLog.e("URLDrawableHelper", 2, "", localThrowable1);
          }
          if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
          }
          if (jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
            jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("URLDrawableHelper", 2, "", localThrowable2);
          }
          jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(4, 4, jdField_a_of_type_AndroidGraphicsBitmap$Config);
        }
      }
    }
  }
  
  public static int a(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      if (paramString == null) {
        return 0;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("URLDrawableHelper", 2, "new ExifInterface", paramString);
        }
        paramString = null;
      }
      switch (paramString.getAttributeInt("Orientation", 0))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      }
    }
    return 180;
    return 90;
    return 270;
  }
  
  public static int a(String paramString, boolean paramBoolean)
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
  
  public static URLDrawable a(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return a(paramPicUiInterface, paramInt, null);
  }
  
  public static URLDrawable a(PicUiInterface paramPicUiInterface, int paramInt, String paramString)
  {
    boolean bool2 = true;
    if (paramPicUiInterface == null) {
      return null;
    }
    paramString = URLDrawable.getDrawable(a(paramPicUiInterface, paramInt, paramString));
    paramString.setTag(paramPicUiInterface);
    if (paramPicUiInterface.isSendFromLocal()) {}
    for (;;)
    {
      return paramString;
      if (!PicContants.jdField_b_of_type_Boolean) {
        break;
      }
      paramString.setAutoDownload(true);
    }
    boolean bool3 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131563423), "qqsetting_auto_receive_pic_key", true);
    boolean bool1 = bool2;
    if (NetworkUtil.b(BaseApplication.getContext()) != 1) {
      if (!bool3) {
        break label98;
      }
    }
    label98:
    for (bool1 = bool2;; bool1 = false)
    {
      paramString.setAutoDownload(bool1);
      break;
    }
  }
  
  public static String a(Context paramContext, URL paramURL)
  {
    String str2 = paramURL.getProtocol();
    String str3 = paramURL.getHost();
    String str1 = "chatthumb";
    if (str2.equals("chatimg")) {
      str1 = "chatthumb";
    }
    for (;;)
    {
      String str4 = paramURL.getFile();
      Object localObject = paramURL;
      if (str4 != null) {
        if (!str4.startsWith("/file/"))
        {
          localObject = paramURL;
          if (!str4.startsWith("file/")) {}
        }
        else
        {
          localObject = paramURL;
          if (!str4.contains("thumb/"))
          {
            localObject = str4.substring(str4.indexOf("file/") + 5);
            paramContext = "file/" + ImageUtil.a(paramContext, (String)localObject);
            if (QLog.isColorLevel()) {
              QLog.w("URLDrawableHelper", 2, "forward ,bigProtocol=" + str2 + ",host=" + str3 + ",file=" + paramContext);
            }
          }
        }
      }
      try
      {
        localObject = new URL(str2, str3, paramContext);
        return ((URL)localObject).toString().replaceFirst(str2, str1);
        if (str2.equals("lbsimg"))
        {
          str1 = "lbsthumb";
          continue;
        }
        if (!str2.equals("billdimg")) {
          continue;
        }
        str1 = "billdthumb";
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          URL localURL = paramURL;
          if (QLog.isColorLevel())
          {
            QLog.w("URLDrawableHelper", 2, "forward MalformedURLException ,bigProtocol=" + str2 + ",host=" + str3 + ",file=" + paramContext);
            localURL = paramURL;
          }
        }
      }
    }
  }
  
  private static String a(PicBaseInfo paramPicBaseInfo)
  {
    if (paramPicBaseInfo == null) {
      return null;
    }
    switch (paramPicBaseInfo.jdField_b_of_type_Int)
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
      return "C2C";
    case 1: 
      return "Troup";
    }
    return "Disscussion";
  }
  
  private static String a(PicBaseInfo paramPicBaseInfo, int paramInt)
  {
    int i;
    String str;
    if (paramInt == 65537)
    {
      i = 1;
      str = null;
      if (paramInt != 65537) {
        break label55;
      }
      str = "chatthumb";
      label19:
      switch (paramPicBaseInfo.jdField_b_of_type_Int)
      {
      }
    }
    label55:
    do
    {
      return str;
      i = 0;
      break;
      if (paramInt == 1)
      {
        str = "chatimg";
        break label19;
      }
      if (paramInt != 131075) {
        break label19;
      }
      str = "chatraw";
      break label19;
      return "favimage";
    } while (paramPicBaseInfo.e >= 3);
    if (i != 0) {
      return "lbsthumb";
    }
    return "lbsimg";
  }
  
  public static URL a(PicDownloadInfo paramPicDownloadInfo, int paramInt, String paramString)
  {
    if (paramPicDownloadInfo == null) {
      return null;
    }
    String str1 = paramPicDownloadInfo.f;
    if ((str1 != null) && (!"null".equals(str1)) && (!"".equals(str1)))
    {
      if (paramPicDownloadInfo.jdField_b_of_type_Boolean) {
        paramInt = 1;
      }
      if (paramString == null) {
        break label164;
      }
    }
    for (;;)
    {
      String str2 = str1;
      if (str1 == null) {}
      try
      {
        str1 = "holyshit_" + System.currentTimeMillis();
        str2 = str1;
        if (QLog.isColorLevel())
        {
          QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramPicDownloadInfo.toString());
          str2 = str1;
        }
        paramPicDownloadInfo = new URL(paramString, null, str2);
      }
      catch (MalformedURLException paramPicDownloadInfo)
      {
        for (;;)
        {
          paramPicDownloadInfo.printStackTrace();
          paramPicDownloadInfo = null;
        }
      }
      return paramPicDownloadInfo;
      if ((paramPicDownloadInfo.jdField_b_of_type_Int == 8000) && (paramInt == 65537))
      {
        str1 = paramPicDownloadInfo.h;
        break;
      }
      str1 = paramPicDownloadInfo.g;
      break;
      label164:
      paramString = a(paramPicDownloadInfo, paramInt);
    }
  }
  
  public static URL a(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return a(paramPicUiInterface, paramInt, null);
  }
  
  public static URL a(PicUiInterface paramPicUiInterface, int paramInt, String paramString)
  {
    if (paramPicUiInterface == null) {
      return null;
    }
    if (paramPicUiInterface.isSendFromLocal()) {
      return a(paramPicUiInterface.getPicUploadInfo(), paramInt, paramString);
    }
    return a(paramPicUiInterface.getPicDownloadInfo(), paramInt, paramString);
  }
  
  public static URL a(PicUploadInfo paramPicUploadInfo, int paramInt, String paramString)
  {
    if (paramPicUploadInfo == null) {
      return null;
    }
    if (paramPicUploadInfo.e < 4) {}
    for (String str2 = a(paramPicUploadInfo);; str2 = null)
    {
      String str3 = a(paramPicUploadInfo, paramInt);
      if ((paramPicUploadInfo.jdField_b_of_type_Int == 8000) && (paramInt == 65537)) {}
      for (String str1 = paramPicUploadInfo.h;; str1 = "") {
        for (;;)
        {
          if (str1 != null) {}
          try
          {
            if (("".equals(str1)) && (QLog.isColorLevel())) {
              QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramPicUploadInfo.toString());
            }
            if (paramString != null)
            {
              paramPicUploadInfo = new URL(paramString, str2, str1);
              return paramPicUploadInfo;
              if ((paramPicUploadInfo.f != null) && (!"".equals(paramPicUploadInfo.f)))
              {
                str1 = paramPicUploadInfo.f;
                continue;
              }
              if ((paramPicUploadInfo.a != null) && (!"".equals(paramPicUploadInfo.a)))
              {
                str1 = paramPicUploadInfo.a;
                continue;
              }
              if ((paramPicUploadInfo.g != null) && (!"".equals(paramPicUploadInfo.g))) {
                str1 = paramPicUploadInfo.g;
              }
            }
            else
            {
              paramPicUploadInfo = new URL(str3, str2, str1);
              return paramPicUploadInfo;
            }
          }
          catch (MalformedURLException paramPicUploadInfo)
          {
            paramPicUploadInfo.printStackTrace();
            return null;
          }
        }
      }
    }
  }
  
  public static URL a(String paramString, int paramInt)
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
  
  public static void a(URLDrawable paramURLDrawable, String paramString, boolean paramBoolean)
  {
    String str = paramURLDrawable.getURL().toString();
    if ((paramURLDrawable.getStatus() != 1) && (AbsDownloader.a(str))) {}
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
  
  /* Error */
  public static void a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc_w 405
    //   5: ldc_w 407
    //   8: new 158	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 409
    //   18: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: getstatic 108	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   24: invokeinterface 414 1 0
    //   29: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 419	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   38: invokestatic 215	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   41: invokestatic 233	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)I
    //   44: iconst_1
    //   45: if_icmpne +123 -> 168
    //   48: invokestatic 215	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   51: invokestatic 422	com/tencent/mobileqq/utils/NetworkUtil:d	(Landroid/content/Context;)Z
    //   54: istore_2
    //   55: iload_1
    //   56: ifne +7 -> 63
    //   59: iload_2
    //   60: ifeq +122 -> 182
    //   63: invokestatic 427	android/os/Looper:prepare	()V
    //   66: new 98	java/util/ArrayList
    //   69: dup
    //   70: getstatic 108	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   73: invokeinterface 414 1 0
    //   78: anewarray 429	com/tencent/mobileqq/data/MessageForPic
    //   81: invokestatic 435	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   84: invokespecial 438	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   87: astore_0
    //   88: aload_0
    //   89: getstatic 108	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   92: invokestatic 442	java/util/Collections:copy	(Ljava/util/List;Ljava/util/List;)V
    //   95: aload_0
    //   96: invokeinterface 446 1 0
    //   101: astore_0
    //   102: aload_0
    //   103: invokeinterface 451 1 0
    //   108: ifeq +65 -> 173
    //   111: aload_0
    //   112: invokeinterface 455 1 0
    //   117: checkcast 429	com/tencent/mobileqq/data/MessageForPic
    //   120: astore_3
    //   121: ldc_w 405
    //   124: ldc_w 457
    //   127: new 158	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 459
    //   137: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_3
    //   141: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 419	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_3
    //   151: iconst_1
    //   152: invokestatic 461	com/tencent/mobileqq/transfile/URLDrawableHelper:a	(Lcom/tencent/mobileqq/pic/PicUiInterface;I)Lcom/tencent/image/URLDrawable;
    //   155: iconst_0
    //   156: invokevirtual 464	com/tencent/image/URLDrawable:startDownload	(Z)V
    //   159: goto -57 -> 102
    //   162: astore_0
    //   163: aload_0
    //   164: invokevirtual 465	java/lang/Exception:printStackTrace	()V
    //   167: return
    //   168: iconst_0
    //   169: istore_1
    //   170: goto -122 -> 48
    //   173: getstatic 108	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   176: invokeinterface 468 1 0
    //   181: return
    //   182: ldc_w 405
    //   185: ldc_w 407
    //   188: ldc_w 470
    //   191: invokestatic 419	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   194: return
    //   195: astore_0
    //   196: goto -130 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   1	169	1	i	int
    //   54	6	2	bool	boolean
    //   120	31	3	localMessageForPic	com.tencent.mobileqq.data.MessageForPic
    // Exception table:
    //   from	to	target	type
    //   2	48	162	java/lang/Exception
    //   48	55	162	java/lang/Exception
    //   66	102	162	java/lang/Exception
    //   102	159	162	java/lang/Exception
    //   173	181	162	java/lang/Exception
    //   182	194	162	java/lang/Exception
    //   63	66	195	java/lang/Exception
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = NetworkUtil.c(BaseApplication.getContext());
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131563423), "qqsetting_auto_receive_pic_key", true);
    return (bool1) && (!bool2);
  }
  
  public static boolean a(Context paramContext, PicUiInterface paramPicUiInterface, int paramInt)
  {
    return AbsDownloader.a(a(paramPicUiInterface, paramInt).toString()) != null;
  }
  
  public static URLDrawable b(PicUiInterface paramPicUiInterface, int paramInt)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(a(paramPicUiInterface, 65537));
    localURLDrawable.setTargetDensity(h);
    int i;
    URL localURL;
    if (localURLDrawable.getStatus() == 1)
    {
      i = 1;
      localURL = a(paramPicUiInterface, paramInt);
      if (i == 0) {
        break label77;
      }
    }
    label77:
    for (localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, localURLDrawable, null, true);; localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, true))
    {
      localURLDrawable.setTargetDensity(h);
      if (!paramPicUiInterface.isSendFromLocal()) {
        break label89;
      }
      localURLDrawable.setTag(paramPicUiInterface);
      return localURLDrawable;
      i = 0;
      break;
    }
    label89:
    localURLDrawable.setTag(paramPicUiInterface);
    return localURLDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.URLDrawableHelper
 * JD-Core Version:    0.7.0.1
 */