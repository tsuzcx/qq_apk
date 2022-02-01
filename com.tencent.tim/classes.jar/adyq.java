import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class adyq
  implements BusinessObserver
{
  public void Dr(boolean paramBoolean) {}
  
  public void aa(boolean paramBoolean, String paramString) {}
  
  public void ab(boolean paramBoolean, String paramString) {}
  
  public void k(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void l(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramInt = paramBundle.getInt("resp_result", 0);
      l(paramBoolean, paramBundle.getString("key_card_id"), paramInt);
      return;
    case 2: 
      ab(paramBoolean, paramBundle.getString("key_card_id"));
      return;
    case 3: 
      aa(paramBoolean, paramBundle.getString("key_card_id"));
      return;
    case 4: 
      Dr(paramBoolean);
      return;
    }
    k(paramBoolean, paramBundle.getString("key_card_id"), paramBundle.getInt("key_get_detail_type"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyq
 * JD-Core Version:    0.7.0.1
 */