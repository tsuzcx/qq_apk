package dov.com.qq.im.capture.control;

import android.text.TextUtils;
import aoll;
import aolm;
import aolm.b;
import aomg;
import aomh;
import aomi;
import aqgz;
import aqiw;
import atad;
import axol;
import axov;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.TicketManagerImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetSingleFullMusicInfoTask
  extends AsyncStep
  implements aolm.b
{
  protected FlowMusic a;
  private a a;
  protected FlowMusic b;
  private final Object dA = new Object();
  private aolm e;
  private String mSongMid;
  private String mUin;
  
  public GetSingleFullMusicInfoTask(FlowMusic paramFlowMusic, a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFlowMusic = paramFlowMusic;
    this.jdField_a_of_type_DovComQqImCaptureControlGetSingleFullMusicInfoTask$a = parama;
    paramFlowMusic = (QIMMusicConfigManager)axov.a(2);
    this.mUin = paramFlowMusic.a().getCurrentAccountUin();
    this.e = paramFlowMusic.e;
  }
  
  public GetSingleFullMusicInfoTask(String paramString, a parama)
  {
    this.mSongMid = paramString;
    this.jdField_a_of_type_DovComQqImCaptureControlGetSingleFullMusicInfoTask$a = parama;
    paramString = (QIMMusicConfigManager)axov.a(2);
    this.mUin = paramString.a().getCurrentAccountUin();
    this.e = paramString.e;
  }
  
  private void a(boolean paramBoolean, FlowMusic arg2)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureControlGetSingleFullMusicInfoTask$a != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureControlGetSingleFullMusicInfoTask$a.m(paramBoolean, ???);
      return;
    }
    synchronized (this.dA)
    {
      this.dA.notify();
      return;
    }
  }
  
  private static Map<String, String> b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_type", String.valueOf(1));
    localHashMap.put("uin", paramString1);
    localHashMap.put("ticket_type", "skey");
    localHashMap.put("auth", paramString2);
    return localHashMap;
  }
  
  private static String cw(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs").append("_").append("2000000025").append("_").append("SApgehUTVGxZKBQZTt").append("_").append("QmnkKmaTHNDozKdIUA").append("_").append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    String str = atad.toMD5((String)localObject).toLowerCase();
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "generate the sign string, pre=" + (String)localObject + ", md5=" + str);
    }
    return str;
  }
  
  private String f(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (!paramMap.isEmpty())
    {
      paramString = paramMap.entrySet().iterator();
      int i = 1;
      if (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        if (i != 0)
        {
          localStringBuilder.append("?");
          i = 0;
        }
        for (;;)
        {
          localStringBuilder.append((String)paramMap.getKey()).append("=").append((String)paramMap.getValue());
          break;
          localStringBuilder.append("&");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "genQQMusicReqUrl url" + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public int od()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataFlowMusic != null)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqDataFlowMusic.songMid;
      aoll localaoll = new aoll();
      localaoll.mHttpMethod = 0;
      localaoll.dPo = 1;
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      localaoll.mExcuteTimeLimit = 60000L;
      localaoll.f = this;
      long l = System.currentTimeMillis() / 1000L;
      String str = ((TicketManagerImpl)axol.getAppInterface().getManager(2)).getSkey(this.mUin);
      HashMap localHashMap = new HashMap();
      localHashMap.put("app_id", "2000000025");
      localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
      localHashMap.put("device_id", aqgz.getIMEI());
      localHashMap.put("timestamp", String.valueOf(l));
      localHashMap.put("sign", cw(l));
      localHashMap.put("song_mid", ???);
      localHashMap.putAll(b(this.mUin, str));
      localaoll.bZ = f("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_song_info_batch.fcg", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "QQMusicReq SingleFullMusicInfoTask songId:" + (String)???);
      }
      this.e.a(localaoll);
      if (this.jdField_a_of_type_DovComQqImCaptureControlGetSingleFullMusicInfoTask$a != null) {}
    }
    try
    {
      synchronized (this.dA)
      {
        this.dA.wait(30000L);
        label278:
        return 7;
        ??? = this.mSongMid;
      }
    }
    catch (Exception localException)
    {
      break label278;
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.dPy == 200)
    {
      if (paramaomh.mRespData != null)
      {
        paramaomh = new String(paramaomh.mRespData);
        if (!TextUtils.isEmpty(paramaomh))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask respJson =" + paramaomh);
          }
          try
          {
            paramaomh = new JSONObject(paramaomh);
            if (paramaomh.optInt("ret", -1) == 0)
            {
              paramaomh = paramaomh.optJSONArray("songlist");
              if (paramaomh == null) {
                return;
              }
              paramaomh = paramaomh.optJSONObject(0);
              if (paramaomh == null) {
                return;
              }
              this.b = new FlowMusic();
              this.b.albumId = paramaomh.optInt("album_id");
              this.b.albumMid = paramaomh.optString("album_mid");
              this.b.albumName = paramaomh.optString("album_name");
              this.b.albumUrl = paramaomh.optString("album_pic");
              this.b.singerId = paramaomh.optInt("singer_id");
              this.b.singerMid = paramaomh.optString("singer_mid");
              this.b.singerName = paramaomh.optString("singer_name");
              this.b.songId = paramaomh.optInt("song_id");
              this.b.songMid = paramaomh.optString("song_mid");
              this.b.songName = paramaomh.optString("song_name");
              this.b.songPlayTime = paramaomh.optInt("song_play_time");
              this.b.userOwnRule = paramaomh.optInt("user_own_rule");
              this.b.url = paramaomh.optString("song_play_url");
              this.b.size = paramaomh.optLong("song_size");
              this.b.playable = paramaomh.optInt("playable", 1);
              this.b.storeTimeStamp = System.currentTimeMillis();
              a(true, this.b);
              return;
            }
            a(false, null);
            return;
          }
          catch (JSONException paramaomh)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask e:" + paramaomh.toString());
        }
      }
      else
      {
        a(false, null);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "GetSingleFullMusicInfoTask resp.mHttpCode:" + paramaomh.dPy);
      }
      a(false, null);
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  
  public static abstract interface a
  {
    public abstract void m(boolean paramBoolean, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */