import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView.a;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ovh
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private ExtraTypeInfo mExtraTypeInfo;
  private BaseWidgetView.a mInteractor;
  private List<ovx> mList;
  
  public void bF(List<ovx> paramList)
  {
    this.mList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.mList == null) {
      return 0;
    }
    return this.mList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mList != null) && ((this.mInteractor instanceof ovv))) {
      ((ovh.a)paramViewHolder).a(this.mList.get(paramInt), paramInt, this.mExtraTypeInfo, (ovv)this.mInteractor);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ovh.a(new QCircleFeedCommentWidget(paramViewGroup.getContext()));
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setInteractor(BaseWidgetView.a parama)
  {
    this.mInteractor = parama;
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
 * Qualified Name:     ovh
 * JD-Core Version:    0.7.0.1
 */