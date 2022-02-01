import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashSet;

public class hvk
  implements View.OnClickListener
{
  public hvk(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((ActionSheet.a(this.a)) && ((ActionSheet.a(this.a) == null) || (!ActionSheet.a(this.a).contains(Integer.valueOf(i)))) && (ActionSheet.a(this.a) != -1) && (i != ActionSheet.a(this.a)))
    {
      ((ImageView)((View)ActionSheet.a(this.a).get(ActionSheet.a(this.a))).findViewById(2131231062)).setBackgroundResource(2130840218);
      ((ImageView)((View)ActionSheet.a(this.a).get(i)).findViewById(2131231062)).setBackgroundResource(2130840217);
      ActionSheet.a(this.a, i);
    }
    if (ActionSheet.a(this.a) != null) {
      ActionSheet.a(this.a).OnClick(paramView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hvk
 * JD-Core Version:    0.7.0.1
 */