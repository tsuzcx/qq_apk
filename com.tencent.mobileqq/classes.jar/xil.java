import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment.1;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class xil
  extends JobSegment<String, StoryVideoItem>
  implements wzf
{
  public String a;
  
  private xil(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  private void a(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if ((paramStoryVideoItem != null) && (paramStoryVideoItem.mErrorCode != 0))
    {
      ykq.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "showPage, show error view, because video item error code = %d", new Object[] { Integer.valueOf(paramStoryVideoItem.mErrorCode) });
      VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 4);
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, false);
      VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, paramStoryVideoItem.mErrorCode);
      notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), "videoDeleted"));
      return;
    }
    if ((paramStoryVideoItem == null) || (!paramStoryVideoItem.isBasicInfoOK()))
    {
      if (paramBoolean)
      {
        VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 3);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Xjm.a(8);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.b.setVisibility(8);
        VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, anvx.a(2131715809));
        paramStoryVideoItem = new ArrayList();
        paramStoryVideoItem.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString);
        localObject = VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder);
        if (localObject != null) {
          ((wzb)localObject).a();
        }
        VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, new wzb(paramStoryVideoItem));
        VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder).a(this);
        VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder).b();
        return;
      }
      a();
      return;
    }
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, paramStoryVideoItem);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    Object localObject = (String)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_AndroidWidgetImageView.getTag();
    if (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString);
      wzk.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_AndroidWidgetImageView, paramStoryVideoItem.mVideoLocalThumbnailPath, paramStoryVideoItem.getThumbUrl(), VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Wzw);
    }
    a(paramStoryVideoItem);
  }
  
  public void a()
  {
    if (isCanceled()) {
      return;
    }
    wzb localwzb = VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder);
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, null);
    if (localwzb != null) {
      localwzb.a();
    }
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoInfoSegment.2(this));
  }
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 2);
    super.notifyResult(paramStoryVideoItem);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 1);
    this.jdField_a_of_type_JavaLangString = paramString;
    a(((wjp)wjs.a(5)).b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_Xhf.jdField_a_of_type_JavaLangString), true);
  }
  
  public void a(ArrayList<StoryVideoItem> paramArrayList)
  {
    if (isCanceled()) {
      return;
    }
    paramArrayList = VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder);
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, null);
    if (paramArrayList != null) {
      paramArrayList.a();
    }
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoInfoSegment.1(this));
  }
  
  public void onCancel()
  {
    super.onCancel();
    ykq.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "VideoInfoSegment onCancel");
    wzb localwzb = VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder);
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, null);
    if (localwzb != null) {
      localwzb.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xil
 * JD-Core Version:    0.7.0.1
 */