import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView;

public class tmg
  implements View.OnFocusChangeListener
{
  public tmg(GdtFormItemTextBoxView paramGdtFormItemTextBoxView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((this.a.a() == null) || (!this.a.a().isValid()))
    {
      tkw.i("GdtFormItemTextBoxView", "onFocusChange error");
      return;
    }
    if (paramBoolean)
    {
      paramView = new AdFormError(2, -1, this.a.a().title.text);
      paramView.index = GdtFormItemTextBoxView.a(this.a);
      GdtFormItemTextBoxView.a(this.a, paramView);
      return;
    }
    GdtFormItemTextBoxView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmg
 * JD-Core Version:    0.7.0.1
 */