package com.tencent.mobileqq.activity.contact.troop;

import acbn;
import acdu;
import acff;
import acfp;
import achq;
import ackn;
import acnd;
import acrp;
import aizr;
import ajdr;
import anaz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anze;
import aozz;
import aprz;
import apuh;
import apyh;
import aqdf;
import aqdf.a;
import aqdj;
import aqfr;
import aqgv;
import aqha;
import aqhu;
import aqiw;
import aqju;
import aqnm;
import arhz;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
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
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import tog;
import yru;
import yvp;
import yvx;
import ywa.a;
import ywk;
import ywu;
import yxe;
import yxe.a;
import yxf;
import yxg;
import yxh;
import yxi;
import yxj;
import yxk;
import yxl;
import yxm;
import yxn;
import yxo;
import yxp;
import yxq;
import yxr;
import yxs;
import yxt;
import yxu;
import yxv;
import yxw;
import yxx;
import yxy;
import yxz;
import yya;
import yym;

public class TroopNotifyAndRecommendView
  extends BaseTroopView
  implements View.OnClickListener, aqdf.a, AbsListView.e, Observer, yru
{
  protected static long lastClickTime;
  public arhz J;
  public final long KP = 1000L;
  public final long KQ = 500L;
  private TextView Mi;
  private TextView Mj;
  private TextView Mk;
  private TextView Ml;
  private TextView Mm;
  public TextView Mn;
  public Context P;
  acnd jdField_a_of_type_Acnd = new yxl(this);
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private yvp jdField_a_of_type_Yvp;
  public yxe.a a;
  achq jdField_b_of_type_Achq = new yxx(this);
  public ackn b;
  private ajdr jdField_b_of_type_Ajdr;
  protected SosoInterface.a b;
  public ywk b;
  protected boolean bix;
  private boolean bpA;
  private boolean bpB;
  protected boolean bpC;
  protected boolean bpD;
  protected boolean bpE = true;
  protected boolean bpF;
  private boolean bpG;
  public boolean bpk;
  Drawable cC;
  public int cbI = 0;
  private int cbJ;
  private int cbK;
  public aqdf d;
  protected View.OnClickListener ep = new yxw(this);
  protected View.OnClickListener eq = new yxg(this);
  View.OnClickListener ev = new yxq(this);
  protected View.OnClickListener ew = new yxs(this);
  public MqqHandler g = new yxv(this);
  public SwipListView i;
  protected boolean isFinished;
  protected int mCurrentScrollState = 0;
  public List<MessageRecord> mDataList = new ArrayList();
  protected int mLastVisibleIndex;
  private int mLastX;
  private int mLastY;
  protected View mLoadingView;
  public int mType = 0;
  public List<RecommendTroopItem> tA = new ArrayList();
  public List<MessageRecord> tx = new ArrayList();
  public List<MessageRecord> ty = new ArrayList();
  public List<MessageRecord> tz = new ArrayList();
  private ImageView uH;
  private ImageView uI;
  private ImageView uJ;
  private View yp;
  private View yq;
  private View yr;
  private View ys;
  
  public TroopNotifyAndRecommendView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Yxe$a = new yxk(this);
    this.P = paramContext;
  }
  
  private void KR()
  {
    Object localObject3 = "";
    String str = "";
    Object localObject2 = str;
    Object localObject1 = localObject3;
    Intent localIntent;
    int j;
    if ((getContext() instanceof Activity))
    {
      localIntent = ((Activity)getContext()).getIntent();
      localObject2 = str;
      localObject1 = localObject3;
      if (localIntent != null)
      {
        j = localIntent.getIntExtra("key_from", 0);
        if (j == 1)
        {
          localObject1 = "3";
          localObject2 = "1";
        }
      }
    }
    for (;;)
    {
      aqfr.b("Grp_contacts_news", "notice", "enter_verify", 0, 0, new String[] { localObject2, localObject1 });
      return;
      localObject2 = str;
      localObject1 = localObject3;
      if (j == 2)
      {
        localObject3 = "3";
        if (localIntent.getBooleanExtra("has_red", false))
        {
          str = "2";
          localObject2 = localObject3;
          localObject1 = str;
          if (this.mDataList == null) {
            break label292;
          }
          localObject2 = localObject3;
          localObject1 = str;
          if (this.mDataList.size() <= 0) {
            break label292;
          }
          localObject1 = (MessageRecord)this.mDataList.get(0);
          if (!(localObject1 instanceof MessageForSystemMsg)) {
            break label285;
          }
          long l = ((MessageForSystemMsg)localObject1).getSystemMsg().msg.group_code.get();
          localObject1 = ((TroopManager)this.app.getManager(52)).b(l + "");
          if (localObject1 == null) {
            break label285;
          }
          if (((TroopInfo)localObject1).isAdmin()) {
            localObject1 = "1";
          }
        }
        for (;;)
        {
          localObject2 = "2";
          break;
          localObject1 = "2";
          continue;
          localObject1 = "3";
          localObject2 = "3";
          break;
          label285:
          localObject1 = "3";
        }
      }
      label292:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    aprz.a(this.app, paramLong, new yxh(this), localBundle);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    ywu localywu;
    if (this.cbI == 0)
    {
      int k = paramRecyclerView.getChildCount();
      int j = 0;
      while (j < k)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(j);
        if ((localObject == null) || (!(localObject instanceof ywu)))
        {
          j += 1;
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
    while ((localywu.uw != null) && (paramString.equals(localObject)))
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
    int j;
    do
    {
      return;
      localywu.a = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localywu.uniseq = paramMessageRecord.uniseq;
      j = 2;
      if (paramMessageRecord != null) {
        j = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg().msg_type.get();
      }
    } while (j != 2);
    structmsg.StructMsg localStructMsg;
    label206:
    String str;
    label289:
    Object localObject1;
    if (paramInt < this.cbK)
    {
      yym.C(paramyvx.S(), true);
      localStructMsg = localywu.a;
      localywu._id = paramInt;
      localywu.senderUin = (localStructMsg.req_uin.get() + "");
      localywu.bDQ = localStructMsg.msg.group_msg_type.get();
      paramInt = localStructMsg.msg.sub_type.get();
      localywu.KO = localStructMsg.msg_time.get();
      localywu.nickname = localStructMsg.msg.req_uin_nick.get();
      if ((localywu.nickname == null) || (localywu.nickname.equals(""))) {
        break label721;
      }
      a(localywu, localStructMsg);
      localywu.uF.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      paramMessageRecord = "";
      if (localStructMsg.msg.bytes_warning_tips.get() != null) {
        paramMessageRecord = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      }
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        break label734;
      }
      localywu.LY.setVisibility(8);
      if (localywu.bDQ != 22) {
        break label813;
      }
      paramMessageRecord = localStructMsg.msg;
      localywu.LY.setVisibility(0);
      localObject1 = new SpannableString(this.app.getApp().getString(2131720695, new Object[] { paramMessageRecord.action_uin_nick.get() }));
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramMessageRecord.action_uin_nick.get().length() + 6, 33);
      localywu.LY.setText((CharSequence)localObject1);
      localywu.LY.setOnClickListener(new yxp(this, paramMessageRecord));
    }
    for (;;)
    {
      paramMessageRecord = apuh.a(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (paramMessageRecord == null) {
        break label1072;
      }
      localywu.LX.setText(paramMessageRecord);
      label442:
      if (localywu.bDQ != 80) {
        break label1130;
      }
      paramMessageRecord = localStructMsg.msg.actions.get();
      localywu.ej.setClickable(true);
      localywu.ej.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
      localywu.ej.setTextAppearance(this.P, 2131755597);
      localywu.ej.setBackgroundResource(2130839559);
      localywu.ej.setContentDescription(localywu.ej.getText() + "");
      localywu.ej.setTag(localywu);
      localywu.ej.setOnClickListener(this.ew);
      label579:
      if (!TextUtils.isEmpty(localywu.ej.getText())) {
        break label1457;
      }
      localywu.ej.setVisibility(8);
      label603:
      if ((paramInt == 2) && (localywu.bDQ == 2) && (((TroopManager)this.app.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        aizr.a().n(String.valueOf(localStructMsg.msg.group_code.get()), this.app);
      }
      localywu.hC.setTag(paramyvx);
      localywu.uw.setTag(paramyvx);
      localywu.uw.setOnClickListener(this.ev);
      a(localywu);
      return;
      yym.C(paramyvx.S(), false);
      break;
      label721:
      localywu.nickname = localywu.senderUin;
      break label206;
      label734:
      localywu.LY.setVisibility(0);
      localywu.LY.setText(paramMessageRecord);
      paramMessageRecord = this.P.getResources().getDrawable(2130848673);
      paramMessageRecord.setBounds(0, 0, aqnm.dip2px(16.0F), aqnm.dip2px(16.0F));
      localywu.LY.setCompoundDrawablePadding(aqnm.dip2px(5.0F));
      localywu.LY.setCompoundDrawables(paramMessageRecord, null, null, null);
      break label289;
      label813:
      if ((localywu.bDQ == 2) && (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        localObject1 = "";
        switch (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
        {
        }
      }
    }
    paramMessageRecord = (TroopManager)this.app.getManager(52);
    if (paramMessageRecord != null) {}
    for (paramMessageRecord = paramMessageRecord.jo(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; paramMessageRecord = "")
    {
      localywu.LY.setText(acfp.m(2131709158) + paramMessageRecord);
      localywu.LY.setVisibility(0);
      break;
      Object localObject2 = (acdu)this.app.getManager(53);
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((acdu)localObject2).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        paramMessageRecord = (MessageRecord)localObject1;
        if (localObject2 != null) {
          paramMessageRecord = ((DiscussionInfo)localObject2).discussionName;
        }
      }
      localywu.LY.setText(acfp.m(2131709147) + paramMessageRecord);
      localywu.LY.setVisibility(0);
      break;
      label1072:
      paramMessageRecord = localStructMsg.msg.msg_additional.get();
      if ((paramMessageRecord == null) || ("".equals(paramMessageRecord)))
      {
        localywu.LX.setText(this.P.getString(2131698420));
        break label442;
      }
      localywu.LX.setText(paramMessageRecord);
      break label442;
      label1130:
      if (paramInt == 1)
      {
        paramMessageRecord = localStructMsg.msg.actions.get();
        localywu.ej.setClickable(true);
        if ((paramMessageRecord != null) && (paramMessageRecord.size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (paramMessageRecord.size() > 1)
            {
              localywu.ej.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(1)).name.get());
              localywu.ej.setTextAppearance(this.P, 2131755597);
              localywu.ej.setBackgroundResource(2130839559);
            }
          }
          for (;;)
          {
            localywu.ej.setContentDescription(localywu.ej.getText() + "");
            localywu.ej.setTag(paramyvx);
            localywu.ej.setOnClickListener(this.ew);
            break;
            localywu.ej.setText("");
            continue;
            localywu.ej.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
            localywu.ej.setTextAppearance(this.P, 2131755596);
            localywu.ej.setBackgroundResource(2130839558);
          }
        }
        localywu.ej.setText("");
        localywu.ej.setBackgroundDrawable(null);
        break label579;
      }
      localywu.ej.setBackgroundDrawable(null);
      localywu.ej.setClickable(false);
      localywu.ej.setTextAppearance(this.P, 2131756687);
      localywu.ej.setText(localStructMsg.msg.msg_decided.get());
      paramMessageRecord = (RelativeLayout.LayoutParams)localywu.ej.getLayoutParams();
      break label579;
      label1457:
      localywu.ej.setVisibility(0);
      break label603;
    }
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
  
  private void a(ywa.a parama, structmsg.StructMsg paramStructMsg, String paramString)
  {
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
      if (paramStructMsg.msg.pic_url.has())
      {
        if (!TextUtils.isEmpty(paramString)) {
          localObject = acfp.m(2131716043) + paramString;
        }
      }
      else
      {
        label110:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label497;
        }
        parama.LY.setSingleLine(true);
        parama.LY.setText((CharSequence)localObject);
        parama.LY.setVisibility(0);
        label143:
        if (parama.bDQ != 22) {
          break label509;
        }
        paramStructMsg = paramStructMsg.msg;
        parama.LY.setVisibility(0);
        paramString = new SpannableString(this.app.getApp().getString(2131720695, new Object[] { paramStructMsg.action_uin_nick.get() }));
        paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramStructMsg.action_uin_nick.get().length() + 6, 33);
        parama.LY.setText(paramString);
        parama.LY.setOnClickListener(new yxy(this, paramStructMsg));
      }
      label497:
      label509:
      while ((parama.bDQ != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        return;
        if ((!TextUtils.isEmpty(paramString)) && ((parama.bDQ == 1) || (parama.bDQ == 22)))
        {
          parama.LY.setTextAppearance(this.P, 2131756689);
          break;
        }
        localObject = new ArrayList();
        ((List)localObject).add(paramStructMsg.msg.msg_qna.get());
        if (paramStructMsg.msg.msg_actor_describe.get() != null) {}
        for (paramString = apuh.a(paramStructMsg, paramStructMsg.msg.msg_actor_describe.get());; paramString = "")
        {
          ((List)localObject).add(paramString);
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
        localObject = acfp.m(2131716044);
        break label110;
        parama.LY.setVisibility(8);
        break label143;
      }
      localObject = "";
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      case 0: 
      default: 
        return;
      case 1: 
        paramString = (TroopManager)this.app.getManager(52);
        if (paramString == null) {
          break;
        }
      }
      for (paramStructMsg = paramString.jo(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; paramStructMsg = "")
      {
        parama.LY.setText(acfp.m(2131716047) + paramStructMsg);
        parama.LY.setVisibility(0);
        return;
        acdu localacdu = (acdu)this.app.getManager(53);
        paramString = (String)localObject;
        if (localacdu != null)
        {
          paramStructMsg = localacdu.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
          paramString = (String)localObject;
          if (paramStructMsg != null) {
            paramString = paramStructMsg.discussionName;
          }
        }
        parama.LY.setText(acfp.m(2131716045) + paramString);
        parama.LY.setVisibility(0);
        return;
      }
      paramString = "";
    }
  }
  
  private void a(ywu paramywu)
  {
    int j = 1;
    if (paramywu == null) {
      return;
    }
    Object localObject;
    String str;
    switch (yxe.fx(paramywu.bDQ))
    {
    default: 
      localObject = String.valueOf(paramywu.a.msg.group_code.get());
      j = 4;
      str = paramywu.a.msg.group_name.get() + this.P.getString(2131698750);
    }
    for (;;)
    {
      localObject = yxe.a(this.d, (String)localObject, j);
      paramywu.uw.setContentDescription(str);
      paramywu.uw.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramywu.senderUin;
      str = paramywu.a.msg.req_uin_nick.get() + this.P.getString(2131698749);
      continue;
      localObject = String.valueOf(paramywu.a.msg.action_uin.get());
      str = paramywu.a.msg.action_uin_nick.get() + this.P.getString(2131698748);
    }
  }
  
  private void a(ywu paramywu, structmsg.StructMsg paramStructMsg)
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
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int m;
    int n;
    if (paramStructMsg != null)
    {
      int j = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int k = paramStructMsg.msg.sub_type.get();
      m = paramStructMsg.msg.src_id.get();
      n = paramStructMsg.msg.sub_src_id.get();
      int i1 = paramStructMsg.msg.group_msg_type.get();
      List localList = paramStructMsg.msg.actions.get();
      if ((localList == null) || (paramInt >= localList.size())) {
        break label216;
      }
      this.app.a().a().a(j, l1, l2, k, m, n, i1, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
    }
    label216:
    for (bool = true;; bool = false)
    {
      if ((m == 116) && (n == 0)) {
        anot.a(this.app, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private void aMG()
  {
    if ((this.bpk) || (this.mType == 2) || (this.mType == 1)) {}
    do
    {
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
          if ((this.jdField_b_of_type_Ywk == null) || ((this.jdField_b_of_type_Ywk.UJ()) && (!this.jdField_b_of_type_Ywk.isShowAll()))) {
            break;
          }
        } while ((this.jdField_b_of_type_Ajdr != null) && (this.jdField_b_of_type_Ajdr.aqu()));
        this.bpk = true;
        this.mLoadingView.setVisibility(0);
        this.app.a().a().cOi();
      } while (!QLog.isColorLevel());
      QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of Notofication");
      return;
      if ((this.jdField_b_of_type_Ackn.isEnd != 1) && (this.bpB))
      {
        this.bpk = true;
        this.mLoadingView.setVisibility(0);
        this.jdField_b_of_type_Ackn.abC();
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of recommend");
        }
        aqfr.b("Grp_contacts_news", "notice", "recom_,more", 2, 0, new String[0]);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopNotifyAndRecommendView", 2, "ray test touch the end of list.");
  }
  
  private void b(ywa.a parama)
  {
    int j = 1;
    if (parama == null) {
      return;
    }
    Object localObject;
    String str;
    switch (yxe.fx(parama.bDQ))
    {
    default: 
      localObject = String.valueOf(parama.a.msg.group_code.get());
      j = 4;
      str = parama.a.msg.group_name.get() + this.P.getString(2131698750);
    }
    for (;;)
    {
      if (this.cC == null) {
        this.cC = aqhu.at();
      }
      localObject = aqdj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), j, (String)localObject, 3, this.cC, this.cC);
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
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + parama._id + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", parama._id);
    localBundle.putInt("mTroopMsgType", parama.bDQ);
    localBundle.putString("mTroopCode", String.valueOf(parama.a.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(parama.a.msg.action_uin.get()));
    localBundle.putString("troopsMsg", parama.a.msg.msg_additional.get());
    if ((this.jdField_b_of_type_Ywk != null) && (parama.mPosition < this.jdField_b_of_type_Ywk.unreadMsgNum)) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(parama.a.req_uin.get()));
      localBundle.putString("troopsummary", parama.a.msg.msg_describe.get());
      localBundle.putLong("infotime", parama.KO);
      localBundle.putInt("troopfromtab", this.mType);
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
  
  private void b(ywa.a parama, structmsg.StructMsg paramStructMsg)
  {
    String str = apuh.a(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (str != null)
    {
      parama.LX.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      parama.LX.setText(this.P.getString(2131698420));
      return;
    }
    parama.LX.setText(paramStructMsg);
  }
  
  private void b(ywa.a parama, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
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
        if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
        {
          if ((paramString == null) || ("".equals(paramString))) {
            if (paramStructMsg.size() > 1)
            {
              parama.ej.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
              parama.ej.setTextAppearance(this.P, 2131755597);
              parama.ej.setBackgroundResource(2130839559);
            }
          }
          for (;;)
          {
            parama.ej.setContentDescription(parama.ej.getText() + "");
            parama.ej.setTag(parama);
            parama.ej.setOnClickListener(this.eq);
            break;
            parama.ej.setText("");
            continue;
            parama.ej.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
            parama.ej.setTextAppearance(this.P, 2131755596);
            parama.ej.setBackgroundResource(2130839558);
          }
        }
        parama.ej.setText("");
        parama.ej.setBackgroundDrawable(null);
      }
      else
      {
        parama.ej.setBackgroundDrawable(null);
        parama.ej.setClickable(false);
        parama.ej.setTextAppearance(this.P, 2131756687);
        parama.ej.setText(paramStructMsg.msg.msg_decided.get());
      }
    }
    parama.ej.setVisibility(0);
  }
  
  private void b(ywu paramywu)
  {
    if (paramywu == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramywu._id);
    }
    yym.a(paramywu.a, "unnormal_edit");
    Intent localIntent = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramywu._id);
    localBundle.putInt("mTroopMsgType", paramywu.bDQ);
    localBundle.putString("mTroopCode", String.valueOf(paramywu.a.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramywu.a.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramywu.a.msg.msg_additional.get());
    int j = anze.a().af(this.app);
    if (paramywu.mPosition < j) {}
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
  
  private boolean b(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int m;
    int n;
    if (paramStructMsg != null)
    {
      int j = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int k = paramStructMsg.msg.sub_type.get();
      m = paramStructMsg.msg.src_id.get();
      n = paramStructMsg.msg.sub_src_id.get();
      int i1 = paramStructMsg.msg.group_msg_type.get();
      Object localObject = paramStructMsg.msg.actions.get();
      if ((localObject == null) || (paramInt >= ((List)localObject).size())) {
        break label226;
      }
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).uint32_req_msg_type.set(2);
      this.app.a().a().a(j, l1, l2, k, m, n, i1, (structmsg.SystemMsgActionInfo)localObject, paramInt);
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
  
  private void cmF()
  {
    int k = anze.a().af(this.app);
    if (this.jdField_b_of_type_Ywk != null) {
      this.jdField_b_of_type_Ywk.unreadMsgNum = k;
    }
    this.mDataList = this.app.b().b(acbn.bkK, 0, null);
    setAndCheckNotifyFollowSeq(this.mDataList, this.app);
    if (yya.UO())
    {
      setType(1);
      yya.Bd(false);
    }
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < this.mDataList.size())
    {
      localArrayList.add(this.mDataList.get(this.mDataList.size() - j - 1));
      j += 1;
    }
    this.mDataList = localArrayList;
    yxz.L(this.mDataList, k);
    this.mDataList = yxz.de();
    this.ty = yxz.dc();
    this.tz = yxz.dd();
    if (this.mType == 1)
    {
      this.mDataList = this.tz;
      AX(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "mDataList Size =", Integer.valueOf(this.mDataList.size()), "mExitDataList Size =", Integer.valueOf(this.ty.size()), "mUndealDataList Size=", Integer.valueOf(this.tz.size()) });
    }
    if ((this.mDataList != null) && (this.mDataList.size() > 0) && (!(this.mDataList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "initNotificationListData error");
      }
      this.app.cLI();
      if (this.jdField_b_of_type_Ywk != null) {
        this.jdField_b_of_type_Ywk.gR(null);
      }
      return;
    }
    if (this.jdField_b_of_type_Ywk != null)
    {
      this.jdField_b_of_type_Ywk.gR(this.mDataList);
      this.jdField_b_of_type_Ywk.a(this.jdField_b_of_type_Ackn);
    }
    gV(this.ty);
    gU(this.tz);
    if (!yxz.UM()) {
      aK(false, 2);
    }
    if (yxz.UL())
    {
      aK(true, 1);
      this.mDataList = yxz.de();
      if ((!this.tz.isEmpty()) || (!this.tx.isEmpty()) || (!this.ty.isEmpty()) || (this.yp == null)) {
        break label482;
      }
      this.yp.setVisibility(8);
    }
    for (;;)
    {
      KR();
      return;
      aK(false, 1);
      break;
      label482:
      if (this.yp != null) {
        this.yp.setVisibility(0);
      }
    }
  }
  
  private void cmM()
  {
    this.jdField_a_of_type_Yvp = new yxm(this, getActivity(), 2131560104);
    this.jdField_a_of_type_Yvp.EG(2131560105);
    this.jdField_a_of_type_Yvp.a(2131561721);
    this.jdField_a_of_type_Yvp.a(new yxn(this));
  }
  
  private void cmN()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)findViewById(2131379027));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new yxr(this));
    this.d = new aqdf(getActivity(), this.app);
    this.d.a(this);
  }
  
  private void cmO()
  {
    if (this.bpD) {}
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
      } while ((this.jdField_b_of_type_Ajdr != null) && (this.jdField_b_of_type_Ajdr.aqv()));
      this.bpD = true;
      if (this.jdField_a_of_type_Yvp != null) {
        this.jdField_a_of_type_Yvp.a(new yxt(this));
      }
      this.app.a().a().Ki(3);
    } while (!QLog.isColorLevel());
    QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page.");
  }
  
  private void cmP()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "stopLoadMore().");
    }
    if (this.jdField_a_of_type_Yvp != null) {
      this.jdField_a_of_type_Yvp.cmj();
    }
    this.bpD = false;
  }
  
  private void cmQ()
  {
    ThreadManager.post(new TroopNotifyAndRecommendView.25(this), 8, null, false);
  }
  
  private void cmS()
  {
    this.cbK = anze.a().ag(this.app);
    if (this.g != null) {
      this.g.sendEmptyMessage(1012);
    }
  }
  
  private void cms()
  {
    if (this.mLoadingView == null) {
      this.mLoadingView = LayoutInflater.from(this.P).inflate(2131561721, null);
    }
    if (this.mLoadingView.getParent() == null) {
      this.i.addFooterView(this.mLoadingView);
    }
    this.mLoadingView.setVisibility(8);
  }
  
  private void cmt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "sendReadConfirm lll");
    }
    ThreadManager.post(new TroopNotifyAndRecommendView.8(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "sendReadConfirm is end!");
    }
  }
  
  public static long d(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l = paramList.msg_seq.get();
          if (l > 0L) {
            return l;
          }
        }
      }
    }
    return 0L;
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
      QLog.d("TroopNotifyAndRecommendView", 2, "checkInviteeIsFriend stranger list is empty ");
    }
    return false;
  }
  
  public static List<MessageRecord> g(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return paramList1;
    }
    if (d(paramList1) >= d(paramList2))
    {
      paramList1.addAll(paramList2);
      return paramList1;
    }
    paramList2.addAll(paramList1);
    return paramList2;
  }
  
  private void initListData()
  {
    this.cbJ = anze.a().ag(this.app);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Yvp);
    this.tx = this.app.b().k(acbn.bkL, 0);
    yym.setAndCheckNotifyFollowSeq(this.tx, this.app);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < this.tx.size())
    {
      localArrayList.add(this.tx.get(this.tx.size() - j - 1));
      j += 1;
    }
    this.tx = localArrayList;
    if ((this.tx != null) && (this.tx.size() > 0))
    {
      if (this.ys.getVisibility() == 8) {
        anot.a(this.app, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      this.ys.setVisibility(0);
      if ((this.tx.get(0) instanceof MessageForSystemMsg)) {
        break label243;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "initListData error");
      }
      this.app.cLI();
      this.jdField_a_of_type_Yvp.gQ(null);
    }
    label243:
    do
    {
      return;
      this.ys.setVisibility(8);
      this.jdField_a_of_type_Yvp.gQ(this.tx);
      if ((this.tz.isEmpty()) && (this.tx.isEmpty()) && (this.ty.isEmpty()) && (this.yp != null))
      {
        this.yp.setVisibility(8);
        return;
      }
    } while (this.yp == null);
    this.yp.setVisibility(0);
  }
  
  public static void setAndCheckNotifyFollowSeq(List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    if (paramList.size() >= 40)
    {
      paramList = (MessageRecord)paramList.get(39);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l = paramList.msg_seq.get();
          if (l > 0L) {
            paramQQAppInterface.a().aN("following_group_seq", l);
          }
        }
      }
    }
  }
  
  private void stopLoadMore()
  {
    if (this.mLoadingView != null) {
      this.mLoadingView.setVisibility(8);
    }
    this.bpk = false;
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "stopLoadMore().");
    }
  }
  
  public void AX(boolean paramBoolean)
  {
    if ((this.yq == null) || (this.Mi == null) || (this.uH == null)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.Mi.getText());
    if ((paramBoolean) && (this.mType == 1))
    {
      this.Mi.setTextColor(-16725252);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, this.Mi.getText().length(), 18);
      this.uH.setVisibility(0);
      AY(false);
      AZ(false);
      this.Mi.setText(localSpannableStringBuilder);
      return;
    }
    this.Mi.setTextColor(-7894119);
    this.uH.setVisibility(8);
    gU(this.tz);
  }
  
  public void AY(boolean paramBoolean)
  {
    if ((this.yr == null) || (this.uI == null) || (this.Mj == null)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.Mj.getText());
    if ((paramBoolean) && (this.mType == 2))
    {
      this.Mj.setTextColor(-16725252);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, this.Mj.getText().length(), 18);
      this.uI.setVisibility(0);
      AZ(false);
      AX(false);
      this.Mj.setText(localSpannableStringBuilder);
      return;
    }
    this.Mj.setTextColor(-7894119);
    this.uI.setVisibility(8);
    this.Mj.setText("退群");
  }
  
  public void AZ(boolean paramBoolean)
  {
    if ((this.ys == null) || (this.uJ == null) || (this.Mk == null)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.Mk.getText());
    if ((paramBoolean) && (this.mType == 3))
    {
      this.Mk.setTextColor(-16725252);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, this.Mk.getText().length(), 33);
      this.Mk.setText(localSpannableStringBuilder);
      this.uJ.setVisibility(0);
      AX(false);
      AY(false);
      return;
    }
    this.Mk.setTextColor(-7894119);
    this.uJ.setVisibility(8);
    this.Mk.setText("已过滤");
  }
  
  protected void a(Intent paramIntent, BaseTroopView.a parama)
  {
    super.a(paramIntent, parama);
    this.jdField_b_of_type_Ackn = ((ackn)this.app.getManager(22));
    this.jdField_b_of_type_Ajdr = ((ajdr)this.app.getManager(37));
    initView();
    b(paramIntent, parama);
    c(paramIntent, parama);
    this.Mn = parama.K();
    anot.a(this.app, "dc00899", "Grp_contacts_news", "", "notice", "notice_exp", 0, 0, "", "", "", "");
  }
  
  public void a(ywa.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleGroupSystemMsg! start " + parama._id);
    }
    b(parama, 998);
    Object localObject = parama.a.msg.group_info.msg_alert.get();
    String str4 = parama.a.msg.group_code.get() + "";
    String str2;
    int j;
    label146:
    String str1;
    if ((this.jdField_b_of_type_Ywk != null) && (parama.mPosition < this.jdField_b_of_type_Ywk.unreadMsgNum))
    {
      str2 = "1";
      j = parama.a.msg.group_inviter_role.get();
      if ((j != 2) && (j != 3)) {
        break label306;
      }
      j = 0;
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
      label306:
      j = 1;
      break label146;
      str1 = "enter_askjoin";
      if ((localObject == null) || ("".equals(localObject))) {}
      for (localObject = "1";; localObject = "0")
      {
        if (parama.a.msg.sub_type.get() != 1) {
          break label367;
        }
        parama = "0";
        break;
      }
      label367:
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
      if (j != 0) {}
      String str3;
      for (parama = "0";; parama = "1")
      {
        str1 = "refuseinvite_page";
        str3 = "";
        localObject = parama;
        parama = str3;
        break;
      }
      if (j != 0) {}
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
    int k = -1;
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "bindTroopSystemMsgView! start " + parama._id);
    }
    structmsg.StructMsg localStructMsg = parama.a;
    parama._id = paramInt;
    parama.senderUin = (localStructMsg.req_uin.get() + "");
    parama.bDQ = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    parama.KO = localStructMsg.msg_time.get();
    parama.nickname = localStructMsg.msg.req_uin_nick.get();
    String str;
    if ((parama.nickname != null) && (!parama.nickname.equals("")))
    {
      a(parama, localStructMsg);
      parama.uF.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      a(parama, localStructMsg, str);
      b(parama, localStructMsg);
      b(parama, localStructMsg, paramInt, str);
      if ((paramInt == 2) && (parama.bDQ == 2) && (((TroopManager)this.app.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        aizr.a().n(String.valueOf(localStructMsg.msg.group_code.get()), this.app);
      }
      if (localStructMsg.msg.bytes_warning_tips.get() == null) {
        break label594;
      }
      str = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      label311:
      if (TextUtils.isEmpty(str)) {
        break label601;
      }
      parama.LZ.setText(str);
      parama.LZ.setVisibility(0);
      label336:
      if (QLog.isColorLevel()) {
        QLog.d("Q.security_verify", 2, String.format("bindTroopSystemMsgView reqUin: %s, warningTips: %s", new Object[] { parama.senderUin, str }));
      }
      parama.hC.setTag(parama);
      parama.hC.setOnClickListener(this.ep);
      parama.uw.setTag(parama);
      if ((parama.bDQ != 8) && (parama.bDQ != 7)) {
        break label613;
      }
      parama.uw.setEnabled(false);
      label424:
      b(parama);
      if (((parama.bDQ == 1) || (parama.bDQ == 22) || (parama.bDQ == 60)) && (QLog.isColorLevel())) {
        if ((!localStructMsg.msg.has()) || (!localStructMsg.msg.src_id.has())) {
          break label624;
        }
      }
    }
    label594:
    label601:
    label613:
    label624:
    for (paramInt = localStructMsg.msg.src_id.get();; paramInt = -1)
    {
      int j = k;
      if (localStructMsg.msg.has())
      {
        j = k;
        if (localStructMsg.msg.sub_src_id.has()) {
          j = localStructMsg.msg.sub_src_id.get();
        }
      }
      QLog.i("TroopNotifyAndRecommendView", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(parama.bDQ) }));
      return;
      parama.nickname = parama.senderUin;
      break;
      str = "";
      break label311;
      parama.LZ.setVisibility(8);
      break label336;
      parama.uw.setOnClickListener(this);
      break label424;
    }
  }
  
  public void aK(boolean paramBoolean, int paramInt)
  {
    TextView localTextView;
    if (1 == paramInt) {
      localTextView = this.Ml;
    }
    for (;;)
    {
      if (localTextView == null)
      {
        return;
        if (2 == paramInt) {
          localTextView = this.Mm;
        }
      }
      else
      {
        Drawable localDrawable = this.P.getResources().getDrawable(2130838050);
        localDrawable.setBounds(new Rect(0, 0, 9, 9));
        localTextView.setBackgroundResource(0);
        localTextView.setText("");
        localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
        if ((this.mType == paramInt) && ((this.mType == 1) || (this.mType == 2)))
        {
          localTextView.setVisibility(8);
          return;
        }
        if (paramBoolean)
        {
          localTextView.setVisibility(0);
          return;
        }
        localTextView.setVisibility(8);
        return;
      }
      localTextView = null;
    }
  }
  
  protected void b(Intent paramIntent, BaseTroopView.a parama)
  {
    addObserver(this.jdField_b_of_type_Achq);
    cms();
    cmF();
    this.J = new arhz(this.P, getTitleBarHeight());
    this.app.setHandler(getClass(), this.g);
    if (yxe.v(this.app) > 0) {
      this.app.a().a().Kg(3);
    }
    yxe.bk(this.app);
    if (this.jdField_b_of_type_Ywk != null) {
      this.jdField_b_of_type_Ywk.notifyDataSetChanged();
    }
    int j = anze.a().af(this.app);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "notification num:" + j);
    }
    this.jdField_b_of_type_Ackn.cxG = j;
    int k = ackn.F(this.app);
    this.app.a().G(acbn.bkT, 9000, 0 - (j + k));
    anze.a().N(this.app, 0);
    this.isFinished = false;
  }
  
  protected void c(Intent paramIntent, BaseTroopView.a parama)
  {
    super.a(paramIntent, parama);
    this.app.b().addObserver(this);
    addObserver(this.jdField_a_of_type_Acnd);
    cmH();
  }
  
  public void cmG()
  {
    aqha.a(this.P, null, this.P.getString(2131721444), null, 2131721058, 2131696878, new yxi(this), new yxj(this)).show();
  }
  
  public void cmH()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 4, "onChecked........");
    }
    this.bpB = this.app.getPreferences().getBoolean("show_new_troop_recommend", false);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "getNotificationRecommendTroopList showOpen is :" + this.bpB);
    }
    if ((this.bpE) && (this.bpB))
    {
      this.bpE = false;
      this.jdField_b_of_type_Ackn.abC();
    }
    if ((!this.bpB) && (this.jdField_b_of_type_Ywk != null))
    {
      this.jdField_b_of_type_Ywk.bpq = true;
      this.jdField_b_of_type_Ywk.notifyDataSetChanged();
    }
    xQ();
    cmI();
  }
  
  protected void cmI()
  {
    if ((this.bix) && (this.jdField_b_of_type_Ywk != null) && (this.jdField_b_of_type_Ywk.UJ()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 4, "reportPv");
      }
      anot.a(this.app, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
    }
  }
  
  public void cmJ()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 4, "refreshRecommendTroopList");
    }
    if (this.bpF) {}
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d("TroopNotifyAndRecommendView", 4, "refreshRecommendTroopList start ");
  }
  
  protected void cmK()
  {
    if ((this.jdField_b_of_type_Ackn != null) && (!this.isChecked) && (ackn.F(this.app) > 0))
    {
      aJ(1, true);
      return;
    }
    aJ(1, false);
  }
  
  public void cmL()
  {
    cmN();
    cmM();
    initListData();
  }
  
  public void cmR()
  {
    cmt();
    this.app.cLH();
    anze.a().O(this.app, 0);
    this.tx.clear();
    if (this.jdField_a_of_type_Yvp != null) {
      this.jdField_a_of_type_Yvp.clearDatas();
    }
    if (this.ys != null) {
      this.ys.setVisibility(8);
    }
    this.g.sendEmptyMessage(1012);
  }
  
  public void cmu()
  {
    cmt();
    this.app.cLG();
    anze.a().N(this.app, 0);
    this.mDataList.clear();
    this.tx.clear();
    this.tz.clear();
    this.ty.clear();
    yxz.cmT();
    if (this.jdField_b_of_type_Ywk != null)
    {
      this.jdField_b_of_type_Ywk.cmw();
      this.jdField_b_of_type_Ywk.notifyDataSetChanged();
    }
    gV(this.ty);
    gU(this.tz);
    aK(false, 1);
    aK(false, 2);
    this.g.sendEmptyMessage(1012);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.mLastY = k;
      this.mLastX = j;
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      int m = j - this.mLastX;
      int n = k - this.mLastY;
      if ((m > 20) || (m < -20)) {
        this.bpG = true;
      }
      if (((n > 20) || (n < -20)) && (!this.bpG))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        continue;
        this.bpG = false;
      }
    }
  }
  
  public void gT(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleRecommendDataResult: " + Log.getStackTraceString(new RuntimeException("debug trace")));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.runOnUiThread(new TroopNotifyAndRecommendView.17(this, paramList));
  }
  
  public void gU(List<MessageRecord> paramList)
  {
    if ((this.yq == null) || (this.Mi == null)) {
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.yq.setVisibility(8);
      return;
    }
    int j = paramList.size();
    paramList = String.valueOf(j);
    if (j > 99) {
      paramList = "99+";
    }
    paramList = "待处理(" + paramList + ")";
    if (this.yq.getVisibility() == 8) {
      anot.a(this.app, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_exp", 0, 0, "", "", "", "");
    }
    if (this.mType == 1)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramList);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramList.length(), 18);
      this.Mi.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      this.yq.setVisibility(0);
      return;
      this.Mi.setText(paramList);
    }
  }
  
  public void gV(List<MessageRecord> paramList)
  {
    if ((this.Mj == null) || (this.yr == null)) {
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.yr.setVisibility(8);
      return;
    }
    if (this.yq.getVisibility() == 8) {
      anot.a(this.app, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_exp", 0, 0, "", "", "", "");
    }
    this.yr.setVisibility(0);
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      cmJ();
      xQ();
    }
  }
  
  public void initView()
  {
    setContentView(2131560091);
    this.jdField_b_of_type_Ywk = new ywk(this.app, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a, this);
    this.i = ((SwipListView)findViewById(2131380333));
    this.yp = findViewById(2131364612);
    this.yq = findViewById(2131379108);
    this.yr = findViewById(2131379103);
    this.ys = findViewById(2131379112);
    this.Mi = ((TextView)findViewById(2131379111));
    this.uH = ((ImageView)findViewById(2131379109));
    this.Ml = ((TextView)findViewById(2131379110));
    this.Mj = ((TextView)findViewById(2131379106));
    this.uI = ((ImageView)findViewById(2131379104));
    this.Mm = ((TextView)findViewById(2131379105));
    this.Mk = ((TextView)findViewById(2131379113));
    this.uJ = ((ImageView)findViewById(2131379114));
    cmL();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setVisibility(8);
    this.i.setDragEnable(true);
    this.i.setAdapter(this.jdField_b_of_type_Ywk);
    this.i.setOnScrollListener(this);
    this.ys.setOnClickListener(new yxf(this));
    this.yr.setOnClickListener(new yxo(this));
    this.yq.setOnClickListener(new yxu(this));
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - lastClickTime > 0L) && (l - lastClickTime < 800L)) {}
    Object localObject2;
    Object localObject3;
    int j;
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      lastClickTime = l;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131372238: 
        aozz.b(getActivity(), this.app);
        break;
      case 2131374278: 
        if ((paramView.getTag() instanceof ywa.a))
        {
          localObject2 = (ywa.a)paramView.getTag();
          if (localObject2 != null)
          {
            localObject3 = ((ywa.a)localObject2).a;
            j = ((ywa.a)localObject2).bDQ;
            if (yxe.fx(j) == 0)
            {
              localObject1 = TroopInfoActivity.c(String.valueOf(((ywa.a)localObject2).a.msg.group_code.get()), 4);
              ((Bundle)localObject1).putInt("t_s_f", 1001);
              apuh.a(getActivity(), (Bundle)localObject1, 2);
              if ((j == 2) || (j == 10) || (j == 12))
              {
                j = 1;
                label192:
                localObject3 = this.app;
                String str = ((ywa.a)localObject2).a.msg.group_code.get() + "";
                if (j == 0) {
                  break label343;
                }
                localObject1 = "0";
                label241:
                anot.a((QQAppInterface)localObject3, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, (String)localObject1, "", "");
                localObject2 = ((ywa.a)localObject2).a.msg.group_code + "";
                if (j == 0) {
                  break label350;
                }
              }
              label343:
              label350:
              for (localObject1 = "0";; localObject1 = "1")
              {
                aqfr.b("Grp_contacts_news", "notice", "see_data", 0, 0, new String[] { localObject2, localObject1 });
                break;
                j = 0;
                break label192;
                localObject1 = "1";
                break label241;
              }
            }
            if ((((ywa.a)localObject2).bDQ != 2) || (!TroopInfo.isQidianPrivateTroop(((ywa.a)localObject2).a.msg.uint32_group_flagext3.get())))
            {
              if (((ywa.a)localObject2).bDQ != 82) {
                break label474;
              }
              localObject1 = new Intent(this.P, AccountDetailActivity.class);
              ((Intent)localObject1).putExtra("uin", ((ywa.a)localObject2).a.req_uin.get() + "");
              ((Intent)localObject1).putExtra("source", 112);
              startActivity((Intent)localObject1);
            }
          }
        }
        break;
      }
    }
    label474:
    l = ((structmsg.StructMsg)localObject3).req_uin.get();
    switch (yxe.fx(j))
    {
    default: 
      localObject1 = String.valueOf(l);
      label514:
      if (((acff)this.app.getManager(51)).isFriend((String)localObject1)) {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
      }
      break;
    }
    for (;;)
    {
      l = ((structmsg.StructMsg)localObject3).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l);
      j = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + j + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
      }
      if ((bool) && (j == 2)) {
        break;
      }
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject1);
      aqfr.b("Grp_contacts_news", "notice", "see_fromdata", 0, 0, new String[] { ((ywa.a)localObject2).a.msg.group_code + "", "3" });
      break;
      localObject1 = ((ywa.a)localObject2).senderUin;
      break label514;
      localObject1 = String.valueOf(((ywa.a)localObject2).a.msg.action_uin.get());
      break label514;
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
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView, paramString, paramBitmap);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_b_of_type_Ywk != null) {
      this.jdField_b_of_type_Ywk.cmx();
    }
    if ((this.jdField_b_of_type_Ywk != null) && (this.jdField_b_of_type_Ywk.xN() > 0)) {
      cmt();
    }
    removeObserver(this.jdField_a_of_type_Acnd);
    MqqHandler localMqqHandler = this.app.getHandler(TroopNotifyAndRecommendView.class);
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    removeObserver(this.jdField_b_of_type_Achq);
    if (this.jdField_b_of_type_Ywk != null)
    {
      this.jdField_b_of_type_Ywk.cmw();
      this.jdField_b_of_type_Ywk.notifyDataSetChanged();
    }
    this.app.b().deleteObserver(this);
    yxe.cmE();
    anze.a().N(this.app, 0);
    if (this.isFinished) {
      anze.a().dTY();
    }
    apyh.a(getActivity()).clear();
    this.app.removeHandler(getClass());
    if (this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a != null) {
      SosoInterface.c(this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a);
    }
    this.jdField_b_of_type_Ackn.cmt();
    this.jdField_b_of_type_Ackn.cMd();
    this.jdField_b_of_type_Ackn.cMa();
    if (this.jdField_b_of_type_Ajdr != null) {
      this.jdField_b_of_type_Ajdr.LQ(false);
    }
    if (this.d != null) {
      this.d.a(null);
    }
    if (this.jdField_a_of_type_Yvp != null)
    {
      this.jdField_a_of_type_Yvp.clearDatas();
      this.jdField_a_of_type_Yvp.notifyDataSetChanged();
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
    if (this.bpA)
    {
      yxe.cmE();
      anze.a().N(this.app, 0);
      if (this.jdField_b_of_type_Ywk != null)
      {
        this.jdField_b_of_type_Ywk.unreadMsgNum = 0;
        this.jdField_b_of_type_Ywk.notifyDataSetChanged();
      }
      this.jdField_b_of_type_Ackn.cxG = anze.a().af(this.app);
    }
    if (this.mType == 3) {
      anze.a().O(this.app, 0);
    }
    this.bpA = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLastVisibleIndex = (paramInt1 + paramInt2 - 1);
    if (this.jdField_b_of_type_Ywk != null) {
      this.jdField_b_of_type_Ywk.fW(this.mLastVisibleIndex, this.mType);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "ray test firstvis:" + paramInt1 + " viscount:" + paramInt2);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder().append("ray test lastindex:").append(this.mLastVisibleIndex).append("list count");
      if (this.jdField_b_of_type_Ywk == null) {
        break label100;
      }
    }
    label100:
    for (int j = this.jdField_b_of_type_Ywk.getCount();; j = 0)
    {
      QLog.d("TroopNotifyAndRecommendView", 2, j);
      if ((this.jdField_b_of_type_Ywk != null) && (paramInt == 0) && (this.mLastVisibleIndex == this.jdField_b_of_type_Ywk.getCount() - 1)) {
        aMG();
      }
      this.mCurrentScrollState = paramInt;
      return;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.jdField_b_of_type_Ackn != null) {
      this.jdField_b_of_type_Ackn.cmt();
    }
    if (this.mType == 3)
    {
      this.d.pause();
      this.d.edu();
    }
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
  
  protected int xQ()
  {
    int m = ackn.F(this.app);
    if (m > 0)
    {
      this.app.a().G(acbn.bkT, 9000, 0 - m);
      this.jdField_b_of_type_Ackn.cmt();
      cmK();
    }
    int k = 0;
    int j = k;
    if (this.jdField_b_of_type_Ackn != null)
    {
      j = k;
      if (!this.isChecked)
      {
        j = k;
        if (m > 0) {
          j = 1;
        }
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView
 * JD-Core Version:    0.7.0.1
 */