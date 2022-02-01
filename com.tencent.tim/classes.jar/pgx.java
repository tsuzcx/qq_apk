import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget;

public class pgx
  extends RecyclerView.OnScrollListener
{
  public pgx(QCircleRecommendWidget paramQCircleRecommendWidget) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      pcl.a(30, 2, QCircleRecommendWidget.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgx
 * JD-Core Version:    0.7.0.1
 */