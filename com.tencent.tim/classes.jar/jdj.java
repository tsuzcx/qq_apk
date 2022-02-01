import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class jdj
  implements Animator.AnimatorListener
{
  jdj(jdh paramjdh) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationCancel");
    }
    this.this$0.setShowState(3, false);
    if (jdh.a(this.this$0) != null) {
      jdh.a(this.this$0).requestLayout();
    }
    jdh.a(this.this$0, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationEnd");
    }
    this.this$0.setShowState(3);
    if (jdh.a(this.this$0) != null) {
      jdh.a(this.this$0).requestLayout();
    }
    jdh.a(this.this$0, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationStart");
    }
    jdh.a(this.this$0).setVisibility(0);
    jdh.a(this.this$0).setAlpha(0.0F);
    jdh.a(this.this$0).setVisibility(0);
    jdh.a(this.this$0).setAlpha(0.0F);
    jdh.a(this.this$0).height = -2;
    jdh.a(this.this$0).width = -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdj
 * JD-Core Version:    0.7.0.1
 */