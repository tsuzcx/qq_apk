import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.ApolloManager.21;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class abhn
  implements jox
{
  public abhn(ApolloManager.21 param21) {}
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] offline pkg bid:", this.a.val$bid, " loaded, param=", paramString, ", code=", Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.a.v.edit().putInt(this.a.bgb, this.a.coL).commit();
    }
    VipUtils.a(this.a.this$0.mApp, "cmshow", "Apollo", "gamecenter_preload_res_android", 0, paramInt, new String[] { this.a.val$bid, String.valueOf(this.a.coL) });
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhn
 * JD-Core Version:    0.7.0.1
 */