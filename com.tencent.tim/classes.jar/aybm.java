import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

class aybm
  implements View.OnTouchListener
{
  boolean dxM = false;
  
  aybm(aybl paramaybl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return true;
      this.a.this$0.a.setBackgroundColor(this.a.this$0.getResources().getColor(2131165518));
      this.dxM = true;
      return true;
    } while (!this.dxM);
    this.a.this$0.a.setBackgroundColor(this.a.this$0.getResources().getColor(2131165520));
    if (!this.a.this$0.dxJ)
    {
      this.a.this$0.dxJ = true;
      this.a.this$0.stopCapture();
    }
    this.dxM = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybm
 * JD-Core Version:    0.7.0.1
 */