import android.app.Dialog;

public final class hbs
  implements Runnable
{
  public hbs(Dialog paramDialog) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hbs
 * JD-Core Version:    0.7.0.1
 */