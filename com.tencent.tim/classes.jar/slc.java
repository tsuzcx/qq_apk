import com.tencent.biz.troop.TroopMemberApiService.a;
import cooperation.troop.TroopPluginManager.a;

public class slc
  implements TroopPluginManager.a
{
  public slc(TroopMemberApiService.a parama, acms paramacms, String paramString1, int paramInt, String paramString2) {}
  
  public void onInstallFinish(int paramInt)
  {
    if ((paramInt == 0) && (this.b != null)) {
      this.b.f(Long.valueOf(this.Uf).longValue(), 510, 0, this.bxF, this.aEx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slc
 * JD-Core Version:    0.7.0.1
 */