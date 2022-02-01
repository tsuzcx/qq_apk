package com.tencent.mobileqq.qfix;

import android.app.Application;
import android.content.Context;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AndroidNClassLoader
  extends PathClassLoader
{
  static ArrayList oldDexFiles = new ArrayList();
  PathClassLoader originClassLoader;
  
  private AndroidNClassLoader(String paramString, PathClassLoader paramPathClassLoader)
  {
    super(paramString, paramPathClassLoader.getParent());
    this.originClassLoader = paramPathClassLoader;
  }
  
  private static AndroidNClassLoader createAndroidNClassLoader(PathClassLoader paramPathClassLoader)
    throws Exception
  {
    AndroidNClassLoader localAndroidNClassLoader = new AndroidNClassLoader("", paramPathClassLoader);
    paramPathClassLoader = ShareReflectUtil.findField(paramPathClassLoader, "pathList").get(paramPathClassLoader);
    ShareReflectUtil.findField(paramPathClassLoader, "definingContext").set(paramPathClassLoader, localAndroidNClassLoader);
    ShareReflectUtil.findField(localAndroidNClassLoader, "pathList").set(localAndroidNClassLoader, paramPathClassLoader);
    ArrayList localArrayList = new ArrayList();
    Field localField = ShareReflectUtil.findField(paramPathClassLoader, "dexElements");
    Object[] arrayOfObject = (Object[])localField.get(paramPathClassLoader);
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      localObject = (DexFile)ShareReflectUtil.findField(localObject, "dexFile").get(localObject);
      localArrayList.add(new File(((DexFile)localObject).getName()));
      oldDexFiles.add(localObject);
      i += 1;
    }
    localField.set(paramPathClassLoader, (Object[])ShareReflectUtil.findMethod(paramPathClassLoader, "makePathElements", new Class[] { List.class, File.class, List.class }).invoke(paramPathClassLoader, new Object[] { localArrayList, null, new ArrayList() }));
    return localAndroidNClassLoader;
  }
  
  public static AndroidNClassLoader inject(PathClassLoader paramPathClassLoader, Application paramApplication)
    throws Exception
  {
    paramPathClassLoader = createAndroidNClassLoader(paramPathClassLoader);
    reflectPackageInfoClassloader(paramApplication, paramPathClassLoader);
    return paramPathClassLoader;
  }
  
  private static void reflectPackageInfoClassloader(Application paramApplication, ClassLoader paramClassLoader)
    throws Exception
  {
    paramApplication = (Context)ShareReflectUtil.findField(paramApplication, "mBase").get(paramApplication);
    paramApplication = ShareReflectUtil.findField(paramApplication, "mPackageInfo").get(paramApplication);
    Field localField = ShareReflectUtil.findField(paramApplication, "mClassLoader");
    Thread.currentThread().setContextClassLoader(paramClassLoader);
    localField.set(paramApplication, paramClassLoader);
  }
  
  public Class findClass(String paramString)
    throws ClassNotFoundException
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null) {
      if (!paramString.startsWith("com.tencent.mobileqq.qfix."))
      {
        localObject1 = localObject2;
        if (!paramString.startsWith("com.tencent.common.app.QFixApplicationImpl")) {}
      }
      else
      {
        localObject1 = this.originClassLoader.loadClass(paramString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = super.findClass(paramString);
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.AndroidNClassLoader
 * JD-Core Version:    0.7.0.1
 */