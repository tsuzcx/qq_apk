import android.graphics.Outline;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;

public class tbg
  extends ViewOutlineProvider
{
  public tbg(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), wja.dp2px(5.0F, paramView.getResources()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tbg
 * JD-Core Version:    0.7.0.1
 */