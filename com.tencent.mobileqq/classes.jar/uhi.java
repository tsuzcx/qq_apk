import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class uhi
  implements DialogInterface.OnClickListener
{
  public uhi(VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.n();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CA", "", 1, 0, 0, HttpUtil.a(), "2", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uhi
 * JD-Core Version:    0.7.0.1
 */