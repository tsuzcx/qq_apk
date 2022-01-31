import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;

public class wzd
  implements PopupWindow.OnDismissListener
{
  public wzd(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void onDismiss()
  {
    if (!TroopUnAccalimedRedPacketList.a(this.a)) {
      QWalletTools.a(TroopUnAccalimedRedPacketList.a(), TroopUnAccalimedRedPacketList.a().getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.keyback", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzd
 * JD-Core Version:    0.7.0.1
 */