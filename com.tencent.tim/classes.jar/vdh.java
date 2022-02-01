import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class vdh
  implements DialogInterface.OnClickListener
{
  public vdh(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = GroupManagerActivity.a(this.a).getInputValue();
    if (paramDialogInterface.equals("")) {
      paramDialogInterface = this.a.getResources().getString(2131694502);
    }
    for (;;)
    {
      if (GroupManagerActivity.a(this.a) == 0) {
        if (this.a.oW.size() > 0)
        {
          b = (byte)(((Groups)this.a.oW.get(this.a.oW.size() - 1)).seqid + 1);
          GroupManagerActivity.a(this.a, this.a.a(b, paramDialogInterface));
          if (QLog.isColorLevel()) {
            QLog.d("GroupManagerActivity", 2, "AddFriendGroup needShowDialog = " + GroupManagerActivity.a(this.a));
          }
          if (GroupManagerActivity.a(this.a)) {
            this.a.Ba(2131694545);
          }
          anot.a(this.a.app, "CliOper", "", "", "category", "Add_category", 0, 0, "", "", "", "");
        }
      }
      while (1 != GroupManagerActivity.a(this.a)) {
        for (;;)
        {
          return;
          byte b = 1;
        }
      }
      GroupManagerActivity.a(this.a, this.a.b((byte)GroupManagerActivity.a(this.a).group_id, paramDialogInterface));
      if (QLog.isColorLevel()) {
        QLog.d("GroupManagerActivity", 2, "EditeFriendGroup needShowDialog = " + GroupManagerActivity.a(this.a));
      }
      if (GroupManagerActivity.a(this.a)) {
        this.a.Ba(2131694548);
      }
      anot.a(this.a.app, "CliOper", "", "", "category", "Name_category", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdh
 * JD-Core Version:    0.7.0.1
 */