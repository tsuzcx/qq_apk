import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.bigbrother.JumpConfirmFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;

public class adwt
  implements DialogInterface.OnClickListener
{
  public adwt(JumpConfirmFragment paramJumpConfirmFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    JefsClass.getInstance().F(JumpConfirmFragment.a(this.a), JumpConfirmFragment.a(this.a), JumpConfirmFragment.b(this.a));
    if (JumpConfirmFragment.b(this.a) == null) {}
    for (paramDialogInterface = "";; paramDialogInterface = JumpConfirmFragment.b(this.a))
    {
      anot.a(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "1", "", paramDialogInterface, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adwt
 * JD-Core Version:    0.7.0.1
 */