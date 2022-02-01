import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.qphone.base.util.QLog;

public class alia
  extends alhu.c
{
  public alia(LSRecordPanel paramLSRecordPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startCloseAnimation onAnimationEnd");
    }
    if (LSRecordPanel.a(this.this$0))
    {
      if (paramAnimation == this.this$0.aP) {
        LSRecordPanel.a(this.this$0);
      }
      this.this$0.b = null;
      this.this$0.aP = null;
      paramAnimation = (RelativeLayout.LayoutParams)LSRecordPanel.a(this.this$0).getLayoutParams();
      int i = (int)(this.this$0.getResources().getDisplayMetrics().density * 4.0F);
      paramAnimation.height -= i;
      paramAnimation.width -= i;
      int j = paramAnimation.rightMargin;
      paramAnimation.rightMargin = (i / 2 + j);
      LSRecordPanel.a(this.this$0, false);
      LSRecordPanel.a(this.this$0).setLayoutParams(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alia
 * JD-Core Version:    0.7.0.1
 */