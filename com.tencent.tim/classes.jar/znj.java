import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class znj
  extends xeh
{
  boolean brF = false;
  
  public znj(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
  }
  
  private boolean hn(int paramInt)
  {
    return (paramInt == 62) || (paramInt == 96) || (paramInt == 75);
  }
  
  public void BN(boolean paramBoolean)
  {
    this.brF = paramBoolean;
  }
  
  public wko a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (hn(a(this.app, paramChatMessage))) {
      if (this.a == null) {
        this.a = new znn(this.app, paramBaseAdapter, this.mContext, this.d, this.e);
      }
    }
    for (paramChatMessage = a(this.a, paramBaseAdapter);; paramChatMessage = super.a(paramChatMessage, paramBaseAdapter))
    {
      if ((paramChatMessage instanceof BaseBubbleBuilder)) {
        ((BaseBubbleBuilder)paramChatMessage).bdn = true;
      }
      return paramChatMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znj
 * JD-Core Version:    0.7.0.1
 */