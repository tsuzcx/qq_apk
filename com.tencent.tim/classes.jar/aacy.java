import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.a;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.2;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;

public class aacy
  implements PreloadManager.a
{
  public aacy(QWalletIPCModule.2 param2, ResultReceiver paramResultReceiver) {}
  
  public void onDownloadResFinished(String paramString1, int paramInt, String paramString2, ResourceInfo paramResourceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "QWalletIPC downloadModule" + paramString2 + "|" + paramResourceInfo + "|" + System.currentTimeMillis());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString1);
    localBundle.putInt("result", paramInt);
    localBundle.putString("path", paramString2);
    localBundle.putSerializable("res_info", paramResourceInfo);
    this.i.send(0, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacy
 * JD-Core Version:    0.7.0.1
 */