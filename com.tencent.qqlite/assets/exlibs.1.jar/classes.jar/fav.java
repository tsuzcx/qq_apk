import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupConfirmActivity;

public class fav
  implements Runnable
{
  public fav(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fav
 * JD-Core Version:    0.7.0.1
 */