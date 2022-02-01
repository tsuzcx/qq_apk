import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
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
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class klh
  implements nln, nlp
{
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private nnb jdField_a_of_type_Nnb = new nnb();
  private WeakReference<Context> mContext;
  
  public int a(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusInnerData)) {
      return kmx.a((ProteusInnerData)paramBaseData);
    }
    return 20;
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
      this.mContext = new WeakReference(paramContext);
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
      QLog.d("WebFastProteusViewAdBannerBigPicCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    }
    return new klh.a(paramViewGroup, localProteusItemData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.type == 22;
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
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject = null;
    if (this.mContext != null) {
      localObject = (Context)this.mContext.get();
    }
    if ((localObject == null) || (!(localObject instanceof Activity)) || (((Activity)localObject).getWindow().getAttributes().softInputMode != 4)) {}
    do
    {
      return;
      localObject = (InputMethodManager)((Context)localObject).getSystemService("input_method");
    } while (localObject == null);
    ((InputMethodManager)localObject).hideSoftInputFromWindow(paramAbsListView.getWindowToken(), 2);
  }
  
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
      ViewFactory.findClickableViewListener(paramJSONObject, new kli(this, paramContext, paramBaseData, paramJSONObject));
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
          ((kox)localObject).mC(false);
          ((kox)localObject).mB(false);
          ((kox)localObject).setModel(null, true);
        }
        if (((paramProteusItemData instanceof AdData)) && (((AdData)paramProteusItemData).a != null) && (kmx.a((AdData)paramProteusItemData)))
        {
          localObject = localViewBase.findViewBaseByName("id_inner_small_img");
          if ((localObject != null) && ((localObject instanceof lsr)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.gameIcon))) {
            kmx.a(paramContainer.getContext(), (ViewBase)localObject, ((AdData)paramProteusItemData).a.gameIcon, 10);
          }
          localObject = localViewBase.findViewBaseByName("id_inner_game_img1");
          if ((localObject != null) && ((localObject instanceof lsr)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.a.aag))) {
            kmx.a(paramContainer.getContext(), (ViewBase)localObject, ((AdData)paramProteusItemData).a.a.aag, 10);
          }
          localObject = localViewBase.findViewBaseByName("id_inner_game_img2");
          if ((localObject != null) && ((localObject instanceof lsr)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.a.aah))) {
            kmx.a(paramContainer.getContext(), (ViewBase)localObject, ((AdData)paramProteusItemData).a.a.aah, 10);
          }
          localViewBase = localViewBase.findViewBaseByName("id_inner_game_img3");
          if ((localViewBase != null) && ((localViewBase instanceof lsr)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.a.aai))) {
            kmx.a(paramContainer.getContext(), localViewBase, ((AdData)paramProteusItemData).a.a.aai, 10);
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
      if (paramBaseData1 != paramBaseData2) {}
      try
      {
        localTemplateBean.bindData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.aD);
        kvx.a(this.b.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.mTemplateBean.getViewBean());
        this.g = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
        a(this.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData);
        if (klh.a(klh.this) != null) {
          a(paramBaseData2, (Context)klh.a(klh.this).get(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.aD);
        }
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
 * Qualified Name:     klh
 * JD-Core Version:    0.7.0.1
 */