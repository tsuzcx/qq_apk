import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.activity.Leba;

public class ass
  implements View.OnFocusChangeListener
{
  public ass(Leba paramLeba) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      SearchActivity.a(this.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ass
 * JD-Core Version:    0.7.0.1
 */