package cooperation.qzone.contentbox;

import android.widget.RelativeLayout.LayoutParams;
import aqnm;
import com.tencent.widget.ListView;
import java.util.ArrayList;

class QZoneMsgFragment$6
  implements Runnable
{
  QZoneMsgFragment$6(QZoneMsgFragment paramQZoneMsgFragment, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.fr != null) && (this.fr.size() > 0)) {}
    for (int i = 44;; i = 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)QZoneMsgFragment.a(this.this$0).getLayoutParams();
      localLayoutParams.bottomMargin = aqnm.dpToPx(i);
      QZoneMsgFragment.a(this.this$0).setLayoutParams(localLayoutParams);
      QZoneMsgFragment.a(this.this$0).updateData(this.fr);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.6
 * JD-Core Version:    0.7.0.1
 */