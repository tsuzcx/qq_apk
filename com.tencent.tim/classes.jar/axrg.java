import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class axrg
  extends aygy
  implements View.OnClickListener, axri, aydu
{
  private axro a = (axro)axov.a().c(8);
  private long aCv = -1L;
  private boolean dwi;
  private boolean isPause;
  private boolean tL = true;
  
  public axrg(@NonNull aygz paramaygz, boolean paramBoolean)
  {
    super(paramaygz);
    this.dwi = paramBoolean;
  }
  
  private Bundle E()
  {
    Bundle localBundle = null;
    if (this.b.bQ != null) {
      localBundle = this.b.bQ.getBundle("container");
    }
    return localBundle;
  }
  
  private MusicItemInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = E();
    if (localObject1 != null) {}
    for (localObject1 = ((Bundle)localObject1).getBundle(MusicProviderView.class.getSimpleName());; localObject1 = null)
    {
      MusicItemInfo localMusicItemInfo;
      boolean bool;
      if (localObject1 != null)
      {
        localMusicItemInfo = (MusicItemInfo)((Bundle)localObject1).getParcelable("select_music");
        localObject2 = ((Bundle)localObject1).getString("select_music_local_path");
        bool = ((Bundle)localObject1).getBoolean("select_mute");
        if (localMusicItemInfo == null) {
          break label111;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localMusicItemInfo.setPath((String)localObject2);
        }
        localObject2 = localMusicItemInfo;
        if (QLog.isColorLevel())
        {
          QLog.i("EditVideoQimMusic", 2, "restore music" + localMusicItemInfo.mMusicName);
          localObject2 = localMusicItemInfo;
        }
      }
      label111:
      do
      {
        return localObject2;
        localObject2 = localMusicItemInfo;
      } while (!bool);
      localObject1 = new MusicItemInfo();
      ((MusicItemInfo)localObject1).mType = 3;
      ((MusicItemInfo)localObject1).mItemId = -2;
      return localObject1;
    }
  }
  
  private void a(int paramInt, ayqb paramayqb, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = paramayqb.g.getBooleanExtra("isMixOriginal", this.dwi);
    if (paramMusicItemInfo != null)
    {
      paramayqb.g.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.b.aQB()) {
        i = Math.min(j, (int)this.b.x(paramInt));
      }
      paramayqb.g.backgroundMusicDuration = i;
      paramayqb.g.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      PublishVideoEntry localPublishVideoEntry = paramayqb.g;
      if (!bool)
      {
        bool = true;
        localPublishVideoEntry.isMuteRecordVoice = bool;
        paramayqb.g.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
        paramayqb.g.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
        paramayqb.g.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
        paramayqb.g.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramMusicItemInfo = this.a.c();
    } while ((paramMusicItemInfo == null) || ((paramMusicItemInfo.mType != 3) && (!paramMusicItemInfo.isDownloading())));
    paramayqb.g.backgroundMusicPath = null;
  }
  
  private void b(int paramInt, @NonNull ayqb paramayqb, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null) {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        paramayqb.g.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.b.x(paramInt));
        paramayqb.g.backgroundMusicDuration = paramInt;
        paramayqb.g.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
        paramayqb.g.isMuteRecordVoice = true;
      }
    }
    do
    {
      return;
      paramayqb.g.backgroundMusicOffset = 0;
      paramayqb.g.backgroundMusicDuration = ((int)this.b.x(paramInt));
      break;
      paramMusicItemInfo = this.a.c();
    } while ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType != 3));
    paramayqb.g.backgroundMusicPath = null;
    paramayqb.g.isMuteRecordVoice = true;
  }
  
  public void YS(boolean paramBoolean)
  {
    ayhm localayhm = (ayhm)this.b.a(ayhm.class);
    if (localayhm != null) {
      localayhm.tt(paramBoolean);
    }
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    if (this.a == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = this.a.b();
    if ((this.b.a != null) && (this.b.a.asi == 14))
    {
      a(paramInt, paramayqb, localMusicItemInfo);
      return;
    }
    b(paramInt, paramayqb, localMusicItemInfo);
  }
  
  public void a(ayic.a parama)
  {
    MusicItemInfo localMusicItemInfo = b();
    if (localMusicItemInfo == null)
    {
      parama.aHk = false;
      return;
    }
    if ((localMusicItemInfo.mType != 5) && (localMusicItemInfo.mType != 1))
    {
      parama.aHk = false;
      return;
    }
    switch (localMusicItemInfo.mType)
    {
    }
    for (;;)
    {
      try
      {
        parama.BP = localMusicItemInfo.mItemId;
        parama.aHk = true;
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EditVideoQimMusic", 2, "music id is error: title:" + localMusicItemInfo.mMusicName + ", id:" + localMusicItemInfo.mItemId);
        parama.aHk = false;
      }
      parama.musicType = 0;
      continue;
      parama.musicType = 1;
    }
  }
  
  @Nullable
  public MusicItemInfo b()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.b();
  }
  
  public void bsg()
  {
    if (this.a == null) {}
    do
    {
      return;
      if (!this.isPause) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.isPause);
    return;
    this.a = ((axro)axov.a().c(8));
    MusicItemInfo localMusicItemInfo2;
    if (this.tL)
    {
      this.tL = false;
      localMusicItemInfo2 = a();
      localMusicItemInfo1 = localMusicItemInfo2;
      if (localMusicItemInfo2 == null) {
        this.a.eOq();
      }
    }
    for (MusicItemInfo localMusicItemInfo1 = localMusicItemInfo2;; localMusicItemInfo1 = this.a.b())
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.aCv + " currentTime=" + l);
      }
      this.a.a(localMusicItemInfo1, true, this.b.RS());
      return;
    }
  }
  
  public void bsh()
  {
    if (this.a != null) {
      this.a.Zx();
    }
  }
  
  public void bsi()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "resumeClipMusic isPause=" + this.isPause);
    }
    if ((this.a == null) || (this.isPause)) {
      return;
    }
    this.a.resumeMusic();
  }
  
  public void onClick(View paramView)
  {
    this.b.changeState(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate()
  {
    super.onCreate();
    a(aydu.class, this);
    if (this.a != null)
    {
      this.a.a(this);
      this.a.YV(this.dwi);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.a(null);
    this.a = null;
  }
  
  public void onPause()
  {
    super.onPause();
    this.isPause = true;
    if (this.a != null) {
      this.a.Zx();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.isPause = false;
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "onResume");
    }
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void seekTo(long paramLong)
  {
    if (this.a == null) {}
    while (this.a.b() == null) {
      return;
    }
    this.a.seekTo(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axrg
 * JD-Core Version:    0.7.0.1
 */