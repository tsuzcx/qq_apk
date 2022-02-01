import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xjk
  extends xov
  implements BaseBubbleBuilder.d
{
  public xjk(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    if (paramChatMessage == null) {
      return null;
    }
    MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
    if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("0")) || (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("1")))
    {
      if ((paramView != null) && ((paramView instanceof TextView))) {
        return super.a(paramChatMessage, parame, paramView, paramBaseChatItemLayout, paramwlz);
      }
      return super.a(paramChatMessage, parame, null, paramBaseChatItemLayout, paramwlz);
    }
    Object localObject1 = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (xov.a)parame;
    if (paramView != null)
    {
      parame = paramView;
      if (!(paramView instanceof TextView)) {}
    }
    else
    {
      paramView = this.mContext.getResources();
      parame = new RelativeLayout((Context)localObject1);
      parame.setPadding(paramView.getDimensionPixelSize(2131296404), paramView.getDimensionPixelSize(2131296406), paramView.getDimensionPixelSize(2131296403), paramView.getDimensionPixelSize(2131296405));
      localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.bNS, -2);
      int i = paramView.getDimensionPixelSize(2131299515);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(i, 0, i, 0);
      parame.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      i = wja.dp2px(6.0F, ((Context)localObject1).getResources());
      int j = wja.dp2px(7.0F, ((Context)localObject1).getResources());
      int k = wja.dp2px(13.0F, ((Context)localObject1).getResources());
      int m = wja.dp2px(15.0F, ((Context)localObject1).getResources());
      paramView = new LinearLayout((Context)localObject1);
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(BaseChatItemLayout.bNT, -2));
      paramView.setId(2131364504);
      paramView.setOrientation(1);
      paramView.setBackgroundResource(2130851460);
      paramView.setPadding(k, m, k, m);
      localObject2 = new ETTextView((Context)localObject1);
      aofy.P((TextView)localObject2);
      ((ETTextView)localObject2).setTextSize(2, 15.0F);
      ((ETTextView)localObject2).setId(2131364506);
      ((ETTextView)localObject2).setTextColor(-16777216);
      ((ETTextView)localObject2).setPadding(0, 0, 0, i);
      paramBaseChatItemLayout.mText = ((TextView)localObject2);
      paramView.addView((View)localObject2);
      localObject2 = new View((Context)localObject1);
      ((View)localObject2).setBackgroundColor(((Context)localObject1).getResources().getColor(2131166634));
      paramView.addView((View)localObject2, BaseChatItemLayout.bNT, 2);
      localObject1 = new ETTextView((Context)localObject1);
      ((ETTextView)localObject1).setTextSize(2, 15.0F);
      ((ETTextView)localObject1).setId(2131364505);
      ((ETTextView)localObject1).setPadding(0, j, 0, 0);
      ((ETTextView)localObject1).setTextColor(-7829368);
      paramView.addView((View)localObject1);
      parame.addView(paramView);
    }
    paramView = (TextView)parame.findViewById(2131364506);
    Object localObject2 = parame.findViewById(2131364504);
    localObject1 = (TextView)parame.findViewById(2131364505);
    paramView.setMaxLines(4);
    if (!TextUtils.isEmpty(localMessageForLongTextMsg.sb)) {
      if (!TextUtils.isEmpty(localMessageForLongTextMsg.sb2))
      {
        paramBaseChatItemLayout.mText.setText(localMessageForLongTextMsg.sb2);
        ((View)localObject2).setOnTouchListener(paramwlz);
        ((View)localObject2).setOnLongClickListener(paramwlz);
        if ((!localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3")) || (!localMessageForLongTextMsg.loading)) {
          break label621;
        }
        ((TextView)localObject1).setText(acfp.m(2131707970));
        ((View)localObject2).setTag(null);
        parame.setClickable(false);
        ((View)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      paramChatMessage = lf.a(paramChatMessage);
      paramView.setTypeface(paramChatMessage);
      ((TextView)localObject1).setTypeface(paramChatMessage);
      return parame;
      paramBaseChatItemLayout.mText.setText(localMessageForLongTextMsg.sb);
      break;
      paramView.setText(localMessageForLongTextMsg.msg);
      break;
      label621:
      if (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3"))
      {
        ((TextView)localObject1).setText(acfp.m(2131707971));
        ((TextView)localObject1).setClickable(false);
        ((View)localObject2).setTag(localMessageForLongTextMsg);
        ((View)localObject2).setOnClickListener(this);
        ((View)localObject2).setClickable(false);
        ((View)localObject2).setVisibility(0);
      }
    }
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    if (L(paramView)) {
      return this;
    }
    return null;
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
    if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {
      return;
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(bTv, bTs, bTu, bTt);
      return;
    }
    paramView.setPadding(bTu, bTs, bTv, bTt);
  }
  
  public aqob[] a(View paramView)
  {
    ChatMessage localChatMessage = wja.a(paramView);
    if (((localChatMessage instanceof MessageForLongTextMsg)) && ((localChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("3"))))
    {
      paramView = new aqoa();
      if (localChatMessage.istroop == 1) {}
      a(localChatMessage, paramView);
      ujt.a(paramView, this.mContext, this.sessionInfo.cZ);
      b(localChatMessage, paramView);
      super.c(paramView, this.mContext);
      super.e(paramView, this.mContext);
      return paramView.a();
    }
    return super.a(paramView);
  }
  
  public void e(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364504) {
      if (paramView.getTag() != null) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramView.getTag();
      Context localContext = paramView.getContext();
      Object localObject = (FragmentActivity)localContext;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        int i = ((FragmentActivity)localObject).getChatFragment().a().getCurType();
        String str1 = ((FragmentActivity)localObject).getChatFragment().a().oL();
        String str2 = ((FragmentActivity)localObject).getChatFragment().a().oN();
        localObject = new Intent(localContext, MultiForwardActivity.class);
        ((Intent)localObject).putExtra("chat_subType", 3);
        ((Intent)localObject).putExtra("uin", str1);
        ((Intent)localObject).putExtra("uintype", i);
        ((Intent)localObject).putExtra("troop_code", str2);
        str1 = localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_msg_resid");
        if (TextUtils.isEmpty(str1)) {
          QLog.e("ChatItemBuilder", 1, "LongTextMsg resid is null!");
        }
        ((Intent)localObject).putExtra("multi_url", str1);
        ((Intent)localObject).putExtra("multi_uniseq", localMessageForLongTextMsg.uniseq);
        ((Intent)localObject).putExtra("callback_type", 2);
        localContext.startActivity((Intent)localObject);
      }
      super.onClick(paramView);
    }
  }
  
  public void v(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramView = null;; paramView = d)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjk
 * JD-Core Version:    0.7.0.1
 */