import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.i;

public class qkq
  implements qlb.e
{
  public qkq(VideoViewVideoHolder.i parami, StoryVideoItem paramStoryVideoItem) {}
  
  public void d(qlb paramqlb)
  {
    if (this.a.isCanceled()) {
      return;
    }
    ram.b(this.a.this$0.TAG, "onPrepared, [videoView=%d]", Integer.valueOf(System.identityHashCode(paramqlb)));
    VideoViewVideoHolder.a(this.a.this$0, "VP", SystemClock.uptimeMillis());
    this.a.g(this.val$storyVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qkq
 * JD-Core Version:    0.7.0.1
 */