import android.database.DataSetObserver;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;

public class mvo
  extends DataSetObserver
{
  public mvo(VideoFeedsListView paramVideoFeedsListView) {}
  
  public void onChanged()
  {
    VideoFeedsListView localVideoFeedsListView = this.this$0;
    if (VideoFeedsListView.a(this.this$0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      VideoFeedsListView.a(localVideoFeedsListView, bool);
      return;
    }
  }
  
  public void onInvalidated()
  {
    VideoFeedsListView localVideoFeedsListView = this.this$0;
    if (VideoFeedsListView.a(this.this$0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      VideoFeedsListView.a(localVideoFeedsListView, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvo
 * JD-Core Version:    0.7.0.1
 */