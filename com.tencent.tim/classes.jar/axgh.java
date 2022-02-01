import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;

public abstract class axgh
{
  private ViewStub O;
  protected axgi c;
  private volatile boolean dtn;
  protected Activity mActivity;
  protected View mRootView;
  
  @Deprecated
  public axgh(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    this.mActivity = paramActivity;
    this.mRootView = paramView;
    this.c = paramaxgi;
  }
  
  public axgh(Activity paramActivity, ViewStub paramViewStub, axgi paramaxgi)
  {
    this.O = paramViewStub;
    this.mActivity = paramActivity;
    this.c = paramaxgi;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    return null;
  }
  
  public boolean aOe()
  {
    return this.dtn;
  }
  
  protected final void eHc()
  {
    if (this.dtn) {
      return;
    }
    View localView = this.O.inflate();
    this.dtn = true;
    jm(localView);
  }
  
  protected abstract void initView();
  
  protected void jm(View paramView) {}
  
  public void onActivityPause() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResume() {}
  
  public void onActivityStart() {}
  
  public void onActivityStop() {}
  
  public void onDestroy() {}
  
  public void p(int paramInt, Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgh
 * JD-Core Version:    0.7.0.1
 */