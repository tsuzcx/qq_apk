import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import org.json.JSONObject;

public class klq
  implements nln, nlp
{
  public static GdtHandler.Params a;
  public static boolean agk;
  public static boolean agl;
  public static boolean agm;
  public static long sr = -2147483648L;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  klq.a jdField_a_of_type_Klq$a;
  private nnb jdField_a_of_type_Nnb = new nnb();
  public BaseData b;
  public BaseData c;
  private Context mContext;
  
  public static void aEf()
  {
    mp(false);
    agl = false;
    agm = false;
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    sr = -2147483648L;
  }
  
  public static void mp(boolean paramBoolean)
  {
    try
    {
      agk = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerVideoItemData)) {
      i = kmx.a((ProteusBannerVideoItemData)paramBaseData);
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
    paramViewGroup = null;
    try
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.mTemplateBean);
      paramViewGroup = (ViewGroup)localObject;
      kvx.a(((Container)localObject).getVirtualView(), localProteusItemData.mTemplateBean.getViewBean());
      paramViewGroup = (ViewGroup)localObject;
      str = localProteusItemData.aD.toString();
      paramViewGroup = (ViewGroup)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        boolean bool;
        String str = "error!! msg=" + localException.toString();
      }
    }
    bool = false;
    localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject = new View(paramContext);
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebFastProteusViewAdBannerVideoCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    }
    if ((this.jdField_a_of_type_Klq$a == null) || (paramBaseData != this.c))
    {
      this.c = paramBaseData;
      this.jdField_a_of_type_Klq$a = new klq.a((View)localObject, localProteusItemData);
    }
    return this.jdField_a_of_type_Klq$a;
  }
  
  public boolean a(BaseData paramBaseData)
  {
    if (paramBaseData.type == 17)
    {
      this.b = paramBaseData;
      return true;
    }
    return false;
  }
  
  public void aEe() {}
  
  public void aEg() {}
  
  public void onCreate()
  {
    mp(true);
  }
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume()
  {
    ods.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, sr);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    sr = -2147483648L;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.b == null) {
      return;
    }
    int i = this.b.pos;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramInt = paramAbsListView.getFirstVisiblePosition();
    int j = paramAbsListView.getLastVisiblePosition();
    if ((i >= paramInt) && (i <= j))
    {
      startVideo();
      return;
    }
    aEg();
  }
  
  public void startVideo() {}
  
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
      ViewFactory.findClickableViewListener(this.b.getVirtualView(), new klr(this));
    }
    
    private void a(Container paramContainer)
    {
      if (paramContainer != null)
      {
        ViewBase localViewBase1 = paramContainer.getVirtualView();
        ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_view_AdDownloadView");
        if ((localViewBase2 != null) && ((localViewBase2 instanceof kox))) {
          ((kox)localViewBase2).setModel(null, true);
        }
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof AdData)) && (((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).a != null) && (kmx.a((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData)))
        {
          localViewBase1 = localViewBase1.findViewBaseByName("id_game_small_img");
          if ((localViewBase1 != null) && ((localViewBase1 instanceof lsr)) && (!TextUtils.isEmpty(((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).alU)))
          {
            int i = wja.dp2px(40.0F, paramContainer.getContext().getResources());
            kmx.a(paramContainer.getContext(), localViewBase1, ((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).alU, 10, i, i);
          }
        }
      }
    }
    
    private void aEh() {}
    
    public void a(ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2) {}
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      if ((this.b == null) || (paramBaseData2 == null)) {}
      TemplateBean localTemplateBean;
      do
      {
        do
        {
          return;
        } while (!(paramBaseData2 instanceof ProteusBannerVideoItemData));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData = ((ProteusBannerVideoItemData)paramBaseData2);
        localTemplateBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.mTemplateBean;
      } while (localTemplateBean == null);
      if (paramBaseData1 == paramBaseData2) {
        a(this.b);
      }
      if (paramBaseData1 != paramBaseData2) {}
      try
      {
        localTemplateBean.bindData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.aD);
        kvx.a(this.b.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.mTemplateBean.getViewBean());
        this.g = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
        if ((paramBaseData1 != null) && (paramBaseData1.type == 17))
        {
          paramBaseData1 = (ProteusBannerVideoItemData)paramBaseData1;
          a((ProteusBannerVideoItemData)paramBaseData2, paramBaseData1);
          a(paramBaseData2, klq.a(klq.this), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.aD);
          this.itemView.setTag(2131362133, paramBaseData2);
          aEh();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          a((ProteusBannerVideoItemData)paramBaseData2, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     klq
 * JD-Core Version:    0.7.0.1
 */