import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class amtv
  implements View.OnClickListener
{
  amtv(amtn paramamtn, amyv paramamyv, int paramInt, Context paramContext, boolean paramBoolean, SongInfo paramSongInfo, amqv paramamqv) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    Object localObject = this.a.Dz;
    ((ImageView)localObject).setTag(Integer.valueOf(this.val$position));
    amtn.a(this.this$0, new WeakReference(localObject));
    if ((QQPlayerService.getPlayState() == 2) && (amtn.a(this.this$0) == amxk.akn))
    {
      QQPlayerService.eG(this.val$context);
      amxk.akn = -1L;
      ((ImageView)localObject).clearAnimation();
      if (this.avT)
      {
        ((ImageView)localObject).setImageResource(2130850617);
        i = 0;
      }
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      JSONObject localJSONObject;
      if (amkl.mT.containsKey(this.b))
      {
        localObject = (amkl.a)amkl.mT.get(this.b);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("project", amub.zn());
        localJSONObject.put("event_src", "client");
        localJSONObject.put("obj_lct", ((amkl.a)localObject).index);
        localJSONObject.put("get_src", "web");
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528();
        if ((this.val$context instanceof UniteSearchActivity))
        {
          localObject = "all_result";
          localReportModelDC02528 = localReportModelDC02528.module((String)localObject);
          if (i == 0) {
            break label507;
          }
          localObject = "play_music";
          amub.a(null, localReportModelDC02528.action((String)localObject).obj1(this.b.ajO + "").obj2(this.b.id).ver1(UniteSearchActivity.caM).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            ((ImageView)localObject).setImageResource(2130850616);
            i = 0;
            break;
            localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if ((localObject == null) || (!((QQAppInterface)localObject).bF())) {
              break label374;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QQPlayerService", 2, "Video Chatting is going on, don't play music.");
            }
          }
          label374:
          localObject = new Intent(this.val$context, MusicPlayerActivity.class);
          ((Intent)localObject).putExtra("url", this.j.url);
          ((Intent)localObject).putExtra("param_force_internal_browser", true);
          QQPlayerService.ag((Intent)localObject);
          if (QQPlayerService.getExtras() == null) {
            QQPlayerService.setExtras(new Bundle());
          }
          QQPlayerService.a(this.this$0);
          QQPlayerService.setPlayMode(101);
          QQPlayerService.a(this.val$context, QQPlayerService.getToken(), new SongInfo[] { this.j });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + localJSONException);
          continue;
          String str = "subweb_search";
          continue;
          label507:
          str = "pause_music";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtv
 * JD-Core Version:    0.7.0.1
 */