package cooperation.weiyun.upload;

import awqz;
import awra;
import com.tencent.weiyun.uploader.IReporter;
import com.tencent.weiyun.uploader.IUploader;
import com.tencent.weiyun.uploader.IUploader.IUploadListener;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.UploadResponse.Builder;
import com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag;
import java.io.File;

public class WyUploadJob
  implements IUploader, Runnable
{
  protected UploadRequest a;
  protected volatile boolean mCanceled;
  private volatile int mLastErrorNo;
  private IUploader.IUploadListener mListener;
  protected File mSrcFile;
  protected volatile boolean mSuspended;
  
  awqz a(UploadRequest paramUploadRequest)
  {
    return new awra(paramUploadRequest, this);
  }
  
  UploadResponse a(int paramInt)
  {
    UploadResponse.Builder localBuilder = new UploadResponse.Builder();
    localBuilder.request(this.a);
    localBuilder.code(paramInt);
    return localBuilder.build();
  }
  
  public String[] calSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag)
  {
    return null;
  }
  
  public void cancel(UploadRequest paramUploadRequest)
  {
    if ((paramUploadRequest == null) || (this.a == null) || (this.a.requestKey() == null)) {}
    while (!this.a.requestKey().equals(paramUploadRequest.requestKey())) {
      return;
    }
    this.mCanceled = true;
  }
  
  public void cancelAll()
  {
    this.mCanceled = true;
  }
  
  public void cb(boolean paramBoolean, int paramInt)
  {
    UploadResponse localUploadResponse = a(paramInt);
    this.mListener.onUploadFinished(this.a, paramBoolean, localUploadResponse);
  }
  
  boolean doTransfer()
  {
    int i = a(this.a).transfer();
    setLastErrorNo(i);
    return (i == 1810002) || (i == 0);
  }
  
  void eEP()
  {
    this.mListener.onUploadCanceled(this.a);
  }
  
  public int getLastErrorNo()
  {
    return this.mLastErrorNo;
  }
  
  public boolean isAlive()
  {
    return (!this.mCanceled) && (!this.mSuspended);
  }
  
  public void notifyProgressChanged(long paramLong1, long paramLong2)
  {
    double d = paramLong1 / paramLong2;
    this.mListener.onUploadProgress(this.a, paramLong2, (float)d, 0L, 0L, 0L);
  }
  
  public void reportError(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (running() == true)
      {
        cb(true, 0);
        return;
      }
      if ((!Thread.interrupted()) && (isAlive())) {
        break label74;
      }
      if (this.mCanceled)
      {
        eEP();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (getLastErrorNo() == 0) {
        setLastErrorNo(1810014);
      }
      cb(false, getLastErrorNo());
      return;
    }
    cb(false, getLastErrorNo());
    return;
    label74:
    cb(false, getLastErrorNo());
  }
  
  boolean running()
  {
    if (!isAlive()) {}
    while (!doTransfer()) {
      return false;
    }
    return true;
  }
  
  public void setHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void setIpConfig(String paramString1, String paramString2) {}
  
  protected void setLastErrorNo(int paramInt)
  {
    this.mLastErrorNo = paramInt;
  }
  
  public void setNetType(int paramInt) {}
  
  public void setReporter(IReporter paramIReporter) {}
  
  public void speedDown() {}
  
  public void trialSpeedUp(int paramInt) {}
  
  public boolean upload(UploadRequest paramUploadRequest)
  {
    if (paramUploadRequest == null) {
      return false;
    }
    this.a = paramUploadRequest;
    this.mSrcFile = new File(this.a.path());
    this.mListener = this.a.listener();
    new Thread(this).start();
    return true;
  }
  
  public void vipSpeedUp() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.weiyun.upload.WyUploadJob
 * JD-Core Version:    0.7.0.1
 */