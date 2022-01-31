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

public class ubg
  extends SimpleJob<Void>
{
  public ubg(QQStoryMainController paramQQStoryMainController, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    vlm.a(this.a.jdField_a_of_type_AndroidAppActivity);
    ((sia)sqg.a(6)).c();
    tri.a(this.a.jdField_a_of_type_AndroidAppActivity).a(this.a.jdField_a_of_type_AndroidAppActivity);
    PngQuantUtils.a(QQStoryContext.a());
    ((sgm)sqg.a(4)).c();
    axvg.g();
    ((spz)sqg.a(10)).c();
    urk.d("QQStoryMainController", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(sis.a()) });
    tfk.a().a(this.a.jdField_a_of_type_AndroidAppActivity, 3);
    urk.b("QQStoryMainController", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    urk.b("QQStoryMainController", "queueIdle loadShortVideoSo end");
    urk.b("QQStoryMainController", "queueIdle startDownloadFilterSo start");
    this.a.b = awlw.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    urk.b("QQStoryMainController", "queueIdle startDownloadFilterSo end");
    urk.b("QQStoryMainController", "queueIdle preloadFrameDrawable start");
    QQStoryLoadingView.a(this.a.jdField_a_of_type_AndroidAppActivity);
    urk.b("QQStoryMainController", "queueIdle preloadFrameDrawable end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ubg
 * JD-Core Version:    0.7.0.1
 */