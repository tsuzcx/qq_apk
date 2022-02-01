package com.tencent.mobileqq.activity;

import aetp;
import aetq;
import aghq;
import aghw;
import ahao;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anpc;
import aobw;
import aqiw;
import aqmj;
import arkn;
import atcm;
import ated;
import ated.a;
import ateh;
import atgc;
import atgd;
import atgi;
import aths;
import aths.a;
import atht;
import athu;
import atik;
import atik.a;
import atin;
import ativ;
import atjx;
import atlo;
import atti;
import aueh;
import auen;
import augw;
import auhh;
import auhk.k;
import auja;
import aulh;
import aulm;
import auuw.b;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.a;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.search.activity.CloudFileGroupSearchActivity;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.anima.CloudSendAnimaActivity;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;
import com.tencent.tim.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import urb;
import urc;
import urd;
import ure;
import urf;
import urg;
import urh;
import uri;
import urj;
import url;
import urm;
import urn;
import uro;
import urp;
import wja;

public class CloudFileActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, arkn, auhk.k, CommonLoadingView.a, AbsListView.e
{
  private static int bFV = 2;
  private ViewStub C;
  private TextView CP;
  private TextView CQ;
  private TextView CR;
  private TextView CS;
  private TextView CT;
  private aghq jdField_a_of_type_Aghq = new urh(this);
  private atcm jdField_a_of_type_Atcm;
  public ated a;
  atgd jdField_a_of_type_Atgd = new urd(this);
  aths.a jdField_a_of_type_Aths$a = new ure(this);
  private atht jdField_a_of_type_Atht;
  atik.a jdField_a_of_type_Atik$a = new urf(this);
  private ativ jdField_a_of_type_Ativ;
  private atjx jdField_a_of_type_Atjx;
  private atlo jdField_a_of_type_Atlo;
  private auhh jdField_a_of_type_Auhh;
  public auja a;
  private aulm jdField_a_of_type_Aulm = new urg(this);
  public auuw.b a;
  CloudFileCallbackCenter jdField_a_of_type_ComTencentCloudfileCloudFileCallbackCenter = new urc(this);
  private CommonLoadingView jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView;
  public GridListView a;
  private CloudFileUploadingStatusBar jdField_a_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar;
  PullRefreshHeader jdField_a_of_type_ComTencentTimWidgetPullRefreshHeader = null;
  private boolean aUC;
  boolean aUD = true;
  boolean aUE = false;
  private volatile boolean aUF;
  private boolean aUG;
  private atlo jdField_b_of_type_Atlo;
  private CloudFileUploadingStatusBar jdField_b_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar;
  public MqqHandler b;
  private int bFU;
  NavBarCommon c;
  private Runnable dK;
  private AdapterView.OnItemClickListener e = new uri(this);
  private LinearLayout fV;
  RelativeLayout gu;
  private int guideType = -1;
  private HorizontalListView l;
  private boolean mHasInited;
  private boolean needRefresh;
  public boolean processing = false;
  private View rX;
  private View rY;
  
  public CloudFileActivity()
  {
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Auuw$b = new urb(this);
  }
  
