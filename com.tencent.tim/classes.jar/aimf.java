import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.ContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class aimf
  extends yzc
  implements ContactsBaseFragment.b, zbi
{
  private CommonRefreshLayout jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout;
  private ContactRefreshHeader jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader;
  private ContactsMiniAppEntryManager jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new aimg(this));
  protected QQAppInterface mApp;
  private int mToastOffset;
  private boolean uA;
  private ListView w;
  
  public aimf(Activity paramActivity)
  {
    super(paramActivity);
    if ((paramActivity instanceof SplashActivity)) {
      this.mApp = ((SplashActivity)paramActivity).app;
    }
  }
  
  public static boolean UR()
  {
    aeku localaeku = aekv.a();
    return (localaeku != null) && (localaeku.agS());
  }
  
  private void ckI()
  {
    long l = System.currentTimeMillis();
    getActivity().getSharedPreferences("last_leba_mini_app_refresh_time", 0).edit().putLong("last_leba_mini_app_refresh_time", l).commit();
  }
  
  private void cnm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaViewController", 2, "initMicroAppEntryLayout.");
    }
    if (this.mApp == null)
    {
      QLog.e("LebaViewController", 1, "initMicroAppEntryLayout, mApp = null.");
      return;
    }
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)this.mApp.getManager(309);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendUserAppListRequest(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue(), 20L);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager = new ContactsMiniAppEntryManager(getActivity(), this.mApp, this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader, 2);
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setMiniAppScrollListener(this.jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager);
    }
    this.jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.showMicroAppPanel(MainFragment.bIn);
  }
  
  private long ek()
  {
    return getActivity().getSharedPreferences("last_leba_mini_app_refresh_time", 0).getLong("last_leba_mini_app_refresh_time", 0L);
  }
  
  public void EP(int paramInt)
  {
    this.mToastOffset = paramInt;
  }
  
  public void aJ(QQAppInterface paramQQAppInterface) {}
  
  public void bMe()
  {
    super.bMe();
  }
  
  public void ckJ() {}
  
  public void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaViewController", 2, "onRefreshResult. position:" + paramInt + " success:" + paramBoolean);
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
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    if (this.jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) {
      this.jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.onAccountChanged(paramQQAppInterface);
    }
    if ((!UR()) && (this.jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.shutdownMiniAppPullDownEntry(this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout, MainFragment.bIn);
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshEnabled(false);
      if (this.w != null) {
        this.w.disableOverScrollTop(false);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.uA = false;
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager != null) {
      this.jdField_b_of_type_ComTencentMobileqqMiniEntryContactsMiniAppEntryManager.onPostThemeChanged();
    }
  }
  
  public void onRefresh()
  {
    if (aqiw.isNetworkAvailable(BaseApplication.getContext()))
    {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader.tT(0);
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, 800L);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaViewController", 2, "refresh falied. network unavailable");
    }
    Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(3);
    this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public void u(View paramView)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)paramView.findViewById(2131379046));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.findViewById(2131379044));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new aimh(this));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setOnRefreshListener(this);
    this.w = ((ListView)paramView.findViewById(2131370342));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setTargetListView(this.w);
    if (UR())
    {
      cnm();
      this.w.setNeedCheckSpringback(false);
      this.w.setOverscrollHeader(null);
      this.w.disableOverScrollTop(true);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshEnabled(false);
    this.w.disableOverScrollTop(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aimf
 * JD-Core Version:    0.7.0.1
 */