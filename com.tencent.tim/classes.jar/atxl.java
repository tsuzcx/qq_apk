import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class atxl
  implements View.OnClickListener
{
  atxl(Activity paramActivity, String paramString, audx.d paramd) {}
  
  public void onClick(View paramView)
  {
    audx.a(this.val$activity, this.bIW, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxl
 * JD-Core Version:    0.7.0.1
 */