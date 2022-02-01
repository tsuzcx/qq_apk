import android.animation.ValueAnimator;
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
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.2;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.6;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView.a;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView.b;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListReq;
import tencent.im.oidb.oidb_0xc2f.ReqBody;

public class lsf
  extends ViewBase
  implements DisableSlideHorizontalListView.a, DisableSlideHorizontalListView.b
{
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  private lsf.b jdField_a_of_type_Lsf$b;
  private ArticleInfo b;
  private lce g = new lsh(this);
  private ViewBase j;
  private ViewBase k;
  private int mHeight;
  private LinearLayout mRootView;
  
  private lsf(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mRootView = ((LinearLayout)LayoutInflater.from(paramVafContext.getContext()).inflate(2131560478, null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)this.mRootView.findViewById(2131376927));
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)this.mRootView.findViewById(2131363393);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_Lsf$b = new lsf.b(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setDividerWidth(riw.dip2px(paramVafContext.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_Lsf$b);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnViewWindowChangedListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.mHeight = riw.dip2px(paramVafContext.getContext(), 6.0F);
  }
  
  private void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    lbz.a().l(this.b);
    ThreadManager.post(new ReadInJoySocializeRecommendFollowView.6(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  private void aNi()
  {
    ViewBean localViewBean = new ViewBean();
    ValueBean localValueBean = localViewBean.valueBean;
    String str1;
    if (this.b.isShowRecommendList) {
      str1 = "VISIBLE";
    }
    for (;;)
    {
      localValueBean.putTrueDynamicValue("visibility", str1);
      bindDynamicValue(localViewBean);
      localViewBean = new ViewBean();
      localValueBean = localViewBean.valueBean;
      if (this.b.isShowRecommendList)
      {
        str1 = "GONE";
        localValueBean.putTrueDynamicValue("visibility", str1);
      }
      try
      {
        if (llu.O(this.b)) {
          localViewBean.valueBean.putTrueDynamicValue("visibility", "GONE");
        }
        if (this.j != null) {
          this.j.bindDynamicValue(localViewBean);
        }
        localViewBean = new ViewBean();
        localValueBean = localViewBean.valueBean;
        if (this.b.isShowRecommendList)
        {
          str1 = "VISIBLE";
          localValueBean.putTrueDynamicValue("visibility", str1);
          if (this.k != null) {
            this.k.bindDynamicValue(localViewBean);
          }
          return;
          str1 = "GONE";
          continue;
          str1 = "VISIBLE";
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ReadInJoySocializeRecommendFollowView", 2, localJSONException, new Object[0]);
          continue;
          String str2 = "GONE";
        }
      }
    }
  }
  
  private void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!aqiw.isNetworkAvailable(this.mContext.getContext())) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySocializeRecommendFollowView", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    paramRecommendFollowInfo = kwt.acJ + aqgo.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    Intent localIntent = new Intent(this.mContext.getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", paramRecommendFollowInfo);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    this.mContext.getContext().startActivity(localIntent);
  }
  
  private void ez(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "requestRecommendList, uin = " + BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    }
    oidb_0xc2f.ReqBody localReqBody = new oidb_0xc2f.ReqBody();
    oidb_0xc2f.GetFollowUserRecommendListReq localGetFollowUserRecommendListReq = new oidb_0xc2f.GetFollowUserRecommendListReq();
    localGetFollowUserRecommendListReq.uint64_followed_uin.set(paramLong);
    localReqBody.msg_get_follow_user_recommend_list_req.set(localGetFollowUserRecommendListReq);
    jnm.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new lsn(this), localReqBody.toByteArray(), "OidbSvc.0xc2f", 3119, 1, null, 0L);
  }
  
  private void nF(boolean paramBoolean)
  {
    lsl locallsl = new lsl(this);
    lsm locallsm = new lsm(this, paramBoolean);
    if (paramBoolean) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { riw.dip2px(this.mContext.getContext(), 6.0F), this.mRootView.getMeasuredHeight() });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.mRootView.getMeasuredHeight(), riw.dip2px(this.mContext.getContext(), 6.0F) }))
    {
      localValueAnimator.addListener(locallsm);
      localValueAnimator.addUpdateListener(locallsl);
      localValueAnimator.setDuration(300L);
      localValueAnimator.start();
      return;
    }
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (aqiw.isNetworkAvailable(this.mContext.getContext()))
    {
      if ((paramBoolean) && (paramRecommendFollowInfo.type != 1)) {
        break label39;
      }
      c(paramRecommendFollowInfo, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Lsf$b.notifyDataSetChanged();
      return;
      label39:
      if (paramRecommendFollowInfo.type == 2) {
        b(paramRecommendFollowInfo, paramBoolean);
      } else {
        QLog.e("ReadInJoySocializeRecommendFollowView", 1, "followAccount, error type, info.type = " + paramRecommendFollowInfo.type + ", follow = " + paramBoolean);
      }
    }
  }
  
  public void aNj()
  {
    String str = this.b.mRecommendFollowInfos.jumpUrl;
    Intent localIntent = new Intent(this.mContext.getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", str);
    this.mContext.getContext().startActivity(localIntent);
    kbp.a(null, kxm.getLongAccountUin() + "", "0X800984C", "0X800984C", 0, 0, "1", "", "", "", false);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    lbz.a().a().a(localQQAppInterface.getCurrentAccountUin(), paramRecommendFollowInfo.uin + "", paramBoolean, new lsi(this, paramRecommendFollowInfo), 2);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      lbz.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, new lsj(this, paramRecommendFollowInfo), 1);
      return;
    }
    lbz.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, new lsk(this, paramRecommendFollowInfo), 1);
  }
  
  public int getComMeasuredHeight()
  {
    return this.mHeight;
  }
  
  public int getComMeasuredWidth()
  {
    return this.mRootView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.mRootView;
  }
  
  public void onAttachedToWindow()
  {
    lcc.a().b(this.g);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mRootView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mRootView.measure(paramInt1, paramInt2);
  }
  
  public void onDetachedFromWindow()
  {
    lcc.a().c(this.g);
  }
  
  public void setModel(lie paramlie)
  {
    this.b = paramlie.a();
    if (this.j == null) {
      this.j = getParent().findViewBaseByName("id_dislike_button");
    }
    if (this.k == null)
    {
      this.k = getParent().findViewBaseByName("id_social_header_fold_button");
      if (this.k != null) {
        this.k.setOnClickListener(new lsg(this));
      }
    }
    aNi();
    if ((this.b.isShowRecommendList) && (this.b.mRecommendFollowInfos != null) && (this.b.mRecommendFollowInfos.iM != null))
    {
      this.jdField_a_of_type_Lsf$b.setData(this.b.mRecommendFollowInfos.iM);
      paramlie = new ReadInJoySocializeRecommendFollowView.2(this);
      if (this.mRootView.getMeasuredHeight() == 0)
      {
        this.mRootView.post(paramlie);
        return;
      }
      paramlie.run();
      return;
    }
    this.mHeight = riw.dip2px(this.mContext.getContext(), 6.0F);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lsf(paramVafContext, null);
    }
  }
  
  public class b
    extends BaseAdapter
  {
    private List<RecommendFollowInfo> mDatas;
    
    private b() {}
    
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
      int j = 8;
      Object localObject1;
      RecommendFollowInfo localRecommendFollowInfo;
      Object localObject2;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560453, paramViewGroup, false);
        localObject1 = new lsf.c(lsf.this, null);
        ((lsf.c)localObject1).jb = ((ImageView)paramView.findViewById(2131368398));
        ((lsf.c)localObject1).fc = ((RelativeLayout)paramView.findViewById(2131368407));
        ((lsf.c)localObject1).vImage = ((ImageView)paramView.findViewById(2131381453));
        ((lsf.c)localObject1).jc = ((ImageView)paramView.findViewById(2131378685));
        ((lsf.c)localObject1).pY = ((TextView)paramView.findViewById(2131372390));
        ((lsf.c)localObject1).tagText = ((TextView)paramView.findViewById(2131379233));
        ((lsf.c)localObject1).pZ = ((TextView)paramView.findViewById(2131367406));
        ((lsf.c)localObject1).dL = ((LinearLayout)paramView.findViewById(2131367397));
        paramView.setTag(localObject1);
        paramView.setBackgroundResource(2130843795);
        paramView.setOnClickListener((View.OnClickListener)localObject1);
        ((lsf.c)localObject1).fc.setOnClickListener((View.OnClickListener)localObject1);
        ((lsf.c)localObject1).pY.setOnClickListener((View.OnClickListener)localObject1);
        ((lsf.c)localObject1).dL.setOnClickListener((View.OnClickListener)localObject1);
        localRecommendFollowInfo = (RecommendFollowInfo)this.mDatas.get(paramInt);
        ((lsf.c)localObject1).b = localRecommendFollowInfo;
        lsf.a(lsf.this).mRecommendFollowInfos.reportMap.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
        if (TextUtils.isEmpty(localRecommendFollowInfo.headUrl)) {
          break label535;
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = aqhu.at();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
        localObject2 = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(aqbn.b);
        ((URLDrawable)localObject2).setFadeInImage(true);
        ((lsf.c)localObject1).jb.setImageDrawable((Drawable)localObject2);
        label317:
        ((lsf.c)localObject1).pY.setText(localRecommendFollowInfo.nickName);
        ((lsf.c)localObject1).tagText.setText(localRecommendFollowInfo.recommendReason);
        if (!localRecommendFollowInfo.isFollowed) {
          break label549;
        }
        ((lsf.c)localObject1).pZ.setTextColor(-8947849);
        ((lsf.c)localObject1).dL.setBackgroundResource(2130850283);
        label371:
        localObject2 = ((lsf.c)localObject1).vImage;
        if (!localRecommendFollowInfo.isVip) {
          break label572;
        }
      }
      label535:
      label549:
      label572:
      for (int i = 0;; i = 8)
      {
        ((ImageView)localObject2).setVisibility(i);
        localObject1 = ((lsf.c)localObject1).jc;
        i = j;
        if (localRecommendFollowInfo.isStar) {
          i = 0;
        }
        ((ImageView)localObject1).setVisibility(i);
        if (!localRecommendFollowInfo.hasReport)
        {
          localRecommendFollowInfo.hasReport = true;
          kbp.a(null, kxm.getLongAccountUin() + "", "0X8009848", "0X8009848", 0, 0, "1", localRecommendFollowInfo.uin + "", "", "", false);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (lsf.c)paramView.getTag();
        break;
        ((lsf.c)localObject1).jb.setImageDrawable(aqhu.at());
        break label317;
        ((lsf.c)localObject1).pZ.setTextColor(-1);
        ((lsf.c)localObject1).dL.setBackgroundResource(2130850252);
        break label371;
      }
    }
    
    public void setData(List<RecommendFollowInfo> paramList)
    {
      this.mDatas = paramList;
      notifyDataSetChanged();
    }
  }
  
  class c
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
    
    private c() {}
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        lsf locallsf = lsf.this;
        RecommendFollowInfo localRecommendFollowInfo = this.b;
        if (!this.b.isFollowed) {}
        for (boolean bool = true;; bool = false)
        {
          locallsf.a(localRecommendFollowInfo, bool);
          kbp.a(null, kxm.getLongAccountUin() + "", "0X800984A", "0X800984A", 0, 0, "1", this.b.uin + "", "", "", false);
          break;
        }
        lsf.b(lsf.this, this.b);
        kbp.a(null, kxm.getLongAccountUin() + "", "0X8009849", "0X8009849", 0, 0, "1", this.b.uin + "", "", "", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsf
 * JD-Core Version:    0.7.0.1
 */