import com.tencent.biz.qqstory.network.pb.qqstory_struct.GatherCardInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class wgz
{
  private qqstory_struct.GatherCardInfo a;
  
  public wgz(qqstory_struct.GatherCardInfo paramGatherCardInfo)
  {
    this.a = paramGatherCardInfo;
  }
  
  public wgz(byte[] paramArrayOfByte)
  {
    this.a = new qqstory_struct.GatherCardInfo();
    try
    {
      this.a.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wsv.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgz
 * JD-Core Version:    0.7.0.1
 */