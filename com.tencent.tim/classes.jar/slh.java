import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.biz.troop.TroopMemberApiService.a;

public class slh
  implements acgk.a
{
  public slh(TroopMemberApiService.a parama, Bundle paramBundle) {}
  
  public boolean a(acgl.c paramc)
  {
    Bundle localBundle = new Bundle();
    acgl.c localc = paramc;
    if (paramc == null) {
      localc = this.a.d.a.a.a(this.a.d.a.bor, 1, acgk.dV());
    }
    if (localc != null)
    {
      localBundle.putString("url", localc.url);
      localBundle.putString("content", localc.content);
    }
    for (;;)
    {
      localBundle.putInt("seq", this.val$data.getInt("seq", -1));
      this.a.d.j(101, localBundle);
      return false;
      localBundle.putString("url", "");
      localBundle.putString("content", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slh
 * JD-Core Version:    0.7.0.1
 */