import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class vbw
  extends RecyclerView.OnScrollListener
{
  vbw(vbr paramvbr) {}
  
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
 * Qualified Name:     vbw
 * JD-Core Version:    0.7.0.1
 */