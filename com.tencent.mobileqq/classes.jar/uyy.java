import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleTimeLineAndGridFeedAdapter.1;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Calendar;

public class uyy
  extends QCircleFakeAdapter
{
  private static String jdField_a_of_type_JavaLangString = "QCircleTimeLineAndGridFeedAdapter";
  public static final boolean a;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private vsc jdField_a_of_type_Vsc;
  private vsg jdField_a_of_type_Vsg;
  private vsi jdField_a_of_type_Vsi;
  private vsj jdField_a_of_type_Vsj;
  private int b;
  private int c = Calendar.getInstance().get(1);
  
  static
  {
    jdField_a_of_type_Boolean = QzoneConfig.getQQCircleEnablePlayVideoInWorksTab();
  }
  
  public uyy(Bundle paramBundle, int paramInt)
  {
    super(paramBundle);
    this.b = paramInt;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "QCircleTimeLineAndGridFeedAdapter spanCount:" + paramInt);
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_Vsg = new vsg(getContext(), paramRecyclerView, this);
    this.jdField_a_of_type_Vsi = new vsi(a());
    this.jdField_a_of_type_Vsj = new vsj();
    if (jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Vsc = new vsc(a());
      this.jdField_a_of_type_Vsc.a(false, true);
      this.jdField_a_of_type_Vsg.a(this.jdField_a_of_type_Vsc);
      this.jdField_a_of_type_Vsg.a(new vsh());
    }
    this.jdField_a_of_type_Vsg.a(this.jdField_a_of_type_Vsi);
    this.jdField_a_of_type_Vsg.a(this.jdField_a_of_type_Vsj);
    this.jdField_a_of_type_Vsg.a(new vrx());
    addOnScrollListener(this.jdField_a_of_type_Vsg);
    this.jdField_a_of_type_Vsg.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_Vsg.a(paramRecyclerView);
  }
  
  private boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      if ((paramInt1 + 1) % paramInt2 == 0) {
        bool = true;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool;
          bool = false;
        }
        if (!(paramRecyclerView instanceof StaggeredGridLayoutManager)) {
          break label76;
        }
        if (((StaggeredGridLayoutManager)paramRecyclerView).getOrientation() != 1) {
          break;
        }
      } while ((paramInt1 + 1) % paramInt2 == 0);
      return false;
    } while (paramInt1 >= paramInt3 - paramInt3 % paramInt2);
    return false;
    label76:
    return false;
  }
  
  private boolean b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        bool = true;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool;
          bool = false;
        }
        if (!(paramRecyclerView instanceof StaggeredGridLayoutManager)) {
          break label79;
        }
        if (((StaggeredGridLayoutManager)paramRecyclerView).getOrientation() != 1) {
          break;
        }
      } while (paramInt1 >= paramInt3 - paramInt3 % paramInt2);
      return false;
    } while ((paramInt1 + 1) % paramInt2 == 0);
    return false;
    label79:
    return false;
  }
  
  protected String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public uyz a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new uyz(new QCircleDefaultFeedItemView(getContext(), paramInt));
    case 1001: 
    case 1002: 
    case 1003: 
      paramViewGroup = new QCircleTimeLineFeedItemView(getContext(), paramInt);
      paramViewGroup.setReportBean(a());
      return new uyz(paramViewGroup);
    }
    paramViewGroup = new QCircleGridFeedItemView(getContext(), paramInt);
    paramViewGroup.setTag(2131376495, Boolean.valueOf(true));
    paramViewGroup.setReportBean(a());
    return new uyz(paramViewGroup);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Vsg != null) {
      this.jdField_a_of_type_Vsg.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Vsg != null) {
      this.jdField_a_of_type_Vsg.a(paramInt);
    }
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    if (this.jdField_a_of_type_Vsg != null) {
      this.jdField_a_of_type_Vsg.a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "setTimeLineVideoPlayState canPlay:" + paramBoolean);
    if (this.jdField_a_of_type_Vsc == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "playerHelper is null");
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QCircleTimeLineAndGridFeedAdapter.1(this, paramBoolean), 500L);
  }
  
  public void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = this.b;
    int j = paramRecyclerView.getAdapter().getItemCount();
    int k = paramRecyclerView.getChildLayoutPosition(paramView);
    if ((k == 0) && (i == 1))
    {
      paramRect.set(0, zby.b(getContext(), 24.0F), 0, zby.b(getContext(), 1.0F));
      return;
    }
    if (b(paramRecyclerView, k, i, j))
    {
      paramRect.set(0, 0, zby.b(getContext(), 1.0F), 0);
      return;
    }
    if (a(paramRecyclerView, k, i, j))
    {
      paramRect.set(0, 0, 0, zby.b(getContext(), 1.0F));
      return;
    }
    paramRect.set(0, 0, zby.b(getContext(), 1.0F), zby.b(getContext(), 1.0F));
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt))
    {
      if (this.b == 1)
      {
        FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.mDataList.get(paramInt);
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(localStFeed.createTime.get() * 1000L);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "Date:" + localCalendar.get(1) + localCalendar.get(2) + localCalendar.get(5));
        int i = localCalendar.get(1);
        int j = localCalendar.get(6);
        if (paramInt > 0)
        {
          localCalendar.setTimeInMillis(((FeedCloudMeta.StFeed)this.mDataList.get(paramInt - 1)).createTime.get() * 1000L);
          paramInt = localCalendar.get(1);
          int k = localCalendar.get(6);
          if ((this.c != i) && (paramInt != i)) {
            return 1001;
          }
          if (j != k) {
            return 1002;
          }
          return 1003;
        }
        if (this.c != i) {
          return 1001;
        }
        return 1002;
      }
      if (this.b == 3) {
        return 2001;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "getItemViewType()  return 0");
    return 0;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void loadData(zxz paramzxz) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_Vsg != null) {
      this.jdField_a_of_type_Vsg.e();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if (this.jdField_a_of_type_Vsg != null) {
      this.jdField_a_of_type_Vsg.d();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_Vsg != null) {
      this.jdField_a_of_type_Vsg.c();
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    a(paramRecyclerView);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList != null) && ((paramViewHolder instanceof uyz)))
    {
      uyz localuyz = (uyz)paramViewHolder;
      this.mDataList.get(paramInt);
      localuyz.a(this.mDataList.get(paramInt), paramInt, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, (uzb)this.mInteractor);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Vsg != null)
    {
      removeOnScrollListener(this.jdField_a_of_type_Vsg);
      this.jdField_a_of_type_Vsg.e();
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (this.jdField_a_of_type_Vsg != null) {
      this.jdField_a_of_type_Vsg.a(paramViewHolder);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewAttachedToWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if (this.jdField_a_of_type_Vsg != null) {
      this.jdField_a_of_type_Vsg.b(paramViewHolder);
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "onViewDetachedFromWindow:" + paramViewHolder.getAdapterPosition() + "  " + paramViewHolder + "  " + this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyy
 * JD-Core Version:    0.7.0.1
 */