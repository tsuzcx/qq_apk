import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class cjn
  implements Runnable
{
  cjn(cjm paramcjm) {}
  
  public void run()
  {
    this.a.a.a.setText(this.a.a.b);
    this.a.a.a.setTextColor(Color.rgb(119, 119, 119));
    EditInfoActivity.a(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cjn
 * JD-Core Version:    0.7.0.1
 */