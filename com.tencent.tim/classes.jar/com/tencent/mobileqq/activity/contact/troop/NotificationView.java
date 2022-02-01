package com.tencent.mobileqq.activity.contact.troop;

import acbn;
import acdu;
import acff;
import acfp;
import achq;
import ackn;
import acrp;
import aizr;
import ajdr;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anze;
import aprz;
import apuh;
import aqdf;
import aqdf.a;
import aqfr;
import aqgv;
import aqiw;
import arhz;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import tog;
import yru;
import ywa;
import ywa.a;
import ywc;
import ywd;
import ywe;
import ywf;
import ywg;
import ywh;
import ywi;
import ywj;
import yxe;
import yxe.a;
import yym;

public class NotificationView
  extends BaseTroopView
  implements View.OnClickListener, aqdf.a, SlideDetectListView.a, AbsListView.e, yru
{
  protected static int cby = 1;
  protected static long lastClickTime;
  public arhz J;
  public final long KP = 1000L;
  public final long KQ = 500L;
  private TextView Ma;
  public Context P;
  public yxe.a a = new ywj(this);
  achq b;
  protected ajdr b;
  public ywa b;
  public boolean bpk;
  protected aqdf d;
  protected View.OnClickListener ep = new ywd(this);
  protected View.OnClickListener eq = new ywh(this);
  private boolean firstResume;
  public MqqHandler g = new ywc(this);
  protected SlideDetectListView h;
  protected boolean isFinished;
  protected int mCurrentScrollState = 0;
  public List<MessageRecord> mDataList = new ArrayList();
  protected int mLastVisibleIndex;
  protected View mLoadingView;
  protected View.OnTouchListener u = new ywf(this);
  public View yk;
  private View yl;
  private View ym;
  
  public NotificationView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Achq = new ywe(this);
    this.P = paramContext;
  }
  
  private void Ad()
  {
    setContentView(2131560106);
    this.h = ((SlideDetectListView)findViewById(2131374290));
    this.yk = findViewById(2131374286);
    cmr();
    cms();
    this.d = new aqdf(getContext(), this.app);
    this.d.a(this);
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    aprz.a(this.app, paramLong, new ywi(this), localBundle);
  }
  
  private void a(XListView paramXListView, String paramString, Bitmap paramBitmap)
  {
    ywa.a locala;
    String str;
    if (this.mCurrentScrollState == 0)
    {
      int j = paramXListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        locala = (ywa.a)paramXListView.getChildAt(i).getTag();
        if (locala == null) {
          i += 1;
        } else {
          switch (yxe.fx(locala.bDQ))
          {
          default: 
            str = String.valueOf(locala.a.msg.group_code.get());
          }
        }
      }
    }
    while ((locala != null) && (paramString.equals(str)))
    {
      locala.uw.setImageBitmap(paramBitmap);
      return;
      str = locala.senderUin;
      continue;
      str = String.valueOf(locala.a.msg.action_uin.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      anze.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      anze.a().lC(l);
      anze.a().lB(paramLong);
    }
  }
  
  private void a(ywa.a parama, String paramString, List<structmsg.SystemMsgAction> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if ((paramString == null) || ("".equals(paramString))) {
        if (paramList.size() > 1)
        {
          parama.ej.setText(((structmsg.SystemMsgAction)paramList.get(1)).name.get());
          parama.ej.setTextAppearance(this.P, 2131755597);
          parama.ej.setBackgroundResource(2130839559);
        }
      }
      for (;;)
      {
        parama.ej.setContentDescription(parama.ej.getText() + "");
        parama.ej.setTag(parama);
        parama.ej.setOnClickListener(this.eq);
        return;
        parama.ej.setText("");
        continue;
        parama.ej.setText(((structmsg.SystemMsgAction)paramList.get(0)).name.get());
        parama.ej.setTextAppearance(this.P, 2131755596);
        parama.ej.setBackgroundResource(2130839558);
      }
    }
    parama.ej.setText("");
    parama.ej.setBackgroundDrawable(null);
  }
  
  private void a(ywa.a parama, structmsg.StructMsg paramStructMsg)
  {
    if ((parama == null) || (paramStructMsg == null)) {
      return;
    }
    if ((parama.bDQ == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        parama.LW.setText(paramStructMsg);
        return;
        paramStructMsg = paramStructMsg.msg.action_uin_nick.get();
        continue;
        Object localObject = (TroopManager)this.app.getManager(52);
        if (localObject == null) {
          break;
        }
        String str2 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
        String str3 = String.valueOf(paramStructMsg.msg.action_uin.get());
        paramStructMsg = ((TroopManager)localObject).jr(str2);
        str1 = aqgv.a(this.app, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).getTroopMemberName(str2, str3);
          continue;
          localObject = (acdu)this.app.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((acdu)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (yxe.fx(parama.bDQ))
    {
    default: 
      parama.LW.setText(parama.nickname);
      return;
    case 0: 
      parama.LW.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      parama.LW.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    parama.LW.setText(parama.nickname);
  }
  
  private void a(ywa.a parama, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (parama.bDQ == 80)
    {
      paramStructMsg = paramStructMsg.msg.actions.get();
      parama.ej.setClickable(true);
      parama.ej.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
      parama.ej.setTextAppearance(this.P, 2131755597);
      parama.ej.setBackgroundResource(2130839559);
      parama.ej.setContentDescription(parama.ej.getText() + "");
      parama.ej.setTag(parama);
      parama.ej.setOnClickListener(this.eq);
    }
    while (TextUtils.isEmpty(parama.ej.getText()))
    {
      parama.ej.setVisibility(8);
      return;
      if (paramInt == 1)
      {
        paramStructMsg = paramStructMsg.msg.actions.get();
        parama.ej.setClickable(true);
        a(parama, paramString, paramStructMsg);
      }
      else
      {
        parama.ej.setBackgroundDrawable(null);
        parama.ej.setClickable(false);
        parama.ej.setTextAppearance(this.P, 2131756687);
        parama.ej.setText(paramStructMsg.msg.msg_decided.get());
        paramStructMsg = (RelativeLayout.LayoutParams)parama.ej.getLayoutParams();
      }
    }
    parama.ej.setVisibility(0);
  }
  
  private void a(ywa.a parama, structmsg.StructMsg paramStructMsg, String paramString)
  {
    parama.LY.setTextAppearance(this.P, 2131756688);
    parama.LY.setTextColor(Color.parseColor("#a6a6a6"));
    Object localObject;
    if (parama.bDQ == 11)
    {
      localObject = paramStructMsg.msg.msg_additional.get();
      paramString = (String)localObject;
      if (((String)localObject).length() > 15) {
        paramString = ((String)localObject).subSequence(0, 15) + "...";
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramStructMsg.msg.pic_url.has()) {
        if (TextUtils.isEmpty(paramString)) {
          break label358;
        }
      }
      label358:
      for (localObject = acfp.m(2131709159) + paramString;; localObject = acfp.m(2131709149))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label369;
        }
        parama.LY.setSingleLine(true);
        parama.LY.setText((CharSequence)localObject);
        parama.LY.setVisibility(0);
        return;
        localObject = new ArrayList();
        if ((parama.bDQ == 1) || (parama.bDQ == 22)) {
          ((List)localObject).add(paramString);
        }
        ((List)localObject).add(paramStructMsg.msg.msg_qna.get());
        ((List)localObject).add(paramStructMsg.msg.msg_actor_describe.get());
        ((List)localObject).add(paramStructMsg.msg.msg_additional_list.get());
        ((List)localObject).add(paramStructMsg.msg.msg_additional.get());
        if ((parama.bDQ == 12) || (parama.bDQ == 83)) {
          ((List)localObject).add(paramStructMsg.msg.msg_detail.get());
        }
        localObject = ((List)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramString = (String)((Iterator)localObject).next();
        } while ((paramString == null) || (paramString.isEmpty()));
        break;
      }
      label369:
      parama.LY.setVisibility(8);
      return;
      paramString = "";
    }
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int k;
    int m;
    if (paramStructMsg != null)
    {
      int i = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int j = paramStructMsg.msg.sub_type.get();
      k = paramStructMsg.msg.src_id.get();
      m = paramStructMsg.msg.sub_src_id.get();
      int n = paramStructMsg.msg.group_msg_type.get();
      List localList = paramStructMsg.msg.actions.get();
      if ((localList == null) || (paramInt >= localList.size())) {
        break label220;
      }
      this.app.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
    }
    label220:
    for (bool = true;; bool = false)
    {
      if ((k == 116) && (m == 0)) {
        anot.a(this.app, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private void aMG()
  {
    if (this.bpk) {}
    do
    {
      do
      {
        return;
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(this.P, this.P.getResources().getString(2131693404), 0).show(getTitleBarHeight());
          return;
        }
      } while ((this.jdField_b_of_type_Ajdr != null) && (this.jdField_b_of_type_Ajdr.aqu()));
      this.bpk = true;
      this.mLoadingView.setVisibility(0);
      this.app.a().a().cOi();
    } while (!QLog.isColorLevel());
    QLog.i("NotificationView", 2, "loadNextPage.get next page.");
  }
  
  private void addObserver()
  {
    addObserver(this.jdField_b_of_type_Achq);
  }
  
  private void b(ywa.a parama)
  {
    int i = 1;
    if (parama == null) {
      return;
    }
    Object localObject;
    String str;
    switch (yxe.fx(parama.bDQ))
    {
    default: 
      localObject = String.valueOf(parama.a.msg.group_code.get());
      i = 4;
      str = parama.a.msg.group_name.get() + this.P.getString(2131698750);
    }
    for (;;)
    {
      localObject = yxe.a(this.d, (String)localObject, i);
      parama.uw.setContentDescription(str);
      parama.uw.setImageDrawable((Drawable)localObject);
      return;
      localObject = parama.senderUin;
      str = parama.a.msg.req_uin_nick.get() + this.P.getString(2131698749);
      continue;
      localObject = String.valueOf(parama.a.msg.action_uin.get());
      str = parama.a.msg.action_uin_nick.get() + this.P.getString(2131698748);
    }
  }
  
  private void b(ywa.a parama, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "jumpToTroopRequestActivity!" + parama._id + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", parama._id);
    localBundle.putInt("mTroopMsgType", parama.bDQ);
    localBundle.putString("mTroopCode", String.valueOf(parama.a.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(parama.a.msg.action_uin.get()));
    localBundle.putString("troopsMsg", parama.a.msg.msg_additional.get());
    if (parama.mPosition < this.jdField_b_of_type_Ywa.unreadMsgNum) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(parama.a.req_uin.get()));
      localBundle.putString("troopsummary", parama.a.msg.msg_describe.get());
      localBundle.putLong("infotime", parama.KO);
      if ((getActivity() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", f((ArrayList)((TroopActivity)getActivity()).tw, String.valueOf(parama.a.msg.action_uin.get())));
      }
      if (parama.a.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", parama.a.msg.msg_detail.get());
      }
      a((structmsg.StructMsg)parama.a.get(), parama.uniseq);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      startActivity(localIntent);
      return;
    }
  }
  
  private void b(ywa.a parama, structmsg.StructMsg paramStructMsg, String paramString)
  {
    acdu localacdu = (acdu)this.app.getManager(53);
    String str = paramString;
    if (localacdu != null)
    {
      paramStructMsg = localacdu.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
      str = paramString;
      if (paramStructMsg != null) {
        str = paramStructMsg.discussionName;
      }
    }
    parama.LY.setText(acfp.m(2131709147) + str);
    parama.LY.setVisibility(0);
  }
  
  private void c(ywa.a parama, structmsg.StructMsg paramStructMsg, String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager != null) {
      paramString = localTroopManager.jo(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
    }
    parama.LY.setText(acfp.m(2131709158) + paramString);
    parama.LY.setVisibility(0);
  }
  
  private void cmr()
  {
    if (this.yl == null) {
      this.yl = LayoutInflater.from(this.P).inflate(2131561724, null);
    }
    this.ym = this.yl.findViewById(2131379025);
    this.ym.setOnClickListener(this);
    if (ThemeUtil.isDefaultTheme()) {
      this.ym.setBackgroundResource(2130839642);
    }
    for (;;)
    {
      this.Ma = ((TextView)this.yl.findViewById(2131379026));
      if (this.h != null)
      {
        AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
        this.yl.setLayoutParams(localLayoutParams);
        this.h.addHeaderView(this.yl);
      }
      int i = anze.a().ag(this.app);
      if (i <= 0) {
        break;
      }
      this.Ma.setText(i + "");
      return;
      this.ym.setBackgroundResource(2130839639);
    }
    this.Ma.setText("");
  }
  
  private void cms()
  {
    if (this.mLoadingView == null) {
      this.mLoadingView = LayoutInflater.from(this.P).inflate(2131561721, null);
    }
    if (this.mLoadingView.getParent() == null) {
      this.h.addFooterView(this.mLoadingView);
    }
    this.mLoadingView.setVisibility(8);
  }
  
  private void cmt()
  {
    ThreadManager.post(new NotificationView.5(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "sendReadConfirm is end!");
    }
  }
  
  private void cmv()
  {
    boolean bool;
    if ((yym.UP()) && (yym.H(this.app)))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "needRefresh =" + bool);
      }
      if (!bool) {
        break label189;
      }
      if (this.ym != null) {
        this.ym.setVisibility(0);
      }
      if (this.Ma != null)
      {
        i = anze.a().ag(this.app);
        if (QLog.isColorLevel()) {
          QLog.d("NotificationView", 2, "refreshTroopSuspiciousDisplay num =" + i);
        }
        if (i <= 0) {
          break label176;
        }
        this.Ma.setText(i + "");
      }
      aqfr.b("Grp_contacts_news", "notice", "unnormal_exp", 0, 0, new String[0]);
    }
    label176:
    label189:
    while (this.ym == null) {
      for (;;)
      {
        int i;
        return;
        bool = false;
        break;
        this.Ma.setText("");
      }
    }
    this.ym.setVisibility(8);
  }
  
  private boolean f(List<Stranger> paramList, String paramString)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (!TextUtils.equals(((Stranger)paramList.next()).uin, paramString));
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "checkInviteeIsFriend stranger list is empty ");
    }
    return false;
  }
  
  private void initListData()
  {
    int i = ((ackn)this.app.getManager(22)).cxG;
    this.jdField_b_of_type_Ywa = new ywa(this.P, this.app, this, i, this.h);
    this.mDataList = this.app.b().k(acbn.bkK, 0);
    TroopNotifyAndRecommendView.setAndCheckNotifyFollowSeq(this.mDataList, this.app);
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < this.mDataList.size())
    {
      localArrayList.add(this.mDataList.get(this.mDataList.size() - i - 1));
      i += 1;
    }
    this.mDataList = localArrayList;
    this.h.setAdapter(this.jdField_b_of_type_Ywa);
    this.h.setDividerHeight(1);
    if ((this.mDataList != null) && (this.mDataList.size() > 0) && (!(this.mDataList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "initListData error");
      }
      this.app.cLI();
      this.jdField_b_of_type_Ywa.setData(null);
      return;
    }
    this.jdField_b_of_type_Ywa.setData(this.mDataList);
    clB();
  }
  
  private void removeObserver()
  {
    removeObserver(this.jdField_b_of_type_Achq);
  }
  
  private void showRedDot(boolean paramBoolean)
  {
    aJ(0, paramBoolean);
  }
  
  private void stopLoadMore()
  {
    if (this.mLoadingView != null) {
      this.mLoadingView.setVisibility(8);
    }
    this.bpk = false;
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "stopLoadMore().");
    }
  }
  
  protected void a(Intent paramIntent, BaseTroopView.a parama)
  {
    super.a(paramIntent, parama);
    addObserver();
    Ad();
    initListData();
    this.jdField_b_of_type_Ajdr = ((ajdr)this.app.getManager(37));
    this.h.setOnTouchListener(this.u);
    this.h.setOnScrollToTopListener(this);
    this.J = new arhz(this.P, getTitleBarHeight());
    this.app.setHandler(getClass(), this.g);
    if (yxe.v(this.app) > 0) {
      this.app.a().a().Kg(3);
    }
    yxe.bk(this.app);
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    ywa.a locala = (ywa.a)paramView.getTag();
    if ((locala != null) && ((locala instanceof ywa.a)))
    {
      paramView = (ShaderAnimLayout)paramView.findViewById(2131380367);
      if (paramView != null) {
        break label38;
      }
    }
    label38:
    Button localButton;
    do
    {
      return;
      localButton = (Button)paramView.findViewById(2131380366);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramView.show();
    localButton.setTag(locala);
  }
  
  public void a(ywa.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "handleGroupSystemMsg! start " + parama._id);
    }
    b(parama, 998);
    Object localObject = parama.a.msg.group_info.msg_alert.get();
    String str4 = parama.a.msg.group_code.get() + "";
    String str2;
    int i;
    label141:
    String str1;
    if (parama.mPosition < this.jdField_b_of_type_Ywa.unreadMsgNum)
    {
      str2 = "1";
      i = parama.a.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label307;
      }
      i = 0;
      switch (parama.bDQ)
      {
      case 4: 
      case 5: 
      case 8: 
      case 9: 
      case 14: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      default: 
        parama = "";
        localObject = "";
        str1 = "";
      }
    }
    for (;;)
    {
      aqfr.b("Grp_contacts_news", "notice", str1, 3, 0, new String[] { str4, str2, localObject, parama });
      return;
      str2 = "0";
      break;
      label307:
      i = 1;
      break label141;
      str1 = "enter_askjoin";
      if ((localObject == null) || ("".equals(localObject))) {}
      for (localObject = "1";; localObject = "0")
      {
        if (parama.a.msg.sub_type.get() != 1) {
          break label370;
        }
        parama = "0";
        break;
      }
      label370:
      long l = parama.a.msg.actor_uin.get();
      if ((l != 0L) && (!(l + "").equals(this.app.getCurrentAccountUin()))) {}
      for (parama = "2";; parama = "1") {
        break;
      }
      parama = "";
      localObject = "";
      str1 = "refuseask_page";
      continue;
      if (parama.a.msg.sub_type.get() == 1) {}
      for (parama = "0";; parama = "1")
      {
        localObject = "";
        str1 = "enter_invite";
        break;
      }
      if (i != 0) {}
      String str3;
      for (parama = "0";; parama = "1")
      {
        str1 = "refuseinvite_page";
        str3 = "";
        localObject = parama;
        parama = str3;
        break;
      }
      if (i != 0) {}
      for (parama = "0";; parama = "1")
      {
        str1 = "refuseagree_page";
        str3 = "";
        localObject = parama;
        parama = str3;
        break;
      }
      parama = "";
      localObject = "";
      str1 = "quit_page";
      continue;
      str1 = "byquit_page";
      parama = "";
      localObject = "0";
      continue;
      str1 = "byquit_page";
      parama = "";
      localObject = "1";
      continue;
      if ((parama.a.req_uin.get() + "").equals(this.app.getCurrentAccountUin())) {}
      for (parama = "0";; parama = "1")
      {
        str1 = "set_admin_page";
        str3 = "";
        localObject = parama;
        parama = str3;
        break;
      }
      str1 = "un_admin_page";
      parama = "";
      localObject = "0";
      continue;
      str1 = "un_admin_page";
      parama = "";
      localObject = "1";
    }
  }
  
  public void a(ywa.a parama, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "bindTroopSystemMsgView! start " + parama._id);
    }
    structmsg.StructMsg localStructMsg = parama.a;
    parama._id = paramInt;
    parama.senderUin = (localStructMsg.req_uin.get() + "");
    parama.bDQ = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    parama.KO = localStructMsg.msg_time.get();
    parama.nickname = localStructMsg.msg.req_uin_nick.get();
    String str;
    Object localObject;
    if ((parama.nickname != null) && (!parama.nickname.equals("")))
    {
      a(parama, localStructMsg);
      parama.uF.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      a(parama, localStructMsg, str);
      if (parama.bDQ != 22) {
        break label465;
      }
      localObject = localStructMsg.msg;
      parama.LY.setVisibility(0);
      SpannableString localSpannableString = new SpannableString(this.app.getApp().getString(2131720695, new Object[] { ((structmsg.SystemMsg)localObject).action_uin_nick.get() }));
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, ((structmsg.SystemMsg)localObject).action_uin_nick.get().length() + 6, 33);
      parama.LY.setText(localSpannableString);
      parama.LY.setOnClickListener(new ywg(this, (structmsg.SystemMsg)localObject));
      label307:
      localObject = apuh.a(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (localObject == null) {
        break label555;
      }
      parama.LX.setText((CharSequence)localObject);
    }
    for (;;)
    {
      a(parama, localStructMsg, paramInt, str);
      if ((paramInt == 2) && (parama.bDQ == 2) && (((TroopManager)this.app.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        aizr.a().n(String.valueOf(localStructMsg.msg.group_code.get()), this.app);
      }
      parama.hC.setTag(parama);
      parama.hC.setOnClickListener(this.ep);
      parama.uw.setTag(parama);
      parama.uw.setOnClickListener(this);
      b(parama);
      return;
      parama.nickname = parama.senderUin;
      break;
      label465:
      if ((parama.bDQ != 2) || (!localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has())) {
        break label307;
      }
      switch (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      case 0: 
      default: 
        break;
      case 1: 
        c(parama, localStructMsg, "");
        break;
      case 2: 
        b(parama, localStructMsg, "");
        break;
        label555:
        localObject = localStructMsg.msg.msg_additional.get();
        if ((localObject == null) || ("".equals(localObject))) {
          parama.LX.setText(this.P.getString(2131698420));
        } else {
          parama.LX.setText((CharSequence)localObject);
        }
        break;
      }
    }
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131380367);
    if (paramSlideDetectListView != null)
    {
      paramSlideDetectListView.hide();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131380366);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setTag(null);
      }
    }
  }
  
  public void clB()
  {
    if ((this.mDataList != null) && (this.mDataList.size() > 0))
    {
      this.yk.setVisibility(8);
      return;
    }
    this.yk.setVisibility(0);
  }
  
  public void cml()
  {
    super.cml();
    this.app.a().G(acbn.bkT, 9000, 0 - anze.a().af(this.app));
    anze.a().N(this.app, 0);
    this.isFinished = false;
    if ((this.jdField_b_of_type_Ywa != null) && (this.jdField_b_of_type_Ywa.getCount() > 0))
    {
      clB();
      this.jdField_b_of_type_Ywa.notifyDataSetChanged();
      cmt();
    }
    showRedDot(false);
  }
  
  public void cmu()
  {
    cmt();
    this.app.cLG();
    anze.a().N(this.app, 0);
    this.mDataList.clear();
    if (this.jdField_b_of_type_Ywa != null) {
      this.jdField_b_of_type_Ywa.clearData();
    }
    this.g.sendEmptyMessage(1012);
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public boolean h(float paramFloat)
  {
    if (this.h.getChildCount() - this.h.getHeaderViewsCount() > 0)
    {
      View localView = this.h.getChildAt(this.h.getChildCount() - 1);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1];
      if (paramFloat > localView.getMeasuredHeight() + i) {
        return true;
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - lastClickTime > 0L) && (l - lastClickTime < 800L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      lastClickTime = l;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131374278: 
        if ((paramView.getTag() instanceof ywa.a))
        {
          Object localObject2 = (ywa.a)paramView.getTag();
          if (localObject2 != null)
          {
            Object localObject3 = ((ywa.a)localObject2).a;
            int i = ((ywa.a)localObject2).bDQ;
            Object localObject1;
            if (yxe.fx(i) == 0)
            {
              localObject1 = TroopInfoActivity.c(String.valueOf(((ywa.a)localObject2).a.msg.group_code.get()), 4);
              ((Bundle)localObject1).putInt("t_s_f", 1001);
              apuh.a(getActivity(), (Bundle)localObject1, 2);
              if ((i == 2) || (i == 10) || (i == 12))
              {
                i = 1;
                localObject3 = this.app;
                localObject2 = ((ywa.a)localObject2).a.msg.group_code.get() + "";
                if (i == 0) {
                  break label268;
                }
              }
              for (localObject1 = "0";; localObject1 = "1")
              {
                anot.a((QQAppInterface)localObject3, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject2, (String)localObject1, "", "");
                break;
                i = 0;
                break label178;
              }
            }
            if ((((ywa.a)localObject2).bDQ != 2) || (!TroopInfo.isQidianPrivateTroop(((ywa.a)localObject2).a.msg.uint32_group_flagext3.get()))) {
              if (((ywa.a)localObject2).bDQ == 82)
              {
                localObject1 = new Intent(this.P, AccountDetailActivity.class);
                ((Intent)localObject1).putExtra("uin", ((ywa.a)localObject2).a.req_uin.get() + "");
                ((Intent)localObject1).putExtra("source", 112);
                startActivity((Intent)localObject1);
              }
              else
              {
                l = ((structmsg.StructMsg)localObject3).req_uin.get();
                switch (yxe.fx(i))
                {
                default: 
                  localObject1 = String.valueOf(l);
                  if (((acff)this.app.getManager(51)).isFriend((String)localObject1)) {
                    localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
                  }
                  break;
                }
                for (;;)
                {
                  l = ((structmsg.StructMsg)localObject3).msg.uint32_group_flagext3.get();
                  boolean bool = TroopInfo.isQidianPrivateTroop(l);
                  i = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
                  if (QLog.isColorLevel()) {
                    QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + i + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
                  }
                  if ((bool) && (i == 2)) {
                    break;
                  }
                  ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject1);
                  anot.a(this.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((ywa.a)localObject2).a.msg.group_code.get() + "", "3", "", "");
                  break;
                  localObject1 = ((ywa.a)localObject2).senderUin;
                  break label434;
                  localObject1 = String.valueOf(((ywa.a)localObject2).a.msg.action_uin.get());
                  break label434;
                  if ((((structmsg.StructMsg)localObject3).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject3).msg.sub_type.get() == 3))
                  {
                    localObject1 = new ProfileActivity.AllInOne((String)localObject1, 26);
                    ((ProfileActivity.AllInOne)localObject1).bIW = 1;
                  }
                  else
                  {
                    localObject1 = new ProfileActivity.AllInOne((String)localObject1, 24);
                    apuh.a((structmsg.StructMsg)localObject3, (ProfileActivity.AllInOne)localObject1);
                  }
                }
              }
            }
          }
        }
        break;
      case 2131379025: 
        label178:
        label434:
        if (QLog.isColorLevel()) {
          QLog.d(".troop.qidian_private_troop", 2, "TroopSuspiciousFragment click");
        }
        label268:
        aqfr.b("Grp_contacts_news", "notice", "unnormal_clk", 0, 0, new String[0]);
        TroopSuspiciousFragment.dr(this.P);
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.h, paramString, paramBitmap);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    removeObserver();
    if (this.jdField_b_of_type_Ywa != null)
    {
      this.jdField_b_of_type_Ywa.clearData();
      this.jdField_b_of_type_Ywa = null;
    }
    yxe.cmE();
    if ((this.jdField_b_of_type_Ywa != null) && (this.jdField_b_of_type_Ywa.getCount() > 0)) {
      cmt();
    }
    if (this.isFinished) {
      anze.a().dTY();
    }
    this.d.a(null);
    this.app.removeHandler(getClass());
    if (this.jdField_b_of_type_Ajdr != null) {
      this.jdField_b_of_type_Ajdr.LQ(false);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.isFinished = false;
    if ((this.jdField_b_of_type_Ywa != null) && (this.jdField_b_of_type_Ywa.getCount() > 0) && (this.firstResume))
    {
      this.jdField_b_of_type_Ywa.unreadMsgNum = anze.a().af(this.app);
      this.jdField_b_of_type_Ywa.notifyDataSetChanged();
    }
    this.firstResume = true;
    cmv();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLastVisibleIndex = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_b_of_type_Ywa != null) && (paramInt == 0) && (this.mLastVisibleIndex == this.jdField_b_of_type_Ywa.getCount())) {
      aMG();
    }
    this.mCurrentScrollState = paramInt;
    if (paramInt != 0)
    {
      this.d.edu();
      this.d.pause();
    }
    while (!this.d.isPausing()) {
      return;
    }
    this.d.resume();
  }
  
  protected void onStart()
  {
    super.onStart();
    showRedDot(false);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.d.pause();
    this.d.edu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotificationView
 * JD-Core Version:    0.7.0.1
 */