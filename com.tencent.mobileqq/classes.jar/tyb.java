import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class tyb
  extends RecyclerView.OnScrollListener
{
  tyb(txz paramtxz) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      abvl.a().a("qcircle_content_page", false);
      return;
    }
    abvl.a().a("qcircle_content_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyb
 * JD-Core Version:    0.7.0.1
 */