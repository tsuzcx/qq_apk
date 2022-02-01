import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class aiea
  implements aicu.a
{
  aiea(aidx paramaidx) {}
  
  public void KU(boolean paramBoolean)
  {
    boolean bool = true;
    aidx.a(this.a, paramBoolean);
    int i;
    if (!aqiw.isWifiEnabled(aidx.a(this.a).getApplicationContext()))
    {
      i = 1;
      if (!paramBoolean) {
        break label190;
      }
      localObject = aiem.a;
      if (i != 0) {
        break label185;
      }
    }
    label185:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((aien)localObject).cG(33, String.valueOf(paramBoolean));
      aidx.a(this.a).findViewById(16908290).setVisibility(8);
      if (!aidx.a(this.a).isFinishing())
      {
        if (this.a.m != null) {
          this.a.m.dismiss();
        }
        this.a.m = new arhz(aidx.a(this.a), 40);
        this.a.m.setMessage(acfp.m(2131707310));
        this.a.m.setOnDismissListener(new aieb(this));
        this.a.m.show();
      }
      aidx.a(this.a, false);
      return;
      i = 0;
      break;
    }
    label190:
    Object localObject = aiem.a;
    if (i == 0)
    {
      paramBoolean = true;
      ((aien)localObject).cG(34, String.valueOf(paramBoolean));
      localObject = aidx.a(this.a).opType("huiyin").opName("hy_plugin_down");
      if (i != 0) {
        break label331;
      }
      paramBoolean = true;
      label237:
      ((IVPluginDataReporter)localObject).d1(String.valueOf(paramBoolean)).d2(String.valueOf(this.a.ckf)).report();
      aidx.a(this.a).findViewById(16908290).setVisibility(0);
      if (i == 0) {
        break label336;
      }
      if (!this.a.ckf) {
        aidx.a(this.a).opType("huiyin").opName("plugin_view").report();
      }
      aidx.a(this.a, true);
    }
    for (;;)
    {
      aids.report("2880338");
      return;
      paramBoolean = false;
      break;
      label331:
      paramBoolean = false;
      break label237;
      label336:
      if (!this.a.ckf) {
        aidx.a(this.a).opType("huiyin").opName("plugin_download_loading_view").d1("3").report();
      }
      aidx.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiea
 * JD-Core Version:    0.7.0.1
 */