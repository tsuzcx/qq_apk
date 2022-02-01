import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zlx
  implements View.OnClickListener
{
  zlx(zlt paramzlt) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onClick, id = " + i);
    }
    switch (i)
    {
    default: 
    case 2131365509: 
    case 2131367523: 
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            if (this.b.jdField_a_of_type_Zmc != null) {
              ((ClipboardManager)this.b.mContext.getSystemService("clipboard")).setText(this.b.jdField_a_of_type_Zmc.messageRecord.msg);
            }
          }
        } while (this.b.jdField_a_of_type_Zmc == null);
        localObject1 = this.b.jdField_a_of_type_Zmc.messageRecord;
      } while (!(localObject1 instanceof MessageForText));
    }
    Object localObject2;
    for (Object localObject1 = (MessageForText)localObject1;; localObject2 = null)
    {
      try
      {
        localObject1 = aoyb.deserialize(((MessageForText)localObject1).msgData);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = (TroopLinkElement)localObject1;
        Object localObject3 = new Bundle();
        if (localObject1 != null)
        {
          ((Bundle)localObject3).putString("image_url_remote", ((TroopLinkElement)localObject1).url);
          ((Bundle)localObject3).putString("detail_url", ((TroopLinkElement)localObject1).iconUrl);
          ((Bundle)localObject3).putString("title", ((TroopLinkElement)localObject1).title);
          ((Bundle)localObject3).putString("desc", ((TroopLinkElement)localObject1).title);
          ((Bundle)localObject3).putString("req_create_time", ((TroopLinkElement)localObject1).timeSecond);
        }
        localObject1 = anre.a((Bundle)localObject3);
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("forward_type", -3);
        ((Intent)localObject3).putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject1).getBytes());
        ahgq.f((Activity)this.b.mContext, (Intent)localObject3, 21);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.i("LinkMessageSearchDialog", 2, "OnClickListener, setMessageItems");
      }
      this.b.gV = false;
      zlt.a(this.b).setVisibility(8);
      zlt.a(this.b, 0, null);
      this.b.jdField_a_of_type_Zjj.a(zlt.a(this.b), this.b.ban, this.b.Lj);
      this.b.jdField_a_of_type_Zjj.notifyDataSetChanged();
      this.b.cdG = 1;
      break;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlx
 * JD-Core Version:    0.7.0.1
 */