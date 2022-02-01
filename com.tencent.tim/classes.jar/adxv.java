import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class adxv
  extends AnimatorListenerAdapter
{
  adxv(adxq paramadxq, adxq.b paramb) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "animHolder.animView.startPassiveAnimator!");
    }
    if ((this.a != null) && (this.a.u != null))
    {
      paramAnimator = "";
      if (this.a.u.istroop != 0) {
        break label84;
      }
      paramAnimator = "1";
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Bubble", "Passive_dync", paramAnimator, 1, 0, 0, "", String.valueOf(acle.Q(this.a.u.vipBubbleID)), "");
      return;
      label84:
      if (this.a.u.istroop == 1) {
        paramAnimator = "2";
      } else if (this.a.u.istroop == 3000) {
        paramAnimator = "3";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxv
 * JD-Core Version:    0.7.0.1
 */