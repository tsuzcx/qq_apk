package com.tencent.tim.teamworkforgroup;

import aaiy;
import acde;
import ajdr;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apuh;
import aqgx;
import aqha;
import aqiw;
import aqju;
import aqmf;
import aqmj;
import ateh;
import athu;
import atiz;
import atjx;
import aueh;
import augx;
import auhk.e;
import aujw;
import aujz;
import auko;
import aulh;
import aull;
import aulm;
import ault;
import aulw;
import auma;
import aumb;
import aumc;
import aumd;
import aume;
import aumf;
import aumg;
import aumh;
import aumi;
import aumj;
import aumk;
import auml;
import aumm;
import aumo;
import aump;
import aumq;
import aums;
import aumu;
import aumv;
import aumw;
import aumx;
import aumy;
import aurf;
import auuo;
import auuw.b;
import com.tencent.cloudfile.CloudFile;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.teamwork.TeamWorkAuthorizeSettingActivity;
import com.tencent.tim.teamwork.TeamWorkTransparentShareActivity;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;

public class GroupTeamWorkListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, augx, aujw, auuo, AbsListView.e
{
  public static String cjr = "key_qun_id";
  TextView Co;
  List<GroupPadTemplateInfo> GX = new ArrayList();
  private View HF;
  private View HG;
  private View HH;
  private View HI;
  private TextView MZ;
  private TextView Wg;
  private TextView ZQ;
  private aaiy jdField_a_of_type_Aaiy;
  private atjx jdField_a_of_type_Atjx;
  aulh jdField_a_of_type_Aulh;
  aull jdField_a_of_type_Aull;
  private auma jdField_a_of_type_Auma;
  public aumb a;
  aumx jdField_a_of_type_Aumx;
  private auuw.b jdField_a_of_type_Auuw$b = new aumw(this);
  private a jdField_a_of_type_ComTencentTimTeamworkforgroupGroupTeamWorkListActivity$a;
  List<GPadInfo> aa = new ArrayList();
  Comparator<PadInfo> ae = new aumd(this);
  private ProgressBar am;
  public long aoW;
  public Dialog az;
  private aulw jdField_b_of_type_Aulw;
  aumy jdField_b_of_type_Aumy = new aumm(this);
  public CloudSendBottomBar b;
  public int bQb = 0;
  EditText by;
  private AlphaAnimation jdField_c_of_type_AndroidViewAnimationAlphaAnimation;
  aulm jdField_c_of_type_Aulm = new aumo(this);
  private FPSSwipListView jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private boolean cLg;
  private boolean cLh;
  private boolean cLi;
  volatile boolean cLj = false;
  int cWz;
  private AlphaAnimation d;
  private volatile int dOc = 1;
  public int dOd;
  private boolean dhZ;
  private boolean dhu;
  private boolean dhx;
  private boolean djf;
  public boolean djg;
  private int epA;
  private int epB;
  private int epC;
  RelativeLayout fD;
  private PullRefreshHeader j;
  private aqju m;
  private View mEmptyView;
  private View mLoadingView;
  String mPeerUin;
  private View mRoot;
  private boolean ob;
  public final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  private ImageView vq;
  private View xR;
  private View xf;
  private HorizontalListView y;
  
  private int OJ()
  {
    if (this.bQb == 1) {
      return 1;
    }
    if (this.bQb == 2) {
      return 3;
    }
    return 4;
  }
  
  private void VG(int paramInt)
  {
    ThreadManager.postImmediately(new GroupTeamWorkListActivity.10(this, paramInt), null, true);
  }
  
  private void VH(int paramInt)
  {
    ThreadManager.postImmediately(new GroupTeamWorkListActivity.12(this, paramInt), null, true);
  }
  
  private void Vw(boolean paramBoolean)
  {
    this.dhx = paramBoolean;
    if (paramBoolean)
    {
      this.rightViewImg.setVisibility(8);
      this.MZ.setVisibility(0);
      this.MZ.setText(2131721058);
      this.leftView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.leftView.setText(2131691565);
      this.centerView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.centerView.setTextSize(20.0F);
      setTitle("已选1项");
      this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDragEnable(false);
      this.jdField_a_of_type_Auma.Vq(true);
      this.xR.setVisibility(0);
      findViewById(2131366197).setVisibility(4);
      findViewById(2131366199).setVisibility(4);
      this.vq.setEnabled(false);
      this.centerView.setOnClickListener(null);
      return;
    }
    aC();
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDragEnable(true);
    this.jdField_a_of_type_Auma.Vq(false);
    atiz.clearSelected();
    this.xR.setVisibility(8);
  }
  
