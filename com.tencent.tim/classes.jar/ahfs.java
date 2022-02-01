import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

class ahfs
  implements ahfn.b
{
  ahfs(ahfr paramahfr, String paramString1, String paramString2) {}
  
  public void b(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    QLog.d("FlutterMainQIPCModule", 1, String.format("onResult, isSuccess: %s, installDir: %s, isEngineExist: %s, isAppExist: %s", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("KEY_INSTALL_RESULT", paramBoolean1);
    localBundle.putString("KEY_INSTALL_DIR", paramString);
    localBundle.putBoolean("KEY_IS_APP_EXIST", paramBoolean3);
    localBundle.putBoolean("KEY_IS_ENGINE_EXIST", paramBoolean2);
    QIPCServerHelper.getInstance().callClient(this.bKn, "FlutterSubQIPCModule", this.val$action, localBundle, new ahft(this));
  }
  
  public void onProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfs
 * JD-Core Version:    0.7.0.1
 */