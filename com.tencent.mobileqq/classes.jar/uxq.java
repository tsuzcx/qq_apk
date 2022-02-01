import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.PopupWindow;

class uxq
  extends CountDownTimer
{
  uxq(uxp paramuxp, long paramLong1, long paramLong2, Context paramContext)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if ((uxp.a(this.jdField_a_of_type_Uxp) != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()))
    {
      uxp.a(this.jdField_a_of_type_Uxp).dismiss();
      uxp.a(this.jdField_a_of_type_Uxp, null);
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxq
 * JD-Core Version:    0.7.0.1
 */