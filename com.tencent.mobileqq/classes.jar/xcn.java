import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbItemClickListener;

class xcn
  extends TroopUnAccalimedRedPacketList.HbItemClickListener
{
  xcn(xcm paramxcm) {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 1) && (TroopUnAccalimedRedPacketList.a() != null)) {
      TroopUnAccalimedRedPacketList.a().dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcn
 * JD-Core Version:    0.7.0.1
 */