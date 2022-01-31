import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.anonymous.QQAnonymousDialog;

public class ko
  implements Handler.Callback
{
  public ko(QQAnonymousDialog paramQQAnonymousDialog) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 291) {
      switch (this.a.f)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(i));
      paramMessage = this.a;
      paramMessage.f += 1;
      if (this.a.f == 4) {
        this.a.f = 0;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(291, 1000L);
      return false;
      i = 2131362628;
      continue;
      i = 2131362629;
      continue;
      i = 2131362630;
      continue;
      i = 2131362631;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ko
 * JD-Core Version:    0.7.0.1
 */