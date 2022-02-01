import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class vkv
  extends RecyclerView.OnScrollListener
{
  vkv(vks paramvks) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      adcd.a().a("qcircle_content_page", false);
      return;
    }
    adcd.a().a("qcircle_content_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkv
 * JD-Core Version:    0.7.0.1
 */