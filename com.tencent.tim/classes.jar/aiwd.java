import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.a;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.a;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.d;
import com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;

public class aiwd
{
  public Conversation a;
  private LoginUserGuideHelper.a jdField_b_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$a;
  LoginWelcomeManager.d jdField_b_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$d = new aiwe(this);
  boolean cmj = true;
  ViewGroup ei;
  private ViewGroup mRootView;
  
  public aiwd(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.a = paramConversation;
    this.mRootView = paramViewGroup;
  }
  
  private boolean apP()
  {
    LoginWelcomeManager localLoginWelcomeManager = LoginWelcomeManager.a(this.a.app);
    return (localLoginWelcomeManager.cme) || (localLoginWelcomeManager.cmf);
  }
  
  private void b(LoginWelcomeManager.a parama)
  {
    if (!this.a.isForeground()) {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(parama.url)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "Bad url: " + parama.url);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "show common guide web");
    }
    Object localObject = BaseActivity.sTopActivity;
    Intent localIntent = new Intent((Context)localObject, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("url", parama.url);
    localIntent.putExtra("flag_show_loading_dialog", false);
    localIntent.putExtra("hide_left_button", true);
    localIntent.setData(Uri.parse(parama.url));
    ((Activity)localObject).startActivity(localIntent);
    localObject = LoginWelcomeManager.a(this.a.app);
    ((LoginWelcomeManager)localObject).cmf = false;
    ((LoginWelcomeManager)localObject).cmb = true;
    LoginWelcomeManager.C(this.a.app, parama.dfq);
  }
  
  private void dvc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("isFirstLoginEnter=%s, shouldCheckOnResume=%s", new Object[] { Boolean.valueOf(this.cmj), Boolean.valueOf(apP()) }));
    }
    if ((!this.cmj) && (apP())) {
      ThreadManagerV2.postImmediately(new LoginwelcomeHelper.2(this), null, true);
    }
    this.cmj = false;
  }
  
  private void eA(Context paramContext)
  {
    boolean bool2 = false;
    if ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        if (Build.VERSION.SDK_INT >= 23) {
          bool2 = true;
        }
        QLog.i("LoginUserGuideHelper", 2, String.format("requestLocation [%s, %s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (this.jdField_b_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$a == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$a = new LoginUserGuideHelper.a("Login.Guide");
        this.jdField_b_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$a.observerOnUiThread = true;
      }
      if (!bool1) {
        aczc.a(this.jdField_b_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$a);
      }
      return;
    }
  }
  
  private void r(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realShowContactsGuideLayer");
    }
    if (!this.a.isForeground()) {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
      }
    }
    do
    {
      return;
      if ((this.mRootView != null) && (this.mRootView.findViewById(2131365268) == null) && (paramURLDrawable != null) && (paramURLDrawable.getStatus() == 1) && (this.a.app != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "view repeat or mDragHost==null or drawable status wrong");
    return;
    if (this.ei == null)
    {
      this.ei = ((ViewGroup)LayoutInflater.from(this.mRootView.getContext()).inflate(2131559113, null));
      Object localObject1 = (ImageView)this.ei.findViewById(2131364701);
      ((ImageView)localObject1).setContentDescription(acfp.m(2131707958));
      ((ImageView)localObject1).setOnClickListener(new aiwf(this));
      localObject1 = this.a.a();
      Object localObject2 = (Button)this.ei.findViewById(2131367100);
      ((Button)localObject2).setContentDescription(this.a.a().getString(2131700853));
      ((Button)localObject2).setOnClickListener(new aiwg(this, (Activity)localObject1));
      localObject2 = (TextView)this.ei.findViewById(2131366017);
      ((TextView)localObject2).setContentDescription(((Activity)localObject1).getString(2131700852));
      ((TextView)localObject2).setOnClickListener(new aiwh(this, (Activity)localObject1));
      localObject1 = (ThemeImageView)this.ei.findViewById(2131365361);
      ((ThemeImageView)localObject1).setMaskShape(auvj.euL);
      ((ThemeImageView)localObject1).setImageDrawable(paramURLDrawable);
    }
    this.mRootView.removeView(this.ei);
    this.mRootView.addView(this.ei);
    LoginWelcomeManager.de(this.a.app);
    paramURLDrawable = LoginWelcomeManager.a(this.a.app);
    paramURLDrawable.cme = false;
    paramURLDrawable.cmb = true;
    eA(this.mRootView.getContext());
  }
  
  public void addObserver()
  {
    if (this.a.app != null) {
      ((LoginWelcomeManager)this.a.app.getManager(146)).a(this.jdField_b_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$d);
    }
  }
  
  public void bMe()
  {
    dvd();
    bpN();
    this.cmj = true;
  }
  
  public void bpN()
  {
    if (this.a.app != null) {
      ((LoginWelcomeManager)this.a.app.getManager(146)).a(null);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$a != null)
    {
      aczc.b(this.jdField_b_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$a);
      this.jdField_b_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$a = null;
    }
  }
  
  public void dvd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "removeContactsGuidelayer");
    }
    if ((this.mRootView != null) && (this.ei != null)) {
      this.mRootView.removeView(this.ei);
    }
    this.ei = null;
  }
  
  public void onDestroy()
  {
    dvd();
    bpN();
  }
  
  public void onResume()
  {
    dvc();
  }
  
  public void onStop()
  {
    LoginWelcomeManager.df(this.a.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwd
 * JD-Core Version:    0.7.0.1
 */