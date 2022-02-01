import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class ppu
{
  public int errorCode;
  public String errorMsg;
  
  public ppu() {}
  
  public ppu(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMsg = paramString;
  }
  
  public ppu(qqstory_struct.ErrorInfo paramErrorInfo)
  {
    this.errorCode = paramErrorInfo.error_code.get();
    this.errorMsg = paramErrorInfo.error_desc.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppu
 * JD-Core Version:    0.7.0.1
 */