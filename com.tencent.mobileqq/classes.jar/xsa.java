import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class xsa
  extends JobSegment<StoryVideoItem, StoryVideoItem>
  implements wlh
{
  private StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  private xsc jdField_a_of_type_Xsc;
  
  public xsa(VideoViewVideoHolder paramVideoViewVideoHolder, xsc paramxsc)
  {
    this.jdField_a_of_type_Xsc = paramxsc;
  }
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 4);
    super.notifyResult(paramStoryVideoItem);
  }
  
  protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 3);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    int i = paramStoryVideoItem.isMaskDownloaded();
    if (i == 0)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 4);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Xtg.a(8);
      yuk.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "wait doodle download and display ... %s", paramStoryVideoItem.getDownloadMaskUrl());
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, anzj.a(2131715220));
      this.jdField_a_of_type_Xsc.a().a(paramStoryVideoItem.mVid, 1, true, this);
      return;
    }
    if (i == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.b.setVisibility(0);
      xiz.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.b, paramStoryVideoItem.mLocalMaskPath, paramStoryVideoItem.getDownloadMaskUrl(), VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder));
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, anzj.a(2131715215));
    }
    for (;;)
    {
      a(paramStoryVideoItem);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.b.setVisibility(8);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!isCanceled())
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, "DD", SystemClock.uptimeMillis());
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.b.setVisibility(0);
      xiz.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getDownloadMaskUrl(), VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder));
      a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      return;
    }
    yuk.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "wait doodle download and display onSuccess. stream canceled.");
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    if (!isCanceled())
    {
      yuk.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "wait doodle download and display error. vid :%s, error=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramErrorMessage });
      VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 2);
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, false);
      VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, paramErrorMessage.errorCode);
      notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), "doodle download failed"));
      return;
    }
    yuk.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "wait doodle download and display error. stream canceled.");
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!isCanceled())
    {
      yuk.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "wait doodle download and display cancel. vid :%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 2);
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, false);
      VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 1234);
      notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), "doodle download cancel"));
      return;
    }
    yuk.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "wait doodle download and display cancel. stream canceled.");
  }
  
  public void onCancel()
  {
    super.onCancel();
    yuk.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "DoodleSegment onCancel");
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) {
      this.jdField_a_of_type_Xsc.a().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsa
 * JD-Core Version:    0.7.0.1
 */