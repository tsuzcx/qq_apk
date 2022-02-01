import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class aiei
  extends WebViewPlugin
{
  public long DM;
  private long Sj;
  private aica jdField_b_of_type_Aica;
  private aidu jdField_b_of_type_Aidu;
  private IVPluginDataReporter jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter;
  private String bNp;
  public String bNq;
  public String bNr;
  private BroadcastReceiver bo;
  public String hC;
  protected Context mContext;
  private int mCurrentState;
  public String mNickName;
  private Handler mUIHandler;
  public long mUin;
  private String pluginPackageName;
  
  private void a(int paramInt, long paramLong, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      localJSONObject.put("seqid", paramLong);
      if (paramString2 != null) {
        localJSONObject.put("msg", paramString2);
      }
      if (paramJSONObject != null) {
        localJSONObject.put("data", paramJSONObject);
      }
      log("invoke jscallback " + localJSONObject.toString());
      callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString1)
    {
      log("invoke callback error " + paramString1.getLocalizedMessage());
    }
  }
  
  private void aw(long paramLong, String paramString)
  {
    String str = Environment.getExternalStorageDirectory().getPath() + "/tencent/huiyin";
    if (!new File(str).exists()) {
      new File(str).mkdir();
    }
    this.jdField_b_of_type_Aidu.a(str + "/av_" + System.currentTimeMillis() + this.jdField_b_of_type_Aidu.wO(), new aiek(this));
    this.Sj = System.currentTimeMillis();
    this.mCurrentState = 0;
    a(0, paramLong, paramString, null, null);
  }
  
  private void ax(long paramLong, String paramString)
  {
    this.jdField_b_of_type_Aidu.StopRecording();
    this.mCurrentState = 1;
    a(0, paramLong, paramString, null, null);
  }
  
  private void ay(long paramLong, String paramString)
  {
    int i = this.jdField_b_of_type_Aidu.FA();
    if (this.mCurrentState == 0) {}
    for (long l = System.currentTimeMillis() - this.Sj;; l = 0L) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("volume", i);
        localJSONObject.put("duration", l);
        localJSONObject.put("state", this.mCurrentState);
        localJSONObject.put("seqid", paramLong);
        a(0, paramLong, paramString, null, localJSONObject);
        return;
      }
      catch (JSONException paramString) {}
    }
  }
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Huiyin", 2, paramString);
    }
  }
  
  private void r(long paramLong, String paramString1, String paramString2)
  {
    str5 = "unknown";
    String str4 = "https://huiyin.qq.com/cgi-bin/mozart/upload_user_voice";
    String str3 = "0";
    Log.i("Huiyin", "do real upload begin...");
    localObject2 = str3;
    str1 = str4;
    try
    {
      localJSONObject = new JSONObject(paramString2);
      localObject2 = str3;
      str1 = str4;
      localObject1 = str4;
      if (!localJSONObject.has("uploadUrl")) {
        break label502;
      }
      localObject2 = str3;
      str1 = str4;
      localObject1 = localJSONObject.getString("uploadUrl");
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        Object localObject1;
        try
        {
          JSONObject localJSONObject;
          str1 = URLEncoder.encode(this.mNickName, "UTF-8");
          aidw.a(paramString2, this.bNp, String.valueOf(this.DM), this.hC, str1, (String)localObject1, String.valueOf(this.mUin), this.bNq, new aiel(this, paramLong, paramString1));
          return;
          paramString2 = paramString2;
          localObject1 = localObject2;
          paramString2 = str1;
          continue;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
          String str2 = str5;
          continue;
        }
        paramString2 = (String)localObject1;
        if (localObject1 == null) {
          paramString2 = "https://huiyin.qq.com/cgi-bin/mozart/upload_user_voice";
        }
      }
    }
    localObject1 = str3;
    localObject2 = str3;
    str1 = paramString2;
    if (localJSONObject.has("gender"))
    {
      localObject2 = str3;
      str1 = paramString2;
      localObject1 = localJSONObject.getString("gender");
    }
    localObject2 = localObject1;
    str1 = paramString2;
    if (localJSONObject.has("tinyID"))
    {
      localObject2 = localObject1;
      str1 = paramString2;
      this.DM = Long.parseLong(localJSONObject.getString("tinyID"));
      localObject2 = localObject1;
      str1 = paramString2;
      QLog.d("Huiyin", 2, "tinyID: " + this.DM);
    }
    localObject2 = localObject1;
    str1 = paramString2;
    if (localJSONObject.has("a2"))
    {
      localObject2 = localObject1;
      str1 = paramString2;
      this.hC = localJSONObject.getString("a2");
      localObject2 = localObject1;
      str1 = paramString2;
      QLog.d("Huiyin", 2, "a2: " + this.hC);
    }
    localObject2 = localObject1;
    str1 = paramString2;
    if (localJSONObject.has("uid"))
    {
      localObject2 = localObject1;
      str1 = paramString2;
      this.mUin = Long.parseLong(localJSONObject.getString("uid"));
      localObject2 = localObject1;
      str1 = paramString2;
      QLog.d("Huiyin", 2, "uin: " + this.mUin);
    }
    localObject2 = localObject1;
    str1 = paramString2;
    if (localJSONObject.has("voice_word"))
    {
      localObject2 = localObject1;
      str1 = paramString2;
      this.bNq = localJSONObject.getString("voice_word");
      localObject2 = localObject1;
      str1 = paramString2;
      QLog.d("Huiyin", 2, "voice_word: " + this.bNq);
    }
  }
  
  void eP(String paramString, int paramInt)
  {
    aiem.a.redDotNum = -1;
    if (paramString == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("redNum", paramInt);
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"huiyin".equals(paramString2)) {}
    do
    {
      return false;
      paramString2 = new StringBuilder().append("huiyin handleJsRequest: method:").append(paramString3).append(" args:");
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        paramJsBridgeListener = paramVarArgs[0];
      }
      for (;;)
      {
        log(paramJsBridgeListener);
        long l1 = 0L;
        paramString1 = Uri.parse(paramString1);
        for (;;)
        {
          try
          {
            long l2 = Long.valueOf(paramString1.getQueryParameter("seqid")).longValue();
            l1 = l2;
          }
          catch (Exception paramJsBridgeListener)
          {
            continue;
          }
          try
          {
            paramJsBridgeListener = paramString1.getQueryParameter("callback");
            if ("startRecord".equals(paramString3))
            {
              aw(l1, paramJsBridgeListener);
              return false;
              paramJsBridgeListener = "";
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener = null;
            continue;
            if ("stopRecord".equals(paramString3))
            {
              ax(l1, paramJsBridgeListener);
              return false;
            }
            if ("queryRecordState".equals(paramString3))
            {
              ay(l1, paramJsBridgeListener);
              return false;
            }
            if ("uploadRecord".equals(paramString3)) {
              try
              {
                paramString1 = URLDecoder.decode(paramString1.getQueryParameter("param"), "UTF-8");
                Log.i("Huiyin", "upload extra " + paramString1);
                r(l1, paramJsBridgeListener, paramString1);
                return false;
              }
              catch (Exception paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
                return false;
              }
            }
            if ("start".equals(paramString3))
            {
              aqmj.fB(this.mRuntime.a().getApp().getApplicationContext());
              aiem.a.f(this.mRuntime.a(), paramString1.getQueryParameter("p"));
              eP(this.bNr, 0);
              this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("huiyin").opName("huiyin_click").report();
              aiem.a.cG(0, null);
              return false;
            }
            if ("requestRedNum".equals(paramString3))
            {
              aiem.a.g(this.mRuntime.a(), paramString1.getQueryParameter("p"));
              this.bNr = paramJsBridgeListener;
              if (aiem.a.redDotNum != -1)
              {
                eP(this.bNr, aiem.a.redDotNum);
                return false;
              }
              aiem.a.a(this.mRuntime.a(), new aiej(this));
              return false;
            }
          }
        }
      }
    } while (!"registerOk".equals(paramString3));
    aiem.a.ckg = false;
    aiem.a.cG(11, null);
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mContext = this.mRuntime.getActivity().getApplicationContext();
    log(" onCreate");
    this.jdField_b_of_type_Aidu = new aidu(this.mContext, 1);
    this.jdField_b_of_type_Aica = new aica();
    this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("huiyin");
    IntentFilter localIntentFilter = new IntentFilter(aidi.lu(this.pluginPackageName));
    localIntentFilter.addAction(aidi.lv(this.pluginPackageName));
    localIntentFilter.addAction(aidi.lw(this.pluginPackageName));
    localIntentFilter.addAction(aidi.lx(this.pluginPackageName));
    this.mContext.registerReceiver(this.bo, localIntentFilter);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mContext.unregisterReceiver(this.bo);
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Aidu.Fz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiei
 * JD-Core Version:    0.7.0.1
 */