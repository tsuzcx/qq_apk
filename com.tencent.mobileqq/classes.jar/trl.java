import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.widgets.QCircleDefaultFeedWidget;
import com.tencent.biz.qqcircle.widgets.QCircleFeedWidget;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;

public class trl
  extends QCircleFakeAdapter
{
  private static String jdField_a_of_type_JavaLangString = "QCircleRelativeAdapter";
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private tqc jdField_a_of_type_Tqc;
  private tyc jdField_a_of_type_Tyc;
  
  public trl(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a()
  {
    return 3;
  }
  
  public trm a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
      return new trm(new QCircleDefaultFeedWidget(a().getActivity(), paramInt));
    case 2: 
    case 3: 
      return new trm(new QCircleFeedWidget(a().getActivity(), paramInt));
    }
    return new trm(new QCircleRecommendWidget(paramViewGroup.getContext(), paramInt));
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    super.a(paramArrayList);
  }
  
  public void a(yeb paramyeb) {}
  
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
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localStFeed.dittoFeed.dittoId.get() != 0)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getItemViewType()  data.dittoFeed.dittoId.get() = " + localStFeed.dittoFeed.dittoId.get());
        return 4;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getItemViewType()  data.type = " + localStFeed.type.get());
      return localStFeed.type.get();
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "getItemViewType()  return 0");
    return 0;
  }
  
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
    this.jdField_a_of_type_Tqc = new tqc(a(), paramRecyclerView);
    a(this.jdField_a_of_type_Tqc);
    this.jdField_a_of_type_Tyc = new tyc();
    a(this.jdField_a_of_type_Tyc);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      ((trm)paramViewHolder).a(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), paramInt, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, (trr)this.jdField_a_of_type_Xzc);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Tqc != null)
    {
      b(this.jdField_a_of_type_Tqc);
      this.jdField_a_of_type_Tqc.a();
    }
    if (this.jdField_a_of_type_Tyc != null)
    {
      b(this.jdField_a_of_type_Tyc);
      this.jdField_a_of_type_Tyc.a();
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.b(paramViewHolder);
    }
    if (this.jdField_a_of_type_Tyc != null) {
      this.jdField_a_of_type_Tyc.a(paramViewHolder);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewAttachedToWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if (this.jdField_a_of_type_Tqc != null) {
      this.jdField_a_of_type_Tqc.a(paramViewHolder);
    }
    if (this.jdField_a_of_type_Tyc != null) {
      this.jdField_a_of_type_Tyc.b(paramViewHolder);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewDetachedFromWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trl
 * JD-Core Version:    0.7.0.1
 */