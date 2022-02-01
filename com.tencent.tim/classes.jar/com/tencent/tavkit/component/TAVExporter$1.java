package com.tencent.tavkit.component;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.decoder.logger.Logger;

class TAVExporter$1
  implements AssetExportSession.ExportCallbackHandler
{
  TAVExporter$1(TAVExporter paramTAVExporter, String paramString) {}
  
  public void handlerCallback(AssetExportSession paramAssetExportSession)
  {
    switch (TAVExporter.2.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[paramAssetExportSession.getStatus().ordinal()])
    {
    default: 
      return;
    case 1: 
      if (TAVExporter.access$000(this.this$0) != null)
      {
        Logger.i(TAVExporter.access$100(this.this$0), "export progress: " + paramAssetExportSession.getProgress(), new Object[0]);
        if (!TAVExporter.access$200(this.this$0)) {
          TAVExporter.access$000(this.this$0).onExportStart();
        }
        TAVExporter.access$000(this.this$0).onExporting(paramAssetExportSession.getProgress());
      }
      TAVExporter.access$202(this.this$0, true);
      return;
    case 2: 
      Logger.i(TAVExporter.access$100(this.this$0), "export progress finished", new Object[0]);
      if (TAVExporter.access$000(this.this$0) != null) {
        TAVExporter.access$000(this.this$0).onExportCompleted(this.val$outputPath);
      }
      TAVExporter.access$202(this.this$0, false);
      return;
    case 3: 
    case 4: 
      Logger.i(TAVExporter.access$100(this.this$0), "export error", new Object[0]);
      if (TAVExporter.access$000(this.this$0) != null) {
        TAVExporter.access$000(this.this$0).onExportError();
      }
      TAVExporter.access$202(this.this$0, false);
      return;
    }
    Logger.i(TAVExporter.access$100(this.this$0), "export cancel", new Object[0]);
    if ((TAVExporter.access$000(this.this$0) != null) && (TAVExporter.access$300(this.this$0)))
    {
      TAVExporter.access$302(this.this$0, false);
      TAVExporter.access$000(this.this$0).onExportCancel();
    }
    TAVExporter.access$202(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVExporter.1
 * JD-Core Version:    0.7.0.1
 */