package cooperation.plugin;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import aqos;
import avfu;
import avfv;
import avgh;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Dex2Oat
{
  private static final boolean dmT = tn(System.getProperty("java.vm.version"));
  
  public static final boolean J(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.canRead()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static boolean a(Collection<File> paramCollection, File paramFile, boolean paramBoolean, String paramString, a parama)
  {
    return a(paramCollection, paramFile, paramBoolean, paramString, new AtomicInteger(0), parama, 2);
  }
  
  private static boolean a(Collection<File> paramCollection, File paramFile, boolean paramBoolean, String paramString, AtomicInteger paramAtomicInteger, a parama, int paramInt)
  {
    try
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(paramCollection.size());
      ExecutorService localExecutorService = Executors.newFixedThreadPool(paramInt, new avfu());
      long l = System.nanoTime();
      Object localObject = new ArrayList(paramCollection);
      Collections.sort((List)localObject, new avfv());
      Collections.reverse((List)localObject);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localExecutorService.submit(new OptimizeWorker((File)((Iterator)localObject).next(), paramFile, paramBoolean, paramString, paramAtomicInteger, localCountDownLatch, parama));
      }
      try
      {
        localCountDownLatch.await();
        l = (System.nanoTime() - l) / 1000000L;
        if (paramAtomicInteger.get() == paramCollection.size())
        {
          Log.i("plugin_tag.Dex2Oat", "All dexes are optimized successfully, cost: " + l + " ms.");
          paramBoolean = true;
        }
      }
      catch (InterruptedException paramCollection)
      {
        for (;;)
        {
          Log.w("plugin_tag.Dex2Oat", "Dex optimizing was interrupted.", paramCollection);
          paramBoolean = false;
          localExecutorService.shutdown();
        }
      }
      finally
      {
        localExecutorService.shutdown();
      }
    }
    finally {}
    for (;;)
    {
      return paramBoolean;
      Log.e("plugin_tag.Dex2Oat", "Dexes optimizing failed, some dexes are not optimized.");
      paramBoolean = false;
      localExecutorService.shutdown();
    }
  }
  
  public static boolean aKB()
  {
    return (dmT) || (Build.VERSION.SDK_INT >= 21);
  }
  
  public static String getCurrentInstructionSet()
    throws Exception
  {
    String str2 = (String)aqos.invokeStaticMethod("dalvik.system.VMRuntime", "getCurrentInstructionSet");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "arm";
    }
    return str1;
  }
  
  public static String optimizedPathFor(File paramFile1, File paramFile2)
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
  
  private static boolean tn(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!paramString.matches()) {}
    }
    try
    {
      int i = Integer.parseInt(paramString.group(1));
      int j = Integer.parseInt(paramString.group(2));
      if (i <= 2)
      {
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j < 1) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  public static boolean to(String paramString)
  {
    String str = avgh.FP();
    if ((paramString == null) || (paramString.equals("")) || (str == null) || (str.equals("")))
    {
      Log.d("plugin_tag.Dex2Oat", "fingerprint empty:" + paramString + ",current:" + str);
      return false;
    }
    if (paramString.equals(str))
    {
      Log.d("plugin_tag.Dex2Oat", "same fingerprint:" + str);
      return false;
    }
    Log.d("plugin_tag.Dex2Oat", "system OTA,fingerprint not equal:" + paramString + "," + str);
    return true;
  }
  
  static class OptimizeWorker
    implements Runnable
  {
    private static String cKt;
    private final Dex2Oat.a a;
    private final File bd;
    private final File dexFile;
    private final boolean dmU;
    private final CountDownLatch f;
    private final AtomicInteger successCount;
    
    OptimizeWorker(File paramFile1, File paramFile2, boolean paramBoolean, String paramString, AtomicInteger paramAtomicInteger, CountDownLatch paramCountDownLatch, Dex2Oat.a parama)
    {
      this.dexFile = paramFile1;
      this.bd = paramFile2;
      this.dmU = paramBoolean;
      this.successCount = paramAtomicInteger;
      this.f = paramCountDownLatch;
      this.a = parama;
      cKt = paramString;
    }
    
    public void run()
    {
      try
      {
        if ((!Dex2Oat.J(this.dexFile)) && (this.a != null)) {
          this.a.a(this.dexFile, this.bd, new IOException("dex file " + this.dexFile.getAbsolutePath() + " is not exist!"));
        }
        if (this.a != null) {
          this.a.i(this.dexFile, this.bd);
        }
        String str = Dex2Oat.optimizedPathFor(this.dexFile, this.bd);
        DexFile.loadDex(this.dexFile.getAbsolutePath(), str, 0);
        this.successCount.incrementAndGet();
        if (this.a != null) {
          this.a.a(this.dexFile, this.bd, new File(str));
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("plugin_tag.Dex2Oat", "Failed to optimize dex: " + this.dexFile.getAbsolutePath(), localThrowable);
        if (this.a != null) {
          this.a.a(this.dexFile, this.bd, localThrowable);
        }
        return;
      }
      finally
      {
        this.f.countDown();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(File paramFile1, File paramFile2, File paramFile3);
    
    public abstract void a(File paramFile1, File paramFile2, Throwable paramThrowable);
    
    public abstract void i(File paramFile1, File paramFile2);
  }
  
  static class b
  {
    static final Executor s = ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.plugin.Dex2Oat
 * JD-Core Version:    0.7.0.1
 */