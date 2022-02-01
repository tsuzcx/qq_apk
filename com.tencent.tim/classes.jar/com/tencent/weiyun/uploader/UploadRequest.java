package com.tencent.weiyun.uploader;

import android.text.TextUtils;

public class UploadRequest
{
  private Object mBusinessData;
  private int mChannelCount;
  private final String mCheckKey;
  private final String mFileId;
  private final IUploader.IUploadListener mListener;
  private final String mPath;
  private final String mRequestKey;
  private final String mServerIp;
  private final String mServerName;
  private final int mServerPort;
  private final String mSha;
  private final long mSize;
  private final String[] mSliceSha;
  private long[] mStatisticTimes;
  private final long mUin;
  private final long mUploadedSize;
  
  private UploadRequest(Builder paramBuilder)
  {
    this.mRequestKey = paramBuilder.requestKey;
    this.mListener = paramBuilder.listener;
    this.mUin = paramBuilder.uin;
    this.mPath = paramBuilder.path;
    this.mSha = paramBuilder.sha;
    this.mSliceSha = paramBuilder.sliceSha;
    this.mSize = paramBuilder.size;
    this.mUploadedSize = paramBuilder.uploadedSize;
    this.mFileId = paramBuilder.fileId;
    this.mCheckKey = paramBuilder.checkKey;
    this.mServerName = paramBuilder.serverName;
    this.mServerIp = paramBuilder.serverIp;
    this.mServerPort = paramBuilder.serverPort;
    this.mChannelCount = paramBuilder.channelCount;
    this.mBusinessData = paramBuilder.businessData;
    this.mStatisticTimes = paramBuilder.statisticTimes;
  }
  
  public Object businessData()
  {
    return this.mBusinessData;
  }
  
  public int channelCount()
  {
    return this.mChannelCount;
  }
  
