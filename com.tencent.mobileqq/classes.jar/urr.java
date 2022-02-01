import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.1;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.2;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.3;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.4;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.5;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.6;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

public class urr
  extends urq
{
  private urr(WSPlayerManager paramWSPlayerManager) {}
  
  private void a(urt paramurt)
  {
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_ENDOF_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean))
    {
      urw localurw = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localurw != null) && (!localurw.e())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_Urw.f();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.5(this, paramurt));
  }
  
  private boolean a()
  {
    if (!WSPlayerManager.e(this.a)) {
      return false;
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.3(this));
    return true;
  }
  
  private void b()
  {
    uya.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
    if ((WSPlayerManager.a(this.a) == null) || (WSPlayerManager.a(this.a) == null)) {
      return;
    }
    if (WSPlayerManager.a(this.a).b > WSPlayerManager.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      WSPlayerManager.a(this.a).a(WSPlayerManager.a(this.a).b, bool);
      WSPlayerManager.a(this.a, WSPlayerManager.a(this.a).b);
      return;
    }
  }
  
  private void b(urt paramurt)
  {
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_START_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean))
    {
      urw localurw = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localurw != null) && (!localurw.e())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_Urw.e();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.6(this, paramurt));
  }
  
  private void c()
  {
    urw localurw = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
    if (localurw != null) {
      localurw.e();
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.1(this));
    b();
  }
  
  public void a()
  {
    WSPlayerManager.a(this.a).removeMessages(-3);
    WSPlayerManager.a(this.a).removeMessages(-4);
    if (WSPlayerManager.d(this.a))
    {
      this.a.a();
      return;
    }
    WSPlayerManager.b(this.a, true);
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, urw paramurw)
  {
    super.a(paramTVK_NetVideoInfo, paramurw);
    if ((!WSPlayerManager.a(this.a, paramurw)) && (paramurw == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)))) {
      WSPlayerManager.a(this.a, paramTVK_NetVideoInfo);
    }
  }
  
  public void a(urw paramurw)
  {
    super.a(paramurw);
    if (!WSPlayerManager.a(this.a, paramurw))
    {
      uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] checkIsPlayerPlaying false! playingVideoUrl:" + WSPlayerManager.b(this.a, WSPlayerManager.b(this.a)));
      return;
    }
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] 播放状态回调 playingVideoUrl:" + WSPlayerManager.b(this.a, WSPlayerManager.b(this.a)));
    if (a())
    {
      uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] checkPlayerLoop:true!");
      return;
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.2(this));
    WSPlayerManager.c(this.a, true);
  }
  
  public void a(urw paramurw, Object paramObject)
  {
    paramObject = WSPlayerManager.b(this.a);
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] 视频准备完成状态! mIsOpenedVideo:" + WSPlayerManager.a(this.a) + ", playingTitle:" + WSPlayerManager.a(this.a, paramObject));
    if (!WSPlayerManager.a(this.a, paramurw))
    {
      uya.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onVideoPrepared] prePlayVideo prepared!");
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramurw) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean)) {
        c();
      }
      return;
    }
    if (!WSPlayerManager.a(this.a))
    {
      uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] mIsOpenedVideo is false. return!");
      return;
    }
    WSPlayerManager.a(this.a, false);
    if (WSPlayerManager.a(this.a, paramObject) != null) {
      WSPlayerManager.a(this.a, paramObject).a(WSPlayerManager.a(this.a, paramObject));
    }
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] startVideoAfterPrepared!");
    a();
  }
  
  public boolean a(urw paramurw, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    super.a(paramurw, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      localObject = paramObject;
      if (WSPlayerManager.a(this.a, paramurw)) {
        break;
      }
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramurw) && (paramurw != null))
      {
        paramurw.e();
        WSPlayerManager.a(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramObject = WSPlayerManager.b(this.a);
    localObject = new StringBuilder().append("[WSPlayerManager.java][onError] 播放状态回调 errorStr:").append((String)localObject).append(", playingVideoUrl:");
    if (paramObject == null) {
      paramurw = "playingVideoParam is null.";
    }
    for (;;)
    {
      uya.d("WS_VIDEO_PLAYER", paramurw);
      WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.4(this, paramInt1, paramInt2, paramInt3, paramObject));
      paramurw = WSPlayerManager.a(this.a, paramObject);
      if (paramurw == null) {
        break;
      }
      paramurw.a(paramInt1, paramInt2, paramString);
      return false;
      if (paramObject.jdField_a_of_type_Urx != null) {
        paramurw = paramObject.jdField_a_of_type_Urx.b;
      } else {
        paramurw = "videoInfo is null.";
      }
    }
  }
  
  public boolean a(urw paramurw, int paramInt, Object paramObject)
  {
    super.a(paramurw, paramInt, paramObject);
    if ((paramInt != 42) && (!WSPlayerManager.a(this.a, paramurw)))
    {
      if (paramInt == 39)
      {
        if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean)) {
          WSPlayerManager.d(this.a, true);
        }
        uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED mIsPrePlayHWDecodeFailed:" + WSPlayerManager.c(this.a));
      }
      return false;
    }
    paramurw = WSPlayerManager.b(this.a);
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramurw = WSPlayerManager.a(this.a, paramurw);
      if (paramurw == null) {
        break;
      }
      paramurw.a(paramInt, paramObject);
      return false;
      b(paramurw);
      continue;
      a(paramurw);
    }
  }
  
  public void b(urw paramurw)
  {
    super.b(paramurw);
    WSPlayerManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void c(urw paramurw)
  {
    super.c(paramurw);
    if ((!WSPlayerManager.a(this.a, paramurw)) && (paramurw == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)))) {
      uya.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urr
 * JD-Core Version:    0.7.0.1
 */