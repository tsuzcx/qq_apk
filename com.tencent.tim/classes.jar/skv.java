import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;

public class skv
  extends acfd
{
  public skv(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 30);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString });
    localBundle.putSerializable("observer_type", Integer.valueOf(2));
    this.d.j(3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skv
 * JD-Core Version:    0.7.0.1
 */