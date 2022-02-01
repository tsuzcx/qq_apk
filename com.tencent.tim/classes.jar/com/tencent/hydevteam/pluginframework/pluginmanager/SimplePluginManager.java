package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.Progress;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.common.progress.ProgressFutureImpl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.PluginRunningPath;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

@API
public class SimplePluginManager
  implements PluginManager
{
  public static final Map<String, Object> a = new HashMap();
  private static final File i = new File("/data/local/tmp");
  private final File b;
  private final File c;
  private final Downloader d;
  private final VersionChecker e;
  private final TargetManager f;
  private final UnpackManager g;
  private final ExecutorService h = Executors.newSingleThreadExecutor();
  private File j;
  
  public SimplePluginManager(File paramFile, Downloader paramDownloader, VersionChecker paramVersionChecker, String paramString)
  {
    this.b = paramFile;
    this.c = new File(this.b, "PluginManager_" + paramString);
    this.f = new TargetManager(this.c);
    if ((this.c.exists()) && (!this.c.isDirectory())) {
      throw new IllegalArgumentException(this.c.getAbsolutePath() + "已存在且不是目录");
    }
    this.g = new UnpackManager(this.c);
    this.d = paramDownloader;
    this.e = paramVersionChecker;
  }
  
  private boolean a(String paramString)
  {
    this.j = new File(i, paramString + ".zip");
    return this.j.exists();
  }
  
  @API
  public List<InstalledPlugin> getCachedLatestPlugin(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (a(paramString)) {}
    for (paramString = new GetTestPluginTask(false);; paramString = new GetPluginTask(null, true))
    {
      paramString = this.h.submit(paramString);
      try
      {
        localArrayList.add((InstalledPlugin)paramString.get());
        return localArrayList;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  @API
  public VersionChecker getVersionChecker()
  {
    return this.e;
  }
  
  @API
  public ProgressFuture preloadApk(Context paramContext, InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    paramContext = new PluginPreloadTask(paramContext, paramInstalledPlugin.pluginFile, paramInstalledPlugin.pluginPackageName, paramInstalledPlugin.pluginVersionForPluginLoaderManage, paramBoolean);
    return new ProgressFutureImpl(this.h.submit(paramContext), null);
  }
  
  @API
  public List<ProgressFuture<InstalledPlugin>> updatePlugin(String paramString1, TargetDownloadInfo paramTargetDownloadInfo, String paramString2)
  {
    paramString2 = new ArrayList();
    if (a(paramString1))
    {
      paramString1 = new GetTestPluginTask(true);
      paramString2.add(new ProgressFutureImpl(this.h.submit(paramString1), paramString1));
      return paramString2;
    }
    paramString1 = new GetPluginTask(paramTargetDownloadInfo, false);
    paramString2.add(new ProgressFutureImpl(this.h.submit(paramString1), paramString1));
    return paramString2;
  }
  
  class GetPluginTask
    implements Progress, Callable<InstalledPlugin>
  {
    private TargetDownloadInfo a;
    private boolean b;
    private volatile ProgressFuture<File> c;
    private volatile int d = 0;
    
    GetPluginTask(TargetDownloadInfo paramTargetDownloadInfo, boolean paramBoolean)
    {
      this.b = paramBoolean;
      this.a = paramTargetDownloadInfo;
    }
    
    /* Error */
    private InstalledPlugin a()
      throws Exception
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   4: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   7: invokevirtual 51	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:a	()Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
      //   10: astore_3
      //   11: aload_0
      //   12: bipush 10
      //   14: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   17: new 56	java/util/ArrayList
      //   20: dup
      //   21: invokespecial 57	java/util/ArrayList:<init>	()V
      //   24: astore_2
      //   25: aload_3
      //   26: ifnonnull +223 -> 249
      //   29: aload_0
      //   30: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   33: invokestatic 60	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:b	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetManager;
      //   36: getfield 65	com/tencent/hydevteam/pluginframework/pluginmanager/TargetManager:a	Ljava/io/File;
      //   39: invokestatic 70	com/tencent/hydevteam/pluginframework/pluginmanager/MinFileUtils:b	(Ljava/io/File;)Ljava/util/List;
      //   42: astore_2
      //   43: aload_0
      //   44: bipush 10
      //   46: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   49: aload_3
      //   50: astore_1
      //   51: aload_3
      //   52: ifnonnull +86 -> 138
      //   55: aload_3
      //   56: astore_1
      //   57: aload_0
      //   58: getfield 36	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
      //   61: ifnull +77 -> 138
      //   64: aload_2
      //   65: invokeinterface 76 1 0
      //   70: astore 4
      //   72: aload_3
      //   73: astore_1
      //   74: aload 4
      //   76: invokeinterface 82 1 0
      //   81: ifeq +57 -> 138
      //   84: aload 4
      //   86: invokeinterface 86 1 0
      //   91: checkcast 88	java/io/File
      //   94: astore_1
      //   95: aload_0
      //   96: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   99: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   102: aload_1
      //   103: invokevirtual 91	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:b	(Ljava/io/File;)Z
      //   106: ifne -34 -> 72
      //   109: aload_1
      //   110: invokevirtual 95	java/io/File:getName	()Ljava/lang/String;
      //   113: aload_0
      //   114: getfield 36	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	Lcom/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo;
      //   117: getfield 101	com/tencent/hydevteam/pluginframework/pluginmanager/TargetDownloadInfo:hash	Ljava/lang/String;
      //   120: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   123: ifeq -51 -> 72
      //   126: aload_0
      //   127: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   130: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   133: aload_1
      //   134: invokevirtual 110	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:c	(Ljava/io/File;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
      //   137: astore_1
      //   138: aload_1
      //   139: ifnonnull +107 -> 246
      //   142: aload_2
      //   143: invokeinterface 76 1 0
      //   148: astore_3
      //   149: aload_3
      //   150: invokeinterface 82 1 0
      //   155: ifeq +91 -> 246
      //   158: aload_3
      //   159: invokeinterface 86 1 0
      //   164: checkcast 88	java/io/File
      //   167: astore_2
      //   168: aload_0
      //   169: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   172: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   175: aload_2
      //   176: invokevirtual 91	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:b	(Ljava/io/File;)Z
      //   179: ifne -30 -> 149
      //   182: aload_0
      //   183: getfield 27	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:e	Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;
      //   186: invokestatic 47	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager:a	(Lcom/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager;)Lcom/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager;
      //   189: aload_2
      //   190: invokevirtual 110	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:c	(Ljava/io/File;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
      //   193: astore_2
      //   194: aload_2
      //   195: astore_1
      //   196: aload_0
      //   197: bipush 100
      //   199: putfield 32	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:d	I
      //   202: aload_1
      //   203: ifnonnull +33 -> 236
      //   206: new 40	java/lang/Exception
      //   209: dup
      //   210: ldc 112
      //   212: invokespecial 115	java/lang/Exception:<init>	(Ljava/lang/String;)V
      //   215: athrow
      //   216: astore_1
      //   217: aload_0
      //   218: iconst_5
      //   219: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   222: aload_3
      //   223: astore_1
      //   224: goto -86 -> 138
      //   227: astore_2
      //   228: aload_0
      //   229: iconst_5
      //   230: invokespecial 54	com/tencent/hydevteam/pluginframework/pluginmanager/SimplePluginManager$GetPluginTask:a	(I)V
      //   233: goto -84 -> 149
      //   236: aload_1
      //   237: areturn
      //   238: astore_2
      //   239: goto -11 -> 228
      //   242: astore_1
      //   243: goto -26 -> 217
      //   246: goto -50 -> 196
      //   249: goto -206 -> 43
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	252	0	this	GetPluginTask
      //   50	153	1	localObject1	Object
      //   216	1	1	localJSONException1	JSONException
      //   223	14	1	localObject2	Object
      //   242	1	1	localIOException1	IOException
      //   24	171	2	localObject3	Object
      //   227	1	2	localJSONException2	JSONException
      //   238	1	2	localIOException2	IOException
      //   10	213	3	localObject4	Object
      //   70	15	4	localIterator	java.util.Iterator
      // Exception table:
      //   from	to	target	type
      //   126	138	216	org/json/JSONException
      //   182	194	227	org/json/JSONException
      //   182	194	238	java/io/IOException
      //   126	138	242	java/io/IOException
    }
    
    private void a(int paramInt)
    {
      this.d += paramInt;
    }
    
    private InstalledPlugin b()
      throws ExecutionException, InterruptedException, IOException, JSONException
    {
      Object localObject1 = SimplePluginManager.a.get(this.a.hash);
      if (localObject1 == null)
      {
        localObject1 = new Object();
        SimplePluginManager.a.put(this.a.hash, localObject1);
        for (;;)
        {
          try
          {
            Object localObject2 = SimplePluginManager.b(SimplePluginManager.this);
            Object localObject4 = this.a.hash;
            localObject2 = new File(((TargetManager)localObject2).a, (String)localObject4);
            try
            {
              localObject4 = SimplePluginManager.a(SimplePluginManager.this).c((File)localObject2);
              ((File)localObject2).delete();
              this.d = 100;
              return localObject4;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (((File)localObject2).exists()) {
                  ((File)localObject2).delete();
                }
                Object localObject5 = SimplePluginManager.b(SimplePluginManager.this);
                String str = this.a.hash;
                localObject5 = new File(((TargetManager)localObject5).b, "downloading." + str);
                localObject2 = SimplePluginManager.c(SimplePluginManager.this).download(this.a, (File)localObject2, (File)localObject5);
                a(5);
                this.c = ((ProgressFuture)localObject2);
                localObject2 = (File)((ProgressFuture)localObject2).get();
                a(5);
                localObject5 = SimplePluginManager.a(SimplePluginManager.this).c((File)localObject2);
                ((File)localObject2).delete();
                a(5);
              }
            }
          }
          finally {}
        }
      }
    }
    
    public double getProgress()
    {
      if (this.c != null) {
        return (this.d + (100 - this.d) * this.c.getProgress()) / 100.0D;
      }
      return this.d / 100.0D;
    }
  }
  
  class GetTestPluginTask
    implements Progress, Callable<InstalledPlugin>
  {
    private boolean a = false;
    
    GetTestPluginTask(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public double getProgress()
    {
      return 1.0D;
    }
  }
  
  class PluginPreloadTask
    implements Runnable
  {
    private File a;
    private String c;
    private String d;
    private boolean e;
    
    PluginPreloadTask(File paramFile, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.a = paramFile;
      this.c = paramString1;
      this.d = paramString2;
      this.e = paramBoolean;
    }
    
    public void run()
    {
      Object localObject;
      if (!this.e)
      {
        localObject = PluginRunningPath.getPluginOptDexDir(SimplePluginManager.this, this.c, this.d);
        String str = PluginRunningPath.getPluginNewLibDir(SimplePluginManager.this, this.c, this.d);
        new DexClassLoader(this.a.getAbsolutePath(), (String)localObject, str, SimplePluginManager.this.getClassLoader());
        localObject = new File((String)localObject, this.a.getName() + ".preload");
      }
      try
      {
        ((File)localObject).createNewFile();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimplePluginManager
 * JD-Core Version:    0.7.0.1
 */