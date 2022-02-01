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

public class yeg
  extends SimpleJob<Void>
{
  public yeg(QQStoryMainController paramQQStoryMainController, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    zom.a(this.a.jdField_a_of_type_AndroidAppActivity);
    ((wlb)wth.a(6)).c();
    xui.a(this.a.jdField_a_of_type_AndroidAppActivity).a(this.a.jdField_a_of_type_AndroidAppActivity);
    PngQuantUtils.a(QQStoryContext.a());
    ((wjn)wth.a(4)).c();
    bext.g();
    ((wta)wth.a(10)).c();
    yuk.d("QQStoryMainController", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(wlt.a()) });
    xil.a().a(this.a.jdField_a_of_type_AndroidAppActivity, 3);
    yuk.b("QQStoryMainController", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    yuk.b("QQStoryMainController", "queueIdle loadShortVideoSo end");
    yuk.b("QQStoryMainController", "queueIdle startDownloadFilterSo start");
    this.a.b = bdek.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    yuk.b("QQStoryMainController", "queueIdle startDownloadFilterSo end");
    yuk.b("QQStoryMainController", "queueIdle preloadFrameDrawable start");
    QQStoryLoadingView.a(this.a.jdField_a_of_type_AndroidAppActivity);
    yuk.b("QQStoryMainController", "queueIdle preloadFrameDrawable end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yeg
 * JD-Core Version:    0.7.0.1
 */