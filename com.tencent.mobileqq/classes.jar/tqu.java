import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.PopupWindow;

class tqu
  extends CountDownTimer
{
  tqu(tqt paramtqt, long paramLong1, long paramLong2, Context paramContext)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    if ((tqt.a(this.jdField_a_of_type_Tqt) != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()))
    {
      tqt.a(this.jdField_a_of_type_Tqt).dismiss();
      tqt.a(this.jdField_a_of_type_Tqt, null);
    }
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqu
 * JD-Core Version:    0.7.0.1
 */