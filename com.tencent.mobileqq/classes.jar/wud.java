import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class wud
  implements Animation.AnimationListener
{
  wud(wtw paramwtw, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    wtw.a(this.jdField_a_of_type_Wtw, false);
    wtw.b(this.jdField_a_of_type_Wtw).setVisibility(8);
    wtw.a(this.jdField_a_of_type_Wtw).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!wtw.a(this.jdField_a_of_type_Wtw).get())) {
      wtw.a(this.jdField_a_of_type_Wtw, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    wtw.a(this.jdField_a_of_type_Wtw, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wud
 * JD-Core Version:    0.7.0.1
 */