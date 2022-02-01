import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class xar
  implements View.OnClickListener
{
  private long IP;
  
  xar(xaq paramxaq) {}
  
  public void onClick(View paramView)
  {
    Resources localResources = paramView.getContext().getResources();
    long l = SystemClock.uptimeMillis();
    if (l - this.IP >= 500L)
    {
      this.IP = l;
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof JSONObject))) {
        break label56;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label56:
      Object localObject2 = (JSONObject)paramView.getTag();
      String str2;
      Context localContext;
      try
      {
        String str1 = ((JSONObject)localObject2).getString("url");
        str2 = ((JSONObject)localObject2).getString("name");
        localContext = paramView.getContext();
        if (this.this$0.app != null) {
          MediaPlayerManager.a(this.this$0.app).stop(true);
        }
        if (!QQPlayerService.a(this.this$0)) {
          break label164;
        }
        QQPlayerService.eG(localContext);
        paramView.setContentDescription(localResources.getString(2131690639));
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel())
      {
        QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(localException));
        continue;
        label164:
        if ((this.this$0.app != null) && (this.this$0.app.bF()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("CommonHobbyForAIOShowItemBuilder", 0, "Video Chatting is going on, don't play music.");
          }
        }
        else
        {
          SongInfo localSongInfo = new SongInfo();
          localSongInfo.url = localException;
          localSongInfo.type = 4;
          QQPlayerService.ag(new Intent(localContext, MusicPlayerActivity.class));
          localObject2 = QQPlayerService.getExtras();
          Object localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new Bundle();
            QQPlayerService.setExtras((Bundle)localObject1);
          }
          ((Bundle)localObject1).putString("KEY_SOURCE_NAME", str2);
          QQPlayerService.a(this.this$0);
          QQPlayerService.a(localContext, this.this$0.getToken(), localSongInfo);
          paramView.setContentDescription(localResources.getString(2131690637));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xar
 * JD-Core Version:    0.7.0.1
 */