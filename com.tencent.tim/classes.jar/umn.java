import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class umn
  implements View.OnClickListener
{
  public umn(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.uo < this.this$0.pageCount)
    {
      this.this$0.pA.setEnabled(true);
      this.this$0.pA.setImageResource(2130839264);
      ChatHistory localChatHistory = this.this$0;
      localChatHistory.uo += 1;
      if (this.this$0.uo >= this.this$0.pageCount)
      {
        this.this$0.pB.setEnabled(false);
        this.this$0.pB.setImageResource(2130850446);
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
 * Qualified Name:     umn
 * JD-Core Version:    0.7.0.1
 */