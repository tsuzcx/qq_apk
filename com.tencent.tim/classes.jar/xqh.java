import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class xqh
  extends BaseBubbleBuilder
{
  public static String aVU = "";
  public static int bWm = 0;
  private xqh.a a = new xqi(this);
  private View.OnClickListener dW = new xqj(this);
  
  public xqh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void B(View paramView, boolean paramBoolean)
  {
    int j = 0;
    View localView = paramView.findViewById(2131369522);
    paramView = paramView.findViewById(2131382028);
    if (paramBoolean)
    {
      i = 8;
      localView.setVisibility(i);
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (int i = j;; i = 8)
    {
      paramView.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString2)
  {
    if (bWm == 0) {}
    while ((paramArrayList.size() != 1) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramArrayList = (MessageForText.AtTroopMemberInfo)paramArrayList.get(0);
        long l1 = paramArrayList.uin;
        long l2 = Long.parseLong(aVU);
        if (l1 != l2) {
          return;
        }
        paramArrayList = paramString1.substring(paramArrayList.textLen).trim();
        Object localObject;
        if (bWm == 1)
        {
          localObject = "";
          if (TroopManager.tM.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new anov(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_welcome_suc").a(new String[] { paramString2, localObject, aVU }).report();
          new anov(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_text_suc").a(new String[] { paramString2, "", "" + apuh.o(paramQQAppInterface, paramString2), localObject }).report();
        }
        if (bWm == 2)
        {
          localObject = "";
          if (TroopManager.tN.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new anov(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_play_suc").a(new String[] { paramString2, localObject, aVU }).report();
        }
        if (bWm == 3)
        {
          if (TroopManager.tN.contains(paramArrayList)) {
            new anov(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_bartext_suc").a(new String[] { paramString2, "", "" + apuh.o(paramQQAppInterface, paramString2), paramArrayList }).report();
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopPobingItemBuilder", 2, "reportWelcome subString error ,content length = " + paramString1.length());
        }
        return;
      }
      finally
      {
        bWm = 0;
      }
      paramArrayList = "";
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString2)
  {
    if (bWm == 0) {}
    while ((paramArrayList.size() != 1) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramArrayList = (MessageForText.AtTroopMemberInfo)paramArrayList.get(0);
        long l1 = paramArrayList.uin;
        long l2 = Long.parseLong(aVU);
        if (l1 != l2) {
          return;
        }
        paramArrayList = paramString1.substring(paramArrayList.textLen).trim();
        if (bWm == 1)
        {
          Object localObject = "";
          if (TroopManager.tM.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new anov(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_pic_suc").a(new String[] { paramString2, "", "" + apuh.o(paramQQAppInterface, paramString2), localObject }).report();
        }
        if (bWm == 3)
        {
          if (TroopManager.tN.contains(paramArrayList)) {
            new anov(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_barpic_suc").a(new String[] { paramString2, "", "" + apuh.o(paramQQAppInterface, paramString2), paramArrayList }).report();
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopPobingItemBuilder", 2, "reportWelcomeForMixMsg subString error ,content length = " + paramString1.length());
        }
        return;
      }
      finally
      {
        bWm = 0;
      }
      paramArrayList = "";
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 3;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    xqh.b localb = (xqh.b)parame;
    boolean bool = paramChatMessage.senderuin.equals(this.app.getCurrentUin());
    Context localContext = paramBaseChatItemLayout.getContext();
    parame = paramView;
    if (paramView == null)
    {
      parame = LayoutInflater.from(this.mContext).inflate(2131558930, paramBaseChatItemLayout, false);
      localb.Kd = ((TextView)parame.findViewById(2131363719));
      localb.Ke = ((TextView)parame.findViewById(2131363744));
      localb.divider = parame.findViewById(2131365846);
      localb.wW = parame.findViewById(2131363902);
      paramView = parame.findViewById(2131369522);
      paramBaseChatItemLayout = paramView.getLayoutParams();
      paramBaseChatItemLayout.width = (BaseChatItemLayout.bNS - wja.dp2px(24.0F, localContext.getResources()));
      paramView.setLayoutParams(paramBaseChatItemLayout);
      parame.setOnLongClickListener(paramwlz);
      parame.setOnTouchListener(paramwlz);
    }
    int i = this.mContext.getResources().getDimensionPixelOffset(2131298564);
    int k = this.mContext.getResources().getDimensionPixelOffset(2131298565);
    int j;
    if (paramChatMessage.isSend()) {
      j = k;
    }
    for (;;)
    {
      k = wja.dp2px(20.0F, localContext.getResources());
      int m = wja.dp2px(20.0F, localContext.getResources());
      localb.Kd.setPadding(j, k, i, m);
      paramView = (MessageForTroopPobing)paramChatMessage;
      localb.Kd.setText(paramView.mBrief);
      if (!bool)
      {
        localb.divider.setVisibility(0);
        localb.wW.setVisibility(0);
        localb.Ke.setOnClickListener(this.dW);
      }
      for (;;)
      {
        paramBaseChatItemLayout = (TroopPobingItemView)parame.findViewById(2131382028);
        paramBaseChatItemLayout.a(parame, this.a);
        B(parame, false);
        if ((paramView.mTemplateId != 2000) && (!anlm.ayn()) && (aqsr.isEnable()))
        {
          ((TextView)paramBaseChatItemLayout.findViewById(2131373432)).setText(paramView.mBrief);
          paramBaseChatItemLayout.aP(paramView.mTemplateId, paramChatMessage.isSend());
        }
        return parame;
        localb.divider.setVisibility(8);
        localb.wW.setVisibility(8);
      }
      j = i;
      i = k;
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xqh.b();
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
    super.k(paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    if (((MessageForTroopPobing)paramChatMessage).mTemplateId == 2000)
    {
      if (paramChatMessage.isSend())
      {
        parame.E.setBackgroundResource(2130851006);
        return;
      }
      parame.E.setBackgroundResource(2130850829);
      return;
    }
    parame.E.setBackgroundResource(0);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = wja.a(paramView);
    a(paramView, localaqoa);
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    b(paramView, localaqoa);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public static abstract interface a
  {
    public abstract void fx(View paramView);
    
    public abstract void fy(View paramView);
  }
  
  public static class b
    extends BaseBubbleBuilder.e
  {
    public TextView Kd;
    public TextView Ke;
    public View divider;
    public View wW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqh
 * JD-Core Version:    0.7.0.1
 */