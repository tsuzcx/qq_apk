import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.qphone.base.util.QLog;

class aade
  implements PreloadManager.d
{
  aade(aacv paramaacv, ResultReceiver paramResultReceiver) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "QWalletIPC downloadUrls" + paramPathResult);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramPathResult);
    this.i.send(0, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aade
 * JD-Core Version:    0.7.0.1
 */