  public String checkKey()
  {
    return this.mCheckKey;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof UploadRequest)) {
        return false;
      }
      paramObject = (UploadRequest)paramObject;
      if (this.mRequestKey != null)
      {
        if (this.mRequestKey.equals(paramObject.mRequestKey)) {}
      }
      else {
        while (paramObject.mRequestKey != null) {
          return false;
        }
      }
      if (this.mListener != null) {
        return this.mListener.equals(paramObject.mListener);
      }
    } while (paramObject.mListener == null);
    return false;
  }
  
  public String fileId()
  {
    return this.mFileId;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.mRequestKey != null) {}
    for (int i = this.mRequestKey.hashCode();; i = 0)
    {
      if (this.mListener != null) {
        j = this.mListener.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public IUploader.IUploadListener listener()
  {
    return this.mListener;
  }
  
  public Builder newBuilder()
  {
    return new Builder(this, null);
  }
  
  public String path()
  {
    return this.mPath;
  }
  
  public String requestKey()
  {
    return this.mRequestKey;
  }
  
  public String serverIp()
  {
    return this.mServerIp;
  }
  
  public String serverName()
  {
    return this.mServerName;
  }
  
  public int serverPort()
  {
    return this.mServerPort;
  }
  
  public String sha()
  {
    return this.mSha;
  }
  
  public long size()
  {
    return this.mSize;
  }
  
  public String[] sliceSha()
  {
    return this.mSliceSha;
  }
  
  public long[] statisticTimes()
  {
    return this.mStatisticTimes;
  }
  
  public String toString()
  {
    return "UploadRequest{requestKey='" + this.mRequestKey + '\'' + ", listener=" + this.mListener + ", uin=" + this.mUin + ", path='" + this.mPath + '\'' + ", sha='" + this.mSha + '\'' + ", size=" + this.mSize + ", uploadedSize=" + this.mUploadedSize + ", fileId='" + this.mFileId + '\'' + ", checkKey='" + this.mCheckKey + '\'' + ", serverName='" + this.mServerName + '\'' + ", serverIp='" + this.mServerIp + '\'' + ", serverPort=" + this.mServerPort + ", channelCount=" + this.mChannelCount + ", businessData=" + this.mBusinessData + '}';
  }
  
  public long uin()
  {
    return this.mUin;
  }
  
  public long uploadedSize()
  {
    return this.mUploadedSize;
  }
  
  public static class Builder
  {
    private Object businessData;
    private int channelCount;
    private String checkKey;
    private String fileId;
    private IUploader.IUploadListener listener;
    private String path;
    private String requestKey;
    private String serverIp;
    private String serverName;
    private int serverPort;
    private String sha;
    private long size;
    private String[] sliceSha;
    private long[] statisticTimes;
    private long uin;
    private long uploadedSize;
    
    public Builder() {}
    
    private Builder(UploadRequest paramUploadRequest)
    {
      this.requestKey = paramUploadRequest.mRequestKey;
      this.listener = paramUploadRequest.mListener;
      this.uin = paramUploadRequest.mUin;
      this.path = paramUploadRequest.mPath;
      this.sha = paramUploadRequest.mSha;
      this.sliceSha = paramUploadRequest.mSliceSha;
      this.size = paramUploadRequest.mSize;
      this.uploadedSize = paramUploadRequest.mUploadedSize;
      this.fileId = paramUploadRequest.mFileId;
      this.checkKey = paramUploadRequest.mCheckKey;
      this.serverName = paramUploadRequest.mServerName;
      this.serverIp = paramUploadRequest.mServerIp;
      this.serverPort = paramUploadRequest.mServerPort;
      this.channelCount = paramUploadRequest.mChannelCount;
      this.businessData = paramUploadRequest.mBusinessData;
      this.statisticTimes = paramUploadRequest.mStatisticTimes;
    }
    
    public UploadRequest build()
    {
      if (TextUtils.isEmpty(this.path)) {
        throw new IllegalStateException("path is empty");
      }
      if (TextUtils.isEmpty(this.fileId)) {
        throw new IllegalStateException("fileId is empty");
      }
      if ((this.uin == 0L) || (TextUtils.isEmpty(this.sha)) || (TextUtils.isEmpty(this.checkKey)) || ((TextUtils.isEmpty(this.serverName)) && (TextUtils.isEmpty(this.serverIp)))) {
        throw new IllegalStateException("uin, sha, checkKey, serverName or serverIp is invalid.");
      }
      if (TextUtils.isEmpty(this.requestKey)) {
        this.requestKey = this.fileId;
      }
      return new UploadRequest(this, null);
    }
    
    public Builder businessData(Object paramObject)
    {
      this.businessData = paramObject;
      return this;
    }
    
    public Builder channelCount(int paramInt)
    {
      this.channelCount = paramInt;
      return this;
    }
    
    public Builder checkKey(String paramString)
    {
      this.checkKey = paramString;
      return this;
    }
    
    public Builder fileId(String paramString)
    {
      this.fileId = paramString;
      return this;
    }
    
    public Builder listener(IUploader.IUploadListener paramIUploadListener)
    {
      this.listener = paramIUploadListener;
      return this;
    }
    
    public Builder path(String paramString)
    {
      this.path = paramString;
      return this;
    }
    
    public Builder requestKey(String paramString)
    {
      this.requestKey = paramString;
      return this;
    }
    
    public Builder serverIp(String paramString)
    {
      this.serverIp = paramString;
      return this;
    }
    
    public Builder serverName(String paramString)
    {
      this.serverName = paramString;
      return this;
    }
    
    public Builder serverPort(int paramInt)
    {
      this.serverPort = paramInt;
      return this;
    }
    
    public Builder sha(String paramString)
    {
      this.sha = paramString;
      return this;
    }
    
    public Builder size(long paramLong)
    {
      this.size = paramLong;
      return this;
    }
    
    public Builder sliceSha(String[] paramArrayOfString)
    {
      this.sliceSha = paramArrayOfString;
      return this;
    }
    
    public Builder statisticTime(long paramLong1, long paramLong2, long paramLong3)
    {
      this.statisticTimes = new long[] { paramLong1, paramLong2, paramLong3 };
      return this;
    }
    
    public Builder uin(long paramLong)
    {
      this.uin = paramLong;
      return this;
    }
    
    public Builder uploadedSize(long paramLong)
    {
      this.uploadedSize = paramLong;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.uploader.UploadRequest
 * JD-Core Version:    0.7.0.1
 */