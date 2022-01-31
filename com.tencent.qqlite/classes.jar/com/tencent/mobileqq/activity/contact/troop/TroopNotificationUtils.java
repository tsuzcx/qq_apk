package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationUtils
{
  public static final int a = 0;
  protected static final String a = "TroopNotificationUtils";
  public static final int b = 1;
  protected static final String b = "troop_notification_sp";
  public static final int c = 2;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 13: 
    case 22: 
      return 2;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int i = 0 + GroupSystemMsgController.a().a(paramQQAppInterface);
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotificationUtils", 4, "getTroopNotificationUnreadNum:" + i);
    }
    return i;
  }
  
  public static Drawable a(FaceDecoder paramFaceDecoder, String paramString, int paramInt)
  {
    if ((paramFaceDecoder == null) || (paramString == null) || (paramInt == -1)) {
      return null;
    }
    if (paramFaceDecoder.a()) {
      paramFaceDecoder.b();
    }
    Bitmap localBitmap2 = paramFaceDecoder.a(paramInt, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      paramFaceDecoder.a(paramString, paramInt, true);
      if (paramInt != 4) {
        break label68;
      }
    }
    label68:
    for (localBitmap1 = ImageUtil.c();; localBitmap1 = ImageUtil.a()) {
      return new BitmapDrawable(localBitmap1);
    }
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationUtils", 2, "clearAccountLoginInfoSp");
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().clear().commit();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
      } while (localSharedPreferences == null);
      localSharedPreferences.edit().putBoolean("isFirstLogin" + paramString, paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationUtils", 2, "setIsAccountFirstLogin uin=" + paramString + " firstLogin=" + paramBoolean);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return bool1;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
      } while (localSharedPreferences == null);
      bool2 = localSharedPreferences.getBoolean("isFirstLogin" + paramString, true);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationUtils", 2, "isAccountFirstLogin uin=" + paramString + " result=" + bool2);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils
 * JD-Core Version:    0.7.0.1
 */