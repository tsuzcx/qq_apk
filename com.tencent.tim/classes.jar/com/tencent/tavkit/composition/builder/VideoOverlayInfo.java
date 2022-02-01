package com.tencent.tavkit.composition.builder;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoCompositionLayerInstruction;

class VideoOverlayInfo
{
  CompositionTrack track;
  TAVVideo video;
  
  VideoOverlayInfo(CompositionTrack paramCompositionTrack, TAVVideo paramTAVVideo)
  {
    this.track = paramCompositionTrack;
    this.video = paramTAVVideo;
  }
  
  TAVVideoCompositionLayerInstruction convertToLayerInstruction()
  {
    TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = new TAVVideoCompositionLayerInstruction(this.track.getTrackID(), this.video.getVideoConfiguration(), this.video);
    localTAVVideoCompositionLayerInstruction.setPreferredTransform(this.track.getPreferredTransform());
    localTAVVideoCompositionLayerInstruction.setTimeRange(this.video.getTimeRange());
    return localTAVVideoCompositionLayerInstruction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.VideoOverlayInfo
 * JD-Core Version:    0.7.0.1
 */