import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahiw
  implements View.OnClickListener
{
  ahiw(ahio paramahio, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hideSoftInputFromWindow();
    if (this.val$pl != null) {
      this.val$pl.onClick(this.this$0, 0);
    }
    if (ahio.a(this.this$0))
    {
      ahio.a(this.this$0).removeView(ahio.a(this.this$0));
      ahio.a(this.this$0, false);
    }
    try
    {
      if (this.this$0.isShowing()) {
        this.this$0.dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Forward.NewVersion.Dialog", 2, Log.getStackTraceString(localException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahiw
 * JD-Core Version:    0.7.0.1
 */