import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class ald
  implements Runnable
{
  ald(alc paramalc) {}
  
  public void run()
  {
    this.a.a.a.setText(this.a.a.b);
    this.a.a.a.setTextColor(Color.rgb(119, 119, 119));
    EditInfoActivity.b(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ald
 * JD-Core Version:    0.7.0.1
 */