import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqcircle.polylike.QCirclePolyBaseLikeView;
import qqcircle.QQCircleFeedBase.StPolyLike;

class vrr
  extends RecyclerView.ViewHolder
{
  public vrr(vrn paramvrn, View paramView)
  {
    super(paramView);
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    if ((this.itemView instanceof QCirclePolyBaseLikeView))
    {
      RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(bdep.a / 4, bdep.a / 4);
      this.itemView.setLayoutParams(localLayoutParams);
      ((QCirclePolyBaseLikeView)this.itemView).setReportBean(vrn.a(this.a));
      ((QCirclePolyBaseLikeView)this.itemView).setRequestManager(vrn.a(this.a));
      ((QCirclePolyBaseLikeView)this.itemView).setCurrentFeed(vrn.a(this.a));
      ((QCirclePolyBaseLikeView)this.itemView).setHookListener(new vrs(this));
      ((QCirclePolyBaseLikeView)this.itemView).a(paramStPolyLike, paramInt);
      this.a.a((QCirclePolyBaseLikeView)this.itemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrr
 * JD-Core Version:    0.7.0.1
 */