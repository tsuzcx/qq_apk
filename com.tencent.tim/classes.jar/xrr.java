import android.os.Handler.Callback;
import android.os.Message;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.aio.panel.PEPanel;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;

public class xrr
  implements Handler.Callback
{
  public xrr(PEPanel paramPEPanel) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    PEPanel.a(this.a).setVisibility(0);
    paramMessage = new TranslateAnimation(0.0F, 0.0F, XPanelContainer.aLe, 0.0F);
    paramMessage.setDuration(200L);
    PEPanel.a(this.a).startAnimation(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrr
 * JD-Core Version:    0.7.0.1
 */