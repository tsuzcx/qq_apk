package android.support.v7.app;

class ActionBarImplICS$OnMenuVisibilityListenerWrapper
  implements android.app.ActionBar.OnMenuVisibilityListener
{
  final ActionBar.OnMenuVisibilityListener mWrappedListener;
  
  public ActionBarImplICS$OnMenuVisibilityListenerWrapper(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    this.mWrappedListener = paramOnMenuVisibilityListener;
  }
  
  public void onMenuVisibilityChanged(boolean paramBoolean)
  {
    this.mWrappedListener.onMenuVisibilityChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarImplICS.OnMenuVisibilityListenerWrapper
 * JD-Core Version:    0.7.0.1
 */