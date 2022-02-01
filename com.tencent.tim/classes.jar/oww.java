import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.bizparts.QCirclePolyListPart.PolyListAdapter.1;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.LightInteractionBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class oww
  extends rxk
{
  private final String TAG = "QCirclePolyListPart";
  private QCircleBlockContainer jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  private QCircleSlidBottomView jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private oww.b jdField_a_of_type_Oww$b;
  private pef jdField_a_of_type_Pef;
  private FrameLayout ay;
  private boolean ayW;
  private ImageView lS;
  private int mPos;
  
  private void c(pel<List<FeedCloudMeta.StLightInteractInfo>> parampel)
  {
    switch (parampel.getState())
    {
    case 1: 
    default: 
      return;
    case 0: 
    case 4: 
      d(parampel);
      return;
    }
    e(parampel);
  }
  
  private void d(pel<List<FeedCloudMeta.StLightInteractInfo>> parampel)
  {
    if (parampel.getState() == 4) {}
    for (String str = acfp.m(2131700172); !parampel.HV(); str = acfp.m(2131700083))
    {
      this.jdField_a_of_type_Oww$b.clearData();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(0);
      l(false, false, false);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.showEmptyView(str);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
    l(false, true, false);
  }
  
  private void e(pel<List<FeedCloudMeta.StLightInteractInfo>> parampel)
  {
    if (parampel.getData() != null)
    {
      if (parampel.HV()) {
        break label86;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
      this.jdField_a_of_type_Oww$b.a((List)parampel.getData(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.mPos);
      if ((!parampel.HU()) && (!this.ayW) && (parampel.getState() != 2)) {
        this.ayW = true;
      }
    }
    for (;;)
    {
      l(true, parampel.HV(), parampel.HU());
      return;
      label86:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.setVisibility(8);
      this.jdField_a_of_type_Oww$b.ca((List)parampel.getData());
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setRefreshing(false);
    }
  }
  
  protected void dC(View paramView)
  {
    owx localowx = new owx(this);
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView = ((QCircleSlidBottomView)paramView.findViewById(2131374578));
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.setOnClickListener(localowx);
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.setStatusListener(new owy(this));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer = ((QCircleBlockContainer)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131374575));
    this.lS = ((ImageView)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131374576));
    this.lS.setOnClickListener(localowx);
    this.ay = ((FrameLayout)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131374508));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.findViewById(2131374564));
    new LinearLayoutManager(paramView.getContext()).setOrientation(1);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.getBlockMerger().yf(2);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setRefreshing(false);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setParentFragment(b());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().setNestedScrollingEnabled(true);
    paramView = new ArrayList();
    this.jdField_a_of_type_Oww$b = new oww.b(null);
    paramView.add(this.jdField_a_of_type_Oww$b);
    this.jdField_a_of_type_Oww$b.setOnLoadDataDelegate(new owz(this));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.cx(paramView);
    this.jdField_a_of_type_Oww$b.setRecycleView(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.start();
  }
  
  public String getLogTag()
  {
    return "QCirclePolyListPart";
  }
  
  public void l(String paramString, Object paramObject)
  {
    if ((paramObject instanceof oww.c))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((oww.c)paramObject).mFeed;
      this.mPos = ((oww.c)paramObject).mPos;
    }
    if (paramString.equals("poly_zan_list_show"))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = (this.mPos + 1);
      this.ayW = false;
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.getBlockMerger().bxn();
      this.jdField_a_of_type_Oww$b.clearData();
      this.jdField_a_of_type_Pef = ((pef)a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), pef.class));
      this.jdField_a_of_type_Pef.q().removeObservers(b());
      this.jdField_a_of_type_Pef.q().observe(b(), new oxa(this));
      this.jdField_a_of_type_Pef.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, false, false);
      if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.dI(this.ay);
        pcl.a(70, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      }
    }
    while ((!paramString.equals("poly_zan_list_dismiss")) || (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.bki();
  }
  
  public void l(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer != null) && (this.jdField_a_of_type_Oww$b.getBlockMerger() != null))
    {
      this.jdField_a_of_type_Oww$b.getLoadInfo().setCurrentState(4);
      this.jdField_a_of_type_Oww$b.getLoadInfo().setFinish(paramBoolean3);
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setRefreshing(false);
      this.jdField_a_of_type_Oww$b.getBlockMerger().up(false);
      this.jdField_a_of_type_Oww$b.getBlockMerger().sR("");
      this.jdField_a_of_type_Oww$b.getBlockMerger().ay(paramBoolean1, paramBoolean3);
      QLog.d("QCirclePolyListPart", 3, "iscuccess:" + paramBoolean1 + " isfinish:" + paramBoolean3);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.bki();
      return true;
    }
    return super.onBackEvent();
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    private URLImageView N;
    private URLImageView O;
    private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
    private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
    private FeedCloudMeta.StLightInteractInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo;
    private int bgA;
    private int bgB;
    private ImageView lT;
    private FeedCloudMeta.StFeed mFeed;
    private TextView vU;
    
    public a(View paramView)
    {
      super();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131374565));
      this.N = ((URLImageView)paramView.findViewById(2131374566));
      this.O = ((URLImageView)paramView.findViewById(2131374573));
      this.vU = ((TextView)paramView.findViewById(2131374571));
      this.lT = ((ImageView)paramView.findViewById(2131374572));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131374567));
    }
    
    private void a(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo)
    {
      QQCircleFeedBase.LightInteractionBusiData localLightInteractionBusiData = new QQCircleFeedBase.LightInteractionBusiData();
      try
      {
        localLightInteractionBusiData.mergeFrom(paramStLightInteractInfo.busiData.get().toByteArray());
        ous.b(localLightInteractionBusiData.polyInfo.polyIconUrl.get(), this.O);
        ous.b(localLightInteractionBusiData.polyInfo.polyUnderPicUrl.get(), this.N);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramStLightInteractInfo)
      {
        for (;;)
        {
          paramStLightInteractInfo.printStackTrace();
        }
      }
    }
    
    private void b(FeedCloudMeta.StUser paramStUser)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(false);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(paramStUser);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(new oxb(this));
    }
    
    private void c(FeedCloudMeta.StUser paramStUser)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(oww.this.app, paramStUser);
      this.vU.setText(paramStUser.nick.get());
      if (paramStUser.id.get().equals(this.mFeed.poster.id.get()))
      {
        this.lT.setVisibility(0);
        this.lT.setImageResource(2130844870);
      }
      for (;;)
      {
        paramStUser = new oxc(this, paramStUser);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(paramStUser);
        this.vU.setOnClickListener(paramStUser);
        return;
        this.lT.setVisibility(8);
      }
    }
    
    public void a(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo, FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo = paramStLightInteractInfo;
      this.mFeed = paramStFeed;
      this.bgA = paramInt1;
      this.bgB = paramInt2;
      c(paramStLightInteractInfo.user);
      a(paramStLightInteractInfo);
      b(paramStLightInteractInfo.user);
    }
  }
  
  public class b
    extends rxq<FeedCloudMeta.StLightInteractInfo>
  {
    private FeedCloudMeta.StFeed mFeed;
    private int mPos;
    private RecyclerView mRecycleView;
    
    public b(Bundle paramBundle)
    {
      super();
    }
    
    private void bim()
    {
      if (this.mRecycleView != null)
      {
        if (this.mRecycleView.isComputingLayout()) {
          this.mRecycleView.post(new QCirclePolyListPart.PolyListAdapter.1(this));
        }
      }
      else {
        return;
      }
      notifyDataSetChanged();
    }
    
    public oww.a a(ViewGroup paramViewGroup, int paramInt)
    {
      return new oww.a(oww.this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560934, paramViewGroup, false));
    }
    
    public void a(List<FeedCloudMeta.StLightInteractInfo> paramList, FeedCloudMeta.StFeed paramStFeed, int paramInt)
    {
      this.mFeed = paramStFeed;
      this.mPos = paramInt;
      if (paramList != null)
      {
        this.mDataList.clear();
        bim();
        this.mDataList.addAll(paramList);
        bim();
      }
    }
    
    public void ca(List<FeedCloudMeta.StLightInteractInfo> paramList)
    {
      this.mDataList.addAll(this.mDataList.size(), paramList);
      bim();
    }
    
    public void clearData()
    {
      this.mDataList.clear();
      bim();
    }
    
    public int getItemCount()
    {
      return this.mDataList.size();
    }
    
    public int getViewTypeCount()
    {
      return 0;
    }
    
    public void loadData(rxt paramrxt) {}
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if (this.mDataList.size() > paramInt) {
        ((oww.a)paramViewHolder).a((FeedCloudMeta.StLightInteractInfo)this.mDataList.get(paramInt), this.mFeed, this.mPos, paramInt);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
    }
    
    public void onInitBlock(Bundle paramBundle) {}
    
    public void setRecycleView(RecyclerView paramRecyclerView)
    {
      this.mRecycleView = paramRecyclerView;
    }
  }
  
  public static class c
  {
    public FeedCloudMeta.StFeed mFeed;
    public int mPos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oww
 * JD-Core Version:    0.7.0.1
 */