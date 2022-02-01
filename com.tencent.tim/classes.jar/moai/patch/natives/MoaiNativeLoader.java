package moai.patch.natives;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import moai.patch.log.PatchLog;
import moai.patch.multidex.MultiDex;
import moai.patch.reflect.MoaiReflect;

public class MoaiNativeLoader
{
  public static final String NATIVE_DIR_NAME = "so";
  
  private static void addNativeLibraryPath(Context paramContext, File paramFile)
    throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject1 = MultiDex.getPathListFieldObject(paramContext.getClassLoader());
    if (i < 23)
    {
      MoaiReflect.expandFieldArray(localObject1, "nativeLibraryDirectories", new File[] { paramFile });
      PatchLog.i(5003, "addNativeLibraryPath: " + paramFile.getAbsolutePath());
      return;
    }
    paramContext = (List)MoaiReflect.findField(localObject1, "nativeLibraryDirectories").get(localObject1);
    paramContext.add(0, paramFile);
    Object localObject2 = (List)MoaiReflect.findField(localObject1, "systemNativeLibraryDirectories").get(localObject1);
    ArrayList localArrayList = new ArrayList();
    paramContext.addAll((Collection)localObject2);
    if (((i == 25) && (Build.VERSION.PREVIEW_SDK_INT != 0)) || (i > 25)) {}
    for (paramContext = (Object[])MoaiReflect.findMethod(localObject1, "makePathElements", new Class[] { List.class }).invoke(localObject1, new Object[] { paramContext });; paramContext = (Object[])MoaiReflect.findMethod(localObject1, "makePathElements", new Class[] { List.class, File.class, List.class }).invoke(localObject1, new Object[] { paramContext, null, localArrayList }))
    {
      localObject2 = MoaiReflect.findField(localObject1, "nativeLibraryPathElements");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(localObject1, paramContext);
      PatchLog.i(5003, "addNativeLibraryPath:" + paramFile.getAbsolutePath());
      return;
    }
  }
  
  public static boolean attachPatchNative(Context paramContext, File paramFile)
    throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException
  {
    paramFile = new File(paramFile, "so");
    File[] arrayOfFile = paramFile.listFiles(new MoaiNativeLoader.1());
    if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
      addNativeLibraryPath(paramContext, paramFile);
    }
    return true;
  }
  
  public static void revertNative(Context paramContext)
    throws Exception
  {
    Object localObject1 = MultiDex.getPathListFieldObject(paramContext.getClassLoader());
    paramContext = paramContext.getDir("patch", 0);
    Object localObject2;
    if (Build.VERSION.SDK_INT < 23)
    {
      localObject2 = MoaiReflect.findField(localObject1, "nativeLibraryDirectories");
      ((Field)localObject2).setAccessible(true);
      File[] arrayOfFile = (File[])((Field)localObject2).get(localObject1);
      LinkedList localLinkedList = new LinkedList();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          if (!localFile.getAbsolutePath().contains(paramContext.getAbsolutePath())) {
            localLinkedList.add(localFile);
          }
          i += 1;
        }
        if (localLinkedList.size() > 0) {
          ((Field)localObject2).set(localObject1, (File[])localLinkedList.toArray(new File[localLinkedList.size()]));
        }
        PatchLog.w(1036, "revert native L:" + Build.VERSION.SDK_INT);
      }
    }
    for (;;)
    {
      PatchLog.w(1025, "revert native");
      return;
      localObject2 = (List)MoaiReflect.findField(localObject1, "nativeLibraryDirectories").get(localObject1);
      if ((localObject2 != null) && (((List)localObject2).get(0) != null) && (((File)((List)localObject2).get(0)).getAbsolutePath().contains(paramContext.getAbsolutePath())))
      {
        ((List)localObject2).remove(0);
        paramContext = (Object[])MoaiReflect.findMethod(localObject1, "makePathElements", new Class[] { List.class, File.class, List.class }).invoke(localObject1, new Object[] { localObject2, null, new ArrayList() });
        localObject2 = MoaiReflect.findField(localObject1, "nativeLibraryPathElements");
        ((Field)localObject2).setAccessible(true);
        ((Field)localObject2).set(localObject1, paramContext);
        PatchLog.w(1037, "revert native M:" + Build.VERSION.SDK_INT);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.natives.MoaiNativeLoader
 * JD-Core Version:    0.7.0.1
 */