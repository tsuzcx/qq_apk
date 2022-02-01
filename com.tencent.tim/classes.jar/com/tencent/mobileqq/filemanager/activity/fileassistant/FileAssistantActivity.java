package com.tencent.mobileqq.filemanager.activity.fileassistant;

import acfp;
import aepo;
import aepo.a;
import aetp;
import aetq;
import aeuh;
import aeui;
import afdp;
import agfb;
import agfc;
import agfd;
import agfe;
import agff;
import agfg;
import agfh;
import agfi;
import aghq;
import aghw;
import agiq;
import agkh;
import ahao;
import ahau;
import ahau.a;
import ahav;
import aklk;
import altq;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aobw;
import aqiw;
import aqmj;
import arkn;
import auuw;
import auuw.a;
import avhc;
import avio;
import awph;
import awpk;
import awpx;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import wja;

public class FileAssistantActivity
  extends BaseFileAssistantActivity
  implements arkn
{
  private ViewStub H;
  ViewStub I = null;
  RedTouch J;
  RedTouch K;
  RedTouch L;
  TextView So;
  TextView Sp;
  TextView Sq;
  TextView Sr;
  TextView Ss;
  aepo jdField_a_of_type_Aepo;
  private aghq jdField_a_of_type_Aghq = new agfg(this);
  private awpk jdField_a_of_type_Awpk;
  public QfileTabBarView a;
  NavBarCommon b;
  private String bGS = acfp.m(2131706204);
  public Handler bO = new agfh(this, Looper.getMainLooper());
  public boolean cdf = false;
  boolean cdg = false;
  public auuw d;
  HeaderScrollView d;
  private aklk e = new agfi(this);
  private int[] lm = { 2131693796, 2131700496, 2131721848, 2131720993 };
  private int[] ln = { 2130845180, 2130845181, 2130845186, 2130845228 };
  private volatile boolean mPaused;
  BusinessInfoCheckUpdate.AppInfo t;
  BusinessInfoCheckUpdate.AppInfo u;
  public BusinessInfoCheckUpdate.AppInfo v;
  
  public FileAssistantActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = null;
  }
  
  private void a(FileAssistantActivity paramFileAssistantActivity, String paramString, int paramInt)
    throws MiniAppException
  {
    MiniAppLauncher.startMiniApp(this, "mqqapi://miniapp/open?_ext=&_mappid=1107999468&_mvid=&_nq=&_path=&_q=&referer=2011&via=2011&_sig=31ba7125a22d3462e9dc4f8abff74d9e9c445cdd46e8ea446f39a839ebb110b4", 2011, null);
  }
  
  private void bLN()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
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
      if (this.cdf)
      {
        ahau.JH("0X8005538");
        return;
      }
      ahau.JH("0X800681E");
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
      Intent localIntent = new Intent(getApplicationContext(), QQBrowserActivity.class);
      if (TextUtils.isEmpty(aetq.a().tV())) {}
      for (String str1 = "https://docs.qq.com/desktop/m/index.html?_from=1";; str1 = aetq.a().tV())
      {
        String str2 = aobw.bD(str1, "s_qq_myfile");
        localIntent.putExtra("tdsourcetag", "s_qq_myfile");
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        if (this.cdg)
        {
          str2 = aobw.bD(str1, "s_qq_myfile_banner");
          localIntent.putExtra("tdsourcetag", "s_qq_myfile_banner");
          this.cdg = false;
        }
        localIntent.putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
        if (TeamWorkDocEditBrowserActivity.g(this, str2, localIntent.getStringExtra("tdsourcetag"))) {
          break;
        }
        startActivity(localIntent.putExtra("url", str2));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("FileAssistantActivity", 1, localException.toString());
    }
  }
  
  private void c(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    QLog.i("FileAssistantActivity", 1, " fileRedTouch deleteRedTouch path = " + paramString);
    altq localaltq = (altq)this.app.getManager(36);
    if (paramAppInfo == null)
    {
      localaltq.OS(paramString);
      return;
    }
    localaltq.d(paramAppInfo, null);
  }
  
  private void dfR()
  {
    this.Sr = ((TextView)findViewById(2131369429));
    this.K = new RedTouch(getApplicationContext(), this.Sr).a(53).c(10).a();
    this.Sr.setOnClickListener(this);
    anot.a(this.app, "dc00898", "", "", "0X800906F", "0X800906F", 0, 0, "", "", "", "");
  }
  
  private void dfS()
  {
    aeuh localaeuh = aeui.a();
    if (localaeuh != null)
    {
      this.Sr.setText(localaeuh.bBL);
      this.Sq.setText(localaeuh.bBM);
      this.bGS = localaeuh.bBN;
    }
  }
  
  private void dfT()
  {
    if ((this.jdField_a_of_type_Aepo == null) || (!this.jdField_a_of_type_Aepo.So()))
    {
      QLog.i("FileAssistantActivity", 1, "FileAssistantTips is switch off");
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aepo.tE()))
    {
      QLog.i("FileAssistantActivity", 1, "FileAssistantTips not ready, textContent is null");
      return;
    }
    this.H = ((ViewStub)findViewById(2131366621));
    this.H.inflate();
    TextView localTextView1 = (TextView)findViewById(2131380974);
    TextView localTextView2 = (TextView)findViewById(2131380975);
    ImageView localImageView = (ImageView)findViewById(2131369928);
    localTextView1.setText(this.jdField_a_of_type_Aepo.tE());
    localTextView2.setText(this.jdField_a_of_type_Aepo.tF());
    localTextView2.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    this.jdField_a_of_type_Aepo.cXk();
  }
  
  private void dfU()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.H.getHeight(), 0 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new agfb(this));
    localValueAnimator.addListener(new agfc(this));
    localValueAnimator.start();
  }
  
  private void dfV()
  {
    this.app.a().gK("0X800474E", 1);
    avhc.c(this, 2, null);
  }
  
  private void dfW()
  {
    FileSearchActivity.a(this, "", new ArrayList(), false, 8);
  }
  
  private void dfX()
  {
    this.jdField_a_of_type_Awpk = new awpk();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_Awpk);
    awph.gz(this.app.getApplication());
  }
  
  private void dfY()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    startActivityForResult(localIntent, 101);
  }
  
  private void dfZ()
  {
    this.mPaused = false;
    if (this.app.a().hasQueriedVerifyPassword() == true)
    {
      this.app.a().dfZ();
      return;
    }
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    ahao.JD(BaseApplication.getContext().getString(2131696270));
  }
  
  private void dga()
  {
    QLog.i("FileAssistantActivity", 1, "fileRedTouch updateAllRedTouch");
    dgb();
    dgd();
    dgc();
  }
  
  private void dgb()
  {
    altq localaltq;
    if (this.K != null)
    {
      localaltq = (altq)this.app.getManager(36);
      if (localaltq != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.u = localaltq.a(1, "100160.100163");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateDocsFileRedTouch info = " + this.u);
      this.K.e(this.u);
    } while (this.u == null);
    localaltq.e(this.u, null);
  }
  
  private void dgc()
  {
    altq localaltq;
    if (this.L != null)
    {
      localaltq = (altq)this.app.getManager(36);
      if (localaltq != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.v = localaltq.a(1, "100160.100162");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunBackupRedTouch info = " + this.v);
      this.L.e(this.v);
    } while (this.v == null);
    localaltq.e(this.v, null);
  }
  
  private void dgd()
  {
    altq localaltq;
    if (this.J != null)
    {
      localaltq = (altq)this.app.getManager(36);
      if (localaltq != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.t = localaltq.a(1, "100160.100164");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunFileRedTouch info = " + this.t);
      this.J.e(this.t);
    } while (this.t == null);
    localaltq.e(this.t, null);
  }
  
  private void gb()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 14L);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void sz()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.lm.length)
    {
      if (this.lm[i] == 2131721848) {}
      auuw.a locala = new auuw.a();
      locala.id = i;
      locala.title = getString(this.lm[i]);
      locala.contentDescription = locala.title;
      if (i == 3)
      {
        aeuh localaeuh = aeui.a();
        if ((localaeuh != null) && (!TextUtils.isEmpty(localaeuh.bBO)))
        {
          locala.title = localaeuh.bBO;
          locala.contentDescription = localaeuh.bBO;
        }
      }
      locala.iconId = this.ln[i];
      localArrayList.add(locala);
      i += 1;
    }
    this.jdField_d_of_type_Auuw = auuw.a(this, localArrayList, new agfd(this), null, wja.dp2px(210.0F, getResources()));
    this.jdField_d_of_type_Auuw.setTouchInterceptor(new agfe(this));
  }
  
  public ListView b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    }
    return null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.I != null) {
      this.I.setVisibility(8);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true)) && (paramInt2 == 4))
    {
      Intent localIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
    if (paramInt1 == 10001) {
      awpx.gB(this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int j = 0;
    super.doOnCreate(paramBundle);
    TdsReaderGlobal.init();
    setContentView(2131560996);
    ThreadManager.getFileThreadHandler().post(new FileAssistantActivity.1(this));
    this.jdField_d_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)findViewById(2131368482));
    this.So = ((TextView)findViewById(2131369475));
    this.Sp = ((TextView)findViewById(2131369483));
    this.Sq = ((TextView)findViewById(2131369548));
    this.J = new RedTouch(getApplicationContext(), this.Sq).a(53).c(10).a();
    dfR();
    this.Ss = ((TextView)findViewById(2131369430));
    this.So.setOnClickListener(this);
    this.Sp.setOnClickListener(this);
    this.Sq.setOnClickListener(this);
    this.Ss.setOnClickListener(this);
    findViewById(2131379228).setOnClickListener(this);
    this.b = ((NavBarCommon)findViewById(2131377361));
    this.b.setTitle(getString(2131693604));
    if (Build.VERSION.SDK_INT >= 21) {}
    int[] arrayOfInt;
    for (paramBundle = getDrawable(2130845109);; paramBundle = getResources().getDrawable(2130845109))
    {
      this.b.setOnItemSelectListener(this);
      this.b.setRightImage(paramBundle);
      this.b.setRightImageDesc(acfp.m(2131706206));
      this.L = new RedTouch(getApplicationContext(), this.b).a(53).c(5).d(10).a();
      dfS();
      gY();
      this.app.a().addObserver(this.jdField_a_of_type_Aghq);
      dfX();
      dga();
      this.app.registObserver(this.e);
      if (aqmj.bB(this, this.app.getCurrentAccountUin()) == 1)
      {
        MiniAppController.preloadMiniProcess();
        if (QLog.isColorLevel()) {
          QLog.d("FileAssistantActivity", 2, "doOnCreate, preload mini app process");
        }
      }
      this.cdf = getIntent().getBooleanExtra("COMEFROMDESK", false);
      paramBundle = new ahau.a();
      paramBundle.bJE = "file_asst_in";
      paramBundle.cYX = 11;
      ahau.a(this.app.getCurrentAccountUin(), paramBundle);
      if (ahav.S(this, getString(2131693537))) {
        break label548;
      }
      paramBundle = new int[this.lm.length + 1];
      arrayOfInt = new int[this.ln.length + 1];
      i = 0;
      while (i < this.lm.length)
      {
        paramBundle[i] = this.lm[i];
        i += 1;
      }
    }
    paramBundle[(paramBundle.length - 1)] = 2131693582;
    this.lm = paramBundle;
    int i = j;
    while (i < this.ln.length)
    {
      arrayOfInt[i] = this.ln[i];
      i += 1;
    }
    arrayOfInt[(arrayOfInt.length - 1)] = 2130845182;
    this.ln = arrayOfInt;
    label548:
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.dmJ();
    if (this.jdField_a_of_type_Aghq != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
    }
    this.app.unRegistObserver(this.e);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.mPaused = true;
    this.jdField_a_of_type_Awpk.a(null);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.rightViewText.setVisibility(8);
    this.b.setTitle(getString(2131693604));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.refreshUI();
    this.Ss.setText(2131692006);
    dga();
    refreshUI();
  }
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.ej(paramArrayList);
  }
  
  public void ek(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.ek(paramArrayList);
  }
  
  protected void gY()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131367039));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setAttribution(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.dmJ();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setHeaderScrollView(this.jdField_d_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(3, getString(2131693844));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(4, getString(2131693846));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(20, this.bGS);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(5, getString(2131693850));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(6, getString(2131693847));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.cw(7, getString(2131693845));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
  }
  
  public void iq()
  {
    if (this.Ss != null)
    {
      if (akL()) {
        this.Ss.setText(2131721058);
      }
    }
    else {
      return;
    }
    this.Ss.setText(2131692006);
  }
  
  public void m(Set<FileInfo> paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.m(paramSet);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131369430)
    {
      deO();
      if (akL())
      {
        this.Ss.setText(2131721058);
        this.b.setTitle(getString(2131693604));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.refreshUI();
        this.rightViewText.setVisibility(8);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ahau.JH("0X8009C32");
      this.Ss.setText(2131692006);
      break;
      if (i == 2131369475)
      {
        if (!CheckPermission.isHasStoragePermission(this)) {
          CheckPermission.requestSDCardPermission(this, new agff(this));
        } else {
          bLN();
        }
      }
      else
      {
        Object localObject;
        if (i == 2131369483)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("string_from", false);
          ((Bundle)localObject).putBoolean("string_uin", false);
          ((Bundle)localObject).putLong("device_din", 0L);
          ((Bundle)localObject).putInt("sTitleID", 0);
          avio.b(this, (Bundle)localObject, "com.qqdataline.mpfile.LiteMpFileMainActivity");
          if (this.cdf) {
            ahau.JH("0X8005539");
          } else {
            ahau.JH("0X800681F");
          }
        }
        else
        {
          if (i == 2131369548)
          {
            i = aqmj.bB(this, this.app.getCurrentAccountUin());
            if (i == 1)
            {
              localObject = aqmj.am(this, this.app.getCurrentAccountUin());
              i = aqmj.bC(this, this.app.getCurrentAccountUin());
              if (TextUtils.isEmpty((CharSequence)localObject)) {}
            }
            for (;;)
            {
              try
              {
                a(this, (String)localObject, i);
                if (!this.cdf) {
                  break label402;
                }
                ahau.JH("0X800553A");
                c(this.t, "100160.100164");
              }
              catch (MiniAppException localMiniAppException)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("FileAssistantActivity", 2, "fail to open weiyun mini app!");
                }
                dfZ();
                continue;
              }
              QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, apkgUrl = " + localMiniAppException + ", version = " + i);
              dfZ();
              continue;
              QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, weiYunGrayConfig = " + i);
              dfZ();
              continue;
              label402:
              ahau.JH("0X8006820");
            }
          }
          if (i == 2131369429)
          {
            ahau.JH("0X8009070");
            bLO();
            afdp.p(getAppInterface());
            c(this.u, "100160.100163");
          }
          else if (i == 2131369928)
          {
            this.jdField_a_of_type_Aepo.cXl();
            dfU();
          }
          else if (i == 2131380975)
          {
            this.jdField_a_of_type_Aepo.cXm();
            agiq localagiq = (agiq)this.app.getManager(317);
            if (localagiq != null)
            {
              localagiq.a().a().eh(this);
              dfU();
            }
          }
          else if (i == 2131379228)
          {
            ahau.JH("0X8009C33");
            dfW();
          }
        }
      }
    }
  }
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      if (this.jdField_d_of_type_Auuw == null) {
        sz();
      }
      paramInt = this.b.getWidth();
      int i = this.jdField_d_of_type_Auuw.getWidth();
      int j = getResources().getDimensionPixelSize(2131299275);
      this.jdField_d_of_type_Auuw.showAsDropDown(this.b, paramInt - i - j, 0);
      anot.a(this.app, "dc00898", "", "", "0X800A15E", "0X800A15E", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        deO();
        this.rightViewText.setVisibility(8);
        this.b.setTitle(getString(2131693604));
        return;
      }
    } while (paramInt != 1);
    finish();
  }
  
  public void refreshUI()
  {
    super.refreshUI();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.refreshUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */