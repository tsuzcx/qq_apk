import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aied
  implements View.OnClickListener
{
  aied(aiec paramaiec) {}
  
  public void onClick(View paramView)
  {
    this.a.a.mAction = "download";
    aidx.a(this.a.a).opType("huiyin").opName("plugin_download_click").d1(String.valueOf(aqiw.isWifiEnabled(aidx.a(this.a.a).getApplicationContext()))).report();
    aidx.a(this.a.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aied
 * JD-Core Version:    0.7.0.1
 */