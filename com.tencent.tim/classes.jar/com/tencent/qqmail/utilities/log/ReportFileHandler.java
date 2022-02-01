package com.tencent.qqmail.utilities.log;

import android.os.Build.VERSION;
import android.os.FileObserver;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;

public class ReportFileHandler
{
  private static final long FLUSH_INTERVAL = 10000L;
  private static final String TAG = "ReportFileHandler";
  private static String lineSeperator;
  private static File sAndroidDataDir;
  private volatile boolean mClosed;
  private File mDir;
  private File mFile;
  private FileObserver mFileObserver;
  private File mNoPermissionDir;
  private File mNoPermissionFile;
  private volatile BufferedWriter mOut;
  private volatile boolean mRenew;
  private FileLock mUploadLock;
  private File mUploadLockFile;
  private FileOutputStream mUploadLockFileOS;
  private volatile boolean mUploading;
  
  static
  {
    Object localObject2 = null;
    lineSeperator = System.getProperty("line.separator");
    if (TextUtils.isEmpty(lineSeperator)) {
      lineSeperator = "\r\n";
    }
    Object localObject1 = localObject2;
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = localObject2;
        if (FileUtil.hasSdcard()) {
          localObject1 = QMApplicationContext.sharedInstance().getExternalFilesDir(null);
        }
      }
      sAndroidDataDir = (File)localObject1;
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.log(5, "ReportFileHandler", "get android data dir failed", localThrowable);
    }
  }
  
  public ReportFileHandler(String paramString)
  {
    this.mFile = new File(paramString);
    this.mDir = this.mFile.getParentFile();
    if (needCheckNoPermissionFile())
    {
      int i = this.mDir.getAbsolutePath().lastIndexOf("/");
      paramString = this.mDir.getAbsolutePath().substring(i + 1);
      this.mNoPermissionDir = new File(sAndroidDataDir + "/" + paramString);
      i = this.mFile.getAbsolutePath().lastIndexOf("/");
      paramString = this.mFile.getAbsolutePath().substring(i + 1);
      this.mNoPermissionFile = new File(this.mNoPermissionDir, paramString);
    }
    if ((this.mDir.mkdirs()) || (this.mDir.isDirectory()))
    {
      this.mFileObserver = new InnerFileObserver(this.mDir.getAbsolutePath());
      this.mFileObserver.startWatching();
      this.mUploadLockFile = new File(this.mDir, "upload.lock");
    }
    Threads.runInBackgroundRepeatly(new ReportFileHandler.1(this), 10000L, 10000L);
  }
  
  public static void deleteFiles(List<File> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((File)paramList.next()).delete();
      }
    }
  }
  
  private boolean needCheckNoPermissionFile()
  {
    return (Build.VERSION.SDK_INT >= 23) && (sAndroidDataDir != null) && (this.mDir != null) && (!this.mDir.getParent().equals(sAndroidDataDir.getAbsolutePath()));
  }
  
  private void renewWriterLocked()
  {
    try
    {
      this.mOut.close();
      this.mOut = null;
      try
      {
        label12:
        if (this.mClosed) {
          return;
        }
        this.mOut = new BufferedWriter(new FileWriter(this.mFile, true));
        return;
      }
      catch (Exception localException1)
      {
        QMLog.log(5, "ReportFileHandler", "new writer failed, dir: " + this.mDir + ", isDir: " + this.mDir.isDirectory() + ", readable: " + this.mDir.canRead() + ", writable: " + this.mDir.canWrite() + ", error: " + localException1);
        return;
      }
    }
    catch (Exception localException2)
    {
      break label12;
    }
  }
  
  /* Error */
  public boolean acquireUpload()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 265	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploading	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 165	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFile	Ljava/io/File;
    //   21: ifnonnull +20 -> 41
    //   24: aload_0
    //   25: new 96	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: getfield 106	com/tencent/qqmail/utilities/log/ReportFileHandler:mDir	Ljava/io/File;
    //   33: ldc 163
    //   35: invokespecial 143	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: putfield 165	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFile	Ljava/io/File;
    //   41: aload_0
    //   42: getfield 165	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFile	Ljava/io/File;
    //   45: invokevirtual 268	java/io/File:exists	()Z
    //   48: ifeq +21 -> 69
    //   51: aload_0
    //   52: getfield 165	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFile	Ljava/io/File;
    //   55: invokevirtual 271	java/io/File:isFile	()Z
    //   58: ifne +11 -> 69
    //   61: aload_0
    //   62: getfield 165	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFile	Ljava/io/File;
    //   65: invokevirtual 211	java/io/File:delete	()Z
    //   68: pop
    //   69: aload_0
    //   70: getfield 273	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLock	Ljava/nio/channels/FileLock;
    //   73: invokevirtual 278	java/nio/channels/FileLock:release	()V
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 273	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLock	Ljava/nio/channels/FileLock;
    //   81: aload_0
    //   82: new 280	java/io/FileOutputStream
    //   85: dup
    //   86: aload_0
    //   87: getfield 165	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFile	Ljava/io/File;
    //   90: invokespecial 283	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: putfield 285	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFileOS	Ljava/io/FileOutputStream;
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 285	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFileOS	Ljava/io/FileOutputStream;
    //   101: invokevirtual 289	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   104: invokevirtual 295	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   107: putfield 273	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLock	Ljava/nio/channels/FileLock;
    //   110: iconst_3
    //   111: ldc 15
    //   113: new 127	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 297
    //   123: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: getfield 273	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLock	Ljava/nio/channels/FileLock;
    //   130: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 262	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 273	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLock	Ljava/nio/channels/FileLock;
    //   143: astore_3
    //   144: aload_3
    //   145: ifnonnull +17 -> 162
    //   148: aload_0
    //   149: getfield 285	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFileOS	Ljava/io/FileOutputStream;
    //   152: invokevirtual 298	java/io/FileOutputStream:close	()V
    //   155: goto -142 -> 13
    //   158: astore_3
    //   159: goto -146 -> 13
    //   162: aload_0
    //   163: iconst_1
    //   164: putfield 265	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploading	Z
    //   167: iconst_1
    //   168: istore_1
    //   169: goto -156 -> 13
    //   172: astore_3
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_3
    //   176: athrow
    //   177: astore_3
    //   178: goto -68 -> 110
    //   181: astore_3
    //   182: goto -106 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	ReportFileHandler
    //   1	168	1	bool1	boolean
    //   8	2	2	bool2	boolean
    //   143	2	3	localFileLock	FileLock
    //   158	1	3	localException1	Exception
    //   172	4	3	localObject	Object
    //   177	1	3	localException2	Exception
    //   181	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   148	155	158	java/lang/Exception
    //   4	9	172	finally
    //   17	41	172	finally
    //   41	69	172	finally
    //   69	76	172	finally
    //   76	81	172	finally
    //   81	110	172	finally
    //   110	144	172	finally
    //   148	155	172	finally
    //   162	167	172	finally
    //   81	110	177	java/lang/Exception
    //   69	76	181	java/lang/Exception
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 232	com/tencent/qqmail/utilities/log/ReportFileHandler:mClosed	Z
    //   7: aload_0
    //   8: getfield 225	com/tencent/qqmail/utilities/log/ReportFileHandler:mOut	Ljava/io/BufferedWriter;
    //   11: ifnull +17 -> 28
    //   14: aload_0
    //   15: getfield 225	com/tencent/qqmail/utilities/log/ReportFileHandler:mOut	Ljava/io/BufferedWriter;
    //   18: invokevirtual 301	java/io/BufferedWriter:flush	()V
    //   21: aload_0
    //   22: getfield 225	com/tencent/qqmail/utilities/log/ReportFileHandler:mOut	Ljava/io/BufferedWriter;
    //   25: invokevirtual 230	java/io/BufferedWriter:close	()V
    //   28: aload_0
    //   29: getfield 156	com/tencent/qqmail/utilities/log/ReportFileHandler:mFileObserver	Landroid/os/FileObserver;
    //   32: ifnull +10 -> 42
    //   35: aload_0
    //   36: getfield 156	com/tencent/qqmail/utilities/log/ReportFileHandler:mFileObserver	Landroid/os/FileObserver;
    //   39: invokevirtual 304	android/os/FileObserver:stopWatching	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: goto -23 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	ReportFileHandler
    //   45	4	1	localObject	Object
    //   50	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	45	finally
    //   7	28	45	finally
    //   28	42	45	finally
    //   7	28	50	java/lang/Exception
  }
  
  /* Error */
  public void finishUpload()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_3
    //   3: ldc 15
    //   5: new 127	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 307
    //   15: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: getfield 273	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLock	Ljava/nio/channels/FileLock;
    //   22: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 262	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 273	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLock	Ljava/nio/channels/FileLock;
    //   35: invokevirtual 278	java/nio/channels/FileLock:release	()V
    //   38: aload_0
    //   39: getfield 285	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFileOS	Ljava/io/FileOutputStream;
    //   42: invokevirtual 298	java/io/FileOutputStream:close	()V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 273	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLock	Ljava/nio/channels/FileLock;
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 285	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploadLockFileOS	Ljava/io/FileOutputStream;
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 265	com/tencent/qqmail/utilities/log/ReportFileHandler:mUploading	Z
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: goto -24 -> 45
    //   72: astore_1
    //   73: goto -35 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ReportFileHandler
    //   63	4	1	localObject	Object
    //   68	1	1	localException1	Exception
    //   72	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	31	63	finally
    //   31	38	63	finally
    //   38	45	63	finally
    //   45	60	63	finally
    //   38	45	68	java/lang/Exception
    //   31	38	72	java/lang/Exception
  }
  
  public void flush()
  {
    try
    {
      this.mOut.flush();
      return;
    }
    catch (Exception localException) {}
  }
  
  @NonNull
  public List<File> getFileListBySuffixes(String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    Observable.defer(new ReportFileHandler.6(this)).filter(new ReportFileHandler.5(this, paramVarArgs)).subscribe(new ReportFileHandler.3(this, localArrayList), new ReportFileHandler.4(this));
    return localArrayList;
  }
  
  public void log(String paramString)
  {
    log(paramString, false, false);
  }
  
  /* Error */
  public void log(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: getfield 232	com/tencent/qqmail/utilities/log/ReportFileHandler:mClosed	Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: iload_2
    //   16: ifne +26 -> 42
    //   19: invokestatic 354	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   22: invokestatic 357	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   25: if_acmpne +17 -> 42
    //   28: new 359	com/tencent/qqmail/utilities/log/ReportFileHandler$2
    //   31: dup
    //   32: aload_0
    //   33: aload_1
    //   34: iload_3
    //   35: invokespecial 362	com/tencent/qqmail/utilities/log/ReportFileHandler$2:<init>	(Lcom/tencent/qqmail/utilities/log/ReportFileHandler;Ljava/lang/String;Z)V
    //   38: invokestatic 366	com/tencent/qqmail/utilities/thread/Threads:runInBackground	(Ljava/lang/Runnable;)V
    //   41: return
    //   42: iconst_2
    //   43: ldc 15
    //   45: aload_1
    //   46: invokestatic 262	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 106	com/tencent/qqmail/utilities/log/ReportFileHandler:mDir	Ljava/io/File;
    //   53: invokevirtual 268	java/io/File:exists	()Z
    //   56: ifeq +23 -> 79
    //   59: aload_0
    //   60: getfield 106	com/tencent/qqmail/utilities/log/ReportFileHandler:mDir	Ljava/io/File;
    //   63: invokevirtual 151	java/io/File:isDirectory	()Z
    //   66: ifne +13 -> 79
    //   69: aload_0
    //   70: getfield 106	com/tencent/qqmail/utilities/log/ReportFileHandler:mDir	Ljava/io/File;
    //   73: invokevirtual 211	java/io/File:delete	()Z
    //   76: ifeq -62 -> 14
    //   79: aload_0
    //   80: getfield 106	com/tencent/qqmail/utilities/log/ReportFileHandler:mDir	Ljava/io/File;
    //   83: invokevirtual 151	java/io/File:isDirectory	()Z
    //   86: ifne +63 -> 149
    //   89: aload_0
    //   90: getfield 106	com/tencent/qqmail/utilities/log/ReportFileHandler:mDir	Ljava/io/File;
    //   93: invokevirtual 148	java/io/File:mkdirs	()Z
    //   96: ifne +13 -> 109
    //   99: aload_0
    //   100: getfield 106	com/tencent/qqmail/utilities/log/ReportFileHandler:mDir	Ljava/io/File;
    //   103: invokevirtual 151	java/io/File:isDirectory	()Z
    //   106: ifeq -92 -> 14
    //   109: aload_0
    //   110: getfield 156	com/tencent/qqmail/utilities/log/ReportFileHandler:mFileObserver	Landroid/os/FileObserver;
    //   113: ifnull +10 -> 123
    //   116: aload_0
    //   117: getfield 156	com/tencent/qqmail/utilities/log/ReportFileHandler:mFileObserver	Landroid/os/FileObserver;
    //   120: invokevirtual 304	android/os/FileObserver:stopWatching	()V
    //   123: aload_0
    //   124: new 6	com/tencent/qqmail/utilities/log/ReportFileHandler$InnerFileObserver
    //   127: dup
    //   128: aload_0
    //   129: aload_0
    //   130: getfield 106	com/tencent/qqmail/utilities/log/ReportFileHandler:mDir	Ljava/io/File;
    //   133: invokevirtual 113	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   136: invokespecial 154	com/tencent/qqmail/utilities/log/ReportFileHandler$InnerFileObserver:<init>	(Lcom/tencent/qqmail/utilities/log/ReportFileHandler;Ljava/lang/String;)V
    //   139: putfield 156	com/tencent/qqmail/utilities/log/ReportFileHandler:mFileObserver	Landroid/os/FileObserver;
    //   142: aload_0
    //   143: getfield 156	com/tencent/qqmail/utilities/log/ReportFileHandler:mFileObserver	Landroid/os/FileObserver;
    //   146: invokevirtual 161	android/os/FileObserver:startWatching	()V
    //   149: aload_0
    //   150: getfield 106	com/tencent/qqmail/utilities/log/ReportFileHandler:mDir	Ljava/io/File;
    //   153: invokevirtual 148	java/io/File:mkdirs	()Z
    //   156: ifne +13 -> 169
    //   159: aload_0
    //   160: getfield 106	com/tencent/qqmail/utilities/log/ReportFileHandler:mDir	Ljava/io/File;
    //   163: invokevirtual 268	java/io/File:exists	()Z
    //   166: ifeq -152 -> 14
    //   169: aload_0
    //   170: getfield 225	com/tencent/qqmail/utilities/log/ReportFileHandler:mOut	Ljava/io/BufferedWriter;
    //   173: ifnull +20 -> 193
    //   176: aload_0
    //   177: getfield 100	com/tencent/qqmail/utilities/log/ReportFileHandler:mFile	Ljava/io/File;
    //   180: invokevirtual 268	java/io/File:exists	()Z
    //   183: ifeq +10 -> 193
    //   186: aload_0
    //   187: getfield 182	com/tencent/qqmail/utilities/log/ReportFileHandler:mRenew	Z
    //   190: ifeq +47 -> 237
    //   193: aload_0
    //   194: monitorenter
    //   195: aload_0
    //   196: getfield 225	com/tencent/qqmail/utilities/log/ReportFileHandler:mOut	Ljava/io/BufferedWriter;
    //   199: ifnull +20 -> 219
    //   202: aload_0
    //   203: getfield 100	com/tencent/qqmail/utilities/log/ReportFileHandler:mFile	Ljava/io/File;
    //   206: invokevirtual 268	java/io/File:exists	()Z
    //   209: ifeq +10 -> 219
    //   212: aload_0
    //   213: getfield 182	com/tencent/qqmail/utilities/log/ReportFileHandler:mRenew	Z
    //   216: ifeq +19 -> 235
    //   219: aload_0
    //   220: invokespecial 368	com/tencent/qqmail/utilities/log/ReportFileHandler:renewWriterLocked	()V
    //   223: aload_0
    //   224: iconst_0
    //   225: putfield 182	com/tencent/qqmail/utilities/log/ReportFileHandler:mRenew	Z
    //   228: aload_0
    //   229: getfield 225	com/tencent/qqmail/utilities/log/ReportFileHandler:mOut	Ljava/io/BufferedWriter;
    //   232: invokevirtual 371	java/io/BufferedWriter:newLine	()V
    //   235: aload_0
    //   236: monitorexit
    //   237: aload_0
    //   238: getfield 225	com/tencent/qqmail/utilities/log/ReportFileHandler:mOut	Ljava/io/BufferedWriter;
    //   241: new 127	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   248: aload_1
    //   249: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: getstatic 49	com/tencent/qqmail/utilities/log/ReportFileHandler:lineSeperator	Ljava/lang/String;
    //   255: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 374	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   264: iload_3
    //   265: ifeq -251 -> 14
    //   268: aload_0
    //   269: invokevirtual 375	com/tencent/qqmail/utilities/log/ReportFileHandler:flush	()V
    //   272: return
    //   273: astore_1
    //   274: return
    //   275: astore_1
    //   276: aload_0
    //   277: monitorexit
    //   278: aload_1
    //   279: athrow
    //   280: astore 4
    //   282: goto -47 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	ReportFileHandler
    //   0	285	1	paramString	String
    //   0	285	2	paramBoolean1	boolean
    //   0	285	3	paramBoolean2	boolean
    //   280	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   237	264	273	java/lang/Exception
    //   268	272	273	java/lang/Exception
    //   195	219	275	finally
    //   219	228	275	finally
    //   228	235	275	finally
    //   235	237	275	finally
    //   276	278	275	finally
    //   228	235	280	java/lang/Exception
  }
  
  public void rename(String paramString)
  {
    this.mFile.renameTo(new File(this.mFile.getAbsolutePath() + "_" + System.currentTimeMillis() / 1000L + "_" + paramString));
    if ((needCheckNoPermissionFile()) && (this.mNoPermissionFile != null)) {
      this.mNoPermissionFile.renameTo(new File(this.mNoPermissionFile.getAbsolutePath() + "_" + System.currentTimeMillis() / 1000L + "_" + paramString));
    }
  }
  
  class InnerFileObserver
    extends FileObserver
  {
    InnerFileObserver(String paramString)
    {
      super(3648);
    }
    
    public void onEvent(int paramInt, String paramString)
    {
      QMLog.log(2, "ReportFileHandler", "onEvent, event: " + paramInt + ", path: " + paramString);
      if ((paramInt == 1024) || (paramInt == 2048) || (ReportFileHandler.this.mFile.getName().equals(paramString)))
      {
        ReportFileHandler.this.flush();
        ReportFileHandler.access$102(ReportFileHandler.this, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.ReportFileHandler
 * JD-Core Version:    0.7.0.1
 */