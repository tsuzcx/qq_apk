import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;

public class kkl
{
  public static kkk a(Context paramContext, AdData paramAdData)
  {
    if ((paramContext == null) || (paramAdData == null)) {
      return null;
    }
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).zI())) {
      return new kkc(paramContext, 2);
    }
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).zH())) {
      return new kkg(paramContext, 1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkl
 * JD-Core Version:    0.7.0.1
 */