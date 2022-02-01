import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.1;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.2;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.3;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.4;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.5;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

public class ukx
  extends ukv
{
  private ukx(WSPlayerManager paramWSPlayerManager) {}
  
  private void a(ukz paramukz)
  {
    uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_ENDOF_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean))
    {
      ulc localulc = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localulc != null) && (!localulc.d())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_Ulc.f();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.4(this, paramukz));
  }
  
  private void b()
  {
    ulc localulc = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
    if (localulc != null) {
      localulc.e();
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.1(this));
  }
  
  private void b(ukz paramukz)
  {
    uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_START_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean))
    {
      ulc localulc = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localulc != null) && (!localulc.d())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_Ulc.e();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.5(this, paramukz));
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
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, ulc paramulc)
  {
    super.a(paramTVK_NetVideoInfo, paramulc);
    if ((!WSPlayerManager.a(this.a, paramulc)) && (paramulc == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)))) {
      WSPlayerManager.a(this.a, paramTVK_NetVideoInfo);
    }
  }
  
  public void a(ulc paramulc)
  {
    super.a(paramulc);
    if (!WSPlayerManager.a(this.a, paramulc))
    {
      uqf.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] checkIsPlayerPlaying false! playingVideoUrl:" + WSPlayerManager.b(this.a, WSPlayerManager.b(this.a)));
      return;
    }
    uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] 播放状态回调 playingVideoUrl:" + WSPlayerManager.b(this.a, WSPlayerManager.b(this.a)));
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.2(this));
    WSPlayerManager.c(this.a, true);
  }
  
  public void a(ulc paramulc, Object paramObject)
  {
    paramObject = WSPlayerManager.b(this.a);
    uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] 视频准备完成状态! mIsOpenedVideo:" + WSPlayerManager.a(this.a) + ", playingTitle:" + WSPlayerManager.a(this.a, paramObject));
    if (!WSPlayerManager.a(this.a, paramulc))
    {
      uqf.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onVideoPrepared] prePlayVideo prepared!");
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramulc) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean)) {
        b();
      }
      return;
    }
    if (!WSPlayerManager.a(this.a))
    {
      uqf.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] mIsOpenedVideo is false. return!");
      return;
    }
    WSPlayerManager.a(this.a, false);
    if (WSPlayerManager.a(this.a, paramObject) != null) {
      WSPlayerManager.a(this.a, paramObject).a(WSPlayerManager.a(this.a, paramObject));
    }
    uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] startVideoAfterPrepared!");
    a();
  }
  
  public boolean a(ulc paramulc, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    super.a(paramulc, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      localObject = paramObject;
      if (WSPlayerManager.a(this.a, paramulc)) {
        break;
      }
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramulc) && (paramulc != null))
      {
        paramulc.e();
        WSPlayerManager.a(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramObject = WSPlayerManager.b(this.a);
    localObject = new StringBuilder().append("[WSPlayerManager.java][onError] 播放状态回调 errorStr:").append((String)localObject).append(", playingVideoUrl:");
    if (paramObject == null) {
      paramulc = "playingVideoParam is null.";
    }
    for (;;)
    {
      uqf.d("WS_VIDEO_PLAYER", paramulc);
      WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.3(this, paramInt1, paramInt2, paramObject));
      paramulc = WSPlayerManager.a(this.a, paramObject);
      if (paramulc == null) {
        break;
      }
      paramulc.a(paramInt1, paramInt2, paramString);
      return false;
      if (paramObject.jdField_a_of_type_Uld != null) {
        paramulc = paramObject.jdField_a_of_type_Uld.b;
      } else {
        paramulc = "videoInfo is null.";
      }
    }
  }
  
  public boolean a(ulc paramulc, int paramInt, Object paramObject)
  {
    super.a(paramulc, paramInt, paramObject);
    if ((paramInt != 42) && (!WSPlayerManager.a(this.a, paramulc))) {
      if (paramInt == 39)
      {
        if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean)) {
          WSPlayerManager.d(this.a, true);
        }
        uqf.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED mIsPrePlayHWDecodeFailed:" + WSPlayerManager.c(this.a));
      }
    }
    for (;;)
    {
      return false;
      paramulc = WSPlayerManager.b(this.a);
      switch (paramInt)
      {
      }
      while (WSPlayerManager.a(this.a, paramulc) != null)
      {
        WSPlayerManager.a(this.a, paramulc).a(paramInt, paramObject);
        return false;
        b(paramulc);
        continue;
        a(paramulc);
      }
    }
  }
  
  public void b(ulc paramulc)
  {
    super.b(paramulc);
    WSPlayerManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void c(ulc paramulc)
  {
    super.c(paramulc);
    if ((!WSPlayerManager.a(this.a, paramulc)) && (paramulc == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a))))
    {
      uqf.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
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
 * Qualified Name:     ukx
 * JD-Core Version:    0.7.0.1
 */