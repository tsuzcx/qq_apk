package com.tencent.tim.wxapi;

import acbn;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import auqq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class WXApiHelper
  extends BroadcastReceiver
  implements IWXAPIEventHandler
{
  private static WXApiHelper jdField_a_of_type_ComTencentTimWxapiWXApiHelper;
  private static final String cIP = acbn.SDCARD_PATH + "head/" + "wxHead.jpg";
  private static byte[] lock = new byte[0];
  private ArrayList<a> Ep = new ArrayList(1);
  private IWXAPI jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), "wx4c9797ab3fd1e003", true);
  private Map<String, String> pH = new HashMap();
  
  private WXApiHelper()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.tim.action.ACTION_WECHAT_RESPONSE"), "com.tencent.tim.msg.permission.pushnotify", null);
    registerApp();
  }
  
  public static WXApiHelper a()
  {
    if (jdField_a_of_type_ComTencentTimWxapiWXApiHelper == null) {}
    synchronized (lock)
    {
      if (jdField_a_of_type_ComTencentTimWxapiWXApiHelper == null) {
        jdField_a_of_type_ComTencentTimWxapiWXApiHelper = new WXApiHelper();
      }
      return jdField_a_of_type_ComTencentTimWxapiWXApiHelper;
    }
  }
  
  private void bn(QQAppInterface paramQQAppInterface, String paramString)
  {
    new auqq(this, paramString, paramQQAppInterface).execute(new Void[0]);
  }
  
  private boolean sZ(String paramString)
  {
    boolean bool = true;
    QLog.i("WXApiHelper", 1, "start downloadWxHead path:" + cIP);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("WXApiHelper", 1, "start downloadWxHead url is null:");
      return false;
    }
    int i = 0;
    if (i < 3) {}
    for (;;)
    {
      try
      {
        File localFile = new File(cIP);
        if (localFile.exists()) {
          localFile.delete();
        }
        QLog.i("WXApiHelper", 1, "downloadWxHead url" + paramString + " failTryCount:" + i);
        if (ta(paramString)) {
          return bool;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WXApiHelper", 2, "downloadWxHead delete e = " + localException);
        continue;
        i += 1;
      }
      break;
      bool = false;
    }
  }
  
  private boolean ta(String paramString)
  {
    localObject = null;
    try
    {
      paramString = new URL(paramString);
      paramString.openConnection().connect();
      paramString = new BufferedInputStream(paramString.openStream(), 8192);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label90:
        label121:
        localFileOutputStream = null;
      }
    }
    try
    {
      localFileOutputStream = new FileOutputStream(new File(cIP));
      try
      {
        localObject = new byte[1024];
        for (;;)
        {
          int i = paramString.read((byte[])localObject);
          if (i == -1) {
            break;
          }
          localFileOutputStream.write((byte[])localObject, 0, i);
        }
        if (!QLog.isColorLevel()) {
          break label121;
        }
      }
      catch (Exception localException1)
      {
        localObject = paramString;
        paramString = localException1;
      }
    }
    catch (Exception localException2)
    {
      localFileOutputStream = null;
      localObject = paramString;
      paramString = localException2;
      break label90;
    }
    QLog.d("WXApiHelper", 2, "httpDownloadWxHead download head e = " + paramString);
    if (localObject != null) {}
    try
    {
      ((InputStream)localObject).close();
      if (localFileOutputStream != null) {
        localFileOutputStream.close();
      }
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WXApiHelper", 2, "httpDownloadWxHead close input output e = " + paramString);
      return false;
    }
    return false;
    localFileOutputStream.flush();
    localFileOutputStream.close();
    paramString.close();
    return true;
  }
  
  public void a(a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXApiHelper", 2, "addListener");
    }
    synchronized (this.Ep)
    {
      if (!this.Ep.contains(parama)) {
        this.Ep.add(parama);
      }
      return;
    }
  }
  
  public void b(a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXApiHelper", 2, "removeListener");
    }
    synchronized (this.Ep)
    {
      if (this.Ep.contains(parama)) {
        this.Ep.remove(parama);
      }
      return;
    }
  }
  
  public void bm(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = cm(paramString, "first_time_login");
    if ((!TextUtils.isEmpty(str)) && (str == "1"))
    {
      paramString = cm(paramString, "headimgurl");
      if (!TextUtils.isEmpty(paramString)) {
        bn(paramQQAppInterface, paramString);
      }
    }
  }
  
  public void bv(String paramString1, String paramString2, String paramString3)
  {
    this.pH.put(paramString1 + paramString2, paramString3);
  }
  
  public String cm(String paramString1, String paramString2)
  {
    return (String)this.pH.get(paramString1 + paramString2);
  }
  
  public void d(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramString.isEmpty())) {}
    for (;;)
    {
      return;
      paramArrayOfByte = ByteStringMicro.copyFrom(paramArrayOfByte).toStringUtf8();
      bv(paramString, "first_time_login", String.valueOf(paramInt));
      bv(paramString, "time_stamp", String.valueOf(System.currentTimeMillis()));
      try
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte);
        if (paramArrayOfByte.has("openid")) {
          bv(paramString, "openid", paramArrayOfByte.get("openid").toString());
        }
        if (paramArrayOfByte.has("unionid")) {
          bv(paramString, "unionid", paramArrayOfByte.get("unionid").toString());
        }
        if (paramArrayOfByte.has("access_token")) {
          bv(paramString, "access_token", paramArrayOfByte.get("access_token").toString());
        }
        if (paramArrayOfByte.has("refresh_token")) {
          bv(paramString, "refresh_token", paramArrayOfByte.get("refresh_token").toString());
        }
        if (paramArrayOfByte.has("nickname")) {
          bv(paramString, "nickname", paramArrayOfByte.get("nickname").toString());
        }
        if (paramArrayOfByte.has("headimgurl"))
        {
          bv(paramString, "headimgurl", paramArrayOfByte.get("headimgurl").toString());
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("WXApiHelper", 1, "decodeLoginData error " + paramString.toString());
      }
    }
  }
  
  public void ewm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXApiHelper", 2, "loginGetCode");
    }
    SendAuth.Req localReq = new SendAuth.Req();
    localReq.scope = "snsapi_userinfo";
    localReq.state = "tim_wx_login";
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(localReq);
  }
  
  public boolean isWXinstalled()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.isWXAppInstalled();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXApiHelper", 2, "onReceive");
    }
    try
    {
      this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.handleIntent(paramIntent, this);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXApiHelper", 2, "onReq");
    }
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXApiHelper", 2, "onResp");
    }
    synchronized (this.Ep)
    {
      Iterator localIterator = this.Ep.iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).b(paramBaseResp);
      }
    }
  }
  
  public void registerApp()
  {
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.registerApp("wx4c9797ab3fd1e003");
  }
  
  public String rs(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      int i = paramString.lastIndexOf("/");
      if (i == -1) {
        return "";
      }
      paramString = paramString.substring(0, i);
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      paramString = paramString + "/0";
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static abstract interface a
  {
    public abstract void b(BaseResp paramBaseResp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.wxapi.WXApiHelper
 * JD-Core Version:    0.7.0.1
 */