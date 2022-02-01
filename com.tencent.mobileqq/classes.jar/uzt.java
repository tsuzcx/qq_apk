import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCirclePYMKRecommendWidget;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;

public class uzt
  extends QCircleFakeAdapter
{
  private static String jdField_a_of_type_JavaLangString = "QCircleInsFeedAdapter";
  private final RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private vup jdField_a_of_type_Vup;
  private vur jdField_a_of_type_Vur;
  private vut jdField_a_of_type_Vut;
  private int b;
  
  public uzt(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.b != 0) && (paramInt == 0) && ((paramViewHolder.itemView instanceof QCircleInsFeedItemView)) && (((FeedCloudMeta.StFeed)this.mDataList.get(0)).type.get() == 2)) {
      ((QCircleInsFeedItemView)paramViewHolder.itemView).setPicInitialItemPos(this.b);
    }
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Vut = new vut(getContext(), paramRecyclerView, this);
    this.jdField_a_of_type_Vup = new vup(a());
    this.jdField_a_of_type_Vut.a(this.jdField_a_of_type_Vup);
    this.jdField_a_of_type_Vur = new vur(a(), a());
    this.jdField_a_of_type_Vut.a(this.jdField_a_of_type_Vur);
    this.jdField_a_of_type_Vut.a(new vuj());
    this.jdField_a_of_type_Vut.a(new vuu());
    this.jdField_a_of_type_Vut.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_Vut.b(this.jdField_a_of_type_Int);
    addOnScrollListener(this.jdField_a_of_type_Vut);
    this.jdField_a_of_type_Vut.a(paramRecyclerView);
  }
  
  protected String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public uzu a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new uzu(new QCircleDefaultFeedItemView(getParentFragment().getActivity(), paramInt));
    case 2: 
    case 3: 
      paramViewGroup = new QCircleInsFeedItemView(getParentFragment().getActivity(), paramInt);
      paramViewGroup.setRecyclerView(getParentRecyclerView());
      paramViewGroup.setReportBean(a());
      paramViewGroup.setShareRecyclerViewPool(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool);
      return new uzu(paramViewGroup);
    case 1001: 
      paramViewGroup = new QCirclePYMKRecommendWidget(paramViewGroup.getContext(), paramInt);
      paramViewGroup.setReportBean(a());
      return new uzu(paramViewGroup);
    case 1002: 
    case 1003: 
      vtq.a("", 54, 2, 1, "", "", "", "", "", null, a().getPageId(), a().getFromPageId());
      paramViewGroup = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131560799, null, false);
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      return new uzu(paramViewGroup);
    case 1004: 
      paramViewGroup = new QCirclePushRankTopView(paramViewGroup.getContext());
      paramViewGroup.setReportBean(a());
      return new uzu(paramViewGroup);
    }
    paramViewGroup = new QCircleTagRecommendWidget(paramViewGroup.getContext(), paramInt);
    paramViewGroup.setReportBean(a());
    return new uzu(paramViewGroup);
  }
  
  public vup a()
  {
    return this.jdField_a_of_type_Vup;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.a(paramInt);
    }
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramStFeed);
    setDatas(localArrayList);
  }
  
  protected String b()
  {
    return "feeds";
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.b(paramInt);
    }
  }
  
  public void d(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.mDataList.get(paramInt);
      if (localStFeed.dittoFeed.dittoId.get() == 1)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getItemViewType()  data.dittoFeed.dittoId.get() = 1");
        return 1001;
      }
      if (localStFeed.dittoFeed.dittoId.get() == 4)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getItemViewType()  data.dittoFeed.dittoId.get() = 4");
        return 1002;
      }
      if (localStFeed.dittoFeed.dittoId.get() == -1) {
        return 1003;
      }
      if (localStFeed.dittoFeed.dittoId.get() == 2) {
        return 1004;
      }
      if (localStFeed.dittoFeed.dittoId.get() == 6) {
        return 1005;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getItemViewType()  data.type = " + localStFeed.type.get());
      return localStFeed.type.get();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "getItemViewType()  return 0");
    return 0;
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
  
  public void loadData(aabu paramaabu) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.e();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.d();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.c();
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    a(paramRecyclerView);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null)
    {
      ((uzu)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, (var)this.mInteractor);
      if (paramInt == 0)
      {
        a(paramViewHolder, paramInt);
        this.b = 0;
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Vut != null)
    {
      removeOnScrollListener(this.jdField_a_of_type_Vut);
      this.jdField_a_of_type_Vut.e();
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.a(paramViewHolder);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewAttachedToWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.b(paramViewHolder);
    }
    this.b = 0;
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewDetachedFromWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
  
  public void setDatas(ArrayList paramArrayList)
  {
    super.setDatas(paramArrayList);
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzt
 * JD-Core Version:    0.7.0.1
 */