import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject.ReverseAddressResult;
import com.tencent.lbssearch.object.result.SearchResultObject;
import com.tencent.lbssearch.object.result.SearchResultObject.SearchResultData;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject.SuggestionData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.1.1;
import com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.1.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aitd
  implements HttpResponseListener<BaseObject>
{
  aitd(aitc paramaitc) {}
  
  public void a(int paramInt, BaseObject paramBaseObject)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    aitc.a(this.b, false);
    Object localObject2;
    if ((paramBaseObject instanceof Geo2AddressResultObject))
    {
      paramBaseObject = (Geo2AddressResultObject)paramBaseObject;
      if ((paramBaseObject.result != null) && (paramBaseObject.result.pois != null))
      {
        aitc.a(this.b);
        localObject1 = paramBaseObject.result.pois.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Poi)((Iterator)localObject1).next();
          localObject2 = LocationRoom.Venue.a(aitc.a(this.b).app.getCurrentUin(), (Poi)localObject2);
          aitc.a(this.b).add(localObject2);
        }
        localObject1 = this.b;
        if (paramBaseObject.result.poi_count < 20) {
          break label235;
        }
        bool1 = true;
        aitc.b((aitc)localObject1, bool1);
      }
    }
    label235:
    label368:
    do
    {
      do
      {
        do
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onSuccess: mVenueList size = " + aitc.a(this.b).size() + ", mHashMore = " + aitc.a(this.b));
          }
          if (aitc.a(this.b) != null) {
            ThreadManager.getUIHandler().post(new LocationPoiDataFromMapHelper.1.1(this));
          }
          return;
          bool1 = false;
          break;
          if (!(paramBaseObject instanceof SuggestionResultObject)) {
            break label368;
          }
          paramBaseObject = (SuggestionResultObject)paramBaseObject;
        } while (paramBaseObject.data == null);
        aitc.a(this.b);
        localObject1 = paramBaseObject.data.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SuggestionResultObject.SuggestionData)((Iterator)localObject1).next();
          localObject2 = LocationRoom.Venue.a(aitc.a(this.b).app.getCurrentUin(), (SuggestionResultObject.SuggestionData)localObject2);
          aitc.a(this.b).add(localObject2);
        }
        localObject1 = this.b;
        if (paramBaseObject.count >= 20) {}
        for (;;)
        {
          aitc.b((aitc)localObject1, bool1);
          break;
          bool1 = false;
        }
      } while (!(paramBaseObject instanceof SearchResultObject));
      paramBaseObject = (SearchResultObject)paramBaseObject;
    } while (paramBaseObject.data == null);
    aitc.a(this.b);
    Object localObject1 = paramBaseObject.data.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SearchResultObject.SearchResultData)((Iterator)localObject1).next();
      localObject2 = LocationRoom.Venue.a(aitc.a(this.b).app.getCurrentUin(), (SearchResultObject.SearchResultData)localObject2);
      aitc.a(this.b).add(localObject2);
    }
    localObject1 = this.b;
    if (paramBaseObject.count >= 20) {}
    for (bool1 = bool2;; bool1 = false)
    {
      aitc.b((aitc)localObject1, bool1);
      break;
    }
  }
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    aitc.a(this.b, false);
    if (QLog.isDevelopLevel()) {
      QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onFailure: mVenueList size = " + aitc.a(this.b).size() + ", mHashMore = " + aitc.a(this.b));
    }
    if (aitc.a(this.b) != null) {
      ThreadManager.getUIHandler().post(new LocationPoiDataFromMapHelper.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitd
 * JD-Core Version:    0.7.0.1
 */