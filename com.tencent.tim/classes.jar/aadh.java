import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class aadh
  implements PreloadManager.d
{
  aadh(aadg paramaadg, File paramFile, AtomicBoolean paramAtomicBoolean) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult arg2)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(???.filePath))) {}
    synchronized (this.val$file)
    {
      this.val$file.notify();
      this.bT.set(true);
      return;
      QLog.e("QWalletPicDownloader", 2, "downloadImage file not succeed, pathRes=" + ???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aadh
 * JD-Core Version:    0.7.0.1
 */