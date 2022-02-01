package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;

class TAVCutVideoSession$4
  implements MediaBuilderListener
{
  TAVCutVideoSession$4(TAVCutVideoSession paramTAVCutVideoSession, boolean paramBoolean) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    paramInt = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
    int i = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
    this.this$0.constrainRenderSize(paramInt, i, paramVideoRenderChainManager);
    this.this$0.renderChainManagers.put(0, paramVideoRenderChainManager);
    this.this$0.tavCompositions.put(0, paramVideoRenderChainManager.getComposition());
    paramMediaBuilderOutput = paramVideoRenderChainManager.getComposition();
    if (this.this$0.sessionConfig != null) {}
    for (paramVideoRenderChainManager = this.this$0.sessionConfig.getRenderLayoutMode();; paramVideoRenderChainManager = null)
    {
      paramMediaBuilderOutput.setRenderLayoutMode(paramVideoRenderChainManager);
      paramVideoRenderChainManager = new CMTimeRange(CMTime.CMTimeZero, TAVCutVideoSession.access$300(this.this$0).getDuration());
      TAVCutVideoSession.access$400(this.this$0).updateComposition(TAVCutVideoSession.access$300(this.this$0), paramVideoRenderChainManager.getStart(), this.val$autoPlay);
      TAVCutVideoSession.access$400(this.this$0).setPlayRange(paramVideoRenderChainManager);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.4
 * JD-Core Version:    0.7.0.1
 */