package moai.patch.handle;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import moai.patch.bsdiff.BSPatch;
import moai.patch.exception.FileInvalidException;
import moai.patch.log.PatchLog;
import moai.patch.util.PatchUtil;

public class DexPatch
{
  public static boolean optimizeAll(Collection<File> paramCollection, File paramFile)
    throws InterruptedException
  {
    return optimizeAll(paramCollection, paramFile, new AtomicInteger(0));
  }
  
  private static boolean optimizeAll(Collection<File> paramCollection, File paramFile, AtomicInteger paramAtomicInteger)
    throws InterruptedException
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    paramAtomicInteger.set(0);
    Object localObject1 = new CountDownLatch(paramCollection.size());
    Object localObject2 = Executors.newCachedThreadPool();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      ((ExecutorService)localObject2).execute(new OptimizeWorker((File)localIterator.next(), paramFile, (CountDownLatch)localObject1, paramAtomicInteger));
    }
    ((CountDownLatch)localObject1).await();
    ((ExecutorService)localObject2).shutdown();
    PatchLog.i(3002, "optimizeAll success COUNT:" + paramAtomicInteger.get() + ",files:" + paramCollection.size() + ",cost:" + (System.currentTimeMillis() - l));
    boolean bool1 = bool2;
    int j;
    if (paramAtomicInteger.get() == paramCollection.size())
    {
      localObject1 = new ArrayList();
      localObject2 = paramCollection.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        paramAtomicInteger = (File)((Iterator)localObject2).next();
        if (Build.VERSION.SDK_INT >= 26) {}
        for (paramAtomicInteger = paramAtomicInteger.getName().substring(0, paramAtomicInteger.getName().lastIndexOf(".")) + ".odex";; paramAtomicInteger = paramAtomicInteger.getName())
        {
          ((Collection)localObject1).add(new File(paramFile, paramAtomicInteger));
          break;
        }
      }
      PatchLog.d("need odex: " + localObject1);
      j = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (j < 100)
      {
        paramFile = ((Collection)localObject1).iterator();
        int i = 1;
        if (paramFile.hasNext())
        {
          paramAtomicInteger = (File)paramFile.next();
          if (!paramAtomicInteger.exists()) {
            i = 0;
          }
          for (;;)
          {
            break;
            paramFile.remove();
            PatchLog.d("found: " + paramAtomicInteger.getAbsolutePath() + ", cost: " + (System.currentTimeMillis() - l));
          }
        }
        if (i != 0)
        {
          PatchLog.d("odex success, all odex files found: " + paramCollection);
          bool1 = true;
        }
      }
      else
      {
        PatchLog.i(3002, "optimizeAll finish, success: " + bool1 + ", realCost: " + (System.currentTimeMillis() - l));
        return bool1;
      }
      SystemClock.sleep(3000L);
      j += 1;
    }
  }
  
  static boolean optimizeAll(File[] paramArrayOfFile, File paramFile)
    throws InterruptedException
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, paramArrayOfFile);
    return optimizeAll(localArrayList, paramFile, new AtomicInteger(0));
  }
  
  private static String optimizedPathFor(File paramFile1, File paramFile2)
  {
    String str = paramFile1.getName();
    paramFile1 = str;
    int i;
    if (!str.endsWith(".dex"))
    {
      i = str.lastIndexOf(".");
      if (i >= 0) {
        break label60;
      }
    }
    for (paramFile1 = str + ".dex";; paramFile1 = paramFile1.toString())
    {
      return new File(paramFile2, paramFile1).getPath();
      label60:
      paramFile1 = new StringBuilder(i + 4);
      paramFile1.append(str, 0, i);
      paramFile1.append(".dex");
    }
  }
  
  public static File patch(Context paramContext, File paramFile1, File paramFile2, File paramFile3, PatchConfig paramPatchConfig)
  {
    int i = 0;
    long l1;
    File localFile2;
    File localFile1;
    try
    {
      l1 = System.currentTimeMillis();
      localFile2 = new File(paramFile1, "old_dex_merge_file");
      localFile1 = new File(paramFile1, "new_dex_merge_file");
      PatchMergeFile.mergeDiffFile(paramContext.getApplicationInfo().sourceDir, paramFile3.getAbsolutePath(), localFile2.getAbsolutePath());
      if (!localFile2.exists()) {
        throw new FileInvalidException("old dex merge file not exist");
      }
    }
    catch (Exception paramContext)
    {
      PatchLog.e(3001, "dex patch fail:" + paramContext.toString() + "\n" + Log.getStackTraceString(paramContext));
      throw new RuntimeException(paramContext);
    }
    long l2 = PatchUtil.adler32(localFile2);
    if (l2 != paramPatchConfig.getOld_dex_merge_file_adler32()) {
      throw new FileInvalidException("old dex merge file invalid:" + l2 + ", conf:" + paramPatchConfig.getOld_dex_merge_file_adler32());
    }
    BSPatch.patchFast(new File(localFile2.getAbsolutePath()), new File(localFile1.getAbsolutePath()), new File(paramFile2.getAbsolutePath()), 0);
    if (!localFile1.exists()) {
      throw new FileInvalidException("new dex merge file not exist after patch");
    }
    l2 = PatchUtil.adler32(localFile1);
    if (l2 != paramPatchConfig.getNew_dex_merge_file_adler32()) {
      throw new FileInvalidException("new dex merge file invalid:" + l2 + ", conf:" + paramPatchConfig.getNew_dex_merge_file_adler32());
    }
    localFile2.delete();
    paramContext = new File(paramFile1, "dex");
    PatchUtil.forceMkdir(paramContext.getParentFile());
    int j = PatchMergeFile.recover(localFile1.getAbsolutePath(), paramFile3.getAbsolutePath(), paramContext.getAbsolutePath());
    paramFile2 = paramContext.listFiles();
    int k = paramFile2.length;
    while (i < k)
    {
      paramFile3 = paramFile2[i];
      renameToPatchDex(paramFile1.getName(), paramFile3);
      i += 1;
    }
    localFile1.delete();
    PatchLog.i(3000, "dex patch count:" + j, System.currentTimeMillis() - l1);
    return paramContext;
  }
  
  public static void renameToPatchDex(String paramString, File paramFile)
    throws IOException
  {
    PatchUtil.forceRename(paramFile, new File(paramFile.getParent() + File.separator + paramString + "_" + paramFile.getName()));
  }
  
  static class OptimizeWorker
    implements Runnable
  {
    private File dexFile;
    private CountDownLatch latch;
    private File optimizeDirectory;
    private AtomicInteger successCount;
    
    public OptimizeWorker(File paramFile1, File paramFile2, CountDownLatch paramCountDownLatch, AtomicInteger paramAtomicInteger)
    {
      this.dexFile = paramFile1;
      this.optimizeDirectory = paramFile2;
      this.latch = paramCountDownLatch;
      this.successCount = paramAtomicInteger;
    }
    
    private void optimize(File paramFile1, File paramFile2)
      throws Exception
    {
      try
      {
        PatchUtil.forceMkdir(paramFile2);
        DexFile.loadDex(paramFile1.getAbsolutePath(), DexPatch.optimizedPathFor(paramFile1, paramFile2), 0);
        this.successCount.incrementAndGet();
        return;
      }
      catch (Throwable paramFile2)
      {
        PatchLog.e(3003, "optimize dex fail:" + paramFile2.toString() + ",dex:" + paramFile1.getAbsolutePath());
        return;
      }
      finally
      {
        this.latch.countDown();
      }
    }
    
    public void run()
    {
      try
      {
        optimize(this.dexFile, this.optimizeDirectory);
        return;
      }
      catch (Exception localException)
      {
        String str = "optimize dex fail:" + this.dexFile.getAbsolutePath() + ", err:" + localException.toString();
        PatchLog.e(3004, str);
        throw new RuntimeException(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.DexPatch
 * JD-Core Version:    0.7.0.1
 */