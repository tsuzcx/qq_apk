import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.9;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.Arrays;

public class ued
  implements ucz
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public final Context a;
  public TVK_IMediaPlayer.OnSeekCompleteListener a;
  public TVK_IMediaPlayer a;
  final IVideoViewBase jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  public String a;
  uda jdField_a_of_type_Uda;
  udb jdField_a_of_type_Udb;
  public udc a;
  public udd a;
  public ude a;
  private udm jdField_a_of_type_Udm = new udm();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 5;
  String jdField_c_of_type_JavaLangString;
  public String d;
  private String e = "bus_type_qqstory";
  
  public ued(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "VideoViewTVKImpl";
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString += paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = TVK_SDKMgr.getProxyFactory().createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    ved.d(this.jdField_a_of_type_JavaLangString, "TVK info, sdk:%s", new Object[] { TVK_SDKMgr.getSdkVersion() });
  }
  
  public static TVK_PlayerVideoInfo a(String paramString1, String paramString2, String paramString3)
  {
    return udl.a(paramString1, paramString2, paramString3);
  }
  
  private void a(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (paramTVK_PlayerVideoInfo != null)
    {
      paramTVK_PlayerVideoInfo.setConfigMap("ff_probesize", String.valueOf(bhvy.b()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_ff_probelist_switch", String.valueOf(bhvy.q()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_download_async_io", String.valueOf(bhvy.r()));
      paramTVK_PlayerVideoInfo.setConfigMap("httpbuffertime_for_playpreload", String.valueOf(bhvy.f()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_switch", String.valueOf(bhvy.g()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_config_json", String.valueOf(bhvy.b()));
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = TVK_SDKMgr.getProxyFactory().createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(2);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new uef(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new ueg(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new ueh(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new uei(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(new uej(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoOutputFrameListener(new uek(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new uel(this));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return (int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  }
  
  public udm a()
  {
    return this.jdField_a_of_type_Udm;
  }
  
  public void a()
  {
    ved.d(this.jdField_a_of_type_JavaLangString, "stopPlayback, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public void a(int paramInt)
  {
    a().setVisibility(paramInt);
  }
  
  public void a(long paramLong)
  {
    ved.d(this.jdField_a_of_type_JavaLangString, "seekTo, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)paramLong);
    }
  }
  
  public void a(TVK_IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramString3, "auto", paramLong, paramInt1, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
    if (this.jdField_a_of_type_Udm.jdField_a_of_type_JavaLangString != null) {
      ved.a(this.jdField_a_of_type_JavaLangString, "%s", this.jdField_a_of_type_Udm);
    }
    this.jdField_a_of_type_Udm.a();
    this.jdField_a_of_type_Udm.jdField_a_of_type_JavaLangString = paramString1;
    Object localObject1 = this.jdField_a_of_type_Udm;
    if (paramString3 == null) {}
    Object localObject2;
    for (boolean bool = true;; bool = false)
    {
      ((udm)localObject1).jdField_a_of_type_Boolean = bool;
      if ((paramString2 != null) && (paramString3 != null))
      {
        this.jdField_c_of_type_Int = tvh.a(new tvn(paramString1, paramString3, paramString2, "TVKsetVideoPath"));
        ved.d(this.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d", new Object[] { paramString1, Integer.valueOf(this.jdField_c_of_type_Int) });
      }
      localObject1 = (stl)tcz.a(28);
      this.jdField_b_of_type_JavaLangString = paramString1;
      localObject2 = sui.a(paramString1, 0);
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.d = paramString3;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        h();
      }
      paramString3 = tsr.a(paramInt2);
      paramString2 = a((String)localObject2, this.jdField_c_of_type_JavaLangString, this.e);
      paramString2.setConfigMap("keep_last_frame", "true");
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label439;
      }
      localObject2 = new File(this.jdField_c_of_type_JavaLangString);
      if (!suj.a((File)localObject2)) {
        break;
      }
      paramString3.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      paramString3.jdField_a_of_type_Int = 1;
      ved.d(this.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 4, vid=%s", new Object[] { paramString1 });
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, 0L, 0L, null, paramString2);
      this.jdField_b_of_type_Int = 0;
      return;
    }
    if (((File)localObject2).exists()) {
      paramString3.jdField_a_of_type_Int = 2;
    }
    while (TextUtils.isEmpty(this.d)) {
      if (paramString1.trim().length() > 0)
      {
        paramString3 = new TVK_UserInfo("", "");
        paramString2.setPlayType(2);
        paramString2.setConfigMap("enable_cover_frame", "true");
        paramString2.setCid(paramString1);
        paramString2.setVid(paramString1);
        paramString2.setNeedCharge(false);
        a(paramString2);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, paramString3, paramString2, paramString4, 0L, 0L);
        this.jdField_b_of_type_Int = 1;
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "play by vid");
        return;
        paramString3.jdField_a_of_type_Int = 3;
        continue;
        label439:
        paramString3.jdField_a_of_type_Int = 4;
      }
      else
      {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "params is invalid");
        return;
      }
    }
    if (!this.d.contains("authkey"))
    {
      paramString4 = (stf)tcz.a(4);
      localObject2 = paramString4.b();
      if (localObject2 != null)
      {
        this.d = bfnx.a(this.d, "authkey", (String)localObject2);
        paramString3.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        paramString3 = ((stl)localObject1).a(this.d.replace("https://", "http://"));
        ved.d(this.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 3, vid=%s, urls=%s", new Object[] { paramString1, Arrays.toString(paramString3) });
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString3, 0L, 0L, paramString2, null);
        this.jdField_b_of_type_Int = 1;
        return;
      }
      Bosses.get().postJob(new uee(this, this.jdField_a_of_type_JavaLangString, paramString4, paramString3, (stl)localObject1, paramString1, paramString2));
      return;
    }
    paramString3.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    tvh.a();
    paramString3 = ((stl)localObject1).a(this.d.replace("https://", "http://"));
    ved.d(this.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 2, vid=%s, urls=%s", new Object[] { paramString1, Arrays.toString(paramString3) });
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString3, 0L, 0L, paramString2, null);
    this.jdField_b_of_type_Int = 1;
  }
  
  public void a(uda paramuda)
  {
    this.jdField_a_of_type_Uda = paramuda;
  }
  
  public void a(udb paramudb)
  {
    this.jdField_a_of_type_Udb = paramudb;
  }
  
  public void a(udc paramudc)
  {
    this.jdField_a_of_type_Udc = paramudc;
  }
  
  public void a(udd paramudd)
  {
    this.jdField_a_of_type_Udd = paramudd;
  }
  
  public void a(ude paramude)
  {
    this.jdField_a_of_type_Ude = paramude;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public void b()
  {
    ved.d(this.jdField_a_of_type_JavaLangString, "start, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    ved.d(this.jdField_a_of_type_JavaLangString, "pause, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void d()
  {
    ved.d(this.jdField_a_of_type_JavaLangString, "restart, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.d, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, 0);
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localObject != null) {
      ThreadManager.executeOnSubThread(new VideoViewTVKImpl.9(this, (TVK_IMediaPlayer)localObject));
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase != null) && (((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getParent() != null))
    {
      localObject = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
      }
    }
  }
  
  public void f()
  {
    ved.d(this.jdField_a_of_type_JavaLangString, "stop, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.d, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ued
 * JD-Core Version:    0.7.0.1
 */