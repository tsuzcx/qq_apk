import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.b;

public class qkj
  extends VideoViewVideoHolder.b<StoryVideoItem>
{
  public qkj(VideoViewVideoHolder paramVideoViewVideoHolder)
  {
    super(paramVideoViewVideoHolder, null);
  }
  
  public void f(StoryVideoItem paramStoryVideoItem)
  {
    super.onNext(paramStoryVideoItem);
    VideoViewVideoHolder.a(this.this$0);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.w(this.this$0.TAG, "VideoFileSegment error=%s", new Object[] { ((ErrorMessage)paramError).getErrorMessage() });
    VideoViewVideoHolder.a(this.this$0, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qkj
 * JD-Core Version:    0.7.0.1
 */