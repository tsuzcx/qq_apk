import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import qqcircle.QQCircleRankinglist.RankingItem;

class wfk
  extends RecyclerView.ViewHolder
{
  public wfk(View paramView)
  {
    super(paramView);
  }
  
  public void a(QQCircleRankinglist.RankingItem paramRankingItem, int paramInt)
  {
    if ((this.itemView instanceof QCircleBaseWidgetView))
    {
      this.itemView.setTag(this);
      ((QCircleBaseWidgetView)this.itemView).setData(paramRankingItem, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfk
 * JD-Core Version:    0.7.0.1
 */