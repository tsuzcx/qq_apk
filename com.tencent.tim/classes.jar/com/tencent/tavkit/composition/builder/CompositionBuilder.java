package com.tencent.tavkit.composition.builder;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class CompositionBuilder
{
  private BuilderModel builderModel;
  private MutableComposition composition;
  private boolean isAudioTracksMerge;
  private boolean isVideoTracksMerge;
  
  public CompositionBuilder(BuilderModel paramBuilderModel, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.builderModel = paramBuilderModel;
    this.isVideoTracksMerge = paramBoolean1;
    this.isAudioTracksMerge = paramBoolean2;
    this.composition = new MutableComposition();
  }
  
  @NonNull
  private AudioTransitionInfo getAudioTransitionInfo(List<? extends TAVTransitionableAudio> paramList, TAVAudioTransition paramTAVAudioTransition, TAVTransitionableAudio paramTAVTransitionableAudio, int paramInt)
  {
    if ((paramInt == 0) && (paramList.size() > 1)) {
      return new AudioTransitionInfo(null, paramTAVTransitionableAudio.getAudioTransition());
    }
    if (paramInt == paramList.size() - 1) {
      return new AudioTransitionInfo(paramTAVAudioTransition, null);
    }
    return new AudioTransitionInfo(paramTAVAudioTransition, paramTAVTransitionableAudio.getAudioTransition());
  }
  
  private void initCompositionWithAudioChannels()
  {
    Iterator localIterator = this.builderModel.getAudioChannels().iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      int i = 0;
      TAVAudioTransition localTAVAudioTransition = null;
      while (i < localList.size())
      {
        TAVTransitionableAudio localTAVTransitionableAudio = (TAVTransitionableAudio)localList.get(i);
        int j = 0;
        if (j < localTAVTransitionableAudio.numberOfAudioTracks())
        {
          CompositionTrack localCompositionTrack = localTAVTransitionableAudio.audioCompositionTrackForComposition(this.composition, j, this.isAudioTracksMerge);
          if (localCompositionTrack == null) {}
          for (;;)
          {
            j += 1;
            break;
            localArrayList.add(new AudioInfo(localCompositionTrack, localTAVTransitionableAudio));
          }
        }
        localHashMap.put(String.valueOf(i), getAudioTransitionInfo(localList, localTAVAudioTransition, localTAVTransitionableAudio, i));
        localTAVAudioTransition = localTAVTransitionableAudio.getAudioTransition();
        i += 1;
      }
      this.builderModel.addMainAudioTrackInfo(new AudioParamsInfo(localArrayList, localHashMap));
    }
  }
  
  private void initCompositionWithMixAudios(List<? extends TAVAudio> paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      paramList = paramList.iterator();
    } while (!paramList.hasNext());
    TAVAudio localTAVAudio = (TAVAudio)paramList.next();
    int i = 0;
    label33:
    CompositionTrack localCompositionTrack;
    if (i < localTAVAudio.numberOfAudioTracks())
    {
      localCompositionTrack = localTAVAudio.audioCompositionTrackForComposition(this.composition, i, this.isAudioTracksMerge);
      if (localCompositionTrack != null) {
        break label72;
      }
    }
    for (;;)
    {
      i += 1;
      break label33;
      break;
      label72:
      this.builderModel.addAudioTrackInfo(new AudioMixInfo(localCompositionTrack, localTAVAudio));
    }
  }
  
  private void initCompositionWithOverlays(List<? extends TAVVideo> paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      paramList = paramList.iterator();
    } while (!paramList.hasNext());
    TAVVideo localTAVVideo = (TAVVideo)paramList.next();
    int i = 0;
    label33:
    CompositionTrack localCompositionTrack;
    if (i < localTAVVideo.numberOfVideoTracks())
    {
      localCompositionTrack = localTAVVideo.videoCompositionTrackForComposition(this.composition, i, this.isVideoTracksMerge);
      if (localCompositionTrack != null) {
        break label72;
      }
    }
    for (;;)
    {
      i += 1;
      break label33;
      break;
      label72:
      this.builderModel.addOverlayTrackInfo(new VideoOverlayInfo(localCompositionTrack, localTAVVideo));
    }
  }
  
  private void initCompositionWithVideoChannels()
  {
    Iterator localIterator = this.builderModel.getVideoChannels().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)localIterator.next();
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        TAVTransitionableVideo localTAVTransitionableVideo = (TAVTransitionableVideo)((Iterator)localObject).next();
        int i = 0;
        label74:
        CompositionTrack localCompositionTrack;
        if (i < localTAVTransitionableVideo.numberOfVideoTracks())
        {
          localCompositionTrack = localTAVTransitionableVideo.videoCompositionTrackForComposition(this.composition, i, this.isVideoTracksMerge);
          if (localCompositionTrack != null) {
            break label115;
          }
        }
        for (;;)
        {
          i += 1;
          break label74;
          break;
          label115:
          localArrayList.add(new VideoInfo(localCompositionTrack, localTAVTransitionableVideo));
        }
      }
      this.builderModel.addMainVideoTrackInfo(localArrayList);
    }
  }
  
  @NonNull
  MutableComposition build()
  {
    initCompositionWithVideoChannels();
    initCompositionWithAudioChannels();
    initCompositionWithOverlays(this.builderModel.getOverlays());
    initCompositionWithMixAudios(this.builderModel.getMixAudios());
    return this.composition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.CompositionBuilder
 * JD-Core Version:    0.7.0.1
 */