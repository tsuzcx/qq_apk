import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

public class vfa
  implements View.OnFocusChangeListener
{
  public vfa(Leba paramLeba) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      amub.a(null, 0, 21, "0X8009D15", 0, 0, null, null);
      UniteSearchActivity.a(this.this$0.a(), null, 21, 0L, null, 3);
      anot.a(this.this$0.app, "CliOper", "", "", "0x8004B21", "0x8004B21", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfa
 * JD-Core Version:    0.7.0.1
 */