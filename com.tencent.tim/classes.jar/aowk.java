import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class aowk
  extends acnd
{
  public aowk(TroopCreateLogicActivity paramTroopCreateLogicActivity) {}
  
  protected void a(long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3)
  {
    this.a.app.removeObserver(this.a.q);
    if (paramInt1 == 0)
    {
      TroopManager localTroopManager = (TroopManager)this.a.app.getManager(52);
      localObject = null;
      if (localTroopManager != null) {
        localObject = localTroopManager.b(Long.toString(paramLong));
      }
      if (localObject != null)
      {
        ((TroopInfo)localObject).troopLat = paramInt2;
        ((TroopInfo)localObject).troopLon = paramInt3;
        localTroopManager.i((TroopInfo)localObject);
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troopUin", paramLong);
    ((Intent)localObject).putExtra("errCode", paramInt1);
    ((Intent)localObject).putExtra("isClear", paramBoolean);
    ((Intent)localObject).putExtra("location", paramString);
    ((Intent)localObject).putExtra("lat", paramInt2);
    ((Intent)localObject).putExtra("lon", paramInt3);
    this.a.setResult(-1, (Intent)localObject);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aowk
 * JD-Core Version:    0.7.0.1
 */