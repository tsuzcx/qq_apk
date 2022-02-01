import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.PopupWindow;

class uyz
  extends CountDownTimer
{
  uyz(uyy paramuyy, long paramLong1, long paramLong2, Context paramContext)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if ((uyy.a(this.jdField_a_of_type_Uyy) != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()))
    {
      uyy.a(this.jdField_a_of_type_Uyy).dismiss();
      uyy.a(this.jdField_a_of_type_Uyy, null);
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyz
 * JD-Core Version:    0.7.0.1
 */