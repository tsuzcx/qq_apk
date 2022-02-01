import cooperation.weiyun.channel.pb.WeiyunPB.MsgBody;
import cooperation.weiyun.channel.pb.WeiyunPB.RspMsgBody;

class awpv<T>
  implements awps.a
{
  private static final String ERR_INVALID_PROTO = acfp.m(2131703061);
  private final int cmd;
  private final awpw<T> d;
  
  awpv(int paramInt, awpw<T> paramawpw)
  {
    this.cmd = paramInt;
    this.d = paramawpw;
  }
  
  public void b(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (this.d == null) {
      return;
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      this.d.c(paramInt, paramString, null);
      return;
    }
    try
    {
      paramString = (WeiyunPB.MsgBody)new WeiyunPB.MsgBody().mergeFrom(paramArrayOfByte);
      paramString = (WeiyunPB.RspMsgBody)paramString.RspMsg_body.get();
      if (paramString == null)
      {
        awrj.a().w("BaseCallback", "rspMsgBody is null.");
        paramString = ERR_INVALID_PROTO;
        this.d.c(1828003, paramString, null);
        return;
      }
    }
    catch (Throwable paramString)
    {
      awrj.a().w("BaseCallback", "decode Rsp Body failed.", paramString);
      paramString = ERR_INVALID_PROTO;
      this.d.c(1828003, paramString, null);
      return;
    }
    switch (this.cmd)
    {
    default: 
      paramString = ERR_INVALID_PROTO;
      this.d.c(1828001, paramString, null);
      return;
    case 26113: 
      this.d.onSuccess(paramString.LibInfoListGetMsgRsp_body);
      return;
    case 2402: 
      this.d.onSuccess(paramString.DiskFileBatchDownloadMsgRsp_body);
      return;
    case 2414: 
      this.d.onSuccess(paramString.DiskFileDocDownloadAbsMsgRsp_body);
      return;
    case 2509: 
      this.d.onSuccess(paramString.DiskDirFileBatchDeleteExMsgRsp_body);
      return;
    case 2803: 
      this.d.onSuccess(paramString.DiskPicBackupRsp_body);
      return;
    case 2804: 
      this.d.onSuccess(paramString.DiskAlbumStatusReportRsp_body);
      return;
    case 11001: 
      this.d.onSuccess(paramString.PwdQueryMsgRsp_body);
      return;
    case 11005: 
      this.d.onSuccess(paramString.PwdVerifyMsgRsp_body);
      return;
    case 245700: 
      this.d.onSuccess(paramString.CrossBidProxyCopyFileToOtherBidMsgRsp_body);
      return;
    case 245706: 
      this.d.onSuccess(paramString.CrossBidProxyOfflineFileGetListMsgRsp_body);
      return;
    case 246000: 
      this.d.onSuccess(paramString.QqSdkFileUploadMsgRsp_body);
      return;
    case 246001: 
      this.d.onSuccess(paramString.AioPicAndVideoCopyToWeiyunMsgRsp_body);
      return;
    }
    this.d.onSuccess(paramString.WeiyunShareAddFromMobileQQMsgRsp_body);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpv
 * JD-Core Version:    0.7.0.1
 */