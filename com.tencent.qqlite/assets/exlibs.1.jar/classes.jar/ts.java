import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.GalleryPageView;

public class ts
  implements Animation.AnimationListener
{
  public ts(GalleryPageView paramGalleryPageView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.d()) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ts
 * JD-Core Version:    0.7.0.1
 */