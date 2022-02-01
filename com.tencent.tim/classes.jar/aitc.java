import android.text.TextUtils;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.Geo2AddressParam.PoiOptions;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.param.SuggestionParam.Policy;
import com.tencent.map.tools.net.http.HttpResponseListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class aitc
{
  private final List<LocationRoom.Venue> CF = new ArrayList(20);
  private aitc.a a;
  private TencentMap c;
  private boolean clM = true;
  private int dff = 1;
  private final LatLng f;
  private boolean isSearching;
  private BaseActivity mActivity;
  private final String wB;
  
  aitc(BaseActivity paramBaseActivity, TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.mActivity = paramBaseActivity;
    this.c = paramTencentMap;
    this.f = paramLatLng;
    paramBaseActivity = paramString;
    if (paramString == null) {
      paramBaseActivity = "";
    }
    this.wB = paramBaseActivity;
  }
  
  void a(aitc.a parama)
  {
    this.a = parama;
  }
  
  public boolean apF()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch next: mKeyWord = " + this.wB + " latLng = " + this.f + ", page = " + this.dff + ", isSearching = " + this.isSearching + ", hasMore = " + this.clM);
    }
    if ((this.isSearching) || (!this.clM)) {
      return false;
    }
    this.isSearching = true;
    TencentSearch localTencentSearch = new TencentSearch(this.mActivity);
    Object localObject2 = this.c.getCityName(this.f);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).lastIndexOf("市") == ((String)localObject2).length() - 1) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      }
    }
    localObject2 = new aitd(this);
    if (TextUtils.isEmpty(this.wB)) {
      localTencentSearch.geo2address(new Geo2AddressParam(this.f).getPoi(true).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(20).setPageIndex(this.dff)), (HttpResponseListener)localObject2);
    }
    for (;;)
    {
      return true;
      localTencentSearch.suggestion(new SuggestionParam(this.wB, (String)localObject1).location(this.f).policy(SuggestionParam.Policy.DEF).pageSize(20).pageIndex(this.dff), (HttpResponseListener)localObject2);
    }
  }
  
  public boolean hasMore()
  {
    return this.clM;
  }
  
  public static abstract interface a
  {
    public abstract void cR(List<LocationRoom.Venue> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitc
 * JD-Core Version:    0.7.0.1
 */