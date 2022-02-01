import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver.12;
import com.tencent.mobileqq.activity.main.MainAssistObserver.13;
import com.tencent.mobileqq.activity.main.MainAssistObserver.15;
import com.tencent.mobileqq.activity.main.MainAssistObserver.2;
import com.tencent.mobileqq.activity.main.MainAssistObserver.22;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class zju
{
  aqju Y = null;
  protected aqju Z;
  private achq jdField_a_of_type_Achq = new zko(this);
  private achv jdField_a_of_type_Achv = new zkt(this);
  private acyz jdField_a_of_type_Acyz = new zkr(this);
  private acza jdField_a_of_type_Acza = new zkq(this);
  private akll jdField_a_of_type_Akll = new zkd(this);
  private aklo jdField_a_of_type_Aklo = new zjv(this);
  public arhz a;
  public SplashActivity a;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  protected jqk a;
  private ysf.a jdField_a_of_type_Ysf$a = new zku(this);
  public zjt a;
  AtomicInteger aG = new AtomicInteger(0);
  public boolean aRg;
  protected Bundle al;
  private accz jdField_b_of_type_Accz = new zjw(this);
  acku jdField_b_of_type_Acku = new zki(this);
  private akln jdField_b_of_type_Akln = new zkp(this);
  protected Handler bJ;
  public volatile boolean brx;
  protected boolean bry;
  public boolean brz;
  accn cardObserver = new zke(this);
  public final int cdA = 0;
  public final int cdB = 1;
  public final int cdC = 3;
  public Handler ce = new zjz(this, Looper.getMainLooper());
  private afsr f = new zjx(this);
  private aklk g = new zks(this);
  protected String mAction;
  protected String mAppId;
  protected String mOpenId;
  protected Bundle mParams;
  ConcurrentLinkedQueue<Runnable> s = new ConcurrentLinkedQueue();
  protected aqju x;
  
  public zju(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_Jqk = new zkh(this);
    this.jdField_a_of_type_Zjt = new zjt(paramSplashActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private void V(Runnable paramRunnable)
  {
    this.s.offer(paramRunnable);
    runNext();
  }
  
  private aqju a(String paramString)
  {
    return aqha.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131691042), new zkl(this));
  }
  
  private aqju a(String paramString1, String paramString2)
  {
    return aqha.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(paramString1).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131720025), new zkn(this)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131720024) + paramString2, new zkm(this));
  }
  
  private void bD(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("thridparty_prepare_mini_app", false);
    boolean bool1 = paramBundle.getBoolean("pull_show_open_id_diff_main", false);
    String str1 = paramBundle.getString("mini_app_id", "");
    String str2 = paramBundle.getString("mini_app_path", "");
    String str3 = paramBundle.getString("mini_app_type", "release");
    boolean bool2 = paramBundle.getBoolean("pull_mini_app_not_privilege", false);
    boolean bool3 = paramBundle.getBoolean("pull_mini_app_not_privilege_not_bind", false);
    String str4 = paramBundle.getString("pull_mini_app_not_privilege_not_bind_app_name", "");
    paramBundle = paramBundle.getString("pull_mini_app_not_privilege_string", "");
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver", 2, "showAccountConfirm: shouldShowOpenIdDifferent is true");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_show_open_id_diff_main");
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("is_change_account", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("if_check_account_same", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("key_action", aceo.class.getSimpleName());
      bFG();
      return;
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_app_not_privilege");
      if (bool3) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_mini_app_not_privilege_not_bind");
      }
      for (this.Z = a(paramBundle, str4);; this.Z = a(paramBundle))
      {
        this.Z.show();
        return;
      }
    }
    aceo.l(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, str1, str2, str3);
  }
  
  private void bE(Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("pull_app_not_privilege", false);
    String str1 = paramBundle.getString("pull_app_not_privilege_string", "");
    boolean bool2 = paramBundle.getBoolean("pull_show_open_id_diff_main", false);
    paramBundle.getBoolean("pull_uin_not_exist", false);
    boolean bool3 = paramBundle.getBoolean("pull_add_friend_tip", false);
    String str2 = paramBundle.getString("uin", "");
    paramBundle.getString("openid", "");
    paramBundle.getString("appid", "");
    if (bool1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_app_not_privilege");
      this.Z = a(str1);
      this.Z.show();
    }
    do
    {
      return;
      if (bool2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("thridparty_pull_main");
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_show_open_id_diff_main");
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("is_change_account", true);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("if_check_account_same", true);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("key_action", ahhz.class.getSimpleName());
        bFG();
        return;
      }
    } while (!bool3);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_add_friend_tip");
    zw(str2);
  }
  
  private void bRy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.bRy();
  }
  
  private void bt(QQAppInterface paramQQAppInterface)
  {
    int i = ((akjp)paramQQAppInterface.getManager(160)).GR();
    String str = null;
    switch (i)
    {
    }
    for (;;)
    {
      if (str != null) {
        anot.a(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      str = "0X80073B0";
      continue;
      str = "0X80073B2";
      continue;
      str = "0X80073B6";
    }
  }
  
  private void runNext()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "runNext: mRunningTaskNum=" + this.aG.get() + ", queueSize=" + this.s.size());
    }
    if (this.aG.get() <= 3)
    {
      Runnable localRunnable = (Runnable)this.s.poll();
      if (localRunnable != null)
      {
        this.aG.incrementAndGet();
        ThreadManager.post(localRunnable, 10, null, false);
      }
    }
  }
  
  private void zw(String paramString)
  {
    aqha.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131701799), new Object[] { paramString })).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131692001), new zkk(this, paramString)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131691040), new zkj(this)).show();
  }
  
  public UpgradeDetailWrapper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper == null) {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = aqap.a().b();
    }
    return this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.a(paramInt, paramRedTypeInfo);
  }
  
  protected void bFE()
  {
    if (this.jdField_a_of_type_Arhz == null)
    {
      this.jdField_a_of_type_Arhz = new arhz(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getTitleBarHeight());
      this.jdField_a_of_type_Arhz.setMessage(acfp.m(2131707996));
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().a(this.mAppId);
    if (QLog.isColorLevel()) {
      QLog.i("MainAssistObserver", 2, "-->checkAccountDiff, mOpenid: " + this.mOpenId);
    }
    if (!TextUtils.isEmpty(this.mOpenId))
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((OpenID)localObject1).openID))) {
        break label185;
      }
      this.jdField_a_of_type_Arhz.setMessage(2131694339);
      this.jdField_a_of_type_Arhz.show();
      this.bJ = new Handler();
      this.bJ.postDelayed(new MainAssistObserver.22(this), 3000L);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().Eo(this.mAppId);
    }
    label185:
    do
    {
      return;
      if (!this.mOpenId.equals(((OpenID)localObject1).openID))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MainAssistObserver", 2, "-->checkAccountDiff, !mOpenId.equals(openId.openID) mOpenId =" + this.mOpenId + " openId.openID = " + ((OpenID)localObject1).openID);
        }
        bFG();
        return;
      }
    } while (this.brz);
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "-->checkAccountDiff, mOpenId.equals(openId.openID)  " + this.mOpenId);
    }
    if (BindGroupActivity.class.getSimpleName().equals(this.mAction))
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, BindGroupActivity.class);
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("skey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getCurrentAccountUin()));
      ((Intent)localObject1).putExtra("key_params", this.mParams);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject1);
    }
    for (;;)
    {
      this.brz = true;
      return;
      if (ChatSettingForTroop.class.getSimpleName().equals(this.mAction))
      {
        apuh.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.mParams, this.mParams.getInt("vistor_type", 1));
      }
      else if (AddFriendLogicActivity.class.getSimpleName().equals(this.mAction))
      {
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, AddFriendLogicActivity.class);
        ((Intent)localObject1).putExtras(this.mParams);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject1);
      }
      else
      {
        Object localObject2;
        if (ahhz.class.getSimpleName().equals(this.mAction))
        {
          localObject2 = (acff)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(51);
          localObject1 = this.mParams.getString("uin", "");
          if (((acff)localObject2).isFriend((String)localObject1))
          {
            if (this.mParams.getBoolean("thridparty_pull_aio", false))
            {
              localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, SplashActivity.class);
              ((Intent)localObject2).putExtras(this.mParams);
              ((Intent)localObject2).putExtra("thridparty_pull_aio", true);
              localObject1 = aqgv.s(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, (String)localObject1);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              localObject1 = wja.a((Intent)localObject2, new int[] { 2 });
              this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject1);
            }
          }
          else {
            zw((String)localObject1);
          }
        }
        else if (aceo.class.getSimpleName().equals(this.mAction))
        {
          localObject1 = this.mParams.getString("mini_app_id", "");
          localObject2 = this.mParams.getString("mini_app_path", "");
          String str = this.mParams.getString("mini_app_type", "release");
          aceo.l(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, (String)localObject1, (String)localObject2, str);
        }
      }
    }
  }
  
  protected void bFG()
  {
    if (this.x == null)
    {
      this.x = aqha.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230);
      this.x.setMessage(2131697425);
      this.x.setTitle(2131693317);
      this.x.setNegativeButton(2131721058, new zkf(this));
      this.x.setPositiveButton(2131697395, new zkg(this));
    }
    if (!this.x.isShowing()) {
      this.x.show();
    }
  }
  
  public void cC(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.bry = paramIntent.getBooleanExtra("if_check_account_same", false);
          this.mAction = paramIntent.getStringExtra("key_action");
        } while (TextUtils.isEmpty(this.mAction));
        this.mParams = paramIntent.getExtras();
      } while (this.mParams == null);
      this.mAppId = this.mParams.getString("appid");
      this.mOpenId = this.mParams.getString("openid");
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver", 2, "if Check =" + this.bry + " appid = " + this.mAppId + " openId= " + this.mOpenId);
      }
    } while (!this.bry);
    bFE();
  }
  
  public void cD(Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool2;
    do
    {
      do
      {
        return;
        this.al = paramIntent.getExtras();
      } while (this.al == null);
      boolean bool1 = this.al.getBoolean("thridparty_pull_main", false);
      bool2 = this.al.getBoolean("thridparty_prepare_mini_app", false);
      if (bool1)
      {
        bE(this.al);
        return;
      }
    } while (!bool2);
    bD(this.al);
  }
  
  public void clear()
  {
    this.aG.set(0);
    this.s.clear();
    this.jdField_a_of_type_Zjt.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
  }
  
  public void cpF()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {}
    while (this.brx) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_Aklo);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_b_of_type_Akln);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.g);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_b_of_type_Accz);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Achq);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Akll);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_Achv);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Acyz);
      VSNetworkHelper.a();
      ((ysf)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(34)).a(this.jdField_a_of_type_Ysf$a);
      ((jnp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getBusinessHandler(43)).ayy();
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.cardObserver);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Jqk);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_b_of_type_Acku);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.f);
      Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(162);
      ((KandianMergeManager)localObject).a(this.jdField_a_of_type_Acza);
      QLog.d("Q.readinjoy.4tab", 2, "register main assist call notify to update icon red point!");
      ((KandianMergeManager)localObject).aIM();
      localObject = (KandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(280);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(((KandianSubscribeManager)localObject).a());
      this.brx = true;
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localNullPointerException.printStackTrace();
      }
    }
  }
  
  public void cpG()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) || (!this.brx)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_b_of_type_Akln);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Achq);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Akll);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.g);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_b_of_type_Accz);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Acyz);
    ((ysf)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(34)).b(this.jdField_a_of_type_Ysf$a);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_b_of_type_Acku);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_Aklo);
    ((jnp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getBusinessHandler(43)).ayz();
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(162)).b(this.jdField_a_of_type_Acza);
    KandianSubscribeManager localKandianSubscribeManager = (KandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(280);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(localKandianSubscribeManager.a());
    this.brx = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.cardObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Jqk);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.f);
  }
  
  public void cpH()
  {
    try
    {
      ThreadManager.getSubThreadHandler().postDelayed(new MainAssistObserver.2(this), 500L);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MainAssistObserver", 4, "notifyWindowShowed e=" + localException);
    }
  }
  
  public void cpI()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    ThreadManager.post(new MainAssistObserver.12(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
  }
  
  public void cpJ()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    ThreadManager.post(new MainAssistObserver.13(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
  }
  
  public void cpK()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null))
    {
      QLog.d("Q.lebanew", 1, "updateTabLebaNotify but it's NewLeba!");
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "updateTabLebaNotify, curUin=" + str);
    }
    V(this.jdField_a_of_type_Zjt.a(new zjy(this)));
  }
  
  public void cpL()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    cpI();
    Object localObject = localQQAppInterface.b();
    ysf localysf = (ysf)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(34);
    if ((localObject != null) && (localysf != null)) {
      ThreadManager.post(new MainAssistObserver.15(this, localQQAppInterface, (QQMessageFacade)localObject), 8, null, false);
    }
    cpK();
    cpJ();
    localObject = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.getApp().sendBroadcast((Intent)localObject);
  }
  
  public void f(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.f(paramInt1, paramInt2, paramObject);
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "onAccountChanged, ");
    }
    this.aG.set(0);
    this.s.clear();
    anwa.init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zju
 * JD-Core Version:    0.7.0.1
 */