import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class udk
  implements View.OnClickListener
{
  public udk(LimitWordCountEditText paramLimitWordCountEditText) {}
  
  public final void onClick(View paramView)
  {
    if (!LimitWordCountEditText.a(this.a).hasFocus())
    {
      LimitWordCountEditText.a(this.a).requestFocus();
      LimitWordCountEditText.a(this.a).setSelection(LimitWordCountEditText.a(this.a).getText().length());
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.a.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(LimitWordCountEditText.a(this.a), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udk
 * JD-Core Version:    0.7.0.1
 */