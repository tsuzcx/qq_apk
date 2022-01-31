import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.2;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.3;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.4;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class thj
  extends thh
{
  private thj(WSPlayerManager paramWSPlayerManager) {}
  
  private void a(thl paramthl)
  {
    tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_ENDOF_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean))
    {
      tho localtho = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localtho != null) && (!localtho.d())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_Tho.f();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.3(this, paramthl));
  }
  
  private void b()
  {
    WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)).e();
    thf localthf;
    thl localthl;
    boolean bool2;
    if (WSPlayerManager.a(this.a) != null)
    {
      localthf = WSPlayerManager.a(this.a).jdField_a_of_type_Thf;
      localthl = WSPlayerManager.a(this.a);
      bool2 = WSPlayerManager.b(this.a);
      if (WSPlayerManager.c(this.a)) {
        break label115;
      }
    }
    label115:
    for (boolean bool1 = true;; bool1 = false)
    {
      localthf.a(localthl, bool2, bool1);
      tlo.g("WS_VIDEO_PRE_PLAY", "<=============================== [WSPlayerManager.java][onPrePlayFinished] title:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
      return;
    }
  }
  
  private void b(thl paramthl)
  {
    tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_START_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean))
    {
      tho localtho = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localtho != null) && (!localtho.d())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_Tho.e();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.4(this, paramthl));
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
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, tho paramtho)
  {
    super.a(paramTVK_NetVideoInfo, paramtho);
    if ((!WSPlayerManager.a(this.a, paramtho)) && (paramtho == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)))) {
      WSPlayerManager.a(this.a, paramTVK_NetVideoInfo);
    }
  }
  
  public void a(tho paramtho)
  {
    super.a(paramtho);
    if (!WSPlayerManager.a(this.a, paramtho))
    {
      localStringBuilder = new StringBuilder().append("[WSPlayerManager.java][onCompletion] checkIsPlayerPlaying false! playingVideoUrl:");
      if (WSPlayerManager.b(this.a) != null) {}
      for (paramtho = WSPlayerManager.b(this.a).jdField_a_of_type_Thp.b;; paramtho = "playing param null")
      {
        tlo.d("WS_VIDEO_PLAYER", paramtho);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[WSPlayerManager.java][onCompletion] 播放状态回调 playingVideoUrl:");
    if (WSPlayerManager.b(this.a) != null) {}
    for (paramtho = WSPlayerManager.b(this.a).jdField_a_of_type_Thp.b;; paramtho = "playing param null")
    {
      tlo.e("WS_VIDEO_PLAYER", paramtho);
      WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.2(this));
      WSPlayerManager.c(this.a, true);
      return;
    }
  }
  
  public void a(tho paramtho, Object paramObject)
  {
    paramObject = WSPlayerManager.b(this.a);
    tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] 视频准备完成状态! mIsOpenedVideo:" + WSPlayerManager.a(this.a) + ", playingTitle:" + WSPlayerManager.a(this.a, paramObject));
    if (!WSPlayerManager.a(this.a, paramtho))
    {
      tlo.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onVideoPrepared] prePlayVideo prepared!");
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramtho) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean)) {
        b();
      }
      return;
    }
    if (!WSPlayerManager.a(this.a))
    {
      tlo.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] mIsOpenedVideo is false. return!");
      return;
    }
    WSPlayerManager.a(this.a, false);
    if (WSPlayerManager.a(this.a, paramObject) != null) {
      WSPlayerManager.a(this.a, paramObject).a(WSPlayerManager.a(this.a, paramObject));
    }
    tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] startVideoAfterPrepared!");
    a();
  }
  
  public boolean a(tho paramtho, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    super.a(paramtho, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramObject = paramObject.toString();
      localObject = paramObject;
      if (WSPlayerManager.a(this.a, paramtho)) {
        break label147;
      }
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramtho) && (paramtho != null))
      {
        paramtho.e();
        WSPlayerManager.a(this.a).jdField_a_of_type_Boolean = false;
      }
    }
    label147:
    do
    {
      return false;
      paramObject = "";
      break;
      paramObject = WSPlayerManager.b(this.a);
      localObject = new StringBuilder().append("[WSPlayerManager.java][onError] 播放状态回调 errorStr:").append((String)localObject).append(", playingVideoUrl:");
      if (paramObject == null) {
        paramtho = "playingVideoParam is null.";
      }
      for (;;)
      {
        tlo.d("WS_VIDEO_PLAYER", paramtho);
        paramtho = WSPlayerManager.a(this.a, paramInt1, paramInt2);
        if ((paramObject != null) && (paramObject.jdField_a_of_type_Thf != null)) {
          paramObject.jdField_a_of_type_Thf.a(paramObject, paramInt1, paramInt2, paramtho);
        }
        if (WSPlayerManager.a(this.a) == null) {
          break;
        }
        localObject = WSPlayerManager.a(this.a).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((thm)((Iterator)localObject).next()).a(paramObject, paramInt1, paramInt2, paramtho);
        }
        if (paramObject.jdField_a_of_type_Thp != null) {
          paramtho = paramObject.jdField_a_of_type_Thp.b;
        } else {
          paramtho = "videoInfo is null.";
        }
      }
    } while (WSPlayerManager.a(this.a, paramObject) == null);
    WSPlayerManager.a(this.a, paramObject).a(paramInt1, paramInt2, paramString);
    return false;
  }
  
  public boolean a(tho paramtho, int paramInt, Object paramObject)
  {
    super.a(paramtho, paramInt, paramObject);
    if ((paramInt != 42) && (!WSPlayerManager.a(this.a, paramtho))) {
      if (paramInt == 39)
      {
        if ((WSPlayerManager.a(this.a) != null) && (WSPlayerManager.a(this.a).jdField_a_of_type_Boolean)) {
          WSPlayerManager.d(this.a, true);
        }
        tlo.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED mIsPrePlayHWDecodeFailed:" + WSPlayerManager.c(this.a));
      }
    }
    for (;;)
    {
      return false;
      paramtho = WSPlayerManager.b(this.a);
      switch (paramInt)
      {
      }
      while (WSPlayerManager.a(this.a, paramtho) != null)
      {
        WSPlayerManager.a(this.a, paramtho).a(paramInt, paramObject);
        return false;
        b(paramtho);
        continue;
        a(paramtho);
      }
    }
  }
  
  public void b(tho paramtho)
  {
    super.b(paramtho);
    WSPlayerManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void c(tho paramtho)
  {
    super.c(paramtho);
    if ((!WSPlayerManager.a(this.a, paramtho)) && (paramtho == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a))))
    {
      tlo.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
      if (WSPlayerManager.a(this.a) != null) {
        WSPlayerManager.a(this.a).a(WSPlayerManager.a(this.a).b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     thj
 * JD-Core Version:    0.7.0.1
 */