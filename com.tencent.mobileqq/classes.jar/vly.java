import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.aio.panel.PEPanel;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;

class vly
  implements Runnable
{
  vly(vlx paramvlx) {}
  
  public void run()
  {
    PEPanel.a(this.a.a).setVisibility(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, XPanelContainer.a, 0.0F);
    localTranslateAnimation.setDuration(200L);
    PEPanel.a(this.a.a).startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vly
 * JD-Core Version:    0.7.0.1
 */