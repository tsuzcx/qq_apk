import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.videostory.capture.widgets.AEPlayShowPageView;
import com.tencent.image.ApngImage;

public class wvw
  extends RecyclerView.OnScrollListener
{
  public wvw(AEPlayShowPageView paramAEPlayShowPageView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      ApngImage.resumeAll();
    }
    for (;;)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      return;
      ApngImage.pauseAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wvw
 * JD-Core Version:    0.7.0.1
 */