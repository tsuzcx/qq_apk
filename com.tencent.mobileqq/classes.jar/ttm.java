import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ttm
  extends tsy
{
  private ReadInJoyArticleBottomVideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyArticleBottomVideoView;
  private qiv jdField_a_of_type_Qiv;
  private qja jdField_a_of_type_Qja;
  
  public ttm(View paramView, BaseData paramBaseData, WeakReference<Context> paramWeakReference)
  {
    super(paramBaseData, paramWeakReference, localWeakReference);
    if ((paramBaseData != null) && (((Container)paramBaseData).getVirtualView() != null)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyArticleBottomVideoView == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyArticleBottomVideoView = ((ReadInJoyArticleBottomVideoView)((Container)paramBaseData).getVirtualView().findViewBaseByName("id_ad_banner_bottom_video"));
        twp.a("VideoPlayerWrapper_AD", "bottomView create - item:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyArticleBottomVideoView.hashCode());
      }
    }
    try
    {
      if (this.jdField_a_of_type_Qiv == null) {
        this.jdField_a_of_type_Qiv = ((qiv)((Container)paramBaseData).getVirtualView().findViewBaseByName("id_ad_title_mask"));
      }
      if (this.jdField_a_of_type_Qja == null) {
        this.jdField_a_of_type_Qja = ((qja)((Container)paramBaseData).getVirtualView().findViewBaseByName("id_tv_title_inner"));
      }
      return;
    }
    catch (Exception paramView)
    {
      twp.a("WebFastProteusViewAdBannerVideoCreator", "ProteusItemViewHolder create error: " + paramView.getMessage());
    }
  }
  
  private void a(ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if ((paramProteusBannerVideoItemData1 == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyArticleBottomVideoView == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyArticleBottomVideoView.setVisibility(0);
      oar localoar = new oar();
      AdvertisementInfo localAdvertisementInfo = tws.a(paramProteusBannerVideoItemData1);
      localoar.e = paramProteusBannerVideoItemData1.d;
      localoar.d = paramProteusBannerVideoItemData1.o;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyArticleBottomVideoView.a(localoar, localAdvertisementInfo, paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2);
    } while (!paramProteusBannerVideoItemData1.f);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyArticleBottomVideoView.d();
  }
  
  protected void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new ttn(this, paramBaseData, paramContext));
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    if (!(paramBaseData1 instanceof ProteusBannerVideoItemData)) {
      return;
    }
    if ((paramBaseData2 != null) && (paramBaseData2.r == 17))
    {
      paramBaseData2 = (ProteusBannerVideoItemData)paramBaseData2;
      a((ProteusBannerVideoItemData)paramBaseData1, paramBaseData2);
      return;
    }
    a((ProteusBannerVideoItemData)paramBaseData1, null);
  }
  
  protected boolean a(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    return paramBaseData1 == paramBaseData2;
  }
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ttm
 * JD-Core Version:    0.7.0.1
 */