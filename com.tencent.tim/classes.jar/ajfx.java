import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment;

public class ajfx
  implements arkn
{
  public ajfx(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    int i = 2;
    if (paramInt == 1)
    {
      ajgv.b("MsgBackup.MsgBackupSelectionFragment", "click cancel btn mfrom = %d,  pcHandler = %b", new Object[] { Integer.valueOf(MsgBackupSelectionFragment.a(this.a)), Boolean.valueOf(ajee.cnI) });
      if (MsgBackupSelectionFragment.a(this.a) != 0) {
        break label79;
      }
      paramInt = i;
      if (MsgBackupSelectionFragment.a(this.a)) {
        paramInt = 3;
      }
      ajgt.cN("0X800A242", paramInt);
    }
    for (;;)
    {
      this.a.onBackEvent();
      return;
      label79:
      if ((ajee.cnI) && (ajdt.a().Gi() == 1)) {
        ajgt.cN("0X800A266", 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfx
 * JD-Core Version:    0.7.0.1
 */