import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.rookery.translate.AITranslator;
import com.rookery.translate.type.Language;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.RotateableView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class xpc
  extends xov
{
  private static int bVN;
  private static int bVO;
  static int bVP;
  private long Jj = -1L;
  ifr a;
  private boolean bic = true;
  HashMap<Long, Long> gP = new HashMap();
  AlphaAnimation l = new AlphaAnimation(0.0F, 1.0F);
  AlphaAnimation m = new AlphaAnimation(1.0F, 0.0F);
  
  public xpc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.l.setDuration(300L);
    this.l.setFillAfter(true);
    this.m.setDuration(150L);
    this.m.setFillAfter(true);
  }
  
  public static int a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    String str;
    if (paramInt == 0) {
      str = "0";
    }
    for (;;)
    {
      if (bVN != 0) {
        anpc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, bVN, 0, "", str, "", "");
      }
      if (bVO != 0) {
        anpc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, bVO, 0, "", str, "", "");
      }
      if (bVP != 0) {
        anpc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, bVP, 0, "", str, "", "");
      }
      bVN = 0;
      bVO = 0;
      bVP = 0;
      return 0;
      if (paramInt == 1) {
        str = "1";
      } else if (paramInt == 3000) {
        str = "2";
      } else {
        str = "";
      }
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, xpc.a parama)
  {
    parama.wR = parama.mContentLayout.findViewById(2131380151);
    parama.a = ((RotateableView)parama.mContentLayout.findViewById(2131380150));
    parama.a.setBackgroundResource(2130847895);
  }
  
  private void a(xpc.a parama)
  {
    parama.wR.setVisibility(0);
    parama.a.eiM();
    parama.mContentLayout.setPadding(parama.mContentLayout.getPaddingLeft(), parama.mContentLayout.getPaddingTop() - 2, b(1.5D), b(4.0D));
  }
  
  private void a(xpc.a parama, MessageForText paramMessageForText)
  {
    parama.bVQ = ((int)paramMessageForText.vipBubbleID);
    parama.uniseq = paramMessageForText.uniseq;
    parama.istroop = paramMessageForText.istroop;
    parama.msg = paramMessageForText.msg;
    parama.aVP = paramMessageForText.msg;
  }
  
  @SuppressLint({"NewApi"})
  private void a(xpc.a parama, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int j = 1;
    String str = paramMessageForText.msg;
    if (parama == null) {
      return;
    }
    if (parama.mContentLayout != null)
    {
      localObject = (RelativeLayout.LayoutParams)parama.mContentLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      parama.mContentLayout.clearAnimation();
      parama.mContentLayout.setAnimation(null);
    }
    if (parama.mText != null)
    {
      parama.mText.clearAnimation();
      parama.mText.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        parama.mText.setAlpha(1.0F);
      }
    }
    Object localObject = ifw.Q(this.mContext.getApplicationContext());
    if (!ifs.a(this.mContext.getApplicationContext()).a((String)localObject, parama.aVP, parama.uniseq))
    {
      b(parama);
      this.a = null;
      if (parama.bVQ == 100000)
      {
        ifo localifo = ifs.a(this.mContext.getApplicationContext());
        if (localifo != null) {
          this.a = localifo.a(str, parama.uniseq, (String)localObject);
        }
        if ((this.a == null) || (!this.a.e().booleanValue()) || (paramMessageForText.isSend())) {
          break label463;
        }
        parama.b = adyd.a(100001, this.app, this.mContext.getResources(), this.adapter);
      }
      label243:
      this.bic = aqmj.ao(this.mContext, this.app.getCurrentAccountUin());
      if ((this.bic) && (!paramMessageForText.isSend()) && (parama.bVQ == 100000) && (paramMessageForText.msgtype == -1000))
      {
        paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.sessionInfo.a.k, null);
        if (!paramMessageForText.isSend()) {
          break label496;
        }
      }
    }
    label463:
    label496:
    for (int i = 1;; i = 0)
    {
      paramBaseChatItemLayout.setHearIconPosition(i);
      paramBaseChatItemLayout.nf.setText(2131721273);
      aqmj.cr(this.mContext, this.app.getCurrentAccountUin());
      this.Jj = parama.uniseq;
      anpc.a(BaseApplication.getContext()).a(this.app, this.app.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.Jj < 0L) || (this.Jj != parama.uniseq)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.sessionInfo.a.k, null);
      if (paramMessageForText.isSend()) {}
      for (i = j;; i = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(i);
        paramBaseChatItemLayout.nf.setText(2131721273);
        return;
        a(parama);
        break;
        parama.b = adyd.a(100000, this.app, this.mContext.getResources(), this.adapter);
        break label243;
      }
    }
  }
  
  private int b(double paramDouble)
  {
    return (int)(this.mContext.getResources().getDisplayMetrics().density * paramDouble);
  }
  
  private void b(xpc.a parama)
  {
    parama.wR.setVisibility(8);
    parama.a.eiN();
    parama.mContentLayout.setPadding(parama.mContentLayout.getPaddingLeft(), parama.mContentLayout.getPaddingTop() - 2, b(14.0D), b(5.0D));
  }
  
  private void b(xpc.a parama, MessageForText paramMessageForText)
  {
    int i = 0;
    parama.msg = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (parama.bVQ == 100000)
    {
      parama.aVP = paramMessageForText.msg;
      localObject1 = ifw.Q(this.mContext.getApplicationContext());
      this.a = null;
      ifo localifo = ifs.a(this.mContext.getApplicationContext());
      if (localifo != null) {
        this.a = localifo.a(paramMessageForText.msg, parama.uniseq, (String)localObject1);
      }
      localObject1 = localObject2;
      if (this.a != null)
      {
        localObject1 = localObject2;
        if (this.a.e().booleanValue())
        {
          localObject1 = localObject2;
          if (!paramMessageForText.isSend())
          {
            parama.msg = this.a.gt();
            localObject1 = new aofk(parama.msg, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (parama.bVQ == 100000)
    {
      localObject2 = parama.msg;
      if (parama.bVR == 0) {
        parama.mText.setText((CharSequence)localObject1);
      }
      while ((paramMessageForText.isSend()) || (this.a == null) || (parama.bVR != 1)) {
        return;
      }
      paramMessageForText = parama.mText.getText();
      int k = parama.mText.getMeasuredWidth();
      int j = parama.mText.getMeasuredHeight();
      parama.mText.setText((CharSequence)localObject1);
      parama.mText.measure(0, 0);
      if (parama.mText.getMeasuredWidth() < BaseChatItemLayout.bNS) {
        i = parama.mText.getMeasuredWidth() - k;
      }
      k = parama.mText.getMeasuredHeight();
      parama.mText.setText(paramMessageForText);
      paramMessageForText = new ifx(parama.mContentLayout, 300, i, k - j);
      paramMessageForText.setAnimationListener(new xpe(this, parama, (CharSequence)localObject1));
      parama.mContentLayout.startAnimation(paramMessageForText);
      return;
    }
    parama.mText.setText((CharSequence)localObject1);
  }
  
  @Deprecated
  void As(int paramInt)
  {
    Toast.makeText(this.mContext, paramInt, 0).show();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramViewGroup = (xpc.a)paramView.getTag();
    a(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    b(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (xpc.a)parame;
    parame = paramView;
    if (paramView == null)
    {
      parame = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131562069, null);
      paramBaseChatItemLayout.mContentLayout = parame;
      paramBaseChatItemLayout.mText = ((AnimationTextView)parame.findViewById(2131364506));
      paramBaseChatItemLayout.mText.setMaxWidth(BaseChatItemLayout.bNS);
      paramBaseChatItemLayout.mText.setMovementMethod(new LinkMovementMethod());
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
    paramBaseChatItemLayout.mText.setOnTouchListener(paramwlz);
    paramBaseChatItemLayout.mText.setOnLongClickListener(paramwlz);
    paramBaseChatItemLayout.mText.setOnClickListener(this);
    paramBaseChatItemLayout.mContentLayout.setOnClickListener(this);
    if ((paramBaseChatItemLayout.mText instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.mText).onDoubleClick = new xpd(this);
    }
    return parame;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xpc.a();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.bNY, BaseChatItemLayout.bNV, BaseChatItemLayout.bNX, BaseChatItemLayout.bNW);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.bNX, BaseChatItemLayout.bNV, BaseChatItemLayout.bNY, BaseChatItemLayout.bNW);
  }
  
  @TargetApi(16)
  protected void c(xpc.a parama, MessageForText paramMessageForText)
  {
    if (parama == null) {
      break label4;
    }
    label4:
    Context localContext;
    String str;
    label330:
    for (;;)
    {
      return;
      if ((parama.bVQ == 100000) && (paramMessageForText.msgtype == -1000) && (!paramMessageForText.isSend()))
      {
        if (parama.bid)
        {
          parama.bid = false;
          return;
        }
        long l2 = System.currentTimeMillis();
        if (this.gP.get(Long.valueOf(parama.uniseq)) == null) {}
        for (long l1 = 0L;; l1 = ((Long)this.gP.get(Long.valueOf(parama.uniseq))).longValue())
        {
          if (l2 - l1 < 800L) {
            break label330;
          }
          this.gP.put(Long.valueOf(parama.uniseq), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("Translator", 2, "on click translate status:" + parama.bVR);
          }
          if (parama.bVR != 0) {
            break;
          }
          localContext = this.mContext;
          str = ifw.Q(localContext);
          paramMessageForText = null;
          ifo localifo = ifs.a(this.mContext.getApplicationContext());
          if (localifo != null) {
            paramMessageForText = localifo.a(parama.aVP, parama.uniseq, str);
          }
          if (paramMessageForText == null) {
            break label340;
          }
          if (paramMessageForText.gt().equalsIgnoreCase(parama.aVP)) {
            break label332;
          }
          if ((paramMessageForText.e().booleanValue()) && (!ifs.a(localContext).b(str, parama.aVP, parama.uniseq)))
          {
            bVO += 1;
            ifs.a(localContext).c(str, parama.aVP, parama.uniseq, Boolean.valueOf(true));
          }
          paramMessageForText.aln();
          ifs.a(localContext).a(str, parama.aVP, parama.uniseq, paramMessageForText.e());
          parama.bVR = 1;
          this.adapter.notifyDataSetChanged();
          return;
        }
      }
    }
    label332:
    As(2131717242);
    return;
    label340:
    bVN += 1;
    parama.Jk = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, parama, parama.msg, Language.fromString(str), new xpf(this, parama, localContext, str)).booleanValue())
    {
      b(parama);
      if (AITranslator.a().a(this.mContext).booleanValue())
      {
        As(2131717242);
        return;
      }
      As(2131717244);
      return;
    }
    a(parama);
    ifs.a(this.mContext.getApplicationContext()).b(str, parama.aVP, parama.uniseq, Boolean.valueOf(true));
  }
  
  protected void e(ChatMessage paramChatMessage, String paramString)
  {
    String str = paramChatMessage.msg;
    ifo localifo;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      paramString = ifw.Q(this.mContext.getApplicationContext());
      localifo = ifs.a(this.mContext.getApplicationContext());
      if (localifo == null) {
        break label142;
      }
    }
    label142:
    for (paramString = localifo.a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.e().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (paramString = paramString.gt();; paramString = str)
      {
        aviz.a(null, paramString).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
        avjg.a(this.app, 6, 1);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131364503) || (paramView.getId() == 2131364506))
    {
      MessageForText localMessageForText = (MessageForText)wja.a(paramView);
      c((xpc.a)wja.a(paramView), localMessageForText);
      wja.bcO = true;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
    }
  }
  
  public class a
    extends xov.a
  {
    long Jk;
    RotateableView jdField_a_of_type_ComTencentMobileqqWidgetRotateableView;
    String aVP;
    int bVQ;
    int bVR;
    boolean bid = false;
    int istroop;
    ViewGroup mContentLayout;
    String msg;
    public long uniseq;
    View wR;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpc
 * JD-Core Version:    0.7.0.1
 */