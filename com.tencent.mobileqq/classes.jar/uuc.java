import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public abstract class uuc
{
  public int a;
  public String a;
  
  public uuc() {}
  
  public uuc(qqstory_struct.ErrorInfo paramErrorInfo)
  {
    this.jdField_a_of_type_Int = paramErrorInfo.error_code.get();
    this.jdField_a_of_type_JavaLangString = paramErrorInfo.error_desc.get().toStringUtf8();
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt, Bundle paramBundle);
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuc
 * JD-Core Version:    0.7.0.1
 */