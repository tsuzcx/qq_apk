import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class dxa
  implements DialogInterface.OnClickListener
{
  public dxa(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString + "({button: 1})");
        return;
      }
    } while (paramInt != 1);
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString + "({button: 0})");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dxa
 * JD-Core Version:    0.7.0.1
 */