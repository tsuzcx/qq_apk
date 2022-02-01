import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zlm
  implements View.OnClickListener
{
  zlm(zli paramzli) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onClick, id = " + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.c.jdField_a_of_type_Zmc != null)
      {
        ((ClipboardManager)this.c.mContext.getSystemService("clipboard")).setText(this.c.jdField_a_of_type_Zmc.messageRecord.msg);
        continue;
        if (this.c.jdField_a_of_type_Zmc != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("forward_type", -1);
          localBundle.putString("forward_text", this.c.jdField_a_of_type_Zmc.messageRecord.msg);
          Intent localIntent = new Intent(this.c.mContext, ForwardRecentActivity.class);
          localIntent.putExtras(localBundle);
          ((Activity)this.c.mContext).startActivityForResult(localIntent, 21);
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("C2CMessageSearchDialog", 2, "OnClickListener, setMessageItems");
          }
          this.c.gV = false;
          zli.a(this.c).setVisibility(8);
          zli.a(this.c, 0, null);
          this.c.jdField_a_of_type_Zlg.a(zli.a(this.c), this.c.ban, this.c.Lj);
          this.c.jdField_a_of_type_Zlg.notifyDataSetChanged();
          this.c.cdG = 1;
          VipUtils.a(this.c.app, "chat_history", "ChatSearch", "Clk_cloudtips", 0, 0, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlm
 * JD-Core Version:    0.7.0.1
 */