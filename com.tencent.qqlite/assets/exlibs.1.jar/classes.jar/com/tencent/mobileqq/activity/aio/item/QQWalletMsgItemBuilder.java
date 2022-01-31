package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bxn;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg.QQWalletTransferMsgElem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;

public class QQWalletMsgItemBuilder
  extends BaseBubbleBuilder
{
  protected String b = "";
  protected final int e = 100001;
  protected final int f = 100002;
  protected final int g = 100003;
  protected final int h = 100004;
  protected final int i = 100005;
  protected final int j = 100006;
  protected final int k = 100007;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  
  public QQWalletMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.b = paramContext.getString(2131362783);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.l = ((int)(222.0F * f1 + 0.5F));
    this.m = ((int)(42.0F * f1 + 0.5F));
    this.n = ((int)(21.0F * f1 + 0.5F));
    this.o = ((int)(15.0F * f1 + 0.5F));
    this.p = ((int)(10.0F * f1 + 0.5F));
    this.q = ((int)(9.0F * f1 + 0.5F));
    this.r = ((int)(6.0F * f1 + 0.5F));
    this.s = ((int)(f1 * 4.0F + 0.5F));
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130839047;
    case 2: 
      return 2130839044;
    }
    return 2130839048;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (bxn)paramViewHolder;
    if ((paramView.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramView.jdField_a_of_type_Long == paramChatMessage.uniseq)) {
      return paramView.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    if (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = a(this.jdField_a_of_type_AndroidContentContext);
    }
    paramView.jdField_a_of_type_Long = paramChatMessage.uniseq;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;; paramViewHolder = null)
    {
      if ((paramViewHolder == null) || (paramViewHolder.mQQWalletTransferMsg == null)) {
        return paramView.jdField_a_of_type_AndroidWidgetRelativeLayout;
      }
      QQWalletTransferMsg.QQWalletTransferMsgElem localQQWalletTransferMsgElem = paramViewHolder.mQQWalletTransferMsg.elem;
      if (localQQWalletTransferMsgElem == null) {
        return paramView.jdField_a_of_type_AndroidWidgetRelativeLayout;
      }
      TextView localTextView1 = (TextView)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(100003);
      TextView localTextView2 = (TextView)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(100004);
      ImageView localImageView = (ImageView)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(100002);
      TextView localTextView3 = (TextView)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(100006);
      paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(100007);
      QQWalletTransferBubbleView localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(100001);
      localTextView1.setText(localQQWalletTransferMsgElem.title);
      localTextView2.setText(localQQWalletTransferMsgElem.subTitle);
      localTextView3.setText(localQQWalletTransferMsgElem.content);
      localImageView.setImageResource(a(localQQWalletTransferMsgElem.icon));
      int i1 = localQQWalletTransferMsgElem.background;
      boolean bool;
      if (!paramChatMessage.isSend())
      {
        bool = true;
        localQQWalletTransferBubbleView.setBubbleBackground(2130839045, 0xFF000000 | i1, bool);
        if (TextUtils.isEmpty(localQQWalletTransferMsgElem.blackStripe)) {
          break label427;
        }
        paramBaseChatItemLayout.setText(localQQWalletTransferMsgElem.blackStripe);
        paramBaseChatItemLayout.setVisibility(0);
      }
      for (;;)
      {
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(localQQWalletTransferMsgElem.title + localQQWalletTransferMsgElem.subTitle + this.b);
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + paramViewHolder.mQQWalletTransferMsg.templateId, "", "", "");
        return paramView.jdField_a_of_type_AndroidWidgetRelativeLayout;
        bool = false;
        break;
        label427:
        paramBaseChatItemLayout.setVisibility(8);
      }
    }
  }
  
  protected RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    Object localObject1 = new QQWalletTransferBubbleView(paramContext);
    ((QQWalletTransferBubbleView)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.l, -2));
    ((QQWalletTransferBubbleView)localObject1).setId(100001);
    Object localObject2 = new ImageView(paramContext);
    Object localObject3 = new RelativeLayout.LayoutParams(this.m, this.m);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.n;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject2).setId(100002);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(this.p * 12, -2);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.n;
    ((RelativeLayout.LayoutParams)localObject3).topMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextColor(-1);
    ((TextView)localObject3).setTextSize(24.0F);
    ((TextView)localObject3).setId(100003);
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = (this.p / 2);
    ((TextView)localObject3).setLayoutParams(localLayoutParams);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextColor(-1);
    ((TextView)localObject3).setTextSize(14.0F);
    ((TextView)localObject3).setId(100004);
    ((LinearLayout)localObject2).addView((View)localObject3);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localObject1 = new RelativeLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(this.l, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 100001);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setBackgroundResource(2130839046);
    ((RelativeLayout)localObject1).setId(100005);
    paramContext = new TextView(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.n;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.n;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(100006);
    ((RelativeLayout)localObject1).addView(paramContext);
    localRelativeLayout.addView((View)localObject1);
    return localRelativeLayout;
  }
  
  protected TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.p;
    localLayoutParams.bottomMargin = this.r;
    localLayoutParams.leftMargin = (this.m + this.s);
    localLayoutParams.rightMargin = (this.m + this.s);
    localLayoutParams.addRule(3, 2131296305);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130838639);
    paramContext.setPadding(this.q, this.s, this.q, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.s, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(100007);
    return paramContext;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new bxn(this, null);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.msg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    if (super.a()) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364497, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */