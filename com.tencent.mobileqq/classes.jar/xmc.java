import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.NewStyleDropdownView;

class xmc
  implements Runnable
{
  xmc(xmb paramxmb, Object paramObject) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      this.jdField_a_of_type_Xmb.a.a.a(true, this.jdField_a_of_type_JavaLangObject);
      return;
    }
    if (LoginView.b(this.jdField_a_of_type_Xmb.a))
    {
      this.jdField_a_of_type_Xmb.a.a.a(true, null);
      return;
    }
    this.jdField_a_of_type_Xmb.a.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xmc
 * JD-Core Version:    0.7.0.1
 */