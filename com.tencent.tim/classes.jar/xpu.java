import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFee;

public class xpu
  extends BaseBubbleBuilder
{
  protected int bUJ;
  protected int bUK;
  protected int bUL;
  protected int bUN;
  protected int bUO;
  protected int bUP;
  protected final int bUT = 2131380269;
  protected final int bUU = 2131380265;
  protected final int bUV = 2131380268;
  protected final int bUW = 2131380267;
  protected final int bUX = 2131380264;
  protected final int bUY = 2131380266;
  protected int bUZ;
  protected int bVa;
  protected int bVb;
  protected int bWb;
  protected int bWc;
  protected int bWd;
  protected int bWe;
  protected int bWf;
  protected int bWg;
  protected int bWh;
  private View.OnClickListener onClickListener = new xpv(this);
  
  public xpu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.bUJ = ((int)(42.0F * f + 0.5F));
    this.bVa = ((int)(21.0F * f + 0.5F));
    this.bVb = ((int)(15.0F * f + 0.5F));
    this.bUK = ((int)(10.0F * f + 0.5F));
    this.bUL = ((int)(9.0F * f + 0.5F));
    this.bWb = ((int)(6.0F * f + 0.5F));
    this.bUN = ((int)(4.0F * f + 0.5F));
    this.bUO = ((int)(1.0F * f + 0.5F));
    this.bUZ = (this.bUK * 23);
    this.bWc = ((int)(157.0F * f + 0.5F));
    this.bWd = ((int)(65.0F * f + 0.5F));
    this.bUP = ((int)(7.0F * f + 0.5F));
    this.bWe = ((int)(152.0F * f + 0.5F));
    this.bWf = ((int)(5.0F * f + 0.5F));
    this.bWg = ((int)(61.0F * f + 0.5F));
    this.bWh = ((int)(f * 19.0F + 0.5F));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    parame = (xpu.a)parame;
    paramBaseChatItemLayout = (MessageForTroopFee)paramChatMessage;
    if ((parame.layout != null) && (parame.uniseq == paramChatMessage.uniseq)) {
      return parame.layout;
    }
    QQWalletTransferBubbleView localQQWalletTransferBubbleView;
    float f;
    label210:
    int i;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      parame.layout = ((RelativeLayout)paramView);
      parame.friendUin = paramChatMessage.frienduin;
      parame.uniseq = paramChatMessage.uniseq;
      paramView = (TextView)parame.layout.findViewById(2131380268);
      TextView localTextView1 = (TextView)parame.layout.findViewById(2131380267);
      ImageView localImageView = (ImageView)parame.layout.findViewById(2131380265);
      TextView localTextView2 = (TextView)parame.layout.findViewById(2131380266);
      localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)parame.layout.findViewById(2131380269);
      if (paramBaseChatItemLayout.title != null)
      {
        paramView.setTextSize(24.0F);
        TextPaint localTextPaint = paramView.getPaint();
        if (localTextPaint != null)
        {
          f = localTextPaint.measureText(paramBaseChatItemLayout.title);
          if (this.bUZ <= BaseChatItemLayout.bNS) {
            break label378;
          }
          if (f > BaseChatItemLayout.bNS - this.bUK * 9) {
            paramView.setTextSize(14.0F);
          }
        }
      }
      paramView.setText(paramBaseChatItemLayout.title);
      paramView.setTextColor(-1);
      localTextView1.setText(paramBaseChatItemLayout.summary);
      localTextView1.setTextColor(-1);
      localTextView2.setText(paramBaseChatItemLayout.source);
      localImageView.setImageResource(2130848116);
      i = Color.parseColor(paramBaseChatItemLayout.backgroundColor);
      if (paramChatMessage.isSend()) {
        break label401;
      }
    }
    label401:
    for (boolean bool = true;; bool = false)
    {
      localQQWalletTransferBubbleView.setBubbleBackground(2130848114, i, bool);
      parame.layout.setContentDescription(paramBaseChatItemLayout.title + paramBaseChatItemLayout.summary + paramBaseChatItemLayout.source);
      parame.layout.setOnClickListener(this.onClickListener);
      parame.layout.setOnLongClickListener(paramwlz);
      parame.layout.setOnTouchListener(paramwlz);
      return parame.layout;
      parame.layout = b(this.mContext);
      break;
      label378:
      if (f <= this.bUK * 14) {
        break label210;
      }
      paramView.setTextSize(14.0F);
      break label210;
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xpu.a(null);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365686: 
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    }
    super.m(paramChatMessage);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = wja.a(paramView);
    a(paramView, localaqoa);
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    b(paramView, localaqoa);
    super.c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  protected RelativeLayout b(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    Object localObject1 = new QQWalletTransferBubbleView(paramContext);
    ((QQWalletTransferBubbleView)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.bUZ, this.bVb * 5));
    ((QQWalletTransferBubbleView)localObject1).setId(2131380269);
    Object localObject2 = new ImageView(paramContext);
    Object localObject3 = new RelativeLayout.LayoutParams(this.bUJ, this.bUJ);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject2).setId(2131380265);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131380265);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.bWb;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(24.0F);
    ((TextView)localObject3).setId(2131380268);
    ((LinearLayout)localObject2).addView((View)localObject3);
    localObject3 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.bUO;
    ((TextView)localObject3).setLayoutParams(localLayoutParams);
    ((TextView)localObject3).setSingleLine();
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setTextSize(13.0F);
    ((TextView)localObject3).setId(2131380267);
    ((LinearLayout)localObject2).addView((View)localObject3);
    ((QQWalletTransferBubbleView)localObject1).addView((View)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localObject1 = new RelativeLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(this.bUZ, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131380269);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setBackgroundResource(2130848115);
    ((RelativeLayout)localObject1).setId(2131380264);
    paramContext = new TextView(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = this.bVb;
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.bVb;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131380266);
    ((RelativeLayout)localObject1).addView(paramContext);
    localRelativeLayout.addView((View)localObject1);
    return localRelativeLayout;
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFee)paramChatMessage;
    return paramChatMessage.title + paramChatMessage.summary + paramChatMessage.source;
  }
  
  class a
    extends BaseBubbleBuilder.e
  {
    public String friendUin;
    public RelativeLayout layout;
    public long uniseq;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpu
 * JD-Core Version:    0.7.0.1
 */