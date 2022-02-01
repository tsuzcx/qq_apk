import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class ppt
  extends ppu
{
  public boolean isEnd;
  public String nextCookie;
  
  public ppt(qqstory_struct.ErrorInfo paramErrorInfo, PBUInt32Field paramPBUInt32Field, PBBytesField paramPBBytesField)
  {
    super(paramErrorInfo);
    if (paramPBUInt32Field.get() == 1) {}
    for (;;)
    {
      this.isEnd = bool;
      this.nextCookie = paramPBBytesField.get().toStringUtf8();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppt
 * JD-Core Version:    0.7.0.1
 */