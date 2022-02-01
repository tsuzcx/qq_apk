import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class adxt
  extends AnimatorListenerAdapter
{
  adxt(adxq paramadxq, ObjectAnimator paramObjectAnimator, adxq.b paramb) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "animHolder.animView.startAnimation!");
    }
    if (this.bG != null) {
      this.bG.start();
    }
    if ((this.a != null) && (this.a.j != null))
    {
      paramAnimator = "";
      if (this.a.j.istroop != 0) {
        break label98;
      }
      paramAnimator = "1";
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Bubble", "Active_dync", paramAnimator, 1, 0, 0, "", String.valueOf(acle.Q(this.a.j.vipBubbleID)), "");
      return;
      label98:
      if (this.a.j.istroop == 1) {
        paramAnimator = "2";
      } else if (this.a.j.istroop == 3000) {
        paramAnimator = "3";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxt
 * JD-Core Version:    0.7.0.1
 */