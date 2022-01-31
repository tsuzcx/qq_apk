package com.tencent.mobileqq.horn;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class HornJsPlugin
  extends VasWebviewJsPlugin
{
  public static String a;
  public static final String b = "horn";
  public static final String c = "report";
  public static final String d = "notifyCommentHorn";
  public static final String e = "0";
  public static final String f = "-2";
  public static final String g = "-1";
  public static final String h = "CommentHorn";
  public static final String i = "MyCommentHorn";
  public AppInterface a;
  public JsBridgeListener a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "HornJsPlugin";
  }
  
  public HornJsPlugin()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  protected long getPluginBusiness()
  {
    return 2147549184L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewpluginJsBridgeListener = paramJsBridgeListener;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null) || (!"horn".equals(paramString2))) {
      return false;
    }
    if ("horn".equals(paramString2))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if (paramJsBridgeListener == null) {
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "Failed to parse json str,json=" + null);
          }
          paramJsBridgeListener = null;
        }
      }
      if (!"notifyCommentHorn".equals(paramString3)) {}
    }
    try
    {
      paramString1 = paramJsBridgeListener.getJSONObject("params");
      paramJsBridgeListener = paramString1.getString("hornKey");
      int j = paramString1.getInt("commentCnt");
      paramString1 = new Bundle();
      paramString1.putString("hornKey", paramJsBridgeListener);
      paramString1.putInt("commentCnt", j);
      sendRemoteReq(DataFactory.makeIPCRequestPacket("notifyCommentCnt", "", this.mOnRemoteResp.key, paramString1), true, false);
      return true;
    }
    catch (Exception paramJsBridgeListener)
    {
      do
      {
        for (;;)
        {
          paramJsBridgeListener.printStackTrace();
        }
      } while (!"report".equals(paramString3));
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        try
        {
          paramString1 = paramJsBridgeListener.optString("operName");
          paramString2 = paramJsBridgeListener.optString("callback");
          if (paramString2.equals(""))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i(jdField_a_of_type_JavaLangString, 2, "invalid callback,callback=" + paramString2);
            continue;
          }
          if (paramString1.equals(""))
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "invalid operName, operName=" + paramString1);
            }
            callJs(paramString2, new String[] { "-1" });
            continue;
          }
          if ((paramJsBridgeListener.has("isSvip")) && (paramJsBridgeListener.has("hasPriviledge")))
          {
            ReportController.b(null, "P_CliOper", "Svip", "", "Vip_nearby", paramString1, 0, 0, "isSvip", "" + paramJsBridgeListener.getInt("isSvip"), "hasPriviledge", "" + paramJsBridgeListener.getInt("hasPriviledge"));
            callJs(paramString2, new String[] { "0" });
            continue;
          }
          ReportController.b(null, "P_CliOper", "Svip", "", "Vip_nearby", paramString1, 0, 0, "", "", "", "");
          continue;
          return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
        }
        catch (Exception paramJsBridgeListener) {}
        paramJsBridgeListener = paramJsBridgeListener;
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.horn.HornJsPlugin
 * JD-Core Version:    0.7.0.1
 */