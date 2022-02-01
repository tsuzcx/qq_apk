import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.b;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;

public class aali
  implements DragFrameLayout.b
{
  public TabDragAnimationView a;
  private boolean aGT;
  public View zC;
  
  public aali(TabDragAnimationView paramTabDragAnimationView)
  {
    this.a = paramTabDragAnimationView;
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt, View paramView)
  {
    if ((this.a == null) || (this.zC == null) || (!this.zC.equals(paramView))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TabDragListener", 2, "drag detect x=" + paramFloat1 + ",y=" + paramFloat2 + ",dragType=" + paramInt);
      }
      if ((paramInt == 1) || (paramInt == 2))
      {
        if (!this.aGT) {
          this.a.stop();
        }
        this.aGT = true;
        this.a.f(paramFloat1, paramFloat2, false);
        return;
      }
    } while (!this.aGT);
    this.aGT = false;
    this.a.ejf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aali
 * JD-Core Version:    0.7.0.1
 */