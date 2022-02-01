import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

class dmu
  implements Runnable
{
  dmu(dmt paramdmt) {}
  
  public void run()
  {
    String str = SubLoginActivity.a(this.a.a).getText().toString();
    if ((str != null) && (str.equals("!@#ewaGbhkc$!!="))) {
      SubLoginActivity.a(this.a.a).setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmu
 * JD-Core Version:    0.7.0.1
 */