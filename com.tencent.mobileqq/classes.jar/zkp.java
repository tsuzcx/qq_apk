import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class zkp
  implements Runnable
{
  public zkp(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void run()
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().app == null)) {}
    do
    {
      return;
      this.a.l();
    } while (this.a.a == null);
    this.a.a.sendEmptyMessage(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zkp
 * JD-Core Version:    0.7.0.1
 */