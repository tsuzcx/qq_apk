import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.app.BaseActivity;

public class kgu
  extends kfr
{
  private ReadInJoyBaseListViewGroup a;
  private ViewGroup aM;
  protected lce mObserver = new kgv(this);
  
  public kgu(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void O(boolean paramBoolean, int paramInt)
  {
    super.O(paramBoolean, paramInt);
    this.a.lP(paramBoolean);
  }
  
  public void aBY()
  {
    super.aBY();
    if (this.a != null)
    {
      this.a.a(null, null);
      this.a.H(null);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      this.aM.addView(this.a, localLayoutParams);
    }
  }
  
  public void aBZ()
  {
    super.aBZ();
    if (this.a != null)
    {
      this.a.a(null, false);
      this.aM.removeView(this.a);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (((this.activity instanceof ReadInJoyFeedsActivity)) && (((ReadInJoyFeedsActivity)this.activity).nk() == 1)) {
      oan.a().aq(((BaseActivity)getActivity()).app);
    }
  }
  
  public void i(ViewGroup paramViewGroup)
  {
    super.i(paramViewGroup);
    this.aM = paramViewGroup;
  }
  
  public ViewGroup j()
  {
    return this.aM;
  }
  
  public void lP(boolean paramBoolean)
  {
    super.lP(paramBoolean);
    this.a.lP(paramBoolean);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    aBY();
    lbz.a().aJk();
    lcc.a().b(this.mObserver);
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.mObserver);
    super.onDestroy();
    this.a.a(null, false);
    this.a.G(null);
    this.a.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.a.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    lbz.a().aJk();
    this.a.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgu
 * JD-Core Version:    0.7.0.1
 */