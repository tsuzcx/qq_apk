import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MusicSharePlayActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class cjs
  implements View.OnClickListener
{
  public cjs(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    paramView = QQPlayerService.a();
    int i;
    if (paramView != null)
    {
      BannerManager.a(this.a).startActivity(paramView);
      paramView = paramView.getComponent().getClassName();
      if (!paramView.equals(MusicSharePlayActivity.class.getName())) {
        break label92;
      }
      i = 0;
    }
    for (;;)
    {
      ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "Msg_tab", "Mt_music_tips", 0, 0, "" + i, "", "", "");
      return;
      label92:
      if (paramView.equals(MusicGeneQQBrowserActivity.class.getName())) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cjs
 * JD-Core Version:    0.7.0.1
 */