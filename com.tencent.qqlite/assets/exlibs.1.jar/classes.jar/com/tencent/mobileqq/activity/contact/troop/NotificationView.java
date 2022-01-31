package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cel;
import cem;
import cen;
import ceo;
import cep;
import ceq;
import cer;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.newfriend.BaseSystemMsgInterface;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter.ViewHolder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.newfriend.TroopSystemMessage;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class NotificationView
  extends BaseTroopView
  implements View.OnClickListener, BaseSystemMsgInterface, FaceDecoder.DecodeTaskCompletionListener, SlideDetectListView.OnScrollToTopListener, SlideDetectListView.OnSlideListener
{
  private static final String jdField_a_of_type_JavaLangString = "NotificationView";
  static final int jdField_b_of_type_Int = 60;
  public static final int c = 1012;
  protected static long c = 0L;
  public static final int d = 1013;
  public static final int e = 1014;
  public static final int f = 998;
  public static final int g = 999;
  public static final int h = 1000;
  public static final int i = 1100;
  public static final int j = 1001;
  public static final int k = 1002;
  public static final int l = 1003;
  public static final int m = 1012;
  public static int n = 0;
  public final long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cem(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ceo(this);
  private NotificationAdapter jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new cen(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public QQProgressDialog a;
  private SlideDetectListView.OnScrollToTopListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollToTopListener = new cep(this);
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public final long b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new cer(this);
  private boolean c;
  private boolean d;
  public View e;
  private View f;
  private int o = 0;
  private int p;
  
  static
  {
    jdField_c_of_type_Long = 0L;
  }
  
  public NotificationView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 500L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new cel(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(NotificationAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg)
  {
    if ((paramViewHolder == null) || (paramStructMsg == null)) {
      return;
    }
    switch (TroopNotificationUtils.a(paramViewHolder.jdField_a_of_type_Int))
    {
    default: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
  }
  
  private void a(XListView paramXListView, String paramString, Bitmap paramBitmap)
  {
    NotificationAdapter.ViewHolder localViewHolder;
    String str;
    if (this.o == 0)
    {
      int i2 = paramXListView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localViewHolder = (NotificationAdapter.ViewHolder)paramXListView.getChildAt(i1).getTag();
        if (localViewHolder == null) {
          i1 += 1;
        } else {
          switch (TroopNotificationUtils.a(localViewHolder.jdField_a_of_type_Int))
          {
          default: 
            str = String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localViewHolder != null) && (paramString.equals(str)))
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      str = localViewHolder.jdField_a_of_type_JavaLangString;
      continue;
      str = String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l1 = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      GroupSystemMsgController.a().a(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      GroupSystemMsgController.a().b(l1);
      GroupSystemMsgController.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(0, paramBoolean);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 35) || (paramInt == 3) || (paramInt == 15) || (paramInt == 16) || (paramInt == 7);
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int i3;
    int i4;
    if (paramStructMsg != null)
    {
      int i1 = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int i2 = paramStructMsg.msg.sub_type.get();
      i3 = paramStructMsg.msg.src_id.get();
      i4 = paramStructMsg.msg.sub_src_id.get();
      int i5 = paramStructMsg.msg.group_msg_type.get();
      List localList = paramStructMsg.msg.actions.get();
      if ((localList == null) || (paramInt >= localList.size())) {
        break label220;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
    }
    label220:
    for (bool = true;; bool = false)
    {
      if ((i3 == 116) && (i4 == 0)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private void b(NotificationAdapter.ViewHolder paramViewHolder)
  {
    int i1 = 1;
    if (paramViewHolder == null) {
      return;
    }
    Object localObject;
    String str;
    switch (TroopNotificationUtils.a(paramViewHolder.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      i1 = 4;
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131362478);
    }
    for (;;)
    {
      localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, (String)localObject, i1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramViewHolder.jdField_a_of_type_JavaLangString;
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131362479);
      continue;
      localObject = String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131362480);
    }
  }
  
  private void b(NotificationAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "jumpToTroopRequestActivity!" + paramViewHolder.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramViewHolder.jdField_a_of_type_Long);
    localBundle.putInt("troopMsgTpype", paramViewHolder.jdField_a_of_type_Int);
    localBundle.putString("troopCode", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if (paramViewHolder.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramViewHolder.jdField_b_of_type_Long);
      localIntent.putExtra("troopMsgDealInfo", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      a((structmsg.StructMsg)paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramViewHolder.jdField_c_of_type_Long);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void m()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  private void n()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  private void o()
  {
    a(2130903339);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131297760));
    this.e = findViewById(2131297761);
    q();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
  }
  
  private void p()
  {
    int i1 = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter = new NotificationAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, i1, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ae, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDividerHeight(1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "initListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a(this.jdField_a_of_type_JavaUtilList);
    k();
  }
  
  private void q()
  {
    if (this.f == null) {
      this.f = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903553, null);
    }
    if (this.f.getParent() == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b(this.f);
    }
    this.f.setVisibility(8);
  }
  
  private void r()
  {
    if (this.d) {}
    do
    {
      do
      {
        return;
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362797), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_JavaUtilList.size() < 10) || (GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.d = true;
      this.f.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().i();
    } while (!QLog.isColorLevel());
    QLog.i("NotificationView", 2, "loadNextPage.get next page.");
  }
  
  private void s()
  {
    if (this.f != null) {
      this.f.setVisibility(8);
    }
    this.d = false;
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "stopLoadMore().");
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new ceq(this));
    }
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "sendReadConfirm is end!");
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131492887);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, paramString, paramBitmap);
  }
  
  public void a(Intent paramIntent)
  {
    GroupSystemMsgController.a().e();
    super.a(paramIntent);
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    m();
    o();
    p();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollToTopListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public void a(NotificationAdapter.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "handleGroupSystemMsg! start " + paramViewHolder.jdField_a_of_type_Long);
    }
    b(paramViewHolder, 998);
    String str6 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = "";
    String str5 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str3 = "";
    String str2 = "";
    String str1;
    int i1;
    label155:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramViewHolder.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int)
    {
      str1 = "1";
      i1 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i1 != 2) && (i1 != 3)) {
        break label324;
      }
      i1 = 0;
      localObject1 = str4;
      localObject2 = str3;
      localObject3 = str2;
      switch (paramViewHolder.jdField_a_of_type_Int)
      {
      default: 
        localObject3 = str2;
        localObject2 = str3;
        localObject1 = str4;
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", (String)localObject1, 0, 0, str5, str1, (String)localObject2, (String)localObject3);
      return;
      str1 = "0";
      break;
      label324:
      i1 = 1;
      break label155;
      localObject3 = "enter_askjoin";
      if ((str6 == null) || ("".equals(str6))) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label398;
        }
        paramViewHolder = "0";
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = paramViewHolder;
        break;
      }
      label398:
      long l1 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l1 != 0L) && (!(l1 + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {}
      for (paramViewHolder = "2";; paramViewHolder = "1")
      {
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = paramViewHolder;
        break;
      }
      localObject1 = "refuseask_page";
      localObject2 = str3;
      localObject3 = str2;
      continue;
      if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "enter_invite";
        localObject2 = str3;
        localObject3 = paramViewHolder;
        break;
      }
      if (i1 != 0) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "refuseinvite_page";
        localObject2 = paramViewHolder;
        localObject3 = str2;
        break;
      }
      if (i1 != 0) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "refuseagree_page";
        localObject2 = paramViewHolder;
        localObject3 = str2;
        break;
      }
      localObject1 = "quit_page";
      localObject2 = str3;
      localObject3 = str2;
      continue;
      localObject1 = "byquit_page";
      localObject2 = "0";
      localObject3 = str2;
      continue;
      localObject1 = "byquit_page";
      localObject2 = "1";
      localObject3 = str2;
      continue;
      if ((paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {}
      for (paramViewHolder = "0";; paramViewHolder = "1")
      {
        localObject1 = "set_admin_page";
        localObject2 = paramViewHolder;
        localObject3 = str2;
        break;
      }
      localObject1 = "un_admin_page";
      localObject2 = "0";
      localObject3 = str2;
      continue;
      localObject1 = "un_admin_page";
      localObject2 = "1";
      localObject3 = str2;
    }
  }
  
  public void a(NotificationAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "bindTroopSystemMsgView! start " + paramViewHolder.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramViewHolder.jdField_a_of_type_Long = paramInt;
    paramViewHolder.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramViewHolder.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    int i1 = localStructMsg.msg.sub_type.get();
    paramViewHolder.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramViewHolder.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    label214:
    String str;
    label272:
    Object localObject;
    if ((paramViewHolder.jdField_b_of_type_JavaLangString != null) && (!paramViewHolder.jdField_b_of_type_JavaLangString.equals("")))
    {
      a(paramViewHolder, localStructMsg);
      switch (paramViewHolder.jdField_a_of_type_Int)
      {
      default: 
        paramInt = 0;
        if ((paramInt != 0) && ((localStructMsg.msg.group_ext_flag.get() & 0x800) != 0)) {
          if (localStructMsg.msg.group_info.group_auth_type.get() == 2)
          {
            paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838196);
            str = localStructMsg.msg.group_info.msg_alert.get();
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131623986);
            if ((TextUtils.isEmpty(str)) || ((paramViewHolder.jdField_a_of_type_Int != 1) && (paramViewHolder.jdField_a_of_type_Int != 22))) {
              break label794;
            }
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131623987);
            localObject = str;
            label345:
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label939;
            }
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            label378:
            localObject = TroopUtils.a(localStructMsg, localStructMsg.msg.msg_describe.get());
            if (localObject == null) {
              break label951;
            }
            paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            label410:
            if (paramViewHolder.jdField_a_of_type_Int != 80) {
              break label1012;
            }
            localObject = localStructMsg.msg.actions.get();
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject).get(0)).name.get());
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131624044);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837749);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          }
        }
        break;
      }
    }
    for (;;)
    {
      if ((i1 == 2) && (paramViewHolder.jdField_a_of_type_Int == 2) && (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        TroopRemindSettingManager.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      b(paramViewHolder);
      ((RelativeLayout.LayoutParams)paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(0, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getId());
      ((RelativeLayout.LayoutParams)paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(0, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getId());
      ((RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(0, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getId());
      return;
      paramViewHolder.jdField_b_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
      break;
      paramInt = 1;
      break label214;
      if (localStructMsg.msg.group_info.group_auth_type.get() == 1)
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838257);
        break label272;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label272;
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label272;
      label794:
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_qna.get()))
      {
        localObject = localStructMsg.msg.msg_qna.get();
        break label345;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_actor_describe.get()))
      {
        localObject = TroopUtils.a(localStructMsg, localStructMsg.msg.msg_actor_describe.get());
        break label345;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional_list.get()))
      {
        localObject = localStructMsg.msg.msg_additional_list.get();
        break label345;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional.get()))
      {
        localObject = localStructMsg.msg.msg_additional.get();
        break label345;
      }
      localObject = "";
      break label345;
      label939:
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label378;
      label951:
      localObject = localStructMsg.msg.msg_additional.get();
      if ((localObject == null) || ("".equals(localObject)))
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131362299));
        break label410;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      break label410;
      label1012:
      if (i1 == 1)
      {
        localObject = localStructMsg.msg.actions.get();
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          if ((str == null) || ("".equals(str)))
          {
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject).get(1)).name.get());
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131624044);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837749);
          }
          for (;;)
          {
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject).get(0)).name.get());
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131624053);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837747);
          }
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131623988);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
        localObject = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
        if (localObject != null)
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(11);
          ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
          ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, (int)(14.0F * this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density), 0);
        }
      }
    }
  }
  
  public void a(SystemMsgListAdapter.ViewHolder paramViewHolder, int paramInt) {}
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBusinessObserver);
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    NotificationAdapter.ViewHolder localViewHolder = (NotificationAdapter.ViewHolder)paramView.getTag();
    if ((localViewHolder != null) && ((localViewHolder instanceof NotificationAdapter.ViewHolder)))
    {
      paramView = (ShaderAnimLayout)paramView.findViewById(2131297758);
      if (paramView != null) {
        break label38;
      }
    }
    label38:
    Button localButton;
    do
    {
      return;
      localButton = (Button)paramView.findViewById(2131297759);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramView.a();
    localButton.setTag(localViewHolder);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount() - this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.k() > 0)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount() - 1);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      int i1 = arrayOfInt[1];
      if (paramFloat > localView.getMeasuredHeight() + i1) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.aj, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0))
    {
      k();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.notifyDataSetChanged();
      t();
    }
    a(false);
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(paramBusinessObserver);
    }
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131297758);
    if (paramSlideDetectListView != null)
    {
      paramSlideDetectListView.d();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131297759);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setTag(null);
      }
    }
  }
  
  protected void d()
  {
    super.d();
    a(false);
  }
  
  protected void e()
  {
    super.e();
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.notifyDataSetChanged();
    }
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).a(new TroopSystemMessage(0));
  }
  
  protected void f()
  {
    super.f();
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
  }
  
  protected void h()
  {
    super.h();
    n();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0)) {
      t();
    }
    GroupSystemMsgController.a().b();
    if (this.jdField_c_of_type_Boolean) {
      GroupSystemMsgController.a().d();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
  }
  
  public void i()
  {
    GroupSystemMsgController.a().b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount() > 0)) {
      t();
    }
    this.jdField_c_of_type_Boolean = true;
    super.i();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
  }
  
  public void l()
  {
    t();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.a();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1012);
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if ((l1 - jdField_c_of_type_Long > 0L) && (l1 - jdField_c_of_type_Long < 800L)) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        jdField_c_of_type_Long = l1;
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (!(paramView.getTag() instanceof NotificationAdapter.ViewHolder));
      localObject1 = (NotificationAdapter.ViewHolder)paramView.getTag();
    } while (localObject1 == null);
    Object localObject2 = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    int i1 = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_Int;
    if (TroopNotificationUtils.a(i1) == 0)
    {
      paramView = TroopInfoActivity.a(String.valueOf(((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
      ChatSettingForTroop.a(a(), paramView, 2);
      if ((i1 == 2) || (i1 == 10) || (i1 == 12))
      {
        i1 = 1;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
        if (i1 == 0) {
          break label233;
        }
      }
      label233:
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject1, paramView, "", "");
        return;
        i1 = 0;
        break;
      }
    }
    l1 = ((structmsg.StructMsg)localObject2).req_uin.get();
    switch (TroopNotificationUtils.a(i1))
    {
    default: 
      paramView = String.valueOf(l1);
      if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramView)) {
        paramView = new ProfileActivity.AllInOne(paramView, 1);
      }
      break;
    }
    for (;;)
    {
      ProfileActivity.b(a(), paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", "3", "", "");
      return;
      paramView = ((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangString;
      break;
      paramView = String.valueOf(((NotificationAdapter.ViewHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break;
      if ((((structmsg.StructMsg)localObject2).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject2).msg.sub_type.get() == 3))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 26);
        paramView.d = 1;
      }
      else
      {
        paramView = new ProfileActivity.AllInOne(paramView, 19);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotificationView
 * JD-Core Version:    0.7.0.1
 */