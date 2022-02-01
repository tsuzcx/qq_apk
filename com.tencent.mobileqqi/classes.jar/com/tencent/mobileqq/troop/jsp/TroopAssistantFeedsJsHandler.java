package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.troop.activity.TroopAssistantFeedsActivity;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopProxyActivity;
import gwo;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TroopAssistantFeedsJsHandler
  extends WebViewPlugin
{
  public static final byte a = 101;
  public static final String a = "TroopAssistantFeedsJsHandler";
  public static final String b = "http://qqweb.qq.com/m/qunfeeds/index.html?_wv=1031&_bid=200";
  public static final String c = "troopAssistantFeeds";
  protected static final String d = "openGroupCard";
  protected static final String e = "openGroupMemCard";
  protected static final String f = "openGroupAIO";
  protected static final String g = "openGroupFileDetail";
  protected static final String h = "openGroupPhotoDetail";
  protected static final String i = "openVideo";
  protected static final String j = "openGroupFeedsDetail";
  protected RelativeLayout a;
  protected TroopMemberApiClient a;
  protected VideoPlayLogic a;
  protected AtomicBoolean a;
  
  public TroopAssistantFeedsJsHandler()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  protected void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopFeeds:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("url");
      localObject = ((JSONObject)localObject).getString("title");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Activity localActivity = this.mRuntime.a();
      Intent localIntent = new Intent(localActivity, TroopAssistantFeedsActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("isShowAd", false);
      localIntent.putExtra("title", (String)localObject);
      localActivity.startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopFeeds:" + paramString.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideoInner:" + paramString1 + ", " + paramString2);
    }
    Activity localActivity;
    if (this.mRuntime != null)
    {
      localActivity = this.mRuntime.a();
      if (localActivity != null) {
        break label60;
      }
    }
    label60:
    while ((localActivity == null) || (!(localActivity instanceof TroopAssistantFeedsActivity))) {
      return;
    }
    ((TroopAssistantFeedsActivity)localActivity).c(paramString1, paramString2, this.mRuntime.a().a());
  }
  
  protected void b(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideo:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("guin");
      String str = ((JSONObject)localObject).getString("gcode");
      localObject = ((JSONObject)localObject).getString("videourl");
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
        {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b((String)localObject, new gwo(this, (String)localObject, str));
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideo:" + paramString.toString());
      }
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideoInBrowserActivity:" + paramString);
      }
      Activity localActivity = this.mRuntime.a();
      paramString = paramString.trim();
      String str = this.mRuntime.a().a();
      Intent localIntent = new Intent(localActivity, QQBrowserDelegationActivity.class);
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      if (paramString.indexOf("?") > 0) {}
      for (paramString = "";; paramString = "?")
      {
        paramString = localStringBuilder.append(paramString).append("&from=androidqq");
        paramString.append("&uin=").append(str).append("&originuin=").append("");
        localIntent.putExtra("param_force_internal_browser", true);
        localIntent.putExtra("injectrecommend", false);
        localIntent.putExtra("key_isReadModeEnabled", true);
        localIntent.putExtra("url", paramString.toString().trim());
        localActivity.startActivity(localIntent);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideoInBrowserActivity:" + paramString.toString());
      }
    }
  }
  
  protected void d(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopCard:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("guin");
      localObject = ((JSONObject)localObject).getString("gcode");
      if (!TextUtils.isEmpty(paramString))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        Activity localActivity = this.mRuntime.a();
        Intent localIntent = new Intent(localActivity, ChatSettingForTroop.class);
        localIntent.putExtra("troop_code", paramString);
        localIntent.putExtra("troop_uin", (String)localObject);
        localIntent.putExtra("troop_info_from", 6);
        localIntent.putExtra("vistor_type", 2);
        localActivity.startActivity(localIntent);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopCard:" + paramString.toString());
      }
    }
  }
  
  protected void e(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopMemberCard:" + paramString);
      }
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getString("guin");
      String str = ((JSONObject)localObject1).getString("gcode");
      localObject1 = ((JSONObject)localObject1).getString("muin");
      Object localObject2 = this.mRuntime.a().a();
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        localObject2 = this.mRuntime.a();
        Intent localIntent = new Intent((Context)localObject2, TroopMemberCardActivity.class);
        localIntent.putExtra("troopUin", str);
        localIntent.putExtra("troopCode", paramString);
        localIntent.putExtra("memberUin", (String)localObject1);
        localIntent.putExtra("fromFlag", 3);
        ((Activity)localObject2).startActivity(localIntent);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopMemberCard:" + paramString.toString());
      }
    }
  }
  
  protected void f(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopAIO:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("guin");
      String str = ((JSONObject)localObject).getString("gcode");
      localObject = ((JSONObject)localObject).getString("gname");
      if (!TextUtils.isEmpty(paramString))
      {
        if (TextUtils.isEmpty(str)) {
          return;
        }
        Activity localActivity = this.mRuntime.a();
        Intent localIntent = new Intent(localActivity, ChatActivity.class);
        localIntent.putExtra("uin", str);
        localIntent.putExtra("troop_uin", paramString);
        localIntent.putExtra("uintype", 1);
        localIntent.putExtra("uinname", (String)localObject);
        localActivity.startActivity(localIntent);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopAIO:" + paramString.toString());
      }
    }
  }
  
  protected void g(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("gcode");
      String str1 = ((JSONObject)localObject).getString("uuid");
      try
      {
        l = ((JSONObject)localObject).getLong("fileSize");
        String str2 = ((JSONObject)localObject).getString("fileName");
        String str3 = ((JSONObject)localObject).getString("url");
        int k = ((JSONObject)localObject).getInt("bisID");
        localObject = new Intent();
        ((Intent)localObject).putExtra("troopUin", paramString);
        ((Intent)localObject).putExtra("uuid_key", str1);
        ((Intent)localObject).putExtra("fileSize", l);
        ((Intent)localObject).putExtra("fileName", str2);
        ((Intent)localObject).putExtra("Url", str3);
        ((Intent)localObject).putExtra("bisID", k);
        TroopProxyActivity.b(this.mRuntime.a(), (Intent)localObject, 0);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + localException.toString());
          }
          long l = 0L;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + paramString.toString());
      }
    }
  }
  
  protected void h(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openQZoneAlbumDetail:" + paramString);
      }
      paramString = new JSONObject(paramString).getString("url");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      AppInterface localAppInterface = this.mRuntime.a();
      Activity localActivity = this.mRuntime.a();
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.a = localAppInterface.a();
      localUserInfo.b = localUserInfo.a;
      localUserInfo.c = localAppInterface.getSid();
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openQZoneAlbumDetail:sid=" + localUserInfo.c);
      }
      QZoneHelper.c(localActivity, localUserInfo, paramString, "mqqChat.QzoneCard", -1);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openQZoneAlbumDetail:" + paramString.toString());
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopAssistantFeeds".equals(paramString2))
    {
      if (("openGroupCard".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        d(paramVarArgs[0]);
        return true;
      }
      if (("openGroupMemCard".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        e(paramVarArgs[0]);
        return true;
      }
      if (("openGroupAIO".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        f(paramVarArgs[0]);
        return true;
      }
      if (("openGroupFileDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        g(paramVarArgs[0]);
        return true;
      }
      if (("openGroupPhotoDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        h(paramVarArgs[0]);
        return true;
      }
      if (("openVideo".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        b(paramVarArgs[0]);
        return true;
      }
      if (("openGroupFeedsDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        a(paramVarArgs[0]);
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  protected void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 333	com/tencent/mobileqq/webviewplugin/WebViewPlugin:onDestroy	()V
    //   4: aload_0
    //   5: getfield 47	com/tencent/mobileqq/troop/jsp/TroopAssistantFeedsJsHandler:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   8: ifnull +10 -> 18
    //   11: aload_0
    //   12: getfield 47	com/tencent/mobileqq/troop/jsp/TroopAssistantFeedsJsHandler:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   15: invokevirtual 335	com/tencent/biz/troop/TroopMemberApiClient:b	()V
    //   18: aload_0
    //   19: getfield 58	com/tencent/mobileqq/troop/jsp/TroopAssistantFeedsJsHandler:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   22: iconst_0
    //   23: invokevirtual 338	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 58	com/tencent/mobileqq/troop/jsp/TroopAssistantFeedsJsHandler:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   32: iconst_0
    //   33: invokevirtual 338	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 58	com/tencent/mobileqq/troop/jsp/TroopAssistantFeedsJsHandler:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   42: iconst_0
    //   43: invokevirtual 338	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TroopAssistantFeedsJsHandler
    //   27	1	1	localException	Exception
    //   37	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	18	27	java/lang/Exception
    //   4	18	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopAssistantFeedsJsHandler
 * JD-Core Version:    0.7.0.1
 */