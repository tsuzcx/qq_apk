import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.QQComicStep;
import cooperation.comic.VipComicNavConfigHelper;
import cooperation.comic.VipComicSoHelper;

class zri
  implements Runnable
{
  zri(zrh paramzrh) {}
  
  public void run()
  {
    VipComicNavConfigHelper.a(QQComicStep.b(this.a.a).b);
    VipComicSoHelper.a(QQComicStep.c(this.a.a).b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zri
 * JD-Core Version:    0.7.0.1
 */