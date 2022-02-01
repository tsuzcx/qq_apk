import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.10;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.5;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.9;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.c;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class abfd
  extends auvp
  implements View.OnClickListener, aqdf.a, AbsListView.e, SwipListView.c
{
  private static final int[] fA = { 2131371284 };
  private static final int[] fy = { 2131692505 };
  private static final int[] fz = { 2130839769 };
  private arhz A;
  private View AD;
  private Comparator<ytv> G = new abfe(this);
  private TextView Ma;
  private aqdf jdField_a_of_type_Aqdf;
  private auvd jdField_a_of_type_Auvd;
  acdv jdField_b_of_type_Acdv = new abfl(this);
  private acff jdField_b_of_type_Acff;
  private achq jdField_b_of_type_Achq = new abfk(this);
  private final int bDP = 0;
  private boolean bpk;
  private acjf c;
  private int cbc = -1;
  public final ConcurrentHashMap<Long, String> jdField_do = new ConcurrentHashMap();
  private acfd jdField_e_of_type_Acfd = new abfj(this);
  private SwipListView jdField_e_of_type_ComTencentWidgetSwipListView;
  private HashMap<String, Bitmap> eA = new HashMap();
  private PhoneContactManagerImp h;
  public QQAppInterface mApp;
  private Activity mContext;
  private int mFirstPos;
  private FlingHandler mFlingHandler;
  private int mLastVisibleIndex;
  private View mLoadingView;
  private ArrayList<ytv> sF = new ArrayList();
  private View yl;
  
  public abfd(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.mContext = paramActivity;
    this.mApp = paramQQAppInterface;
    this.jdField_b_of_type_Acff = ((acff)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Aqdf = new aqdf(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Aqdf.a(this);
    this.AD = paramView1;
    this.jdField_e_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    cms();
    cmr();
    this.jdField_e_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_e_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_e_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.mApp.addObserver(this.jdField_e_of_type_Acfd);
    this.mApp.addObserver(this.jdField_b_of_type_Achq);
    this.mApp.addObserver(this.jdField_b_of_type_Acdv, true);
    this.jdField_a_of_type_Auvd = a(paramActivity);
    this.mFlingHandler = paramFlingHandler;
    this.mFirstPos = paramInt;
    this.h = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.c = ((acjf)paramQQAppInterface.getManager(257));
    refreshData(true);
    paramView2.setOnClickListener(new abfg(this, paramQQAppInterface));
    if (XV()) {
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).cIR();
    }
  }
  
  private boolean XV()
  {
    return aepi.a().UP();
  }
  
  private View a(Context paramContext, int paramInt, abfd.a parama)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Auvd.a(paramContext, localView, parama, -1);
  }
  
  private auvd a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299263);
    int j = paramContext.getResources().getDimensionPixelSize(2131299264);
    paramContext = fA;
    int[] arrayOfInt1 = fy;
    int[] arrayOfInt2 = fz;
    return new abff(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(abfd.a parama)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgAdapter", 2, "handleBuddySystemMsg! start " + parama.id);
    }
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (ytq.a(this.mApp, String.valueOf(parama.structMsg.req_uin.get()), parama.structMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(parama.structMsg.req_uin.get()), parama.Lx.getText().toString(), "", parama.structMsg.msg.src_id.get(), parama.structMsg.msg.sub_src_id.get());
    }
    int j = parama.structMsg.msg.sub_type.get();
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
        Object localObject2 = parama.structMsg.msg.req_uin_nick.get();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(parama.structMsg.req_uin.get());
        }
        localObject2 = new Intent(this.mContext, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", parama.id);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(parama.structMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", parama.structMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", parama.structMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", parama.structMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", parama.structMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", parama.structMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", parama.structMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", parama.structMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", parama.structMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", parama.structMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
        }
        a((structmsg.StructMsg)parama.structMsg.get(), parama.Nk);
        this.mContext.startActivity((Intent)localObject2);
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("param_wzry_data", localWZRYUIinfo);
    ytb.a(this.mApp, this.mContext, String.valueOf(parama.structMsg.req_uin.get()), parama.structMsg.msg.group_code.get(), j, parama.structMsg.msg.src_id.get(), (Intent)localObject1);
  }
  
  private void a(abfd.a parama, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    parama.id = paramInt;
    parama.bfx = String.valueOf(paramStructMsg.req_uin.get());
    parama.structMsg = paramStructMsg;
    parama.Nk = paramLong;
    parama.type = 0;
    Object localObject2 = (acff)this.mApp.getManager(51);
    Object localObject1 = paramStructMsg.msg.req_uin_nick.get();
    localObject2 = ((acff)localObject2).a(String.valueOf(paramStructMsg.req_uin.get()));
    if ((localObject2 != null) && (!TextUtils.isEmpty(((Friends)localObject2).remark))) {
      localObject1 = ((Friends)localObject2).remark;
    }
    for (;;)
    {
      String str = String.valueOf(paramStructMsg.req_uin.get());
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = str;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        parama.Lx.setVisibility(0);
        parama.Lx.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(str)) || (!aqft.rj(str))) {
          break label605;
        }
        localObject1 = this.mContext.getResources().getDrawable(2130842599);
        ((Drawable)localObject1).setBounds(0, 0, wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(15.0F, this.mContext.getResources()));
        ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
        parama.Lx.setCompoundDrawablePadding(wja.dp2px(5.0F, this.mContext.getResources()));
        parama.Lx.setCompoundDrawables(null, null, (Drawable)localObject1, null);
        label259:
        c(parama);
        parama.xm.setTag(parama);
        parama.LS.setVisibility(8);
        if (paramStructMsg.msg == null) {
          break label1630;
        }
        localObject1 = paramStructMsg.msg.msg_source.get();
        paramInt = paramStructMsg.msg.uint32_source_flag.get();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || ((paramInt & 0x8) != 8)) {
          break label1627;
        }
        paramLong = paramStructMsg.msg.uint64_discuss_uin.get();
        if (paramLong == 0L) {
          break label1627;
        }
        localObject2 = (String)this.jdField_do.get(Long.valueOf(paramLong));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1627;
        }
        localObject1 = String.format(Locale.getDefault(), "%s-%s", new Object[] { localObject1, localObject2 });
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          parama.jdField_Lz_of_type_AndroidWidgetTextView.setText(String.format(Locale.getDefault(), acfp.m(2131709040), new Object[] { localObject1 }));
          parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(0);
          label441:
          if (paramStructMsg.msg != null)
          {
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get())) {
              break label651;
            }
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_qna.get())) {
              break label631;
            }
            parama.Ly.setText(paramStructMsg.msg.msg_qna.get());
            label497:
            switch (paramStructMsg.msg.sub_type.get())
            {
            }
          }
        }
        for (;;)
        {
          parama.ej.setTag(parama);
          parama.ej.setOnClickListener(this);
          return;
          parama.Lx.setVisibility(8);
          break;
          label605:
          parama.Lx.setCompoundDrawables(null, null, null, null);
          break label259;
          parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
          break label441;
          label631:
          parama.Ly.setText(paramStructMsg.msg.msg_additional.get());
          break label497;
          label651:
          parama.Ly.setText(paramStructMsg.msg.msg_describe.get());
          break label497;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            parama.LA.setVisibility(8);
            parama.ej.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            parama.ej.setText(paramStructMsg);
          }
          for (;;)
          {
            b(parama);
            break;
            if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
            {
              parama.LA.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              parama.LA.setText(paramStructMsg);
              parama.ej.setVisibility(8);
            }
          }
          parama.LA.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          parama.LA.setText(paramStructMsg);
          parama.ej.setVisibility(8);
          b(parama);
          continue;
          parama.LA.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          parama.LA.setText(paramStructMsg);
          parama.ej.setVisibility(8);
          b(parama);
          continue;
          parama.LA.setVisibility(8);
          parama.ej.setVisibility(8);
          continue;
          parama.LA.setVisibility(8);
          parama.ej.setVisibility(8);
          continue;
          if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
          {
            parama.jdField_Lz_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.msg_additional.get());
            parama.Ly.setText(paramStructMsg.msg.msg_describe.get());
          }
          for (;;)
          {
            parama.ej.setVisibility(8);
            parama.LA.setVisibility(8);
            break;
            parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          parama.LA.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          parama.LA.setText(paramStructMsg);
          parama.ej.setVisibility(8);
          b(parama);
          continue;
          parama.LA.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          parama.LA.setText(paramStructMsg);
          parama.ej.setVisibility(8);
          continue;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            parama.LA.setVisibility(8);
            parama.ej.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            parama.ej.setText(paramStructMsg);
          }
          for (;;)
          {
            b(parama);
            break;
            parama.LA.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            parama.LA.setText(paramStructMsg);
            parama.ej.setVisibility(8);
          }
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            parama.LA.setVisibility(8);
            parama.ej.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            parama.ej.setText(paramStructMsg);
          }
          for (;;)
          {
            b(parama);
            break;
            parama.LA.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            parama.LA.setText(paramStructMsg);
            parama.ej.setVisibility(8);
          }
          if (paramStructMsg.msg.reqsubtype.has()) {
            if (paramStructMsg.msg.reqsubtype.get() == 1)
            {
              parama.LA.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              parama.LA.setText(paramStructMsg);
              parama.ej.setVisibility(8);
            }
            else if (paramStructMsg.msg.reqsubtype.get() == 2)
            {
              parama.LA.setVisibility(8);
              parama.ej.setVisibility(8);
              continue;
              parama.LA.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              parama.LA.setText(paramStructMsg);
              parama.ej.setVisibility(8);
              parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
            }
          }
        }
        label1627:
        continue;
        label1630:
        localObject1 = null;
      }
    }
  }
  
  private void a(abfd.a parama, PhoneContactAdd paramPhoneContactAdd)
  {
    parama.type = 1;
    parama.jdField_b_of_type_ComTencentMobileqqDataPhoneContactAdd = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      parama.Lx.setVisibility(0);
      parama.Lx.setText(paramPhoneContactAdd.name);
      parama.LS.setVisibility(8);
      parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
      if (TextUtils.isEmpty(paramPhoneContactAdd.remindInfo)) {
        break label158;
      }
      parama.Ly.setVisibility(0);
      parama.Ly.setText(paramPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      parama.LA.setVisibility(0);
      parama.ej.setVisibility(8);
      parama.LA.setText(this.mContext.getString(2131718834));
      parama.bfx = paramPhoneContactAdd.unifiedCode;
      parama.xm.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
      return;
      parama.Lx.setVisibility(8);
      break;
      label158:
      parama.Ly.setVisibility(8);
    }
  }
  
  private void a(abfd.a parama, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    parama.type = 2;
    parama.jdField_b_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    parama.Lx.setText(paramQIMNotifyAddFriend.nickName);
    ysa.a(parama.LS, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((acjf)this.mApp.getManager(257)).g(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      parama.Ly.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.mApp.getManager(217)).wf();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), acfp.m(2131709054), new Object[] { localObject });
      parama.jdField_Lz_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      parama.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(0);
      parama.LA.setVisibility(8);
      parama.ej.setText(acfp.m(2131709042));
      parama.ej.setVisibility(0);
      parama.ej.setTag(parama);
      parama.ej.setOnClickListener(this);
      parama.bfx = String.valueOf(paramQIMNotifyAddFriend.uin);
      parama.xm.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
      return;
      parama.Ly.setVisibility(0);
      parama.Ly.setText((CharSequence)localObject);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, auvd.a parama, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Auvd != null) {}
    for (int i = this.jdField_a_of_type_Auvd.a(paramContext, paramView, paramInt, paramObject, parama, paramOnClickListener);; i = 0)
    {
      if (this.cbc != -1)
      {
        if (paramInt != this.cbc) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
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
  
  private void aMG()
  {
    if (this.bpk) {}
    do
    {
      List localList;
      do
      {
        return;
        if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
        {
          QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(getTitleBarHeight());
          return;
        }
        localList = this.mApp.b().k(acbn.bkJ, 0);
      } while ((localList == null) || (localList.size() < 20) || (anzd.a().bI(this.mApp)));
      this.bpk = true;
      this.mLoadingView.setVisibility(0);
      this.mApp.a().a().cOh();
    } while (!QLog.isColorLevel());
    QLog.i("NewFriendMoreSysMsgAdapter", 2, "loadNextPage.get next page.");
  }
  
  private void b(abfd.a parama)
  {
    if (parama.structMsg.msg.req_uin_gender.has()) {}
    for (int k = parama.structMsg.msg.req_uin_gender.get();; k = -1)
    {
      int j;
      int i;
      switch (k)
      {
      default: 
        parama.LS.setBackgroundResource(2130846773);
        j = 0;
        i = 0;
        m = i;
        if (parama.structMsg.msg.req_uin_age.has())
        {
          if ((parama.structMsg.msg.req_uin_age.get() <= 0) || ((k != 0) && (k != 1))) {
            break label206;
          }
          parama.LS.setText(String.valueOf(parama.structMsg.msg.req_uin_age.get()));
        }
        break;
      }
      for (int m = 1;; m = i)
      {
        parama.LS.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (m != 0) {}
        parama.LS.setVisibility(8);
        return;
        j = 2130846772;
        parama.LS.setBackgroundResource(2130846773);
        i = 1;
        break;
        j = 2130846770;
        parama.LS.setBackgroundResource(2130846771);
        i = 1;
        break;
        label206:
        parama.LS.setText("");
      }
    }
  }
  
  private void bF()
  {
    if ((this.A != null) && (this.A.isShowing())) {
      this.A.dismiss();
    }
    this.A = null;
  }
  
  private void c(abfd.a parama)
  {
    if ((parama == null) || (parama.xm == null)) {
      return;
    }
    int i = parama.structMsg.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (acff)this.mApp.getManager(51);
      if ((localObject1 != null) && (((acff)localObject1).isFriend(String.valueOf(parama.structMsg.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_Aqdf.a(32, String.valueOf(parama.structMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Aqdf.isPausing())
          {
            this.jdField_a_of_type_Aqdf.a(String.valueOf(parama.structMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = aqhu.G();
        }
        parama.xm.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_Aqdf.b(1, String.valueOf(parama.structMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Aqdf.isPausing())
          {
            this.jdField_a_of_type_Aqdf.i(String.valueOf(parama.structMsg.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  private void cBo()
  {
    aqha.a(this.mContext, null, this.mContext.getString(2131701778), null, 2131721058, 2131701777, new abfh(this), new abfi(this)).show();
  }
  
  private void cmr()
  {
    Object localObject;
    if (XV())
    {
      anot.a(this.mApp, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.yl == null) {
        this.yl = LayoutInflater.from(this.mContext).inflate(2131561724, null);
      }
      localObject = this.yl.findViewById(2131379025);
      ((View)localObject).setOnClickListener(this);
      if (!ThemeUtil.isDefaultTheme()) {
        break label203;
      }
      ((View)localObject).setBackgroundResource(2130839642);
    }
    for (;;)
    {
      this.Ma = ((TextView)this.yl.findViewById(2131379026));
      if (this.jdField_e_of_type_ComTencentWidgetSwipListView != null)
      {
        localObject = new AbsListView.LayoutParams(-1, aqnm.dip2px(80.0F));
        this.yl.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_e_of_type_ComTencentWidgetSwipListView.addHeaderView(this.yl);
      }
      int i = ((ysf)this.mApp.getManager(34)).xr();
      if (i <= 0) {
        break;
      }
      this.Ma.setText(i + "");
      return;
      label203:
      ((View)localObject).setBackgroundResource(2130839639);
    }
    this.Ma.setText("");
  }
  
  private void cms()
  {
    if (this.mLoadingView == null) {
      this.mLoadingView = LayoutInflater.from(this.mContext).inflate(2131561721, null);
    }
    if (this.mLoadingView.getParent() == null) {
      this.jdField_e_of_type_ComTencentWidgetSwipListView.addFooterView(this.mLoadingView);
    }
    this.mLoadingView.setVisibility(8);
  }
  
  private int getTitleBarHeight()
  {
    return this.mContext.getResources().getDimensionPixelSize(2131299627);
  }
  
  private void gj(View paramView)
  {
    if (!aqiw.isNetworkAvailable(this.mContext)) {
      QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(getTitleBarHeight());
    }
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            return;
            if (aqft.equalsWithNullCheck("tag_swip_icon_menu_item", paramView.getTag())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick tag is not int");
          return;
          localObject = paramView.getTag(-1);
          paramView = paramView.getTag(-2);
          if (((localObject instanceof Integer)) && ((paramView instanceof Integer))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick posTag or subTag is not int");
        return;
        int i = ((Integer)localObject).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick position = " + i);
        }
        paramView = getItem(i);
      } while (!(paramView instanceof ytv));
      paramView = (ytv)paramView;
      if ((paramView instanceof ytq))
      {
        paramView = (ytq)paramView;
        showProgressDialog();
        this.mApp.a().a().a(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq);
        anot.a(this.mApp, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof yue))
      {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.9(this, paramView), null, true);
        return;
      }
    } while (!(paramView instanceof yug));
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.10(this, paramView), null, true);
  }
  
  private void refreshData()
  {
    refreshData(false);
  }
  
  private void refreshData(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private void showProgressDialog()
  {
    if (this.A == null) {
      this.A = new arhz(this.mContext, getTitleBarHeight());
    }
    this.A.setMessage(this.mContext.getString(2131719519));
    this.A.show();
  }
  
  private void stopLoadMore()
  {
    if (this.mLoadingView != null) {
      this.mLoadingView.setVisibility(8);
    }
    this.bpk = false;
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "stopLoadMore().");
    }
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Aqdf.b(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.a(paramString, paramInt, true, (byte)0);
    }
    return aqhu.G();
  }
  
  public void al(boolean paramBoolean)
  {
    Object localObject;
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)this.mFlingHandler;
      if (((FlingGestureHandler)localObject).mTopLayout != null)
      {
        localObject = ((FlingGestureHandler)localObject).mTopLayout;
        if (paramBoolean) {
          break label49;
        }
      }
    }
    label49:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
      return;
    }
  }
  
  public void d(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.cbc = i;
      return;
    }
  }
  
  public int getCount()
  {
    return this.sF.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.sF.size())) {
      return new Object();
    }
    return this.sF.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    abfd.a locala;
    Object localObject;
    boolean bool;
    if (paramView == null)
    {
      locala = new abfd.a();
      paramView = a(this.mContext, 2131561720, locala);
      locala.xm = ((ImageView)paramView.findViewById(2131361802));
      locala.Lx = ((TextView)paramView.findViewById(2131372384));
      locala.LS = ((TextView)paramView.findViewById(2131362339));
      locala.Ly = ((TextView)paramView.findViewById(2131377214));
      locala.jdField_Lz_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378586));
      locala.ej = ((Button)paramView.findViewById(2131377201));
      locala.LA = ((TextView)paramView.findViewById(2131377211));
      if ((locala.xm instanceof ThemeImageView)) {
        ((ThemeImageView)locala.xm).setSupportMaskView(false);
      }
      paramView.setTag(locala);
      locala.jdField_Lz_of_type_AndroidViewView.setTag(locala);
      locala.jdField_Lz_of_type_AndroidViewView.setOnClickListener(this);
      localObject = (ytv)getItem(paramInt);
      a(this.mContext, paramView, paramInt, localObject, locala, this);
      View localView = locala.jdField_Lz_of_type_AndroidViewView;
      if (((ytv)localObject).isReaded()) {
        break label296;
      }
      bool = true;
      label223:
      ysa.C(localView, bool);
      if (!(localObject instanceof ytq)) {
        break label302;
      }
      localObject = ((ytq)getItem(paramInt)).a;
      a(locala, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (abfd.a)paramView.getTag();
      break;
      label296:
      bool = false;
      break label223;
      label302:
      if ((localObject instanceof yue))
      {
        a(locala, ((yue)getItem(paramInt)).a);
      }
      else if ((localObject instanceof yug))
      {
        localObject = ((yug)getItem(paramInt)).a;
        locala.jdField_Lz_of_type_AndroidViewView.setClickable(false);
        a(locala, (QIMNotifyAddFriend)localObject);
      }
    }
  }
  
  public void hi() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      gj(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof abfd.a)))
      {
        localObject1 = (abfd.a)localObject1;
        if (((abfd.a)localObject1).type == 0)
        {
          if (((abfd.a)localObject1).structMsg.msg_type.get() == 1)
          {
            a((abfd.a)localObject1);
            switch (((abfd.a)localObject1).structMsg.msg.sub_type.get())
            {
            default: 
              break;
            case 1: 
              anot.a(this.mApp, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
              break;
            case 2: 
            case 3: 
              anot.a(this.mApp, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              break;
            case 13: 
              anot.a(this.mApp, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
              break;
            case 6: 
              anot.a(this.mApp, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
              break;
            }
          }
        }
        else if (((abfd.a)localObject1).type == 1)
        {
          Object localObject2 = ((abfd.a)localObject1).jdField_b_of_type_ComTencentMobileqqDataPhoneContactAdd;
          if (localObject2 != null)
          {
            if (((PhoneContactManagerImp)this.mApp.getManager(11)).Uv()) {}
            for (localObject1 = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 34);; localObject1 = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 29))
            {
              ((ProfileActivity.AllInOne)localObject1).nickname = ((PhoneContactAdd)localObject2).name;
              ProfileActivity.b(this.mContext, (ProfileActivity.AllInOne)localObject1);
              break;
            }
            localObject1 = paramView.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof abfd.a))) {
              if (!aqiw.isNetworkAvailable(this.mContext))
              {
                QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(getTitleBarHeight());
              }
              else
              {
                localObject1 = (abfd.a)localObject1;
                if (((abfd.a)localObject1).type != 2)
                {
                  a((structmsg.StructMsg)((abfd.a)localObject1).structMsg.get(), ((abfd.a)localObject1).Nk);
                  long l1 = anzd.a().hf();
                  localObject1 = anzd.a().a(Long.valueOf(l1));
                  int i;
                  if (localObject1 != null)
                  {
                    i = ((structmsg.StructMsg)localObject1).msg_type.get();
                    l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
                    long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
                    j = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
                    int k = ((structmsg.StructMsg)localObject1).msg.src_id.get();
                    int m = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
                    int n = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
                    localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
                    if ((localObject2 != null) && (((List)localObject2).size() > 0))
                    {
                      localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
                      ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
                      ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
                      structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
                      localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
                      localAddFrdSNInfo.uint32_set_sn.set(0);
                      ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
                      this.mApp.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
                      i = 1;
                      j = i;
                      if (aqft.rj(String.valueOf(l2))) {
                        anot.a(this.mApp, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                      }
                    }
                  }
                  for (int j = i;; j = 0)
                  {
                    if (j != 0) {
                      showProgressDialog();
                    }
                    anot.a(this.mApp, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
                    break;
                    localObject1 = new StringBuilder().append("agree, ");
                    if (localObject2 != null) {}
                    for (i = ((List)localObject2).size();; i = -1)
                    {
                      QLog.d("NewFriendMoreSysMsgAdapter", 1, i);
                      i = 0;
                      break;
                    }
                    QLog.d("NewFriendMoreSysMsgAdapter", 1, "agree");
                  }
                }
                ((FlashChatManager)this.mApp.getManager(217)).a(this.mContext, null);
                continue;
                if (this.Ma != null) {
                  this.Ma.setText("");
                }
                anot.a(this.mApp, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
                ((ysf)this.mApp.getManager(34)).EA(0);
                PublicFragmentActivity.start(this.mContext, NewFriendMoreSysMsgSuspiciousFragment.class);
              }
            }
          }
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.eA.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_e_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_e_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof abfd.a)))
        {
          paramString = (abfd.a)paramString;
          if ((paramString.bfx != null) && (paramString.bfx.length() > 0))
          {
            paramBitmap = (Bitmap)this.eA.get(paramString.bfx);
            if (paramBitmap != null) {
              paramString.xm.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.eA.clear();
    }
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.jdField_e_of_type_Acfd);
    this.mApp.removeObserver(this.jdField_b_of_type_Achq);
    this.mApp.removeObserver(this.jdField_b_of_type_Acdv);
    this.jdField_a_of_type_Aqdf.a(null);
    this.jdField_a_of_type_Aqdf.destory();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLastVisibleIndex = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.mLastVisibleIndex == getCount())) {
      aMG();
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.jdField_a_of_type_Aqdf.edu();
      this.jdField_a_of_type_Aqdf.pause();
      return;
    }
    if (this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.resume();
    }
    int i = this.jdField_e_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    label70:
    if (paramInt < i)
    {
      paramAbsListView = this.jdField_e_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof abfd.a))
      {
        paramAbsListView = (abfd.a)paramAbsListView;
        if (paramAbsListView.type != 0) {
          break label118;
        }
        c(paramAbsListView);
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label70;
      break;
      label118:
      if (paramAbsListView.type == 1) {
        paramAbsListView.xm.setImageBitmap(a(11, paramAbsListView.bfx));
      }
    }
  }
  
  public static class a
    extends auvd.a
  {
    public TextView LA;
    public TextView LS;
    public TextView Lx;
    public TextView Ly;
    public TextView Lz;
    public long Nk;
    public PhoneContactAdd b;
    public QIMNotifyAddFriend b;
    public String bfx;
    public Button ej;
    public long id;
    public structmsg.StructMsg structMsg;
    public int type;
    public ImageView xm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfd
 * JD-Core Version:    0.7.0.1
 */