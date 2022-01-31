import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget;

public class ufi
  extends RecyclerView.OnScrollListener
{
  public ufi(QCircleRecommendWidget paramQCircleRecommendWidget) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      tzs.a(30, 2, QCircleRecommendWidget.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufi
 * JD-Core Version:    0.7.0.1
 */