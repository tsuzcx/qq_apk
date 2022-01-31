package android.support.v7.app;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.internal.widget.ActionBarView;

class ActionBarActivityDelegateBase$ActionBarDrawableToggleImpl
  implements ActionBarDrawerToggle.Delegate
{
  private ActionBarActivityDelegateBase$ActionBarDrawableToggleImpl(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase) {}
  
  public Drawable getThemeUpIndicator()
  {
    TypedArray localTypedArray = this.this$0.mActivity.obtainStyledAttributes(ActionBarActivityDelegateBase.access$200());
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }
  
  public void setActionBarDescription(int paramInt) {}
  
  public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if (ActionBarActivityDelegateBase.access$300(this.this$0) != null) {
      ActionBarActivityDelegateBase.access$300(this.this$0).setHomeAsUpIndicator(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.ActionBarDrawableToggleImpl
 * JD-Core Version:    0.7.0.1
 */