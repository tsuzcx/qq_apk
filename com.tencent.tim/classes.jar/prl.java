import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public abstract class prl
{
  public int errorCode;
  public String errorMsg;
  
  public prl() {}
  
  public prl(qqstory_struct.ErrorInfo paramErrorInfo)
  {
    this.errorCode = paramErrorInfo.error_code.get();
    this.errorMsg = paramErrorInfo.error_desc.get().toStringUtf8();
  }
  
  public abstract void aJ(int paramInt, String paramString);
  
  public abstract void h(int paramInt, Bundle paramBundle);
  
  public abstract void onSuccess();
  
  public void q(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prl
 * JD-Core Version:    0.7.0.1
 */