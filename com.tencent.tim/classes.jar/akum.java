import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.c;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.statsvc.song.StatSvcStatSong.SongInfo;

public class akum
  implements Handler.Callback, QQPlayerService.c
{
  private static akum a;
  private static Object lock = new Object();
  public CopyOnWriteArrayList al = new CopyOnWriteArrayList();
  public ConcurrentHashMap<String, aiwn> gu = new ConcurrentHashMap();
  private Handler reportHandler;
  public int sourceType;
  
  public akum()
  {
    QQPlayerService.b(this);
    u(null);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Friends paramFriends, TextView paramTextView)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getResources();
    if ((!TextUtils.isEmpty(paramFriends.songName)) && (System.currentTimeMillis() < paramFriends.songEndTime))
    {
      if (!TextUtils.isEmpty(paramFriends.singerName))
      {
        paramQQAppInterface = String.format(paramQQAppInterface.getString(2131700576), new Object[] { paramFriends.songName, paramFriends.singerName });
        if (!(paramTextView instanceof OnlineStatusLyricView)) {
          break label152;
        }
        ((akun)axol.getAppInterface().getBusinessHandler(174)).i(paramFriends);
        ((OnlineStatusLyricView)paramTextView).setFriendSession(paramFriends, paramQQAppInterface);
      }
      for (;;)
      {
        anot.a(null, "dc00898", "", "", "0X800AC92", "0X800AC92", paramFriends.songSourceType, 0, "", "0", "0", "");
        return paramQQAppInterface;
        paramQQAppInterface = String.format(paramQQAppInterface.getString(2131700577), new Object[] { paramFriends.songName });
        break;
        label152:
        paramQQAppInterface = aeeu.a(paramTextView.getPaint(), paramQQAppInterface, aqnm.dip2px(200.0F));
      }
    }
    return paramQQAppInterface.getString(2131700578);
  }
  
  public static boolean asL()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("online_music_status", 0).getBoolean("has_set_online_music", false);
  }
  
  public static akum b()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new akum();
      }
      return a;
    }
  }
  
  public static void b(Friends paramFriends, byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null) {
      try
      {
        if (paramArrayOfByte.length > 0)
        {
          StatSvcStatSong.SongInfo localSongInfo = new StatSvcStatSong.SongInfo();
          localSongInfo.mergeFrom(paramArrayOfByte);
          paramFriends.songId = localSongInfo.bytes_song_id.get().toStringUtf8();
          if (b().al.contains(paramFriends.songId))
          {
            h(paramFriends);
            QLog.d("OnlineMusicStatusManager", 1, new Object[] { "update onlineSongState from ", paramString, " safeHit true" });
            return;
          }
          paramFriends.songName = localSongInfo.bytes_song_name.get().toStringUtf8();
          paramFriends.singerName = localSongInfo.bytes_singer_name.get().toStringUtf8();
          paramFriends.songEndTime = localSongInfo.uint64_end_time.get();
          paramFriends.songSourceType = localSongInfo.uint32_source_type.get();
          paramFriends.songPauseRemainTime = localSongInfo.uint32_pause_remaining_time.get();
          paramFriends.songDuration = localSongInfo.uint32_song_play_time.get();
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("OnlineMusicStatusManager", 2, new Object[] { "update onlineSongState from ", paramString, ", uin:", aqmr.getSimpleUinForPrint(paramFriends.uin), " songId:", paramFriends.songId, " songName:", paramFriends.songName, " songEndTime:", Long.valueOf(paramFriends.songEndTime), " source:", Integer.valueOf(paramFriends.songSourceType), " pauseRemain:", Integer.valueOf(paramFriends.songPauseRemainTime), " duration:", Integer.valueOf(paramFriends.songDuration), " remainTime:", Long.valueOf(paramFriends.songEndTime - System.currentTimeMillis()) });
          return;
        }
      }
      catch (Exception paramFriends)
      {
        QLog.d("OnlineMusicStatusManager", 1, "parseFriendMusicInfo fail", paramFriends);
        return;
      }
    } else {
      h(paramFriends);
    }
  }
  
  public static void dDy()
  {
    BaseApplicationImpl.getContext().getSharedPreferences("online_music_status", 0).edit().putBoolean("has_set_online_music", true).apply();
  }
  
  public static void h(Friends paramFriends)
  {
    paramFriends.songId = "";
    paramFriends.songName = "";
    paramFriends.singerName = "";
    paramFriends.songEndTime = 0L;
    paramFriends.songSourceType = 0;
    paramFriends.songPauseRemainTime = 0;
    paramFriends.songDuration = 0;
  }
  
  public void J(Activity paramActivity, String paramString)
  {
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      QLog.d("OnlineMusicStatusManager", 1, "openH5 fail");
      return;
    }
    paramString = String.format("https://i.y.qq.com/v8/playsong.html?_mylisten=1&songmid=%s&ADTAG=sqwztg&channelId=10039001", new Object[] { paramString });
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivity(localIntent);
    anot.a(null, "dc00898", "", "", "0X800ABB2", "0X800ABB2", 0, 0, "", "0", "0", "");
  }
  
  public void Sn(int paramInt)
  {
    if (paramInt == 2)
    {
      this.reportHandler.removeCallbacksAndMessages(null);
      this.reportHandler.sendEmptyMessageDelayed(2, 3000L);
    }
    do
    {
      do
      {
        return;
        if (paramInt == 8)
        {
          this.reportHandler.sendEmptyMessageDelayed(1, 3000L);
          return;
        }
        if ((paramInt != 4) && (paramInt != 5)) {
          break;
        }
        this.reportHandler.removeCallbacksAndMessages(null);
        this.reportHandler.sendEmptyMessage(1);
      } while (paramInt != 4);
      this.sourceType = 0;
      return;
    } while (paramInt != 3);
    this.reportHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.reportHandler.obtainMessage(2, 1, 0);
    this.reportHandler.sendMessage(localMessage);
  }
  
  public boolean asM()
  {
    return (QQMusicPlayService.isPlaying()) && (QQMusicPlayService.a() != null);
  }
  
  public boolean asN()
  {
    return (QQPlayerService.isPlaying()) && (QQPlayerService.a() != null);
  }
  
  public void aw(long paramLong1, long paramLong2)
  {
    QLog.d("OnlineMusicStatusManager", 1, new Object[] { "handleOnlineStatusChanged, ", Long.valueOf(paramLong1), "->", Long.valueOf(paramLong2) });
    if ((paramLong1 == 1028L) && (paramLong2 != 1028L)) {}
    do
    {
      this.reportHandler.sendEmptyMessage(1);
      do
      {
        return;
      } while ((paramLong1 == 1028L) || (paramLong2 != 1028L));
      if (asM())
      {
        this.reportHandler.removeMessages(1);
        this.reportHandler.sendEmptyMessageDelayed(2, 3000L);
        return;
      }
    } while (!asN());
    this.reportHandler.removeMessages(1);
    this.reportHandler.sendEmptyMessageDelayed(3, 3000L);
  }
  
  public QQAppInterface getApp()
  {
    return (QQAppInterface)axol.getAppInterface();
  }
  
  public String getToken()
  {
    return getClass().getName();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      ((akun)getApp().getBusinessHandler(174)).a(null);
      return false;
    case 2: 
      localakun = (akun)getApp().getBusinessHandler(174);
      localObject = (MusicInfo)QQMusicPlayService.a();
      int j = QQMusicPlayService.getDuration() - QQMusicPlayService.FH();
      ListenTogetherManager localListenTogetherManager = (ListenTogetherManager)getApp().getManager(331);
      if (localListenTogetherManager.a() != null)
      {
        if (localListenTogetherManager.a().type == 1)
        {
          i = 3;
          this.sourceType = i;
        }
      }
      else {
        if (paramMessage.arg1 != 1) {
          break label169;
        }
      }
      label169:
      for (bool = true;; bool = false)
      {
        localakun.a((MusicInfo)localObject, j, bool, QQMusicPlayService.getDuration());
        this.reportHandler.sendEmptyMessageDelayed(1, j);
        return false;
        i = 2;
        break;
      }
    }
    int i = QQPlayerService.getDuration() - QQPlayerService.Gt();
    akun localakun = (akun)getApp().getBusinessHandler(174);
    Object localObject = QQPlayerService.a();
    if (paramMessage.arg1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localakun.a((SongInfo)localObject, i, bool, QQPlayerService.getDuration());
      this.reportHandler.sendEmptyMessageDelayed(1, i);
      return false;
    }
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    Object localObject = xJ();
    QLog.d("OnlineMusicStatusManager", 1, new Object[] { "onPlayStateChanged, playState:", Integer.valueOf(paramInt), " token:", localObject });
    if ((localObject != null) && ((((String)localObject).startsWith("music_gene_")) || (((String)localObject).startsWith("aio_"))))
    {
      if (paramInt != 2) {
        break label88;
      }
      this.reportHandler.removeMessages(1);
      this.reportHandler.sendEmptyMessageDelayed(3, 3000L);
    }
    label88:
    do
    {
      do
      {
        return;
        if (paramInt == 8)
        {
          this.reportHandler.sendEmptyMessageDelayed(1, 3000L);
          return;
        }
        if ((paramInt != 4) && (paramInt != 5) && (paramInt != 7)) {
          break;
        }
        this.reportHandler.removeCallbacksAndMessages(null);
        this.reportHandler.sendEmptyMessage(1);
      } while (paramInt != 4);
      this.sourceType = 0;
      return;
    } while (paramInt != 3);
    this.reportHandler.removeCallbacksAndMessages(null);
    localObject = this.reportHandler.obtainMessage(3, 1, 0);
    this.reportHandler.sendMessage((Message)localObject);
  }
  
  public void u(Handler paramHandler)
  {
    if (this.reportHandler != null)
    {
      this.reportHandler = paramHandler;
      return;
    }
    this.reportHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public String xJ()
  {
    return QQPlayerService.getToken();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akum
 * JD-Core Version:    0.7.0.1
 */