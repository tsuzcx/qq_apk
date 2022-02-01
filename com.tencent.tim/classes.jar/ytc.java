import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView.a;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Locale;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class ytc
  extends ysa
  implements View.OnClickListener
{
  public long Ky;
  private ysf a;
  private structmsg.StructMsg c;
  private String dF;
  private long mUniseq;
  
  public ytc(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
    this.c = ((ytq)paramytv).a.getSystemMsg();
    this.mUniseq = ((ytq)paramytv).a.uniseq;
    this.jdField_a_of_type_Auvd = a(paramContext);
    this.jdField_a_of_type_Ysf = ((ysf)paramQQAppInterface.getManager(34));
    if (this.c.msg.uint32_source_flag.has()) {}
    for (int i = this.c.msg.uint32_source_flag.get();; i = 0)
    {
      if ((i & 0x8) == 8)
      {
        if (this.c.msg.uint64_discuss_uin.has()) {
          this.Ky = this.c.msg.uint64_discuss_uin.get();
        }
        if (!this.c.msg.msg_source.has()) {
          break label360;
        }
      }
      label341:
      label360:
      for (paramytd = this.c.msg.msg_source.get();; paramytd = null)
      {
        if (this.Ky != 0L)
        {
          this.dF = aqgv.u(paramQQAppInterface, String.valueOf(this.Ky));
          if (TextUtils.isEmpty(this.dF))
          {
            paramQQAppInterface = (acdt)paramQQAppInterface.getBusinessHandler(6);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.hk(this.Ky);
            }
            if (QLog.isColorLevel())
            {
              paramytv = Locale.getDefault();
              long l = this.Ky;
              if (paramQQAppInterface != null) {
                break label341;
              }
              paramQQAppInterface = "handler is null";
              QLog.i("addFriendTag", 2, String.format(paramytv, "SystemMsgItemBuilder need get discuss info %d  %s", new Object[] { Long.valueOf(l), paramQQAppInterface }));
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.Ky), this.dF, paramytd }));
        }
        for (;;)
        {
          this.mItemHeight = paramContext.getResources().getDimensionPixelSize(2131297806);
          return;
          paramQQAppInterface = "handler is not null";
          break;
          this.dF = null;
          this.Ky = 0L;
        }
      }
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      anzd.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      anzd.a().lC(l);
      anzd.a().lB(paramLong);
    }
  }
  
  private void a(ytc.a parama)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgItemBuilder", 2, "handleBuddySystemMsg! start " + parama._id);
    }
    int j = this.c.msg.sub_type.get();
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (ytq.a(this.mApp, String.valueOf(this.c.req_uin.get()), this.c, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(this.c.req_uin.get()), parama.Lx.getText().toString(), "", this.c.msg.src_id.get(), this.c.msg.sub_src_id.get());
    }
    switch (j)
    {
    case 11: 
    default: 
      i = 0;
    case 1: 
    case 9: 
    case 10: 
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      for (;;)
      {
        Object localObject2 = this.c.msg.req_uin_nick.get();
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(this.c.req_uin.get());
        }
        localObject2 = new Intent(this.mContext, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", parama._id);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(this.c.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", this.c.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", this.c.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", this.c.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", this.c.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", this.c.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", this.c.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", this.c.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", this.c.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", this.c.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
          anot.a(this.mApp, "CliOper", "", "", "0X800843B", "0X800843B", 0, 0, "", "", "", "");
        }
        a((structmsg.StructMsg)this.c.get(), this.mUniseq);
        ((NewFriendActivity)this.mContext).startActivityForResult((Intent)localObject2, 227);
        this.jdField_a_of_type_Ysf.clt();
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    }
    parama = new Intent();
    parama.putExtra("param_wzry_data", localWZRYUIinfo);
    ytb.a(this.mApp, this.mContext, String.valueOf(this.c.req_uin.get()), this.c.msg.group_code.get(), j, this.c.msg.src_id.get(), parama);
  }
  
  private void a(ytc.a parama, int paramInt, View.OnClickListener paramOnClickListener)
  {
    parama._id = paramInt;
    parama.aZH = String.valueOf(this.c.req_uin.get());
    parama.a = this.c;
    a(parama, paramInt, String.valueOf(this.c.req_uin.get()));
    this.jdField_a_of_type_Ytd.h(parama);
    parama.uw.setTag(parama);
    parama.LB.setVisibility(8);
    f(parama);
    a(parama, paramOnClickListener);
  }
  
  private void a(ytc.a parama, int paramInt, String paramString)
  {
    Object localObject1 = (acff)this.mApp.getManager(51);
    Object localObject2 = this.c.msg.req_uin_nick.get();
    localObject1 = ((acff)localObject1).b(String.valueOf(this.c.req_uin.get()));
    if ((localObject1 != null) && (!TextUtils.isEmpty(((Friends)localObject1).remark))) {
      localObject2 = ((Friends)localObject1).remark;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (ytq.a(this.mApp, paramString, this.c, true))
      {
        localObject1 = localObject2;
        if (this.c.msg.bytes_game_nick.has())
        {
          String str = new String(this.c.msg.bytes_game_nick.get().toByteArray());
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = KplRoleInfo.WZRYUIinfo.buildNickName((String)localObject2, str);
          }
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramString;
      }
      parama.Lx.setText((CharSequence)localObject2);
      if (this.c.msg.bytes_name_more.has()) {}
      for (localObject1 = new String(this.c.msg.bytes_name_more.get().toByteArray());; localObject1 = null)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          parama.LR.setVisibility(8);
          if ((TextUtils.isEmpty(paramString)) || (!aqft.rj(paramString))) {
            break label446;
          }
          paramString = this.mContext.getResources().getDrawable(2130842599);
          paramString.setBounds(0, 0, wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(15.0F, this.mContext.getResources()));
          parama.Lx.setCompoundDrawables(null, null, paramString, null);
          parama.Lx.setCompoundDrawablePadding(wja.dp2px(5.0F, this.mContext.getResources()));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|position is : " + paramInt + ",name is : " + (String)localObject2 + ",source is : " + this.c.msg.msg_source.get());
          }
          return;
          parama.LR.setVisibility(0);
          localObject1 = "（" + (String)localObject1 + "）";
          parama.LR.setText((CharSequence)localObject1);
          break;
          label446:
          parama.Lx.setCompoundDrawables(null, null, null, null);
        }
      }
    }
  }
  
  private void a(ytc.a parama, View.OnClickListener paramOnClickListener)
  {
    if (this.c.msg != null)
    {
      e(parama);
      int i = this.c.msg.sub_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|myAllowFlag : " + i);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      parama.ej.setTag(parama);
      parama.ej.setOnClickListener(paramOnClickListener);
      return;
      b(parama);
      continue;
      parama.LA.setVisibility(0);
      String str = this.c.msg.msg_decided.get();
      parama.LA.setText(str);
      parama.ej.setVisibility(8);
      g(parama);
      continue;
      parama.LA.setVisibility(8);
      parama.ej.setVisibility(8);
      continue;
      d(parama);
      continue;
      parama.LA.setVisibility(0);
      str = this.c.msg.msg_decided.get();
      parama.LA.setText(str);
      parama.ej.setVisibility(8);
      continue;
      c(parama);
      continue;
      if (this.c.msg.reqsubtype.has()) {
        if (this.c.msg.reqsubtype.get() == 1)
        {
          parama.LA.setVisibility(0);
          str = this.c.msg.msg_decided.get();
          parama.LA.setText(str);
          parama.ej.setVisibility(8);
        }
        else if (this.c.msg.reqsubtype.get() == 2)
        {
          parama.LA.setVisibility(8);
          parama.ej.setVisibility(8);
          continue;
          parama.LA.setVisibility(0);
          str = this.c.msg.msg_decided.get();
          parama.LA.setText(str);
          parama.ej.setVisibility(8);
          parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
  }
  
  private void b(ytc.a parama)
  {
    String str;
    if ((this.c.msg.actions.get() != null) && (this.c.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.c.msg.actions.get().get(0)).name.get())))
    {
      parama.LA.setVisibility(8);
      parama.ej.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.c.msg.actions.get().get(0)).name.get();
      parama.ej.setText(str);
    }
    for (;;)
    {
      g(parama);
      return;
      if ((this.c.msg.actions.get() != null) && (this.c.msg.actions.get().size() == 0))
      {
        parama.LA.setVisibility(0);
        str = this.c.msg.msg_decided.get();
        parama.LA.setText(str);
        parama.ej.setVisibility(8);
      }
    }
  }
  
  private void c(ytc.a parama)
  {
    String str;
    if ((this.c.msg.actions.get() != null) && (this.c.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.c.msg.actions.get().get(0)).name.get())))
    {
      parama.LA.setVisibility(8);
      parama.ej.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.c.msg.actions.get().get(0)).name.get();
      parama.ej.setText(str);
    }
    for (;;)
    {
      g(parama);
      return;
      parama.LA.setVisibility(0);
      str = this.c.msg.msg_decided.get();
      parama.LA.setText(str);
      parama.ej.setVisibility(8);
    }
  }
  
  private void d(ytc.a parama)
  {
    if (!TextUtils.isEmpty(this.c.msg.msg_additional.get()))
    {
      parama.jdField_Lz_of_type_AndroidWidgetTextView.setText(this.c.msg.msg_additional.get());
      parama.Ly.setText(this.c.msg.msg_describe.get());
    }
    for (;;)
    {
      parama.ej.setVisibility(8);
      parama.LA.setVisibility(8);
      return;
      parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void e(ytc.a parama)
  {
    if (!TextUtils.isEmpty(this.c.msg.msg_additional.get()))
    {
      if (!TextUtils.isEmpty(this.c.msg.msg_qna.get()))
      {
        parama.Ly.setText(this.c.msg.msg_qna.get());
        return;
      }
      parama.Ly.setText(this.c.msg.msg_additional.get());
      return;
    }
    parama.Ly.setText(this.c.msg.msg_describe.get());
  }
  
  private void f(ytc.a parama)
  {
    String str = null;
    if (this.c.msg.msg_source.has()) {
      str = this.c.msg.msg_source.get();
    }
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(this.dF)) {}
      for (str = String.format(Locale.getDefault(), acfp.m(2131715105), new Object[] { str, this.dF });; str = String.format(Locale.getDefault(), acfp.m(2131715108), new Object[] { str }))
      {
        parama.jdField_Lz_of_type_AndroidWidgetTextView.setText(str);
        parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
    }
    parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void g(ytc.a parama)
  {
    int i = -1;
    int j = 0;
    if (this.c.msg.req_uin_gender.has()) {
      i = this.c.msg.req_uin_gender.get();
    }
    if (this.c.msg.req_uin_age.has()) {
      j = this.c.msg.req_uin_age.get();
    }
    a(parama.LB, i, j, null);
  }
  
  public View a(int paramInt, View paramView)
  {
    ytc.a locala;
    if ((paramView == null) || (!(paramView.getTag() instanceof ytc.a)))
    {
      locala = new ytc.a();
      paramView = a(this.mContext, 2131561720, locala);
      Y(paramView, this.mItemHeight);
      locala.uw = ((ImageView)paramView.findViewById(2131361802));
      locala.Lx = ((TextView)paramView.findViewById(2131372384));
      locala.LR = ((TextView)paramView.findViewById(2131378516));
      locala.Ly = ((TextView)paramView.findViewById(2131377214));
      locala.LB = ((TextView)paramView.findViewById(2131362339));
      locala.jdField_Lz_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378586));
      locala.LA = ((TextView)paramView.findViewById(2131377211));
      locala.ej = ((Button)paramView.findViewById(2131377201));
      fI(locala.uw);
      paramView.setTag(locala);
      locala.jdField_Lz_of_type_AndroidViewView.setTag(locala);
      locala.jdField_Lz_of_type_AndroidViewView.setOnClickListener(this);
      a(this.mContext, paramView, paramInt, this.jdField_a_of_type_Ytv, locala, this);
      if (this.jdField_a_of_type_Ytv.isReaded()) {
        break label294;
      }
      C(locala.jdField_Lz_of_type_AndroidViewView, true);
      if (aqft.rj(String.valueOf(this.c.req_uin.get()))) {
        anot.a(this.mApp, "dc00898", "", "", "0X800826D", "0X800826D", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      a(locala, paramInt, this);
      return paramView;
      locala = (ytc.a)paramView.getTag();
      break;
      label294:
      C(locala.jdField_Lz_of_type_AndroidViewView, false);
    }
  }
  
  protected void clg()
  {
    MessageForSystemMsg localMessageForSystemMsg = ((ytq)this.jdField_a_of_type_Ytv).a;
    this.jdField_a_of_type_Ytd.b.showProgressDialog();
    this.mApp.a().a().a(this.c, localMessageForSystemMsg.frienduin, localMessageForSystemMsg.istroop, localMessageForSystemMsg.uniseq);
    anot.a(this.mApp, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
    if (ytq.a(this.mApp, String.valueOf(this.c.req_uin.get()), this.c, true)) {
      anot.a(this.mApp, "CliOper", "", "", "0X800843D", "0X800843D", 0, 0, "", "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      fJ(paramView);
    }
    int i;
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof ytc.a)))
      {
        localObject1 = (ytc.a)localObject1;
        if (this.c.msg_type.get() == 1)
        {
          a((ytc.a)localObject1);
          switch (this.c.msg.sub_type.get())
          {
          default: 
            break;
          case 1: 
            anot.a(this.mApp, "dc00898", "", "", "0X80076FF", "0X80076FF", 0, 0, "", "", "", "");
            break;
          case 2: 
          case 3: 
            anot.a(this.mApp, "dc00898", "", "", "0X8007701", "0X8007701", 0, 0, "", "", "", "");
            break;
          case 13: 
            anot.a(this.mApp, "dc00898", "", "", "0X8007702", "0X8007702", 0, 0, "", "", "", "");
            break;
          case 6: 
            anot.a(this.mApp, "dc00898", "", "", "0X8007703", "0X8007703", 0, 0, "", "", "", "");
            continue;
            localObject1 = paramView.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof ytc.a))) {
              if (!aqiw.isNetworkAvailable(this.mContext))
              {
                QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(getTitleBarHeight());
              }
              else
              {
                localObject1 = (ytc.a)localObject1;
                a((structmsg.StructMsg)this.c.get(), this.mUniseq);
                long l1 = anzd.a().hf();
                localObject1 = anzd.a().a(Long.valueOf(l1));
                if (localObject1 == null) {
                  break label913;
                }
                i = ((structmsg.StructMsg)localObject1).msg_type.get();
                l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
                long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
                int j = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
                int k = ((structmsg.StructMsg)localObject1).msg.src_id.get();
                int m = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
                int n = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
                localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
                if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
                  break label860;
                }
                localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
                ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
                ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
                structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
                localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
                localAddFrdSNInfo.uint32_set_sn.set(0);
                ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
                this.mApp.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
                i = 1;
                if (i != 0) {
                  this.jdField_a_of_type_Ytd.b.a.clf();
                }
                anot.a(this.mApp, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
                anot.a(this.mApp, "dc00898", "", "", "0X8007700", "0X8007700", 0, 0, "", "", "", "");
                if (aqft.rj(String.valueOf(this.c.req_uin.get()))) {
                  anot.a(this.mApp, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                }
                if (ytq.a(this.mApp, String.valueOf(this.c.req_uin.get()), this.c, true)) {
                  anot.a(this.mApp, "CliOper", "", "", "0X800843C", "0X800843C", 0, 0, "", "", "", "");
                }
              }
            }
            break;
          }
        }
      }
    }
    label860:
    Object localObject1 = new StringBuilder().append("agree, ");
    if (localObject2 != null)
    {
      i = ((List)localObject2).size();
      label888:
      QLog.d("SystemMsgItemBuilder", 1, i);
    }
    for (;;)
    {
      i = 0;
      break;
      i = -1;
      break label888;
      label913:
      QLog.d("SystemMsgItemBuilder", 1, "agree");
    }
  }
  
  protected int xl()
  {
    return ((ytq)this.jdField_a_of_type_Ytv).a.mSysmsgMenuFlag;
  }
  
  public static class a
    extends ysa.a
  {
    public long _id;
    public structmsg.StructMsg a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ytc
 * JD-Core Version:    0.7.0.1
 */