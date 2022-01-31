import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;

class wls
  extends RecyclerView.ViewHolder
{
  public wls(wlq paramwlq, View paramView)
  {
    super(paramView);
  }
  
  public void a(SubscribeDraftBean paramSubscribeDraftBean)
  {
    if ((this.itemView instanceof SubScribeDraftItemView)) {
      ((SubScribeDraftItemView)this.itemView).setData(paramSubscribeDraftBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wls
 * JD-Core Version:    0.7.0.1
 */