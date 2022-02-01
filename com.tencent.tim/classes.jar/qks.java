import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.i;

public class qks
  implements qlb.c
{
  public qks(VideoViewVideoHolder.i parami, StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(qlb paramqlb, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.a.isCanceled()) {
      return true;
    }
    ram.e(this.a.this$0.TAG, "onError, setOnErrorListener [videoView, model=%d, what=%d, position=%d, extra=%s, Info=%s] = ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramObject });
    if (paramInt2 == 102)
    {
      paramqlb.restart();
      return true;
    }
    VideoViewVideoHolder.c(this.a.this$0, 7);
    VideoViewVideoHolder.a(this.a.this$0, false);
    VideoViewVideoHolder.b(this.a.this$0, paramInt2);
    VideoViewVideoHolder.i.b(this.a, new ErrorMessage(VideoViewVideoHolder.b(this.a.this$0), "wht=" + paramInt2 + ", mod=" + paramInt1 + ", " + this.val$storyVideoItem.mVid));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qks
 * JD-Core Version:    0.7.0.1
 */