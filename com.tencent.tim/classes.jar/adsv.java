import android.os.Bundle;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.2;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class adsv
  extends aquy
{
  public adsv(ChooseImageIPCModule.2 param2, String paramString) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    QLog.d("ArkApp.ChooseImageIPCModule", 1, String.format("ArkMultiProc.download finish, url=%s, err=%d", new Object[] { this.val$url, Integer.valueOf(paramaquz.errCode) }));
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", paramaquz.errCode);
    paramaquz = EIPCResult.createResult(0, localBundle);
    this.a.this$0.callbackResult(this.a.val$callbackId, paramaquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsv
 * JD-Core Version:    0.7.0.1
 */