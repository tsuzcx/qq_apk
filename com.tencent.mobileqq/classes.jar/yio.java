import com.tencent.biz.qqstory.network.pb.qqstory_struct.GatherCardInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class yio
{
  private qqstory_struct.GatherCardInfo a;
  
  public yio(qqstory_struct.GatherCardInfo paramGatherCardInfo)
  {
    this.a = paramGatherCardInfo;
  }
  
  public yio(byte[] paramArrayOfByte)
  {
    this.a = new qqstory_struct.GatherCardInfo();
    try
    {
      this.a.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      yuk.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yio
 * JD-Core Version:    0.7.0.1
 */