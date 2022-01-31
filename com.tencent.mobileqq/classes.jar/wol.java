import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.activity.contact.addcontact.ViewFactory.GuideView.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

public class wol
  implements ViewFactory.GuideView.OnItemClickListener
{
  public wol(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "guide view | onItemClick type is:" + paramInt + " keyWords is:" + paramString);
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.a(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wol
 * JD-Core Version:    0.7.0.1
 */