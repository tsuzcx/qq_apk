import android.os.Bundle;
import java.util.UUID;

class apfk
  extends smq.l
{
  apfk(apfj paramapfj) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != apfj.a(this.this$0)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.this$0.a())));
    if (!paramBoolean) {
      apef.b.e("TroopFileToTroopForwarder", apef.b.USR, "[" + apfj.a(this.this$0) + "] onFowardToTroopResult isSuccess:false ");
    }
    apfj.a(this.this$0, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfk
 * JD-Core Version:    0.7.0.1
 */