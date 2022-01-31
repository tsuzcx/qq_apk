package com.tencent.uncompress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

public class UtilsFunc
{
  private Context mUtilsFuncContext;
  
  @SuppressLint({"NewApi"})
  private void HackSystemICS(String paramString)
  {
    try
    {
      Object localObject = BaseDexClassLoader.class.getDeclaredField("pathList");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(getClass().getClassLoader());
      Field localField = localObject.getClass().getDeclaredField("nativeLibraryDirectories");
      localField.setAccessible(true);
      File[] arrayOfFile1 = (File[])localField.get(localObject);
      File[] arrayOfFile2 = new File[arrayOfFile1.length + 1];
      System.arraycopy(arrayOfFile1, 0, arrayOfFile2, 1, arrayOfFile1.length);
      arrayOfFile2[0] = new File(paramString);
      localField.set(localObject, arrayOfFile2);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Error paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean HackSystemLow1(String paramString)
  {
    try
    {
      Field localField = PathClassLoader.class.getDeclaredField("libraryPathElements");
      localField.setAccessible(true);
      ((List)localField.get(getClass().getClassLoader())).add(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (Error paramString)
    {
      paramString.printStackTrace();
    }
    return true;
  }
  
  private boolean HackSystemLow2(String paramString)
  {
    try
    {
      Field localField = PathClassLoader.class.getDeclaredField("mLibPaths");
      localField.setAccessible(true);
      String[] arrayOfString1 = (String[])localField.get(getClass().getClassLoader());
      String[] arrayOfString2 = new String[arrayOfString1.length + 1];
      System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, arrayOfString1.length);
      arrayOfString2[arrayOfString1.length] = paramString;
      localField.set(getClass().getClassLoader(), arrayOfString2);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (Error paramString)
    {
      paramString.printStackTrace();
    }
    return true;
  }
  
  private boolean HackSystemLow3(String paramString)
  {
    try
    {
      Field localField = DexClassLoader.class.getDeclaredField("mLibPaths");
      localField.setAccessible(true);
      String[] arrayOfString1 = (String[])localField.get(getClass().getClassLoader());
      String[] arrayOfString2 = new String[arrayOfString1.length + 1];
      System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, arrayOfString1.length);
      arrayOfString2[arrayOfString1.length] = paramString;
      localField.set(getClass().getClassLoader(), arrayOfString2);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (Error paramString)
    {
      paramString.printStackTrace();
    }
    return true;
  }
  
  public int getIdByName(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getPackageName();
    try
    {
      Class[] arrayOfClass = Class.forName(paramContext + ".R").getClasses();
      paramContext = null;
      int i = 0;
      for (;;)
      {
        if (i >= arrayOfClass.length) {}
        for (;;)
        {
          if (paramContext == null) {
            break label132;
          }
          return paramContext.getField(paramString2).getInt(paramContext);
          if (!arrayOfClass[i].getName().split("\\$")[1].equals(paramString1)) {
            break;
          }
          paramContext = arrayOfClass[i];
        }
        i += 1;
      }
      return 0;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return 0;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
      return 0;
    }
    catch (SecurityException paramContext)
    {
      paramContext.printStackTrace();
      return 0;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return 0;
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public boolean showToastInThread(String paramString, Context paramContext)
  {
    paramString = new ToastThread(paramString, paramContext);
    paramContext = new Thread(paramString);
    paramContext.start();
    try
    {
      paramContext.join(5000L);
      paramString.getItLooper().quit();
      paramContext.join();
      return true;
    }
    catch (InterruptedException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  class ToastThread
    implements Runnable
  {
    private Looper lp;
    private String msgstr;
    
    public ToastThread(String paramString, Context paramContext)
    {
      this.msgstr = paramString;
      UtilsFunc.this.mUtilsFuncContext = paramContext;
    }
    
    public Looper getItLooper()
    {
      return this.lp;
    }
    
    public void run()
    {
      Looper.prepare();
      this.lp = Looper.myLooper();
      Toast.makeText(UtilsFunc.this.mUtilsFuncContext, this.msgstr, 1).show();
      Looper.loop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.uncompress.UtilsFunc
 * JD-Core Version:    0.7.0.1
 */