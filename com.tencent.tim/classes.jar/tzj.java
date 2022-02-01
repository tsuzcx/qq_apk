import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import mqq.app.AppRuntime;

public class tzj
{
  TroopMemberApiService b;
  AppRuntime mRuntime;
  
  public tzj(AppRuntime paramAppRuntime, TroopMemberApiService paramTroopMemberApiService)
  {
    this.mRuntime = paramAppRuntime;
    this.b = paramTroopMemberApiService;
  }
  
  public static void a(int paramInt, Bundle paramBundle, tzj.a parama)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("key_sub_cmd", paramInt);
    if (parama != null)
    {
      skj.a().a(118, localBundle, parama);
      return;
    }
    skj.a().i(118, localBundle);
  }
  
  public void a(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    switch (paramBundle.getInt("key_sub_cmd"))
    {
    default: 
      return;
    case 1: 
      paramBundle.putBundle("key_result", uag.j());
      this.b.j(paramInt1, paramBundle);
      return;
    case 2: 
      str1 = paramBundle.getString("key");
      paramInt1 = paramBundle.getInt("type");
      paramBundle = paramBundle.getString("appid");
      ubi.a().C(str1, paramInt1, paramBundle);
      return;
    }
    String str1 = paramBundle.getString("key");
    paramInt1 = paramBundle.getInt("type");
    String str2 = paramBundle.getString("appid");
    paramBundle = paramBundle.getString("api");
    ubi.a().g(str1, paramInt1, str2, paramBundle);
  }
  
  public static abstract class a
    implements skj.a
  {
    public void callback(Bundle paramBundle)
    {
      paramBundle = paramBundle.getBundle("key_result");
      if (paramBundle != null) {}
      for (boolean bool = true;; bool = false)
      {
        r(bool, paramBundle);
        return;
      }
    }
    
    protected abstract void r(boolean paramBoolean, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzj
 * JD-Core Version:    0.7.0.1
 */