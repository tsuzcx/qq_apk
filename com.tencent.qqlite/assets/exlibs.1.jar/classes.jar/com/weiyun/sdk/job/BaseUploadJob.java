package com.weiyun.sdk.job;

import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.AddressFetcher.FetchAddressException;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.af.AddressFetcher.UploadAddress;
import com.weiyun.sdk.job.af.UploadAddressFetcher;
import com.weiyun.sdk.job.transfer.Transfer;
import com.weiyun.sdk.job.transfer.UploadTransfer;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.HashSumCalc;
import com.weiyun.sdk.util.Utils;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public abstract class BaseUploadJob
  extends BaseJob
{
  private static final int MAX_COUNT_MD5_TIMES = 3;
  private static final int MAX_FETCH_URL_TIMES = 3;
  private static final int REAL_MAX_FETCH_URL_TIMES = 30;
  private static final String TAG = "BaseUploadJob";
  protected final UploadJobContext mJobContext;
  protected long mLastModifyTime;
  protected final File mSrcFile;
  protected AddressFetcher.TransferAddress mUploadAddress;
  
  public BaseUploadJob(long paramLong, UploadJobContext paramUploadJobContext)
  {
    super(paramLong, paramUploadJobContext);
    this.mJobContext = paramUploadJobContext;
    this.mSrcFile = new File(paramUploadJobContext.getSrcPath());
    this.mLastModifyTime = paramUploadJobContext.getModifyTime();
  }
  
  public static void makeFakeTransfer(JobContext paramJobContext, Job paramJob)
  {
    long l1 = paramJobContext.getTotalSize() - paramJobContext.getCurSize();
    long l4 = Math.max(l1 / 100L, 655360L);
    Random localRandom = new Random();
    if (l1 <= 0L) {}
    for (;;)
    {
      for (;;)
      {
        paramJobContext.setCurSize(paramJobContext.getTotalSize());
        return;
        long l3 = l1;
        long l2 = l3;
        if (l3 >= l4) {
          l2 = l4;
        }
        l1 -= l2;
        paramJobContext.setCurSize(paramJobContext.getCurSize() + l2);
        paramJob.notifyProgressChanged(paramJobContext.getCurSize(), paramJobContext.getTotalSize());
        try
        {
          Thread.sleep(localRandom.nextInt(20) + 50);
        }
        catch (InterruptedException paramJob)
        {
          Log.w("BaseUploadJob", paramJob);
        }
      }
    }
  }
  
  private void processDuplicateFile()
  {
    Log.i("BaseUploadJob", "file is exist. file = " + this.mJobContext.getFileName());
    this.mJobContext.setContentExist(true);
    makeFakeTransfer(this.mJobContext, this);
    this.mJobContext.setCurSize(this.mJobContext.getTotalSize());
    notifyProgressChanged(this.mJobContext.getCurSize(), this.mJobContext.getTotalSize());
  }
  
  protected boolean checkCondition()
  {
    if (!checkContent()) {}
    while ((!checkFile()) || (!checkEnvironment())) {
      return false;
    }
    return true;
  }
  
  public boolean checkContent()
  {
    if ((this.mJobContext.getSrcPath() == null) || (this.mJobContext.getFileName() == null) || (this.mJobContext.getParentDirKey() == null) || ((this.mJobContext.getCurSize() >= this.mJobContext.getTotalSize()) && (this.mJobContext.getTotalSize() > 0L)))
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
    if (!this.mSrcFile.exists())
    {
      Log.w("BaseUploadJob", this.mJobContext.getSrcPath() + " is not exist!");
      setLastErrorNo(-10006);
      return false;
    }
    if (!this.mSrcFile.isFile())
    {
      Log.w("BaseUploadJob", this.mJobContext.getSrcPath() + " is not a file!");
      setLastErrorNo(-10010);
      return false;
    }
    if (checkFileModified())
    {
      handleFileModified();
      return false;
    }
    return true;
  }
  
  protected boolean checkFileModified()
  {
    boolean bool2;
    if ((this.mJobContext.getMd5() == null) || (this.mJobContext.getSha() == null) || (this.mJobContext.getMd5().equals("")) || (this.mJobContext.getSha().equals("")))
    {
      if (getFileSizeAndMd5())
      {
        bool2 = false;
        return bool2;
      }
      return true;
    }
    boolean bool1 = false;
    if (this.mLastModifyTime == 0L) {
      if (Utils.getFileSize(this.mJobContext.getSrcPath()) != this.mJobContext.getTotalSize())
      {
        Log.w("BaseUploadJob", "file size has changed! file=" + this.mJobContext.getSrcPath());
        bool1 = true;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      setLastErrorNo(-10009);
      return bool1;
      if (!HashSumCalc.getMD5Hash(this.mJobContext.getSrcPath(), this).equals(this.mJobContext.getMd5()))
      {
        Log.w("BaseUploadJob", "file content has changed! file=" + this.mJobContext.getSrcPath());
        bool1 = true;
      }
      else
      {
        this.mLastModifyTime = this.mSrcFile.lastModified();
        this.mJobContext.setModifyTime(this.mLastModifyTime);
        continue;
        long l = this.mSrcFile.lastModified();
        if (this.mLastModifyTime != l)
        {
          Log.w("BaseUploadJob", "file has modified! file=" + this.mJobContext.getSrcPath());
          bool1 = true;
        }
      }
    }
  }
  
  protected void cleanContext()
  {
    this.mJobContext.setFileId(null);
    this.mJobContext.setCurSize(0L);
  }
  
  protected abstract AddressFetcher createAddressFetcher(boolean paramBoolean);
  
  protected Transfer createTransfer(AddressFetcher.TransferAddress paramTransferAddress)
  {
    return new UploadTransfer((AddressFetcher.UploadAddress)paramTransferAddress, this.mJobContext, this);
  }
  
  public void deleteFileOnCloud(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  protected boolean doTransfer()
  {
    AddressFetcher.TransferAddress localTransferAddress = getUploadAddress();
    if (localTransferAddress == null)
    {
      l1 = this.mJobContext.getCurSize();
      processDuplicateFile();
      l2 = System.currentTimeMillis();
      this.mJobContext.setContentExist(true);
      reportUploadStatistics(0, l2, l1);
      reportUploadTransferSize(0, 0, l2, l2, l1, 0L, null);
      return true;
    }
    if (!checkFile()) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.mJobContext.getCurSize();
    int i = createTransfer(localTransferAddress).transfer();
    setLastErrorNo(i);
    if (i != -10002) {
      reportUploadStatistics(i, l1, l2);
    }
    return i == 0;
  }
  
  protected int fetchUploadUrl(boolean paramBoolean)
  {
    return fetchUrl(createAddressFetcher(paramBoolean));
  }
  
  protected int fetchUrl(AddressFetcher paramAddressFetcher)
  {
    try
    {
      AddressFetcher.TransferAddress localTransferAddress = paramAddressFetcher.getAddress(45);
      if (localTransferAddress == null)
      {
        Log.w("BaseUploadJob", "get address failed!");
        return -10011;
      }
      handleFetchUrlSuccess(paramAddressFetcher, localTransferAddress);
      return 0;
    }
    catch (AddressFetcher.FetchAddressException paramAddressFetcher)
    {
      Log.w("BaseUploadJob", "fetch upload address failed: error code:" + paramAddressFetcher.getErrorCode() + ", error message:" + paramAddressFetcher.getMessage());
      setLastErrorString(paramAddressFetcher.getMessage());
    }
    return handleFetchUrlFailed(paramAddressFetcher.getErrorCode());
  }
  
  protected boolean fetchUrl()
  {
    boolean bool2 = false;
    int i = 0;
    long l1 = System.currentTimeMillis();
    int j = 0;
    int k = 0;
    int m = i;
    long l2 = l1;
    if (j < 3)
    {
      if (k < 30) {
        break label76;
      }
      l2 = l1;
      m = i;
    }
    label76:
    do
    {
      setLastErrorNo(m);
      if (m != -10002) {
        reportPreUploadStatistics(m, l2);
      }
      boolean bool1 = bool2;
      if (m == 0) {
        bool1 = true;
      }
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!isAlive());
          bool1 = bool2;
        } while (!checkFile());
        bool1 = bool2;
      } while (!checkEnvironment());
      setUploadAddress(null);
      l1 = System.currentTimeMillis();
      if (this.mJobContext.getFileId() != null) {
        break;
      }
      Log.i("BaseUploadJob", "new start upload. file=" + this.mJobContext.getSrcPath());
      i = fetchUploadUrl(false);
      m = i;
      l2 = l1;
    } while (i == 0);
    label163:
    if (i == 1051)
    {
      Log.i("BaseUploadJob", "file name is duplicate. reduce try times.");
      j -= 1;
    }
    for (;;)
    {
      j += 1;
      k += 1;
      break;
      Log.i("BaseUploadJob", "resume start upload. file=" + this.mJobContext.getSrcPath());
      i = fetchUploadUrl(true);
      break label163;
      if (i == 1020)
      {
        Log.i("BaseUploadJob", "file is not exist. reduce try times.");
        j -= 1;
      }
      else if ((i == 5901) && (this.mJobContext.getFileId() != null))
      {
        j -= 1;
      }
      else
      {
        setLastErrorNo(i);
      }
    }
  }
  
  protected boolean getFileSizeAndMd5()
  {
    String str3 = this.mJobContext.getSrcPath();
    File localFile = new File(str3);
    int i = 0;
    for (;;)
    {
      if (i >= 3) {}
      for (;;)
      {
        Log.e("BaseUploadJob", "file is modified always. file=" + str3);
        this.mJobContext.setMd5(null);
        this.mJobContext.setSha(null);
        do
        {
          return false;
        } while (!isAlive());
        long l = localFile.lastModified();
        this.mJobContext.setTotalSize(Utils.getFileSize(str3));
        this.mJobContext.setCurSize(0L);
        String str1 = null;
        String str2 = null;
        HashMap localHashMap = HashSumCalc.getMd5AndShaHash(str3, this);
        if (localHashMap != null)
        {
          str1 = (String)localHashMap.get("MD5");
          str2 = (String)localHashMap.get("SHA");
        }
        if ((str1 != null) && (!str1.equals("")))
        {
          this.mJobContext.setMd5(str1);
          label170:
          if ((str2 == null) || (str2.equals(""))) {
            break label239;
          }
          this.mJobContext.setSha(str2);
        }
        label239:
        while (!isAlive())
        {
          if (l != localFile.lastModified()) {
            break label256;
          }
          this.mLastModifyTime = l;
          this.mJobContext.setModifyTime(this.mLastModifyTime);
          return true;
          if (!isAlive()) {
            break label170;
          }
          setLastErrorNo(-10008);
          break;
        }
        setLastErrorNo(-10008);
      }
      label256:
      i += 1;
    }
  }
  
  public AddressFetcher.TransferAddress getUploadAddress()
  {
    return this.mUploadAddress;
  }
  
  public UploadJobContext getUploadJobContext()
  {
    return this.mJobContext;
  }
  
  protected void handleCouldFileNotExist()
  {
    String str = this.mJobContext.getFileId();
    cleanContext();
    removeLocalRecord(getId(), str);
  }
  
  protected int handleFetchUrlFailed(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.w("BaseUploadJob", " fetch url for file=" + this.mJobContext.getFileName() + " get ret=" + paramInt);
      return paramInt;
    case 1051: 
      processFileNameDuplicate();
      return paramInt;
    case 1022: 
      Log.i("BaseUploadJob", "file is exist! file = " + this.mJobContext.getFileName());
      return 0;
    case 1057: 
      handleFileModified();
      return paramInt;
    }
    handleCouldFileNotExist();
    return paramInt;
  }
  
  protected void handleFetchUrlSuccess(AddressFetcher paramAddressFetcher, AddressFetcher.TransferAddress paramTransferAddress)
  {
    Log.i("BaseUploadJob", "fetch url for task " + getId() + " success. url:" + paramTransferAddress.toString());
    setUploadAddress((AddressFetcher.UploadAddress)paramTransferAddress);
    if ((paramAddressFetcher instanceof UploadAddressFetcher))
    {
      paramAddressFetcher = (UploadAddressFetcher)paramAddressFetcher;
      this.mJobContext.setFileId(paramAddressFetcher.getFileId());
    }
  }
  
  protected void handleFileModified()
  {
    String str1 = this.mJobContext.getFileId();
    String str2 = this.mJobContext.getParentDirKey();
    String str3 = this.mJobContext.getParentParentDirKey();
    cleanContext();
    if (str1 != null) {
      deleteFileOnCloud(str1, str2, str3, this.mJobContext.getFileName());
    }
    removeLocalRecord(getId(), str1);
    if (!getFileSizeAndMd5()) {
      Log.e("BaseUploadJob", "get file Size and md5 failed!");
    }
  }
  
  protected void processFileNameDuplicate()
  {
    String str = Utils.generateNewFilename(this.mJobContext.getFileName());
    this.mJobContext.setFileName(str);
  }
  
  protected abstract void removeLocalRecord(long paramLong, String paramString);
  
  public void reportPreUploadStatistics(int paramInt, long paramLong) {}
  
  public void reportUploadStatistics(int paramInt, long paramLong1, long paramLong2) {}
  
  public void reportUploadTransferSize(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString) {}
  
  protected void setUploadAddress(AddressFetcher.TransferAddress paramTransferAddress)
  {
    this.mUploadAddress = paramTransferAddress;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.BaseUploadJob
 * JD-Core Version:    0.7.0.1
 */