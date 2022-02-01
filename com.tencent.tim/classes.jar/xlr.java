import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class xlr
  extends BaseBubbleBuilder
  implements CustomizeStrategyFactory.c
{
  public static final String TAG = xlr.class.getSimpleName();
  private static int bUF;
  private static int bUG;
  private static int bUH;
  public static Map<MessageForQQWalletMsg, Long> hN = new HashMap();
  private acgn jdField_a_of_type_Acgn;
  xvk jdField_a_of_type_Xvk;
  protected String aVz = "";
  protected final int bUI = 2131375553;
  protected int bUJ;
  protected int bUK;
  protected int bUL;
  protected int bUM;
  protected int bUN;
  protected int bUO;
  protected int bUP;
  protected int bUQ;
  protected int bUR;
  private View.OnClickListener dS = new xls(this);
  BaseChatPie e = null;
  int messageType;
  protected float scale = 1.0F;
  int skinId;
  
  public xlr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Xvk = new xvk(paramContext);
    this.aVz = paramContext.getString(2131717318);
    this.scale = paramContext.getResources().getDisplayMetrics().density;
    this.bUJ = ((int)(42.0F * this.scale + 0.5F));
    this.bUK = ((int)(10.0F * this.scale + 0.5F));
    this.bUL = ((int)(9.0F * this.scale + 0.5F));
    this.bUM = ((int)(6.5F * this.scale + 0.5F));
    this.bUN = ((int)(4.0F * this.scale + 0.5F));
    this.bUO = ((int)(this.scale * 1.0F + 0.5F));
    this.bUP = ((int)(7.0F * this.scale + 0.5F));
    this.bUQ = ((int)(173.0F * this.scale + 0.5F));
    this.bUR = ((int)(255.0F * this.scale + 0.5F));
    bUF = this.bUO * 2;
    bUG = this.bUO * 2;
    bUH = this.bUP;
    paramBaseAdapter = (FragmentActivity)paramContext;
    if (paramBaseAdapter.getChatFragment() != null) {
      this.e = paramBaseAdapter.getChatFragment().a();
    }
    this.jdField_a_of_type_Acgn = ((acgn)paramQQAppInterface.getManager(131));
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.bUK;
    localLayoutParams.bottomMargin = this.bUM;
    localLayoutParams.leftMargin = (this.bUJ + this.bUN);
    localLayoutParams.rightMargin = (this.bUJ + this.bUN);
    localLayoutParams.addRule(3, 2131364503);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130845675);
    paramContext.setPadding(this.bUL, this.bUN, this.bUL, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.bUN, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131375553);
    return paramContext;
  }
  
  private void a(xvt paramxvt, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, wlz paramwlz)
  {
    xvb localxvb = new xvb(this.app, paramxvt, paramQQWalletTransferMsgElem, 0, this);
    paramMessageForQQWalletMsg.specifyIcon = null;
    try
    {
      localxvb.onCreate();
      localxvb.cfl();
      localxvb.cfm();
      localxvb.cfi();
      localxvb.cfn();
      localxvb.ST();
      localxvb.onResume();
      paramxvt.Kv.setOnClickListener(null);
      paramxvt.layout.setOnLongClickListener(paramwlz);
      paramxvt.layout.setOnTouchListener(paramwlz);
      paramxvt.layout.setTag(paramMessageForQQWalletMsg);
      this.jdField_a_of_type_Xvk.a(paramxvt.layout, paramQQWalletTransferMsgElem.title + this.aVz);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "handleOldRedPacketLayout exception", localThrowable);
        }
      }
    }
  }
  
  private void a(xvt paramxvt, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, wlz paramwlz, boolean paramBoolean)
  {
    if ((paramQQWalletTransferMsgElem == null) || (paramMessageForQQWalletMsg == null)) {}
    for (;;)
    {
      return;
      Object localObject;
      int i;
      if (QLog.isColorLevel())
      {
        if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
        {
          localObject = ",QQWalletAioBodyReserve=" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body;
          QLog.d(TAG, 2, "handleRedPacketLayout holder=" + paramxvt + ",elem=" + paramQQWalletTransferMsgElem + ",qqWalletMsg=" + paramMessageForQQWalletMsg + (String)localObject + ",fromItemRefresh=" + paramBoolean);
        }
      }
      else
      {
        int j = xvz.fm(paramMessageForQQWalletMsg.messageType);
        i = j;
        if (j == 4)
        {
          i = j;
          if (paramQQWalletTransferMsgElem.skinId > 0) {
            i = 0;
          }
        }
        localObject = xvz.a(this.app, paramxvt, paramQQWalletTransferMsgElem, i, this);
        if ((localObject instanceof xvw)) {
          ((xvw)localObject).a(this.d);
        }
      }
      try
      {
        ((xvg)localObject).onCreate();
        ((xvg)localObject).cfl();
        ((xvg)localObject).cfm();
        ((xvg)localObject).cfi();
        ((xvg)localObject).cfn();
        ((xvg)localObject).ST();
        ((xvg)localObject).cfo();
        ((xvg)localObject).cfj();
        ((xvg)localObject).onResume();
        if (!paramBoolean)
        {
          this.skinId = paramQQWalletTransferMsgElem.skinId;
          this.messageType = paramMessageForQQWalletMsg.messageType;
          paramxvt.Kv.setOnClickListener(this.dS);
          paramxvt.hU.setOnLongClickListener(paramwlz);
          paramxvt.hU.setOnTouchListener(paramwlz);
          paramxvt.hU.setTag(paramMessageForQQWalletMsg);
          this.jdField_a_of_type_Xvk.a(this.app, this.e, paramxvt.hU, this.sessionInfo, i, paramQQWalletTransferMsgElem.skinId, this.aVz);
          if (i == 1)
          {
            paramxvt.layout.setContentDescription(acfp.m(2131712571) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712576));
            return;
            localObject = "";
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "handleRedPacketLayout exception", localThrowable);
          }
        }
        if (i == 2)
        {
          paramxvt.layout.setContentDescription(acfp.m(2131712578) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712566));
          return;
        }
        if (i == 8)
        {
          paramxvt.layout.setContentDescription("K歌红包:" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712585));
          return;
        }
        if (i == 9)
        {
          paramxvt.layout.setContentDescription(acfp.m(2131712568) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712577));
          return;
        }
        if (i == 10)
        {
          paramxvt.layout.setContentDescription(acfp.m(2131712584) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712587));
          return;
        }
        if (i == 11)
        {
          paramxvt.layout.setContentDescription(acfp.m(2131712574) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712573));
          return;
        }
        paramxvt.layout.setContentDescription(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + this.aVz);
      }
    }
  }
  
  protected void Dj(int paramInt)
  {
    ThreadManager.post(new QQWalletMsgItemBuilder.1(this, paramInt), 8, null, true);
  }
  
  public void M(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.app != null))
    {
      MqqHandler localMqqHandler = this.app.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        Message localMessage = new Message();
        localMessage.what = 78;
        localMessage.arg1 = 888;
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramMessageRecord.uniseq);
        localMessage.setData(localBundle);
        localMqqHandler.sendMessage(localMessage);
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramView = null;
    xvt localxvt = (xvt)parame;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (parame = (MessageForQQWalletMsg)paramChatMessage;; parame = null)
    {
      if ((parame == null) || ((parame.mQQWalletTransferMsg == null) && (parame.mQQWalletRedPacketMsg == null))) {
        return null;
      }
      if (QWalletHelper.graphbSpeedEnable) {
        Dj(parame.istroop);
      }
      if ((localxvt.layout == null) || ((localxvt.layout != null) && (localxvt.uniseq != paramChatMessage.uniseq)))
      {
        localxvt.layout = this.jdField_a_of_type_Xvk.a(localxvt, this.mContext);
        paramBaseChatItemLayout.addView(a(this.mContext));
      }
      localxvt.uniseq = paramChatMessage.uniseq;
      if (parame.mQQWalletRedPacketMsg != null)
      {
        paramChatMessage = parame.mQQWalletRedPacketMsg.elem;
        if (paramChatMessage == null) {
          return localxvt.layout;
        }
        a(localxvt, paramChatMessage, parame, paramwlz, false);
        parame = (TextView)paramBaseChatItemLayout.findViewById(2131375553);
        if (parame != null)
        {
          if ((paramChatMessage == null) || (TextUtils.isEmpty(paramChatMessage.blackStripe))) {
            break label247;
          }
          parame.setText(paramChatMessage.blackStripe);
          parame.setVisibility(0);
        }
      }
      for (;;)
      {
        return localxvt.layout;
        paramChatMessage = paramView;
        if (parame.mQQWalletTransferMsg == null) {
          break;
        }
        paramChatMessage = parame.mQQWalletTransferMsg.elem;
        if (paramChatMessage == null) {
          return localxvt.layout;
        }
        a(localxvt, paramChatMessage, parame, paramwlz);
        break;
        label247:
        parame.setVisibility(8);
      }
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xvt();
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
      paramView.setPadding(bUG, bUH, bUF, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(bUF, bUH, bUG, paramView.getResources().getDimensionPixelSize(2131296405));
      return;
    }
    paramView.setPadding(bUF, bUH, bUG, 0);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateView type=" + paramInt + ",message=" + paramChatMessage);
    }
    if (paramInt == 888)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof xvt))
      {
        paramChatMessage = (xvt)paramView;
        if (paramChatMessage.hU == null) {
          break label117;
        }
      }
      label117:
      for (paramView = paramChatMessage.hU.getTag();; paramView = null)
      {
        if ((paramView instanceof MessageForQQWalletMsg))
        {
          paramView = (MessageForQQWalletMsg)paramView;
          if (paramView.mQQWalletRedPacketMsg != null) {
            a(paramChatMessage, paramView.mQQWalletRedPacketMsg.elem, paramView, null, true);
          }
        }
        return;
      }
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    paramChatMessage = (xvt)parame;
    paramContext = paramBaseChatItemLayout.findViewById(2131375456);
    if (paramChatMessage.c != null)
    {
      paramInt1 = paramChatMessage.E.getPaddingLeft();
      paramInt2 = paramChatMessage.E.getPaddingRight();
      int i = paramChatMessage.E.getPaddingTop();
      int j = paramChatMessage.E.getPaddingBottom();
      paramChatMessage.E.setPadding(this.bUM + paramInt1, i, paramInt2 + this.bUM, j);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.bUQ, this.bUR);
      paramBaseChatItemLayout.addRule(5, 2131364503);
      paramBaseChatItemLayout.addRule(6, 2131364503);
      paramBaseChatItemLayout.leftMargin = paramInt1;
      paramBaseChatItemLayout.topMargin = (-this.bUO);
      if (paramContext != null)
      {
        paramChatMessage.a.removeView(paramContext);
        paramChatMessage.a.addView(paramChatMessage.c, paramBaseChatItemLayout);
      }
    }
    else
    {
      return;
    }
    paramChatMessage.a.addView(paramChatMessage.c, paramBaseChatItemLayout);
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
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (Object localObject = (MessageForQQWalletMsg)paramChatMessage;; localObject = null)
    {
      if ((localObject == null) || ((((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg == null) && (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg == null))) {
        return paramChatMessage.msg;
      }
      if (((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg != null) {
        localObject = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg.elem;
      }
      for (;;)
      {
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (aqiu.ms(paramChatMessage.issend)) {
            localStringBuilder.append("发出");
          }
          for (;;)
          {
            localStringBuilder.append(((QQWalletTransferMsgElem)localObject).content).append(((QQWalletTransferMsgElem)localObject).title).append("按钮");
            return localStringBuilder.toString();
            if (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg == null) {
              break label141;
            }
            localObject = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
            break;
            localStringBuilder.append("发来");
          }
        }
        return paramChatMessage.msg;
        label141:
        localObject = null;
      }
    }
  }
  
  public void destroy()
  {
    super.destroy();
    CustomizeStrategyFactory.a().bZc();
    aagl.a().destroy();
    hN.clear();
  }
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramRedPacketInfo.skinType == 1) && ((paramRedPacketInfo.background != null) || (paramRedPacketInfo.animInfo != null))) {
              M(paramRedPacketInfo.h);
            }
          } while ((paramRedPacketInfo.skinType != 3) || (paramRedPacketInfo.specailBackgroundAnimInfo == null));
          M(paramRedPacketInfo.h);
          return;
        } while (paramRedPacketInfo.animInfo == null);
        M(paramRedPacketInfo.h);
        return;
      } while (paramRedPacketInfo.background == null);
      M(paramRedPacketInfo.h);
      return;
    } while ((!paramRedPacketInfo.Rs()) && (paramRedPacketInfo.dv == null));
    M(paramRedPacketInfo.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlr
 * JD-Core Version:    0.7.0.1
 */