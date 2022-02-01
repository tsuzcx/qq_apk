import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;

public class ssd
  extends RecyclerView.OnScrollListener
{
  public ssd(SmartMusicRecyclerView paramSmartMusicRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    SmartMusicRecyclerView.a(this.c, paramRecyclerView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssd
 * JD-Core Version:    0.7.0.1
 */