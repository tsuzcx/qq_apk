import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.file.MoveFileActivity;

public class smm
  implements DialogInterface.OnClickListener
{
  public smm(MoveFileActivity paramMoveFileActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (svx)paramDialogInterface;
    this.this$0.aEH = paramDialogInterface.getInputValue().trim();
    if (this.this$0.aEH.length() > apsv.dVL)
    {
      paramDialogInterface.bH(this.this$0.getString(2131699589), -65536);
      anot.a(this.this$0.app, "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, this.this$0.CV + "", "", "", "");
    }
    do
    {
      return;
      if (apsv.qR(this.this$0.aEH))
      {
        paramDialogInterface.bH(this.this$0.getString(2131699590), -65536);
        anot.a(this.this$0.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.this$0.CV + "", "0", "", "");
        return;
      }
      paramDialogInterface.dismiss();
    } while (apsv.a(this.this$0.app, this.this$0, this.this$0.CV) == 0);
    smq.a(this.this$0.app, this.this$0.CV, "/", this.this$0.aEH, MoveFileActivity.a(this.this$0));
    this.this$0.yC(2131699518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smm
 * JD-Core Version:    0.7.0.1
 */