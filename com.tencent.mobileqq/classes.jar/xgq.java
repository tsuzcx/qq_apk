import android.view.View;
import android.view.View.OnClickListener;
import mqq.os.MqqHandler;

public class xgq
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public xgq(int paramInt, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgq
 * JD-Core Version:    0.7.0.1
 */