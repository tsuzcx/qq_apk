import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.b;
import com.tencent.biz.pubaccount.readinjoy.view.FrameLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.FrameLayoutCompat.a;

public class mvv
  implements FrameLayoutCompat.a
{
  public mvv(VideoFeedsPlayActivity.b paramb, String paramString) {}
  
  public void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if ((paramView == VideoFeedsPlayActivity.a(this.b.this$0)) && (paramInt == 0))
    {
      VideoFeedsPlayActivity.a(this.b.this$0).setVisibilityChangedListener(null);
      this.b.o(true, this.Vv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvv
 * JD-Core Version:    0.7.0.1
 */