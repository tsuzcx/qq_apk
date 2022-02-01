import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;

public class tlo
{
  public static tln a(Context paramContext, AdData paramAdData)
  {
    if ((paramContext == null) || (paramAdData == null)) {
      return null;
    }
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).g())) {
      return new tlf(paramContext, 2);
    }
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).f())) {
      return new tlj(paramContext, 1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tlo
 * JD-Core Version:    0.7.0.1
 */