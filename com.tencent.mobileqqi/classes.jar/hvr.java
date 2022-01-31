import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.widget.BubblePopupWindow;

public class hvr
  extends FrameLayout
{
  private static final String jdField_a_of_type_JavaLangString = "PopupWindow.PopupViewContainer";
  View jdField_a_of_type_AndroidViewView = null;
  
  public hvr(BubblePopupWindow paramBubblePopupWindow, Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(View paramView)
  {
    if (paramView.isPressed()) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        View localView = a(paramView.getChildAt(i));
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void a(View paramView1, View paramView2, Rect paramRect)
  {
    if (paramView1 == paramView2) {
      return;
    }
    paramRect.top += paramView1.getTop();
    paramRect.bottom += paramView1.getTop();
    paramRect.left += paramView1.getLeft();
    paramRect.right += paramView1.getLeft();
    a((View)paramView1.getParent(), paramView2, paramRect);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null) {
        bool = super.dispatchKeyEvent(paramKeyEvent);
      }
      KeyEvent.DispatcherState localDispatcherState;
      do
      {
        return bool;
        if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
          break;
        }
        localDispatcherState = getKeyDispatcherState();
      } while (localDispatcherState == null);
      localDispatcherState.startTracking(paramKeyEvent, this);
      return true;
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
          return true;
        }
      }
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = 0;
    int i = 0;
    if ((BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow) != null) && (BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).onTouch(this, paramMotionEvent))) {
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent = a(BubblePopupWindow.b(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow));
    if ((this.jdField_a_of_type_AndroidViewView == null) && (paramMotionEvent == null)) {}
    while (this.jdField_a_of_type_AndroidViewView == paramMotionEvent) {
      return bool;
    }
    this.jdField_a_of_type_AndroidViewView = paramMotionEvent;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.getDrawingRect(BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow));
      a(this.jdField_a_of_type_AndroidViewView, BubblePopupWindow.b(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow), BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow));
      if (BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).left != 0) {
        break label410;
      }
    }
    label410:
    for (int m = 1;; m = 0)
    {
      int j;
      if (BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).right == BubblePopupWindow.b(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).getWidth()) {
        j = BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).getWidth();
      }
      for (int n = 1;; n = 0)
      {
        if ((m == 0) || (n == 0))
        {
          this.jdField_a_of_type_AndroidViewView.getDrawingRect(BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow));
          a(this.jdField_a_of_type_AndroidViewView, BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow), BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow));
          if (m == 0) {
            i = BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).left;
          }
          k = i;
          if (n == 0)
          {
            j = BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).right;
            k = i;
          }
        }
        for (i = j;; i = j)
        {
          BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).a(k, i);
          BubblePopupWindow.b(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).a(k - BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).getLeft(), i - BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).getLeft());
          BubblePopupWindow.c(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).a(k - BubblePopupWindow.b(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).getLeft(), i - BubblePopupWindow.b(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).getLeft());
          for (;;)
          {
            BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).invalidate();
            break;
            BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).a(0, 0);
            BubblePopupWindow.b(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).a(0, 0);
            BubblePopupWindow.c(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).a(0, 0);
          }
        }
        j = 0;
      }
    }
  }
  
  @TargetApi(8)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (BubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow))
    {
      int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
      View.mergeDrawableStates(arrayOfInt, BubblePopupWindow.a());
      return arrayOfInt;
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= getWidth()) || (j < 0) || (j >= getHeight())))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (BubblePopupWindow.b(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow) != null)
    {
      BubblePopupWindow.b(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow).sendAccessibilityEvent(paramInt);
      return;
    }
    super.sendAccessibilityEvent(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hvr
 * JD-Core Version:    0.7.0.1
 */