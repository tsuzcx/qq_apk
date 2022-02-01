import android.widget.EditText;
import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class wid
  extends acog
{
  public wid(SendBirthdayWishesActivity paramSendBirthdayWishesActivity) {}
  
  public void Ca(int paramInt)
  {
    this.this$0.aqz();
    SendBirthdayWishesActivity.a(this.this$0, paramInt);
    this.this$0.aL.removeTextChangedListener(this.this$0);
    this.this$0.aL.setText("");
    if (this.this$0.d.vm() != 0) {
      this.this$0.d.aJS();
    }
    if (paramInt != 2)
    {
      SendBirthdayWishesActivity.a(this.this$0).removeCallbacks(SendBirthdayWishesActivity.a(this.this$0));
      SendBirthdayWishesActivity.a(this.this$0).postDelayed(SendBirthdayWishesActivity.a(this.this$0), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wid
 * JD-Core Version:    0.7.0.1
 */