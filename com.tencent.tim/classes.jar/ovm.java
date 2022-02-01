import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleMessageReplyItemView;
import com.tencent.biz.qqcircle.widgets.message.item.QCircleMessageReplyItemView.a;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ovm
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private QCircleMessageReplyItemView.a a;
  private ExtraTypeInfo mExtraTypeInfo;
  private List<ovx> mList;
  
  public void a(QCircleMessageReplyItemView.a parama)
  {
    this.a = parama;
  }
  
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
    if (this.mList != null) {
      ((ovm.a)paramViewHolder).a(this.mList.get(paramInt), paramInt, this.mExtraTypeInfo);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleMessageReplyItemView(paramViewGroup.getContext());
    paramViewGroup.setReplyItemListener(this.a);
    return new ovm.a(paramViewGroup);
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    public a(BaseWidgetView paramBaseWidgetView)
    {
      super();
    }
    
    public void a(Object paramObject, int paramInt, ExtraTypeInfo paramExtraTypeInfo)
    {
      if ((this.itemView instanceof BaseWidgetView))
      {
        this.itemView.setTag(this);
        ((BaseWidgetView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
        ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovm
 * JD-Core Version:    0.7.0.1
 */