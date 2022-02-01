import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.DropdownView.1.1;
import com.tencent.mobileqq.widget.DropdownView.AutoCompleteView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arfn
  implements View.OnClickListener
{
  public arfn(DropdownView paramDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.a.clearFocus();
    this.this$0.d.hideSoftInputFromWindow(this.this$0.a.getWindowToken(), 0);
    if ((this.this$0.a.getAdapter() != null) && (this.this$0.a.getAdapter().getCount() > 0))
    {
      if ((((ImageView)paramView).getDrawable() != this.this$0.gc) || (this.this$0.dab)) {
        break label167;
      }
      DropdownView.a(this.this$0).postDelayed(new DropdownView.1.1(this, paramView), 250L);
      Context localContext = paramView.getContext();
      if ((localContext != null) && ((localContext instanceof LoginActivity))) {
        anot.c(((LoginActivity)localContext).app, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label167:
      this.this$0.a.dismissDropDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfn
 * JD-Core Version:    0.7.0.1
 */