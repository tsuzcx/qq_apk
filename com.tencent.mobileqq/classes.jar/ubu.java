import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class ubu
  extends JobSegment<uav, String>
{
  private ubu(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  protected void a(JobContext paramJobContext, uav paramuav)
  {
    veg.b(this.a.jdField_a_of_type_JavaLangString, "CheckDataSegment runSegment");
    if (this.a.jdField_a_of_type_Uav.a())
    {
      veg.b(this.a.jdField_a_of_type_JavaLangString, "isLoadingData, show loading view");
      VideoViewVideoHolder.a(this.a, 2);
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
      this.a.jdField_a_of_type_Udc.a(8);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.a.b.setVisibility(8);
      notifyError(new ErrorMessage(0, "isLoadingData"));
      return;
    }
    if (this.a.jdField_a_of_type_Uav.b())
    {
      veg.b(this.a.jdField_a_of_type_JavaLangString, "showPage, show error view, because this is a error data = %s", this.a.jdField_a_of_type_Uav.a());
      VideoViewVideoHolder.b(this.a, this.a.jdField_a_of_type_Uav.a().errorCode);
      VideoViewVideoHolder.a(this.a, false);
      veg.d(this.a.jdField_a_of_type_JavaLangString, "isErrorData, hide loading view. subErrorCode=%d", new Object[] { Integer.valueOf(VideoViewVideoHolder.a(this.a)) });
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
    if (StoryVideoItem.isFakeVid(this.a.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString))
    {
      paramJobContext = ((tcz)tdc.a(5)).b(this.a.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString);
      if (paramJobContext != null)
      {
        VideoViewVideoHolder.a(this.a, paramJobContext);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramuav = (String)this.a.jdField_a_of_type_AndroidWidgetImageView.getTag();
        if (!TextUtils.equals(this.a.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString, paramuav))
        {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setTag(this.a.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString);
          tsu.a(this.a.jdField_a_of_type_AndroidWidgetImageView, paramJobContext.mVideoLocalThumbnailPath, paramJobContext.getThumbUrl(), VideoViewVideoHolder.a(this.a), this.a.jdField_a_of_type_Ttg);
        }
        veg.d(this.a.jdField_a_of_type_JavaLangString, "showPage, show error view, because this is fake vid = %s", new Object[] { this.a.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString });
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
    notifyResult(this.a.jdField_a_of_type_Uav.jdField_a_of_type_JavaLangString);
  }
  
  public void onCancel()
  {
    super.onCancel();
    veg.b(this.a.jdField_a_of_type_JavaLangString, "CheckDataSegment onCancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ubu
 * JD-Core Version:    0.7.0.1
 */