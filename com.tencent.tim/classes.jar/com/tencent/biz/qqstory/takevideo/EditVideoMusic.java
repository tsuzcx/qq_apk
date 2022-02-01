package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase.a;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Music;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import ram;
import ras;
import raz;
import rbl;
import rcy;
import rcz;
import rdb;
import rdb.a;
import rdc;
import rdo;
import reh.a;
import reh.b;
import rek;
import rjz;
import rkc;
import rkm;
import rmw;
import rmw.a;
import rox;
import ylo;

public class EditVideoMusic
  extends rdb
  implements AudioPlayerBase.a, rbl
{
  protected TakePhotoMusicTimerTask a;
  reh.b a;
  private boolean aGW;
  private boolean aGX;
  private boolean aGY;
  boolean aGZ = false;
  boolean aHa = false;
  private boolean aHb;
  public SparseArray<rkc> aW;
  protected AudioPlayer b;
  private int bqn;
  int bqo = 0;
  private AudioManager mAudioManager;
  protected boolean mIsResume;
  protected boolean mIsTakePhoto;
  protected Handler mUIHandler = new rcz(this);
  public ArrayList<rkc> nu;
  protected Timer p;
  
  public EditVideoMusic(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  private rkc a(reh.b paramb)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramb.azO);
      localJSONObject.put("audio_url", paramb.azP);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramb.musicId);
      return new rkc(localJSONObject.toString());
    }
    catch (JSONException paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
      }
    }
  }
  
  private void aEV()
  {
    if (this.aGX) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((rkc)localObject).equals(rkc.f)))
    {
      localObject = (rdo)this.jdField_b_of_type_Rdc.a(rdo.class);
      if (localObject != null) {
        ((rdo)localObject).tt(this.aGW);
      }
      VideoSourceHelper.nativeSetPlayAFMute(this.aGW);
      return;
    }
    if (this.aGW)
    {
      bsS();
      return;
    }
    bsi();
  }
  
  private void bsU()
  {
    if (this.aGY)
    {
      QQToast.a(getContext(), "GIF不支持添加音乐", 0).show();
      return;
    }
    this.jdField_b_of_type_Rdc.changeState(2);
  }
  
  public boolean KZ()
  {
    if (this.jdField_a_of_type_Reh$b == null) {}
    while (this.jdField_a_of_type_Reh$b.musicType != 2) {
      return true;
    }
    return false;
  }
  
  public rkc a()
  {
    if (this.aW != null) {
      return (rkc)this.aW.get(this.jdField_b_of_type_Rdc.tj());
    }
    return null;
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    super.a(paramInt, paramrkm);
    rkc localrkc = (rkc)this.aW.get(paramInt);
    if (localrkc == null)
    {
      ram.w("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && ((this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer.a() instanceof AmrPlayer)) && (localrkc.start - 1000 > 0)) {
      localrkc.start -= 1000;
    }
    paramrkm.g.backgroundMusicPath = localrkc.aAR;
    Object localObject1 = paramrkm.g;
    if (localrkc.musicType != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramrkm.g.backgroundMusicOffset = localrkc.start;
      paramrkm.g.backgroundMusicDuration = ((int)this.jdField_b_of_type_Rdc.x(paramInt));
      if (!TextUtils.isEmpty(localrkc.aAR)) {
        ram.w("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(rox.checkFileExist(localrkc.aAR)), localrkc.aAR });
      }
      switch (localrkc.musicType)
      {
      default: 
        ram.w("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localrkc.musicType == 2)
    {
      localObject1 = "1";
      rdc localrdc = this.jdField_b_of_type_Rdc;
      paramInt = this.jdField_b_of_type_Rdc.tk();
      String str = localrkc.title;
      if (!this.mIsTakePhoto) {
        break label423;
      }
      localObject2 = "2";
      label298:
      localrdc.d("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label431;
      }
      localObject1 = "0X80076E6";
      label343:
      ras.g((String)localObject1, String.valueOf(ras.bpq), "", localrkc.title, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localrkc.title;
      if (localrkc.musicType != 3) {
        break label439;
      }
    }
    label423:
    label431:
    label439:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramrkm.a.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label298;
      localObject1 = "0X80076E5";
      break label343;
    }
    this.jdField_b_of_type_Rdc.d("sound_off", this.jdField_b_of_type_Rdc.tk(), 0, new String[0]);
    ras.bv("0X80076E7", ras.bpq);
    paramrkm.a.isSoundOn = false;
    return;
    this.jdField_b_of_type_Rdc.d("sound_on", this.jdField_b_of_type_Rdc.tk(), 0, new String[0]);
    ras.so("0X80076E8");
    paramrkm.a.isSoundOn = true;
    return;
    paramrkm = new Properties();
    paramrkm.setProperty("bless_param_voice_id", "" + localrkc.changeType);
    ylo.c("bless_event_voice_result", paramrkm);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void a(reh.a parama)
  {
    rkc localrkc = a();
    if (localrkc == null)
    {
      parama.aHk = false;
      return;
    }
    if ((localrkc.musicType != 2) && (localrkc.musicType != 3))
    {
      parama.aHk = false;
      return;
    }
    switch (localrkc.musicType)
    {
    }
    for (;;)
    {
      try
      {
        parama.BP = Long.valueOf(localrkc.id).longValue();
        parama.aHk = true;
        return;
      }
      catch (Exception localException)
      {
        ram.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localrkc.title, localrkc.id });
        parama.aHk = false;
      }
      parama.musicType = 0;
      continue;
      parama.musicType = 1;
    }
  }
  
  public void a(rkc paramrkc)
  {
    rkc localrkc = null;
    if (paramrkc != null)
    {
      localrkc = new rkc();
      localrkc.g(paramrkc);
      if (paramrkc.musicType != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.aGX = bool;
      this.aW.put(this.jdField_b_of_type_Rdc.tj(), localrkc);
      return;
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void bsR()
  {
    this.jdField_a_of_type_Reh$b = null;
    this.aHa = false;
    rdb.a locala = a(rek.class);
    if (locala != null) {
      ((rek)locala).xe(this.jdField_b_of_type_Rdc.tj());
    }
  }
  
  public void bsS()
  {
    if (this.p != null)
    {
      this.p.cancel();
      this.p = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask.cancel();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer.stop();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "stopClipMusic()");
      }
    }
  }
  
  public void bsT()
  {
    this.jdField_b_of_type_Rdc.a(Message.obtain(null, 3, 2, 0));
  }
  
  public void bsg()
  {
    wZ(-1);
  }
  
  public void bsh()
  {
    if (this.mIsTakePhoto) {
      bsS();
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) || (!this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer.isPlaying()));
      this.bqo = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer.getCurrentPosition();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer.stop();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "pauseClipMusic()");
  }
  
  public void bsi()
  {
    if (this.mIsTakePhoto)
    {
      bsg();
      return;
    }
    wZ(this.bqo);
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool3;
    switch (paramInt2)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    default: 
      return;
    case 2: 
      ras.bv("0X80076BB", ras.bpq);
      bool3 = paramObject instanceof reh.b;
      paramObject = a(rek.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((rek)paramObject).a(this.jdField_b_of_type_Rdc.tj());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.type == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(getContext(), this, this.mIsTakePhoto, (int)this.jdField_b_of_type_Rdc.x(this.jdField_b_of_type_Rdc.tj()), this.jdField_b_of_type_Rdc.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new rcy(this));
      paramObject.setCancelable(true);
      paramObject.show();
      return;
      bsh();
      return;
      if ((this.mIsTakePhoto) && (a() == null)) {
        wY(0);
      }
      if (paramInt1 != 6) {
        break;
      }
      bsi();
      return;
    }
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void e(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_b_of_type_Rdc.f(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public boolean e(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    rkc localrkc;
    label97:
    rdo localrdo;
    do
    {
      do
      {
        for (;;)
        {
          return super.e(paramMessage);
          this.mUIHandler.post(new EditVideoMusic.2(this));
        }
      } while (paramMessage.arg1 != 32);
      bsU();
      return true;
      localrkc = a();
      if (localrkc == null) {
        break;
      }
      wY(localrkc.musicType);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((rkc.e.equals(localrkc)) || (rkc.f.equals(localrkc))) {
        bsS();
      }
      localrdo = (rdo)a(rdo.class);
    } while (localrdo == null);
    if (!rkc.f.equals(localrkc)) {}
    for (;;)
    {
      localrdo.tt(bool);
      break;
      wY(1);
      break label97;
      bool = false;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, new Object[] { "doOnActivityResult selectMusic(), selected:", Boolean.valueOf(this.aHb), " data:", paramIntent });
      }
    } while (this.aHb);
    paramIntent = a();
    if ((paramIntent != null) && ((paramIntent.musicType == 0) || (paramIntent.musicType == 1))) {
      getContext().sendBroadcast(new Intent("action_music_refresh_list"));
    }
    startPlayer();
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mIsTakePhoto = this.jdField_b_of_type_Rdc.La();
    Object localObject3 = null;
    String str = this.jdField_b_of_type_Rdc.a.getStringExtra("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Reh$b = ((reh.b)JsonORM.parseFrom(new JSONObject(str), reh.b.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Reh$b != null)
      {
        if (this.jdField_a_of_type_Reh$b.musicType != 0) {
          break label211;
        }
        localObject1 = localObject3;
        if (rjz.aC(getContext()))
        {
          localObject1 = rjz.a(getContext(), this.jdField_a_of_type_Reh$b.musicId);
          ram.d("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_Reh$b.musicId, localObject1);
        }
      }
      if (localObject1 != null)
      {
        bool = true;
        this.aHa = bool;
        if (this.aW != null) {
          break label335;
        }
        this.aW = new SparseArray(6);
        i = 0;
        for (;;)
        {
          if (i >= 6) {
            break label335;
          }
          if (localObject1 == null) {
            break;
          }
          this.aW.put(i, localObject1);
          i += 1;
        }
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        ram.w("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      label211:
      Object localObject2;
      for (;;)
      {
        boolean bool;
        int i;
        ram.w("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_Reh$b.musicType == 1)
        {
          localObject2 = a(this.jdField_a_of_type_Reh$b);
          ram.d("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Reh$b.musicId, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Reh$b.musicType == 2)
          {
            localObject2 = a(this.jdField_a_of_type_Reh$b);
            ram.d("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Reh$b.musicId, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_b_of_type_Rdc.La()) {
              this.aW.put(i, rkc.e);
            } else {
              this.aW.put(i, rkc.f);
            }
          }
        }
      }
      label335:
      if ((localObject2 == null) && (this.jdField_b_of_type_Rdc.La()))
      {
        a(rkc.e);
        wY(0);
      }
      a(rbl.class, this);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    wY(1);
    bsS();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mIsResume = false;
    bsS();
    if (this.bqn > 0) {
      this.mAudioManager.setStreamVolume(3, this.bqn, 0);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.mIsResume = true;
    aEV();
  }
  
  public void resetPlay()
  {
    this.jdField_b_of_type_Rdc.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void setMuteState(boolean paramBoolean)
  {
    this.aGW = paramBoolean;
    aEV();
  }
  
  public void st(String paramString)
  {
    rkc localrkc = a();
    if (localrkc != null)
    {
      localrkc.aAR = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        ram.w("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(rox.checkFileExist(paramString)), paramString });
      }
    }
  }
  
  public void startPlayer()
  {
    this.jdField_b_of_type_Rdc.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void tB(boolean paramBoolean)
  {
    this.aGY = paramBoolean;
  }
  
  public void tC(boolean paramBoolean)
  {
    this.aHb = paramBoolean;
  }
  
  public void wY(int paramInt)
  {
    raz localraz = (raz)a(raz.class);
    if (localraz != null)
    {
      if (paramInt == 0) {
        localraz.wO(2130847531);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localraz.wO(2130847530);
      return;
    }
    localraz.wO(2130847524);
  }
  
  public void wZ(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "playBgMusic()");
    }
    rkc localrkc = a();
    if ((!this.mIsResume) || (this.aGW) || (localrkc == null))
    {
      ram.d("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    bsS();
    if (this.jdField_b_of_type_Rdc.bqq == 6)
    {
      ram.d("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localrkc.aAR)) || (localrkc.musicType == 0) || (localrkc.musicType == 1))
    {
      ram.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localrkc.aAR, Integer.valueOf(localrkc.musicType));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer = new EditVideoMusic.3(this, getContext(), this, localrkc);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer.setAudioStream(3);
    if (paramInt >= 0) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer.seekPlay(localrkc.aAR, paramInt);
    }
    for (;;)
    {
      if (this.mIsTakePhoto)
      {
        this.p = new Timer();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask = new TakePhotoMusicTimerTask(null);
        this.p.schedule(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask, 5000L, 5000L);
      }
      getContext().sendBroadcast(new Intent("action_music_start"));
      return;
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayer.seekPlay(localrkc.aAR, localrkc.start);
    }
  }
  
  class TakePhotoMusicTimerTask
    extends TimerTask
  {
    private TakePhotoMusicTimerTask() {}
    
    public void run()
    {
      EditVideoMusic.this.mUIHandler.sendEmptyMessage(1001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */