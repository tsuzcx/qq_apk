import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.widget.DragView.b;

class agxx
  implements DragView.b
{
  agxx(agxw paramagxw) {}
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    agxw.a(this.b, true);
    if (agxw.a(this.b) != null)
    {
      Drawable localDrawable = agxw.a(this.b).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      if (agxw.a(this.b) != null) {
        agxw.a(this.b).setVisibility(8);
      }
      if (this.b.kp != null) {
        this.b.kp.setVisibility(8);
      }
    }
  }
  
  public void onGestureFinish()
  {
    agxw.a(this.b, false);
    this.b.a.djZ();
  }
  
  public void onResetPosition()
  {
    agxw.a(this.b, false);
    if (agxw.a(this.b)) {
      this.b.JK(true);
    }
    if (agxw.b(this.b)) {
      this.b.JJ(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxx
 * JD-Core Version:    0.7.0.1
 */