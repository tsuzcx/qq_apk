import android.os.SystemClock;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class xij
  extends JobSegment<StoryVideoItem, StoryVideoItem>
  implements wcb
{
  private StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  private xii jdField_a_of_type_Xii;
  private boolean jdField_a_of_type_Boolean;
  
  public xij(VideoViewVideoHolder paramVideoViewVideoHolder, xii paramxii, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xii = paramxii;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 6);
    super.notifyResult(paramStoryVideoItem);
  }
  
  protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 5);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    if (this.jdField_a_of_type_Boolean)
    {
      a(paramStoryVideoItem);
      return;
    }
    ykq.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a, "showVideo, start download video fully");
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 5);
    this.jdField_a_of_type_Xii.a().a(paramStoryVideoItem.mVid, 0, true, this);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!isCanceled())
    {
      ykq.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a, "showVideo, start download video fully, onSuccess");
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, "VD", SystemClock.uptimeMillis());
      a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
    ykq.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a, "showVideo, start download video fully, onSuccess. stream canceled");
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    if (!isCanceled())
    {
      ykq.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a, paramErrorMessage, "showVideo, start download video fully, onError", new Object[0]);
      VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 3);
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, false);
      VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, paramErrorMessage.errorCode);
      notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), paramErrorMessage.getErrorMessage()));
      return;
    }
    ykq.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a, paramErrorMessage, "showVideo, start download video fully, onError. stream canceled", new Object[0]);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!isCanceled())
    {
      ykq.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a, "showVideo, start download video fully, onCancel");
      VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 3);
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, false);
      VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 1234);
      notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), "Download video cancel"));
      return;
    }
    ykq.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a, "showVideo, start download video fully, onCancel. stream canceled");
  }
  
  public void onCancel()
  {
    super.onCancel();
    ykq.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a, "VideoFileSegment onCancel");
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) {
      this.jdField_a_of_type_Xii.a().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xij
 * JD-Core Version:    0.7.0.1
 */