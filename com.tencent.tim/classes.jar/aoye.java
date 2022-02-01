import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin.2;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoye
  extends WebViewPlugin
  implements skj.a
{
  protected arhz U;
  protected Dialog aB;
  aqju aC;
  AtomicBoolean ac = new AtomicBoolean(false);
  public final byte bz = 5;
  protected boolean cPo;
  String cnu;
  protected int dSg = -1;
  public skj mClient = null;
  protected int mFrom;
  
  public aoye()
  {
    this.mPluginNameSpace = "Troop";
  }
  
  private void Sm(String paramString)
  {
    Activity localActivity = this.mRuntime.getActivity();
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 3);
    localIntent.putExtra("cfg", paramString);
    localActivity.startActivity(localIntent);
  }
  
  private void Ss(String paramString)
  {
    Object localObject = (BaseActivity)this.mRuntime.getActivity();
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a((Context)localObject, 2131696270, 0).show(((BaseActivity)localObject).getTitleBarHeight());
      return;
    }
    dN(((BaseActivity)localObject).getString(2131721482));
    localObject = new Intent((Context)localObject, TroopCreateLogicActivity.class);
    ((Intent)localObject).putExtra("type", 1);
    ((Intent)localObject).putExtra("cfg", paramString);
    startActivityForResult((Intent)localObject, (byte)41);
  }
  
  private void St(String paramString)
  {
    Activity localActivity = this.mRuntime.getActivity();
    if (localActivity == null) {}
    for (;;)
    {
      return;
      Intent localIntent = null;
      try
      {
        paramString = new JSONObject(paramString).getString("troopUin");
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        localIntent = new Intent(localActivity, SelectMemberActivity.class);
        localIntent.putExtra("param_groupcode", paramString);
        localIntent.putExtra("param_type", 1);
        localIntent.putExtra("param_subtype", 0);
        localIntent.putExtra("param_only_friends", true);
        localIntent.putExtra("param_title", this.mRuntime.getActivity().getString(2131695127));
        localIntent.putExtra("param_done_button_wording", this.mRuntime.getActivity().getString(2131721079));
        localIntent.putExtra("param_done_button_highlight_wording", this.mRuntime.getActivity().getString(2131696549));
        localIntent.putExtra("param_only_friends", true);
        localIntent.putExtra("param_exit_animation", 1);
        localIntent.putExtra("param_max", 100);
        localIntent.putExtra("param_donot_need_contacts", true);
        localActivity.startActivity(localIntent);
        localActivity.overridePendingTransition(2130771991, 2130771992);
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localIntent;
        }
      }
    }
  }
  
  private void Su(String paramString)
  {
    int i = 0;
    Activity localActivity = this.mRuntime.getActivity();
    if (localActivity == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optString("troopUin", "");
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          JSONObject localJSONObject;
          boolean bool = localJSONObject.optBoolean("closeCurPage", false);
          i = bool;
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = TroopInfoActivity.c(paramString, 9);
            paramString.putString("troop_info_title", localActivity.getString(2131698347));
            paramString.putInt("troop_info_report_from", 1);
            TroopInfoActivity.b(localActivity, paramString, 45);
            localActivity.overridePendingTransition(2130771991, 2130771992);
          }
          if (i == 0) {
            break;
          }
          localActivity.finish();
          return;
        }
        catch (JSONException localJSONException2)
        {
          break label114;
        }
        localJSONException1 = localJSONException1;
        paramString = "";
      }
      label114:
      localJSONException1.printStackTrace();
    }
  }
  
  private void Sw(String paramString)
  {
    Activity localActivity = this.mRuntime.getActivity();
    Object localObject = paramString.split("\\|");
    String str = "";
    if (localObject.length >= 4) {
      str = localObject[3];
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("location", str);
    ((Intent)localObject).putExtra("locationOriginal", paramString);
    localActivity.setResult(-1, (Intent)localObject);
    localActivity.finish();
  }
  
  private void Sy(String paramString)
  {
    Object localObject = this.mRuntime.getActivity();
    dN(((Activity)localObject).getString(2131721487));
    localObject = new Intent((Context)localObject, TroopCreateLogicActivity.class);
    ((Intent)localObject).putExtra("type", 5);
    ((Intent)localObject).putExtra("troop_location", paramString);
    ((Intent)localObject).putExtra("troop_uin", this.cnu);
    startActivityForResult((Intent)localObject, (byte)5);
  }
  
  private void dN(String paramString)
  {
    Object localObject = (BaseActivity)this.mRuntime.getActivity();
    CA();
    localObject = new arhz((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
    ((arhz)localObject).setMessage(paramString);
    ((arhz)localObject).setCancelable(false);
    ((arhz)localObject).setOnDismissListener(new aoyg(this));
    this.U = ((arhz)localObject);
    this.U.show();
  }
  
  private void dXR()
  {
    if (this.aB != null)
    {
      if (this.aB.isShowing()) {
        this.aB.dismiss();
      }
      this.aB = null;
    }
  }
  
  private void dXS()
  {
    this.mRuntime.getActivity().finish();
  }
  
  void CA()
  {
    if (this.U != null)
    {
      if (this.U.isShowing()) {
        this.U.dismiss();
      }
      this.U = null;
    }
  }
  
  public void SA(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Activity localActivity;
      return;
    }
    catch (JSONException paramString)
    {
      try
      {
        paramString = paramString.getString("url");
        if (paramString != null)
        {
          localActivity = this.mRuntime.getActivity();
          aoyd.a(localActivity, localActivity.getIntent().getExtras(), paramString);
        }
        return;
      }
      catch (JSONException paramString) {}
      paramString = paramString;
      return;
    }
  }
  
  public void SB(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      try
      {
        paramString = paramString.getString("tags");
        if (!(this.mRuntime.getActivity() instanceof TroopTagViewActivity)) {
          return;
        }
        ((TroopTagViewActivity)this.mRuntime.getActivity()).Sq(paramString);
        return;
      }
      catch (JSONException paramString) {}
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void Sr(String paramString)
  {
    QLog.e(this.TAG, 1, "TroopCreateAvatarActivity 已在725下架");
  }
  
  public void Sv(String paramString)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mRuntime.getActivity();
    if (!aqiw.isNetSupport(localBaseActivity)) {
      QQToast.a(localBaseActivity, 2131696270, 0).show(localBaseActivity.getTitleBarHeight());
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    Sw(paramString);
  }
  
  public void Sx(String paramString)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mRuntime.getActivity();
    try
    {
      paramString = new JSONObject(paramString).optString("location", "");
      if (!this.cPo)
      {
        Sv(paramString);
        return;
      }
      if (!aqiw.isNetSupport(localBaseActivity))
      {
        QQToast.a(localBaseActivity, 2131696270, 0).show(localBaseActivity.getTitleBarHeight());
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        dXQ();
        return;
      }
      Sy(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  /* Error */
  public void Sz(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	aoye:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   4: invokevirtual 60	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   7: astore_3
    //   8: new 131	org/json/JSONObject
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 133	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc_w 348
    //   21: invokevirtual 138	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 4
    //   26: aload_1
    //   27: ldc_w 350
    //   30: invokevirtual 354	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   33: istore_2
    //   34: aload 4
    //   36: bipush 13
    //   38: invokestatic 201	com/tencent/mobileqq/activity/TroopInfoActivity:c	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   41: astore_1
    //   42: aload_1
    //   43: ldc_w 350
    //   46: iload_2
    //   47: invokevirtual 358	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   50: aload_3
    //   51: aload_1
    //   52: invokestatic 362	com/tencent/mobileqq/activity/TroopInfoActivity:i	(Landroid/content/Context;Landroid/os/Bundle;)V
    //   55: iload_2
    //   56: ifeq +7 -> 63
    //   59: aload_3
    //   60: invokevirtual 223	android/app/Activity:finish	()V
    //   63: return
    //   64: astore_1
    //   65: return
    //   66: astore_1
    //   67: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	aoye
    //   0	68	1	paramString	String
    //   33	23	2	bool	boolean
    //   7	53	3	localActivity	Activity
    //   24	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   8	17	64	org/json/JSONException
    //   17	55	66	org/json/JSONException
    //   59	63	66	org/json/JSONException
  }
  
  public void Y(String paramString1, String paramString2, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuffer.append("groupCode=" + paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuffer.append("&groupMemberUin=" + paramString2);
    }
    if (paramInt != -1) {
      localStringBuffer.append("&shielded=" + paramInt);
    }
    paramString1 = "mqq://troop_member_card/open_member_recent_chat_view/?" + localStringBuffer.toString();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "jump: " + paramString1);
    }
    this.mRuntime.getActivity().startActivity(new Intent().setData(Uri.parse(paramString1)));
  }
  
  public void callback(Bundle paramBundle)
  {
    int i = 2;
    if (paramBundle == null) {}
    do
    {
      return;
      if (paramBundle.getInt("type") != 84) {
        break;
      }
      paramBundle.getBoolean("isSuccess");
      paramBundle.getInt("appid");
      paramBundle.getString("openGroupId");
      paramBundle.getString("token");
      paramBundle = paramBundle.getString("uin");
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG + ".troopTAG_GET_UIN_BY_OPEN_ID", 2, "callback,uin:" + paramBundle);
    return;
    boolean bool;
    String str;
    Object localObject;
    if (paramBundle.getInt("type") == 71)
    {
      bool = paramBundle.getBoolean("isSuccess");
      int k = paramBundle.getInt("appid");
      str = paramBundle.getString("openGroupId");
      localObject = paramBundle.getString("token");
      int m = paramBundle.getInt("freq");
      int n = paramBundle.getInt("expireTime");
      ArrayList localArrayList = paramBundle.getStringArrayList("apilist");
      int j = paramBundle.getInt("retCode");
      if (!bool)
      {
        switch (j)
        {
        default: 
          i = -100;
        }
        for (;;)
        {
          callJs4OpenApiIfNeeded("init", i, " server retCode:" + j);
          return;
          i = 0;
          continue;
          i = 4;
        }
      }
      CustomWebView localCustomWebView = this.mRuntime.getWebView();
      if (localCustomWebView != null)
      {
        localCustomWebView.saveToken(k, str, (String)localObject, m, n, localArrayList);
        callJs4OpenApiIfNeeded("init", 0, localArrayList.toString());
        return;
      }
      callJs(paramBundle.getString("callback"), new String[] { "webView == null" });
      return;
    }
    if ("troopCreateOpenAIO".equals(paramBundle.getString("type")))
    {
      bool = paramBundle.getBoolean("isSuccess", false);
      localObject = new JSONObject();
      if (bool) {
        str = "0";
      }
      try
      {
        for (;;)
        {
          ((JSONObject)localObject).put("ret", str);
          callJs(paramBundle.getString("callback"), new String[] { ((JSONObject)localObject).toString() });
          return;
          str = "1";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    callJs(paramBundle.getString("callback"), new String[] { "" });
  }
  
  public void dXQ()
  {
    dXR();
    ausj localausj = (ausj)auss.a(this.mRuntime.getActivity(), null);
    localausj.setMainTitle(2131721480);
    localausj.addButton(2131721481, 3);
    localausj.addCancelButton(2131721058);
    localausj.setOnDismissListener(new aoyh(this));
    localausj.a(new aoyi(this));
    this.aB = localausj;
    this.aB.show();
  }
  
  protected void hR(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2.replace("\"", "\\\"");
    }
    paramString1 = "javascript:" + paramString1 + "(\"" + str + "\")";
    this.mRuntime.getWebView().loadUrl(paramString1);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L) {}
    for (;;)
    {
      return false;
      if (paramLong != 8589934601L) {
        if (paramLong == 2L)
        {
          if (this.dSg != -1)
          {
            paramString = new JSONObject();
            try
            {
              paramString.put("isBack", this.dSg);
              hR("onGetGroupHeadEditViewBack", paramString.toString());
              this.dSg = -1;
            }
            catch (JSONException paramString)
            {
              for (;;)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
        else if (paramLong != 16L) {}
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("Troop")) {
      return false;
    }
    addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
    if ("init".equals(paramString3)) {}
    int i;
    int j;
    boolean bool;
    label866:
    try
    {
      paramString2 = new JSONObject(paramVarArgs[0]);
      i = paramString2.optInt("appid");
      paramString1 = paramString2.optString("openGroupId");
      paramString2 = paramString2.optString("token");
      if ((TextUtils.isEmpty(i + "")) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
      {
        callJs4OpenApi(paramJsBridgeListener, 4, JsBridgeListener.a(4, null, null));
        return false;
      }
      paramJsBridgeListener = this.mRuntime.getWebView().getUrl();
      j = paramJsBridgeListener.indexOf("?");
      paramString3 = this.mClient;
      if (j == -1) {}
      for (paramJsBridgeListener = null;; paramJsBridgeListener = paramJsBridgeListener.substring(0, j))
      {
        paramString3.a(i, paramString1, paramString2, paramJsBridgeListener, "init", this);
        break;
      }
      if (paramString3.equals("setTitleButton")) {
        break label2264;
      }
      if (paramString3.equals("commitGroupInfo"))
      {
        Ss(paramVarArgs[0]);
        break label2264;
      }
      if (paramString3.equals("shareGroup"))
      {
        Sm(paramVarArgs[0]);
        break label2264;
      }
      if (paramString3.equals("inviteMemberToGroup"))
      {
        St(paramVarArgs[0]);
        break label2264;
      }
      if (paramString3.equals("enterGroupInfoCard"))
      {
        Su(paramVarArgs[0]);
        break label2264;
      }
      if (paramString3.equals("modifyTroopLocation"))
      {
        Sx(paramVarArgs[0]);
        break label2264;
      }
      if (paramString3.equals("finishCreateGroup"))
      {
        dXS();
        break label2264;
      }
      if (paramString3.equals("insertCreateGroupSuccessMsg")) {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.getString("troopUin");
          paramString1 = paramString2.getString("groupName");
          i = paramString2.optInt("cateId");
          paramString2 = paramString2.optString("callback");
          this.mClient.a(paramJsBridgeListener, paramString1, i, paramString2, this);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      if (paramString3.equals("showGroupHeadEditView"))
      {
        Sr(paramVarArgs[0]);
        break label2264;
      }
      if (paramString3.equals("searchTroop"))
      {
        QQToast.a(this.mRuntime.getActivity(), 0, "该api功能已下架!", 0).show();
        break label2264;
      }
      if (paramString3.equals("didModifyGroupTags"))
      {
        SB(paramVarArgs[0]);
        paramJsBridgeListener.onComplete(Boolean.valueOf(true));
        break label2264;
      }
      if (paramString3.equals("openTroopProfileEdit"))
      {
        Sz(paramVarArgs[0]);
        break label2264;
      }
      if (paramString3.equals("showTroopProfile"))
      {
        QQToast.a(this.mRuntime.getActivity(), 0, "该api功能已下架!", 0).show();
        break label2264;
      }
      if (paramString3.equals("getVersion"))
      {
        paramJsBridgeListener.onComplete("3.4.4.3058");
        break label2264;
      }
      if (paramString3.equals("isNetworkConnected"))
      {
        paramJsBridgeListener.onComplete(Boolean.valueOf(arwo.cs(aroi.a().getContext())));
        break label2264;
      }
      if (paramString3.equals("openUrl"))
      {
        SA(paramVarArgs[0]);
        break label2264;
      }
      if ((paramString3.equals("setWebDataCache")) || (paramString3.equals("getWebDataCache"))) {
        break label2264;
      }
      if ("getUniqueTitleNewFlag".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if ((this.mRuntime.getActivity().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin() + "_troopManager", 0).getInt("uniqueTitleNewFlag", 0) & 0x2) == 0) {}
          for (bool = true;; bool = false)
          {
            callJs(paramJsBridgeListener, new String[] { "{\"showFlag\":" + bool + "}" });
            return true;
          }
          if (!"setUniqueTitleNewFlag".equals(paramString3)) {
            break label866;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else
      {
        paramJsBridgeListener = this.mRuntime.getActivity().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin() + "_troopManager", 0);
        i = paramJsBridgeListener.getInt("uniqueTitleNewFlag", 0);
        paramJsBridgeListener.edit().putInt("uniqueTitleNewFlag", i | 0x2).commit();
        return true;
      }
    }
    catch (JSONException paramJsBridgeListener) {}
    if ("createDingdong".equals(paramString3))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("troopUin");
        if (paramJsBridgeListener == null) {
          break label2264;
        }
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          paramJsBridgeListener.printStackTrace();
          paramJsBridgeListener = null;
        }
      }
    }
    else
    {
      long l;
      if ("updateTroopBindedPubAccount".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          l = paramJsBridgeListener.getLong("troopPubAccountUin");
          paramJsBridgeListener = paramJsBridgeListener.getJSONArray("groupCodeList");
          j = paramJsBridgeListener.length();
          if (j > 0)
          {
            paramString1 = new long[j];
            i = 0;
            while (i < j)
            {
              paramString1[i] = paramJsBridgeListener.getLong(i);
              i += 1;
            }
            this.mClient.b(l, paramString1);
          }
          if (!QLog.isColorLevel()) {
            break label2264;
          }
          QLog.d("AccountDetailActivity.bindTroop", 2, "updateTroopBindedPubAccount:" + paramVarArgs[0]);
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label2264;
          }
        }
        QLog.e("AccountDetailActivity.bindTroop", 2, paramJsBridgeListener.toString());
      }
      else if ("getLastSpeakMessage".equals(paramString3))
      {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("groupCode");
          paramString1 = paramString2.optString("groupMemberUin");
          paramString2 = paramString2.optString("callback");
          this.mClient.a(paramJsBridgeListener, paramString1, new aoyf(this, paramString2));
          if (!QLog.isColorLevel()) {
            break label2264;
          }
          QLog.d("TroopWebviewPlugin", 2, "getLastSpeakMessage:" + paramVarArgs[0]);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else if ("openRecentChatView".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          Y(paramJsBridgeListener.optString("groupCode"), paramJsBridgeListener.optString("groupMemberUin"), paramJsBridgeListener.optInt("shielded"));
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else if ("notifyTroopEnterEffectStatus".equals(paramString3))
      {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          i = paramString1.optInt("effectId");
          j = paramString1.optInt("svipLevel");
          int k = paramString1.optInt("svipType");
          paramString1 = paramString1.optString("effectName");
          this.mClient.m(i, j, k, paramString1);
          super.callJs(paramJsBridgeListener, new String[] { "{\"ret\":0}" });
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else if ("returnToTroopAIO".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopWebviewPlugin", 2, "returnToTroopAIO:" + paramVarArgs[0]);
        }
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("gc");
          paramString1.printStackTrace();
        }
        catch (JSONException paramString1)
        {
          try
          {
            bool = TextUtils.isEmpty(paramJsBridgeListener);
            if (!bool) {
              break label1427;
            }
            return false;
          }
          catch (JSONException paramString1)
          {
            break label1423;
          }
          paramString1 = paramString1;
          paramJsBridgeListener = null;
        }
        label1423:
        label1427:
        if ("Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Sensor", 2, "meizu mx2 returnToTroopAIO");
          }
          new Handler().postDelayed(new TroopWebviewPlugin.2(this, paramJsBridgeListener), 400L);
          break label2264;
        }
        SensorAPIJavaScript.returnToAio(this.mClient, this.mRuntime.getActivity(), paramJsBridgeListener, true);
        break label2264;
      }
      else
      {
        if ("notifyCreateTroops".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString2.optString("groupCode");
            if (TextUtils.isEmpty(paramJsBridgeListener))
            {
              if (!QLog.isColorLevel()) {
                break label2266;
              }
              QLog.e(this.TAG, 2, "METHOD_NOTIFY_TROOP_CREATE uin empty");
              break label2266;
            }
            paramString1 = paramString2.optString("chat_type");
            paramString2 = paramString2.optString("callback");
            this.mClient.b(paramJsBridgeListener, paramString1, paramString2, this);
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (!QLog.isColorLevel()) {
              break label2264;
            }
          }
          QLog.e(this.TAG, 2, "METHOD_NOTIFY_TROOP_CREATE," + paramJsBridgeListener.toString(), paramJsBridgeListener);
          break label2264;
        }
        if ("notifySwitchStatus".equals(paramString3)) {
          for (;;)
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("callback");
              paramString2 = paramJsBridgeListener.optJSONArray("data");
              paramJsBridgeListener = "{\"ret\":0}";
              if ((paramString2 != null) && (paramString2.length() > 0))
              {
                paramString3 = new ArrayList();
                i = 0;
                if (i < paramString2.length())
                {
                  paramVarArgs = paramString2.getJSONObject(i);
                  paramString3.add(paramVarArgs.optString("groupCode") + "," + paramVarArgs.optInt("status"));
                  i += 1;
                  continue;
                }
                this.mClient.cA(paramString3);
                super.callJs(paramString1, new String[] { paramJsBridgeListener });
              }
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e(this.TAG, 1, "notifySwitchStatus error: " + paramJsBridgeListener.toString());
            }
            QLog.e(this.TAG, 1, "notifySwitchStatus dataArray is empty");
            paramJsBridgeListener = "{\"ret\":-1}";
          }
        }
        if ("updateTroopAnnouncement".equals(paramString3)) {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = null;
            paramString3 = this.mRuntime.getActivity();
            paramJsBridgeListener = paramString1;
            if (paramString3 != null)
            {
              paramJsBridgeListener = paramString1;
              if (paramString2.has("lastAnnouncement"))
              {
                paramJsBridgeListener = paramString1;
                if (paramString2.has("groupCode"))
                {
                  l = paramString2.optLong("groupCode");
                  paramJsBridgeListener = paramString2.optString("lastAnnouncement");
                  paramString1 = new Intent();
                  paramString1.putExtra("groupCode", l);
                  paramString1.putExtra("lastAnnouncement", paramJsBridgeListener);
                  paramString1.putExtra("updateFromWeb", true);
                  paramString3.setResult(-1, paramString1);
                }
              }
            }
            if (!QLog.isColorLevel()) {
              break label2264;
            }
            QLog.i(this.TAG, 2, String.format("updateTroopAnnouncement [%s, %s, %s]", new Object[] { paramJsBridgeListener, Boolean.valueOf(paramString2.has("lastAnnouncement")), paramString3 }));
          }
          catch (Throwable paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        if ("updateTroopAutoApprovalSetting".equals(paramString3)) {
          for (;;)
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = this.mRuntime.getActivity();
              j = -1;
              i = j;
              if (paramString1 != null)
              {
                i = j;
                if (paramJsBridgeListener.has("autoApprovalSetting"))
                {
                  i = j;
                  if (paramJsBridgeListener.has("groupCode"))
                  {
                    l = paramJsBridgeListener.optLong("groupCode");
                    i = paramJsBridgeListener.optInt("autoApprovalSetting");
                    paramString2 = new Intent();
                    paramString2.putExtra("groupCode", l);
                    if (i != 1) {
                      break label2251;
                    }
                    bool = true;
                    paramString2.putExtra("autoApprovalSetting", bool);
                    paramString2.putExtra("updateFromWeb", true);
                    paramString1.setResult(-1, paramString2);
                  }
                }
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i(this.TAG, 2, String.format("updateAutoApprovalSetting [%s, %s, %s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramJsBridgeListener.has("autoApprovalSetting")), paramString1 }));
            }
            catch (Throwable paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
            label2251:
            bool = false;
          }
        }
        return false;
      }
    }
    label2264:
    return true;
    label2266:
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    Object localObject2 = (BaseActivity)this.mRuntime.getActivity();
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              CA();
            } while ((paramIntent == null) || (paramInt != -1));
            paramByte = paramIntent.getIntExtra("retCode", -1);
            Object localObject1 = paramIntent.getStringExtra("troopUin");
            paramIntent = (Intent)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramIntent = "";
            }
            paramInt = apbc.e.jG(paramByte);
            if (paramInt != 0) {
              QQToast.a(this.mRuntime.getActivity(), paramInt, 0).show(((BaseActivity)localObject2).getTitleBarHeight());
            }
            localObject2 = new JSONObject();
            for (;;)
            {
              try
              {
                ((JSONObject)localObject2).put("result", paramByte);
                if (TextUtils.isEmpty(paramIntent)) {
                  continue;
                }
                localObject1 = paramIntent;
                ((JSONObject)localObject2).put("troopUin", localObject1);
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
                continue;
              }
              hR("onCreateGroupResult", ((JSONObject)localObject2).toString());
              if (paramByte != 0) {
                break;
              }
              this.cnu = paramIntent;
              return;
              localObject1 = "";
            }
          } while ((paramIntent == null) || (paramInt != -1));
          hR("onGroupInfoModified", paramIntent.getStringExtra("modifiedInfo"));
          return;
        } while ((paramIntent == null) || (paramInt != -1));
        this.dSg = paramIntent.getIntExtra("isBack", -1);
        return;
      } while (TextUtils.isEmpty(this.cnu));
      paramIntent = new Intent(this.mRuntime.getActivity(), TroopCreateLogicActivity.class);
      paramIntent.putExtra("type", 4);
      paramIntent.putExtra("troop_uin", this.cnu);
      startActivityForResult(paramIntent, (byte)42);
      return;
      paramIntent.getBooleanExtra("has_head", false);
      return;
    } while ((paramIntent == null) || (paramInt != -1));
    paramByte = paramIntent.getIntExtra("errCode", -1);
    boolean bool = paramIntent.getBooleanExtra("isClear", false);
    String str = paramIntent.getStringExtra("location");
    paramInt = paramIntent.getIntExtra("lat", 0);
    int i = paramIntent.getIntExtra("lon", 0);
    if (paramByte == 0)
    {
      if (bool) {
        QQToast.a((Context)localObject2, 2131721479, 0).show(((BaseActivity)localObject2).getTitleBarHeight());
      }
      for (;;)
      {
        paramIntent = new Intent();
        paramIntent.putExtra("location", str);
        paramIntent.putExtra("lat", paramInt);
        paramIntent.putExtra("lon", i);
        ((BaseActivity)localObject2).setResult(-1, paramIntent);
        ((BaseActivity)localObject2).finish();
        return;
        QQToast.a((Context)localObject2, 2131721484, 0).show(((BaseActivity)localObject2).getTitleBarHeight());
      }
    }
    if (paramByte == 1002) {
      paramIntent = ((BaseActivity)localObject2).getString(2131721492);
    }
    for (;;)
    {
      QQToast.a((Context)localObject2, paramIntent, 0).show(((BaseActivity)localObject2).getTitleBarHeight());
      return;
      if (bool) {
        paramIntent = ((BaseActivity)localObject2).getString(2131721478);
      } else {
        paramIntent = ((BaseActivity)localObject2).getString(2131721483);
      }
    }
  }
  
  public void onCreate()
  {
    this.mFrom = this.mRuntime.getActivity().getIntent().getIntExtra("troop_create_from", 0);
    if (this.mFrom != 0) {
      this.mRuntime.getActivity().setResult(-1);
    }
    if (this.ac.compareAndSet(false, true))
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
  }
  
  public void onDestroy()
  {
    if (((this.mFrom == 0) || (this.mFrom == 4)) || (this.ac.get())) {
      this.mClient.bzk();
    }
    if (this.aC != null)
    {
      this.aC.dismiss();
      this.aC = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoye
 * JD-Core Version:    0.7.0.1
 */