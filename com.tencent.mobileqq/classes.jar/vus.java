import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class vus
  extends JobSegment<vtt, String>
{
  private vus(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  protected void a(JobContext paramJobContext, vtt paramvtt)
  {
    wxe.b(this.a.jdField_a_of_type_JavaLangString, "CheckDataSegment runSegment");
    if (this.a.jdField_a_of_type_Vtt.a())
    {
      wxe.b(this.a.jdField_a_of_type_JavaLangString, "isLoadingData, show loading view");
      VideoViewVideoHolder.a(this.a, 2);
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
      this.a.jdField_a_of_type_Vwa.a(8);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.a.b.setVisibility(8);
      notifyError(new ErrorMessage(0, "isLoadingData"));
      return;
    }
    if (this.a.jdField_a_of_type_Vtt.b())
    {
      wxe.b(this.a.jdField_a_of_type_JavaLangString, "showPage, show error view, because this is a error data = %s", this.a.jdField_a_of_type_Vtt.a());
      VideoViewVideoHolder.b(this.a, this.a.jdField_a_of_type_Vtt.a().errorCode);
      VideoViewVideoHolder.a(this.a, false);
      wxe.d(this.a.jdField_a_of_type_JavaLangString, "isErrorData, hide loading view. subErrorCode=%d", new Object[] { Integer.valueOf(VideoViewVideoHolder.a(this.a)) });
      if (VideoViewVideoHolder.a(this.a) == 97000000)
      {
        VideoViewVideoHolder.c(this.a, 4);
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.a), "PLAY_DATA_NO_VID"));
        return;
      }
      VideoViewVideoHolder.c(this.a, 9);
      notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.a), "isErrorData"));
      return;
    }
    if (StoryVideoItem.isFakeVid(this.a.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString))
    {
      paramJobContext = ((uvx)uwa.a(5)).b(this.a.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString);
      if (paramJobContext != null)
      {
        VideoViewVideoHolder.a(this.a, paramJobContext);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramvtt = (String)this.a.jdField_a_of_type_AndroidWidgetImageView.getTag();
        if (!TextUtils.equals(this.a.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString, paramvtt))
        {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setTag(this.a.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString);
          vls.a(this.a.jdField_a_of_type_AndroidWidgetImageView, paramJobContext.mVideoLocalThumbnailPath, paramJobContext.getThumbUrl(), VideoViewVideoHolder.a(this.a), this.a.jdField_a_of_type_Vme);
        }
        wxe.d(this.a.jdField_a_of_type_JavaLangString, "showPage, show error view, because this is fake vid = %s", new Object[] { this.a.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString });
        VideoViewVideoHolder.c(this.a, 5);
        VideoViewVideoHolder.a(this.a, false);
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.a), "isFakeData"));
        return;
      }
      VideoViewVideoHolder.c(this.a, 11);
      VideoViewVideoHolder.a(this.a, false);
      notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.a), "Fake Vid No Data"));
      return;
    }
    notifyResult(this.a.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString);
  }
  
  public void onCancel()
  {
    super.onCancel();
    wxe.b(this.a.jdField_a_of_type_JavaLangString, "CheckDataSegment onCancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vus
 * JD-Core Version:    0.7.0.1
 */