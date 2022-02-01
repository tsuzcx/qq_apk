import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Map;
import java.util.UUID;

class apfi
  extends smq.l
{
  apfi(apfh paramapfh) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.a.mTroopUin) {}
    do
    {
      do
      {
        return;
        paramBundle = paramBundle.getString("itemKey");
      } while (paramBundle == null);
      paramBundle = UUID.fromString(paramBundle);
      paramBundle = (TroopFileTransferManager.Item)this.a.nC.get(paramBundle);
    } while (paramBundle == null);
    apfh.a(this.a, paramBundle, paramBoolean, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfi
 * JD-Core Version:    0.7.0.1
 */