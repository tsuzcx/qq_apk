import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.hiboom.HiBoomTextView.d;

public class xea
  extends BaseBubbleBuilder
{
  private HiBoomTextView.d a = new xeb(this);
  Context mContext;
  
  public xea(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.mContext = paramContext;
  }
  
  private void F(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((acle)this.app.getBusinessHandler(13)).z(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = ahxs.a(this.mContext);
      if (paramChatMessage != null)
      {
        paramChatMessage.setMessage(acfp.m(2131707138));
        paramChatMessage.show();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    if ((parame instanceof xea.a))
    {
      paramBaseChatItemLayout = (xea.a)parame;
      parame = paramView;
      paramView = paramBaseChatItemLayout;
      if (!(parame instanceof HiBoomTextView)) {
        break label129;
      }
      paramwlz = (HiBoomTextView)parame;
      paramBaseChatItemLayout = parame;
      parame = paramwlz;
    }
    for (;;)
    {
      paramView.b.a = this.a;
      if ((paramChatMessage instanceof MessageForHiBoom))
      {
        paramChatMessage = (MessageForHiBoom)paramChatMessage;
        if (paramChatMessage.mHiBoomMessage != null)
        {
          parame.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.sessionInfo, ahxs.b);
          parame.setText(paramChatMessage.mHiBoomMessage.text);
          if (aTl) {
            parame.setContentDescription(b(paramChatMessage));
          }
        }
      }
      return paramBaseChatItemLayout;
      paramView = (xea.a)a();
      parame = null;
      break;
      label129:
      parame = new HiBoomTextView(this.mContext);
      parame.setMaxSize(Math.min(BaseChatItemLayout.bNT, ahxs.dbR));
      paramView.b = parame;
      parame.setOnLongClickListener(paramwlz);
      parame.setOnTouchListener(paramwlz);
      parame.setTag(paramView);
      paramBaseChatItemLayout = parame;
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xea.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131372073: 
      super.m(paramChatMessage);
      return;
    case 2131368508: 
      F(paramChatMessage);
      return;
    case 2131365686: 
      ujt.b(paramContext, this.app, paramChatMessage);
      return;
    }
    super.j(paramChatMessage);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    if ((wja.a(paramView) instanceof xea.a))
    {
      paramView = (xea.a)wja.a(paramView);
      if ((paramView.mMessage instanceof MessageForHiBoom))
      {
        localaqoa.Z(2131368508, this.mContext.getString(2131721067), 2130839086);
        if (((MessageForHiBoom)paramView.mMessage).istroop == 0) {
          a(paramView.mMessage, localaqoa);
        }
      }
      if ((paramView.mMessage.extraflag != 32768) && (!this.app.a().aR(paramView.mMessage))) {
        a(localaqoa, this.sessionInfo.cZ, paramView.mMessage);
      }
      a(localaqoa, paramView.mMessage);
    }
    super.c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      if (paramChatMessage.mHiBoomMessage != null) {
        return paramChatMessage.mHiBoomMessage.text;
      }
    }
    return null;
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    paramView = wja.a(paramView);
    String str1 = this.mContext.getString(2131690230);
    String str2 = this.mContext.getString(2131690231);
    if (paramView.isSendFromLocal()) {
      aqha.a(this.mContext, 230, str1, str2, new xec(this, paramView), new xed(this)).show();
    }
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {
    public HiBoomTextView b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xea
 * JD-Core Version:    0.7.0.1
 */