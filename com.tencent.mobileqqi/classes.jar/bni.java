import android.os.Bundle;
import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class bni
  implements BusinessObserver
{
  public bni(QRCodeEncodeCallback paramQRCodeEncodeCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {}
    for (paramBundle = paramBundle.getString("result");; paramBundle = null)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        if (paramBundle.getInt("r") != 0) {
          continue;
        }
        paramBundle = paramBundle.getString("url");
        if (paramBundle != null)
        {
          this.a.a(true, paramBundle);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = null;
        }
      }
      this.a.a(false, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bni
 * JD-Core Version:    0.7.0.1
 */