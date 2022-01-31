import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.widget.QQToast;

public final class bsu
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = (ChatMessage)paramCompoundButton.getTag();
    if (localObject == null) {}
    while (paramBoolean == MultiMsgManager.a().a((ChatMessage)localObject)) {
      return;
    }
    if (!paramBoolean)
    {
      MultiMsgManager.a().a((ChatMessage)localObject, paramBoolean);
      return;
    }
    if (MultiMsgManager.a().b())
    {
      localObject = paramCompoundButton.getContext().getString(2131363005, new Object[] { Integer.valueOf(MultiMsgManager.a().a()) });
      QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject, 0).b(((ChatActivity)paramCompoundButton.getContext()).getTitleBarHeight());
      paramCompoundButton.setChecked(false);
      return;
    }
    if ((((localObject instanceof MessageForPic)) || ((localObject instanceof MessageForMixedMsg)) || (((ChatMessage)localObject).msgtype == -1036)) && (MultiMsgManager.a().c()))
    {
      localObject = paramCompoundButton.getContext().getString(2131363006, new Object[] { Integer.valueOf(MultiMsgManager.a().b()) });
      QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject, 0).b(((ChatActivity)paramCompoundButton.getContext()).getTitleBarHeight());
      paramCompoundButton.setChecked(false);
      return;
    }
    MultiMsgManager.a().a((ChatMessage)localObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bsu
 * JD-Core Version:    0.7.0.1
 */