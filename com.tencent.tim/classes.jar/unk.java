import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class unk
  implements View.OnClickListener
{
  public unk(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.uo > 1)
    {
      this.this$0.pB.setEnabled(true);
      this.this$0.pB.setImageResource(2130839265);
      ChatHistory localChatHistory = this.this$0;
      localChatHistory.uo -= 1;
      if (this.this$0.uo <= 1)
      {
        this.this$0.pA.setEnabled(false);
        this.this$0.pA.setImageResource(2130841231);
      }
      this.this$0.bFe = ((this.this$0.uo - 1) * 8);
      this.this$0.a.O(this.this$0.mUin, this.this$0.mType, this.this$0.bFe);
      this.this$0.au.setText(String.valueOf(this.this$0.uo));
      this.this$0.au.setSelection(this.this$0.au.getText().length());
      this.this$0.bJS();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unk
 * JD-Core Version:    0.7.0.1
 */