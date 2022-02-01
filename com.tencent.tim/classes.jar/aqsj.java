import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class aqsj
{
  private static final aqsj a = new aqsj();
  private static Application sApplication;
  private Class<?> D;
  private ArrayList<String> Dc = new ArrayList();
  private Class<?> E;
  private Class<?> F;
  private DexClassLoader c;
  private boolean cVP;
  private boolean enable = true;
  private Object fy;
  private Method u;
  private Method v;
  private Method w;
  private Method x;
  
  static Application a()
    throws Exception
  {
    if (sApplication != null) {
      return sApplication;
    }
    try
    {
      Object localObject1 = Class.forName("android.app.ActivityThread");
      Object localObject2 = ((Class)localObject1).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject1 = ((Class)localObject1).getMethod("getApplication", new Class[0]).invoke(localObject2, new Object[0]);
      if (localObject1 == null) {
        throw new NullPointerException("u should init first");
      }
    }
    catch (Exception localException)
    {
      aqsl.d("", localException);
      throw new NullPointerException("u should init first");
    }
    sApplication = (Application)localException;
    Application localApplication = sApplication;
    return localApplication;
  }
  
  public static aqsj a()
  {
    if ((!a.cVP) && (a.enable))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        break label33;
      }
      disable();
    }
    for (;;)
    {
      return a;
      label33:
      if (a.aFA()) {
        a.init();
      }
    }
  }
  
  private boolean aFA()
  {
    if (this.cVP) {
      return true;
    }
    return aqsl.aFA();
  }
  
  public static void disable()
  {
    a.enable = false;
    a.cVP = false;
  }
  
  public static File h(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "gldrawable");
  }
  
  public static boolean i(Drawable paramDrawable)
  {
    return (a.cVP) && (paramDrawable != null) && (a.D != null) && (a.D.isAssignableFrom(paramDrawable.getClass()));
  }
  
  public static boolean j(Drawable paramDrawable)
  {
    return (a.cVP) && (paramDrawable != null) && (a.E != null) && (a.E.isAssignableFrom(paramDrawable.getClass()));
  }
  
  public static boolean k(Drawable paramDrawable)
  {
    return (a.cVP) && (paramDrawable != null) && (a.F != null) && (a.F.isAssignableFrom(paramDrawable.getClass()));
  }
  
  private Class<?> loadClass(String paramString)
    throws Exception
  {
    return this.c.loadClass(paramString);
  }
  
  private boolean rE(String paramString)
  {
    if (this.Dc.contains(paramString)) {
      return false;
    }
    this.Dc.add(paramString);
    return true;
  }
  
  public Drawable a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if ((this.cVP) && (new File(paramString).exists())) {
      try
      {
        if (this.w == null) {
          this.w = this.fy.getClass().getMethod("getAutoEtcDrawable", new Class[] { String.class, Handler.class, Boolean.TYPE });
        }
        long l = System.currentTimeMillis();
        paramString = (Drawable)this.w.invoke(this.fy, new Object[] { paramString, paramHandler, Boolean.valueOf(paramBoolean) });
        aqsl.cN("autoetc-sucess", (int)(System.currentTimeMillis() - l));
        return paramString;
      }
      catch (Exception paramString)
      {
        aqsl.h(paramString);
        aqsl.iu("autoetc-error", paramString.getMessage());
      }
    }
    return null;
  }
  
  public String a(Drawable paramDrawable, boolean paramBoolean)
  {
    if ((this.cVP) && (paramDrawable != null))
    {
      if ((this.v == null) && (rE("setLockWH"))) {}
      try
      {
        this.v = this.D.getMethod("setLockWH", new Class[] { Boolean.TYPE });
        if (this.v == null) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            paramDrawable = (String)this.v.invoke(paramDrawable, new Object[] { Boolean.valueOf(paramBoolean) });
            return paramDrawable;
          }
          catch (Exception paramDrawable)
          {
            aqsl.h(paramDrawable);
          }
          localException = localException;
          aqsl.h(localException);
        }
      }
    }
    return null;
  }
  
  public void ab(Drawable paramDrawable)
  {
    if ((!this.cVP) || (paramDrawable == null) || ((this.u == null) && (rE("recycle")))) {}
    try
    {
      this.u = this.D.getMethod("recycle", new Class[0]);
      if (this.u == null) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          this.u.invoke(paramDrawable, new Object[0]);
          return;
        }
        catch (Exception paramDrawable)
        {
          aqsl.h(paramDrawable);
        }
        localException = localException;
        aqsl.h(localException);
      }
    }
  }
  
  public Drawable b(String paramString, boolean paramBoolean)
  {
    if ((this.cVP) && (new File(paramString).exists())) {
      try
      {
        if (this.x == null) {
          this.x = this.fy.getClass().getMethod("getVideoDrawable", new Class[] { String.class, Boolean.TYPE });
        }
        long l = System.currentTimeMillis();
        paramString = (Drawable)this.x.invoke(this.fy, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        aqsl.cN("videodrawable-sucess", (int)(System.currentTimeMillis() - l));
        return paramString;
      }
      catch (Exception paramString)
      {
        aqsl.h(paramString);
        aqsl.iu("videodrawable-error", paramString.getMessage());
      }
    }
    return null;
  }
  
  public void init()
  {
    it(null, null);
  }
  
  public void it(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (this.enable)
        {
          boolean bool = this.cVP;
          if (!bool) {}
        }
        else
        {
          return;
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          disable();
          continue;
        }
        try
        {
          localApplication = a();
          localFile2 = h(localApplication);
          if (TextUtils.isEmpty(paramString1))
          {
            localFile1 = new File(localFile2, "gldrawable.dex");
            if (!TextUtils.isEmpty(paramString2)) {
              break label293;
            }
            if (aqsl.yl()) {
              break label237;
            }
            if (aqsl.is64Bit()) {
              break label212;
            }
            paramString1 = new File(localFile2, "/jni/armeabi-v7a");
            aqsl.report("so", "armeabi-v7a");
            if ((!localFile1.exists()) || (!paramString1.exists())) {
              continue;
            }
            paramString2 = new File(localApplication.getFilesDir(), "gldrawable/opt");
            if (!paramString2.exists()) {
              paramString2.mkdirs();
            }
            if ((paramString2.exists()) && (paramString2.isDirectory())) {
              break label305;
            }
            this.enable = false;
          }
        }
        catch (Exception paramString1)
        {
          aqsl.h(paramString1);
          disable();
          aqsl.iu("init-error", paramString1.getMessage());
        }
      }
      finally {}
      File localFile1;
      label293:
      for (;;)
      {
        Application localApplication;
        File localFile2;
        break;
        localFile1 = new File(paramString1);
        continue;
        label212:
        paramString1 = new File(localFile2, "/jni/arm64-v8a");
        aqsl.report("so", "arm64-v8a");
        continue;
        label237:
        if (!aqsl.is64Bit())
        {
          paramString1 = new File(localFile2, "/jni/x86");
          aqsl.report("so", "x86");
        }
        else
        {
          paramString1 = new File(localFile2, "/jni/x86_64");
          aqsl.report("so", "x86_64");
          continue;
          paramString1 = new File(paramString2);
        }
      }
      label305:
      this.c = new DexClassLoader(localFile1.getAbsolutePath(), paramString2.getAbsolutePath(), paramString1.getAbsolutePath(), aqsj.class.getClassLoader());
      try
      {
        loadClass("com.tencent.android.gldrawable.utils.Logger").getMethod("setLogger", new Class[] { Handler.Callback.class }).invoke(null, new Object[] { new aqsk(this) });
        paramString1 = loadClass("com.tencent.android.gldrawable.GLDrawable");
        paramString1.getMethod("init", new Class[0]).invoke(null, new Object[0]);
        if (aqsl.aFB()) {
          paramString1.getMethod("setDebugGL", new Class[] { Boolean.TYPE }).invoke(null, new Object[] { Boolean.valueOf(true) });
        }
        this.D = loadClass("com.tencent.android.gldrawable.common.BaseDrawable");
        this.E = loadClass("com.tencent.android.gldrawable.video.VideoDrawable");
        this.F = loadClass("com.tencent.android.gldrawable.etc.EtcDrawable");
      }
      catch (Exception paramString1)
      {
        try
        {
          this.fy = loadClass("com.tencent.android.gldrawable.GLDrawable").getMethod("factory", new Class[0]).invoke(null, new Object[0]);
          this.cVP = true;
          continue;
          paramString1 = paramString1;
          aqsl.h(paramString1);
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            aqsl.h(paramString1);
          }
        }
      }
    }
  }
  
  public Drawable r(String paramString)
  {
    return b(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsj
 * JD-Core Version:    0.7.0.1
 */