package com.tencent.biz.pubaccount.readinjoy.view;

import acfd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqdf;
import awit;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.c;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.XListView.a;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kfr;
import kxa;
import kxm;
import kys;
import lbz;
import lce;
import lem;
import lfz;
import lgd;
import lge;
import mgu;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import muj;
import mye.b;
import mza.b;
import ndi.a;
import ndi.b;
import ndi.c;
import ndi.d;
import ngn;
import ngq;
import ngt;
import ngu;
import ngv;
import ngw;
import ngx;
import nny;
import odd;
import odv;
import wja;

public class ReadInJoyProteusFamilyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, ReadInJoyBaseListView.c, AdapterView.c, AdapterView.d, mza.b, ndi.a, ndi.b, ndi.c, ndi.d
{
  private LinearLayout E;
  protected aqdf a;
  private KandianMergeManager.c jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$c = new ngt(this);
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private XListView.a jdField_a_of_type_ComTencentWidgetXListView$a = new ngx(this);
  private int aIz = 1;
  private int aMR = -1;
  private boolean afo = true;
  private boolean arO = true;
  private SparseArray<lfz> av;
  private ngn b;
  private acfd c = new ngu(this);
  Map<String, KandianProgressView> eD = new HashMap();
  private View jH;
  List<KandianProgressView> jU = new ArrayList();
  private List<nny> jW = new ArrayList();
  private int mChannelType = -1;
  private lce mObserver;
  private AbsListView.e mOnScrollListener = new ngq(this);
  private View mRootView;
  private ViewStub r;
  private TextView sY;
  private long xm;
  private long xr = -1L;
  private long xt = -1L;
  
  public ReadInJoyProteusFamilyListViewGroup(kfr paramkfr, int paramInt1, int paramInt2, int paramInt3, kxa paramkxa)
  {
    this(paramkfr, paramInt1, paramInt2, paramInt3, paramkxa, 2131560479);
  }
  
  public ReadInJoyProteusFamilyListViewGroup(kfr paramkfr, int paramInt1, int paramInt2, int paramInt3, kxa paramkxa, int paramInt4)
  {
    super(paramkfr, paramInt1, paramkxa);
    this.mRootView = getCurrentActivity().getLayoutInflater().inflate(paramInt4, this);
    this.mChannelType = paramInt2;
    this.xm = paramInt3;
    this.afo = muj.Eq();
    setId(2131376754);
    this.av = lgd.a(this);
    initUI();
    aBi();
    this.jdField_a_of_type_Kxa.sY = awit.s((QQAppInterface)kxm.getAppRuntime());
  }
  
  public ReadInJoyProteusFamilyListViewGroup(kfr paramkfr, int paramInt1, int paramInt2, kxa paramkxa)
  {
    this(paramkfr, paramInt1, paramInt2, -1, paramkxa);
  }
  
  public ReadInJoyProteusFamilyListViewGroup(kfr paramkfr, int paramInt, kxa paramkxa)
  {
    this(paramkfr, paramInt, -1, paramkxa);
  }
  
