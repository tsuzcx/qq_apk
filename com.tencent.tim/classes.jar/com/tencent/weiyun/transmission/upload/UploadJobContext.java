package com.tencent.weiyun.transmission.upload;

import android.text.TextUtils;
import com.tencent.weiyun.uploader.IUploader.IUploadListener;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.UploadRequest.Builder;
import com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.WeakHashMap;

public class UploadJobContext
  implements Comparable<UploadJobContext>
{
  private volatile long mBirthTime;
  private volatile boolean mCanceled;
  private UploadNative.CanceledFlag mCanceledFlag;
  private long mDbId;
  private final UploadFile mFile;
  private String mFileVersion;
  private volatile boolean mIgnoreNetLimit;
  private final String mJobOwnerUid;
  private final Set<UploadManager.IUploadStatusListener> mListeners;
  private volatile boolean mPriority;
  private volatile int mRank;
  private UploadRequest mRequest;
  private final StatisticsTimes mStatisticsTimes;
  private final StatusInfo mStatusInfo;
  
  private UploadJobContext(String paramString, UploadFile paramUploadFile, StatusInfo paramStatusInfo)
  {
    this.mJobOwnerUid = paramString;
    this.mFile = paramUploadFile;
    this.mStatusInfo = paramStatusInfo;
    this.mListeners = Collections.newSetFromMap(new WeakHashMap());
    this.mStatisticsTimes = new StatisticsTimes();
    this.mCanceledFlag = new UploadNative.CanceledFlag(false);
  }
  
  public static UploadJobContext createInstance(String paramString, UploadFile paramUploadFile, StatusInfo paramStatusInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramUploadFile == null) || (paramStatusInfo == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, file, destDirKey and statusInfo should be valid.");
    }
    return new UploadJobContext(paramString, paramUploadFile, paramStatusInfo);
  }
  
  public void addListener(UploadManager.IUploadStatusListener paramIUploadStatusListener)
  {
    if (paramIUploadStatusListener != null) {
      synchronized (this.mListeners)
      {
        this.mListeners.add(paramIUploadStatusListener);
        return;
      }
    }
  }
  
  public void addListeners(Collection<UploadManager.IUploadStatusListener> paramCollection)
  {
    if (paramCollection != null) {
      synchronized (this.mListeners)
      {
        this.mListeners.addAll(paramCollection);
        return;
      }
    }
  }
  
  public long birthTime()
  {
    return this.mBirthTime;
  }
  
  public StatusInfo cloneStatusInfo()
  {
    return this.mStatusInfo.clone();
  }
  
  public int compareTo(UploadJobContext paramUploadJobContext)
  {
    boolean bool1 = this.mStatusInfo.canRunning();
    boolean bool2 = paramUploadJobContext.mStatusInfo.canRunning();
    if ((bool1) && (!bool2)) {}
    do
    {
      do
      {
        do
        {
          return -1;
          if ((!bool1) && (bool2)) {
            return 1;
          }
          if ((!bool1) && (!bool2)) {
            return 0;
          }
        } while (this.mRank > paramUploadJobContext.mRank);
        if (this.mRank < paramUploadJobContext.mRank) {
          return 1;
        }
      } while ((this.mPriority) && (!paramUploadJobContext.mPriority));
      if ((!this.mPriority) && (paramUploadJobContext.mPriority)) {
        return 1;
      }
    } while (this.mBirthTime < paramUploadJobContext.mBirthTime);
    if (this.mBirthTime > paramUploadJobContext.mBirthTime) {
      return 1;
    }
    return 0;
  }
  
  public void createUploadRequest(UploadFile.UploadServerInfo paramUploadServerInfo, IUploader.IUploadListener paramIUploadListener)
  {
    if (paramUploadServerInfo == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("report", "Weiyun-Report");
    localHashMap.put("uid", this.mJobOwnerUid);
    localHashMap.put("db_id", Long.toString(dbId()));
    localHashMap.put("file_name", this.mFile.fileName);
    localHashMap.put("p_dir_key", this.mFile.pDirKey);
    localHashMap.put("file_id", paramUploadServerInfo.fileId);
    localHashMap.put("sha", this.mFile.sha);
    if (paramUploadServerInfo.fileExist)
    {
      paramUploadServerInfo.checkKey = "empty";
      paramUploadServerInfo.serverName = "empty";
      paramUploadServerInfo.serverIp = "empty";
    }
    String str1;
    int m;
    int i;
    int j;
    label156:
    int k;
    if (this.mJobOwnerUid == null)
    {
      str1 = "";
      m = str1.length();
      i = 0;
      j = -1;
      if (i >= m) {
        break label521;
      }
      if (j != -1) {
        break label207;
      }
      k = j;
      if (Character.isDigit(str1.charAt(i))) {
        k = i;
      }
    }
    label207:
    do
    {
      i += 1;
      j = k;
      break label156;
      str1 = this.mJobOwnerUid;
      break;
      k = j;
    } while (Character.isDigit(str1.charAt(i)));
    for (;;)
    {
      String str2;
      if ((j > -1) && (i > j))
      {
        str1 = str1.substring(j, i);
        UploadRequest.Builder localBuilder = new UploadRequest.Builder();
        if (!TextUtils.isEmpty(paramUploadServerInfo.fileId)) {
          break label467;
        }
        str2 = this.mFile.localPath + this.mFile.pDirKey;
        label296:
        paramUploadServerInfo = localBuilder.requestKey(str2).listener(paramIUploadListener).uin(Long.parseLong(str1)).fileId(paramUploadServerInfo.fileId).checkKey(paramUploadServerInfo.checkKey).serverName(paramUploadServerInfo.serverName).serverIp(paramUploadServerInfo.serverIp).serverPort(paramUploadServerInfo.serverPort).channelCount(paramUploadServerInfo.channelCount).businessData(localHashMap).uploadedSize(this.mStatusInfo.currSize);
        paramIUploadListener = this.mStatisticsTimes.getStatisticsTimes();
        paramUploadServerInfo.statisticTime(paramIUploadListener[0], paramIUploadListener[1], paramIUploadListener[2]);
        if (!TextUtils.isEmpty(this.mFile.compressedPath)) {
          break label476;
        }
        paramUploadServerInfo.path(this.mFile.localPath).sha(this.mFile.sha).sliceSha(this.mFile.sliceSha).size(this.mFile.fileSize);
      }
      for (;;)
      {
        this.mRequest = paramUploadServerInfo.build();
        return;
        str1 = "0";
        break;
        label467:
        str2 = paramUploadServerInfo.fileId;
        break label296;
        label476:
        paramUploadServerInfo.path(this.mFile.compressedPath).sha(this.mFile.compressedSha).sliceSha(this.mFile.compressedSliceSha).size(this.mFile.compressedSize);
      }
      label521:
      i = m;
    }
  }
  
  public long dbId()
  {
    return this.mDbId;
  }
  
  public UploadFile file()
  {
    return this.mFile;
  }
  
  public String fileVersion()
  {
    return this.mFileVersion;
  }
  
  public UploadNative.CanceledFlag getCanceledFlag()
  {
    return this.mCanceledFlag;
  }
  
  public void increaseRank()
  {
    this.mRank += 1;
  }
  
  public boolean isCanceled()
  {
    return this.mCanceled;
  }
  
  public boolean isIgnoreNetLimit()
  {
    return this.mIgnoreNetLimit;
  }
  
  public boolean isPriority()
  {
    return this.mPriority;
  }
  
  public Set<UploadManager.IUploadStatusListener> listeners()
  {
    Set localSet2 = Collections.newSetFromMap(new WeakHashMap());
    synchronized (this.mListeners)
    {
      localSet2.addAll(this.mListeners);
      return localSet2;
    }
  }
  
  public void removeListener(UploadManager.IUploadStatusListener paramIUploadStatusListener)
  {
    if (paramIUploadStatusListener != null) {
      synchronized (this.mListeners)
      {
        this.mListeners.remove(paramIUploadStatusListener);
        return;
      }
    }
  }
  
  public void resetRank()
  {
    this.mRank = 0;
  }
  
  public void setBirthTime(long paramLong)
  {
    this.mBirthTime = paramLong;
  }
  
  public void setCanceled(boolean paramBoolean)
  {
    this.mCanceled = paramBoolean;
    this.mCanceledFlag.setCanceled(paramBoolean);
  }
  
  public void setDbId(long paramLong)
  {
    this.mDbId = paramLong;
  }
  
  public void setFileVersion(String paramString)
  {
    this.mFileVersion = paramString;
  }
  
  public void setIgnoreNetLimit(boolean paramBoolean)
  {
    this.mIgnoreNetLimit = paramBoolean;
  }
  
  public void setPriority(boolean paramBoolean)
  {
    this.mPriority = paramBoolean;
  }
  
  public StatisticsTimes statisticsTimes()
  {
    return this.mStatisticsTimes;
  }
  
  public StatusInfo statusInfo()
  {
    return this.mStatusInfo;
  }
  
  public String uid()
  {
    return this.mJobOwnerUid;
  }
  
  public UploadRequest uploadRequest()
  {
    return this.mRequest;
  }
  
  public final class StatisticsTimes
  {
    private long calShaEndTime = 0L;
    private long calShaStartTime = 0L;
    private long compressEndTime = 0L;
    private long compressStartTime = 0L;
    private long fetchUrlEndTime = 0L;
    private long fetchUrlStartTime = 0L;
    
    StatisticsTimes() {}
    
    public long[] getStatisticsTimes()
    {
      long l3 = 0L;
      long l1;
      long l2;
      if (this.compressEndTime <= this.compressStartTime)
      {
        l1 = 0L;
        if (this.calShaEndTime > this.calShaStartTime) {
          break label73;
        }
        l2 = 0L;
        label31:
        if (this.fetchUrlEndTime > this.fetchUrlStartTime) {
          break label86;
        }
      }
      for (;;)
      {
        return new long[] { l1, l2, l3 };
        l1 = this.compressEndTime - this.compressStartTime;
        break;
        label73:
        l2 = this.calShaEndTime - this.calShaStartTime;
        break label31;
        label86:
        l3 = this.fetchUrlEndTime - this.fetchUrlStartTime;
      }
    }
    
    public void onCalShaEnd()
    {
      this.calShaEndTime = System.currentTimeMillis();
    }
    
    public void onCalShaStart()
    {
      this.calShaStartTime = System.currentTimeMillis();
    }
    
    public void onCompressEnd()
    {
      this.compressEndTime = System.currentTimeMillis();
    }
    
    public void onCompressStart()
    {
      this.compressStartTime = System.currentTimeMillis();
    }
    
    public void onFetchUrlEnd()
    {
      this.fetchUrlEndTime = System.currentTimeMillis();
    }
    
    public void onFetchUrlStart()
    {
      this.fetchUrlStartTime = System.currentTimeMillis();
    }
  }
  
  public static final class StatusInfo
    implements Cloneable
  {
    public static final int STATE_COMPRESSING = 2;
    public static final int STATE_FAILED = 6;
    public static final int STATE_INIT = 0;
    public static final int STATE_RUNNING = 3;
    public static final int STATE_SUCCESS = 5;
    public static final int STATE_SUSPEND = 4;
    public static final int STATE_WAIT = 1;
    public long adSpeed = 0L;
    public boolean autoBackupFlag = false;
    public long currSize = 0L;
    public int errorCode = 0;
    public String errorMsg = "";
    public long exSpeed = 0L;
    public String fileId = "";
    public String filePath = "";
    public String fileVersion = "";
    public UploadJobContext jobContext;
    public long speed = 0L;
    public volatile int state = 0;
    public long totalSize = 0L;
    
    public boolean canRestart()
    {
      return (this.state == 0) || (this.state == 6) || (this.state == 4) || ((this.state == 1) && ((this.errorCode == 1810003) || (this.errorCode == 1810004)));
    }
    
    public boolean canRunning()
    {
      return (this.state == 1) && (this.errorCode != 1810003) && (this.errorCode != 1810004);
    }
    
    public boolean canSuspend()
    {
      return (this.state == 0) || (this.state == 1) || (this.state == 2) || (this.state == 3);
    }
    
    public StatusInfo clone()
    {
      try
      {
        StatusInfo localStatusInfo = (StatusInfo)super.clone();
        return localStatusInfo;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
    
    public boolean isCompressing()
    {
      return this.state == 2;
    }
    
    public boolean waitingNet()
    {
      return (this.state == 1) && ((this.errorCode == 1810003) || (this.errorCode == 1810004));
    }
    
    public boolean waitingNetError(int paramInt)
    {
      return (paramInt == 1810003) || (paramInt == 1810004);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadJobContext
 * JD-Core Version:    0.7.0.1
 */