package com.tencent.mobileqq.activity.history;

import aavp;
import aavr;
import aavw;
import acbn;
import achs;
import achs.a;
import aczx;
import afsf;
import aghq;
import agkh;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import anot;
import aobo;
import aqgv;
import aqiw;
import aqqj;
import arhz;
import aurf;
import ausj;
import auss;
import auuo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.AutoFitScrollView;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TimeLineView;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.a;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder.a;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.b;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.activity.history.widget.ChatHistoryTimeLineContainer;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.BitSet;
import java.util.Calendar;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONException;
import org.json.JSONObject;
import wja;
import wkj;
import wkl;
import wkl.a;
import xje.a;
import xjx.a;
import xov.a;
import zet;
import zeu;
import zew;
import zex;
import zey;
import zez;
import zfa;
import zfb;
import zfc;
import zfd;
import zfe;
import zff;
import zfg;
import zgq;
import zli;

public class ChatHistoryC2CAllFragment
  extends ChatHistoryBaseFragment
  implements achs.a, View.OnClickListener, auuo, AbsListView.e, wkl.a
{
  private TextView CE;
  private int Hy;
  TextView MJ;
  aobo jdField_a_of_type_Aobo = new zey(this);
  AutoFitScrollView jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView;
  TimeLineView jdField_a_of_type_ComTencentMobileqqActivityTimeLineView;
  MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  public ChatHistoryTimeLineContainer a;
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new zew(this);
  TipsBar jdField_a_of_type_ComTencentMobileqqWidgetTipsBar;
  public BroadcastReceiver aR = null;
  public boolean aTP = false;
  public achs b;
  Handler.Callback b;
  public wkl b;
  public zli b;
  private int bEz;
  public Handler bK = new zfb(this);
  String baf = "";
  boolean bmj = false;
  private boolean bml;
  public boolean bqZ = true;
  public boolean bra = false;
  boolean brb = false;
  boolean brc = false;
  boolean brd = false;
  public TipsBar c;
  public int cdn;
  private aghq jdField_d_of_type_Aghq = new zez(this);
  DialogInterface.OnCancelListener jdField_d_of_type_AndroidContentDialogInterface$OnCancelListener;
  public ChatXListView d;
  IntentFilter filter = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
  private View footerView;
  private LinearLayout hI;
  private LinearLayout hJ;
  public LinearLayout hK;
  long iu = 0L;
  RelativeLayout ix;
  DisplayMetrics mDisplayMetrics;
  private View mEmptyView;
  View mRootView;
  public SessionInfo mSessionInfo;
  private Toast mToast;
  public MqqHandler mUIHandler;
  private Calendar n;
  private Calendar o;
  private Calendar p;
  private View rK;
  private View rL;
  private arhz u;
  public List<MessageRecord> ue;
  public String vipType = "";
  private ImageView vj;
  View yC;
  public arhz z;
  
  public ChatHistoryC2CAllFragment()
  {
    this.jdField_b_of_type_AndroidOsHandler$Callback = new zet(this);
  }
  
  private boolean Vl()
  {
    return (this.jdField_a_of_type_Zer instanceof zgq);
  }
  
  public static MessageRecord a(Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.getBooleanExtra("need_jump_to_msg", false))) {}
    long l1;
    long l2;
    do
    {
      return null;
      l1 = paramIntent.getLongExtra("searched_time", -1L);
      l2 = paramIntent.getLongExtra("target_shmsgseq", -1L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "jumpSearchRecord, time = " + l1 + " , shmsgseq = " + l2);
      }
    } while ((l1 == -1L) || (l2 == -1L));
    paramIntent = new MessageRecord();
    paramIntent.time = l1;
    paramIntent.shmsgseq = l2;
    return paramIntent;
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    if (this.brb)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 1, "already open dev");
      }
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramString1);
      localJSONObject.put("wording", paramString2);
      localJSONObject.put("image_res_id", paramInt);
      localJSONObject.put("btn_text", paramString3);
      localJSONObject.put("jump_text", paramString4);
      localJSONObject.put("jump_url", paramString5);
      label89:
      if (this.mApp != null)
      {
        cpe();
        this.mApp.getApp().registerReceiver(this.aR, this.filter, "com.tencent.tim.msg.permission.pushnotify", null);
      }
      paramString1 = new Intent();
      paramString1.setFlags(268435456);
      paramString1.setAction("android.intent.action.VIEW");
      paramString1.putExtra("devlock_guide_config", localJSONObject.toString());
      paramString1.putExtra("devlock_open_source", "RoamMsg");
      paramString1.putExtra("open_devlock_verify_passwd", paramBoolean);
      paramString1.putExtra("open_devlock_from_roam", true);
      paramString1.putExtra("devlock_show_auth_dev_list", false);
      paramString1.setData(Uri.parse("mqqdevlock://devlock/open?"));
      startActivity(paramString1);
      this.brb = true;
      return;
    }
    catch (JSONException paramString1)
    {
      break label89;
    }
  }
  
  private void aA(Message paramMessage)
  {
    int i;
    int j;
    if (paramMessage.arg1 == 1)
    {
      i = 1;
      j = paramMessage.arg2;
      paramMessage = (byte[])paramMessage.obj;
      if (i == 0) {
        break label97;
      }
      if ((paramMessage == null) || (paramMessage.length <= 0)) {
        break label50;
      }
      BD(false);
    }
    label50:
    label97:
    do
    {
      return;
      i = 0;
      break;
      paramMessage = (AccountManager)this.mApp.getManager(0);
      if (paramMessage != null)
      {
        coY();
        paramMessage.refreshDA2(this.mApp.getCurrentAccountUin(), new zfa(this));
        return;
      }
      cpc();
      return;
      if ((2 != j) && (3 != j)) {
        break label140;
      }
      BD(false);
    } while (2 != j);
    VipUtils.a(this.mApp, "chat_history", "LockSet", "Clk_PswUse", 1, 0, new String[0]);
    return;
    label140:
    cpc();
  }
  
  private void ax(Message paramMessage)
  {
    if (this.bra)
    {
      this.bra = false;
      paramMessage = (achs)this.mApp.getManager(92);
      if (paramMessage != null) {
        paramMessage.cKz();
      }
    }
  }
  
  private void ay(Message paramMessage)
  {
    boolean bool3 = true;
    int i = paramMessage.arg1;
    DevlockInfo localDevlockInfo = (DevlockInfo)paramMessage.obj;
    boolean bool1;
    boolean bool2;
    if (paramMessage.arg2 == 1)
    {
      bool1 = true;
      coZ();
      if ((i != 0) || (localDevlockInfo == null)) {
        break label88;
      }
      if (localDevlockInfo.DevSetup != 1) {
        break label76;
      }
      bool2 = true;
      label52:
      if (localDevlockInfo.AllowSet != 1) {
        break label82;
      }
    }
    for (;;)
    {
      r(bool2, bool3, bool1);
      return;
      bool1 = false;
      break;
      label76:
      bool2 = false;
      break label52;
      label82:
      bool3 = false;
    }
    label88:
    if (1 == this.jdField_b_of_type_Achs.getAuthMode())
    {
      cpc();
      return;
    }
    if (!this.jdField_b_of_type_Achs.aaW())
    {
      coW();
      return;
    }
    BD(bool1);
  }
  
  private void az(Message paramMessage)
  {
    boolean bool = true;
    int i;
    if (paramMessage.arg1 == 1)
    {
      i = 1;
      if (paramMessage.arg2 != 1) {
        break label39;
      }
    }
    for (;;)
    {
      coZ();
      if (i == 0) {
        break label44;
      }
      BD(bool);
      return;
      i = 0;
      break;
      label39:
      bool = false;
    }
    label44:
    cpc();
  }
  
  private void bJB()
  {
    this.hK = ((LinearLayout)View.inflate(getActivity(), 2131562136, null));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.hK.findViewById(2131372269));
    this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.hK);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new zfd(this));
    this.CE = this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.getTextView();
    this.vj = this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.F();
    this.bqZ = true;
    cpd();
  }
  
  private void bJM()
  {
    if (this.mToast != null)
    {
      this.mToast.cancel();
      this.mToast = null;
    }
  }
  
  private void coX()
  {
    if (this.hK == null)
    {
      this.hK = ((LinearLayout)View.inflate(getActivity(), 2131562136, null));
      this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.hK);
    }
    this.c = ((TipsBar)this.hK.findViewById(2131379725));
    this.c.setOnClickListener(this);
    this.hK.setVisibility(0);
    this.c.setVisibility(8);
  }
  
  private void coY()
  {
    if (getActivity() == null)
    {
      QLog.e("Q.history.C2CAllFragment", 2, "showDialogLoadingTips activity is null");
      return;
    }
    if (this.jdField_d_of_type_AndroidContentDialogInterface$OnCancelListener == null) {
      this.jdField_d_of_type_AndroidContentDialogInterface$OnCancelListener = new a(this);
    }
    a(getString(2131720488), this.jdField_d_of_type_AndroidContentDialogInterface$OnCancelListener);
  }
  
  private void cpa()
  {
    if (this.bmj) {
      return;
    }
    boolean bool1 = aqiw.isNetSupport(BaseApplication.getContext());
    boolean bool2 = this.jdField_b_of_type_Achs.aaX();
    if ((!bool1) || (!bool2))
    {
      if (!bool1) {
        c(null);
      }
      cpc();
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ChatHistoryC2CAllFragment.5(this, bool2));
      return;
      if (!this.jdField_b_of_type_Achs.aaV())
      {
        aczx localaczx = (aczx)this.mApp.getBusinessHandler(59);
        label92:
        StringBuilder localStringBuilder;
        if (localaczx != null)
        {
          localaczx.cPt();
          if (!QLog.isColorLevel()) {
            break label142;
          }
          localStringBuilder = new StringBuilder().append("hasGetAuthMode false hanlder is null: ");
          if (localaczx != null) {
            break label144;
          }
        }
        label142:
        label144:
        for (bool1 = true;; bool1 = false)
        {
          QLog.d("Q.history.C2CAllFragment", 2, bool1);
          break;
          cpc();
          break label92;
          break;
        }
      }
      BC(false);
    }
  }
  
  private void cpb()
  {
    this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.mRootView.findViewById(2131370538));
    View localView = LayoutInflater.from(getActivity()).inflate(2131559032, null);
    localView.setPadding(0, 0, 0, 30);
    this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(localView);
    this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.mEmptyView = this.mRootView.findViewById(2131366437);
    bJC();
    bJB();
    coX();
    this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollFooter(null);
    }
    this.footerView = getActivity().getLayoutInflater().inflate(2131562071, null);
    this.hI = ((LinearLayout)this.footerView.findViewById(2131377037));
    this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.footerView);
    this.footerView.setVisibility(8);
    this.hJ = ((LinearLayout)this.footerView.findViewById(2131371952));
    this.hJ.findViewById(2131363743).setOnClickListener(this);
    this.jdField_b_of_type_Wkl = new wkl(this.mApp, getActivity(), this.mSessionInfo, null, null, this);
    this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_Wkl);
  }
  
  private void ey(View paramView)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleScrollOutScreen in history, view = ");
      if (paramView != null) {
        break label47;
      }
    }
    label47:
    for (Object localObject = "null";; localObject = paramView.toString())
    {
      QLog.i("Q.history.C2CAllFragment", 2, (String)localObject);
      if (paramView != null) {
        break;
      }
      return;
    }
    paramView = wja.a(paramView);
    if (ShortVideoItemBuilder.b.class.isInstance(paramView))
    {
      ((ShortVideoItemBuilder.b)paramView).cdi();
      label77:
      if (!QLog.isColorLevel()) {
        break label243;
      }
      if (paramView != null) {
        break label245;
      }
    }
    label243:
    label245:
    for (paramView = "null";; paramView = paramView.getClass())
    {
      QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "handleScrollOutScreen in history", " obj=", paramView });
      return;
      if (ShortVideoRealItemBuilder.a.class.isInstance(paramView))
      {
        ((ShortVideoRealItemBuilder.a)paramView).cee();
        break label77;
      }
      if (LightVideoItemBuilder.a.class.isInstance(paramView))
      {
        ((LightVideoItemBuilder.a)paramView).cdi();
        break label77;
      }
      if ((paramView instanceof xov.a))
      {
        localObject = (xov.a)paramView;
        if (((xov.a)localObject).a == null) {
          break label77;
        }
        ((xov.a)localObject).a.detach();
        break label77;
      }
      if ((paramView instanceof xjx.a))
      {
        localObject = (xjx.a)paramView;
        if (((xjx.a)localObject).a == null) {
          break label77;
        }
        ((xjx.a)localObject).a.detach();
        break label77;
      }
      if (!(paramView instanceof xje.a)) {
        break label77;
      }
      localObject = (xje.a)paramView;
      if (((xje.a)localObject).a == null) {
        break label77;
      }
      ((xje.a)localObject).a.detach();
      break label77;
      break;
    }
  }
  
  private void initTitle()
  {
    if (this.mSessionInfo.cZ == 0) {
      if (this.mSessionInfo.aTl.equals(String.valueOf(acbn.bkD))) {
        this.mSessionInfo.aTn = super.getString(2131720683);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.mSessionInfo.aTn)) {
        this.mSessionInfo.aTn = this.mSessionInfo.aTl;
      }
      return;
      this.mSessionInfo.aTn = aqgv.a(this.mApp, this.mSessionInfo.aTl, this.mSessionInfo.troopUin, aqgv.jZ(this.mSessionInfo.cZ), 3);
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("Q.history.C2CAllFragment", 2, "uin type illegal: " + this.mSessionInfo.cZ);
      }
    }
  }
  
  public void BC(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Achs.R() != null)
    {
      r(true, true, paramBoolean);
      return;
    }
    long l = System.currentTimeMillis();
    coY();
    afsf.a().a(this.mApp, this.mApp.getCurrentAccountUin(), new zff(this, l, paramBoolean));
  }
  
  public void BD(boolean paramBoolean)
  {
    this.jdField_b_of_type_Achs.Fs(true);
    this.jdField_b_of_type_Achs.Fq(paramBoolean);
    this.jdField_b_of_type_Achs.cKB();
  }
  
  public void F(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      if (paramMessageRecord == null) {
        break label110;
      }
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr uniseq is:" + paramMessageRecord.uniseq + ",id is:" + paramMessageRecord.getId());
    }
    for (;;)
    {
      ausj localausj = (ausj)auss.a(getActivity(), null);
      localausj.setMainTitle(super.getString(2131698325));
      localausj.addButton(2131691404, 3);
      localausj.addCancelButton(2131721058);
      localausj.a(new zeu(this, paramMessageRecord, localausj));
      localausj.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void K(boolean paramBoolean, Object paramObject) {}
  
  public void P(MessageRecord paramMessageRecord)
  {
    achs localachs = (achs)this.mApp.getManager(92);
    if (paramMessageRecord != null)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(paramMessageRecord.time * 1000L);
      localCalendar1.set(11, 0);
      localCalendar1.set(12, 0);
      localCalendar1.set(13, 0);
      localCalendar1.set(14, 0);
      Calendar localCalendar2 = localachs.d();
      if ((localCalendar2 != null) && (!localCalendar1.after(localCalendar2))) {
        break label97;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.history.C2CAllFragment", 2, "search message's date beyond the dateline, should rebuild the dateline");
      }
    }
    return;
    label97:
    localachs.U(paramMessageRecord);
  }
  
  Calendar a(int paramInt)
  {
    Calendar localCalendar = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
    if (paramInt > 0) {
      localCalendar.add(5, paramInt / this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.vD());
    }
    return localCalendar;
  }
  
  Calendar a(int paramInt1, int paramInt2, Object paramObject)
  {
    Calendar localCalendar = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
    int i;
    int j;
    StringBuilder localStringBuilder;
    if (paramInt1 > 0)
    {
      i = paramInt1 / this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.vD();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a();
      if (paramObject.get(i))
      {
        localCalendar.add(5, i);
        return localCalendar;
      }
      if (paramInt2 <= 0) {
        break label247;
      }
      i += 1;
      j = i;
      if (i < this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.bLr)
      {
        if (!paramObject.get(i)) {
          break label238;
        }
        j = i;
      }
      i = j * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.vD();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("orientation=");
        if (paramInt2 <= 0) {
          break label284;
        }
      }
    }
    label284:
    for (paramObject = "left";; paramObject = "right")
    {
      QLog.d("Q.history.C2CAllFragment", 2, paramObject + ",idnex=" + j + ",old crollX=" + paramInt1 + ",expect crollX=" + i);
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.eQ(i, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localCalendar.add(5, j);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      return localCalendar;
      label238:
      i += 1;
      break;
      label247:
      i -= 1;
      for (;;)
      {
        j = i;
        if (i < 0) {
          break;
        }
        j = i;
        if (paramObject.get(i)) {
          break;
        }
        i -= 1;
      }
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public void a(achs.a parama) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.bml = true;
    paramView = (achs)this.mApp.getManager(92);
    paramListView = this.jdField_b_of_type_Wkl.k;
    if (paramListView != null)
    {
      Calendar localCalendar = paramView.c();
      if ((localCalendar != null) && (paramListView.get(1) == localCalendar.get(1)) && (paramListView.get(2) == localCalendar.get(2)) && (paramListView.get(5) == localCalendar.get(5)))
      {
        aL(2130840117, super.getString(2131696066));
        return false;
      }
      if (paramView.aaT()) {
        paramView.aG(paramListView.get(1), paramListView.get(2), paramListView.get(5));
      }
      for (;;)
      {
        VipUtils.a(this.mApp, "chat_history", "ChatHistory", "Slip_down", 0, 0, new String[] { "0", "0" });
        paramView.a(2, null, false);
        return false;
        paramView.g(paramListView);
      }
    }
    QLog.d("Q.history.C2CAllFragment", 1, "firstDay is null");
    paramView.a(2, null, false);
    return false;
  }
  
  public void aB(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    default: 
      if (i != 0) {
        cpd();
      }
      break;
    }
    label456:
    int j;
    do
    {
      return;
      paramMessage = (achs)this.mApp.getManager(92);
      if (((paramMessage.aaS()) && (paramMessage.AC() == 3)) || ((paramMessage.isFirstPage()) && (paramMessage.AC() == 2)) || ((paramMessage.isFirstPage()) && ((paramMessage.AC() == 0) || (paramMessage.AC() == 1))))
      {
        aL(2130840117, super.getString(2131694326));
        this.hI.setVisibility(8);
        this.footerView.setVisibility(8);
        i = 1;
      }
      for (;;)
      {
        coZ();
        break;
        if (paramMessage.AC() == 4)
        {
          this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.mEmptyView);
          this.jdField_b_of_type_Wkl.gg(this.ue);
          this.jdField_b_of_type_Wkl.notifyDataSetChanged();
          i = 1;
        }
        else if (this.bml)
        {
          paramMessage.cKD();
          i = 1;
        }
        else
        {
          localObject = this.mUIHandler.obtainMessage(33);
          ((Message)localObject).obj = paramMessage.b();
          this.mUIHandler.sendMessage((Message)localObject);
          i = 0;
        }
      }
      Object localObject = (List)paramMessage.obj;
      paramMessage = (achs)this.mApp.getManager(92);
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        if (((paramMessage.aaS()) && (paramMessage.AC() == 3)) || ((paramMessage.isFirstPage()) && (paramMessage.AC() == 2)) || ((paramMessage.isFirstPage()) && ((paramMessage.AC() == 0) || (paramMessage.AC() == 1))))
        {
          aL(2130840117, super.getString(2131694326));
          this.hI.setVisibility(8);
          this.footerView.setVisibility(8);
          break;
        }
        if (paramMessage.AC() == 4) {
          break label456;
        }
        if (this.bml)
        {
          paramMessage.cKD();
          break;
        }
        localObject = this.mUIHandler.obtainMessage(33);
        ((Message)localObject).obj = paramMessage.b();
        this.mUIHandler.sendMessage((Message)localObject);
        i = 0;
        break;
      }
      if (paramMessage.s != null) {
        d(paramMessage.b());
      }
      if (paramMessage.AC() == 4) {
        this.jdField_b_of_type_Wkl.gg(this.ue);
      }
      this.bml = false;
      coZ();
      if ((this.jdField_b_of_type_Wkl == null) || (localObject == null) || (((List)localObject).size() <= 0)) {
        break label623;
      }
      this.hI.setVisibility(8);
      this.footerView.setVisibility(8);
      this.hJ.setVisibility(8);
      j = this.jdField_b_of_type_Wkl.a((List)localObject, paramMessage.AC(), paramMessage.b(), paramMessage.t, this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.getSelectedItemPosition(), paramMessage.s);
    } while (paramMessage.AC() == 4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "setSelection ", Integer.valueOf(j), " indexOfClieckedItem", Integer.valueOf(this.jdField_b_of_type_Wkl.bFo) });
    }
    if (this.jdField_b_of_type_Wkl.bFo != -1) {
      this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_b_of_type_Wkl.bFo);
    }
    for (;;)
    {
      label623:
      this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.mEmptyView);
      if (!this.bqZ) {
        this.CE.setText(getString(2131718888));
      }
      paramMessage.cKE();
      break;
      if (j >= 1) {
        this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(j - 1);
      } else {
        this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(j);
      }
    }
  }
  
  public void aC(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 24: 
      BD(false);
      return;
    }
    paramMessage = this.mApp.getApp().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit();
    paramMessage.putLong("vip_message_roam_last_request_timestamp" + this.mApp.getCurrentAccountUin(), System.currentTimeMillis());
    paramMessage.commit();
    ((achs)this.mApp.getManager(92)).a(1, null, false);
  }
  
  public void aD(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        this.bqZ = true;
        cpd();
        paramMessage = (achs)this.mApp.getManager(92);
      } while (paramMessage.aaT() != true);
      paramMessage.a(1, null, false);
      return;
      c(null);
      return;
    } while (paramMessage.obj == null);
    c((Calendar)paramMessage.obj);
  }
  
  public void aE(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject2;
    label124:
    do
    {
      do
      {
        return;
        d(this.n);
        return;
        this.yC.setVisibility(8);
        return;
        paramMessage = a(paramMessage.arg1);
      } while (paramMessage == null);
      localObject1 = new StringBuilder();
      i = paramMessage.get(1);
      j = paramMessage.get(2) + 1;
      k = paramMessage.get(5);
      localObject2 = ((StringBuilder)localObject1).append(i).append("-");
      if (j > 9)
      {
        paramMessage = Integer.valueOf(j);
        localObject2 = ((StringBuilder)localObject2).append(paramMessage).append("-");
        if (k <= 9) {
          break label210;
        }
      }
      for (paramMessage = Integer.valueOf(k);; paramMessage = "0" + k)
      {
        ((StringBuilder)localObject2).append(paramMessage);
        this.MJ.setText(((StringBuilder)localObject1).toString());
        if (Vl()) {
          break;
        }
        this.yC.setVisibility(0);
        return;
        paramMessage = "0" + j;
        break label124;
      }
      localObject2 = a(paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    } while (localObject2 == null);
    label210:
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = ((Calendar)localObject2).get(1);
    int j = ((Calendar)localObject2).get(2) + 1;
    int k = ((Calendar)localObject2).get(5);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append("-");
    if (j > 9)
    {
      localObject1 = Integer.valueOf(j);
      label317:
      localStringBuilder2 = localStringBuilder2.append(localObject1).append("-");
      if (k <= 9) {
        break label493;
      }
    }
    label493:
    for (Object localObject1 = Integer.valueOf(k);; localObject1 = "0" + k)
    {
      localStringBuilder2.append(localObject1);
      this.MJ.setText(localStringBuilder1.toString());
      this.yC.setVisibility(0);
      localObject1 = this.jdField_b_of_type_Achs.b();
      if (((localObject1 == null) || (!((Calendar)localObject2).equals(localObject1))) && (!((Calendar)localObject2).equals(this.n))) {
        break label519;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "getForwardRoamHistoryByDate same day: " + localStringBuilder1.toString());
      }
      if (this.bqZ) {
        break;
      }
      this.CE.setText(getString(2131718888));
      return;
      localObject1 = "0" + j;
      break label317;
    }
    label519:
    localObject1 = this.mApp;
    if (paramMessage.arg2 > 0) {}
    for (paramMessage = "Slip_timelineleft";; paramMessage = "Slip_timelineright")
    {
      VipUtils.a((AppInterface)localObject1, "chat_history", "ChatHistory", paramMessage, 0, 0, new String[] { "0", "0" });
      this.jdField_b_of_type_Achs.a(5, (Calendar)localObject2, true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.history.C2CAllFragment", 2, "getForwardRoamHistoryByDate someday=" + localStringBuilder1.toString());
      return;
    }
  }
  
  public void aF(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      this.bmj = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "handleTimeLineRsp msg:", Integer.valueOf(paramMessage.what) });
      }
      return;
      if (paramMessage.arg1 == -1) {
        c(null);
      }
      for (;;)
      {
        cpc();
        break;
        aL(2130840117, super.getString(2131694325));
      }
      cpc();
      continue;
      Object localObject;
      if (Vl())
      {
        localObject = a(getActivity().getIntent());
        if (localObject != null) {
          P((MessageRecord)localObject);
        }
      }
      else
      {
        localObject = (achs)this.mApp.getManager(92);
        ((achs)localObject).a(0, null, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.mApp, ((achs)localObject).c(), ((achs)localObject).d(), false);
        d(((achs)localObject).b());
        continue;
        if (Vl())
        {
          localObject = a(getActivity().getIntent());
          if (localObject != null) {
            P((MessageRecord)localObject);
          }
        }
        else
        {
          localObject = (achs)this.mApp.getManager(92);
          if (((achs)localObject).aaR())
          {
            ((achs)localObject).a(1, null, false);
            ((achs)localObject).cKw();
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setDate(this.mApp, ((achs)localObject).c(), ((achs)localObject).d(), true);
            d(((achs)localObject).b());
            break;
            ((achs)localObject).a(0, null, false);
          }
          if (this.jdField_b_of_type_Achs.aaX()) {
            aL(2130840117, super.getString(2131694326));
          }
          coZ();
          this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.bGx();
          localObject = Calendar.getInstance();
          StringBuilder localStringBuilder1 = new StringBuilder();
          int i = ((Calendar)localObject).get(1);
          int j = ((Calendar)localObject).get(2) + 1;
          int k = ((Calendar)localObject).get(5);
          StringBuilder localStringBuilder2 = localStringBuilder1.append(i).append("-");
          if (j > 9)
          {
            localObject = Integer.valueOf(j);
            label427:
            localStringBuilder2 = localStringBuilder2.append(localObject).append("-");
            if (k <= 9) {
              break label561;
            }
          }
          label561:
          for (localObject = Integer.valueOf(k);; localObject = "0" + k)
          {
            localStringBuilder2.append(localObject);
            if (!Vl())
            {
              this.yC.setVisibility(0);
              this.MJ.setText(localStringBuilder1.toString());
              this.yC.invalidate();
            }
            this.mUIHandler.removeMessages(65538);
            this.mUIHandler.sendEmptyMessageDelayed(65538, 3000L);
            this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.mEmptyView);
            break;
            localObject = "0" + j;
            break label427;
          }
          this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.mEmptyView);
        }
      }
    }
  }
  
  public void aG(Message paramMessage)
  {
    achs localachs = (achs)this.mApp.getManager(92);
    Calendar localCalendar;
    long l;
    if (paramMessage.obj != null)
    {
      localCalendar = Calendar.getInstance();
      l = ((Long)paramMessage.obj).longValue();
      if (paramMessage.arg1 != 1) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 0)
    {
      localCalendar.setTimeInMillis(Long.valueOf(l).longValue() * 1000L);
      if (i == 0) {
        localachs.h(localCalendar);
      }
      switch (paramMessage.what)
      {
      case 5: 
      case 6: 
      case 7: 
      default: 
        return;
      }
    }
    localachs.cKA();
    return;
    if (paramMessage.arg1 == -1) {}
    for (;;)
    {
      localachs.cKA();
      return;
      paramMessage = localachs.b();
      if (paramMessage != null) {
        aL(2130840117, super.getString(2131694327, new Object[] { Integer.valueOf(paramMessage.get(2) + 1), Integer.valueOf(paramMessage.get(5)) }));
      }
    }
    localachs.cKA();
    return;
    coV();
    return;
    coZ();
    return;
    bJQ();
    aL(2130840095, super.getString(2131692508));
    getActivity().setResult(-1);
    getActivity().finish();
    return;
    bJQ();
    ((achs)this.mApp.getManager(92)).cKH();
    getActivity().setResult(-1);
    getActivity().finish();
  }
  
  void aL(int paramInt, String paramString)
  {
    QQToast.a(this.mApp.getApp(), paramInt, paramString, 0).show(getActivity().getTitleBarHeight());
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  void bJC()
  {
    this.ix = ((RelativeLayout)this.mRootView.findViewById(2131377786));
    if (Vl()) {
      this.ix.setVisibility(8);
    }
    this.ix.findViewById(2131363801).setVisibility(8);
    EditText localEditText = (EditText)this.ix.findViewById(2131366542);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.ix != null) && (Build.VERSION.SDK_INT > 10)) {
      this.ix.setLayerType(0, null);
    }
  }
  
  void bJQ()
  {
    try
    {
      if (this.u != null)
      {
        this.u.dismiss();
        this.u.cancel();
        this.u = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void bpM() {}
  
  protected void bpN() {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(Calendar paramCalendar)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
    this.vj.setVisibility(0);
    if (paramCalendar == null)
    {
      this.CE.setText(super.getString(2131718888));
      this.bqZ = false;
    }
    Object localObject;
    do
    {
      return;
      localObject = (achs)this.mApp.getManager(92);
      Calendar localCalendar = ((achs)localObject).c();
      localObject = ((achs)localObject).d();
      if ((localCalendar != null) && (paramCalendar.compareTo(localCalendar) < 0))
      {
        this.CE.setText(super.getString(2131696066));
        this.vj.setVisibility(8);
        return;
      }
      if ((localObject != null) && (paramCalendar.compareTo((Calendar)localObject) <= 0))
      {
        if (this.bqZ)
        {
          this.CE.setText(super.getString(2131694330, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
          this.vj.setVisibility(8);
          return;
        }
        this.CE.setText(super.getString(2131694331, new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) }));
        return;
      }
    } while ((localObject == null) || (paramCalendar.compareTo((Calendar)localObject) <= 0));
    cpd();
  }
  
  void coJ()
  {
    super.coJ();
    ChatHistoryC2CSettingFragment.d(getActivity(), this.mSessionInfo.aTl, this.mSessionInfo.cZ, 41);
  }
  
  public void coV()
  {
    QLog.d("Q.history.C2CAllFragment", 1, "gotoCheckPasswordUrl ! ");
    if (!this.brd)
    {
      this.jdField_b_of_type_Achs.Jv(1);
      Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "get_roam_msg"));
      getActivity().startActivityForResult(localIntent, 30);
      this.brd = true;
    }
  }
  
  public void coW()
  {
    if (getActivity() == null) {
      QLog.e("Q.history.C2CAllFragment", 2, "gotoCreatePasswordUrl activity is null");
    }
    while (this.brc) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, "gotoCreatePasswordUrl ! ");
    }
    this.jdField_b_of_type_Achs.Jv(0);
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/create.jsp?_wv=5123");
    getActivity().startActivityForResult(localIntent, 30);
    this.brc = true;
  }
  
  public void coZ()
  {
    bpm();
  }
  
  public void cpc()
  {
    coY();
    achs localachs = (achs)this.mApp.getManager(92);
    localachs.Fs(false);
    localachs.cKI();
  }
  
  public void cpd()
  {
    if (this.bqZ) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    }
  }
  
  void cpe()
  {
    if (this.aR == null) {
      this.aR = new zex(this);
    }
  }
  
  void d(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "scrollToRecentDay rencent is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a().getTimeInMillis();
      l2 = paramCalendar.getTimeInMillis();
      if (l2 >= l1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.history.C2CAllFragment", 2, "scrollToRecentDay rencent < begin, begin=" + l1 + ",recent=" + l2);
    return;
    int i;
    int j;
    StringBuilder localStringBuilder1;
    int k;
    StringBuilder localStringBuilder2;
    if (l2 == l1)
    {
      i = 0;
      j = i;
      if (i > this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.bEd) {
        j = this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.bEd;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "scrollToRecentDay scrollx: " + j + ", maxWidth: " + this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.bEd);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.eQ(j, this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.getScrollY());
      localStringBuilder1 = new StringBuilder();
      i = paramCalendar.get(1);
      j = paramCalendar.get(2) + 1;
      k = paramCalendar.get(5);
      localStringBuilder2 = localStringBuilder1.append(i).append("-");
      if (j <= 9) {
        break label355;
      }
      paramCalendar = Integer.valueOf(j);
      label240:
      localStringBuilder2 = localStringBuilder2.append(paramCalendar).append("-");
      if (k <= 9) {
        break label379;
      }
    }
    label355:
    label379:
    for (paramCalendar = Integer.valueOf(k);; paramCalendar = "0" + k)
    {
      localStringBuilder2.append(paramCalendar);
      if (!Vl())
      {
        this.yC.setVisibility(0);
        this.MJ.setText(localStringBuilder1.toString());
        this.yC.invalidate();
      }
      this.mUIHandler.removeMessages(65538);
      this.mUIHandler.sendEmptyMessageDelayed(65538, 3000L);
      return;
      i = (int)((l2 - l1) / 86400000L) * this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.vD();
      break;
      paramCalendar = "0" + j;
      break label240;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, "ChatHistoryC2CAllFragment, doOnActivityResult, resultCode = " + paramInt1);
    }
    switch (paramInt1)
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
            return;
            if (paramInt2 == 3000)
            {
              cpc();
              this.jdField_b_of_type_Achs.cKx();
            }
            this.brd = false;
            this.brc = false;
            coZ();
            return;
            paramInt1 = this.mApp.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.mApp.getCurrentAccountUin(), -1);
          } while (paramInt1 == this.cdn);
          if (paramInt1 > this.cdn) {
            BC(true);
          }
          for (;;)
          {
            this.cdn = paramInt1;
            return;
            if (paramInt1 < this.cdn) {
              BC(true);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.C2CAllFragment", 2, "switch auth mode result: " + paramInt2 + ", cur mode: " + this.jdField_b_of_type_Achs.getAuthMode());
          }
          BC(false);
          return;
        } while (-1 != paramInt2);
        ForwardUtils.a(this.mApp, paramIntent, getActivity());
        return;
        paramIntent = a(paramIntent);
      } while (paramIntent == null);
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, " ChatHistoryC2CAllFragment doOnActivityResult, startSearchMessage");
      }
      P(paramIntent);
      return;
    } while ((paramInt2 != -1) || (getActivity() == null) || (getActivity().isFinishing()));
    getActivity().finish();
  }
  
  public void doOnDestroy()
  {
    try
    {
      int j = this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
        if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof FlashPicItemBuilder.a)))
        {
          localObject = (FlashPicItemBuilder.a)((View)localObject).getTag();
          if (((FlashPicItemBuilder.a)localObject).a != null) {
            ((URLDrawable)((FlashPicItemBuilder.a)localObject).a.getDrawable()).setURLDrawableListener(null);
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.history.C2CAllFragment", 2, "", localException);
      }
      this.mUIHandler.removeCallbacksAndMessages(null);
      this.bK.removeCallbacksAndMessages(null);
      if (this.jdField_b_of_type_Achs != null)
      {
        this.jdField_b_of_type_Achs.cKO();
        this.jdField_b_of_type_Achs.iw(hashCode());
        this.jdField_b_of_type_Achs.c(this);
      }
      bJM();
      bJQ();
      if (this.mApp.a() != null)
      {
        this.mApp.a().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
        this.mApp.a().saveNotify();
      }
      this.mApp.removeObserver(this.jdField_a_of_type_Aobo);
      this.mApp.a().deleteObserver(this.jdField_d_of_type_Aghq);
      if (this.aR != null)
      {
        this.mApp.getApp().unregisterReceiver(this.aR);
        this.aR = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c(this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView);
      }
      this.jdField_b_of_type_Wkl.destroy();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 1, "doOnPause");
    }
    if (this.jdField_b_of_type_Achs != null) {
      this.jdField_b_of_type_Achs.c(this);
    }
    aavp localaavp = aavp.a();
    if ((localaavp.isSelected()) && (localaavp.Xy())) {
      localaavp.detach();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_b_of_type_Wkl, null);
    if (this.jdField_b_of_type_Wkl != null) {
      this.jdField_b_of_type_Wkl.notifyDataSetChanged();
    }
    ShortVideoItemBuilder.ceb();
    ShortVideoRealItemBuilder.ceb();
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 1, "doOnResume");
    }
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 1, 0, "", "", "", "");
    this.jdField_b_of_type_Achs.Ju(hashCode());
    this.jdField_b_of_type_Achs.b(this);
    cpa();
  }
  
  void gX()
  {
    achs localachs = (achs)this.mApp.getManager(92);
    this.jdField_b_of_type_Zli = new zli(getActivity(), this.mApp, this.mSessionInfo, localachs.abb());
    this.jdField_b_of_type_Zli.setOnDismissListener(new zfe(this));
    this.jdField_b_of_type_Zli.show();
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 1, 0, "", "", "", "");
  }
  
  public void k(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.mUIHandler != null)
    {
      Message localMessage = this.mUIHandler.obtainMessage(paramInt1);
      localMessage.obj = paramObject;
      localMessage.arg1 = paramInt2;
      this.mUIHandler.sendMessage(localMessage);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "onClick event unknow id: " + paramView.getId());
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = aqqj.getUrl("vipRoamChatBanner");
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        startActivity((Intent)localObject2);
        VipUtils.a(this.mApp, "vip", "0X8004F9C", "0X8004F9C", 0, 0, new String[] { this.vipType });
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("Q.history.C2CAllFragment", 2, "onClick blue tipe goUrl is null");
        continue;
        long l = System.currentTimeMillis();
        if (l - this.iu > 1000L)
        {
          this.iu = l;
          gX();
          anot.a(this.mApp, "CliOper", "", "", "0X8005FC1", "0X8005FC1", 0, 0, "", "", "", "");
          continue;
          localObject1 = (achs)this.mApp.getManager(92);
          localObject2 = this.jdField_b_of_type_Wkl.j;
          if (localObject2 != null)
          {
            if (((achs)localObject1).aaT()) {
              ((achs)localObject1).aG(((Calendar)localObject2).get(1), ((Calendar)localObject2).get(2), ((Calendar)localObject2).get(5));
            }
            for (;;)
            {
              Calendar localCalendar = ((achs)localObject1).d();
              if ((localCalendar == null) || (((Calendar)localObject2).get(1) != localCalendar.get(1)) || (((Calendar)localObject2).get(2) != localCalendar.get(2)) || (((Calendar)localObject2).get(5) != localCalendar.get(5))) {
                break label397;
              }
              this.footerView.setVisibility(8);
              this.hI.setVisibility(8);
              this.hJ.setVisibility(8);
              break;
              ((achs)localObject1).g((Calendar)localObject2);
            }
          }
          label397:
          this.bml = true;
          ((achs)localObject1).a(3, null, false);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558945, paramViewGroup, false);
    this.mRootView = paramLayoutInflater;
    this.mSessionInfo = new SessionInfo();
    paramViewGroup = getActivity().getIntent().getExtras();
    this.mSessionInfo.aTl = paramViewGroup.getString("uin");
    this.mSessionInfo.cZ = paramViewGroup.getInt("uintype");
    this.mSessionInfo.troopUin = paramViewGroup.getString("troop_uin");
    this.mSessionInfo.a = new wkj();
    this.mSessionInfo.cN = ChatTextSizeSettingActivity.ag(getActivity());
    paramViewGroup = (DispatchTouchEventRelativeLayout)this.mRootView.findViewById(2131377546);
    paramViewGroup.setOnDispatchListener(new zfc(this));
    if (this.mApp == null)
    {
      QLog.e("Q.history.C2CAllFragment", 1, "app is null");
      getActivity().finish();
      paramLayoutInflater = null;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (wkj.a(BaseApplicationImpl.getContext(), this.mApp.getCurrentAccountUin(), this.mSessionInfo.aTl, true, 0, this.mSessionInfo.a)) {
        paramViewGroup.setBackgroundDrawable(this.mSessionInfo.a.img);
      }
      this.mUIHandler = new aurf(Looper.getMainLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.mApp.getManager(24));
      this.jdField_b_of_type_Achs = ((achs)this.mApp.getManager(92));
      this.jdField_b_of_type_Achs.init(this.mSessionInfo.aTl);
      this.n = Calendar.getInstance();
      this.p = Calendar.getInstance();
      this.o = Calendar.getInstance();
      this.o.setTimeInMillis(0L);
      initTitle();
      cpb();
      xm();
      if (this.mApp.a() != null)
      {
        this.mApp.a().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
        this.mApp.a().saveNotify();
      }
      this.mApp.addObserver(this.jdField_a_of_type_Aobo);
      this.mApp.a().addObserver(this.jdField_d_of_type_Aghq);
      this.jdField_b_of_type_Achs.cKN();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ShortVideoPTVItemBuilder.r(this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    ShortVideoItemBuilder.cea();
    ShortVideoRealItemBuilder.cea();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAbsListView == null) {
      return;
    }
    Object localObject2;
    if ((paramInt2 == paramInt3) && (paramInt3 != 0) && (paramInt1 == 0) && (paramAbsListView.getChildCount() > 0) && (this.hI != null) && (this.hI.getVisibility() != 0))
    {
      localObject1 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - 1);
      if (localObject1 != null) {
        break label405;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        this.p.setTimeInMillis(((ChatMessage)localObject1).time * 1000L);
        localObject1 = (achs)this.mApp.getManager(92);
        localObject2 = ((achs)localObject1).d();
        if ((localObject2 != null) && (this.p.get(1) <= ((Calendar)localObject2).get(1)) && (this.p.get(2) <= ((Calendar)localObject2).get(2)) && (this.p.get(5) < ((Calendar)localObject2).get(5)))
        {
          this.footerView.setVisibility(0);
          this.hJ.setVisibility(0);
        }
        if (((achs)localObject1).aaS())
        {
          this.footerView.setVisibility(8);
          this.hJ.setVisibility(8);
        }
      }
    }
    Object localObject1 = paramAbsListView.getChildAt(0);
    if (localObject1 == null)
    {
      localObject1 = null;
      label219:
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = paramAbsListView.getChildAt(3);
        if (localObject1 != null) {
          break label437;
        }
        localObject2 = null;
      }
      label243:
      if (localObject2 != null)
      {
        this.n.setTimeInMillis(((ChatMessage)localObject2).time * 1000L);
        this.n.set(11, 0);
        this.n.set(12, 0);
        this.n.set(13, 0);
        this.n.set(14, 0);
        if (!this.n.equals(this.o))
        {
          this.o.setTimeInMillis(this.n.getTimeInMillis());
          this.mUIHandler.sendEmptyMessageDelayed(65537, 100L);
        }
      }
      if (this.Hy >= paramInt1) {
        break label453;
      }
      ey(this.rK);
    }
    for (;;)
    {
      this.Hy = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.bEz = (paramInt1 + paramInt2 - 1);
      }
      this.rK = paramAbsListView.getChildAt(0);
      this.rL = paramAbsListView.getChildAt(paramInt2 - 1);
      return;
      label405:
      localObject1 = (ChatMessage)((View)localObject1).getTag(2131364516);
      break;
      localObject1 = (ChatMessage)((View)localObject1).getTag(2131364516);
      break label219;
      label437:
      localObject2 = (ChatMessage)((View)localObject1).getTag(2131364516);
      break label243;
      label453:
      if ((paramInt1 + paramInt2 - 1 > 0) && (paramInt1 + paramInt2 - 1 < this.bEz)) {
        ey(this.rL);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      ShortVideoItemBuilder.ceb();
      ShortVideoRealItemBuilder.ceb();
      this.jdField_a_of_type_Aavw.Ck(16);
    }
    int i;
    int j;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Aavw.Ck(14);
        AbstractGifImage.pauseAll();
        ShortVideoItemBuilder.cea();
        ShortVideoRealItemBuilder.cea();
      } while ((paramAbsListView == null) || (this.jdField_b_of_type_Wkl == null));
      paramInt = paramAbsListView.getLastVisiblePosition();
      i = paramAbsListView.getCount();
      j = paramAbsListView.getFirstVisiblePosition();
    } while ((paramInt != i - 1) || (i == 0) || (j == 0) || (this.bml));
    QLog.d("Q.history.C2CAllFragment", 2, "onScrollStateChanged .... querying querying : ");
    paramAbsListView = (achs)this.mApp.getManager(92);
    Calendar localCalendar1 = this.jdField_b_of_type_Wkl.j;
    if (localCalendar1 != null)
    {
      Calendar localCalendar2 = paramAbsListView.d();
      if ((localCalendar2 != null) && (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5)))
      {
        this.footerView.setVisibility(8);
        this.hI.setVisibility(8);
        this.hJ.setVisibility(8);
        return;
      }
      if (!paramAbsListView.aaT()) {
        break label312;
      }
      paramAbsListView.aG(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5));
    }
    for (;;)
    {
      this.footerView.setVisibility(0);
      this.hI.setVisibility(0);
      this.hJ.setVisibility(8);
      this.bml = true;
      VipUtils.a(this.mApp, "chat_history", "ChatHistory", "Slip_up", 0, 0, new String[] { "0", "0" });
      paramAbsListView.a(3, null, false);
      return;
      label312:
      paramAbsListView.g(localCalendar1);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = this.mRootView.findViewById(2131377546);
    if ((paramView != null) && (this.mApp != null) && (wkj.a(BaseApplicationImpl.getContext(), this.mApp.getCurrentAccountUin(), this.mSessionInfo.aTl, true, 0, this.mSessionInfo.a))) {
      paramView.setBackgroundDrawable(this.mSessionInfo.a.img);
    }
  }
  
  public void r(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = this.jdField_b_of_type_Achs.getAuthMode();
    boolean bool = this.jdField_b_of_type_Achs.aaW();
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_Achs.R();
      localObject2 = new StringBuilder().append("mode: ").append(j).append(", isSetPasswd: ").append(bool).append(", refreshTimeLine: ").append(paramBoolean3).append(", devSetup: ").append(paramBoolean1).append(", allowSet: ").append(paramBoolean2).append(", da2 length: ");
      if (localObject1 == null)
      {
        i = 0;
        QLog.d("Q.history.C2CAllFragment", 2, i);
      }
    }
    else
    {
      if (getActivity() != null) {
        break label149;
      }
      QLog.e("Q.history.C2CAllFragment", 2, "checkAuthMode activity is null");
    }
    label149:
    do
    {
      return;
      i = localObject1.length;
      break;
      if (j != 0) {
        break label325;
      }
      if ((!paramBoolean1) && (!this.jdField_b_of_type_Achs.aaZ()))
      {
        a(super.getString(2131698594), super.getString(2131698597), 2130845985, super.getString(2131698592), super.getString(2131698593), "", true);
        this.jdField_b_of_type_Achs.Ft(true);
        VipUtils.a(this.mApp, "chat_history", "LockSet", "Visit_lockTuiguang", 1, 0, new String[0]);
        return;
      }
      if ((!paramBoolean1) || (this.jdField_b_of_type_Achs.aaZ())) {
        break label309;
      }
      if (!this.brb) {
        break label273;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.history.C2CAllFragment", 1, "already open dev");
    return;
    label273:
    this.jdField_b_of_type_Achs.Ft(true);
    ChatHistoryAuthDevForRoamMsgFragment.n(getActivity(), 32);
    getActivity().overridePendingTransition(2130771991, 2130771989);
    this.brb = true;
    return;
    label309:
    if (!bool)
    {
      coW();
      return;
    }
    BD(paramBoolean3);
    return;
    label325:
    if (paramBoolean1)
    {
      if (this.jdField_b_of_type_Achs.R() != null)
      {
        BD(paramBoolean3);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.history.C2CAllFragment", 2, "devlock is open but no da2 ticket， refresh da2...");
      }
      localObject1 = (AccountManager)this.mApp.getManager(0);
      if (localObject1 != null)
      {
        coY();
        ((AccountManager)localObject1).refreshDA2(this.mApp.getCurrentAccountUin(), new zfg(this, paramBoolean3));
        return;
      }
      cpc();
      return;
    }
    if (paramBoolean2) {
      localObject1 = super.getString(2131698596);
    }
    for (Object localObject2 = super.getString(2131698591);; localObject2 = super.getString(2131698590))
    {
      a(super.getString(2131698594), (String)localObject1, 2130845985, (String)localObject2, "", "", false);
      VipUtils.a(this.mApp, "chat_history", "LockSet", "Visit_lockReadReopen", 1, 0, new String[0]);
      return;
      localObject1 = super.getString(2131698595);
    }
  }
  
  public void vk(String paramString)
  {
    if (this.mToast == null) {
      this.mToast = Toast.makeText(getActivity(), paramString, 0);
    }
    for (;;)
    {
      this.mToast.show();
      return;
      this.mToast.setText(paramString);
    }
  }
  
  void xm()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer = ((ChatHistoryTimeLineContainer)this.mRootView.findViewById(2131381210));
    if (Vl()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView = ((AutoFitScrollView)this.mRootView.findViewById(2131377766));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView = ((TimeLineView)this.mRootView.findViewById(2131379701));
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setPressed(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistoryTimeLineContainer.setScrollView(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView);
    this.mDisplayMetrics = super.getResources().getDisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setFitWidth(this.mDisplayMetrics.widthPixels, this.jdField_a_of_type_ComTencentMobileqqActivityTimeLineView.vD());
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setCallback(this.mUIHandler);
    this.yC = this.mRootView.findViewById(2131381209);
    this.MJ = ((TextView)this.mRootView.findViewById(2131381208));
    if (Vl())
    {
      this.yC.setVisibility(8);
      this.MJ.setVisibility(8);
    }
  }
  
  protected int yg()
  {
    if (Vl()) {
      return 1600;
    }
    return 1601;
  }
  
  static class a
    implements DialogInterface.OnCancelListener
  {
    private final WeakReference<ChatHistoryC2CAllFragment> mHost;
    
    a(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment)
    {
      this.mHost = new WeakReference(paramChatHistoryC2CAllFragment);
    }
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      ChatHistoryC2CAllFragment localChatHistoryC2CAllFragment = (ChatHistoryC2CAllFragment)this.mHost.get();
      if ((localChatHistoryC2CAllFragment != null) && (localChatHistoryC2CAllFragment.getActivity() != null) && (!localChatHistoryC2CAllFragment.getActivity().isFinishing())) {
        paramDialogInterface.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment
 * JD-Core Version:    0.7.0.1
 */