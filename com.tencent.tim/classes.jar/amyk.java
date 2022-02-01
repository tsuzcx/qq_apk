import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public class amyk
  extends amyf
{
  public amyk(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void aDR()
  {
    super.aDR();
    TextView localTextView = N();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      if (localTextView != null) {
        ((TextView)localTextView).setTextColor(localTextView.getContext().getResources().getColor(2131167230));
      }
    }
    while (localTextView == null) {
      return;
    }
    ((TextView)localTextView).setTextColor(Color.parseColor("#737373"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyk
 * JD-Core Version:    0.7.0.1
 */