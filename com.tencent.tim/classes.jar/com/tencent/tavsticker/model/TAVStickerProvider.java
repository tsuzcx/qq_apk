package com.tencent.tavsticker.model;

import android.graphics.Matrix;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavsticker.core.ITAVStickerRenderer;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.ScreenUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.List;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGLayer;
import org.libpag.PAGRenderer;
import org.libpag.PAGSurface;
import org.libpag.PAGText;

public class TAVStickerProvider
  implements ITAVStickerRenderer
{
  private static final String TAG = TAVStickerProvider.class.getSimpleName();
  private boolean isHighQuality = true;
  private PAGRenderer mPagRenderer = null;
  private CGSize mRenderSize = CGSize.CGSizeZero;
  private TAVSticker mTavSticker = null;
  
  public TAVStickerProvider(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker == null) {
      throw new IllegalArgumentException("initWithSticker, parameter 'tavSticker' can not null");
    }
    this.mTavSticker = paramTAVSticker;
    this.mPagRenderer = new PAGRenderer();
    this.mPagRenderer.setFile(this.mTavSticker.getPagFile());
    this.mTavSticker.registerRenderer(this);
    resetRenderConfigs();
  }
  
  private void resetRenderConfigs()
  {
    if (this.mPagRenderer == null) {
      return;
    }
    if ((this.isHighQuality) || (!TAVStickerUtil.isValidCGSize(this.mRenderSize)))
    {
      this.mPagRenderer.setCacheEnabled(true);
      this.mPagRenderer.setMaxFrameRate(60.0F);
      this.mPagRenderer.setCacheScale(1.0F);
      return;
    }
    this.mPagRenderer.setMaxFrameRate(24.0F);
    float f3 = ScreenUtil.getScreenWidth();
    float f1 = ScreenUtil.getScreenHeight();
    float f4 = this.mRenderSize.width;
    float f2 = this.mRenderSize.height;
    f3 = f4 / (f3 * 1.0F);
    f1 = f2 / (f1 * 1.0F);
    this.mPagRenderer.setCacheScale(Math.max(f3, f1));
  }
  
  private void updateTransform()
  {
    if ((TAVStickerUtil.isValidCGSize(this.mRenderSize)) && (this.mPagRenderer != null) && (this.mTavSticker != null))
    {
      Matrix localMatrix = TAVStickerUtil.getMatrix(this.mTavSticker, (int)this.mRenderSize.width, (int)this.mRenderSize.height);
      this.mPagRenderer.setMatrix(localMatrix);
    }
  }
  
  public TAVSticker getSticker()
  {
    return this.mTavSticker;
  }
  
  public List<TAVStickerLayerItem> getUnderPointLayerItems(float paramFloat1, float paramFloat2)
  {
    Object localObject;
    if ((this.mPagRenderer != null) && (this.mTavSticker != null))
    {
      ArrayList localArrayList = new ArrayList();
      PAGLayer[] arrayOfPAGLayer = this.mPagRenderer.getLayersUnderPoint(paramFloat1, paramFloat2);
      localObject = localArrayList;
      if (arrayOfPAGLayer != null)
      {
        int j = arrayOfPAGLayer.length;
        int i = 0;
        localObject = localArrayList;
        if (i < j)
        {
          localObject = arrayOfPAGLayer[i];
          int k;
          if (localObject != null)
          {
            if (3 != ((PAGLayer)localObject).layerType()) {
              break label118;
            }
            k = ((PAGLayer)localObject).editableIndex();
            localObject = this.mTavSticker.getTavStickerTextItem(k);
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label118:
            if (5 == ((PAGLayer)localObject).layerType())
            {
              k = ((PAGLayer)localObject).editableIndex();
              localObject = this.mTavSticker.getTavStickerImageItem(k);
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
          }
        }
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public void release()
  {
    if (this.mPagRenderer != null)
    {
      this.mPagRenderer.setSurface(null);
      this.mPagRenderer = null;
    }
  }
  
  public void replaceSourceImages(List<TAVSourceImage> paramList)
  {
    if ((this.mTavSticker != null) && (this.mTavSticker.getPagFile() != null) && (!CollectionUtil.isEmptyList(paramList)))
    {
      paramList = new ArrayList(paramList);
      int j = this.mTavSticker.getPagFile().numImages();
      int k = paramList.size();
      TLog.d(TAG, "replaceSourceImages ->  numImages : " + j + ", sourceImagesCount : " + k);
      int i = 0;
      while (i < k)
      {
        TAVSourceImage localTAVSourceImage = (TAVSourceImage)paramList.get(i);
        if (localTAVSourceImage != null)
        {
          PAGImage localPAGImage = localTAVSourceImage.getPagImage();
          int m = localTAVSourceImage.getIndex();
          if ((this.mPagRenderer != null) && (m >= 0) && (m < j)) {
            this.mPagRenderer.replaceImage(m, localPAGImage);
          }
        }
        i += 1;
      }
    }
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    if (this.mPagRenderer != null) {
      this.mPagRenderer.setCacheEnabled(paramBoolean);
    }
  }
  
  public void setHighQuality(boolean paramBoolean)
  {
    if (this.isHighQuality != paramBoolean) {
      resetRenderConfigs();
    }
    this.isHighQuality = paramBoolean;
  }
  
  public void setImageData(int paramInt, PAGImage paramPAGImage)
  {
    if (this.mPagRenderer != null)
    {
      this.mPagRenderer.replaceImage(paramInt, paramPAGImage);
      this.mPagRenderer.flush();
    }
  }
  
  public void setPagSurface(PAGSurface paramPAGSurface)
  {
    if ((this.mPagRenderer != null) && (paramPAGSurface != this.mPagRenderer.getSurface())) {
      this.mPagRenderer.setSurface(paramPAGSurface);
    }
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    if ((TAVStickerUtil.isValidCGSize(paramCGSize)) && (!paramCGSize.equals(this.mRenderSize)))
    {
      this.mRenderSize = paramCGSize;
      resetRenderConfigs();
    }
  }
  
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    if (this.mPagRenderer != null) {
      this.mPagRenderer.setTextData(paramInt, paramPAGText);
    }
  }
  
  /* Error */
  public void updateRender(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/tavsticker/model/TAVStickerProvider:mPagRenderer	Lorg/libpag/PAGRenderer;
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 33	com/tencent/tavsticker/model/TAVStickerProvider:mTavSticker	Lcom/tencent/tavsticker/model/TAVSticker;
    //   13: ifnonnull +14 -> 27
    //   16: getstatic 26	com/tencent/tavsticker/model/TAVStickerProvider:TAG	Ljava/lang/String;
    //   19: ldc 243
    //   21: invokestatic 246	com/tencent/tavsticker/log/TLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: invokespecial 248	com/tencent/tavsticker/model/TAVStickerProvider:updateTransform	()V
    //   31: aload_0
    //   32: getfield 33	com/tencent/tavsticker/model/TAVStickerProvider:mTavSticker	Lcom/tencent/tavsticker/model/TAVSticker;
    //   35: lload_1
    //   36: invokevirtual 252	com/tencent/tavsticker/model/TAVSticker:computeProgress	(J)D
    //   39: dstore_3
    //   40: aload_0
    //   41: getfield 44	com/tencent/tavsticker/model/TAVStickerProvider:mPagRenderer	Lorg/libpag/PAGRenderer;
    //   44: dload_3
    //   45: invokevirtual 256	org/libpag/PAGRenderer:setProgress	(D)V
    //   48: aload_0
    //   49: getfield 44	com/tencent/tavsticker/model/TAVStickerProvider:mPagRenderer	Lorg/libpag/PAGRenderer;
    //   52: invokevirtual 259	org/libpag/PAGRenderer:draw	()V
    //   55: goto -31 -> 24
    //   58: astore 5
    //   60: aload_0
    //   61: monitorexit
    //   62: aload 5
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	TAVStickerProvider
    //   0	65	1	paramLong	long
    //   39	6	3	d	double
    //   58	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	58	finally
    //   16	24	58	finally
    //   27	55	58	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerProvider
 * JD-Core Version:    0.7.0.1
 */