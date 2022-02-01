import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

public abstract class zer
{
  protected zgr b;
  protected FragmentActivity mActivity;
  protected View mRootView;
  protected String mUin;
  
  public zer(FragmentActivity paramFragmentActivity)
  {
    this.mActivity = paramFragmentActivity;
  }
  
  public void BB(boolean paramBoolean) {}
  
  protected View C(int paramInt)
  {
    return this.mRootView.findViewById(paramInt);
  }
  
  public void Fg(int paramInt) {}
  
  public BaseActivity a()
  {
    return this.mActivity;
  }
  
  public void a(zgr paramzgr)
  {
    this.b = paramzgr;
  }
  
  protected void aDZ()
  {
    this.mUin = this.mActivity.getIntent().getStringExtra("SissionUin");
  }
  
  public void coI() {}
  
  public FragmentManager getFragmentManager()
  {
    return this.mActivity.getSupportFragmentManager();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate()
  {
    this.mRootView = this.mActivity.findViewById(2131377546);
    aDZ();
  }
  
  public void onDestroy()
  {
    this.b = null;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public abstract int yh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zer
 * JD-Core Version:    0.7.0.1
 */