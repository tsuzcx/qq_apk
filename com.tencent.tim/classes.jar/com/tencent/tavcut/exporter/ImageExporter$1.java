package com.tencent.tavcut.exporter;

import com.google.gson.Gson;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.Util;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.composition.builder.MediaBuilderFactory;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class ImageExporter$1
  implements Runnable
{
  ImageExporter$1(ImageExporter paramImageExporter, ImageExporter.ImageExportCallback paramImageExportCallback, ExecutorService paramExecutorService) {}
  
  public void run()
  {
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    LinkedBlockingDeque localLinkedBlockingDeque = new LinkedBlockingDeque();
    int i = 0;
    if (i < ImageExporter.access$000(this.this$0).size())
    {
      if (ImageExporter.access$100(this.this$0))
      {
        if (this.val$callback != null) {
          this.val$callback.onCancelled();
        }
        this.val$executorService.shutdown();
      }
    }
    else {
      return;
    }
    MediaModel localMediaModel = (MediaModel)new Gson().fromJson(((MediaModel)ImageExporter.access$000(this.this$0).get(i)).toString(), MediaModel.class);
    String str = ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getPath();
    Object localObject1 = BitmapUtil.getImageSize(str, false);
    label163:
    Object localObject2;
    int k;
    if (ImageExporter.access$200(this.this$0) != null)
    {
      j = ImageExporter.access$200(this.this$0).getMaxExportSize();
      if (j != -1)
      {
        localObject2 = Util.constrainMaxSize((Size)localObject1, j);
        k = ((Size)localObject1).getWidth() / ((Size)localObject2).getWidth();
        if (((Size)localObject1).getWidth() % ((Size)localObject2).getWidth() != 0) {
          break label372;
        }
      }
    }
    label372:
    for (int j = 0;; j = 1)
    {
      k = j + k;
      j = k;
      if (k <= 0) {
        j = 1;
      }
      ((Size)localObject1).setWidth(((Size)localObject1).getWidth() / j);
      ((Size)localObject1).setHeight(((Size)localObject1).getHeight() / j);
      ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().setWidth(((Size)localObject1).getWidth());
      ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().setHeight(((Size)localObject1).getHeight());
      localObject1 = (String)ImageExporter.access$200(this.this$0).getOutputPaths().get(i);
      localObject2 = new StickerController(ImageExporter.access$300(this.this$0));
      MediaBuilderFactory.mediaBuilderAsync(localMediaModel, (VideoRenderChainManager.IStickerContextInterface)localObject2, new ImageExporter.1.1(this, (StickerController)localObject2, localMediaModel, str, localLinkedBlockingDeque, (String)localObject1, localAtomicInteger));
      i += 1;
      break;
      j = -1;
      break label163;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.exporter.ImageExporter.1
 * JD-Core Version:    0.7.0.1
 */