import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nxv
  implements View.OnClickListener
{
  public nxv(LimitWordCountEditText paramLimitWordCountEditText) {}
  
  public final void onClick(View paramView)
  {
    if (!LimitWordCountEditText.a(this.this$0).hasFocus())
    {
      LimitWordCountEditText.a(this.this$0).requestFocus();
      LimitWordCountEditText.a(this.this$0).setSelection(LimitWordCountEditText.a(this.this$0).getText().length());
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.this$0.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(LimitWordCountEditText.a(this.this$0), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxv
 * JD-Core Version:    0.7.0.1
 */