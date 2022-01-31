package com.tencent.mobileqq.maproam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.maproam.activity.RoamingActivity;
import com.tencent.mobileqq.maproam.data.PersonalInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RoamMapJsPlugin
  extends VasWebviewJsPlugin
{
  public static String a;
  public static final String b = "RoamMapJsPlugin";
  public static final String c = "jumpToPersonalCard";
  public static final String d = "getRandomRoamResult";
  public static final String e = "getServeralPerson";
  public static final String f = "openSuperMapRoam";
  public static final String g = "lat";
  public static final String h = "lon";
  public static final String i = "lEctID";
  public static final String j = "enc_id";
  public static final String k = "uid";
  public static final String l = "seg";
  public static final String m = "code";
  public static final String n = "list";
  public static final String o = "a2key";
  public static final String p = "0";
  public static final String q = "1";
  private static final String r = "count";
  public Context a;
  public AppInterface a;
  public JsBridgeListener a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "RoamMapJsPlugin";
  }
  
  public RoamMapJsPlugin()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  protected long getPluginBusiness()
  {
    return 2147485696L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewpluginJsBridgeListener = paramJsBridgeListener;
    ArrayList localArrayList = new ArrayList(Arrays.asList(paramVarArgs));
    if ("RoamMapJsPlugin".equals(paramString2))
    {
      if ("getRandomRoamResult".equals(paramString3)) {
        paramJsBridgeListener = (String)localArrayList.get(0);
      }
      for (;;)
      {
        int i1;
        int i2;
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
          i1 = 0;
          i2 = 0;
          if (paramJsBridgeListener.has("lat")) {
            i1 = (int)(1000000.0D * paramJsBridgeListener.getDouble("lat"));
          }
          if (paramJsBridgeListener.has("lon")) {
            i2 = (int)(1000000.0D * paramJsBridgeListener.getDouble("lon"));
          }
          paramJsBridgeListener = new Intent(this.jdField_a_of_type_AndroidContentContext, RoamingActivity.class);
          paramJsBridgeListener.putExtra("lat", i1);
          paramJsBridgeListener.putExtra("lon", i2);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          continue;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          continue;
        }
        return true;
        if ("jumpToPersonalCard".equals(paramString3))
        {
          ReportController.b(null, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_webConversation", 0, 0, "", "", "", "");
          paramJsBridgeListener = (String)localArrayList.get(0);
          try
          {
            paramString3 = new JSONObject(paramJsBridgeListener);
            paramString2 = paramString3.optString("lEctID", "");
            paramJsBridgeListener = paramString3.optString("enc_id", "");
            paramString1 = paramString3.optString("uid", "");
            paramString3 = paramString3.optString("seg", "");
            paramString2 = new ProfileActivity.AllInOne(paramString2, 41);
            paramString3 = paramString3.substring(1, paramString3.length() - 1).split(",");
            paramVarArgs = new byte[paramString3.length];
            if (paramString3.length > 1)
            {
              i1 = 0;
              i2 = paramVarArgs.length;
              while (i1 < i2)
              {
                paramVarArgs[i1] = Byte.valueOf(paramString3[i1].trim()).byteValue();
                i1 += 1;
              }
            }
            paramString2.a = paramVarArgs;
            paramString2.n = paramJsBridgeListener;
            paramString2.o = paramString1;
            paramString2.e = 102;
            paramString2.f = 5;
            ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, paramString2);
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        else if ("getServeralPerson".equals(paramString3))
        {
          paramJsBridgeListener = (String)localArrayList.get(0);
          try
          {
            paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
            i1 = 0;
            i2 = 0;
            int i3 = 0;
            if (paramJsBridgeListener.has("lat")) {
              i1 = (int)(1000000.0D * paramJsBridgeListener.getDouble("lat"));
            }
            if (paramJsBridgeListener.has("lon")) {
              i2 = (int)(1000000.0D * paramJsBridgeListener.getDouble("lon"));
            }
            if (paramJsBridgeListener.has("count")) {
              i3 = paramJsBridgeListener.getInt("count");
            }
            if (NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
            {
              paramJsBridgeListener = new Bundle();
              paramJsBridgeListener.putInt("lat", i1);
              paramJsBridgeListener.putInt("lon", i2);
              paramJsBridgeListener.putInt("count", i3);
              paramJsBridgeListener = DataFactory.makeIPCRequestPacket("getRoamEncounter", "callback", this.mOnRemoteResp.key, paramJsBridgeListener);
              WebIPCOperator.getInstance().sendServiceIpcReq(paramJsBridgeListener);
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            continue;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i(jdField_a_of_type_JavaLangString, 2, "network is unsupport, method = getServeralPerson");
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        else if ("openSuperMapRoam".equals(paramString3))
        {
          ReportController.b(null, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_enterSuperRoam", 0, 0, "", "", "", "");
          paramJsBridgeListener = new Intent(this.jdField_a_of_type_AndroidContentContext, RoamingActivity.class);
          paramJsBridgeListener.putExtra("lat", -2147483648);
          paramJsBridgeListener.putExtra("lon", -2147483648);
          paramJsBridgeListener.putExtra("mode", 1);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramJsBridgeListener);
        }
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
  }
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject1;
    Object localObject2;
    int i1;
    int i2;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject1 = paramBundle.getString("cmd");
      localObject2 = paramBundle.getBundle("response");
      if ((localObject1 != null) && (((String)localObject1).equals("getRoamEncounter")))
      {
        paramBundle = (List)((Bundle)localObject2).getSerializable("list");
        i1 = ((Bundle)localObject2).getInt("lat", 0);
        i2 = ((Bundle)localObject2).getInt("lon", 0);
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        localObject1 = new JSONArray();
        if (paramBundle != null)
        {
          ((JSONObject)localObject2).put("code", "0");
          Iterator localIterator = paramBundle.iterator();
          if (localIterator.hasNext())
          {
            PersonalInfo localPersonalInfo = (PersonalInfo)localIterator.next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("lEctID", localPersonalInfo.lEctID);
            localJSONObject.put("enc_id", localPersonalInfo.enc_id);
            localJSONObject.put("uid", localPersonalInfo.uid);
            localJSONObject.put("seg", localPersonalInfo.seg);
            ((JSONArray)localObject1).put(localJSONObject);
            continue;
          }
        }
        ((JSONObject)localObject2).put("code", "1");
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "return encounterDataSuccess, lat =" + i1 + ", lon = " + i2 + ", count = " + paramBundle.size() + ", uin = " + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
        }
        ((JSONObject)localObject2).put("list", localObject1);
        paramBundle = (WtloginManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(1);
        if (paramBundle == null) {
          break label487;
        }
        localObject1 = HexUtil.bytes2HexStr(WtloginHelper.GetTicketSig(paramBundle.GetLocalSig(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), 16L), 64));
        paramBundle = (Bundle)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "a2 = " + (String)localObject1);
          paramBundle = (Bundle)localObject1;
        }
        ((JSONObject)localObject2).put("a2key", paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqWebviewpluginJsBridgeListener.a(localObject2);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "return encounterDataFail lat =" + i1 + ", lon = " + i2 + ", uin = " + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
        continue;
        label487:
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.RoamMapJsPlugin
 * JD-Core Version:    0.7.0.1
 */