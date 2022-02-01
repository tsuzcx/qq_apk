import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajff
  implements View.OnClickListener
{
  public ajff(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onClick(View paramView)
  {
    if (MsgBackupDateFragment.a(this.a) == 0) {
      ajgt.report("0X800A237");
    }
    for (;;)
    {
      this.a.finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ajee.cnI) {
        ajgt.report("0X800A25C");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajff
 * JD-Core Version:    0.7.0.1
 */