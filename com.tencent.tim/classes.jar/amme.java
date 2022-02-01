import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amme
  implements View.OnClickListener
{
  amme(ammd paramammd, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.b.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.caS);
    this.a.b.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amme
 * JD-Core Version:    0.7.0.1
 */