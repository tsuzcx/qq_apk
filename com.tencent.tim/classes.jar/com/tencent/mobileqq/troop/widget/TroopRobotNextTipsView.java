package com.tencent.mobileqq.troop.widget;

import acfp;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aptw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RobotSubscribeCategory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wja;

public class TroopRobotNextTipsView
  extends RelativeLayout
  implements View.OnClickListener
{
  static int dXG = Color.parseColor("#12B7F5");
  TextView HT;
  Context W;
  oidb_0x496.RobotSubscribeCategory a;
  TextView abr;
  QQAppInterface mApp;
  ChatMessage mMessage;
  
  private TroopRobotNextTipsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TroopRobotNextTipsView(Context paramContext1, Context paramContext2, QQAppInterface paramQQAppInterface)
  {
    this(paramContext1, null);
    this.mApp = paramQQAppInterface;
    this.W = paramContext2;
  }
  
  private TroopRobotNextTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = wja.dp2px(6.0F, getResources());
    if (this.HT == null)
    {
      this.HT = new TextView(getContext());
      this.HT.setId(2131364527);
      this.HT.setBackgroundResource(2130842420);
      this.HT.setTextSize(2, 13.0F);
      this.HT.setTextColor(-1);
      this.HT.setGravity(17);
      this.HT.setPadding(i, 0, i, 0);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(9);
      paramContext.addRule(10);
      addView(this.HT, paramContext);
    }
    if (this.abr == null)
    {
      this.abr = new TextView(getContext());
      this.abr.setId(2131364528);
      this.abr.setBackgroundResource(2130843341);
      this.abr.setTextSize(2, 14.0F);
      this.abr.setTextColor(dXG);
      this.abr.setGravity(17);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(11);
      paramContext.addRule(10);
      this.abr.setPadding(i, 0, i, 0);
      addView(this.abr, paramContext);
    }
    this.HT.setText(acfp.m(2131716113));
    this.abr.setText(acfp.m(2131716100));
    this.abr.setOnClickListener(this);
  }
  
  public void ac(ChatMessage paramChatMessage)
  {
    this.mMessage = paramChatMessage;
    Object localObject = (aptw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(203);
    boolean bool = ((aptw)localObject).bh(paramChatMessage);
    this.a = ((aptw)localObject).a(((aptw)localObject).g(paramChatMessage));
    if (this.a != null)
    {
      localObject = this.a.name.get();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.HT.setText((CharSequence)localObject);
        this.HT.setVisibility(0);
        localObject = this.a.next_wording.get();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bool)) {
          break label189;
        }
        this.abr.setVisibility(0);
        this.abr.setText((CharSequence)localObject);
      }
      for (;;)
      {
        int j = BaseChatItemLayout.bOc;
        int i = BaseChatItemLayout.bOd;
        if (paramChatMessage.isSend())
        {
          j = BaseChatItemLayout.bOd;
          i = BaseChatItemLayout.bOc;
        }
        setPadding(j, 0, i, wja.dp2px(10.0F, getContext().getResources()));
        return;
        this.HT.setVisibility(8);
        break;
        label189:
        this.abr.setVisibility(8);
      }
    }
    this.HT.setVisibility(8);
    this.abr.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aptw localaptw = (aptw)this.mApp.getManager(203);
      Object localObject = ((FragmentActivity)this.W).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null))
      {
        localObject = ((ChatFragment)localObject).a();
        if (this.a != null) {
          localaptw.a(getContext(), (BaseChatPie)localObject, this.mApp, ((BaseChatPie)localObject).a, ((BaseChatPie)localObject).sessionInfo, this.mMessage, this.a.next_content.get());
        } else {
          localaptw.a(getContext(), (BaseChatPie)localObject, this.mApp, ((BaseChatPie)localObject).a, ((BaseChatPie)localObject).sessionInfo, this.mMessage, this.abr.getText().toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopRobotNextTipsView
 * JD-Core Version:    0.7.0.1
 */