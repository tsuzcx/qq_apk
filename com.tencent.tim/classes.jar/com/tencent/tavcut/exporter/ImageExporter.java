package com.tencent.tavcut.exporter;

import android.content.Context;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.Util;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageExporter
{
  private final String TAG = ImageExporter.class.getSimpleName();
  private boolean cancel = false;
  private Context context;
  private ImageExportConfig imageExportConfig;
  private List<MediaModel> mediaModels;
  
  public void cancel()
  {
    this.cancel = true;
  }
  
  protected void constrainRenderSize(int paramInt1, int paramInt2, VideoRenderChainManager paramVideoRenderChainManager)
  {
    CGSize localCGSize = new CGSize(paramInt1, paramInt2);
    int i;
    Size localSize;
    if (this.imageExportConfig != null)
    {
      i = this.imageExportConfig.getMaxIntermediateRenderSize();
      if (i != -1)
      {
        localSize = Util.constrainMaxSize(new Size(paramInt1, paramInt2), i);
        localCGSize.width = localSize.getWidth();
        localCGSize.height = localSize.getHeight();
      }
      if (this.imageExportConfig == null) {
        break label196;
      }
    }
    label196:
    for (paramInt1 = this.imageExportConfig.getMinIntermediateRenderSize();; paramInt1 = -1)
    {
      if (paramInt1 != -1)
      {
        localSize = Util.constrainMinSize(new Size((int)localCGSize.width, (int)localCGSize.height), paramInt1);
        localCGSize.width = localSize.getWidth();
        localCGSize.height = localSize.getHeight();
      }
      Logger.i(this.TAG, String.format("targetRenderSize = %d * %d", new Object[] { Integer.valueOf((int)localCGSize.width), Integer.valueOf((int)localCGSize.height) }));
      paramVideoRenderChainManager.getComposition().setRenderSize(localCGSize);
      return;
      i = -1;
      break;
    }
  }
  
  public void export(ImageExportCallback paramImageExportCallback)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    localExecutorService.submit(new ImageExporter.1(this, paramImageExportCallback, localExecutorService));
  }
  
  public List<MediaModel> getMediaModels()
  {
    return this.mediaModels;
  }
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void setImageExportConfig(ImageExportConfig paramImageExportConfig)
  {
    this.imageExportConfig = paramImageExportConfig;
  }
  
  public void setMediaModels(List<MediaModel> paramList)
  {
    this.mediaModels = paramList;
  }
  
  public static abstract interface ImageExportCallback
  {
    public abstract void onCancelled();
    
    public abstract void onExportComplete();
    
    public abstract void onFailed(Collection<String> paramCollection);
    
    public abstract void onImageExport(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.exporter.ImageExporter
 * JD-Core Version:    0.7.0.1
 */