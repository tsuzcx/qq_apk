package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarPendantJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String BUSINESS_NAME = "faceAddon";
  private static final String JS_REQUEST_SCHEME = "jsbridge";
  private static final String LOG_TAG = "AvatarPendantJsPlugin";
  private static final int MENU_ITEM_SELECT_PHOTO = 1;
  private static final int MENU_ITEM_TAKE_PHOTO = 0;
  private BrowserAppInterface browserApp;
  
  private Bitmap getRoundFaceBitmap(String paramString)
  {
    if (new File(paramString).exists())
    {
      Object localObject = ImageUtil.a(new BitmapFactory.Options(), paramString, 200);
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        int i = paramString.getWidth();
        int j = paramString.getHeight();
        localObject = ImageUtil.a(paramString, i, i, j);
        paramString = (String)localObject;
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (((Bitmap)localObject).getWidth() > 200) {
            paramString = ImageUtil.b((Bitmap)localObject, 200);
          }
        }
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
    }
    return ImageUtil.a();
  }
  
  public void changeFace(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "changeFace: " + paramJSONObject);
    }
    paramJSONObject = (ActionSheet)ActionSheetHelper.a(this.mRuntime.a(), null);
    paramJSONObject.c(BaseApplicationImpl.getContext().getString(2131559331));
    paramJSONObject.c(BaseApplicationImpl.getContext().getString(2131559332));
    paramJSONObject.d(BaseApplicationImpl.getContext().getString(2131559333));
    paramJSONObject.a(new AvatarPendantJsPlugin.4(this, paramString, paramJSONObject));
    paramJSONObject.a(new AvatarPendantJsPlugin.5(this, paramString));
    paramJSONObject.show();
  }
  
  public void checkNetworkStatus(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "checkNetworkStatus: " + paramJSONObject);
    }
    int i = NetworkUtil.a(this.mRuntime.a());
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", 0);
      paramJSONObject.put("status", i);
      callJs(paramString + "(" + paramJSONObject.toString() + ");");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "checkNetworkStatus failed: " + paramJSONObject.getMessage());
      }
      callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void getFaceAddon(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "getFaceAddon: " + paramJSONObject);
    }
    try
    {
      paramJSONObject = new JSONObject();
      EntityManager localEntityManager = this.browserApp.a(null).createEntityManager();
      ExtensionInfo localExtensionInfo = (ExtensionInfo)localEntityManager.a(ExtensionInfo.class, this.browserApp.getAccount());
      localEntityManager.a();
      paramJSONObject.put("result", 0);
      if (localExtensionInfo == null) {
        paramJSONObject.put("id", 0L);
      }
      for (;;)
      {
        callJs(paramString + "(" + paramJSONObject.toString() + ");");
        return;
        paramJSONObject.put("id", localExtensionInfo.pendantId);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "getFaceAddon failed: " + paramJSONObject.getMessage());
      }
      callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void getFaceFile(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "getFaceFile: " + paramJSONObject);
    }
    paramJSONObject = new Bundle();
    paramJSONObject.putString("uin", this.browserApp.getAccount());
    sendRemoteReq(DataFactory.makeIPCRequestPacket("getFaceFilePath", paramString, this.mOnRemoteResp.key, paramJSONObject), false, false);
  }
  
  public int getIPCResponseKey()
  {
    return this.mOnRemoteResp.key;
  }
  
  public void getPerformance(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "getPerformance: " + paramJSONObject);
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", 0);
      paramJSONObject.put("clickStart", this.startOpenPageTime);
      paramJSONObject.put("pageStart", this.onPageStartedTime);
      paramJSONObject.put("pageFinish", this.onPageFinishedTime);
      callJs(paramString + "(" + paramJSONObject.toString() + ");");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AvatarPendantJsPlugin", 2, "getPerformance failed: " + paramJSONObject.getMessage());
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2147484160L;
  }
  
  public void getSkey(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "getSkey: " + paramJSONObject);
    }
    if (this.browserApp != null)
    {
      Object localObject = (TicketManager)this.browserApp.getManager(2);
      paramJSONObject = this.browserApp.getAccount();
      if ((localObject == null) || (paramJSONObject == null)) {
        return;
      }
      localObject = ((TicketManager)localObject).getSkey(paramJSONObject);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localJSONObject.put("result", 0);
          localJSONObject.put("skey", localObject);
          localJSONObject.put("uin", paramJSONObject);
        }
        for (;;)
        {
          callJs(paramString + "(" + localJSONObject.toString() + ");");
          return;
          localJSONObject.put("result", 1001);
        }
        try
        {
          paramJSONObject = new JSONObject();
          paramJSONObject.put("result", 1001);
          callJs(paramString + "(" + paramJSONObject.toString() + ");");
          return;
        }
        catch (JSONException paramJSONObject)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AvatarPendantJsPlugin", 2, "getSkey failed2: " + paramJSONObject.getMessage());
          }
          callJsOnError(paramString, paramJSONObject.getMessage());
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AvatarPendantJsPlugin", 2, "getSkey failed1: " + paramJSONObject.getMessage());
        }
        callJsOnError(paramString, paramJSONObject.getMessage());
        return;
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"faceAddon".equals(paramString2)) || (paramString3 == null)) {}
    label293:
    do
    {
      for (;;)
      {
        return false;
        int i = paramString1.indexOf("=");
        if ((i != -1) && (i + 1 <= paramString1.length() - 1))
        {
          paramJsBridgeListener = paramString1.substring(i + 1);
          if (paramJsBridgeListener != null) {
            try
            {
              paramJsBridgeListener = URLDecoder.decode(paramJsBridgeListener, "UTF-8");
              if (paramJsBridgeListener == null) {}
            }
            catch (UnsupportedEncodingException paramJsBridgeListener)
            {
              try
              {
                paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
                if (paramJsBridgeListener == null) {}
              }
              catch (JSONException paramJsBridgeListener)
              {
                try
                {
                  for (;;)
                  {
                    paramString1 = paramJsBridgeListener.getString("callback");
                    if (paramString1 == null) {
                      break;
                    }
                    if (!"getFaceAddon".equals(paramString3)) {
                      break label293;
                    }
                    getFaceAddon(paramJsBridgeListener, paramString1);
                    return true;
                    paramJsBridgeListener = paramJsBridgeListener;
                    if (QLog.isColorLevel()) {
                      QLog.i("AvatarPendantJsPlugin", 2, "Failed to decode json str, " + paramJsBridgeListener.getMessage());
                    }
                    paramJsBridgeListener = null;
                  }
                  paramJsBridgeListener = paramJsBridgeListener;
                  if (QLog.isColorLevel()) {
                    QLog.i("AvatarPendantJsPlugin", 2, "Failed to parse json str, " + paramJsBridgeListener.getMessage());
                  }
                  paramJsBridgeListener = null;
                }
                catch (JSONException paramString1)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("AvatarPendantJsPlugin", 2, "Failed to parse callbackid, " + paramString1.getMessage());
                    }
                    paramString1 = null;
                  }
                  if ("updateFaceAddon".equals(paramString3))
                  {
                    updateFaceAddon(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("showBlackMsgBox".equals(paramString3))
                  {
                    showBlackMsgBox(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("showMsgBox".equals(paramString3))
                  {
                    showMsgBox(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("openVip".equals(paramString3))
                  {
                    openVip(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("changeFace".equals(paramString3))
                  {
                    changeFace(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("getFaceFile".equals(paramString3))
                  {
                    getFaceFile(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("checkNetworkStatus".equals(paramString3))
                  {
                    checkNetworkStatus(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("getSkey".equals(paramString3))
                  {
                    getSkey(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("getPerformance".equals(paramString3))
                  {
                    getPerformance(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("openPage".equals(paramString3))
                  {
                    openPage(paramJsBridgeListener, paramString1);
                    return true;
                  }
                  if ("updateSkey".equals(paramString3))
                  {
                    updateSkey(paramJsBridgeListener, paramString1);
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("AvatarPendantJsPlugin", 2, "NOT support method " + paramString3 + " yet!!");
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AvatarPendantJsPlugin", 2, "ERROR!!! Pendant market is not running in web process!");
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      break label4;
    }
    label4:
    while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
      return;
    }
    String str1 = paramBundle.getString("cmd");
    for (;;)
    {
      Object localObject1;
      try
      {
        String str2 = paramBundle.getString("callbackid");
        localObject1 = paramBundle.getBundle("request");
        localObject2 = paramBundle.getBundle("response");
        paramBundle = new JSONObject();
        if (!"getFaceFilePath".equals(str1)) {
          break label297;
        }
        if (localObject2 == null) {
          break label284;
        }
        localObject1 = getRoundFaceBitmap(((Bundle)localObject2).getString("faceFilePath"));
        if (localObject1 != null) {
          break label193;
        }
        paramBundle.put("result", 1002);
        callJs(str2 + "(" + paramBundle.toString() + ");");
        return;
      }
      catch (Exception paramBundle) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AvatarPendantJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
      return;
      label193:
      Object localObject2 = new ByteArrayOutputStream();
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
      String str3 = Base64Util.a(((ByteArrayOutputStream)localObject2).toByteArray(), 2);
      paramBundle.put("result", 0);
      paramBundle.put("file", "data:image/png;base64," + str3);
      paramBundle.put("size", ((Bitmap)localObject1).getWidth());
      ((ByteArrayOutputStream)localObject2).close();
      continue;
      label284:
      paramBundle.put("result", 1002);
      continue;
      label297:
      if ("changeAvatar".equals(str1))
      {
        if (((Bundle)localObject2).getBoolean("updateResult"))
        {
          localObject1 = getRoundFaceBitmap(((Bundle)localObject1).getString("path"));
          if (localObject1 == null)
          {
            paramBundle.put("result", 1002);
          }
          else
          {
            localObject2 = new ByteArrayOutputStream();
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
            str3 = Base64Util.a(((ByteArrayOutputStream)localObject2).toByteArray(), 2);
            paramBundle.put("result", 1);
            paramBundle.put("file", "data:image/png;base64," + str3);
            paramBundle.put("size", ((Bitmap)localObject1).getWidth());
            ((ByteArrayOutputStream)localObject2).close();
          }
        }
        else
        {
          QQToast.a(this.mRuntime.a(), 2131562885, 0).b(((QQBrowserActivity)this.mRuntime.a()).d());
          paramBundle.put("result", 1001);
        }
      }
      else
      {
        boolean bool = "updatePendantId".equals(str1);
        if (!bool) {}
      }
    }
  }
  
  public void openPage(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "openPage: " + paramJSONObject);
    }
    try
    {
      String str = paramJSONObject.getString("url");
      paramJSONObject = paramJSONObject.getString("title");
      Intent localIntent = new Intent();
      localIntent.putExtra("key_sub_page_url", str);
      localIntent.putExtra("key_sub_page_title", paramJSONObject);
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      VasWebviewUtil.a(this.mRuntime.a(), null, 1024L, localIntent, false, -1);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", 0);
      callJs(paramString + "(" + paramJSONObject.toString() + ");");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AvatarPendantJsPlugin", 2, "openPage failed: " + paramJSONObject.getMessage());
    }
  }
  
  public void openVip(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "openVip: " + paramJSONObject);
    }
  }
  
  protected boolean shouldGetBusiness()
  {
    return false;
  }
  
  public void showBlackMsgBox(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "showBlackMsgBox: " + paramJSONObject);
    }
    try
    {
      paramJSONObject = paramJSONObject.getString("msg");
      QQToast.a(this.mRuntime.a(), paramJSONObject, 0).b(((QQBrowserActivity)this.mRuntime.a()).d());
      paramJSONObject = new JSONObject();
      callJs(paramString + "(" + paramJSONObject.toString() + ");");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "showBlackMsgBox failed: " + paramJSONObject.getMessage());
      }
      callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void showMsgBox(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "showMsgBox: " + paramJSONObject);
    }
    try
    {
      String str1 = paramJSONObject.getString("msg");
      String str2 = paramJSONObject.getString("title");
      paramJSONObject = paramJSONObject.getJSONArray("button");
      if (paramJSONObject.length() >= 1)
      {
        QQCustomDialogThreeBtns localQQCustomDialogThreeBtns = DialogUtil.a(this.mRuntime.a(), 230);
        localQQCustomDialogThreeBtns.a(str2);
        localQQCustomDialogThreeBtns.b(str1);
        localQQCustomDialogThreeBtns.a(paramJSONObject.getString(0), new AvatarPendantJsPlugin.1(this, paramString));
        if (paramJSONObject.length() >= 2) {
          localQQCustomDialogThreeBtns.b(paramJSONObject.getString(1), new AvatarPendantJsPlugin.2(this, paramString));
        }
        if (paramJSONObject.length() >= 3) {
          localQQCustomDialogThreeBtns.c(paramJSONObject.getString(2), new AvatarPendantJsPlugin.3(this, paramString));
        }
        localQQCustomDialogThreeBtns.show();
        paramJSONObject = new JSONObject();
        callJs(paramString + "(" + paramJSONObject.toString() + ");");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "no button message");
      }
      throw new Exception("no button message");
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "showMsgBox failed: " + paramJSONObject.getMessage());
      }
      callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void updateFaceAddon(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "updateFaceAddon: " + paramJSONObject);
    }
    try
    {
      long l = paramJSONObject.getLong("id");
      paramJSONObject = new Bundle();
      paramJSONObject.putString("uin", this.browserApp.getAccount());
      paramJSONObject.putLong("pendantId", l);
      sendRemoteReq(DataFactory.makeIPCRequestPacket("updatePendantId", paramString, this.mOnRemoteResp.key, paramJSONObject), false, false);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "updateFaceAddon failed: " + paramJSONObject.getMessage());
      }
      callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  /* Error */
  public void updateSkey(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 14
    //   8: iconst_2
    //   9: new 82	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 622
    //   19: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 104	com/tencent/mobileqq/vaswebviewplugin/AvatarPendantJsPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   36: invokevirtual 426	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +384 -> 425
    //   44: aload_1
    //   45: iconst_2
    //   46: invokevirtual 625	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   49: checkcast 303	mqq/manager/TicketManager
    //   52: astore 4
    //   54: aload_0
    //   55: getfield 203	com/tencent/mobileqq/vaswebviewplugin/AvatarPendantJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   58: invokevirtual 219	com/tencent/mobileqq/app/BrowserAppInterface:getAccount	()Ljava/lang/String;
    //   61: astore_1
    //   62: aload 4
    //   64: ifnull +356 -> 420
    //   67: aload_1
    //   68: ifnull +352 -> 420
    //   71: aload 4
    //   73: aload_1
    //   74: invokeinterface 306 2 0
    //   79: astore 4
    //   81: new 169	org/json/JSONObject
    //   84: dup
    //   85: invokespecial 170	org/json/JSONObject:<init>	()V
    //   88: astore 5
    //   90: aload 4
    //   92: invokestatic 312	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne +263 -> 358
    //   98: ldc_w 627
    //   101: invokestatic 631	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 6
    //   106: aload_0
    //   107: getfield 104	com/tencent/mobileqq/vaswebviewplugin/AvatarPendantJsPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   110: invokevirtual 634	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/smtt/sdk/WebView;
    //   113: invokevirtual 637	com/tencent/smtt/sdk/WebView:getContext	()Landroid/content/Context;
    //   116: invokestatic 643	com/tencent/smtt/sdk/CookieSyncManager:createInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/CookieSyncManager;
    //   119: pop
    //   120: invokestatic 649	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   123: astore 7
    //   125: aload 7
    //   127: iconst_1
    //   128: invokevirtual 653	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   131: aload 7
    //   133: aload 6
    //   135: ldc_w 655
    //   138: iconst_2
    //   139: anewarray 657	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload 4
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload 6
    //   151: aastore
    //   152: invokestatic 661	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   155: invokevirtual 664	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload 7
    //   160: aload 6
    //   162: ldc_w 666
    //   165: iconst_2
    //   166: anewarray 657	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_1
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: aload 6
    //   177: aastore
    //   178: invokestatic 661	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   181: invokevirtual 664	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: invokestatic 669	com/tencent/smtt/sdk/CookieSyncManager:getInstance	()Lcom/tencent/smtt/sdk/CookieSyncManager;
    //   187: invokevirtual 672	com/tencent/smtt/sdk/CookieSyncManager:sync	()V
    //   190: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +60 -> 253
    //   196: ldc 14
    //   198: iconst_2
    //   199: new 82	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 674
    //   209: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 627
    //   215: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 676
    //   221: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc_w 655
    //   227: iconst_2
    //   228: anewarray 657	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload 4
    //   235: aastore
    //   236: dup
    //   237: iconst_1
    //   238: aload 6
    //   240: aastore
    //   241: invokestatic 661	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   244: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload 5
    //   255: ldc 172
    //   257: iconst_0
    //   258: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   261: pop
    //   262: aload_0
    //   263: new 82	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   270: aload_2
    //   271: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 180
    //   276: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 5
    //   281: invokevirtual 181	org/json/JSONObject:toString	()Ljava/lang/String;
    //   284: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc 183
    //   289: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokevirtual 186	com/tencent/mobileqq/vaswebviewplugin/AvatarPendantJsPlugin:callJs	(Ljava/lang/String;)V
    //   298: iconst_0
    //   299: istore_3
    //   300: iload_3
    //   301: ifeq +56 -> 357
    //   304: new 169	org/json/JSONObject
    //   307: dup
    //   308: invokespecial 170	org/json/JSONObject:<init>	()V
    //   311: astore_1
    //   312: aload_1
    //   313: ldc 172
    //   315: sipush 1001
    //   318: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   321: pop
    //   322: aload_0
    //   323: new 82	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   330: aload_2
    //   331: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc 180
    //   336: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload_1
    //   340: invokevirtual 181	org/json/JSONObject:toString	()Ljava/lang/String;
    //   343: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc 183
    //   348: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokevirtual 186	com/tencent/mobileqq/vaswebviewplugin/AvatarPendantJsPlugin:callJs	(Ljava/lang/String;)V
    //   357: return
    //   358: aload 5
    //   360: ldc 172
    //   362: sipush 1001
    //   365: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   368: pop
    //   369: goto -107 -> 262
    //   372: astore_1
    //   373: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   376: ifeq +32 -> 408
    //   379: ldc 14
    //   381: iconst_2
    //   382: new 82	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   389: ldc_w 678
    //   392: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_1
    //   396: invokevirtual 191	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   399: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload_0
    //   409: aload_2
    //   410: aload_1
    //   411: invokevirtual 191	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   414: invokevirtual 198	com/tencent/mobileqq/vaswebviewplugin/AvatarPendantJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: goto -119 -> 298
    //   420: iconst_1
    //   421: istore_3
    //   422: goto -122 -> 300
    //   425: iconst_1
    //   426: istore_3
    //   427: goto -127 -> 300
    //   430: astore_1
    //   431: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +32 -> 466
    //   437: ldc 14
    //   439: iconst_2
    //   440: new 82	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 680
    //   450: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_1
    //   454: invokevirtual 191	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   457: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: aload_0
    //   467: aload_2
    //   468: aload_1
    //   469: invokevirtual 191	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   472: invokevirtual 198	com/tencent/mobileqq/vaswebviewplugin/AvatarPendantJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	AvatarPendantJsPlugin
    //   0	476	1	paramJSONObject	JSONObject
    //   0	476	2	paramString	String
    //   299	128	3	i	int
    //   52	182	4	localObject	Object
    //   88	271	5	localJSONObject	JSONObject
    //   104	135	6	str	String
    //   123	36	7	localCookieManager	com.tencent.smtt.sdk.CookieManager
    // Exception table:
    //   from	to	target	type
    //   81	253	372	org/json/JSONException
    //   253	262	372	org/json/JSONException
    //   262	298	372	org/json/JSONException
    //   358	369	372	org/json/JSONException
    //   304	357	430	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin
 * JD-Core Version:    0.7.0.1
 */