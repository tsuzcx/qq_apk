import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;

class uzu
  extends RecyclerView.ViewHolder
{
  public uzu(View paramView)
  {
    super(paramView);
  }
  
  public void a(Object paramObject, int paramInt, ExtraTypeInfo paramExtraTypeInfo, var paramvar)
  {
    if ((this.itemView instanceof BaseWidgetView))
    {
      this.itemView.setTag(this);
      ((BaseWidgetView)this.itemView).setInteractor(paramvar);
      ((BaseWidgetView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
      ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
      ((BaseWidgetView)this.itemView).setDataPosInList(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzu
 * JD-Core Version:    0.7.0.1
 */