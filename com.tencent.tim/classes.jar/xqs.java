import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xqs
  extends BaseBubbleBuilder
{
  public xqs(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseBubbleBuilder.e parame, View paramView)
  {
    int i = 0;
    if (((this.mContext instanceof MultiForwardActivity)) || (this.sessionInfo.beB)) {}
    for (boolean bool = false;; bool = true)
    {
      ifo localifo;
      if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000))
      {
        paramContext = ifw.Q(this.mContext.getApplicationContext());
        localifo = ifs.a(this.mContext.getApplicationContext());
        if (localifo == null) {
          break label324;
        }
      }
      label324:
      for (paramContext = localifo.a(paramChatMessage.msg, paramChatMessage.uniseq, paramContext);; paramContext = null)
      {
        if ((paramContext != null) && (paramContext.e().booleanValue()) && (!paramChatMessage.isSend())) {}
        for (parame.b = adyd.a(100001, this.app, this.mContext.getResources(), null, bool);; parame.b = adyd.a(100000, this.app, this.mContext.getResources(), null, bool))
        {
          if (parame.b != null) {
            parame.b.m(parame.E, null);
          }
          if (parame.b != null)
          {
            int j = paramChatMessage.vipBubbleDiyTextId;
            i = j;
            if (j <= 0) {
              i = acle.R(paramChatMessage.vipBubbleID);
            }
            parame.b.a(this.app, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), true, paramView, ku.a(paramChatMessage), i);
          }
          if (parame.E != null)
          {
            paramContext = parame.E.getBackground();
            if (paramContext != null) {
              paramContext.setAlpha(alpha);
            }
          }
          super.a(paramView, paramChatMessage);
          return;
        }
        if (!paramChatMessage.needVipBubble()) {}
        for (;;)
        {
          parame.b = adyd.a(i, this.app, paramContext.getResources(), null, bool);
          break;
          i = ((acle)this.app.getBusinessHandler(13)).j(paramChatMessage);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Object localObject2;
    RelativeLayout localRelativeLayout;
    Object localObject1;
    if (paramView == null)
    {
      localObject2 = new RelativeLayout(this.mContext);
      localRelativeLayout = (RelativeLayout)localObject2;
      localObject1 = new RelativeLayout(this.mContext);
      paramBaseChatItemLayout = new TextView(this.mContext);
      paramBaseChatItemLayout.setMaxWidth(BaseChatItemLayout.bNS);
      paramBaseChatItemLayout.setTextColor(this.mContext.getResources().getColorStateList(2131167322));
      paramBaseChatItemLayout.setLinkTextColor(this.mContext.getResources().getColorStateList(2131167316));
      paramBaseChatItemLayout.setTextSize(0, this.sessionInfo.cN);
      paramBaseChatItemLayout.setId(2131374483);
      ((RelativeLayout)localObject1).setId(2131374484);
      ((RelativeLayout)localObject1).addView(paramBaseChatItemLayout);
      paramView = new TextView(this.mContext);
      paramView.setSingleLine(true);
      paramView.setGravity(17);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(1, 13.0F);
      paramView.setBackgroundResource(2130843454);
      paramView.setId(2131374486);
      paramView.setText(acfp.m(2131716181));
      localRelativeLayout.addView((View)localObject1);
      localRelativeLayout.addView(paramView);
      localObject1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131374484);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374484);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.mDensity));
      localObject1 = paramView;
      ((TextView)localObject1).setPadding((int)(5.0F * this.mDensity), 0, (int)(5.0F * this.mDensity), 0);
      ((TextView)localObject1).getLayoutParams().height = ((int)(20.0F * this.mDensity));
      paramView = (MessageForWantGiftMsg)paramChatMessage;
      ((TextView)localObject1).setOnClickListener(new xqt(this, paramChatMessage, paramView));
      int j = BaseChatItemLayout.bOc;
      int i = BaseChatItemLayout.bOd;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.bOd;
        i = BaseChatItemLayout.bOc;
      }
      paramBaseChatItemLayout.setPadding(j, BaseChatItemLayout.bOa, i, BaseChatItemLayout.bOb);
      paramBaseChatItemLayout.setText(paramView.msg);
      paramBaseChatItemLayout.setBackgroundResource(2130838454);
      a(paramChatMessage, this.mContext, parame, localRelativeLayout.findViewById(2131374484));
      if (paramView.wantGiftSenderUin == this.app.getLongAccountUin()) {
        break label466;
      }
      ((TextView)localObject1).setVisibility(8);
    }
    for (;;)
    {
      ((View)localObject2).setOnLongClickListener(paramwlz);
      ((View)localObject2).setOnTouchListener(new xqu(this, paramwlz));
      return localObject2;
      localRelativeLayout = (RelativeLayout)paramView;
      paramBaseChatItemLayout = (TextView)localRelativeLayout.findViewById(2131374483);
      localObject1 = (TextView)localRelativeLayout.findViewById(2131374486);
      localObject2 = paramView;
      break;
      label466:
      ((TextView)localObject1).setVisibility(0);
      new anov(this.app).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_send_him").a(0).a(new String[] { paramChatMessage.frienduin + "", "29" }).report();
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xqs.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131377133: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ujt.b(this.mContext, this.app, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.bNY, 0, 0, BaseChatItemLayout.bNW);
      return;
    }
    paramView.setPadding(0, 0, BaseChatItemLayout.bNY, BaseChatItemLayout.bNW);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = wja.a(paramView);
    a(paramView, localaqoa);
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    b(paramView, localaqoa);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return paramChatMessage.msg;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqs
 * JD-Core Version:    0.7.0.1
 */