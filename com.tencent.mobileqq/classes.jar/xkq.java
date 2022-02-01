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

public class xkq
  implements xjm
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public final Context a;
  public TVK_IMediaPlayer.OnSeekCompleteListener a;
  public TVK_IMediaPlayer a;
  final IVideoViewBase jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  public String a;
  xjn jdField_a_of_type_Xjn;
  xjo jdField_a_of_type_Xjo;
  public xjp a;
  public xjq a;
  public xjr a;
  private xjz jdField_a_of_type_Xjz = new xjz();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 5;
  String jdField_c_of_type_JavaLangString;
  public String d;
  private String e = "bus_type_qqstory";
  
  public xkq(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "VideoViewTVKImpl";
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString += paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = TVK_SDKMgr.getProxyFactory().createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    ykq.d(this.jdField_a_of_type_JavaLangString, "TVK info, sdk:%s", new Object[] { TVK_SDKMgr.getSdkVersion() });
  }
  
  public static TVK_PlayerVideoInfo a(String paramString1, String paramString2, String paramString3)
  {
    return xjy.a(paramString1, paramString2, paramString3);
  }
  
  private void a(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (paramTVK_PlayerVideoInfo != null)
    {
      paramTVK_PlayerVideoInfo.setConfigMap("ff_probesize", String.valueOf(bmhv.b()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_ff_probelist_switch", String.valueOf(bmhv.u()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_download_async_io", String.valueOf(bmhv.v()));
      paramTVK_PlayerVideoInfo.setConfigMap("httpbuffertime_for_playpreload", String.valueOf(bmhv.g()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_switch", String.valueOf(bmhv.h()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_config_json", String.valueOf(bmhv.c()));
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = TVK_SDKMgr.getProxyFactory().createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(2);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new xks(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new xkt(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new xku(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new xkv(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(new xkw(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoOutputFrameListener(new xkx(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new xky(this));
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
  
  public xjz a()
  {
    return this.jdField_a_of_type_Xjz;
  }
  
  public void a()
  {
    ykq.d(this.jdField_a_of_type_JavaLangString, "stopPlayback, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
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
    if (this.jdField_a_of_type_Xjz.jdField_a_of_type_JavaLangString != null) {
      ykq.a(this.jdField_a_of_type_JavaLangString, "%s", this.jdField_a_of_type_Xjz);
    }
    this.jdField_a_of_type_Xjz.a();
    this.jdField_a_of_type_Xjz.jdField_a_of_type_JavaLangString = paramString1;
    Object localObject1 = this.jdField_a_of_type_Xjz;
    if (paramString3 == null) {}
    Object localObject2;
    for (boolean bool = true;; bool = false)
    {
      ((xjz)localObject1).jdField_a_of_type_Boolean = bool;
      if ((paramString2 != null) && (paramString3 != null))
      {
        this.jdField_c_of_type_Int = xbu.a(new xca(paramString1, paramString3, paramString2, "TVKsetVideoPath"));
        ykq.d(this.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d", new Object[] { paramString1, Integer.valueOf(this.jdField_c_of_type_Int) });
      }
      localObject1 = (wan)wjs.a(28);
      this.jdField_b_of_type_JavaLangString = paramString1;
      localObject2 = wbk.a(paramString1, 0);
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.d = paramString3;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        f();
      }
      paramString3 = wzk.a(paramInt2);
      paramString2 = a((String)localObject2, this.jdField_c_of_type_JavaLangString, this.e);
      paramString2.setConfigMap("keep_last_frame", "true");
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label439;
      }
      localObject2 = new File(this.jdField_c_of_type_JavaLangString);
      if (!wbl.a((File)localObject2)) {
        break;
      }
      paramString3.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      paramString3.jdField_a_of_type_Int = 1;
      ykq.d(this.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 4, vid=%s", new Object[] { paramString1 });
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
      paramString4 = (wah)wjs.a(4);
      localObject2 = paramString4.b();
      if (localObject2 != null)
      {
        this.d = bkyp.a(this.d, "authkey", (String)localObject2);
        paramString3.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        paramString3 = ((wan)localObject1).a(this.d.replace("https://", "http://"));
        ykq.d(this.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 3, vid=%s, urls=%s", new Object[] { paramString1, Arrays.toString(paramString3) });
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString3, 0L, 0L, paramString2, null);
        this.jdField_b_of_type_Int = 1;
        return;
      }
      Bosses.get().postJob(new xkr(this, this.jdField_a_of_type_JavaLangString, paramString4, paramString3, (wan)localObject1, paramString1, paramString2));
      return;
    }
    paramString3.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    xbu.a();
    paramString3 = ((wan)localObject1).a(this.d.replace("https://", "http://"));
    ykq.d(this.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 2, vid=%s, urls=%s", new Object[] { paramString1, Arrays.toString(paramString3) });
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString3, 0L, 0L, paramString2, null);
    this.jdField_b_of_type_Int = 1;
  }
  
  public void a(xjn paramxjn)
  {
    this.jdField_a_of_type_Xjn = paramxjn;
  }
  
  public void a(xjo paramxjo)
  {
    this.jdField_a_of_type_Xjo = paramxjo;
  }
  
  public void a(xjp paramxjp)
  {
    this.jdField_a_of_type_Xjp = paramxjp;
  }
  
  public void a(xjq paramxjq)
  {
    this.jdField_a_of_type_Xjq = paramxjq;
  }
  
  public void a(xjr paramxjr)
  {
    this.jdField_a_of_type_Xjr = paramxjr;
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
    ykq.d(this.jdField_a_of_type_JavaLangString, "start, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void c()
  {
    ykq.d(this.jdField_a_of_type_JavaLangString, "pause, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void d()
  {
    ykq.d(this.jdField_a_of_type_JavaLangString, "restart, %s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkq
 * JD-Core Version:    0.7.0.1
 */