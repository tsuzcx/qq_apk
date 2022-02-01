package com.tencent.tav.extractor;

import android.graphics.Matrix;
import android.media.MediaFormat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderUtils;

public class ExtractorUtils
{
  public static final String MIME_AUDIO = "audio/";
  public static final String MIME_VIDEO = "video/";
  
  public static void applyMirror(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramMatrix == null) {
      return;
    }
    Matrix localMatrix = new Matrix();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramMatrix.postConcat(localMatrix);
      return;
      localMatrix.postScale(-1.0F, 1.0F);
      localMatrix.postTranslate(paramInt2, 0.0F);
      continue;
      localMatrix.postScale(1.0F, -1.0F);
      localMatrix.postTranslate(0.0F, paramInt3);
      continue;
      localMatrix.postScale(-1.0F, -1.0F);
      localMatrix.postTranslate(paramInt2, paramInt3);
    }
  }
  
  public static int getFrameRate(MediaFormat paramMediaFormat)
  {
    if (paramMediaFormat != null) {}
    try
    {
      if (paramMediaFormat.containsKey("frame-rate"))
      {
        int i = paramMediaFormat.getInteger("frame-rate");
        return i;
      }
    }
    catch (Exception paramMediaFormat)
    {
      return 0;
    }
    catch (Error paramMediaFormat)
    {
      label23:
      break label23;
    }
  }
  
  public static int getPreferRotation(AssetExtractor paramAssetExtractor)
  {
    try
    {
      paramAssetExtractor = DecoderUtils.getFirstFormat(paramAssetExtractor, "video/");
      if ((paramAssetExtractor != null) && (paramAssetExtractor.containsKey("rotation-degrees")))
      {
        int i = paramAssetExtractor.getInteger("rotation-degrees") / 90;
        return i;
      }
    }
    catch (Exception paramAssetExtractor)
    {
      return 0;
    }
    catch (Error paramAssetExtractor)
    {
      label33:
      break label33;
    }
  }
  
  public static CGSize getVideoSize(AssetExtractor paramAssetExtractor)
  {
    try
    {
      paramAssetExtractor = DecoderUtils.getFirstFormat(paramAssetExtractor, "video/");
      CGSize localCGSize = new CGSize();
      if (paramAssetExtractor != null)
      {
        if (paramAssetExtractor.containsKey("display-width")) {}
        for (localCGSize.width = paramAssetExtractor.getInteger("display-width"); paramAssetExtractor.containsKey("display-height"); localCGSize.width = paramAssetExtractor.getInteger("width"))
        {
          localCGSize.height = paramAssetExtractor.getInteger("display-height");
          return localCGSize;
        }
      }
      label76:
      return localCGSize;
    }
    catch (Exception paramAssetExtractor)
    {
      return new CGSize();
      localCGSize.height = paramAssetExtractor.getInteger("height");
      return localCGSize;
    }
    catch (Error paramAssetExtractor)
    {
      break label76;
    }
  }
  
  public static boolean isSameExtractor(DecoderAssetTrack paramDecoderAssetTrack1, DecoderAssetTrack paramDecoderAssetTrack2)
  {
    if ((paramDecoderAssetTrack1 != null) && (paramDecoderAssetTrack2 != null)) {}
    for (int i = 1; (i != 0) && (paramDecoderAssetTrack1.assetPath != null) && (paramDecoderAssetTrack1.assetPath.equals(paramDecoderAssetTrack2.assetPath)); i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tav.extractor.ExtractorUtils
 * JD-Core Version:    0.7.0.1
 */