  private void aBi()
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyProteusFamilyListViewGroup.6(this), 3000L);
  }
  
  private void aDy()
  {
    if (this.jH != null) {
      this.jH.setVisibility(8);
    }
    View localView = findViewById(2131374329);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void aWO()
  {
    this.sY = ((TextView)findViewById(2131374333));
    if (kys.dv(this.mChannelID))
    {
      this.E = ((LinearLayout)findViewById(2131374332));
      return;
    }
    this.r = ((ViewStub)findViewById(2131374331));
  }
  
  private void aWs()
  {
    Activity localActivity;
    View localView2;
    if ((this.jdField_a_of_type_Kfr instanceof lem))
    {
      localActivity = getCurrentActivity();
      if (localActivity.findViewById(2131362038) == null) {
        break label190;
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362038);
      localView1 = localActivity.findViewById(2131378734);
      localView2 = findViewById(2131367492);
      i = getResources().getDimensionPixelOffset(2131299219);
      i = wja.dp2px(50.0F, getResources()) + ImmersiveUtils.getStatusBarHeight(getContext()) + i;
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI 看点 mListView.setPadding :" + i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.mChannelID, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, localActivity.findViewById(16908307), new ReadInJoyProteusFamilyListViewGroup.4(this, localView1, i, localView2));
    }
    label190:
    while (localActivity.findViewById(2131362039) == null) {
      return;
    }
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362039);
    View localView1 = localActivity.findViewById(2131379798);
    int i = wja.dp2px(50.0F, getResources());
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI 消息看点 mListView.setPadding heightDef=" + i);
      }
      localView2 = findViewById(2131367492);
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.mChannelID, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyProteusFamilyListViewGroup.5(this, localView1, i, localView2));
      return;
    }
  }
  
  private void aWt()
  {
    this.b.setChannelType(ni());
    this.b.eJ(this.xm);
    this.b.a(this);
    this.b.a(this);
    this.b.a(this);
    this.b.a(this);
    this.b.b(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.b);
  }
  
  private void initListView()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(this.mChannelID);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemLongClickListener(this);
    if (this.mChannelID == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollFlingMode(1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$a);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(this.mOnScrollListener);
  }
  
  private void initUI()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131379011));
    this.jdField_a_of_type_Aqdf = new aqdf(getCurrentActivity(), ((BaseActivity)getCurrentActivity()).app);
    this.b = new ngn(BaseActivity.sTopActivity, BaseActivity.sTopActivity.getLayoutInflater(), this.mChannelID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.av, getCurrentActivity());
    a(new ngv(this, "onListViewGroupInit"));
    aWO();
    if (QLog.isColorLevel()) {
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Kfr + getCurrentActivity());
    }
    aWs();
    initListView();
    aWt();
    aDy();
    ((BaseActivity)getCurrentActivity()).app.addObserver(this.c);
    ((KandianMergeManager)kxm.getAppRuntime().getManager(162)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$c);
    this.mObserver = new ngw(this);
  }
  
  private int ni()
  {
    if (this.mChannelType != -1) {
      return this.mChannelType;
    }
    return getCurrentActivity().getIntent().getIntExtra("channel_type", 0);
  }
  
  public void F(Map<Integer, mgu> paramMap) {}
  
  public void G(Map<Integer, Boolean> paramMap) {}
  
  public void H(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.mChannelID), Boolean.valueOf(true));
  }
  
  public void O(boolean paramBoolean, int paramInt) {}
  
  public ngn a()
  {
    return this.b;
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadinJoyProteusFamilyListViewGroup", 2, "jumpToGallery failed: atlas has undercarriage");
      }
      lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.b.notifyDataSetChanged();
      odv.J(paramArticleInfo);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ReadinJoyProteusFamilyListViewGroup", 2, "rowKey is empty");
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public void a(Map<Long, mgu> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinJoyProteusFamilyListViewGroup_" + this.mChannelID, 2, "detachFromViewGroup()");
    }
  }
  
  public void a(Set<Long> paramSet, Map<Long, mgu> paramMap) {}
  
  public void a(lge paramlge)
  {
    if (paramlge == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.av.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramlge.a((lfz)this.av.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(this.av.keyAt(i)), ", jobName : ", paramlge.aV(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
  
  public void a(mye.b paramb1, mye.b paramb2) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void aCB() {}
  
  public void aCk() {}
  
  public void aCz()
  {
    if (!this.aeK)
    {
      this.aeK = true;
      odd.bU(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      lbz.a().a(this.mChannelID, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.mChannelID) });
  }
  
  public void aWI()
  {
    if (this.b != null) {
      this.b.notifyDataSetChanged();
    }
  }
  
  public void aWJ() {}
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public void h(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    this.b.setData(paramList);
  }
  
  public void lP(boolean paramBoolean)
  {
    O(paramBoolean, 1);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onClick(View paramView) {}
  
  public void onDestroy()
  {
    ((BaseActivity)getCurrentActivity()).app.removeObserver(this.c);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPause() {}
  
  public void onRefresh()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    lP(true);
  }
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void setAdapterData(List<BaseArticleInfo> paramList, int paramInt)
  {
    this.b.setData(paramList);
  }
  
  public void setChannelType(int paramInt)
  {
    this.mChannelType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup
 * JD-Core Version:    0.7.0.1
 */