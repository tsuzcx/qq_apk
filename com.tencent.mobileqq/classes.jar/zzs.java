import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;

public class zzs
  extends RecyclerView.OnScrollListener
{
  public zzs(SmartMusicRecyclerView paramSmartMusicRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    SmartMusicRecyclerView.a(this.a, paramRecyclerView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzs
 * JD-Core Version:    0.7.0.1
 */