import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdModuleImpl.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdModuleImpl.2;
import com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdModuleImpl.3;
import com.tencent.cmsdk.hippy.api.ITKDAdModule;
import com.tencent.hippy.qq.module.tkd.TKDAccountModule;
import com.tencent.hippy.qq.module.tkd.TKDDeviceModule;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class uhe
  implements ITKDAdModule
{
  public static String a;
  protected SoftReference<HippyEngineContext> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TkdAdModuleImpl";
  }
  
  private int a(String paramString)
  {
    int i = 9999;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 9999;
  }
  
  public void MMAOnExpose(String paramString, int paramInt) {}
  
  public void getAccountInfo(Promise paramPromise)
  {
    try
    {
      paramPromise.resolve(TKDAccountModule.convertAccountInfo2HippyMap(TKDAccountModule.getCurAccountInfo()));
      return;
    }
    catch (Exception paramPromise) {}
  }
  
  public void getAppPkgInfo(String paramString, Promise paramPromise)
  {
    paramPromise.resolve("null");
  }
  
  public void getDeviceInfo(Promise paramPromise)
  {
    paramPromise.resolve(TKDDeviceModule.getDeviceInfo());
  }
  
  public void getEnv(Promise paramPromise)
  {
    paramPromise.resolve("test");
  }
  
  public void goBack(String paramString, Promise paramPromise)
  {
    if (this.jdField_a_of_type_JavaLangRefSoftReference == null) {}
    do
    {
      return;
      paramString = (HippyEngineContext)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    } while ((paramString == null) || (paramString.getGlobalConfigs() == null) || (!(paramString.getGlobalConfigs().getContext() instanceof Activity)));
    UIThreadUtils.runOnUiThread(new TkdAdModuleImpl.2(this, paramString));
  }
  
  public void init(HippyEngineContext paramHippyEngineContext)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramHippyEngineContext);
  }
  
  public void isSupportQQMiniGame(Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("ret", 0);
    paramPromise.resolve(localHippyMap);
  }
  
  public void loadUrl(String paramString, HippyMap paramHippyMap)
  {
    if (this.jdField_a_of_type_JavaLangRefSoftReference == null) {}
    do
    {
      return;
      paramHippyMap = (HippyEngineContext)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    } while (paramHippyMap == null);
    if (tto.b(paramString)) {
      tto.a(paramHippyMap.getGlobalConfigs().getContext(), "小游戏", tto.b(paramString), null);
    }
    for (;;)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "loadUrl url:" + paramString);
      return;
      pqx.a(paramHippyMap.getGlobalConfigs().getContext(), paramString);
    }
  }
  
  public void openQQMiniGameByLink(HippyMap paramHippyMap, Promise paramPromise)
  {
    if ((paramPromise == null) || (this.jdField_a_of_type_JavaLangRefSoftReference == null)) {}
    do
    {
      return;
      paramPromise = (HippyEngineContext)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    } while (paramPromise == null);
    try
    {
      String str = paramHippyMap.getString("link");
      int i = a(paramHippyMap.getString("refer"));
      QLog.d(jdField_a_of_type_JavaLangString, 2, "openQQMiniGameByLink link:" + str + " refer:" + i);
      MiniAppLauncher.startMiniApp(paramPromise.getGlobalConfigs().getContext(), str, i, null);
      return;
    }
    catch (Exception paramHippyMap)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "openQQMiniGameByLink error : " + paramHippyMap.getMessage());
    }
  }
  
  public void runApp(String paramString)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "run app params:" + paramString);
    if (this.jdField_a_of_type_JavaLangRefSoftReference == null) {}
    for (;;)
    {
      return;
      Object localObject = (HippyEngineContext)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      if (localObject != null)
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains(":")))
        {
          udy.a(paramString, (Activity)((HippyEngineContext)localObject).getGlobalConfigs().getContext());
          return;
        }
        try
        {
          if (!TextUtils.isEmpty(paramString))
          {
            localObject = ContextHolder.getAppContext();
            paramString = ((Context)localObject).getPackageManager().getLaunchIntentForPackage(paramString);
            if (paramString != null)
            {
              ((Context)localObject).startActivity(paramString);
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void sendWupRequest(HippyMap paramHippyMap, Promise paramPromise) {}
  
  public void setTitle(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (this.jdField_a_of_type_JavaLangRefSoftReference == null) {}
    do
    {
      return;
      paramPromise = (HippyEngineContext)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    } while (paramPromise == null);
    UIThreadUtils.runOnUiThread(new TkdAdModuleImpl.3(this, paramHippyMap, paramPromise));
  }
  
  public void showToast(String paramString1, String paramString2, int paramInt, String paramString3, Promise paramPromise)
  {
    UIThreadUtils.runOnUiThread(new TkdAdModuleImpl.1(this, paramString1, paramInt, paramPromise));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhe
 * JD-Core Version:    0.7.0.1
 */