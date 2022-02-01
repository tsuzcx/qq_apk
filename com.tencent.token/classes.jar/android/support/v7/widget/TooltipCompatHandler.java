package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
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
  private final Runnable mHideRunnable = new Runnable()
  {
    public void run()
    {
      TooltipCompatHandler.this.hide();
    }
  };
  private TooltipPopup mPopup;
  private final Runnable mShowRunnable = new Runnable()
  {
    public void run()
    {
      TooltipCompatHandler.this.show(false);
    }
  };
  private final CharSequence mTooltipText;
  
  private TooltipCompatHandler(View paramView, CharSequence paramCharSequence)
  {
    this.mAnchor = paramView;
    this.mTooltipText = paramCharSequence;
    this.mAnchor.setOnLongClickListener(this);
    this.mAnchor.setOnHoverListener(this);
  }
  
  private void cancelPendingShow()
  {
    this.mAnchor.removeCallbacks(this.mShowRunnable);
  }
  
  private void hide()
  {
    if (sActiveHandler == this)
    {
      sActiveHandler = null;
      TooltipPopup localTooltipPopup = this.mPopup;
      if (localTooltipPopup != null)
      {
        localTooltipPopup.hide();
        this.mPopup = null;
        this.mAnchor.removeOnAttachStateChangeListener(this);
      }
      else
      {
        Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
      }
    }
    if (sPendingHandler == this) {
      setPendingHandler(null);
    }
    this.mAnchor.removeCallbacks(this.mHideRunnable);
  }
  
  private void scheduleShow()
  {
    this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
  }
  
  private static void setPendingHandler(TooltipCompatHandler paramTooltipCompatHandler)
  {
    TooltipCompatHandler localTooltipCompatHandler = sPendingHandler;
    if (localTooltipCompatHandler != null) {
      localTooltipCompatHandler.cancelPendingShow();
    }
    sPendingHandler = paramTooltipCompatHandler;
    paramTooltipCompatHandler = sPendingHandler;
    if (paramTooltipCompatHandler != null) {
      paramTooltipCompatHandler.scheduleShow();
    }
  }
  
  public static void setTooltipText(View paramView, CharSequence paramCharSequence)
  {
    TooltipCompatHandler localTooltipCompatHandler = sPendingHandler;
    if ((localTooltipCompatHandler != null) && (localTooltipCompatHandler.mAnchor == paramView)) {
      setPendingHandler(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramCharSequence = sActiveHandler;
      if ((paramCharSequence != null) && (paramCharSequence.mAnchor == paramView)) {
        paramCharSequence.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new TooltipCompatHandler(paramView, paramCharSequence);
  }
  
  private void show(boolean paramBoolean)
  {
    if (!ViewCompat.isAttachedToWindow(this.mAnchor)) {
      return;
    }
    setPendingHandler(null);
    TooltipCompatHandler localTooltipCompatHandler = sActiveHandler;
    if (localTooltipCompatHandler != null) {
      localTooltipCompatHandler.hide();
    }
    sActiveHandler = this;
    this.mFromTouch = paramBoolean;
    this.mPopup = new TooltipPopup(this.mAnchor.getContext());
    this.mPopup.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
    this.mAnchor.addOnAttachStateChangeListener(this);
    long l;
    if (this.mFromTouch) {
      l = 2500L;
    } else if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 0x1) == 1) {
      l = 3000L - ViewConfiguration.getLongPressTimeout();
    } else {
      l = 15000L - ViewConfiguration.getLongPressTimeout();
    }
    this.mAnchor.removeCallbacks(this.mHideRunnable);
    this.mAnchor.postDelayed(this.mHideRunnable, l);
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.mPopup != null) && (this.mFromTouch)) {
      return false;
    }
    paramView = (AccessibilityManager)this.mAnchor.getContext().getSystemService("accessibility");
    if ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled())) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 7)
    {
      if (i != 10) {
        return false;
      }
      hide();
      return false;
    }
    if ((this.mAnchor.isEnabled()) && (this.mPopup == null))
    {
      this.mAnchorX = ((int)paramMotionEvent.getX());
      this.mAnchorY = ((int)paramMotionEvent.getY());
      setPendingHandler(this);
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.TooltipCompatHandler
 * JD-Core Version:    0.7.0.1
 */