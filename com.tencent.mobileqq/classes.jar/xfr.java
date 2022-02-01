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

public class xfr
  extends SimpleJob<Void>
{
  public xfr(QQStoryMainController paramQQStoryMainController, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    ypi.a(this.a.jdField_a_of_type_AndroidAppActivity);
    ((vna)vux.a(6)).c();
    wvt.a(this.a.jdField_a_of_type_AndroidAppActivity).a(this.a.jdField_a_of_type_AndroidAppActivity);
    PngQuantUtils.a(QQStoryContext.a());
    ((vlm)vux.a(4)).c();
    StoryUploadProcessor.checkUploadSessionKey();
    ((vuq)vux.a(10)).c();
    xvv.d("QQStoryMainController", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(vns.a()) });
    wkb.a().a(this.a.jdField_a_of_type_AndroidAppActivity, 3);
    xvv.b("QQStoryMainController", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.loadShortVideoSo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    xvv.b("QQStoryMainController", "queueIdle loadShortVideoSo end");
    xvv.b("QQStoryMainController", "queueIdle startDownloadFilterSo start");
    this.a.b = bbxj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    xvv.b("QQStoryMainController", "queueIdle startDownloadFilterSo end");
    xvv.b("QQStoryMainController", "queueIdle preloadFrameDrawable start");
    QQStoryLoadingView.a(this.a.jdField_a_of_type_AndroidAppActivity);
    xvv.b("QQStoryMainController", "queueIdle preloadFrameDrawable end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfr
 * JD-Core Version:    0.7.0.1
 */