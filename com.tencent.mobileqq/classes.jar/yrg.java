import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView;
import com.tencent.gdtad.views.xijing.GdtTextData;

public class yrg
  implements View.OnFocusChangeListener
{
  public yrg(GdtFormItemTextBoxView paramGdtFormItemTextBoxView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((this.a.a() == null) || (!this.a.a().isValid()))
    {
      yny.b("GdtFormItemTextBoxView", "onFocusChange error");
      return;
    }
    if (paramBoolean)
    {
      paramView = new yqq(2, -1, this.a.a().title.text);
      paramView.b = GdtFormItemTextBoxView.a(this.a);
      GdtFormItemTextBoxView.a(this.a, paramView);
      return;
    }
    GdtFormItemTextBoxView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yrg
 * JD-Core Version:    0.7.0.1
 */