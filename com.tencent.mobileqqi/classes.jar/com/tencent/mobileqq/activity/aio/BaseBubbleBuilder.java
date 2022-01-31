package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import ebc;
import ebd;
import java.io.UnsupportedEncodingException;

public abstract class BaseBubbleBuilder
  implements View.OnClickListener, ChatItemBuilder
{
  public static int a = 0;
  private static final Handler jdField_a_of_type_AndroidOsHandler;
  public static boolean a = false;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  protected Context a;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new ebd(this);
  @Deprecated
  protected BaseAdapter a;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  public QQAppInterface a;
  private boolean d = false;
  
  static
  {
    jdField_a_of_type_Int = 255;
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public BaseBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    int j = a(paramChatMessage);
    paramViewHolder.jdField_a_of_type_Int = j;
    Object localObject;
    if (j != 0) {
      if (paramChatMessage.msgtype == -1000)
      {
        paramContext = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (localObject == null) {
          break label442;
        }
      }
    }
    label424:
    label442:
    for (paramContext = ((TransDiskCache)localObject).a(paramChatMessage.msg, paramChatMessage.uniseq, paramContext);; paramContext = null)
    {
      boolean bool1;
      if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend()))
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
        }
        if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
        {
          paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumWidth(AIOUtils.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        paramContext = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        boolean bool2 = paramChatMessage.isSend();
        boolean bool3 = paramChatMessage.needVipBubble();
        if (j != 2) {
          break label424;
        }
        bool1 = true;
        label228:
        paramContext.a((QQAppInterface)localObject, bool2, bool3, bool1, paramViewHolder.jdField_a_of_type_AndroidViewView);
        paramContext = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
        if (paramContext != null) {
          paramContext.setAlpha(jdField_a_of_type_Int);
        }
        a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
        a(paramViewHolder, paramChatMessage);
        if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag))
        {
          jdField_a_of_type_AndroidOsHandler.post(new ebc(this, paramViewHolder, paramChatMessage));
          paramChatMessage.mAnimFlag = false;
        }
      }
      for (;;)
      {
        paramBaseChatItemLayout.a(paramViewHolder.jdField_a_of_type_AndroidViewView);
        a(paramViewHolder.jdField_a_of_type_AndroidViewView, paramChatMessage);
        return;
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        break;
        if (((paramChatMessage instanceof MessageForText)) && (paramChatMessage.needVipBubble())) {}
        for (int i = (int)paramChatMessage.vipBubbleID;; i = 0)
        {
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
          break;
        }
        bool1 = false;
        break label228;
        paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    paramBaseChatItemLayout.setPendantImageVisible(false);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    Object localObject = null;
    boolean bool1 = true;
    int k = 0;
    if (MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
    {
      localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, paramChatMessage.frienduin, 1, 0);
      if (localObject != null)
      {
        paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        paramViewHolder = paramChatMessage.senderuin;
      }
      localObject = MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      OpenTroopInfo localOpenTroopInfo = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramChatMessage.frienduin);
      label125:
      boolean bool2;
      label139:
      int i;
      label158:
      int j;
      if (localOpenTroopInfo.troopAdminList == null)
      {
        bool1 = false;
        if (localObject != null) {
          break label225;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "handleNickname, TroopMemberInfo is null ");
        }
        if ((paramViewHolder == null) || (paramChatMessage.isSend())) {
          break label303;
        }
        bool2 = true;
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
        if (localObject != null) {
          break label309;
        }
        i = 0;
        if (localObject != null) {
          break label319;
        }
        j = 0;
        label166:
        if (localObject != null) {
          break label329;
        }
      }
      for (;;)
      {
        paramBaseChatItemLayout.a(bool2, paramViewHolder, paramChatMessage, true, i, j, k, bool1);
        return;
        bool1 = localOpenTroopInfo.troopAdminList.contains(paramChatMessage.senderuin + "|");
        break;
        label225:
        if (!QLog.isColorLevel()) {
          break label125;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "handleNickname, info.age = " + ((TroopMemberInfo)localObject).age + " info.sex = " + ((TroopMemberInfo)localObject).sex + " nickname = " + paramViewHolder + " info.memberuin = " + ((TroopMemberInfo)localObject).memberuin);
        break label125;
        label303:
        bool2 = false;
        break label139;
        label309:
        i = ((TroopMemberInfo)localObject).age;
        break label158;
        label319:
        j = ((TroopMemberInfo)localObject).sex;
        break label166;
        label329:
        k = ((TroopMemberInfo)localObject).distance;
      }
    }
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
      if (paramChatMessage.istroop == 1)
      {
        localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, paramChatMessage.frienduin, 1, 0);
        label384:
        if ((localObject != null) && (((String)localObject).length() != 0)) {
          break label544;
        }
        localObject = paramChatMessage.senderuin;
        label403:
        if ((localObject == null) || (paramChatMessage.isSend())) {
          break label570;
        }
        label415:
        paramBaseChatItemLayout.a(bool1, (CharSequence)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
      }
    }
    for (;;)
    {
      if ((this.d) && (paramBaseChatItemLayout.d != null))
      {
        paramBaseChatItemLayout.d.setOnClickListener(this);
        paramBaseChatItemLayout.d.setTag(Integer.valueOf(2131230775));
      }
      if (paramViewHolder.jdField_a_of_type_JavaLangStringBuilder == null) {
        break;
      }
      if (!paramChatMessage.isSend()) {
        break label595;
      }
      paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558884));
      return;
      if (3000 != paramChatMessage.istroop) {
        break label384;
      }
      localObject = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).d(paramChatMessage.frienduin, paramChatMessage.senderuin);
      break label384;
      label544:
      localObject = (String)localObject + ":";
      break label403;
      label570:
      bool1 = false;
      break label415;
      paramBaseChatItemLayout.a(false, null, null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
    }
    label595:
    paramChatMessage = (ChatMessage)localObject;
    if (localObject == null) {
      paramChatMessage = "";
    }
    paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append(paramChatMessage);
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    paramQQCustomMenu.a(2131234872, paramContext.getString(2131562749));
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "Bubble", paramString1, 0, 1, null, String.valueOf(paramInt), null, paramString2, null);
      }
      return;
    }
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int j = paramChatMessage.istroop;
    Object localObject1;
    if (paramChatMessage.isSend())
    {
      localObject1 = paramChatMessage.selfuin;
      if (j != 1006) {
        break label393;
      }
    }
    label393:
    for (int i = 11;; i = 1)
    {
      paramBaseChatItemLayout.setHeaderIcon(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject1));
      label108:
      Object localObject2;
      byte[] arrayOfByte;
      if ((!paramChatMessage.isSendFromLocal()) && ((j == 1) || (j == 3000))) {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramChatMessage.senderuin))
        {
          localObject1 = null;
          if (j != 1) {
            break label313;
          }
          localObject1 = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
          if ((localObject1 == null) || (((String)localObject1).getBytes().length <= 3)) {
            break label348;
          }
          localObject2 = ((String)localObject1).getBytes();
          if ((localObject2[0] != -17) || (localObject2[1] != -69) || (localObject2[2] != -65)) {
            break label348;
          }
          arrayOfByte = new byte[localObject2.length - 3];
          System.arraycopy(localObject2, 3, arrayOfByte, 0, arrayOfByte.length);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = new String(arrayOfByte, "UTF-8");
          localObject1 = localObject2;
          paramBaseChatItemLayout.a.setTag(2131230773, localObject1);
          paramBaseChatItemLayout.a.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          paramBaseChatItemLayout.a.setOnClickListener(this);
          paramBaseChatItemLayout.a.setTag(paramChatMessage);
          if (!paramChatMessage.isSend()) {
            break label362;
          }
          paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558883);
          paramBaseChatItemLayout.a.setContentDescription(paramChatMessage);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          label313:
          localUnsupportedEncodingException.printStackTrace();
        }
        if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
        {
          localObject1 = paramChatMessage.frienduin;
          break;
        }
        localObject1 = paramChatMessage.senderuin;
        break;
        if (j != 3000) {
          break label108;
        }
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
        break label108;
        label348:
        continue;
        paramBaseChatItemLayout.a.setOnLongClickListener(null);
        continue;
        label362:
        paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558883, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
      }
    }
  }
  
  private void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
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
    for (paramChatMessage = localFriendsManagerImp.a(paramChatMessage.frienduin, paramChatMessage.senderuin);; paramChatMessage = null)
    {
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0))
      {
        paramBaseChatItemLayout.a(true, paramChatMessage);
        this.d = true;
        paramBaseChatItemLayout.c.setOnClickListener(this);
        paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131230774));
        return;
      }
      this.d = false;
      paramBaseChatItemLayout.a(false, null);
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
    paramViewGroup = (BaseChatItemLayout)paramView;
    if (paramViewGroup == null)
    {
      paramViewGroup = new BaseChatItemLayout(localContext);
      paramViewGroup.setId(2131230835);
      paramViewGroup.setFocusableInTouchMode(true);
      paramViewGroup.setPadding(BaseChatItemLayout.u, BaseChatItemLayout.w, BaseChatItemLayout.v, 0);
      paramView = a();
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramViewGroup;
      paramView.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      paramViewGroup.setContentDescription(null);
      paramView.jdField_a_of_type_JavaLangStringBuilder.replace(0, paramView.jdField_a_of_type_JavaLangStringBuilder.length(), "");
      if (paramChatMessage.time > 0L)
      {
        CharSequence localCharSequence = TimeFormatterUtils.a(localContext, 3, paramChatMessage.time * 1000L);
        paramView.jdField_a_of_type_JavaLangStringBuilder.append(localCharSequence).append(" ");
      }
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      if (!paramChatMessage.isSend()) {
        break label393;
      }
    }
    label393:
    for (int i = 1;; i = 0)
    {
      paramViewGroup.setHearIconPosition(i);
      paramViewGroup.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage.time, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
      paramViewGroup.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage.mMessageSource, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131361809));
      c(paramChatMessage, paramViewGroup);
      a(paramChatMessage, paramViewGroup, paramInt1, paramInt2);
      d(paramChatMessage, paramViewGroup);
      a(paramChatMessage, paramViewGroup, paramView);
      b(paramChatMessage, paramViewGroup);
      a(paramChatMessage, paramViewGroup);
      paramView.jdField_a_of_type_AndroidViewView = a(paramChatMessage, paramView, paramView.jdField_a_of_type_AndroidViewView, paramViewGroup, paramOnLongClickAndTouchListener);
      a(paramChatMessage, localContext, paramViewGroup, paramView, paramInt1, paramInt2);
      paramView.jdField_a_of_type_JavaLangStringBuilder.append(a(paramChatMessage));
      paramViewGroup.setContentDescription(paramView.jdField_a_of_type_JavaLangStringBuilder.toString());
      paramViewGroup.requestLayout();
      return paramViewGroup;
      paramView = (BaseBubbleBuilder.ViewHolder)paramViewGroup.getTag();
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
  
  public void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    String str;
    if (TextUtils.a(paramChatMessage.msg))
    {
      str = TextUtils.a(paramChatMessage.msg);
      if (!(paramChatMessage instanceof MessageForText)) {
        break label118;
      }
      str = paramBubbleInfo.a(str);
      if (str == null) {
        break label118;
      }
      paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      if ((paramView != null) && (paramView.first != null))
      {
        a("keyword_trigger", paramBubbleInfo.jdField_a_of_type_Int, str);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(1), Long.valueOf(paramChatMessage.uniseq), paramView });
      }
    }
    label118:
    do
    {
      do
      {
        return;
        str = paramChatMessage.msg;
        break;
      } while (!paramBubbleInfo.a(paramView.getHeight()));
      paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    } while ((paramView == null) || (paramView.first == null));
    a("wordnum_trigger", paramBubbleInfo.jdField_a_of_type_Int, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(2), Long.valueOf(paramChatMessage.uniseq), paramView });
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo, int paramInt)
  {
    paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if ((paramView != null) && (paramView.first != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramView });
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo) {}
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage) {}
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (a(paramChatMessage, paramBaseChatItemLayout))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return (paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal());
  }
  
  public boolean a_(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.senderuin != null) && (paramChatMessage.senderuin.equals(paramChatMessage.selfuin));
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
  }
  
  protected void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {}
    FriendManager localFriendManager;
    do
    {
      return;
      localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    } while (("1000000".equals(localChatMessage.senderuin)) || ("10000".equals(localChatMessage.senderuin)));
    Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject != null) {}
    for (boolean bool2 = ((FriendManager)localObject).f(localChatMessage.frienduin); (!bool2) && (localChatMessage.istroop == 1); bool2 = false)
    {
      localObject = new Intent(paramView.getContext(), TroopMemberCardActivity.class);
      ((Intent)localObject).putExtra("troopUin", localChatMessage.frienduin);
      ((Intent)localObject).putExtra("memberUin", localChatMessage.senderuin);
      ((Intent)localObject).putExtra("fromFlag", 0);
      ((Activity)paramView.getContext()).startActivityForResult((Intent)localObject, 2000);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_head", 0, 0, localChatMessage.frienduin, localChatMessage.senderuin, "", "");
      return;
    }
    boolean bool1;
    String str;
    if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004))
    {
      bool1 = localFriendManager.b(localChatMessage.senderuin);
      str = localChatMessage.senderuin;
      label270:
      if (str == null) {
        break label449;
      }
      if ((localChatMessage.issend != 1) && (localChatMessage.issend != 2)) {
        break label1407;
      }
    }
    label342:
    label1407:
    for (int i = 1;; i = 0)
    {
      if (localFriendManager.b(str)) {
        bool1 = true;
      }
      if (i != 0)
      {
        localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
        if (str.equals(((ProfileActivity.AllInOne)localObject).g)) {
          ((ProfileActivity.AllInOne)localObject).g = null;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020)) {
          break label1347;
        }
        ((ProfileActivity.AllInOne)localObject).c = localChatMessage.senderuin;
      }
      for (;;)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_Int = 2;
        ((ProfileActivity.AllInOne)localObject).f = 1;
        ProfileActivity.a(paramView.getContext(), (ProfileActivity.AllInOne)localObject);
        return;
        str = localChatMessage.frienduin;
        bool1 = false;
        break label270;
        break;
        if (localChatMessage.istroop == 1008)
        {
          localObject = new Intent(paramView.getContext(), AccountDetailActivity.class);
          ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
          ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          ((ChatActivity)paramView.getContext()).startActivityForResult((Intent)localObject, 2000);
          return;
        }
        if (localChatMessage.istroop == 1024)
        {
          localObject = new Intent(paramView.getContext(), EnterpriseDetailActivity.class);
          ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).putExtra("need_finish", true);
          ((ChatActivity)paramView.getContext()).startActivityForResult((Intent)localObject, 2000);
          return;
        }
        if (bool1)
        {
          if (localChatMessage.istroop == 1) {}
          for (localObject = new ProfileActivity.AllInOne(str, 20);; localObject = new ProfileActivity.AllInOne(str, 1))
          {
            ((ProfileActivity.AllInOne)localObject).g = localFriendManager.a(str);
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
        {
          localObject = new ProfileActivity.AllInOne(str, 70);
          ((ProfileActivity.AllInOne)localObject).g = localFriendManager.a(str);
          break label342;
        }
        if (localChatMessage.istroop == 1000)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 22);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label342;
        }
        if (localChatMessage.istroop == 1020)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 58);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label342;
        }
        if (localChatMessage.istroop == 1)
        {
          if (bool2) {}
          for (localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 58);; localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 21))
          {
            ((ProfileActivity.AllInOne)localObject).g = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, localChatMessage.senderuin);
            break;
          }
        }
        if (3000 == localChatMessage.istroop)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 46);
          ((ProfileActivity.AllInOne)localObject).g = localFriendManager.d(localChatMessage.frienduin, localChatMessage.senderuin);
          break label342;
        }
        if (localChatMessage.istroop == 1001)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 42);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label342;
        }
        if (localChatMessage.istroop == 1004)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 47);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
          break label342;
        }
        if (localChatMessage.istroop == 1005)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 2);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label342;
        }
        if (localChatMessage.istroop == 1023)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 74);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label342;
        }
        if (localChatMessage.istroop == 1009)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 57);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label342;
        }
        if (localChatMessage.istroop == 1006)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 34);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label342;
        }
        if (localChatMessage.istroop == 1009)
        {
          localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 57);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label342;
        }
        if (localChatMessage.istroop == 1021)
        {
          localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 72);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label342;
        }
        if (localChatMessage.istroop == 1022)
        {
          localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 27);
          ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label342;
        }
        localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 19);
        ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label342;
        if (localChatMessage.istroop == 1)
        {
          ((ProfileActivity.AllInOne)localObject).c = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
          ((ProfileActivity.AllInOne)localObject).b = localChatMessage.frienduin;
        }
        else if (3000 == localChatMessage.istroop)
        {
          ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
  
  public void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setProgressVisable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage));
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.istroop == 0) || (paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1001) || (paramChatMessage.istroop == 1002) || (paramChatMessage.istroop == 1003) || (paramChatMessage.istroop == 1004) || (paramChatMessage.istroop == 1005) || (paramChatMessage.istroop == 1006) || (paramChatMessage.istroop == 1008) || (paramChatMessage.istroop == 1009) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1021) || (paramChatMessage.istroop == 1022);
  }
  
  public void c() {}
  
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
    switch (paramView.getId())
    {
    case 2131230774: 
    case 2131230775: 
    case 2131230776: 
    case 2131230777: 
    default: 
      return;
    case 2131230773: 
      b(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */