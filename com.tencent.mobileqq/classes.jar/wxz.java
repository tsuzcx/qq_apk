import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import java.util.ArrayList;

public class wxz
  extends ajyr
{
  public wxz(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void a(boolean paramBoolean, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ArrayList<String> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 1050);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString, paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayList });
    localBundle.putSerializable("observer_type", Integer.valueOf(5));
    this.a.a(3, localBundle);
  }
  
  public void a(boolean paramBoolean, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", this.a.f);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putStringArrayList("uins", paramArrayList1);
    localBundle.putStringArrayList("tinyIds", paramArrayList2);
    this.a.a(102, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxz
 * JD-Core Version:    0.7.0.1
 */