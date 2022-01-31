import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;

class wlv
  extends RecyclerView.ViewHolder
{
  public wlv(wlt paramwlt, View paramView)
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
 * Qualified Name:     wlv
 * JD-Core Version:    0.7.0.1
 */