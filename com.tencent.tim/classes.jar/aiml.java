import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

class aiml
  implements View.OnClickListener
{
  aiml(aimk paramaimk) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    aevs localaevs = (aevs)aimk.a(this.a).getItem(i);
    if (localaevs == null) {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    Map localMap;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMap = aimk.a(this.a).aa();
    } while (aimk.a(this.a) == null);
    aimq localaimq = new aimq();
    localaimq.bCg = false;
    localaimq.WP = localaevs.WP;
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(Long.valueOf(localaevs.WP));
    }
    if (localInteger == null) {}
    for (i = 0;; i = localInteger.intValue())
    {
      localaimq.position = i;
      if ((paramView instanceof RedTouch)) {
        localaimq.redPointType = aims.b((RedTouch)paramView);
      }
      aimk.a(this.a).a(paramView, localaevs, localaimq);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiml
 * JD-Core Version:    0.7.0.1
 */