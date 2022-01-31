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

public class wcr
  extends SimpleJob<Void>
{
  public wcr(QQStoryMainController paramQQStoryMainController, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    xmx.a(this.a.jdField_a_of_type_AndroidAppActivity);
    ((ujl)urr.a(6)).c();
    vst.a(this.a.jdField_a_of_type_AndroidAppActivity).a(this.a.jdField_a_of_type_AndroidAppActivity);
    PngQuantUtils.a(QQStoryContext.a());
    ((uhx)urr.a(4)).c();
    bato.g();
    ((urk)urr.a(10)).c();
    wsv.d("QQStoryMainController", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(ukd.a()) });
    vgv.a().a(this.a.jdField_a_of_type_AndroidAppActivity, 3);
    wsv.b("QQStoryMainController", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    wsv.b("QQStoryMainController", "queueIdle loadShortVideoSo end");
    wsv.b("QQStoryMainController", "queueIdle startDownloadFilterSo start");
    this.a.b = azgk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    wsv.b("QQStoryMainController", "queueIdle startDownloadFilterSo end");
    wsv.b("QQStoryMainController", "queueIdle preloadFrameDrawable start");
    QQStoryLoadingView.a(this.a.jdField_a_of_type_AndroidAppActivity);
    wsv.b("QQStoryMainController", "queueIdle preloadFrameDrawable end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wcr
 * JD-Core Version:    0.7.0.1
 */