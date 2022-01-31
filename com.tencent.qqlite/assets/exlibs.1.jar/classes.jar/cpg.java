import com.tencent.common.galleryactivity.AnimationLister;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;

public class cpg
  implements AnimationLister
{
  public cpg(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "RectAnimation : onEnterAnimationEnd ");
    }
    ShortVideoPlayActivity.d(this.a);
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cpg
 * JD-Core Version:    0.7.0.1
 */