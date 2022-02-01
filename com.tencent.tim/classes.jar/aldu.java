import android.os.Handler;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;

public class aldu
  extends alfx
{
  public aldu(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    super(paramLong, paramString1, paramArrayOfByte, paramString2);
  }
  
  public void g(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 1001: 
      do
      {
        return;
        this.this$0.dFq();
      } while (getResult() == null);
      this.this$0.a(this.val$filePath, (UpsImageUploadResult)getResult());
      return;
    }
    this.this$0.dFq();
    paramVarArgs = this.this$0.mHandler.obtainMessage(24, getErrorMsg());
    this.this$0.mHandler.sendMessage(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldu
 * JD-Core Version:    0.7.0.1
 */