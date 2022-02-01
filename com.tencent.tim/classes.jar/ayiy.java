import android.os.Bundle;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.a;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import java.util.ArrayList;

public class ayiy
  implements FrameVideoHelper.a
{
  public ayiy(LocalVideoSelectActivity paramLocalVideoSelectActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if (!this.this$0.isFinishing())
    {
      this.this$0.bpm();
      Bundle localBundle = new Bundle();
      if (paramArrayList != null)
      {
        localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", paramArrayList);
        localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", paramLong);
      }
      aytv.a(this.this$0, LocalVideoSelectActivity.a(this.this$0), LocalVideoSelectActivity.a(this.this$0), this.agx, this.agy, this.bnL, this.eKl, 0, "", "", false, LocalVideoSelectActivity.c(this.this$0), this.eKm, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayiy
 * JD-Core Version:    0.7.0.1
 */