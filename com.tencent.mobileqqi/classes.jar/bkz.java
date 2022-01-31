import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.QLog;

public class bkz
  implements Animation.AnimationListener
{
  public bkz(VideoControlUI paramVideoControlUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.c.clearAnimation();
    if (!this.a.h)
    {
      this.a.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(true);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      return;
      if (this.a.b != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoControlUI", 2, "onAnimationEnd, change member list ui to visible");
        }
        this.a.b.setVisibility(0);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkz
 * JD-Core Version:    0.7.0.1
 */