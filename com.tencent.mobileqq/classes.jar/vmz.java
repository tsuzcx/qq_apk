import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class vmz
  extends RecyclerView.OnScrollListener
{
  vmz(vmw paramvmw) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      adlb.a().a("qcircle_content_page", false);
      return;
    }
    adlb.a().a("qcircle_content_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmz
 * JD-Core Version:    0.7.0.1
 */