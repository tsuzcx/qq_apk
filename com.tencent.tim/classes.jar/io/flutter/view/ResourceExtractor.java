package io.flutter.view;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

class ResourceExtractor
{
  private static final String[] SUPPORTED_ABIS = ;
  private static final String TAG = "ResourceExtractor";
  private static final String TIMESTAMP_PREFIX = "res_timestamp-";
  @NonNull
  private final AssetManager mAssetManager;
  @NonNull
  private final String mDataDirPath;
  private ExtractTask mExtractTask;
  @NonNull
  private final PackageManager mPackageManager;
  @NonNull
  private final String mPackageName;
  @NonNull
  private final HashSet<String> mResources;
  
  ResourceExtractor(@NonNull String paramString1, @NonNull String paramString2, @NonNull PackageManager paramPackageManager, @NonNull AssetManager paramAssetManager)
  {
    this.mDataDirPath = paramString1;
    this.mPackageName = paramString2;
    this.mPackageManager = paramPackageManager;
    this.mAssetManager = paramAssetManager;
    this.mResources = new HashSet();
  }
  
  private static String checkTimestamp(@NonNull File paramFile, @NonNull PackageManager paramPackageManager, @NonNull String paramString)
  {
    try
    {
      paramPackageManager = paramPackageManager.getPackageInfo(paramString, 0);
      if (paramPackageManager == null) {
        paramFile = "res_timestamp-";
      }
      do
      {
        do
        {
          do
          {
            return paramFile;
            paramString = new StringBuilder();
            paramString.append("res_timestamp-");
            paramString.append(getVersionCode(paramPackageManager));
            paramString.append("-");
            paramString.append(paramPackageManager.lastUpdateTime);
            paramPackageManager = paramString.toString();
            paramString = getExistingTimestamps(paramFile);
            paramFile = paramPackageManager;
          } while (paramString == null);
          int i = paramString.length;
          paramFile = paramPackageManager;
        } while (paramString.length != 1);
        paramFile = paramPackageManager;
      } while (!paramPackageManager.equals(paramString[0]));
      return null;
    }
    catch (PackageManager.NameNotFoundException paramFile) {}
    return "res_timestamp-";
  }
  
