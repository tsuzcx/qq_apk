import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

class dnk
  implements Runnable
{
  dnk(dni paramdni) {}
  
  public void run()
  {
    String str = SubLoginActivity.a(this.a.a).getText().toString();
    if ((str != null) && (str.equals("!@#ewaGbhkc$!!="))) {
      SubLoginActivity.a(this.a.a).setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dnk
 * JD-Core Version:    0.7.0.1
 */