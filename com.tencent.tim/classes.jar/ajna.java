import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity.c;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ajna
  implements View.OnClickListener
{
  private ausj e;
  
  public ajna(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject5 = MusicPlayerActivity.a(this.a);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.finish();
      continue;
      anot.a(this.a.app, "CliOper", "", "", "0X800682A", "0X800682A", 0, 0, "", "", "", "");
      Object localObject4 = paramView.getTag();
      Object localObject1 = paramView.getContext();
      if ((!(localObject4 instanceof MusicPlayerActivity.c)) || (localObject1 == null)) {
        continue;
      }
      localObject4 = (MusicPlayerActivity.c)localObject4;
      localObject5 = new ArrayList();
      int i = 0;
      while (i <= 3)
      {
        ((List)localObject5).add(ausr.a(i));
        i += 1;
      }
      Object localObject6 = new ausr((Context)localObject1);
      ((ausr)localObject6).setData((List)localObject5);
      this.e = ausr.a((Context)localObject1, (ausr)localObject6, new ajnb(this, (MusicPlayerActivity.c)localObject4), null, null, true);
      this.e.show();
      continue;
      if (localObject5 == null) {
        continue;
      }
      localObject1 = alla.getString(this.a.getContentResolver(), "android_id");
      try
      {
        localObject4 = ((ajmj)localObject5).a();
        if (localObject4 == null) {
          continue;
        }
        localObject4 = MusicPlayerActivity.a(this.a, (SongInfo)localObject4);
        if (!MusicPlayerActivity.access$600().containsKey(localObject4)) {
          continue;
        }
        localObject5 = paramView.getTag();
        if (!paramView.isSelected()) {
          break label420;
        }
        anot.a(this.a.app, "CliOper", "", "", "0X8006829", "0X8006829", 0, 0, "", "", "", "");
        MusicPlayerActivity.a(this.a).b((String)localObject1, this.a.app.getLongAccountUin(), ((Long)MusicPlayerActivity.access$600().get(localObject4)).longValue(), false);
        paramView.setSelected(false);
        MusicPlayerActivity.a(this.a).setImageResource(2130842143);
        if (!(localObject5 instanceof Integer)) {
          continue;
        }
        i = ((Integer)localObject5).intValue();
        MusicPlayerActivity.a(this.a, 2130842143, i);
      }
      catch (RemoteException localRemoteException1)
      {
        QLog.e("MusicPlayerActivity", 1, "add favourite RemoteException ", localRemoteException1);
      }
      continue;
      label420:
      anot.a(this.a.app, "CliOper", "", "", "0X8006828", "0X8006828", 0, 0, "", "", "", "");
      MusicPlayerActivity.a(this.a).b(localRemoteException1, this.a.app.getLongAccountUin(), ((Long)MusicPlayerActivity.access$600().get(localObject4)).longValue(), true);
      paramView.setSelected(true);
      MusicPlayerActivity.a(this.a).setImageResource(2130842142);
      if (!(localObject5 instanceof Integer)) {
        continue;
      }
      i = ((Integer)localObject5).intValue();
      MusicPlayerActivity.a(this.a, 2130842142, i);
      continue;
      if (localObject5 == null) {
        continue;
      }
      try
      {
        switch (((ajmj)localObject5).getPlayState())
        {
        case 2: 
          localObject4 = ((ajmj)localObject5).a();
          if ((localObject4 == null) || (localObject4.length <= 0)) {
            continue;
          }
          i = ((ajmj)localObject5).Gt();
          if (i >= 0) {
            if (i < localObject4.length) {}
          }
          break;
        case 3: 
        default: 
          for (;;)
          {
            for (;;)
            {
              label568:
              localObject6 = ((ajmj)localObject5).getToken();
              if (TextUtils.isEmpty((CharSequence)localObject6)) {
                break;
              }
              ((ajmj)localObject5).a((String)localObject6, (SongInfo[])localObject4, i);
              if (localRemoteException1 == null) {
                break;
              }
              localObject4 = MusicPlayerActivity.a(this.a, localRemoteException1);
              if (!MusicPlayerActivity.S().containsKey(localObject4)) {
                break;
              }
              localObject4 = (MusicPlayerActivity.d)MusicPlayerActivity.S().get(localObject4);
              Object localObject2 = MusicPlayerActivity.a(this.a, (ajmj)localObject5, localRemoteException1, ((MusicPlayerActivity.d)localObject4).acZ);
              MusicPlayerActivity.a(this.a, (MusicPlayerActivity.d)localObject4, (String)localObject2);
              break;
              ((ajmj)localObject5).pause();
              break;
              ((ajmj)localObject5).resume();
              break;
              anot.a(this.a.app, "CliOper", "", "", "0X800682B", "0X800682B", 0, 0, "", "", "", "");
              if (ajni.U(this.a, "com.tencent.qqmusic"))
              {
                localObject4 = null;
                localObject2 = localObject4;
                if (localObject5 != null) {}
                try
                {
                  localObject2 = ((ajmj)localObject5).a();
                  if (localObject2 == null) {
                    break;
                  }
                  localObject2 = MusicPlayerActivity.a(this.a, (SongInfo)localObject2);
                  if (!MusicPlayerActivity.access$600().containsKey(localObject2)) {
                    break;
                  }
                  localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("androidqqmusic://form=webpage&mid=23&k1=0&k2=%s&download=1&action=download", new Object[] { String.valueOf(MusicPlayerActivity.access$600().get(localObject2)) })));
                  ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_qqmusic");
                  this.a.startActivity((Intent)localObject2);
                  anot.a(this.a.app, "CliOper", "", "", "0X800682C", "0X800682C", 0, 0, "", "", "", "");
                }
                catch (RemoteException localRemoteException2)
                {
                  for (;;)
                  {
                    QLog.e("MusicPlayerActivity", 1, "music player activity RemoteException ", localRemoteException2);
                    localObject3 = localObject4;
                  }
                }
              }
            }
            Object localObject3 = (ausj)auss.a(this.a, null);
            ((ausj)localObject3).setMainTitle(2131696136);
            ((ausj)localObject3).addButton(2131696138, 2);
            ((ausj)localObject3).addCancelButton(2131696135);
            ((ausj)localObject3).a(new ajnc(this, paramView, (ausj)localObject3));
            ((ausj)localObject3).show();
            break;
            localObject3 = null;
            continue;
            break label568;
            localObject3 = localObject4[0];
            i = 0;
          }
        }
      }
      catch (RemoteException localRemoteException3) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajna
 * JD-Core Version:    0.7.0.1
 */