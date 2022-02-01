import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerTriplePicItemData;

public class tth
  extends tsx
{
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerTriplePicItemData)) {
      i = twh.a((ProteusBannerTriplePicItemData)paramBaseData);
    }
    return i;
  }
  
  protected stg a(View paramView, BaseData paramBaseData)
  {
    return new tti(this, paramView, paramBaseData, this.a);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.r == 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tth
 * JD-Core Version:    0.7.0.1
 */