import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xxj
  implements View.OnClickListener
{
  xxj(xxh paramxxh) {}
  
  public void onClick(View paramView)
  {
    if (!abmt.isFastDoubleClick()) {
      ((abhh)this.this$0.app.getManager(153)).a().dc(this.this$0.oL(), 319);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "[onClick] click audio button too fast.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxj
 * JD-Core Version:    0.7.0.1
 */