import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.3.1;

public final class ahci
  implements ahch.b
{
  ahci(String paramString1, String paramString2) {}
  
  public void onResult(String paramString)
  {
    if (paramString == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new UniformDownloadUtil.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahci
 * JD-Core Version:    0.7.0.1
 */