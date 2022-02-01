import android.os.Looper;
import com.tencent.ad.tangram.offline.AdOfflineAdapter;

public final class tfp
  implements AdOfflineAdapter
{
  public String getAppVersion()
  {
    return tkz.getQQVersion();
  }
  
  public String getVersionIfExists(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      tkw.e("GdtOfflineAdapter", "getVersionIfExists error");
      return null;
    }
    return jpa.dL(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfp
 * JD-Core Version:    0.7.0.1
 */