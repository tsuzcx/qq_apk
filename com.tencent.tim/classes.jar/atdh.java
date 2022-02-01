import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.recent.RecentCallHelper.12;
import com.tencent.tim.call.recent.RecentCallHelper.3;
import com.tencent.tim.call.recent.RecentCallHelper.4;
import com.tencent.tim.call.recent.RecentCallHelper.6;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.ListView.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class atdh
{
  private View Kl;
  private ViewStub M;
  private aaja jdField_a_of_type_Aaja;
  private aimb jdField_a_of_type_Aimb = new atdi(this);
  protected Handler.Callback a;
  private ViewStub.OnInflateListener jdField_a_of_type_AndroidViewViewStub$OnInflateListener;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
  public boolean aUR;
  private long axT;
  private String cGI = "";
  private FPSSwipListView jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private RedDotRadioButton jdField_d_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
  public boolean dhe = true;
  private boolean dhf;
  private boolean dhg;
  private boolean dhh = true;
  private boolean dhi;
  private boolean dhj;
  public boolean dhk;
  private boolean dhl;
  public boolean dhm;
  private boolean dhn;
  private int epl = 300;
  private int epm;
  public aajg g;
  private Runnable in;
  private PullRefreshHeader k;
  private LinearLayout lW;
  public MqqHandler m = new aqgw(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  private HashMap<String, RecentCallItem> mCache;
  private RelativeLayout nq;
  private RelativeLayout nr;
  public QQAppInterface x = null;
  
  public atdh(QQAppInterface paramQQAppInterface, View paramView, ViewStub.OnInflateListener paramOnInflateListener)
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new atdl(this);
    this.x = paramQQAppInterface;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    this.epm = aqmj.getAppVersionCode(localBaseApplication);
    this.dhi = aqmj.b(localBaseApplication, paramQQAppInterface.getCurrentAccountUin(), this.epm, "acount_uin_first_use_app");
    this.M = ((ViewStub)paramView.findViewById(2131378889));
    if (this.M != null)
    {
      this.M.setLayoutResource(2131561291);
      this.M.setOnInflateListener(paramOnInflateListener);
      return;
    }
    this.dhl = true;
    this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener = paramOnInflateListener;
    this.Kl = paramView.findViewById(2131376841);
  }
  
  private void YH(String paramString)
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.lW != null) && (paramString != null) && (paramString.length() > 0))
    {
      TextView localTextView = (TextView)this.lW.findViewById(2131364187);
      if (localTextView != null)
      {
        localTextView.setText(paramString);
        localTextView.setContentDescription(paramString);
      }
      if (!this.dhg) {
        this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.lW);
      }
      this.lW.setVisibility(0);
      this.dhg = true;
    }
  }
  
  private RecentCallItem a(String paramString)
  {
    if ((this.mCache == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    return (RecentCallItem)this.mCache.get(paramString);
  }
  
  private void a(BaseActivity paramBaseActivity, auuo paramauuo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "initDelay");
    }
    if ((paramBaseActivity == null) || (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallHelper", 2, "initDelay invalid parameter!");
      }
      return;
    }
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramBaseActivity);
    this.k = ((PullRefreshHeader)localLayoutInflater.inflate(2131559847, this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
    this.k.setBackgroundDrawable(paramBaseActivity.getResources().getDrawable(2130838900));
    this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.k);
    this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(paramauuo);
    this.nr = ((RelativeLayout)localLayoutInflater.inflate(2131558815, null));
    paramauuo = (ImageView)this.nr.findViewById(2131364188);
    this.nr.setOnClickListener(new atdn(this, paramBaseActivity));
    paramauuo.setOnClickListener(new atdj(this));
    paramauuo.setContentDescription("关闭");
    this.lW = ((LinearLayout)localLayoutInflater.inflate(2131558816, null));
    this.lW.setVisibility(8);
    paramBaseActivity = (ImageView)this.lW.findViewById(2131364186);
    paramBaseActivity.setOnClickListener(new atdk(this));
    paramBaseActivity.setContentDescription("关闭");
    if (!this.dhj) {
      etg();
    }
    if (alkm.by(this.x)) {
      YH(alkm.E(this.x));
    }
    this.dhn = true;
  }
  
  private void a(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler, boolean paramBoolean)
  {
    this.aUR = true;
    if (paramBoolean)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.e(paramQQAppInterface.getCurrentAccountUin(), (byte)0);
      }
      a(paramMqqHandler, 60000L);
      return;
    }
    a(paramMqqHandler, 800L);
  }
  
  private void etj()
  {
    alkm.c(this.x, false, "");
    if ((this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.lW != null))
    {
      this.lW.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(this.lW);
      this.dhg = false;
    }
  }
  
  private void etk()
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.lW != null) && (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.indexOfChild(this.lW) != -1))
    {
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(this.lW);
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.lW);
    }
  }
  
  private void nw(List<RecentCallItem> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (this.mCache == null) {
      this.mCache = new HashMap(40);
    }
    for (;;)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        RecentCallItem localRecentCallItem = (RecentCallItem)paramList.get(i);
        if (localRecentCallItem != null)
        {
          String str = localRecentCallItem.qx() + "-" + localRecentCallItem.ng();
          this.mCache.put(str, localRecentCallItem);
        }
        i += 1;
      }
      break;
      this.mCache.clear();
    }
  }
  
  public void Vo(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) {
      this.jdField_d_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.showRedDot(paramBoolean);
    }
    if (paramBoolean) {
      ThreadManager.getFileThreadHandler().post(new RecentCallHelper.3(this));
    }
  }
  
  public void Vp(boolean paramBoolean)
  {
    if ((this.nr == null) || (this.x == null)) {}
    int i;
    do
    {
      return;
      i = aqmj.l(this.x.getCurrentAccountUin()).getInt("show_tab_lightalk_tips", 0);
    } while ((i < 0) || (i >= 3));
    ThreadManager.post(new RecentCallHelper.12(this, i, paramBoolean), 5, null, true);
  }
  
  public void YI(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "updateItem");
    }
    if ((this.dhh) && (this.g != null)) {
      this.g.bp(paramString, false);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.k == null) || (paramListView != this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {
      return;
    }
    if (this.aUR)
    {
      this.k.pn();
      return;
    }
    this.k.Q(0L);
  }
  
  public void a(BaseActivity paramBaseActivity, ViewStub paramViewStub, View paramView1, QQAppInterface paramQQAppInterface, View paramView2, View paramView3, auuo paramauuo, aajb paramaajb, AbsListView.e parame)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if ((paramViewStub.getLayoutResource() == 2131561291) && (paramView1 != null))
    {
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramView1.findViewById(2131376840));
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      etl();
      this.in = new RecentCallHelper.6(this, paramBaseActivity, paramauuo);
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.postDelayed(this.in, 1000L);
      this.g = new aajg(paramBaseActivity, paramQQAppInterface, this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView, paramaajb, 4);
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.g);
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(parame);
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(paramBaseActivity.getResources().getDrawable(2130838900));
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallHelper", 2, "onInflate end");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "refreshData|REFRESH_FLAG_CALL_LIST");
    }
    atdm localatdm;
    if ((paramQQAppInterface != null) && (paramContext != null) && (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null))
    {
      localObject = (alkm)paramQQAppInterface.getManager(38);
      localatdm = new atdm(this, paramQQAppInterface, paramContext, paramMqqHandler);
      if (localObject != null) {
        break label72;
      }
    }
    label72:
    for (Object localObject = null;; localObject = ((alkm)localObject).a(localatdm))
    {
      a(paramQQAppInterface, paramContext, paramMqqHandler, (List)localObject);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, List<QCallRecent> paramList)
  {
    int i;
    ArrayList localArrayList;
    int j;
    label33:
    QCallRecent localQCallRecent;
    RecentCallItem localRecentCallItem;
    if (paramList != null)
    {
      i = paramList.size();
      if (i <= 0) {
        break label265;
      }
      localArrayList = new ArrayList(30);
      j = 0;
      if (j >= i) {
        break label207;
      }
      localQCallRecent = (QCallRecent)paramList.get(j);
      if ((localQCallRecent != null) && (!TextUtils.isEmpty(localQCallRecent.uin)))
      {
        localRecentCallItem = a(localQCallRecent.uin + "-" + localQCallRecent.type);
        if (localRecentCallItem != null) {
          break label167;
        }
        localRecentCallItem = new RecentCallItem(localQCallRecent);
        label124:
        if ((localQCallRecent.type != 1024) || (jqs.c(paramQQAppInterface, localQCallRecent.uin, localQCallRecent.type))) {
          break label177;
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label33;
      i = 0;
      break;
      label167:
      localRecentCallItem.a(localQCallRecent);
      break label124;
      label177:
      localRecentCallItem.mUnreadNum = localQCallRecent.missedCallCount;
      localRecentCallItem.c(paramQQAppInterface, paramContext);
      localArrayList.add(localRecentCallItem);
    }
    label207:
    nw(localArrayList);
    label265:
    for (paramQQAppInterface = localArrayList;; paramQQAppInterface = null)
    {
      if ((paramMqqHandler != null) && (paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
        paramMqqHandler.obtainMessage(1021, 0, 0, paramQQAppInterface).sendToTarget();
      }
      while (paramMqqHandler == null) {
        return;
      }
      paramMqqHandler.obtainMessage(1021, 0, 0, null).sendToTarget();
      return;
    }
  }
  
  protected void a(MqqHandler paramMqqHandler, long paramLong)
  {
    if ((this.aUR) && (paramMqqHandler != null))
    {
      paramMqqHandler.removeMessages(1022);
      paramMqqHandler.sendEmptyMessageDelayed(1022, paramLong);
    }
  }
  
  public void a(MqqHandler paramMqqHandler, boolean paramBoolean)
  {
    if (this.k == null) {}
    while (!this.aUR) {
      return;
    }
    a(paramMqqHandler, 800L);
    paramMqqHandler = this.k;
    if (paramBoolean) {}
    for (int i = 0;; i = 2)
    {
      paramMqqHandler.tT(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, MqqHandler paramMqqHandler)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "refreshCallList|mInRecentCallList: " + this.dhh + ", isListViewIdle: " + paramBoolean1 + ", bImmediate: " + paramBoolean2);
    }
    if ((this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) || (paramMqqHandler == null)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("RecentCallHelper", 4, "refreshCallList|invalidate to refresh");
      }
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean1) {
          break;
        }
        this.dhe = false;
        long l;
        if (paramBoolean2) {
          l = 0L;
        }
        while (!paramMqqHandler.hasMessages(16)) {
          if (l == 0L)
          {
            paramMqqHandler.sendEmptyMessage(16);
            return;
            l = Math.max(2000L - Math.abs(this.axT - System.currentTimeMillis()), 500L);
          }
          else
          {
            paramMqqHandler.sendEmptyMessageDelayed(16, l);
            return;
          }
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("RecentCallHelper", 4, "refreshCallList|already has not complete refresh");
      return;
      this.dhe = true;
    } while (!QLog.isDevelopLevel());
    QLog.i("RecentCallHelper", 4, "refreshCallList|list scrolling");
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView, QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler, boolean paramBoolean)
  {
    if ((this.aUR) || (this.k == null) || (paramListView != this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {
      return true;
    }
    this.k.S(0L);
    a(paramQQAppInterface, paramMqqHandler, paramBoolean);
    return true;
  }
  
  public void aCB()
  {
    this.aUR = false;
    if (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.springBackOverScrollHeaderView();
    }
  }
  
  public void aV(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("RecentCallHelper", 4, "refreshCallList|msg: " + paramMessage);
    }
    if (this.g != null)
    {
      this.axT = System.currentTimeMillis();
      paramMessage = (List)paramMessage.obj;
      this.g.cS(paramMessage);
      this.g.notifyDataSetChanged();
      if (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
        this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.post(new RecentCallHelper.4(this));
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("RecentCallHelper", 4, "REFRESH_FLAG_CALL_LIST|" + this.axT);
      }
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.i("RecentCallHelper", 4, "REFRESH_FLAG_CALL_LIST|call adapter is null");
  }
  
  public void aW(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      YH(paramString);
      return;
    }
    etj();
  }
  
  public void aq(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "onAccountChanged");
    }
    if ((this.aUR) && (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null))
    {
      this.aUR = false;
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.hideOverScrollHeaderView();
    }
    if (this.jdField_a_of_type_Aaja != null) {
      this.jdField_a_of_type_Aaja.onAccountChanged(paramQQAppInterface);
    }
    if (this.g != null) {
      this.g.onAccountChanged(paramQQAppInterface);
    }
    if ((this.jdField_d_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (!this.jdField_d_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.isChecked())) {
      eJ(paramQQAppInterface);
    }
    this.epl = 300;
    this.cGI = "";
    this.x = paramQQAppInterface;
    if ((paramQQAppInterface != null) && (!paramBoolean))
    {
      this.dhh = true;
      if (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
        etl();
      }
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.k == null) || (paramListView != this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView)) {}
    while (this.aUR) {
      return;
    }
    this.k.R(0L);
  }
  
  public void b(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "setVisibility|visibility: " + paramInt + ", forceRecommend: " + paramBoolean);
    }
    if (this.M != null) {
      this.M.setVisibility(paramInt);
    }
    for (;;)
    {
      if ((this.dhh) && (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null))
      {
        this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(paramInt);
        if (paramInt == 8) {
          this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.AP();
        }
      }
      if (paramInt == 0)
      {
        if ((this.jdField_d_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_d_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.isChecked()))
        {
          if (this.jdField_d_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.ds()) {
            anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004C0B", "0X8004C0B", 0, 0, "", "", "", "");
          }
          this.jdField_d_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.showRedDot(false);
          df(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
        }
        if (paramQQAppInterface.bJb) {
          df(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
        }
      }
      return;
      if ((this.dhl) && (this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener != null) && (this.Kl != null)) {}
      try
      {
        this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener.onInflate(null, this.Kl);
        this.dhl = false;
        this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener = null;
        if (this.Kl == null) {
          continue;
        }
        this.Kl.setVisibility(paramInt);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("RecentCallHelper", 2, "ViewStub inflate manual error " + localException);
          }
        }
      }
    }
  }
  
  public void df(Context paramContext, String paramString)
  {
    if (aqmj.b(paramContext, paramString, this.epm, "acount_uin_first_use_app")) {
      aqmj.d(paramContext, paramString, this.epm, "acount_uin_first_use_app");
    }
  }
  
  public void eJ(QQAppInterface paramQQAppInterface)
  {
    this.dhm = aqmj.b(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin(), this.epm, "acount_uin_first_use_app");
    Vo(this.dhm);
  }
  
  public void eK(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "updateOnlineStatus");
    }
  }
  
  public void etg()
  {
    if ((this.nq == null) || (this.x == null)) {
      break label14;
    }
    label14:
    while (aqwu.a(this.x, this.x.getAccount(), 6, true, null) != 0) {
      return;
    }
    Object localObject = this.x.getPreferences();
    int i = ((SharedPreferences)localObject).getInt("funcall_RecentCall_Tipsnum", 0);
    if (i < 3)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("funcall_RecentCall_Tipsnum", i + 1);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.dhf) {
          break;
        }
        this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.nq);
        this.dhf = true;
        etk();
        return;
      }
      if (this.dhf != true) {
        break;
      }
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(this.nq);
      this.dhf = false;
      return;
    }
  }
  
  public void eth()
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.nq != null)) {}
    try
    {
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(this.nq);
      this.dhf = false;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RecentCallHelper", 2, "dismiss funcall bar exception");
    }
  }
  
  public void eti()
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.nr != null))
    {
      this.nr.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(this.nr);
      this.dhj = false;
    }
  }
  
  public void etl()
  {
    if (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {}
    do
    {
      do
      {
        return;
        if (!ThemeBackground.getThemeBackgroundEnable())
        {
          this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130838900);
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
        }
      } while (!ThemeBackground.getThemeBackground(this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), "theme_bg_message_path_png", this.x.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground));
      if (("null".equals(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path)) || (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null))
      {
        this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130838900);
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null);
    this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
  }
  
  public void fY(Context paramContext)
  {
    Object localObject1;
    Object localObject2;
    if ((!this.dhj) && (this.nr != null))
    {
      this.dhj = true;
      eth();
      localObject1 = atda.a();
      localObject2 = (TextView)this.nr.findViewById(2131364190);
      ((TextView)localObject2).setText(((atda)localObject1).mWording);
      ((TextView)localObject2).setContentDescription(((atda)localObject1).mWording + "点击进入");
      localObject2 = (ImageView)this.nr.findViewById(2131364189);
    }
    try
    {
      localObject1 = new BitmapDrawable(paramContext.getResources(), aqcu.decodeFile(atda.aYm));
      paramContext = (Context)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramContext = (BitmapDrawable)paramContext.getResources().getDrawable(2130845741);
      }
    }
    ((ImageView)localObject2).setImageDrawable(paramContext);
    this.nr.setVisibility(0);
    this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.nr);
    etk();
    anot.a(this.x, "CliOper", "", "", "0X8005812", "0X8005812", 0, 0, "", "", "", "");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aaja != null) {
      this.jdField_a_of_type_Aaja.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDestory()
  {
    if (this.jdField_a_of_type_Aaja != null) {
      this.jdField_a_of_type_Aaja.onDestory();
    }
    if (this.g != null) {
      this.g.onDestory();
    }
    if (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) {
      try
      {
        Object localObject = Class.forName("com.tencent.widget.ListView").getDeclaredField("mHeaderViewInfos");
        ((Field)localObject).setAccessible(true);
        localObject = ((List)((Field)localObject).get(this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView)).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ListView.b localb = (ListView.b)((Iterator)localObject).next();
          this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(localb.view);
        }
        this.epl = 300;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentCallHelper", 2, "" + localException);
        }
        this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
        this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
        this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeCallbacks(this.in);
      }
    }
    this.cGI = "";
    this.M = null;
    this.jdField_a_of_type_AndroidViewViewStub$OnInflateListener = null;
    this.Kl = null;
    this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView = null;
    this.g = null;
    this.jdField_a_of_type_Aaja = null;
    this.k = null;
    this.nq = null;
    this.lW = null;
    this.jdField_d_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = null;
    if (this.mCache != null)
    {
      this.mCache.clear();
      this.mCache = null;
    }
    if (this.x != null) {
      this.x.a(null);
    }
    this.x = null;
    this.nr = null;
    this.m.removeCallbacksAndMessages(null);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "onPause|mInRecentCallList: " + this.dhh);
    }
    if (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      if (this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
        this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.AP();
      }
      this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView.pause();
    }
    if (this.jdField_a_of_type_Aaja != null) {
      this.jdField_a_of_type_Aaja.onPause();
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "onResume|mInRecentCallList: " + this.dhh);
    }
    if ((QLog.isColorLevel()) && (this.g != null)) {
      QLog.d("lightalktips", 2, "onresume adapter size is " + this.g.getCount());
    }
    if (!this.dhk) {
      Vp(true);
    }
    if (!this.dhj) {
      etg();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    while ((paramAbsListView != this.jdField_d_of_type_ComTencentMobileqqFpsreportFPSSwipListView) || (this.g == null)) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.g.Cq(false);
      return;
    }
    this.g.Cq(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdh
 * JD-Core Version:    0.7.0.1
 */