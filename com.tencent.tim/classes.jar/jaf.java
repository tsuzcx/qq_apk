import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class jaf
  implements View.OnClickListener
{
  public jaf(MultiMembersAudioUI paramMultiMembersAudioUI) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jai.a locala = (jai.a)paramView.getTag();
      if (locala == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiMembersAudioUI", 2, "onItemClick-->holder is null");
        }
      }
      else
      {
        if (locala.Xa) {}
        for (int i = 7;; i = this.a.v(locala.uin))
        {
          if ((this.a.iG.size() <= 8) || ((this.a.aqx != 1) && (this.a.aqx != 2))) {
            break label134;
          }
          this.a.a.d(locala.uin, locala.awy, i, true);
          break;
        }
        label134:
        this.a.a.d(locala.uin, locala.awy, i, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jaf
 * JD-Core Version:    0.7.0.1
 */