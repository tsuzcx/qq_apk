package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TooltipCompatHandler
  implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener
{
  private static final long HOVER_HIDE_TIMEOUT_MS = 15000L;
  private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000L;
  private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500L;
  private static final String TAG = "TooltipCompatHandler";
  private static TooltipCompatHandler sActiveHandler;
  private static TooltipCompatHandler sPendingHandler;
  private final View mAnchor;
  private int mAnchorX;
  private int mAnchorY;
  private boolean mFromTouch;
  private final Runnable mHideRunnable = new TooltipCompatHandler.2(this);
  private final int mHoverSlop;
  private TooltipPopup mPopup;
  private final Runnable mShowRunnable = new TooltipCompatHandler.1(this);
  private final CharSequence mTooltipText;
  
  private TooltipCompatHandler(View paramView, CharSequence paramCharSequence)
  {
    this.mAnchor = paramView;
    this.mTooltipText = paramCharSequence;
    this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(this.mAnchor.getContext()));
    clearAnchorPos();
    this.mAnchor.setOnLongClickListener(this);
    this.mAnchor.setOnHoverListener(this);
  }
  
  private void cancelPendingShow()
  {
    this.mAnchor.removeCallbacks(this.mShowRunnable);
  }
  
  private void clearAnchorPos()
  {
    this.mAnchorX = 2147483647;
    this.mAnchorY = 2147483647;
  }
  
  private void scheduleShow()
  {
    this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
  }
  
  private static void setPendingHandler(TooltipCompatHandler paramTooltipCompatHandler)
  {
    if (sPendingHandler != null) {
      sPendingHandler.cancelPendingShow();
    }
    sPendingHandler = paramTooltipCompatHandler;
    if (sPendingHandler != null) {
      sPendingHandler.scheduleShow();
    }
  }
  
  public static void setTooltipText(View paramView, CharSequence paramCharSequence)
  {
    if ((sPendingHandler != null) && (sPendingHandler.mAnchor == paramView)) {
      setPendingHandler(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((sActiveHandler != null) && (sActiveHandler.mAnchor == paramView)) {
        sActiveHandler.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new TooltipCompatHandler(paramView, paramCharSequence);
  }
  
  private boolean updateAnchorPos(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((Math.abs(i - this.mAnchorX) <= this.mHoverSlop) && (Math.abs(j - this.mAnchorY) <= this.mHoverSlop)) {
      return false;
    }
    this.mAnchorX = i;
    this.mAnchorY = j;
    return true;
  }
  
  void hide()
  {
    if (sActiveHandler == this)
    {
      sActiveHandler = null;
      if (this.mPopup == null) {
        break label66;
      }
      this.mPopup.hide();
      this.mPopup = null;
      clearAnchorPos();
      this.mAnchor.removeOnAttachStateChangeListener(this);
    }
    for (;;)
    {
      if (sPendingHandler == this) {
        setPendingHandler(null);
      }
      this.mAnchor.removeCallbacks(this.mHideRunnable);
      return;
      label66:
      Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
    }
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.mPopup != null) && (this.mFromTouch)) {}
    do
    {
      do
      {
        return false;
        paramView = (AccessibilityManager)this.mAnchor.getContext().getSystemService("accessibility");
      } while ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled()));
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      case 9: 
      default: 
        return false;
      }
    } while ((!this.mAnchor.isEnabled()) || (this.mPopup != null) || (!updateAnchorPos(paramMotionEvent)));
    setPendingHandler(this);
    return false;
    clearAnchorPos();
    hide();
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    this.mAnchorX = (paramView.getWidth() / 2);
    this.mAnchorY = (paramView.getHeight() / 2);
    show(true);
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    hide();
  }
  
  void show(boolean paramBoolean)
  {
    if (!ViewCompat.isAttachedToWindow(this.mAnchor)) {
      return;
    }
    setPendingHandler(null);
    if (sActiveHandler != null) {
      sActiveHandler.hide();
    }
    sActiveHandler = this;
    this.mFromTouch = paramBoolean;
    this.mPopup = new TooltipPopup(this.mAnchor.getContext());
    this.mPopup.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
    this.mAnchor.addOnAttachStateChangeListener(this);
    long l;
    if (this.mFromTouch) {
      l = 2500L;
    }
    for (;;)
    {
      this.mAnchor.removeCallbacks(this.mHideRunnable);
      this.mAnchor.postDelayed(this.mHideRunnable, l);
      return;
      if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 0x1) == 1) {
        l = 3000L - ViewConfiguration.getLongPressTimeout();
      } else {
        l = 15000L - ViewConfiguration.getLongPressTimeout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.TooltipCompatHandler
 * JD-Core Version:    0.7.0.1
 */