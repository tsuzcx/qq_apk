import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.qphone.base.util.QLog;

class wst
  implements View.OnLayoutChangeListener
{
  wst(wsr paramwsr, View paramView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt1 == paramInt5) && (paramInt2 == paramInt6) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8)) {
      return;
    }
    paramView = new int[2];
    paramInt1 = 0;
    if (this.wy != null)
    {
      this.wy.getLocationInWindow(paramView);
      paramInt1 = paramView[1] + this.wy.getHeight();
    }
    if (wsr.a(this.b) != null)
    {
      paramInt2 = wsr.a(this.b).getRight();
      label81:
      if (wsr.a(this.b) == null) {
        break label180;
      }
    }
    label180:
    for (paramInt3 = wsr.a(this.b).getHeight();; paramInt3 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatDrawer", 2, String.format("setTouchableBound, drawerWidth: %s, drawerHeight: %s, titleBarBottom: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) }));
      }
      if ((paramInt2 <= 0) || (paramInt3 <= 0) || (paramInt1 <= 0)) {
        break;
      }
      wsr.a(this.b).setTouchableBound(0, paramInt1, paramInt2, paramInt3);
      return;
      paramInt2 = 0;
      break label81;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wst
 * JD-Core Version:    0.7.0.1
 */