import android.os.SystemClock;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.i;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.j;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

public class qko
  implements qlb.d
{
  public qko(VideoViewVideoHolder.i parami) {}
  
  public boolean a(qlb paramqlb, int paramInt, Object paramObject)
  {
    if (this.a.isCanceled()) {
      return false;
    }
    ram.a(this.a.this$0.TAG, "onInfo, [videoView=%d, what=%d, extra=%s]", Integer.valueOf(System.identityHashCode(paramqlb)), Integer.valueOf(paramInt), paramObject);
    switch (paramInt)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.a.this$0).a(this.a.this$0, paramqlb, paramInt, paramObject);
      return false;
      ram.w(this.a.this$0.TAG, "PLAYER_INFO_HW_DECODE_FAILED. extra=%s", new Object[] { paramObject });
      continue;
      VideoViewVideoHolder.d(this.a.this$0, ((Integer)paramObject).intValue());
      continue;
      VideoViewVideoHolder.a(this.a.this$0, 0L, "rendering-Start");
      continue;
      ram.w(this.a.this$0.TAG, "start buffering, show loading view");
      VideoViewVideoHolder.e(this.a.this$0, VideoViewVideoHolder.c(this.a.this$0) + 1);
      VideoViewVideoHolder.a(this.a.this$0, SystemClock.uptimeMillis());
      VideoViewVideoHolder.a(this.a.this$0, 8);
      this.a.this$0.a.setVisibility(0);
      continue;
      VideoViewVideoHolder.f(this.a.this$0, (int)(VideoViewVideoHolder.d(this.a.this$0) + (SystemClock.uptimeMillis() - VideoViewVideoHolder.a(this.a.this$0))));
      ram.w(this.a.this$0.TAG, "end buffering, hide loading view");
      this.a.this$0.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qko
 * JD-Core Version:    0.7.0.1
 */