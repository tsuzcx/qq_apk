import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class actf
{
  private static String bqS = "en-release.zip";
  private acte a;
  private acth b;
  
  private boolean P(Context paramContext, String paramString)
  {
    bs(paramContext, paramString);
    try
    {
      long l = System.currentTimeMillis();
      AssetManager localAssetManager = (AssetManager)AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
      Object localObject = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(localAssetManager, new Object[] { paramString });
      Resources localResources = new Resources(localAssetManager, this.b.c().getDisplayMetrics(), this.b.c().getConfiguration());
      localObject = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (paramContext != null) {}
      for (paramContext = paramContext.packageName;; paramContext = (Context)localObject)
      {
        this.b.a(localResources, paramContext);
        QLog.d("MultiLanguageEngine", 1, new Object[] { "loadLangPkg:", localAssetManager.toString(), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
        return true;
        QLog.d("MultiLanguageEngine", 1, "pkgInfo is null");
      }
      return false;
    }
    catch (Exception paramContext)
    {
      QLog.d("MultiLanguageEngine", 1, paramContext, new Object[0]);
    }
  }
  
  public static actf a()
  {
    return actf.a.b();
  }
  
  private void bs(Context paramContext, String paramString)
  {
    long l;
    String str;
    if (!new File(paramString).exists())
    {
      QLog.d("MultiLanguageEngine", 1, new Object[] { "loadLanguage need unzip:", bqS });
      l = System.currentTimeMillis();
      paramString = "language" + File.separator + bqS;
      str = rU() + bqS;
      aqhq.p(paramContext, paramString, str);
    }
    try
    {
      jqp.b(new File(str), rU());
      if (QLog.isColorLevel()) {
        QLog.e("MultiLanguageEngine", 2, new Object[] { "copy and unzip success! cost:", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void dV(Context paramContext)
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject1 = Class.forName("android.app.ContextImpl");
      Object localObject2 = ((Class)localObject1).getDeclaredField("mResources");
      ((Field)localObject2).setAccessible(true);
      Object localObject3 = ((Field)localObject2).get(paramContext);
      ((Field)localObject2).set(paramContext, this.a);
      QLog.d("MultiLanguageEngine", 1, new Object[] { "success in delegate ContextImpl resources:", this.a.toString(), " ,old:", localObject3.toString() });
      localObject1 = ((Class)localObject1).getDeclaredField("mPackageInfo");
      ((Field)localObject1).setAccessible(true);
      paramContext = ((Field)localObject1).get(paramContext);
      localObject1 = Class.forName("android.app.LoadedApk").getDeclaredField("mResources");
      ((Field)localObject1).setAccessible(true);
      localObject2 = ((Field)localObject1).get(paramContext);
      ((Field)localObject1).set(paramContext, this.a);
      QLog.d("MultiLanguageEngine", 1, new Object[] { "success in delegate LoadedApk resources:", this.a.toString(), " ,old:", localObject2.toString(), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static String rU()
  {
    File localFile = new File(BaseApplicationImpl.getApplication().getFilesDir(), "/multi_language");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator;
  }
  
  public void bP(Activity paramActivity)
  {
    if (acha.isLocaleCN()) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      LayoutInflater.from(paramActivity).setFactory2(new actg(paramActivity));
    } while (!QLog.isColorLevel());
    QLog.d("MultiLanguageEngine", 2, new Object[] { "register cost:", Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void dR(Context paramContext)
  {
    boolean bool = false;
    if (!acha.isLocaleCN()) {
      bool = true;
    }
    QLog.d("MultiLanguageEngine", 1, new Object[] { "initAndDelegate:", Boolean.valueOf(bool), ", context:", paramContext });
    if (paramContext == null) {}
    while (acha.isLocaleCN()) {
      return;
    }
    this.b = new acth(paramContext);
    this.a = new acte(this.b);
    dV(paramContext);
  }
  
  public void dS(Context paramContext)
  {
    if (acha.aaA()) {
      P(paramContext, rU() + "en.lang");
    }
    while (this.b == null) {
      return;
    }
    this.b.a(null, null);
  }
  
  public void dT(Context paramContext)
  {
    long l = System.currentTimeMillis();
    aqhq.cn(rU());
    dS(paramContext);
    QLog.d("MultiLanguageEngine", 1, new Object[] { "update lang pkg! cost:", Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void dU(Context paramContext)
  {
    bs(paramContext, rU() + "en.lang");
  }
  
  static class a
  {
    private static actf a = new actf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     actf
 * JD-Core Version:    0.7.0.1
 */