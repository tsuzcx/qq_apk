import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

public class vqc
  extends vqk<StoryVideoItem>
{
  public vqc(VideoViewVideoHolder paramVideoViewVideoHolder)
  {
    super(paramVideoViewVideoHolder, null);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    super.onNext(paramStoryVideoItem);
    VideoViewVideoHolder.a(this.a);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wsv.d(this.a.a, "STATE_VIDEOFILE_ED error=%s", new Object[] { ((ErrorMessage)paramError).getErrorMessage() });
    VideoViewVideoHolder.a(this.a, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqc
 * JD-Core Version:    0.7.0.1
 */