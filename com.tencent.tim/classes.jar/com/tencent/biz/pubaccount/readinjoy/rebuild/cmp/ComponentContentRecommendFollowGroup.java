package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqbn;
import aqgo;
import aqhu;
import aqiw;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView.a;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kbp;
import kwt;
import kxm;
import lbz;
import lcc;
import lce;
import lhm;
import lie;
import ljc;
import lwk;
import lwm.a;
import mbn;
import mbo;
import mbp;
import mhh;
import mhx;
import ndi;
import riw;

public class ComponentContentRecommendFollowGroup
  extends RelativeLayout
  implements DisableSlideHorizontalListView.a, lwk
{
  private static int aQo = -1;
  private a a;
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private DisableSlideHorizontalListView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  private lie d;
  protected lce g = new mbp(this);
  private View kG;
  private View kH;
  private TextView mTitleText;
  
  public ComponentContentRecommendFollowGroup(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public static void i(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mRecommendFollowInfos == null) || (paramBaseArticleInfo.mRecommendFollowInfos.reportMap == null) || (paramBaseArticleInfo.mRecommendFollowInfos.reportMap.size() <= 0)) {
      return;
    }
    Iterator localIterator = paramBaseArticleInfo.mRecommendFollowInfos.reportMap.values().iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      String str = ComponentContentRecommend.a(paramInt, localRecommendFollowInfo.uin, paramBaseArticleInfo, localRecommendFollowInfo.algorithmId, 3, 0, aQo, null);
      kbp.a(null, kxm.getLongAccountUin() + "", "0X80094DB", "0X80094DB", 0, 0, paramBaseArticleInfo.mRecommendFollowId + "", paramBaseArticleInfo.mArticleID + "", localRecommendFollowInfo.strategyId + "", str, false);
    }
    paramBaseArticleInfo.mRecommendFollowInfos.reportMap.clear();
  }
  
  public void P(Object paramObject)
  {
    aQo = kxm.nQ();
    if ((paramObject instanceof lie))
    {
      this.d = ((lie)paramObject);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.d.a();
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    }
    else
    {
      return;
    }
    paramObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos;
    this.mTitleText.setText(paramObject.ahE);
    this.a.setData(paramObject.iQ);
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.amI)
    {
      this.kG.setVisibility(0);
      return;
    }
    this.kG.setVisibility(8);
  }
  
  public void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    lbz.a().l(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ThreadManager.post(new ComponentContentRecommendFollowGroup.3(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, List<RecommendFollowInfo> paramList)
  {
    int j = 0;
    int i = j;
    if (this.d != null)
    {
      i = j;
      if (this.d.b() != null) {
        i = this.d.b().nh();
      }
    }
    paramList = ComponentContentRecommend.a(i, paramLong1, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramLong2, 3, paramInt2, aQo, paramList);
    kbp.a(null, kxm.getLongAccountUin() + "", paramString, paramString, 0, 0, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowId + "", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", paramInt1 + "", paramList, false);
  }
  
  public void a(lwm.a parama) {}
  
  public void aNZ()
  {
    Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jumpUrl;
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", (String)localObject);
    getContext().startActivity(localIntent);
    localObject = (RecommendFollowInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.iM.get(0);
    a("0X800955C", 0L, ((RecommendFollowInfo)localObject).algorithmId, ((RecommendFollowInfo)localObject).strategyId, 0, null);
  }
  
  public void aNj()
  {
    aNZ();
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!aqiw.isNetworkAvailable(getContext())) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentRecommendFollowGroup", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    String str = kwt.acJ + aqgo.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    ((Activity)getContext()).startActivityForResult(localIntent, 1);
    a("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0, null);
  }
  
  public void cG(View paramView)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)paramView.findViewById(2131376927));
    this.mTitleText = ((TextView)paramView.findViewById(2131376936));
    this.kG = paramView.findViewById(2131370239);
    this.kH = paramView.findViewById(2131376930);
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)paramView.findViewById(2131363393);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.a = new a(null);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setDividerWidth(riw.dip2px(paramView.getContext(), 5.0F));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.a);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.kH.setOnClickListener(new mbn(this));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560304, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
  
  protected void o(List<RecommendFollowInfo> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    RecommendFollowInfo localRecommendFollowInfo;
    while (i < paramList.size())
    {
      localRecommendFollowInfo = (RecommendFollowInfo)paramList.get(i);
      if (paramBoolean != localRecommendFollowInfo.isFollowed)
      {
        localArrayList1.add(new lhm(localRecommendFollowInfo.uin, localRecommendFollowInfo.type));
        localArrayList2.add(localRecommendFollowInfo);
      }
      i += 1;
    }
    if (!localArrayList2.isEmpty())
    {
      localRecommendFollowInfo = (RecommendFollowInfo)localArrayList2.get(0);
      if (!paramBoolean) {
        break label174;
      }
      a("0X80094DC", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
    }
    for (;;)
    {
      paramList = new mbo(this, paramList, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      lbz.a().a().a(localArrayList1, paramList, 2);
      return;
      label174:
      a("0X80094DD", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
    }
    lbz.a().a().b(localArrayList1, paramList, 2);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    lcc.a().b(this.g);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    lcc.a().c(this.g);
  }
  
  public class a
    extends BaseAdapter
  {
    private List<mhh> mDatas;
    
    private a() {}
    
    public int getCount()
    {
      if (this.mDatas != null) {
        return this.mDatas.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return this.mDatas.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int k = 0;
      View localView;
      Object localObject1;
      label325:
      Object localObject2;
      if (paramView == null)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560451, paramViewGroup, false);
        paramView = new ComponentContentRecommendFollowGroup.b(ComponentContentRecommendFollowGroup.this, null);
        paramView.qr = ((TextView)localView.findViewById(2131368211));
        paramView.pZ = ((TextView)localView.findViewById(2131367406));
        paramView.dL = ((LinearLayout)localView.findViewById(2131367397));
        paramView.dR = ((LinearLayout)localView.findViewById(2131368181));
        paramView.e = new RelativeLayout[3];
        paramView.h = new ImageView[3];
        paramView.i = new ImageView[3];
        paramView.j = new ImageView[3];
        paramView.m = new TextView[3];
        i = 0;
        while (i < paramView.dR.getChildCount())
        {
          localObject1 = (RelativeLayout)paramView.dR.getChildAt(i);
          paramView.e[i] = ((RelativeLayout)((RelativeLayout)localObject1).findViewById(2131368407));
          paramView.h[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131368398));
          paramView.i[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131381453));
          paramView.j[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131378685));
          paramView.m[i] = ((TextView)((RelativeLayout)localObject1).findViewById(2131372390));
          paramView.e[i].setOnClickListener(paramView);
          paramView.m[i].setOnClickListener(paramView);
          i += 1;
        }
        localView.setTag(paramView);
        paramView.dL.setOnClickListener(paramView);
        paramView.a = ((mhh)this.mDatas.get(paramInt));
        paramView.qr.setText(paramView.a.className);
        i = 0;
        if (i >= paramView.a.iM.size()) {
          break label611;
        }
        localObject1 = (RecommendFollowInfo)paramView.a.iM.get(i);
        paramView.m[i].setText(((RecommendFollowInfo)localObject1).nickName);
        paramView.m[i].setTag(localObject1);
        paramView.e[i].setTag(localObject1);
        if (TextUtils.isEmpty(((RecommendFollowInfo)localObject1).headUrl)) {
          break label581;
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = aqhu.at();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
        localObject2 = URLDrawable.getDrawable(((RecommendFollowInfo)localObject1).headUrl, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(aqbn.b);
        ((URLDrawable)localObject2).setFadeInImage(true);
        paramView.h[i].setImageDrawable((Drawable)localObject2);
        label473:
        localObject2 = paramView.i[i];
        if (!((RecommendFollowInfo)localObject1).isVip) {
          break label597;
        }
        j = 0;
        label493:
        ((ImageView)localObject2).setVisibility(j);
        localObject2 = paramView.j[i];
        if (!((RecommendFollowInfo)localObject1).isStar) {
          break label604;
        }
      }
      label581:
      label597:
      label604:
      for (int j = 0;; j = 8)
      {
        ((ImageView)localObject2).setVisibility(j);
        ComponentContentRecommendFollowGroup.a(ComponentContentRecommendFollowGroup.this).mRecommendFollowInfos.reportMap.put(Long.valueOf(((RecommendFollowInfo)localObject1).uin), localObject1);
        i += 1;
        break label325;
        localObject1 = (ComponentContentRecommendFollowGroup.b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject1;
        break;
        paramView.h[i].setImageDrawable(aqhu.at());
        break label473;
        j = 8;
        break label493;
      }
      label611:
      int i = 0;
      if (i < paramView.a.iM.size()) {
        if (((RecommendFollowInfo)paramView.a.iM.get(i)).isFollowed) {}
      }
      for (i = k;; i = 1)
      {
        if (i != 0)
        {
          paramView.pZ.setTextColor(-8947849);
          paramView.dL.setBackgroundResource(2130850283);
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
          return localView;
          i += 1;
          break;
          paramView.pZ.setTextColor(-1);
          paramView.dL.setBackgroundResource(2130850252);
        }
      }
    }
    
    public void setData(List<mhh> paramList)
    {
      this.mDatas = paramList;
      notifyDataSetChanged();
    }
  }
  
  class b
    implements View.OnClickListener
  {
    mhh a;
    LinearLayout dL;
    LinearLayout dR;
    RelativeLayout[] e;
    ImageView[] h;
    ImageView[] i;
    ImageView[] j;
    TextView[] m;
    TextView pZ;
    TextView qr;
    
    private b() {}
    
    public void onClick(View paramView)
    {
      boolean bool = true;
      switch (paramView.getId())
      {
      default: 
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      case 2131367397: 
        k = 0;
        label50:
        if (k < this.a.iM.size()) {
          if (((RecommendFollowInfo)this.a.iM.get(k)).isFollowed) {
            break;
          }
        }
        break;
      }
      for (int k = 0;; k = 1)
      {
        ComponentContentRecommendFollowGroup localComponentContentRecommendFollowGroup = ComponentContentRecommendFollowGroup.this;
        List localList = this.a.iM;
        if (k == 0) {}
        for (;;)
        {
          localComponentContentRecommendFollowGroup.o(localList, bool);
          break;
          k += 1;
          break label50;
          bool = false;
        }
        ComponentContentRecommendFollowGroup.this.b((RecommendFollowInfo)paramView.getTag());
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup
 * JD-Core Version:    0.7.0.1
 */