import android.widget.EditText;
import com.tencent.mobileqq.apollo.ApolloRender;

public final class yhx
  implements Runnable
{
  public yhx(ApolloRender paramApolloRender, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.getText().toString().compareToIgnoreCase(this.jdField_a_of_type_JavaLangString) != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.setSelection(this.jdField_a_of_type_JavaLangString.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yhx
 * JD-Core Version:    0.7.0.1
 */