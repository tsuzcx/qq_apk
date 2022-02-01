import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.onlinestatus.AccountPanel.10;
import com.tencent.mobileqq.onlinestatus.AccountPanel.2;
import com.tencent.mobileqq.onlinestatus.AccountPanel.3;
import com.tencent.mobileqq.onlinestatus.AccountPanel.4;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter.a;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class akrv
  extends ReportDialog
  implements View.OnClickListener, OnlineStatusPagerAdapter.a
{
  private ImageView BY;
  private View FA;
  private TextView WG;
  private acfd jdField_a_of_type_Acfd = new akry(this);
  private acmf jdField_a_of_type_Acmf = new akrz(this);
  private akrv.b jdField_a_of_type_Akrv$b;
  private akrv.c jdField_a_of_type_Akrv$c;
  private akth jdField_a_of_type_Akth = new aksb(this);
  private aktr jdField_a_of_type_Aktr = new akse(this);
  private akua jdField_a_of_type_Akua;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aksd(this);
  private long ael;
  private long aem = -1L;
  private aqju az;
  private achq jdField_b_of_type_Achq = new aksa(this);
  private AppRuntime.Status jdField_b_of_type_MqqAppAppRuntime$Status;
  private String bUg;
  private boolean cur;
  private boolean cus = true;
  private SimpleAccount e;
  private RelativeLayout el;
  private Observer f = new aksc(this);
  private View.OnClickListener fA = new aksk(this);
  private LinearLayout fP;
  public arhz g;
  private LinearLayout jO;
  private BaseActivity mActivity;
  private QQAppInterface mApp;
  private View mContainerView;
  private boolean mDismissFinish;
  private boolean mIsFirstRequest;
  private LayoutInflater mLayoutInflater;
  private int mRequestNum;
  private RelativeLayout mRootView;
  public Handler mSubHandler;
  
  public akrv(@NonNull BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity, 2131755428);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      getWindow().addFlags(67108864);
    }
    ImmersiveUtils.clearCoverForStatus(getWindow(), true);
    this.mActivity = paramBaseActivity;
    this.mApp = this.mActivity.app;
    this.mLayoutInflater = LayoutInflater.from(this.mActivity);
    this.mRootView = ((RelativeLayout)this.mLayoutInflater.inflate(2131558453, null));
    this.mContainerView = this.mRootView.findViewById(2131365357);
    this.el = ((RelativeLayout)this.mRootView.findViewById(2131365396));
    this.fP = ((LinearLayout)this.mRootView.findViewById(2131361915));
    this.jO = ((LinearLayout)this.mRootView.findViewById(2131372642));
    this.WG = ((TextView)this.mRootView.findViewById(2131361945));
    this.BY = ((ImageView)this.mRootView.findViewById(2131369737));
    this.FA = this.mRootView.findViewById(2131365565);
    this.FA.setVisibility(8);
    this.mRootView.setOnClickListener(this);
    this.BY.setOnClickListener(this);
    this.el.setOnClickListener(null);
    setContentView(this.mRootView);
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.mApp.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.mApp.addObserver(this.jdField_a_of_type_Aktr);
  }
  
  private void Ng(boolean paramBoolean)
  {
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
      this.mApp.removeObserver(this.jdField_a_of_type_Acmf);
      this.mApp.removeObserver(this.jdField_b_of_type_Achq);
      this.mApp.unRegistObserver(this.jdField_a_of_type_Akth);
      if (paramBoolean)
      {
        this.mApp.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.mApp.removeObserver(this.jdField_a_of_type_Aktr);
      }
      if (this.mApp.b() != null) {
        this.mApp.b().deleteObserver(this.f);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "removeObservers");
      }
    }
  }
  
  private akrv.a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i;
    View localView;
    if ((this.fP != null) && (this.fP.getChildCount() > 0))
    {
      int j = this.fP.getChildCount();
      i = 0;
      if (i < j)
      {
        localView = this.fP.getChildAt(i);
        if (!paramString.equals((String)localView.getTag(2131361946))) {}
      }
    }
    for (paramString = localView;; paramString = null)
    {
      if (paramString != null) {}
      for (paramString = (akrv.a)paramString.getTag();; paramString = null)
      {
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  private View a(SubAccountInfo paramSubAccountInfo)
  {
    View localView = this.mLayoutInflater.inflate(2131558454, null);
    akrv.a locala = new akrv.a(localView, 2);
    locala.setIcon(aqdj.a(this.mApp, 1, paramSubAccountInfo.subuin));
    locala.setText(aqgv.b(this.mApp, paramSubAccountInfo.subuin, false));
    anxk.b localb = anxk.a(this.mApp, paramSubAccountInfo.subuin);
    if ((localb.unReadCount > 0) && (paramSubAccountInfo.status == 1))
    {
      locala.bI(localb.unReadCount, localb.showRedDot);
      locala.Nh(true);
      if (paramSubAccountInfo.status == 1) {
        break label151;
      }
      locala.Ni(true);
    }
    for (;;)
    {
      localView.setTag(2131361946, paramSubAccountInfo.subuin);
      localView.setTag(2131361913, paramSubAccountInfo);
      localView.setTag(locala);
      return localView;
      locala.bI(0, false);
      break;
      label151:
      locala.Ni(false);
    }
  }
  
  private View a(SimpleAccount paramSimpleAccount)
  {
    View localView = this.mLayoutInflater.inflate(2131558454, null);
    akrv.a locala = new akrv.a(localView, 1);
    locala.setIcon(aqdj.a(this.mApp, 1, paramSimpleAccount.getUin()));
    locala.setText(anxk.a(this.mApp, paramSimpleAccount));
    locala.bI(anxk.l(this.mApp, paramSimpleAccount.getUin()), false);
    locala.Nh(false);
    locala.Ni(false);
    localView.setTag(2131361946, paramSimpleAccount.getUin());
    localView.setTag(2131361913, paramSimpleAccount);
    localView.setTag(locala);
    return localView;
  }
  
  private boolean a(boolean paramBoolean, String paramString, anxt paramanxt)
  {
    if ((this.mActivity == null) || (this.mActivity.isFinishing()) || (this.mApp == null) || (paramanxt == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, mainAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return true;
    }
    if (!TextUtils.equals(paramString, this.mApp.getCurrentAccountUin()))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, mainAccount: %s not equal", new Object[] { paramString }));
      return true;
    }
    return false;
  }
  
  private void b(AppRuntime.Status paramStatus, long paramLong)
  {
    if (paramStatus != null)
    {
      this.jdField_b_of_type_MqqAppAppRuntime$Status = paramStatus;
      this.ael = paramLong;
      this.mApp.a(paramStatus, paramLong);
      if (this.jdField_a_of_type_Akrv$c != null) {
        this.jdField_a_of_type_Akrv$c.a(paramStatus);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("switchOnlineStatus %s", new Object[] { paramStatus }));
    }
  }
  
  private boolean b(akto paramakto, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_b_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      if (this.ael != paramakto.id) {}
    }
    while (this.jdField_b_of_type_MqqAppAppRuntime$Status == paramStatus)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean b(String paramString, anxs paramanxs)
  {
    return (this.mActivity == null) || (this.mActivity.isFinishing()) || (this.mApp == null) || (paramanxs == null) || (TextUtils.isEmpty(paramString));
  }
  
  private void bpM()
  {
    if (this.mApp != null)
    {
      this.mApp.addObserver(this.jdField_a_of_type_Acfd);
      this.mApp.addObserver(this.jdField_a_of_type_Acmf);
      this.mApp.addObserver(this.jdField_b_of_type_Achq);
      this.mApp.registObserver(this.jdField_a_of_type_Akth);
      if (this.mApp.b() != null) {
        this.mApp.b().addObserver(this.f);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "addObservers");
      }
    }
  }
  
  private void c(AppRuntime.Status paramStatus, long paramLong)
  {
    if ((this.az != null) && (this.az.isShowing()))
    {
      this.az.dismiss();
      this.az = null;
    }
    Object localObject1 = akti.a().a(paramLong, paramStatus);
    localObject1 = this.mActivity.getResources().getString(2131700582, new Object[] { localObject1 });
    String str = ((aktg)this.mApp.getManager(319)).a().mRawText;
    Object localObject2 = new Paint();
    ((Paint)localObject2).setTextSize(aqnm.spToPx(14.0F));
    int i;
    if ((paramLong == 1000L) || (paramLong == 1028L))
    {
      if (paramLong == 1000L) {}
      for (i = 2131700579;; i = 2131700575)
      {
        str = this.mActivity.getResources().getString(i);
        this.az = aqha.a(this.mActivity, 230).setTitle((String)localObject1).setMessageWithoutAutoLink(new aofk(str, 3, 16)).setMessageMaxLine(4);
        if (!this.mActivity.isFinishing()) {
          this.az.show();
        }
        this.az.setPositiveButton(2131700580, new aksi(this, paramLong, paramStatus));
        this.az.setNegativeButton(2131700570, new aksj(this));
        this.az.setCancelable(false);
        this.az.show();
        return;
      }
    }
    if (paramLong == -1L)
    {
      localObject1 = ((aktw)this.mApp.getManager(370)).a(-1L, false);
      if (localObject1 != null) {}
      for (localObject1 = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(-1L, ((OnlineStatusPermissionEntity)localObject1).allHasPermission, ((OnlineStatusPermissionEntity)localObject1).hasPermissionList);; localObject1 = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(-1L, true, null))
      {
        this.az = OnlineStatusPermissionChecker.a(this.mApp, this.mActivity, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject1);
        break;
      }
    }
    int j;
    if (paramStatus == AppRuntime.Status.dnd)
    {
      j = 2131700572;
      i = 4;
    }
    for (;;)
    {
      Object localObject3 = this.mActivity.getResources().getString(j);
      str = aofy.a(str, (Paint)localObject2, 3, 16, (int)(wja.dp2px(i * 242, this.mActivity.getResources()) - ((Paint)localObject2).measureText((String)localObject3)), true);
      str = AutoReplyText.trimRawString(this.mActivity.getResources().getString(j, new Object[] { str }), true);
      localObject2 = new SpannableString(str);
      localObject3 = new aksg(this, paramStatus, paramLong);
      ((SpannableString)localObject2).setSpan(localObject3, str.length() - 7, str.length(), 33);
      this.az = aqha.a(this.mActivity, 230).setTitle((String)localObject1).setMessageWithoutAutoLink(new aofk((CharSequence)localObject2, 3, 16)).setMessageMaxLine(i);
      if (!AppSetting.enableTalkBack) {
        break;
      }
      this.az.getMessageTextView().setAccessibilityDelegate(new aksh(this, (ClickableSpan)localObject3));
      break;
      i = 3;
      j = 2131700581;
    }
  }
  
  private View cn()
  {
    View localView = this.mLayoutInflater.inflate(2131558454, null);
    akrv.a locala = new akrv.a(localView, 0);
    locala.setIcon(this.mActivity.getResources().getDrawable(2130837613));
    locala.setText(this.mActivity.getResources().getText(2131700549));
    locala.setTextColor(this.mActivity.getResources().getColor(2131167273));
    localView.setTag(locala);
    return localView;
  }
  
  private void dDm()
  {
    this.fP.removeAllViews();
    Object localObject1 = ((anxr)this.mApp.getManager(61)).dL();
    Object localObject2 = new ArrayList();
    Object localObject5;
    Object localObject6;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SubAccountInfo)((Iterator)localObject3).next();
        if ((localObject4 != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject4).subuin)))
        {
          localObject5 = a((SubAccountInfo)localObject4);
          ((View)localObject5).setOnClickListener(this.fA);
          ((View)localObject5).setOnTouchListener(new jll.a());
          localObject6 = new LinearLayout.LayoutParams(aqnm.dip2px(68.0F), -2);
          this.fP.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
          ((List)localObject2).add(((SubAccountInfo)localObject4).subuin);
          if (QLog.isColorLevel()) {
            QLog.d("AccountPanel", 2, String.format("prepareContentViews, add sub account uin: %s", new Object[] { ((SubAccountInfo)localObject4).subuin }));
          }
        }
      }
    }
    Object localObject4 = this.mApp.getApplication().getAllAccounts();
    Object localObject3 = new ArrayList();
    if (localObject4 != null) {
      ((List)localObject3).addAll((Collection)localObject4);
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject4 = ((List)localObject3).iterator();
      localObject5 = this.mApp.getCurrentUin();
    }
    label642:
    label658:
    for (;;)
    {
      label296:
      int i;
      label315:
      int j;
      if (((Iterator)localObject4).hasNext())
      {
        if (this.fP.getChildCount() >= 7) {
          QLog.d("AccountPanel", 1, "add account exceed the limit");
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          if (localObject3 == null) {
            break label632;
          }
          i = ((List)localObject3).size();
          if (localObject1 == null) {
            break label637;
          }
          j = ((List)localObject1).size();
          label326:
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, account size: %s, sub account size: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        }
        if (this.fP.getChildCount() <= 0) {
          break label642;
        }
        this.WG.setText(2131700567);
        label377:
        if (this.fP.getChildCount() < 7)
        {
          localObject1 = cn();
          ((View)localObject1).setOnTouchListener(new jll.a());
          localObject2 = new LinearLayout.LayoutParams(aqnm.dip2px(68.0F), -2);
          this.fP.addView((View)localObject1, 0, (ViewGroup.LayoutParams)localObject2);
          ((View)localObject1).setOnClickListener(this.fA);
        }
        return;
      }
      localObject6 = (SimpleAccount)((Iterator)localObject4).next();
      if ((!TextUtils.isEmpty(((SimpleAccount)localObject6).getUin())) && (!((SimpleAccount)localObject6).getUin().equals(localObject5)))
      {
        Object localObject7 = ((List)localObject2).iterator();
        Object localObject8;
        do
        {
          if (!((Iterator)localObject7).hasNext()) {
            break;
          }
          localObject8 = (String)((Iterator)localObject7).next();
        } while (!((SimpleAccount)localObject6).getUin().equals(localObject8));
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label658;
          }
          localObject7 = a((SimpleAccount)localObject6);
          ((View)localObject7).setOnClickListener(this.fA);
          ((View)localObject7).setOnTouchListener(new jll.a());
          localObject8 = new LinearLayout.LayoutParams(aqnm.dip2px(68.0F), -2);
          this.fP.addView((View)localObject7, (ViewGroup.LayoutParams)localObject8);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, add account uin: %s", new Object[] { ((SimpleAccount)localObject6).getUin() }));
          break;
          QLog.d("AccountPanel", 1, "localAccountList is empty");
          break label296;
          label632:
          i = 0;
          break label315;
          label637:
          j = 0;
          break label326;
          this.WG.setText(2131700568);
          break label377;
        }
      }
    }
  }
  
  private int getRequestNum()
  {
    int j = ((anxr)this.mApp.getManager(61)).dL().size();
    List localList = this.mApp.getApplication().getAllAccounts();
    int i = j;
    if (localList != null)
    {
      i = j;
      if (localList.size() > 0) {
        i = j + 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "getRequestNum: " + i);
    }
    return i;
  }
  
  private void prepareContentViews()
  {
    dDm();
    if (this.jdField_a_of_type_Akua == null)
    {
      this.jdField_a_of_type_Akua = new akua(this.mActivity, this.jO, this, 5);
      this.jdField_a_of_type_Akua.dDv();
    }
    for (;;)
    {
      this.jdField_b_of_type_MqqAppAppRuntime$Status = this.mApp.getOnlineStatus();
      this.ael = akti.a().k(this.mApp);
      this.jdField_a_of_type_Akua.d(this.jdField_b_of_type_MqqAppAppRuntime$Status, this.ael);
      return;
      this.jdField_a_of_type_Akua.dDw();
    }
  }
  
  public void a(akrv.b paramb)
  {
    this.jdField_a_of_type_Akrv$b = paramb;
  }
  
  public void a(akrv.c paramc)
  {
    this.jdField_a_of_type_Akrv$c = paramc;
  }
  
  public void a(akto paramakto1, akto paramakto2)
  {
    if (!aqiw.isNetworkAvailable(this.mActivity))
    {
      QQToast.a(this.mActivity, 1, 2131720447, 1).show();
      if (this.jdField_a_of_type_Akua != null) {
        this.jdField_a_of_type_Akua.d(this.jdField_b_of_type_MqqAppAppRuntime$Status, this.ael);
      }
    }
    for (;;)
    {
      return;
      AppRuntime.Status localStatus = akti.a().a(paramakto2);
      paramakto1 = akti.a().a(paramakto1);
      if ((localStatus != null) && (paramakto2 != null) && (!b(paramakto2, localStatus)))
      {
        aktm.b(this.mApp, localStatus, paramakto2.id);
        nN(true);
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("online_battery", 0);
        boolean bool = localSharedPreferences.getBoolean("has_set_battery", false);
        if ((akti.a().a(paramakto2)) && (!bool))
        {
          localSharedPreferences.edit().putBoolean("has_set_battery", true).apply();
          c(localStatus, paramakto2.id);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", new Object[] { paramakto1, localStatus, Long.valueOf(paramakto2.id) }));
          return;
          if (aktk.a(localStatus))
          {
            c(localStatus, paramakto2.id);
          }
          else if ((paramakto2.id == 1028L) && (!akum.asL()))
          {
            akum.dDy();
            c(localStatus, paramakto2.id);
          }
          else if (paramakto2.id == -1L)
          {
            if (Build.VERSION.SDK_INT >= 23)
            {
              this.mActivity.requestPermissions(new akrw(this, localStatus, paramakto2), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
            }
            else
            {
              ((aktp)this.mApp.getManager(369)).Sm(5);
              c(localStatus, paramakto2.id);
            }
          }
          else
          {
            b(localStatus, paramakto2.id);
          }
        }
      }
    }
  }
  
  public void a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    anxk.b localb = anxk.a(paramQQAppInterface, paramSimpleAccount.getUin());
    if ((localb.unReadCount <= 0) || (localb.showRedDot)) {
      d(paramSimpleAccount);
    }
    for (;;)
    {
      if (localb.unReadCount > 0) {
        ThreadManagerV2.executeOnSubThread(new AccountPanel.10(this, paramQQAppInterface, paramSimpleAccount));
      }
      return;
      this.e = paramSimpleAccount;
    }
  }
  
  public boolean a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    if ((paramSimpleAccount != null) && (anxk.a(paramQQAppInterface, paramSimpleAccount)))
    {
      d(paramSimpleAccount);
      return true;
    }
    return false;
  }
  
  public void atg()
  {
    if (this.g == null)
    {
      this.g = new arhz(this.mActivity, this.mActivity.getTitleBarHeight());
      this.g.setBackAndSearchFilter(true);
    }
    this.g.setMessage(2131696693);
    if ((this.g != null) && (!this.g.isShowing()) && (!this.mActivity.isFinishing())) {
      this.g.show();
    }
  }
  
  public void ath()
  {
    if ((this.g != null) && (this.g.isShowing())) {}
    try
    {
      this.g.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d(SimpleAccount paramSimpleAccount)
  {
    if (!aqiw.bW(BaseApplication.getContext()))
    {
      QQToast.a(this.mActivity, this.mActivity.getString(2131693404), 0).show(this.mActivity.getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "switchAccount toAccount=" + paramSimpleAccount);
    }
    atg();
    this.bUg = paramSimpleAccount.getUin();
    Intent localIntent = new Intent("before_account_change");
    this.mActivity.sendBroadcast(localIntent);
    this.mActivity.app.switchAccount(paramSimpleAccount, null);
    anxj.j(this.mApp, this.mActivity);
    aqfy.edD();
  }
  
  public void nN(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mDismissFinish)
      {
        this.mDismissFinish = false;
        ThreadManager.getUIHandler().post(new AccountPanel.4(this));
      }
    }
    for (;;)
    {
      Ng(false);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, String.format("dismiss AccountPanel, needAnim: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      return;
      try
      {
        super.dismiss();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onAccountChanged()
  {
    QLog.d("AccountPanel", 2, "onAccountChanged");
    ath();
    this.mApp = this.mActivity.app;
    this.bUg = null;
    nN(false);
    anxj.k(this.mApp, this.mActivity);
    if (this.fP != null) {
      this.fP.removeAllViews();
    }
  }
  
  public void onAccoutChangeFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed");
    }
    ath();
    if ((this.mActivity != null) && (this.mApp != null) && (!TextUtils.isEmpty(this.bUg)))
    {
      aqju localaqju = aqha.a(this.mActivity, 230).setTitle(this.mActivity.getString(2131720549)).setMessage(this.mActivity.getString(2131720548));
      localaqju.setPositiveButton(2131691970, new akrx(this));
      localaqju.setCancelable(true);
      localaqju.show();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100) {
      OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.mActivity, this.mActivity.app, true);
    }
  }
  
  public void onBackPressed()
  {
    nN(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      nN(true);
      continue;
      if (this.jdField_a_of_type_Akrv$b != null) {
        this.jdField_a_of_type_Akrv$b.cIH();
      }
    }
  }
  
  public void onDestory()
  {
    if (this.fP != null) {
      this.fP.removeAllViews();
    }
    if (this.mSubHandler != null) {
      this.mSubHandler.removeCallbacksAndMessages(null);
    }
    Ng(true);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onDestory");
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onPause");
    }
    this.cus = false;
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onResume");
    }
    this.cus = true;
  }
  
  public void show()
  {
    if ((this.mApp == null) || (this.mActivity == null) || (isShowing())) {
      return;
    }
    super.show();
    if (this.jdField_a_of_type_Akrv$c != null) {
      this.jdField_a_of_type_Akrv$c.a(this.jdField_b_of_type_MqqAppAppRuntime$Status);
    }
    bpM();
    prepareContentViews();
    ThreadManager.getUIHandler().post(new AccountPanel.2(this));
    this.mSubHandler.post(new AccountPanel.3(this));
    Intent localIntent = new Intent("before_account_change");
    this.mActivity.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "show AccountPanel");
    }
    anot.a(this.mApp, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
  }
  
  class a
  {
    ImageView BZ;
    View FB;
    TextView WH;
    DragTextView jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
    FixSizeImageView jdField_i_of_type_ComTencentWidgetFixSizeImageView;
    View itemView;
    int type;
    
    public a(View paramView, int paramInt)
    {
      this.itemView = paramView;
      this.type = paramInt;
      this.jdField_i_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131363198));
      this.BZ = ((ImageView)paramView.findViewById(2131378930));
      this.WH = ((TextView)paramView.findViewById(2131372383));
      this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131381286));
      this.FB = paramView.findViewById(2131363192);
    }
    
    private void dDn()
    {
      boolean bool2 = false;
      if (!AppSetting.enableTalkBack) {
        return;
      }
      if (this.WH != null) {}
      for (String str = this.WH.getText().toString();; str = "")
      {
        if ((this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView != null) && ((this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getTag() instanceof Integer))) {}
        for (int j = ((Integer)this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getTag()).intValue();; j = 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          boolean bool1;
          if (this.type == 2)
          {
            localStringBuilder.append(akrv.a(akrv.this).getString(2131720581, new Object[] { str })).append(akrv.a(akrv.this).getString(2131691029));
            bool1 = bool2;
            if (this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView != null)
            {
              bool1 = bool2;
              if ((this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getTag(2131381286) instanceof Boolean)) {
                bool1 = ((Boolean)this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getTag(2131381286)).booleanValue();
              }
            }
            if ((j <= 0) || (bool1)) {
              break label318;
            }
            if (j != 1) {
              break label278;
            }
            localStringBuilder.append(" 有一条未读");
          }
          for (;;)
          {
            this.itemView.setContentDescription(localStringBuilder.toString());
            return;
            if (this.type == 2)
            {
              localStringBuilder.append(akrv.a(akrv.this).getString(2131720582, new Object[] { str })).append(akrv.a(akrv.this).getString(2131691029));
              break;
            }
            localStringBuilder.append(str).append(akrv.a(akrv.this).getString(2131691029));
            break;
            label278:
            if (j == 2)
            {
              localStringBuilder.append(" 有两条未读");
            }
            else if (j > 0)
            {
              localStringBuilder.append(" 有").append(j).append("条未读");
              continue;
              label318:
              if (bool1) {
                localStringBuilder.append(" 有最新消息");
              }
            }
          }
        }
      }
    }
    
    public void Nh(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.BZ.setVisibility(0);
        return;
      }
      this.BZ.setVisibility(8);
    }
    
    public void Ni(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.FB.setVisibility(0);
        return;
      }
      this.FB.setVisibility(8);
    }
    
    public void bI(int paramInt, boolean paramBoolean)
    {
      int j;
      int k;
      if (paramInt > 0) {
        if (paramBoolean)
        {
          j = 1;
          if (this.type != 2) {
            break label89;
          }
          if (!paramBoolean) {
            break label82;
          }
          k = 2130851400;
          label26:
          aute.updateCustomNoteTxt(this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView, j, paramInt, k, 99, null);
          label40:
          this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
          this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
        }
      }
      for (;;)
      {
        this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131381286, Boolean.valueOf(paramBoolean));
        dDn();
        return;
        j = 3;
        break;
        label82:
        k = 2130851404;
        break label26;
        label89:
        aute.updateCustomNoteTxt(this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView, j, paramInt, 2130851407, 99, null);
        break label40;
        this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
        this.jdField_i_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      }
    }
    
    public void setIcon(Drawable paramDrawable)
    {
      this.jdField_i_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(paramDrawable);
    }
    
    public void setText(CharSequence paramCharSequence)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        this.WH.setText(paramCharSequence);
        dDn();
      }
    }
    
    public void setTextColor(int paramInt)
    {
      this.WH.setTextColor(paramInt);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cIH();
  }
  
  public static abstract interface c
  {
    public abstract void a(AppRuntime.Status paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akrv
 * JD-Core Version:    0.7.0.1
 */