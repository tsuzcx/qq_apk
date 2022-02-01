import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ulk
  implements View.OnClickListener
{
  ulk(ulh paramulh) {}
  
  public void onClick(View paramView)
  {
    ulh.a(this.a).deleteEmoticonClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulk
 * JD-Core Version:    0.7.0.1
 */