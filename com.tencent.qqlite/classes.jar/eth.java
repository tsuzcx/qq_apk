import android.app.Dialog;

public final class eth
  implements Runnable
{
  public eth(Dialog paramDialog) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eth
 * JD-Core Version:    0.7.0.1
 */