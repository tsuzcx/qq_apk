import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wfh
{
  public int a;
  public String b;
  
  public wfh() {}
  
  public wfh(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public wfh(qqstory_struct.ErrorInfo paramErrorInfo)
  {
    this.a = paramErrorInfo.error_code.get();
    this.b = paramErrorInfo.error_desc.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfh
 * JD-Core Version:    0.7.0.1
 */