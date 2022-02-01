import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class xje
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.d
{
  private static final int bTs = BaseChatItemLayout.bNV + BaseChatItemLayout.bOa;
  private static final int bTt = BaseChatItemLayout.bNW + BaseChatItemLayout.bOb;
  private static final int bTu = BaseChatItemLayout.bNX + BaseChatItemLayout.bOc;
  private static final int bTv = BaseChatItemLayout.bNY + BaseChatItemLayout.bOd;
  AnimationTextView.a a = new xji(this);
  protected View.OnClickListener onClickListener = new xjj(this);
  
  public xje(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public int a(MessageForLongMsg paramMessageForLongMsg)
  {
    if ((paramMessageForLongMsg != null) && (paramMessageForLongMsg.mSourceMsgInfo != null)) {
      return 2;
    }
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    xje.a locala = (xje.a)parame;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131167322));
        paramView.setMaxWidth(BaseChatItemLayout.bNS);
        paramView.setSpannableFactory(aofk.a);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364506);
        locala.mText = paramView;
        locala.a = new aavr();
        locala.a.a(paramView);
        locala.a.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (locala.jdField_do == null)) {
        paramView = a(localContext, locala, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (locala.mText != null) {
          locala.mText.setTextSize(0, this.sessionInfo.cN);
        }
        if (i == 2)
        {
          locala.jdField_do.setVisibility(0);
          xmb.a(this.mContext, this.app, locala.jdField_do, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.sessionInfo);
          locala.jdField_do.setOnClickListener(this.onClickListener);
          locala.jdField_do.setOnTouchListener(paramwlz);
          locala.jdField_do.setOnLongClickListener(paramwlz);
          label261:
          paramView.setOnTouchListener(paramwlz);
          paramView.setOnLongClickListener(paramwlz);
          if (locala.mText != null)
          {
            locala.mText.setOnTouchListener(paramwlz);
            locala.mText.setOnLongClickListener(paramwlz);
            if (!TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label575;
            }
            locala.mText.setText(localMessageForLongMsg.sb);
          }
        }
        for (;;)
        {
          if ((locala.mText instanceof AnimationTextView))
          {
            paramBaseChatItemLayout = (AnimationTextView)locala.mText;
            ApolloUtil.a(this.app, this.sessionInfo, paramChatMessage, paramBaseChatItemLayout, parame.pos, parame.count, true);
            paramBaseChatItemLayout.onDoubleClick = this.a;
            paramBaseChatItemLayout.onSingleClick = new xjf(this, paramChatMessage.isSend());
            paramBaseChatItemLayout.setStrokeColor(false, 0);
          }
          if ((locala.d instanceof AnimationTextView)) {
            locala.d.onDoubleClick = this.a;
          }
          if ((locala.e instanceof AnimationTextView)) {
            locala.e.onDoubleClick = this.a;
          }
          parame = lf.a(paramChatMessage);
          if (locala.mText != null) {
            locala.mText.setTypeface(parame);
          }
          if (locala.d != null) {
            locala.d.setTypeface(parame);
          }
          if (locala.e != null) {
            locala.e.setTypeface(parame);
          }
          if (locala.Jm != null) {
            locala.Jm.setTypeface(parame);
          }
          if (locala.a != null) {
            locala.a.P(paramChatMessage);
          }
          return paramView;
          paramView = a(localContext, locala, paramBaseChatItemLayout);
          break;
          if (locala.jdField_do == null) {
            break label261;
          }
          locala.jdField_do.setVisibility(8);
          break label261;
          label575:
          locala.mText.setText(localMessageForLongMsg.sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, xje.a parama, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = xmb.a(paramContext);
    localLinearLayout.addView((View)localObject);
    parama.jdField_do = ((ViewGroup)localObject);
    parama.Jm = ((TextView)((ViewGroup)localObject).findViewById(2131372190));
    parama.d = ((ETTextView)((ViewGroup)localObject).findViewById(2131371989));
    parama.e = ((ETTextView)((ViewGroup)localObject).findViewById(2131372006));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167322));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.bNS);
    ((AnimationTextView)localObject).setSpannableFactory(aofk.a);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364506);
    localLinearLayout.addView((View)localObject);
    parama.mText = ((TextView)localObject);
    int i = BaseChatItemLayout.bOc;
    int j = BaseChatItemLayout.bOd;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.bOa, j, BaseChatItemLayout.bOb);
    parama.a = new aavr();
    parama.a.a((aawc)localObject);
    parama.a.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    paramView = wja.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xje.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    String str1;
    if (this.app != null)
    {
      String str2 = this.app.getCurrentAccountUin();
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "";
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131365686: 
    case 2131372073: 
    case 2131365509: 
    case 2131377193: 
      do
      {
        return;
        str1 = "";
        break;
        ujt.b(this.mContext, this.app, paramChatMessage);
        return;
        super.m(paramChatMessage);
        return;
        if (aavp.a().isSelected())
        {
          paramContext = aavp.a().qL();
          if (paramContext != null) {
            if (paramContext.length() == aavp.a().length()) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          ((ClipboardManager)this.mContext.getSystemService("clipboard")).setText(paramContext);
          if (paramInt == 0) {
            break;
          }
          anot.a(this.app, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
          paramInt = 1;
        }
        anot.a(this.app, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
        return;
      } while (this.app == null);
      ujt.a(this.app, this.mContext, this.sessionInfo, (MessageForLongMsg)paramChatMessage);
      return;
    case 2131367523: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putInt("selection_mode", this.bOY);
      paramContext.putInt("forward_source_uin_type", this.sessionInfo.cZ);
      if (aavp.a().isSelected())
      {
        paramChatMessage = aavp.a().qL();
        paramContext.putString("forward_text", paramChatMessage);
        if (paramChatMessage != null) {
          if (paramChatMessage.length() == aavp.a().length()) {
            paramInt = 1;
          }
        }
      }
      for (;;)
      {
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        ahgq.f((Activity)this.mContext, paramChatMessage, 21);
        anot.a(this.app, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (paramInt == 0) {
          break;
        }
        anot.a(this.app, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
        return;
        paramInt = 0;
        continue;
        paramInt = 0;
        continue;
        paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
        paramInt = 1;
      }
      anot.a(this.app, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      return;
    case 2131366733: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131372030: 
      super.j(paramChatMessage);
      return;
    }
    aavp.a().O(paramChatMessage);
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
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if (paramInt == 1)
    {
      BaseBubbleBuilder.e locale = (BaseBubbleBuilder.e)paramView.getTag();
      if (locale != null) {
        a(locale, paramView, paramChatMessage, locale.b);
      }
    }
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    xje.a locala = (xje.a)parame;
    if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        parame = paramView.getColorStateList(2131167326);
        if (parame != null)
        {
          locala.mText.setTextColor(parame);
          if (locala.jdField_do != null)
          {
            locala.Jm.setTextColor(parame);
            locala.d.setTextColor(parame);
            locala.e.setTextColor(parame);
          }
        }
        if (aine.f(this.sessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label239;
          }
          i = -1;
          label110:
          locala.mText.setTextColor(i);
          if (locala.jdField_do != null)
          {
            locala.Jm.setTextColor(i);
            locala.d.setTextColor(i);
            locala.e.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label247;
        }
      }
      label239:
      label247:
      for (parame = paramView.getColorStateList(2131167325);; parame = paramView.getColorStateList(2131167324))
      {
        locala.mText.setLinkTextColor(parame);
        if (locala.jdField_do != null)
        {
          locala.d.setLinkTextColor(parame);
          locala.e.setLinkTextColor(parame);
          locala.mText.setLinkTextColor(parame);
          ImmersiveUtils.setAlpha(locala.Jm, 0.5F);
        }
        return;
        parame = paramView.getColorStateList(2131167322);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramadxp.mTextColor == 0)
    {
      locala.mText.setTextColor(-16777216);
      if (locala.jdField_do != null)
      {
        locala.Jm.setTextColor(-16777216);
        locala.d.setTextColor(-16777216);
        locala.e.setTextColor(-16777216);
      }
      if (paramadxp.mLinkColor != 0) {
        break label520;
      }
      parame = paramView.getResources().getColorStateList(2131167324);
      locala.mText.setLinkTextColor(parame);
      if (locala.jdField_do != null)
      {
        locala.d.setLinkTextColor(parame);
        locala.e.setLinkTextColor(parame);
      }
      label372:
      if ((locala.mText instanceof AnimationTextView))
      {
        if (!paramadxp.hasStroke) {
          break label570;
        }
        ((AnimationTextView)locala.mText).setStrokeColor(true, paramadxp.mStrokeColor);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramadxp.mStrokeColor);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.setAlpha(locala.Jm, 0.5F);
      return;
      locala.mText.setTextColor(paramadxp.mTextColor);
      if (locala.jdField_do == null) {
        break;
      }
      locala.Jm.setTextColor(paramadxp.mTextColor);
      locala.d.setTextColor(paramadxp.mTextColor);
      locala.e.setTextColor(paramadxp.mTextColor);
      break;
      label520:
      locala.mText.setLinkTextColor(paramadxp.mLinkColor);
      if (locala.jdField_do == null) {
        break label372;
      }
      locala.d.setLinkTextColor(paramadxp.mLinkColor);
      locala.e.setLinkTextColor(paramadxp.mLinkColor);
      break label372;
      label570:
      if ((paramadxp.bRF) && (((ChatBackgroundManager)this.app.getManager(63)).a(this.mContext, this.sessionInfo, locala.mText.getCurrentTextColor(), 10000.0D * locala.b.cs) == 1))
      {
        parame = (AnimationTextView)locala.mText;
        float f2 = parame.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        parame.setTextColor(-1);
        parame.setShadowLayer(f1, 0.0F, 0.0F, paramadxp.mStrokeColor);
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    String str;
    int i;
    if (this.app != null)
    {
      if (!aavp.a().isSelected()) {
        break label115;
      }
      str = aavp.a().qL();
      if (str == null) {
        break label110;
      }
      if (str.length() != aavp.a().length()) {
        break label105;
      }
      i = 1;
      if ((i == 0) && (str != null)) {
        break label122;
      }
      aviz.b(paramMessageForLongMsg).b(this.app, paramMessageForLongMsg).b((Activity)this.mContext, this.app.getAccount());
      avjg.a(this.app, 4, 0, paramMessageForLongMsg.istroop);
    }
    for (;;)
    {
      avjg.a(this.app, 6, 8);
      return;
      label105:
      i = 0;
      break;
      label110:
      i = 0;
      break;
      label115:
      i = 1;
      str = null;
      break;
      label122:
      aviz.a(null, str).b(this.app, paramMessageForLongMsg).b((Activity)this.mContext, this.app.getAccount());
      avjg.a(this.app, 1, 0, paramMessageForLongMsg.istroop);
    }
  }
  
  public aqob[] a(View paramView)
  {
    paramView = (MessageForLongMsg)wja.a(paramView);
    aqoa localaqoa = new aqoa();
    if (ApolloUtil.V(paramView)) {
      return localaqoa.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localaqoa.Z(2131365509, this.mContext.getString(2131718653), 2130839077);
      localaqoa.Z(2131377193, this.mContext.getString(2131718661), 2130839091);
    }
    for (;;)
    {
      localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
      a(paramView, localaqoa);
      if ((paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
        localaqoa.Z(2131361826, this.mContext.getString(2131717241), 2130839064);
      }
      if ((paramView.extraflag != 32768) && (!this.app.a().aR(paramView))) {
        a(localaqoa, this.sessionInfo.cZ, paramView);
      }
      a(localaqoa, paramView);
      if (wja.eU(5) == 1) {
        localaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
      }
      super.a(localaqoa, this.mContext, paramView);
      b(paramView, localaqoa);
      super.c(localaqoa, this.mContext);
      super.e(localaqoa, this.mContext);
      return localaqoa.a();
      localaqoa.Z(2131365509, acfp.m(2131707968), 2130839077);
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131707969) + aofy.og(paramChatMessage.msg);
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
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    if (wja.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)wja.a(paramView);
      str1 = this.mContext.getString(2131690230);
      str2 = this.mContext.getString(2131690231);
    } while (!paramView.isSendFromLocal());
    aqha.a(this.mContext, 230, str1, str2, new xjg(this, paramView), new xjh(this)).show();
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
  
  public class a
    extends BaseBubbleBuilder.e
  {
    protected TextView Jm;
    public aavr a;
    protected ETTextView d;
    protected ViewGroup jdField_do;
    public ETTextView e;
    TextView mText;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xje
 * JD-Core Version:    0.7.0.1
 */