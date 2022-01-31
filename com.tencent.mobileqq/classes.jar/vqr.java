import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.io.File;

public class vqr
  extends JobSegment<StoryVideoItem, StoryVideoItem>
{
  StoryVideoItem a;
  
  private vqr(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    if (VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 8))
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 8);
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Vrr);
      super.notifyResult(paramStoryVideoItem);
      return;
    }
    wsv.e(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "STATE_PREPARE_ED ignore");
  }
  
  protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 7);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    paramJobContext = null;
    File localFile = ujb.a(paramStoryVideoItem.mVid, 0, false, false);
    if ((localFile != null) && (ujb.a(localFile))) {
      paramJobContext = localFile.getAbsolutePath();
    }
    for (;;)
    {
      if (paramJobContext == null)
      {
        wsv.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "finalFileName null, hide loading view");
        VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 8);
        VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, false);
        wsv.e(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "setVideoPath, fileName is empty !!");
        VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, alpo.a(2131716818));
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), "fileName null"));
        return;
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.b())
        {
          if ((!TextUtils.isEmpty(paramStoryVideoItem.mVideoUrl)) || (!TextUtils.isEmpty(paramStoryVideoItem.mTempVideoUrl)))
          {
            localFile = ujb.a(paramStoryVideoItem.mVid, 0, true, true);
            if (localFile != null) {
              paramJobContext = localFile.getAbsolutePath();
            }
            for (;;)
            {
              break;
              wsv.e(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "showVideo, vid=%s, support stream, getLocalFile return null", new Object[] { paramStoryVideoItem.mVid });
            }
          }
        }
        else {
          notifyError(new ErrorMessage(-1, "not tvk videoView, and videoFile has not downloaded."));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Vrr.a(0);
        wsv.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "set video view listeners ... and then setVideoPath");
        VideoViewVideoHolder.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Vrr.a(new vqs(this));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Vrr.a(new vqt(this, paramJobContext, paramStoryVideoItem));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Vrr.a(new vqu(this, paramStoryVideoItem));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Vrr.a(new vqv(this, paramStoryVideoItem));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Vrr.a(new vqw(this, paramStoryVideoItem));
        ((uid)urr.a(28)).a(paramStoryVideoItem.mVid, 0, new vqx(this, paramStoryVideoItem, paramJobContext));
        return;
      }
      paramJobContext = null;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    wsv.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "VideoPrepareSegment onCancel");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Vrr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqr
 * JD-Core Version:    0.7.0.1
 */