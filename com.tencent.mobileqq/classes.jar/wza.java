import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;

public class wza
  implements View.OnClickListener
{
  public wza(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void onClick(View paramView)
  {
    TroopUnAccalimedRedPacketList.a(this.a, true);
    QWalletTools.a(TroopUnAccalimedRedPacketList.a(), TroopUnAccalimedRedPacketList.a().getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.back", "", "");
    if (TroopUnAccalimedRedPacketList.a() != null) {
      TroopUnAccalimedRedPacketList.a().dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wza
 * JD-Core Version:    0.7.0.1
 */