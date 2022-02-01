import com.tencent.biz.qqstory.network.pb.qqstory_struct.QimVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class ptt
{
  public String avd;
  public String mFeedId;
  public String mVid;
  
  public ptt(qqstory_struct.QimVideoInfo paramQimVideoInfo)
  {
    this.avd = paramQimVideoInfo.qim_unionid.get().toStringUtf8();
    this.mFeedId = paramQimVideoInfo.qim_feedID.get().toStringUtf8();
    this.mVid = paramQimVideoInfo.qim_vid.get().toStringUtf8();
  }
  
  public static ptt a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    qqstory_struct.QimVideoInfo localQimVideoInfo = new qqstory_struct.QimVideoInfo();
    try
    {
      localQimVideoInfo.mergeFrom(paramArrayOfByte);
      return new ptt(localQimVideoInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.e("QimVideoInfoItem", "Error: parse db bytes error.", paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] J()
  {
    qqstory_struct.QimVideoInfo localQimVideoInfo = new qqstory_struct.QimVideoInfo();
    localQimVideoInfo.qim_vid.set(ByteStringMicro.copyFromUtf8(this.mVid));
    localQimVideoInfo.qim_unionid.set(ByteStringMicro.copyFromUtf8(this.avd));
    localQimVideoInfo.qim_feedID.set(ByteStringMicro.copyFromUtf8(this.mFeedId));
    return localQimVideoInfo.toByteArray();
  }
  
  public String toString()
  {
    return "QimVideoInfoItem{mOwnerUnionId='" + this.avd + '\'' + ", mFeedId='" + this.mFeedId + '\'' + ", mVid='" + this.mVid + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptt
 * JD-Core Version:    0.7.0.1
 */