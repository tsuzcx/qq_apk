package com.weiyun.sdk.job.af.pb;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.Utils;
import java.io.File;
import java.io.IOException;

public class PbZeroSizeDownloadJob
  extends BaseDownloadJob
{
  private static final String TAG = "ZeroSizeDownloadJob";
  
  public PbZeroSizeDownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext)
  {
    super(paramLong, paramDownloadJobContext);
  }
  
  protected boolean checkCondition()
  {
    return true;
  }
  
  protected AddressFetcher createDownloadAddressFetcher()
  {
    return null;
  }
  
  protected boolean doTransfer()
  {
    Log.d("ZeroSizeDownloadJob", "doTransfer");
    File localFile = new File(this.mJobContext.getDestDirectoryPath());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    while (Utils.checkFileExist(this.mJobContext.getDestFilePath())) {
      renameDestFile(Utils.generateNewFilename(this.mJobContext.getDestFileName()));
    }
    boolean bool1 = true;
    localFile = new File(localFile, this.mJobContext.getDestFileName());
    try
    {
      if (localFile.exists())
      {
        bool1 = localFile.delete();
        Log.d("ZeroSizeDownloadJob", "delete " + bool1 + ": " + localFile.getPath());
      }
      boolean bool2 = bool1;
      if (bool1) {
        bool2 = localFile.createNewFile();
      }
      return bool2;
    }
    catch (IOException localIOException)
    {
      Log.w("ZeroSizeDownloadJob", localIOException);
    }
    return false;
  }
  
  protected boolean fetchUrl()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.job.af.pb.PbZeroSizeDownloadJob
 * JD-Core Version:    0.7.0.1
 */