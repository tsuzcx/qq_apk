import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment;

public class ajfq
  implements arkn
{
  public ajfq(MsgBackupPCConfirmFragment paramMsgBackupPCConfirmFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      ajgv.b("MsgBackupMsgBackupPCConfirmFragment", "click cancel btn bizType = %d, pcHandler %b", new Object[] { Integer.valueOf(this.b.diy), Boolean.valueOf(ajee.cnI) });
      ajgp.b().exit();
      if (!TextUtils.isEmpty(this.b.mExtraData)) {
        break label93;
      }
      this.b.ca(this.b.getActivity());
      if (this.b.diy != 2) {
        break label104;
      }
      ajgt.report("0X800A282");
    }
    label93:
    label104:
    while (!ajee.cnI)
    {
      return;
      this.b.onBackEvent();
      break;
    }
    ajgt.cN("0X800A266", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfq
 * JD-Core Version:    0.7.0.1
 */