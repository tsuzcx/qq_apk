import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class btv
  extends TroopObserver
{
  public btv(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 5);
    localBundle.putBoolean("isSuccess", false);
    localBundle.putSerializable("data", new Object[] { Integer.valueOf(paramInt), Byte.valueOf(paramByte) });
    TroopMemberApiService.a(this.a, 3, localBundle);
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 5);
    localBundle.putBoolean("isSuccess", true);
    localBundle.putSerializable("data", new Object[] { Integer.valueOf(paramInt), Byte.valueOf(paramByte), paramString });
    TroopMemberApiService.a(this.a, 3, localBundle);
  }
  
  protected void a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 4);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", null);
    TroopMemberApiService.a(this.a, 3, localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("troopMember", 2, "get member list from server successful in qq process");
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 40);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", Integer.valueOf(paramInt));
    TroopMemberApiService.a(this.a, 3, localBundle);
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 43);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { Integer.valueOf(paramInt), paramArrayList });
    TroopMemberApiService.a(this.a, 3, localBundle);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 44);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(paramInt), paramArrayOfLong });
    TroopMemberApiService.a(this.a, 3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     btv
 * JD-Core Version:    0.7.0.1
 */