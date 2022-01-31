import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class ale
  implements Runnable
{
  ale(alc paramalc, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Alc.a.c)
    {
      this.jdField_a_of_type_Alc.a.a.setText("内容超出!" + this.jdField_a_of_type_Alc.a.b);
      this.jdField_a_of_type_Alc.a.a.setTextColor(-65536);
      EditInfoActivity.c(this.jdField_a_of_type_Alc.a, false);
      return;
    }
    this.jdField_a_of_type_Alc.a.a.setText(this.jdField_a_of_type_Alc.a.b);
    this.jdField_a_of_type_Alc.a.a.setTextColor(Color.rgb(119, 119, 119));
    EditInfoActivity.d(this.jdField_a_of_type_Alc.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ale
 * JD-Core Version:    0.7.0.1
 */