import android.os.Bundle;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

final class rwu
  implements BusinessObserver
{
  rwu(rtu paramrtu) {}
  
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
          this.a.F(true, paramBundle);
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
      this.a.F(false, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     rwu
 * JD-Core Version:    0.7.0.1
 */