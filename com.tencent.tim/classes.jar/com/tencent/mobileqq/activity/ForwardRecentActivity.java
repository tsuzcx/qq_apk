package com.tencent.mobileqq.activity;

import Wallet.PfaFriend;
import abej;
import abej.a;
import abej.b;
import acbn;
import acbo;
import acfd;
import acfp;
import ackv;
import acnd;
import acxw;
import aeuh;
import aeui;
import ahgg.a;
import ahgq;
import ahhc;
import ahhg;
import ahhw;
import ahix;
import ahkr;
import ahlx;
import amsf.a;
import amxk;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anov;
import apuh;
import aqcl;
import aqdf;
import aqha;
import aqhr;
import aqiw;
import aqla;
import aqmr;
import arts;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.ResultRecord.a;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.forward.ForwardBaseActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCClient;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ocp;
import syw;
import tas;
import uxh;
import uxi;
import uxj;
import uxk;
import uxl;
import uxm;
import uxn;
import uxo;
import uxp;
import uxq;
import uxr;
import uxs;
import uxt;
import uxu;
import uxv;
import uxw;
import uxx;
import uxy;
import uxz;
import uya;
import wja;
import zzn;
import zzn.a;

public class ForwardRecentActivity
  extends ForwardBaseActivity
  implements ahhg, zzn.a
{
  public static int bGS = 1;
  public static int bGT = 2;
  TextView Dk;
  TextView Dl;
  TextView Dm;
  public int EP = 0;
  private Dialog N;
  public int ZO = -1;
  private abej.b jdField_a_of_type_Abej$b = new uxl(this);
  private abej jdField_a_of_type_Abej;
  private acnd jdField_a_of_type_Acnd = new uxj(this);
  public ahgq a;
  private aqdf jdField_a_of_type_Aqdf;
  private SelectedAndSearchBar.b jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$b = new uxm(this);
  SelectedAndSearchBar jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar;
  private ForwardRecentItemView jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView;
  private BroadcastReceiver aA;
  private int aDC;
  String aMZ;
  public String aNa;
  public FrameLayout aS;
  boolean aWa = false;
  private boolean aWb;
  public boolean aWc = false;
  boolean aWd = false;
  public boolean aWe = false;
  boolean aWf = false;
  boolean aWg = false;
  boolean aWh = false;
  public boolean aWi = false;
  public boolean aWj = false;
  private boolean aWk;
  boolean aWl = false;
  public String appid = "";
  private BroadcastReceiver az;
  private acbo jdField_b_of_type_Acbo = new uxk(this);
  private amsf.a jdField_b_of_type_Amsf$a = new uxn(this);
  private ForwardRecentItemView jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView;
  private ContactSearchFragment jdField_b_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  public TipsBar b;
  public int bGQ = 0;
  int bGR = -1;
  private String businessId;
  private acfd jdField_c_of_type_Acfd = new uxi(this);
  FormItemRelativeLayout jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  FormItemRelativeLayout d;
  private View.OnClickListener di = new uxh(this);
  private View.OnClickListener dj = new uxr(this);
  private View.OnClickListener dk = new uxs(this);
  FormItemRelativeLayout e;
  FormItemRelativeLayout f;
  RelativeLayout fD;
  LinearLayout fY;
  private LinearLayout fZ;
  FormItemRelativeLayout g;
  private Map<String, ResultRecord> hi = new LinkedHashMap();
  public boolean isSdkShare = false;
  private DataSetObserver mDataSetObserver;
  private InputMethodManager mImm;
  private XListView mListView;
  protected List<RecentUser> qK;
  private View sB;
  View sC;
  private TextView title;
  int uinType;
  public Uri w;
  
  public ForwardRecentActivity()
  {
    this.jdField_a_of_type_Ahgq = null;
  }
  
  private void AI(int paramInt)
  {
    int i = 32;
    if (this.jdField_a_of_type_Ahgq.e(ahgg.a.S)) {
      i = 33;
    }
    paramInt = i;
    if (this.jdField_a_of_type_Ahgq.e(ahgg.a.Y)) {
      paramInt = i | 0x100;
    }
    i = paramInt;
    if (this.jdField_a_of_type_Ahgq.e(ahgg.a.Z)) {
      i = paramInt | 0x4;
    }
    paramInt = i;
    if (this.jdField_a_of_type_Ahgq.e(ahgg.a.U)) {
      paramInt = i | 0x8;
    }
    if (this.jdField_a_of_type_Ahgq.e(ahgg.a.T)) {
      paramInt = paramInt | 0x10 | 0x200000 | 0x400000;
    }
    for (;;)
    {
      long l = -1L;
      if ((this.jdField_a_of_type_Ahgq instanceof ahlx)) {
        l = 1L;
      }
      ContactSearchComponentActivity.a(this, null, 7, paramInt, 561243, l);
      anot.a(this.app, "CliOper", "", "", "0X8004049", "0X8004049", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private boolean E(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.hi.containsKey(R(paramString, paramInt));
  }
  
  private boolean Pv()
  {
    return this.aDC == 1;
  }
  
  private String R(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  public static void a(Intent paramIntent, Object paramObject)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramObject != null)) {
      if (!(paramObject instanceof Activity)) {
        break label176;
      }
    }
    label176:
    for (boolean bool = ((Activity)paramObject).isFinishing();; bool = false)
    {
      ResultReceiver localResultReceiver;
      if (!bool)
      {
        localResultReceiver = (ResultReceiver)paramIntent.getParcelableExtra("PARAM_ActivityResultReceiver");
        if (localResultReceiver == null) {}
      }
      try
      {
        Field localField = Activity.class.getDeclaredField("mResultCode");
        localField.setAccessible(true);
        i = ((Integer)localField.get(paramObject)).intValue();
        if (QLog.isDevelopLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 1, "notifyResultReceiver, resultReceiver[" + localResultReceiver + "]", new Throwable("打印调用栈"));
        }
        localResultReceiver.send(i, paramIntent.getExtras());
        return;
      }
      catch (NoSuchFieldException paramObject)
      {
        for (;;)
        {
          QLog.w("ForwardOption.ForwardEntranceActivity", 1, "finish, get mResultCode NoSuchFieldException", paramObject);
          i = 0;
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.w("ForwardOption.ForwardEntranceActivity", 1, "finish, get mResultCode fail", paramObject);
          int i = 0;
        }
      }
    }
  }
  
  private boolean a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return false;
    }
    Object localObject = R(paramResultRecord.uin, paramResultRecord.lk());
    ResultRecord localResultRecord = (ResultRecord)this.hi.get(localObject);
    if (localResultRecord != null)
    {
      localResultRecord.MO = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.hi.values());
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X(paramResultRecord, false);
      return false;
    }
    if (this.hi.size() == 9)
    {
      bNV();
      return false;
    }
    paramResultRecord = ResultRecord.a(paramResultRecord);
    paramResultRecord.MO = SystemClock.elapsedRealtime();
    this.hi.put(localObject, paramResultRecord);
    bNR();
    paramResultRecord = new ArrayList(this.hi.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X(paramResultRecord, true);
    paramResultRecord = new ArrayList();
    localObject = this.hi.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      paramResultRecord.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
      this.jdField_b_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.N(paramResultRecord, paramResultRecord);
    }
    return true;
  }
  
  private List<RecentUser> aD(List<RecentUser> paramList)
  {
    return this.jdField_a_of_type_Ahgq.aD(paramList);
  }
  
  private ArrayList<ResultRecord> bD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "getResultRecord() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    ArrayList localArrayList = new ArrayList();
    ListAdapter localListAdapter = this.mListView.getAdapter();
    int j = localListAdapter.getCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = localListAdapter.getItem(i);
      if (!(localObject instanceof abej.a))
      {
        i += 1;
      }
      else
      {
        localObject = (abej.a)localObject;
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = ((abej.a)localObject).uin;
        if (((abej.a)localObject).b != null) {
          localResultRecord.type = ((abej.a)localObject).b.getType();
        }
        if ((localResultRecord.type == 1) && (!apuh.ra(localResultRecord.uin))) {}
        for (boolean bool = true;; bool = false)
        {
          localResultRecord.isNewTroop = bool;
          localResultRecord.name = ((abej.a)localObject).name;
          localArrayList.add(localResultRecord);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void bJo()
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    Object localObject1 = new Bundle(this.jdField_a_of_type_Ahgq.getExtras());
    ((Bundle)localObject1).putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Bundle)localObject1).putBoolean("PhotoConst.IS_FORWARD", true);
    ((Bundle)localObject1).putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    ((Bundle)localObject1).putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    localIntent.putExtra("isBack2Root", false);
    localIntent.putExtras((Bundle)localObject1);
    Object localObject2 = ((Bundle)localObject1).getString("GALLERY.FORWORD_LOCAL_PATH");
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = (syw)this.app.getBusinessHandler(51);
    try
    {
      bool = ((syw)localObject2).i(Long.parseLong(localIntent.getStringExtra("uin")), 17);
      if (bool)
      {
        localIntent.putExtra("send_in_background", true);
        localIntent.putExtra("sIsCloudPrinter", true);
        PhotoUtils.a(this, localIntent, (ArrayList)localObject1, 0, true);
        if (aqiw.getSystemNetwork(BaseApplication.getContext()) != 0) {
          QQToast.a(this.app.getApp(), 2, 2131693980, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        PhotoUtils.a(this, localIntent, (ArrayList)localObject1, 0, false);
      }
    }
  }
  
  private void bM(Intent paramIntent)
  {
    boolean bool2 = false;
    String str = paramIntent.getStringExtra("caller_name");
    int i = paramIntent.getIntExtra("selection_mode", 0);
    if (i == 2)
    {
      this.aWi = false;
      return;
    }
    if (i == 1)
    {
      this.aWi = true;
      return;
    }
    if (("SplashActivity".equals(str)) || ("ChatActivity".equals(str)) || ("LiteActivity".equals(str)) || ("ChatHistoryActivity".equals(str))) {
      this.aWg = true;
    }
    boolean bool1;
    if ((!paramIntent.getBooleanExtra("only_single_selection", false)) && (this.jdField_a_of_type_Ahgq.ann()))
    {
      bool1 = bool2;
      if (!this.aWg)
      {
        bool1 = bool2;
        if (!this.aWh)
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_Ahgq.ant()) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    this.aWi = bool1;
  }
  
  private void bN(Intent paramIntent)
  {
    if (this.isSdkShare)
    {
      bOf();
      paramIntent.putExtra("param_bind_finish", true);
    }
  }
  
  private void bNR()
  {
    this.Dk.setEllipsize(null);
    this.Dk.setMaxWidth(2147483647);
    if (this.hi.isEmpty())
    {
      this.Dk.setText(acfp.m(2131706491));
      this.Dk.setClickable(false);
      this.Dk.setTextColor(getResources().getColor(2131167321));
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        this.Dk.setContentDescription(this.Dk.getText());
      }
      return;
      this.Dk.setText(String.format(acfp.m(2131706481), new Object[] { Integer.valueOf(this.hi.size()) }));
      this.Dk.setClickable(true);
      this.Dk.setTextColor(getResources().getColor(2131167320));
    }
  }
  
  private void bNT()
  {
    this.mImm = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)super.findViewById(2131377961));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.fO(0L);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.v(new uxo(this));
  }
  
  private void bNU()
  {
    this.mImm.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.bVl();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.bVm();
    this.aS.setVisibility(8);
  }
  
  private void bNV()
  {
    if (this.N == null) {
      this.N = aqha.a(this, getString(2131701227), 0, 2131696701, null, new uxq(this));
    }
    if (!isFinishing()) {
      this.N.show();
    }
  }
  
  private void bNW()
  {
    if (this.hi.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, "forward2MultiTargets no forward target !");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList(this.hi.values());
    Collections.sort(localArrayList, new ResultRecord.a());
    Bundle localBundle = new Bundle();
    localBundle.putInt("chooseFriendFrom", aqla.as.intValue());
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    localBundle.putBoolean("from_outside_share", this.aWe);
    localBundle.putBoolean("from_dataline_aio", this.aWf);
    this.jdField_a_of_type_Ahgq.H(ahgg.a.R.intValue(), localBundle);
    this.jdField_a_of_type_Ahgq.cph();
  }
  
  private void bNX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "registerListViewDataSetChangedObserver() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    if (this.mDataSetObserver == null) {
      this.mDataSetObserver = new uxt(this);
    }
    ListAdapter localListAdapter = this.mListView.getAdapter();
    if (localListAdapter != null) {
      localListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ForwardOption.ForwardEntranceActivity", 2, "registerListViewDataSetChangedObserver() adapter is null");
  }
  
  private void bNY()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.setAlpha(0.0F);
    localViewGroup.setBackgroundDrawable(null);
    getWindow().setBackgroundDrawable(null);
    localViewGroup.removeAllViews();
  }
  
  private void bNZ()
  {
    this.Dk = ((TextView)super.findViewById(2131369612));
    this.Dl = ((TextView)super.findViewById(2131369581));
    if (!this.aWi)
    {
      this.Dk.setVisibility(0);
      this.Dk.setText(acfp.m(2131706489));
      this.Dk.setOnClickListener(this.di);
      this.Dl.setVisibility(0);
      this.Dl.setOnClickListener(this.di);
      this.Dl.setText(acfp.m(2131706495));
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Dk.getLayoutParams();
      localLayoutParams.rightMargin = wja.dp2px(10.0F, getResources());
      if (Build.VERSION.SDK_INT <= 18) {
        localLayoutParams.width = wja.dp2px(75.0F, getResources());
      }
      this.Dk.setLayoutParams(localLayoutParams);
      this.Dk.setPadding(wja.dp2px(7.0F, getResources()), 0, wja.dp2px(7.0F, getResources()), 0);
      if (AppSetting.enableTalkBack)
      {
        this.Dk.setContentDescription(this.Dk.getText());
        this.Dl.setContentDescription(this.Dl.getText());
      }
      return;
      this.Dl.setVisibility(8);
      this.Dk.setVisibility(0);
      this.Dk.setText(acfp.m(2131706494));
      this.Dk.setOnClickListener(this.di);
    }
  }
  
  private void bOa()
  {
    this.sB = LayoutInflater.from(this).inflate(2131559342, this.mListView, false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.sB.setOverScrollMode(2);
    }
    if (this.uinType != 9501) {
      this.mListView.addHeaderView(this.sB);
    }
    this.fZ = ((LinearLayout)this.sB.findViewById(2131370661));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.sB.findViewById(2131367505));
    this.d = ((FormItemRelativeLayout)this.sB.findViewById(2131367508));
    this.e = ((FormItemRelativeLayout)this.sB.findViewById(2131367512));
    this.f = ((FormItemRelativeLayout)this.sB.findViewById(2131367507));
    this.g = ((FormItemRelativeLayout)this.sB.findViewById(2131367509));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.sB.findViewById(2131379265));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
    this.e.setBGType(2);
    this.f.setBGType(3);
    this.d.setBGType(2);
    this.g.setBGType(0);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839637);
    this.d.setBackgroundResource(2130839637);
    this.e.setBackgroundResource(2130839637);
    this.f.setBackgroundResource(2130839637);
    this.g.setBackgroundResource(2130839637);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setBackgroundResource(2130839637);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.di);
    this.e.setOnClickListener(this.di);
    this.d.setOnClickListener(this.di);
    this.f.setOnClickListener(this.di);
    this.g.setOnClickListener(this.dk);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setCloseListener(this.dj);
    View localView = LayoutInflater.from(this).inflate(2131559066, null);
    localView.setFocusable(true);
    this.Dm = ((TextView)localView.findViewById(2131380662));
    if (this.aWc)
    {
      this.Dm.setText(2131693998);
      if (!this.aWi) {
        break label450;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
      this.d.setVisibility(0);
      this.e.setVisibility(0);
      this.f.setVisibility(0);
    }
    for (;;)
    {
      this.mListView.addHeaderView(localView);
      return;
      this.Dm.setText(2131693997);
      break;
      label450:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(0);
    }
  }
  
  private void bOb()
  {
    if (this.mDataSetObserver == null) {}
    ListAdapter localListAdapter;
    do
    {
      return;
      localListAdapter = this.mListView.getAdapter();
    } while (localListAdapter == null);
    localListAdapter.unregisterDataSetObserver(this.mDataSetObserver);
  }
  
  private void bOc()
  {
    if ((!this.jdField_a_of_type_Ahgq.e(ahgg.a.S)) && (!this.jdField_a_of_type_Ahgq.e(ahgg.a.T)) && (!this.jdField_a_of_type_Ahgq.e(ahgg.a.U)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends, troop and discuss forward, remove mEntryHeader");
      }
      if ((!(this.jdField_a_of_type_Ahgq instanceof ahhc)) || (this.jdField_a_of_type_Ahgq.e(ahgg.a.ac))) {
        this.mListView.removeHeaderView(this.sB);
      }
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Ahgq.e(ahgg.a.S))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends forward, set friendBtn gone");
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      }
      if (!this.jdField_a_of_type_Ahgq.e(ahgg.a.Y))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support phone contacts forward, set contactBtn gone");
        }
        this.d.setVisibility(8);
        this.sB.findViewById(2131369485).setVisibility(8);
      }
      if ((!this.jdField_a_of_type_Ahgq.e(ahgg.a.T)) || (this.jdField_a_of_type_Ahgq.e(ahgg.a.ac)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support discuss forward, set multiChatBtn gone");
        }
        this.f.setVisibility(8);
      }
      if ((!this.jdField_a_of_type_Ahgq.e(ahgg.a.T)) && (!this.jdField_a_of_type_Ahgq.e(ahgg.a.U)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support troop and discuss forward, set troopDiscussionBtn gone");
        }
        this.e.setVisibility(8);
      }
      if ((this.jdField_a_of_type_Ahgq instanceof ahhw))
      {
        if ((!this.jdField_a_of_type_Ahgq.e(ahgg.a.S)) && (!this.jdField_a_of_type_Ahgq.e(ahgg.a.T)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends and troop forward, set friendBtn gone");
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
          this.f.setVisibility(8);
        }
        if (!this.jdField_a_of_type_Ahgq.e(ahgg.a.S))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends");
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
          this.f.setVisibility(8);
        }
      }
    } while ((!(this.jdField_a_of_type_Ahgq instanceof ahhc)) || (this.jdField_a_of_type_Ahgq.e(ahgg.a.ac)));
    this.f.setVisibility(0);
  }
  
  private void bOd()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView = new ForwardRecentItemView(this);
    ResultRecord localResultRecord1 = new ResultRecord(acbn.bkw, acfp.m(2131696154), 6000, "", "");
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(acfp.m(2131696154), "", getResources().getDrawable(2130845074), localResultRecord1, false, false);
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.setOnClickListener(new uxu(this, localResultRecord1));
    this.mListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
    if (((ackv)this.app.getBusinessHandler(10)).AN() != 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView = new ForwardRecentItemView(this);
      ResultRecord localResultRecord2 = new ResultRecord(acbn.bkx, "我的iPad", 6003, "", "");
      this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a("我的iPad", "", getResources().getDrawable(2130845071), localResultRecord2, false, false);
      this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView.setOnClickListener(new uxv(this, localResultRecord1));
      this.mListView.addHeaderView(this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
    }
  }
  
  private void bOe()
  {
    syw localsyw = (syw)this.app.getBusinessHandler(51);
    DeviceInfo[] arrayOfDeviceInfo;
    if (localsyw.Nz())
    {
      arrayOfDeviceInfo = localsyw.b();
      if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
        break label38;
      }
    }
    label38:
    do
    {
      return;
      arrayOfDeviceInfo = this.jdField_a_of_type_Ahgq.a(arrayOfDeviceInfo);
    } while (arrayOfDeviceInfo == null);
    int j = arrayOfDeviceInfo.length;
    int i = 0;
    label60:
    DeviceInfo localDeviceInfo;
    if (i < j)
    {
      localDeviceInfo = arrayOfDeviceInfo[i];
      if (localDeviceInfo.isAdmin != 2) {
        break label87;
      }
    }
    for (;;)
    {
      i += 1;
      break label60;
      break;
      label87:
      if ((!localsyw.bn(localDeviceInfo.din)) || (localsyw.i(localDeviceInfo.din, 17)))
      {
        ForwardRecentItemView localForwardRecentItemView = new ForwardRecentItemView(this);
        String str = tas.a(localDeviceInfo);
        ResultRecord localResultRecord = new ResultRecord(String.valueOf(localDeviceInfo.din), str, 9501, "", "");
        localForwardRecentItemView.a(str, "", new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(String.valueOf(localDeviceInfo.din))), localResultRecord, false, false);
        localForwardRecentItemView.setOnClickListener(new uxw(this, localDeviceInfo, localForwardRecentItemView, localResultRecord, super.getResources(), str));
        this.mListView.addHeaderView(localForwardRecentItemView);
      }
    }
  }
  
  private void bOf()
  {
    if (this.aA == null)
    {
      this.aA = new uxy(this);
      registerReceiver(this.aA, new IntentFilter("ForwardEntranceActivity"));
    }
  }
  
  private void bOg()
  {
    int j = 0;
    Object localObject;
    if (this.app.abl())
    {
      this.qK = aD(this.app.a().a().q(true));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("refreshRecentList 01 forwardList size is: ");
        if (this.qK != null) {
          break label415;
        }
      }
      label415:
      for (i = 0;; i = this.qK.size())
      {
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, i);
        if (this.qK == null) {
          break label439;
        }
        localObject = new ArrayList();
        Iterator localIterator = this.qK.iterator();
        while (localIterator.hasNext())
        {
          RecentUser localRecentUser = (RecentUser)localIterator.next();
          if ((localRecentUser.lFlag == 16L) || (localRecentUser.getType() == 10005)) {
            ((List)localObject).add(localRecentUser);
          }
          if (localRecentUser.getType() == 1038) {
            ((List)localObject).add(localRecentUser);
          }
          if ((this.aWd) && (TextUtils.equals(localRecentUser.uin, this.app.getCurrentAccountUin()))) {
            ((List)localObject).add(localRecentUser);
          }
          if ((TextUtils.equals(acbn.bld, localRecentUser.uin)) || (localRecentUser.getType() == 8111) || (localRecentUser.getType() == 8112) || (localRecentUser.getType() == 8113)) {
            ((List)localObject).add(localRecentUser);
          }
          if (localRecentUser.getType() == 1)
          {
            TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).a(localRecentUser.uin, true);
            if ((localTroopInfo != null) && ((localTroopInfo.isKicked()) || (localTroopInfo.isDisband())))
            {
              if (QLog.isColorLevel()) {
                QLog.i("ForwardOption.ForwardEntranceActivity", 2, "refreshRecentList, filter troop, recentUser.troopUin =" + localRecentUser.troopUin + ",recentUser.uin = " + localRecentUser.uin);
              }
              ((List)localObject).add(localRecentUser);
            }
          }
          if ((localRecentUser.getType() == 1008) && (!ocp.ew(localRecentUser.uin))) {
            ((List)localObject).add(localRecentUser);
          }
        }
      }
      this.qK.removeAll((Collection)localObject);
      label439:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("refreshRecentList forwardList size is: ");
        if (this.qK != null) {
          break label537;
        }
      }
    }
    label537:
    for (int i = j;; i = this.qK.size())
    {
      QLog.i("ForwardOption.ForwardEntranceActivity", 2, i);
      if (this.jdField_a_of_type_Abej != null) {
        break;
      }
      if (this.mListView != null)
      {
        this.jdField_a_of_type_Abej = new abej(this, this.app, this.mListView, this.qK, this.jdField_a_of_type_Abej$b);
        this.mListView.setAdapter(this.jdField_a_of_type_Abej);
      }
      return;
    }
    this.jdField_a_of_type_Abej.hT(this.qK);
  }
  
  private void bOh()
  {
    switch (this.bGR)
    {
    default: 
      return;
    case 10: 
      s("user_click", "more_about", "share", "fail");
      return;
    case 11: 
      s("user_click", "custom_button", "share_QQ", "fail");
      return;
    }
    s("user_click", "more_button", "share_QQ", "fail");
  }
  
  private void bOi()
  {
    this.hi.clear();
  }
  
  private void bOj()
  {
    this.aDC = 1;
    this.Dl.setText(acfp.m(2131706495));
    this.Dk.setText(acfp.m(2131706492));
    Object localObject = (RelativeLayout.LayoutParams)this.Dk.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = wja.dp2px(29.0F, getResources());
    this.Dk.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.Dk.setBackgroundResource(2130846112);
    this.Dk.setTextSize(1, 14.0F);
    this.Dk.setTextColor(getResources().getColor(2131167321));
    this.Dk.setClickable(false);
    this.sC.setVisibility(4);
    this.f.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    this.g.setVisibility(8);
    this.e.setVisibility(0);
    this.e.setBGType(3);
    this.e.setBackgroundResource(2130839637);
    localObject = (FrameLayout.LayoutParams)this.fZ.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).topMargin = wja.dp2px(8.0F, getResources());
    this.fZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mListView.postDelayed(new ForwardRecentActivity.15(this), 50L);
    if (this.jdField_a_of_type_Aqdf == null)
    {
      this.jdField_a_of_type_Aqdf = new aqdf(this.app);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(null, this.jdField_a_of_type_Aqdf, this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$b);
    }
    localObject = new ArrayList(this.hi.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X((List)localObject, true);
    if (AppSetting.enableTalkBack)
    {
      this.Dl.setContentDescription(this.Dl.getText());
      this.Dk.setContentDescription(this.Dk.getText());
    }
    if (this.isSdkShare)
    {
      xi(false);
      ForwardUtils.a(this.app, "0X800A733", new String[0]);
    }
  }
  
  private void bOk()
  {
    this.aDC = 0;
    bNU();
    this.Dl.setText(acfp.m(2131706495));
    this.Dk.setText(acfp.m(2131706493));
    this.Dk.setTextColor(getResources().getColor(2131167301));
    this.Dk.setBackgroundResource(2130851767);
    Object localObject = (RelativeLayout.LayoutParams)this.Dk.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = wja.dp2px(36.0F, getResources());
    this.Dk.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.Dk.setTextSize(1, 17.0F);
    this.Dk.setClickable(true);
    this.sC.setVisibility(0);
    this.f.setVisibility(0);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
    this.e.setVisibility(8);
    if ((this.jdField_a_of_type_Ahgq.e(ahgg.a.V)) && (!this.aWb)) {
      this.g.setVisibility(0);
    }
    for (;;)
    {
      localObject = (FrameLayout.LayoutParams)this.fZ.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).topMargin = wja.dp2px(0.0F, getResources());
      this.fZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      bOi();
      this.jdField_a_of_type_Ahgq.JZ("forward_multi_target");
      this.mListView.postDelayed(new ForwardRecentActivity.16(this), 1L);
      if (AppSetting.enableTalkBack)
      {
        this.Dl.setContentDescription(this.Dl.getText());
        this.Dk.setContentDescription(this.Dk.getText());
      }
      if (this.isSdkShare) {
        xi(true);
      }
      return;
      this.g.setVisibility(8);
    }
  }
  
  private void cl(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = R(paramString, paramInt);
      this.hi.remove(paramString);
      bNR();
      paramString = new ArrayList(this.hi.values());
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X(paramString, true);
      paramString = new ArrayList();
      Iterator localIterator = this.hi.values().iterator();
      while (localIterator.hasNext()) {
        paramString.add(((ResultRecord)localIterator.next()).uin);
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment == null);
    this.jdField_b_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.N(paramString, paramString);
  }
  
  private String dE()
  {
    if (TextUtils.isEmpty(this.businessId)) {
      this.businessId = getIntent().getStringExtra("key_forward_business_id");
    }
    if (TextUtils.isEmpty(this.businessId)) {
      this.businessId = "other";
    }
    return this.businessId;
  }
  
  private void eJ(View paramView)
  {
    paramView = (ForwardRecentItemView)paramView;
    ResultRecord localResultRecord = paramView.b;
    boolean bool = E(localResultRecord.uin, localResultRecord.lk());
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onListViewItemClickedInMultiSelectStatus, isSelected = " + bool);
    }
    if (bool)
    {
      paramView.Du(false);
      cl(localResultRecord.uin, localResultRecord.lk());
    }
    while (!a(localResultRecord)) {
      return;
    }
    paramView.Du(true);
  }
  
  private void initData() {}
  
  private void initViews()
  {
    this.fY = ((LinearLayout)super.findViewById(2131377546));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.fY.setFitsSystemWindows(true);
      this.fY.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.fD = ((RelativeLayout)super.findViewById(2131377498));
    super.findViewById(2131369579).setVisibility(8);
    super.findViewById(2131369594).setVisibility(8);
    this.title = ((TextView)super.findViewById(2131369627));
    this.title.setText(this.jdField_a_of_type_Ahgq.getTitle());
    bNZ();
    bNT();
    this.aS = ((FrameLayout)super.findViewById(2131377207));
    if (AppSetting.enableTalkBack) {
      aqcl.changeAccessibilityForView(this.Dk, Button.class.getName());
    }
    this.mListView = ((XListView)super.findViewById(2131370537));
    if (AppSetting.enableTalkBack) {
      ViewCompat.setImportantForAccessibility(this.mListView, 2);
    }
    this.sC = LayoutInflater.from(this).inflate(2131563007, this.mListView, false);
    this.sC.findViewById(2131363801).setVisibility(8);
    Object localObject = (EditText)this.sC.findViewById(2131366542);
    ((EditText)localObject).setFocusable(false);
    ((EditText)localObject).setOnClickListener(this.di);
    ((EditText)localObject).setCursorVisible(false);
    this.mListView.addHeaderView(this.sC);
    bOa();
    if (this.jdField_a_of_type_Ahgq.e(ahgg.a.W)) {
      bOd();
    }
    if (this.jdField_a_of_type_Ahgq.e(ahgg.a.aa)) {
      bOe();
    }
    if ((this.jdField_a_of_type_Ahgq.e(ahgg.a.V)) && (!this.aWb))
    {
      this.g.setVisibility(0);
      anot.a(this.app, "CliOper", "", "", "friendchoose", "0X800A2D6", vu(), 0, "", "", "", dE());
      if (getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("forward_share_card", true)) {
        this.sB.findViewById(2131369485).setVisibility(0);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar != null)
      {
        if (!this.aWl) {
          break label505;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
        localObject = aeui.a();
        if ((localObject != null) && (!TextUtils.isEmpty(((aeuh)localObject).bBP))) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText(((aeuh)localObject).bBP);
        }
      }
    }
    for (;;)
    {
      if ((bGS == this.ZO) || (bGT == this.ZO)) {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new uxp(this));
      }
      return;
      this.g.setVisibility(8);
      break;
      label505:
      this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    }
  }
  
  private void s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_mini_report_event_action_type", paramString1);
    localBundle.putString("key_mini_report_event_sub_action_type", paramString2);
    localBundle.putString("key_mini_report_event_reserves", paramString3);
    localBundle.putString("key_mini_report_event_reserves2", paramString4);
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
  }
  
  private void ts()
  {
    if (this.az == null)
    {
      this.az = new uxx(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.az, localIntentFilter);
    }
  }
  
  private int vu()
  {
    if (this.aWe) {
      return 2;
    }
    if (this.aWh) {
      return 3;
    }
    return 1;
  }
  
  private void xi(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView != null)
    {
      if (!paramBoolean) {
        break label45;
      }
      this.mListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.mListView.addHeaderView(this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
      }
      return;
      label45:
      this.mListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
    }
    this.mListView.removeHeaderView(this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
  }
  
  public void H(long paramLong, String paramString)
  {
    Object localObject = getIntent();
    if (localObject != null) {}
    for (localObject = ((Intent)localObject).getExtras();; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = new Bundle((Bundle)localObject);; localObject = new Bundle())
      {
        ((Bundle)localObject).putInt("uintype", 0);
        ((Bundle)localObject).putString("uin", paramLong + "");
        if (paramString != null) {
          ((Bundle)localObject).putString("uinname", paramString);
        }
        this.jdField_a_of_type_Ahgq.H(ahgg.a.R.intValue(), (Bundle)localObject);
        this.jdField_a_of_type_Ahgq.cph();
        return;
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
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
              do
              {
                return;
                if (getIntent().getExtras().getBoolean("jump_to_mobileqq_share", false)) {
                  setResult(10, paramIntent);
                }
                for (;;)
                {
                  finish();
                  overridePendingTransition(0, 0);
                  return;
                  setResult(-1, paramIntent);
                }
                setResult(-1, paramIntent);
                finish();
                return;
                if (paramIntent.getBooleanExtra("select_memeber_single_friend", false))
                {
                  localObject1 = paramIntent.getExtras();
                  paramInt2 = paramIntent.getIntExtra("select_memeber_single_friend_type", 2);
                  paramInt1 = paramInt2;
                  if (paramInt2 == 4) {
                    paramInt1 = 1;
                  }
                  paramInt2 = paramInt1;
                  if (paramInt1 == 0) {
                    paramInt2 = 2;
                  }
                  ((Bundle)localObject1).putBoolean("forward_report_confirm", true);
                  ((Bundle)localObject1).putString("forward_report_confirm_action_name", "0X8005A14");
                  ((Bundle)localObject1).putString("forward_report_confirm_reverse2", Integer.toString(paramInt2));
                  this.jdField_a_of_type_Ahgq.H(ahgg.a.S.intValue(), (Bundle)localObject1);
                  arts.a().a(this.app.getAccount(), "", this.appid, "1000", "30", "0", false, this.isSdkShare);
                  return;
                }
                localObject1 = paramIntent.getStringExtra("roomId");
                Object localObject2;
                if (!aqmr.isEmpty((String)localObject1))
                {
                  bOg();
                  anot.a(this.app, "CliOper", "", "", "0X80056B0", "0X80056B0", 0, 0, "", "", "", "");
                  paramInt1 = paramIntent.getIntExtra("select_memeber_discussion_memeber_count", 0);
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putBoolean("forward_report_confirm", true);
                  ((Bundle)localObject2).putString("forward_report_confirm_action_name", "0X8005A15");
                  ((Bundle)localObject2).putString("forward_report_confirm_reverse2", Integer.toString(paramInt1));
                  this.jdField_a_of_type_Ahgq.b((String)localObject1, paramIntent.getStringExtra("discussName"), (Bundle)localObject2);
                }
                arts.a().a(this.app.getAccount(), "", this.appid, "1000", "32", "0", false, this.isSdkShare);
                return;
                this.jdField_a_of_type_Ahgq.onActivityResult(paramInt1, paramInt2, paramIntent);
                return;
                paramIntent.putExtra("chooseFriendFrom", aqla.at);
                if (getIntent() != null) {}
                for (boolean bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);; bool = false)
                {
                  if (bool)
                  {
                    localObject1 = getIntent().getStringExtra("choose_friend_confirmTitle");
                    localObject2 = getIntent().getStringExtra("choose_friend_confirmContent");
                    paramIntent.putExtra("choose_friend_needConfirm", bool);
                    paramIntent.putExtra("choose_friend_confirmTitle", (String)localObject1);
                    paramIntent.putExtra("choose_friend_confirmContent", (String)localObject2);
                  }
                  amxk.a(paramIntent, this.jdField_a_of_type_Ahgq);
                  return;
                }
                this.jdField_a_of_type_Ahgq.onActivityResult(paramInt1, paramInt2, paramIntent);
                return;
              } while (paramIntent == null);
              paramIntent = paramIntent.getStringExtra("new_video_extra_info");
              ((ahkr)this.jdField_a_of_type_Ahgq).Kk(paramIntent);
              finish();
              overridePendingTransition(0, 0);
              return;
              this.jdField_a_of_type_Ahgq.onActivityResult(paramInt1, paramInt2, paramIntent);
              return;
              setResult(-1, paramIntent);
              finish();
            } while (this.aWk);
            uya.bOl();
            return;
            if (paramInt2 != 1) {
              break;
            }
          } while (20000 != paramInt1);
          finish();
          return;
          if ((20000 != paramInt1) || (paramInt2 == -1)) {
            break;
          }
          if (this.aWa)
          {
            finish();
            return;
          }
        } while (paramInt2 != 0);
        localObject1 = null;
        if (paramIntent != null) {
          localObject1 = paramIntent.getParcelableArrayListExtra("selected_target_list");
        }
      } while (localObject1 == null);
      this.hi.clear();
      if (((List)localObject1).isEmpty())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X((List)localObject1, false);
        this.jdField_a_of_type_Abej.notifyDataSetChanged();
        bNR();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView != null) {
          this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.Du(E(acbn.bkw, 6000));
        }
        if (this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView == null) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView.Du(E(acbn.bkx, 6003));
        return;
        Collections.sort((List)localObject1, new ResultRecord.a());
        paramIntent = ((List)localObject1).iterator();
        while (paramIntent.hasNext()) {
          a((ResultRecord)paramIntent.next());
        }
        this.jdField_a_of_type_Abej.notifyDataSetChanged();
      }
    } while ((paramInt2 != 0) || (!this.aWk) || (paramInt1 != 20005));
    finish();
  }
  
  public void doOnBackPressed()
  {
    if (!isFinishing())
    {
      this.jdField_a_of_type_Ahgq.Kp(false);
      com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = false;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((bGS != this.ZO) && (bGT != this.ZO)) {
      setTheme(2131755343);
    }
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.jdField_c_of_type_Acfd);
    this.app.addObserver(this.jdField_a_of_type_Acnd);
    this.app.addObserver(this.jdField_b_of_type_Acbo);
    setContentViewNoTitle(2131559346);
    return v(paramBundle);
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_c_of_type_Acfd);
    this.app.removeObserver(this.jdField_a_of_type_Acnd);
    this.app.removeObserver(this.jdField_b_of_type_Acbo);
    if (this.aWc) {
      zzn.bA(this.app);
    }
    bOb();
    if (this.jdField_a_of_type_Abej != null)
    {
      this.jdField_a_of_type_Abej.destroy();
      this.mListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Ahgq != null) {
      this.jdField_a_of_type_Ahgq.onDestroy();
    }
    if (this.az != null) {
      unregisterReceiver(this.az);
    }
    if (this.aA != null) {
      unregisterReceiver(this.aA);
    }
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int i = 1;
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "ForwardOption.ForwardEntranceActivity onNewIntent()");
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        break label54;
      }
    }
    label54:
    int j;
    label273:
    label290:
    for (;;)
    {
      return;
      paramIntent = (String)paramIntent.get(0);
      Bundle localBundle = this.jdField_a_of_type_Ahgq.getExtras();
      j = localBundle.getInt("key_forward_ability_type", 0);
      String str1 = localBundle.getString("uin");
      int k = localBundle.getInt("uintype", -1);
      String str2 = localBundle.getString("troop_uin");
      localBundle.getString("uinname");
      boolean bool = localBundle.getBoolean("FORWARD_IS_QZONE_SHARE");
      localBundle.putBoolean("FORWARD_IS_EDITED", true);
      if (!bool) {
        break;
      }
      if ((j == ahgg.a.W.intValue()) || (j == ahgg.a.ab.intValue()))
      {
        LiteActivity.a(this.app, paramIntent, this);
        bool = true;
        i = 0;
        if (!bool) {
          break label273;
        }
        setResult(-1);
      }
      for (;;)
      {
        if (i != 0) {
          break label290;
        }
        finish();
        return;
        if (j == ahgg.a.X.intValue())
        {
          this.jdField_a_of_type_Ahgq.getExtras().putString("forward_filepath", paramIntent);
          this.jdField_a_of_type_Ahgq.getExtras().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
          this.jdField_a_of_type_Ahgq.dnS();
          bool = true;
          break;
        }
        bool = aqhr.a(this.app, paramIntent, str1, k, str2, true, this);
        i = 0;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardEntranceActivity", 2, "failed to send pic from qzone");
        }
      }
    }
    if ((j == ahgg.a.W.intValue()) || (j == ahgg.a.ab.intValue()))
    {
      this.jdField_a_of_type_Ahgq.getExtras().putString("forward_extra", paramIntent);
      this.jdField_a_of_type_Ahgq.Pa(j);
      return;
    }
    if (j == ahgg.a.X.intValue())
    {
      this.jdField_a_of_type_Ahgq.getExtras().putString("forward_filepath", paramIntent);
      this.jdField_a_of_type_Ahgq.getExtras().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
      this.jdField_a_of_type_Ahgq.dnS();
      return;
    }
    this.jdField_a_of_type_Ahgq.getExtras().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
    bJo();
    anot.a(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Ahgq != null) {
      this.jdField_a_of_type_Ahgq.onPause();
    }
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    if (this.jdField_a_of_type_Ahgq != null) {
      this.jdField_a_of_type_Ahgq.doOnRestoreInstanceState(paramBundle);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (AppSetting.enableTalkBack) {
      this.Dk.postDelayed(new ForwardRecentActivity.1(this), 1000L);
    }
    if (BaseApplicationImpl.appStartTime > 0L) {
      Log.d("AutoMonitor", "actStartSel, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
    }
    if (this.jdField_a_of_type_Ahgq != null) {
      this.jdField_a_of_type_Ahgq.onResume();
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (this.jdField_a_of_type_Ahgq != null) {
      this.jdField_a_of_type_Ahgq.doOnSaveInstanceState(paramBundle);
    }
  }
  
  public void eL(View paramView)
  {
    vw("0X8007827");
    paramView = (ForwardRecentItemView)paramView;
    ResultRecord localResultRecord = paramView.b;
    if ((this.isSdkShare) && (localResultRecord != null)) {}
    Bundle localBundle;
    switch (localResultRecord.lk())
    {
    default: 
      if (localResultRecord != null)
      {
        localBundle = new Bundle();
        localBundle.putInt("uintype", localResultRecord.lk());
        localBundle.putString("uin", localResultRecord.uin);
        localBundle.putString("troop_uin", localResultRecord.QD);
        if (localResultRecord.lk() != 3000) {
          break label487;
        }
        localBundle.putString("uinname", ForwardUtils.c(this.app, paramView.name, localResultRecord.uin));
      }
      break;
    }
    for (;;)
    {
      localBundle.putBoolean("forward_report_confirm", true);
      localBundle.putString("forward_report_confirm_action_name", "0X8005A13");
      localBundle.putString("forward_report_confirm_reverse2", "5");
      localBundle.putInt("chooseFriendFrom", aqla.as.intValue());
      localBundle.putString("caller_name", this.aNa);
      if ((getIntent() != null) && (getIntent().getExtras() != null))
      {
        localBundle.putBoolean("needShareCallBack", getIntent().getExtras().getBoolean("needShareCallBack"));
        localBundle.putInt("miniAppShareFrom", getIntent().getExtras().getInt("miniAppShareFrom"));
      }
      this.jdField_a_of_type_Ahgq.H(ahgg.a.R.intValue(), localBundle);
      this.jdField_a_of_type_Ahgq.cph();
      if ((localResultRecord.lk() == 3000) || (localResultRecord.lk() == 1)) {
        new anov(this.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "0" }).report();
      }
      anot.a(this.app, "CliOper", "", "", "friendchoose", "0X8009D90", vu(), 0, "", "", "", dE());
      return;
      arts.a().a(this.app.getAccount(), "", this.appid, "1000", "30", "0", false, this.isSdkShare);
      break;
      arts.a().a(this.app.getAccount(), "", this.appid, "1000", "31", "0", false, this.isSdkShare);
      break;
      arts.a().a(this.app.getAccount(), "", this.appid, "1000", "32", "0", false, this.isSdkShare);
      break;
      label487:
      localBundle.putString("uinname", paramView.name);
    }
  }
  
  public void finish()
  {
    a(getIntent(), this);
    super.finish();
    overridePendingTransition(0, 2130771990);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 20002) {
      finish();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.aS.getVisibility() != 8)
    {
      bNU();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.QG()) {
      bNU();
    }
    if (this.aWj) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
    }
    bOh();
    return super.onBackEvent();
  }
  
  protected boolean v(Bundle paramBundle)
  {
    this.jdField_a_of_type_Ahgq = ahix.a(getIntent(), this.app, this);
    if (this.jdField_a_of_type_Ahgq != null)
    {
      this.jdField_a_of_type_Ahgq.E();
      if (isFinishing())
      {
        QLog.d("ForwardOption.ForwardEntranceActivity", 1, "-->doOnCreate_init--isFinishing");
        return false;
      }
    }
    else
    {
      QLog.d("ForwardOption.ForwardEntranceActivity", 1, "-->doOnCreate_init--mForwardOption == null");
      finish();
      return false;
    }
    this.jdField_a_of_type_Ahgq.dnW();
    paramBundle = getIntent();
    this.aWb = paramBundle.getBooleanExtra("forward_ability_entrence_show_in_share", false);
    this.aWh = paramBundle.getBooleanExtra("isWebCompShare", false);
    this.aWd = paramBundle.getBooleanExtra("choose_friend_isForConfess", false);
    this.aWj = paramBundle.getBooleanExtra("needShareCallBack", false);
    this.bGR = paramBundle.getIntExtra("miniAppShareFrom", -1);
    this.aWl = paramBundle.getBooleanExtra("k_forward_show_direct_share_tips", false);
    this.aWk = paramBundle.getBooleanExtra("key_direct_jump_qzone_shuoshuo", false);
    Object localObject;
    if (this.aWk)
    {
      localObject = paramBundle.getStringExtra("key_forward_business_id");
      boolean bool = paramBundle.hasExtra("file_send_path");
      uya.a(this.app, this, paramBundle, (String)localObject, bool);
      QLog.d("ForwardOption.ForwardEntranceActivity", 1, "-->doOnCreate_init--mJumpQzoneShuoshuoDirect==true");
      return true;
    }
    for (;;)
    {
      try
      {
        this.uinType = paramBundle.getIntExtra("forward_source_uin_type", 0);
        this.w = paramBundle.getData();
        if (paramBundle.getIntExtra("forward_type", -1) == 11) {
          this.isSdkShare = true;
        }
        this.aMZ = paramBundle.getStringExtra("pkg_name");
        long l = paramBundle.getLongExtra("req_share_id", 0L);
        this.aNa = getIntent().getStringExtra("caller_name");
        this.aWe = getIntent().getBooleanExtra("isFromShare", false);
        this.aWf = getIntent().getBooleanExtra("isFromDataLineAIO", false);
        if (l > 0L) {
          this.appid = String.valueOf(l);
        }
        if ((!this.aWe) && ((l > 0L) || (this.isSdkShare) || ((!TextUtils.isEmpty(this.aMZ)) && (!this.aMZ.equals("com.tencent.mobileqq"))))) {
          this.aWe = true;
        }
        QLog.d("ForwardOption.ForwardEntranceActivity", 1, new Object[] { "-->doOnCreate_init--isSdkShare=", Boolean.valueOf(this.isSdkShare), ", pkgName=", this.aMZ, ", appid=", this.appid, ", isFromWeb=" + this.aWh + ", isFromShare=" + this.aWe + ", isFromDatalineAIO=" + this.aWf });
        bM(paramBundle);
        this.EP = paramBundle.getIntExtra("choose_friend_businessType", 0);
        this.bGQ = paramBundle.getIntExtra("choose_friend_businessSubType", 0);
        if ((this.EP == 1) && (this.bGQ > 0) && (this.bGQ < 3)) {
          this.aWc = true;
        }
        initData();
        initViews();
        if (this.app.getCurrentAccountUin() == null) {
          finish();
        }
        if (!this.aWc) {
          continue;
        }
        xg(true);
        this.jdField_a_of_type_Ahgq.dnt();
        bOc();
        l = paramBundle.getLongExtra("forward_send_to_uin", 0L);
        if (l != 0L) {
          H(l, paramBundle.getStringExtra("forward_send_to_uin_nickname"));
        }
        if ((bGS == this.ZO) || (bGT == this.ZO)) {
          bNX();
        }
      }
      catch (Exception localException)
      {
        QLog.d("ForwardOption.ForwardEntranceActivity", 1, "exception in ForwardRecentActivity", localException);
        finish();
        continue;
        if ((this.EP != 1) || (this.bGQ != 2)) {
          continue;
        }
        anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.show", 0, 0, "", "", "", "");
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuildertime", 4, "zhuanfa end:" + System.currentTimeMillis());
      }
      if (this.aWc)
      {
        if ((this.EP != 1) || (this.bGQ != 1)) {
          continue;
        }
        anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.show", 0, 0, "", "", "", "");
      }
      if (paramBundle.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
        anot.a(this.app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "", "", "", "");
      }
      if (this.aWd)
      {
        this.aWa = true;
        localObject = new Intent();
        ((Intent)localObject).putExtra("call_by_forward", true);
        if (this.w != null) {
          ((Intent)localObject).setData(this.w);
        }
        ((Intent)localObject).putExtras(this.jdField_a_of_type_Ahgq.getExtras());
        ((Intent)localObject).putExtras(paramBundle.getExtras());
        ((Intent)localObject).putExtra("isForConfessDirectFriendsTitle", this.jdField_a_of_type_Ahgq.getTitle());
        ((Intent)localObject).setClass(this, ForwardFriendListActivity.class);
        ((Intent)localObject).putExtra("extra_choose_friend", 5);
        startActivityForResult((Intent)localObject, 20000);
      }
      correctStatusBarHeight();
      anot.a(this.app, "CliOper", "", "", "friendchoose", "0X8009D8E", vu(), 0, "", "", "", "");
      return true;
      bOg();
    }
  }
  
  public void vw(String paramString)
  {
    if (getIntent().getBooleanExtra("forward_source_from_shoot_quick", false)) {
      anot.a(this.app, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
  
  protected void xg(boolean paramBoolean)
  {
    if (isFinishing()) {}
    do
    {
      return;
      localObject1 = zzn.a(this, paramBoolean, this.EP, this.bGQ);
    } while (localObject1 == null);
    Object localObject2 = ((HashMap)localObject1).get(zzn.bbR);
    if (localObject2 != null)
    {
      localObject2 = (ArrayList)localObject2;
      this.jdField_a_of_type_Ahgq.getExtras().putStringArrayList("choose_friend_feedbacks", (ArrayList)localObject2);
    }
    this.qK = new ArrayList();
    Object localObject1 = ((HashMap)localObject1).get(zzn.bbQ);
    if (localObject1 != null) {}
    for (localObject1 = (ArrayList)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int i = 0;
        if (i < ((ArrayList)localObject1).size())
        {
          localObject2 = (PfaFriend)((ArrayList)localObject1).get(i);
          if ((localObject2 == null) || (TextUtils.isEmpty(((PfaFriend)localObject2).uin))) {}
          for (;;)
          {
            i += 1;
            break;
            if ((!this.aWd) || (this.app == null) || (!TextUtils.equals(((PfaFriend)localObject2).uin, this.app.getCurrentAccountUin())))
            {
              localObject2 = new RecentUser(((PfaFriend)localObject2).uin, 0);
              this.qK.add(localObject2);
              Collections.sort(this.qK, new uxz(this));
            }
          }
        }
      }
      if (this.jdField_a_of_type_Abej == null)
      {
        this.jdField_a_of_type_Abej = new abej(this, this.app, this.mListView, this.qK, this.jdField_a_of_type_Abej$b);
        this.mListView.setAdapter(this.jdField_a_of_type_Abej);
        return;
      }
      this.jdField_a_of_type_Abej.hT(this.qK);
      return;
    }
  }
  
  public void xh(boolean paramBoolean)
  {
    xg(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity
 * JD-Core Version:    0.7.0.1
 */