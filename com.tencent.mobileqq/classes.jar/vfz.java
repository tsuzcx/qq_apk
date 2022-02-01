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

public class vfz
  extends vfy
{
  private vfz(WSPlayerManager paramWSPlayerManager) {}
  
  private void a(vgb paramvgb)
  {
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_ENDOF_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean))
    {
      vgh localvgh = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localvgh != null) && (!localvgh.e())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_Vgh.f();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.5(this, paramvgb));
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
    vmp.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
    vgb localvgb = WSPlayerManager.a(this.a);
    if ((WSPlayerManager.a(this.a) == null) || (localvgb == null)) {
      return;
    }
    int i = localvgb.b;
    if (i > WSPlayerManager.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      WSPlayerManager.a(this.a).a(i, bool);
      WSPlayerManager.a(this.a, i);
      return;
    }
  }
  
  private void b(vgb paramvgb)
  {
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_START_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean))
    {
      vgh localvgh = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localvgh != null) && (!localvgh.e())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_Vgh.e();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.6(this, paramvgb));
  }
  
  private void c()
  {
    vgh localvgh = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
    if (localvgh != null) {
      localvgh.e();
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
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, vgh paramvgh)
  {
    super.a(paramTVK_NetVideoInfo, paramvgh);
    if ((!WSPlayerManager.a(this.a, paramvgh)) && (paramvgh == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)))) {
      WSPlayerManager.a(this.a, paramTVK_NetVideoInfo);
    }
  }
  
  public void a(vgh paramvgh)
  {
    super.a(paramvgh);
    if (!WSPlayerManager.a(this.a, paramvgh))
    {
      vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] checkIsPlayerPlaying false! playingVideoUrl:" + WSPlayerManager.b(this.a, WSPlayerManager.b(this.a)));
      return;
    }
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] 播放状态回调 playingVideoUrl:" + WSPlayerManager.b(this.a, WSPlayerManager.b(this.a)));
    if (a())
    {
      vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] checkPlayerLoop:true!");
      return;
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.2(this));
    WSPlayerManager.c(this.a, true);
  }
  
  public void a(vgh paramvgh, Object paramObject)
  {
    paramObject = WSPlayerManager.b(this.a);
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] 视频准备完成状态! mIsOpenedVideo:" + WSPlayerManager.a(this.a) + ", playingTitle:" + WSPlayerManager.a(this.a, paramObject));
    if (!WSPlayerManager.a(this.a, paramvgh))
    {
      vmp.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onVideoPrepared] prePlayVideo prepared!");
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramvgh) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean)) {
        c();
      }
      return;
    }
    if (!WSPlayerManager.a(this.a))
    {
      vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] mIsOpenedVideo is false. return!");
      return;
    }
    WSPlayerManager.a(this.a, false);
    if (WSPlayerManager.a(this.a, paramObject) != null) {
      WSPlayerManager.a(this.a, paramObject).a(WSPlayerManager.a(this.a, paramObject));
    }
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] startVideoAfterPrepared!");
    a();
  }
  
  public boolean a(vgh paramvgh, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    super.a(paramvgh, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      localObject = paramObject;
      if (WSPlayerManager.a(this.a, paramvgh)) {
        break;
      }
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramvgh) && (paramvgh != null))
      {
        paramvgh.e();
        WSPlayerManager.a(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramObject = WSPlayerManager.b(this.a);
    localObject = new StringBuilder().append("[WSPlayerManager.java][onError] 播放状态回调 errorStr:").append((String)localObject).append(", playingVideoUrl:");
    if (paramObject == null) {
      paramvgh = "playingVideoParam is null.";
    }
    for (;;)
    {
      vmp.d("WS_VIDEO_PLAYER", paramvgh);
      WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.4(this, paramInt1, paramInt2, paramInt3, paramObject));
      paramvgh = WSPlayerManager.a(this.a, paramObject);
      if (paramvgh == null) {
        break;
      }
      paramvgh.a(paramInt1, paramInt2, paramString);
      return false;
      if (paramObject.jdField_a_of_type_Vgi != null) {
        paramvgh = paramObject.jdField_a_of_type_Vgi.b;
      } else {
        paramvgh = "videoInfo is null.";
      }
    }
  }
  
  public boolean a(vgh paramvgh, int paramInt, Object paramObject)
  {
    super.a(paramvgh, paramInt, paramObject);
    if ((paramInt != 42) && (!WSPlayerManager.a(this.a, paramvgh)))
    {
      if (paramInt == 39)
      {
        if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean)) {
          WSPlayerManager.d(this.a, true);
        }
        vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED mIsPrePlayHWDecodeFailed:" + WSPlayerManager.c(this.a));
      }
      return false;
    }
    paramvgh = WSPlayerManager.b(this.a);
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramvgh = WSPlayerManager.a(this.a, paramvgh);
      if (paramvgh == null) {
        break;
      }
      paramvgh.a(paramInt, paramObject);
      return false;
      b(paramvgh);
      continue;
      a(paramvgh);
    }
  }
  
  public void b(vgh paramvgh)
  {
    super.b(paramvgh);
    WSPlayerManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void c(vgh paramvgh)
  {
    super.c(paramvgh);
    if ((!WSPlayerManager.a(this.a, paramvgh)) && (paramvgh == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)))) {
      vmp.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfz
 * JD-Core Version:    0.7.0.1
 */