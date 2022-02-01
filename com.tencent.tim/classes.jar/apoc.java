import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;

class apoc
  implements View.OnTouchListener
{
  apoc(apoa paramapoa, View paramView1, View paramView2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.IJ.getVisibility() == 0) {}
    for (int i = 1; (paramMotionEvent.getAction() == 4) && (AtPanelTouchController.k(this.rN, paramMotionEvent)) && ((i == 0) || ((i != 0) && (!AtPanelTouchController.k(this.IJ, paramMotionEvent)))); i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apoc
 * JD-Core Version:    0.7.0.1
 */