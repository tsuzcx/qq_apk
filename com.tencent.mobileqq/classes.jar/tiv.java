import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class tiv
{
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LinkedList<tix> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public tiv(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public tix a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return null;
    }
    return (tix)this.jdField_a_of_type_JavaUtilLinkedList.pop();
  }
  
  public void a(tiw paramtiw)
  {
    if (paramtiw == null) {}
    for (;;)
    {
      return;
      while (!a())
      {
        tix localtix = a();
        if (localtix != null) {
          paramtiw.a(localtix);
        }
      }
    }
  }
  
  public void a(tix paramtix)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.push(paramtix);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tiv
 * JD-Core Version:    0.7.0.1
 */