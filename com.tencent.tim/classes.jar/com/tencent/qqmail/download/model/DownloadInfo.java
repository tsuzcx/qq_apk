package com.tencent.qqmail.download.model;

import android.content.Intent;
import com.tencent.moai.downloader.model.DownloadTask;
import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.util.ArrayList;
import org.apache.http.cookie.Cookie;

public class DownloadInfo
{
  public static final int OFF_LINE_OPT_TYPE_DELETE = 2;
  public static final int OFF_LINE_OPT_TYPE_MOVE = 1;
  public static final int OFF_LINE_OPT_TYPE_NORMAL = 0;
  public static final long UPDATE_PROGRESS_TIME = 300L;
  private int accountId;
  private AttachDownloadListener attachDownloadListener;
  private long attachId;
  private int attachType = 0;
  private ArrayList<Cookie> cookies;
  private long createTime;
  private String displayName;
  private long downloadSize;
  private DownloadTask downloadTask;
  private int downloadType = 3;
  private String fid;
  private String fileName;
  private String filePath;
  private long fileSize;
  private long ftnBytes;
  private String ftnCode;
  private String ftnKey;
  private int id;
  private ImageDownloadListener imageDownloadListener;
  private Intent intent;
  private boolean isFixProcess;
  private boolean isNotify;
  private String key;
  private long lastNotifyTime;
  private long mailId;
  private int notificationId;
  private int offlineType = 0;
  private String saveAsPath;
  private int sessionType = -1;
  private boolean shouldUpdateInfo = true;
  private int status;
  private String url;
  
  public static int generateId(int paramInt, String paramString1, String paramString2)
  {
    return QMMath.hashInt(paramInt + "_" + paramString1 + "_" + paramString2);
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public AttachDownloadListener getAttachDownloadListener()
  {
    return this.attachDownloadListener;
  }
  
  public long getAttachId()
  {
    return this.attachId;
  }
  
  public int getAttachType()
  {
    return this.attachType;
  }
  
  public ArrayList<Cookie> getCookies()
  {
    return this.cookies;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public long getDownloadSize()
  {
    return this.downloadSize;
  }
  
  public DownloadTask getDownloadTask()
  {
    return this.downloadTask;
  }
  
  public int getDownloadType()
  {
    return this.downloadType;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public long getFileSize()
  {
    return this.fileSize;
  }
  
  public long getFtnBytes()
  {
    return this.ftnBytes;
  }
  
  public String getFtnCode()
  {
    return this.ftnCode;
  }
  
  public String getFtnKey()
  {
    return this.ftnKey;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public ImageDownloadListener getImageDownloadListener()
  {
    return this.imageDownloadListener;
  }
  
  public Intent getIntent()
  {
    return this.intent;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public long getLastNotifyTime()
  {
    return this.lastNotifyTime;
  }
  
  public long getMailId()
  {
    return this.mailId;
  }
  
  public int getNotificationId()
  {
    return this.notificationId;
  }
  
  public int getOfflineType()
  {
    return this.offlineType;
  }
  
  public String getSaveAsPath()
  {
    return FileUtil.toDirPath(this.saveAsPath);
  }
  
  public int getSessionType()
  {
    return this.sessionType;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean isFixProcess()
  {
    return this.isFixProcess;
  }
  
  public boolean isNotify()
  {
    return this.isNotify;
  }
  
  public boolean isShouldUpdateInfo()
  {
    return this.shouldUpdateInfo;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAttachDownloadListener(AttachDownloadListener paramAttachDownloadListener)
  {
    this.attachDownloadListener = paramAttachDownloadListener;
  }
  
  public void setAttachId(long paramLong)
  {
    this.attachId = paramLong;
  }
  
  public void setAttachType(int paramInt)
  {
    this.attachType = paramInt;
  }
  
  public void setCookies(ArrayList<Cookie> paramArrayList)
  {
    this.cookies = paramArrayList;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }
  
  public void setDownloadSize(long paramLong)
  {
    this.downloadSize = paramLong;
  }
  
  public void setDownloadTask(DownloadTask paramDownloadTask)
  {
    this.downloadTask = paramDownloadTask;
  }
  
  public void setDownloadType(int paramInt)
  {
    this.downloadType = paramInt;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public void setFtnBytes(long paramLong)
  {
    this.ftnBytes = paramLong;
  }
  
  public void setFtnCode(String paramString)
  {
    this.ftnCode = paramString;
  }
  
  public void setFtnKey(String paramString)
  {
    this.ftnKey = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImageDownloadListener(ImageDownloadListener paramImageDownloadListener)
  {
    this.imageDownloadListener = paramImageDownloadListener;
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.intent = paramIntent;
  }
  
  public void setIsFixProcess(boolean paramBoolean)
  {
    this.isFixProcess = paramBoolean;
  }
  
  public void setIsNotify(boolean paramBoolean)
  {
    this.isNotify = paramBoolean;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setLastNotifyTime(long paramLong)
  {
    this.lastNotifyTime = paramLong;
  }
  
  public void setMailId(long paramLong)
  {
    this.mailId = paramLong;
  }
  
  public void setNotificationId(int paramInt)
  {
    this.notificationId = paramInt;
  }
  
  public void setOfflineType(int paramInt)
  {
    if (paramInt > this.offlineType) {
      this.offlineType = paramInt;
    }
  }
  
  public void setSaveAsPath(String paramString)
  {
    this.saveAsPath = paramString;
  }
  
  public void setSessionType(int paramInt)
  {
    this.sessionType = paramInt;
  }
  
  public void setShouldUpdateInfo(boolean paramBoolean)
  {
    this.shouldUpdateInfo = paramBoolean;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public String toString()
  {
    return "[url: " + this.url + ", path: " + this.filePath + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.model.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */