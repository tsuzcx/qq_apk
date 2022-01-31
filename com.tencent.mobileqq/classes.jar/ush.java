import com.tencent.biz.qqstory.network.pb.qqstory_struct.GatherCardInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class ush
{
  private qqstory_struct.GatherCardInfo a;
  
  public ush(qqstory_struct.GatherCardInfo paramGatherCardInfo)
  {
    this.a = paramGatherCardInfo;
  }
  
  public ush(byte[] paramArrayOfByte)
  {
    this.a = new qqstory_struct.GatherCardInfo();
    try
    {
      this.a.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ved.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ush
 * JD-Core Version:    0.7.0.1
 */