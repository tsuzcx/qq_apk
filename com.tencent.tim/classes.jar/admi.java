import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView;
import com.tencent.qphone.base.util.QLog;

public class admi
  implements View.OnTouchListener
{
  public admi(ScanEntryProviderContainerView paramScanEntryProviderContainerView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, String.format("dispatchTouchEvent onTabClickListener", new Object[0]));
    }
    long l = System.currentTimeMillis();
    if (l - ScanEntryProviderContainerView.a(this.this$0) <= 1000L) {
      QLog.i("ScanEntryProviderContainerView", 1, "avoid user fast click");
    }
    do
    {
      return false;
      ScanEntryProviderContainerView.a(this.this$0, l);
      switch (paramMotionEvent.getAction())
      {
      default: 
        return false;
      }
      paramView = (Integer)paramView.getTag();
      ScanEntryProviderContainerView.a(this.this$0).a(paramView.intValue(), new admj(this, paramView));
    } while (paramView.intValue() != 2);
    anot.a(null, "dc00898", "", "", "0X800A9CE", "0X800A9CE", 0, 0, "", "0", "0", "");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admi
 * JD-Core Version:    0.7.0.1
 */