package android.support.v7.app;

class ActionBarImplICS$OnNavigationListenerWrapper
  implements android.app.ActionBar.OnNavigationListener
{
  private final ActionBar.OnNavigationListener mWrappedListener;
  
  public ActionBarImplICS$OnNavigationListenerWrapper(ActionBar.OnNavigationListener paramOnNavigationListener)
  {
    this.mWrappedListener = paramOnNavigationListener;
  }
  
  public boolean onNavigationItemSelected(int paramInt, long paramLong)
  {
    return this.mWrappedListener.onNavigationItemSelected(paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarImplICS.OnNavigationListenerWrapper
 * JD-Core Version:    0.7.0.1
 */