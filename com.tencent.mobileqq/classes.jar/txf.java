import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class txf
  extends RecyclerView.OnScrollListener
{
  txf(txe paramtxe) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      abqw.a().a("qcircle_content_page", false);
      return;
    }
    abqw.a().a("qcircle_content_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txf
 * JD-Core Version:    0.7.0.1
 */