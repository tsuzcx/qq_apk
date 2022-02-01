import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afmo
  implements View.OnClickListener
{
  afmo(afmn paramafmn) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - afmn.a(this.this$0) > 1000L)
    {
      afmn.a(this.this$0, l);
      Bundle localBundle = new Bundle();
      localBundle.putInt("AECAMERA_MODE", 202);
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", axcg.i.getId());
      axcj.b((BaseActivity)this.this$0.a.context, 120, localBundle);
      anot.a(((BaseActivity)this.this$0.a.context).app, "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmo
 * JD-Core Version:    0.7.0.1
 */