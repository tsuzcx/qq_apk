package com.google.android.exoplayer2.ext.mediaplayer;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataDecoderFactory;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.metadata.MetadataRenderer.Output;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.text.TextRenderer.Output;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.List;

public class DefaultRendererProvider
  implements RendererProvider
{
  protected int allowedJoiningTimeMs = 5000;
  protected AudioRendererEventListener audioRendererEventListener;
  protected TextRenderer.Output captionListener;
  protected Context context;
  protected DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
  protected int droppedFrameNotificationAmount = 50;
  protected Handler handler;
  protected MetadataRenderer.Output metadataListener;
  protected VideoRendererEventListener videoRendererEventListener;
  
  public DefaultRendererProvider(Context paramContext, Handler paramHandler, TextRenderer.Output paramOutput, MetadataRenderer.Output paramOutput1, AudioRendererEventListener paramAudioRendererEventListener, VideoRendererEventListener paramVideoRendererEventListener)
  {
    this.context = paramContext;
    this.handler = paramHandler;
    this.captionListener = paramOutput;
    this.metadataListener = paramOutput1;
    this.audioRendererEventListener = paramAudioRendererEventListener;
    this.videoRendererEventListener = paramVideoRendererEventListener;
  }
  
  protected List<Renderer> buildAudioRenderers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new MediaCodecAudioRenderer(MediaCodecSelector.DEFAULT, this.drmSessionManager, true, this.handler, this.audioRendererEventListener, AudioCapabilities.getCapabilities(this.context), new AudioProcessor[0]));
    return localArrayList;
  }
  
  protected List<Renderer> buildCaptionRenderers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TextRenderer(this.captionListener, this.handler.getLooper()));
    return localArrayList;
  }
  
  protected List<Renderer> buildMetadataRenderers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new MetadataRenderer(this.metadataListener, this.handler.getLooper(), MetadataDecoderFactory.DEFAULT));
    return localArrayList;
  }
  
  protected List<Renderer> buildVideoRenderers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new MediaCodecVideoRenderer(this.context, MediaCodecSelector.DEFAULT, this.allowedJoiningTimeMs, this.drmSessionManager, false, this.handler, this.videoRendererEventListener, this.droppedFrameNotificationAmount));
    return localArrayList;
  }
  
  public List<Renderer> generate()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(buildAudioRenderers());
    localArrayList.addAll(buildVideoRenderers());
    return localArrayList;
  }
  
  public void setAllowedVideoJoiningTimeMs(int paramInt)
  {
    this.allowedJoiningTimeMs = paramInt;
  }
  
  public void setDrmSessionManager(DrmSessionManager<FrameworkMediaCrypto> paramDrmSessionManager)
  {
    this.drmSessionManager = paramDrmSessionManager;
  }
  
  public void setDroppedFrameNotificationAmount(int paramInt)
  {
    this.droppedFrameNotificationAmount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.DefaultRendererProvider
 * JD-Core Version:    0.7.0.1
 */