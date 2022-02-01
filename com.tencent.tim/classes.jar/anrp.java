import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class anrp
  implements View.OnClickListener
{
  public anrp(StructMsgForGeneralShare paramStructMsgForGeneralShare, Context paramContext, PopupWindow paramPopupWindow) {}
  
  public void onClick(View paramView)
  {
    QLog.d(StructMsgForGeneralShare.access$000(), 1, "filter_ad");
    ((FragmentActivity)this.val$context).getChatFragment().a().a((ChatMessage)this.this$0.message);
    ((kds)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(139)).a(7, this.this$0.message);
    if (this.l.isShowing()) {
      this.l.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrp
 * JD-Core Version:    0.7.0.1
 */