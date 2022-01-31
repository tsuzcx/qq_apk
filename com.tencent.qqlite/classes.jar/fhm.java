import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class fhm
  implements View.OnClickListener
{
  public fhm(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((ActionSheet.a(this.a)) && (ActionSheet.b(this.a) != -1) && (i != ActionSheet.b(this.a)))
    {
      ((View)ActionSheet.a(this.a).get(ActionSheet.b(this.a))).findViewById(2131296506).setVisibility(8);
      View localView = (View)ActionSheet.a(this.a).get(i);
      localView.findViewById(2131296506).setVisibility(0);
      localView.findViewById(2131296506).setContentDescription(ActionSheet.a(this.a).getString(2131364374));
      ActionSheet.a(this.a, i);
    }
    if (ActionSheet.a(this.a) != null) {
      ActionSheet.a(this.a).a(paramView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhm
 * JD-Core Version:    0.7.0.1
 */