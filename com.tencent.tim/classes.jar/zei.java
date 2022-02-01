import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment;
import com.tencent.mobileqq.widget.QQToast;

public class zei
  implements Handler.Callback
{
  public zei(ChatHistoryAuthDevForRoamMsgFragment paramChatHistoryAuthDevForRoamMsgFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    ChatHistoryAuthDevForRoamMsgFragment.a(this.a).findViewById(2131381372).setEnabled(true);
    if ((this.a.z != null) && (this.a.z.isShowing())) {
      this.a.z.dismiss();
    }
    if (paramMessage.arg1 == 0) {
      QQToast.a(this.a.getActivity(), 2, acfp.m(2131703633), 0).show(this.a.getActivity().getTitleBarHeight());
    }
    for (;;)
    {
      this.a.getActivity().setResult(1);
      this.a.getActivity().finish();
      return false;
      QQToast.a(this.a.getActivity(), 2, acfp.m(2131703643), 0).show(this.a.getActivity().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zei
 * JD-Core Version:    0.7.0.1
 */