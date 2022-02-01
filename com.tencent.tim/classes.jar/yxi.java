import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;

public class yxi
  implements DialogInterface.OnClickListener
{
  public yxi(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.cmu();
    this.this$0.cmR();
    if (TroopNotifyAndRecommendView.b(this.this$0) != null) {
      TroopNotifyAndRecommendView.b(this.this$0).setVisibility(8);
    }
    anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "clear_clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxi
 * JD-Core Version:    0.7.0.1
 */