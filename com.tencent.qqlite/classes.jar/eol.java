import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public final class eol
  implements Runnable
{
  public eol(Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.b);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(this.jdField_a_of_type_Int), new eom(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eol
 * JD-Core Version:    0.7.0.1
 */