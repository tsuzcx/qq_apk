import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.viewplugin.ViewPluginManager.1;
import com.tencent.biz.viewplugin.ViewPluginManager.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ssj
{
  public sse a;
  public String aGf;
  String aoF = null;
  public HashMap<String, Class> fX;
  SharedPreferences k;
  public BaseActivity mActivity;
  public String mBid;
  public ClassLoader mClassLoader;
  public String mPluginName;
  
  public ssj(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3)
  {
    this.mPluginName = paramString1;
    this.mBid = paramString2;
    this.mActivity = paramBaseActivity;
    this.fX = new HashMap();
    this.aoF = (this.mActivity.getFilesDir() + paramString3);
    this.k = this.mActivity.getPreferences(0);
  }
  
  public static boolean a(View paramView, String paramString)
  {
    if ((paramView == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      Method localMethod = paramView.getClass().getMethod("setData", new Class[] { String.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramView, new Object[] { paramString });
      return true;
    }
    catch (Exception paramView)
    {
      ThreadManager.post(new ViewPluginManager.1(paramView), 2, null, true);
    }
    return false;
  }
  
  public View a(String paramString)
  {
    if (this.mClassLoader != null) {}
    for (;;)
    {
      try
      {
        Class localClass = this.mClassLoader.loadClass(paramString);
        if (localClass == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ViewPluginManager", 2, "plugin:" + this.mPluginName + " not find view:" + paramString);
          }
          return null;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localObject = null;
        continue;
        if (this.a == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ViewPluginManager", 2, "plugin:" + this.mPluginName + " plugin context is null");
          }
          return null;
        }
        try
        {
          paramString = (View)localObject.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.a });
          return paramString;
        }
        catch (Exception paramString)
        {
          return null;
        }
      }
      Object localObject = null;
    }
  }
  
  public void a(joy paramjoy, boolean paramBoolean)
  {
    String str = "https://" + this.mPluginName + "?_bid=" + this.mBid;
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginManager", 2, "loadPlugin:" + this.mPluginName + "mBid:" + this.mBid);
    }
    jpa.init();
    if ((this.mActivity.app != null) && (this.mActivity.app.getLongAccountUin() % 10L == 6L)) {}
    for (boolean bool = true;; bool = false)
    {
      jpa.aba = bool;
      bAD();
      Context localContext = this.mActivity.getApplicationContext();
      long l = System.currentTimeMillis();
      if ((!jpa.a(this.mActivity.getApplicationContext(), str, new ssk(this, l, localContext, paramBoolean, paramjoy))) && (QLog.isColorLevel())) {
        QLog.i("ViewPluginManager", 2, "plugin:" + this.mPluginName + " transToLocalUrl: return false");
      }
      return;
    }
  }
  
  public void bAD()
  {
    ThreadManager.post(new ViewPluginManager.3(this), 8, null, true);
  }
  
  public String gL(String paramString)
  {
    return "sp_key_plugin_view_version_" + paramString;
  }
  
  public void tB(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    try
    {
      Method localMethod = paramString.getClass().getMethod("destory", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramString, new Object[0]);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssj
 * JD-Core Version:    0.7.0.1
 */