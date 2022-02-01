package com.tencent.weseevideo.composition.builder;

import android.support.annotation.NonNull;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.model.MediaModel;

public class MediaBuilderFactory
{
  public static final int RHYTHM_SINGLE_IMAGE = 10000;
  public static final float TIME_FLOAT_MS = 1000.0F;
  public static final float TIME_FLOAT_US = 1000000.0F;
  public static final int TIME_INT_MS = 1000;
  public static final int TIME_MAX_MS = 60000;
  public static final int TIME_MIN_MS = 2000;
  
  public static void mediaBuilderAsync(@NonNull MediaModel paramMediaModel, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull VideoRenderChainConfigure paramVideoRenderChainConfigure, @NonNull MediaBuilderListener paramMediaBuilderListener)
  {
    paramVideoRenderChainConfigure.setSceneType(0);
    MediaBuilder.build(paramMediaModel, paramIStickerContextInterface, paramMediaBuilderListener, paramVideoRenderChainConfigure);
  }
  
  public static void mediaBuilderAsync(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull MediaBuilderListener paramMediaBuilderListener)
  {
    mediaBuilderAsync(paramMediaModel, paramIStickerContextInterface, new VideoRenderChainConfigure(true), paramMediaBuilderListener);
  }
  
  public static class MediaBuilderErrorCode
  {
    public static final int AUTO_COMPOSITION_BUILD_FAILED = -201;
    public static final int AUTO_TEMPLATE_BUILD_FAILED = -200;
    public static final int BUILD_SUCCESS = 0;
    public static final int COMPOSITION_BUILD_FAILED = -101;
    public static final int MOVIE_COMPOSITION_BUILD_FAILED = -301;
    public static final int MOVIE_LOAD_DATA_FAILED = -302;
    public static final int MOVIE_MODEL_EMPTY = -303;
    public static final int MOVIE_TEMPLATE_BUILD_FAILED = -300;
    public static final int RESOURCE_EMPTY = -100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.composition.builder.MediaBuilderFactory
 * JD-Core Version:    0.7.0.1
 */