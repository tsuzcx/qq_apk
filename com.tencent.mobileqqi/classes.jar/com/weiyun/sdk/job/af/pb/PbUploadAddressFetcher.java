package com.weiyun.sdk.job.af.pb;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.channel.ISender;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.af.AddressFetcher.FetchAddressException;
import com.weiyun.sdk.job.af.AddressFetcher.UploadAddress;
import com.weiyun.sdk.job.af.UploadAddressFetcher;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.log.LogTag;
import com.weiyun.sdk.protocol.BaseCallback;
import com.weiyun.sdk.util.UtilsMisc;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.Upload2QCloudReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.Upload2QCloudRspBody;

public class PbUploadAddressFetcher
  extends UploadAddressFetcher
{
  private static final int DEFAULT_DEST_TYPE = 1;
  private static final int DEFAULT_UPLOAD_TYPE = 0;
  
  public PbUploadAddressFetcher(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    super(paramString1, null, null, paramLong, paramString2, paramString3, null, null, null);
  }
  
  protected void handleResponse(int paramInt, String paramString, Cmd0X31B.Upload2QCloudRspBody paramUpload2QCloudRspBody)
  {
    if ((paramInt != 0) || (paramUpload2QCloudRspBody == null))
    {
      failedGetAddress(new AddressFetcher.FetchAddressException(paramInt, paramString));
      if (LogTag.NeedSpecialLog()) {
        Log.w("FM-TransferFile", "get upload address failed. error code: " + paramInt);
      }
      return;
    }
    this.mFileId = paramUpload2QCloudRspBody.str_file_id.get();
    this.mDone = true;
    successGetAddress(new AddressFetcher.UploadAddress(paramUpload2QCloudRspBody.str_host.get(), paramUpload2QCloudRspBody.uint32_port.get(), paramUpload2QCloudRspBody.str_check_sum.get(), 30223));
  }
  
  protected int sendRequest()
  {
    Cmd0X31B.Upload2QCloudReqBody localUpload2QCloudReqBody = new Cmd0X31B.Upload2QCloudReqBody();
    localUpload2QCloudReqBody.str_md5.set(this.mMd5);
    localUpload2QCloudReqBody.str_sha.set(this.mSha);
    localUpload2QCloudReqBody.str_file_name.set(UtilsMisc.getValidateFileName(this.mFileName));
    localUpload2QCloudReqBody.uint32_upload_type.set(0);
    localUpload2QCloudReqBody.uint32_dst_type.set(1);
    localUpload2QCloudReqBody.uint64_file_size.set(this.mTotalSize);
    Cmd0X31B.ReqBody localReqBody = new Cmd0X31B.ReqBody();
    localReqBody.uint32_sub_cmd.set(5);
    localReqBody.str_app_id.set("30223");
    localReqBody.msg_upload2qcloud_req_body.set(localUpload2QCloudReqBody);
    if (SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_UPLOAD2QCLOUD-5", localReqBody.toByteArray(), new UploadFileRequestCallback())) {
      return 0;
    }
    return -10011;
  }
  
  protected class UploadFileRequestCallback
    extends BaseCallback<Cmd0X31B.Upload2QCloudRspBody>
  {
    protected UploadFileRequestCallback() {}
    
    protected void handleResponse(IWyFileSystem.WyErrorStatus paramWyErrorStatus, Cmd0X31B.Upload2QCloudRspBody paramUpload2QCloudRspBody)
    {
      PbUploadAddressFetcher.this.handleResponse(paramWyErrorStatus.errorCode, paramWyErrorStatus.errorMsg, paramUpload2QCloudRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.job.af.pb.PbUploadAddressFetcher
 * JD-Core Version:    0.7.0.1
 */