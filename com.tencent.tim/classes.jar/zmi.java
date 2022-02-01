import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zmi
  implements View.OnClickListener
{
  zmi(zme paramzme) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i(zme.TAG, 2, "onClick, id = " + i);
    }
    Object localObject = this.b.a;
    if (this.b.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (i)
      {
      default: 
        break;
      case 2131365509: 
        ((ClipboardManager)this.b.mContext.getSystemService("clipboard")).setText(((zmc)localObject).messageRecord.msg);
        break;
      case 2131367523: 
        Bundle localBundle = new Bundle();
        localBundle.putInt("forward_type", -1);
        localBundle.putString("forward_text", ((zmc)localObject).messageRecord.msg);
        localObject = new Intent();
        ((Intent)localObject).putExtras(localBundle);
        ahgq.f((Activity)this.b.mContext, (Intent)localObject, 21);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmi
 * JD-Core Version:    0.7.0.1
 */