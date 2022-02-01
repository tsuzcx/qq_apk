import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaar
  implements View.OnClickListener
{
  public aaar(LingHbFragment paramLingHbFragment) {}
  
  public void onClick(View paramView)
  {
    QLog.i("LingHbFragment", 2, "change others...");
    if (this.a.channel == 65536) {}
    for (String str = "yyhongbao.word.change";; str = "klhongbao.word.change")
    {
      this.a.addUploadData(str, "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaar
 * JD-Core Version:    0.7.0.1
 */