import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppInfo.TimeRecord;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.rich.ArkNodeContainer.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class amuf
  extends ArkViewModel
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  private amue a;
  public ArkAppInfo.TimeRecord mExtraTimerRecord;
  
  public amuf(amuc paramamuc) {}
  
  private void PV(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public boolean a(amue paramamue, String paramString, float paramFloat)
  {
    this.a = paramamue;
    if (this.a == null) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString)) {
      xQ(paramString);
    }
    return super.init(this.a.getAppName(), this.a.zp(), this.a.getAppVersion(), paramString, adqr.sQ(), paramFloat);
  }
  
  public void initLibrary()
  {
    ark.MediaSetStub(adrh.sFactory);
  }
  
  public void loadArkApp(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("ArkNodeContainer", 2, String.format("loadArkApp, apppath:" + paramString1 + " retcode:" + paramInt + " msg:" + paramString2, new Object[0]));
    }
    boolean bool1;
    label72:
    String str1;
    String str2;
    String str3;
    if (paramInt != 0)
    {
      bool1 = true;
      if (paramInt != -2) {
        break label152;
      }
      str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
      str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
      str3 = ArkEnvironmentManager.getInstance().getAppResPath(this.mAppInfo.name);
      PV(str1);
      PV(str2);
      PV(str3);
      if (paramString2 != null) {
        break label158;
      }
      paramString2 = "";
    }
    label152:
    label158:
    for (;;)
    {
      doLoadArkApp(paramString1, str1, str2, str3, bool1, bool2, paramInt, paramString2);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label72;
    }
  }
  
  public void onFirstDrawEnd()
  {
    super.onFirstDrawEnd();
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if (paramAppPathInfo != null) {}
    for (paramAppPathInfo = paramAppPathInfo.path;; paramAppPathInfo = null)
    {
      this.mExtraTimerRecord.getAppFromLocal = false;
      this.mExtraTimerRecord.endOfGetApp = System.currentTimeMillis();
      loadArkApp(paramAppPathInfo, paramInt, paramString);
      return;
    }
  }
  
  public boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null)
    {
      this.mInit = false;
      this.mLoadFailed = true;
      paramAppInfo = this.mViewImpl;
      if (paramAppInfo != null) {
        paramAppInfo.onLoadFailed(null, this.mErrorInfo.retCode, true);
      }
      return true;
    }
    this.mExtraTimerRecord.beginOfGetApp = System.currentTimeMillis();
    Object localObject2 = this.a.zo();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.mAppInfo.name, this.mAppInfo.view, this.mAppInfo.appMinVersion, true);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("onLoadApp,mAppInfo.name=%s,appPath=%s", new Object[] { this.mAppInfo.name, localObject1 }));
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ArkDispatchTask.getInstance().post(this.mAppInfo.name, new ArkNodeContainer.1(this, (String)localObject1));
      return true;
    }
    localObject2 = this.mViewImpl;
    if (localObject2 != null) {
      ((ArkViewImplement)localObject2).onLoading();
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("onLoadApp,mAppInfo.name=%s,appPath=%s,viewImplement=%h", new Object[] { this.mAppInfo.name, localObject1, localObject2 }));
    }
    ArkAppMgr.getInstance().getAppPathByName(paramAppInfo.name, paramAppInfo.view, paramAppInfo.appMinVersion, null, new amuf.a(this));
    return false;
  }
  
  public void onLoadReport(int paramInt)
  {
    if (this.mAppInfo != null) {
      adqu.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.mAppInfo.name, "ArkAppLoadState", paramInt, 0, 0L, 0L, 0L, this.mAppInfo.view, "");
    }
  }
  
  public void onRunAppFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("onRunAppFailed", new Object[0]));
    }
    Object localObject = this.mViewImpl;
    if (localObject != null)
    {
      if (this.a == null) {
        break label90;
      }
      localObject = ((ArkViewImplement)localObject).getView().getContext().getString(2131719298);
    }
    label90:
    for (this.mErrorInfo.msg = String.format((String)localObject, new Object[] { this.a.getAppName() });; this.mErrorInfo.msg = "")
    {
      this.mErrorInfo.canRetry = false;
      super.onRunAppFailed();
      return;
    }
  }
  
  public void unInit()
  {
    destroy();
    this.a = null;
  }
  
  public void xQ(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ArkNodeContainer", 2, String.format("CheckMetaLegality,appMeta is parse error and msg=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  static final class a
    implements ArkAppMgr.IGetAppPathByNameCallback
  {
    protected WeakReference<amuf> mWeakWrapper;
    
    public a(amuf paramamuf)
    {
      this.mWeakWrapper = new WeakReference(paramamuf);
    }
    
    public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
    {
      amuf localamuf = (amuf)this.mWeakWrapper.get();
      if (localamuf == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkNodeContainer", 1, "onGetAppPathByName.wrapper == null");
        }
        return;
      }
      localamuf.onGetAppPathByName(paramInt, paramString, paramAppPathInfo, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amuf
 * JD-Core Version:    0.7.0.1
 */