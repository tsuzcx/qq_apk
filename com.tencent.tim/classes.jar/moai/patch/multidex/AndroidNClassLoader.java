package moai.patch.multidex;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import moai.patch.reflect.MoaiReflect;

@TargetApi(14)
class AndroidNClassLoader
  extends PathClassLoader
{
  static ArrayList<DexFile> oldDexFiles = new ArrayList();
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
    paramPathClassLoader = MultiDex.getPathListFieldObject(paramPathClassLoader);
    MoaiReflect.findField(paramPathClassLoader, "definingContext").set(paramPathClassLoader, localAndroidNClassLoader);
    MoaiReflect.findField(localAndroidNClassLoader, "pathList").set(localAndroidNClassLoader, paramPathClassLoader);
    ArrayList localArrayList = new ArrayList();
    Field localField = MoaiReflect.findField(paramPathClassLoader, "dexElements");
    Object[] arrayOfObject = (Object[])localField.get(paramPathClassLoader);
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      localObject = (DexFile)MoaiReflect.findField(localObject, "dexFile").get(localObject);
      localArrayList.add(new File(((DexFile)localObject).getName()));
      oldDexFiles.add(localObject);
      i += 1;
    }
    localField.set(paramPathClassLoader, (Object[])MoaiReflect.findMethod(paramPathClassLoader, "makePathElements", new Class[] { List.class, File.class, List.class }).invoke(paramPathClassLoader, new Object[] { localArrayList, null, new ArrayList() }));
    return localAndroidNClassLoader;
  }
  
  private static void reflectPackageInfoClassloader(Application paramApplication, ClassLoader paramClassLoader)
    throws Exception
  {
    paramApplication = (Context)MoaiReflect.findField(paramApplication, "mBase").get(paramApplication);
    paramApplication = MoaiReflect.findField(paramApplication, "mPackageInfo").get(paramApplication);
    Field localField = MoaiReflect.findField(paramApplication, "mClassLoader");
    Thread.currentThread().setContextClassLoader(paramClassLoader);
    localField.set(paramApplication, paramClassLoader);
  }
  
  public static AndroidNClassLoader replacePathClassLoader(Application paramApplication)
    throws Exception
  {
    AndroidNClassLoader localAndroidNClassLoader = createAndroidNClassLoader((PathClassLoader)paramApplication.getClassLoader());
    reflectPackageInfoClassloader(paramApplication, localAndroidNClassLoader);
    return localAndroidNClassLoader;
  }
  
  public Class<?> findClass(String paramString)
    throws ClassNotFoundException
  {
    if ((paramString != null) && (!paramString.equals("")) && (paramString.startsWith("moai.patch."))) {
      return this.originClassLoader.loadClass(paramString);
    }
    return super.findClass(paramString);
  }
  
  public String findLibrary(String paramString)
  {
    return super.findLibrary(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.multidex.AndroidNClassLoader
 * JD-Core Version:    0.7.0.1
 */