import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.theme.SkinEngine;
import mqq.os.MqqHandler;

public final class vvj
  implements Runnable
{
  public vvj(TextView paramTextView) {}
  
  public void run()
  {
    Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845961);
    Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130845963);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable1);
    localStateListDrawable.addState(new int[] { 16842919, 16842910 }, localDrawable2);
    ThreadManager.getUIHandler().post(new vvk(this, localStateListDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vvj
 * JD-Core Version:    0.7.0.1
 */