import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.biz.troop.TroopMemberApiService.a;

public class sle
  implements jry
{
  public sle(TroopMemberApiService.a parama, Bundle paramBundle, int paramInt) {}
  
  public void K(int paramInt1, int paramInt2, int paramInt3)
  {
    this.val$data.putInt("state", paramInt2);
    this.val$data.putInt("percentage", paramInt3);
    this.val$data.putLong("errCode", 0L);
    if ((paramInt2 == 6) && (this.val$action == 2)) {
      this.val$data.putBoolean("actionFinish", true);
    }
    for (;;)
    {
      this.a.d.j(79, this.val$data);
      return;
      if ((paramInt2 == 4) && (this.val$action == 1)) {
        this.val$data.putBoolean("actionFinish", true);
      }
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    this.val$data.putLong("errCode", paramInt);
    this.val$data.putBoolean("actionFinish", true);
    this.a.d.j(79, this.val$data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sle
 * JD-Core Version:    0.7.0.1
 */