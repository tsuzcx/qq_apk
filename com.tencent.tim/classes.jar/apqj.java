import android.view.View;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.widget.ClearableEditText;
import java.util.List;

public class apqj
  implements ausj.a
{
  public apqj(BulkSendMessageFragment paramBulkSendMessageFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.this$0.Ig.size())
    {
      paramView = (String)this.this$0.Ig.get(paramInt);
      this.this$0.k.setText(paramView);
    }
    this.val$sheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqj
 * JD-Core Version:    0.7.0.1
 */