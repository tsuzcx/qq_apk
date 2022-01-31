import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class cjp
  implements Runnable
{
  cjp(cjn paramcjn, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Cjn.a.c)
    {
      this.jdField_a_of_type_Cjn.a.a.setText(this.jdField_a_of_type_Cjn.a.getString(2131559055, new Object[] { this.jdField_a_of_type_Cjn.a.b }));
      this.jdField_a_of_type_Cjn.a.a.setTextColor(-65536);
      EditInfoActivity.b(this.jdField_a_of_type_Cjn.a, false);
      return;
    }
    this.jdField_a_of_type_Cjn.a.a.setText(this.jdField_a_of_type_Cjn.a.b);
    this.jdField_a_of_type_Cjn.a.a.setTextColor(Color.rgb(119, 119, 119));
    EditInfoActivity.c(this.jdField_a_of_type_Cjn.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cjp
 * JD-Core Version:    0.7.0.1
 */