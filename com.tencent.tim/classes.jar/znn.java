import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForScribble;

public class znn
  extends xov
{
  public znn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    paramContext = (xov.a)parame;
    if (paramContext.mText != null)
    {
      if ((!(paramChatMessage instanceof MessageForPoke)) && (!(paramChatMessage instanceof MessageForPokeEmo))) {
        break label109;
      }
      if (!TextUtils.isEmpty(paramChatMessage.msg)) {
        break label95;
      }
      paramContext.mText.setText(acfp.m(2131708413));
    }
    for (;;)
    {
      if (paramContext.sL != null) {
        paramContext.sL.setVisibility(8);
      }
      if (paramContext.sM != null) {
        paramContext.sM.setVisibility(8);
      }
      return;
      label95:
      paramContext.mText.setText(paramChatMessage.msg);
      continue;
      label109:
      if ((paramChatMessage instanceof MessageForScribble)) {
        paramContext.mText.setText(acfp.m(2131708412));
      } else {
        paramContext.mText.setText(acfp.m(2131708414));
      }
    }
  }
  
  public void ej(View paramView)
  {
    super.ej(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znn
 * JD-Core Version:    0.7.0.1
 */