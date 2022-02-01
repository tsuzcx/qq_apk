import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ajjh
  extends ajjl
{
  private wll a;
  boolean uA = false;
  
  public ajjh(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void Ra(int paramInt)
  {
    super.Ra(paramInt);
    if (this.a == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.a.yz(true);
      this.a.yy(true);
      this.a.bZg();
      this.a.setCurrentShowType(3);
      return;
    }
    this.a.yy(false);
    this.a.yz(false);
    this.a.setCurrentShowType(4);
  }
  
  public void a(ajjf paramajjf)
  {
    super.a(paramajjf);
    if (this.a != null)
    {
      if (getMode() != 0) {
        this.a.yy(false);
      }
      this.a.a(a(), nD());
      this.a.bZe();
    }
  }
  
  public void bZt()
  {
    super.bZt();
    if (this.a != null) {
      this.a.bZt();
    }
  }
  
  public void bZu()
  {
    super.bZu();
    if (this.a != null) {
      this.a.bZu();
    }
  }
  
  public void cqr() {}
  
  public void cqt() {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (this.a == null)
    {
      paramBundle = null;
      Bundle localBundle = o();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.a = new wll(this.mApp, this.mActivity, this.mContext, paramBundle);
      this.a.a(this);
      setMode(1);
      hg(this.a.getRootView());
    }
    hh(this.a.getRootView());
    if (a() != null) {
      this.a.a(a(), nD());
    }
    if (this.uA) {
      this.a.onResumed();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.a == null) {
      return;
    }
    this.a.onDestroy();
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.uA = false;
    if (this.a == null) {
      return;
    }
    this.a.onPaused();
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnResume() called");
    }
    this.uA = true;
    if (this.a == null) {
      return;
    }
    if (getMode() == 0)
    {
      this.a.yy(true);
      this.a.bZg();
    }
    for (;;)
    {
      this.a.bZo();
      this.a.onResumed();
      return;
      this.a.yy(false);
    }
  }
  
  public void doOnStart()
  {
    if (this.a == null) {
      return;
    }
    this.a.yx(true);
    this.a.bZe();
  }
  
  public void doOnStop() {}
  
  public void unInit()
  {
    super.unInit();
    if (this.a != null)
    {
      this.a.a(null);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjh
 * JD-Core Version:    0.7.0.1
 */