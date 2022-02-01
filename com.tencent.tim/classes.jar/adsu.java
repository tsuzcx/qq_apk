import android.os.Bundle;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.1;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class adsu
  implements acci
{
  public adsu(ChooseImageIPCModule.1 param1, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putBoolean("sucess", paramBoolean);
    localBundle.putString("data", (String)paramObject);
    paramObject = EIPCResult.createResult(0, localBundle);
    QLog.d("ArkApp.ChooseImageIPCModule", 1, new Object[] { "ArkMultiProc.callSendAppMsg success callback cmd=", this.val$cmd });
    this.a.this$0.callbackResult(this.a.val$callbackId, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsu
 * JD-Core Version:    0.7.0.1
 */