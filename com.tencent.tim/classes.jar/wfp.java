import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class wfp
  implements DialogInterface.OnClickListener
{
  public wfp(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.bXQ();
    if (this.this$0.bbV)
    {
      this.this$0.bbV = false;
      this.this$0.bXL();
      this.this$0.b.setVisibility(0);
      this.this$0.bXM();
    }
    if (!TextUtils.isEmpty(this.this$0.getCurrentText())) {}
    for (paramDialogInterface = "1";; paramDialogInterface = "0")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CA", "", 1, 0, 0, jqc.hS(), paramDialogInterface, "1");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wfp
 * JD-Core Version:    0.7.0.1
 */