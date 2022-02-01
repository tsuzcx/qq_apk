import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.qqprotect.qsec.QSecFramework;

public class ahny
  implements View.OnTouchListener
{
  public ahny(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (QSecFramework.a().c(1001).booleanValue())) {
      QSecFramework.a().sendCmdToLib(5, 0, 2, new Object[] { Integer.valueOf(83), Integer.valueOf(1), Integer.valueOf(6), "clickWeb", null }, null);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahny
 * JD-Core Version:    0.7.0.1
 */