import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;

class vvx
  implements DialogInterface.OnClickListener
{
  vvx(vvw paramvvw, anxs paramanxs) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_Anxs.aQf)))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_Vvw.a, SubLoginActivity.class);
      paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_Anxs.aQf);
      paramDialogInterface.putExtra("fromWhere", this.jdField_a_of_type_Vvw.a.aOa);
      this.jdField_a_of_type_Vvw.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vvx
 * JD-Core Version:    0.7.0.1
 */