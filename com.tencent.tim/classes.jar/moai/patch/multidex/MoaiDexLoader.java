package moai.patch.multidex;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import moai.patch.log.PatchLog;
import moai.patch.util.DexFilter;
import moai.patch.util.PatchUtil;

public class MoaiDexLoader
{
  public static final String DEX_DIR_NAME = "dex";
  
  public static boolean attachPatchDex(Application paramApplication, File paramFile)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new File(paramFile, "dex").listFiles(new DexFilter());
    if ((localObject == null) || (localObject.length == 0))
    {
      PatchLog.w(2028, paramFile.getAbsolutePath());
      return true;
    }
    Collections.addAll(localArrayList, (Object[])localObject);
    paramFile = MultiDex.getDefaultMultiDexDir(paramApplication);
    PatchUtil.forceMkdir(paramFile);
    if (Build.VERSION.SDK_INT >= 24) {
      AndroidNClassLoader.replacePathClassLoader(paramApplication);
    }
    if (Build.VERSION.SDK_INT <= 19)
    {
      localObject = paramFile.listFiles(new MoaiDexLoader.1(localArrayList));
      if (localObject.length > 0) {
        Collections.addAll(localArrayList, (Object[])localObject);
      }
    }
    localObject = new StringBuilder("dex files:");
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append(((File)localIterator.next()).getAbsolutePath()).append(",");
    }
    PatchLog.d(((StringBuilder)localObject).toString());
    setUpClassLoader(paramApplication, localArrayList, paramFile);
    return true;
  }
  
  private static String buildDexPath(List<File> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(((File)paramList.get(i)).getAbsolutePath()).append(File.pathSeparator);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void revertClassLoader(Context paramContext)
    throws Exception
  {
    paramContext = (PathClassLoader)paramContext.getClassLoader();
    ClassLoader localClassLoader = paramContext.getParent();
    if ((localClassLoader instanceof IncrementalClassLoader))
    {
      setClassLoaderParent(paramContext, ((IncrementalClassLoader)localClassLoader).getParent());
      PatchLog.w(1023, "revert classloader");
      return;
    }
    PatchLog.w(1034, "classloader not IncrementalClassLoader");
  }
  
  private static void setClassLoaderParent(ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
    throws Exception
  {
    Field localField = ClassLoader.class.getDeclaredField("parent");
    localField.setAccessible(true);
    localField.set(paramClassLoader1, paramClassLoader2);
  }
  
  private static void setUpClassLoader(Context paramContext, List<File> paramList, File paramFile)
    throws Exception
  {
    if (paramList.size() == 0) {
      throw new RuntimeException("setUpClassLoader need at least one file");
    }
    paramContext = (PathClassLoader)paramContext.getClassLoader();
    setClassLoaderParent(paramContext, new IncrementalClassLoader(paramContext, buildDexPath(paramList), paramFile, ""));
  }
  
  public static class IncrementalClassLoader
    extends ClassLoader
  {
    private DelegateClassLoader delegateClassLoader;
    private BaseDexClassLoader originClassLoader;
    
    public IncrementalClassLoader(BaseDexClassLoader paramBaseDexClassLoader, String paramString1, File paramFile, String paramString2)
    {
      super();
      this.originClassLoader = paramBaseDexClassLoader;
      this.delegateClassLoader = new DelegateClassLoader(paramString1, paramFile, paramString2, paramBaseDexClassLoader);
    }
    
    protected Class<?> findClass(String paramString)
      throws ClassNotFoundException
    {
      return this.delegateClassLoader.findClass(paramString);
    }
    
    protected String findLibrary(String paramString)
    {
      return this.originClassLoader.findLibrary(paramString);
    }
    
    public DelegateClassLoader getDelegateClassLoader()
    {
      return this.delegateClassLoader;
    }
    
    class DelegateClassLoader
      extends BaseDexClassLoader
    {
      public DelegateClassLoader(String paramString1, File paramFile, String paramString2, ClassLoader paramClassLoader)
      {
        super(paramFile, paramString2, paramClassLoader);
      }
      
      public Class<?> findClass(String paramString)
        throws ClassNotFoundException
      {
        return super.findClass(paramString);
      }
      
      public String findLibrary(String paramString)
      {
        return MoaiDexLoader.IncrementalClassLoader.this.originClassLoader.findLibrary(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.multidex.MoaiDexLoader
 * JD-Core Version:    0.7.0.1
 */