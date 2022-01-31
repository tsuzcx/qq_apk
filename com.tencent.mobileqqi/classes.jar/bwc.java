import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.AnimationLister;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.qphone.base.util.QLog;

public class bwc
  implements AnimationLister
{
  public bwc(AbstractImageListScene paramAbstractImageListScene) {}
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "image list onEnterAnimationEnd");
    }
    if (this.a.a.a() != this.a) {
      this.a.k();
    }
    this.a.b();
  }
  
  public void c()
  {
    this.a.c();
  }
  
  public void d()
  {
    this.a.d();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "image list onExitAnimationEnd");
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bwc
 * JD-Core Version:    0.7.0.1
 */