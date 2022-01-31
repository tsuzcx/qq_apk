package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hfr;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class AvatarPendantUtil
{
  public static final int a = 1;
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final String jdField_a_of_type_JavaLangString = "AvatarPendantUtil";
  private static Vector jdField_a_of_type_JavaUtilVector = new Vector();
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  private static final int h = 1;
  private static final int i = 0;
  
  public static URLDrawable a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    Object localObject6 = null;
    Object localObject3;
    if (paramQQAppInterface == null) {
      localObject3 = localObject6;
    }
    Object localObject1;
    label59:
    Object localObject2;
    Object localObject5;
    URLDrawable localURLDrawable;
    for (;;)
    {
      return localObject3;
      switch (paramInt)
      {
      case 6: 
      default: 
        localObject1 = null;
        localObject3 = localObject6;
        if (localObject1 != null)
        {
          if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8));
          }
          if ((localObject1 != "url_host_pendant_image_aio_dynamic") && (localObject1 != "url_host_pendant_image_market_static")) {
            break label541;
          }
          localObject3 = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 7: 
        try
        {
          localURL = new URL("protocol_pendant_image", "url_host_pendant_image_aio_static", a(paramLong, 1));
          localObject2 = localObject3;
          if (localURL != null)
          {
            localObject5 = URLDrawable.getDrawable(localURL, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableDrawable, false);
            ((URLDrawable)localObject5).setTag(Long.valueOf(paramLong));
            localObject2 = localObject3;
            if (localObject5 != null)
            {
              localObject2 = localObject3;
              if (((URLDrawable)localObject5).getStatus() == 1)
              {
                localObject2 = localObject3;
                if (((URLDrawable)localObject5).getCurrDrawable() != null) {
                  localObject2 = ((URLDrawable)localObject5).getCurrDrawable();
                }
              }
            }
          }
        }
        catch (MalformedURLException localMalformedURLException1)
        {
          try
          {
            URL localURL;
            localObject5 = new URL("protocol_pendant_image", (String)localObject1, a(paramLong, paramInt));
            if (localURL == null)
            {
              localObject3 = localObject6;
              if (localObject5 == null) {}
            }
            else if ((localURL != null) && (localObject5 == null))
            {
              return URLDrawable.getDrawable(localURL, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableDrawable, false);
              localObject1 = "url_host_pendant_image_aio_static";
              break label59;
              localObject1 = "url_host_pendant_image_aio_dynamic";
              break label59;
              localObject1 = "url_host_pendant_image_market_static";
              break label59;
              localObject1 = "url_host_pendant_image_market_dynamic";
              break label59;
              localObject1 = "pendant_thumbnail";
              break label59;
              localObject1 = "url_host_pendant_image_crop_portrait";
              break label59;
              localMalformedURLException1 = localMalformedURLException1;
              if (QLog.isColorLevel()) {
                QLog.e("AvatarPendantUtil", 2, "Failed to getAioPendantDrawable: " + localMalformedURLException1.getMessage());
              }
              localURLDrawable = null;
            }
          }
          catch (MalformedURLException localMalformedURLException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AvatarPendantUtil", 2, "Failed to get PendantDrawable: " + localMalformedURLException2.getMessage() + ", pendantResourceType=" + paramInt);
              }
              localObject5 = null;
            }
          }
        }
      }
    }
    if (localObject1 == "url_host_pendant_image_aio_dynamic")
    {
      localObject1 = URLDrawable.getDrawable((URL)localObject5, (Drawable)localObject2, (Drawable)localObject2, true);
      if (localObject1 == null) {
        break label654;
      }
      ((URLDrawable)localObject1).setTag(Long.valueOf(paramLong));
      if ((((URLDrawable)localObject1).getStatus() != 1) || (((URLDrawable)localObject1).getCurrDrawable() == null) || (!(((URLDrawable)localObject1).getCurrDrawable() instanceof GifDrawable))) {
        break label654;
      }
      ((GifDrawable)((URLDrawable)localObject1).getCurrDrawable()).getImage().reset();
    }
    label654:
    for (;;)
    {
      Object localObject4 = localObject1;
      if (localObject1 == null) {
        break;
      }
      ((URLDrawable)localObject1).addHeader("my_uin", paramQQAppInterface.a());
      ((URLDrawable)localObject1).startDownload();
      return localObject1;
      if (localObject1 == "url_host_pendant_image_market_static")
      {
        localURLDrawable = URLDrawable.getDrawable((URL)localObject5, (Drawable)localObject2, (Drawable)localObject2, false);
        localObject1 = localURLDrawable;
        if (localURLDrawable == null) {
          continue;
        }
        localURLDrawable.setTag(Long.valueOf(paramLong));
        localObject1 = localURLDrawable;
        continue;
        try
        {
          label541:
          localObject1 = new URL("protocol_pendant_image", (String)localObject1, a(paramLong, paramInt));
          localURLDrawable = URLDrawable.getDrawable((URL)localObject1, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableDrawable, false);
          localObject1 = localURLDrawable;
          if (localURLDrawable == null) {
            continue;
          }
          localURLDrawable.setTag(Long.valueOf(paramLong));
          localObject1 = localURLDrawable;
        }
        catch (MalformedURLException paramQQAppInterface)
        {
          localObject4 = localObject6;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AvatarPendantUtil", 2, "Failed to getPendantDrawable: " + paramQQAppInterface.getMessage() + ", pendantResourceType" + paramInt);
        return null;
      }
      localObject1 = null;
    }
  }
  
  public static File a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    Object localObject1 = new File(a(paramLong, 6));
    label66:
    Object localObject2;
    int j;
    if (!((File)localObject1).exists())
    {
      if ((HttpDownloadUtil.a(paramQQAppInterface, b(paramLong, 6), (File)localObject1)) && (localObject1 != null) && (((File)localObject1).exists())) {
        a(paramQQAppInterface, ((File)localObject1).length());
      }
    }
    else
    {
      localObject2 = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if ((((File)localObject1).exists()) && (localObject2 == null))
      {
        localObject2 = new String(FileUtils.a((File)localObject1));
        if (localObject2 == null) {
          break label465;
        }
        j = ((String)localObject2).indexOf("\"type\":");
        if (j == -1) {
          break label465;
        }
        int k = ((String)localObject2).indexOf(",", j + 6);
        if (k == -1) {
          break label465;
        }
        localObject2 = ((String)localObject2).substring(j + 7, k);
        if (localObject2 == null) {
          break label465;
        }
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt(((String)localObject2).trim());
      }
      catch (Exception localException1)
      {
        boolean bool;
        j = -2147483648;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantUtil", 2, "pendant type=" + j);
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), Integer.valueOf(j));
      }
      catch (Exception localException2)
      {
        continue;
      }
      if (j == -2147483648) {
        ((File)localObject1).delete();
      }
      localObject1 = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if ((localObject1 != null) && (((Integer)localObject1).intValue() == 0) && (paramInt == 2))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AvatarPendantUtil", 2, "static pendant, abort gif request");
        return null;
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label66;
        }
        ((File)localObject1).delete();
        break label66;
      }
      localObject1 = new File(a(paramLong, paramInt));
      if (((File)localObject1).exists()) {
        return localObject1;
      }
      localObject2 = b(paramLong, paramInt);
      bool = HttpDownloadUtil.a(paramQQAppInterface, (String)localObject2, (File)localObject1);
      if ((bool) && (localObject1 != null))
      {
        a(paramQQAppInterface, ((File)localObject1).length());
        if (QLog.isColorLevel()) {
          QLog.i("AvatarPendantUtil", 2, "Download pendant image:" + bool + "; url=" + (String)localObject2);
        }
        if (bool)
        {
          paramQQAppInterface = (QQAppInterface)localObject1;
          return paramQQAppInterface;
        }
      }
      else
      {
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          continue;
        }
        ((File)localObject1).delete();
        continue;
      }
      paramQQAppInterface = null;
      continue;
      label465:
      j = -2147483648;
    }
  }
  
  public static String a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.aH).append(paramLong).append(File.separator);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("aio_static_50.png");
      continue;
      localStringBuilder.append("aio_dynamic_50.gif");
      continue;
      localStringBuilder.append("market_static_50.png");
      continue;
      localStringBuilder.append("market_dynamic_50.gif");
      continue;
      localStringBuilder.append("thumbnail.png");
      continue;
      localStringBuilder.append("config.json");
      continue;
      localStringBuilder.append("crop_portrait.png");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilVector == null) || (jdField_a_of_type_JavaUtilVector.size() == 0)) {
      return;
    }
    ThreadManager.a(new hfr(paramQQAppInterface));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    String[] arrayOfString;
    if (NetworkUtil.a(((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo()))
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGAvatarPendantDownloadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      paramQQAppInterface.a(paramQQAppInterface.a(), arrayOfString, paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "Download data length:" + paramLong);
      }
      return;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAvatarPendantDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int m = 1;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, AvatarPendantMarketActivity.class);
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)paramQQAppInterface.getManager(11);
    int j = localGameCenterManagerImp.a("100005.100006");
    RedTouchManager localRedTouchManager;
    int k;
    if ((j == 1) || (j == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantUtil", 2, "Clear pendant red flag");
      }
      localIntent.putExtra("key_update_flag", true);
      localRedTouchManager = (RedTouchManager)paramQQAppInterface.getManager(34);
      localRedTouchManager.b("100005.100006");
      if (localGameCenterManagerImp.a("100005.100003") == -1) {
        break label255;
      }
      j = 1;
      if (localGameCenterManagerImp.a("100005.100002") == -1) {
        break label260;
      }
      k = 1;
      label126:
      if (localGameCenterManagerImp.a("100005.100001") == -1) {
        break label265;
      }
    }
    for (;;)
    {
      if ((j == 0) && (k == 0) && (m == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantUtil", 2, "Clear parent red flag");
        }
        BusinessInfoCheckUpdateItem.a(paramQQAppInterface, "100005", false);
        localRedTouchManager.b("100005");
      }
      localIntent.putExtra("url", VasWebviewConstants.AVATAR_PENDANT_URL);
      localIntent.putExtra("business", 512L);
      localIntent.putExtra("isShowAd", false);
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramContext.startActivity(localIntent);
      return;
      label255:
      j = 0;
      break;
      label260:
      k = 0;
      break label126;
      label265:
      m = 0;
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    while (jdField_a_of_type_JavaUtilVector.contains(paramString)) {
      return;
    }
    jdField_a_of_type_JavaUtilVector.add(paramString);
  }
  
  public static boolean a(long paramLong)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localInteger == null) {
      return true;
    }
    if (localInteger.intValue() == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String b(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://imgcache.qq.com/qqshow/admindata/comdata/vipFaceAddon_").append(paramLong).append(File.separator);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("aio_50.png");
      continue;
      localStringBuilder.append("aio_50.gif");
      continue;
      localStringBuilder.append("preview_50.png");
      continue;
      localStringBuilder.append("preview_50.gif");
      continue;
      localStringBuilder.append("thumb_nail.png");
      continue;
      localStringBuilder.append("xydata.js");
      continue;
      localStringBuilder.append("avatarfit.png");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AvatarPendantUtil
 * JD-Core Version:    0.7.0.1
 */