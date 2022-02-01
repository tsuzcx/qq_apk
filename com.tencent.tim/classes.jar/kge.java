import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyPullToZoomHeaderXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DailyDianDianEntranceView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Map;
import org.json.JSONObject;

public class kge
  extends kfr
  implements View.OnClickListener
{
  private static String YX = "readinjoy_daily_old_version_cache_deal";
  private static int aIA;
  private static boolean aeN = true;
  private static boolean aeO = ((Boolean)awit.f(YX, Boolean.valueOf(false))).booleanValue();
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private ReadInJoyDailyPullToZoomHeaderXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView;
  private DailyDianDianEntranceView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView;
  private mye jdField_a_of_type_Mye;
  private mza jdField_a_of_type_Mza;
  private ndi jdField_a_of_type_Ndi;
  private ViewGroup aM;
  private boolean aeP;
  private int from = -1;
  private int mChannelID = -1;
  private int mChannelType = -1;
  protected lce mObserver = new kgf(this);
  private volatile boolean zw;
  
  public kge(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void aCC()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView = ((DailyDianDianEntranceView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131366489));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView != null)
      {
        if (ncs.a().Fm()) {
          break label57;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView.setVisibility(8);
        QLog.d("ReadInJoyDailyViewController", 1, "hide entry Icon");
      }
    }
    label57:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView.a(ncs.a().a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView, this));
    } while (ncs.a().qw() != 1);
    RecommendFeedsDiandianEntranceManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView);
  }
  
  private void aCE()
  {
    if (aIA == 2) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.setCanLoadMore(true);
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.getOverScrollFooterView() != null) {
      return;
    }
    View localView = LayoutInflater.from(getActivity()).inflate(2131560340, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.setOverScrollFooter(localView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView.a(new nen());
  }
  
  private void aCF()
  {
    lhf locallhf = lbz.a().a();
    if ((locallhf != null) && (!aeO)) {
      locallhf.a(new kgg(this, locallhf));
    }
  }
  
  private void b(ListView paramListView, ndi paramndi)
  {
    TemplateBean localTemplateBean = null;
    JSONObject localJSONObject = kys.z();
    try
    {
      Object localObject = localJSONObject.optString("style_ID", "null");
      QLog.i("ReadInJoyDailyViewController", 1, "[initPTSFooterView] " + (String)localObject);
      localObject = npi.a("default_feeds", true);
      if (localObject != null) {
        localTemplateBean = ((npi)localObject).getTemplateBean(localJSONObject);
      }
      if (localTemplateBean != null)
      {
        paramndi = paramndi.getVafContext();
        paramndi = paramndi.getViewFactory().inflate(paramndi, localTemplateBean);
        kvx.bindDynamicValueWithoutRecursion(paramndi, null, localTemplateBean);
        paramndi.setTag(localTemplateBean);
        paramListView.addFooterView(paramndi);
        if ((paramListView instanceof ReadInJoyDailyXListView)) {
          ((ReadInJoyDailyXListView)paramListView).setPTSFooterView(paramndi);
        }
      }
      else
      {
        QLog.e("ReadInJoyDailyViewController", 1, "[initPTSFooterView] template bean is null");
        return;
      }
    }
    catch (Exception paramListView)
    {
      QLog.e("ReadInJoyDailyViewController", 1, "[initPTSFooterView] ", paramListView);
    }
  }
  
  public static int getMode()
  {
    return aIA;
  }
  
  private int nh()
  {
    if (this.mChannelID != -1) {
      return this.mChannelID;
    }
    return this.activity.getIntent().getIntExtra("channel_id", 0);
  }
  
  private int ni()
  {
    if (this.mChannelType != -1) {
      return this.mChannelType;
    }
    return this.activity.getIntent().getIntExtra("channel_type", 0);
  }
  
  public void O(boolean paramBoolean, int paramInt)
  {
    super.O(paramBoolean, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.lP(paramBoolean);
  }
  
  public mye a()
  {
    return this.jdField_a_of_type_Mye;
  }
  
  public void a(ListView paramListView, ndi paramndi)
  {
    if ((paramListView != null) && (getMode() != 2)) {
      b(paramListView, paramndi);
    }
  }
  
  public void aBY()
  {
    if (this.zw) {}
    do
    {
      do
      {
        return;
        this.zw = true;
        super.aBY();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(nh())), b(Integer.valueOf(nh())));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.H(this.dC);
    } while (this.aM == null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.aM.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, localLayoutParams);
  }
  
  public void aBZ()
  {
    if (!this.zw) {}
    do
    {
      do
      {
        return;
        this.zw = false;
        super.aBZ();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(nh())), b(Integer.valueOf(nh())));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.G(this.dC);
      aCD();
    } while (this.aM == null);
    this.aM.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup);
  }
  
  public void aCD()
  {
    this.dB.clear();
    this.dD.clear();
    this.dC.clear();
  }
  
  public VafContext getVafContext()
  {
    return this.jdField_a_of_type_Ndi.getVafContext();
  }
  
  public void i(ViewGroup paramViewGroup)
  {
    super.i(paramViewGroup);
    this.aM = paramViewGroup;
  }
  
  public ViewGroup j()
  {
    return this.aM;
  }
  
  public void lP(boolean paramBoolean)
  {
    super.lP(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.lP(paramBoolean);
  }
  
  public void oD(int paramInt)
  {
    this.mChannelID = paramInt;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate()
  {
    super.onCreate();
    mzj.a().aO(getActivity());
    this.jdField_a_of_type_Mye = new mye(getActivity());
    aIA = kys.getMode();
    this.dC.put(Integer.valueOf(nh()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, nh(), ni(), this.from, null, 2131560338);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView = ((ReadInJoyDailyPullToZoomHeaderXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131379011));
    aCC();
    aCE();
    aCF();
    this.jdField_a_of_type_Ndi = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    this.jdField_a_of_type_Mza = new mza((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131381801), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyDailyPullToZoomHeaderXListView, this.activity);
    this.jdField_a_of_type_Mye.b(this.jdField_a_of_type_Mza);
    lcc.a().b(this.mObserver);
    if (aeN)
    {
      aeN = false;
      lbz.a().aJi();
    }
    aBY();
    oej.uz(8);
    kxj.a().clearData();
    kxj.a().mB(String.valueOf(nh()));
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.mObserver);
    lhf locallhf = lbz.a().a();
    if (locallhf != null) {
      locallhf.a(null);
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView != null)
    {
      RecommendFeedsDiandianEntranceManager.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDailyDianDianEntranceView.onDestroy();
    }
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.destroy();
    }
    mzj.a().aP(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onDestroy();
    this.jdField_a_of_type_Ndi.aVM();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.aTN();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    lcc.a().b(this.mObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onResume();
    ndh localndh = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      localndh = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    }
    if ((this.jdField_a_of_type_Mye != null) && (localndh != null))
    {
      mye.b localb = this.jdField_a_of_type_Mye.c();
      if ((localb != null) && (localb.aqp)) {
        localndh.aVX();
      }
    }
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.aTO();
    }
    lcc.a().b(this.mObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onResume();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).aWh();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ndi != null) {
      this.jdField_a_of_type_Ndi.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onStart();
    if (!this.aeP)
    {
      ncs.a().aVD();
      this.aeP = true;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onStop();
  }
  
  public void refreshList()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.O(true, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kge
 * JD-Core Version:    0.7.0.1
 */