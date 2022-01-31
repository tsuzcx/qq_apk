package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import bsm;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public abstract class BaseBubbleBuilder
  implements View.OnClickListener, ChatItemBuilder
{
  public static int a = 0;
  private static final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public Context a;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new bsm(this);
  @Deprecated
  public BaseAdapter a;
  public SessionInfo a;
  public QQAppInterface a;
  private boolean c = false;
  
  static
  {
    jdField_a_of_type_Int = 255;
  }
  
  public BaseBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      paramInt2 = a(paramChatMessage);
      paramViewHolder.jdField_a_of_type_Int = paramInt2;
      if (paramInt2 != 0) {
        if (paramChatMessage.needVipBubble())
        {
          paramInt1 = (int)paramChatMessage.vipBubbleID;
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
          if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.c, null);
          }
          if (paramViewHolder.c != null)
          {
            paramViewHolder.c.setMinimumWidth(AIOUtils.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            paramViewHolder.c.setMinimumHeight(AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          }
          if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
          {
            paramContext = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
            QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            boolean bool3 = paramChatMessage.isSend();
            boolean bool4 = paramChatMessage.needVipBubble();
            bool1 = bool2;
            if (paramInt2 == 2) {
              bool1 = true;
            }
            paramContext.a(localQQAppInterface, bool3, bool4, bool1, paramViewHolder.c);
          }
          if (paramViewHolder.c != null)
          {
            paramContext = paramViewHolder.c.getBackground();
            if (paramContext != null) {
              paramContext.setAlpha(jdField_a_of_type_Int);
            }
          }
          a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
        }
      }
      for (;;)
      {
        paramBaseChatItemLayout.a(paramViewHolder.c);
        a(paramViewHolder.c, paramChatMessage);
        return;
        paramInt1 = 0;
        break;
        paramViewHolder.c.setBackgroundDrawable(null);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    Object localObject1 = null;
    int j = 1;
    int k = 0;
    Object localObject2;
    boolean bool1;
    label124:
    int i;
    if (MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
    {
      localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, paramChatMessage.frienduin, 1, 0);
      if (localObject1 != null)
      {
        paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        paramViewHolder = paramChatMessage.senderuin;
      }
      localObject1 = MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      localObject2 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramChatMessage.frienduin);
      label132:
      label140:
      boolean bool2;
      if (((OpenTroopInfo)localObject2).troopAdminList == null)
      {
        bool1 = false;
        if (localObject1 != null) {
          break label223;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "handleNickname, TroopMemberInfo is null ");
        }
        if (localObject1 != null) {
          break label298;
        }
        i = 0;
        if (localObject1 != null) {
          break label308;
        }
        j = 0;
        if ((paramViewHolder == null) || (paramChatMessage.isSend())) {
          break label318;
        }
        bool2 = true;
        label154:
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
        if (localObject1 != null) {
          break label324;
        }
      }
      for (;;)
      {
        paramBaseChatItemLayout.a(bool2, paramViewHolder, paramChatMessage, true, j, i, k, bool1);
        return;
        bool1 = ((OpenTroopInfo)localObject2).troopAdminList.contains(paramChatMessage.senderuin + "|");
        break;
        label223:
        if (!QLog.isColorLevel()) {
          break label124;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "handleNickname, info.age = " + ((TroopMemberInfo)localObject1).age + " info.sex = " + ((TroopMemberInfo)localObject1).sex + " nickname = " + paramViewHolder + " info.memberuin = " + ((TroopMemberInfo)localObject1).memberuin);
        break label124;
        label298:
        i = ((TroopMemberInfo)localObject1).sex;
        break label132;
        label308:
        j = ((TroopMemberInfo)localObject1).age;
        break label140;
        label318:
        bool2 = false;
        break label154;
        label324:
        k = ((TroopMemberInfo)localObject1).distance;
      }
    }
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
      if (paramChatMessage.isMultiMsg)
      {
        localObject1 = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        label379:
        if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
          break label628;
        }
        localObject1 = paramChatMessage.senderuin;
        label398:
        if ((localObject1 == null) || (paramChatMessage.isSend())) {
          break label654;
        }
        bool1 = true;
        label413:
        paramBaseChatItemLayout.a(bool1, (CharSequence)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a, false);
        localObject2 = localObject1;
        label436:
        if ((this.c) && (paramBaseChatItemLayout.e != null))
        {
          paramBaseChatItemLayout.e.setOnClickListener(this);
          paramBaseChatItemLayout.e.setTag(Integer.valueOf(2131296300));
        }
        if (paramChatMessage.istroop != 1) {
          break label680;
        }
        i = 1;
        label482:
        if (paramChatMessage.istroop != 3000) {
          break label686;
        }
        label492:
        bool1 = paramChatMessage.isSend();
        if ((i != 0) || (j != 0))
        {
          if (i == 0) {
            break label724;
          }
          if (!bool1) {
            break label692;
          }
          localObject1 = "进入我的群名片";
        }
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.a.setContentDescription((CharSequence)localObject1);
      if (paramViewHolder.jdField_a_of_type_JavaLangStringBuilder == null) {
        break;
      }
      if (paramChatMessage.isSend())
      {
        paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append("我");
        return;
        if (paramChatMessage.istroop == 1)
        {
          localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, paramChatMessage.frienduin, 1, 0);
          break label379;
        }
        if (3000 != paramChatMessage.istroop) {
          break label379;
        }
        localObject1 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramChatMessage.frienduin, paramChatMessage.senderuin);
        break label379;
        label628:
        localObject1 = (String)localObject1 + ":";
        break label398;
        label654:
        bool1 = false;
        break label413;
        paramBaseChatItemLayout.a(false, null, null, false);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label436;
        label680:
        i = 0;
        break label482;
        label686:
        j = 0;
        break label492;
        label692:
        localObject1 = "进入" + (String)localObject2 + "的群名片";
        continue;
        label724:
        if (j == 0) {
          break label796;
        }
        if (bool1)
        {
          localObject1 = "进入我的资料卡";
          continue;
        }
        localObject1 = "进入" + (String)localObject2 + "的资料卡";
        continue;
      }
      paramChatMessage = (ChatMessage)localObject2;
      if (localObject2 == null) {
        paramChatMessage = "";
      }
      paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append(paramChatMessage);
      return;
      label796:
      localObject1 = "";
    }
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    paramQQCustomMenu.a(2131298983, paramContext.getString(2131363073));
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (paramChatMessage.istroop == 1)
    {
      paramBaseChatItemLayout.a(false, "", null);
      return;
    }
    paramBaseChatItemLayout.a(false, "", null);
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setCheckBox(paramChatMessage, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int j = paramChatMessage.istroop;
    Object localObject1;
    if (paramChatMessage.isSend()) {
      localObject1 = paramChatMessage.selfuin;
    }
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      if (((j != 1001) && ((j != 1022) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3019) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2019)))) || (localObject2 == null) || (((FriendsManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break;
      }
      localObject3 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, (String)localObject1, true);
      localObject2 = localObject3;
      if (QLog.isColorLevel())
      {
        QLog.d("BaseBubbleBuilder", 2, "new head, uin = " + (String)localObject1);
        localObject2 = localObject3;
      }
      paramBaseChatItemLayout.setHeaderIcon((Drawable)localObject2);
      if ((paramChatMessage.isSendFromLocal()) || ((j != 1) && (j != 3000))) {
        break label563;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramChatMessage.senderuin))
      {
        localObject1 = null;
        if (j != 1) {
          break label525;
        }
        localObject1 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
        label248:
        if ((localObject1 == null) || (((String)localObject1).getBytes().length <= 3)) {
          break label560;
        }
        localObject2 = ((String)localObject1).getBytes();
        if ((localObject2[0] != -17) || (localObject2[1] != -69) || (localObject2[2] != -65)) {
          break label560;
        }
        localObject3 = new byte[localObject2.length - 3];
        System.arraycopy(localObject2, 3, localObject3, 0, localObject3.length);
      }
      try
      {
        localObject2 = new String((byte[])localObject3, "UTF-8");
        localObject1 = localObject2;
        label336:
        paramBaseChatItemLayout.a.setTag(2131296298, localObject1);
        paramBaseChatItemLayout.a.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        label359:
        paramBaseChatItemLayout.a.setOnClickListener(this);
        paramBaseChatItemLayout.a.setTag(paramChatMessage);
        localObject1 = "";
        if (paramChatMessage.istroop == 0)
        {
          if (!paramChatMessage.isSend()) {
            break label574;
          }
          localObject1 = "进入我的资料卡";
        }
        label399:
        paramBaseChatItemLayout.a.setContentDescription((CharSequence)localObject1);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004)) {
        localObject1 = paramChatMessage.frienduin;
      } else {
        localObject1 = paramChatMessage.senderuin;
      }
    }
    if (j == 1006) {}
    for (int i = 11;; i = 1)
    {
      localObject3 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject1);
      localObject2 = localObject3;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseBubbleBuilder", 2, "QQ head, uin = " + (String)localObject1);
      localObject2 = localObject3;
      break;
      label525:
      if (j != 3000) {
        break label248;
      }
      localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
      break label248;
      label560:
      break label336;
      label563:
      paramBaseChatItemLayout.a.setOnLongClickListener(null);
      break label359;
      label574:
      localObject1 = "进入" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString + "的资料卡";
      break label399;
    }
  }
  
  private void e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    FriendsManagerImp localFriendsManagerImp;
    if (paramChatMessage.istroop == 1)
    {
      localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localFriendsManagerImp != null)
      {
        TroopInfo localTroopInfo = localFriendsManagerImp.a(paramChatMessage.frienduin);
        if ((localTroopInfo == null) || (localTroopInfo.cGroupRankSysFlag != 1) || (localTroopInfo.cGroupRankUserFlag != 1)) {}
      }
    }
    for (paramChatMessage = localFriendsManagerImp.a(paramChatMessage.frienduin, paramChatMessage.senderuin, this.jdField_a_of_type_AndroidContentContext);; paramChatMessage = null)
    {
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0))
      {
        paramBaseChatItemLayout.a(true, paramChatMessage, false, false, 2130839471);
        this.c = true;
        paramBaseChatItemLayout.c.setOnClickListener(this);
        paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131296299));
        return;
      }
      this.c = false;
      paramBaseChatItemLayout.a(false, null, false, false, -1);
      return;
    }
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleView", 2, " getView position = " + paramInt1);
    }
    Context localContext = paramViewGroup.getContext();
    paramView = (BaseChatItemLayout)paramView;
    ColorStateList localColorStateList;
    Object localObject;
    if (paramView == null)
    {
      paramView = new BaseChatItemLayout(localContext);
      paramView.setId(2131296365);
      paramView.setFocusableInTouchMode(true);
      paramView.setPadding(BaseChatItemLayout.u, BaseChatItemLayout.w, BaseChatItemLayout.v, 0);
      paramViewGroup = a();
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
      paramViewGroup.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      localColorStateList = null;
      paramView.setContentDescription(null);
      paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.replace(0, paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.length(), "");
      localObject = localColorStateList;
      if (paramChatMessage.mNeedTimeStamp)
      {
        localObject = localColorStateList;
        if (paramChatMessage.time > 0L)
        {
          localObject = TimeFormatterUtils.a(localContext, 3, paramChatMessage.time * 1000L);
          paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.append((CharSequence)localObject).append(" ");
        }
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      if (!paramChatMessage.isSend()) {
        break label424;
      }
    }
    label424:
    for (int i = 1;; i = 0)
    {
      paramView.setHearIconPosition(i);
      localColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
      paramView.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage.time, localColorStateList, (CharSequence)localObject);
      paramView.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage.mMessageSource, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427339));
      c(paramChatMessage, paramView);
      d(paramChatMessage, paramView);
      e(paramChatMessage, paramView);
      a(paramChatMessage, paramView, paramViewGroup);
      b(paramChatMessage, paramView, paramViewGroup);
      b(paramChatMessage, paramView);
      a(paramChatMessage, paramView);
      paramViewGroup.c = a(paramChatMessage, paramViewGroup, paramViewGroup.c, paramView, paramOnLongClickAndTouchListener);
      a(paramChatMessage, localContext, paramView, paramViewGroup, paramInt1, paramInt2);
      paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.append(a(paramChatMessage));
      paramView.setContentDescription(paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.toString());
      paramView.requestLayout();
      return paramView;
      paramViewGroup = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      break;
    }
  }
  
  protected abstract View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  protected abstract BaseBubbleBuilder.ViewHolder a();
  
  protected abstract String a(ChatMessage paramChatMessage);
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void a(View paramView) {}
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.l, BaseChatItemLayout.i, BaseChatItemLayout.k, BaseChatItemLayout.j);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.i, BaseChatItemLayout.l, BaseChatItemLayout.j);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo) {}
  
  protected void a(ChatMessage paramChatMessage)
  {
    BaseChatPie localBaseChatPie = ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).a();
    localBaseChatPie.b(paramChatMessage);
    localBaseChatPie.f(true);
    if (paramChatMessage == null) {
      return;
    }
    int i;
    if (paramChatMessage.istroop == 0) {
      i = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + i, "", "", "");
      return;
      if (paramChatMessage.istroop == 3000) {
        i = 2;
      } else if (paramChatMessage.istroop == 1) {
        i = 3;
      } else {
        i = 4;
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (a(paramChatMessage, paramBaseChatItemLayout))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    if ((b()) && (MultiMsgManager.a().a())) {
      paramQQCustomMenu.a(2131298990, this.jdField_a_of_type_AndroidContentContext.getString(2131363132));
    }
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.b;
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return (paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal());
  }
  
  public boolean a_(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.senderuin != null) && (paramChatMessage.senderuin.equals(paramChatMessage.selfuin));
  }
  
  public void b() {}
  
  protected void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {}
    FriendManager localFriendManager;
    do
    {
      return;
      localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    } while (("80000000".equals(localChatMessage.senderuin)) || ("1000000".equals(localChatMessage.senderuin)) || ("10000".equals(localChatMessage.senderuin)));
    Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localChatMessage.istroop == 1)
    {
      localObject = new Intent(paramView.getContext(), TroopMemberCardActivity.class);
      ((Intent)localObject).putExtra("troopUin", localChatMessage.frienduin);
      ((Intent)localObject).putExtra("memberUin", localChatMessage.senderuin);
      ((Intent)localObject).putExtra("fromFlag", 0);
      ((Activity)paramView.getContext()).startActivityForResult((Intent)localObject, 2000);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_head", 0, 0, localChatMessage.frienduin, localChatMessage.senderuin, "", "");
      return;
    }
    boolean bool;
    String str;
    if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004))
    {
      bool = localFriendManager.b(localChatMessage.senderuin);
      str = localChatMessage.senderuin;
      label254:
      if (str == null) {
        break label510;
      }
      if ((localChatMessage.issend != 1) && (localChatMessage.issend != 2)) {
        break label1457;
      }
    }
    label401:
    label1435:
    label1447:
    label1457:
    for (int i = 1;; i = 0)
    {
      if (localFriendManager.b(str)) {
        bool = true;
      }
      if (i != 0)
      {
        localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        label326:
        if (str.equals(((ProfileActivity.AllInOne)localObject).h)) {
          ((ProfileActivity.AllInOne)localObject).h = null;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020)) {
          break label1375;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = localChatMessage.senderuin;
        ((ProfileActivity.AllInOne)localObject).jdField_f_of_type_Int = 2;
        ((ProfileActivity.AllInOne)localObject).g = 1;
        if (localChatMessage.istroop != 1001) {
          break label1447;
        }
        if (localChatMessage.istroop == 1001) {
          ((ProfileActivity.AllInOne)localObject).g = 10;
        }
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
        paramView.putExtra("AllInOne", (Parcelable)localObject);
        if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str)) {
          break label1435;
        }
        paramView.putExtra("param_mode", 2);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        return;
        str = localChatMessage.frienduin;
        bool = false;
        break label254;
        label510:
        break;
        if (localChatMessage.istroop == 1024)
        {
          localObject = new Intent(paramView.getContext(), EnterpriseDetailActivity.class);
          ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).putExtra("need_finish", true);
          ((ChatActivity)paramView.getContext()).startActivityForResult((Intent)localObject, 2000);
          return;
        }
        if (bool)
        {
          if (localChatMessage.istroop == 1) {}
          for (localObject = new ProfileActivity.AllInOne(str, 20);; localObject = new ProfileActivity.AllInOne(str, 1))
          {
            ((ProfileActivity.AllInOne)localObject).h = localFriendManager.a(str);
            break;
          }
        }
        if (localChatMessage.istroop == 1001)
        {
          localObject = new ProfileActivity.AllInOne(str, 42);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label326;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
        {
          localObject = new ProfileActivity.AllInOne(str, 70);
          ((ProfileActivity.AllInOne)localObject).h = localFriendManager.a(str);
          break label326;
        }
        if (localChatMessage.istroop == 1000)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 22);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label326;
        }
        if (localChatMessage.istroop == 1020)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 58);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label326;
        }
        if (localChatMessage.istroop == 1)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 21);
          ((ProfileActivity.AllInOne)localObject).h = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, localChatMessage.senderuin);
          break label326;
        }
        if (3000 == localChatMessage.istroop)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 46);
          ((ProfileActivity.AllInOne)localObject).h = localFriendManager.c(localChatMessage.frienduin, localChatMessage.senderuin);
          break label326;
        }
        if (localChatMessage.istroop == 1001)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 42);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label326;
        }
        if (localChatMessage.istroop == 1004)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 47);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
          break label326;
        }
        if (localChatMessage.istroop == 1005)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 2);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label326;
        }
        if (localChatMessage.istroop == 1023)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 74);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label326;
        }
        if (localChatMessage.istroop == 1009)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 57);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label326;
        }
        if (localChatMessage.istroop == 1006)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 34);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label326;
        }
        if (localChatMessage.istroop == 1009)
        {
          localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 57);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label326;
        }
        if (localChatMessage.istroop == 1022)
        {
          localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 27);
          ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label326;
        }
        if (localChatMessage.istroop == 1025)
        {
          if (this.jdField_a_of_type_AndroidContentContext == null) {
            break;
          }
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
          paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
          paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          return;
        }
        localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 19);
        ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label326;
        label1375:
        if (localChatMessage.istroop == 1)
        {
          ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
          ((ProfileActivity.AllInOne)localObject).c = localChatMessage.frienduin;
          break label401;
        }
        if (3000 != localChatMessage.istroop) {
          break label401;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        break label401;
        paramView.putExtra("param_mode", 3);
      }
      ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject);
      return;
    }
  }
  
  public void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setProgressVisable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage));
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if ((localFriendManager != null) && (localFriendManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  protected void c(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if ((localChatMessage != null) && (localChatMessage.istroop == 1))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", "http://qinfo.clt.qq.com/qlevel/faq.html?_bid=125#gc=" + localChatMessage.frienduin + "&target=" + localChatMessage.senderuin);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      paramView.getContext().startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    if (a()) {}
    while ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {
      return;
    }
    switch (paramView.getId())
    {
    case 2131296301: 
    case 2131296303: 
    default: 
      return;
    case 2131296298: 
      b(paramView);
      return;
    case 2131296304: 
      a(paramView);
      return;
    }
    c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */