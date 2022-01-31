package com.tencent.mobileqq.activity.voip;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Base64;
import android.view.Window;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.unipay.plugsdk.IUnipayServiceCallBack.Stub;
import com.tencent.unipay.plugsdk.UnipayPlugAPI;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import fbp;
import fbq;
import fbt;
import fbv;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;

public class VoipTencentPayActivity
  extends BaseActivity
{
  public static final long a = 917504L;
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public static final String a = "VoipTencentPayActivityParam";
  public static final String b = "TencentUnipay.apk";
  public static final String c = "B6004AD4B164B2C12DF5F76B6690206C";
  public static final String d = "http://dldir1.qq.com/qqfile/QQIntl/QQi_wireless/Android/TencentUnipay.apk";
  private static final String o = "HmacSHA1";
  public QQProgressDialog a;
  IUnipayServiceCallBack.Stub jdField_a_of_type_ComTencentUnipayPlugsdkIUnipayServiceCallBack$Stub = new fbt(this);
  private UnipayPlugAPI jdField_a_of_type_ComTencentUnipayPlugsdkUnipayPlugAPI = null;
  private Handler b;
  private final String e = "/v3/r/mpay/buy_goods_m";
  private final String f = "http://10.137.224.117";
  private final String g = "1450000947";
  private final String h = "fQtVzybkXg77AfjT1sZTOaTaG46ISnG6";
  private final String i = "qq_m_qqi-2001-android-2011-0001";
  private final String j = "release";
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  
  public VoipTencentPayActivity()
  {
    this.jdField_b_of_type_AndroidOsHandler = new fbv(this);
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      str = paramString;
      paramString = paramString.replaceAll("[\\\\\\\\+]", "%20");
      str = paramString;
      paramString = paramString.replaceAll("[\\\\\\\\*]", "%2A");
      return paramString;
    }
    catch (Exception paramString)
    {
      g();
    }
    return str;
  }
  
  private String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new SecretKeySpec(paramString1.getBytes(), "HmacSHA1");
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init(paramString1);
      paramString1 = Base64.encodeToString(localMac.doFinal(paramString2.getBytes()), 2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      g();
    }
    return "";
  }
  
  private String b(String paramString)
  {
    String str1 = "";
    int i1 = 0;
    if (i1 < paramString.length())
    {
      String str2 = String.valueOf(paramString.charAt(i1));
      if (!str2.matches("[A-Za-z0-9]|!|\\*|\\(|\\)")) {}
      for (str1 = str1 + "%" + c(str2);; str1 = str1 + str2)
      {
        i1 += 1;
        break;
      }
    }
    return str1;
  }
  
  private String c(String paramString)
  {
    String str1 = "";
    int i1 = 0;
    while (i1 < paramString.length())
    {
      String str2 = Integer.toHexString(paramString.charAt(i1));
      str1 = str1 + str2;
      i1 += 1;
    }
    return str1.toUpperCase();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentUnipayPlugsdkUnipayPlugAPI = new UnipayPlugAPI(this);
    this.jdField_a_of_type_ComTencentUnipayPlugsdkUnipayPlugAPI.setOfferId("1450000947");
    this.jdField_a_of_type_ComTencentUnipayPlugsdkUnipayPlugAPI.setCallBack(this.jdField_a_of_type_ComTencentUnipayPlugsdkIUnipayServiceCallBack$Stub);
    this.jdField_a_of_type_ComTencentUnipayPlugsdkUnipayPlugAPI.setEnv("release");
    this.jdField_a_of_type_ComTencentUnipayPlugsdkUnipayPlugAPI.setNumVisible(false);
    this.jdField_a_of_type_ComTencentUnipayPlugsdkUnipayPlugAPI.bindUnipayService();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentUnipayPlugsdkUnipayPlugAPI.unbindUnipayService();
  }
  
  private void g()
  {
    jdField_a_of_type_AndroidOsHandler.post(new fbp(this));
  }
  
  private void h()
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "TencentUnipay.apk";
    localPluginParams.d = "TencentUnipay.apk";
    localPluginParams.a = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    PluginInfo localPluginInfo = new PluginInfo();
    localPluginInfo.mID = "TencentUnipay.apk";
    localPluginInfo.mName = "TencentUnipay.apk";
    localPluginInfo.mURL = "http://dldir1.qq.com/qqfile/QQIntl/QQi_wireless/Android/TencentUnipay.apk";
    localPluginInfo.mLength = 917504L;
    ((IPluginManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this, localPluginInfo, localPluginParams, new fbq(this));
  }
  
  private void i()
  {
    try
    {
      String str1 = getAppRuntime().getAccount();
      String str2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d();
      Object localObject = BitmapFactory.decodeResource(getResources(), 2130839194);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      this.jdField_a_of_type_ComTencentUnipayPlugsdkUnipayPlugAPI.SaveGoods(str1, str2, "uin", "skey", "1", "qq_m_qqi-2001-android-2011-0001", "pfKey", this.n, (byte[])localObject, "");
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      QRUtils.a(1, 2131562452);
    }
  }
  
  public void d()
  {
    String str1 = getAppRuntime().getAccount();
    String str2 = this.k;
    String str3 = this.l;
    String str4 = this.m;
    String str5 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d();
    String str6 = "" + System.currentTimeMillis() / 1000L;
    Bundle localBundle = new Bundle();
    localBundle.putString("offerId", "1450000947");
    localBundle.putString("goodsmeta", str3);
    localBundle.putString("goodsurl", str4);
    localBundle.putString("openid", str1);
    localBundle.putString("openkey", str5);
    localBundle.putString("pay_token", "");
    localBundle.putString("payitem", str2);
    localBundle.putString("pf", "qq_m_qqi-2001-android-2011-0001");
    localBundle.putString("pfkey", "pfkey");
    localBundle.putString("session_id", "uin");
    localBundle.putString("session_type", "skey");
    localBundle.putString("ts", str6);
    localBundle.putString("zoneid", "1");
    new VoipSSOInterface(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidOsHandler).a(localBundle);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904060);
    getWindow().setBackgroundDrawableResource(2131361815);
    setContentView(2130904060);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562300);
    paramBundle = getIntent().getExtras().getBundle("VoipTencentPayActivityParam");
    this.k = paramBundle.getString("payItem");
    this.l = paramBundle.getString("goodsmeta");
    this.m = paramBundle.getString("goodsurl");
    e();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.hide();
    f();
    super.doOnDestroy();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    finish();
    super.doOnStop();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipTencentPayActivity
 * JD-Core Version:    0.7.0.1
 */