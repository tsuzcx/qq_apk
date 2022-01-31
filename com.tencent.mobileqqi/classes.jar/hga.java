import android.app.Dialog;

public final class hga
  implements Runnable
{
  public hga(Dialog paramDialog) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hga
 * JD-Core Version:    0.7.0.1
 */