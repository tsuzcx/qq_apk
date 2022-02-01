package com.tencent.superplayer.preload;

import android.app.Activity;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.SuperPlayerWrapper;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.view.SPlayerVideoView;
import java.util.Map;

class PreloadPlayerMgr$1
  implements Runnable
{
  PreloadPlayerMgr$1(PreloadPlayerMgr paramPreloadPlayerMgr, Activity paramActivity, int paramInt1, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt2) {}
  
  public void run()
  {
    Object localObject1 = CommonUtil.createPlayerTag() + "-PreLoading";
    Object localObject3 = new HandlerThread("SuperPlayer-" + (String)localObject1);
    ((HandlerThread)localObject3).start();
    localObject3 = ((HandlerThread)localObject3).getLooper();
    localObject1 = new SuperPlayerWrapper(this.val$activity.getApplicationContext(), this.val$sceneId, (String)localObject1, (Looper)localObject3);
    localObject3 = (SPlayerVideoView)PreloadUtils.createCleanTextureView(this.val$activity);
    ((SPlayerVideoView)localObject3).addViewCallBack(new PreloadPlayerMgr.1.1(this, (SuperPlayerWrapper)localObject1, (SPlayerVideoView)localObject3));
    ((SuperPlayerWrapper)localObject1).setSurface(((SPlayerVideoView)localObject3).getSurface());
    ??? = SuperPlayerOption.obtain();
    ((SuperPlayerOption)???).isPrePlay = true;
    ((SuperPlayerWrapper)localObject1).openMediaPlayer(this.val$activity, this.val$videoInfo, 0L, (SuperPlayerOption)???);
    ((SuperPlayerWrapper)localObject1).updateIsPreloadingStatus(true);
    synchronized (PreloadPlayerMgr.access$000(this.this$0))
    {
      PreloadPlayerInfo localPreloadPlayerInfo = (PreloadPlayerInfo)PreloadPlayerMgr.access$000(this.this$0).get(Integer.valueOf(this.val$taskId));
      if (localPreloadPlayerInfo != null)
      {
        localPreloadPlayerInfo.player = ((SuperPlayerWrapper)localObject1);
        localPreloadPlayerInfo.videoView = ((SPlayerVideoView)localObject3);
        return;
      }
      ((SuperPlayerWrapper)localObject1).release();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.preload.PreloadPlayerMgr.1
 * JD-Core Version:    0.7.0.1
 */