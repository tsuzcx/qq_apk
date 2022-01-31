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

public class unz
  extends SimpleJob<Void>
{
  public unz(QQStoryMainController paramQQStoryMainController, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    vyf.a(this.a.jdField_a_of_type_AndroidAppActivity);
    ((sut)tcz.a(6)).c();
    ueb.a(this.a.jdField_a_of_type_AndroidAppActivity).a(this.a.jdField_a_of_type_AndroidAppActivity);
    PngQuantUtils.a(QQStoryContext.a());
    ((stf)tcz.a(4)).c();
    ayvp.g();
    ((tcs)tcz.a(10)).c();
    ved.d("QQStoryMainController", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(svl.a()) });
    tsd.a().a(this.a.jdField_a_of_type_AndroidAppActivity, 3);
    ved.b("QQStoryMainController", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ved.b("QQStoryMainController", "queueIdle loadShortVideoSo end");
    ved.b("QQStoryMainController", "queueIdle startDownloadFilterSo start");
    this.a.b = axle.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    ved.b("QQStoryMainController", "queueIdle startDownloadFilterSo end");
    ved.b("QQStoryMainController", "queueIdle preloadFrameDrawable start");
    QQStoryLoadingView.a(this.a.jdField_a_of_type_AndroidAppActivity);
    ved.b("QQStoryMainController", "queueIdle preloadFrameDrawable end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     unz
 * JD-Core Version:    0.7.0.1
 */