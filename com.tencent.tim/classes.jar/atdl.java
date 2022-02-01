import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class atdl
  implements Handler.Callback
{
  atdl(atdh paramatdh) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Boolean)))
      {
        atdh.a(this.this$0).showRedDot(((Boolean)paramMessage.obj).booleanValue());
        continue;
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Integer)))
        {
          this.this$0.fY(BaseApplication.getContext());
          aqmj.l(this.this$0.x.getCurrentAccountUin()).edit().putInt("show_tab_lightalk_tips", ((Integer)paramMessage.obj).intValue() + 1).commit();
          continue;
          this.this$0.eti();
          if (QLog.isColorLevel()) {
            QLog.d("RecentCallHelper", 2, "dismiss lightalk tips");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdl
 * JD-Core Version:    0.7.0.1
 */