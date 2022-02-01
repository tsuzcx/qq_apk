import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class aewq
  implements View.OnClickListener
{
  aewq(aewn paramaewn, String paramString) {}
  
  public void onClick(View paramView)
  {
    aewn.a(this.this$0).removeCallbacks(aewn.a(this.this$0));
    aewn.a(this.this$0).run();
    int i = aewn.a(this.this$0).getSelectionStart();
    Editable localEditable = aewn.a(this.this$0).getEditableText();
    if ((i < 0) || (i >= localEditable.length())) {
      localEditable.append(this.buJ);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localEditable.insert(i, this.buJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewq
 * JD-Core Version:    0.7.0.1
 */