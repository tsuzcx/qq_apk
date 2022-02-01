import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.i;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.j;

public class qkr
  implements qlb.a
{
  public qkr(VideoViewVideoHolder.i parami, StoryVideoItem paramStoryVideoItem) {}
  
  public void e(qlb paramqlb)
  {
    if (this.a.isCanceled()) {}
    do
    {
      return;
      ram.b(this.a.this$0.TAG, "onCompletion, [videoView], current state = %s", VideoViewVideoHolder.bU[this.a.this$0.bmD]);
    } while (!VideoViewVideoHolder.b(this.a.this$0, 12));
    VideoViewVideoHolder.a(this.a.this$0, 12);
    this.a.this$0.bmH = 1;
    VideoViewVideoHolder.a(this.a.this$0).b(this.a.this$0, paramqlb, VideoViewVideoHolder.b(this.a.this$0));
    rar.c("video_ope", "play_finish", 0, 0, new String[] { this.val$storyVideoItem.mOwnerUid, "", "", this.val$storyVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qkr
 * JD-Core Version:    0.7.0.1
 */