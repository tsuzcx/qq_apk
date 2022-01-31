import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.file.MoveFileActivity;

public class xag
  implements DialogInterface.OnClickListener
{
  public xag(MoveFileActivity paramMoveFileActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (xnj)paramDialogInterface;
    this.a.jdField_a_of_type_JavaLangString = paramDialogInterface.getInputValue().trim();
    if (this.a.jdField_a_of_type_JavaLangString.length() > bakx.a)
    {
      paramDialogInterface.a(this.a.getString(2131697631), -65536);
      axqy.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, this.a.jdField_a_of_type_Long + "", "", "", "");
    }
    do
    {
      return;
      if (bakx.a(this.a.jdField_a_of_type_JavaLangString))
      {
        paramDialogInterface.a(this.a.getString(2131697632), -65536);
        axqy.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "0", "", "");
        return;
      }
      paramDialogInterface.dismiss();
    } while (bakx.a(this.a.app, this.a, this.a.jdField_a_of_type_Long) == 0);
    xam.a(this.a.app, this.a.jdField_a_of_type_Long, "/", this.a.jdField_a_of_type_JavaLangString, MoveFileActivity.a(this.a));
    this.a.a(2131697560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xag
 * JD-Core Version:    0.7.0.1
 */