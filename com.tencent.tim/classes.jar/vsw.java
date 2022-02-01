import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.activity.ScoreQAVFragment.a;
import java.util.ArrayList;

public class vsw
  implements ScoreQAVFragment.a
{
  public vsw(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    paramView = (Button)paramView.findViewById(2131375378);
    if (paramView.isSelected())
    {
      paramView.setSelected(false);
      this.a.Bx(paramInt);
      if (this.a.px.size() != 0) {}
    }
    do
    {
      return;
      paramView.setSelected(true);
      this.a.px.add(Integer.valueOf(paramInt));
    } while (this.a.px.size() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsw
 * JD-Core Version:    0.7.0.1
 */