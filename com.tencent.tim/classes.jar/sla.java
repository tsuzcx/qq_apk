import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.biz.troop.TroopMemberApiService.a;

public class sla
  implements aqym.b
{
  public sla(TroopMemberApiService.a parama, int paramInt, String paramString) {}
  
  public void onResult(Bundle paramBundle)
  {
    paramBundle.putInt("seq", this.val$seq);
    paramBundle.putString("processName", this.aEx);
    this.a.d.j(121, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sla
 * JD-Core Version:    0.7.0.1
 */