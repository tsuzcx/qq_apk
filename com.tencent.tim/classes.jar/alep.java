import VIP.GetMusicListReq;
import VIP.GetMusicListRsp;
import VIP.GetQzoneMusicInfoReq;
import VIP.GetQzoneMusicInfoRsp;
import VIP.MusicInfo;
import VIP.MusicListInfo;
import VIP.SingerInfo;
import VIP.SourceInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.c;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController.1;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class alep
  extends aipd
  implements acci, QQPlayerService.c
{
  public static int dsH = 3;
  private alep.a a;
  private boolean bFk;
  private SongInfo[] d;
  private SongInfo l = new SongInfo();
  private boolean mIsPlay;
  private long mStartPlayTime;
  private long mUin;
  
  public alep(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aipb.ckZ = true;
    paramQQAppInterface.removeObserver(this.jdField_b_of_type_Ainv);
  }
  
  public static boolean o(long paramLong)
  {
    SongInfo localSongInfo = QQPlayerService.a();
    if ((localSongInfo != null) && (QQPlayerService.a().type == 10) && (localSongInfo.uin == paramLong)) {
      return QQPlayerService.isPlaying();
    }
    return false;
  }
  
  public void NE(boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ProfileMusicBoxController.1(this, paramBoolean));
  }
  
  public void Od(String paramString)
  {
    if ((this.app != null) && (this.app.getAccount().equalsIgnoreCase(paramString)))
    {
      this.bFk = true;
      if (!atv()) {
        break label54;
      }
      QQPlayerService.F(BaseApplicationImpl.getContext(), false);
      NE(true);
    }
    label54:
    while (TextUtils.isEmpty(paramString))
    {
      return;
      this.bFk = false;
      break;
    }
    aipd localaipd = ListenTogetherManager.a(this.app).a();
    if (localaipd != null)
    {
      this.jdField_a_of_type_Aipb.deq = localaipd.a().deq;
      this.jdField_a_of_type_Aipb.der = localaipd.a().der;
      this.jdField_a_of_type_Aipb.ckY = localaipd.a().ckY;
      if (localaipd.app()) {
        localaipd.df(localaipd.a().des, localaipd.a().bPp);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileMusicBoxController", 2, "showLyrics");
    }
    if ((TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aipb.bPp)))
    {
      super.de(dsH, this.jdField_a_of_type_Aipb.bPp);
      return;
    }
    this.cE.add(dsH + "_" + paramString);
    if (!app())
    {
      super.de(dsH, paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.apn();
      }
    }
    aogn.a().c(this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout, paramString, dsH);
  }
  
  public void Zx()
  {
    QQPlayerService.eE(BaseApplicationImpl.getContext());
    NE(false);
  }
  
  public void a(alep.a parama)
  {
    this.jdField_a_of_type_Alep$a = parama;
  }
  
  public boolean atv()
  {
    return (QQPlayerService.getPlayState() == 3) && (QQPlayerService.a() != null) && (QQPlayerService.a().type == 10) && (app());
  }
  
  public void b(long paramLong, SongInfo paramSongInfo)
  {
    this.mUin = paramLong;
    this.l = paramSongInfo;
    this.mIsPlay = o(paramLong);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramSongInfo.album);
    n(paramLong, localArrayList);
  }
  
  public void b(Context paramContext, SongInfo paramSongInfo)
  {
    if (QQPlayerService.getPlayState() == 3)
    {
      QQPlayerService.F(paramContext, false);
      NE(true);
    }
    do
    {
      return;
      new Intent(paramContext, QQBrowserActivity.class).putExtra("url", aurr.addParameter(aery.a().bAL, "uin", String.valueOf(this.mUin)));
      QQPlayerService.b(this);
      QQPlayerService.setPlayMode(103);
      QQPlayerService.a(paramContext, getToken(), new SongInfo[] { paramSongInfo }, 0, false);
      kE(this.mUin);
      Od(String.valueOf(this.mUin));
      h(paramSongInfo);
    } while (!QLog.isColorLevel());
    QLog.d("ProfileMusicBoxController", 2, "playMusic mid:" + paramSongInfo.album + " url:" + paramSongInfo.url);
  }
  
  public void dFu()
  {
    super.df(dsH, this.jdField_a_of_type_Aipb.bPp);
    this.jdField_a_of_type_Aipb.des = 0;
    u(dsH, this.jdField_a_of_type_Aipb.bPp, true);
    if (this.app != null)
    {
      aipd localaipd = ListenTogetherManager.a(this.app).a();
      if (localaipd != null)
      {
        localaipd.a().deq = this.jdField_a_of_type_Aipb.deq;
        localaipd.a().der = this.jdField_a_of_type_Aipb.der;
        localaipd.a().ckY = this.jdField_a_of_type_Aipb.ckY;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMusicBoxController", 2, "hideLyrics");
      }
    }
  }
  
  public void dFv()
  {
    SongInfo localSongInfo = QQPlayerService.f();
    Object localObject = QQPlayerService.a();
    if ((localSongInfo != null) && (localObject != null) && (localSongInfo.type == 10) && (!TextUtils.isEmpty(localSongInfo.album)) && (!localSongInfo.album.equals(((SongInfo)localObject).album)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(localSongInfo.album);
      n(this.mUin, (ArrayList)localObject);
    }
  }
  
  public void de(int paramInt, String paramString)
  {
    super.de(dsH, paramString);
    aogn.a().c(this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout, paramString, dsH);
    if ((this.app != null) && (this.app.getAccount().equalsIgnoreCase(paramString)))
    {
      this.bFk = true;
      return;
    }
    this.bFk = false;
  }
  
  public void destroy()
  {
    QQPlayerService.c(this);
    this.jdField_a_of_type_Alep$a = null;
    super.destroy();
    aogn.a().leave();
  }
  
  public void dts()
  {
    aleo.bO(this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.getContext(), this.jdField_a_of_type_Aipb.bPp);
    String str;
    if (this.bFk)
    {
      str = "";
      if (!this.bFk) {
        break label80;
      }
    }
    label80:
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", str, "qq_vip", "0X800A7DF", i, 0, "", "", "", "");
      return;
      str = String.valueOf(this.mUin);
      break;
    }
  }
  
  public void dtt()
  {
    QQPlayerService.eG(BaseApplicationImpl.getContext());
    resetState();
    String str;
    if (this.bFk)
    {
      str = "";
      if (!this.bFk) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", str, "qq_vip", "0X800A7E0", i, 0, "", "", "", "");
      return;
      str = String.valueOf(this.mUin);
      break;
    }
  }
  
  public String getToken()
  {
    return QQPlayerService.I(4, "QQMusicWrap");
  }
  
  public void h(SongInfo paramSongInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileMusicBoxController", 2, "onPlayMusicChange song.id:" + paramSongInfo.coverUrl);
    }
    this.jdField_a_of_type_Aipb.albumUrl = paramSongInfo.coverUrl;
    if (app()) {
      this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Aipb);
    }
  }
  
  public boolean isPlaying()
  {
    return this.mIsPlay;
  }
  
  public void kE(long paramLong)
  {
    new aqve("VIP.ProfileMusicBoxServer.ProfileMusicBoxObj", "ProfileMusicBox.getMusicList").a("getMusicList", new GetMusicListReq(paramLong, "", 100L, new SourceInfo(3, "3.4.4"), 0), new GetMusicListRsp(), this, false);
  }
  
  public void n(long paramLong, ArrayList<String> paramArrayList)
  {
    new aqve("VIP.ProfileMusicBoxServer.ProfileMusicBoxObj", "ProfileMusicBox.getQzoneMusicInfo").a("getQzoneMusicInfo", new GetQzoneMusicInfoReq(paramLong, paramArrayList, new SourceInfo(3, "3.4.4")), new GetQzoneMusicInfoRsp(), new aleq(this), false);
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    this.l = paramSongInfo;
    if (paramSongInfo.type == 10)
    {
      if (this.jdField_a_of_type_Alep$a != null) {
        this.jdField_a_of_type_Alep$a.a(paramSongInfo, this.mIsPlay);
      }
      dFv();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMusicBoxController", 2, "onPlaySongChanged newSong:" + paramSongInfo.title);
      }
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMusicBoxController", 2, "onPlayStateChanged playState:" + paramInt);
      }
      return;
      Object localObject = QQPlayerService.a();
      if (((SongInfo)localObject).type == 10)
      {
        if (this.jdField_a_of_type_Alep$a != null) {
          this.jdField_a_of_type_Alep$a.a((SongInfo)localObject, true);
        }
        h((SongInfo)localObject);
        if (!app()) {
          Od(String.valueOf(this.mUin));
        }
        if (this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
          this.jdField_b_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(true);
        }
        this.mIsPlay = true;
        this.mStartPlayTime = System.currentTimeMillis();
      }
      else
      {
        dFu();
        continue;
        if (this.jdField_a_of_type_Alep$a != null) {
          this.jdField_a_of_type_Alep$a.SL(2);
        }
        NE(false);
        this.mIsPlay = false;
        long l1 = this.mUin;
        if (this.bFk)
        {
          localObject = "0X800A7D9";
          label220:
          if (!aogn.a().azA()) {
            break label285;
          }
        }
        for (;;)
        {
          anot.a(null, "dc00898", "", String.valueOf(l1), "qq_vip", (String)localObject, i, 0, String.valueOf((System.currentTimeMillis() - this.mStartPlayTime) / 1000L), "", "", "");
          break;
          localObject = "0X800A7DE";
          break label220;
          label285:
          i = 2;
        }
        resetState();
        this.mIsPlay = false;
        continue;
        this.mIsPlay = false;
        localObject = QQPlayerService.a();
        if ((localObject != null) && (((SongInfo)localObject).type == 10))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(((SongInfo)localObject).album);
          n(this.mUin, localArrayList);
          continue;
          localObject = QQPlayerService.a();
          if ((localObject != null) && (TextUtils.isEmpty(((SongInfo)localObject).url)) && (((SongInfo)localObject).type == 10))
          {
            this.mIsPlay = false;
            localArrayList = new ArrayList();
            localArrayList.add(((SongInfo)localObject).album);
            n(this.mUin, localArrayList);
          }
        }
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetMusicListRsp)))
    {
      paramObject = (GetMusicListRsp)paramObject;
      ArrayList localArrayList = new ArrayList();
      this.d = new SongInfo[paramObject.stMusicList.vMusicList.size()];
      paramInt = 0;
      while (paramInt < paramObject.stMusicList.vMusicList.size())
      {
        this.d[paramInt] = new SongInfo();
        this.d[paramInt].album = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongId;
        this.d[paramInt].summary = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sAlbumName;
        this.d[paramInt].coverUrl = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sPic;
        this.d[paramInt].title = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongName;
        this.d[paramInt].duration = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).iDuration;
        this.d[paramInt].type = 10;
        this.d[paramInt].uin = this.mUin;
        if (this.d[paramInt].album.equals(this.l.album)) {
          this.d[paramInt].url = this.l.url;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        while (i < ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).vSingerList.size())
        {
          if (i != 0) {
            localStringBuilder.append("/");
          }
          localStringBuilder.append(((SingerInfo)((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).vSingerList.get(i)).sSingerName);
          i += 1;
        }
        this.d[paramInt].singer = localStringBuilder.toString();
        localArrayList.add(((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongId);
        paramInt += 1;
      }
      QQPlayerService.b(this.d);
      dFv();
    }
  }
  
  public void resetState()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ProfileMusicBoxController.2(this));
    aipd localaipd = ListenTogetherManager.a(this.app).a();
    JSONObject localJSONObject;
    if ((localaipd != null) && (!ListenTogetherManager.a(this.app).isPlaying())) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("type", "musicboxResume");
      localJSONObject.put("uin", localaipd.a().bPp);
      localJSONObject.put("uinType", localaipd.a().des);
      ListenTogetherManager.a(this.app).bo(localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMusicBoxController", 2, "resetState");
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void stopMusic()
  {
    QQPlayerService.eG(BaseApplicationImpl.getContext());
    resetState();
  }
  
  public static abstract interface a
  {
    public abstract void SL(int paramInt);
    
    public abstract void a(SongInfo paramSongInfo, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alep
 * JD-Core Version:    0.7.0.1
 */