import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.widgets.QCircleDefaultFeedWidget;
import com.tencent.biz.qqcircle.widgets.QCircleFeedDividerWidget;
import com.tencent.biz.qqcircle.widgets.QCircleFeedWidget;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;

public class ovg
  extends QCircleFakeAdapter
{
  private static String TAG = "QCircleRelativeAdapter";
  private pdd jdField_a_of_type_Pdd;
  private pdf jdField_a_of_type_Pdf;
  private pdg jdField_a_of_type_Pdg;
  private ExtraTypeInfo mExtraTypeInfo;
  
  public ovg(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void c(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Pdg = new pdg(getContext(), paramRecyclerView);
    this.jdField_a_of_type_Pdd = new pdd();
    this.jdField_a_of_type_Pdg.a(this.jdField_a_of_type_Pdd);
    this.jdField_a_of_type_Pdf = new pdf();
    this.jdField_a_of_type_Pdg.a(this.jdField_a_of_type_Pdf);
    this.jdField_a_of_type_Pdg.a(new pda());
    addOnScrollListener(this.jdField_a_of_type_Pdg);
    this.jdField_a_of_type_Pdg.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public ovg.a a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e(TAG, 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new ovg.a(new QCircleDefaultFeedWidget(getParentFragment().getActivity(), paramInt));
    case 2: 
    case 3: 
      return new ovg.a(new QCircleFeedWidget(getParentFragment().getActivity(), paramInt));
    case 1001: 
      return new ovg.a(new QCircleRecommendWidget(paramViewGroup.getContext(), paramInt));
    }
    return new ovg.a(new QCircleFeedDividerWidget(paramViewGroup.getContext()));
  }
  
  public void bhT()
  {
    if (this.jdField_a_of_type_Pdd != null) {
      this.jdField_a_of_type_Pdd.bhT();
    }
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
        QLog.d(TAG, 2, "getItemViewType()  data.dittoFeed.dittoId.get() = 1");
        return 1001;
      }
      if (localStFeed.dittoFeed.dittoId.get() == 4)
      {
        QLog.d(TAG, 2, "getItemViewType()  data.dittoFeed.dittoId.get() = 4");
        return 1002;
      }
      QLog.d(TAG, 2, "getItemViewType()  data.type = " + localStFeed.type.get());
      return localStFeed.type.get();
    }
    QLog.e(TAG, 2, "getItemViewType()  return 0");
    return 0;
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
  
  public void loadData(rxt paramrxt) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_Pdd != null) {
      this.jdField_a_of_type_Pdd.onDestroy();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if (this.jdField_a_of_type_Pdd != null) {
      this.jdField_a_of_type_Pdd.onPause();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_Pdd != null) {
      this.jdField_a_of_type_Pdd.onResumed();
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    c(paramRecyclerView);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null) {
      ((ovg.a)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo, (ovv)this.mInteractor);
    }
    QLog.d(TAG, 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Pdg != null)
    {
      removeOnScrollListener(this.jdField_a_of_type_Pdg);
      this.jdField_a_of_type_Pdg.onDestroy();
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_Pdd != null) {
      this.jdField_a_of_type_Pdd.onPageSelected(paramInt);
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (this.jdField_a_of_type_Pdg != null) {
      this.jdField_a_of_type_Pdg.onViewAttachedToWindow(paramViewHolder);
    }
    QLog.d(TAG, 4, "onViewAttachedToWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if (this.jdField_a_of_type_Pdg != null) {
      this.jdField_a_of_type_Pdg.onViewDetachedFromWindow(paramViewHolder);
    }
    QLog.d(TAG, 4, "onViewDetachedFromWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
  
  public void setDatas(ArrayList paramArrayList)
  {
    super.setDatas(paramArrayList);
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
    if (this.jdField_a_of_type_Pdg != null) {
      this.jdField_a_of_type_Pdg.a(this.mExtraTypeInfo);
    }
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    public a(BaseWidgetView paramBaseWidgetView)
    {
      super();
    }
    
    public void a(Object paramObject, int paramInt, ExtraTypeInfo paramExtraTypeInfo, ovv paramovv)
    {
      if ((this.itemView instanceof BaseWidgetView))
      {
        this.itemView.setTag(this);
        ((BaseWidgetView)this.itemView).setInteractor(paramovv);
        ((BaseWidgetView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
        ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovg
 * JD-Core Version:    0.7.0.1
 */