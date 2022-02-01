import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class sbn
  extends rxq<SubscribeDraftBean>
  implements rwx
{
  public static String TAG = "SubscribeDraftAdapter";
  public static int bwi = ImmersiveUtils.dpToPx(4.0F);
  private int bwd = ImmersiveUtils.dpToPx(19.0F);
  private int bwf = ImmersiveUtils.dpToPx(3.0F);
  private String mUin;
  
  public sbn(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubDraftChangeEvent.class);
    return localArrayList;
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (((StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex() % 2 == 0) {
      paramRect.left = bwi;
    }
    for (paramRect.right = (this.bwf / 2);; paramRect.right = bwi)
    {
      paramRect.bottom = this.bwd;
      return;
      paramRect.left = (this.bwf / 2);
    }
  }
  
  public int getSpanCount(int paramInt)
  {
    return 2;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean isEnableRefresh()
  {
    return true;
  }
  
  public void loadData(rxt paramrxt)
  {
    if ((paramrxt.Mh()) || (paramrxt.Mg())) {
      refreshData();
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof sbn.a)) {
      ((sbn.a)paramViewHolder).a((SubscribeDraftBean)getDataList().get(paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new sbn.a(new SubScribeDraftItemView(paramViewGroup.getContext(), this));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    rwv.a().b(this);
  }
  
  public void onInitBlock(Bundle paramBundle) {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof SubDraftChangeEvent)) {
      refreshData();
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    rwv.a().a(this);
  }
  
  public void refreshData()
  {
    if ((getBlockMerger() != null) && (getContext() != null) && (((PublicFragmentActivity)getContext()).app != null))
    {
      this.mUin = ((PublicFragmentActivity)getContext()).app.getAccount();
      if (shg.a().fV(this.mUin)) {
        shg.a().a(this.mUin, new sbo(this));
      }
    }
    else
    {
      return;
    }
    clearData();
    notifyDataSetChanged();
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
    }
    
    public void a(SubscribeDraftBean paramSubscribeDraftBean)
    {
      if ((this.itemView instanceof SubScribeDraftItemView)) {
        ((SubScribeDraftItemView)this.itemView).setData(paramSubscribeDraftBean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbn
 * JD-Core Version:    0.7.0.1
 */