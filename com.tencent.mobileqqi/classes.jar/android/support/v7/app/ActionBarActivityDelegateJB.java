package android.support.v7.app;

class ActionBarActivityDelegateJB
  extends ActionBarActivityDelegateICS
{
  ActionBarActivityDelegateJB(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  public ActionBar createSupportActionBar()
  {
    return new ActionBarImplJB(this.mActivity, this.mActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateJB
 * JD-Core Version:    0.7.0.1
 */