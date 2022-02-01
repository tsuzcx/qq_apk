import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class nlw
  implements nln, nlp
{
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private nnb jdField_a_of_type_Nnb = new nnb();
  private Context mContext;
  
  private void a(Container paramContainer, RecommendAdData paramRecommendAdData)
  {
    Object localObject;
    if (paramContainer != null)
    {
      paramContainer = paramContainer.getVirtualView();
      if (paramContainer != null)
      {
        localObject = paramContainer.findViewBaseByName("id_recommend_title");
        if ((localObject != null) && (((ViewBase)localObject).getNativeView() != null) && ((((ViewBase)localObject).getNativeView() instanceof NativeTextImp)))
        {
          localObject = (NativeTextImp)((ViewBase)localObject).getNativeView();
          ((NativeTextImp)localObject).setLines(2);
          ((NativeTextImp)localObject).setGravity(51);
        }
        localObject = paramContainer.findViewBaseByName("id_recommend_category_download");
        if ((localObject == null) || (((ViewBase)localObject).getNativeView() == null) || (!(((ViewBase)localObject).getNativeView() instanceof NativeTextImp)) || (paramRecommendAdData.productType != 12) || (TextUtils.isEmpty(paramRecommendAdData.pkgName))) {
          break label152;
        }
        localObject = (NativeTextImp)((ViewBase)localObject).getNativeView();
        if ((localObject == null) || (paramRecommendAdData.mShowAdButton)) {
          break label133;
        }
        ((NativeTextImp)localObject).setVisibility(8);
      }
    }
    label133:
    label152:
    label200:
    for (;;)
    {
      return;
      if (jzk.C(BaseApplicationImpl.getContext(), paramRecommendAdData.pkgName)) {
        ((NativeTextImp)localObject).setText("立即打开");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramRecommendAdData.alV)) {
          break label200;
        }
        paramContainer = paramContainer.findViewBaseByName("id_recommend_account_name");
        if (paramContainer == null) {
          break;
        }
        paramContainer.getComLayoutParams().mLayoutMarginLeft = wja.dp2px(16.0F, this.mContext.getResources());
        return;
        ((NativeTextImp)localObject).setText("立即下载");
      }
    }
  }
  
  private void f(Container paramContainer)
  {
    int i = 8;
    int j = 0;
    ViewBase localViewBase;
    if (paramContainer != null)
    {
      localViewBase = paramContainer.getVirtualView();
      if (localViewBase != null)
      {
        paramContainer = localViewBase.findViewBaseByName("id_large_video_icon");
        localViewBase = localViewBase.findViewBaseByName("id_video_bg");
        if (!NetworkState.isWifiConn()) {
          break label64;
        }
      }
    }
    for (;;)
    {
      if (paramContainer != null) {
        paramContainer.setVisibility(j);
      }
      if (localViewBase != null) {
        localViewBase.setVisibility(i);
      }
      return;
      label64:
      j = 8;
      i = 0;
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof RecommendAdData)) {
      i = 9;
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
      QLog.d("WebFastProteusViewAdCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    }
    return new nlw.a(paramViewGroup, localProteusItemData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    switch (paramBaseData.type)
    {
    default: 
      return false;
    }
    return true;
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
    
    private void c(Context paramContext, JSONObject paramJSONObject)
    {
      ViewFactory.findClickableViewListener(this.b.getVirtualView(), new nlx(this, paramContext));
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
      nlw.a(nlw.this, this.b);
      if ((paramBaseData2 instanceof RecommendAdData)) {
        nlw.a(nlw.this, this.b, (RecommendAdData)paramBaseData2);
      }
      if (paramBaseData1 != paramBaseData2) {}
      try
      {
        localTemplateBean.bindData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.aD);
        kvx.a(this.b.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.mTemplateBean.getViewBean());
        this.g = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
        label119:
        c(nlw.a(nlw.this), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.aD);
        return;
      }
      catch (Exception paramBaseData1)
      {
        break label119;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlw
 * JD-Core Version:    0.7.0.1
 */