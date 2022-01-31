import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class cqc
  implements Runnable
{
  cqc(cqa paramcqa, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Cqa.a.c)
    {
      this.jdField_a_of_type_Cqa.a.a.setText(this.jdField_a_of_type_Cqa.a.getString(2131559055, new Object[] { this.jdField_a_of_type_Cqa.a.b }));
      this.jdField_a_of_type_Cqa.a.a.setTextColor(-65536);
      EditInfoActivity.b(this.jdField_a_of_type_Cqa.a, false);
      return;
    }
    this.jdField_a_of_type_Cqa.a.a.setText(this.jdField_a_of_type_Cqa.a.b);
    this.jdField_a_of_type_Cqa.a.a.setTextColor(Color.rgb(119, 119, 119));
    EditInfoActivity.c(this.jdField_a_of_type_Cqa.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqc
 * JD-Core Version:    0.7.0.1
 */