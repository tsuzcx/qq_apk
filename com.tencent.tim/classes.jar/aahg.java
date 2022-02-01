import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aahg
  implements View.OnClickListener
{
  aahg(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    try
    {
      aqha.a(aahb.a(this.this$0), 0, null, acfp.m(2131703031), 2131721058, 2131721079, new aahh(this), new aahi(this)).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahg
 * JD-Core Version:    0.7.0.1
 */