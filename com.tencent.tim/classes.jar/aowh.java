import android.view.KeyEvent;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.XEditTextExWithListener.a;

public class aowh
  implements XEditTextExWithListener.a
{
  public aowh(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1)) {
      TroopBarReplyActivity.a(this.this$0, false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aowh
 * JD-Core Version:    0.7.0.1
 */