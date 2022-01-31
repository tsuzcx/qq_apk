import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.file.MoveFileActivity;

public class yoz
  implements DialogInterface.OnClickListener
{
  public yoz(MoveFileActivity paramMoveFileActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (zcc)paramDialogInterface;
    this.a.jdField_a_of_type_JavaLangString = paramDialogInterface.getInputValue().trim();
    if (this.a.jdField_a_of_type_JavaLangString.length() > bcjk.a)
    {
      paramDialogInterface.a(this.a.getString(2131697806), -65536);
      azmj.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, this.a.jdField_a_of_type_Long + "", "", "", "");
    }
    do
    {
      return;
      if (bcjk.a(this.a.jdField_a_of_type_JavaLangString))
      {
        paramDialogInterface.a(this.a.getString(2131697807), -65536);
        azmj.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "0", "", "");
        return;
      }
      paramDialogInterface.dismiss();
    } while (bcjk.a(this.a.app, this.a, this.a.jdField_a_of_type_Long) == 0);
    ypf.a(this.a.app, this.a.jdField_a_of_type_Long, "/", this.a.jdField_a_of_type_JavaLangString, MoveFileActivity.a(this.a));
    this.a.a(2131697735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yoz
 * JD-Core Version:    0.7.0.1
 */