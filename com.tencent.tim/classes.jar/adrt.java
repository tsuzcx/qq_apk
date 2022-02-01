import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.ark.ark.Application;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class adrt
  extends WebViewPlugin
{
  private Dialog H;
  private int bHl = 0;
  private String bvm;
  private String bvn;
  private ConcurrentHashMap<String, Integer> eI = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> eJ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> eK = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> eL = new ConcurrentHashMap();
  private String mAppName;
  private String mAppPath;
  private Context mContext;
  boolean mHasInit = false;
  private String mJumpUrl;
  
  public adrt()
  {
    this.mPluginNameSpace = "lightapp";
  }
  
  private void GP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("ArkPlugin", 1, "decodeArkH5Config, keywordCfgJsonStr is empty");
    }
    for (;;)
    {
      return;
      this.eK.clear();
      this.eL.clear();
      Object localObject2;
      Object localObject3;
      try
      {
        paramString = new JSONObject(paramString);
        localObject1 = paramString.optJSONObject("web-view-jump-web-config");
        paramString = paramString.optJSONObject("web-view-open-app-config");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).keys();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            Object localObject4 = ((JSONObject)localObject1).get((String)localObject3);
            if (((localObject4 instanceof String)) && (localObject4 != null)) {
              this.eK.put(localObject3, (String)localObject4);
            }
          }
        }
        if (paramString == null) {
          continue;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("ArkPlugin", 1, String.format("decodeArkH5Config, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
        return;
      }
      Object localObject1 = paramString.keys();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = paramString.get((String)localObject2);
        if (((localObject3 instanceof String)) && (localObject3 != null)) {
          this.eL.put(localObject2, (String)localObject3);
        }
      }
    }
  }
  
  protected void GO(String paramString)
  {
    TextView localTextView1;
    if (this.H == null)
    {
      this.H = new ReportDialog(BaseActivity.sTopActivity, 2131756467);
      this.H.setContentView(2131559151);
      localTextView1 = (TextView)this.H.findViewById(2131365867);
      TextView localTextView2 = (TextView)this.H.findViewById(2131365863);
      TextView localTextView3 = (TextView)this.H.findViewById(2131365852);
      TextView localTextView4 = (TextView)this.H.findViewById(2131365858);
      localTextView1.setText(2131721103);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView2.setText(paramString);
      }
      localTextView4.setText(2131721897);
      localTextView4.setOnClickListener(new adru(this));
      localTextView3.setOnClickListener(new adrv(this));
      localTextView3.setText(2131721058);
    }
    do
    {
      return;
      localTextView1 = (TextView)this.H.findViewById(2131365863);
    } while (TextUtils.isEmpty(paramString));
    localTextView1.setText(paramString);
  }
  
  protected boolean aL(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        int i = paramString1.lastIndexOf(paramString2);
        bool1 = bool2;
        if (i >= 0)
        {
          bool1 = bool2;
          if (i == paramString1.length() - paramString2.length()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected void cUe()
  {
    if (this.mHasInit) {}
    for (;;)
    {
      return;
      try
      {
        ArkAppCenter.setupArkEnvironment(true);
        Object localObject = this.mRuntime.b();
        if (localObject == null) {
          continue;
        }
        localObject = ((WebViewFragment)localObject).getArguments();
        if (localObject == null) {
          continue;
        }
        localObject = ((Intent)((Bundle)localObject).getParcelable("intent")).getExtras();
        if (localObject == null) {
          continue;
        }
        this.mAppName = ((Bundle)localObject).getString("h5_ark_app_name");
        this.mAppPath = ((Bundle)localObject).getString("h5_ark_app_path");
        this.bvn = ((Bundle)localObject).getString("h5_ark_app_des");
        GP(((Bundle)localObject).getString("h5_ark_check_config"));
        this.mHasInit = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ArkPlugin", 1, String.format("setupArkEnvironment error, err=%s", new Object[] { localException.getMessage() }));
        }
      }
    }
  }
  
  protected void cUf()
  {
    if (this.mRuntime == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.mRuntime.getActivity();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    QQToast.a(localActivity, acfp.m(2131702849), 0).show();
  }
  
  Context getCurrentContext()
  {
    for (Activity localActivity = this.mRuntime.getActivity(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    boolean bool = false;
    if (paramLong == 16L) {
      bool = lh(paramString);
    }
    return bool;
  }
  
  protected String jX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  protected boolean lh(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return true;
        localObject1 = jX(paramString);
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      this.bvm = ((String)localObject1);
      if (this.eI.containsKey(this.bvm))
      {
        localObject1 = (Integer)this.eI.get(this.bvm);
        if (localObject1 != null)
        {
          if (((Integer)localObject1).intValue() == 1) {
            return false;
          }
          if (((Integer)localObject1).intValue() == 0)
          {
            cUf();
            return true;
          }
        }
      }
      cUe();
      localObject1 = null;
      localObject2 = this.mRuntime.b();
      if (localObject2 != null) {
        localObject1 = ((WebViewFragment)localObject2).CE();
      }
      localObject1 = jX((String)localObject1);
      if (aL(this.bvm, (String)localObject1))
      {
        this.eI.put(this.bvm, Integer.valueOf(1));
        return false;
      }
      this.mJumpUrl = paramString;
    } while ((this.H != null) && (this.H.isShowing()));
    this.bHl = 0;
    if (this.eK != null) {
      for (localObject1 = this.eK.keySet().iterator(); ((Iterator)localObject1).hasNext(); localObject1 = (String)this.eK.get(localObject2))
      {
        label207:
        localObject2 = (String)((Iterator)localObject1).next();
        if ((TextUtils.isEmpty(this.mAppName)) || (!((String)localObject2).equals(this.mAppName))) {
          break label207;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      boolean bool;
      if (((String)localObject1).equals("allow")) {
        bool = false;
      }
      for (;;)
      {
        label281:
        paramString = this.eI;
        localObject1 = this.bvm;
        if (bool) {}
        for (i = j;; i = 1)
        {
          paramString.put(localObject1, Integer.valueOf(i));
          return bool;
          if (((String)localObject1).equals("ask"))
          {
            if ((i == 0) && (!TextUtils.isEmpty(this.mAppPath)))
            {
              localObject1 = ark.Application.Create(this.mAppName, this.mAppPath);
              if ((localObject1 != null) && (!TextUtils.isEmpty(paramString)))
              {
                bool = ((ark.Application)localObject1).CheckUrlLegality(paramString);
                ((ark.Application)localObject1).Release();
                if (bool)
                {
                  this.eI.put(this.bvm, Integer.valueOf(1));
                  return false;
                }
              }
            }
            paramString = this.mRuntime.getActivity();
            if ((paramString == null) || (paramString.isFinishing())) {
              break;
            }
            GO(paramString.getString(2131690513));
            this.H.show();
            return true;
          }
          if (!((String)localObject1).equals("forbidden")) {
            break label464;
          }
          cUf();
          bool = true;
          break label281;
        }
        label464:
        bool = false;
      }
      localObject1 = "ask";
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mContext = getCurrentContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrt
 * JD-Core Version:    0.7.0.1
 */