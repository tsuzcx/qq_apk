package com.tencent.ttpic.openapi.cache;

import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import java.io.File;
import java.util.Map;

class VideoMemoryManager$3
  implements Runnable
{
  VideoMemoryManager$3(VideoMemoryManager paramVideoMemoryManager, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.val$externalDir == null)
    {
      localObject = this.val$assertsDir;
      localObject = (String)localObject + File.separator + this.val$resource;
      if (!this.val$encrypted) {
        break label85;
      }
    }
    label85:
    for (Object localObject = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile((String)localObject);; localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, 1))
    {
      if (localObject != null) {
        VideoMemoryManager.access$1100(this.this$0).put(this.val$resource, localObject);
      }
      return;
      localObject = this.val$externalDir;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.VideoMemoryManager.3
 * JD-Core Version:    0.7.0.1
 */