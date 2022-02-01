import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.b;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.ContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class yzf
  extends yzc
  implements anwa.a, ContactsBaseFragment.b, SimpleSlidingIndicator.b, zbi
{
  private HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private ContactsMiniAppEntryManager jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager;
  private yzv jdField_a_of_type_Yzv;
  private zbn jdField_a_of_type_Zbn;
  private ContactsViewPager jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager;
  private ContactsViewPagerAdapter jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
  private CommonRefreshLayout jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout;
  private ContactRefreshHeader jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new yzg(this));
  private boolean bpQ;
  private boolean bpR;
  private boolean bpS;
  private boolean bpT;
  private boolean bpU;
  private boolean bpV;
  private boolean bpW;
  private int cbR;
  private int cbS = -1;
  private int cbT = 2;
  private acfd e = new yzm(this);
  protected QQAppInterface mApp;
  private View mRootView;
  private int mToastOffset;
  private boolean uA;
  
  public yzf(Activity paramActivity)
  {
    super(paramActivity);
    if ((paramActivity instanceof SplashActivity)) {
      this.mApp = ((SplashActivity)paramActivity).app;
    }
    achg localachg = (achg)this.mApp.getManager(159);
    this.jdField_a_of_type_Yzv = new yzv(localachg.kl("sp_mayknow_entry_list_recommend"));
    int i;
    if (localachg.aaD())
    {
      i = 2;
      this.cbT = i;
      if (this.cbT != 2) {
        break label189;
      }
    }
    label189:
    for (paramActivity = new zce(paramActivity);; paramActivity = new zca(paramActivity))
    {
      this.jdField_a_of_type_Zbn = paramActivity;
      this.jdField_a_of_type_Zbn.a(new yzh(this));
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager.ContactsViewController", 2, "ContactsViewController headType is: " + this.cbT);
      }
      return;
      i = 1;
      break;
    }
  }
  
  private void EM(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt + " oldType: " + this.cbT);
    }
    if (this.cbT == paramInt) {
      return;
    }
    this.jdField_a_of_type_Zbn.onDestroy();
    this.cbT = paramInt;
    if (this.cbT == 2) {}
    for (Object localObject = new zce(this.activity);; localObject = new zca(this.activity))
    {
      this.jdField_a_of_type_Zbn = ((zbn)localObject);
      this.jdField_a_of_type_Zbn.a(new yzi(this));
      this.jdField_a_of_type_Zbn.onCreate();
      this.jdField_a_of_type_Zbn.u(this.mRootView);
      if (!this.uA) {
        break;
      }
      this.jdField_a_of_type_Zbn.onResume(false);
      return;
    }
  }
  
  private void EN(int paramInt)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null) || (this.jdField_a_of_type_Yzv == null) || (this.mApp == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "switchToTabPos mCurrentTabPos:" + this.cbR + "  pos:" + paramInt);
    }
    this.cbR = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.cbR, false);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setCurrentItem(this.cbR, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.cbR, true));
  }
  
  private void EO(int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onPageChange. position:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(paramInt, true));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.fZ(paramInt, this.cbS);
    SimpleSlidingIndicator localSimpleSlidingIndicator = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
    if (this.bpR) {
      bool = false;
    }
    localSimpleSlidingIndicator.setCurrentPosition(paramInt, bool);
    this.cbR = paramInt;
  }
  
  private boolean UQ()
  {
    boolean bool2;
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null) || (this.jdField_a_of_type_Yzv == null) || (this.mApp == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView == null))
    {
      bool2 = false;
      return bool2;
    }
    achg localachg = (achg)this.mApp.getManager(159);
    if (localachg != null) {
      bool1 = localachg.kl("sp_mayknow_entry_list_recommend");
    }
    for (boolean bool1 = this.jdField_a_of_type_Yzv.aE(bool1);; bool1 = false)
    {
      if (bool1)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.dd(this.jdField_a_of_type_Yzv.eF);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_Yzv.cV, this.jdField_a_of_type_Yzv.iX);
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ContactsViewController", 2, "checkAndUpdateRecommendTabShow. mCurrentTabPos:" + this.cbR + " isShowRecommendTab:" + this.jdField_a_of_type_Yzv.UU() + " changed:" + bool1);
      return bool1;
    }
  }
  
  private static boolean UR()
  {
    aeku localaeku = aekv.a();
    return (localaeku != null) && (localaeku.agR());
  }
  
  private void bj(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "checkTabsNeedChange. causeSwitchAccount:" + paramBoolean1 + " moveToDefault:" + paramBoolean2 + " mIsResumed:" + this.uA);
    }
    if (this.uA)
    {
      this.bpR = true;
      int i = this.jdField_a_of_type_Yzv.getId(this.cbR);
      if (UQ())
      {
        i = this.jdField_a_of_type_Yzv.fy(i);
        if ((i == -1) || (paramBoolean2)) {
          i = u(paramBoolean1);
        }
        EN(i);
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOffscreenPageLimit(this.jdField_a_of_type_Yzv.eF.size());
      }
      this.bpR = false;
      return;
    }
    this.bpS = true;
    this.bpT = paramBoolean1;
    this.bpU = paramBoolean2;
  }
  
  private void ckI()
  {
    long l = System.currentTimeMillis();
    getActivity().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l).commit();
  }
  
  private void cnm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "initMicroAppEntryLayout.");
    }
    if (this.mApp == null)
    {
      QLog.e("ContactsViewController", 1, "initMicroAppEntryLayout, mApp = null.");
      return;
    }
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)this.mApp.getManager(309);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendUserAppListRequest(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue(), 20L);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager = new ContactsMiniAppEntryManager(getActivity(), this.mApp, this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader, 1);
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setMiniAppScrollListener(this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager);
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.showMicroAppPanel(MainFragment.bIm);
  }
  
  private long ek()
  {
    return getActivity().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.onAccountChanged(paramQQAppInterface);
    }
    if ((!UR()) && (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.shutdownMiniAppPullDownEntry(this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout, MainFragment.bIm);
    }
  }
  
  private int u(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Yzv.fy(1);
    if (this.jdField_a_of_type_Yzv.UU())
    {
      int m = aqmj.aQ(getActivity(), this.mApp.getCurrentUin());
      int j = 0;
      acff localacff = (acff)this.mApp.getManager(51);
      if (localacff != null) {
        j = localacff.As();
      }
      if ((paramBoolean) && (j == 0)) {
        this.bpW = true;
      }
      if (((paramBoolean) && (j == 0)) || (j > m))
      {
        i = this.jdField_a_of_type_Yzv.fy(1);
        k = i;
        if (QLog.isColorLevel()) {
          QLog.i("ContactsViewController", 2, "getDefaultTabPosition ShowRecommendTab friendCount:" + j + " boundaryCount:" + m);
        }
      }
    }
    for (int k = i;; k = i)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "getDefaultTabPosition. defaultPos:" + k);
      }
      return k;
      break;
    }
  }
  
  public void EP(int paramInt)
  {
    this.mToastOffset = paramInt;
  }
  
  public void aJ(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (this.mApp != paramQQAppInterface)
      {
        if (this.mApp != null) {
          this.mApp.removeObserver(this.e);
        }
        paramQQAppInterface.addObserver(this.e);
      }
      this.mApp = paramQQAppInterface;
      achg localachg = (achg)this.mApp.getManager(159);
      if ((localachg == null) || (localachg.kl("sp_mayknow_entry_list_recommend") == this.jdField_a_of_type_Yzv.UU())) {
        break label252;
      }
    }
    label252:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "fillData. tabsChanged:" + bool + " mIsResumed:" + this.uA);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(6);
      if (bool) {
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(6, 500L);
      }
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
          this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.bl(paramQQAppInterface);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, 0);
        }
        this.jdField_a_of_type_Zbn.aJ(paramQQAppInterface);
        onAccountChanged(paramQQAppInterface);
        if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null)) {
          this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.fY(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.getScrollY(), this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.kk());
        }
        return;
        this.bpR = true;
        EN(u(true));
        this.bpR = false;
      }
    }
  }
  
  public void bMe()
  {
    super.bMe();
    if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.bMe();
    }
    this.jdField_a_of_type_Zbn.bMe();
  }
  
  public void bMf()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null))
    {
      int i = this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.ES(i);
      if ((i == this.jdField_a_of_type_Yzv.fy(1)) || (i == this.jdField_a_of_type_Yzv.fy(2)) || (i == this.jdField_a_of_type_Yzv.fy(0))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, 0);
      }
    }
    this.bpW = false;
  }
  
  public void ckJ()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.US())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.kk());
    }
  }
  
  public void cni()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.bx(2131365317, obt.lb());
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.notifyDataSetChanged();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ContactsViewController", 2, "updateContactsTabPubAccount error! " + QLog.getStackTraceString(localThrowable));
    }
  }
  
  public void cnj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.findViewById(2131372284);
      if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.getScrollY() > localView.getTop())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.scrollTo(0, localView.getTop());
      }
    }
  }
  
  public void cnk()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_a_of_type_Yzv.fy(3), false);
    }
  }
  
  protected void cnl()
  {
    int m = 2131167311;
    boolean bool1;
    int k;
    boolean bool2;
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null)
    {
      bool1 = ThemeUtil.isNowThemeIsDefaultCache(this.mApp, true);
      k = 25;
      bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if (!anlm.Vr()) {
        break label96;
      }
      if (!bool2) {
        break label89;
      }
      i = 2131166736;
      k = 2131167383;
      int n = 255;
      j = i;
      i = k;
      k = n;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.EU(k);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.T(m, i, j);
      return;
      label89:
      i = 2131166735;
      break;
      label96:
      if (bool2)
      {
        m = 2131165722;
        i = 2131165721;
        j = 2131165720;
        k = 30;
      }
      else if (!bool1)
      {
        i = 2131167383;
        j = 2131167311;
      }
      else
      {
        m = 2131165723;
        i = 2131167383;
        j = 2131165723;
      }
    }
  }
  
  public void cnn()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null) && (ContactsBaseFragment.bq == null) && (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getHeight() > 0) && (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getWidth() > 0))
    {
      int[] arrayOfInt = new int[2];
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getLocationOnScreen(arrayOfInt);
      DisplayMetrics localDisplayMetrics = this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getResources().getDisplayMetrics();
      int i = (int)(54.0F * localDisplayMetrics.density);
      ContactsBaseFragment.bq = new Rect(arrayOfInt[0], arrayOfInt[1], localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels - i);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, String.format("init sContentRect:%s, w:%s, h: %s, density: %s", new Object[] { ContactsBaseFragment.bq.toString(), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels), Float.valueOf(localDisplayMetrics.density) }));
      }
    }
  }
  
  public int d(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onContactTabChange. position:" + paramInt + " fromUserClick:" + paramBoolean);
    }
    this.cbS = this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
    if (this.cbS != paramInt) {
      this.bpV = true;
    }
    this.cbR = paramInt;
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setCurrentItem(paramInt, false);
    String str;
    if (paramBoolean)
    {
      str = "";
      switch (this.jdField_a_of_type_Yzv.getId(paramInt))
      {
      }
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      return 0;
      str = "0X8007F19";
      continue;
      str = "0X8007F1A";
      continue;
      str = "0X8007F1C";
      continue;
      str = "0X8007F1D";
      continue;
      str = "0X8007F1E";
      continue;
      str = "0X800A1F6";
    }
  }
  
  public void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onRefreshResult. position:" + paramInt + " success:" + paramBoolean);
    }
    paramObject = this.jdField_b_of_type_MqqOsMqqHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramObject = paramObject.obtainMessage(4, paramInt, i);
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(paramObject);
      return;
    }
  }
  
  public void onChange(boolean paramBoolean)
  {
    bj(false, false);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mApp != null) {
      this.mApp.addObserver(this.e);
    }
    this.jdField_a_of_type_Zbn.onCreate();
    anwa.a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.doOnDestroy();
    }
    this.jdField_a_of_type_Zbn.onDestroy();
    if (this.mApp != null) {
      this.mApp.removeObserver(this.e);
    }
    anwa.b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null)) {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.sx(this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onPause. mCurrentTabPos:" + this.cbR + " isBackground_Stop:" + this.mApp.isBackground_Stop + " isBackground_Pause:" + this.mApp.isBackground_Pause);
    }
    this.jdField_a_of_type_Zbn.onPause();
    this.uA = false;
  }
  
  public void onPostThemeChanged()
  {
    boolean bool = ThemeUtil.isNowThemeIsDefaultCache(this.mApp, true);
    cnl();
    if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.Bi(bool);
    }
    this.jdField_a_of_type_Zbn.Bi(bool);
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.onPostThemeChanged();
    }
  }
  
  public void onRefresh()
  {
    if (aqiw.isNetworkAvailable(BaseApplication.getContext()))
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null)) {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.refresh(this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "refresh falied. network unavailable");
    }
    Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(3);
    this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public void onResume(boolean paramBoolean)
  {
    this.uA = true;
    super.onResume(paramBoolean);
    this.mApp.cKW();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setAccessibilityMsg();
    }
    int i;
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager != null))
    {
      if (!this.bpQ)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ContactsViewController", 2, "mContactsViewPagerAdapter.doOnResume");
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.aU(this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem(), paramBoolean);
      }
    }
    else
    {
      this.jdField_a_of_type_Zbn.onResume(paramBoolean);
      i = this.cbR;
      if (!this.bpS) {
        break label279;
      }
      bj(this.bpT, this.bpU);
      this.bpS = false;
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null)) {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.fY(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.getScrollY(), this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.kk());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.setDrawerFrameEvent(MainFragment.bIm);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8, 500L);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onResume. oldPos:" + i + " mCurrentTabPos:" + this.cbR + " isBackground_Stop:" + this.mApp.isBackground_Stop + " isBackground_Pause:" + this.mApp.isBackground_Pause);
      }
      return;
      this.bpQ = false;
      break;
      label279:
      int j = u(false);
      if ((j != this.cbR) && (this.mApp.isBackground_Stop))
      {
        this.bpR = true;
        EN(j);
        this.bpR = false;
      }
    }
  }
  
  public void u(View paramView)
  {
    this.mRootView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)paramView.findViewById(2131378499));
    cnl();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)paramView.findViewById(2131365258));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager = ((ContactsViewPager)paramView.findViewById(2131365261));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter = new ContactsViewPagerAdapter(((SplashActivity)getActivity()).getSupportFragmentManager(), ((SplashActivity)getActivity()).app, (BaseActivity)getActivity(), this.jdField_a_of_type_Yzv.eF);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOffscreenPageLimit(this.jdField_a_of_type_Yzv.eF.size());
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOnPageChangeListener(new yzj(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_Yzv.cV, this.jdField_a_of_type_Yzv.iX);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setInterceptListener(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)paramView.findViewById(2131379046));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.findViewById(2131379044));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new yzk(this));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_Zbn.u(paramView);
    if (UR()) {
      cnm();
    }
    EN(u(false));
    if (this.cbR != 0) {
      this.bpQ = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setOnScrollListener(new yzl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzf
 * JD-Core Version:    0.7.0.1
 */