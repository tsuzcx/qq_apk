package com.weiyun.sdk.job;

import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.FetchAddressException;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.transfer.DownloadTransfer;
import com.weiyun.sdk.job.transfer.Transfer;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class BaseDownloadJob
  extends BaseJob
{
  private static final int MAX_FETCH_URL_TIMES = 3;
  private static final String TAG = "BaseDownloadJob";
  protected AddressFetcher.DownloadAddress mDownloadAddress;
  protected final DownloadJobContext mJobContext;
  
  public BaseDownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext)
  {
    super(paramLong, paramDownloadJobContext);
    this.mJobContext = paramDownloadJobContext;
  }
  
  private String getSubFileName(String paramString)
  {
    Object localObject = paramString.getBytes();
    paramString = paramString.substring(paramString.lastIndexOf("."));
    localObject = new String((byte[])localObject, 0, 200 - paramString.getBytes().length);
    return ((String)localObject).substring(0, ((String)localObject).length() - 1) + paramString;
  }
  
  protected boolean checkCondition()
  {
    if (!checkContent()) {}
    while ((!checkEnvironment()) || (!checkFile())) {
      return false;
    }
    return true;
  }
  
  protected boolean checkContent()
  {
    if ((this.mJobContext == null) || (this.mJobContext.getFileId() == null) || (this.mJobContext.getParentDirKey() == null) || (this.mJobContext.getFileName() == null) || (this.mJobContext.getDestDirectoryPath() == null) || (this.mJobContext.getDestFileName() == null) || (this.mJobContext.getDestFilePath() == null) || (this.mJobContext.getDataFilePath() == null))
    {
      setLastErrorNo(-10001);
      return false;
    }
    return true;
  }
  
  public boolean checkEnvironment()
  {
    return true;
  }
  
  public boolean checkFile()
  {
    if (!Utils.checkDirAndCreate(this.mJobContext.getDestDirectoryPath()))
    {
      setLastErrorNo(-10007);
      return false;
    }
    if (!Utils.checkDirAndCreate(this.mJobContext.getDataDirectoryPath()))
    {
      setLastErrorNo(-10007);
      return false;
    }
    String str = this.mJobContext.getDestFileName();
    if (str.getBytes().length >= 200) {
      renameDestFile(getSubFileName(str));
    }
    while (Utils.checkFileExist(this.mJobContext.getDestFilePath())) {
      renameDestFile(Utils.generateNewFilename(this.mJobContext.getDestFileName()));
    }
    this.mJobContext.setCurSize(Math.max(0L, Utils.getFileSize(this.mJobContext.getDataFilePath())));
    return true;
  }
  
  protected boolean createDestFile(String paramString)
  {
    try
    {
      new FileOutputStream(new File(paramString)).close();
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      Log.w("BaseDownloadJob", paramString);
      return false;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.w("BaseDownloadJob", paramString);
      }
    }
  }
  
  protected abstract AddressFetcher createDownloadAddressFetcher();
  
  protected Transfer createTransfer(AddressFetcher.TransferAddress paramTransferAddress)
  {
    return new DownloadTransfer((AddressFetcher.DownloadAddress)paramTransferAddress, this.mJobContext, this);
  }
  
  protected boolean doTransfer()
  {
    return doTransferImpl();
  }
  
  protected boolean doTransferImpl()
  {
    AddressFetcher.TransferAddress localTransferAddress = getDownloadAddress();
    if (localTransferAddress == null)
    {
      setLastErrorNo(-10012);
      return false;
    }
    if (!checkEnvironment()) {
      return false;
    }
    long l1 = this.mJobContext.getCurSize();
    long l2 = System.currentTimeMillis();
    int i = createTransfer(localTransferAddress).transfer();
    setLastErrorNo(i);
    if (i != -10002) {
      reportDownloadStatistics(i, l2, l1);
    }
    return i == 0;
  }
  
  protected int fetchDownloadUrl()
  {
    try
    {
      AddressFetcher localAddressFetcher = createDownloadAddressFetcher();
      AddressFetcher.TransferAddress localTransferAddress = localAddressFetcher.getAddress(45);
      if (localTransferAddress == null)
      {
        Log.w("BaseDownloadJob", "get address failed!");
        return -10011;
      }
      handleFetchUrlSuccess(localAddressFetcher, localTransferAddress);
      return 0;
    }
    catch (AddressFetcher.FetchAddressException localFetchAddressException)
    {
      Log.w("BaseDownloadJob", "fetch download address failed: error code:" + localFetchAddressException.getErrorCode() + ", error message:" + localFetchAddressException.getMessage());
      setLastErrorString(localFetchAddressException.getMessage());
      return handleFetchUrlFailed(localFetchAddressException.getErrorCode());
    }
  }
  
  protected boolean fetchUrl()
  {
    return fetchUrlImpl();
  }
  
  protected boolean fetchUrlImpl()
  {
    boolean bool2 = false;
    int j = 0;
    long l = System.currentTimeMillis();
    int i = 0;
    int k;
    if (i >= 3) {
      k = j;
    }
    do
    {
      setLastErrorNo(k);
      if (k != -10002) {
        reportPreDownloadStatistics(k, l);
      }
      boolean bool1 = bool2;
      if (k == 0) {
        bool1 = true;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!isAlive());
        bool1 = bool2;
      } while (!checkEnvironment());
      Log.i("BaseDownloadJob", "start fetch download address. file=" + this.mJobContext.getFileName());
      j = fetchDownloadUrl();
      k = j;
    } while (j == 0);
    if (j == 5901) {
      i -= 1;
    }
    for (;;)
    {
      i += 1;
      break;
      setLastErrorNo(j);
    }
  }
  
  public AddressFetcher.TransferAddress getDownloadAddress()
  {
    return this.mDownloadAddress;
  }
  
  public DownloadJobContext getDownloadJobContext()
  {
    return this.mJobContext;
  }
  
  protected int handleFetchUrlFailed(int paramInt)
  {
    return paramInt;
  }
  
  protected void handleFetchUrlSuccess(AddressFetcher paramAddressFetcher, AddressFetcher.TransferAddress paramTransferAddress)
  {
    setDownloadAddress((AddressFetcher.DownloadAddress)paramTransferAddress);
  }
  
  protected void handleFileNameChanged(String paramString) {}
  
  public void renameDestFile(String paramString)
  {
    this.mJobContext.setDestFileName(paramString);
    handleFileNameChanged(paramString);
  }
  
  public void reportDownloadStatistics(int paramInt, long paramLong1, long paramLong2) {}
  
  public void reportDownloadTransferSize(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  public void reportPreDownloadStatistics(int paramInt, long paramLong) {}
  
  protected void setDownloadAddress(AddressFetcher.DownloadAddress paramDownloadAddress)
  {
    this.mDownloadAddress = paramDownloadAddress;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.BaseDownloadJob
 * JD-Core Version:    0.7.0.1
 */