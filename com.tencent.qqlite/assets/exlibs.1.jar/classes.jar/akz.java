import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class akz
  implements Runnable
{
  akz(akx paramakx, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Akx.a.c)
    {
      this.jdField_a_of_type_Akx.a.a.setText("内容超出!" + this.jdField_a_of_type_Akx.a.b);
      this.jdField_a_of_type_Akx.a.a.setTextColor(-65536);
      EditInfoActivity.c(this.jdField_a_of_type_Akx.a, false);
      return;
    }
    this.jdField_a_of_type_Akx.a.a.setText(this.jdField_a_of_type_Akx.a.b);
    this.jdField_a_of_type_Akx.a.a.setTextColor(Color.rgb(119, 119, 119));
    EditInfoActivity.d(this.jdField_a_of_type_Akx.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     akz
 * JD-Core Version:    0.7.0.1
 */