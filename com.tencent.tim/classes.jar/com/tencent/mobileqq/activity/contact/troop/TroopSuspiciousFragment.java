package com.tencent.mobileqq.activity.contact.troop;

import acbn;
import acdu;
import acfp;
import achq;
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
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.BadTokenException;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anze;
import anzf;
import apuh;
import aqdf;
import aqdf.a;
import aqgv;
import aqiw;
import aqnm;
import arhz;
import ausj;
import auss;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import yvp;
import yvx;
import ywu;
import yxe;
import yyb;
import yyc;
import yyd;
import yye;
import yyf;
import yyg;
import yyh;
import yyi;
import yyj;
import yyk;
import yyl;
import yym;

public class TroopSuspiciousFragment
  extends IphoneTitleBarFragment
  implements aqdf.a
{
  private arhz J;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private yvp jdField_a_of_type_Yvp;
  achq b;
  protected ajdr b;
  protected boolean bpk;
  private int cbJ;
  private int cbK;
  public aqdf d;
  protected View.OnClickListener eq = new yyj(this);
  View.OnClickListener ev = new yyi(this);
  public MqqHandler g = new yyc(this);
  public BaseActivity k;
  private QQAppInterface mApp;
  public int mCurrentScrollState = 0;
  protected List<MessageRecord> mDataList = new ArrayList();
  
  public TroopSuspiciousFragment()
  {
    this.jdField_b_of_type_Achq = new yyl(this);
  }
  
  private void Be(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.bpk))
    {
      String str = this.k.getResources().getString(2131720697);
      QQToast.a(this.k, 1, str, 0).show(getTitleBarHeight());
    }
  }
  
  private void Qq()
  {
    ausj localausj = (ausj)auss.a(this.k, null);
    localausj.addButton(2131698517, 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new yyd(this, localausj));
    if ((!localausj.isShowing()) && (this != null) && (!this.k.isFinishing())) {}
    try
    {
      localausj.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    if (this.J != null) {
      this.J.dismiss();
    }
    String str = this.k.getResources().getString(2131694032);
    Object localObject;
    if (paramInt1 == 1)
    {
      localObject = anze.a().a(Long.valueOf(paramLong));
      if ((localObject != null) && (((structmsg.StructMsg)localObject).msg.group_msg_type.get() == 82)) {
        localObject = paramString;
      }
    }
    for (;;)
    {
      QQToast.a(this.k, 2, (CharSequence)localObject, 0).show(getTitleBarHeight());
      long l = anze.a().he();
      anzf.a(anze.a().a(Long.valueOf(paramLong)), paramInt1, paramString, paramInt2);
      paramString = anze.a().a(Long.valueOf(paramLong));
      if (paramString != null)
      {
        paramInt2 = paramString.msg.group_inviter_role.get();
        if (((paramInt2 == 2) || (paramInt2 == 3)) && (paramInt1 == 1))
        {
          localObject = "" + paramString.msg.group_code.get();
          str = paramString.msg.group_name.get();
          this.mApp.a().eQ((String)localObject, str);
        }
      }
      if (l != 0L) {}
      try
      {
        if ((this.mApp != null) && (paramString != null)) {
          this.mApp.b().c(acbn.bkL, 0, l, paramString.toByteArray());
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          structmsg.StructMsg localStructMsg;
          paramString.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("TroopSuspiciousFragment", 2, "onSendSystemMsgActionFin Exception!");
          }
        }
      }
      cmS();
      return;
      localObject = this.k.getResources().getString(2131694020);
      continue;
      if (paramInt1 == 2)
      {
        localObject = this.k.getResources().getString(2131694030);
      }
      else
      {
        localObject = str;
        if (paramInt1 == 0)
        {
          localStructMsg = anze.a().a(Long.valueOf(paramLong));
          localObject = str;
          if (localStructMsg != null)
          {
            localObject = str;
            if (localStructMsg.msg.group_msg_type.get() == 82) {
              localObject = this.k.getResources().getString(2131694030);
            }
          }
        }
      }
    }
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    ywu localywu;
    if (this.mCurrentScrollState == 0)
    {
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localObject == null) || (!(localObject instanceof ywu)))
        {
          i += 1;
        }
        else
        {
          localywu = (ywu)localObject;
          switch (yxe.fx(localywu.bDQ))
          {
          default: 
            localObject = String.valueOf(localywu.a.msg.group_code.get());
          }
        }
      }
    }
    while ((localywu != null) && (paramString.equals(localObject)))
    {
      localywu.uw.setImageBitmap(paramBitmap);
      return;
      localObject = localywu.senderUin;
      continue;
      localObject = String.valueOf(localywu.a.msg.action_uin.get());
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
  
  private void a(yvx paramyvx, MessageRecord paramMessageRecord, int paramInt)
  {
    ywu localywu = (ywu)paramyvx;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    for (;;)
    {
      return;
      localywu.a = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localywu.uniseq = paramMessageRecord.uniseq;
      if (paramMessageRecord != null) {}
      for (int i = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg().msg_type.get(); i == 2; i = 2)
      {
        if (paramInt < this.cbK)
        {
          yym.C(paramyvx.S(), true);
          paramMessageRecord = localywu.a;
          localywu._id = paramInt;
          localywu.senderUin = (paramMessageRecord.req_uin.get() + "");
          localywu.bDQ = paramMessageRecord.msg.group_msg_type.get();
          paramInt = paramMessageRecord.msg.sub_type.get();
          localywu.KO = paramMessageRecord.msg_time.get();
          localywu.nickname = paramMessageRecord.msg.req_uin_nick.get();
          if ((localywu.nickname == null) || (localywu.nickname.equals(""))) {
            break label370;
          }
        }
        for (;;)
        {
          d(localywu, paramMessageRecord);
          localywu.uF.setVisibility(8);
          String str = paramMessageRecord.msg.group_info.msg_alert.get();
          c(localywu, paramMessageRecord);
          b(localywu, paramMessageRecord);
          a(paramyvx, localywu, paramMessageRecord, paramInt, str);
          if ((paramInt == 2) && (localywu.bDQ == 2) && (((TroopManager)this.mApp.getManager(52)).b(String.valueOf(paramMessageRecord.msg.group_code.get())) != null)) {
            aizr.a().n(String.valueOf(paramMessageRecord.msg.group_code.get()), this.mApp);
          }
          localywu.hC.setTag(paramyvx);
          localywu.uw.setTag(paramyvx);
          localywu.uw.setOnClickListener(this.ev);
          d(localywu);
          return;
          yym.C(paramyvx.S(), false);
          break;
          label370:
          localywu.nickname = localywu.senderUin;
        }
      }
    }
  }
  
  private void a(yvx paramyvx, ywu paramywu, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramywu.bDQ == 80)
    {
      paramyvx = paramStructMsg.msg.actions.get();
      paramywu.ej.setClickable(true);
      paramywu.ej.setText(((structmsg.SystemMsgAction)paramyvx.get(0)).name.get());
      paramywu.ej.setTextAppearance(this.k, 2131755597);
      paramywu.ej.setBackgroundResource(2130839559);
      paramywu.ej.setContentDescription(paramywu.ej.getText() + "");
      paramywu.ej.setTag(paramywu);
      paramywu.ej.setOnClickListener(this.eq);
    }
    while (TextUtils.isEmpty(paramywu.ej.getText()))
    {
      paramywu.ej.setVisibility(8);
      return;
      if (paramInt == 1)
      {
        paramStructMsg = paramStructMsg.msg.actions.get();
        paramywu.ej.setClickable(true);
        if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
        {
          if ((paramString == null) || ("".equals(paramString))) {
            if (paramStructMsg.size() > 1)
            {
              paramywu.ej.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
              paramywu.ej.setTextAppearance(this.k, 2131755597);
              paramywu.ej.setBackgroundResource(2130839559);
            }
          }
          for (;;)
          {
            paramywu.ej.setContentDescription(paramywu.ej.getText() + "");
            paramywu.ej.setTag(paramyvx);
            paramywu.ej.setOnClickListener(this.eq);
            break;
            paramywu.ej.setText("");
            continue;
            paramywu.ej.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
            paramywu.ej.setTextAppearance(this.k, 2131755596);
            paramywu.ej.setBackgroundResource(2130839558);
          }
        }
        paramywu.ej.setText("");
        paramywu.ej.setBackgroundDrawable(null);
      }
      else
      {
        paramywu.ej.setBackgroundDrawable(null);
        paramywu.ej.setClickable(false);
        paramywu.ej.setTextAppearance(this.k, 2131756687);
        paramywu.ej.setText(paramStructMsg.msg.msg_decided.get());
        paramyvx = (RelativeLayout.LayoutParams)paramywu.ej.getLayoutParams();
      }
    }
    paramywu.ej.setVisibility(0);
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int m;
    int n;
    if (paramStructMsg != null)
    {
      int i = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int j = paramStructMsg.msg.sub_type.get();
      m = paramStructMsg.msg.src_id.get();
      n = paramStructMsg.msg.sub_src_id.get();
      int i1 = paramStructMsg.msg.group_msg_type.get();
      Object localObject = paramStructMsg.msg.actions.get();
      if ((localObject == null) || (paramInt >= ((List)localObject).size())) {
        break label226;
      }
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).uint32_req_msg_type.set(2);
      this.mApp.a().a().a(i, l1, l2, j, m, n, i1, (structmsg.SystemMsgActionInfo)localObject, paramInt);
    }
    label226:
    for (bool = true;; bool = false)
    {
      if ((m == 116) && (n == 0)) {
        anot.a(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
          QQToast.a(this.k, this.k.getResources().getString(2131693404), 0).show(getTitleBarHeight());
          return;
        }
      } while ((this.jdField_b_of_type_Ajdr != null) && (this.jdField_b_of_type_Ajdr.aqv()));
      this.bpk = true;
      if (this.jdField_a_of_type_Yvp != null) {
        this.jdField_a_of_type_Yvp.a(new yyk(this));
      }
      this.mApp.a().a().Ki(3);
    } while (!QLog.isColorLevel());
    QLog.i("TroopSuspiciousFragment", 2, "loadNextPage.get next page.");
  }
  
  private void addObserver()
  {
    if (this.mApp != null) {
      this.mApp.addObserver(this.jdField_b_of_type_Achq);
    }
  }
  
  private void b(ywu paramywu, structmsg.StructMsg paramStructMsg)
  {
    String str = apuh.a(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (str != null)
    {
      paramywu.LX.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      paramywu.LX.setText(this.k.getString(2131698420));
      return;
    }
    paramywu.LX.setText(paramStructMsg);
  }
  
  private void c(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (this.J != null) {
      this.J.dismiss();
    }
    String str = this.k.getResources().getString(2131719483);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      QQToast.a(this.k, 1, paramString2, 0).show(getTitleBarHeight());
      anzf.a(anze.a().a(Long.valueOf(paramLong)), paramInt, paramString1, paramString3);
      paramString1 = anze.a().a(Long.valueOf(paramLong));
      if ((paramString1 != null) && (paramString1.msg_type.get() == 2)) {
        cmS();
      }
      return;
      paramString2 = str;
    }
  }
  
  private void c(ywu paramywu)
  {
    if (paramywu == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopSuspiciousFragment", 2, "jumpToTroopRequestActivity!" + paramywu._id);
    }
    yym.a(paramywu.a, "unnormal_edit");
    Intent localIntent = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramywu._id);
    localBundle.putInt("mTroopMsgType", paramywu.bDQ);
    localBundle.putString("mTroopCode", String.valueOf(paramywu.a.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramywu.a.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramywu.a.msg.msg_additional.get());
    int i = anze.a().af(this.mApp);
    if (paramywu.mPosition < i) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramywu.a.req_uin.get()));
      localBundle.putString("troopsummary", paramywu.a.msg.msg_describe.get());
      localBundle.putLong("infotime", paramywu.KO);
      if ((getActivity() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", f((ArrayList)((TroopActivity)getActivity()).tw, String.valueOf(paramywu.a.msg.action_uin.get())));
      }
      if (paramywu.a.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramywu.a.msg.msg_detail.get());
      }
      yym.a((structmsg.StructMsg)paramywu.a.get());
      a((structmsg.StructMsg)paramywu.a.get(), paramywu.uniseq);
      localBundle.putInt("t_s_f", 1001);
      localBundle.putBoolean("troop_suspicious_request", true);
      localIntent.putExtras(localBundle);
      startActivity(localIntent);
      return;
    }
  }
  
  private void c(ywu paramywu, structmsg.StructMsg paramStructMsg)
  {
    Object localObject = "";
    if (paramStructMsg.msg.bytes_warning_tips.get() != null) {
      localObject = paramStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramywu.LY.setVisibility(8);
      if (paramywu.bDQ != 22) {
        break label237;
      }
      paramStructMsg = paramStructMsg.msg;
      paramywu.LY.setVisibility(0);
      localObject = new SpannableString(this.mApp.getApp().getString(2131720695, new Object[] { paramStructMsg.action_uin_nick.get() }));
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramStructMsg.action_uin_nick.get().length() + 6, 33);
      paramywu.LY.setText((CharSequence)localObject);
      paramywu.LY.setOnClickListener(new yyh(this, paramStructMsg));
    }
    label237:
    while ((paramywu.bDQ != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      return;
      paramywu.LY.setVisibility(0);
      paramywu.LY.setText((CharSequence)localObject);
      localObject = this.k.getResources().getDrawable(2130848673);
      ((Drawable)localObject).setBounds(0, 0, aqnm.dip2px(16.0F), aqnm.dip2px(16.0F));
      paramywu.LY.setCompoundDrawablePadding(aqnm.dip2px(5.0F));
      paramywu.LY.setCompoundDrawables((Drawable)localObject, null, null, null);
      break;
    }
    String str = "";
    switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
    {
    case 0: 
    default: 
      return;
    case 1: 
      localObject = (TroopManager)this.mApp.getManager(52);
      if (localObject == null) {
        break;
      }
    }
    for (paramStructMsg = ((TroopManager)localObject).jo(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; paramStructMsg = "")
    {
      paramywu.LY.setText(acfp.m(2131709158) + paramStructMsg);
      paramywu.LY.setVisibility(0);
      return;
      acdu localacdu = (acdu)this.mApp.getManager(53);
      localObject = str;
      if (localacdu != null)
      {
        paramStructMsg = localacdu.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        localObject = str;
        if (paramStructMsg != null) {
          localObject = paramStructMsg.discussionName;
        }
      }
      paramywu.LY.setText(acfp.m(2131709147) + (String)localObject);
      paramywu.LY.setVisibility(0);
      return;
    }
  }
  
  private void cmS()
  {
    this.cbK = anze.a().ag(this.mApp);
    if (this.g != null) {
      this.g.sendEmptyMessage(1012);
    }
  }
  
  private void cmV()
  {
    if (this.rightViewImg == null) {
      return;
    }
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130840663);
    this.rightViewImg.setOnClickListener(new yye(this));
  }
  
  private void cmt()
  {
    ThreadManager.post(new TroopSuspiciousFragment.11(this), 8, null, false);
  }
  
  private void d(ywu paramywu)
  {
    int i = 1;
    if (paramywu == null) {
      return;
    }
    Object localObject;
    String str;
    switch (yxe.fx(paramywu.bDQ))
    {
    default: 
      localObject = String.valueOf(paramywu.a.msg.group_code.get());
      i = 4;
      str = paramywu.a.msg.group_name.get() + this.k.getString(2131698750);
    }
    for (;;)
    {
      localObject = yxe.a(this.d, (String)localObject, i);
      paramywu.uw.setContentDescription(str);
      paramywu.uw.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramywu.senderUin;
      str = paramywu.a.msg.req_uin_nick.get() + this.k.getString(2131698749);
      continue;
      localObject = String.valueOf(paramywu.a.msg.action_uin.get());
      str = paramywu.a.msg.action_uin_nick.get() + this.k.getString(2131698748);
    }
  }
  
  private void d(ywu paramywu, structmsg.StructMsg paramStructMsg)
  {
    if ((paramywu == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramywu.bDQ == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramywu.LW.setText(paramStructMsg);
        return;
        paramStructMsg = paramStructMsg.msg.action_uin_nick.get();
        continue;
        Object localObject = (TroopManager)this.mApp.getManager(52);
        if (localObject == null) {
          break;
        }
        String str2 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
        String str3 = String.valueOf(paramStructMsg.msg.action_uin.get());
        paramStructMsg = ((TroopManager)localObject).jr(str2);
        str1 = aqgv.a(this.mApp, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).getTroopMemberName(str2, str3);
          continue;
          localObject = (acdu)this.mApp.getManager(53);
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
    switch (yxe.fx(paramywu.bDQ))
    {
    default: 
      paramywu.LW.setText(paramywu.nickname);
      return;
    case 0: 
      paramywu.LW.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramywu.LW.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramywu.LW.setText(paramywu.nickname);
  }
  
  public static void dr(Context paramContext)
  {
    PublicFragmentActivity.start(paramContext, new Intent(), TroopSuspiciousFragment.class);
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
      QLog.d("TroopSuspiciousFragment", 2, "checkInviteeIsFriend stranger list is empty ");
    }
    return false;
  }
  
  private void gW(List<MessageRecord> paramList)
  {
    if ((this.mDataList != null) && (paramList != null) && (paramList.size() > 0))
    {
      this.mDataList.clear();
      this.mDataList = TroopNotifyAndRecommendView.g(this.mDataList, paramList);
    }
    anze.a().O(this.mApp, 0);
    if (this.jdField_a_of_type_Yvp != null)
    {
      this.jdField_a_of_type_Yvp.clearDatas();
      this.jdField_a_of_type_Yvp.gQ(this.mDataList);
      this.jdField_a_of_type_Yvp.notifyDataSetChanged();
      this.mApp.a().a().FN(true);
    }
  }
  
  private void initAdapter()
  {
    this.jdField_a_of_type_Yvp = new yyf(this, getActivity(), 2131560104);
    this.jdField_a_of_type_Yvp.EG(2131560105);
    this.jdField_a_of_type_Yvp.a(2131561721);
    this.jdField_a_of_type_Yvp.a(new yyg(this));
  }
  
  private void initListData()
  {
    this.cbJ = anze.a().ag(this.mApp);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Yvp);
    this.mDataList = this.mApp.b().k(acbn.bkL, 0);
    yym.setAndCheckNotifyFollowSeq(this.mDataList, this.mApp);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mDataList.size())
    {
      localArrayList.add(this.mDataList.get(this.mDataList.size() - i - 1));
      i += 1;
    }
    this.mDataList = localArrayList;
    if ((this.mDataList != null) && (this.mDataList.size() > 0) && (!(this.mDataList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopSuspiciousFragment", 2, "initListData error");
      }
      this.mApp.cLI();
      this.jdField_a_of_type_Yvp.gQ(null);
      return;
    }
    this.jdField_a_of_type_Yvp.gQ(this.mDataList);
  }
  
  private void initUI(View paramView)
  {
    if (paramView == null) {
      return;
    }
    cmV();
    this.J = new arhz(this.k, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131379027));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new yyb(this));
    this.d = new aqdf(getActivity(), this.mApp);
    this.d.a(this);
  }
  
  private void removeObserver()
  {
    if (this.mApp != null) {
      this.mApp.removeObserver(this.jdField_b_of_type_Achq);
    }
  }
  
  private void stopLoadMore()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "stopLoadMore().");
    }
    if (this.jdField_a_of_type_Yvp != null) {
      this.jdField_a_of_type_Yvp.cmj();
    }
    this.bpk = false;
  }
  
  public void cmu()
  {
    cmt();
    this.mApp.cLH();
    anze.a().O(this.mApp, 0);
    this.mDataList.clear();
    if (this.jdField_a_of_type_Yvp != null) {
      this.jdField_a_of_type_Yvp.clearDatas();
    }
    this.g.sendEmptyMessage(1012);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mApp.setHandler(getClass(), this.g);
    this.jdField_b_of_type_Ajdr = ((ajdr)this.mApp.getManager(37));
    this.k = getActivity();
    initUI(this.mContentView);
    initAdapter();
    initListData();
    addObserver();
  }
  
  public int getContentLayoutId()
  {
    return 2131561753;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.k = getActivity();
    this.mApp = ((QQAppInterface)this.k.getAppInterface());
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131701782));
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView, paramString, paramBitmap);
  }
  
  public void onDestroy()
  {
    removeObserver();
    super.onDestroy();
    anze.a().dTY();
    if (this.d != null) {
      this.d.a(null);
    }
    if (this.mApp != null) {
      this.mApp.removeHandler(getClass());
    }
    if (this.jdField_b_of_type_Ajdr != null) {
      this.jdField_b_of_type_Ajdr.LR(false);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if ((this.cbJ > 0) && (this.jdField_a_of_type_Yvp != null) && (this.jdField_a_of_type_Yvp.getRealItemCount() > 0)) {
      cmt();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    cmS();
    anze.a().O(this.mApp, 0);
  }
  
  public void onStop()
  {
    super.onStop();
    this.d.pause();
    this.d.edu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */