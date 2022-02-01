import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wov
{
  public int a;
  public String b;
  
  public wov() {}
  
  public wov(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public wov(qqstory_struct.ErrorInfo paramErrorInfo)
  {
    this.a = paramErrorInfo.error_code.get();
    this.b = paramErrorInfo.error_desc.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wov
 * JD-Core Version:    0.7.0.1
 */