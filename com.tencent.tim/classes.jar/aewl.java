import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class aewl
  implements View.OnClickListener
{
  aewl(aewi paramaewi, String paramString) {}
  
  public void onClick(View paramView)
  {
    aewi.a(this.this$0).removeCallbacks(aewi.a(this.this$0));
    aewi.a(this.this$0).run();
    int i = aewi.a(this.this$0).a.getSelectionStart();
    Editable localEditable = aewi.a(this.this$0).a.getEditableText();
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
 * Qualified Name:     aewl
 * JD-Core Version:    0.7.0.1
 */