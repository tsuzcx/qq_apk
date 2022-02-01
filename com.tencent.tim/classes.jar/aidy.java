import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aidy
  implements View.OnClickListener
{
  aidy(aidx paramaidx) {}
  
  public void onClick(View paramView)
  {
    aiem.a.cG(31, null);
    aida.a(aidx.a(this.a).getApplicationContext(), this.a.pluginPackageName).cancel();
    aidx.a(this.a).finish();
    aidx.a(this.a).opType("huiyin").opName("loading_close").d1(String.valueOf(aqiw.isWifiEnabled(aidx.a(this.a).getApplicationContext()))).d2(String.valueOf(aidx.a(this.a))).report();
    if (aidx.a(this.a) == 1)
    {
      if (aqiw.isWifiEnabled(aidx.a(this.a).getApplicationContext())) {
        break label149;
      }
      aidx.a(this.a).opType("huiyin").opName("plugin_download_close").report();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label149:
      aidx.a(this.a).opType("huiyin").opName("plugin_download_loading_close").report();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidy
 * JD-Core Version:    0.7.0.1
 */