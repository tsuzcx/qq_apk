import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavPluginProxyActivity;

public class fna
  implements View.OnClickListener
{
  public fna(QfavBuilder paramQfavBuilder, Activity paramActivity, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    QfavPluginProxyActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, QfavBuilder.a(this.jdField_a_of_type_CooperationQqfavQfavBuilder), this.jdField_a_of_type_Int);
    if ((QfavBuilder.a(this.jdField_a_of_type_CooperationQqfavQfavBuilder) != null) && (QfavBuilder.a(this.jdField_a_of_type_CooperationQqfavQfavBuilder).isShowing()))
    {
      QfavBuilder.a(this.jdField_a_of_type_CooperationQqfavQfavBuilder).dismiss();
      QfavBuilder.a(this.jdField_a_of_type_CooperationQqfavQfavBuilder, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fna
 * JD-Core Version:    0.7.0.1
 */