import android.content.Intent;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class gxw
  extends TroopObserver
{
  public gxw(TroopCreateLogicActivity paramTroopCreateLogicActivity) {}
  
  protected void a(long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3)
  {
    this.a.b.c(this.a.a);
    if (paramInt1 == 0)
    {
      Object localObject2 = (FriendManager)this.a.b.getManager(8);
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = ((FriendManager)localObject2).a(Long.toString(paramLong));
      }
      if (localObject1 != null)
      {
        ((TroopInfo)localObject1).troopLat = paramInt2;
        ((TroopInfo)localObject1).troopLon = paramInt3;
        localObject2 = (FriendsManagerImp)this.a.b.getManager(8);
        if (localObject2 != null) {
          ((FriendsManagerImp)localObject2).b((TroopInfo)localObject1);
        }
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("troopUin", paramLong);
    ((Intent)localObject1).putExtra("errCode", paramInt1);
    ((Intent)localObject1).putExtra("isClear", paramBoolean);
    ((Intent)localObject1).putExtra("location", paramString);
    ((Intent)localObject1).putExtra("lat", paramInt2);
    ((Intent)localObject1).putExtra("lon", paramInt3);
    this.a.setResult(-1, (Intent)localObject1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxw
 * JD-Core Version:    0.7.0.1
 */