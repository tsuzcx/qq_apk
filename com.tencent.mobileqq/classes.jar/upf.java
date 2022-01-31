import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.OnChatMessageCheckedChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.widget.QQToast;

public final class upf
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = (ChatMessage)paramCompoundButton.getTag();
    if (localObject == null) {}
    for (;;)
    {
      return;
      if (paramBoolean != MultiMsgManager.a().a((ChatMessage)localObject))
      {
        if (!paramBoolean) {
          MultiMsgManager.a().a((ChatMessage)localObject, paramBoolean);
        }
        while (BaseChatItemLayout.a != null)
        {
          BaseChatItemLayout.a.a((ChatMessage)localObject, paramBoolean);
          return;
          if (MultiMsgManager.a().b())
          {
            localObject = paramCompoundButton.getContext().getString(2131433432, new Object[] { Integer.valueOf(MultiMsgManager.a().a()) });
            QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
            paramCompoundButton.setChecked(false);
            return;
          }
          if ((((localObject instanceof MessageForPic)) || ((localObject instanceof MessageForMixedMsg)) || (((ChatMessage)localObject).msgtype == -1036)) && (MultiMsgManager.a().c()))
          {
            localObject = paramCompoundButton.getContext().getString(2131433433, new Object[] { Integer.valueOf(MultiMsgManager.a().b()) });
            QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
            paramCompoundButton.setChecked(false);
            return;
          }
          if (((localObject instanceof MessageForShortVideo)) && (MultiMsgManager.a().d()))
          {
            localObject = paramCompoundButton.getContext().getString(2131433434, new Object[] { Integer.valueOf(MultiMsgManager.a().c()) });
            QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
            paramCompoundButton.setChecked(false);
            return;
          }
          MultiMsgManager.a().a((ChatMessage)localObject, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upf
 * JD-Core Version:    0.7.0.1
 */