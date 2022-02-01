import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class cjo
  implements Runnable
{
  cjo(cjm paramcjm, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Cjm.a.c)
    {
      this.jdField_a_of_type_Cjm.a.a.setText(this.jdField_a_of_type_Cjm.a.getString(2131559055, new Object[] { this.jdField_a_of_type_Cjm.a.b }));
      this.jdField_a_of_type_Cjm.a.a.setTextColor(-65536);
      EditInfoActivity.b(this.jdField_a_of_type_Cjm.a, false);
      return;
    }
    this.jdField_a_of_type_Cjm.a.a.setText(this.jdField_a_of_type_Cjm.a.b);
    this.jdField_a_of_type_Cjm.a.a.setTextColor(Color.rgb(119, 119, 119));
    EditInfoActivity.c(this.jdField_a_of_type_Cjm.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cjo
 * JD-Core Version:    0.7.0.1
 */