import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class aawk
{
  private static final int clI = Color.rgb(123, 113, 30);
  private static final int clK = Color.argb(64, 125, 113, 30);
  private static final int clM = Color.rgb(162, 116, 4);
  private static final int clN = Color.argb(64, 213, 185, 118);
  public int clP = 0;
  
  private aawc a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof aawc)) {
        return (aawc)paramView.getParent();
      }
    } while (!(paramView instanceof aawc));
    return (aawc)paramView;
  }
  
  void a(View paramView, aavv paramaavv)
  {
    aawc localaawc = a(paramView);
    if (localaawc == null) {}
    aawe localaawe;
    do
    {
      return;
      localaawe = localaawc.delegate();
    } while ((localaawe == null) || (!localaawe.isSelectable()) || (localaawc.hasSelected()));
    if (this.clP == 2)
    {
      localaawe.Ci(clM);
      localaawe.GG(clN);
    }
    for (;;)
    {
      localaawe.a(paramaavv);
      localaawc.doSelecting(null);
      return;
      if (this.clP == 1)
      {
        localaawe.Ci(clI);
        localaawe.GG(clK);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131167281).getDefaultColor();
        int j = paramView.getColorStateList(2131167283).getDefaultColor();
        localaawe.Ci(i);
        localaawe.GG(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawk
 * JD-Core Version:    0.7.0.1
 */