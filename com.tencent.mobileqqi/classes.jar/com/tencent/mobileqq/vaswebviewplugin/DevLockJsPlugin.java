package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class DevLockJsPlugin
  extends VasWebviewJsPlugin
  implements SMSBodyObserver
{
  public static final String NAMESPACE = "EquipLockManager";
  private static final String tag = "DevLockJsPlugin";
  protected QQBrowserActivity activity = null;
  boolean isSubaccount;
  boolean needResult;
  private QQProgressDialog progressDialog = null;
  String resultMobileMask;
  boolean resultSetMobile = false;
  String resultSppkey;
  int resultState = 1;
  String resultUin;
  SmsContent smsContent = null;
  String subAccountUin;
  String tagRequest;
  private boolean waittingResponse = false;
  
  private void hideProgressDialog()
  {
    this.mRuntime.a().runOnUiThread(new DevLockJsPlugin.2(this));
  }
  
  private boolean onBackEvent()
  {
    boolean bool = true;
    if (!this.waittingResponse)
    {
      closeWeb(true);
      bool = false;
    }
    return bool;
  }
  
  private void showProgressDialog()
  {
    this.mRuntime.a().runOnUiThread(new DevLockJsPlugin.1(this));
  }
  
  protected void OnActivityCreate()
  {
    Intent localIntent = getInfoIntent();
    this.tagRequest = localIntent.getStringExtra("tag");
    this.needResult = localIntent.getBooleanExtra("needResult", false);
    this.isSubaccount = localIntent.getBooleanExtra("isSubaccount", false);
    if (this.isSubaccount) {
      this.subAccountUin = localIntent.getStringExtra("subAccountUin");
    }
    this.smsContent = new SmsContent(null);
    this.smsContent.a(this.activity, this);
  }
  
  public void changeEquipLockMobile(String paramString1, String paramString2, String paramString3)
  {
    this.resultState = 3;
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString3;
    closeWeb(false);
  }
  
  public void closeWeb(boolean paramBoolean)
  {
    Intent localIntent;
    if (this.needResult)
    {
      localIntent = new Intent();
      localIntent.putExtra("resultMobileMask", this.resultMobileMask);
      localIntent.putExtra("resultUin", this.resultUin);
      localIntent.putExtra("resultSppkey", this.resultSppkey);
      localIntent.putExtra("resultState", this.resultState);
      if (this.resultState == 2) {
        localIntent.putExtra("resultSetMobile", this.resultSetMobile);
      }
      if (!paramBoolean) {
        break label117;
      }
      this.activity.setResult(0, localIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevLockJsPlugin", 2, "close Web");
      }
      hideProgressDialog();
      this.activity.finish();
      return;
      label117:
      this.activity.setResult(-1, localIntent);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2147500032L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("EquipLockManager".equalsIgnoreCase(paramString2)) {
      return call(paramString3, Arrays.asList(paramVarArgs));
    }
    return false;
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    paramString1 = Utils.d(paramString1, paramString2);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      callJs("_pushInputVcode", new String[] { paramString1 });
    }
  }
  
  public void handleWebError(String paramString1, String paramString2, String paramString3)
  {
    this.resultState = 1;
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString3;
    closeWeb(false);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.a() instanceof QQBrowserActivity)) {
      this.activity = ((QQBrowserActivity)this.mRuntime.a());
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.smsContent != null)
    {
      this.smsContent.a();
      this.smsContent = null;
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getString("cmd");
      paramBundle = paramBundle.getBundle("response");
      if (QLog.isColorLevel()) {
        QLog.i("DevLockJsPlugin", 2, "response:" + str);
      }
      if (str != null)
      {
        if (!str.equalsIgnoreCase("openEquipmentLock")) {
          break label81;
        }
        if (paramBundle.getInt("checkDevLockSms_ret") < 0)
        {
          hideProgressDialog();
          closeWeb(false);
        }
      }
    }
    label81:
    do
    {
      do
      {
        return;
        if (!str.equalsIgnoreCase("setWaitingResponse")) {
          break;
        }
        this.waittingResponse = paramBundle.getBoolean("isWaiting", false);
      } while (this.waittingResponse);
      hideProgressDialog();
      return;
      if (str.equalsIgnoreCase("setMobileResult"))
      {
        this.resultSetMobile = paramBundle.getBoolean("setMobileResult", false);
        return;
      }
    } while (!str.equalsIgnoreCase("closeWeb"));
    closeWeb(paramBundle.getBoolean("isBack"));
  }
  
  public void openEquipmentLock(String paramString1, String paramString2, String paramString3)
  {
    this.resultState = 2;
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString3;
    showProgressDialog();
    byte[] arrayOfByte = null;
    if (paramString3 != null) {
      arrayOfByte = paramString3.getBytes();
    }
    this.waittingResponse = true;
    paramString3 = new Bundle();
    paramString3.putString("uin", paramString1);
    paramString3.putString("mobileMask", paramString2);
    paramString3.putByteArray("sppkey", arrayOfByte);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("openEquipmentLock", "", this.mOnRemoteResp.key, paramString3), true, false);
  }
  
  public void pushMobileResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevLockJsPlugin", 2, "pushMobileResult uin=" + paramString1 + " mobileMask=" + paramString2 + " state=" + paramString3 + " sppkey=" + paramString4);
    }
    updateResult(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void pushMobileReturn(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevLockJsPlugin", 2, "pushMobileReturn uin=" + paramString1 + " mobileMask=" + paramString2 + " state=" + paramString3 + " sppkey=" + paramString4);
    }
    if ("1".equals(paramString3))
    {
      openEquipmentLock(paramString1, paramString2, paramString4);
      return;
    }
    if ("2".equals(paramString3))
    {
      changeEquipLockMobile(paramString1, paramString2, paramString4);
      return;
    }
    handleWebError(paramString1, paramString2, paramString4);
  }
  
  public void updateResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString4;
    if ("1".equals(paramString3))
    {
      this.resultState = 2;
      return;
    }
    if ("2".equals(paramString3))
    {
      this.resultState = 3;
      return;
    }
    this.resultState = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.DevLockJsPlugin
 * JD-Core Version:    0.7.0.1
 */