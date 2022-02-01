import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.HashMap;

public class wfv
  implements DialogInterface.OnClickListener
{
  public wfv(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.bXO();
    if (VipUtils.ce(this.this$0.app))
    {
      if (this.this$0.Hy != 0L) {
        break label144;
      }
      paramDialogInterface = (String)this.this$0.gF.get(this.this$0.aRQ);
      if (!TextUtils.isEmpty(paramDialogInterface)) {
        this.this$0.r(this.this$0.aRQ, paramDialogInterface, false);
      }
    }
    else
    {
      if ((this.this$0.Hy != 0L) && (this.this$0.Hy != 160L)) {
        break label222;
      }
    }
    label144:
    label222:
    for (paramDialogInterface = "3";; paramDialogInterface = "4")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CA", "", 1, 0, 0, jqc.hS(), paramDialogInterface, "0");
      return;
      this.this$0.aV(this.this$0.aRQ, false);
      break;
      if (((this.this$0.Hy != 160L) && (this.this$0.Hy != 1600L)) || (TextUtils.isEmpty(this.this$0.aRP))) {
        break;
      }
      paramDialogInterface = alco.a(this.this$0, alcs.agq, this.this$0.Hy);
      this.this$0.r(paramDialogInterface, this.this$0.aRP, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wfv
 * JD-Core Version:    0.7.0.1
 */