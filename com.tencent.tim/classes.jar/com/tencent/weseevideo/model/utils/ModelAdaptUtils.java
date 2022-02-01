package com.tencent.weseevideo.model.utils;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.util.StickerUtil;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.base.TAVMovieAudioConfiguration;
import com.tencent.tavmovie.base.TAVMovieVideoConfiguration;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.resource.AudioConfigurationModel;
import com.tencent.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;

public class ModelAdaptUtils
{
  public static final String TAG = "ModelAdaptUtils";
  
  private static TAVVideoConfiguration.TAVVideoConfigurationContentMode getContentMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit;
    case 1: 
      return TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill;
    }
    return TAVVideoConfiguration.TAVVideoConfigurationContentMode.scaleToFit;
  }
  
  public static TAVSticker stickerModelToTAVSticker(@NonNull StickerModel paramStickerModel, @NonNull CGSize paramCGSize)
  {
    return StickerUtil.stickerModel2TavSticker(paramStickerModel);
  }
  
  public static TAVMovieAudioConfiguration transformToTAVAudioConfiguration(@NonNull AudioConfigurationModel paramAudioConfigurationModel)
  {
    return new TAVMovieAudioConfiguration();
  }
  
  public static TAVResource transformToTAVResource(@NonNull VideoResourceModel paramVideoResourceModel)
  {
    Object localObject = null;
    if ((paramVideoResourceModel.getType() == 1) || (paramVideoResourceModel.getType() == 3))
    {
      URLAsset localURLAsset = new URLAsset(paramVideoResourceModel.getPath());
      Log.e("debug", "videoResourceModel = " + paramVideoResourceModel);
      localObject = new TAVAssetTrackResource(localURLAsset);
      Log.e("debug", "asset.getDuration() = " + localURLAsset.getDuration());
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((TAVResource)localObject).setSourceTimeRange(new CMTimeRange(new CMTime(paramVideoResourceModel.getSourceTimeStart() + paramVideoResourceModel.getSelectTimeStart(), 1000), new CMTime(paramVideoResourceModel.getSelectTimeDuration(), 1000)));
        ((TAVResource)localObject).setScaledDuration(new CMTime(paramVideoResourceModel.getScaleDuration(), 1000));
      }
      return localObject;
      if (paramVideoResourceModel.getType() == 2)
      {
        localObject = new TAVImageTrackResource(paramVideoResourceModel.getPath(), new CMTime((float)paramVideoResourceModel.getSourceTimeDuration() / 1000.0F));
      }
      else if (paramVideoResourceModel.getType() == 4)
      {
        localObject = new CGSize(paramVideoResourceModel.getWidth(), paramVideoResourceModel.getHeight());
        localObject = new TAVImageResource(new CIImage(paramVideoResourceModel.getPath(), (CGSize)localObject), new CMTime((float)paramVideoResourceModel.getSourceTimeDuration() / 1000.0F));
      }
    }
  }
  
  public static TAVMovieVideoConfiguration transformToTAVVideoConfiguration(@NonNull VideoConfigurationModel paramVideoConfigurationModel)
  {
    TAVMovieVideoConfiguration localTAVMovieVideoConfiguration = new TAVMovieVideoConfiguration();
    localTAVMovieVideoConfiguration.setContentMode(getContentMode(paramVideoConfigurationModel.getContentMode()));
    Object localObject = paramVideoConfigurationModel.createFrameRect();
    if (localObject != null) {
      localTAVMovieVideoConfiguration.setFrame((CGRect)localObject);
    }
    localObject = new Matrix();
    ((Matrix)localObject).setValues(paramVideoConfigurationModel.getMatrix());
    localTAVMovieVideoConfiguration.setTransform((Matrix)localObject);
    localTAVMovieVideoConfiguration.setPreferRotation(paramVideoConfigurationModel.getRotate());
    return localTAVMovieVideoConfiguration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.utils.ModelAdaptUtils
 * JD-Core Version:    0.7.0.1
 */