  private void aC()
  {
    this.leftView.setText(getResources().getString(2131694535));
    this.leftView.setCompoundDrawablesWithIntrinsicBounds(2130851757, 0, 0, 0);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130840650);
    this.rightViewImg.setOnClickListener(this);
    this.MZ = ((TextView)findViewById(2131369612));
    this.rightViewText.setOnClickListener(this);
    this.MZ.setVisibility(8);
    this.centerView.setTextSize(16.0F);
    this.centerView.setTextColor(Color.parseColor("#000000"));
    this.centerView.setMaxEms(13);
    this.centerView.setText(getResources().getString(2131694533));
    this.centerView.setOnClickListener(this);
  }
  
  private void aC(View paramView, int paramInt)
  {
    if ((paramView == null) || (paramInt < 0)) {
      return;
    }
    if (this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation != null) {
      this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.cancel();
    }
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setDuration(paramInt);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation);
  }
  
  private void af(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = getString(2131720968);
    if (paramInt == 1)
    {
      localObject1 = aull.Az();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label187;
      }
    }
    for (;;)
    {
      Object localObject3 = getString(2131720968);
      Object localObject2 = localObject1;
      localObject1 = localObject3;
      for (;;)
      {
        if (this.cWz == 6000)
        {
          paramString2 = (acde)this.app.getBusinessHandler(8);
          if (paramString2 != null) {
            paramString2.a(paramString1, 0);
          }
          label78:
          return;
          if (paramInt != 2) {
            break label179;
          }
          localObject1 = aull.Az();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label171;
          }
        }
        for (;;)
        {
          localObject3 = getString(2131720969);
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
          localObject3 = new aujz(this, this.app);
          ((aujz)localObject3).g(paramString1, paramString2, (String)localObject1, (String)localObject2, paramInt);
          paramString1 = ((aujz)localObject3).d();
          if (paramString1 == null) {
            break label78;
          }
          aqmf.a(this.app, this.mPeerUin, this.cWz, paramString1, null);
          return;
          label171:
          localObject1 = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
        }
        label179:
        localObject2 = "";
      }
      label187:
      localObject1 = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
    }
  }
  
  private void d(Activity paramActivity, View paramView)
  {
    if ((paramActivity == null) || (paramView == null)) {
      return;
    }
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(paramView);
  }
  
  private void dUd()
  {
    if ((this.m == null) || (this.m.isShowing())) {}
    try
    {
      this.m.dismiss();
      this.m = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("GroupTeamWorkListActivity", 1, " dismiss exception: " + localException.toString());
      }
    }
  }
  
  public static void e(Activity paramActivity, View paramView)
  {
    if ((paramActivity == null) || (paramView == null)) {
      return;
    }
    ((ViewGroup)paramActivity.getWindow().getDecorView()).removeView(paramView);
  }
  
  private void evC()
  {
    if ((aull.b(this.app.getApp(), this.app.getCurrentAccountUin(), "key_team_work_guide_flag", 0) == 0) && (this.jdField_a_of_type_Aulh != null)) {
      this.jdField_a_of_type_Aulh.aaQ(1);
    }
  }
  
  private void i(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Aumb != null)
    {
      this.jdField_a_of_type_Aumb.h(paramLong, paramInt1, paramInt2, paramInt3);
      this.jdField_a_of_type_Aumb.lD(paramLong);
    }
  }
  
  private void i(PadInfo paramPadInfo)
  {
    dUd();
    if (paramPadInfo == null) {
      return;
    }
    String str3 = "";
    String str4 = getString(2131721079);
    String str1;
    String str2;
    if ((this.bQb == 1) || ((paramPadInfo.creatorUin > 0L) && (this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin))))) {
      if (paramPadInfo.type == 1)
      {
        str1 = getString(2131692517);
        str2 = getString(2131692498);
        if ((paramPadInfo.creatorUin <= 0L) || (!this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin)))) {
          break label401;
        }
        this.m = aqha.b(this, 230, null, str1, getString(2131692525), getString(2131721058), str2, new aumg(this), new aumh(this, paramPadInfo), new aumi(this));
      }
    }
    for (;;)
    {
      this.m.show();
      return;
      if (paramPadInfo.type == 2)
      {
        str1 = getString(2131692523);
        str2 = getString(2131692498);
        break;
      }
      if (paramPadInfo.type == 3)
      {
        str1 = getString(2131692519);
        str2 = getString(2131692498);
        break;
      }
      str1 = str3;
      str2 = str4;
      if (paramPadInfo.type != 4) {
        break;
      }
      str1 = getString(2131692521);
      str2 = getString(2131692498);
      break;
      str1 = str3;
      str2 = str4;
      if (!apuh.a(this.app, this.aoW, this.app.getCurrentAccountUin())) {
        break;
      }
      if (paramPadInfo.type == 1)
      {
        str1 = getString(2131692516);
        str2 = getString(2131692498);
        break;
      }
      if (paramPadInfo.type == 2)
      {
        str1 = getString(2131692522);
        str2 = getString(2131692498);
        break;
      }
      if (paramPadInfo.type == 3)
      {
        str1 = getString(2131692518);
        str2 = getString(2131692498);
        break;
      }
      str1 = str3;
      str2 = str4;
      if (paramPadInfo.type != 4) {
        break;
      }
      str1 = getString(2131692520);
      str2 = getString(2131692498);
      break;
      label401:
      this.m = aqha.a(this, 230).setMessage(str1);
      this.m.setPositiveButton(str2, new aumj(this, paramPadInfo));
      this.m.setNegativeButton(getString(2131721058), new aumk(this));
    }
  }
  
  private void initBottomBar()
  {
    this.xR = findViewById(2131366191);
    this.xR.setVisibility(8);
    this.vq = ((ImageView)findViewById(2131366194));
    this.vq.setOnClickListener(this);
  }
  
  private void initUI()
  {
    this.mRoot = findViewById(2131377546);
    this.mLoadingView = findViewById(2131379285);
    this.HI = findViewById(2131379284);
    this.HI.setOnClickListener(this);
    this.mEmptyView = findViewById(2131379270);
    this.Wg = ((TextView)findViewById(2131379272));
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)findViewById(2131370527));
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDragEnable(true);
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDivider(null);
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(getResources().getDrawable(2130839646));
    View localView = LayoutInflater.from(this).inflate(2131558988, this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).addView(localView);
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject);
    this.HF = LayoutInflater.from(this).inflate(2131563190, null);
    this.y = ((HorizontalListView)this.HF.findViewById(2131368191));
    this.y.setVisibility(0);
    if (this.y != null) {
      this.y.setDividerWidth(getResources().getDimensionPixelSize(2131297439));
    }
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.HF);
    this.Co = ((TextView)this.HF.findViewById(2131380917));
    this.by = ((EditText)this.HF.findViewById(2131366542));
    this.by.setCursorVisible(false);
    this.by.setOnFocusChangeListener(new aums(this));
    this.j = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559847, this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.j);
    this.HG = LayoutInflater.from(this).inflate(2131563168, null);
    this.HH = this.HG.findViewById(2131379288);
    this.ZQ = ((TextView)this.HG.findViewById(2131379287));
    this.am = ((ProgressBar)this.HG.findViewById(2131379286));
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.HG);
    aC();
    initBottomBar();
    this.fD = ((RelativeLayout)findViewById(2131377361));
    localObject = new ArrayList();
    ((List)localObject).add(aaiy.a);
    ((List)localObject).add(aaiy.b);
    ((List)localObject).add(aaiy.c);
    ((List)localObject).add(aaiy.d);
    this.jdField_a_of_type_Aaiy = new aaiy(this, (List)localObject, this.jdField_a_of_type_Auuw$b);
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
    this.mLoadingView.setVisibility(0);
    localObject = getIntent();
    this.epA = getIntent().getExtras().getInt("key_file_browser_mode", -1);
    this.dhZ = getIntent().getExtras().getBoolean("key_is_from_aio_cloud_selector", false);
    if (this.epA != 2)
    {
      this.djg = false;
      if (this.djg)
      {
        this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar = ((CloudSendBottomBar)findViewById(2131377980));
        this.epB = getIntent().getExtras().getInt("key_bottom_bar_right_action", 4);
        this.epC = getIntent().getExtras().getInt("key_bottom_bar_left_action", 2);
        if (!getIntent().getBooleanExtra("from_aio", false)) {
          break label867;
        }
        this.rightViewText.setVisibility(8);
        label649:
        this.MZ.setText(2131721058);
        this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDragEnable(false);
        this.jdField_a_of_type_Auma.Vq(true);
        this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setLeftAction(this.epC);
        this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setRightAction(this.epB);
        this.cWz = ((Intent)localObject).getIntExtra("peerType", -1);
        this.mPeerUin = ((Intent)localObject).getStringExtra("targetUin");
        if ((this.cWz != -1) && (this.mPeerUin != null))
        {
          atiz.YO(((Intent)localObject).getStringExtra("targetUin"));
          atiz.YP(((Intent)localObject).getStringExtra("srcDiscGroup"));
          atiz.aav(((Intent)localObject).getIntExtra("peerType", 0));
        }
      }
      if (!aqmj.e(this, this.app.getCurrentUin(), 1)) {
        break label887;
      }
      new aumu(this);
      localView.setVisibility(0);
      localObject = (TextView)localView.findViewById(2131364729);
      FixSizeImageView localFixSizeImageView = (FixSizeImageView)localView.findViewById(2131364728);
      ((TextView)localObject).setText(getString(2131691564));
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      localFixSizeImageView.setOnClickListener(new aumv(this, localView));
    }
    for (;;)
    {
      this.jdField_a_of_type_Auma.setMode(this.epA);
      return;
      this.djg = true;
      break;
      label867:
      this.MZ.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      break label649;
      label887:
      localView.setVisibility(8);
    }
  }
  
  private void j(PadInfo paramPadInfo)
  {
    Intent localIntent = new Intent(getApplicationContext(), TeamWorkAuthorizeSettingActivity.class);
    localIntent.putExtra("team_work_name", paramPadInfo.title);
    localIntent.putExtra("team_work_pad_url", paramPadInfo.pad_url);
    localIntent.putExtra("team_work_pad_list_type", paramPadInfo.type_list);
    startActivityForResult(localIntent, 1002);
  }
  
  private void lz(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.am.setVisibility(0);
      this.ZQ.setText(2131720954);
      this.HH.setVisibility(0);
      return;
    }
    this.am.setVisibility(8);
    this.ZQ.setText(2131720963);
    this.HH.setVisibility(0);
  }
  
  private void my(List<GPadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.aa.clear();
    this.aa.addAll(paramList);
  }
  
  private void mz(List<GroupPadTemplateInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.GX.clear();
    this.GX.addAll(paramList);
  }
  
  private void setHideAnimation(View paramView, int paramInt)
  {
    if ((paramView == null) || (paramInt < 0)) {
      return;
    }
    if (this.d != null) {
      this.d.cancel();
    }
    this.d = new AlphaAnimation(1.0F, 0.0F);
    this.d.setDuration(paramInt);
    this.d.setFillAfter(true);
    paramView.startAnimation(this.d);
  }
  
  public boolean Pp()
  {
    return isResume();
  }
  
  public void VI(int paramInt)
  {
    if (paramInt == 1) {
      this.cLj = true;
    }
    while (paramInt != 2) {
      return;
    }
    this.cLj = false;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).Q(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).S(0L);
    i(this.aoW, 0, 20, 2);
    this.ob = true;
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).R(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(PadInfo paramPadInfo)
  {
    if ((paramPadInfo != null) && (!TextUtils.isEmpty(paramPadInfo.pad_url))) {
      i(paramPadInfo);
    }
  }
  
  public void d(PadInfo paramPadInfo)
  {
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131693404), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
    }
    while ((this.jdField_a_of_type_Aulh == null) || (paramPadInfo == null) || (TextUtils.isEmpty(paramPadInfo.pad_url))) {
      return;
    }
    this.jdField_a_of_type_Aulh.eq(OJ(), paramPadInfo.pad_url);
    VI(1);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupTeamWorkListActivity", 2, " onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramInt1 == 14001) {
      if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getStringExtra("groupCode"))))
      {
        boolean bool = paramIntent.getBooleanExtra("is_add_link_to_troop", false);
        if (paramIntent.getBooleanExtra("is_delete_new_teamwork_file", false))
        {
          paramIntent.getStringExtra("groupCode");
          paramIntent = paramIntent.getStringExtra("url");
          ((aulh)this.app.getBusinessHandler(122)).Zp(paramIntent);
          return;
        }
        if (bool)
        {
          ??? = paramIntent.getStringExtra("groupCode");
          localObject2 = paramIntent.getStringExtra("domainId");
          localObject3 = paramIntent.getStringExtra("localPadId");
          localObject4 = paramIntent.getStringExtra("title");
          paramIntent.getIntExtra("key_team_work_edit_type", 0);
          if ((TextUtils.isEmpty((CharSequence)???)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (this.jdField_a_of_type_Aumb == null)) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        online_docs.DocId localDocId = ault.a(Integer.parseInt((String)localObject2), (String)localObject3);
        this.jdField_a_of_type_Aumb.a(Long.parseLong((String)???), localDocId, (String)localObject4);
        if (QLog.isColorLevel()) {
          QLog.i("GroupTeamWorkListActivity", 2, " onActivityResult groupCode=" + (String)??? + " domainId = " + (String)localObject2 + " padind= " + (String)localObject3);
        }
        i(this.aoW, 0, 20, 1);
        this.cLi = true;
        if ((paramInt2 != -1) || (paramInt1 != 4)) {
          break label752;
        }
        if (paramIntent == null) {
          break label797;
        }
        ??? = (FileInfo)paramIntent.getParcelableExtra("key_selected_dir");
        localObject2 = this.jdField_a_of_type_Atjx.a(3);
        if ((??? == null) || (atiz.Ou() <= 0)) {
          break label747;
        }
        localObject3 = atiz.eo().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label747;
        }
        localObject4 = ((Iterator)localObject3).next();
        if (!(localObject4 instanceof PadInfo)) {
          break label691;
        }
        ((ateh)this.app.getBusinessHandler(180)).a(((FileInfo)???).Y(), athu.a((PadInfo)localObject4));
        continue;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("GroupTeamWorkListActivity", 2, " exception e =" + localException.toString());
        continue;
      }
      GPadInfo localGPadInfo;
      if (paramInt1 == 1002)
      {
        if (paramInt2 == 1122)
        {
          ??? = paramIntent.getStringExtra("url");
          paramIntent.getIntExtra("type", -1);
          localObject2 = this.jdField_a_of_type_Aumx.a((String)???);
          if (localObject2 != null)
          {
            synchronized (this.aa)
            {
              localObject3 = this.aa.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localGPadInfo = (GPadInfo)((Iterator)localObject3).next();
                if (localGPadInfo.pad_url.equals(((GPadInfo)localObject2).pad_url)) {
                  localGPadInfo.copyFrom((PadInfo)localObject2);
                }
              }
            }
            this.jdField_a_of_type_Auma.notifyDataSetChanged();
          }
          QQToast.a(this, 2, "权限设置成功", 0).show(getTitleBarHeight());
        }
      }
      else {
        label797:
        if ((paramInt1 == 13) && (paramInt2 == -1) && (paramIntent != null))
        {
          int i = paramIntent.getIntExtra("key_type_domain_id", 0);
          localObject2 = paramIntent.getStringExtra("key_type_pad_id");
          ??? = paramIntent.getStringExtra("key_type_title");
          localObject2 = ault.a(i, (String)localObject2);
          ((aumb)this.app.getBusinessHandler(143)).b(this.aoW, (online_docs.DocId)localObject2, (String)???);
          continue;
          label691:
          if (((localGPadInfo instanceof FileManagerEntity)) && (localObject2 != null) && (((FileInfo)???).Y() != null))
          {
            ((auhk.e)localObject2).a(((FileManagerEntity)localGPadInfo).cloudFile.pLogicDirKey, aueh.a((FileManagerEntity)localGPadInfo), ((FileInfo)???).Y(), 4);
            continue;
            label747:
            Vw(false);
            label752:
            if (paramInt2 == 11011)
            {
              af(paramIntent.getStringExtra("url"), paramIntent.getStringExtra("title"), paramIntent.getIntExtra("type", -1));
              finish();
            }
            super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
            return;
            ??? = null;
          }
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559421);
    this.aoW = getIntent().getLongExtra(cjr, 0L);
    this.jdField_a_of_type_Aumb = ((aumb)this.app.getBusinessHandler(143));
    this.jdField_a_of_type_Aumx = ((aumx)this.app.getManager(304));
    this.jdField_a_of_type_Aulh = ((aulh)this.app.getBusinessHandler(122));
    this.jdField_a_of_type_Aull = ((aull)this.app.getManager(372));
    this.jdField_a_of_type_Auma = new auma(this.app, this, this, this, null);
    initUI();
    this.app.addObserver(this.jdField_b_of_type_Aumy);
    this.app.addObserver(this.jdField_c_of_type_Aulm);
    VG(1);
    ((ajdr)this.app.getManager(37)).b(this.app.getApp(), String.valueOf(this.aoW), "TIM_GROUP_TM_REDDOT", false);
    ((aumb)this.app.getBusinessHandler(143)).lE(this.aoW);
    aqgx.k(this.app.getCurrentAccountUin(), "group_file_reddot_tim", String.valueOf(this.aoW), false);
    this.cLi = true;
    this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Auma);
    this.jdField_a_of_type_Auma.a(new aumc(this));
    this.jdField_a_of_type_Auma.setOnClickListener(new auml(this));
    if (!this.djg) {}
    this.leftView.setOnClickListener(new aump(this));
    this.jdField_a_of_type_Auma.mx(this.aa);
    this.jdField_a_of_type_Auma.Vq(this.djg);
    this.jdField_b_of_type_Aulw = new aulw(this, this);
    VH(1);
    this.y.setAdapter(this.jdField_b_of_type_Aulw);
    this.jdField_b_of_type_Aulw.setData(this.GX);
    if (this.jdField_b_of_type_Aulw != null) {
      this.jdField_b_of_type_Aulw.notifyDataSetChanged();
    }
    this.jdField_b_of_type_Aulw.setOnClickListener(new aumq(this));
    this.jdField_a_of_type_Atjx = new atjx(this.app, this, this);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aaiy != null) {
      this.jdField_a_of_type_Aaiy.dismiss();
    }
    if (this.uiHandler != null)
    {
      this.uiHandler.removeMessages(114);
      this.uiHandler.removeMessages(111);
      this.uiHandler.removeMessages(112);
    }
    this.app.removeObserver(this.jdField_b_of_type_Aumy);
    this.app.removeObserver(this.jdField_c_of_type_Aulm);
    dUd();
    if (this.jdField_a_of_type_ComTencentTimTeamworkforgroupGroupTeamWorkListActivity$a != null)
    {
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_ComTencentTimTeamworkforgroupGroupTeamWorkListActivity$a);
      this.jdField_a_of_type_ComTencentTimTeamworkforgroupGroupTeamWorkListActivity$a = null;
    }
    if (this.d != null) {
      this.d.cancel();
    }
    if (this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation != null) {
      this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.cancel();
    }
    if (this.jdField_a_of_type_Atjx != null) {
      this.jdField_a_of_type_Atjx.onDestroy();
    }
    if (this.jdField_a_of_type_Auma != null) {
      this.jdField_a_of_type_Auma.onDestroy();
    }
    if (this.jdField_b_of_type_Aulw != null) {
      this.jdField_b_of_type_Aulw = null;
    }
    if (!this.dhZ) {
      atiz.clearSelected();
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Aaiy != null) {
      this.jdField_a_of_type_Aaiy.dismiss();
    }
    if (this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null) {
      this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.doOnPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentTimTeamworkforgroupGroupTeamWorkListActivity$a == null)
    {
      this.jdField_a_of_type_ComTencentTimTeamworkforgroupGroupTeamWorkListActivity$a = new a(this);
      Looper.myQueue().addIdleHandler(this.jdField_a_of_type_ComTencentTimTeamworkforgroupGroupTeamWorkListActivity$a);
    }
    if (this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null) {
      this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.doOnResume();
    }
    ThreadManager.getUIHandler().postDelayed(new GroupTeamWorkListActivity.5(this), 100L);
  }
  
  public void e(PadInfo paramPadInfo)
  {
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131693404), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
    }
    while ((this.jdField_a_of_type_Aulh == null) || (paramPadInfo == null) || (TextUtils.isEmpty(paramPadInfo.pad_url))) {
      return;
    }
    this.jdField_a_of_type_Aulh.er(OJ(), paramPadInfo.pad_url);
    VI(1);
  }
  
  public void f(PadInfo paramPadInfo)
  {
    if ((paramPadInfo != null) && (!TextUtils.isEmpty(paramPadInfo.pad_url)))
    {
      String str1 = paramPadInfo.pad_url;
      String str2 = paramPadInfo.title;
      String str3 = String.valueOf(paramPadInfo.creatorUin);
      Intent localIntent = new Intent(getApplicationContext(), TeamWorkTransparentShareActivity.class);
      if ((!TextUtils.isEmpty(str3)) && (str3.equals(getCurrentAccountUin()))) {
        localIntent.putExtra("team_is_my_document", true);
      }
      if (!TextUtils.isEmpty(str2)) {
        localIntent.putExtra(auko.cjn, str2);
      }
      if (!TextUtils.isEmpty(str1)) {
        localIntent.putExtra("team_work_pad_url", str1);
      }
      localIntent.putExtra("team_policy", paramPadInfo.policy);
      localIntent.putExtra("team_work_pad_list_type", paramPadInfo.type_list);
      localIntent.putExtra("team_work_pad_type", paramPadInfo.type);
      localIntent.putExtra("from_activity", "GroupTeamWorkListActivity");
      localIntent.putExtra("select_type", this.bQb);
      overridePendingTransition(0, 0);
      startActivity(localIntent);
    }
  }
  
  public void g(PadInfo paramPadInfo)
  {
    j(paramPadInfo);
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.j != null)
      {
        if (???.arg1 != 1) {
          break label93;
        }
        this.j.tT(0);
      }
      for (;;)
      {
        ??? = new Message();
        ???.what = 112;
        this.uiHandler.sendMessageDelayed(???, 500L);
        return true;
        label93:
        this.j.tT(1);
      }
      if (this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {
        continue;
      }
      this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.springBackOverScrollHeaderView();
      return true;
      if (this.jdField_a_of_type_Auma == null) {
        continue;
      }
      int i = ???.arg1;
      i = ???.arg2;
      if (i == 4) {
        lz(false);
      }
      for (;;)
      {
        synchronized (this.aa)
        {
          this.jdField_a_of_type_Auma.mx(this.aa);
          if (i == 1)
          {
            if (this.jdField_a_of_type_Auma.getCount() > 0)
            {
              if (this.mLoadingView.getVisibility() == 0) {
                this.mLoadingView.setVisibility(8);
              }
              if (this.mEmptyView.getVisibility() == 0) {
                this.mEmptyView.setVisibility(8);
              }
              this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
              if ((this.djg) && (this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.getVisibility() == 8)) {
                this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setVisibility(0);
              }
              if (this.cLi) {
                VI(1);
              }
            }
            if ((!this.cLj) && (i != 5)) {
              break;
            }
            VI(2);
            return true;
          }
        }
        if (this.jdField_a_of_type_Auma.getCount() > 0)
        {
          if (this.mLoadingView.getVisibility() == 0) {
            this.mLoadingView.setVisibility(8);
          }
          if (this.mEmptyView.getVisibility() == 0) {
            this.mEmptyView.setVisibility(8);
          }
          if ((this.djg) && (this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.getVisibility() == 8)) {
            this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setVisibility(0);
          }
          this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
          if (this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition() - this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() + 1 >= this.jdField_a_of_type_Auma.getCount()) {
            this.HH.setVisibility(8);
          }
        }
        else
        {
          if (this.mLoadingView.getVisibility() == 0) {
            this.mLoadingView.setVisibility(8);
          }
          if (this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
            this.jdField_c_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
          }
          if ((this.djg) && (this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.getVisibility() == 0)) {
            this.jdField_b_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setVisibility(8);
          }
          this.mEmptyView.setVisibility(0);
        }
      }
      this.uiHandler.removeMessages(114);
      if (this.am.getVisibility() != 8) {
        continue;
      }
      this.HH.setVisibility(8);
      return true;
      if (this.jdField_b_of_type_Aulw == null) {
        continue;
      }
      synchronized (this.GX)
      {
        this.jdField_b_of_type_Aulw.setData(this.GX);
        if (this.jdField_b_of_type_Aulw.getCount() <= 0) {
          continue;
        }
        this.y.setVisibility(0);
        return true;
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Aaiy != null) {
      this.jdField_a_of_type_Aaiy.dismiss();
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
      if (this.jdField_a_of_type_Aaiy != null)
      {
        this.jdField_a_of_type_Aaiy.t(this.fD, this.fD.getWidth() - getResources().getDimensionPixelSize(2131299279), getResources().getDimensionPixelSize(2131299276));
        continue;
        i(this.aoW, 0, 20, 1);
        this.HI.setVisibility(8);
        this.mLoadingView.setVisibility(0);
        continue;
        setHideAnimation(this.xf, 200);
        e(this, this.xf);
        this.djf = false;
        if (this.jdField_a_of_type_Aulh != null)
        {
          this.jdField_a_of_type_Aulh.kV(1, 1);
          continue;
          if (this.djg)
          {
            setResult(-1);
            finish();
          }
          else if (this.dhx)
          {
            Vw(false);
            continue;
            Object localObject = atiz.ek();
            if (((List)localObject).size() == 1)
            {
              c((PadInfo)((List)localObject).get(0));
            }
            else
            {
              ArrayList localArrayList = new ArrayList();
              String str = "你正在批量删除腾讯文档，确定删除吗？";
              localObject = ((List)localObject).iterator();
              int i = 1;
              if (((Iterator)localObject).hasNext())
              {
                PadInfo localPadInfo = (PadInfo)((Iterator)localObject).next();
                if ((localPadInfo.creatorUin > 0L) && (this.app.getLongAccountUin() == localPadInfo.creatorUin)) {
                  str = "部分腾讯文档是由你创建的，不允许批量删除。如确认要删除这些文档，请手动逐个删除。";
                }
                for (;;)
                {
                  break;
                  localArrayList.add(localPadInfo);
                  i = 0;
                }
              }
              this.m = aqha.a(this, 230).setMessage(str);
              this.m.setPositiveButton(getString(2131691042), new aume(this, localArrayList));
              if (i == 0) {
                this.m.setNegativeButton(getString(2131721058), new aumf(this));
              }
              this.m.show();
            }
          }
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 != 0) && (paramInt1 + paramInt2 == paramInt3))
    {
      this.cLg = true;
      if (paramInt3 <= paramInt2)
      {
        this.cLh = false;
        return;
      }
      this.cLh = true;
      return;
    }
    this.cLg = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if ((this.cLg) && (this.jdField_a_of_type_Auma != null) && (this.jdField_a_of_type_Auma.getCount() > 0) && (this.cLh) && (paramInt != 0))
      {
        if (this.dOd == 0) {
          break;
        }
        lz(true);
        i(this.aoW, this.dOd, 20, 3);
      }
      return;
    }
    lz(false);
    this.uiHandler.sendEmptyMessageDelayed(114, 1500L);
  }
  
  static class a
    implements MessageQueue.IdleHandler
  {
    private WeakReference<GroupTeamWorkListActivity> weakReference;
    
    public a(GroupTeamWorkListActivity paramGroupTeamWorkListActivity)
    {
      this.weakReference = new WeakReference(paramGroupTeamWorkListActivity);
    }
    
    public boolean queueIdle()
    {
      GroupTeamWorkListActivity localGroupTeamWorkListActivity = (GroupTeamWorkListActivity)this.weakReference.get();
      if (localGroupTeamWorkListActivity != null) {
        GroupTeamWorkListActivity.b(localGroupTeamWorkListActivity);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity
 * JD-Core Version:    0.7.0.1
 */