import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.HashSet;

public class wyt
  extends BaseBubbleBuilder
{
  HashSet<String> aB = new HashSet();
  private final float mDensity;
  
  public wyt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(wyt.a parama)
  {
    if (parama.c.isMixed)
    {
      Object localObject = parama.c;
      if (((MessageForPic)localObject).msgtype == -1032)
      {
        parama.IN.setVisibility(8);
        return;
      }
      String str2 = this.mContext.getString(2131721554);
      String str1;
      if (((MessageForPic)localObject).shareAppID != 0L)
      {
        localObject = aqgb.bM(((MessageForPic)localObject).shareAppID);
        AppShareID localAppShareID = this.app.a().a((String)localObject);
        if (localAppShareID != null)
        {
          str1 = str2;
          if (localAppShareID.messagetail != null) {
            str1 = this.mContext.getString(2131690419) + localAppShareID.messagetail;
          }
        }
      }
      for (;;)
      {
        parama.IN.setVisibility(0);
        parama.IN.setText(str1);
        return;
        str1 = str2;
        if (!this.aB.contains(localObject))
        {
          anae.n(this.app, this.app.getCurrentAccountUin(), (String)localObject);
          this.aB.add(localObject);
          str1 = str2;
          continue;
          str1 = str2;
          if (((MessageForPic)localObject).msgtype == -3001) {
            str1 = this.mContext.getString(2131693303);
          }
        }
      }
    }
    parama.IN.setVisibility(8);
  }
  
  private void b(MessageForPic paramMessageForPic)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaurl", paramMessageForPic.action);
    localBundle.putString("uin", this.app.getCurrentAccountUin());
    localBundle.putString("vkey", this.app.rK());
    OpenAppClient.q((Activity)this.mContext, localBundle);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout = (wyt.a)parame;
    parame = paramView;
    if (paramView == null)
    {
      parame = new LinearLayout(this.mContext);
      parame.setOrientation(1);
      paramView = new ChatThumbView(this.mContext);
      paramView.setId(2131373231);
      if (!bdm) {
        paramView.setAdjustViewBounds(true);
      }
      paramView.setMaxWidth((int)(this.mDensity * 224.0F + 0.5F));
      paramView.setMaxHeight((int)(this.mDensity * 224.0F + 0.5F));
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      int i = (int)(this.mDensity * 5.0F + 0.5F);
      ((LinearLayout.LayoutParams)localObject).leftMargin = i;
      ((LinearLayout.LayoutParams)localObject).topMargin = i;
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject).bottomMargin = i;
      parame.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(this.mContext);
      ((TextView)localObject).setTextColor(-16777216);
      ((TextView)localObject).setTextSize(2, 12.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      localLayoutParams.bottomMargin = i;
      parame.addView((View)localObject, localLayoutParams);
      parame.setOnClickListener(this);
      parame.setOnTouchListener(paramwlz);
      parame.setOnLongClickListener(paramwlz);
      paramBaseChatItemLayout.a = paramView;
      paramBaseChatItemLayout.IN = ((TextView)localObject);
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramBaseChatItemLayout.c = paramChatMessage;
    if (!paramChatMessage.isSendFromLocal())
    {
      paramView = aoop.a(paramChatMessage, 1);
      if ((paramBaseChatItemLayout.u == null) || (!paramBaseChatItemLayout.u.getURL().equals(paramView)))
      {
        paramChatMessage = xkl.b(this.mContext, paramChatMessage, paramBaseChatItemLayout.a);
        paramBaseChatItemLayout.a.setImageDrawable(paramChatMessage);
        paramBaseChatItemLayout.u = paramChatMessage;
      }
    }
    a(paramBaseChatItemLayout);
    return parame;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new wyt.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365686) {
      ujt.b(this.mContext, this.app, paramChatMessage);
    }
    while (paramInt != 2131372073) {
      return;
    }
    super.m(paramChatMessage);
  }
  
  public aqob[] a(View paramView)
  {
    paramView = new aqoa();
    ujt.a(paramView, this.mContext, this.sessionInfo.cZ);
    super.c(paramView, this.mContext);
    super.e(paramView, this.mContext);
    return paramView.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131702766);
  }
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    if (super.Rk()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131364503)
      {
        Object localObject = (wyt.a)wja.a(paramView);
        MessageForPic localMessageForPic = (MessageForPic)((wyt.a)localObject).mMessage;
        localObject = ((wyt.a)localObject).u;
        if (!localMessageForPic.isSendFromLocal()) {
          switch (((URLDrawable)localObject).getStatus())
          {
          default: 
            break;
          case 0: 
            if (((URLDrawable)localObject).isDownloadStarted()) {
              continue;
            }
            ((URLDrawable)localObject).startDownload();
            break;
          case 2: 
            ((URLDrawable)localObject).restartDownload();
            break;
          case 1: 
            if (localMessageForPic.msgtype == -3001)
            {
              b(localMessageForPic);
              continue;
            }
            if (localMessageForPic.msgtype == -3005)
            {
              ChatActivityUtils.a(this.mContext, this.app, localMessageForPic.action, localMessageForPic.shareAppID, localMessageForPic.msgtype);
              continue;
            }
            if ((localMessageForPic.msgtype != -3000) && (localMessageForPic.msgtype != -3004) && (localMessageForPic.msgtype != -1032)) {
              continue;
            }
            ChatActivityUtils.a(this.mContext, this.app, localMessageForPic.action, localMessageForPic.shareAppID, localMessageForPic.msgtype, null);
            break;
          }
        }
      }
      else
      {
        super.onClick(paramView);
      }
    }
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    public TextView IN;
    public ChatThumbView a;
    public MessageForPic c;
    public URLDrawable u;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyt
 * JD-Core Version:    0.7.0.1
 */