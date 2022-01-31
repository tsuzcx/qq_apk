package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
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
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import eay;
import eaz;
import eba;
import ebb;
import ebc;
import ebd;

public class TextItemBuilder
  extends BaseBubbleBuilder
{
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int g = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private static final int h = BaseChatItemLayout.l + BaseChatItemLayout.q;
  private View.OnClickListener a;
  
  public TextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new eay(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    TextItemBuilder.Holder localHolder = (TextItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new ETTextView(paramBaseChatItemLayout);
      paramViewHolder.setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131362087));
      paramViewHolder.setLinkTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131362086));
      paramViewHolder.setSpannableFactory(QQText.a);
      paramViewHolder.setMaxWidth(BaseChatItemLayout.f);
      paramViewHolder.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewHolder.setId(2131231227);
      localHolder.a = paramViewHolder;
    }
    ((ETTextView)localHolder.a).setFont(0, paramChatMessage.uniseq);
    localHolder.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int j = BaseChatItemLayout.p;
    int i = BaseChatItemLayout.q;
    if (paramChatMessage.isSend())
    {
      j = BaseChatItemLayout.q;
      i = BaseChatItemLayout.p;
    }
    localHolder.a.setPadding(j, BaseChatItemLayout.n, i, BaseChatItemLayout.o);
    if ((paramChatMessage instanceof MessageForText))
    {
      paramView = (MessageForText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008) {
        if (paramChatMessage.isSend()) {
          localHolder.a.setText(paramBaseChatItemLayout.getString(2131561557));
        }
      }
    }
    for (;;)
    {
      localHolder.a.setOnTouchListener(paramOnLongClickAndTouchListener);
      localHolder.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localHolder.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((localHolder.a instanceof AnimationTextView)) {
        ((AnimationTextView)localHolder.a).a = new eaz(this);
      }
      return paramViewHolder;
      localHolder.a.setText(paramBaseChatItemLayout.getString(2131561556));
      continue;
      localHolder.a.setText(paramView.sb);
      continue;
      localHolder.a.setText(paramChatMessage.msg);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TextItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText)) {
      return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558911, new Object[] { ((MessageForText)paramChatMessage).sb });
    }
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558911, new Object[] { paramChatMessage.msg });
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
    case 2131234874: 
    case 2131234879: 
      do
      {
        return;
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      } while (paramChatMessage.msg == null);
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(b(paramChatMessage));
      return;
    case 2131234880: 
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
      return;
    case 2131231190: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", b(paramChatMessage));
      paramChatMessage = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      paramChatMessage.putExtras(paramContext);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    case 2131234886: 
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectTransLangActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
    case 2131234887: 
      paramChatMessage = DialogUtil.c(this.jdField_a_of_type_AndroidContentContext, 230, null, null, 2131561746, 2131562539, null, null);
      paramChatMessage.setDividerGone();
      if (TextTranslationItemBuilder.d) {}
      for (paramContext = this.jdField_a_of_type_AndroidContentContext.getString(2131559796);; paramContext = this.jdField_a_of_type_AndroidContentContext.getString(2131559797))
      {
        paramChatMessage.setMessage(paramContext);
        paramContext = new eba(this);
        ebb localebb = new ebb(this);
        paramChatMessage.setPositiveButton(2131562539, paramContext);
        paramChatMessage.setNegativeButton(2131561746, localebb);
        paramChatMessage.show();
        return;
      }
    }
    a(paramChatMessage, b(paramChatMessage));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForText)AIOUtils.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131562859);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131561439);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ebc(this, paramView), new ebd(this)).show();
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
    TextItemBuilder.Holder localHolder = (TextItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.a == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131362090);
        localHolder.a.setTextColor(paramViewHolder);
        if (!paramChatMessage.isSend()) {
          break label86;
        }
      }
      label86:
      for (paramViewHolder = paramView.getColorStateList(2131362089);; paramViewHolder = paramView.getColorStateList(2131362088))
      {
        localHolder.a.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131362087);
        break;
      }
    }
    if (paramBubbleInfo.b == 0) {
      localHolder.a.setTextColor(-16777216);
    }
    while (paramBubbleInfo.c == 0)
    {
      localHolder.a.setLinkTextColor(paramView.getResources().getColorStateList(2131362088));
      return;
      localHolder.a.setTextColor(paramBubbleInfo.b);
    }
    localHolder.a.setLinkTextColor(paramBubbleInfo.c);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    paramViewHolder = (TextItemBuilder.Holder)paramViewHolder;
    ETTextView localETTextView;
    if (((paramViewHolder.a instanceof ETTextView)) && (b(paramChatMessage)))
    {
      localETTextView = (ETTextView)paramViewHolder.a;
      if (!paramChatMessage.isSend()) {
        break label72;
      }
    }
    label72:
    for (paramViewHolder = paramChatMessage.selfuin;; paramViewHolder = paramChatMessage.frienduin)
    {
      localETTextView.setFont(((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a(paramViewHolder, paramChatMessage.isSend()), paramChatMessage.uniseq);
      return;
    }
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    QfavBuilder.a(paramChatMessage.msg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    QfavBuilder.a(paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForText)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131234879, this.jdField_a_of_type_AndroidContentContext.getString(17039361));
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localQQCustomMenu.a(2131234880, this.jdField_a_of_type_AndroidContentContext.getString(2131562855));
    }
    localQQCustomMenu.a(2131231190, this.jdField_a_of_type_AndroidContentContext.getString(2131562129));
    localQQCustomMenu.a(2131231192, this.jdField_a_of_type_AndroidContentContext.getString(2131560772));
    if (!paramView.isSend())
    {
      localQQCustomMenu.a(2131234886, this.jdField_a_of_type_AndroidContentContext.getString(2131559793));
      if (!TextTranslationItemBuilder.d) {
        break label168;
      }
      localQQCustomMenu.a(2131234887, this.jdField_a_of_type_AndroidContentContext.getString(2131559795));
    }
    for (;;)
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      return localQQCustomMenu.a();
      label168:
      localQQCustomMenu.a(2131234887, this.jdField_a_of_type_AndroidContentContext.getString(2131559794));
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    String str = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Trans_entity localTrans_entity = null;
    TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (localTransDiskCache != null) {
      localTrans_entity = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, str);
    }
    if ((localTrans_entity != null) && (localTrans_entity.a().booleanValue()) && (!paramChatMessage.isSend())) {
      return localTrans_entity.a();
    }
    return paramChatMessage.msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder
 * JD-Core Version:    0.7.0.1
 */