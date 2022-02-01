import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetEmoticonPackList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class pys
  extends ppw<qaf>
{
  public final String mCookie;
  public final int mCount;
  public final int mLatitude;
  public final int mLongitude;
  
  public pys(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0, 0);
  }
  
  public pys(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("mCookie should not be null");
    }
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("mCount should not be less than 0 : " + paramInt1);
    }
    this.mCookie = paramString;
    this.mCount = paramInt1;
    this.mLatitude = paramInt2;
    this.mLongitude = paramInt3;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetEmoticonPackList localRspGetEmoticonPackList = new qqstory_service.RspGetEmoticonPackList();
    try
    {
      localRspGetEmoticonPackList.mergeFrom(paramArrayOfByte);
      return new qaf(localRspGetEmoticonPackList, paramArrayOfByte, System.currentTimeMillis());
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.e("GetEmojiPackInfoListRequest", "GetEmojiPackInfoListRequest error : " + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqGetEmoticonPackList localReqGetEmoticonPackList = new qqstory_service.ReqGetEmoticonPackList();
    localReqGetEmoticonPackList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.mCookie));
    localReqGetEmoticonPackList.count.set(this.mCount);
    return localReqGetEmoticonPackList.toByteArray();
  }
  
  public String mg()
  {
    return ppf.fQ("StorySvc.video_emoticon_get");
  }
  
  public String toString()
  {
    return "GetEmojiPackInfoListRequest{mCookie='" + this.mCookie + '\'' + ", mCount=" + this.mCount + ", latitude=" + this.mLatitude + ", longitude=" + this.mLongitude + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pys
 * JD-Core Version:    0.7.0.1
 */