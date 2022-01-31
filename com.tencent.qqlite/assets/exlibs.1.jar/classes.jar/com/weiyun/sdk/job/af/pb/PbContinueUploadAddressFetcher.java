package com.weiyun.sdk.job.af.pb;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.channel.ISender;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.af.AddressFetcher.FetchAddressException;
import com.weiyun.sdk.job.af.AddressFetcher.UploadAddress;
import com.weiyun.sdk.job.af.ContinueUploadAddressFetcher;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.log.LogTag;
import com.weiyun.sdk.protocol.BaseCallback;
import com.weiyun.sdk.util.UtilsMisc;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ResumeFileUploadReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ResumeFileUploadRspBody;

public class PbContinueUploadAddressFetcher
  extends ContinueUploadAddressFetcher
{
  public PbContinueUploadAddressFetcher(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, null, null, paramString3);
  }
  
  void handleResponse(int paramInt, String paramString, Cmd0X31B.ResumeFileUploadRspBody paramResumeFileUploadRspBody)
  {
    if ((paramInt != 0) || (paramResumeFileUploadRspBody == null))
    {
      failedGetAddress(new AddressFetcher.FetchAddressException(paramInt, paramString));
      if (LogTag.NeedSpecialLog()) {
        Log.w("FM-TransferFile", "get upload address failed. error code: " + paramInt);
      }
      return;
    }
    successGetAddress(new AddressFetcher.UploadAddress(paramResumeFileUploadRspBody.str_hostname.get(), paramResumeFileUploadRspBody.uint32_server_port.get(), paramResumeFileUploadRspBody.str_check_key.get(), 30223));
  }
  
  protected int sendRequest()
  {
    Cmd0X31B.ResumeFileUploadReqBody localResumeFileUploadReqBody = new Cmd0X31B.ResumeFileUploadReqBody();
    localResumeFileUploadReqBody.str_file_id.set(this.mFildId);
    localResumeFileUploadReqBody.str_file_name.set(UtilsMisc.getValidateFileName(this.mFileName));
    localResumeFileUploadReqBody.str_sha.set(this.mSha);
    Cmd0X31B.ReqBody localReqBody = new Cmd0X31B.ReqBody();
    localReqBody.uint32_sub_cmd.set(10);
    localReqBody.str_app_id.set("30223");
    localReqBody.msg_resume_file_upload_req_body.set(localResumeFileUploadReqBody);
    if (SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_RESUME_FILE_UPLOAD-10", localReqBody.toByteArray(), new ContinueUploadRequestCallback())) {
      return 0;
    }
    return -10011;
  }
  
  protected class ContinueUploadRequestCallback
    extends BaseCallback<Cmd0X31B.ResumeFileUploadRspBody>
  {
    protected ContinueUploadRequestCallback() {}
    
    protected void handleResponse(IWyFileSystem.WyErrorStatus paramWyErrorStatus, Cmd0X31B.ResumeFileUploadRspBody paramResumeFileUploadRspBody)
    {
      PbContinueUploadAddressFetcher.this.handleResponse(paramWyErrorStatus.errorCode, paramWyErrorStatus.errorMsg, paramResumeFileUploadRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.af.pb.PbContinueUploadAddressFetcher
 * JD-Core Version:    0.7.0.1
 */