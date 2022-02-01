import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class xry
  implements Manager
{
  private boolean bil;
  private ConcurrentHashMap<String, Boolean> cW;
  QQAppInterface mApp;
  
  public xry(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.cW = new ConcurrentHashMap();
  }
  
  public static xry a(QQAppInterface paramQQAppInterface)
  {
    return (xry)paramQQAppInterface.getManager(327);
  }
  
  private void xZ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioPanelMiniAppManager", 2, "fetchDrawable: invoked.  url: " + paramString);
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      if (localObject != null)
      {
        ((URLDrawable)localObject).setURLDrawableListener(new xrz(this, paramString));
        ((URLDrawable)localObject).downloadImediatly();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("AioPanelMiniAppManager", 1, "fetchDrawable: failed. ", paramString);
    }
  }
  
  public boolean SE()
  {
    if (this.bil)
    {
      this.bil = false;
      return false;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((altq)this.mApp.getManager(36)).getAppInfoByPath("110000");
    return (localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1);
  }
  
  public void a(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    MiniAppLauncher.startMiniApp(paramContext, aekv.a().tm(), 2053, paramBaseChatPie.a(), null);
    paramContext = (altq)this.mApp.getManager(36);
    paramContext.d(paramContext.getAppInfoByPath("110000"), "");
    this.bil = true;
    anot.a(null, "dc00898", "", "", "0X800A120", "0X800A120", 0, 0, "", "", "", "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, aeku paramaeku)
  {
    a(paramQQAppInterface).xZ(paramaeku.tn());
    a(paramQQAppInterface).xZ(paramaeku.to());
    a(paramQQAppInterface).xZ(paramaeku.tp());
    a(paramQQAppInterface).xZ(paramaeku.tq());
  }
  
  public Drawable aD()
  {
    Object localObject = aekv.a();
    boolean bool1 = anlm.ayn();
    boolean bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (bool1) {
      if (bool2) {
        localObject = ((aeku)localObject).tq();
      }
    }
    Drawable localDrawable;
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130842104);
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      try
      {
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        return localObject;
      }
      catch (Exception localException) {}
      localObject = ((aeku)localObject).tp();
      continue;
      if (bool2) {
        localObject = ((aeku)localObject).to();
      } else {
        localObject = ((aeku)localObject).tn();
      }
    }
    return localDrawable;
  }
  
  public void cez()
  {
    aeku localaeku = aekv.a();
    boolean bool = TextUtils.isEmpty(localaeku.tm());
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if ((localObject != null) && (!bool)) {
        a((QQAppInterface)localObject, localaeku);
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    this.cW.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xry
 * JD-Core Version:    0.7.0.1
 */