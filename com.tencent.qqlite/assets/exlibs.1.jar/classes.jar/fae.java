import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.ContextMenuTextView;
import com.tencent.widget.MenuPopupDialog;

public class fae
  implements View.OnLongClickListener, View.OnTouchListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  
  private fae(ContextMenuTextView paramContextMenuTextView) {}
  
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
    if ((ContextMenuTextView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView) != null) && (ContextMenuTextView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView).isShowing()))
    {
      a(paramView);
      return false;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131298963, ContextMenuTextView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView).getString(2131363575));
    ContextMenuTextView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView, MenuPopupDialog.a(paramView, ContextMenuTextView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView).getString(2131363287), localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.a, new fad(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fae
 * JD-Core Version:    0.7.0.1
 */