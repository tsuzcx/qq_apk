import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StModifyFeedReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StModifyFeedRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class wrn
  extends wrr
{
  private CertifiedAccountWrite.StModifyFeedReq a = new CertifiedAccountWrite.StModifyFeedReq();
  
  public wrn(COMM.StCommonExt paramStCommonExt, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
    if (paramStFeed != null) {
      this.a.feed.set(paramStFeed);
    }
    this.a.mBitmap.set(1L);
  }
  
  public static CertifiedAccountWrite.StModifyFeedRsp a(byte[] paramArrayOfByte)
  {
    CertifiedAccountWrite.StModifyFeedRsp localStModifyFeedRsp = new CertifiedAccountWrite.StModifyFeedRsp();
    try
    {
      paramArrayOfByte = (CertifiedAccountWrite.StModifyFeedRsp)localStModifyFeedRsp.mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CertifiedAccountModifyFeedRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wrn
 * JD-Core Version:    0.7.0.1
 */