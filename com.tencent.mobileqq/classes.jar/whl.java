import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.widget.FormMutiItem;

class whl
  implements Runnable
{
  whl(whk paramwhk, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Whk.a.b != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Whk.a.b.setSecondLineText("");
        this.jdField_a_of_type_Whk.a.b.setSecondLineVisible(false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Whk.a.b.setSecondLineText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Whk.a.b.setSecondLineVisible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     whl
 * JD-Core Version:    0.7.0.1
 */