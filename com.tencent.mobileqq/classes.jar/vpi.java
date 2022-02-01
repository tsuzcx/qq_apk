import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqcircle.polylike.QCirclePolyBaseLikeView;
import qqcircle.QQCircleFeedBase.StPolyLike;

class vpi
  extends RecyclerView.ViewHolder
{
  public vpi(vpe paramvpe, View paramView)
  {
    super(paramView);
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    if ((this.itemView instanceof QCirclePolyBaseLikeView))
    {
      RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(bclx.a / 4, bclx.a / 4);
      this.itemView.setLayoutParams(localLayoutParams);
      ((QCirclePolyBaseLikeView)this.itemView).setReportBean(vpe.a(this.a));
      ((QCirclePolyBaseLikeView)this.itemView).setRequestManager(vpe.a(this.a));
      ((QCirclePolyBaseLikeView)this.itemView).setCurrentFeed(vpe.a(this.a));
      ((QCirclePolyBaseLikeView)this.itemView).setHookListener(new vpj(this));
      ((QCirclePolyBaseLikeView)this.itemView).a(paramStPolyLike, paramInt);
      this.a.a((QCirclePolyBaseLikeView)this.itemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpi
 * JD-Core Version:    0.7.0.1
 */