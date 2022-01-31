import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.widget.FormMutiItem;

class wmv
  implements Runnable
{
  wmv(wmu paramwmu, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Wmu.a.b != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Wmu.a.b.setSecondLineText("");
        this.jdField_a_of_type_Wmu.a.b.setSecondLineVisible(false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Wmu.a.b.setSecondLineText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Wmu.a.b.setSecondLineVisible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmv
 * JD-Core Version:    0.7.0.1
 */