import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.bigbrother.JumpConfirmFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;

public class adws
  implements DialogInterface.OnClickListener
{
  public adws(JumpConfirmFragment paramJumpConfirmFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    JefsClass.getInstance().E(JumpConfirmFragment.a(this.a), JumpConfirmFragment.a(this.a), JumpConfirmFragment.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adws
 * JD-Core Version:    0.7.0.1
 */