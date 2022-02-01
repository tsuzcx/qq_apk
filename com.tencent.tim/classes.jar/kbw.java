import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class kbw
  extends WebViewPlugin
{
  public Bundle mReqBundle;
  
  public kbw()
  {
    this.mPluginNameSpace = "PublicAccountJs";
  }
  
  private int getInt(Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (!TextUtils.isEmpty(paramMap)) {}
    try
    {
      i = Integer.parseInt(paramMap);
      return i;
    }
    catch (Exception paramMap) {}
    return paramInt;
  }
  
  private String getString(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    paramMap = (String)paramMap.get(paramString1);
    if (paramMap == null) {
      return paramString2;
    }
    return paramMap;
  }
  
  private void lO(String paramString)
  {
    paramString = aurr.getArgumentsFromURL(paramString);
    String str1 = getString(paramString, "sub_action", "");
    String str2 = getString(paramString, "action_name", "");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountWebviewPlugin", 2, "subAction[" + str1 + "] or actionName[" + str2 + "] null");
      }
      return;
    }
    anot.a(null, getString(paramString, "tag", "P_CliOper"), getString(paramString, "main_action", "Pb_account_lifeservice"), getString(paramString, "to_uin", ""), str1, str2, getInt(paramString, "from_type", 0), getInt(paramString, "result", 0), getString(paramString, "r2", ""), getString(paramString, "r3", ""), getString(paramString, "r4", ""), getString(paramString, "r5", ""));
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("setShopFolderMsg".equals(paramString3)) {}
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString1.optString("msg");
      int i = paramString1.optInt("type");
      paramString1 = new Intent("action_folder_msg_change");
      paramString1.putExtra("msg", paramJsBridgeListener);
      paramString1.putExtra("type", i);
      this.mRuntime.getActivity().sendBroadcast(paramString1);
      for (;;)
      {
        label75:
        return true;
        if ("onShopMsgClick".equals(paramString3))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString1 = paramString1.optString("uin");
            paramString2 = this.mRuntime.getActivity();
            if ((!(paramString2 instanceof EcshopWebActivity)) || (TextUtils.isEmpty(paramJsBridgeListener))) {
              continue;
            }
            ((EcshopWebActivity)paramString2).lW(paramString1);
            paramString1 = new JSONObject();
            paramString1.put("ret", 0);
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          catch (Exception paramJsBridgeListener) {}
        }
        else if ("getShopFirstMsg".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
            paramString1 = this.mRuntime.getActivity();
            if ((!(paramString1 instanceof EcshopWebActivity)) || (TextUtils.isEmpty(paramJsBridgeListener))) {
              continue;
            }
            paramString1 = (EcshopWebActivity)paramString1;
            paramString2 = new JSONObject();
            if ((paramString1.gb != null) && (!paramString1.gb.isEmpty()))
            {
              paramString3 = (RecentShopParcel)paramString1.gb.get(0);
              paramVarArgs = new JSONObject();
              if ((paramString3 != null) && (paramString3.unReadNum > 0) && (paramString3.lastMsgTime >= paramString1.rQ) && (paramString3.lastMsgTime > paramString3.rR))
              {
                paramVarArgs.put("uin", paramString3.puin);
                paramVarArgs.put("msg", paramString3.msg);
                paramVarArgs.put("nick", paramString3.nickName);
                paramString2.put("data", paramVarArgs);
              }
            }
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          catch (Exception paramJsBridgeListener) {}
        }
        else if (TextUtils.equals("socialize_feeds_update", paramString3))
        {
          try
          {
            this.mReqBundle.clear();
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.getString("feeds_id");
            paramString1 = paramString1.optString("feeds_type", "1");
            this.mReqBundle.putLong("feeds_id", Long.valueOf(paramJsBridgeListener).longValue());
            this.mReqBundle.putInt("feeds_type", Integer.valueOf(paramString1).intValue());
            sendRemoteReq(affz.a("ipc_kandian_socialfeeds_update", "", -1, this.mReqBundle), false, false);
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.d("PublicAccountWebviewPlugin", 1, "handle socialize_feeds_update response failed ", paramJsBridgeListener);
          }
        }
        else if ("toggleFolderList".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            i = paramJsBridgeListener.optInt("y_offset");
            boolean bool = paramJsBridgeListener.optBoolean("show_list");
            paramJsBridgeListener = this.mRuntime.getActivity();
            if (!(paramJsBridgeListener instanceof EcshopWebActivity)) {
              continue;
            }
            paramJsBridgeListener = ((EcshopWebActivity)paramJsBridgeListener).c();
            if (!(paramJsBridgeListener instanceof ShopWebViewFragment)) {
              continue;
            }
            if (!bool) {
              break label613;
            }
            ((ShopWebViewFragment)paramJsBridgeListener).cm(1, i);
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          continue;
          label613:
          ((ShopWebViewFragment)paramJsBridgeListener).cm(0, 0);
        }
        else if ("showRedDot".equals(paramString3))
        {
          try
          {
            i = new JSONObject(paramVarArgs[0]).optInt("reddot");
            paramJsBridgeListener = this.mRuntime.getActivity();
            if (!(paramJsBridgeListener instanceof EcshopWebActivity)) {
              continue;
            }
            paramJsBridgeListener = ((EcshopWebActivity)paramJsBridgeListener).c();
            if (!(paramJsBridgeListener instanceof ShopWebViewFragment)) {
              continue;
            }
            ((ShopWebViewFragment)paramJsBridgeListener).oy(i);
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        else if ("getShopPushInfo".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
            paramString1 = this.mRuntime.getActivity();
            if ((paramString1 instanceof EcshopWebActivity))
            {
              paramString1 = paramString1.getIntent().getBundleExtra("bundle");
              paramString2 = new JSONObject();
              paramString2.put("taskId", paramString1.getInt("PUSH_TASK_ID"));
              paramString2.put("folderMsg", paramString1.getString("str_ecshop_diy"));
              paramString2.put("taskType", paramString1.getInt("PUSH_TASK_TYPE"));
              paramString2.put("taskInfo", paramString1.getString("PUSH_TASK_INFO"));
              paramString2.put("receiveTs", paramString1.getLong("PUSH_RECEIVE_TIME"));
              callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e("PublicAccountWebviewPlugin", 1, "getShopPushInfo error:", paramJsBridgeListener);
          }
        }
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      break label75;
    }
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString2))
    {
      bool1 = bool2;
      if (paramString2.equals("publicaccount"))
      {
        bool1 = bool2;
        if (paramString1 != null)
        {
          bool1 = bool2;
          if (paramString1.contains("/report?"))
          {
            lO(paramString1);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!afjy.a().ajq())
    {
      if (paramBoolean2) {}
      return;
    }
    if (paramBoolean1)
    {
      afjy.a().cr(paramBundle);
      return;
    }
    afjy.a().cq(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbw
 * JD-Core Version:    0.7.0.1
 */