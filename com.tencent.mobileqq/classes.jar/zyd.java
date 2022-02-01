import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StPublishFeedReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StPublishFeedRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.qphone.base.util.QLog;

public class zyd
  extends zyf
{
  private CertifiedAccountWrite.StPublishFeedReq a = new CertifiedAccountWrite.StPublishFeedReq();
  
  public zyd(COMM.StCommonExt paramStCommonExt, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
    if (paramStFeed != null) {
      this.a.feed.set(paramStFeed);
    }
  }
  
  public static CertifiedAccountWrite.StPublishFeedRsp a(byte[] paramArrayOfByte)
  {
    CertifiedAccountWrite.StPublishFeedRsp localStPublishFeedRsp = new CertifiedAccountWrite.StPublishFeedRsp();
    try
    {
      paramArrayOfByte = (CertifiedAccountWrite.StPublishFeedRsp)localStPublishFeedRsp.mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CertifiedAccountGetMsgTopRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyd
 * JD-Core Version:    0.7.0.1
 */