import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.selectmember.DiscussionMemberListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class aaww
  implements DialogInterface.OnClickListener
{
  public aaww(DiscussionMemberListInnerFrame paramDiscussionMemberListInnerFrame) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    boolean bool;
    do
    {
      return;
      paramDialogInterface = this.a.F;
      if (this.a.F.isChecked()) {
        break;
      }
      bool = true;
      paramDialogInterface.setChecked(bool);
      this.a.onCheckedChanged(this.a.F, this.a.F.isChecked());
    } while (this.a.a.eK != 32);
    if (this.a.F.isChecked()) {}
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
 * Qualified Name:     aaww
 * JD-Core Version:    0.7.0.1
 */