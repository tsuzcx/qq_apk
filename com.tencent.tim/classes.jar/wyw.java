import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.ark.ArkViewModelBase.Size;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.Container;
import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppInfo.AppTemplateView;
import com.tencent.ark.open.ArkAppInfo.TimeRecord;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.2;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.3;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public class wyw
  extends ArkViewModel
{
  protected static final ark.ApplicationCallback a;
  public static String aUB;
  public static int bSt = 1000;
  public static String mTroopUin;
  protected static ArrayList<WeakReference<wyw>> qu;
  protected ArkViewModelBase.Size a;
  public ArkAppMessage.Config a;
  public String aUA;
  protected boolean bgA;
  boolean bgB;
  protected boolean bgC;
  int cZ;
  protected WeakReference<wyw.b> mCallback;
  public ArkAppInfo.TimeRecord mExtraTimerRecord;
  protected WeakReference<wyw> mWeakThis;
  
  static
  {
    aUB = "";
    qu = new ArrayList();
    jdField_a_of_type_ComTencentArkArk$ApplicationCallback = new wyx();
  }
  
  public wyw() {}
  
  public wyw(boolean paramBoolean) {}
  
  public static WeakReference<wyw> a(ark.Container paramContainer)
  {
    int i = 0;
    while (i < qu.size())
    {
      WeakReference localWeakReference = (WeakReference)qu.get(i);
      wyw localwyw = (wyw)localWeakReference.get();
      if ((localwyw != null) && (localwyw.getContainer() == paramContainer)) {
        return localWeakReference;
      }
      i += 1;
    }
    return new WeakReference(null);
  }
  
  private static void a(ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    boolean bool;
    if (paramAppPathInfo != null)
    {
      if (paramAppPathInfo.from == 0) {
        break label122;
      }
      bool = true;
      if (paramAppPathInfo.desc == null) {
        break label127;
      }
    }
    label122:
    label127:
    for (String str = paramAppPathInfo.desc.name;; str = "")
    {
      QLog.d("ArkApp.ArkAppContainer", 1, new Object[] { "profiling reportPredownloadFirstHit appName=", str, ",from=", Integer.valueOf(paramAppPathInfo.from), ", hasFile=", Boolean.valueOf(bool) });
      paramAppPathInfo = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramAppPathInfo instanceof QQAppInterface))
      {
        paramAppPathInfo = (ArkAppCenter)((QQAppInterface)paramAppPathInfo).getManager(121);
        if (paramAppPathInfo != null)
        {
          paramAppPathInfo = paramAppPathInfo.a();
          if (paramAppPathInfo != null) {
            paramAppPathInfo.bX(str, bool);
          }
        }
      }
      return;
      bool = false;
      break;
    }
  }
  
  public static QQAppInterface getAppInterface()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
  
  private static void xR(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public ArkViewModelBase.Size a()
  {
    return this.jdField_a_of_type_ComTencentArkArkViewModelBase$Size;
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString)
  {
    aUB = "";
    if ((paramSessionInfo.cZ == 0) || (paramSessionInfo.cZ == 1008)) {
      aUB = paramString;
    }
  }
  
  public void a(wyw.b paramb)
  {
    this.mCallback = new WeakReference(paramb);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, SessionInfo paramSessionInfo)
  {
    mTroopUin = null;
    if (paramSessionInfo.cZ == 1) {
      mTroopUin = paramSessionInfo.aTl;
    }
    this.cZ = paramSessionInfo.cZ;
    this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config = new ArkAppMessage.Config();
    paramSessionInfo = getConfigString();
    this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config.fromString(paramSessionInfo);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config.round == null) || (this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config.round.intValue() != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mRoundCorner = bool;
      if (!TextUtils.isEmpty(paramString4)) {
        xQ(paramString4);
      }
      String str = adqr.sQ();
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      ArkAppCenter.r("ArkApp.ArkAppContainer", String.format(Locale.CHINA, "ArkSafe.init appName=%s, appView=%s, appMinVersion=%s, senderuin=%s, scale=%f, res-scale=%f-%f, system-scale=%f-%f, config=%s, metaData=%s, appconfig=%s", new Object[] { paramString1, paramString2, paramString3, aUB, Float.valueOf(paramFloat), Float.valueOf(localDisplayMetrics.density), Float.valueOf(localDisplayMetrics.scaledDensity), Float.valueOf(acej.k.density), Float.valueOf(acej.k.scaledDensity), paramSessionInfo, paramString4, str }));
      return super.init(paramString1, paramString2, paramString3, paramString4, str, paramFloat);
    }
  }
  
  public void cdw()
  {
    wyw.b localb = (wyw.b)this.mCallback.get();
    if (localb != null) {
      localb.a(this);
    }
  }
  
  public void dC(String paramString1, String paramString2)
  {
    wyw.b localb = (wyw.b)this.mCallback.get();
    if (localb != null) {
      localb.a(this, paramString1, paramString2);
    }
  }
  
  public void destroy()
  {
    qu.remove(this.mWeakThis);
    super.destroy();
  }
  
  public void fI(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentArkArkViewModelBase$Size = new ArkViewModelBase.Size(paramInt1, paramInt2);
  }
  
  public String getConfigString()
  {
    return "";
  }
  
  public ark.Container getContainer()
  {
    return this.mContainer;
  }
  
  public String hs(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public void initLibrary()
  {
    ark.MediaSetStub(adrh.sFactory);
  }
  
  public void loadArkApp(String paramString1, int paramInt, String paramString2)
  {
    boolean bool1;
    if (paramInt != 0)
    {
      bool1 = true;
      if (paramInt != -2) {
        break label140;
      }
    }
    label140:
    for (boolean bool2 = true;; bool2 = false)
    {
      String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
      String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
      String str3 = ArkEnvironmentManager.getInstance().getAppResPath(this.mAppInfo.name);
      xR(str1);
      xR(str2);
      xR(str3);
      if (TextUtils.isEmpty(paramString1)) {
        QLog.d("ArkApp.ArkAppContainer", 1, String.format("ArkTemp.loadArkApp app=null mAppInfo.appName=%s, mAppInfo.appView=%s, appPath=%s", new Object[] { this.mAppInfo.name, this.mAppInfo.view, paramString1 }), new RuntimeException());
      }
      doLoadArkApp(paramString1, str1, str2, str3, bool1, bool2, paramInt, paramString2);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onFirstDrawEnd()
  {
    super.onFirstDrawEnd();
    ThreadManager.executeOnSubThread(new ArkAppContainer.3(this));
  }
  
  public boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    if (getAppInterface() == null)
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
    ArkAppMgr.AppPathInfo localAppPathInfo = ArkAppMgr.getInstance().getAppPathInfoByNameFromLocal(this.mAppInfo.name, this.mAppInfo.view, this.mAppInfo.appMinVersion, true);
    Object localObject1 = "";
    String str1 = "";
    String str2 = "";
    boolean bool;
    if (localAppPathInfo != null)
    {
      localObject2 = localAppPathInfo.path;
      localObject1 = localObject2;
      if (localAppPathInfo.appTempInfo != null)
      {
        str1 = localAppPathInfo.appTempInfo.template;
        str2 = localAppPathInfo.appTempInfo.templateView;
        this.mAppInfo.view = str2;
        localObject1 = localObject2;
        bool = true;
      }
    }
    for (Object localObject2 = str2;; localObject2 = str2)
    {
      QLog.d("ArkApp.ArkAppContainer", 1, new Object[] { "ArkTemp.onLoadApp,mAppInfo.name=", this.mAppInfo.name, ",view=", this.mAppInfo.view, ",isTempApp=", Boolean.valueOf(bool), ",template=", str1, ",templateView=", localObject2, ",appPath=", localObject1 });
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (int i = 1; i != 0; i = 0)
      {
        a(localAppPathInfo);
        ArkDispatchTask.getInstance().post(this.mAppInfo.name, new ArkAppContainer.2(this, (String)localObject1));
        return true;
      }
      localObject2 = this.mViewImpl;
      if (localObject2 != null) {
        ((ArkViewImplement)localObject2).onLoading();
      }
      QLog.i("ArkApp.ArkAppContainer", 1, String.format("onLoadApp,mAppInfo.name=%s,appPath=%s,viewImplement=%h", new Object[] { this.mAppInfo.name, localObject1, localObject2 }));
      ArkAppMgr.getInstance().getAppPathByName(paramAppInfo.name, paramAppInfo.view, paramAppInfo.appMinVersion, null, new wyw.a(this.mWeakThis));
      return false;
      bool = false;
    }
  }
  
  public void onLoadReport(int paramInt)
  {
    if (this.mAppInfo != null) {
      adqu.a(getAppInterface(), this.mAppInfo.name, "ArkAppLoadState", paramInt, 0, 0L, 0L, 0L, this.mAppInfo.view, "");
    }
  }
  
  public void onRunAppFailed()
  {
    Object localObject = this.mViewImpl;
    if (localObject != null)
    {
      if ((this.mApplication == null) || (this.mApplication.GetScriptType() != 2) || (ark.Application.JSCLoaded())) {
        break label72;
      }
      localObject = ((ArkViewImplement)localObject).getView().getContext().getString(2131695298);
      this.mErrorInfo.msg = hs((String)localObject);
    }
    for (this.mErrorInfo.canRetry = true;; this.mErrorInfo.canRetry = false)
    {
      super.onRunAppFailed();
      return;
      label72:
      localObject = ((ArkViewImplement)localObject).getView().getContext().getString(2131695303);
      this.mErrorInfo.msg = hs((String)localObject);
    }
  }
  
  public void resetInputState()
  {
    if (this.mViewImpl != null)
    {
      this.mViewImpl.resetInputState();
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppContainer", 2, String.format("resetInputState done.in.wrapper: %h", new Object[] { this }));
      }
    }
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
      ArkAppCenter.r("ArkApp.ArkAppContainer", String.format("CheckMetaLegality,appMeta is parse error and msg=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  public static final class a
    implements ArkAppMgr.IGetAppPathByNameCallback
  {
    protected WeakReference<wyw> mWeakWrapper;
    
    public a(WeakReference<wyw> paramWeakReference)
    {
      this.mWeakWrapper = paramWeakReference;
    }
    
    public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
    {
      paramObject = (wyw)this.mWeakWrapper.get();
      if (paramObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAppContainer", 1, "onGetAppPathByName.wrapper == null");
        }
        return;
      }
      String str1 = paramObject.hs(paramString);
      if (paramAppPathInfo != null) {}
      for (paramString = paramAppPathInfo.path;; paramString = null)
      {
        paramObject.mExtraTimerRecord.getAppFromLocal = false;
        paramObject.mExtraTimerRecord.endOfGetApp = System.currentTimeMillis();
        if ((paramAppPathInfo != null) && (paramAppPathInfo.appTempInfo != null))
        {
          String str2 = paramAppPathInfo.appTempInfo.template;
          str2 = paramAppPathInfo.appTempInfo.templateView;
          wyw.a(paramObject).view = str2;
        }
        wyw.b(paramAppPathInfo);
        paramObject.loadArkApp(paramString, paramInt, str1);
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(wyw paramwyw);
    
    public abstract boolean a(wyw paramwyw, String paramString1, String paramString2);
  }
  
  public static abstract interface c
  {
    public abstract void a(wyw paramwyw, ArkAppLoadLayout paramArkAppLoadLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyw
 * JD-Core Version:    0.7.0.1
 */