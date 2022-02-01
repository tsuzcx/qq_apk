import android.os.Handler;
import com.tencent.biz.qcircleshadow.local.widgets.QCirclePluginLoadingDialog.1.1;
import com.tencent.biz.qcircleshadow.local.widgets.QCirclePluginLoadingDialog.1.2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

public class vwf
  implements znw
{
  vwf(vwe paramvwe) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      vwe.a(this.a, paramQQAnimationDrawable);
      QzoneHandlerThreadFactory.getMainHandler().post(new QCirclePluginLoadingDialog.1.1(this));
      return;
    }
    QzoneHandlerThreadFactory.getMainHandler().post(new QCirclePluginLoadingDialog.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwf
 * JD-Core Version:    0.7.0.1
 */