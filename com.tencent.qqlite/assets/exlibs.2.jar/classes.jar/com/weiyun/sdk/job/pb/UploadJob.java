package com.weiyun.sdk.job.pb;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.channel.ISender;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.BaseUploadJob;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.pb.PbContinueUploadAddressFetcher;
import com.weiyun.sdk.job.af.pb.PbUploadAddressFetcher;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.protocol.BaseCallback;
import com.weiyun.sdk.util.NetworkUtils;
import tencent.im.cs.cmd0x31b.Cmd0X31B.DeleteFileReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.DeleteFileRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ReqBody;

public class UploadJob
  extends BaseUploadJob
{
  private static final String TAG = "UploadJob";
  
  public UploadJob(long paramLong, UploadJobContext paramUploadJobContext)
  {
    super(paramLong, paramUploadJobContext);
  }
  
  public boolean checkContent()
  {
    if ((this.mJobContext.getSrcPath() == null) || (this.mJobContext.getFileName() == null) || ((this.mJobContext.getCurSize() >= this.mJobContext.getTotalSize()) && (this.mJobContext.getTotalSize() > 0L)))
    {
      setLastErrorNo(-10001);
      return false;
    }
    return true;
  }
  
  public boolean checkEnvironment()
  {
    if (!NetworkUtils.hasInternet(null))
    {
      setLastErrorNo(-10003);
      return false;
    }
    return true;
  }
  
  protected AddressFetcher createAddressFetcher(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new PbContinueUploadAddressFetcher(this.mJobContext.getFileName(), this.mJobContext.getFileId(), this.mJobContext.getSha());
    }
    return new PbUploadAddressFetcher(this.mJobContext.getFileName(), this.mJobContext.getTotalSize(), this.mJobContext.getMd5(), this.mJobContext.getSha());
  }
  
  public void deleteFileOnCloud(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = new Cmd0X31B.DeleteFileReqBody();
    paramString2.str_file_id.set(paramString1);
    paramString3 = new Cmd0X31B.ReqBody();
    paramString3.uint32_sub_cmd.set(7);
    paramString3.str_app_id.set("30223");
    paramString3.msg_delete_file_req_body.set(paramString2);
    SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_DELETE_FILE-7", paramString3.toByteArray(), new DeleteFileCallback(paramString1));
  }
  
  protected int handleFetchUrlFailed(int paramInt)
  {
    paramInt = super.handleFetchUrlFailed(paramInt);
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    try
    {
      synchronized (this.mJobContext)
      {
        this.mJobContext.wait(5000L);
        return paramInt;
      }
      return -10002;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  protected void removeLocalRecord(long paramLong, String paramString) {}
  
  private static class DeleteFileCallback
    extends BaseCallback<Cmd0X31B.DeleteFileRspBody>
  {
    private final String mFileId;
    
    public DeleteFileCallback(String paramString)
    {
      this.mFileId = paramString;
    }
    
    protected void handleResponse(IWyFileSystem.WyErrorStatus paramWyErrorStatus, Cmd0X31B.DeleteFileRspBody paramDeleteFileRspBody)
    {
      if (paramWyErrorStatus.errorCode != 0) {
        Log.w("UploadJob", "delete file failed. file id=" + this.mFileId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.pb.UploadJob
 * JD-Core Version:    0.7.0.1
 */