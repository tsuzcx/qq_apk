import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class aaye
  implements DialogInterface.OnClickListener
{
  public aaye(SelectMemberActivity paramSelectMemberActivity, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((acms)this.this$0.app.getBusinessHandler(20)).a(this.this$0.aRJ, this.sv, "");
    SelectMemberActivity.a(this.this$0);
    this.this$0.pd.show();
    this.this$0.Bc("Clk_invite");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaye
 * JD-Core Version:    0.7.0.1
 */