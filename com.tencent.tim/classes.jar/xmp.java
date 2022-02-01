import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShakeWindow;

public class xmp
  extends BaseBubbleBuilder
{
  private View.OnClickListener onClickListener = new xmq(this);
  private long startTime = -1L;
  
  public xmp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    xmp.a locala = (xmp.a)parame;
    parame = paramView;
    if (paramView == null)
    {
      parame = new LinearLayout(paramBaseChatItemLayout);
      parame.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      parame.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131167322));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.bNT);
      ((TextView)localObject).setId(2131364506);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      parame.addView((View)localObject, localLayoutParams);
      locala.tw = paramView;
      locala.JM = ((TextView)localObject);
    }
    locala.JM.setTextSize(0, this.sessionInfo.cN);
    int k = BaseChatItemLayout.bOc;
    int j = BaseChatItemLayout.bOd;
    int i = BaseChatItemLayout.bOc;
    locala.tw.setImageResource(2130845737);
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.bOd;
      j = BaseChatItemLayout.bOc;
      i = BaseChatItemLayout.bOd;
      locala.tw.setImageResource(2130845738);
    }
    locala.tw.setPadding(i, 0, 0, 0);
    locala.JM.setPadding(k, BaseChatItemLayout.bOa, j, BaseChatItemLayout.bOb);
    locala.JM.setText(paramBaseChatItemLayout.getResources().getString(2131720016));
    parame.setOnTouchListener(paramwlz);
    parame.setOnLongClickListener(paramwlz);
    parame.setOnClickListener(this.onClickListener);
    if (aTl)
    {
      if ((locala.E != null) && (locala.E.length() > 0)) {
        locala.E.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L) {
        paramView.append(aqmu.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
      }
      if (!paramChatMessage.isSend()) {
        break label417;
      }
      paramView.append("我抖了").append(this.sessionInfo.aTn).append("一下");
    }
    for (;;)
    {
      parame.setContentDescription(paramView.toString());
      return parame;
      label417:
      paramView.append(this.sessionInfo.aTn).append("抖了你一下");
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xmp.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131365686: 
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    }
    super.m(paramChatMessage);
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    xmp.a locala = (xmp.a)parame;
    if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        parame = paramView.getColorStateList(2131167326);
        if (parame != null) {
          locala.JM.setTextColor(parame);
        }
        if (!paramChatMessage.isSend()) {
          break label90;
        }
      }
      label90:
      for (parame = paramView.getColorStateList(2131167325);; parame = paramView.getColorStateList(2131167324))
      {
        locala.JM.setLinkTextColor(parame);
        return;
        parame = paramView.getColorStateList(2131167322);
        break;
      }
    }
    if (paramadxp.mTextColor == 0) {
      locala.JM.setTextColor(-16777216);
    }
    while (paramadxp.mLinkColor == 0)
    {
      locala.JM.setLinkTextColor(paramView.getResources().getColorStateList(2131167324));
      return;
      locala.JM.setTextColor(paramadxp.mTextColor);
    }
    locala.JM.setLinkTextColor(paramadxp.mLinkColor);
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
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(aqmu.a(this.mContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    if (paramChatMessage.isSend()) {
      localStringBuilder.append("我抖了").append(this.sessionInfo.aTn).append("一下");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.sessionInfo.aTn).append("抖了你一下");
    }
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    paramView = (MessageForShakeWindow)wja.a(paramView);
    String str1 = this.mContext.getString(2131690230);
    String str2 = this.mContext.getString(2131690231);
    if (paramView.isSendFromLocal()) {
      aqha.a(this.mContext, 230, str1, str2, new xmr(this, paramView), new xms(this)).show();
    }
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    TextView JM;
    ImageView tw;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmp
 * JD-Core Version:    0.7.0.1
 */