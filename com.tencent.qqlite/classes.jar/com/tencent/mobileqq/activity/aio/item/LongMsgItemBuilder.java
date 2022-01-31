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
import bvi;
import bvj;
import bvk;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

public class LongMsgItemBuilder
  extends BaseBubbleBuilder
{
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int g = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private static final int h = BaseChatItemLayout.l + BaseChatItemLayout.q;
  
  public LongMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
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
      paramViewHolder.setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131427473));
      paramViewHolder.setMaxWidth(BaseChatItemLayout.f);
      paramViewHolder.setSpannableFactory(QQText.a);
      paramViewHolder.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewHolder.setId(2131296698);
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
      ((AnimationTextView)localHolder.a).a = new bvi(this);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new LongMsgItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "说" + ((MessageForLongMsg)paramChatMessage).sb;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131298932: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131298937: 
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage));
      return;
    case 2131298938: 
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
      return;
    case 2131296652: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
      paramChatMessage = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      paramChatMessage.putExtras(paramContext);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    case 2131298945: 
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
    case 2131296656: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    }
    a(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363073);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131363074);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new bvj(this, paramView), new bvk(this)).show();
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
        paramViewHolder = paramView.getColorStateList(2131427476);
        localHolder.a.setTextColor(paramViewHolder);
        if (!paramChatMessage.isSend()) {
          break label86;
        }
      }
      label86:
      for (paramViewHolder = paramView.getColorStateList(2131427475);; paramViewHolder = paramView.getColorStateList(2131427474))
      {
        localHolder.a.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131427473);
        break;
      }
    }
    if (paramBubbleInfo.c == 0) {
      localHolder.a.setTextColor(-16777216);
    }
    while (paramBubbleInfo.d == 0)
    {
      localHolder.a.setLinkTextColor(paramView.getResources().getColorStateList(2131427474));
      return;
      localHolder.a.setTextColor(paramBubbleInfo.c);
    }
    localHolder.a.setLinkTextColor(paramBubbleInfo.d);
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
      localQQCustomMenu.a(2131298937, this.jdField_a_of_type_AndroidContentContext.getString(2131363124));
      localQQCustomMenu.a(2131298938, this.jdField_a_of_type_AndroidContentContext.getString(2131363126));
    }
    for (;;)
    {
      localQQCustomMenu.a(2131296652, this.jdField_a_of_type_AndroidContentContext.getString(2131363562));
      localQQCustomMenu.a(2131296656, this.jdField_a_of_type_AndroidContentContext.getString(2131362666));
      a(localQQCustomMenu);
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      return localQQCustomMenu.a();
      localQQCustomMenu.a(2131298937, "复制");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */