import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;

public class ucn
  extends Handler
{
  public ucn(ViolaBaseView paramViolaBaseView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      return;
    case 0: 
      ViolaBaseView.d(this.a);
      return;
    case 3: 
      ViolaBaseView.a(this.a);
      return;
    }
    ViolaBaseView.a(this.a, true);
    ViolaBaseView.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucn
 * JD-Core Version:    0.7.0.1
 */