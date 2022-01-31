import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.activity.ScoreQAVFragment.OnItemClickListener;
import java.util.ArrayList;

public class tny
  implements ScoreQAVFragment.OnItemClickListener
{
  public tny(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = (Button)paramView.findViewById(2131366224);
    if (paramView.isSelected())
    {
      paramView.setSelected(false);
      this.a.a(paramInt);
      if (this.a.a.size() != 0) {}
    }
    do
    {
      return;
      paramView.setSelected(true);
      this.a.a.add(Integer.valueOf(paramInt));
    } while (this.a.a.size() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tny
 * JD-Core Version:    0.7.0.1
 */