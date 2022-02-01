import android.app.Activity;
import android.os.IBinder;
import android.widget.Button;

public class auug
  extends auud
{
  public boolean dkE = true;
  
  public auug(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected void d(IBinder paramIBinder)
  {
    if (this.dkE) {
      super.d(paramIBinder);
    }
  }
  
  public void initPopupWindow()
  {
    super.initPopupWindow();
    this.dkC = false;
    if (this.bU != null) {
      this.bU.setText(acfp.m(2131707578));
    }
    exc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auug
 * JD-Core Version:    0.7.0.1
 */