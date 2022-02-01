package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import lie;
import ljc;
import lwk;
import lwm.a;
import mbq;
import mbr;
import mbs;
import mbt;
import mbu;
import mhx;
import ndi;
import riw;

public class ComponentContentRecommendFollowList
  extends RelativeLayout
  implements DisableSlideHorizontalListView.a, lwk
{
  private static int aQo = -1;
  private a a;
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private DisableSlideHorizontalListView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  private lie d;
  protected lce g = new mbu(this);
  private View kG;
  private View kH;
  private TextView mTitleText;
  
  public ComponentContentRecommendFollowList(Context paramContext)
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
      String str = ComponentContentRecommend.a(paramInt, localRecommendFollowInfo.uin, paramBaseArticleInfo, localRecommendFollowInfo.algorithmId, 2, 0, aQo, null);
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
    this.a.setData(paramObject.iM);
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
    ThreadManager.post(new ComponentContentRecommendFollowList.3(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (aqiw.isNetworkAvailable(getContext()))
    {
      if (!paramBoolean) {
        break label55;
      }
      b("0X80094DC", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 1);
      if (paramRecommendFollowInfo.type != 1) {
        break label77;
      }
      c(paramRecommendFollowInfo, paramBoolean);
    }
    for (;;)
    {
      this.a.notifyDataSetChanged();
      return;
      label55:
      b("0X80094DD", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 1);
      break;
      label77:
      if (paramRecommendFollowInfo.type == 2) {
        b(paramRecommendFollowInfo, paramBoolean);
      } else {
        QLog.e("ComponentContentRecommendFollowList", 1, "followAccount, error type, info.type = " + paramRecommendFollowInfo.type + ", follow = " + paramBoolean);
      }
    }
  }
  
  public void a(lwm.a parama) {}
  
  public void aNZ()
  {
    Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jumpUrl;
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", (String)localObject);
    getContext().startActivity(localIntent);
    localObject = (RecommendFollowInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.iM.get(0);
    b("0X800955C", 0L, ((RecommendFollowInfo)localObject).algorithmId, ((RecommendFollowInfo)localObject).strategyId, 0);
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
        QLog.d("ComponentContentRecommendFollowList", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    String str = kwt.acJ + aqgo.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    getContext().startActivity(localIntent);
    b("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    lbz.a().a().a(localQQAppInterface.getCurrentAccountUin(), paramRecommendFollowInfo.uin + "", paramBoolean, new mbr(this, paramRecommendFollowInfo), 2);
  }
  
  protected void b(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
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
    String str = ComponentContentRecommend.a(i, paramLong1, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramLong2, 2, paramInt2, aQo, null);
    kbp.a(null, kxm.getLongAccountUin() + "", paramString, paramString, 0, 0, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowId + "", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", paramInt1 + "", str, false);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      lbz.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, new mbs(this, paramRecommendFollowInfo), 1);
      return;
    }
    lbz.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, new mbt(this, paramRecommendFollowInfo), 1);
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
    this.kH.setOnClickListener(new mbq(this));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560304, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
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
    private List<RecommendFollowInfo> mDatas;
    
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
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int j = 0;
      Object localObject1;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560453, paramViewGroup, false);
        localObject1 = new ComponentContentRecommendFollowList.b(ComponentContentRecommendFollowList.this, null);
        ((ComponentContentRecommendFollowList.b)localObject1).jb = ((ImageView)paramView.findViewById(2131368398));
        ((ComponentContentRecommendFollowList.b)localObject1).fc = ((RelativeLayout)paramView.findViewById(2131368407));
        ((ComponentContentRecommendFollowList.b)localObject1).vImage = ((ImageView)paramView.findViewById(2131381453));
        ((ComponentContentRecommendFollowList.b)localObject1).jc = ((ImageView)paramView.findViewById(2131378685));
        ((ComponentContentRecommendFollowList.b)localObject1).pY = ((TextView)paramView.findViewById(2131372390));
        ((ComponentContentRecommendFollowList.b)localObject1).tagText = ((TextView)paramView.findViewById(2131379233));
        ((ComponentContentRecommendFollowList.b)localObject1).pZ = ((TextView)paramView.findViewById(2131367406));
        ((ComponentContentRecommendFollowList.b)localObject1).dL = ((LinearLayout)paramView.findViewById(2131367397));
        paramView.setTag(localObject1);
        paramView.setOnClickListener((View.OnClickListener)localObject1);
        ((ComponentContentRecommendFollowList.b)localObject1).fc.setOnClickListener((View.OnClickListener)localObject1);
        ((ComponentContentRecommendFollowList.b)localObject1).pY.setOnClickListener((View.OnClickListener)localObject1);
        ((ComponentContentRecommendFollowList.b)localObject1).dL.setOnClickListener((View.OnClickListener)localObject1);
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)this.mDatas.get(paramInt);
        ((ComponentContentRecommendFollowList.b)localObject1).b = localRecommendFollowInfo;
        ComponentContentRecommendFollowList.a(ComponentContentRecommendFollowList.this).mRecommendFollowInfos.reportMap.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
        if (TextUtils.isEmpty(localRecommendFollowInfo.headUrl)) {
          break label443;
        }
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = aqhu.at();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
        localObject2 = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(aqbn.b);
        ((URLDrawable)localObject2).setFadeInImage(true);
        ((ComponentContentRecommendFollowList.b)localObject1).jb.setImageDrawable((Drawable)localObject2);
        label310:
        ((ComponentContentRecommendFollowList.b)localObject1).pY.setText(localRecommendFollowInfo.nickName);
        ((ComponentContentRecommendFollowList.b)localObject1).tagText.setText(localRecommendFollowInfo.recommendReason);
        if (!localRecommendFollowInfo.isFollowed) {
          break label457;
        }
        ((ComponentContentRecommendFollowList.b)localObject1).pZ.setTextColor(-8947849);
        ((ComponentContentRecommendFollowList.b)localObject1).dL.setBackgroundResource(2130850283);
        label364:
        localObject2 = ((ComponentContentRecommendFollowList.b)localObject1).vImage;
        if (!localRecommendFollowInfo.isVip) {
          break label480;
        }
        i = 0;
        label382:
        ((ImageView)localObject2).setVisibility(i);
        localObject1 = ((ComponentContentRecommendFollowList.b)localObject1).jc;
        if (!localRecommendFollowInfo.isStar) {
          break label487;
        }
      }
      label443:
      label457:
      label480:
      label487:
      for (int i = j;; i = 8)
      {
        ((ImageView)localObject1).setVisibility(i);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (ComponentContentRecommendFollowList.b)paramView.getTag();
        break;
        ((ComponentContentRecommendFollowList.b)localObject1).jb.setImageDrawable(aqhu.at());
        break label310;
        ((ComponentContentRecommendFollowList.b)localObject1).pZ.setTextColor(-1);
        ((ComponentContentRecommendFollowList.b)localObject1).dL.setBackgroundResource(2130850252);
        break label364;
        i = 8;
        break label382;
      }
    }
    
    public void setData(List<RecommendFollowInfo> paramList)
    {
      this.mDatas = paramList;
      notifyDataSetChanged();
    }
  }
  
  class b
    implements View.OnClickListener
  {
    RecommendFollowInfo b;
    LinearLayout dL;
    RelativeLayout fc;
    ImageView jb;
    ImageView jc;
    TextView pY;
    TextView pZ;
    TextView tagText;
    ImageView vImage;
    
    private b() {}
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ComponentContentRecommendFollowList localComponentContentRecommendFollowList = ComponentContentRecommendFollowList.this;
        RecommendFollowInfo localRecommendFollowInfo = this.b;
        if (!this.b.isFollowed) {}
        for (boolean bool = true;; bool = false)
        {
          localComponentContentRecommendFollowList.a(localRecommendFollowInfo, bool);
          break;
        }
        ComponentContentRecommendFollowList.this.b(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList
 * JD-Core Version:    0.7.0.1
 */