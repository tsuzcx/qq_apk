import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.widgets.QCircleCommentListView;

public class vyj
  extends RecyclerView.OnScrollListener
{
  public vyj(QCircleCommentListView paramQCircleCommentListView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      adlb.a().a("qcircle_comment_page", false);
      return;
    }
    adlb.a().a("qcircle_comment_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyj
 * JD-Core Version:    0.7.0.1
 */