import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.qphone.base.util.QLog;

public class xra
  extends BaseBubbleBuilder
{
  private static int bWx;
  private static int bWy;
  private static int bWz;
  private int bUJ;
  private int bUO;
  private int bUP;
  private int bUZ;
  private int bVa;
  private int bVb;
  private int bWb;
  private Context mContext;
  private View.OnClickListener onClickListener = new xrb(this);
  
  public xra(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.mContext = paramContext;
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.bUO = ((int)(1.0F * f + 0.5F));
    this.bWb = ((int)(6.0F * f + 0.5F));
    this.bUP = ((int)(7.0F * f + 0.5F));
    this.bVb = ((int)(15.0F * f + 0.5F));
    this.bVa = ((int)(21.0F * f + 0.5F));
    this.bUJ = ((int)(42.0F * f + 0.5F));
    this.bUZ = ((int)(f * 230.0F + 0.5F));
    bWx = this.bUO * 2;
    bWy = this.bUO * 2;
    bWz = this.bUP;
  }
  
  private RelativeLayout b(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.bUZ, this.bVb * 5));
    localQQWalletTransferBubbleView.setId(2131382018);
    Object localObject1 = new ImageView(paramContext);
    Object localObject2 = new RelativeLayout.LayoutParams(this.bUJ, this.bUJ);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject1).setId(2131382014);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localObject1 = new LinearLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131382014);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.bWb;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).setOrientation(1);
    localObject2 = new TextView(paramContext);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(20.0F);
    ((TextView)localObject2).setId(2131382017);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.bUO;
    ((TextView)localObject2).setLayoutParams(localLayoutParams);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(14.0F);
    ((TextView)localObject2).setId(2131382016);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(this.bUZ, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131382018);
    localQQWalletTransferBubbleView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localQQWalletTransferBubbleView.setBackgroundResource(2130848115);
    localQQWalletTransferBubbleView.setId(2131382013);
    paramContext = new TextView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.bVb;
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.bVb;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131382015);
    localQQWalletTransferBubbleView.addView(paramContext);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    return localRelativeLayout;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    boolean bool2 = true;
    paramView = (xra.a)parame;
    if (paramView.layout == null) {
      paramView.layout = b(this.mContext);
    }
    if ((paramChatMessage instanceof MessageForVIPDonate)) {}
    for (parame = (MessageForVIPDonate)paramChatMessage;; parame = null)
    {
      if (parame == null)
      {
        QLog.e("VIPDonateMsgItemBuilder", 1, "vipdonate msg empty");
        return null;
      }
      parame.parse();
      parame = parame.donateMsg;
      if (parame == null)
      {
        QLog.e("VIPDonateMsgItemBuilder", 1, "donateMsg empty");
        return null;
      }
      paramBaseChatItemLayout = (TextView)paramView.layout.findViewById(2131382017);
      paramBaseChatItemLayout.setText(parame.title);
      paramBaseChatItemLayout.setTextColor(-1);
      paramBaseChatItemLayout = (TextView)paramView.layout.findViewById(2131382016);
      paramBaseChatItemLayout.setText(parame.subTitle);
      paramBaseChatItemLayout.setTextColor(-1);
      ((TextView)paramView.layout.findViewById(2131382015)).setText(parame.footer);
      ((ImageView)paramView.layout.findViewById(2131382014)).setImageResource(2130851914);
      paramBaseChatItemLayout = (QQWalletTransferBubbleView)paramView.layout.findViewById(2131382013);
      QQWalletTransferBubbleView localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)paramView.layout.findViewById(2131382018);
      int i = Color.rgb(255, 170, 57);
      if (!paramChatMessage.isSend())
      {
        bool1 = true;
        localQQWalletTransferBubbleView.setBubbleBackground(2130848114, i, bool1);
        i = Color.rgb(255, 255, 255);
        if (paramChatMessage.isSend()) {
          break label346;
        }
      }
      label346:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramBaseChatItemLayout.setBubbleBackground(2130848115, i, bool1);
        if (aTl) {
          paramView.layout.setContentDescription(parame.subTitle + parame.title);
        }
        paramView.layout.setOnClickListener(this.onClickListener);
        paramView.layout.setOnLongClickListener(paramwlz);
        paramView.layout.setOnTouchListener(paramwlz);
        return paramView.layout;
        bool1 = false;
        break;
      }
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xra.a(null);
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
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(bWy, bWz, bWx, 0);
      return;
    }
    paramView.setPadding(bWx, bWz, bWy, 0);
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
  
  public String b(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  class a
    extends BaseBubbleBuilder.e
  {
    public RelativeLayout layout;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xra
 * JD-Core Version:    0.7.0.1
 */