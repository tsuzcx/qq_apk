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

public class qqu
  extends SimpleJob<Void>
{
  public qqu(QQStoryMainController paramQQStoryMainController, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    rox.aD(this.this$0.mContext);
    ((pnm)psx.a(6)).blW();
    qln.a(this.this$0.mContext).cC(this.this$0.mContext);
    PngQuantUtils.f(QQStoryContext.c());
    ((pmm)psx.a(4)).blU();
    aoob.dWj();
    ((psr)psx.a(10)).bmE();
    ram.w("QQStoryMainController", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(pnx.so()) });
    qea.a().T(this.this$0.mContext, 3);
    ram.d("QQStoryMainController", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.B(this.this$0.mApp);
    ram.d("QQStoryMainController", "queueIdle loadShortVideoSo end");
    ram.d("QQStoryMainController", "queueIdle startDownloadFilterSo start");
    this.this$0.aEP = ankq.f(this.this$0.mApp, BaseApplicationImpl.getContext());
    ram.d("QQStoryMainController", "queueIdle startDownloadFilterSo end");
    ram.d("QQStoryMainController", "queueIdle preloadFrameDrawable start");
    QQStoryLoadingView.cI(this.this$0.mContext);
    ram.d("QQStoryMainController", "queueIdle preloadFrameDrawable end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqu
 * JD-Core Version:    0.7.0.1
 */