import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.BizTroopObserver;
import java.util.ArrayList;
import java.util.List;

public class bnv
  extends BizTroopObserver
{
  public bnv(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(String paramString, List paramList, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 25);
    localBundle.putString("pageUrl", paramString);
    localBundle.putStringArrayList("lstVideoUrl", (ArrayList)paramList);
    localBundle.putInt("totalTime", paramInt);
    TroopMemberApiService.a(this.a, 13, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bnv
 * JD-Core Version:    0.7.0.1
 */