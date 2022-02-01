package com.tencent.ttpic.openapi.cache;

import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.cache.LoadItemManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class VideoMemoryManager$1
  implements Runnable
{
  VideoMemoryManager$1(VideoMemoryManager paramVideoMemoryManager, VideoMaterial paramVideoMaterial, List paramList) {}
  
  public void run()
  {
    long l1 = DeviceUtils.getRuntimeRemainSize(1);
    if (((l1 <= 30720L) || (VideoMemoryManager.isInBlackList())) && (this.this$0.isForceLoadFromSdCard())) {}
    for (;;)
    {
      return;
      long l2 = Math.min(Math.max(Math.min(l1 * 0.75D, l1 - 30720L), 0.0D), DeviceInstance.getInstance().getMaxMemorySizeInKB());
      l1 = l2;
      if (VideoMemoryManager.access$000(this.this$0) > 0) {
        l1 = Math.min(l2, VideoMemoryManager.access$000(this.this$0));
      }
      l2 = VideoMemoryManager.access$100(this.this$0, this.val$material);
      VideoMemoryManager.access$202(this.this$0, l2 / 1024L);
      VideoMemoryManager.access$302(this.this$0, VideoMaterialUtil.calSampleSize(l1, l2));
      LogUtils.d(VideoMemoryManager.access$400(), "[heap size] = " + l1 / 1024L + " MB, [material size] = " + VideoMemoryManager.access$200(this.this$0) + " MB, [sampleSize] = " + VideoMemoryManager.access$300(this.this$0));
      VideoMemoryManager.access$500(this.this$0, this.val$material, VideoMemoryManager.access$300(this.this$0), this.val$items);
      VideoMemoryManager.access$600(this.this$0, this.val$material, VideoMemoryManager.access$300(this.this$0));
      Iterator localIterator = VideoMemoryManager.access$700(this.this$0).values().iterator();
      while (localIterator.hasNext()) {
        ((LoadItemManager)localIterator.next()).prepareImages();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.VideoMemoryManager.1
 * JD-Core Version:    0.7.0.1
 */