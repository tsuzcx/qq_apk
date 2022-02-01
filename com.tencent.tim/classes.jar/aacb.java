import android.os.Bundle;
import android.text.TextUtils;
import mqq.observer.BusinessObserver;

public class aacb
  implements BusinessObserver
{
  public void d(int paramInt, String paramString, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 1) && (paramBundle != null))
    {
      paramInt = paramBundle.getInt("btype");
      String str = paramBundle.getString("bid");
      if ((aaca.ht(paramInt)) && (!TextUtils.isEmpty(str))) {
        d(paramInt, str, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacb
 * JD-Core Version:    0.7.0.1
 */