import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.widget.FormMutiItem;

class weg
  implements Runnable
{
  weg(wef paramwef, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Wef.a.b != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Wef.a.b.setSecondLineText("");
        this.jdField_a_of_type_Wef.a.b.setSecondLineVisible(false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Wef.a.b.setSecondLineText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Wef.a.b.setSecondLineVisible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     weg
 * JD-Core Version:    0.7.0.1
 */