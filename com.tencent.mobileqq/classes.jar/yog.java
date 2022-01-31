import android.graphics.Outline;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;

public class yog
  extends ViewOutlineProvider
{
  public yog(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), actj.a(5.0F, paramView.getResources()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yog
 * JD-Core Version:    0.7.0.1
 */