import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.Map;

class apcn
  implements DialogInterface.OnClickListener
{
  apcn(apca paramapca, apbr paramapbr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    TroopFileTransferManager.a(this.this$0.mApp, this.this$0.mTroopUin).c(this.c.Id);
    paramDialogInterface = (apbr)apsf.a(this.this$0.mApp, this.this$0.mTroopUin).nO.get(this.c.mParentId);
    if (paramDialogInterface != null) {
      paramDialogInterface.nA.remove(this.c.mFileId);
    }
    anot.a(this.this$0.mApp, "CliOper", "", "", "Grp", "Cancel_pause_download", 0, 0, "", this.this$0.mTroopUin + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apcn
 * JD-Core Version:    0.7.0.1
 */