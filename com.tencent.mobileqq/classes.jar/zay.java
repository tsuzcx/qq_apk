import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView;
import com.tencent.gdtad.views.xijing.GdtTextData;

public class zay
  implements View.OnFocusChangeListener
{
  public zay(GdtFormItemTextBoxView paramGdtFormItemTextBoxView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((this.a.a() == null) || (!this.a.a().isValid()))
    {
      yxs.b("GdtFormItemTextBoxView", "onFocusChange error");
      return;
    }
    if (paramBoolean)
    {
      paramView = new zai(2, -1, this.a.a().title.text);
      paramView.b = GdtFormItemTextBoxView.a(this.a);
      GdtFormItemTextBoxView.a(this.a, paramView);
      return;
    }
    GdtFormItemTextBoxView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zay
 * JD-Core Version:    0.7.0.1
 */