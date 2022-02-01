import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class xum
  extends SimpleJob<Void>
{
  public xum(QQStoryMainController paramQQStoryMainController, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    zeb.a(this.a.jdField_a_of_type_AndroidAppActivity);
    ((wbv)wjs.a(6)).c();
    xko.a(this.a.jdField_a_of_type_AndroidAppActivity).a(this.a.jdField_a_of_type_AndroidAppActivity);
    PngQuantUtils.a(QQStoryContext.a());
    ((wah)wjs.a(4)).c();
    StoryUploadProcessor.checkUploadSessionKey();
    ((wjl)wjs.a(10)).c();
    ykq.d("QQStoryMainController", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(wcn.a()) });
    wyw.a().a(this.a.jdField_a_of_type_AndroidAppActivity, 3);
    ykq.b("QQStoryMainController", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.loadShortVideoSo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ykq.b("QQStoryMainController", "queueIdle loadShortVideoSo end");
    ykq.b("QQStoryMainController", "queueIdle startDownloadFilterSo start");
    this.a.b = bdee.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    ykq.b("QQStoryMainController", "queueIdle startDownloadFilterSo end");
    ykq.b("QQStoryMainController", "queueIdle preloadFrameDrawable start");
    QQStoryLoadingView.a(this.a.jdField_a_of_type_AndroidAppActivity);
    ykq.b("QQStoryMainController", "queueIdle preloadFrameDrawable end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xum
 * JD-Core Version:    0.7.0.1
 */