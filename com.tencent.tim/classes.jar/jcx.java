import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.QavPanel.a;
import com.tencent.av.ui.QavPanel.e;

public class jcx
  implements View.OnTouchListener
{
  public jcx(QavPanel paramQavPanel) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.this$0.bv.isEnabled()) || (this.this$0.mApp == null)) {}
    int i;
    do
    {
      return false;
      i = this.this$0.lZ();
      paramView = this.this$0.mApp.b().b();
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return false;
      case 0: 
        if ((i == 0) || (i == 1) || (i == 2))
        {
          if (i == 2)
          {
            if (!QavPanel.a(this.this$0)) {
              break label247;
            }
            paramView.O("MotionEventDown", true);
            paramView.Z("MotionEventDown", 1);
            this.this$0.a("MotionEventDown", 2, 1, true);
          }
          QavPanel.a(this.this$0).setAlpha(127);
          QavPanel.a(this.this$0).setColor(1291845632);
        }
        if (QavPanel.b(this.this$0))
        {
          QavPanel.a(this.this$0, false);
          QavPanel.a(this.this$0).removeMessages(256);
          QavPanel.a(this.this$0).sendEmptyMessageDelayed(256, 200L);
          QavPanel.a(this.this$0).removeMessages(261);
        }
        break;
      }
    } while (QavPanel.a(this.this$0) == null);
    QavPanel.a(this.this$0).auj();
    return false;
    label247:
    if (this.this$0.mApp.b().ss()) {
      this.this$0.mApp.b().V("MotionEventDown", 1);
    }
    for (;;)
    {
      this.this$0.a("MotionEventDown", 2, 1, false);
      QavPanel.a(this.this$0).K(false, false);
      break;
      this.this$0.mApp.b().a("MotionEventDown", QavPanel.a(this.this$0).bO(), false, true, 1);
    }
    QavPanel.a(this.this$0).setAlpha(255);
    QavPanel.a(this.this$0).setAlpha(255);
    QavPanel.a(this.this$0).removeMessages(256);
    QavPanel.a(this.this$0).removeMessages(261);
    if (i == 3)
    {
      QavPanel.a(this.this$0, true);
      if (QavPanel.a(this.this$0))
      {
        paramView.O("MotionEventACTION_UP", true);
        paramView.Z("MotionEventACTION_UP", 1);
        this.this$0.a("MotionEventUP", 3, 1, true);
      }
    }
    for (;;)
    {
      QavPanel.a(this.this$0).auj();
      return false;
      this.this$0.mApp.b().a("MotionEventACTION_UP", QavPanel.a(this.this$0).bO(), false, true, 1);
      this.this$0.a("MotionEventACTION_UP", 3, 1, false);
      QavPanel.a(this.this$0).K(false, true);
      continue;
      if (i == 1) {
        QavPanel.a(this.this$0).setColor(-1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcx
 * JD-Core Version:    0.7.0.1
 */