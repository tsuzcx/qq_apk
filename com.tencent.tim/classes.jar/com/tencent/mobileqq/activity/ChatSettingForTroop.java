package com.tencent.mobileqq.activity;

import abrb;
import accc;
import accd;
import acfd;
import acff;
import acfp;
import acms;
import acnd;
import acqe;
import aeif;
import aenw;
import aenw.a;
import aeof;
import aeoo;
import aeop;
import aepa;
import aerd;
import afsi;
import afyk;
import aizp;
import ajcw;
import ajdr;
import aldj;
import anaz;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anlm;
import anot;
import aofe;
import aofk;
import aofr;
import aohy;
import aoij;
import apdh.a;
import apdh.b;
import apdr;
import apmb;
import apov;
import apoy;
import apoz;
import apqz;
import aprb.a;
import aprg;
import aprp;
import aptl;
import aptr;
import aptw;
import apuh;
import apvf;
import apyg;
import apyh;
import apzg;
import aqdf;
import aqdf.a;
import aqfr;
import aqgv;
import aqgx;
import aqha;
import aqha.a;
import aqhu;
import aqiw;
import aqju;
import aqlz;
import aqpm;
import aqqj;
import aqrd;
import aqsy;
import aqvl;
import arfj;
import arhz;
import arib;
import arie;
import ausi;
import ausj;
import auss;
import auvv;
import awjk;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.c;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.EntryDebugFragment;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.GameRankFormItem;
import com.tencent.mobileqq.troop.widget.TroopAppFormItem;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.Switch;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageProxyActivity;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x899.oidb_0x899.memberlist;>;
import java.util.concurrent.ConcurrentHashMap;
import jll.a;
import jpp;
import jqk;
import jrp;
import jrp.a;
import kgw;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
import rar;
import tbb;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.AppInfo;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.ExtraInfo;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.RspBody;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.TabInfo;
import upl;
import upm;
import upn;
import upp;
import upq;
import upr;
import ups;
import upt;
import upu;
import upv;
import upw;
import upx;
import upy;
import upz;
import uqa;
import uqb;
import uqc;
import uqd;
import uqe;
import uqf;
import uqh;
import uqi;
import uqj;
import uqk;
import uql;
import uqn;
import uqp;
import uqq;
import uqr;
import uqu;
import uqv;
import uqw;
import uqx;
import uqy;
import uqz;
import wja;
import yxe;

