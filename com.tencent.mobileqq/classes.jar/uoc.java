import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class uoc
  extends SimpleJob<Void>
{
  public uoc(QQStoryMainController paramQQStoryMainController, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    vyi.a(this.a.jdField_a_of_type_AndroidAppActivity);
    ((suw)tdc.a(6)).c();
    uee.a(this.a.jdField_a_of_type_AndroidAppActivity).a(this.a.jdField_a_of_type_AndroidAppActivity);
    PngQuantUtils.a(QQStoryContext.a());
    ((sti)tdc.a(4)).c();
    ayvn.g();
    ((tcv)tdc.a(10)).c();
    veg.d("QQStoryMainController", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(svo.a()) });
    tsg.a().a(this.a.jdField_a_of_type_AndroidAppActivity, 3);
    veg.b("QQStoryMainController", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    veg.b("QQStoryMainController", "queueIdle loadShortVideoSo end");
    veg.b("QQStoryMainController", "queueIdle startDownloadFilterSo start");
    this.a.b = axlc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    veg.b("QQStoryMainController", "queueIdle startDownloadFilterSo end");
    veg.b("QQStoryMainController", "queueIdle preloadFrameDrawable start");
    QQStoryLoadingView.a(this.a.jdField_a_of_type_AndroidAppActivity);
    veg.b("QQStoryMainController", "queueIdle preloadFrameDrawable end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uoc
 * JD-Core Version:    0.7.0.1
 */