import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class aubg
  extends auby
{
  public aubg(atzy paramatzy, Activity paramActivity)
  {
    super(paramatzy, paramActivity);
  }
  
  protected void djT()
  {
    super.djT();
    if (this.jdField_a_of_type_Atzy.bL() == 2) {
      this.jdField_a_of_type_Aucs.f("安装", new aubh(this));
    }
  }
  
  public void init()
  {
    super.init();
    String str = BaseApplicationImpl.getContext().getString(2131694125);
    this.jdField_a_of_type_Aucs.cj(str, true);
    this.jdField_a_of_type_Aucs.showTip(false);
    this.jdField_a_of_type_Aucs.OP(2130845117);
    this.jdField_a_of_type_Aucs.Ju(this.jdField_a_of_type_Atzy.aB());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubg
 * JD-Core Version:    0.7.0.1
 */