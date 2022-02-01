import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;

public class van
  extends vbl<FeedCloudMeta.StFeed>
{
  private int jdField_a_of_type_Int = ImmersiveUtils.a(8.0F);
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private vur jdField_a_of_type_Vur;
  private vut jdField_a_of_type_Vut;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = ImmersiveUtils.a(8.0F);
  private int c = ImmersiveUtils.a(18.0F);
  private int d = ImmersiveUtils.a(8.0F);
  private int e = ImmersiveUtils.a(12.5F);
  
  public van(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Vut = new vut(getContext(), paramRecyclerView, this);
    this.jdField_a_of_type_Vur = new vur(a(), a());
    this.jdField_a_of_type_Vut.a(this.jdField_a_of_type_Vur);
    this.jdField_a_of_type_Vut.a(new vuj());
    this.jdField_a_of_type_Vut.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    addOnScrollListener(this.jdField_a_of_type_Vut);
    this.jdField_a_of_type_Vut.a(paramRecyclerView);
  }
  
  protected String a()
  {
    return "QCircleWaterfallFeedsBlock";
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRecyclerView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    QLog.d("QCircleWaterfallFeedsBlock", 1, "getItemOffsets layoutPosition:" + i);
    paramRect.top = (this.b / 2 - this.e);
    if (paramRecyclerView.getSpanIndex() % 2 == 0) {
      paramRect.left = (this.jdField_a_of_type_Int - this.e);
    }
    for (paramRect.right = (this.d / 2 - this.e);; paramRect.right = (this.jdField_a_of_type_Int - this.e))
    {
      paramRect.bottom = (this.b / 2 - this.e);
      return;
      paramRect.left = (this.d / 2 - this.e);
    }
  }
  
  public int getSpanCount(int paramInt)
  {
    return 2;
  }
  
  public String getUniqueKey()
  {
    return "WATERFALL_ADAPTER_UNIQUE_KEY";
  }
  
  public int getViewTypeCount()
  {
    return 1;
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = paramRecyclerView.getLayoutManager();
    a(paramRecyclerView);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (blgn.a(paramInt, getDataList())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getDataList().get(paramInt);
      ((vap)paramViewHolder).a(localStFeed, getExtraTypeInfo(), paramInt);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleWaterfallFeedItemView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(a());
    return new vap(this, paramViewGroup);
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
  
  public void onInitBlock(Bundle paramBundle)
  {
    getParentRecyclerView().addOnScrollListener(new vao(this));
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.a(paramViewHolder);
    }
    QLog.d("QCircleWaterfallFeedsBlock", 4, "onViewAttachedToWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.b(paramViewHolder);
    }
    QLog.d("QCircleWaterfallFeedsBlock", 4, "onViewDetachedFromWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
  
  public void setDatas(ArrayList<FeedCloudMeta.StFeed> paramArrayList)
  {
    super.setDatas(paramArrayList);
    if (this.jdField_a_of_type_Vut != null) {
      this.jdField_a_of_type_Vut.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     van
 * JD-Core Version:    0.7.0.1
 */