import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class amjj
  implements View.OnClickListener
{
  amjj(amji paramamji, View paramView1, amof.a parama, View paramView2, String paramString, List paramList) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (((this.GL.getTag() instanceof Long)) && (l - ((Long)this.GL.getTag()).longValue() < 400L))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.GL.setTag(Long.valueOf(l));
    if (this.a.jumpUrl.equals("mqqapi://contact/search_might_know")) {
      anot.a(null, "dc00898", "", "", "0X800A336", "0X800A336", 0, 0, "", "", "", "");
    }
    Object localObject1;
    int i;
    if (!TextUtils.isEmpty(this.a.jumpUrl))
    {
      localObject1 = this.a.jumpUrl;
      if (MiniAppLauncher.isMiniAppUrl((String)localObject1)) {
        if (this.a.dDd == 103)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_refer", 4001);
          PublicFragmentActivity.start(paramView.getContext(), (Intent)localObject1, MiniAppSearchFragment.class);
          i = 0;
          label172:
          if (this.a.dDd == 1)
          {
            if (i == 0) {
              break label641;
            }
            MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "click", "2");
          }
        }
      }
    }
    for (;;)
    {
      if (this.GM.getVisibility() == 0)
      {
        this.GM.setVisibility(8);
        aqmj.dT(this.a.dDd, this.val$uin);
      }
      amxk.b("home_page", "clk_entry", new String[] { this.a.title, String.valueOf(this.this$0.bms), String.valueOf(this.FC.size()) });
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_entry").ver2(amub.eZ(this.this$0.bms)).ver3(this.FC.size() + "").ver4(this.a.title).ver7("{experiment_id:" + amub.cce + "}"));
      amub.a(amji.a(this.this$0), 0, SearchEntryFragment.jf(this.this$0.bms), "0X8009D1C", 0, 0, this.a.title, null);
      break;
      MiniAppLauncher.startMiniApp(amji.a(this.this$0), (String)localObject1, 2005, null);
      i = 1;
      break label172;
      Object localObject2;
      if ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://")))
      {
        localObject2 = new Intent(amji.a(this.this$0), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        amji.a(this.this$0).startActivity((Intent)localObject2);
        i = 0;
        break label172;
      }
      if ((amji.a(this.this$0) instanceof BaseActivity))
      {
        localObject2 = aqik.c(((BaseActivity)paramView.getContext()).app, amji.a(this.this$0), (String)localObject1);
        if (localObject2 != null) {
          ((aqhv)localObject2).ace();
        }
        for (;;)
        {
          i = 0;
          break;
          amji.a(this.this$0).startActivity(new Intent(amji.a(this.this$0), JumpActivity.class).setData(Uri.parse((String)localObject1)));
        }
      }
      amji.a(this.this$0).startActivity(new Intent(amji.a(this.this$0), JumpActivity.class).setData(Uri.parse((String)localObject1)));
      i = 0;
      break label172;
      label641:
      MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "click", "1");
      continue;
      i = this.this$0.bms;
      if (this.this$0.bms == 3) {
        i = 21;
      }
      ActiveEntitySearchActivity.a(amji.a(this.this$0), this.a.title, this.a.at, i);
      if (aqiw.isNetworkAvailable(amji.a(this.this$0))) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjj
 * JD-Core Version:    0.7.0.1
 */