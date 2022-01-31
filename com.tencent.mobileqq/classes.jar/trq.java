import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.widgets.QCircleDefaultFeedWidget;
import com.tencent.biz.qqcircle.widgets.QCircleFeedDividerWidget;
import com.tencent.biz.qqcircle.widgets.QCircleFeedWidget;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;

public class trq
  extends QCircleFakeAdapter
{
  private static String jdField_a_of_type_JavaLangString = "QCircleRelativeAdapter";
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private tqc jdField_a_of_type_Tqc;
  private tzo jdField_a_of_type_Tzo;
  
  public trq(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public trr a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new trr(new QCircleDefaultFeedWidget(getParentFragment().getActivity(), paramInt));
    case 2: 
    case 3: 
      return new trr(new QCircleFeedWidget(getParentFragment().getActivity(), paramInt));
    case 1001: 
      return new trr(new QCircleRecommendWidget(paramViewGroup.getContext(), paramInt));
    }
    return new trr(new QCircleFeedDividerWidget(paramViewGroup.getContext()));
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.d();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.a(paramInt);
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getItemViewType()  data.dittoFeed.dittoId.get() = 1");
        return 1001;
      }
      if (localStFeed.dittoFeed.dittoId.get() == 4)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getItemViewType()  data.dittoFeed.dittoId.get() = 4");
        return 1002;
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
  
  public void loadData(yii paramyii) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.a();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.c();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.b();
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_Tqc = new tqc(getContext(), paramRecyclerView);
    addOnScrollListener(this.jdField_a_of_type_Tqc);
    this.jdField_a_of_type_Tzo = new tzo();
    addOnScrollListener(this.jdField_a_of_type_Tzo);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null) {
      ((trr)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, (trw)this.mInteractor);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Tqc != null)
    {
      removeOnScrollListener(this.jdField_a_of_type_Tqc);
      this.jdField_a_of_type_Tqc.a();
    }
    if (this.jdField_a_of_type_Tzo != null)
    {
      removeOnScrollListener(this.jdField_a_of_type_Tzo);
      this.jdField_a_of_type_Tzo.a();
    }
  }
  
  public void onPrepareParams(Bundle paramBundle) {}
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.b(paramViewHolder);
    }
    if (this.jdField_a_of_type_Tzo != null) {
      this.jdField_a_of_type_Tzo.a(paramViewHolder);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewAttachedToWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.a(paramViewHolder);
    }
    if (this.jdField_a_of_type_Tzo != null) {
      this.jdField_a_of_type_Tzo.b(paramViewHolder);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewDetachedFromWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
  
  public void setDatas(ArrayList paramArrayList)
  {
    super.setDatas(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trq
 * JD-Core Version:    0.7.0.1
 */