  private View a(String paramString, int[] paramArrayOfInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.getCount())
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.getChildAt(i);
      if (localObject1 == null) {}
      int j;
      do
      {
        do
        {
          i += 1;
          break;
        } while (!(localObject1 instanceof LinearLayout));
        localObject1 = (LinearLayout)localObject1;
        j = 0;
      } while (j >= ((LinearLayout)localObject1).getChildCount());
      for (;;)
      {
        try
        {
          Object localObject2 = ((RelativeLayout)((LinearLayout)localObject1).getChildAt(j)).getTag();
          if ((localObject2 == null) || (!(localObject2 instanceof ated.a))) {
            break;
          }
          localObject2 = (ated.a)localObject2;
          localObject3 = (String)((ated.a)localObject2).aeE.getText();
          if (QLog.isDevelopLevel()) {
            QLog.e("SendAnim", 1, "find view:" + (String)localObject3);
          }
          if (paramString.equals(localObject3))
          {
            if ((!paramString.equals(getString(2131691584))) || (paramArrayOfInt.length != 4)) {
              break label379;
            }
            localObject3 = new int[2];
            ((ated.a)localObject2).contentView.getLocationOnScreen((int[])localObject3);
            localObject3[0] += wja.dp2px(10.0F, getResources());
            localObject3[1] += wja.dp2px(10.0F, getResources());
            if (Build.VERSION.SDK_INT <= 20)
            {
              paramArrayOfInt[2] = (localObject3[0] + ((ated.a)localObject2).contentView.getWidth() / 2 - wja.dp2px(3.0F, getResources()));
              paramArrayOfInt[3] = (localObject3[1] + ((ated.a)localObject2).contentView.getHeight() / 2 - wja.dp2px(3.0F, getResources()));
              return ((ated.a)localObject2).Km;
            }
            paramArrayOfInt[2] = ((int)(localObject3[0] + ((ated.a)localObject2).contentView.getPivotX() - wja.dp2px(3.0F, getResources())));
            paramArrayOfInt[3] = ((int)(localObject3[1] + ((ated.a)localObject2).contentView.getPivotY() - wja.dp2px(3.0F, getResources())));
            continue;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isDevelopLevel()) {
            QLog.e("SendAnim", 1, localException.toString());
          }
          j += 1;
        }
        label379:
        Object localObject3 = new int[2];
        localException.contentView.getLocationOnScreen((int[])localObject3);
        if (Build.VERSION.SDK_INT <= 20)
        {
          localObject3[0] += localException.contentView.getWidth() / 2;
          localObject3[1] += localException.contentView.getHeight() / 2;
        }
        else
        {
          paramArrayOfInt[0] = ((int)(localObject3[0] + localException.contentView.getPivotX()));
          paramArrayOfInt[1] = ((int)(localObject3[1] + localException.contentView.getPivotY()));
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    if ((!Pp()) || (getActivity().isFinishing()))
    {
      QLog.w("SendAnim", 1, "doAddFileAnim but view is no activie:");
      return;
    }
    Intent localIntent = new Intent(getActivity(), CloudSendAnimaActivity.class);
    localIntent.putExtra("x", paramInt1);
    localIntent.putExtra("y", paramInt2);
    localIntent.putExtra("count", paramInt3);
    startActivity(localIntent);
    getActivity().overridePendingTransition(0, 0);
    new Handler().postDelayed(new CloudFileActivity.20(this, paramView), 1300L);
    paramView.setVisibility(0);
  }
  
  private void aC()
  {
    this.c = ((NavBarCommon)findViewById(2131377361));
    this.c.setTitle(getString(2131720736));
    this.c.setRightImage(getResources().getDrawable(2130840650));
    this.c.setOnItemSelectListener(this);
    this.bFU = getResources().getDimensionPixelSize(2131299627);
  }
  
  private boolean ai(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileFrame", 2, "updateBuddyList " + this.aUD + " " + this.aUE);
    }
    ateh localateh = (ateh)this.app.getBusinessHandler(180);
    if (!paramBoolean)
    {
      localateh.N(0, null);
      return true;
    }
    if (aqiw.isNetworkAvailable(BaseApplication.getContext()))
    {
      if (this.aUD)
      {
        localateh.N(1, null);
        Object localObject = ((atgc)this.app.getManager(373)).hg();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
            if (localFileManagerEntity.peerType == 3000) {
              localateh.c(localFileManagerEntity, false);
            } else {
              localateh.a(localFileManagerEntity, false);
            }
          }
        }
      }
      this.aUE = true;
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileFrame", 2, "updateBuddyList succeeded");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileFrame", 2, "updateBuddyList falied");
    }
    return false;
  }
  
  private void bLI()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView == null) {
      return;
    }
    if (this.jdField_a_of_type_Ated == null)
    {
      this.jdField_a_of_type_Ated = new ated(this.app, getActivity(), new urp(this), bFV, this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_a_of_type_Ated);
    }
    this.jdField_a_of_type_Ated.nx(this.jdField_a_of_type_Auja.hk());
  }
  
  private void bLJ()
  {
    bLI();
    this.needRefresh = true;
    ai(false);
    wC(false);
    wE(true);
  }
  
  private void bLK()
  {
    this.C.setVisibility(0);
  }
  
  private void bLL()
  {
    this.aUF = false;
    if (this.app.a().hasQueriedVerifyPassword() == true)
    {
      this.app.a().dfZ();
      return;
    }
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getActivity(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "CloudFileTab");
      localIntent.putExtra("qfile_selecter_entrance_type", -1);
      startActivityForResult(localIntent, 101);
      return;
    }
    ahao.JD(BaseApplication.getContext().getString(2131696270));
  }
  
  private void bLM()
  {
    String str = aqmj.am(getActivity(), this.app.getCurrentAccountUin());
    int i = aqmj.bC(getActivity(), this.app.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str))
    {
      MiniAppLauncher.startMiniApp(getActivity(), "mqqapi://miniapp/open?_ext=&_mappid=1107999468&_mvid=&_nq=&_path=&_q=&referer=2011&via=2011&_sig=31ba7125a22d3462e9dc4f8abff74d9e9c445cdd46e8ea446f39a839ebb110b4", 2011, null);
      return;
    }
    QLog.w("CloudFileFrame", 2, "can not to start WeiYun Mini app, apkgUrl = " + str + ", version = " + i);
    bLL();
  }
  
  private void bLN()
  {
    Intent localIntent = new Intent(getActivity(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 1);
    localIntent.putExtra("qfile_entrance_type_key", 8);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 15);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("from", "FileAssistant");
      localIntent.putExtra("custom_title", getString(2131693534));
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bLO()
  {
    try
    {
      Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      if (TextUtils.isEmpty(aetq.a().tV())) {}
      for (String str = "https://docs.qq.com/desktop/m/index.html?_from=1";; str = aetq.a().tV())
      {
        str = aobw.bD(str, "s_qq_myfile");
        localIntent.putExtra("tdsourcetag", "s_qq_myfile");
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        localIntent.putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
        if (TeamWorkDocEditBrowserActivity.g(getActivity(), str, localIntent.getStringExtra("tdsourcetag"))) {
          break;
        }
        startActivity(localIntent.putExtra("url", str));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("CloudFileFrame", 1, localException.toString());
    }
  }
  
  private void bLP()
  {
    if (this.jdField_a_of_type_Ated == null) {}
    while (this.dK != null) {
      return;
    }
    this.dK = new CloudFileActivity.21(this);
    ThreadManager.getUIHandler().postDelayed(this.dK, 1000L);
  }
  
  private void ck(String paramString, int paramInt)
  {
    int i = this.jdField_a_of_type_Ated.fK(paramString);
    if (i < 0)
    {
      QLog.w("CloudFileFrame", 1, "not find folder, return!");
      return;
    }
    QLog.e("SendAnim", 1, "find[" + paramString + "] index[" + i + "]");
    this.processing = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnScrollListener(new urj(this, paramString, paramInt));
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.getHeaderViewsCount();
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_a_of_type_Ated);
    if ((i > 2) && (i % 2 == 0)) {
      paramInt = i + 2;
    }
    for (;;)
    {
      paramInt /= 2;
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.smoothScrollToPositionFromTop(paramInt + (j - 2), 0, 100);
      return;
      paramInt = i;
      if (i > 2) {
        paramInt = i + 1;
      }
    }
  }
  
  private void d(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar != null) && (this.jdField_b_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar != null))
    {
      if (paramInt1 > 3) {
        this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar.setForceHide(false);
      }
      if (paramInt1 < 3)
      {
        this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar.setForceHide(true);
        this.jdField_b_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar.setForceHide(false);
      }
    }
  }
  
  private void notifyDataSetChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Ated != null) {
        this.jdField_a_of_type_Ated.notifyDataSetChanged();
      }
      return;
    }
    bLP();
  }
  
  private void o(ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView) {
      if (paramListView.getFirstVisiblePosition() > 0) {
        post(new CloudFileActivity.2(this));
      }
    }
    while (paramListView.getFirstVisiblePosition() <= 0) {
      return;
    }
    paramListView.setSelection(0);
  }
  
  private void updateQzoneFeeds()
  {
    ThreadManager.getSubThreadHandler().post(new CloudFileActivity.5(this));
  }
  
  public boolean Pp()
  {
    return isResume();
  }
  
  public void aa(long paramLong, boolean paramBoolean)
  {
    int i = 9527;
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(4);
    if (paramBoolean) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9527);
    }
    while (paramLong == 0L)
    {
      wD(paramBoolean);
      return;
      if (this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(9527)) {
        return;
      }
    }
    MqqHandler localMqqHandler = this.jdField_b_of_type_MqqOsMqqHandler;
    if (paramBoolean) {}
    for (;;)
    {
      localMqqHandler.sendEmptyMessageDelayed(i, paramLong);
      return;
      i = 4;
    }
  }
  
  public void bLH()
  {
    if ((this.guideType != -1) && (this.jdField_a_of_type_Ated != null))
    {
      this.jdField_a_of_type_Ated.aak(this.guideType);
      this.guideType = -1;
      o(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView);
    }
  }
  
  public void bcH()
  {
    if (this.app != null)
    {
      atgi.a().a(this.jdField_a_of_type_ComTencentCloudfileCloudFileCallbackCenter);
      aths.a().a(this.jdField_a_of_type_Aths$a);
      if (!"0".equals(this.app.getCurrentAccountUin())) {}
    }
    else
    {
      return;
    }
    this.aUD = true;
    this.app.addObserver(this.jdField_a_of_type_Aulm);
    bLJ();
    if (this.jdField_a_of_type_Atjx == null) {
      this.jdField_a_of_type_Atjx = new atjx(this.app, getActivity(), this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ated != null) {
        this.jdField_a_of_type_Ated.onAccountChanged(this.app);
      }
      this.app.addObserver(this.jdField_a_of_type_Atgd);
      if (this.jdField_a_of_type_Atht == null) {
        break;
      }
      this.jdField_a_of_type_Atht.bF(this.jdField_a_of_type_Auja.hm());
      return;
      this.jdField_a_of_type_Atjx.onAccountChanged(this.app);
    }
  }
  
  public List<augw> cH()
  {
    this.jdField_a_of_type_Auja = new auja(this.app, this);
    this.jdField_a_of_type_Auja.onCreate();
    if ((this.jdField_a_of_type_Auja instanceof augw)) {}
    return Arrays.asList(new augw[] { this.jdField_a_of_type_Auja });
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558968);
    this.gu = ((RelativeLayout)findViewById(2131377546));
    aC();
    paramBundle = new ArrayList();
    paramBundle.add(atcm.g);
    paramBundle.add(atcm.a);
    paramBundle.add(atcm.b);
    paramBundle.add(atcm.d);
    paramBundle.add(atcm.h);
    paramBundle.add(atcm.e);
    paramBundle.add(atcm.f);
    paramBundle.add(atcm.j);
    this.jdField_a_of_type_Atcm = new atcm(getActivity(), paramBundle, this.jdField_a_of_type_Auuw$b);
    this.C = ((ViewStub)findViewById(2131378880));
    this.C.setOnInflateListener(this);
    cH();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)findViewById(2131365078));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnResume();
    this.app.removeObserver(this.jdField_a_of_type_Atgd);
    this.app.removeObserver(this.jdField_a_of_type_Aulm);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Ated != null) {
      this.jdField_a_of_type_Ated.onDestroy();
    }
    if (this.jdField_a_of_type_Atjx != null) {
      this.jdField_a_of_type_Atjx.onDestroy();
    }
    atgi.c(this.jdField_a_of_type_ComTencentCloudfileCloudFileCallbackCenter);
    aths.a().b(this.jdField_a_of_type_Aths$a);
    if (this.dK != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.dK);
      this.dK = null;
    }
    if (this.jdField_a_of_type_Auja != null) {
      this.jdField_a_of_type_Auja.destroy();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnScrollListener(this);
    }
    this.app.a().addObserver(this.jdField_a_of_type_Aghq);
    bLK();
    updateQzoneFeeds();
    if (this.jdField_b_of_type_Atlo != null) {
      this.jdField_b_of_type_Atlo.onResume();
    }
    if (this.jdField_a_of_type_Atlo != null) {
      this.jdField_a_of_type_Atlo.onResume();
    }
    this.aUG = false;
    QLog.d("CloudFileFrame", 1, "onResume Animating is end");
    if (this.mHasInited)
    {
      wC(false);
      ((ateh)this.app.getBusinessHandler(180)).N(8, null);
    }
    WebProcessManager.Tb(true);
    ThreadManager.getUIHandler().postDelayed(new CloudFileActivity.3(this), 100L);
    if (auen.aJn())
    {
      this.guideType = 6;
      bLH();
    }
    for (;;)
    {
      bLH();
      return;
      if (this.jdField_a_of_type_Ated != null) {
        this.jdField_a_of_type_Ated.aal(6);
      }
    }
  }
  
  public void f(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileFrame", 2, "updateListView isSuccess:" + paramBoolean1 + "operationType:" + paramInt + " isComplete:" + paramBoolean2 + " needRefresh:" + this.needRefresh);
    }
    switch (paramInt)
    {
    case 6: 
    default: 
      if ((paramBoolean1) && (this.aUD)) {
        aa(100L, false);
      }
      break;
    }
    do
    {
      do
      {
        return;
        post(new CloudFileActivity.10(this));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setVisibility(8);
        }
        this.aUD = true;
        if (this.jdField_a_of_type_Ativ != null) {
          this.jdField_a_of_type_Ativ.cG(paramBoolean1, paramBoolean2);
        }
        if (this.jdField_a_of_type_Ated != null) {
          this.jdField_a_of_type_Ated.etn();
        }
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 800L);
        if (paramBoolean1) {
          aa(0L, true);
        }
      } while (!this.needRefresh);
      ai(true);
      this.needRefresh = false;
      return;
    } while ((!paramBoolean1) || (!this.aUD));
    aa(100L, true);
  }
  
  public void g(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Ated.Vv(true);
  }
  
  public AppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
          } while (this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView == null);
          this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.springBackOverScrollHeaderView();
          return true;
          QQToast.a(getActivity(), 1, 2131720480, 0).show(getTitleBarHeight());
        } while (!(paramMessage.obj instanceof ListView));
        ((ListView)paramMessage.obj).springBackOverScrollHeaderView();
        return true;
      } while (!this.aUD);
      aa(0L, false);
      return true;
      aa(0L, true);
      return true;
      bcH();
      if (!this.mHasInited) {
        doOnResume();
      }
      this.mHasInited = true;
      return true;
    } while (this.CP == null);
    paramMessage = paramMessage.getData().getString("key_space_string");
    this.CP.setText(paramMessage);
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == 0))
    {
      finish();
      this.app.exit(false);
    }
    do
    {
      Object localObject1;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_Atjx != null) {
                this.jdField_a_of_type_Auhh = ((auhh)this.jdField_a_of_type_Atjx.a(2));
              }
              switch (paramInt1)
              {
              case 1: 
              case 2: 
              case 4: 
              default: 
                return;
              }
            } while ((paramInt2 != -1) || (paramIntent == null));
            localObject1 = paramIntent.getParcelableArrayListExtra("key_file_to_be_dealt_with");
            paramIntent = (FileInfo)paramIntent.getParcelableExtra("key_selected_dir");
          } while ((localObject1 == null) || (paramIntent == null) || (paramIntent.Y() == null));
          long l1 = 0L;
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            l1 += ((FileInfo)((Iterator)localObject2).next()).getSize();
          }
          localObject2 = (atgc)this.app.getManager(373);
          if (l1 > ((atgc)localObject2).getTotalSpace() - ((atgc)localObject2).it())
          {
            athu.c(this.app, getActivity(), 2);
            return;
          }
          this.jdField_a_of_type_Auhh.a(paramIntent.Y(), (List)localObject1, 1, new url(this, paramIntent, (List)localObject1));
          return;
        } while (paramInt2 != -1);
        paramIntent = (FileInfo)paramIntent.getParcelableExtra("key_selected_dir");
        localObject1 = ((atgc)this.app.getManager(373)).aE();
      } while ((this.jdField_a_of_type_Ated.gT() == null) || (paramIntent == null) || (paramIntent.Y() == null));
      Object localObject2 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_Ated.gT().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        if ((localObject3 instanceof FileManagerEntity)) {
          ((List)localObject2).add(aueh.a((FileManagerEntity)localObject3));
        } else if ((localObject3 instanceof atin)) {
          ((List)localObject2).add(aueh.a((atin)localObject3));
        }
      }
      this.jdField_a_of_type_Auhh.a((byte[])localObject1, (List)localObject2, paramIntent.Y());
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    paramIntent = paramIntent.getData();
    new atik(this.jdField_a_of_type_Atik$a).b(paramIntent, getActivity());
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileFrame", 2, "CloudFileFrame on key down");
    }
    if (FrameHelperActivity.ZW())
    {
      FrameHelperActivity.cuA();
      return true;
    }
    return super.onBackEvent();
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
      if (this.jdField_a_of_type_Atcm != null)
      {
        this.jdField_a_of_type_Atcm.b(paramView, wja.getScreenWidth(getActivity()) - getResources().getDimensionPixelSize(2131299279), getResources().getDimensionPixelSize(2131299276), 1);
        anpc.report("tim_mine_tab_file_click_r_plus_click");
        continue;
        CloudFileGroupSearchActivity.p(getActivity(), null, 27);
        anpc.report("tim_mine_tab_file_click_search_click");
      }
    }
  }
  
  public void onFirstDraw()
  {
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(9528);
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView = ((GridListView)paramView.findViewById(2131366303));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setNumColumns(bFV);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setEnableAverageLayout(true);
    float f = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSpacing((int)(f * 12.0F), 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setSelector(2131167595);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOverscrollHeader(getResources().getDrawable(2130851105));
    this.jdField_a_of_type_ComTencentTimWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getActivity()).inflate(2131559848, this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView, false));
    this.jdField_a_of_type_ComTencentTimWidgetPullRefreshHeader.setTheme(1);
    this.jdField_a_of_type_ComTencentTimWidgetPullRefreshHeader.setBackgroundDrawable(getResources().getDrawable(2130851105));
    paramViewStub = new RelativeLayout.LayoutParams(-1, this.bFU);
    this.jdField_a_of_type_ComTencentTimWidgetPullRefreshHeader.setLayoutParams(paramViewStub);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentTimWidgetPullRefreshHeader);
    this.jdField_a_of_type_Ativ = new ativ(getActivity(), "sp_key_refresh_time_cloud_file", this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView, this.jdField_a_of_type_ComTencentTimWidgetPullRefreshHeader, new urm(this));
    this.rX = getActivity().getLayoutInflater().inflate(2131558982, null);
    this.rY = this.rX.findViewById(2131364813);
    this.rY.setVisibility(8);
    this.CR = ((TextView)this.rX.findViewById(2131379751));
    this.CS = ((TextView)this.rX.findViewById(2131379741));
    this.CT = ((TextView)this.rX.findViewById(2131379744));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.addHeaderView(this.rX);
    paramViewStub = new LinearLayout(this);
    paramViewStub.setBackgroundResource(2130851105);
    paramViewStub.setId(2131377784);
    paramViewStub.setOrientation(1);
    paramViewStub.setGravity(16);
    paramView = getLayoutInflater().inflate(2131558980, this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView, false);
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    int i = wja.dp2px(14.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).setMargins(i, i, i, i);
    paramView.setId(2131377783);
    paramView.setOnClickListener(this);
    paramViewStub.addView(paramView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.addHeaderView(paramViewStub, 0);
    this.jdField_b_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar = new CloudFileUploadingStatusBar(getActivity());
    this.jdField_b_of_type_Atlo = new atlo(getActivity(), this.jdField_b_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.addHeaderView(this.jdField_b_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar);
    this.fV = ((LinearLayout)getActivity().getLayoutInflater().inflate(2131558990, null));
    this.l = ((HorizontalListView)this.fV.findViewById(2131380013));
    this.jdField_a_of_type_Atht = new atht(getActivity());
    this.jdField_a_of_type_Atht.bF(this.jdField_a_of_type_Auja.hm());
    this.l.setAdapter(this.jdField_a_of_type_Atht);
    this.l.setOnItemClickListener(this.e);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.addHeaderView(this.fV);
    paramViewStub = getActivity().getLayoutInflater().inflate(2131558979, null);
    this.CP = ((TextView)paramViewStub.findViewById(2131364730));
    this.CQ = ((TextView)paramViewStub.findViewById(2131364731));
    paramView = new urn(this);
    localObject = new SpannableString(getString(2131691659));
    ((SpannableString)localObject).setSpan(paramView, 0, ((SpannableString)localObject).length(), 17);
    this.CQ.setText((CharSequence)localObject);
    this.CQ.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.addFooterView(paramViewStub);
    this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar = ((CloudFileUploadingStatusBar)findViewById(2131381358));
    this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar.setStateListener(new uro(this));
    this.jdField_a_of_type_Atlo = new atlo(getActivity(), this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudFileUploadingStatusBar);
    bLI();
  }
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 1) {
      finish();
    }
    while ((paramInt != 5) || (this.jdField_a_of_type_Atcm == null)) {
      return;
    }
    this.jdField_a_of_type_Atcm.b(paramView, wja.getScreenWidth(getActivity()) - getResources().getDimensionPixelSize(2131299279), getResources().getDimensionPixelSize(2131299276), 1);
    anpc.report("tim_mine_tab_file_click_r_plus_click");
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.aUG)
    {
      QLog.d("CloudFileFrame", 1, "onPause is not Animating, so call status onpause");
      if (this.jdField_b_of_type_Atlo != null) {
        this.jdField_b_of_type_Atlo.onPause();
      }
      if (this.jdField_a_of_type_Atlo != null) {
        this.jdField_a_of_type_Atlo.onPause();
      }
    }
    for (;;)
    {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
      if (this.jdField_a_of_type_Atcm != null) {
        this.jdField_a_of_type_Atcm.dismiss();
      }
      WebProcessManager.Tb(false);
      return;
      QLog.d("CloudFileFrame", 1, "onPause but is Animating, so not call status onpause");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    d(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_Ativ != null) {
      this.jdField_a_of_type_Ativ.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Ativ != null) {
      this.jdField_a_of_type_Ativ.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected void post(Runnable paramRunnable)
  {
    if (this.mContentView != null) {
      this.mContentView.post(paramRunnable);
    }
  }
  
  public void qw(String paramString)
  {
    QQToast.a(this.app.getApp(), 1, paramString, 0).show(getTitleBarHeight());
  }
  
  public String setLastActivityName()
  {
    return getActivity().getString(2131695647);
  }
  
  public void showSuccessToast(String paramString)
  {
    QQToast.a(this.app.getApp(), 2, paramString, 0).show(getTitleBarHeight());
  }
  
  public void wC(boolean paramBoolean)
  {
    aulh localaulh = (aulh)this.app.getBusinessHandler(178);
    if (paramBoolean)
    {
      localaulh.VT(false);
      return;
    }
    localaulh.VT(true);
  }
  
  void wD(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JustGo", 2, "<<--doRefreshBuddyList");
    }
    if (this.jdField_a_of_type_Ated != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Ated.nx(this.jdField_a_of_type_Auja.hk());
      }
    }
    else {
      return;
    }
    notifyDataSetChanged(false);
  }
  
  public void wE(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = (atgc)this.app.getManager(373);
      localObject = String.format(getString(2131691658), new Object[] { athu.c((float)(((atgc)localObject).getTotalSpace() - ((atgc)localObject).it())), athu.d((float)((atgc)localObject).getTotalSpace()) });
      if (this.CP != null) {
        this.CP.setText((CharSequence)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.CloudFileActivity
 * JD-Core Version:    0.7.0.1
 */