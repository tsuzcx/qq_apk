import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;

class aqkz
  implements View.OnClickListener
{
  aqkz(aqky paramaqky, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick timeGap:" + (System.currentTimeMillis() - aqky.a(this.this$0)) + " MANUFACTURER:" + Build.MANUFACTURER + " MODEL:" + Build.MODEL);
    }
    if ((System.currentTimeMillis() - aqky.a(this.this$0) < 800L) && (aqky.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick skip");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = aqky.a(this.this$0).getText().toString();
      if (localObject != null) {
        if ((aofk.containsEmoji((String)localObject)) || (aofk.pU((String)localObject)))
        {
          localObject = (Context)aqky.a(this.this$0).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).setDuration(2000);
            ((QQToast)localObject).setToastMsg(2131721196);
            ((QQToast)localObject).show();
          }
        }
        else if ((aqky.a(this.this$0) == null) && (24 < ((String)localObject).getBytes().length))
        {
          localObject = (Context)aqky.a(this.this$0).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).setDuration(2000);
            ((QQToast)localObject).setToastMsg(2131721197);
            ((QQToast)localObject).show();
          }
        }
        else
        {
          if (this.val$nl != null) {
            this.val$nl.onClick(this.this$0, 1);
          }
          this.this$0.dismiss();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkz
 * JD-Core Version:    0.7.0.1
 */