import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;

public class ttd
  extends tsx
{
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerBigPicItemData)) {
      i = twh.a((ProteusBannerBigPicItemData)paramBaseData);
    }
    return i;
  }
  
  protected stg a(View paramView, BaseData paramBaseData)
  {
    return new tte(this, paramView, paramBaseData, this.a);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.r == 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ttd
 * JD-Core Version:    0.7.0.1
 */