import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class aiec
  implements aidc
{
  aiec(aidx paramaidx) {}
  
  public void I(int paramInt, Bundle paramBundle)
  {
    if ((aidx.a(this.a).isFinishing()) && (!this.a.ckf)) {}
    do
    {
      return;
      if ((!aidx.a(this.a)) || (this.a.ckf)) {
        break;
      }
    } while ((paramInt != 8) && (paramInt != 7));
    aidx.a(this.a).finish();
    this.a.m.dismiss();
    return;
    aidx.a(this.a, paramInt);
    aidx.a(this.a).setVisibility(8);
    aidx.a(this.a).setVisibility(8);
    aidx.a(this.a).setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      aidx.a(this.a).setVisibility(4);
      aidx.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      if (aidx.b(this.a))
      {
        aidx.a(this.a).setVisibility(0);
        aidx.a(this.a).setVisibility(0);
        aidx.a(this.a).setText(acfp.m(2131707316));
        localObject = acfp.m(2131707319);
        paramBundle = (Bundle)localObject;
        if (aidx.a(this.a) != 0L) {
          paramBundle = (String)localObject + "(" + aicm.formatSize(aidx.a(this.a)) + ")";
        }
        aidx.a(this.a).setText(paramBundle);
        aidx.a(this.a).setOnClickListener(new aied(this));
      }
      Log.i("huiyin.loading", "checkVersion? " + aidx.b(this.a) + "checkversion ok " + aidx.a(this.a));
      return;
    case 1: 
      aidx.a(this.a).setVisibility(0);
      paramInt = paramBundle.getInt("key_progress", 0);
      aidx.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      aidx.a(this.a).setProgress(paramInt);
      paramBundle = aicm.formatSize(aidx.a(this.a) * paramInt / 100L);
      localObject = aicm.formatSize(aidx.a(this.a));
      aidx.b(this.a).setText(paramBundle + "/" + (String)localObject);
      Log.i("huiyin.loading", "downloading... " + paramInt);
      return;
    case 2: 
      aidx.a(this.a).setVisibility(0);
      aidx.b(this.a).setText(acfp.m(2131707320));
      paramBundle = Message.obtain();
      paramBundle.arg1 = 10;
      aidx.a(this.a).sendMessage(paramBundle);
      Log.i("huiyin.loading", "download complete");
      if (aidx.b(this.a) != 0L)
      {
        localObject = aidx.a(this.a).opType("huiyin").opName("plugin_download_loading_view");
        if (!aqiw.isWifiConnected(aidx.a(this.a).getApplicationContext())) {
          break label670;
        }
      }
      for (paramBundle = "3";; paramBundle = "2")
      {
        ((IVPluginDataReporter)localObject).d1(paramBundle).d2(String.valueOf(System.currentTimeMillis() - aidx.b(this.a))).d3(String.valueOf(this.a.ckf)).report();
        aiem.a.cG(50, null);
        return;
      }
    case 3: 
      aiem.a.cG(41, null);
      aidx.a(this.a).setVisibility(4);
      aidx.a(this.a).setVisibility(0);
      localObject = acfp.m(2131707318);
      paramBundle = (Bundle)localObject;
      if (aidx.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + aicm.formatSize(aidx.a(this.a)) + ")";
      }
      aidx.a(this.a).setText(paramBundle);
      if (!aqiw.isNetworkAvailable(aidx.a(this.a).getApplicationContext()))
      {
        aidx.a(this.a).setVisibility(0);
        aidx.a(this.a).setText(acfp.m(2131707313));
      }
      aidx.a(this.a).opType("huiyin").opName("download_result").d1("1").d2(String.valueOf(aqiw.isWifiEnabled(aidx.a(this.a).getApplicationContext()))).report();
      aidx.a(this.a).setOnClickListener(new aiee(this));
      Log.i("huiyin.loading", "download fail");
      return;
    case 5: 
    case 7: 
      aidx.a(this.a).setVisibility(4);
      localObject = acfp.m(2131707312);
      paramBundle = (Bundle)localObject;
      if (aidx.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + aicm.formatSize(aidx.a(this.a)) + ")";
      }
      aidx.a(this.a).setText(paramBundle);
      aidx.a(this.a).setOnClickListener(new aief(this));
      Log.i("huiyin.loading", "preload or load fail");
      aidx.a(this.a).opType("huiyin").opName("launch_result").d1("1").report();
      aiem.a.cG(51, null);
      return;
    case 4: 
      aidx.a(this.a).setVisibility(0);
      aidx.b(this.a).setText(acfp.m(2131707317));
      return;
    case 6: 
      aidx.a(this.a).setVisibility(0);
      aidx.b(this.a, 90);
      aidx.a(this.a).setProgress(90);
      aidx.b(this.a).setText(acfp.m(2131707314));
      Log.i("huiyin.loading", "load complete");
      return;
    case 9: 
      label670:
      if (this.a.m != null) {
        this.a.m.dismiss();
      }
      aidx.a(this.a).finish();
      aiem.a.cG(61, null);
      return;
    }
    aidx.a(this.a).setVisibility(0);
    aidx.b(this.a, 100);
    aidx.a(this.a).setProgress(100);
    Log.i("huiyin.loading", "launch complete");
    aidx.a(this.a).finish();
    Object localObject = aidx.a(this.a).opType("huiyin").opName("launch_result").d1("0").d2(String.valueOf(System.currentTimeMillis() - aidx.c(this.a)));
    if (this.a.ckf) {}
    for (paramBundle = "1";; paramBundle = "2")
    {
      ((IVPluginDataReporter)localObject).d4(paramBundle).report();
      aiem.a.cG(60, String.valueOf(System.currentTimeMillis() - aidx.c(this.a)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiec
 * JD-Core Version:    0.7.0.1
 */