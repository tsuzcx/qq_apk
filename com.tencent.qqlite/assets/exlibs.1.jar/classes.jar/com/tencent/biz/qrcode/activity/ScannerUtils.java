package com.tencent.biz.qrcode.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.QRCodeServlet;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.request.WtloginHelper;
import qq;
import qr;
import qs;

public class ScannerUtils
{
  public static final int a = 600;
  public static final String a = "ScannerUtils";
  public static final int b = 600;
  protected static final String b = "needLandScape";
  public static int c = 1;
  protected static final String c = "lastCheckOrientation";
  public static final int d = 0;
  protected static final String d = "http://qm.qq.com/cgi-bin/check_orientation";
  public static final int e = 1;
  public static final String e = "qrcode";
  public static final int f = 2;
  public static final String f = "user";
  public static final String g = "group";
  public static final String h = "discussion";
  public static String i = "addDisSource";
  public static final String j = "scanResult";
  public static final String k = "exttype";
  public static final String l = "extvalue";
  public static final String m = "^mecard.*";
  public static final String n = "^begin:vcard[\\s\\S]*end:vcard";
  public static final String o = "^bizcard.*;;$";
  
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap, Rect paramRect)
  {
    try
    {
      paramRect = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(paramRect);
      localCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, 600, 600), null);
    }
    catch (OutOfMemoryError paramRect)
    {
      for (;;)
      {
        try
        {
          Canvas localCanvas;
          paramBitmap = new Paint();
          paramBitmap.setAntiAlias(true);
          Rect localRect = new Rect(247, 247, 353, 353);
          paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130838036);
          localCanvas.drawBitmap(paramContext, null, localRect, paramBitmap);
          paramContext.recycle();
          return paramRect;
        }
        catch (OutOfMemoryError paramContext)
        {
          paramContext.printStackTrace();
        }
        paramRect = paramRect;
        System.gc();
        try
        {
          paramRect = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.w("ScannerUtils", 2, paramContext.getMessage());
          }
          return null;
        }
      }
    }
    return null;
  }
  
  public static BitMatrix a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    paramSharedPreferences = paramSharedPreferences.getString("user" + paramString, null);
    if (paramSharedPreferences == null) {
      return null;
    }
    return QRUtils.a(paramSharedPreferences, paramInt);
  }
  
  public static String a(String paramString, SharedPreferences paramSharedPreferences)
  {
    return paramSharedPreferences.getString("user" + paramString, null);
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramInt == 1) {
      localObject = "ConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", (String)localObject, 1);
      do
      {
        return;
        if (paramInt == 2)
        {
          localObject = "GroupQRcard";
          break;
        }
      } while (paramInt == 3);
      String str = "ThirdpartyQRcard";
      if (QRUtils.d(paramString))
      {
        StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (QRUtils.f(paramString))
        {
          StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardphone", 1);
          localObject = str;
        }
      }
    }
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    paramString1 = "user" + paramString1;
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.putString(paramString1, paramString2);
    paramSharedPreferences.commit();
  }
  
  public static void a(Boolean paramBoolean1, Boolean paramBoolean2, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, ScannerView paramScannerView, WtloginHelper paramWtloginHelper, View paramView)
  {
    String str = paramString.trim();
    if (QLog.isColorLevel()) {
      QLog.d("ScannerUtils", 2, "resultString:" + str);
    }
    if (paramBoolean2.booleanValue())
    {
      if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
        AudioUtil.b(2131165191, false);
      }
      paramAppActivity.setResult(-1, paramAppActivity.getIntent().putExtra("scanResult", paramString));
      paramAppActivity.finish();
      return;
    }
    paramString = str.toLowerCase();
    int i2 = -1;
    int i1 = i2;
    if (Pattern.compile("^mecard.*").matcher(paramString).matches()) {
      if (str.length() <= "MECARD:".length())
      {
        i1 = i2;
        if (!str.contains(":")) {}
      }
      else
      {
        i1 = 0;
      }
    }
    i2 = i1;
    if (Pattern.compile("^begin:vcard[\\s\\S]*end:vcard").matcher(paramString).matches()) {
      if (str.length() <= "BEGIN:VCARD\nEND:VCARD".length())
      {
        i2 = i1;
        if (!str.contains(":")) {}
      }
      else
      {
        i2 = 1;
      }
    }
    if ((Pattern.compile("^bizcard.*;;$").matcher(paramString).matches()) && ((str.length() > "BIZCARD:;;:".length()) || (str.contains(":")))) {}
    for (i1 = 2;; i1 = i2)
    {
      if (i1 != -1) {}
      for (i2 = 1;; i2 = 0)
      {
        if (i2 != 0)
        {
          if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
            AudioUtil.b(2131165191, false);
          }
          if (i2 == 0) {
            break label598;
          }
          QRResultHandler.a(paramQQAppInterface, paramAppActivity, str, i1);
          i1 = 0;
        }
        while ((i1 == 0) && (paramBoolean1.booleanValue()))
        {
          paramAppActivity.finish();
          return;
          if (!HttpUtil.a(paramAppActivity))
          {
            paramBoolean1 = DialogUtil.a(paramAppActivity, 230);
            paramBoolean1.setMessage(2131362377);
            paramBoolean2 = new qr(paramScannerView);
            paramBoolean1.setPositiveButton(2131362802, paramBoolean2);
            paramBoolean1.setOnCancelListener(paramBoolean2);
            paramBoolean1.show();
            return;
          }
          if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
            AudioUtil.b(2131165191, false);
          }
          paramBoolean2 = paramWtloginHelper;
          if (paramWtloginHelper == null) {
            paramBoolean2 = new WtloginHelper(paramAppActivity.getApplicationContext());
          }
          if ((paramBoolean2.IsWtLoginUrl(paramString)) && (!QRUtils.a(paramString)))
          {
            paramView.setVisibility(0);
            paramBoolean2 = new Intent(paramAppActivity, QRLoginActivity.class);
            paramBoolean2.putExtra("QR_CODE_STRING", str);
            paramAppActivity.startActivity(paramBoolean2);
            i1 = 0;
          }
          else if (QRUtils.e(paramString))
          {
            if (QRUtils.b(paramString))
            {
              paramBoolean2 = new Intent(paramAppActivity, JoinDiscussionActivity.class);
              paramBoolean2.putExtra("innerSig", str);
              paramBoolean2.putExtra(i, c);
              if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
                paramAppActivity.startActivityForResult(paramBoolean2, 2);
              }
              for (;;)
              {
                i1 = 0;
                break;
                paramAppActivity.startActivity(paramBoolean2);
              }
            }
            a(paramBoolean1.booleanValue(), str, paramAppActivity, paramQQAppInterface, paramBoolean, paramScannerView, paramView);
            i1 = 1;
          }
          else
          {
            QRResultHandler.a(paramQQAppInterface, paramAppActivity, str);
            label598:
            i1 = 0;
          }
        }
        break;
      }
    }
  }
  
  public static void a(boolean paramBoolean1, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean2, ScannerView paramScannerView, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerView = new qs(paramAppActivity, paramString, paramQQAppInterface, paramBoolean1, paramView, paramBoolean2, paramScannerView);
    paramAppActivity = new NewIntent(paramAppActivity, QRCodeServlet.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramAppActivity.setObserver(paramScannerView);
    paramQQAppInterface.startServlet(paramAppActivity);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("://aq.qq.com"))) {
      paramQQAppInterface.sendWirelessPswReq(3);
    }
  }
  
  public static boolean a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("ScannerUtils", 2, "Product:" + Build.PRODUCT);
    }
    if (paramSharedPreferences.contains("needLandScape")) {}
    for (bool = paramSharedPreferences.getBoolean("needLandScape", false);; bool = true) {
      do
      {
        long l1 = paramSharedPreferences.getLong("lastCheckOrientation", 0L);
        if (System.currentTimeMillis() - l1 > 86400000L) {
          new qq(paramSharedPreferences, paramContext).start();
        }
        return bool;
      } while ((!Build.PRODUCT.equals("SCH-I619")) && (!Build.PRODUCT.equals("GT-S5360")) && (!Build.PRODUCT.equals("GT-S5830i")) && ((!Build.PRODUCT.equals("meizu_m9")) || (Build.VERSION.SDK_INT >= 9)) && (!Build.PRODUCT.equals("GT-S6352")) && (!Build.PRODUCT.equals("GT-S5831i")));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerUtils
 * JD-Core Version:    0.7.0.1
 */