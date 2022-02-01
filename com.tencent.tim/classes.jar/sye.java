import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.ViewGroup;

public abstract class sye
{
  protected sxz a;
  private Handler mHandler = new Handler();
  ViewGroup rootView;
  
  public void aA(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void aB(boolean paramBoolean1, boolean paramBoolean2) {}
  
  void b(sxz paramsxz)
  {
    this.a = paramsxz;
  }
  
  public void bBV()
  {
    if (this.a != null) {
      this.a.bBV();
    }
  }
  
  public boolean back()
  {
    return false;
  }
  
  public ViewGroup getRootView()
  {
    return this.rootView;
  }
  
  public void notifyDataSetChanged() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onDestroy() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void setRootView(ViewGroup paramViewGroup)
  {
    this.rootView = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sye
 * JD-Core Version:    0.7.0.1
 */