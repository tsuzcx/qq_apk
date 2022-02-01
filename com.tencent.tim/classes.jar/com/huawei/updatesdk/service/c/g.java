package com.huawei.updatesdk.service.c;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class g
{
  protected static final d a = new d();
  private static final ExecutorService b = Executors.newFixedThreadPool(1);
  
  private static b a(String paramString, d.a parama)
  {
    paramString = a.a(paramString, parama);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("INSTALL_STATE", paramInt1);
    localBundle.putInt("INSTALL_TYPE", paramInt2);
    ((Intent)localObject).putExtras(localBundle);
    localObject = com.huawei.updatesdk.a.b.c.b.a((Intent)localObject);
    com.huawei.updatesdk.service.b.c.a().c((com.huawei.updatesdk.a.b.c.b)localObject);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2);
  }
  
  private static b b(String paramString)
  {
    return a(paramString, d.a.a);
  }
  
  /* Error */
  private static void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 78
    //   5: new 80	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   12: ldc 83
    //   14: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 89
    //   23: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 91
    //   32: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iconst_0
    //   36: invokevirtual 94	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 102	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +14 -> 63
    //   52: ldc 78
    //   54: ldc 110
    //   56: invokestatic 113	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: ldc 2
    //   61: monitorexit
    //   62: return
    //   63: new 115	com/huawei/updatesdk/service/c/b
    //   66: dup
    //   67: aload_1
    //   68: aload_0
    //   69: invokespecial 117	com/huawei/updatesdk/service/c/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: astore_0
    //   73: aload_0
    //   74: getstatic 122	com/huawei/updatesdk/service/c/c$a:b	Lcom/huawei/updatesdk/service/c/c$a;
    //   77: invokevirtual 125	com/huawei/updatesdk/service/c/b:a	(Lcom/huawei/updatesdk/service/c/c$a;)V
    //   80: aload_0
    //   81: iconst_0
    //   82: invokevirtual 128	com/huawei/updatesdk/service/c/b:a	(Z)V
    //   85: getstatic 19	com/huawei/updatesdk/service/c/g:a	Lcom/huawei/updatesdk/service/c/d;
    //   88: aload_1
    //   89: aload_0
    //   90: invokevirtual 131	com/huawei/updatesdk/service/c/d:a	(Ljava/lang/String;Lcom/huawei/updatesdk/service/c/b;)Lcom/huawei/updatesdk/service/c/b;
    //   93: pop
    //   94: aload_0
    //   95: getstatic 136	com/huawei/updatesdk/service/c/c$b:a	Lcom/huawei/updatesdk/service/c/c$b;
    //   98: invokevirtual 139	com/huawei/updatesdk/service/c/b:a	(Lcom/huawei/updatesdk/service/c/c$b;)V
    //   101: new 80	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   108: ldc 141
    //   110: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: invokevirtual 143	com/huawei/updatesdk/service/c/b:c	()Ljava/lang/String;
    //   117: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 145
    //   122: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: invokevirtual 147	com/huawei/updatesdk/service/c/b:d	()Ljava/lang/String;
    //   129: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_1
    //   136: new 149	java/lang/Thread
    //   139: dup
    //   140: new 151	com/huawei/updatesdk/service/c/e
    //   143: dup
    //   144: invokestatic 156	com/huawei/updatesdk/a/b/a/a:a	()Lcom/huawei/updatesdk/a/b/a/a;
    //   147: invokevirtual 159	com/huawei/updatesdk/a/b/a/a:b	()Landroid/content/Context;
    //   150: aload_0
    //   151: invokespecial 162	com/huawei/updatesdk/service/c/e:<init>	(Landroid/content/Context;Lcom/huawei/updatesdk/service/c/b;)V
    //   154: invokespecial 165	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   157: astore_0
    //   158: aload_0
    //   159: aload_1
    //   160: invokevirtual 169	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: invokevirtual 172	java/lang/Thread:start	()V
    //   167: goto -108 -> 59
    //   170: astore_0
    //   171: ldc 2
    //   173: monitorexit
    //   174: aload_0
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString1	String
    //   0	176	1	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   3	59	170	finally
    //   63	167	170	finally
  }
  
  public static final class a
    extends AsyncTask<Void, Void, Boolean>
  {
    private final String a;
    private final int b;
    private boolean c = false;
    private b d;
    
    private a(String paramString, int paramInt, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramInt;
      this.c = paramBoolean;
    }
    
    private void a()
    {
      if (TextUtils.isEmpty(this.d.d())) {}
      File localFile;
      do
      {
        return;
        localFile = new File(this.d.d());
      } while ((!localFile.exists()) || (localFile.delete()));
      com.huawei.updatesdk.a.a.b.a.a.a.d("PackageService", "file delete error.");
    }
    
    public static void a(String paramString, int paramInt)
    {
      new a(paramString, paramInt, false).execute(new Void[0]);
    }
    
    public static void a(String paramString, int paramInt, boolean paramBoolean)
    {
      new a(paramString, paramInt, paramBoolean).execute(new Void[0]);
    }
    
    private void a(String paramString, File paramFile)
    {
      String str = paramString + File.separator + paramFile.getName();
      paramString = new File(paramString);
      if ((!paramString.exists()) && (!paramString.mkdirs())) {
        com.huawei.updatesdk.a.a.b.a.a.a.d("PackageService", "getbackFile mkdirs failed!");
      }
      paramString = new File(str);
      if (!f.a(paramFile, paramString))
      {
        if (!b())
        {
          g.a(5, 0);
          return;
        }
        this.c = false;
        return;
      }
      paramFile = paramString.getParentFile();
      if (paramFile != null) {
        paramFile.setExecutable(true, false);
      }
      paramString.setReadable(true, false);
      this.d.b(str);
      paramString = "install|pkg:" + this.d.c() + "|path:" + this.d.d();
      paramFile = new Thread(new e(com.huawei.updatesdk.a.b.a.a.a().b(), this.d));
      paramFile.setName(paramString);
      paramFile.start();
    }
    
    private boolean a(String paramString)
    {
      this.d = g.a(paramString);
      if (this.d == null) {}
      do
      {
        return false;
        if (1 != this.b) {
          break;
        }
      } while (TextUtils.isEmpty(this.d.d()));
      g.a.remove(c.b.a);
      return com.huawei.updatesdk.service.e.c.a(this.d.d());
      if (this.c)
      {
        this.d.b(this.d.f() + 1);
        if (this.d.f() >= h.a().length)
        {
          com.huawei.updatesdk.a.a.b.a.a.a.d("PackageService", "getRetryBackupPaths large,can not change file path to retry install");
          this.c = false;
          return false;
        }
        paramString = h.a()[this.d.f()];
        File localFile = new File(this.d.d());
        if (!localFile.exists())
        {
          com.huawei.updatesdk.a.a.b.a.a.a.d("PackageService", "file do not exist,can not change file path to retry install");
          this.c = false;
          return false;
        }
        a(paramString, localFile);
        return false;
      }
      a();
      return false;
    }
    
    private boolean b()
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (-1 == new ContextWrapper(com.huawei.updatesdk.a.b.a.a.a().b()).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
          bool1 = false;
        }
      }
      return bool1;
    }
    
    protected Boolean a(Void... paramVarArgs)
    {
      boolean bool = a(this.a);
      if ((this.d != null) && (c.b.a == this.d.e()) && (1 != this.b) && (!this.c) && (this.d.f() > -1)) {
        a();
      }
      return Boolean.valueOf(bool);
    }
    
    protected void a(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.c.g
 * JD-Core Version:    0.7.0.1
 */