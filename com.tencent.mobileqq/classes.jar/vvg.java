import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.widgets.QCircleCommentListView;

public class vvg
  extends RecyclerView.OnScrollListener
{
  public vvg(QCircleCommentListView paramQCircleCommentListView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      adcd.a().a("qcircle_comment_page", false);
      return;
    }
    adcd.a().a("qcircle_comment_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvg
 * JD-Core Version:    0.7.0.1
 */