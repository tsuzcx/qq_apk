package moai.patch.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import moai.patch.handle.DexPatch;
import moai.patch.handle.NameGenerator;
import moai.patch.log.PatchLog;
import moai.patch.reflect.MoaiReflect;
import moai.patch.resource.Hack;
import moai.patch.resource.Hack.HackedClass;
import moai.patch.resource.Hack.HackedMethod;

public final class MultiDex
{
  private static final String CODE_CACHE_NAME = "moai_cache";
  private static final String CODE_CACHE_SECONDARY_FOLDER_NAME = "secondary-dexes";
  private static String sCurrentInstructionSet;
  
  private static boolean checkValidZipFiles(List<File> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!MultiDexExtractor.verifyZipFile((File)paramList.next())) {
        return false;
      }
    }
    return true;
  }
  
  public static ApplicationInfo getApplicationInfo(Context paramContext)
    throws PackageManager.NameNotFoundException
  {
    PackageManager localPackageManager;
    try
    {
      localPackageManager = paramContext.getPackageManager();
      paramContext = paramContext.getPackageName();
      if ((localPackageManager == null) || (paramContext == null)) {
        return null;
      }
    }
    catch (RuntimeException paramContext)
    {
      PatchLog.e(9003, "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", paramContext);
      return null;
    }
    return localPackageManager.getApplicationInfo(paramContext, 128);
  }
  
  private static ClassLoader getClassLoader(Context paramContext)
  {
    paramContext = paramContext.getClassLoader();
    if (paramContext == null) {
      throw new RuntimeException("patch class loader is null");
    }
    return paramContext;
  }
  
  private static String getCurrentInstructionSet()
  {
    if (sCurrentInstructionSet == null) {}
    try
    {
      sCurrentInstructionSet = (String)Hack.clazz("dalvik.system.VMRuntime").method("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
      return sCurrentInstructionSet;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        PatchLog.e(2, "getCurrentInstructionSet failed", localException);
      }
    }
  }
  
  public static File getDefaultMultiDexDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      localFile = NameGenerator.getMaxMoaiPatchDir(paramContext, false);
      if (localFile != null) {
        return new File(localFile, "dex/oat/" + getCurrentInstructionSet());
      }
    }
    File localFile = new File(paramContext.getApplicationInfo().dataDir, "moai_cache");
    try
    {
      mkdirChecked(localFile);
      paramContext = localFile;
    }
    catch (IOException localIOException1)
    {
      try
      {
        for (;;)
        {
          mkdirChecked(paramContext);
          return paramContext;
          localIOException1 = localIOException1;
          paramContext = new File(paramContext.getFilesDir(), "moai_cache");
          try
          {
            mkdirChecked(paramContext);
          }
          catch (IOException localIOException2)
          {
            PatchLog.i(9003, "create cache dir fail:" + localIOException2.toString());
          }
        }
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          PatchLog.i(9003, "create dex dir fail:" + localIOException3.toString());
        }
      }
    }
    paramContext = new File(paramContext, "secondary-dexes");
  }
  
  public static Object getPathListFieldObject(Context paramContext)
    throws NoSuchFieldException, IllegalAccessException
  {
    return getPathListFieldObject(getClassLoader(paramContext));
  }
  
  public static Object getPathListFieldObject(ClassLoader paramClassLoader)
    throws NoSuchFieldException, IllegalAccessException
  {
    return MoaiReflect.findField(paramClassLoader, "pathList").get(paramClassLoader);
  }
  
  public static void install(Context paramContext, File paramFile)
  {
    if (Build.VERSION.SDK_INT <= 19) {
      install_4(paramContext, paramFile);
    }
  }
  
  public static void installSecondaryDexes(ClassLoader paramClassLoader, File paramFile, List<File> paramList)
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException
  {
    if (!paramList.isEmpty())
    {
      if (Build.VERSION.SDK_INT < 19) {
        break label24;
      }
      V19.install(paramClassLoader, paramList, paramFile);
    }
    label24:
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    V14.install(paramClassLoader, paramList, paramFile);
  }
  
  private static void install_4(Context paramContext, File paramFile)
  {
    PatchLog.d("install multidex");
    try
    {
      ApplicationInfo localApplicationInfo = getApplicationInfo(paramContext);
      if (localApplicationInfo == null) {
        return;
      }
      install_4_default(paramContext, getClassLoader(paramContext), localApplicationInfo, paramFile);
      return;
    }
    catch (Exception paramContext)
    {
      throw new RuntimeException("Multi dex installation failed (" + paramContext.getMessage() + ").");
    }
  }
  
  private static void install_4_default(Context paramContext, ClassLoader paramClassLoader, ApplicationInfo paramApplicationInfo, File paramFile)
    throws IOException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException
  {
    List localList = MultiDexExtractor.load(paramContext, paramApplicationInfo, paramFile, false);
    if (checkValidZipFiles(localList)) {
      installSecondaryDexes(paramClassLoader, paramFile, localList);
    }
    for (;;)
    {
      PatchLog.d("install done:default");
      return;
      PatchLog.w(9004, "Files were not valid zip files.  Forcing a reload.");
      paramContext = MultiDexExtractor.load(paramContext, paramApplicationInfo, paramFile, true);
      if (!checkValidZipFiles(paramContext)) {
        break;
      }
      installSecondaryDexes(paramClassLoader, paramFile, paramContext);
    }
    throw new RuntimeException("Zip files were not valid.");
  }
  
  private static void mkdirChecked(File paramFile)
    throws IOException
  {
    paramFile.mkdir();
    if (!paramFile.isDirectory())
    {
      File localFile = paramFile.getParentFile();
      if (localFile == null) {
        PatchLog.e(9003, "Failed to create dir " + paramFile.getPath() + ". Parent file is null.");
      }
      for (;;)
      {
        throw new IOException("Failed to create directory " + paramFile.getPath());
        PatchLog.e(9003, "Failed to create dir " + paramFile.getPath() + ". parent file is a dir " + localFile.isDirectory() + ", a file " + localFile.isFile() + ", exists " + localFile.exists() + ", readable " + localFile.canRead() + ", writable " + localFile.canWrite());
      }
    }
  }
  
  private static void preOptimize(List<File> paramList, File paramFile)
  {
    String[] arrayOfString = paramFile.list(new MultiDex.1());
    if (arrayOfString != null) {}
    try
    {
      if (arrayOfString.length == 0) {
        DexPatch.optimizeAll(paramList, paramFile);
      }
      return;
    }
    catch (InterruptedException paramList)
    {
      PatchLog.w(9004, "Multidex optimizeAll fail:" + paramList.toString());
    }
  }
  
  static final class V14
  {
    private static void install(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
    {
      paramClassLoader = MultiDex.getPathListFieldObject(paramClassLoader);
      MultiDex.preOptimize(paramList, paramFile);
      MoaiReflect.expandFieldArray(paramClassLoader, "dexElements", makeDexElements(paramClassLoader, new ArrayList(paramList), paramFile));
    }
    
    private static Object[] makeDexElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      return (Object[])MoaiReflect.findMethod(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile });
    }
  }
  
  static final class V19
  {
    private static void install(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
    {
      Object localObject = MultiDex.getPathListFieldObject(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      MultiDex.preOptimize(paramList, paramFile);
      MoaiReflect.expandFieldArray(localObject, "dexElements", makeDexElements(localObject, new ArrayList(paramList), paramFile, localArrayList));
      if (localArrayList.size() > 0)
      {
        paramClassLoader = localArrayList.iterator();
        while (paramClassLoader.hasNext()) {
          PatchLog.w(9004, "Exception in makeDexElement", (IOException)paramClassLoader.next());
        }
        paramList = MoaiReflect.findField(localObject, "dexElementsSuppressedExceptions");
        paramFile = (IOException[])paramList.get(localObject);
        if (paramFile != null) {
          break label130;
        }
        paramClassLoader = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]);
      }
      for (;;)
      {
        paramList.set(localObject, paramClassLoader);
        return;
        label130:
        paramClassLoader = new IOException[localArrayList.size() + paramFile.length];
        localArrayList.toArray(paramClassLoader);
        System.arraycopy(paramFile, 0, paramClassLoader, localArrayList.size(), paramFile.length);
      }
    }
    
    private static Object[] makeDexElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      return (Object[])MoaiReflect.findMethod(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.multidex.MultiDex
 * JD-Core Version:    0.7.0.1
 */