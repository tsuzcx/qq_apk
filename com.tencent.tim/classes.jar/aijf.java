import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.activity.QQIdentiferLegacyActivity;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPluginProxyActivity;
import cooperation.troop.TroopBaseProxyActivity;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class aijf
  extends WebViewPlugin
{
  public static final String bOd = acfp.m(2131707355);
  public static final String bOe = acfp.m(2131707354);
  private static final String bOf = acfp.m(2131707360);
  public static final String bOg = acfp.m(2131707363);
  private static final String bOh = acfp.m(2131707359);
  private Dialog X;
  private long abD;
  private Activity activity;
  private int appId;
  private String bMz;
  private int dcQ;
  private AtomicBoolean dj = new AtomicBoolean(false);
  private String key;
  private String mCallback;
  private int mServiceType;
  private String method;
  private String name;
  private String openId;
  private String ticket;
  private String uin;
  
  public aijf()
  {
    this.mPluginNameSpace = "identification";
  }
  
  private void Lt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        this.dcQ = paramString.optInt("platformAppId", 0);
        this.abD = paramString.optLong("nonce");
        this.appId = paramString.optInt("srcAppId", 0);
        this.openId = paramString.optString("srcOpenId", "");
        this.key = paramString.optString("key", "");
        this.bMz = paramString.optString("idNum", "");
        this.name = paramString.optString("name", "");
        this.mCallback = paramString.optString("callback", "");
        this.mServiceType = paramString.optInt("serviceType", -1);
        this.ticket = paramString.optString("ticket", "");
        this.uin = paramString.optString("uin", "");
        if ((this.dcQ == 0) || (this.appId == 0) || (TextUtils.isEmpty(this.key)))
        {
          if (((this.method == null) || ("identify".equals(this.method))) && ((TextUtils.isEmpty(this.name)) || (TextUtils.isEmpty(this.mCallback)))) {
            continue;
          }
          QLog.e("IdentificationApiPlugin", 1, "empty param");
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("IdentificationApiPlugin", 1, paramString, new Object[0]);
        return;
      }
    }
    if (Build.VERSION.SDK_INT < 18)
    {
      paramString = new JSONObject();
      paramString.put("ret", 203);
      paramString.put("errMsg", bOf);
      bg(paramString);
      QLog.e("IdentificationApiPlugin", 1, "sdk version < 18");
      return;
    }
    if (((this.activity instanceof QQBrowserActivity)) && (((QQBrowserActivity)this.activity).isInMultiWindow()))
    {
      paramString = new JSONObject();
      paramString.put("ret", 206);
      paramString.put("errMsg", bOe);
      bg(paramString);
      QLog.e("IdentificationApiPlugin", 1, "current activity is QQBrowserActivity, mode is in multi window");
      return;
    }
    if (((this.activity instanceof QWalletPluginProxyActivity)) && (Build.VERSION.SDK_INT >= 24) && (this.activity.isInMultiWindowMode()))
    {
      paramString = new JSONObject();
      paramString.put("ret", 206);
      paramString.put("errMsg", bOe);
      bg(paramString);
      QLog.e("IdentificationApiPlugin", 1, "current activity is QWalletPluginProxyActivity, mode is in multi window");
      return;
    }
    if (QIPCClientHelper.getInstance().getClient().callServer("IdentificationIpcServer_Model", "action_is_video_chatting", null).code == 1)
    {
      paramString = new JSONObject();
      paramString.put("ret", 204);
      paramString.put("errMsg", bOd);
      bg(paramString);
      QLog.e("IdentificationApiPlugin", 1, "current mode is video chatting");
      return;
    }
    if (this.dj.get())
    {
      paramString = new JSONObject();
      paramString.put("ret", 212);
      paramString.put("errMsg", bOh);
      bg(paramString);
      QLog.e("IdentificationApiPlugin", 1, "current operate is running");
      return;
    }
    dsI();
  }
  
  private void bSZ()
  {
    if ((this.activity == null) || (this.activity.isFinishing())) {
      QLog.e("IdentificationApiPlugin", 1, "dismissLoadingView activity is null or activity is null");
    }
    while (this.X == null) {
      return;
    }
    this.X.cancel();
  }
  
  private void bg(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    if (("loginVerify".equals(this.method)) || ("changeSecureMobile".equals(this.method)))
    {
      if ((paramJSONObject != null) && (paramJSONObject.has("errMsg")) && (this.activity != null))
      {
        QLog.d("IdentificationApiPlugin", 1, new Object[] { "jsonObject is ", paramJSONObject.toString(), " method is ", this.method });
        QQToast.a(this.activity, paramJSONObject.optString("errMsg"), 0).show();
        return;
      }
      if (this.activity == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramJSONObject == null) {
          bool2 = true;
        }
        QLog.e("IdentificationApiPlugin", 1, new Object[] { "activity is null ? ", Boolean.valueOf(bool1), " jsonObject is null ? ", Boolean.valueOf(bool2) });
        return;
      }
    }
    callJs(this.mCallback, new String[] { paramJSONObject.toString() });
  }
  
  private void dsI()
  {
    if (("loginVerify".equals(this.method)) || ("changeSecureMobile".equals(this.method)))
    {
      showLoadingView();
      aiak.a(this.activity, this.key, this.method, this.uin, this.abD, this.appId, new aijg(this));
      return;
    }
    this.dj.set(true);
    Intent localIntent = new Intent(this.activity, QQIdentiferLegacyActivity.class);
    localIntent.putExtra("platformAppId", this.dcQ);
    localIntent.putExtra("srcAppId", this.appId);
    localIntent.putExtra("srcOpenId", this.openId);
    localIntent.putExtra("key", this.key);
    localIntent.putExtra("method", this.method);
    if ("identify".equals(this.method))
    {
      localIntent.putExtra("idNum", this.bMz);
      localIntent.putExtra("name", this.name);
    }
    if ("loginVerify".equals(this.method))
    {
      localIntent.putExtra("uin", this.uin);
      localIntent.putExtra("nonce", this.abD);
    }
    localIntent.putExtra("serviceType", this.mServiceType);
    startActivityForResult(localIntent, (byte)2);
  }
  
  private void dy(Intent paramIntent)
  {
    Intent localIntent = new Intent(this.activity, QQIdentiferActivity.class);
    localIntent.putExtra("platformAppId", this.dcQ);
    localIntent.putExtra("srcAppId", this.appId);
    localIntent.putExtra("srcOpenId", this.openId);
    localIntent.putExtra("key", this.key);
    localIntent.putExtra("method", this.method);
    if ("identify".equals(this.method))
    {
      localIntent.putExtra("idNum", this.bMz);
      localIntent.putExtra("name", this.name);
    }
    if ("loginVerify".equals(this.method))
    {
      localIntent.putExtra("uin", this.uin);
      localIntent.putExtra("ticket", this.ticket);
    }
    localIntent.putExtra("serviceType", this.mServiceType);
    if ((paramIntent != null) && (paramIntent.getSerializableExtra("FaceRecognition.AppConf") != null))
    {
      paramIntent = (FaceDetectForThirdPartyManager.AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf");
      localIntent.putExtra("FaceRecognition.AppConf", paramIntent);
      localIntent.putExtra("key_identification_type", paramIntent.mode);
    }
    startActivityForResult(localIntent, (byte)1);
  }
  
  private void o(Intent paramIntent, int paramInt)
  {
    JSONObject localJSONObject;
    Object localObject2;
    Object localObject1;
    if (!TextUtils.isEmpty(this.mCallback))
    {
      localJSONObject = new JSONObject();
      localObject2 = "";
      localObject1 = localObject2;
      if (paramIntent != null)
      {
        localObject1 = localObject2;
        if (paramIntent.hasExtra("allResults"))
        {
          localObject2 = paramIntent.getStringExtra("allResults");
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (((String)localObject2).endsWith("|")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
          }
        }
      }
    }
    else
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("identificationPlugin invokeCallback intent=");
          if (paramIntent == null)
          {
            localObject2 = "true";
            localObject2 = localStringBuilder.append((String)localObject2);
            if ((paramIntent != null) && (paramIntent.hasExtra("data"))) {
              ((StringBuilder)localObject2).append(" has_key_data=").append("true");
            }
            ((StringBuilder)localObject2).append(" resultCode=").append(paramInt);
            QLog.d("IdentificationApiPlugin", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          if (paramIntent == null) {
            break label422;
          }
        }
        try
        {
          if (paramIntent.hasExtra("data"))
          {
            paramIntent = paramIntent.getBundleExtra("data");
            paramInt = paramIntent.getInt("ret", 299);
            localJSONObject.put("ret", paramInt);
            localJSONObject.put("errMsg", paramIntent.getString("errMsg", acfp.m(2131707362)));
            localJSONObject.put("idKey", paramIntent.getString("idKey"));
            localJSONObject.put("allResults", localObject1);
          }
          for (;;)
          {
            anot.a(null, "dc00898", "", "", "0X8009862", "0X8009862", 0, 0, this.mServiceType + "", "", this.appId + "", paramInt + "");
            if (QLog.isColorLevel()) {
              QLog.d("IdentificationApiPlugin", 2, "native invoke web ret:" + paramInt + " all_results:" + (String)localObject1);
            }
            callJs(this.mCallback, new String[] { localJSONObject.toString() });
            return;
            localObject2 = "false";
            break;
            label422:
            if (paramInt == 0)
            {
              localJSONObject.put("ret", 201);
              localJSONObject.put("errMsg", bOg);
              localJSONObject.put("allResults", localObject1);
              paramInt = 201;
            }
            else
            {
              localJSONObject.put("ret", 299);
              localJSONObject.put("errMsg", acfp.m(2131707361));
              localJSONObject.put("allResults", localObject1);
              paramInt = 299;
            }
          }
        }
        catch (JSONException paramIntent)
        {
          QLog.e("IdentificationApiPlugin", 1, paramIntent, new Object[0]);
          return;
        }
      }
    }
  }
  
  private Activity r()
  {
    for (Activity localActivity = this.mRuntime.getActivity(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void showLoadingView()
  {
    if ((this.activity == null) || (this.activity.isFinishing()))
    {
      QLog.e("IdentificationApiPlugin", 1, "showLoadingView activity is null or is finish");
      return;
    }
    if (this.X == null)
    {
      this.X = TroopBaseProxyActivity.a(this.activity);
      this.X.findViewById(2131372861).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.X.findViewById(2131373180);
      localTextView.setSingleLine();
      localTextView.setPadding(15, 0, 15, 0);
      localTextView.setText("请稍等...");
    }
    this.X.show();
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ("identification".equals(paramString2))
    {
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if (("identify".equals(paramString3)) || ("loginVerify".equals(paramString3)) || ("changeSecureMobile".equals(paramString3)))
      {
        this.method = paramString3;
        Lt(paramVarArgs[0]);
      }
      bool = true;
    }
    return bool;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        return;
        QLog.d("IdentificationApiPlugin", 1, new Object[] { "onActivityResult REQ_IDENTIFICATION, result code is ", Integer.valueOf(paramInt), " method is ", this.method });
        this.dj.set(false);
        o(paramIntent, paramInt);
      } while (!"loginVerify".equals(this.method));
      if (this.activity != null)
      {
        this.activity.finish();
        return;
      }
      QLog.e("IdentificationApiPlugin", 1, "onActivityResult REQ_IDENTIFICATION activity is null");
      return;
      QLog.d("IdentificationApiPlugin", 1, new Object[] { "onActivityResult REQ_LEGACY, result code is ", Integer.valueOf(paramInt), " method is ", this.method });
      if (paramInt == -1)
      {
        dy(paramIntent);
        return;
      }
      this.dj.set(false);
      o(paramIntent, paramInt);
    } while (!"loginVerify".equals(this.method));
    if (this.activity != null)
    {
      this.activity.finish();
      return;
    }
    QLog.e("IdentificationApiPlugin", 1, "onActivityResult REQ_LEGACY activity is null");
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.activity = r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijf
 * JD-Core Version:    0.7.0.1
 */