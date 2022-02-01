package cooperation.qzone.music;

import acfp;
import android.text.TextUtils;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QzoneMusicHelper
{
  public static final String NO_NETWORK_MSG = acfp.m(2131713200);
  
  public static SongInfo convertAudioSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.title = getString(paramJSONObject, "name");
    localSongInfo.singer = getString(paramJSONObject, "singer");
    localSongInfo.id = getLong(paramJSONObject, "songId");
    localSongInfo.url = getString(paramJSONObject, "playUrl");
    localSongInfo.type = getInt(paramJSONObject, "type");
    localSongInfo.coverUrl = getString(paramJSONObject, "cover");
    localSongInfo.singerId = getLong(paramJSONObject, "singerId");
    localSongInfo.album = getString(paramJSONObject, "album");
    localSongInfo.detailUrl = getString(paramJSONObject, "detailUrl");
    localSongInfo.summary = getString(paramJSONObject, "showId");
    if (localSongInfo.id == 0L) {
      localSongInfo.id = getFMID(localSongInfo.summary);
    }
    return localSongInfo;
  }
  
  public static SongInfo convertFMBgMusic(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    String str = getString(paramJSONObject, "showID");
    localSongInfo.title = getString(paramJSONObject, "showName");
    localSongInfo.singer = "";
    localSongInfo.id = getFMID(str);
    localSongInfo.url = getString(paramJSONObject, "showAudioUrl");
    localSongInfo.type = 8;
    localSongInfo.coverUrl = "";
    localSongInfo.singerId = 0L;
    localSongInfo.album = "";
    localSongInfo.detailUrl = "";
    localSongInfo.summary = str;
    return localSongInfo;
  }
  
  public static SongInfo convertSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.title = getString(paramJSONObject, "name");
    localSongInfo.singer = getString(paramJSONObject, "singer");
    localSongInfo.id = getLong(paramJSONObject, "songId");
    localSongInfo.url = getString(paramJSONObject, "playUrl");
    localSongInfo.type = getInt(paramJSONObject, "type");
    localSongInfo.coverUrl = getString(paramJSONObject, "cover");
    localSongInfo.singerId = getLong(paramJSONObject, "singerId");
    localSongInfo.album = getString(paramJSONObject, "album");
    localSongInfo.uin = getLong(paramJSONObject, "uin");
    if (TextUtils.isEmpty(localSongInfo.album)) {
      localSongInfo.album = getString(paramJSONObject, "songMid");
    }
    if (TextUtils.isEmpty(localSongInfo.album)) {
      localSongInfo.album = getString(paramJSONObject, "musicMId");
    }
    if ((!TextUtils.isEmpty(localSongInfo.album)) && (localSongInfo.id == 0L)) {
      localSongInfo.id = getSongIDWithMid(localSongInfo.album);
    }
    if ((localSongInfo.type == 0) && (getInt(paramJSONObject, "voiceType") == 3)) {
      localSongInfo.type = 11;
    }
    localSongInfo.detailUrl = getString(paramJSONObject, "detailUrl");
    return localSongInfo;
  }
  
  public static long getFMID(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      long l2 = paramString.hashCode();
      long l1 = l2;
      if (l2 >= 0L) {
        l1 = l2 * -1L - 1L - 2147483648L;
      }
      return l1;
    }
    return 0L;
  }
  
  private static int getInt(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      int i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("QzoneWebMusicJsPlugin", 2, "getInt " + paramJSONObject.getMessage());
    }
    return 0;
  }
  
  private static long getLong(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      long l = paramJSONObject.getLong(paramString);
      return l;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("QzoneWebMusicJsPlugin", 2, "getLong " + paramJSONObject.getMessage());
    }
    return 0L;
  }
  
  public static long getSongIDWithMid(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      long l2 = paramString.hashCode();
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = l2 * -1L;
      }
      return l1;
    }
    return 0L;
  }
  
  private static String getString(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("QzoneWebMusicJsPlugin", 2, "getString " + paramJSONObject.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.music.QzoneMusicHelper
 * JD-Core Version:    0.7.0.1
 */