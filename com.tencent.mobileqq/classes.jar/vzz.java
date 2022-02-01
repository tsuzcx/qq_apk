import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabView.2.1;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;

public class vzz
  implements zzi
{
  vzz(vzy paramvzy) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if (vzy.a(this.a))
    {
      QLog.e("QCircleFolderTabView", 1, "fetchAnimDrawable Anim action canceled,direct return!");
      return;
    }
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      vzy.a(this.a, paramQQAnimationDrawable);
      bkdz.a().post(new QCircleFolderTabView.2.1(this));
      return;
    }
    this.a.b();
    QLog.e("QCircleFolderTabView", 1, "fetchAnimDrawable fail !use default image");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzz
 * JD-Core Version:    0.7.0.1
 */