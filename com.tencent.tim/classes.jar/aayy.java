import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;

public class aayy
  implements DialogInterface.OnClickListener
{
  public aayy(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    boolean bool;
    do
    {
      return;
      paramDialogInterface = this.this$0.F;
      if (this.this$0.F.isChecked()) {
        break;
      }
      bool = true;
      paramDialogInterface.setChecked(bool);
      this.this$0.onCheckedChanged(this.this$0.F, this.this$0.F.isChecked());
    } while (this.this$0.a.eK != 32);
    if (this.this$0.F.isChecked()) {}
    for (paramDialogInterface = "friendsfinder.all.confirm";; paramDialogInterface = "friendsfinder.all.cancel")
    {
      aagd.bD(0, paramDialogInterface);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayy
 * JD-Core Version:    0.7.0.1
 */