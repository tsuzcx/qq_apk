import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import org.json.JSONObject;

public class kln
  implements nln, nlp
{
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private nnb jdField_a_of_type_Nnb = new nnb();
  private Context mContext;
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerTriplePicItemData)) {
      i = kmx.a((ProteusBannerTriplePicItemData)paramBaseData);
    }
    return i;
  }
  
  public nlm a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new luh();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      kvx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    if (this.mContext == null) {
      this.mContext = paramContext;
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    paramBaseData = null;
    try
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.mTemplateBean);
      paramBaseData = paramViewGroup;
      kvx.a(((Container)paramViewGroup).getVirtualView(), localProteusItemData.mTemplateBean.getViewBean());
      paramBaseData = paramViewGroup;
      str = localProteusItemData.aD.toString();
      paramBaseData = paramViewGroup;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        boolean bool;
        String str = "error!! msg=" + paramViewGroup.toString();
      }
    }
    bool = false;
    paramViewGroup = paramBaseData;
    if (paramBaseData == null)
    {
      paramViewGroup = new View(paramContext);
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebFastProteusViewAdBannerTriplePicCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    }
    return new kln.a(paramViewGroup, localProteusItemData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.type == 24);
  }
  
  public void aEe() {}
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Nnb.onDestroy();
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    this.jdField_a_of_type_Nnb.onResume();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  class a
    extends nlm
  {
    private ProteusItemData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
    private Container b;
    
    public a(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      if ((paramView instanceof Container)) {
        this.b = ((Container)paramView);
      }
    }
    
    private void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject)
    {
      paramJSONObject = this.b.getVirtualView();
      ViewFactory.findClickableViewListener(paramJSONObject, new klo(this, paramBaseData, paramContext, paramJSONObject));
    }
    
    private void a(Container paramContainer, ProteusItemData paramProteusItemData)
    {
      if (paramContainer != null)
      {
        ViewBase localViewBase = paramContainer.getVirtualView();
        Object localObject = localViewBase.findViewBaseByName("id_view_AdDownloadView");
        if ((localObject != null) && ((localObject instanceof kox)))
        {
          localObject = (kox)localObject;
          ((kox)localObject).mB(false);
          ((kox)localObject).mC(false);
          ((kox)localObject).setModel(null, true);
        }
        if (((paramProteusItemData instanceof AdData)) && (((AdData)paramProteusItemData).a != null) && (kmx.a((AdData)paramProteusItemData)))
        {
          localViewBase = localViewBase.findViewBaseByName("id_game_small_img");
          if ((localViewBase != null) && ((localViewBase instanceof lsr)) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).alU)))
          {
            int i = wja.dp2px(40.0F, paramContainer.getContext().getResources());
            kmx.a(paramContainer.getContext(), localViewBase, ((AdData)paramProteusItemData).alU, 10, i, i);
          }
        }
      }
    }
    
    private void a(ViewBase paramViewBase)
    {
      if (paramViewBase == null) {}
      do
      {
        return;
        paramViewBase = paramViewBase.findViewBaseByName("id_view_AdDownloadView");
      } while ((paramViewBase == null) || (!(paramViewBase instanceof kox)));
      ((kox)paramViewBase).mB(false);
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      if ((this.b == null) || (paramBaseData2 == null)) {}
      TemplateBean localTemplateBean;
      do
      {
        do
        {
          return;
        } while (!(paramBaseData2 instanceof ProteusItemData));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData = ((ProteusItemData)paramBaseData2);
        localTemplateBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.mTemplateBean;
      } while (localTemplateBean == null);
      if ((paramBaseData1 == paramBaseData2) && ((paramBaseData2 instanceof ProteusBannerTriplePicItemData))) {
        a(this.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData);
      }
      if (paramBaseData1 != paramBaseData2) {}
      try
      {
        localTemplateBean.bindData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.aD);
        kvx.a(this.b.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.mTemplateBean.getViewBean());
        this.g = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
        a(paramBaseData2, kln.a(kln.this), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.aD);
        this.itemView.setTag(2131362133, paramBaseData2);
        return;
      }
      catch (Exception paramBaseData1)
      {
        for (;;)
        {
          paramBaseData1.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kln
 * JD-Core Version:    0.7.0.1
 */