  private static void copy(@NonNull InputStream paramInputStream, @NonNull OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[16384];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i < 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void deleteFiles(@NonNull String paramString, @NonNull HashSet<String> paramHashSet)
  {
    paramString = new File(paramString);
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      File localFile = new File(paramString, (String)paramHashSet.next());
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    paramHashSet = getExistingTimestamps(paramString);
    if (paramHashSet == null) {}
    for (;;)
    {
      return;
      int j = paramHashSet.length;
      int i = 0;
      while (i < j)
      {
        new File(paramString, paramHashSet[i]).delete();
        i += 1;
      }
    }
  }
  
  private static String[] getExistingTimestamps(File paramFile)
  {
    return paramFile.list(new ResourceExtractor.1());
  }
  
  private static String[] getSupportedAbis()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return Build.SUPPORTED_ABIS;
    }
    ArrayList localArrayList = new ArrayList(Arrays.asList(new String[] { Build.CPU_ABI, Build.CPU_ABI2 }));
    localArrayList.removeAll(Arrays.asList(new String[] { null, "" }));
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  static long getVersionCode(@NonNull PackageInfo paramPackageInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramPackageInfo.getLongVersionCode();
    }
    return paramPackageInfo.versionCode;
  }
  
  ResourceExtractor addResource(@NonNull String paramString)
  {
    this.mResources.add(paramString);
    return this;
  }
  
  ResourceExtractor addResources(@NonNull Collection<String> paramCollection)
  {
    this.mResources.addAll(paramCollection);
    return this;
  }
  
  ResourceExtractor start()
  {
    this.mExtractTask = new ExtractTask(this.mDataDirPath, this.mResources, this.mPackageName, this.mPackageManager, this.mAssetManager);
    this.mExtractTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    return this;
  }
  
  void waitForCompletion()
  {
    if (this.mExtractTask == null) {
      return;
    }
    try
    {
      this.mExtractTask.get();
      return;
    }
    catch (CancellationException localCancellationException)
    {
      deleteFiles(this.mDataDirPath, this.mResources);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label18;
    }
    catch (ExecutionException localExecutionException)
    {
      label18:
      break label18;
    }
  }
  
  static class ExtractTask
    extends AsyncTask<Void, Void, Void>
  {
    @NonNull
    private final AssetManager mAssetManager;
    @NonNull
    private final String mDataDirPath;
    @NonNull
    private final PackageManager mPackageManager;
    @NonNull
    private final String mPackageName;
    @NonNull
    private final HashSet<String> mResources;
    
    ExtractTask(@NonNull String paramString1, @NonNull HashSet<String> paramHashSet, @NonNull String paramString2, @NonNull PackageManager paramPackageManager, @NonNull AssetManager paramAssetManager)
    {
      this.mDataDirPath = paramString1;
      this.mResources = paramHashSet;
      this.mAssetManager = paramAssetManager;
      this.mPackageName = paramString2;
      this.mPackageManager = paramPackageManager;
    }
    
    /* Error */
    @android.support.annotation.WorkerThread
    private boolean extractAPK(@NonNull File paramFile)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 28	io/flutter/view/ResourceExtractor$ExtractTask:mResources	Ljava/util/HashSet;
      //   4: invokevirtual 53	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   7: astore 4
      //   9: aload 4
      //   11: invokeinterface 59 1 0
      //   16: ifeq +232 -> 248
      //   19: aload 4
      //   21: invokeinterface 63 1 0
      //   26: checkcast 65	java/lang/String
      //   29: astore_2
      //   30: new 67	java/lang/StringBuilder
      //   33: dup
      //   34: invokespecial 68	java/lang/StringBuilder:<init>	()V
      //   37: astore_3
      //   38: aload_3
      //   39: ldc 70
      //   41: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   44: pop
      //   45: aload_3
      //   46: aload_2
      //   47: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: pop
      //   51: aload_3
      //   52: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   55: pop
      //   56: new 80	java/io/File
      //   59: dup
      //   60: aload_1
      //   61: aload_2
      //   62: invokespecial 83	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   65: astore_3
      //   66: aload_3
      //   67: invokevirtual 86	java/io/File:exists	()Z
      //   70: ifne -61 -> 9
      //   73: aload_3
      //   74: invokevirtual 90	java/io/File:getParentFile	()Ljava/io/File;
      //   77: ifnull +11 -> 88
      //   80: aload_3
      //   81: invokevirtual 90	java/io/File:getParentFile	()Ljava/io/File;
      //   84: invokevirtual 93	java/io/File:mkdirs	()Z
      //   87: pop
      //   88: aload_0
      //   89: getfield 30	io/flutter/view/ResourceExtractor$ExtractTask:mAssetManager	Landroid/content/res/AssetManager;
      //   92: aload_2
      //   93: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   96: astore 5
      //   98: new 101	java/io/FileOutputStream
      //   101: dup
      //   102: aload_3
      //   103: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   106: astore 6
      //   108: aload 5
      //   110: aload 6
      //   112: invokestatic 108	io/flutter/view/ResourceExtractor:access$200	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
      //   115: aload 6
      //   117: invokevirtual 113	java/io/OutputStream:close	()V
      //   120: aload 5
      //   122: ifnull -113 -> 9
      //   125: aload 5
      //   127: invokevirtual 116	java/io/InputStream:close	()V
      //   130: goto -121 -> 9
      //   133: astore_2
      //   134: goto -125 -> 9
      //   137: astore_2
      //   138: aconst_null
      //   139: astore_3
      //   140: aload_3
      //   141: ifnull +85 -> 226
      //   144: aload 6
      //   146: invokevirtual 113	java/io/OutputStream:close	()V
      //   149: aload_2
      //   150: athrow
      //   151: astore_3
      //   152: aload_3
      //   153: athrow
      //   154: astore_2
      //   155: aload 5
      //   157: ifnull +12 -> 169
      //   160: aload_3
      //   161: ifnull +79 -> 240
      //   164: aload 5
      //   166: invokevirtual 116	java/io/InputStream:close	()V
      //   169: aload_2
      //   170: athrow
      //   171: astore_1
      //   172: new 67	java/lang/StringBuilder
      //   175: dup
      //   176: invokespecial 68	java/lang/StringBuilder:<init>	()V
      //   179: astore_2
      //   180: aload_2
      //   181: ldc 118
      //   183: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   186: pop
      //   187: aload_2
      //   188: aload_1
      //   189: invokevirtual 121	java/io/IOException:getMessage	()Ljava/lang/String;
      //   192: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   195: pop
      //   196: ldc 123
      //   198: aload_2
      //   199: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   202: invokestatic 129	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   205: pop
      //   206: aload_0
      //   207: getfield 26	io/flutter/view/ResourceExtractor$ExtractTask:mDataDirPath	Ljava/lang/String;
      //   210: aload_0
      //   211: getfield 28	io/flutter/view/ResourceExtractor$ExtractTask:mResources	Ljava/util/HashSet;
      //   214: invokestatic 133	io/flutter/view/ResourceExtractor:access$100	(Ljava/lang/String;Ljava/util/HashSet;)V
      //   217: iconst_0
      //   218: ireturn
      //   219: astore_3
      //   220: aload_3
      //   221: athrow
      //   222: astore_2
      //   223: goto -83 -> 140
      //   226: aload 6
      //   228: invokevirtual 113	java/io/OutputStream:close	()V
      //   231: goto -82 -> 149
      //   234: astore_2
      //   235: aconst_null
      //   236: astore_3
      //   237: goto -82 -> 155
      //   240: aload 5
      //   242: invokevirtual 116	java/io/InputStream:close	()V
      //   245: goto -76 -> 169
      //   248: iconst_1
      //   249: ireturn
      //   250: astore_3
      //   251: goto -102 -> 149
      //   254: astore_3
      //   255: goto -86 -> 169
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	258	0	this	ExtractTask
      //   0	258	1	paramFile	File
      //   29	64	2	str	String
      //   133	1	2	localFileNotFoundException	java.io.FileNotFoundException
      //   137	13	2	localObject1	Object
      //   154	16	2	localObject2	Object
      //   179	20	2	localStringBuilder	StringBuilder
      //   222	1	2	localObject3	Object
      //   234	1	2	localObject4	Object
      //   37	104	3	localObject5	Object
      //   151	10	3	localThrowable1	java.lang.Throwable
      //   219	2	3	localThrowable2	java.lang.Throwable
      //   236	1	3	localObject6	Object
      //   250	1	3	localThrowable3	java.lang.Throwable
      //   254	1	3	localThrowable4	java.lang.Throwable
      //   7	13	4	localIterator	Iterator
      //   96	145	5	localInputStream	InputStream
      //   106	121	6	localFileOutputStream	java.io.FileOutputStream
      // Exception table:
      //   from	to	target	type
      //   30	88	133	java/io/FileNotFoundException
      //   88	98	133	java/io/FileNotFoundException
      //   125	130	133	java/io/FileNotFoundException
      //   164	169	133	java/io/FileNotFoundException
      //   169	171	133	java/io/FileNotFoundException
      //   240	245	133	java/io/FileNotFoundException
      //   108	115	137	finally
      //   98	108	151	java/lang/Throwable
      //   115	120	151	java/lang/Throwable
      //   149	151	151	java/lang/Throwable
      //   226	231	151	java/lang/Throwable
      //   152	154	154	finally
      //   30	88	171	java/io/IOException
      //   88	98	171	java/io/IOException
      //   125	130	171	java/io/IOException
      //   164	169	171	java/io/IOException
      //   169	171	171	java/io/IOException
      //   240	245	171	java/io/IOException
      //   108	115	219	java/lang/Throwable
      //   220	222	222	finally
      //   98	108	234	finally
      //   115	120	234	finally
      //   144	149	234	finally
      //   149	151	234	finally
      //   226	231	234	finally
      //   144	149	250	java/lang/Throwable
      //   164	169	254	java/lang/Throwable
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      paramVarArgs = new File(this.mDataDirPath);
      String str = ResourceExtractor.checkTimestamp(paramVarArgs, this.mPackageManager, this.mPackageName);
      if (str == null) {}
      do
      {
        return null;
        ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
      } while ((!extractAPK(paramVarArgs)) || (str == null));
      try
      {
        new File(paramVarArgs, str).createNewFile();
        return null;
      }
      catch (IOException paramVarArgs)
      {
        Log.w("ResourceExtractor", "Failed to write resource timestamp");
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.ResourceExtractor
 * JD-Core Version:    0.7.0.1
 */