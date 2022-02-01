import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.AnimationTextView;

public class xbf
  extends xov
{
  public xbf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (xov.a)parame;
    parame = paramView;
    if (paramView == null)
    {
      parame = new ETTextView((Context)localObject);
      parame.setTextColor(((Context)localObject).getResources().getColorStateList(2131167322));
      parame.setLinkTextColor(((Context)localObject).getResources().getColorStateList(2131167316));
      parame.setSpannableFactory(aofk.a);
      parame.setMaxWidth(BaseChatItemLayout.bNS);
      parame.setMovementMethod(LinkMovementMethod.getInstance());
      parame.setId(2131364506);
      paramBaseChatItemLayout.mText = parame;
    }
    ((ETTextView)paramBaseChatItemLayout.mText).setFont(0, paramChatMessage.uniseq);
    if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      paramView = ((ETTextView)paramBaseChatItemLayout.mText).getETLayout();
      if (paramView != null) {
        paramView.mMsgId = (paramChatMessage.uniseq + 1L);
      }
    }
    paramBaseChatItemLayout.mText.setTextSize(0, this.sessionInfo.cN);
    int j = BaseChatItemLayout.bOc;
    int i = BaseChatItemLayout.bOd;
    if (paramChatMessage.isSend())
    {
      j = BaseChatItemLayout.bOd;
      i = BaseChatItemLayout.bOc;
    }
    paramBaseChatItemLayout.mText.setPadding(j, BaseChatItemLayout.bOa, i, BaseChatItemLayout.bOb);
    if ((paramChatMessage instanceof MessageForDeviceText))
    {
      paramView = (MessageForDeviceText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008) {
        if (paramChatMessage.isSend()) {
          paramBaseChatItemLayout.mText.setText(((Context)localObject).getString(2131719356));
        }
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.mText.setOnTouchListener(paramwlz);
      paramBaseChatItemLayout.mText.setOnLongClickListener(paramwlz);
      if ((paramBaseChatItemLayout.mText instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.mText).onDoubleClick = new xbk(this);
      }
      return parame;
      paramBaseChatItemLayout.mText.setText(((Context)localObject).getString(2131719355));
      continue;
      if ("device_lock_msg".equals(paramView.extStr))
      {
        localObject = paramView.msg;
        paramChatMessage = new TextPaint();
        paramChatMessage.setColor(-14782465);
        paramChatMessage.setUnderlineText(true);
        paramView = new SpannableString((CharSequence)localObject);
        i = ((String)localObject).indexOf("点这里开启QQ设备锁");
        j = "点这里开启QQ设备锁".length();
        int k = ((String)localObject).indexOf("QQ设备锁介绍");
        int m = "QQ设备锁介绍".length();
        localObject = new xbi(this);
        xbj localxbj = new xbj(this);
        ((ClickableSpan)localObject).updateDrawState(paramChatMessage);
        localxbj.updateDrawState(paramChatMessage);
        paramView.setSpan(localObject, i, j + i, 33);
        paramView.setSpan(localxbj, k, m + k, 33);
        paramBaseChatItemLayout.mText.setMovementMethod(LinkMovementMethod.getInstance());
        paramBaseChatItemLayout.mText.setText(paramView);
      }
      else
      {
        paramBaseChatItemLayout.mText.setText(paramView.sb);
        continue;
        paramBaseChatItemLayout.mText.setText(paramChatMessage.msg);
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    paramContext = (szy)this.app.getBusinessHandler(49);
    paramChatMessage = (MessageForDeviceText)paramChatMessage;
    paramContext.a(this.app, this.mContext, this.sessionInfo, paramChatMessage);
  }
  
  public aqob[] a(View paramView)
  {
    paramView = wja.a(paramView);
    aqoa localaqoa = new aqoa();
    localaqoa.Z(2131365509, acfp.m(2131705021), 2130839077);
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localaqoa.Z(2131377193, this.mContext.getString(2131718661), 2130839091);
    }
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    if (wja.eU(5) == 1) {
      localaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
    }
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public void ei(View paramView)
  {
    if (wja.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForDeviceText)wja.a(paramView);
      str1 = this.mContext.getString(2131690230);
      str2 = this.mContext.getString(2131690231);
    } while (!paramView.isSendFromLocal());
    aqha.a(this.mContext, 230, str1, str2, new xbg(this, paramView), new xbh(this)).show();
  }
  
  public void ej(View paramView)
  {
    ChatMessage localChatMessage = wja.a(paramView);
    if (localChatMessage == null) {}
    do
    {
      do
      {
        return;
      } while (localChatMessage.istroop != 9501);
      if (localChatMessage.isSendFromLocal())
      {
        super.ej(paramView);
        return;
      }
    } while (!"device_groupchat".equals(localChatMessage.extStr));
    super.ej(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbf
 * JD-Core Version:    0.7.0.1
 */