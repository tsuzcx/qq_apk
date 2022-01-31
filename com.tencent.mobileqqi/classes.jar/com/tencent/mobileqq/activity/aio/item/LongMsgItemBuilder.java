package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.language.SelectTransLangActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import eek;
import eel;
import eem;

public class LongMsgItemBuilder
  extends BaseBubbleBuilder
{
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int g = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private static final int h = BaseChatItemLayout.l + BaseChatItemLayout.q;
  
  public LongMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new AnimationTextView(paramBaseChatItemLayout);
      paramViewHolder.setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131362077));
      paramViewHolder.setMaxWidth(BaseChatItemLayout.f);
      paramViewHolder.setSpannableFactory(QQText.a);
      paramViewHolder.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewHolder.setId(2131231227);
      localHolder.a = paramViewHolder;
    }
    localHolder.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int j = BaseChatItemLayout.p;
    int i = BaseChatItemLayout.q;
    if (paramChatMessage.isSend())
    {
      j = BaseChatItemLayout.q;
      i = BaseChatItemLayout.p;
    }
    localHolder.a.setPadding(j, BaseChatItemLayout.n, i, BaseChatItemLayout.o);
    paramChatMessage = (MessageForLongMsg)paramChatMessage;
    localHolder.a.setText(paramChatMessage.sb);
    localHolder.a.setOnTouchListener(paramOnLongClickAndTouchListener);
    localHolder.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
    if ((localHolder.a instanceof AnimationTextView)) {
      ((AnimationTextView)localHolder.a).a = new eek(this);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new LongMsgItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558895, new Object[] { ((MessageForLongMsg)paramChatMessage).sb });
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131234872: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131234877: 
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage));
      return;
    case 2131234878: 
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
      return;
    case 2131231190: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
      paramChatMessage = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      paramChatMessage.putExtras(paramContext);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    case 2131234884: 
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectTransLangActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
    }
    a((MessageForLongMsg)paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForLongMsg)AIOUtils.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131562859);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131561439);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new eel(this, paramView), new eem(this)).show();
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(h, e, g, f);
      return;
    }
    paramView.setPadding(g, e, h, f);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.a == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131362080);
        localHolder.a.setTextColor(paramViewHolder);
        if (!paramChatMessage.isSend()) {
          break label86;
        }
      }
      label86:
      for (paramViewHolder = paramView.getColorStateList(2131362079);; paramViewHolder = paramView.getColorStateList(2131362078))
      {
        localHolder.a.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131362077);
        break;
      }
    }
    if (paramBubbleInfo.b == 0) {
      localHolder.a.setTextColor(-16777216);
    }
    while (paramBubbleInfo.c == 0)
    {
      localHolder.a.setLinkTextColor(paramView.getResources().getColorStateList(2131362078));
      return;
      localHolder.a.setTextColor(paramBubbleInfo.b);
    }
    localHolder.a.setLinkTextColor(paramBubbleInfo.c);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    QfavBuilder.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForLongMsg)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localQQCustomMenu.a(2131234877, this.jdField_a_of_type_AndroidContentContext.getString(2131561880));
      localQQCustomMenu.a(2131234878, this.jdField_a_of_type_AndroidContentContext.getString(2131562855));
    }
    for (;;)
    {
      localQQCustomMenu.a(2131231190, this.jdField_a_of_type_AndroidContentContext.getString(2131562129));
      localQQCustomMenu.a(2131231192, this.jdField_a_of_type_AndroidContentContext.getString(2131560772));
      if (!paramView.isSend()) {
        localQQCustomMenu.a(2131234884, this.jdField_a_of_type_AndroidContentContext.getString(2131559793));
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      return localQQCustomMenu.a();
      localQQCustomMenu.a(2131234877, this.jdField_a_of_type_AndroidContentContext.getString(17039361));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */