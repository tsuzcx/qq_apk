import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;

public abstract interface mry
{
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public abstract void a(DragFrameLayout paramDragFrameLayout);
  
  public abstract void g(VideoInfo paramVideoInfo);
  
  public static abstract interface a
  {
    public abstract void a(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mry
 * JD-Core Version:    0.7.0.1
 */