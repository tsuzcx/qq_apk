package com.tencent.thumbplayer.datatransport.resourceloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPReadWriteLock;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class TPAssetResourceLoadingDataRequest
  implements ITPAssetResourceLoadingDataRequest
{
  private static final boolean ENV_DEBUG = false;
  private static final int MAX_ASSET_READ_LEN = 1048576;
  private static final int MSG_RESPOND_WITH_DATA = 256;
  private static String TAG = "TPAssetResourceLoadingDataRequest";
  private long mCurrentOffset;
  private String mDataWritePath;
  private EventHandler mEventHandler;
  private TPReadWriteLock mLock;
  private RandomAccessFile mRandomAccessFile;
  private long mReadyDataTotalSize;
  private long mRealOffset;
  private int mRequestNum;
  private long mRequestedLength;
  private long mRequestedOffset;
  private boolean mRequestsAllDataToEndOfResource;
  
  public TPAssetResourceLoadingDataRequest(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.mRequestedOffset = paramLong1;
    this.mCurrentOffset = paramLong1;
    this.mRealOffset = paramLong1;
    this.mRequestedLength = paramLong2;
    this.mRequestsAllDataToEndOfResource = paramBoolean;
    this.mLock = new TPReadWriteLock();
  }
  
  private void internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (this.mEventHandler != null)
    {
      Message localMessage = this.mEventHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.mEventHandler.sendMessage(localMessage);
    }
  }
  
  private boolean writeDataToPath(long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        this.mRandomAccessFile = new RandomAccessFile(paramString, "rw");
        this.mRandomAccessFile.seek(paramLong);
        this.mRandomAccessFile.write(paramArrayOfByte);
        bool2 = true;
        bool1 = bool2;
      }
      catch (FileNotFoundException paramArrayOfByte)
      {
        boolean bool2;
        TPLogUtil.e(TAG, "file not found");
        if (this.mRandomAccessFile == null) {
          continue;
        }
        try
        {
          this.mRandomAccessFile.close();
          return false;
        }
        catch (IOException paramArrayOfByte)
        {
          TPLogUtil.e(TAG, "fail to close mRandomAccessFile");
          return false;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        TPLogUtil.e(TAG, "fail to write data");
        if (this.mRandomAccessFile == null) {
          continue;
        }
        try
        {
          this.mRandomAccessFile.close();
          return false;
        }
        catch (IOException paramArrayOfByte)
        {
          TPLogUtil.e(TAG, "fail to close mRandomAccessFile");
          return false;
        }
      }
      finally
      {
        if (this.mRandomAccessFile == null) {
          break label160;
        }
      }
      try
      {
        this.mRandomAccessFile.close();
        bool1 = bool2;
        return bool1;
      }
      catch (IOException paramArrayOfByte)
      {
        TPLogUtil.e(TAG, "fail to close mRandomAccessFile");
        return true;
      }
    }
    try
    {
      this.mRandomAccessFile.close();
      label160:
      throw paramArrayOfByte;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        TPLogUtil.e(TAG, "fail to close mRandomAccessFile");
      }
    }
  }
  
  public long getCurrentOffset()
  {
    this.mLock.readLock().lock();
    long l = this.mCurrentOffset;
    this.mLock.readLock().unlock();
    return l;
  }
  
  public int getDataReadyLength(long paramLong)
  {
    this.mLock.readLock().lock();
    long l = this.mRealOffset;
    this.mLock.readLock().unlock();
    if (paramLong >= l) {
      return -1;
    }
    if (paramLong < this.mRequestedOffset)
    {
      TPLogUtil.e(TAG, "Offset less than mRequestedOffset");
      return -1;
    }
    return (int)(l - paramLong);
  }
  
  public int getRequestNum()
  {
    return this.mRequestNum;
  }
  
  public long getRequestedLength()
  {
    return this.mRequestedLength;
  }
  
  public long getRequestedOffset()
  {
    return this.mRequestedOffset;
  }
  
  public void notifyDataReady(long paramLong1, long paramLong2)
  {
    if (paramLong1 + paramLong2 > this.mRequestedOffset + this.mRequestedLength)
    {
      TPLogUtil.e(TAG, "data exceed the max request offset");
      return;
    }
    if (paramLong1 < this.mRequestedOffset) {
      TPLogUtil.w(TAG, "the notify data offset is less than request offset");
    }
    if (paramLong1 + paramLong2 < this.mCurrentOffset)
    {
      TPLogUtil.e(TAG, "data not reach current offset");
      return;
    }
    this.mLock.writeLock().lock();
    this.mCurrentOffset = (paramLong1 + paramLong2);
    this.mRealOffset = this.mCurrentOffset;
    this.mLock.writeLock().unlock();
  }
  
  public void release()
  {
    if (this.mEventHandler != null)
    {
      this.mEventHandler.removeCallbacksAndMessages(null);
      this.mEventHandler = null;
    }
  }
  
  public void respondWithData(byte[] paramArrayOfByte)
  {
    if (this.mReadyDataTotalSize > this.mRequestedLength)
    {
      TPLogUtil.i(TAG, "respond full data");
      return;
    }
    int i = paramArrayOfByte.length;
    DataWriteParams localDataWriteParams = new DataWriteParams(null);
    localDataWriteParams.writeOffset = this.mCurrentOffset;
    localDataWriteParams.data = paramArrayOfByte;
    internalMessage(256, i, 0, localDataWriteParams);
    TPLogUtil.i(TAG, "respond data from:" + this.mCurrentOffset + ", dataLength:" + i);
    this.mLock.writeLock().lock();
    this.mCurrentOffset += i;
    long l = this.mReadyDataTotalSize;
    this.mReadyDataTotalSize = (i + l);
    this.mLock.writeLock().unlock();
  }
  
  public void setDataWritePath(String paramString)
  {
    this.mDataWritePath = paramString;
  }
  
  public void setDataWriteThreadLooper(Looper paramLooper)
  {
    this.mEventHandler = new EventHandler(paramLooper);
  }
  
  public void setRequestNum(int paramInt)
  {
    this.mRequestNum = paramInt;
  }
  
  static class DataWriteParams
  {
    byte[] data;
    long writeOffset;
  }
  
  class EventHandler
    extends Handler
  {
    EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      Object localObject = (TPAssetResourceLoadingDataRequest.DataWriteParams)paramMessage.obj;
      long l = ((TPAssetResourceLoadingDataRequest.DataWriteParams)localObject).writeOffset;
      localObject = ((TPAssetResourceLoadingDataRequest.DataWriteParams)localObject).data;
      int i = paramMessage.arg1;
      if (!TPAssetResourceLoadingDataRequest.this.writeDataToPath(l, (byte[])localObject, TPAssetResourceLoadingDataRequest.this.mDataWritePath))
      {
        TPLogUtil.e(TPAssetResourceLoadingDataRequest.TAG, "write data failed");
        return;
      }
      TPAssetResourceLoadingDataRequest.this.mLock.writeLock().lock();
      TPAssetResourceLoadingDataRequest.access$502(TPAssetResourceLoadingDataRequest.this, i + l);
      TPAssetResourceLoadingDataRequest.this.mLock.writeLock().unlock();
      TPLogUtil.i(TPAssetResourceLoadingDataRequest.TAG, "write data from " + l + " , with dataLength" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoadingDataRequest
 * JD-Core Version:    0.7.0.1
 */