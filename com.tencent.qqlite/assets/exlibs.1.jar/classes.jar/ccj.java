import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ViewFactory.GuideView.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

public class ccj
  implements ViewFactory.GuideView.OnItemClickListener
{
  public ccj(SearchContactsActivity paramSearchContactsActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsActivity", 2, "guide view | onItemClick type is:" + paramInt + " keyWords is:" + paramString);
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ccj
 * JD-Core Version:    0.7.0.1
 */