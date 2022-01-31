import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.ContextMenuTextView;
import com.tencent.widget.BubblePopupWindow;

public class hkj
  implements View.OnLongClickListener, View.OnTouchListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  
  private hkj(ContextMenuTextView paramContextMenuTextView) {}
  
  protected void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.setBackgroundColor(-1);
  }
  
  public boolean onLongClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.setBackgroundColor(-7829368);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g()))
    {
      a(paramView);
      return false;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131234877, ContextMenuTextView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView).getString(2131561879));
    ContextMenuTextView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView, BubbleContextMenu.a(paramView, localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.jdField_a_of_type_AndroidViewView$OnClickListener, null));
    a(paramView);
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hkj
 * JD-Core Version:    0.7.0.1
 */