import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.Constants.LogoutReason;

public abstract class acep
{
  public QQAppInterface app;
  private View contentView;
  public boolean isResume;
  private BaseActivity mActivity;
  protected List<augw> xt;
  
  public void E(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramBoolean) {
        paramView.setBackgroundResource(2130851106);
      }
    }
    else {
      return;
    }
    paramView.setBackgroundColor(getResources().getColor(2131167361));
  }
  
  public boolean PN()
  {
    return true;
  }
  
  protected boolean ZV()
  {
    return BaseApplicationImpl.getContext().doesHasSDCardPermission();
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return null;
  }
  
  public final BaseActivity a()
  {
    return this.mActivity;
  }
  
  protected void aXN() {}
  
  protected void bMe() {}
  
  protected void bMf() {}
  
  public void bMp() {}
  
  public void bRz()
  {
    if (this.contentView != null)
    {
      localObject = this.contentView.getAnimation();
      if (localObject != null) {
        ((Animation)localObject).setAnimationListener(null);
      }
      this.contentView.clearAnimation();
    }
    Object localObject = FrameHelperActivity.a(a());
    if (localObject != null) {
      ((FrameHelperActivity)localObject).cIB();
    }
  }
  
  public List<augw> cH()
  {
    return null;
  }
  
  protected void cIu()
  {
    CheckPermission.requestSDCardPermission(a(), new aceq(this));
  }
  
  public View findViewById(int paramInt)
  {
    return this.contentView.findViewById(paramInt);
  }
  
  public void finish()
  {
    this.mActivity.finish();
  }
  
  public Resources getResources()
  {
    return this.mActivity.getResources();
  }
  
  public String getString(int paramInt)
  {
    return this.mActivity.getString(paramInt);
  }
  
  public void onAccountChanged()
  {
    boolean bool2 = false;
    bMe();
    Object localObject = this.app;
    this.app = ((QQAppInterface)this.mActivity.getAppRuntime());
    QQAppInterface localQQAppInterface = this.app;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (localQQAppInterface != null) {
        if (TextUtils.equals(((QQAppInterface)localObject).getAccount(), localQQAppInterface.getAccount())) {
          break label108;
        }
      }
    }
    label108:
    for (bool1 = true; this.xt != null; bool1 = false)
    {
      localObject = this.xt.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((augw)((Iterator)localObject).next()).onAccountChanged(this.app);
      }
    }
    pE(bool1);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPressed()
  {
    if (FrameHelperActivity.ZW())
    {
      FrameHelperActivity.cuA();
      return true;
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate()
  {
    this.app = ((QQAppInterface)this.mActivity.getAppRuntime());
    Object localObject = cH();
    if (localObject != null)
    {
      this.xt = new ArrayList();
      this.xt.addAll((Collection)localObject);
      localObject = this.xt.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((augw)((Iterator)localObject).next()).create();
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.xt != null)
    {
      Iterator localIterator = this.xt.iterator();
      while (localIterator.hasNext()) {
        ((augw)localIterator.next()).destroy();
      }
    }
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void onPause()
  {
    this.isResume = false;
    if (Build.VERSION.SDK_INT >= 15)
    {
      UEC localUEC = UEC.a;
      if (localUEC != null) {
        localUEC.a(getClass().getSimpleName(), a(), true, this);
      }
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    this.isResume = true;
    if (Build.VERSION.SDK_INT >= 15)
    {
      UEC localUEC = UEC.a;
      if (localUEC != null) {
        localUEC.a(getClass().getSimpleName(), a(), false, this);
      }
    }
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    if (this.isResume) {
      onPause();
    }
  }
  
  public abstract void pE(boolean paramBoolean);
  
  public void runOnUiThread(Runnable paramRunnable)
  {
    this.mActivity.runOnUiThread(paramRunnable);
  }
  
  public void setActivity(BaseActivity paramBaseActivity)
  {
    this.mActivity = paramBaseActivity;
  }
  
  public void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public String setLastActivityName()
  {
    return null;
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.mActivity.startActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acep
 * JD-Core Version:    0.7.0.1
 */