import android.app.Dialog;

public final class hbt
  implements Runnable
{
  public hbt(Dialog paramDialog) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hbt
 * JD-Core Version:    0.7.0.1
 */