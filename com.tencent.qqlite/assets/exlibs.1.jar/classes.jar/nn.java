import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;

public final class nn
  extends SOSOMapLBSApiListener
{
  public nn(int paramInt1, int paramInt2, int paramInt3, int paramInt4, SharedPreferences paramSharedPreferences)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult)
  {
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    SearchProtocol.a((float)paramSOSOMapLBSApiResult.Latitude);
    SearchProtocol.b((float)paramSOSOMapLBSApiResult.Longitude);
    this.a.edit().putFloat("search_lbs_latitude", SearchProtocol.a()).commit();
    this.a.edit().putFloat("search_lbs_logitude", SearchProtocol.b()).commit();
    this.a.edit().putLong("search_lbs_timestamp", System.currentTimeMillis()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     nn
 * JD-Core Version:    0.7.0.1
 */