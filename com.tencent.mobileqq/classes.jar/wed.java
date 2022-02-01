import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetEmoticonPackList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wed
  extends vqr<wgb>
{
  public final String a;
  public final int c;
  public final int d;
  public final int e;
  
  public wed(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0, 0);
  }
  
  public wed(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("mCookie should not be null");
    }
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("mCount should not be less than 0 : " + paramInt1);
    }
    this.a = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public String a()
  {
    return vpl.a("StorySvc.video_emoticon_get");
  }
  
  public vqm a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetEmoticonPackList localRspGetEmoticonPackList = new qqstory_service.RspGetEmoticonPackList();
    try
    {
      localRspGetEmoticonPackList.mergeFrom(paramArrayOfByte);
      return new wgb(localRspGetEmoticonPackList, paramArrayOfByte, System.currentTimeMillis());
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      xvv.e("GetEmojiPackInfoListRequest", "GetEmojiPackInfoListRequest error : " + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetEmoticonPackList localReqGetEmoticonPackList = new qqstory_service.ReqGetEmoticonPackList();
    localReqGetEmoticonPackList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    localReqGetEmoticonPackList.count.set(this.c);
    return localReqGetEmoticonPackList.toByteArray();
  }
  
  public String toString()
  {
    return "GetEmojiPackInfoListRequest{mCookie='" + this.a + '\'' + ", mCount=" + this.c + ", latitude=" + this.d + ", longitude=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wed
 * JD-Core Version:    0.7.0.1
 */