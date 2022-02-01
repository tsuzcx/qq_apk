import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;

public class tng
  extends tna
{
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerBigPicItemData)) {
      i = tpp.a((ProteusBannerBigPicItemData)paramBaseData);
    }
    return i;
  }
  
  protected spi a(View paramView, BaseData paramBaseData)
  {
    return new tnh(this, paramView, paramBaseData, this.a);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.r == 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tng
 * JD-Core Version:    0.7.0.1
 */