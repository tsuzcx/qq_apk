import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;

class zuw
  implements View.OnClickListener
{
  zuw(zuv paramzuv, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (!badq.d(zuv.a(this.jdField_a_of_type_Zuv)))
    {
      bbmy.a(zuv.a(this.jdField_a_of_type_Zuv), zuv.a(this.jdField_a_of_type_Zuv).getString(2131628946), 0).a();
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null)
    {
      QLog.e("SdkAuthDialog", 1, "positiveListener is null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    awqx.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zuw
 * JD-Core Version:    0.7.0.1
 */