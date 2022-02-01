import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class pbe
  extends RecyclerView.OnScrollListener
{
  pbe(pbc parampbc) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene("qcircle_content_page", false);
      return;
    }
    txn.a().startMonitorScene("qcircle_content_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbe
 * JD-Core Version:    0.7.0.1
 */