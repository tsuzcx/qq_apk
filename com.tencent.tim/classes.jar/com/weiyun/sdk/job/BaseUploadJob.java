package com.weiyun.sdk.job;

import android.text.TextUtils;
import com.weiyun.sdk.Global;
import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.AddressFetcher.FetchAddressException;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.af.AddressFetcher.UploadAddress;
import com.weiyun.sdk.job.af.UploadAddressFetcher;
import com.weiyun.sdk.job.transfer.Transfer;
import com.weiyun.sdk.job.transfer.UploadTransfer;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.report.WeiyunReport;
import com.weiyun.sdk.report.WeiyunReportObj;
import com.weiyun.sdk.util.HashSumCalc;
import com.weiyun.sdk.util.NetworkUtils;
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
  protected static final int[] RETRY_ERROR_CODES = { 190041, 190042, 190043, 190045, 190071 };
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
  
  private void doSecondsUploadReport()
  {
    if (!Global.isInit()) {
      return;
    }
    WeiyunReportObj localWeiyunReportObj = new WeiyunReportObj(2);
    localWeiyunReportObj.network = NetworkUtils.getNetworkTypeForReport(Global.getContext());
    localWeiyunReportObj.flow_id = Global.generateRandomId(new Object[] { this.mJobContext.getSrcPath(), this });
    localWeiyunReportObj.flash_upload = true;
    localWeiyunReportObj.total_size = this.mJobContext.getTotalSize();
    localWeiyunReportObj.file_name = this.mJobContext.getFileName();
    localWeiyunReportObj.file_id = ('/' + this.mJobContext.getParentDirKey() + '/' + this.mJobContext.getFileId());
    localWeiyunReportObj.file_path = this.mJobContext.getSrcPath();
    localWeiyunReportObj.file_md5 = this.mJobContext.getMd5();
    localWeiyunReportObj.file_sha = this.mJobContext.getSha();
    WeiyunReport.uploadReport(localWeiyunReportObj);
  }
  
  public static void makeFakeTransfer(JobContext paramJobContext, Job paramJob)
  {
    long l1 = paramJobContext.getTotalSize() - paramJobContext.getCurSize();
    long l3 = Math.max(l1 / 100L, 655360L);
    Random localRandom = new Random();
    if (l1 > 0L) {
      if (l1 < l3) {
        break label110;
      }
    }
    label110:
    for (long l2 = l3;; l2 = l1)
    {
      for (;;)
      {
        l1 -= l2;
        paramJobContext.setCurSize(l2 + paramJobContext.getCurSize());
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
      paramJobContext.setCurSize(paramJobContext.getTotalSize());
      return;
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
  
  protected boolean canRetry(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = RETRY_ERROR_CODES;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
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
    boolean bool1 = true;
    boolean bool2 = true;
    if ((this.mJobContext.getMd5() == null) || (this.mJobContext.getSha() == null) || (this.mJobContext.getMd5().equals("")) || (this.mJobContext.getSha().equals("")))
    {
      if (!getFileSizeAndMd5()) {
        return bool2;
      }
      return false;
    }
    if (this.mLastModifyTime == 0L) {
      if (Utils.getFileSize(this.mJobContext.getSrcPath()) != this.mJobContext.getTotalSize()) {
        Log.w("BaseUploadJob", "file size has changed! file=" + this.mJobContext.getSrcPath());
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
      }
      else
      {
        this.mLastModifyTime = this.mSrcFile.lastModified();
        this.mJobContext.setModifyTime(this.mLastModifyTime);
        long l;
        do
        {
          bool1 = false;
          break;
          l = this.mSrcFile.lastModified();
        } while (this.mLastModifyTime == l);
        Log.w("BaseUploadJob", "file has modified! file=" + this.mJobContext.getSrcPath());
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
      doSecondsUploadReport();
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
    int i;
    for (;;)
    {
      try
      {
        localTransferAddress = paramAddressFetcher.getAddress(45);
        if (localTransferAddress != null) {
          continue;
        }
        Log.w("BaseUploadJob", "get address failed!");
        i = -10011;
      }
      catch (AddressFetcher.FetchAddressException localFetchAddressException)
      {
        AddressFetcher.TransferAddress localTransferAddress;
        Log.w("BaseUploadJob", "fetch upload address failed: error code:" + localFetchAddressException.getErrorCode() + ", error message:" + localFetchAddressException.getMessage());
        setLastErrorString(localFetchAddressException.getMessage());
        i = handleFetchUrlFailed(localFetchAddressException.getErrorCode());
        continue;
      }
      if ((paramAddressFetcher instanceof UploadAddressFetcher)) {
        paramAddressFetcher = (UploadAddressFetcher)paramAddressFetcher;
      }
      try
      {
        paramAddressFetcher = paramAddressFetcher.getFileId();
        if (!TextUtils.isEmpty(paramAddressFetcher)) {
          this.mJobContext.setFileId(paramAddressFetcher);
        }
        return i;
      }
      catch (IllegalStateException paramAddressFetcher)
      {
        Log.w("BaseUploadJob", "getFileId failed:" + paramAddressFetcher.getMessage());
      }
      handleFetchUrlSuccess(paramAddressFetcher, localTransferAddress);
      i = 0;
    }
    return i;
  }
  
  protected boolean fetchUrl()
  {
    long l = System.currentTimeMillis();
    int k = 0;
    int j = 0;
    int i = 0;
    if ((j < 3) && (k < 30))
    {
      if (!isAlive()) {}
      while ((!checkFile()) || (!checkEnvironment())) {
        return false;
      }
      setUploadAddress(null);
      l = System.currentTimeMillis();
      if (this.mJobContext.getFileId() == null)
      {
        Log.i("BaseUploadJob", "new start upload. file=" + this.mJobContext.getSrcPath());
        i = fetchUploadUrl(false);
        label102:
        if (i != 0) {
          break label175;
        }
      }
    }
    for (;;)
    {
      label106:
      setLastErrorNo(i);
      if (i != -10002) {
        reportPreUploadStatistics(i, l);
      }
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        return bool;
        Log.i("BaseUploadJob", "resume start upload. file=" + this.mJobContext.getSrcPath());
        i = fetchUploadUrl(true);
        break label102;
        label175:
        if (i == 1051)
        {
          Log.i("BaseUploadJob", "file name is duplicate. reduce try times.");
          j -= 1;
        }
        label251:
        do
        {
          for (;;)
          {
            k += 1;
            j += 1;
            break;
            if (i == 1020)
            {
              Log.i("BaseUploadJob", "file is not exist. reduce try times.");
              j -= 1;
            }
            else
            {
              if ((i != 5901) || (this.mJobContext.getFileId() == null)) {
                break label251;
              }
              j -= 1;
            }
          }
          setLastErrorNo(i);
        } while (canRetry(i));
        break label106;
      }
    }
  }
  
  protected boolean getFileSizeAndMd5()
  {
    String str2 = this.mJobContext.getSrcPath();
    File localFile = new File(str2);
    int i = 0;
    long l;
    Object localObject;
    String str1;
    if (i < 3)
    {
      if (!isAlive()) {
        return false;
      }
      l = localFile.lastModified();
      this.mJobContext.setTotalSize(Utils.getFileSize(str2));
      this.mJobContext.setCurSize(0L);
      localObject = HashSumCalc.getMd5AndShaHash(str2, this);
      if (localObject == null) {
        break label259;
      }
      str1 = (String)((HashMap)localObject).get("MD5");
      localObject = (String)((HashMap)localObject).get("SHA");
    }
    for (;;)
    {
      if ((str1 != null) && (!str1.equals(""))) {
        this.mJobContext.setMd5(str1);
      }
      while ((localObject != null) && (!((String)localObject).equals("")))
      {
        this.mJobContext.setSha((String)localObject);
        if (l != localFile.lastModified()) {
          break label252;
        }
        this.mLastModifyTime = l;
        this.mJobContext.setModifyTime(this.mLastModifyTime);
        return true;
        if (isAlive()) {
          setLastErrorNo(-10008);
        }
      }
      for (;;)
      {
        Log.e("BaseUploadJob", "file is modified always. file=" + str2);
        this.mJobContext.setMd5(null);
        this.mJobContext.setSha(null);
        return false;
        if (!isAlive()) {
          break;
        }
        setLastErrorNo(-10008);
      }
      label252:
      i += 1;
      break;
      label259:
      localObject = null;
      str1 = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.BaseUploadJob
 * JD-Core Version:    0.7.0.1
 */