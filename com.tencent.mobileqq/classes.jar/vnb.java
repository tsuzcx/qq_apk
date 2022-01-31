import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

public final class vnb
  implements Runnable
{
  public vnb(LinearLayout paramLinearLayout, XEditTextEx paramXEditTextEx, PanelIconLinearLayout paramPanelIconLinearLayout, PatchedButton paramPatchedButton) {}
  
  public void run()
  {
    Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845507);
    Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845508);
    Drawable localDrawable3 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845549);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable4 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845650);
    localStateListDrawable.addState(new int[] { -16842910 }, localDrawable4);
    localDrawable4 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845653);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable4);
    localDrawable4 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845654);
    localStateListDrawable.addState(new int[] { 16842919, 16842910 }, localDrawable4);
    ThreadManager.getUIHandler().post(new vnc(this, localDrawable1, localDrawable2, localDrawable3, localStateListDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnb
 * JD-Core Version:    0.7.0.1
 */