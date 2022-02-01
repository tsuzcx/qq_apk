import android.view.View;
import android.widget.EditText;
import com.tencent.widget.XPanelContainer;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView.a;

class aylb
  implements EditTextPreView.a
{
  aylb(aykw paramaykw) {}
  
  public void a(View paramView, DynamicTextItem paramDynamicTextItem, int paramInt)
  {
    if ((paramDynamicTextItem != null) && (paramInt > -1))
    {
      paramView = paramDynamicTextItem.getText(paramInt);
      if (paramView != null)
      {
        this.this$0.ag.setText(paramView);
        this.this$0.ag.setSelection(this.this$0.ag.length());
        if (!paramView.equals(axug.aa(paramDynamicTextItem.getType(), paramInt))) {
          break label139;
        }
        this.this$0.ag.setOnClickListener(aykw.a(this.this$0));
        this.this$0.ag.setSelectAllOnFocus(true);
        if (this.this$0.ag.hasFocus()) {
          this.this$0.ag.selectAll();
        }
      }
      for (;;)
      {
        if (this.this$0.h != null) {
          this.this$0.h.abp(34);
        }
        return;
        label139:
        this.this$0.ag.setOnClickListener(null);
      }
    }
    this.this$0.nN(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylb
 * JD-Core Version:    0.7.0.1
 */