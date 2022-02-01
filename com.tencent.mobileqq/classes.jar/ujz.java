import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.2;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.3;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.4;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.5;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

public class ujz
  extends ujx
{
  private ujz(WSPlayerManager paramWSPlayerManager) {}
  
  private void a(ukb paramukb)
  {
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_ENDOF_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean))
    {
      uke localuke = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localuke != null) && (!localuke.d())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_Uke.f();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.4(this, paramukb));
  }
  
  private void b()
  {
    Object localObject = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
    if (localObject != null) {
      ((uke)localObject).e();
    }
    ukb localukb;
    boolean bool2;
    if (WSPlayerManager.a(this.a) != null)
    {
      localObject = WSPlayerManager.a(this.a).jdField_a_of_type_Ujv;
      localukb = WSPlayerManager.a(this.a);
      bool2 = WSPlayerManager.b(this.a);
      if (WSPlayerManager.c(this.a)) {
        break label121;
      }
    }
    label121:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((ujv)localObject).a(localukb, bool2, bool1);
      upe.g("WS_VIDEO_PRE_PLAY", "<=============================== [WSPlayerManager.java][onPrePlayFinished] title:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
      return;
    }
  }
  
  private void b(ukb paramukb)
  {
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_START_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean))
    {
      uke localuke = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localuke != null) && (!localuke.d())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_Uke.e();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.5(this, paramukb));
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
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, uke paramuke)
  {
    super.a(paramTVK_NetVideoInfo, paramuke);
    if ((!WSPlayerManager.a(this.a, paramuke)) && (paramuke == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)))) {
      WSPlayerManager.a(this.a, paramTVK_NetVideoInfo);
    }
  }
  
  public void a(uke paramuke)
  {
    super.a(paramuke);
    if (!WSPlayerManager.a(this.a, paramuke))
    {
      upe.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] checkIsPlayerPlaying false! playingVideoUrl:" + WSPlayerManager.b(this.a, WSPlayerManager.b(this.a)));
      return;
    }
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] 播放状态回调 playingVideoUrl:" + WSPlayerManager.b(this.a, WSPlayerManager.b(this.a)));
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.2(this));
    WSPlayerManager.c(this.a, true);
  }
  
  public void a(uke paramuke, Object paramObject)
  {
    paramObject = WSPlayerManager.b(this.a);
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] 视频准备完成状态! mIsOpenedVideo:" + WSPlayerManager.a(this.a) + ", playingTitle:" + WSPlayerManager.a(this.a, paramObject));
    if (!WSPlayerManager.a(this.a, paramuke))
    {
      upe.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onVideoPrepared] prePlayVideo prepared!");
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramuke) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean)) {
        b();
      }
      return;
    }
    if (!WSPlayerManager.a(this.a))
    {
      upe.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] mIsOpenedVideo is false. return!");
      return;
    }
    WSPlayerManager.a(this.a, false);
    if (WSPlayerManager.a(this.a, paramObject) != null) {
      WSPlayerManager.a(this.a, paramObject).a(WSPlayerManager.a(this.a, paramObject));
    }
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] startVideoAfterPrepared!");
    a();
  }
  
  public boolean a(uke paramuke, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    super.a(paramuke, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      localObject = paramObject;
      if (WSPlayerManager.a(this.a, paramuke)) {
        break;
      }
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramuke) && (paramuke != null))
      {
        paramuke.e();
        WSPlayerManager.a(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramObject = WSPlayerManager.b(this.a);
    localObject = new StringBuilder().append("[WSPlayerManager.java][onError] 播放状态回调 errorStr:").append((String)localObject).append(", playingVideoUrl:");
    if (paramObject == null) {
      paramuke = "playingVideoParam is null.";
    }
    for (;;)
    {
      upe.d("WS_VIDEO_PLAYER", paramuke);
      WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.3(this, paramInt1, paramInt2, paramObject));
      if (WSPlayerManager.a(this.a, paramObject) == null) {
        break;
      }
      WSPlayerManager.a(this.a, paramObject).a(paramInt1, paramInt2, paramString);
      return false;
      if (paramObject.jdField_a_of_type_Ukf != null) {
        paramuke = paramObject.jdField_a_of_type_Ukf.b;
      } else {
        paramuke = "videoInfo is null.";
      }
    }
  }
  
  public boolean a(uke paramuke, int paramInt, Object paramObject)
  {
    super.a(paramuke, paramInt, paramObject);
    if ((paramInt != 42) && (!WSPlayerManager.a(this.a, paramuke))) {
      if (paramInt == 39)
      {
        if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean)) {
          WSPlayerManager.d(this.a, true);
        }
        upe.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED mIsPrePlayHWDecodeFailed:" + WSPlayerManager.c(this.a));
      }
    }
    for (;;)
    {
      return false;
      paramuke = WSPlayerManager.b(this.a);
      switch (paramInt)
      {
      }
      while (WSPlayerManager.a(this.a, paramuke) != null)
      {
        WSPlayerManager.a(this.a, paramuke).a(paramInt, paramObject);
        return false;
        b(paramuke);
        continue;
        a(paramuke);
      }
    }
  }
  
  public void b(uke paramuke)
  {
    super.b(paramuke);
    WSPlayerManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void c(uke paramuke)
  {
    super.c(paramuke);
    if ((!WSPlayerManager.a(this.a, paramuke)) && (paramuke == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a))))
    {
      upe.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
      if (WSPlayerManager.a(this.a) != null) {
        if (WSPlayerManager.a(this.a).b <= WSPlayerManager.a(this.a)) {
          break label143;
        }
      }
    }
    label143:
    for (boolean bool = true;; bool = false)
    {
      WSPlayerManager.a(this.a).a(WSPlayerManager.a(this.a).b, bool);
      WSPlayerManager.a(this.a, WSPlayerManager.a(this.a).b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujz
 * JD-Core Version:    0.7.0.1
 */