public class ChatSettingForTroop
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener, aprb.a, aqdf.a
{
  public static String aMr = "https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi";
  public static final ArrayList<Integer> oT = new ArrayList(6);
  public Intent C;
  public TextView CN;
  private aqju F;
  long FK = 0L;
  acnd jdField_a_of_type_Acnd = new uqd(this);
  public aeoo a;
  private apvf jdField_a_of_type_Apvf;
  public apyg a;
  public apzg a;
  public aqlz a;
  public arib a;
  protected a a;
  TroopMoreDetailView jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView;
  public TroopInfoData a;
  protected QQBlurView a;
  protected jqk a;
  protected jrp.a a;
  protected String aMi;
  private String aMj;
  public String aMk;
  public String aMl;
  String aMm;
  String aMn;
  String aMo;
  String aMp;
  String aMq;
  protected boolean aRf;
  public boolean aRg;
  public volatile boolean aUn;
  public boolean aUo;
  public boolean aUp = false;
  private boolean aUq;
  private boolean aUr;
  protected boolean aUs;
  protected boolean aUt;
  public boolean aUu;
  protected boolean aUv;
  private boolean aUw;
  private boolean aUx;
  private boolean aUy;
  private boolean aUz = true;
  String apc;
  public String authKey;
  protected String authSig;
  accd jdField_b_of_type_Accd = new uql(this);
  aqrd jdField_b_of_type_Aqrd = new uqu(this);
  protected TroopManager b;
  public TroopInfo b;
  protected MyGridView b;
  protected jrp b;
  protected final int bFD = 1;
  public int bFE;
  protected int bFF;
  protected int bFG;
  protected int bFH;
  protected int bFI;
  protected int bFJ = 5;
  protected int bFK;
  public int bFL;
  public int bFM;
  private int bFN = 2;
  public int bFO;
  protected int bFP = -1;
  public Handler bJ;
  protected boolean bO;
  protected Runnable bz = new ChatSettingForTroop.12(this);
  acfd jdField_c_of_type_Acfd = new uqf(this);
  private acnd jdField_c_of_type_Acnd = new upl(this);
  private View.OnLayoutChangeListener jdField_c_of_type_AndroidViewView$OnLayoutChangeListener = new upn(this);
  acnd d;
  protected aqdf d;
  protected Runnable dJ = new ChatSettingForTroop.23(this);
  protected Button dc;
  protected Button dd;
  View.OnClickListener dg;
  protected View.OnClickListener dh = new uqn(this);
  protected LinearLayout dl;
  public Drawable dx;
  acnd e = new uqe(this);
  protected ImmersiveTitleBar2 f;
  protected arhz g;
  protected RelativeLayout gt;
  public boolean isDestory;
  protected DisplayMetrics mDisplayMetrics;
  public boolean mIsDestroyed;
  public boolean mIsInit = true;
  protected View mN;
  protected BroadcastReceiver mReceiver = new uqj(this);
  protected View mRootView;
  public TextView mTitleTv;
  public Handler mUIHandler = new uqb(this);
  public XListView n;
  protected ArrayList<TroopAppInfo> oU;
  private ArrayList<Long> oW = new ArrayList();
  public View[] p;
  protected ImageView pJ;
  public ImageView pK;
  View.OnTouchListener q = new jll.a();
  protected List<oidb_0x899.memberlist> qA;
  protected List<Long> qB = new ArrayList();
  public List<oidb_0x899.memberlist> qC;
  public List<Integer> qy;
  List<ImageView> qz;
  protected View rV;
  protected View rW;
  public TextView tR;
  public aqju x;
  private FormSimpleItem x;
  protected TextView xt;
  
  static
  {
    oT.add(Integer.valueOf(2131380398));
    oT.add(Integer.valueOf(2131380399));
    oT.add(Integer.valueOf(2131380400));
    oT.add(Integer.valueOf(2131380401));
    oT.add(Integer.valueOf(2131380402));
    oT.add(Integer.valueOf(2131380403));
  }
  
  public ChatSettingForTroop()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Jrp$a = new upv(this);
    this.jdField_d_of_type_Acnd = new uqc(this);
    this.jdField_a_of_type_Jqk = new uqq(this);
  }
  
  private void Au(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131721375);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131721380);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131721382);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 4;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131721377);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 5;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131721376);
  }
  
  private void Av(int paramInt)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_Arib == null) {
        this.jdField_a_of_type_Arib = new arib(this);
      }
      this.jdField_a_of_type_Arib.aq(2, 2131696272, 1500);
      this.mUIHandler.sendEmptyMessage(17);
    }
    while (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_Aqlz.ja.clear();
    this.app.b(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Aqlz.jb.put(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Boolean.valueOf(true));
    if (!this.aUw)
    {
      SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      if (!localSharedPreferences.getBoolean("Change_Msg_Notify_Tips_Value", false))
      {
        this.aUw = true;
        localSharedPreferences.edit().putBoolean("Change_Msg_Notify_Tips_Value", true).commit();
        aqha.a(this, getString(2131699859), 2131720227, 2131720227, new aqha.a(), null).show();
      }
    }
    this.mUIHandler.sendEmptyMessage(17);
    anot.a(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
  }
  
  private void Aw(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        Au(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void Ax(int paramInt)
  {
    this.bFN = paramInt;
    apqz.p(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  private boolean Pn()
  {
    byte[] arrayOfByte = ((ajdr)this.app.getManager(37)).r(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (arrayOfByte != null) {
      try
      {
        oidb_0xea4.RspBody localRspBody = new oidb_0xea4.RspBody();
        localRspBody.mergeFrom(arrayOfByte);
        a(localRspBody);
        return true;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData exception");
        }
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData==null");
    }
    return false;
  }
  
  private boolean Po()
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool4;
    boolean bool5;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        break label201;
      }
      bool1 = true;
      bool4 = TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mTroopPicListJson);
      bool5 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt > 0L) {
        break label206;
      }
      i = 1;
      label65:
      if (!apuh.cS(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) {
        break label211;
      }
      bool2 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags != null) {
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags.isEmpty()) {
          break label211;
        }
      }
    }
    label201:
    label206:
    label211:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      bool3 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      bool1 = apuh.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, new boolean[] { bool1, bool4, bool5, i, bool2, bool3 }, new int[] { 11, 12, 5, 4, 8, 6 });
      return bool1;
      bool1 = false;
      break;
      i = 0;
      break label65;
    }
  }
  
  private void Qq()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.a(new ausi(getString(2131698429), 34, 0), 5);
    localausj.a(new ausi(auss.n(this, 2131718824), 21, 0), 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new upq(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  private void ZM()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.aUz) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (!this.aUz) {
      this.aUz = true;
    }
    if ((this.aUz) || (bool)) {}
    for (int i = 2131167301;; i = 2131166970)
    {
      i = getResources().getColor(i);
      if ((this.aUz) && (!bool)) {}
      Drawable localDrawable = getResources().getDrawable(2130851758);
      localDrawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      this.mTitleTv.setTextColor(i);
      this.xt.setTextColor(i);
      this.xt.setBackgroundDrawable(localDrawable);
      this.pJ.setImageResource(2130844509);
      this.pJ.setColorFilter(i);
      wz(this.aUz);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_is_troop_admin", paramBoolean);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131721066));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131698293));
    localIntent.putExtra("param_max", 100);
    if (!paramBoolean) {
      localIntent.putExtra("filer_robot", true);
    }
    localIntent.putExtra("param_entrance", 38);
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363620);
    paramView = (TextView)paramView.findViewById(2131377275);
    if (TextUtils.isEmpty(paramCharSequence1)) {
      if (TextUtils.isEmpty(paramCharSequence3)) {
        paramView.setVisibility(8);
      }
    }
    while (TextUtils.isEmpty(paramCharSequence2))
    {
      localTextView.setVisibility(8);
      return;
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence3);
      continue;
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence1);
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramCharSequence2);
  }
  
  private void aA(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop()))
    {
      localObject = (acms)this.app.getBusinessHandler(20);
      str = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
      if (!paramBoolean) {
        break label82;
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      ((acms)localObject).ae(str, paramInt, i);
      localObject = (FormSwitchItem)this.p[31];
      if (localObject != null) {
        ((FormSwitchItem)localObject).a().setClickable(false);
      }
      return;
    }
  }
  
  private Drawable ax()
  {
    Object localObject1 = null;
    if (this.jdField_d_of_type_Aqdf != null)
    {
      localObject2 = this.jdField_d_of_type_Aqdf.b(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_d_of_type_Aqdf.isPausing())
        {
          this.jdField_d_of_type_Aqdf.i(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = aqhu.G();
    }
    return new BitmapDrawable((Bitmap)localObject2);
  }
  
  private void bKQ()
  {
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.p[16];
    if ((localFormSimpleItem == null) || (localFormSimpleItem.getVisibility() != 0)) {}
    do
    {
      return;
      aeof localaeof = (aeof)aeif.a().o(535);
      if ((localaeof == null) || (!localaeof.bVl)) {
        break;
      }
      localFormSimpleItem.setVisibility(0);
    } while (localFormSimpleItem.getVisibility() != 0);
    if (aoij.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_RED_DOT_SHOW", true, false))
    {
      localFormSimpleItem.setRightIcon(getResources().getDrawable(2130842212));
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    localFormSimpleItem.setRightIcon(null);
  }
  
  private void bKR()
  {
    new QueryTask(new uqy(this), new upm(this)).bq(null);
  }
  
  private void bKS()
  {
    int i = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int j = (int)(24.0F * f1);
    int k = (int)(20.0F * f1);
    int m = (int)(66.0F * f1);
    i = (i - j) / ((int)(50.0F * f1) + k);
    j = (int)(16.0F * f1);
    this.bFF = j;
    this.bFG = j;
    this.bFH = ((int)(5.0F * f1));
    this.bFI = ((int)(f1 * 17.0F));
    this.bFJ = i;
    this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.bFF, this.bFH, this.bFG, this.bFI);
  }
  
  private void bKT()
  {
    View localView = this.p[26];
    if (localView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        break label116;
      }
      SpannableString localSpannableString = new SpannableString("[Avatar]");
      Drawable localDrawable = ax();
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, ankt.dip2px(32.0F), ankt.dip2px(32.0F));
        localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
        a(localView, localSpannableString, null, null);
      }
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      localView = this.p[35];
      if (localView != null) {
        ((ImageView)localView).setImageDrawable(ax());
      }
      return;
      label116:
      a(localView, null, null, acfp.m(2131703774));
    }
  }
  
  private void bKV()
  {
    byte[] arrayOfByte = ((TroopManager)this.app.getManager(52)).r(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (arrayOfByte != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        oidb_0xea4.RspBody localRspBody = new oidb_0xea4.RspBody();
        localRspBody.mergeFrom(arrayOfByte);
        a(localRspBody);
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData exception");
        return;
      }
    }
    QLog.d("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData==null");
  }
  
  private void bKW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop quitTroop mTroopInfoData.bOwner = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner);
    }
    Object localObject;
    if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject == null)
      {
        localObject = null;
        this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label186;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && (this.bFL == 0)) {
        break label179;
      }
      bKX();
      label107:
      localObject = "2";
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label237;
      }
      localObject = "0";
    }
    for (;;)
    {
      anot.a(this.app, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject, "", "");
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label179:
      bKY();
      break label107;
      label186:
      localObject = ausj.b(this);
      ((ausj)localObject).setMainTitle(2131691988);
      ((ausj)localObject).addButton(2131693282, 3);
      ((ausj)localObject).a(new upr(this, (ausj)localObject));
      ((ausj)localObject).addCancelButton(getString(2131721058));
      ((ausj)localObject).show();
      break label107;
      label237:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        localObject = "1";
      }
    }
  }
  
  private void bKX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop showDisbandTroopAlertWindow");
    }
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131561286);
    ((TextView)localReportDialog.findViewById(2131365903)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365891);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365889);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365895);
    String str = acfp.m(2131703749);
    localTextView1.setText(getString(2131691982, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131721079);
    localTextView3.setText(2131721058);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new ups(this, localReportDialog));
    localTextView3.setOnClickListener(new upt(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void bKY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop troopDisband");
    }
    getString(2131692811);
    String str = getString(2131691981);
    ausj localausj = ausj.b(this);
    localausj.setMainTitle(str);
    localausj.addButton(getString(2131691980), 3);
    localausj.addCancelButton(getString(2131721058));
    localausj.a(new upu(this, localausj));
    localausj.show();
  }
  
  private void bKZ()
  {
    acms localacms = (acms)this.app.getBusinessHandler(20);
    if (localacms != null) {
      localacms.j(accc.Z(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), true, 1);
    }
    this.jdField_b_of_type_Jrp.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_Jrp$a);
  }
  
  private void bKq()
  {
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.p[38];
    if ((localFormSimpleItem == null) || (localFormSimpleItem.getVisibility() != 0)) {
      return;
    }
    Object localObject = ((aenw)aeif.a().o(551)).a(4);
    if ((localObject != null) && (((aenw.a)localObject).bVi))
    {
      localFormSimpleItem.setVisibility(0);
      if (!((aohy)this.app.getManager(339)).e(4, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
        break label130;
      }
    }
    label130:
    for (localObject = "已开启";; localObject = "未开启")
    {
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (!aoij.a(this.app, "SP_KEY_SING_TOGETHER_TROOP_RED_DOT_SHOW", true, false)) {
        break;
      }
      localFormSimpleItem.setRightIcon(getResources().getDrawable(2130842212));
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    localFormSimpleItem.setRightIcon(null);
  }
  
  private void bLA()
  {
    Object localObject = (FormSwitchItem)this.p[31];
    if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (localObject != null))
    {
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.showGameSwitchStatus != 1) {
        break label82;
      }
      ((FormSwitchItem)localObject).setVisibility(0);
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.gameSwitchStatus != 1) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
      ((Switch)localObject).setClickable(true);
      return;
    }
    label82:
    ((FormSwitchItem)localObject).setVisibility(8);
  }
  
  private void bLB()
  {
    Object localObject = (TroopManager)this.app.getManager(52);
    long l;
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      l = 0L;
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) {
        l = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.cmdUinFlagEx2;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("mTroopInfo.mask=");
        if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) {
          break label172;
        }
      }
    }
    label172:
    for (localObject = "no troopInfo";; localObject = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.cmdUinFlagEx2 + "")
    {
      QLog.d("Q.chatopttroop", 2, (String)localObject);
      boolean bool = TroopInfo.isCmdUinFlagEx2Open(l, 512);
      localObject = (FormSwitchItem)this.p[10];
      if (localObject != null)
      {
        localObject = ((FormSwitchItem)localObject).a();
        ((Switch)localObject).setOnCheckedChangeListener(null);
        ((Switch)localObject).setChecked(bool);
        bLC();
        ((Switch)localObject).setOnCheckedChangeListener(this);
      }
      return;
      localObject = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo;
      break;
    }
  }
  
  private void bLC()
  {
    int j = 0;
    boolean bool1 = ((FormSwitchItem)this.p[10]).isChecked();
    Object localObject = this.p[8];
    if (!bool1)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      if ((this.jdField_x_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && ((localObject instanceof FormSwitchItem)))
      {
        boolean bool2 = ((FormSwitchItem)localObject).isChecked();
        localObject = this.jdField_x_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        if ((bool1) || (bool2)) {
          break label92;
        }
      }
    }
    label92:
    for (int i = j;; i = 8)
    {
      ((FormSimpleItem)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  private void bLD()
  {
    boolean bool = ((TroopManager)this.app.getManager(52)).kx(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.p[19];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131698443));
    }
  }
  
  private void bLE()
  {
    int j = 0;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    bLc();
    Object localObject = this.p[5];
    if ((bool) && (this.aUn)) {}
    for (int i = 0;; i = 8)
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(i);
      }
      localObject = (FormSimpleItem)this.p[6];
      if (localObject != null)
      {
        if (i == 0) {
          j = 3;
        }
        ((FormSimpleItem)localObject).setBgType(j);
      }
      return;
    }
  }
  
  private void bLa()
  {
    acms localacms = (acms)this.app.getBusinessHandler(20);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum <= 100) {
      localacms.a(accc.Z(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 0L, 5, 100, 0);
    }
  }
  
  private void bLh()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) {}
    do
    {
      return;
      localObject = (Boolean)this.jdField_a_of_type_Aqlz.jb.get(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
    } while ((localObject != null) && (((Boolean)localObject).booleanValue()));
    anot.a(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "0", "");
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
    }
    for (;;)
    {
      ausj localausj = (ausj)auss.a(this, null);
      localausj.setMainTitle(getString(2131720791, new Object[] { localObject }));
      localausj.addRadioButton(getString(2131699868), false);
      localausj.addRadioButton(getString(2131699864), false);
      localausj.addRadioButton(getString(2131699860), false);
      int i = this.app.cs(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      switch (i)
      {
      }
      for (;;)
      {
        localausj.addCancelButton(2131721058);
        localausj.a(new upw(this, i, localausj));
        localausj.show();
        return;
        localausj.setRadioButtonChecked(0);
        continue;
        localausj.setRadioButtonChecked(1);
        continue;
        localausj.setRadioButtonChecked(2);
      }
    }
  }
  
  private void bLi()
  {
    if ((this.F == null) || (this.F.isShowing())) {}
    try
    {
      this.F.dismiss();
      label24:
      this.F = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  private void bLj()
  {
    bLi();
    this.F = aqha.a(this, 230).setTitle(getString(2131699849));
    this.F.setPositiveButton(getString(2131699848), new uqa(this));
    try
    {
      this.F.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bLk()
  {
    aqfr.b("Grp_set_new", "grpData_admin", "clk_notice", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), "3.4.4" });
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (TextUtils.isEmpty(this.aMj)))
    {
      bLj();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Aeoo;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = aeop.a();
      this.jdField_a_of_type_Aeoo = ((aeoo)localObject1);
    }
    localObject1 = ((aeoo)localObject1).bzY;
    localObject2 = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", apuh.a((String)localObject1, 0L, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app, true));
    ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
    ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult((Intent)localObject2, 17);
  }
  
  private void bLm()
  {
    View localView = this.p[14];
    if (localView != null)
    {
      localView.setOnTouchListener(null);
      localView.setOnClickListener(null);
    }
  }
  
  private void bLr()
  {
    View localView = this.p[33];
    if ((localView != null) && ((localView instanceof ExpandableTextView)))
    {
      localObject2 = apuh.l(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        localObject1 = (String)localObject2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      }
      ((ExpandableTextView)localView).setText(new aofk((CharSequence)localObject1, 11, 16));
    }
    Object localObject2 = this.p[37];
    if ((localObject2 != null) && ((localObject2 instanceof TextView))) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label156;
      }
    }
    label156:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;; localObject1 = getString(2131698378))
    {
      ((TextView)localObject2).setText(new aofk((CharSequence)localObject1, 11, 16));
      return;
    }
  }
  
  private void bLs()
  {
    atg();
    ((acms)this.app.getBusinessHandler(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.authKey, this.authSig, null, null);
  }
  
  private void bLu()
  {
    ImageView localImageView = (ImageView)this.p[12].findViewById(2131374327);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFlagExt4(3)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFreezeReason(2)))
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
  
  private void bLw()
  {
    if ((this.p == null) || (this.p.length <= 0)) {}
    for (;;)
    {
      return;
      View localView = this.p[13];
      if (localView != null)
      {
        Object localObject1 = null;
        int i = 0;
        while (i <= 7)
        {
          switch (i)
          {
          default: 
            if ((localObject1 == null) || (((View)localObject1).getVisibility() != 0)) {
              break label383;
            }
            Object localObject2 = ((View)localObject1).getTag();
            if ((localObject2 == null) || (!(localObject2 instanceof oidb_0xea4.AppInfo))) {
              break label383;
            }
            localObject2 = (oidb_0xea4.AppInfo)localObject2;
            long l = -1000L;
            int j = -1000;
            if (((oidb_0xea4.AppInfo)localObject2).push_red_point.has()) {
              j = ((oidb_0xea4.AppInfo)localObject2).push_red_point.get();
            }
            if (((oidb_0xea4.AppInfo)localObject2).appid.has()) {
              l = ((oidb_0xea4.AppInfo)localObject2).appid.get();
            }
            if (l != 1L) {
              break label383;
            }
            boolean bool = aqgx.c(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
            if ((j != -1) && (!bool)) {
              break;
            }
          }
          for (i = 1;; i = 0)
          {
            localObject1 = (TextView)((View)localObject1).findViewById(2131362863);
            if (i == 0) {
              break label375;
            }
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setText("");
            ((TextView)localObject1).setBackgroundResource(0);
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130851400, 0, 0, 0);
            return;
            localObject1 = localView.findViewById(2131380212);
            break;
            localObject1 = localView.findViewById(2131380213);
            break;
            localObject1 = localView.findViewById(2131380214);
            break;
            localObject1 = localView.findViewById(2131380215);
            break;
            localObject1 = localView.findViewById(2131380216);
            break;
            localObject1 = localView.findViewById(2131380217);
            break;
            localObject1 = localView.findViewById(2131380218);
            break;
            localObject1 = localView.findViewById(2131380219);
            break;
          }
          label375:
          ((TextView)localObject1).setVisibility(8);
          return;
          label383:
          i += 1;
        }
      }
    }
  }
  
  private void bLx()
  {
    if ((this.C == null) && (getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.C = new Intent();
      this.C.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    Intent localIntent2 = this.C;
    Intent localIntent1 = localIntent2;
    if (this.aUy)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.aUy = false;
    }
    setResult(-1, localIntent1);
  }
  
  private void bLy()
  {
    boolean bool = ((TroopManager)this.app.getManager(52)).kv(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject = (FormSwitchItem)this.p[7];
    if (localObject != null)
    {
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
    }
  }
  
  private void bLz()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop()))
    {
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setText(getString(2131694513));
      localFormSwitchItem.getTextView().setTextColor(getResources().getColor(2131167304));
      localFormSwitchItem.setFocusable(true);
      localFormSwitchItem.getBackground().setAlpha(255);
      localFormSwitchItem.setContentDescription(getString(2131694513));
      this.p[31] = localFormSwitchItem;
      localFormSwitchItem.a().setTag(Integer.valueOf(31));
      this.dl.addView(localFormSwitchItem);
      bLA();
    }
  }
  
  private void fJ(List<oidb_0x899.memberlist> paramList)
  {
    acms localacms = (acms)this.app.getBusinessHandler(20);
    ArrayList localArrayList1 = new ArrayList();
    aptw localaptw = (aptw)this.app.getManager(203);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      localObject = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {
        paramList = (List<oidb_0x899.memberlist>)localObject;
      } else if (localaptw.gM(str)) {
        localArrayList1.add(localObject);
      } else if (apuh.g(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str)) {
        localArrayList2.add(localObject);
      } else {
        localArrayList3.add(localObject);
      }
    }
    this.qC = new ArrayList();
    Object localObject = paramList;
    if (paramList == null) {}
    try
    {
      localObject = new oidb_0x899.memberlist();
      ((oidb_0x899.memberlist)localObject).uint64_member_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin));
      this.qC.add(0, localObject);
    }
    catch (NumberFormatException paramList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, paramList.toString());
        }
      }
      localObject = apuh.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo, paramList);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label388;
      }
      this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.memberListToShow = ((String)localObject);
      localacms.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
    }
    this.qC.addAll(localArrayList2);
    this.qC.addAll(localArrayList3);
    this.qC.addAll(localArrayList1);
    paramList = new ArrayList();
    localObject = this.qC.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject).next()).uint64_member_uin.get()));
    }
    label388:
  }
  
  private void l(View paramView, String paramString)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363620);
    paramView = (TextView)paramView.findViewById(2131377275);
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(getString(2131699850));
      return;
    }
    paramView.setVisibility(8);
    localTextView.setVisibility(0);
    localTextView.setText(paramString);
  }
  
  private void uV(String paramString)
  {
    runOnUiThread(new ChatSettingForTroop.51(this, paramString));
  }
  
  private void vI(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "switchTroopShowExternal");
    }
    if (aqiw.getSystemNetwork(this) == 0)
    {
      QQToast.a(this, 2131698425, 0).show(getTitleBarHeight());
      bLD();
      return;
    }
    ((acms)this.app.getBusinessHandler(20)).h(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean, false);
    if (paramBoolean)
    {
      anot.a(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label207;
      }
    }
    label207:
    for (String str = "showGrp_open";; str = "showGrp_close")
    {
      aqfr.b("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      anot.a(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      break;
    }
  }
  
  private void vq(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)
    {
      bLs();
      return;
    }
    vr(paramString);
  }
  
  private void vr(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      if ((this.bFK == 1) || (this.bFK == 2)) {
        i = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, this.mTitleTv.getText().toString(), this.authKey, this.authSig, paramString));
        return;
      }
      paramString = AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, this.mTitleTv.getText().toString(), this.authKey, this.authSig, paramString);
      paramString.putExtra("from_newer_guide", getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 10);
      return;
    }
    cf(2131721390, 0);
  }
  
  private void wA(boolean paramBoolean)
  {
    accc localaccc = (accc)this.app.getBusinessHandler(22);
    int i;
    if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopcode != null))
    {
      str = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      if (!paramBoolean) {
        break label149;
      }
      i = 0;
      label45:
      if (!localaccc.N(str, i)) {
        break label161;
      }
      if (!paramBoolean) {
        break label154;
      }
    }
    label149:
    label154:
    for (String str = "open_stick";; str = "close_stick")
    {
      anot.a(this.app, "dc00899", "Grp_set", "", "Grp_data", str, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      aqfr.b("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      break;
      i = 1;
      break label45;
    }
    label161:
    bLy();
  }
  
  private void wB(boolean paramBoolean)
  {
    int j = 1;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      cf(2131693404, 1);
      bLB();
      return;
    }
    if (paramBoolean) {
      acqe.a(this.app).bO(this);
    }
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i = 1;
      int k = (int)NetConnInfoCenter.getServerTime();
      ((acms)this.app.getBusinessHandler(20)).c(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, this.app.getCurrentUin(), i, 512, k);
      bLC();
      localQQAppInterface = this.app;
      if (!paramBoolean) {
        break label142;
      }
    }
    label142:
    for (int i = j;; i = 2)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X800A348", "0X800A348", 2, i, "0", "0", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  private void wx(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.p != null) {}
    for (View localView = this.p[25];; localView = null)
    {
      Object localObject2;
      Object localObject1;
      if (localView != null)
      {
        localObject2 = "";
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin != null) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            }
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label480;
        }
        localObject1 = " ";
      }
      label274:
      label453:
      label475:
      label480:
      for (;;)
      {
        localView.setVisibility(0);
        int i;
        if (paramBoolean) {
          i = 2131701825;
        }
        for (;;)
        {
          a(25, 2, localView, getString(i), "", true);
          localObject2 = new SpannableString((String)localObject1 + "PT[QR]");
          Object localObject3 = getResources().getDrawable(2130844654);
          ((Drawable)localObject3).setBounds(0, 0, ankt.dip2px(18.0F), ankt.dip2px(18.0F));
          if (ThemeUtil.isInNightMode(this.app)) {
            ((Drawable)localObject3).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
          }
          localObject3 = new uqh(this, (Drawable)localObject3, 0);
          if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
          {
            QLog.e("vip_pretty.Q.chatopttroop", 1, "show the pretty troop icon :" + this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.groupFlagExt4);
            if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.checkFlagExt4(1)) && (!this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.checkFreezeReason(2)))
            {
              i = 1;
              if (i == 0) {
                break label453;
              }
              Drawable localDrawable = getResources().getDrawable(2130847806);
              localDrawable.setBounds(0, 0, ankt.dip2px(40.0F), ankt.dip2px(15.0F));
              ((SpannableString)localObject2).setSpan(new uqi(this, localDrawable, 0), ((String)localObject1).length(), ((String)localObject1).length() + 2, 17);
              ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length() + 2, ((String)localObject1).length() + 6, 17);
            }
          }
          for (;;)
          {
            paramBoolean = bool;
            if (!" ".equals(localObject1)) {
              paramBoolean = true;
            }
            apuh.a(localView, (CharSequence)localObject2, null, null, paramBoolean, (String)localObject1, acfp.m(2131692333), new uqk(this));
            localView.setOnClickListener(this);
            return;
            if (paramBoolean) {
              break label475;
            }
            i = 2131701827;
            break;
            if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.checkFlagExt4(2))
            {
              i = 1;
              break label274;
              QLog.e("vip_pretty.Q.chatopttroop", 1, "not show the pretty troop icon");
            }
            i = 0;
            break label274;
            ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length(), ((SpannableString)localObject2).length(), 17);
          }
          i = 0;
        }
      }
    }
  }
  
  private void wy(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 30) {}
    for (Intent localIntent = new Intent(this, ChatActivity.class);; localIntent = new Intent(this, SplashActivity.class))
    {
      localIntent = wja.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      if ((paramBoolean) && (this.aUv))
      {
        localIntent.putExtra("fromThirdAppByOpenSDK", true);
        localIntent.putExtra("appid", getIntent().getExtras().getString("appid"));
        localIntent.putExtra("pkg_name", getIntent().getExtras().getString("pkg_name"));
        localIntent.putExtra("app_name", getIntent().getExtras().getString("app_name"));
        localIntent.putExtra("action", getIntent().getExtras().getInt("pkg_name"));
      }
      startActivity(localIntent);
      return;
    }
  }
  
  private void wz(boolean paramBoolean)
  {
    this.gt.setVisibility(0);
    this.f.setVisibility(0);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    anlm.a(this.f, getActivity().getWindow());
  }
  
  protected void A(int paramInt, Intent paramIntent)
  {
    bLq();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      ThreadManager.post(new ChatSettingForTroop.43(this, paramIntent), 8, null, true);
    }
  }
  
  protected void B(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      String str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.", 2, "ChatSettingActivity|onActivityResult|REQUEST_FOR_TROOP_DISBAND|isNeedFinish = " + bool + ", strTip = " + str);
      }
      if ((!TextUtils.isEmpty(str)) && (bool))
      {
        if (this.jdField_a_of_type_Arib == null) {
          this.jdField_a_of_type_Arib = new arib(this);
        }
        this.jdField_a_of_type_Arib.aa(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopOwner(paramIntent, this.app.getCurrentAccountUin());
        }
        bLE();
        bLa();
        if (this.jdField_a_of_type_Arib == null) {
          this.jdField_a_of_type_Arib = new arib(this);
        }
        this.jdField_a_of_type_Arib.aa(1, str, 1000);
        return;
      }
    } while (!bool);
    paramIntent = new Intent();
    paramIntent.putExtra("isNeedFinish", true);
    setResult(-1, paramIntent);
    finish();
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131369154);
    if (paramString != null)
    {
      paramString.setEditableFactory(aofr.a);
      if (!TextUtils.isEmpty(paramCharSequence)) {
        break label70;
      }
    }
    label70:
    for (paramView = "";; paramView = new aofk(paramCharSequence, 3))
    {
      paramString.setText(paramView);
      paramString.setTextColor(getResources().getColor(2131167379));
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, boolean paramBoolean)
  {
    label52:
    TextView localTextView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        paramView.getBackground().setAlpha(255);
        localTextView = (TextView)paramView.findViewById(2131379769);
        if (localTextView != null)
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label177;
          }
          localTextView.setText("");
          localTextView.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      a(paramInt1, paramView, paramBoolean);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130839682);
      break label52;
      paramView.setBackgroundResource(2130839701);
      break label52;
      paramView.setBackgroundResource(2130839695);
      break label52;
      paramView.setBackgroundResource(2130839689);
      break label52;
      paramView.setBackgroundColor(Color.parseColor("#00000000"));
      break label52;
      label177:
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.showArrow(true);
      switch (paramInt2)
      {
      default: 
        label60:
        paramFormSimpleItem.setRightTextColor(2);
        paramFormSimpleItem.setLeftTextColor(0);
        paramFormSimpleItem.getBackground().setAlpha(255);
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        paramFormSimpleItem.setLeftText(str);
        paramFormSimpleItem.a().setEditableFactory(aofr.a);
        if (paramCharSequence != null) {
          break;
        }
      }
    }
    for (paramString = "";; paramString = new aofk(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.showArrow(false);
      break;
      paramFormSimpleItem.setBgType(0);
      break label60;
      paramFormSimpleItem.setBgType(1);
      break label60;
      paramFormSimpleItem.setBgType(2);
      break label60;
      paramFormSimpleItem.setBgType(3);
      break label60;
      paramFormSimpleItem.setBackgroundColor(Color.parseColor("#00000000"));
      break label60;
    }
  }
  
  protected void a(int paramInt, View paramView, boolean paramBoolean)
  {
    int i = 0;
    if (paramView == null) {}
    do
    {
      return;
      if (33 == paramInt) {
        paramBoolean = false;
      }
      paramView = paramView.findViewById(2131362978);
    } while (paramView == null);
    if (paramBoolean) {}
    for (paramInt = i;; paramInt = 8)
    {
      paramView.setVisibility(paramInt);
      return;
    }
  }
  
  /* Error */
  public void a(KQQ.BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 1913	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 1915	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 1916	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 1920	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 1921	[B
    //   30: invokevirtual 1922	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 1925	KQQ/BatchResponse:seq	I
    //   38: ifne +748 -> 786
    //   41: aload 10
    //   43: ifnull +743 -> 786
    //   46: aload 10
    //   48: getfield 1929	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 1932	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +732 -> 786
    //   57: aload 10
    //   59: getfield 1929	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 1935	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 1941	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 8
    //   70: new 1943	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 1944	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 9
    //   79: aload 9
    //   81: aload 8
    //   83: invokevirtual 1945	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 8
    //   90: aload 9
    //   92: getfield 1949	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 1954	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +53 -> 155
    //   105: iconst_0
    //   106: istore_3
    //   107: goto +1306 -> 1413
    //   110: aload 8
    //   112: ifnonnull +674 -> 786
    //   115: iload 4
    //   117: iload_3
    //   118: if_icmpge +668 -> 786
    //   121: aload 11
    //   123: iload 4
    //   125: invokeinterface 1956 2 0
    //   130: checkcast 1958	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   133: astore 9
    //   135: aload 9
    //   137: ifnonnull +29 -> 166
    //   140: iload 4
    //   142: iconst_1
    //   143: iadd
    //   144: istore 4
    //   146: goto -36 -> 110
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   154: return
    //   155: aload 11
    //   157: invokeinterface 1962 1 0
    //   162: istore_3
    //   163: goto +1250 -> 1413
    //   166: aload 9
    //   168: getfield 1966	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 1969	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore_2
    //   175: iload_2
    //   176: bipush 72
    //   178: if_icmpne +83 -> 261
    //   181: iload 4
    //   183: ifne +78 -> 261
    //   186: aload_0
    //   187: ldc_w 1970
    //   190: iconst_1
    //   191: invokestatic 1596	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   194: aload_0
    //   195: invokevirtual 1599	com/tencent/mobileqq/activity/ChatSettingForTroop:getTitleBarHeight	()I
    //   198: invokevirtual 1602	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   201: pop
    //   202: new 1972	com/tencent/mobileqq/activity/ChatSettingForTroop$35
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 1973	com/tencent/mobileqq/activity/ChatSettingForTroop$35:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   210: bipush 32
    //   212: aconst_null
    //   213: iconst_0
    //   214: invokestatic 1978	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   222: aload_0
    //   223: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: iconst_0
    //   227: putfield 1551	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   230: aload_0
    //   231: invokevirtual 1429	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   234: ldc_w 1980
    //   237: iconst_0
    //   238: invokevirtual 713	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   241: pop
    //   242: aload_0
    //   243: invokevirtual 1744	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   246: aload_0
    //   247: aload_0
    //   248: invokevirtual 1429	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   251: invokevirtual 1764	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   254: iconst_2
    //   255: invokestatic 1983	apuh:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   258: goto -118 -> 140
    //   261: iload_2
    //   262: ifne +1051 -> 1313
    //   265: aload 9
    //   267: getfield 1987	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   270: invokevirtual 1990	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   273: ifeq +1040 -> 1313
    //   276: aload 9
    //   278: getfield 1987	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   281: invokevirtual 1993	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   284: checkcast 1989	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   287: astore 9
    //   289: aload 9
    //   291: astore 8
    //   293: aload 9
    //   295: ifnull -155 -> 140
    //   298: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +40 -> 341
    //   304: ldc_w 604
    //   307: iconst_2
    //   308: new 984	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 985	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 1995
    //   318: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 9
    //   323: getfield 1998	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_long_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   326: invokevirtual 1935	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   329: invokevirtual 2001	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   332: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 997	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 523	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload 9
    //   343: astore 8
    //   345: aload_0
    //   346: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   349: ifnull -209 -> 140
    //   352: aload_0
    //   353: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   356: aload 9
    //   358: invokevirtual 2005	com/tencent/mobileqq/troopinfo/TroopInfoData:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   361: aload_0
    //   362: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   365: getfield 1627	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   368: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +7 -> 378
    //   374: aload_0
    //   375: invokevirtual 1196	com/tencent/mobileqq/activity/ChatSettingForTroop:bLc	()V
    //   378: aload_0
    //   379: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   382: getfield 530	com/tencent/mobileqq/troopinfo/TroopInfoData:hasSetNewTroopHead	Z
    //   385: ifeq +7 -> 392
    //   388: aload_0
    //   389: invokespecial 2007	com/tencent/mobileqq/activity/ChatSettingForTroop:bKT	()V
    //   392: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq +69 -> 464
    //   398: aload 9
    //   400: getfield 2010	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   403: invokevirtual 1969	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   406: istore_2
    //   407: ldc_w 2012
    //   410: iconst_2
    //   411: new 984	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 985	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 2014
    //   421: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   428: getfield 476	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   431: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 2016
    //   437: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload_2
    //   441: invokevirtual 1717	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc_w 2018
    //   447: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_2
    //   451: i2l
    //   452: invokestatic 2021	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   455: invokevirtual 994	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   458: invokevirtual 997	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 523	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload_0
    //   465: getfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   468: ifnull +64 -> 532
    //   471: aload_0
    //   472: getfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   475: aload 9
    //   477: invokevirtual 2022	com/tencent/mobileqq/data/TroopInfo:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   480: aload_0
    //   481: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   484: aload_0
    //   485: getfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   488: invokevirtual 1221	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   491: putfield 1627	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   494: aload_0
    //   495: getfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   498: getfield 2025	com/tencent/mobileqq/data/TroopInfo:isNewTroop	Z
    //   501: ifne +17 -> 518
    //   504: aload_0
    //   505: getfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   508: aload_0
    //   509: getfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   512: invokevirtual 1221	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   515: putfield 2026	com/tencent/mobileqq/data/TroopInfo:newTroopName	Ljava/lang/String;
    //   518: aload_0
    //   519: getfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   522: aload_0
    //   523: getfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   526: invokevirtual 1221	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   529: putfield 2029	com/tencent/mobileqq/data/TroopInfo:oldTroopName	Ljava/lang/String;
    //   532: aload_0
    //   533: aload 9
    //   535: getfield 2010	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   538: invokevirtual 1969	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   541: i2l
    //   542: invokestatic 2021	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   545: putfield 2031	com/tencent/mobileqq/activity/ChatSettingForTroop:aUo	Z
    //   548: aload_0
    //   549: getfield 2031	com/tencent/mobileqq/activity/ChatSettingForTroop:aUo	Z
    //   552: ifeq +77 -> 629
    //   555: aload_0
    //   556: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   559: getfield 527	com/tencent/mobileqq/troopinfo/TroopInfoData:bOwner	Z
    //   562: ifeq +736 -> 1298
    //   565: iconst_1
    //   566: istore_2
    //   567: new 2033	anov
    //   570: dup
    //   571: aload_0
    //   572: getfield 372	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   575: invokespecial 2036	anov:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   578: ldc_w 1013
    //   581: invokevirtual 2039	anov:a	(Ljava/lang/String;)Lanov;
    //   584: ldc_w 2041
    //   587: invokevirtual 2043	anov:b	(Ljava/lang/String;)Lanov;
    //   590: ldc_w 1017
    //   593: invokevirtual 2045	anov:c	(Ljava/lang/String;)Lanov;
    //   596: ldc_w 2047
    //   599: invokevirtual 2049	anov:d	(Ljava/lang/String;)Lanov;
    //   602: iconst_2
    //   603: anewarray 456	java/lang/String
    //   606: dup
    //   607: iconst_0
    //   608: aload_0
    //   609: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   612: getfield 476	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: iload_2
    //   619: invokestatic 458	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   622: aastore
    //   623: invokevirtual 2052	anov:a	([Ljava/lang/String;)Lanov;
    //   626: invokevirtual 2055	anov:report	()V
    //   629: aload_0
    //   630: getfield 2031	com/tencent/mobileqq/activity/ChatSettingForTroop:aUo	Z
    //   633: ifne +791 -> 1424
    //   636: aload_0
    //   637: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   640: getfield 2056	com/tencent/mobileqq/troopinfo/TroopInfoData:isNewTroop	Z
    //   643: ifne +781 -> 1424
    //   646: iconst_1
    //   647: istore 5
    //   649: aload_0
    //   650: iload 5
    //   652: invokespecial 848	com/tencent/mobileqq/activity/ChatSettingForTroop:wx	(Z)V
    //   655: aload_0
    //   656: invokevirtual 2059	com/tencent/mobileqq/activity/ChatSettingForTroop:bLo	()V
    //   659: aload_0
    //   660: getfield 372	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   663: aload_0
    //   664: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   667: getfield 2062	com/tencent/mobileqq/troopinfo/TroopInfoData:publicAccountUin	J
    //   670: new 2064	uqg
    //   673: dup
    //   674: aload_0
    //   675: invokespecial 2065	uqg:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   678: invokestatic 2070	aprz:c	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjnm$d;)V
    //   681: aload_0
    //   682: invokevirtual 2073	com/tencent/mobileqq/activity/ChatSettingForTroop:bLn	()V
    //   685: aload_0
    //   686: invokespecial 2075	com/tencent/mobileqq/activity/ChatSettingForTroop:bLr	()V
    //   689: aload_0
    //   690: invokevirtual 2078	com/tencent/mobileqq/activity/ChatSettingForTroop:bLb	()V
    //   693: aload_0
    //   694: invokespecial 1566	com/tencent/mobileqq/activity/ChatSettingForTroop:bLu	()V
    //   697: aload_0
    //   698: invokevirtual 2081	com/tencent/mobileqq/activity/ChatSettingForTroop:bLt	()V
    //   701: aload_0
    //   702: getfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   705: ifnull +21 -> 726
    //   708: aload_0
    //   709: getfield 355	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   712: aload_0
    //   713: getfield 372	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   716: aload_0
    //   717: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   720: getfield 1551	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   723: invokestatic 2084	apuh:a	(Lcom/tencent/mobileqq/data/TroopInfo;Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   726: aload_0
    //   727: invokevirtual 2087	com/tencent/mobileqq/activity/ChatSettingForTroop:bLd	()V
    //   730: aload 9
    //   732: astore 8
    //   734: aload_0
    //   735: getfield 2089	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   738: ifnull -598 -> 140
    //   741: aload_0
    //   742: getfield 2089	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   745: aload_0
    //   746: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   749: invokevirtual 2095	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:setTroopInfoData	(Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)V
    //   752: aload_0
    //   753: getfield 2089	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   756: invokevirtual 2098	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:initView	()V
    //   759: aload 9
    //   761: astore 8
    //   763: goto -623 -> 140
    //   766: astore 8
    //   768: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   771: ifeq +15 -> 786
    //   774: ldc_w 1833
    //   777: iconst_2
    //   778: aload 8
    //   780: invokevirtual 2099	java/lang/Exception:toString	()Ljava/lang/String;
    //   783: invokestatic 615	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   786: aload_1
    //   787: getfield 1925	KQQ/BatchResponse:seq	I
    //   790: iconst_1
    //   791: if_icmpne +92 -> 883
    //   794: aload 10
    //   796: ifnull +87 -> 883
    //   799: aload 10
    //   801: getfield 1929	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   804: invokevirtual 1932	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   807: ifeq +76 -> 883
    //   810: aload 10
    //   812: getfield 1929	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   815: invokevirtual 1935	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   818: invokevirtual 1941	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   821: astore 8
    //   823: new 2101	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   826: dup
    //   827: invokespecial 2102	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   830: astore 9
    //   832: aload 9
    //   834: aload 8
    //   836: invokevirtual 2103	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   839: pop
    //   840: aload 9
    //   842: getfield 2106	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   845: invokevirtual 2107	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   848: ifeq +35 -> 883
    //   851: aload_0
    //   852: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   855: getfield 1551	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   858: ifne +485 -> 1343
    //   861: aload_0
    //   862: getfield 2089	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   865: ifnull +18 -> 883
    //   868: aload_0
    //   869: getfield 2089	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   872: aload 9
    //   874: getfield 2106	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   877: invokevirtual 1954	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   880: invokevirtual 2110	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:mY	(Ljava/util/List;)V
    //   883: aload_1
    //   884: getfield 1925	KQQ/BatchResponse:seq	I
    //   887: iconst_2
    //   888: if_icmpne -877 -> 11
    //   891: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   894: ifeq +13 -> 907
    //   897: ldc_w 2112
    //   900: iconst_2
    //   901: ldc_w 2114
    //   904: invokestatic 523	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   907: aload 10
    //   909: ifnull -898 -> 11
    //   912: aload 10
    //   914: getfield 1929	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   917: invokevirtual 1932	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   920: ifeq -909 -> 11
    //   923: aload 10
    //   925: getfield 1929	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   928: invokevirtual 1935	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   931: invokevirtual 1941	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   934: astore_1
    //   935: new 2116	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   938: dup
    //   939: invokespecial 2117	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   942: astore 8
    //   944: aload 8
    //   946: aload_1
    //   947: invokevirtual 2118	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   950: pop
    //   951: aload 8
    //   953: getfield 2121	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   956: invokevirtual 1397	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   959: ifeq -948 -> 11
    //   962: aload 8
    //   964: getfield 2124	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   967: invokevirtual 2125	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   970: ifne +438 -> 1408
    //   973: aload 8
    //   975: getfield 2124	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   978: invokevirtual 1954	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   981: astore_1
    //   982: aload_0
    //   983: getfield 372	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   986: bipush 52
    //   988: invokevirtual 468	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   991: checkcast 470	com/tencent/mobileqq/app/TroopManager
    //   994: astore 9
    //   996: aload 8
    //   998: getfield 2121	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1001: invokevirtual 1399	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1004: lstore 6
    //   1006: aload 9
    //   1008: lload 6
    //   1010: invokestatic 1514	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1013: invokevirtual 479	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1016: astore 10
    //   1018: aload 10
    //   1020: ifnull -1009 -> 11
    //   1023: aload_1
    //   1024: ifnull +69 -> 1093
    //   1027: aload 10
    //   1029: aload_1
    //   1030: invokevirtual 2128	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap787	(Ljava/util/List;)V
    //   1033: aload 8
    //   1035: getfield 2131	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1038: invokevirtual 2132	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1041: ifeq +340 -> 1381
    //   1044: aload 8
    //   1046: getfield 2131	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1049: invokevirtual 1969	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1052: istore_2
    //   1053: aload 10
    //   1055: iload_2
    //   1056: i2l
    //   1057: putfield 2135	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   1060: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1063: ifeq +30 -> 1093
    //   1066: ldc_w 2112
    //   1069: iconst_2
    //   1070: new 984	java/lang/StringBuilder
    //   1073: dup
    //   1074: invokespecial 985	java/lang/StringBuilder:<init>	()V
    //   1077: ldc_w 2137
    //   1080: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: iload_2
    //   1084: invokevirtual 1717	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1087: invokevirtual 997	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1090: invokestatic 523	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1093: aload 8
    //   1095: getfield 2140	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1098: astore_1
    //   1099: aload_1
    //   1100: ifnull +19 -> 1119
    //   1103: aload 10
    //   1105: aload 8
    //   1107: getfield 2140	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1110: invokevirtual 1935	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1113: invokevirtual 2001	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1116: putfield 2143	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   1119: aload 8
    //   1121: getfield 2146	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1124: astore_1
    //   1125: aload_1
    //   1126: ifnull +19 -> 1145
    //   1129: aload 10
    //   1131: aload 8
    //   1133: getfield 2146	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1136: invokevirtual 1935	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1139: invokevirtual 2001	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1142: putfield 2149	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   1145: iconst_m1
    //   1146: istore_2
    //   1147: iconst_m1
    //   1148: istore_3
    //   1149: aload 8
    //   1151: getfield 2152	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1154: invokevirtual 2132	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1157: ifeq +23 -> 1180
    //   1160: aload 10
    //   1162: aload 8
    //   1164: getfield 2152	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1167: invokevirtual 1969	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1170: i2b
    //   1171: putfield 2155	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   1174: aload 10
    //   1176: getfield 2155	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   1179: istore_2
    //   1180: aload 8
    //   1182: getfield 2158	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1185: invokevirtual 2132	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1188: ifeq +23 -> 1211
    //   1191: aload 10
    //   1193: aload 8
    //   1195: getfield 2158	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1198: invokevirtual 1969	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1201: i2b
    //   1202: putfield 2161	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1205: aload 10
    //   1207: getfield 2161	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1210: istore_3
    //   1211: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1214: ifeq +45 -> 1259
    //   1217: ldc_w 2112
    //   1220: iconst_2
    //   1221: new 984	java/lang/StringBuilder
    //   1224: dup
    //   1225: invokespecial 985	java/lang/StringBuilder:<init>	()V
    //   1228: lload 6
    //   1230: invokevirtual 1176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1233: ldc_w 2163
    //   1236: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: iload_2
    //   1240: invokevirtual 1717	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1243: ldc_w 2165
    //   1246: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: iload_3
    //   1250: invokevirtual 1717	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1253: invokevirtual 997	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1256: invokestatic 523	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1259: new 2167	com/tencent/mobileqq/activity/ChatSettingForTroop$37
    //   1262: dup
    //   1263: aload_0
    //   1264: aload 9
    //   1266: aload 10
    //   1268: invokespecial 2170	com/tencent/mobileqq/activity/ChatSettingForTroop$37:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1271: bipush 8
    //   1273: aconst_null
    //   1274: iconst_0
    //   1275: invokestatic 1825	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1278: return
    //   1279: astore_1
    //   1280: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1283: ifeq -1272 -> 11
    //   1286: ldc_w 2112
    //   1289: iconst_2
    //   1290: aload_1
    //   1291: invokevirtual 2099	java/lang/Exception:toString	()Ljava/lang/String;
    //   1294: invokestatic 1548	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1297: return
    //   1298: aload_0
    //   1299: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1302: getfield 1042	com/tencent/mobileqq/troopinfo/TroopInfoData:bAdmin	Z
    //   1305: ifeq +114 -> 1419
    //   1308: iconst_2
    //   1309: istore_2
    //   1310: goto -743 -> 567
    //   1313: ldc_w 1709
    //   1316: iconst_1
    //   1317: new 984	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 985	java/lang/StringBuilder:<init>	()V
    //   1324: ldc_w 2172
    //   1327: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: iload_2
    //   1331: invokevirtual 1717	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1334: invokevirtual 997	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: invokestatic 1548	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1340: goto -1200 -> 140
    //   1343: aload_0
    //   1344: aload 9
    //   1346: getfield 2106	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1349: invokevirtual 1954	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1352: invokespecial 783	com/tencent/mobileqq/activity/ChatSettingForTroop:fJ	(Ljava/util/List;)V
    //   1355: goto -472 -> 883
    //   1358: astore 8
    //   1360: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1363: ifeq -480 -> 883
    //   1366: ldc_w 1833
    //   1369: iconst_2
    //   1370: aload 8
    //   1372: invokevirtual 2099	java/lang/Exception:toString	()Ljava/lang/String;
    //   1375: invokestatic 615	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1378: goto -495 -> 883
    //   1381: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1384: ifeq -291 -> 1093
    //   1387: ldc_w 2112
    //   1390: iconst_2
    //   1391: ldc_w 2174
    //   1394: invokestatic 523	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1397: goto -304 -> 1093
    //   1400: astore_1
    //   1401: goto -256 -> 1145
    //   1404: astore_1
    //   1405: goto -286 -> 1119
    //   1408: aconst_null
    //   1409: astore_1
    //   1410: goto -428 -> 982
    //   1413: iconst_0
    //   1414: istore 4
    //   1416: goto -1306 -> 110
    //   1419: iconst_3
    //   1420: istore_2
    //   1421: goto -854 -> 567
    //   1424: iconst_0
    //   1425: istore 5
    //   1427: goto -778 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1430	0	this	ChatSettingForTroop
    //   0	1430	1	paramBatchResponse	KQQ.BatchResponse
    //   174	1247	2	i	int
    //   106	1144	3	j	int
    //   115	1300	4	k	int
    //   647	779	5	bool	boolean
    //   1004	225	6	l	long
    //   68	694	8	localObject1	Object
    //   766	13	8	localException1	Exception
    //   821	373	8	localObject2	Object
    //   1358	13	8	localException2	Exception
    //   77	1268	9	localObject3	Object
    //   19	1248	10	localObject4	Object
    //   98	58	11	localList	List
    // Exception table:
    //   from	to	target	type
    //   21	34	149	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	87	766	java/lang/Exception
    //   90	100	766	java/lang/Exception
    //   121	135	766	java/lang/Exception
    //   155	163	766	java/lang/Exception
    //   166	175	766	java/lang/Exception
    //   186	258	766	java/lang/Exception
    //   265	289	766	java/lang/Exception
    //   298	341	766	java/lang/Exception
    //   345	378	766	java/lang/Exception
    //   378	392	766	java/lang/Exception
    //   392	464	766	java/lang/Exception
    //   464	518	766	java/lang/Exception
    //   518	532	766	java/lang/Exception
    //   532	565	766	java/lang/Exception
    //   567	629	766	java/lang/Exception
    //   629	646	766	java/lang/Exception
    //   649	726	766	java/lang/Exception
    //   726	730	766	java/lang/Exception
    //   734	759	766	java/lang/Exception
    //   1298	1308	766	java/lang/Exception
    //   1313	1340	766	java/lang/Exception
    //   935	982	1279	java/lang/Exception
    //   982	1018	1279	java/lang/Exception
    //   1027	1093	1279	java/lang/Exception
    //   1093	1099	1279	java/lang/Exception
    //   1119	1125	1279	java/lang/Exception
    //   1149	1180	1279	java/lang/Exception
    //   1180	1211	1279	java/lang/Exception
    //   1211	1259	1279	java/lang/Exception
    //   1259	1278	1279	java/lang/Exception
    //   1381	1397	1279	java/lang/Exception
    //   823	883	1358	java/lang/Exception
    //   1343	1355	1358	java/lang/Exception
    //   1129	1145	1400	java/lang/Exception
    //   1103	1119	1404	java/lang/Exception
  }
  
  protected void a(DiscussionInfoCardActivity.b paramb, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramb.pQ == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_d_of_type_Aqdf.b(paramb.type, paramb.uin, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = aqhu.G();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_d_of_type_Aqdf.isPausing())
        {
          this.jdField_d_of_type_Aqdf.i(paramb.uin, paramb.type, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramb.pQ.setImageDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = null;
    String str;
    if (paramTroopMemberInfo != null)
    {
      str = paramTroopMemberInfo.troopColorNick;
      localObject = paramTroopMemberInfo.troopnick;
      paramTroopMemberInfo = str;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "updateNickUseTroopMemberInfo and colorNick is " + paramTroopMemberInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick = paramTroopMemberInfo;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = ((String)localObject);
        this.mUIHandler.sendEmptyMessage(6);
      }
      return;
      str = null;
      paramTroopMemberInfo = (TroopMemberInfo)localObject;
      localObject = str;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    label314:
    label870:
    do
    {
      for (;;)
      {
        return;
        if (paramJSONObject != null)
        {
          try
          {
            paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
            paramJSONObject = (JSONObject)paramJSONObject.get("result");
            if ((paramInt != 0) || (paramJSONObject == null)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "checkApiState onResult. retCode = " + paramInt + "\n");
            }
            paramBundle = (JSONObject)paramJSONObject.get("basics");
            Object localObject2;
            String str;
            int i;
            Object localObject1;
            if (paramBundle != null)
            {
              paramBundle = (JSONArray)paramBundle.get("datas");
              if (paramBundle != null)
              {
                paramInt = 0;
                if (paramInt < paramBundle.length())
                {
                  localObject2 = (JSONObject)paramBundle.get(paramInt);
                  str = (String)((JSONObject)localObject2).get("name");
                  i = ((Integer)((JSONObject)localObject2).get("state")).intValue();
                  localObject1 = (String)((JSONObject)localObject2).get("api");
                  localObject2 = (String)((JSONObject)localObject2).get("msg");
                  if (!QLog.isColorLevel()) {
                    break label1054;
                  }
                  QLog.i("Q.chatopttroop", 2, "checkApiState onResult, basics name = " + str + " state = " + i + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
                  break label1054;
                }
              }
            }
            paramBundle = (JSONObject)paramJSONObject.get("friendlink");
            if (paramBundle != null)
            {
              paramBundle = (JSONArray)paramBundle.get("datas");
              if (paramBundle != null)
              {
                paramInt = 0;
                if (paramInt < paramBundle.length())
                {
                  localObject2 = (JSONObject)paramBundle.get(paramInt);
                  str = (String)((JSONObject)localObject2).get("name");
                  i = ((Integer)((JSONObject)localObject2).get("state")).intValue();
                  localObject1 = (String)((JSONObject)localObject2).get("api");
                  localObject2 = (String)((JSONObject)localObject2).get("msg");
                  if (("add_group".equals(localObject1)) && (i != 1)) {
                    runOnUiThread(new ChatSettingForTroop.52(this));
                  }
                  if (!QLog.isColorLevel()) {
                    break label1061;
                  }
                  QLog.i("Q.chatopttroop", 2, "checkApiState onResult, friendlink name = " + str + " state = " + i + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
                  break label1061;
                }
              }
            }
            paramInt = ((Integer)paramJSONObject.get("appid")).intValue();
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "checkApiState onResult, appid =" + paramInt + "\n");
            }
            paramJSONObject = (JSONObject)paramJSONObject.get("qqpay");
            if (paramJSONObject == null) {
              continue;
            }
            paramJSONObject = (JSONArray)paramJSONObject.get("datas");
            if (paramJSONObject == null) {
              continue;
            }
            paramInt = 0;
            while (paramInt < paramJSONObject.length())
            {
              localObject1 = (JSONObject)paramJSONObject.get(paramInt);
              paramBundle = (String)((JSONObject)localObject1).get("name");
              i = ((Integer)((JSONObject)localObject1).get("state")).intValue();
              str = (String)((JSONObject)localObject1).get("api");
              localObject1 = (String)((JSONObject)localObject1).get("msg");
              if (QLog.isColorLevel()) {
                QLog.i("Q.chatopttroop", 2, "checkApiState onResult, qqpay name = " + paramBundle + " state = " + i + " api = " + str + " msg= " + (String)localObject1 + "\n");
              }
              paramInt += 1;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          catch (Exception paramJSONObject) {}
          QLog.d("Q.chatopttroop", 2, "checkApiState onResult " + paramJSONObject.toString());
          return;
          if (paramJSONObject != null) {
            try
            {
              paramJSONObject = (JSONObject)paramJSONObject.get("data");
              if (paramJSONObject != null)
              {
                paramJSONObject = (JSONObject)paramJSONObject.get("key");
                if (paramJSONObject != null)
                {
                  paramInt = ((Integer)paramJSONObject.get("retCode")).intValue();
                  paramBundle = (String)paramJSONObject.get("retMsg");
                  if (paramInt != 0) {
                    break label969;
                  }
                  wy(true);
                  anot.a(this.app, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
                  if (QLog.isColorLevel())
                  {
                    QLog.i("Q.chatopttroop", 2, "joinGroup onResult retCode = " + paramInt + " retMsg = " + paramBundle);
                    return;
                  }
                }
              }
            }
            catch (Exception paramJSONObject)
            {
              uV(getActivity().getResources().getString(2131721365));
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "joinGroup onResult " + paramJSONObject.toString());
    return;
    label969:
    paramJSONObject = getActivity().getResources().getString(2131721365);
    switch (paramInt)
    {
    }
    for (;;)
    {
      uV(paramJSONObject);
      break label870;
      paramJSONObject = getActivity().getResources().getString(2131721360);
      continue;
      paramJSONObject = getActivity().getResources().getString(2131721366);
      continue;
      label1054:
      paramInt += 1;
      break;
      label1061:
      paramInt += 1;
      break label314;
    }
  }
  
  public void a(oidb_0xea4.RspBody paramRspBody)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("showGetAppListResult: respBody isNull=");
      if (paramRspBody != null) {
        break label50;
      }
    }
    label50:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("Q.chatopttroop", 2, bool1);
      if (paramRspBody != null) {
        break;
      }
      return;
    }
    View localView = this.p[13];
    this.oW.clear();
    if (localView != null)
    {
      localObject1 = paramRspBody.infos.get();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label188;
      }
      localView.setVisibility(8);
      if (this.rW != null) {
        this.rW.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList == null || appList.size() == 0");
      }
    }
    label188:
    boolean bool2;
    aprp localaprp;
    ArrayList localArrayList;
    Object localObject2;
    long l;
    int i1;
    int i;
    label415:
    int j;
    label417:
    do
    {
      localObject1 = this.p[28];
      if (localObject1 == null) {
        break;
      }
      if (paramRspBody.extra_info.tab_infos.size() <= 0) {
        break label1367;
      }
      ((View)localObject1).setVisibility(0);
      fI(paramRspBody.extra_info.tab_infos.get());
      return;
      bool1 = anlm.ayn();
      bool2 = ThemeUtil.isInNightMode(this.app);
      localView.setVisibility(0);
      this.CN = ((TextView)localView.findViewById(2131380301));
      this.CN.setVisibility(8);
      if (this.rW != null) {
        this.rW.setVisibility(0);
      }
      localaprp = (aprp)this.app.getManager(109);
      localArrayList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_0xea4.AppInfo)((Iterator)localObject1).next();
        l = ((oidb_0xea4.AppInfo)localObject2).appid.get();
        if ((l != 0L) && (((l == 1109863013L) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin)) || (l != 1109863013L))) {
          localArrayList.add(localObject2);
        }
      }
      i1 = localArrayList.size();
      localObject1 = localView.findViewById(2131380226);
      if (i1 > 5) {
        break label483;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList.size() <= 5");
      }
      ((View)localObject1).setVisibility(8);
      if (i1 > 5) {
        break label492;
      }
      i = 4;
      j = 0;
    } while (j > i);
    switch (j)
    {
    }
    for (;;)
    {
      j += 1;
      break label417;
      label483:
      ((View)localObject1).setVisibility(0);
      break;
      label492:
      i = 9;
      break label415;
      localObject1 = localView.findViewById(2131380212);
      label508:
      ImageView localImageView;
      Object localObject3;
      TextView localTextView;
      oidb_0xea4.AppInfo localAppInfo;
      String str;
      int k;
      if ((j <= i) && (j < i1))
      {
        ((View)localObject1).setVisibility(0);
        localImageView = (ImageView)((View)localObject1).findViewById(2131362847);
        localObject3 = (TextView)((View)localObject1).findViewById(2131362865);
        localTextView = (TextView)((View)localObject1).findViewById(2131362863);
        localAppInfo = (oidb_0xea4.AppInfo)localArrayList.get(j);
        str = localAppInfo.name.get();
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localObject2 = str;
        if (str.length() > 4) {
          localObject2 = str.substring(0, 4) + "...";
        }
        if (localAppInfo.source.get() == 1) {
          this.oW.add(Long.valueOf(localAppInfo.appid.get()));
        }
        ((TextView)localObject3).setText((CharSequence)localObject2);
        localObject3 = new StringBuffer((String)localObject2);
        k = localAppInfo.push_red_point.get();
        if (k != -1) {
          break label1174;
        }
        localTextView.setVisibility(0);
        localTextView.setText("");
        localTextView.setBackgroundResource(0);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130851400, 0, 0, 0);
        ((StringBuffer)localObject3).append("，新");
        label741:
        l = localAppInfo.appid.get();
        if ((k != -1) && (l == 1L))
        {
          if (!aqgx.c(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false)) {
            break label1236;
          }
          localTextView.setVisibility(0);
          localTextView.setText("");
          localTextView.setBackgroundResource(0);
          localTextView.setCompoundDrawablesWithIntrinsicBounds(2130851400, 0, 0, 0);
        }
        label819:
        if (l == 0L) {
          MiniProgramLpReportDC04239.reportByQQqunInfo("qun", "qun_info", "expo_more", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (!bool2) {
          break label1254;
        }
        if (!localAppInfo.icon_simple_night.has()) {
          break label1246;
        }
        localObject2 = localAppInfo.icon_simple_night.get();
        label871:
        if (!localAppInfo.icon.has()) {
          break label1286;
        }
        str = localAppInfo.icon.get();
        label892:
        if ((!bool1) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          break label1294;
        }
        label905:
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1301;
        }
        localImageView.setImageResource(2130844521);
      }
      for (;;)
      {
        if (bool2) {
          localImageView.setColorFilter(1996488704);
        }
        ((View)localObject1).setTag(localAppInfo);
        ((View)localObject1).setOnClickListener(this.dh);
        k = 0;
        while (k < i1)
        {
          localObject2 = (oidb_0xea4.AppInfo)localArrayList.get(k);
          if ((localObject2 != null) && (((oidb_0xea4.AppInfo)localObject2).appid != null)) {
            aqfr.b("Grp_app_new", "grpData_admin", "app_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), String.valueOf(((oidb_0xea4.AppInfo)localObject2).appid.get()) });
          }
          k += 1;
        }
        localObject1 = localView.findViewById(2131380213);
        break label508;
        localObject1 = localView.findViewById(2131380214);
        break label508;
        localObject1 = localView.findViewById(2131380215);
        break label508;
        localObject1 = localView.findViewById(2131380216);
        break label508;
        localObject1 = localView.findViewById(2131380217);
        break label508;
        localObject1 = localView.findViewById(2131380218);
        break label508;
        localObject1 = localView.findViewById(2131380219);
        break label508;
        localObject1 = localView.findViewById(2131380220);
        break label508;
        localObject1 = localView.findViewById(2131380221);
        break label508;
        ((View)localObject1).setVisibility(4);
        break;
        label1174:
        if (k > 0)
        {
          localTextView.setVisibility(0);
          localTextView.setText(String.valueOf(k));
          localTextView.setBackgroundResource(2130851404);
          ((StringBuffer)localObject3).append("，").append(k).append("未读");
          break label741;
        }
        localTextView.setVisibility(8);
        break label741;
        label1236:
        localTextView.setVisibility(8);
        break label819;
        label1246:
        localObject2 = "";
        break label871;
        label1254:
        if (localAppInfo.icon_simple_day.has())
        {
          localObject2 = localAppInfo.icon_simple_day.get();
          break label871;
        }
        localObject2 = "";
        break label871;
        label1286:
        str = "";
        break label892;
        label1294:
        localObject2 = str;
        break label905;
        try
        {
          label1301:
          int m = localaprp.ae(l);
          k = m;
          if (m == 0) {
            k = 2130844521;
          }
          localImageView.setImageResource(k);
        }
        catch (Exception localException)
        {
          localImageView.setImageDrawable(getResources().getDrawable(2130844521));
        }
      }
      ((View)localObject1).setContentDescription(((StringBuffer)localObject3).toString());
    }
    label1367:
    ((View)localObject1).setVisibility(8);
  }
  
  public void atg()
  {
    try
    {
      if (this.g == null)
      {
        this.g = new arhz(getActivity(), getTitleBarHeight());
        this.g.setMessage(2131696693);
        this.g.setBackAndSearchFilter(false);
      }
      this.g.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  public void ath()
  {
    try
    {
      if ((this.g != null) && (this.g.isShowing())) {
        this.g.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  protected void b(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null)
    {
      this.qB = paramTroopInfo.parseTroopMemeberList();
      bLd();
    }
  }
  
  public void bFG()
  {
    if (this.jdField_x_of_type_Aqju != null)
    {
      if (!this.jdField_x_of_type_Aqju.isShowing()) {
        this.jdField_x_of_type_Aqju.show();
      }
      return;
    }
    this.jdField_x_of_type_Aqju = aqha.a(this, 230);
    this.jdField_x_of_type_Aqju.setMessage(2131697425);
    this.jdField_x_of_type_Aqju.setTitle(2131693317);
    uqp localuqp = new uqp(this);
    this.jdField_x_of_type_Aqju.setNegativeButton(2131721058, localuqp);
    this.jdField_x_of_type_Aqju.setPositiveButton(2131697395, localuqp);
    this.jdField_x_of_type_Aqju.show();
  }
  
  protected void bKU()
  {
    if (!aqiw.isNetworkAvailable(getApplicationContext())) {}
    acms localacms;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initNetworkRequests");
      }
      localacms = (acms)this.app.getBusinessHandler(20);
      ArrayList localArrayList;
      if (localacms != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localacms.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, localArrayList);
      }
      if (localacms != null)
      {
        bLp();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
          localacms.dL(localArrayList);
          localacms.EZ(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
      this.jdField_b_of_type_Jrp = new jrp(this.app);
      bKZ();
    } while (localacms == null);
    localacms.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false, this.bFM, 1);
  }
  
  public void bLF()
  {
    if ((this.app == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager.aA(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "updateNick use cache");
      }
      a(localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin()));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "updateNick async");
    }
    ThreadManager.post(new ChatSettingForTroop.50(this, localTroopManager), 5, null, false);
  }
  
  protected void bLb()
  {
    Object localObject = this.p[23];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    localObject = (TextView)((View)localObject).findViewById(2131380327);
    ((TextView)localObject).setTag(Integer.valueOf(39));
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i = 0;
    }
    if (i > 0)
    {
      String str = String.format(getResources().getString(2131694962), new Object[] { Integer.valueOf(i) });
      ((TextView)localObject).setText(str);
      ((TextView)localObject).setContentDescription(str);
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (this.aUo) {
        ((TextView)localObject).setVisibility(8);
      }
      ((TextView)localObject).setOnClickListener(this);
      return;
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public void bLc()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    View localView = this.p[14];
    String str;
    if (localView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
        break label249;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      localView.setOnClickListener(this);
      if (AppSetting.enableTalkBack)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(acfp.m(2131703751)).append(str);
        if (!bool) {
          break label259;
        }
        localObject = acfp.m(2131703740);
        label85:
        localView.setContentDescription((String)localObject);
      }
      a(localView, new aofe(str, 32).k(), null, null);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateTroopNameEntry %s", new Object[] { str }));
      }
    }
    Object localObject = this.p[36];
    if (localObject != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      if (!TextUtils.isEmpty(str)) {
        break label266;
      }
      str = acfp.m(2131703768);
    }
    label259:
    label266:
    for (;;)
    {
      ((TextView)localObject).setText(str);
      if (AppSetting.enableTalkBack) {
        ((View)localObject).setContentDescription(acfp.m(2131703735) + str);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateHostTroopNameEntry %s", new Object[] { str }));
      }
      return;
      label249:
      str = acfp.m(2131703778);
      break;
      localObject = "";
      break label85;
    }
  }
  
  protected void bLd()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.bFF, this.bFH, this.bFG, this.bFI);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$a == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$a = new a();
        this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$a);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$a.notifyDataSetChanged();
  }
  
  protected void bLe()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.canInviteMember()) {
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4);
    long l = localSharedPreferences.getLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "TroopMemberList lastUpdateTime:" + l);
    }
    if (l == 0L)
    {
      acms localacms = (acms)this.app.getBusinessHandler(20);
      if (localacms != null) {
        localacms.b(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, 6);
      }
      localSharedPreferences.edit().putLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, System.currentTimeMillis()).commit();
    }
    ThreadManager.post(this.dJ, 5, null, false);
  }
  
  protected void bLf()
  {
    int i;
    if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop()))
    {
      i = 1;
      if (i == 0) {
        break label199;
      }
      apqz.p(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "troopProfile");
      anot.a(this.app, "P_CliOper", "Grp_edu", "", "Grp_data", "mbercard_Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    for (;;)
    {
      anot.a(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_modifydata", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      aqfr.b("Grp_set_new", "grpData_admin", "clk_modifydata", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_2", "", 1, 0, 0, "", "", "");
      return;
      i = 0;
      break;
      label199:
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      Intent localIntent = new Intent(this, EditInfoActivity.class);
      localIntent.putExtra("edit_type", 0);
      localIntent.putExtra("title", getString(2131699789));
      localIntent.putExtra("default_text", str);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uin", this.app.getAccount());
      localIntent.putExtra("max_num", 60);
      localIntent.putExtra("from", 0);
      startActivityForResult(localIntent, 2);
    }
  }
  
  protected void bLg()
  {
    if (System.currentTimeMillis() - this.FK < 1500L) {
      return;
    }
    this.FK = System.currentTimeMillis();
    Object localObject = TroopMemberListActivity.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
    startActivityForResult((Intent)localObject, 9);
    localObject = "2";
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        localObject = "0";
      }
      for (;;)
      {
        anot.a(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", (String)localObject, "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject = "1";
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void bLl()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 11)) {
      anot.a(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0))
    {
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", String.format("https://nearby.qq.com/hot_chat/qun_class.html?_wv=1031&latitude=%1$s&longitude=%2$s", new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat / 1000000.0D), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon / 1000000.0D) }));
      startActivity(localIntent);
      report("Grp", "Clk_grp_map", "0");
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      Intent localIntent;
      return;
    }
    anot.a(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    TroopLocationModifyActivity.g(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 12);
  }
  
  public void bLn()
  {
    View localView = this.p[11];
    if (localView != null)
    {
      if (((localView instanceof FormSimpleItem)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)))
      {
        localView.setVisibility(0);
        a(11, 3, (FormSimpleItem)localView, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, null, true);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  public void bLo()
  {
    View localView = this.p[22];
    if (localView != null)
    {
      if (((localView instanceof FormSimpleItem)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo)))
      {
        localView.setVisibility(0);
        a(22, 1, (FormSimpleItem)localView, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, null, true);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  protected void bLp()
  {
    acms localacms = (acms)this.app.getBusinessHandler(20);
    if (localacms == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) {
          this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break label110;
        }
        localacms.Z(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1000L);
        if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break label127;
        }
        localacms.ET(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.chatopttroop", 2, localException.toString());
      return;
      label110:
      localException.Z(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1000L);
    }
    label127:
    localException.ET(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  protected void bLq()
  {
    this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo, getResources(), this.app.getCurrentAccountUin());
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = false;
        apuh.a(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
      }
    }
    bLc();
    bLr();
    bLt();
  }
  
  protected void bLt()
  {
    View localView = this.p[19];
    if ((localView != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mCanSearchByKeywords) || (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.mCanSearchByTroopUin)) {
        localView.setVisibility(0);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  public void bLv()
  {
    Context localContext = getApplicationContext();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      String str = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      apyh.a(localContext).a(str, null);
    }
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    new arie(this).V(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected boolean checkParams()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "checkParams");
    }
    if (this.app == null) {
      return false;
    }
    boolean bool2 = bool3;
    try
    {
      this.isDestory = false;
      bool2 = bool3;
      this.aRf = false;
      bool2 = bool3;
      Bundle localBundle = getIntent().getExtras();
      bool2 = bool3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = apuh.a(localBundle, this);
      bool2 = bool3;
      TroopInfo localTroopInfo = apuh.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this);
      if (localTroopInfo != null)
      {
        bool2 = bool3;
        this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
      }
      bool2 = bool3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = localBundle.getString("troop_uin");
      bool2 = bool3;
      if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) > 0L) {
        bool1 = true;
      }
      bool2 = bool1;
      this.bFK = localBundle.getInt("D2GType");
      bool2 = bool1;
      this.bFP = localBundle.getInt("filter_id", -1);
      bool2 = bool1;
      apuh.dWD = localBundle.getInt("exposureSource", 99);
      bool2 = bool1;
      this.aUv = localBundle.getBoolean("fromThirdAppByOpenSDK");
      bool2 = bool1;
      this.authKey = localBundle.getString("authKey");
      bool2 = bool1;
      this.authSig = localBundle.getString("authSig");
      return bool1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, localException.toString());
      }
      jpp.a(this.app, 69);
    }
    return bool2;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      String str = aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      if (paramInt2 == -1) {}
      for (paramIntent = "0";; paramIntent = "1")
      {
        aqfr.b("Grp_share", "grpData_admin", "share_qzone", 0, 0, new String[] { localObject, str, paramIntent });
        return;
      }
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("select_member_add_request_ok", false)))
      {
        this.aUy = true;
        return;
        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
        {
          paramIntent = new Intent();
          paramIntent.putExtra("isNeedFinish", true);
          setResult(-1, paramIntent);
          finish();
          return;
        }
        if (this.p[6] != null) {
          ThreadManager.post(new ChatSettingForTroop.44(this), 8, null, true);
        }
        bLd();
        return;
        x(paramInt2, paramIntent);
        return;
        if (paramInt2 == -1)
        {
          setResult(-1);
          this.bO = true;
          return;
          y(paramInt2, paramIntent);
          return;
          z(paramInt2, paramIntent);
          return;
          ((acms)this.app.getBusinessHandler(20)).EX(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          return;
          A(paramInt2, paramIntent);
          B(paramInt2, paramIntent);
          return;
          if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramInt2 == -1))
          {
            paramIntent = paramIntent.getExtras();
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = paramIntent.getString("location");
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = paramIntent.getInt("lat", 0);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = paramIntent.getInt("lon", 0);
            bLn();
            return;
            if (paramInt2 == -1)
            {
              if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
              {
                paramIntent = new Intent();
                paramIntent.putExtra("isNeedFinish", true);
                setResult(-1, paramIntent);
              }
              finish();
              return;
              if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("has_operation", false)))
              {
                this.C = paramIntent;
                return;
                if (paramInt2 == -1)
                {
                  paramIntent = wja.a(new Intent(this, SplashActivity.class), null);
                  paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                  paramIntent.putExtra("uinname", this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.getTroopName());
                  paramIntent.putExtra("uintype", 1);
                  startActivity(paramIntent);
                  setResult(-1);
                  finish();
                  return;
                  B(paramInt2, paramIntent);
                  return;
                  paramIntent = (apdr)this.app.getManager(231);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.chatopttroop", 2, "doOnActivityResult REQUEST_FOR_ENTER_EFFECT_SETTING  effectManager.isAllTroopShowEnterance() = " + paramIntent.aAS());
                  }
                  if (paramIntent.aAS())
                  {
                    wv(true);
                    return;
                    boolean bool1 = paramIntent.getBooleanExtra("disabled", true);
                    localObject = (FormSimpleItem)this.p[41];
                    if (localObject != null)
                    {
                      if (bool1) {}
                      for (paramIntent = getResources().getString(2131698433);; paramIntent = getResources().getString(2131698434))
                      {
                        ((FormSimpleItem)localObject).setRightText(paramIntent);
                        return;
                      }
                      if ((paramInt2 == -1) && (paramIntent != null))
                      {
                        if (!aqiw.isNetworkAvailable(this))
                        {
                          QQToast.a(this, 1, 2131696273, 0).show(getTitleBarHeight());
                          return;
                        }
                        paramIntent = paramIntent.getStringExtra("result");
                        if ((!TextUtils.isEmpty(paramIntent)) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (!paramIntent.equals(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopname)))
                        {
                          localObject = (accc)this.app.getBusinessHandler(22);
                          bool1 = bool2;
                          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
                          {
                            bool1 = bool2;
                            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1) {
                              bool1 = true;
                            }
                          }
                          ((accc)localObject).B(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramIntent, bool1);
                          if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.hasSetTroopHead())) {
                            this.aUp = true;
                          }
                          this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.oldTroopName = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopname;
                          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramIntent;
                          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
                          bLc();
                          return;
                          str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                          long l = 0L;
                          if ((paramInt2 == -1) && (paramIntent != null))
                          {
                            bool1 = paramIntent.getBooleanExtra("updateFromWeb", false);
                            localObject = paramIntent.getStringExtra("lastAnnouncement");
                            l = paramIntent.getLongExtra("groupCode", 0L);
                            if ((bool1) && (TextUtils.equals(str, String.valueOf(l))))
                            {
                              paramIntent = this.mUIHandler.obtainMessage();
                              paramIntent.what = 20;
                              paramIntent.obj = localObject;
                              this.mUIHandler.sendMessage(paramIntent);
                              paramIntent = (TroopManager)this.app.getManager(52);
                              if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo == null) {
                                this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = paramIntent.b(str);
                              }
                              if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
                              {
                                this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.updateLastMemoFromWeb((String)localObject);
                                paramIntent.a(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo);
                              }
                            }
                          }
                          for (paramIntent = (Intent)localObject; QLog.isColorLevel(); paramIntent = (Intent)localObject)
                          {
                            QLog.i("Q.chatopttroop", 2, String.format("doOnActivityResult get last memo [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(bool1), str, Long.valueOf(l), paramIntent }));
                            return;
                            bool1 = false;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    bLx();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.aMk = getIntent().getStringExtra("appid");
    this.aMl = getIntent().getStringExtra("openid");
    this.apc = getIntent().getStringExtra("share_uin");
    this.aMm = getIntent().getStringExtra("is_from_game");
    if (("true".equals(this.aMm)) && (!TextUtils.isEmpty(this.aMk)))
    {
      apuh.a(this.app, getApplicationContext(), this.aMk, this, 0, null);
      this.aMn = getIntent().getStringExtra("guild_id");
      this.aMo = getIntent().getStringExtra("zone_id");
      this.aMp = getIntent().getStringExtra("role_id");
      this.aMq = getIntent().getStringExtra("gc");
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "joinGroup appid = " + this.aMk + " openid = " + this.aMl + " guild id = " + this.aMn + "zone_id = " + this.aMo + " role id = " + this.aMp + "  group code= " + this.aMq);
      }
      paramBundle = String.valueOf(this.aMk);
      if ((TextUtils.isEmpty(this.apc)) || (this.apc.equals(this.app.getAccount()))) {
        break label394;
      }
      bFG();
      label313:
      if (!QLog.isColorLevel()) {
        break label1071;
      }
    }
    label394:
    label1071:
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      if (!checkParams())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        finish();
        return false;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.chatopttroop", 2, " joinGroup is from game = false");
        break;
        if (TextUtils.isEmpty(this.aMl)) {
          break label313;
        }
        OpenID localOpenID = this.app.a().a(paramBundle);
        if (localOpenID == null)
        {
          atg();
          this.bJ = new Handler();
          this.bJ.postDelayed(new ChatSettingForTroop.2(this), 3000L);
          this.app.addObserver(this.jdField_a_of_type_Jqk);
          this.app.a().Eo(paramBundle);
          break label313;
        }
        if (this.aMl.equals(localOpenID.openID)) {
          break label313;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop", 2, "-->preForward--openid doesn't equal current local openid");
        }
        bFG();
        break label313;
      }
      this.mDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(this.mDisplayMetrics);
      for (;;)
      {
        try
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
            apuh.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.oU);
          }
          this.jdField_a_of_type_Aqlz = ((aqlz)this.app.getManager(31));
          initUI();
          b(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo);
          if (!Pn()) {
            bKV();
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "onCreate(), time = " + (System.currentTimeMillis() - l));
          }
          ThreadManager.getSubThreadHandler().post(new ChatSettingForTroop.3(this));
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
          {
            paramBundle = "0";
            report("Grp_Admin_data", "Clk_data", paramBundle);
            jpp.a(this.app, 65);
            paramBundle = new IntentFilter();
            paramBundle.addAction("start_recomend_page");
            paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            paramBundle.addAction("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER");
            registerReceiver(this.mReceiver, paramBundle);
            addObserver(this.jdField_c_of_type_Acnd);
            addObserver(this.e);
            apuh.R(this.app);
            this.jdField_b_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
            paramBundle = (TroopManager)this.app.getManager(52);
            if (paramBundle != null)
            {
              paramBundle = paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              if ((paramBundle != null) && (paramBundle.isGameBind())) {
                aqfr.b("Grp_game", "Grp_data", "data_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
              }
            }
            this.app.addObserver(this.jdField_b_of_type_Aqrd);
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_1", "", 1, 0, 0, "", "", "");
            anot.a(this.app, "dc00898", "", "", "0X800A523", "0X800A523", 0, 0, "", "", "", "");
            anot.a(this.app, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_exp", 0, 0, "", "", "", "");
            return true;
          }
        }
        catch (OutOfMemoryError paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.chatopttroop", 2, "initUI got OOM, e:" + paramBundle.getMessage());
          }
          System.gc();
          finish();
          return false;
        }
        catch (InflateException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.chatopttroop", 2, "init UI got InflateException, e:" + paramBundle.getMessage());
          }
          System.gc();
          finish();
          return false;
        }
        paramBundle = "1";
      }
    }
  }
  
  /* Error */
  public void doOnDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 3051	com/tencent/mobileqq/activity/ChatSettingForTroop:mIsDestroyed	Z
    //   5: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +385 -> 393
    //   11: invokestatic 1320	java/lang/System:currentTimeMillis	()J
    //   14: lstore_1
    //   15: ldc 2
    //   17: monitorenter
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 2694	com/tencent/mobileqq/activity/ChatSettingForTroop:isDestory	Z
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: getfield 818	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Aqdf	Laqdf;
    //   30: ifnull +10 -> 40
    //   33: aload_0
    //   34: getfield 818	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Aqdf	Laqdf;
    //   37: invokevirtual 3054	aqdf:destory	()V
    //   40: aload_0
    //   41: getfield 681	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Apvf	Lapvf;
    //   44: ifnull +10 -> 54
    //   47: aload_0
    //   48: getfield 681	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Apvf	Lapvf;
    //   51: invokevirtual 3059	apvf:destroy	()V
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 295	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Jqk	Ljqk;
    //   59: invokevirtual 3062	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lacci;)V
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 278	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Acfd	Lacfd;
    //   67: invokevirtual 3062	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lacci;)V
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 283	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Accd	Laccd;
    //   75: invokevirtual 3062	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lacci;)V
    //   78: aload_0
    //   79: aload_0
    //   80: getfield 268	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Acnd	Lacnd;
    //   83: invokevirtual 3062	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lacci;)V
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 263	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Acnd	Lacnd;
    //   91: invokevirtual 3062	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lacci;)V
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 220	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Acnd	Lacnd;
    //   99: invokevirtual 3062	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lacci;)V
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 273	com/tencent/mobileqq/activity/ChatSettingForTroop:e	Lacnd;
    //   107: invokevirtual 3062	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lacci;)V
    //   110: aload_0
    //   111: getfield 372	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: aload_0
    //   115: getfield 305	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Aqrd	Laqrd;
    //   118: invokevirtual 3063	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lacci;)V
    //   121: aload_0
    //   122: getfield 258	com/tencent/mobileqq/activity/ChatSettingForTroop:mUIHandler	Landroid/os/Handler;
    //   125: ifnull +11 -> 136
    //   128: aload_0
    //   129: getfield 258	com/tencent/mobileqq/activity/ChatSettingForTroop:mUIHandler	Landroid/os/Handler;
    //   132: aconst_null
    //   133: invokevirtual 3066	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   136: aload_0
    //   137: getfield 3068	com/tencent/mobileqq/activity/ChatSettingForTroop:dx	Landroid/graphics/drawable/Drawable;
    //   140: ifnull +30 -> 170
    //   143: aload_0
    //   144: getfield 3068	com/tencent/mobileqq/activity/ChatSettingForTroop:dx	Landroid/graphics/drawable/Drawable;
    //   147: checkcast 3070	android/graphics/drawable/Animatable
    //   150: invokeinterface 3073 1 0
    //   155: ifeq +15 -> 170
    //   158: aload_0
    //   159: getfield 3068	com/tencent/mobileqq/activity/ChatSettingForTroop:dx	Landroid/graphics/drawable/Drawable;
    //   162: checkcast 3070	android/graphics/drawable/Animatable
    //   165: invokeinterface 3076 1 0
    //   170: aload_0
    //   171: invokestatic 2679	apyh:a	(Landroid/content/Context;)Lapyh;
    //   174: invokevirtual 3077	apyh:clear	()V
    //   177: aload_0
    //   178: getfield 2401	com/tencent/mobileqq/activity/ChatSettingForTroop:g	Larhz;
    //   181: ifnull +10 -> 191
    //   184: aload_0
    //   185: getfield 2401	com/tencent/mobileqq/activity/ChatSettingForTroop:g	Larhz;
    //   188: invokevirtual 2415	arhz:dismiss	()V
    //   191: aload_0
    //   192: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Jrp	Ljrp;
    //   195: ifnull +10 -> 205
    //   198: aload_0
    //   199: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Jrp	Ljrp;
    //   202: invokevirtual 3078	jrp:destroy	()V
    //   205: aload_0
    //   206: aload_0
    //   207: getfield 229	com/tencent/mobileqq/activity/ChatSettingForTroop:mReceiver	Landroid/content/BroadcastReceiver;
    //   210: invokevirtual 3082	com/tencent/mobileqq/activity/ChatSettingForTroop:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   213: aload_0
    //   214: getfield 2925	com/tencent/mobileqq/activity/ChatSettingForTroop:bJ	Landroid/os/Handler;
    //   217: ifnull +11 -> 228
    //   220: aload_0
    //   221: getfield 2925	com/tencent/mobileqq/activity/ChatSettingForTroop:bJ	Landroid/os/Handler;
    //   224: aconst_null
    //   225: invokevirtual 3066	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   228: aload_0
    //   229: aconst_null
    //   230: putfield 2422	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_x_of_type_Aqju	Laqju;
    //   233: aload_0
    //   234: getfield 3084	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   237: ifnull +10 -> 247
    //   240: aload_0
    //   241: getfield 3084	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   244: invokevirtual 3089	com/tencent/mobileqq/widget/QQBlurView:onDestroy	()V
    //   247: aload_0
    //   248: getfield 3091	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Apzg	Lapzg;
    //   251: ifnull +10 -> 261
    //   254: aload_0
    //   255: getfield 3091	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Apzg	Lapzg;
    //   258: invokevirtual 3094	apzg:onDestroy	()V
    //   261: aload_0
    //   262: invokespecial 1251	com/tencent/mobileqq/activity/ChatSettingForTroop:bLi	()V
    //   265: aload_0
    //   266: invokespecial 3096	com/tencent/mobileqq/app/BaseActivity:doOnDestroy	()V
    //   269: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +34 -> 306
    //   275: ldc_w 604
    //   278: iconst_2
    //   279: new 984	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 985	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 3098
    //   289: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokestatic 1320	java/lang/System:currentTimeMillis	()J
    //   295: lload_1
    //   296: lsub
    //   297: invokevirtual 1176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: invokevirtual 997	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 615	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: return
    //   307: astore_3
    //   308: ldc 2
    //   310: monitorexit
    //   311: aload_3
    //   312: athrow
    //   313: astore_3
    //   314: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq -104 -> 213
    //   320: ldc_w 604
    //   323: iconst_2
    //   324: new 984	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 985	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 3100
    //   334: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_3
    //   338: invokevirtual 3101	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   341: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 997	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 1548	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: goto -137 -> 213
    //   353: astore_3
    //   354: invokestatic 511	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq -144 -> 213
    //   360: ldc_w 604
    //   363: iconst_2
    //   364: new 984	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 985	java/lang/StringBuilder:<init>	()V
    //   371: ldc_w 3100
    //   374: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload_3
    //   378: invokevirtual 3102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   381: invokevirtual 991	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 997	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 1548	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: goto -177 -> 213
    //   393: lconst_0
    //   394: lstore_1
    //   395: goto -380 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	ChatSettingForTroop
    //   14	381	1	l	long
    //   307	5	3	localObject	Object
    //   313	25	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   353	25	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   18	26	307	finally
    //   308	311	307	finally
    //   205	213	313	java/lang/IllegalArgumentException
    //   205	213	353	java/lang/Exception
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    URLDrawable.resume();
    String str1;
    String str2;
    Object localObject;
    if (this.mIsInit)
    {
      this.mIsInit = false;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      str2 = aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        localObject = "1";
      }
    }
    for (;;)
    {
      aqfr.b("Grp_set_new", "grpData_admin", "exp", 0, 0, new String[] { str1, str2, localObject });
      label83:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) && (aprg.bN(this.app))) {}
      try
      {
        l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        ((acms)this.app.getBusinessHandler(20)).hX(l);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
        bLw();
        ZM();
        anot.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F6", 0, 1, 0, "", "", "", "");
        if (this.p[40] != null) {
          bKR();
        }
        bKQ();
        bKq();
        return;
        localObject = "0";
        continue;
        localObject = (aprp)this.app.getManager(109);
        if ((localObject != null) && (((aprp)localObject).qJ(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
        {
          localObject = (acms)this.app.getBusinessHandler(20);
          if (localObject != null) {
            ((acms)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, this.bFM, 1);
          }
        }
        if (!this.aUx) {
          break label83;
        }
        bLp();
        this.aUx = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.chatopttroop", 2, "onResume  parseLong err", localException);
          long l = 0L;
        }
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (!this.aUs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStart add observer");
      }
      addObserver(this.jdField_c_of_type_Acfd);
      addObserver(this.jdField_b_of_type_Accd);
      addObserver(this.jdField_d_of_type_Acnd);
      addObserver(this.jdField_a_of_type_Acnd);
      addObserver(this.e);
      this.aUs = true;
    }
    if (this.aUt) {
      this.aUt = false;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.aUs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStop remove observer");
      }
      removeObserver(this.jdField_c_of_type_Acfd);
      removeObserver(this.jdField_b_of_type_Accd);
      removeObserver(this.jdField_a_of_type_Acnd);
      this.aUs = false;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.aRf)) {
      this.mUIHandler.sendEmptyMessage(1);
    }
  }
  
  protected void eA(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131380355;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131380356;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131380357;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131380358;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131380359;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131380360;
    tmp38_32;
    this.qz = new ArrayList(6);
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      this.qz.add((ImageView)paramView.findViewById(k));
      i += 1;
    }
  }
  
  protected void eB(View paramView)
  {
    if (paramView == null) {}
    TextView localTextView;
    do
    {
      return;
      localTextView = (TextView)paramView.findViewById(2131379769);
      paramView = paramView.findViewById(2131377275);
    } while ((localTextView == null) || (paramView == null) || (TextUtils.isEmpty(localTextView.getText())));
    int i = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).leftMargin = (wja.dp2px(30.0F, getResources()) + i);
  }
  
  public void fH(long paramLong)
  {
    if (this.qz == null) {
      return;
    }
    ThreadManager.post(new ChatSettingForTroop.21(this, paramLong), 8, null, true);
  }
  
  public void fH(List<oidb_0x899.memberlist> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.qA = paramList;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.qA.size())
    {
      localArrayList.add(Long.valueOf(((oidb_0x899.memberlist)paramList.get(i)).uint64_member_uin.get()));
      i += 1;
    }
    this.qB = localArrayList;
    this.mUIHandler.post(new ChatSettingForTroop.20(this));
  }
  
  public void fI(List<oidb_0xea4.TabInfo> paramList)
  {
    ViewGroup localViewGroup = (ViewGroup)this.p[28];
    localViewGroup.removeAllViews();
    int i1 = 0;
    int j = 0;
    int i = 0;
    oidb_0xea4.TabInfo localTabInfo;
    String str1;
    String str2;
    String str3;
    int i2;
    View localView;
    Object localObject;
    int k;
    if (i1 < paramList.size())
    {
      localTabInfo = (oidb_0xea4.TabInfo)paramList.get(i1);
      str1 = localTabInfo.name.get();
      str2 = localTabInfo.desc.get();
      str3 = localTabInfo.url.get();
      i2 = localTabInfo.num.get();
      if ((i == 0) && (localTabInfo.type.get() == 1))
      {
        localView = this.p[29];
        localObject = localView;
        if (localView == null)
        {
          localObject = new GameRankFormItem(this);
          this.p[29] = localObject;
        }
        ((GameRankFormItem)localObject).mRank = i2;
        i = j;
        j = 1;
        k = 29;
      }
    }
    for (;;)
    {
      label159:
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "game info tag=" + k + ", name=" + str1 + ", desc=" + str2 + ", num=" + i2);
      }
      int m = 2;
      if ((i1 == 0) && (paramList.size() == 1))
      {
        m = 0;
        label247:
        if (!(localObject instanceof TroopAppFormItem)) {
          break label536;
        }
        ((View)localObject).setTag(Integer.valueOf(k));
        ((TroopAppFormItem)localObject).a(localTabInfo, m);
        ((View)localObject).setOnClickListener(this);
      }
      for (;;)
      {
        ((View)localObject).setTag(2131379238, str3);
        ((View)localObject).setTag(2131379207, localTabInfo);
        localViewGroup.addView((View)localObject);
        k = i;
        i = j;
        j = k;
        for (;;)
        {
          i1 += 1;
          break;
          if ((j == 0) && (localTabInfo.type.get() == 2))
          {
            localView = this.p[30];
            localObject = localView;
            if (localView == null)
            {
              localObject = new FormSimpleItem(this);
              this.p[30] = localObject;
            }
            k = 30;
            m = 1;
            j = i;
            i = m;
            break label159;
          }
          localObject = new TroopAppFormItem(this);
          if (localTabInfo.appid.get() == 1106837471L)
          {
            this.aMi = apuh.a((View)localObject, localTabInfo);
            aqfr.b("Grp_set", "Grp_aio_subscription", "subscription_exp", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) });
            k = 1007;
            m = i;
            i = j;
            j = m;
            break label159;
          }
          if (localTabInfo.appid.get() != 1106912788L) {
            break label576;
          }
        }
        if ((i1 == 0) && (paramList.size() > 1))
        {
          m = 1;
          break label247;
        }
        if (i1 != paramList.size() - 1) {
          break label247;
        }
        m = 3;
        break label247;
        label536:
        a(k, m, (FormSimpleItem)localObject, str1, str2, true);
      }
      if (j != 0) {
        ThreadManager.post(new ChatSettingForTroop.22(this), 5, null, true);
      }
      return;
      label576:
      k = 1007;
      m = i;
      i = j;
      j = m;
    }
  }
  
  public void init()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "init(), isInitialized = " + this.aRf);
    }
    if (this.aRf) {
      return;
    }
    this.aRf = true;
    if (!this.isDestory) {
      this.mUIHandler.sendEmptyMessage(3);
    }
    if (this.mTitleTv != null)
    {
      this.dx = getResources().getDrawable(2130839651);
      this.mTitleTv.setCompoundDrawablesWithIntrinsicBounds(this.dx, null, null, null);
      this.mTitleTv.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298469));
      ((Animatable)this.dx).start();
    }
    if (!aqiw.isNetworkAvailable(getApplicationContext())) {
      QQToast.a(getApplicationContext(), 1, getString(2131696272), 1).show(getTitleBarHeight());
    }
    ThreadManager.post(this.bz, 8, null, false);
    this.dg = new upp(this);
    this.gt.setOnClickListener(this.dg);
    this.xt.setOnClickListener(this.dg);
    this.pJ.setOnClickListener(this.dg);
  }
  
  @SuppressLint({"NewApi"})
  protected void initUI()
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      Object localObject2;
      try
      {
        View localView = View.inflate(this, 2131563250, null);
        this.n = ((XListView)localView.findViewById(2131365101));
        this.f = ((ImmersiveTitleBar2)localView.findViewById(2131379866));
        this.n.setVerticalScrollBarEnabled(false);
        this.n.setDivider(null);
        this.p = new View[42];
        this.dl = new LinearLayout(this);
        Object localObject1 = new AbsListView.LayoutParams(-1, -2);
        this.dl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.dl.setOrientation(1);
        localObject1 = new auvv(this.dl);
        this.n.setAdapter((ListAdapter)localObject1);
        this.aUo = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "mIsQidianPrivateTroop : " + this.aUo + ", troopUin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        super.setContentView(localView);
        this.mRootView = localView;
        this.mRootView.setBackgroundResource(2130838900);
        this.mN = localView.findViewById(2131379845);
        this.gt = ((RelativeLayout)localView.findViewById(2131379791));
        this.gt.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131691440));
        this.gt.setFocusable(true);
        this.mTitleTv = ((TextView)localView.findViewById(2131369627));
        this.mTitleTv.setText(getResources().getString(2131691440));
        this.xt = ((TextView)localView.findViewById(2131369579));
        this.xt.setContentDescription(getString(2131696673) + getString(2131691029));
        this.pJ = ((ImageView)localView.findViewById(2131369594));
        this.pJ.setContentDescription(getString(2131692129));
        this.jdField_d_of_type_Aqdf = new aqdf(this, this.app);
        this.jdField_d_of_type_Aqdf.a(this);
        localObject1 = View.inflate(this, 2131560836, null);
        this.p[12] = localObject1;
        bLu();
        this.mN.measure(0, 0);
        localObject1 = View.inflate(this, 2131561775, null);
        ((View)localObject1).setBackgroundResource(2130851773);
        this.dl.addView((View)localObject1);
        ((View)localObject1).getLayoutParams().height = this.mN.getMeasuredHeight();
        localObject2 = View.inflate(this, 2131561772, null);
        this.p[23] = localObject2;
        ((View)localObject2).setTag(Integer.valueOf(23));
        ((View)localObject2).setOnClickListener(this);
        ((View)localObject2).setContentDescription(acfp.m(2131703743));
        this.dl.addView((View)localObject2);
        localView.findViewById(2131380303).setVisibility(8);
        localObject1 = ((View)localObject2).findViewById(2131368375);
        ((View)localObject1).setTag(Integer.valueOf(35));
        ((View)localObject1).setContentDescription(getResources().getString(2131701823));
        if (anlm.ayn()) {
          ((View)localObject1).setBackground(null);
        }
        if ((localObject1 instanceof ThemeImageView)) {
          ((ThemeImageView)localObject1).setSupportMaskView(false);
        }
        this.p[35] = localObject1;
        bKT();
        localObject1 = ((View)localObject2).findViewById(2131380362);
        ((View)localObject1).setTag(Integer.valueOf(36));
        this.p[36] = localObject1;
        bLc();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
          localObject2 = ((View)localObject2).findViewById(2131378902);
          ((TextView)localObject2).setText(new aofk((CharSequence)localObject1, 11, 16));
          this.p[37] = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
            ((View)localObject2).setVisibility(8);
          }
          bLb();
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          localObject1 = View.inflate(this, 2131561768, null);
          this.p[0] = localObject1;
          ((View)localObject1).setTag(Integer.valueOf(0));
          ((View)localObject1).setBackgroundResource(2130839682);
          ((View)localObject1).setOnClickListener(this);
          this.dl.addView((View)localObject1);
          this.tR = ((TextView)((View)localObject1).findViewById(2131371230));
          this.tR.setText(acfp.m(2131703753) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + acfp.m(2131703761));
          if (AppSetting.enableTalkBack) {
            this.tR.setPadding(0, wja.dp2px(12.0F, this.tR.getResources()), wja.dp2px(3.0F, this.tR.getResources()), wja.dp2px(12.0F, this.tR.getResources()));
          }
          eA((View)localObject1);
          this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)((View)localObject1).findViewById(2131371228));
          this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
          bKS();
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          localObject1 = View.inflate(this, 2131560060, null);
          this.p[13] = localObject1;
          ((View)localObject1).getBackground().setAlpha(255);
          this.dl.addView((View)localObject1);
          ((View)localObject1).setVisibility(8);
          this.rW = View.inflate(this, 2131561775, null);
          this.dl.addView(this.rW);
          this.rW.getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          this.rW.setVisibility(8);
          localObject1 = View.inflate(this, 2131561765, null);
          this.p[14] = localObject1;
          this.dl.addView((View)localObject1);
          ((View)localObject1).setTag(Integer.valueOf(14));
          a(14, 2, (View)localObject1, getString(2131692887), "", true);
          bLc();
          eB((View)localObject1);
          localObject1 = View.inflate(this, 2131561765, null);
          this.p[25] = localObject1;
          this.dl.addView((View)localObject1);
          ((View)localObject1).setTag(Integer.valueOf(25));
          a(25, 2, (View)localObject1, getString(2131701827), "", true);
          if ((this.aUo) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
            break label4210;
          }
          bool = true;
          wx(bool);
          eB((View)localObject1);
          localObject1 = View.inflate(this, 2131561765, null);
          this.p[4] = localObject1;
          this.dl.addView((View)localObject1);
          l((View)localObject1, null);
          a(4, 3, (View)localObject1, getString(2131701851), "", true);
          ((View)localObject1).setTag(Integer.valueOf(4));
          ((View)localObject1).setOnClickListener(this);
          localObject1 = new View(this);
          ((View)localObject1).setBackgroundResource(2130851089);
          localObject2 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject2).height = 1;
          ((RelativeLayout.LayoutParams)localObject2).setMargins(wja.dp2px(16.0F, getResources()), 0, 0, 0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.dl.addView((View)localObject1);
          localObject2 = View.inflate(this, 2131561765, null);
          this.p[5] = localObject2;
          this.dl.addView((View)localObject2);
          l((View)localObject2, null);
          ((View)localObject2).setTag(Integer.valueOf(5));
          ((View)localObject2).setOnClickListener(this);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label4216;
          }
          localObject1 = acfp.m(2131703731);
          a(5, 3, (View)localObject2, getString(2131721358), (CharSequence)localObject1, true);
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (!this.aUn)) {
            break label4227;
          }
          i = 0;
          ((View)localObject2).setVisibility(i);
          Object localObject3 = (TextView)((View)localObject2).findViewById(2131377275);
          ((TextView)localObject3).setText((CharSequence)localObject1);
          eB((View)localObject2);
          if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) {
            break label4233;
          }
          bool = false;
          this.aUr = apuh.f(bool, "RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
          apuh.a(apuh.ai(this, "8.0.5"), "RED_POINT_KEY_TROOP_ADMIN", this.aUr, (TextView)localObject3);
          localObject1 = (TroopPluginManager)this.app.getManager(119);
          if (localObject1 != null) {
            this.aUn = ((TroopPluginManager)localObject1).a("troop_manage_plugin.apk", new uqr(this));
          }
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          localObject1 = new FormSimpleItem(this);
          a(1001, 0, (FormSimpleItem)localObject1, getString(2131698337), acfp.m(2131703745), true);
          this.dl.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBgType(1);
          ((FormSwitchItem)localObject1).setText(getString(2131694514));
          ((FormSwitchItem)localObject1).getTextView().setTextColor(getResources().getColor(2131167304));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131694514));
          this.p[7] = localObject1;
          localObject2 = ((FormSwitchItem)localObject1).a();
          if (!((TroopManager)this.app.getManager(52)).kv(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            break label4245;
          }
          ((Switch)localObject2).setChecked(true);
          ((Switch)localObject2).setTag(Integer.valueOf(7));
          ((Switch)localObject2).setOnCheckedChangeListener(this);
          this.dl.addView((View)localObject1);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBackgroundResource(2130839695);
          ((FormSwitchItem)localObject1).setBgType(2);
          ((FormSwitchItem)localObject1).setText(getString(2131694515));
          ((FormSwitchItem)localObject1).getTextView().setTextColor(getResources().getColor(2131167304));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131694515));
          this.p[8] = localObject1;
          localObject2 = ((FormSwitchItem)localObject1).a();
          ((Switch)localObject2).setTag(Boolean.FALSE);
          int j = this.app.cs(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) {
            this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopmask = j;
          }
          if (j == 1) {
            break label4254;
          }
          bool = true;
          ((Switch)localObject2).setChecked(bool);
          ((Switch)localObject2).setOnCheckedChangeListener(new uqv(this));
          this.dl.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561762, null);
          localObject2 = (FormSimpleItem)((View)localObject1).findViewById(2131369545);
          a(9, 0, (FormSimpleItem)localObject2, getString(2131721318), "", true);
          this.pK = new ImageView(this);
          localObject3 = new RelativeLayout.LayoutParams(wja.dp2px(17.0F, getResources()), wja.dp2px(17.0F, getResources()));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = wja.dp2px(30.0F, getResources());
          ((RelativeLayout.LayoutParams)localObject3).addRule(11);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15);
          ((FormSimpleItem)localObject2).addView(this.pK, (ViewGroup.LayoutParams)localObject3);
          this.pK.setImageDrawable(getResources().getDrawable(2130839651));
          this.pK.setVisibility(8);
          this.p[9] = localObject1;
          this.dl.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(1010, 2, (FormSimpleItem)localObject1, getString(2131696477), getString(2131719601), true);
          this.dl.addView((View)localObject1);
          this.jdField_x_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localObject1);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBackgroundResource(2130839695);
          ((FormSwitchItem)localObject1).setText(getString(2131698582));
          ((FormSwitchItem)localObject1).getTextView().setTextColor(getResources().getColor(2131167304));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131698582));
          this.p[10] = localObject1;
          ((FormSwitchItem)localObject1).a().setTag(Integer.valueOf(10));
          bLB();
          this.dl.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          localObject2 = new FormSimpleItem(this);
          this.p[6] = localObject2;
          this.dl.addView((View)localObject2);
          if (i != 0) {
            break label4260;
          }
          i = 3;
          localObject3 = getString(2131696169);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)) {
            break label4265;
          }
          localObject1 = getString(2131699791);
          a(6, i, (FormSimpleItem)localObject2, (String)localObject3, (CharSequence)localObject1, true);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
          {
            localObject1 = new aofe(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).k();
            ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
            aqpm.a(this.app, ((FormSimpleItem)localObject2).a(), (Spannable)localObject1);
          }
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          localObject1 = ((apoz)this.app.getManager(355)).a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
          localObject2 = (apov)aeif.a().o(590);
          if ((localObject2 != null) && ((((apov)localObject2).md((int)this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) || (((apov)localObject2).me((int)this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt))) && (localObject1 != null) && (((apoy)localObject1).LD() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
          {
            if (((apoy)localObject1).LC() != 0) {
              break label4277;
            }
            i = 1;
            localObject2 = new FormSimpleItem(this, null);
            ((FormSimpleItem)localObject2).showArrow(true);
            ((FormSimpleItem)localObject2).setBgType(1);
            ((FormSimpleItem)localObject2).setLeftText(getResources().getString(2131698441));
            if (i == 0) {
              break label4282;
            }
            localObject1 = getResources().getString(2131698434);
            ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
            ((FormSimpleItem)localObject2).setContentDescription(getResources().getString(2131698441));
            ((FormSimpleItem)localObject2).ac().setTextColor(getResources().getColor(2131167304));
            ((FormSimpleItem)localObject2).setFocusable(true);
            ((FormSimpleItem)localObject2).getBackground().setAlpha(255);
            this.p[41] = localObject2;
            ((FormSimpleItem)localObject2).setTag(Integer.valueOf(41));
            ((FormSimpleItem)localObject2).setOnClickListener(this);
            this.dl.addView((View)localObject2);
            localObject1 = View.inflate(this, 2131561775, null);
            ((View)localObject1).setBackgroundResource(2130851773);
            this.dl.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          }
          localObject1 = new FormSimpleItem(this, null);
          ((FormSimpleItem)localObject1).showArrow(true);
          ((FormSimpleItem)localObject1).setBgType(2);
          ((FormSimpleItem)localObject1).setLeftText(getResources().getString(2131721820));
          ((FormSimpleItem)localObject1).ac().setTextColor(getResources().getColor(2131167304));
          ((FormSimpleItem)localObject1).setFocusable(true);
          ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
          ((FormSimpleItem)localObject1).setContentDescription(getResources().getString(2131721820));
          this.p[16] = localObject1;
          ((FormSimpleItem)localObject1).setTag(Integer.valueOf(16));
          ((FormSimpleItem)localObject1).setOnClickListener(this);
          this.dl.addView((View)localObject1);
          bKQ();
          localObject1 = new FormSimpleItem(this, null);
          ((FormSimpleItem)localObject1).showArrow(true);
          ((FormSimpleItem)localObject1).setBgType(3);
          ((FormSimpleItem)localObject1).setLeftText("一起K歌");
          ((FormSimpleItem)localObject1).ac().setTextColor(getResources().getColor(2131167304));
          ((FormSimpleItem)localObject1).setFocusable(true);
          ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
          ((FormSimpleItem)localObject1).setContentDescription("一起K歌");
          this.p[38] = localObject1;
          ((FormSimpleItem)localObject1).setTag(Integer.valueOf(38));
          ((FormSimpleItem)localObject1).setOnClickListener(this);
          this.dl.addView((View)localObject1);
          bKq();
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          if (!aprg.bN(this.app)) {
            break label4329;
          }
          this.jdField_a_of_type_Apvf = new apvf(this, getString(2131721453));
          localObject1 = this.jdField_a_of_type_Apvf.getView();
          if (localObject1 != null)
          {
            if (!aprg.bP(this.app)) {
              break label4297;
            }
            this.aUq = aprg.bO(this.app);
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "bShowRed red robot" + this.aUq);
            }
            this.jdField_a_of_type_Apvf.Sm(this.aUq);
            this.dl.addView((View)localObject1);
            ((View)localObject1).setOnClickListener(this);
            ((View)localObject1).setTag(Integer.valueOf(1009));
            localObject1 = View.inflate(this, 2131561775, null);
            ((View)localObject1).setBackgroundResource(2130851773);
            this.dl.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
            anot.a(this.app, "dc00898", "", "", "", "0X8009F9B", 0, 0, "", "", "", "");
          }
          if ((this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop()))
          {
            localObject1 = new FormSimpleItem(this);
            a(1006, 0, (FormSimpleItem)localObject1, acfp.m(2131703780), "", true);
            this.dl.addView((View)localObject1);
            aqfr.b("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          }
          localObject1 = new LinearLayout(this);
          ((LinearLayout)localObject1).setOrientation(1);
          ((LinearLayout)localObject1).setVisibility(8);
          this.dl.addView((View)localObject1);
          this.p[28] = localObject1;
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.p[24] = localObject1;
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, "initUI  mIsQidianPrivateTroop = " + this.aUo);
          }
          bLz();
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          localObject1 = View.inflate(this, 2131561758, null);
          this.p[27] = localObject1;
          this.dl.addView((View)localObject1);
          a(27, 0, (View)localObject1, getString(2131698338), null, false);
          ((View)localObject1).setTag(Integer.valueOf(27));
          ((View)localObject1).setOnClickListener(this);
          localObject2 = (TextView)((View)localObject1).findViewById(2131379769);
          if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            ((TextView)localObject2).setAlpha(0.5F);
          }
          ((TextView)localObject2).setTextColor(Color.parseColor("#1E6FFF"));
          localObject1 = (TextView)((View)localObject1).findViewById(2131369154);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          localObject1 = View.inflate(this, 2131561773, null);
          this.dl.addView((View)localObject1);
          localObject1 = (Button)((View)localObject1).findViewById(2131365699);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label4342;
          }
          ((Button)localObject1).setText(2131692812);
          ((Button)localObject1).setOnClickListener(new uqw(this));
          localObject1 = View.inflate(this, 2131561775, null);
          ((View)localObject1).setBackgroundResource(2130851773);
          this.dl.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298468);
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "initUI: time = " + (System.currentTimeMillis() - l));
          }
          this.rV = localView.findViewById(2131363832);
          this.dc = ((Button)localView.findViewById(2131363743));
          this.dd = ((Button)localView.findViewById(2131378208));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)localView.findViewById(2131363636));
          this.dc.setOnTouchListener(new uqx(this));
          ww(false);
          this.mUIHandler.sendEmptyMessage(17);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        finish();
        localOutOfMemoryError.printStackTrace();
        return;
      }
      String str = getString(2131698378);
      continue;
      label4210:
      boolean bool = false;
      continue;
      label4216:
      str = acfp.m(2131703738);
      continue;
      label4227:
      int i = 8;
      continue;
      label4233:
      bool = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop();
      continue;
      label4245:
      ((Switch)localObject2).setChecked(false);
      continue;
      label4254:
      bool = false;
      continue;
      label4260:
      i = 0;
      continue;
      label4265:
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      continue;
      label4277:
      i = 0;
      continue;
      label4282:
      str = getResources().getString(2131698433);
      continue;
      label4297:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.aUq = aprg.bO(this.app);
      }
      else
      {
        this.aUq = false;
        continue;
        label4329:
        QLog.i("Q.chatopttroop", 2, "RobotSwithOff");
        continue;
        label4342:
        str.setText(2131717262);
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = paramCompoundButton.getTag();
    if (!(localObject instanceof Integer)) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      switch (((Integer)localObject).intValue())
      {
      default: 
        break;
      case 7: 
        wA(paramBoolean);
        break;
      case 19: 
        vI(paramBoolean);
        break;
      case 10: 
        wB(paramBoolean);
        break;
      case 31: 
        aA(1, paramBoolean);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && ((localObject1 instanceof Integer))) {
        i = ((Integer)localObject1).intValue();
      }
    }
    switch (i)
    {
    default: 
    case 4: 
    case 6: 
    case 0: 
    case 2: 
    case 3: 
    case 22: 
    case 39: 
    case 9: 
    case 1001: 
    case 1010: 
    case 1006: 
    case 1008: 
    case 1002: 
    case 5: 
    case 1004: 
    case 1005: 
    case 1003: 
    case 11: 
    case 17: 
    case 40: 
    case 18: 
    case 41: 
    case 23: 
    case 27: 
    case 29: 
    case 30: 
    case 1007: 
    case 1009: 
    case 14: 
    case 25: 
    case 32: 
    case 38: 
    case 16: 
      label516:
      label4744:
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = paramView.getTag();
        break;
        label402:
        Object localObject6;
        Object localObject7;
        if ((aerd.c().mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
        {
          bool = TroopManager.c.iC(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
          {
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            if (bool)
            {
              i = 15;
              localObject5 = VipUtils.a(0, i).toString();
              localObject6 = acfp.m(2131703750);
              localObject7 = new upx(this, bool);
              if (!bool) {
                break label508;
              }
              localObject1 = "0X800A57F";
              label442:
              if (!bool) {
                break label516;
              }
              i = 1;
              label449:
              VipUtils.a(this, (String)localObject4, (String)localObject5, (String)localObject6, (DialogInterface.OnClickListener)localObject7, (String)localObject1, i, bool);
            }
          }
          for (;;)
          {
            anot.a(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
            break;
            i = 8;
            break label402;
            label508:
            localObject1 = "0X8009E38";
            break label442;
            i = 3;
            break label449;
            VipUtils.O(this, bool);
          }
        }
        bLk();
        continue;
        bLf();
        continue;
        bLg();
        report("Grp_Admin_data", "Clk_mber", "");
        aqfr.b("Grp_set_new", "grpData_admin", "clk_mber", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        continue;
        bLe();
        aqfr.b("Grp_set_new", "grpData_admin", "clk_invite_new", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        continue;
        localObject1 = paramView.getTag(2131379222);
        label3858:
        label3865:
        label4636:
        label4895:
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
          label4641:
          label4777:
          if (((aptw)this.app.getManager(203)).gM((String)localObject1))
          {
            aprg.H(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1);
          }
          else
          {
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("selfSet_leftViewText", getString(2131721410));
            ((Bundle)localObject4).putString("custom_leftbackbutton_name", getTitle().toString());
            aldj.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1, 1, -1, (Bundle)localObject4);
            continue;
            localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            localObject4 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
            ((Intent)localObject4).putExtra("url", (String)localObject1);
            startActivity((Intent)localObject4);
            anot.a(this.app, "dc00899", "Grp_certified", "", "data", "clk_data", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
            for (i = 0;; i = 1)
            {
              localObject1 = new Intent(this, PublicAccountBrowser.class);
              ((Intent)localObject1).putExtra("hide_operation_bar", true);
              ((Intent)localObject1).putExtra("hideRightButton", true);
              ((Intent)localObject1).putExtra("isScreenOrientationPortrait", true);
              ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
              ((Intent)localObject1).putExtra("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + i);
              startActivity((Intent)localObject1);
              anot.a(this.app, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
              jpp.a(this.app, 72);
              break;
            }
            bLh();
            aqfr.b("Grp_msg", "grpData_admin", "Clk_msgSet", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            continue;
            ChatHistoryActivity.k(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1001);
            anot.a(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            aqfr.b("Grp_set_new", "grpData_admin", "clk_chatRecord", 1, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            anot.a(this.app, "dc00898", "", "", "0X800A0B8", "0X800A0B8", 0, 0, "", "", "", "");
            continue;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            ((Intent)localObject1).putExtra("uintype", 1);
            MessageNotificationSettingFragment.launch(this, (Intent)localObject1);
            continue;
            localObject1 = TroopMemberListActivity.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 19);
            ((Intent)localObject1).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
            startActivityForResult((Intent)localObject1, 9);
            localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
            aqfr.b("Grp_edu", "Grp_data", "teachermsg_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.c((TroopMemberInfo)localObject1) });
            continue;
            QQToast.a(this, acfp.m(2131703744), 0).show();
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("extra.GROUP_UIN", this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
            EntryDebugFragment.p(this, (Bundle)localObject1);
            continue;
            wy(false);
            if (this.bFK == 2) {
              anot.a(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            }
            i = getIntent().getIntExtra("extra_share_group_from", 0);
            if (i != 0) {
              rar.a("story_grp", "clk_msg", i, 0, new String[0]);
            }
            localObject1 = this.app;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
            for (i = 1;; i = 2)
            {
              anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A526", "0X800A526", i, 0, apuh.LG() + "", "", "", "");
              break;
            }
            apuh.wM("RED_POINT_KEY_TROOP_ADMIN");
            if (this.aUr) {
              apuh.wM("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
            }
            apuh.c(false, (TextView)paramView.findViewById(2131377275));
            localObject5 = new Intent();
            ((Intent)localObject5).putExtra("uin", this.app.getCurrentAccountUin());
            ((Intent)localObject5).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            ((Intent)localObject5).putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
            ((Intent)localObject5).putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
            ((Intent)localObject5).putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
            ((Intent)localObject5).putExtra("forward_cityid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId);
            ((Intent)localObject5).putExtra("troop_auth_submit_time", this.bFL);
            ((Intent)localObject5).putExtra("leftViewText", getResources().getString(2131691439));
            ((Intent)localObject5).putExtra("key_qidian_private_troop", this.aUo);
            ((Intent)localObject5).putExtra("key_is_update_before_805", apuh.ai(this, "8.0.5"));
            ((Intent)localObject5).putExtra("key_support_troop_honor", ((apmb)this.app.getManager(346)).qC(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin));
            bool = false;
            if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) {
              bool = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop();
            }
            ((Intent)localObject5).putExtra("key_customed_troop", bool);
            if (bool) {
              tbb.a(null, "846", "205605", "", "84601", "1", "145");
            }
            localObject4 = this.jdField_a_of_type_Aeoo;
            localObject1 = localObject4;
            if (localObject4 == null)
            {
              localObject1 = aeop.a();
              this.jdField_a_of_type_Aeoo = ((aeoo)localObject1);
            }
            ((Intent)localObject5).putExtra("autoApprovalUrl", ((aeoo)localObject1).bzZ);
            ((Intent)localObject5).putExtra("frequencyLimitVisible", ((aeoo)localObject1).bVn);
            ((Intent)localObject5).putExtra("key_is_need_update_Group_info", true);
            if ((QLog.isDevelopLevel()) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)) {
              QLog.i("TroopMngTest", 4, String.format("start troop mng [flag: %s, msgLimitFreq: %s]", new Object[] { Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt3 & 0x100000), Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.nMsgLimitFreq) }));
            }
            ((Intent)localObject5).putExtra("troop_manager_edit_red_show", Po());
            ((Intent)localObject5).putExtra("troop_manager_edit_current_uin", this.app.getCurrentUin());
            localObject1 = TroopBaseProxyActivity.a(this);
            localObject4 = new awjk(this.app);
            localObject6 = PluginCommunicationHandler.getInstance();
            if (localObject6 != null) {
              ((PluginCommunicationHandler)localObject6).register((RemoteCommand)localObject4);
            }
            TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.cKH, TroopManageProxyActivity.class, this, (Intent)localObject5, (Dialog)localObject1, "com.tencent.mobileqq.activity.TroopManageActivity", this.app.getCurrentAccountUin(), 8);
            localObject4 = this.app;
            localObject5 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
            for (localObject1 = "0";; localObject1 = "1")
            {
              anot.a((QQAppInterface)localObject4, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, (String)localObject5, (String)localObject1, "", "");
              aqfr.b("Grp_set_new", "grpData_admin", "clk_manageGrp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
              break;
            }
            anot.a(this.app, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            yxe.bm(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            aqfr.o(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            continue;
            apuh.a(this.app, this, getIntent(), this);
            anot.a(this.app, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
            aqfr.o(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            continue;
            localObject1 = this.app;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
            for (i = 1;; i = 2)
            {
              anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A527", "0X800A527", i, 0, apuh.LG() + "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
                break label2656;
              }
              if (!afsi.me(this.app.getCurrentAccountUin())) {
                break label2620;
              }
              localObject1 = afyk.b(this);
              if (!isFinishing())
              {
                ((Dialog)localObject1).show();
                anot.a(this.app, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
              }
              break;
            }
            label2620:
            anot.a(this.app, "dc00898", "", "", "0X80092D7", "0X80092D7", 0, 0, "", "", "", "");
            label2656:
            apuh.e(false, null);
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.authKey)))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
                Ax(1);
              }
              for (;;)
              {
                break;
                bLs();
              }
            }
            apuh.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, apuh.dWD, this.bFP, 2);
            label4523:
            label4919:
            label5049:
            label5054:
            if (!aqiw.isNetSupport(this))
            {
              cf(2131696270, 1);
            }
            else
            {
              localObject1 = (acms)this.app.getBusinessHandler(20);
              if (localObject1 != null) {}
              long l;
              try
              {
                l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                atg();
                ((acms)localObject1).aA(l, 8390784);
                if (super.getIntent().getBooleanExtra("from_babyq", false)) {
                  anot.a(this.app, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
                }
                aqfr.o(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.chatopttroop", 2, localException.toString());
                  }
                }
              }
              bLl();
              continue;
              apuh.a(this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 6);
              anot.a(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
              anot.a(this.app, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
              aqfr.b("Grp_set_new", "grpData_admin", "set_chatBG", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
              continue;
              localObject4 = (aqsy)((FormSimpleItem)this.p[40]).getTag(2131375592);
              Object localObject2;
              label4291:
              label5065:
              if (localObject4 != null)
              {
                l = ((aqsy)localObject4).lastClickTime;
                ((aqsy)localObject4).lastClickTime = SystemClock.uptimeMillis();
                if (((aqsy)localObject4).lastClickTime >= l + 1000L)
                {
                  aqvl.h(this.app, "troop_keyword_expire_list_" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((aqsy)localObject4).cwQ);
                  aqvl.f(this.app, "troop_keyword_guide_clicked", true);
                  localObject2 = aqqj.getUrl("groupkeywords").replace("[groupid]", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.chatopttroop.troop.special_msg.keyword", 2, "onClick: " + (String)localObject2);
                  }
                  anot.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F8", ((aqsy)localObject4).reportType, 1, 0, "", "", "", "");
                  localObject4 = new Intent(this, QQBrowserActivity.class);
                  ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
                  ((Intent)localObject4).putExtra("url", (String)localObject2);
                  ((Intent)localObject4).putExtra("isShowAd", false);
                  startActivity((Intent)localObject4);
                }
              }
              else
              {
                QLog.e("Q.chatopttroop.troop.special_msg.keyword", 1, "onClick status is null");
                continue;
                localObject2 = new Intent(this, QQBrowserActivity.class);
                localObject4 = aqqj.getUrl("troopEnterEffect");
                ((Intent)localObject2).putExtra("url", (String)localObject4 + "&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                startActivityForResult((Intent)localObject2, 15);
                apdr.b("grp_data", "entry_clk", new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                i = ((apdr)this.app.getManager(231)).eM(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "style", "0X8008E62", "", 1, 0, 0, "", Integer.toString(i), "");
                continue;
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("leftViewText", getString(2131698436));
                ((Intent)localObject2).putExtra("trooptype", this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt);
                ((Intent)localObject2).putExtra("troopuin", this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
                ((Intent)localObject2).putExtra("isManagerPage", false);
                ((Intent)localObject2).putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
                PublicFragmentActivity.b.startForResult(this, (Intent)localObject2, PublicFragmentActivity.class, TroopShortcutbarFragment.class, 18);
                continue;
                if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin != null)) {
                  this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
                }
                localObject2 = TroopInfoActivity.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
                ((Bundle)localObject2).putBoolean("troop_info_from_troopsetting", true);
                ((Bundle)localObject2).putInt("exposureSource", 1);
                apuh.a(this, (Bundle)localObject2, 2);
                localObject2 = this.app;
                if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
                for (i = 1;; i = 2)
                {
                  anot.a((QQAppInterface)localObject2, "dc00898", "", "", "0X800A524", "0X800A524", i, 0, "", "", "", "");
                  break;
                }
                localObject2 = new arfj(this, this.app, false);
                ((arfj)localObject2).a(new upy(this));
                ((arfj)localObject2).show(2);
                aqfr.b("Grp_set_new", "grpData_admin", "clk_delRecord", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                continue;
                localObject4 = paramView.getTag(2131379238);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.chatopttroop", 2, "troop app item click type=" + paramView.getId() + ", url=" + localObject4);
                }
                localObject5 = (oidb_0xea4.TabInfo)paramView.getTag(2131379207);
                if (apuh.a(paramView, (oidb_0xea4.TabInfo)localObject5))
                {
                  localObject2 = null;
                  if (((oidb_0xea4.TabInfo)localObject5).red_point.get() != 0)
                  {
                    localObject2 = (String)paramView.getTag(2131379231);
                    kgw.f(this, (String)localObject2, 2);
                    if ((localObject5 != null) && (((oidb_0xea4.TabInfo)localObject5).red_point.get() != 0)) {
                      if ((paramView instanceof TroopAppFormItem))
                      {
                        localObject2 = (TroopAppFormItem)paramView;
                        if (((oidb_0xea4.TabInfo)localObject5).appid.get() != 1106837471L) {
                          break label4291;
                        }
                        ((TroopAppFormItem)localObject2).ecl();
                      }
                    }
                  }
                }
                for (;;)
                {
                  ((acms)this.app.getBusinessHandler(20)).aa(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((oidb_0xea4.TabInfo)localObject5).appid.get());
                  ((oidb_0xea4.TabInfo)localObject5).red_point.set(0);
                  apuh.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, ((oidb_0xea4.TabInfo)localObject5).appid.get());
                  if (i != 30) {
                    break label4299;
                  }
                  aptr.K(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1106611799);
                  this.bFM = ((int)NetConnInfoCenter.getServerTime());
                  ThreadManager.post(new ChatSettingForTroop.27(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 5, null, false);
                  this.mUIHandler.sendEmptyMessage(19);
                  aqfr.b("Grp_game", "Grp_data", "feeds_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                  break;
                  if (TextUtils.isEmpty(this.aMi)) {
                    break label3858;
                  }
                  localObject2 = "{\"tags\":" + this.aMi + "}";
                  break label3858;
                  localObject2 = localObject4;
                  if (localObject5 != null)
                  {
                    localObject2 = localObject4;
                    if (((oidb_0xea4.TabInfo)localObject5).appid.get() == 1106837471L) {
                      localObject2 = (String)paramView.getTag(2131379231);
                    }
                  }
                  if ((!(localObject2 instanceof String)) || (TextUtils.isEmpty((String)localObject2))) {
                    break label3865;
                  }
                  localObject4 = new Bundle();
                  ((Bundle)localObject4).putString("uin", this.app.getCurrentAccountUin());
                  ((Bundle)localObject4).putString("gc", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                  ((Bundle)localObject4).putBoolean("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
                  if (ajcw.b(this, (String)localObject2, (Bundle)localObject4))
                  {
                    if (!QLog.isColorLevel()) {
                      break label3865;
                    }
                    QLog.d("Q.chatopttroop", 2, "mini app jump handled");
                    break label3865;
                  }
                  localObject4 = new Intent(this, QQBrowserActivity.class);
                  ((Intent)localObject4).putExtra("url", (String)localObject2);
                  startActivity((Intent)localObject4);
                  break label3865;
                  ((TroopAppFormItem)localObject2).baG();
                }
                label4299:
                if (i == 29)
                {
                  aqfr.b("Grp_game", "Grp_data", "rank_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                }
                else if ((i == 1007) && (localObject5 != null) && (((oidb_0xea4.TabInfo)localObject5).appid.get() == 1106837471L))
                {
                  aqfr.b("Grp_set", "Grp_aio_subscription", "subscription_clk", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) });
                  continue;
                  if (this.aUq)
                  {
                    aprg.Z(this.app, false);
                    this.jdField_a_of_type_Apvf.Sm(false);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.chatopttroop", 2, "setRobotItemRedDotShowed");
                    }
                  }
                  anot.a(this.app, "dc00898", "", "", "", "0X8009F9C", 0, 0, "", "", "", "");
                  apuh.d(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
                  continue;
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
                  {
                    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1))
                    {
                      i = 1;
                      if ((i == 0) || (!aerd.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
                        break label4725;
                      }
                      bool = TroopManager.c.iC(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
                      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                        break label4716;
                      }
                      localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                      if (!bool) {
                        break label4699;
                      }
                      i = 15;
                      label4596:
                      localObject5 = VipUtils.a(0, i).toString();
                      localObject6 = acfp.m(2131703737);
                      localObject7 = new upz(this, bool);
                      if (!bool) {
                        break label4705;
                      }
                      localObject2 = "0X800A57F";
                      if (!bool) {
                        break label4713;
                      }
                      VipUtils.a(this, (String)localObject4, (String)localObject5, (String)localObject6, (DialogInterface.OnClickListener)localObject7, (String)localObject2, 1, bool);
                    }
                    for (;;)
                    {
                      anot.a(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
                      break;
                      i = 0;
                      break label4523;
                      label4699:
                      i = 8;
                      break label4596;
                      label4705:
                      localObject2 = "0X8009E38";
                      break label4636;
                      label4713:
                      break label4641;
                      label4716:
                      VipUtils.O(this, bool);
                    }
                    label4725:
                    int j;
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)
                    {
                      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
                      localObject4 = localObject2;
                      if (localObject2 == null) {
                        localObject4 = "";
                      }
                      if ((this.aUo) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
                        break label5049;
                      }
                      j = 1;
                      localObject5 = new Intent(this, EditInfoActivity.class);
                      ((Intent)localObject5).putExtra("edit_type", 2);
                      if (i == 0) {
                        break label5054;
                      }
                      localObject2 = acfp.m(2131703756);
                      label4812:
                      ((Intent)localObject5).putExtra("title", (String)localObject2);
                      ((Intent)localObject5).putExtra("default_text", (String)localObject4);
                      ((Intent)localObject5).putExtra("max_num", 96);
                      ((Intent)localObject5).putExtra("canPostNull", false);
                      if (i == 0) {
                        break label5065;
                      }
                      localObject2 = acfp.m(2131703741);
                      ((Intent)localObject5).putExtra("right_btn", (String)localObject2);
                      ((Intent)localObject5).putExtra("isTroopName", true);
                      if (i == 0) {
                        break label5073;
                      }
                      bool = true;
                      ((Intent)localObject5).putExtra("edit_mode", bool);
                      if (j == 0) {
                        break label5079;
                      }
                      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                      ((Intent)localObject5).putExtra("troopUin", (String)localObject2);
                      startActivityForResult((Intent)localObject5, 16);
                      aqfr.b("Grp_set_new", "grpData_admin", "clk_editInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                      localObject4 = this.app;
                      localObject5 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                        break label5087;
                      }
                      localObject2 = "0";
                    }
                    for (;;)
                    {
                      anot.a((QQAppInterface)localObject4, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_name", 0, 0, (String)localObject5, "0", (String)localObject2, "");
                      break;
                      localObject2 = "";
                      break label4744;
                      j = 0;
                      break label4777;
                      localObject2 = acfp.m(2131703755);
                      break label4812;
                      localObject2 = "";
                      break label4867;
                      label5073:
                      bool = false;
                      break label4895;
                      label5079:
                      localObject2 = "";
                      break label4919;
                      label5087:
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
                        localObject2 = "1";
                      } else {
                        localObject2 = "2";
                      }
                    }
                    try
                    {
                      if (this.jdField_a_of_type_Apzg != null) {
                        this.jdField_a_of_type_Apzg.onDestroy();
                      }
                      this.jdField_a_of_type_Apzg = new apzg(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
                      this.jdField_a_of_type_Apzg.ecJ();
                    }
                    catch (NullPointerException localNullPointerException)
                    {
                      for (;;)
                      {
                        localNullPointerException.printStackTrace();
                        continue;
                        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
                          localObject3 = "1";
                        } else {
                          localObject3 = "2";
                        }
                      }
                    }
                    localObject4 = this.app;
                    localObject5 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
                    {
                      localObject2 = "0";
                      anot.a((QQAppInterface)localObject4, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_num", 0, 0, (String)localObject5, "0", (String)localObject2, "");
                    }
                    else
                    {
                      localObject3 = aptl.a().aF(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1);
                      localObject4 = new Intent(this, QQBrowserActivity.class);
                      ((Intent)localObject4).putExtra("url", (String)localObject3);
                      startActivity((Intent)localObject4);
                      anot.a(null, "dc00898", "", "", "0X800A6EF", "0X800A6EF", 0, 0, "", "", "", "");
                      continue;
                      localObject3 = (aohy)this.app.getManager(339);
                      bool = ((aohy)localObject3).e(4, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                      localObject4 = aoij.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
                      if (bool) {
                        ((aohy)localObject3).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 4, 2, (Bundle)localObject4);
                      }
                      for (;;)
                      {
                        aoij.a(this.app, "SP_KEY_SING_TOGETHER_TROOP_RED_DOT_SHOW", false, false);
                        ((aohy)localObject3).g("sing_tab", "clk_setsing", 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                        bKq();
                        break;
                        ((aohy)localObject3).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 4, 2, (Bundle)localObject4);
                      }
                      localObject3 = (aeof)aeif.a().o(535);
                      if ((localObject3 != null) && (((aeof)localObject3).a != null)) {
                        break label5525;
                      }
                      QQToast.a(this, 0, 2131694552, 0).show();
                    }
                  }
                }
              }
            }
          }
        }
      }
      label4867:
      label5525:
      Object localObject4 = (aohy)this.app.getManager(339);
      boolean bool = ((aohy)localObject4).e(2, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      Object localObject5 = aoij.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      switch (((aeof)localObject3).a.getVersion())
      {
      default: 
        if (((aohy)localObject4).a(this, 2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2)) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(2) });
          }
        }
        break;
      }
      for (;;)
      {
        aoij.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_RED_DOT_SHOW", false, false);
        bKQ();
        break;
        QQToast.a(this, 0, 2131694552, 0).show();
        continue;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
        {
          if (bool) {
            ((aohy)localObject4).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject5);
          } else {
            ((aohy)localObject4).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject5);
          }
        }
        else if (bool)
        {
          ((aohy)localObject4).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject5);
        }
        else
        {
          ((aohy)localObject4).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject5);
          continue;
          ((aohy)localObject4).g("video_tab", "clk_setvideo", 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          aoij.a(this.app, ((aeof)localObject3).a.getJumpType(), ((aeof)localObject3).a.getJumpUrl(), ((aeof)localObject3).a.tC(), (Bundle)localObject5, 1);
        }
      }
    }
    if (this.jdField_a_of_type_Apzg != null) {
      this.jdField_a_of_type_Apzg.onDestroy();
    }
    this.jdField_a_of_type_Apzg = apuh.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app);
    Object localObject3 = this.app;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (int i = 1;; i = 2)
    {
      anot.a((QQAppInterface)localObject3, "dc00898", "", "", "0X800A525", "0X800A525", i, 0, apuh.LG() + "", "", "", "");
      break;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        break label55;
      }
      bKT();
    }
    label55:
    while (this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView == null) {
      return;
    }
    paramInt2 = this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
    paramInt1 = 0;
    label72:
    Object localObject;
    if (paramInt1 < paramInt2)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
      if ((localObject != null) && ((localObject instanceof DiscussionInfoCardActivity.b)))
      {
        localObject = (DiscussionInfoCardActivity.b)localObject;
        if (paramString != null) {
          break label129;
        }
        a((DiscussionInfoCardActivity.b)localObject, null, false);
      }
    }
    label129:
    while (!paramString.equals(((DiscussionInfoCardActivity.b)localObject).uin))
    {
      paramInt1 += 1;
      break label72;
      break;
    }
    ((DiscussionInfoCardActivity.b)localObject).pQ.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  protected void report(String paramString1, String paramString2, String paramString3)
  {
    anot.a(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void vs(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString;
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = paramString;
    }
    bLc();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
      this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName;
      this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop;
      apuh.a(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    }
  }
  
  public void wv(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateEnterEffectStatus  isShow = " + paramBoolean);
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.p[18];
    if (localFormSimpleItem == null) {}
    apdh.a locala;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      localFormSimpleItem.setVisibility(0);
      localObject = this.p[17];
      if ((localObject != null) && ((localObject instanceof FormSimpleItem))) {
        ((FormSimpleItem)localObject).setBgType(2);
      }
      localObject = (apdr)this.app.getManager(231);
      locala = ((apdr)localObject).a();
    } while (locala == null);
    if (locala.dTA > 0)
    {
      localFormSimpleItem.setRightText(locala.cos);
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    Object localObject = ((apdr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localObject != null)
    {
      if (((apdh.b)localObject).effectId == 0)
      {
        localFormSimpleItem.setRightText(acfp.m(2131703758));
        return;
      }
      localFormSimpleItem.setRightText(((apdh.b)localObject).aVQ);
      return;
    }
    localFormSimpleItem.setRightText(acfp.m(2131703766));
  }
  
  public void ww(boolean paramBoolean)
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mTroopInfoData is null!");
      }
      return;
    }
    Object localObject = this.p[5];
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.aUn)) {}
    for (int i = 0;; i = 8)
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(i);
      }
      localObject = (FormSimpleItem)this.p[6];
      if (localObject == null) {
        break;
      }
      if (i == 0) {
        j = 3;
      }
      ((FormSimpleItem)localObject).setBgType(j);
      return;
    }
  }
  
  protected void x(int paramInt, Intent paramIntent)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str2 = aqfr.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      aqfr.b("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = wja.a(new Intent(this, SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a((Intent)localObject);
    ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
  }
  
  protected void y(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("ken_qun_photo_data_has_changed", true);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "resultForRequestQzonePhoto|needRereshed = " + bool);
      }
      if (bool) {
        bLp();
      }
    }
    ThreadManager.post(new ChatSettingForTroop.41(this), 8, null, true);
  }
  
  protected void z(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      if (paramIntent.getExtras().getBoolean("isNeedFinish"))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
        finish();
        return;
      }
      if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
      {
        finish();
        return;
      }
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppTroopManager == null) {}
    for (paramIntent = null;; paramIntent = this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      if ((paramIntent != null) && (paramIntent.wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramIntent.Administrator, paramIntent.wMemberNum, this.app.getCurrentAccountUin(), getResources());
        if (this.tR != null) {
          this.tR.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + acfp.m(2131703767));
        }
      }
      if (this.qC != null) {
        fH(this.qC);
      }
      paramIntent = this.jdField_b_of_type_ComTencentMobileqqAppTroopManager;
      if ((this.p[6] == null) || (this.jdField_b_of_type_ComTencentMobileqqAppTroopManager == null)) {
        break;
      }
      ThreadManager.post(new ChatSettingForTroop.42(this, paramIntent), 8, null, true);
      return;
    }
  }
  
  public static class ClearChatRecordTask
    implements Runnable
  {
    WeakReference<ChatSettingForTroop> T;
    
    public ClearChatRecordTask(ChatSettingForTroop paramChatSettingForTroop)
    {
      this.T = new WeakReference(paramChatSettingForTroop);
    }
    
    public void run()
    {
      try
      {
        localChatSettingForTroop = (ChatSettingForTroop)this.T.get();
        if (localChatSettingForTroop == null) {
          return;
        }
        if (localChatSettingForTroop.isDestory) {
          return;
        }
        localObject1 = localChatSettingForTroop.app;
        str = localChatSettingForTroop.a.troopUin;
        localObject2 = new StringBuilder();
        i = apuh.a((QQAppInterface)localObject1, str, 1, (StringBuilder)localObject2);
        List localList = ((QQAppInterface)localObject1).b().k(str, 1);
        if ((localList == null) || (localList.isEmpty())) {
          break label367;
        }
        l1 = ((MessageRecord)localList.get(localList.size() - 1)).shmsgseq;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          Object localObject1;
          long l1;
          try
          {
            ChatSettingForTroop localChatSettingForTroop;
            String str;
            int i;
            long l2 = Long.parseLong(((StringBuilder)localObject2).toString());
            l1 = Math.max(l2, l1);
            if (l1 > 0L) {
              ((QQAppInterface)localObject1).a().F(str, 1, l1);
            }
            if (!((TroopManager)((QQAppInterface)localObject1).getManager(52)).kv(str)) {
              break label325;
            }
            FriendsStatusUtil.r((QQAppInterface)localObject1, str, 1);
            ((QQAppInterface)localObject1).b().a(str, 1, true, false);
            ((QQAppInterface)localObject1).b().cc(str, 1);
            abrb.F((QQAppInterface)localObject1, "chat_history_confirm_del_msg");
            localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
            Object localObject2 = ((MqqHandler)localObject1).obtainMessage(1017);
            ((Message)localObject2).obj = str;
            ((Message)localObject2).arg1 = 1;
            ((MqqHandler)localObject1).sendMessage((Message)localObject2);
            localChatSettingForTroop.mUIHandler.sendEmptyMessage(18);
            return;
          }
          catch (Exception localException)
          {
            QLog.e("Q.chatopttroop", 1, "ClearChatRecordTask parse seq fail.", localException);
            localIllegalStateException.mUIHandler.sendEmptyMessage(18);
            return;
          }
          localIllegalStateException = localIllegalStateException;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.chatopttroop", 2, "msg history clear,  IllegalStateException" + localIllegalStateException.toString());
          return;
          label325:
          ((QQAppInterface)localObject1).b().N(localException, 1);
          aizp.a().k(localException, (QQAppInterface)localObject1);
          continue;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.chatopttroop", 2, "msg history already clear!");
            continue;
            label367:
            l1 = 0L;
          }
        }
      }
      if (i > 0) {}
    }
  }
  
  public class a
    extends BaseAdapter
  {
    private boolean aUB = true;
    private acff e = (acff)ChatSettingForTroop.this.app.getManager(51);
    
    public a()
    {
      bLG();
    }
    
    private void bLG()
    {
      if ((TroopInfo.hasPayPrivilege(ChatSettingForTroop.this.a.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(ChatSettingForTroop.this.a.mTroopPrivilegeFlag, 512))) {}
      for (boolean bool = true; ((!ChatSettingForTroop.this.a.mMemberInvitingFlag) && (!ChatSettingForTroop.this.a.isOwnerOrAdim())) || ((!ChatSettingForTroop.this.a.isOwnerOrAdim()) && (ChatSettingForTroop.this.a.cGroupOption == 3) && (!bool)); bool = false)
      {
        this.aUB = false;
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "隐藏邀请按钮：mMemberInvitingFlag=" + ChatSettingForTroop.this.a.mMemberInvitingFlag + ", mTroopInfoData.isOwnerOrAdim() = " + ChatSettingForTroop.this.a.isOwnerOrAdim() + ", mTroopInfoData.cGroupOption=" + ChatSettingForTroop.this.a.cGroupOption + ", isPayToJoinTroop=" + bool);
        }
        return;
      }
      this.aUB = true;
    }
    
    public int getCount()
    {
      if (ChatSettingForTroop.this.qB == null) {}
      for (int i = 0;; i = ChatSettingForTroop.this.qB.size())
      {
        int j = i;
        if (this.aUB)
        {
          j = i;
          if (i != 0) {
            j = i + 1;
          }
        }
        return Math.min(10, j);
      }
    }
    
    public Object getItem(int paramInt)
    {
      if ((ChatSettingForTroop.this.qB == null) || (paramInt >= ChatSettingForTroop.this.qB.size())) {
        return null;
      }
      return ChatSettingForTroop.this.qB.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      DiscussionInfoCardActivity.b localb;
      TextView localTextView;
      ImageView localImageView;
      if (paramView == null)
      {
        localView = ChatSettingForTroop.this.getLayoutInflater().inflate(2131558933, null);
        localb = new DiscussionInfoCardActivity.b();
        localb.pQ = ((ImageView)localView.findViewById(2131368698));
        localb.nameTV = ((ColorNickTextView)localView.findViewById(2131372190));
        localView.setTag(localb);
        localView.setVisibility(0);
        localView.setFocusable(false);
        localTextView = localb.nameTV;
        localImageView = localb.pQ;
        if ((!this.aUB) || (paramInt != getCount() - 1)) {
          break label239;
        }
        localTextView.setText(ChatSettingForTroop.this.getString(2131695117));
        localTextView.setTextColor(ChatSettingForTroop.this.getResources().getColor(2131167393));
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageResource(2130839346);
        localImageView.setOnTouchListener(ChatSettingForTroop.this.q);
        localImageView.setEnabled(true);
        localImageView.setTag(Integer.valueOf(2));
        localb.uin = "";
      }
      label239:
      String str;
      for (;;)
      {
        if (AppSetting.enableTalkBack) {
          ViewCompat.setImportantForAccessibility(localImageView, 2);
        }
        localImageView.setOnClickListener(ChatSettingForTroop.this);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
        localb = (DiscussionInfoCardActivity.b)paramView.getTag();
        localView = paramView;
        break;
        if (paramInt < ChatSettingForTroop.this.qB.size())
        {
          localImageView.setImageResource(2130845854);
          localTextView.setTextColor(ChatSettingForTroop.this.getResources().getColor(2131167307));
          str = ChatSettingForTroop.this.qB.get(paramInt) + "";
          localb.uin = str;
          if (!TextUtils.isEmpty(str)) {
            break label347;
          }
          localTextView.setText("");
          localImageView.setImageDrawable(aqhu.at());
        }
      }
      label347:
      if (ChatSettingForTroop.this.jdField_b_of_type_ComTencentMobileqqAppTroopManager.aA(ChatSettingForTroop.this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str)) {}
      for (Object localObject2 = aqgv.c(ChatSettingForTroop.this.app, ChatSettingForTroop.this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str, true);; localObject2 = str)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          Object localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = str;
          }
          localObject2 = localObject1;
          if (ChatSettingForTroop.this.aUo)
          {
            localObject2 = localObject1;
            if (TextUtils.isDigitsOnly((CharSequence)localObject1)) {
              localObject2 = acfp.m(2131703775);
            }
          }
          localObject1 = new aofe((CharSequence)localObject2, 12).k();
          localTextView.setText((CharSequence)localObject1);
          aqpm.a(ChatSettingForTroop.this.app, localTextView, (Spannable)localObject1);
        }
        ChatSettingForTroop.this.a(localb, null, true);
        localImageView.setTag(2131379222, str);
        localImageView.setTag(Integer.valueOf(3));
        break;
        aqgv.a(ChatSettingForTroop.this.app, ChatSettingForTroop.this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopuin, str, new uqz(this, localb, str, localTextView));
      }
    }
    
    public void notifyDataSetChanged()
    {
      bLG();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop
 * JD-Core Version:    0.7.0.1
 */