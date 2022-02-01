package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class MediaScanner
{
  static final String TAG = "MediaScanner";
  private static AtomicBoolean mIsScanning = new AtomicBoolean(false);
  public static AtomicBoolean misInitialized = new AtomicBoolean(false);
  private static MediaScanner sInstance = null;
  private String mExternalStorageDirectoryPath = null;
  private HashSet<String> mFileObserverPaths = new HashSet();
  private HashSet<FileObserver> mFileObservers = new HashSet();
  private HashSet<String> mMd5Set;
  private MediaDatabaseHelper mSqLiteOpenHelper;
  
  private MediaScanner() {}
  
  private MediaScanner(Context paramContext)
  {
    this.mSqLiteOpenHelper = MediaDatabaseHelper.getInstance(paramContext);
    paramContext = Environment.getExternalStorageDirectory();
    if (paramContext != null) {
      this.mExternalStorageDirectoryPath = paramContext.getAbsolutePath();
    }
    if (this.mSqLiteOpenHelper != null) {
      this.mMd5Set = this.mSqLiteOpenHelper.queryAllMediaScannerInfoMd5Set();
    }
  }
  
  private void addFileObserver(String paramString)
  {
    File localFile = new File(paramString);
    if ((localFile == null) || (!localFile.exists())) {}
    while (this.mFileObserverPaths.contains(paramString)) {
      return;
    }
    this.mFileObserverPaths.add(paramString);
    paramString = new MediaScannerFileObserver(sInstance, paramString);
    paramString.startWatching();
    this.mFileObservers.add(paramString);
  }
  
  public static void buildVideoMediaInfo(LocalMediaInfo paramLocalMediaInfo)
    throws Throwable
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramLocalMediaInfo.path);
    String str = localMediaMetadataRetriever.extractMetadata(9);
    label285:
    label417:
    label424:
    for (;;)
    {
      char[] arrayOfChar;
      int m;
      int i;
      int k;
      char c;
      try
      {
        paramLocalMediaInfo.mDuration = Long.parseLong(str);
        if (Build.VERSION.SDK_INT >= 17) {
          str = localMediaMetadataRetriever.extractMetadata(24);
        }
        try
        {
          paramLocalMediaInfo.rotation = Integer.parseInt(str);
          Object localObject;
          if (Build.VERSION.SDK_INT >= 14)
          {
            str = localMediaMetadataRetriever.extractMetadata(18);
            localObject = localMediaMetadataRetriever.extractMetadata(19);
          }
          try
          {
            paramLocalMediaInfo.mediaWidth = Integer.parseInt(str);
            paramLocalMediaInfo.mediaHeight = Integer.parseInt((String)localObject);
            StringBuilder localStringBuilder;
            if (Build.VERSION.SDK_INT >= 15)
            {
              str = localMediaMetadataRetriever.extractMetadata(23);
              if (str != null)
              {
                label221:
                try
                {
                  localObject = new ArrayList(3);
                  localStringBuilder = new StringBuilder();
                  arrayOfChar = str.toCharArray();
                  m = arrayOfChar.length;
                  i = 0;
                  k = 0;
                }
                catch (NumberFormatException paramLocalMediaInfo) {}
                int j = i;
                if (localStringBuilder.length() > 0)
                {
                  ((ArrayList)localObject).add(Integer.valueOf((int)(Double.parseDouble(localStringBuilder.toString()) * 1000000.0D)));
                  localStringBuilder.setLength(0);
                  j = i + 1;
                }
                localStringBuilder.append(c);
                i = j;
                break label417;
                if ((!Character.isDigit(c)) && (c != '.')) {
                  continue;
                }
                localStringBuilder.append(c);
                break label417;
              }
            }
            localMediaMetadataRetriever.release();
            return;
            QLog.e("MediaScanner", 2, "Can not under stand the location string: " + str + " !");
            break label417;
            if (localStringBuilder.length() > 0) {
              ((ArrayList)localObject).add(Integer.valueOf((int)(Double.parseDouble(localStringBuilder.toString()) * 1000000.0D)));
            }
            if (((ArrayList)localObject).size() < 2) {
              continue;
            }
            paramLocalMediaInfo.latitude = ((Integer)((ArrayList)localObject).get(0)).intValue();
            paramLocalMediaInfo.longitude = ((Integer)((ArrayList)localObject).get(1)).intValue();
            continue;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            continue;
          }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          continue;
        }
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        continue;
      }
      for (;;)
      {
        if (k >= m) {
          break label424;
        }
        c = arrayOfChar[k];
        if (i >= 2) {
          break label285;
        }
        if ((c == '+') || (c == '-') || (c == '\n')) {
          break;
        }
        if (c != 0) {
          break label221;
        }
        break;
        k += 1;
      }
    }
  }
  
  public static int convertGpsToDegreeE6(String paramString)
  {
    paramString = paramString.split(",", 3);
    String[] arrayOfString = paramString[0].split("/", 2);
    double d1 = Double.valueOf(arrayOfString[0]).doubleValue() / Double.valueOf(arrayOfString[1]).doubleValue();
    arrayOfString = paramString[1].split("/", 2);
    double d3 = Double.valueOf(arrayOfString[0]).doubleValue() / Double.valueOf(arrayOfString[1]).doubleValue();
    paramString = paramString[2].split("/", 2);
    double d2 = Double.valueOf(paramString[0]).doubleValue() / Double.valueOf(paramString[1]).doubleValue();
    d3 /= 60.0D;
    return (int)((d2 / 3600.0D + (d1 + d3)) * 1000000.0D);
  }
  
  @TargetApi(10)
  private MediaScannerInfo createMediaScannerInfo(MediaMetadataRetriever paramMediaMetadataRetriever, String paramString1, String paramString2)
  {
    paramMediaMetadataRetriever = new File(paramString2);
    if (paramMediaMetadataRetriever.exists()) {
      try
      {
        MediaScannerInfo localMediaScannerInfo = new MediaScannerInfo();
        localMediaScannerInfo.duration = 0L;
        localMediaScannerInfo.modifiedDate = (paramMediaMetadataRetriever.lastModified() / 1000L);
        localMediaScannerInfo.fileSize = paramMediaMetadataRetriever.length();
        localMediaScannerInfo.name = paramString2.substring(paramString2.lastIndexOf("/") + 1);
        localMediaScannerInfo.path = paramString2;
        localMediaScannerInfo.folderPath = paramString1;
        localMediaScannerInfo.mimeType = "video/mp4";
        localMediaScannerInfo.md5 = String.valueOf(localMediaScannerInfo.fileSize);
        return localMediaScannerInfo;
      }
      catch (Exception paramMediaMetadataRetriever)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaScanner", 2, "createMediaScannerInfo() error=" + paramMediaMetadataRetriever.getMessage());
        }
      }
    }
    return null;
  }
  
  @TargetApi(10)
  private void doScanFolder(String paramString, boolean paramBoolean)
    throws IOException
  {
    Object localObject = new File(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MediaScanner", 2, "doScanFolder() folderPath=" + paramString);
    }
    if (localObject == null) {}
    label47:
    label332:
    do
    {
      do
      {
        do
        {
          break label47;
          do
          {
            return;
          } while (this.mSqLiteOpenHelper == null);
          if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
            break label332;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MediaScanner", 2, "doScanFolder() videoFolder.exists()=true");
          }
          if ((!paramBoolean) || (isNomediaFileExisit(paramString))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MediaScanner", 2, "doScanFolder() isNomediaFileExisit()=false, return");
        return;
      } while (needScanFolder(paramString) != true);
      localObject = ((File)localObject).listFiles();
      HashSet localHashSet = this.mSqLiteOpenHelper.queryAllMediaScannerInfoPathSetByFolder(paramString);
      ArrayList localArrayList = new ArrayList();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        if (i < j)
        {
          MediaScannerInfo localMediaScannerInfo = localObject[i];
          String str;
          if (localMediaScannerInfo.getName().endsWith(".mp4"))
          {
            str = paramString + "/" + localMediaScannerInfo.getName();
            if ((localHashSet.contains(str)) || (this.mMd5Set == null) || (this.mMd5Set.contains(String.valueOf(localMediaScannerInfo.length())))) {
              break label297;
            }
            localMediaScannerInfo = createMediaScannerInfo(null, paramString, str);
            if (localMediaScannerInfo != null)
            {
              localArrayList.add(localMediaScannerInfo);
              this.mMd5Set.add(String.valueOf(localMediaScannerInfo.fileSize));
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localHashSet.remove(str);
          }
        }
      }
      this.mSqLiteOpenHelper.deleteMediaScannerInfoByPathSet(localHashSet);
      this.mSqLiteOpenHelper.insertMediaScannerInfoByList(localArrayList);
      updateScanFolderInfo(paramString);
      return;
    } while (!QLog.isColorLevel());
    label297:
    QLog.d("MediaScanner", 2, "doScanFolder() videoFolder.exists() = false");
  }
  
  private void doScanWechatVideos()
    throws IOException
  {
    if ((this.mExternalStorageDirectoryPath == null) || (this.mSqLiteOpenHelper == null)) {}
    for (;;)
    {
      return;
      String str = this.mExternalStorageDirectoryPath + "/tencent/MicroMsg";
      File[] arrayOfFile = new File(str).listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = arrayOfFile[i];
          if ((((File)localObject).isDirectory()) && (((File)localObject).getName().length() == 32))
          {
            localObject = str + "/" + ((File)localObject).getName() + "/video";
            doScanFolder((String)localObject, true);
            addFileObserver((String)localObject);
          }
          i += 1;
        }
      }
    }
  }
  
  public static MediaScanner getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new MediaScanner(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  private boolean isNomediaFileExisit(String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("MediaScanner", 2, "isNomediaFileExisit() folderpath=" + paramString + ", mExternalStorageDirectoryPath=" + this.mExternalStorageDirectoryPath);
    }
    if (new File(this.mExternalStorageDirectoryPath).equals(new File(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaScanner", 2, "isNomediaFileExisit() root folder, return false");
      }
      bool = false;
    }
    File localFile;
    do
    {
      return bool;
      localFile = new File(paramString + "/.nomedia");
      if (localFile.exists() != true) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MediaScanner", 2, "isNomediaFileExisit() nomediaFile=" + localFile + " exist, return true");
    return true;
    return isNomediaFileExisit(new File(paramString).getParent());
  }
  
  private boolean needScanFolder(String paramString)
  {
    long l = new File(paramString).lastModified();
    paramString = this.mSqLiteOpenHelper.queryMediaScannerFolderInfoByFolderpath(paramString);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaScanner", 2, "needScanFolder() lastModified=" + l + ", info.modifiedDate=" + paramString.modifiedDate);
      }
      if (l == paramString.modifiedDate) {
        return false;
      }
    }
    return true;
  }
  
  private void preScan()
  {
    if (this.mSqLiteOpenHelper == null) {}
    HashSet localHashSet;
    Iterator localIterator;
    do
    {
      return;
      localHashSet = this.mSqLiteOpenHelper.queryAllMediaScannerFolderPathSet();
      localIterator = localHashSet.iterator();
    } while ((localHashSet == null) || (localIterator == null));
    while (localIterator.hasNext())
    {
      File localFile = new File((String)localIterator.next());
      if ((localFile != null) && (localFile.exists())) {
        localIterator.remove();
      }
    }
    this.mSqLiteOpenHelper.deleteMediaScannerInfoByFolderPathSet(localHashSet);
  }
  
  private void updateScanFolderInfo(String paramString)
  {
    Object localObject = new File(paramString);
    if (localObject == null) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
          l = ((File)localObject).lastModified();
          localObject = this.mSqLiteOpenHelper.queryMediaScannerFolderInfoByFolderpath(paramString);
          if (localObject == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MediaScanner", 2, "needScanFolder() lastModified=" + l + ", info.modifiedDate=" + ((MediaScannerFolderInfo)localObject).modifiedDate);
          }
        } while (l <= ((MediaScannerFolderInfo)localObject).modifiedDate);
        ((MediaScannerFolderInfo)localObject).modifiedDate = l;
        this.mSqLiteOpenHelper.updateMediaScnnerFolderInfo((MediaScannerFolderInfo)localObject);
      } while (!QLog.isColorLevel());
      QLog.d("MediaScanner", 2, "needScanFolder() lastModified > info.modifiedDate , run updateMediaScnnerFolderInfo()");
      return;
      localObject = new MediaScannerFolderInfo();
      ((MediaScannerFolderInfo)localObject).folderpath = paramString;
      ((MediaScannerFolderInfo)localObject).modifiedDate = l;
      this.mSqLiteOpenHelper.insertMediaScnnerFolderInfo((MediaScannerFolderInfo)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("MediaScanner", 2, "updateScanFolderInfo() run insertMediaScnnerFolderInfo()");
  }
  
  public void buildAndUpdateVideo(LocalMediaInfo paramLocalMediaInfo)
    throws Throwable
  {
    buildVideoMediaInfo(paramLocalMediaInfo);
    this.mSqLiteOpenHelper.updateMediaScnnerInfoDuration(paramLocalMediaInfo.path, paramLocalMediaInfo.mDuration);
  }
  
  public void doScan()
  {
    for (;;)
    {
      try
      {
        boolean bool = "mounted".equals(Environment.getExternalStorageState());
        if (!bool) {
          return;
        }
        if ((misInitialized.get() == true) || (mIsScanning.get())) {
          continue;
        }
        mIsScanning.set(true);
        if (QLog.isColorLevel()) {
          QLog.d("MediaScanner", 2, "doScan() start");
        }
      }
      finally {}
      try
      {
        preScan();
        doScanWechatVideos();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        mIsScanning.set(false);
        misInitialized.set(true);
        continue;
      }
      finally
      {
        mIsScanning.set(false);
        misInitialized.set(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MediaScanner", 2, "doScan() finish");
      }
    }
  }
  
  /* Error */
  public ArrayList<MediaScannerInfo> getMediaScannerInfos(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 63	com/tencent/mobileqq/activity/photo/MediaScanner:mSqLiteOpenHelper	Lcom/tencent/mobileqq/activity/photo/MediaDatabaseHelper;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnonnull +7 -> 22
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_3
    //   21: areturn
    //   22: ldc_w 471
    //   25: invokestatic 474	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   28: invokevirtual 475	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq -13 -> 18
    //   34: aload 4
    //   36: astore_3
    //   37: iload_2
    //   38: iconst_m1
    //   39: if_icmpeq +8 -> 47
    //   42: iload_2
    //   43: invokestatic 495	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   46: astore_3
    //   47: iload_1
    //   48: ifne +15 -> 63
    //   51: aload_0
    //   52: getfield 63	com/tencent/mobileqq/activity/photo/MediaScanner:mSqLiteOpenHelper	Lcom/tencent/mobileqq/activity/photo/MediaDatabaseHelper;
    //   55: aload_3
    //   56: invokevirtual 499	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:queryAllMediaScannerInfo	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   59: astore_3
    //   60: goto -42 -> 18
    //   63: aload_0
    //   64: getfield 63	com/tencent/mobileqq/activity/photo/MediaScanner:mSqLiteOpenHelper	Lcom/tencent/mobileqq/activity/photo/MediaDatabaseHelper;
    //   67: aload_3
    //   68: invokevirtual 502	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:queryAllLongVideoMediaScannerInfo	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   71: astore_3
    //   72: goto -54 -> 18
    //   75: astore_3
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_3
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	MediaScanner
    //   0	80	1	paramBoolean	boolean
    //   0	80	2	paramInt	int
    //   4	68	3	localObject1	Object
    //   75	4	3	localObject2	Object
    //   1	34	4	localObject3	Object
    //   11	3	5	localMediaDatabaseHelper	MediaDatabaseHelper
    // Exception table:
    //   from	to	target	type
    //   7	13	75	finally
    //   22	34	75	finally
    //   42	47	75	finally
    //   51	60	75	finally
    //   63	72	75	finally
  }
  
  /* Error */
  public int getMediaScannerInfosCount()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 63	com/tencent/mobileqq/activity/photo/MediaScanner:mSqLiteOpenHelper	Lcom/tencent/mobileqq/activity/photo/MediaDatabaseHelper;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: ldc_w 471
    //   20: invokestatic 474	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   23: invokevirtual 475	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq -13 -> 13
    //   29: aload_0
    //   30: getfield 63	com/tencent/mobileqq/activity/photo/MediaScanner:mSqLiteOpenHelper	Lcom/tencent/mobileqq/activity/photo/MediaDatabaseHelper;
    //   33: invokevirtual 508	com/tencent/mobileqq/activity/photo/MediaDatabaseHelper:queryAllMediaScannerInfoCnt	()I
    //   36: istore_1
    //   37: goto -24 -> 13
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	MediaScanner
    //   1	36	1	i	int
    //   8	2	2	localMediaDatabaseHelper	MediaDatabaseHelper
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	40	finally
    //   17	37	40	finally
  }
  
  @TargetApi(10)
  public void handleFileObserverEvent(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaScanner", 2, "handleFileObserverEvent() is called event=" + paramInt);
    }
    if (!misInitialized.get()) {}
    do
    {
      do
      {
        do
        {
          File localFile;
          do
          {
            return;
            switch (paramInt)
            {
            default: 
              return;
            case 8: 
            case 128: 
              paramString2 = paramString1 + "/" + paramString2;
              localFile = new File(paramString2);
              if ((this.mMd5Set == null) && (this.mSqLiteOpenHelper != null)) {
                this.mMd5Set = this.mSqLiteOpenHelper.queryAllMediaScannerInfoMd5Set();
              }
              break;
            }
          } while ((this.mMd5Set == null) || (this.mSqLiteOpenHelper == null));
          if (!localFile.exists()) {
            break;
          }
          paramString1 = createMediaScannerInfo(null, paramString1, paramString2);
          if ((paramString1 != null) && (!this.mMd5Set.contains(paramString1.md5)))
          {
            this.mMd5Set.add(paramString1.md5);
            this.mSqLiteOpenHelper.insertMediaScannerInfo(paramString1);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MediaScanner", 2, "handleFileObserverEvent() info=null");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("MediaScanner", 2, "handleFileObserverEvent() mMd5Set.contains( md5 ) = true");
      return;
      paramString1 = paramString1 + "/" + paramString2;
      paramString2 = new File(paramString1);
    } while ((paramString2 == null) || (paramString2.exists() == true) || (this.mSqLiteOpenHelper == null));
    paramString2 = new HashSet();
    paramString2.add(paramString1);
    this.mSqLiteOpenHelper.deleteMediaScannerInfoByPathSet(paramString2);
  }
  
  @TargetApi(10)
  public void queryMediaInfoAsync(OnMediaInfoScannerListener paramOnMediaInfoScannerListener, LocalMediaInfo paramLocalMediaInfo)
  {
    paramOnMediaInfoScannerListener = new WeakReference(paramOnMediaInfoScannerListener);
    paramOnMediaInfoScannerListener = new MediaScanner.2(this, new WeakReference(paramLocalMediaInfo), paramOnMediaInfoScannerListener);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManagerV2.excute(paramOnMediaInfoScannerListener, 64, null, true);
      return;
    }
    paramOnMediaInfoScannerListener.run();
  }
  
  @TargetApi(10)
  public void queryMediaInfoDuration(OnMediaScannerListener paramOnMediaScannerListener, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    paramOnMediaScannerListener = new WeakReference(paramOnMediaScannerListener);
    ThreadManagerV2.excute(new MediaScanner.1(this, new WeakReference(paramLocalMediaInfo), paramOnMediaScannerListener, paramInt), 64, null, true);
  }
  
  public static abstract interface OnMediaInfoScannerListener
  {
    public abstract void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean);
  }
  
  public static abstract interface OnMediaScannerListener
  {
    public abstract void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaScanner
 * JD-Core Version:    0.7.0.1
 */