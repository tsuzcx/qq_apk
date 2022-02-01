import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;

class axay
  implements View.OnClickListener
{
  axay(axaw paramaxaw, axaw.a parama, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(axaw.a(this.this$0).getWindowToken(), 0);
    axaw.a(this.this$0).setTextColor(-1);
    axaw.a(this.this$0, axaw.a(this.this$0));
    axaw.a(this.this$0, this.a.editText);
    axaw.a(this.this$0).setTextColor(-12339461);
    axaw.a(this.this$0, this.b);
    if (axaw.a(this.this$0) != null) {
      axaw.a(this.this$0).a(this.b.itemType, this.b.value, this.a.editText);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axay
 * JD-Core Version:    0.7.0.1
 */