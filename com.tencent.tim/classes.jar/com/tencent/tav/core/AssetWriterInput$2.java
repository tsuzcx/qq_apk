package com.tencent.tav.core;

import android.support.annotation.RequiresApi;
import com.tencent.tav.decoder.EncoderWriter;

class AssetWriterInput$2
  implements Runnable
{
  AssetWriterInput$2(AssetWriterInput paramAssetWriterInput) {}
  
  @RequiresApi(api=18)
  public void run()
  {
    if (AssetWriterInput.access$200(this.this$0) == 1) {}
    for (;;)
    {
      try
      {
        AssetWriterInput.access$300(this.this$0).endWriteVideoSample();
        if (AssetWriterInput.access$400(this.this$0) != null) {
          AssetWriterInput.access$400(this.this$0).onProgressChanged(this.this$0, -1L);
        }
        return;
      }
      catch (Throwable localThrowable1)
      {
        if (AssetWriterInput.access$400(this.this$0) == null) {
          continue;
        }
        AssetWriterInput.access$400(this.this$0).onError(new ExportErrorStatus(-123, localThrowable1));
        return;
      }
      try
      {
        AssetWriterInput.access$300(this.this$0).endWriteAudioSample();
        if (AssetWriterInput.access$400(this.this$0) != null)
        {
          AssetWriterInput.access$400(this.this$0).onProgressChanged(this.this$0, -1L);
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        while (AssetWriterInput.access$400(this.this$0) == null) {}
        AssetWriterInput.access$400(this.this$0).onError(new ExportErrorStatus(-124, localThrowable2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.2
 * JD-Core Version:    0.7.0.1
 */