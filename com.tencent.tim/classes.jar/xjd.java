import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.LocationShareItemBuilder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class xjd
  extends BaseBubbleBuilder
{
  private static final int bTs = BaseChatItemLayout.bNV + BaseChatItemLayout.bOa;
  private static final int bTt = BaseChatItemLayout.bNW + BaseChatItemLayout.bOb;
  private static final int bTu = BaseChatItemLayout.bNX + BaseChatItemLayout.bOc;
  private static final int bTv = BaseChatItemLayout.bNY + BaseChatItemLayout.bOd;
  private long IU;
  aisg a = new aisg();
  private boolean clickable = true;
  private ColorStateList n;
  
  public xjd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.n = paramContext.getResources().getColorStateList(2131167322);
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, new Object[] { "LocationShareItemBuilder.new: invoked. ", " clickable: ", Boolean.valueOf(this.clickable) });
    }
  }
  
  private void a(MessageForLocationShare paramMessageForLocationShare)
  {
    List localList;
    if (this.IU == 0L)
    {
      localList = aiup.a(this.app, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
      if ((localList == null) || (localList.size() < 1)) {
        break label97;
      }
    }
    label97:
    for (this.IU = ((MessageRecord)localList.get(localList.size() - 1)).time;; this.IU = (System.currentTimeMillis() / 1000L))
    {
      if (this.IU > paramMessageForLocationShare.time)
      {
        paramMessageForLocationShare.isSharingLocation = false;
        ThreadManager.excute(new LocationShareItemBuilder.1(this, paramMessageForLocationShare), 32, null, true);
      }
      return;
    }
  }
  
  private void c(TextView paramTextView, int paramInt)
  {
    Resources localResources = this.mContext.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int i = localDrawable.getIntrinsicWidth();
    int j = localDrawable.getIntrinsicHeight();
    switch (this.mContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    }
    int m;
    for (paramInt = j;; paramInt = (int)((j * this.sessionInfo.cN / paramInt + m) * 1.6D))
    {
      localDrawable.setBounds(0, 0, i, paramInt);
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.contentPadding);
      return;
      int k = localResources.getDimensionPixelSize(2131298061);
      m = localResources.getDimensionPixelSize(2131298062);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      i = (int)((i * this.sessionInfo.cN / paramInt + m) * 1.6D);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramBaseChatItemLayout = (xjd.a)parame;
    Resources localResources = this.mContext.getResources();
    parame = paramView;
    if (paramView == null)
    {
      parame = new TextView(this.mContext);
      parame.setId(2131364506);
      parame.setTextColor(this.n);
      parame.setTextSize(localResources.getDimensionPixelOffset(2131296478));
      parame.setGravity(16);
      paramBaseChatItemLayout.mTextView = parame;
    }
    paramView = (MessageForLocationShare)paramChatMessage;
    try
    {
      a(paramView);
      label81:
      int i;
      int j;
      if (paramView.isSharingLocation)
      {
        if (!auvj.isNightMode()) {
          if (paramView.isSend()) {
            i = 2130838182;
          }
        }
        for (;;)
        {
          j = localResources.getColor(2131167304);
          c(paramBaseChatItemLayout.mTextView, i);
          paramBaseChatItemLayout.mTextView.setTextColor(j);
          paramBaseChatItemLayout.mTextView.setText(paramChatMessage.msg);
          parame.setOnTouchListener(paramwlz);
          parame.setOnLongClickListener(paramwlz);
          this.a = new aisg();
          this.a.b(paramView);
          this.a.clickable = this.clickable;
          parame.setOnClickListener(this.a);
          if (AppSetting.enableTalkBack) {
            parame.setContentDescription(paramChatMessage.msg);
          }
          return parame;
          i = 2130838177;
          continue;
          i = 2130838178;
        }
      }
      if (!auvj.isNightMode()) {
        if (paramView.isSend()) {
          i = 2130838181;
        }
      }
      for (;;)
      {
        j = Color.parseColor("#6603081A");
        break;
        i = 2130838180;
        continue;
        i = 2130838179;
      }
    }
    catch (Throwable localThrowable)
    {
      break label81;
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xjd.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365686)
    {
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    }
    if (paramInt == 2131372073)
    {
      super.m(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(bTv, bTs, bTu, bTt);
      return;
    }
    paramView.setPadding(bTu, bTs, bTv, bTt);
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    xjd.a locala = (xjd.a)parame;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    locala.mTextView.setTextSize(0, this.sessionInfo.cN);
    if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()))
    {
      parame = paramView.getResources();
      paramView = (MessageForLocationShare)paramChatMessage;
    }
    try
    {
      a(paramView);
      label62:
      if (paramView.isSharingLocation)
      {
        if (paramChatMessage.isSend()) {}
        for (parame = parame.getColorStateList(2131167326);; parame = parame.getColorStateList(2131167322))
        {
          locala.mTextView.setTextColor(parame);
          return;
        }
      }
      if ((paramChatMessage.isSend()) || (auvj.isNightMode())) {}
      for (parame = parame.getColorStateList(2131167327);; parame = parame.getColorStateList(2131167323))
      {
        locala.mTextView.setTextColor(parame);
        return;
      }
      if (paramadxp.mTextColor == 0) {
        locala.mTextView.setTextColor(-16777216);
      }
      while (paramadxp.mLinkColor == 0)
      {
        locala.mTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167324));
        return;
        locala.mTextView.setTextColor(paramadxp.mTextColor);
      }
      locala.mTextView.setLinkTextColor(paramadxp.mLinkColor);
      return;
    }
    catch (Throwable paramadxp)
    {
      break label62;
    }
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    wja.a(paramView);
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    super.c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      return paramChatMessage.msg;
    }
    return null;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.clickable = paramBoolean;
    this.a.clickable = paramBoolean;
  }
  
  class a
    extends BaseBubbleBuilder.e
  {
    TextView mTextView;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjd
 * JD-Core Version:    0.7.0.1
 */