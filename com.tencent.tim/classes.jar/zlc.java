import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zlc
  implements View.OnClickListener
{
  zlc(zky paramzky) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onClick, id = " + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b.a != null)
      {
        ((ClipboardManager)this.b.mContext.getSystemService("clipboard")).setText(this.b.a.messageRecord.msg);
        continue;
        if ((this.b.a != null) && (this.b.h != null) && (this.b.h.structingMsg != null) && ((this.b.h.structingMsg instanceof AbsShareMsg)))
        {
          AbsShareMsg localAbsShareMsg = (AbsShareMsg)this.b.h.structingMsg;
          Intent localIntent = new Intent(this.b.mContext, ForwardRecentActivity.class);
          localIntent.putExtra("forward_type", -3);
          localIntent.putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
          localIntent.putExtra("is_need_show_sources", false);
          ahgq.f((Activity)this.b.mContext, localIntent, 21);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlc
 * JD-Core Version:    0.7.0.1
 */