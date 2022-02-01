import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.plugin.PluginBaseActivity;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class tao
{
  protected static long DT;
  public static volatile ConcurrentHashMap<Integer, LightAppSettingInfo> cG = new ConcurrentHashMap();
  public static ArrayList<LightAppSettingInfo> oB = new ArrayList();
  protected DeviceInfo a;
  protected tao.a a;
  protected String aIE;
  protected boolean aOm;
  protected boolean aOn;
  protected boolean aOo;
  protected boolean aOp;
  private BusinessObserver f = new tap(this);
  public Activity mActivity;
  protected AppRuntime mApp;
  protected Bundle mExtras;
  protected arhz mProgress;
  protected ArrayList<Integer> oz;
  
  public tao()
  {
    this.mApp = BaseApplicationImpl.getApplication().getRuntime();
    this.aOo = false;
  }
  
  public tao(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    if ((this.mActivity instanceof AppActivity))
    {
      this.mApp = ((AppActivity)this.mActivity).getAppRuntime();
      this.aOo = true;
    }
    while (!(this.mActivity instanceof BaseActivity)) {
      return;
    }
    this.mApp = ((BaseActivity)this.mActivity).getAppRuntime();
    this.aOo = false;
  }
  
  private void a(Intent paramIntent, LightAppSettingInfo paramLightAppSettingInfo)
  {
    String str = null;
    if (paramLightAppSettingInfo.deviceType == 2) {
      str = "https://qzs.qq.com/open/mobile/iot_public_device_2/html/ipCamera.html";
    }
    for (;;)
    {
      paramIntent.putExtra("url", str);
      return;
      if (paramLightAppSettingInfo.deviceType == 17) {
        str = "https://qzs.qq.com/open/mobile/iot_public_device_2/html/print.html";
      }
    }
  }
  
  private void bCm()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.aIE);
    Object localObject = new StringBuilder();
    if (this.oz != null)
    {
      int i = 0;
      while (i < this.oz.size())
      {
        ((StringBuilder)localObject).append(this.oz.get(i));
        if (i != this.oz.size() - 1) {
          ((StringBuilder)localObject).append(",");
        }
        i += 1;
      }
    }
    localBundle.putString("pids", ((StringBuilder)localObject).toString());
    if ((this.aOp) && (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null)) {
      localBundle.putLong("din", this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din);
    }
    if (this.aOp) {}
    for (localObject = "get_public_lightapp_info";; localObject = "get_lightapp_info")
    {
      tas.a((String)localObject, localBundle, this.mApp, this.f);
      return;
    }
  }
  
  public static void cH(ArrayList<LightAppSettingInfo> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        LightAppSettingInfo localLightAppSettingInfo = (LightAppSettingInfo)paramArrayList.next();
        if (!cG.containsKey(Integer.valueOf(localLightAppSettingInfo.productId)))
        {
          cG.put(Integer.valueOf(localLightAppSettingInfo.productId), localLightAppSettingInfo);
          oB.add(localLightAppSettingInfo);
        }
      }
    }
  }
  
  public static void clear()
  {
    cG.clear();
    oB.clear();
  }
  
  public boolean NC()
  {
    if (this.mActivity == null) {
      return false;
    }
    Object localObject;
    if ((this.mActivity instanceof PluginBaseActivity))
    {
      localObject = ((PluginBaseActivity)this.mActivity).getOutActivity();
      label30:
      if (localObject == null) {
        break label94;
      }
      localObject = new WebView((Context)localObject);
      if (Build.VERSION.SDK_INT >= 11)
      {
        ((WebView)localObject).removeJavascriptInterface("searchBoxJavaBridge_");
        ((WebView)localObject).removeJavascriptInterface("accessibility");
        ((WebView)localObject).removeJavascriptInterface("accessibilityTraversal");
      }
      if ((localObject == null) || (((WebView)localObject).getX5WebViewExtension() == null)) {
        break label96;
      }
    }
    label94:
    label96:
    for (boolean bool = true;; bool = false)
    {
      ((WebView)localObject).destroy();
      return bool;
      localObject = this.mActivity;
      break label30;
      break;
    }
  }
  
  public LightAppSettingInfo a(DeviceInfo paramDeviceInfo)
  {
    LightAppSettingInfo localLightAppSettingInfo2 = (LightAppSettingInfo)cG.get(Integer.valueOf(paramDeviceInfo.productId));
    LightAppSettingInfo localLightAppSettingInfo1 = localLightAppSettingInfo2;
    if (localLightAppSettingInfo2 == null)
    {
      localLightAppSettingInfo1 = localLightAppSettingInfo2;
      if (!this.aOo)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        localLightAppSettingInfo1 = localLightAppSettingInfo2;
        if ((localAppRuntime instanceof QQAppInterface))
        {
          cH(((syw)((QQAppInterface)localAppRuntime).getBusinessHandler(51)).bA());
          localLightAppSettingInfo1 = (LightAppSettingInfo)cG.get(Integer.valueOf(paramDeviceInfo.productId));
        }
      }
    }
    return localLightAppSettingInfo1;
  }
  
  public HashMap<Integer, String> a(JSONArray paramJSONArray)
  {
    localHashMap = new HashMap();
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          int i = 0;
          while (i < paramJSONArray.length())
          {
            JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
            if (localJSONObject != null) {
              localHashMap.put(Integer.valueOf(localJSONObject.getInt("property_id")), localJSONObject.getString("property_val"));
            }
            i += 1;
          }
        }
        return localHashMap;
      }
      catch (Exception paramJSONArray) {}
    }
  }
  
  public void a(DeviceInfo paramDeviceInfo, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramDeviceInfo == null)
    {
      if (this.jdField_a_of_type_Tao$a != null) {
        this.jdField_a_of_type_Tao$a.onResult(false);
      }
      return;
    }
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("showProgress", true);; bool = true)
    {
      this.aOn = true;
      this.aOp = paramBoolean;
      LightAppSettingInfo localLightAppSettingInfo = a(paramDeviceInfo);
      String str;
      if (localLightAppSettingInfo != null) {
        if ((localLightAppSettingInfo.bindType != 3) && (localLightAppSettingInfo.bindType != 7) && (localLightAppSettingInfo.bindType != 5) && (localLightAppSettingInfo.bindType != 4) && (localLightAppSettingInfo.bindType != 1) && (localLightAppSettingInfo.bindType != 8) && (localLightAppSettingInfo.bindType != 9))
        {
          if (QLog.isColorLevel()) {
            QLog.e("LightAppUtil", 2, "bindType=" + localLightAppSettingInfo.bindType);
          }
          arxa.a().showToast(2131692577);
          str = null;
        }
      }
      for (;;)
      {
        if ((str == null) && (0 == 0))
        {
          paramDeviceInfo = new Intent();
          paramDeviceInfo.setClassName("com.tencent.mobileqq", "com.tencent.biz.pubaccount.PublicAccountBrowser");
          paramDeviceInfo.putExtra("url", "https://qzs.qq.com/open/mobile/qq_download/index.html");
          paramDeviceInfo.putExtra("isPublicDevice", paramBoolean);
          tar.a(null, "Net_LiteApp_Setting", 0, 1, localLightAppSettingInfo.productId);
          if (str != null) {
            break label713;
          }
          this.mActivity.startActivity(paramDeviceInfo);
          label247:
          if (this.jdField_a_of_type_Tao$a == null) {
            break label794;
          }
          this.jdField_a_of_type_Tao$a.onResult(true);
          return;
          if (localLightAppSettingInfo.templateType == 0) {
            switch (localLightAppSettingInfo.deviceType)
            {
            default: 
              if ((TextUtils.isEmpty(localLightAppSettingInfo.aIB)) && (TextUtils.isEmpty(localLightAppSettingInfo.aIC))) {
                break label935;
              }
              str = "com.tencent.device.lightapp.LightAppActivity";
              break;
            case 2: 
              if ((localLightAppSettingInfo.oA != null) && (localLightAppSettingInfo.oA.contains(Integer.valueOf(200031))))
              {
                str = "com.tencent.device.superav.ui.SuperVideoActivity";
                continue;
              }
              if ((this.aOp) && (NC()))
              {
                str = "com.tencent.device.lightapp.LightAppActivity";
                continue;
              }
              str = "com.tencent.device.av.VideoActivity";
              break;
            case 14: 
              str = "com.tencent.device.qqwifi.WiFiStorageActivity";
              break;
            case 16: 
              str = "com.tencent.device.av.VisualDoorBellActivity";
              break;
            case 17: 
              str = "com.tencent.device.lightapp.LightAppActivity";
              break;
            }
          }
          if (localLightAppSettingInfo.templateType == 1)
          {
            if ((TextUtils.isEmpty(localLightAppSettingInfo.aIB)) && (TextUtils.isEmpty(localLightAppSettingInfo.aIC))) {
              break label935;
            }
            str = "com.tencent.device.lightapp.LightAppActivity";
            continue;
          }
          arxa.a().showToast(2131692581);
          if (this.jdField_a_of_type_Tao$a == null) {
            break;
          }
          this.jdField_a_of_type_Tao$a.onResult(false);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("device_info", paramDeviceInfo);
        localBundle.putParcelable("lightapp_setting", localLightAppSettingInfo);
        if (paramBundle != null) {
          localBundle.putBundle("extras", paramBundle);
        }
        if (0 == 0) {}
        for (Intent localIntent = new Intent();; localIntent = null)
        {
          localIntent.putExtra("uin", String.valueOf(paramDeviceInfo.din));
          if (!TextUtils.isEmpty(paramDeviceInfo.displayName)) {
            localIntent.putExtra("uinname", paramDeviceInfo.displayName);
          }
          for (;;)
          {
            localIntent.putExtra("account", paramDeviceInfo.serialNum);
            localIntent.putExtra("pid", paramDeviceInfo.productId);
            localIntent.putExtra("device_info", paramDeviceInfo);
            localIntent.putExtra("isPublicDevice", paramBoolean);
            if (this.aOp) {
              a(localIntent, localLightAppSettingInfo);
            }
            if ((paramBundle != null) && (paramBundle.getBoolean("isFromBindSucc", false))) {
              localIntent.putExtra("bindSuccTime", System.currentTimeMillis());
            }
            localIntent.putExtras(localBundle);
            paramDeviceInfo = localIntent;
            break;
            localIntent.putExtra("uinname", tas.a(paramDeviceInfo));
          }
          label713:
          if ((this.mActivity instanceof PluginBaseActivity))
          {
            paramDeviceInfo.setClassName(this.mActivity, str);
            this.mActivity.startActivity(paramDeviceInfo);
            break label247;
          }
          if ((this.mActivity instanceof ChatActivity)) {
            paramDeviceInfo.putExtra("bFromChatActivity", true);
          }
          awjb.a().a(this.mActivity, this.mApp, this.mApp.getAccount(), paramDeviceInfo, str, -1, null, SmartDevicePluginProxyActivity.class);
          break label247;
          label794:
          break;
          if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null)
          {
            if (!aqiw.isNetworkAvailable(this.mActivity))
            {
              arxa.a().showToast(2131692580);
              if (this.jdField_a_of_type_Tao$a == null) {
                break;
              }
              this.jdField_a_of_type_Tao$a.onResult(false);
              return;
            }
            this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = paramDeviceInfo;
            this.mExtras = paramBundle;
            paramBundle = new ArrayList();
            paramBundle.add(Integer.valueOf(paramDeviceInfo.productId));
            s(paramBundle, bool);
            return;
          }
          arxa.a().showToast(2131692579);
          if ((this.mProgress != null) && (!this.mActivity.isFinishing())) {
            this.mProgress.dismiss();
          }
          if (this.jdField_a_of_type_Tao$a == null) {
            break;
          }
          this.jdField_a_of_type_Tao$a.onResult(false);
          return;
        }
        label935:
        str = null;
      }
    }
  }
  
  public void bCl()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = ((syw)((QQAppInterface)localObject1).getBusinessHandler(51)).b();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        ArrayList localArrayList = new ArrayList();
        if (SystemClock.elapsedRealtime() - DT > 15000L)
        {
          DT = SystemClock.elapsedRealtime();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if (!cG.containsKey(Integer.valueOf(localObject2.productId))) {
              localArrayList.add(Integer.valueOf(localObject2.productId));
            }
            i += 1;
          }
          if (localArrayList.size() > 0) {
            s(localArrayList, false);
          }
        }
      }
    }
  }
  
  protected void doLogin()
  {
    if (this.aOm)
    {
      if ((this.mActivity == null) || (this.mActivity.isFinishing())) {
        break label103;
      }
      this.mProgress = new arhz(this.mActivity, this.mActivity.getResources().getDimensionPixelSize(2131299627));
      this.mProgress.setMessage(2131692578);
      this.mProgress.show();
    }
    while (this.mApp == null)
    {
      arwt.w("LightAppUtil", "app == null when dologin");
      if (this.jdField_a_of_type_Tao$a != null) {
        this.jdField_a_of_type_Tao$a.onResult(false);
      }
      return;
      label103:
      this.aOm = false;
    }
    this.aIE = this.mApp.getAccount();
    if (TextUtils.isEmpty(this.aIE)) {
      arxa.a().showToast(2131696665);
    }
    bCm();
  }
  
  public void s(ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    this.oz = paramArrayList;
    this.aOm = paramBoolean;
    doLogin();
  }
  
  public static abstract interface a
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tao
 * JD-Core Version:    0.7.0.1
 */