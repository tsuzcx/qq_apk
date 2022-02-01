import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;

public class xuo
  extends RecyclerView.OnScrollListener
{
  public xuo(PhotoListPanel paramPhotoListPanel) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.this$0.mScrollState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xuo
 * JD-Core Version:    0.7.0.1
 */