package com.tencent.tavcut.exporter;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tavcut.util.Logger;

class MovieExporter$1
  implements AssetExportSession.ExportCallbackHandler
{
  MovieExporter$1(MovieExporter paramMovieExporter, String paramString) {}
  
  public void handlerCallback(AssetExportSession paramAssetExportSession)
  {
    switch (MovieExporter.2.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[paramAssetExportSession.getStatus().ordinal()])
    {
    default: 
      return;
    case 1: 
      if (MovieExporter.access$000(this.this$0) != null)
      {
        if (!MovieExporter.access$100(this.this$0)) {
          MovieExporter.access$000(this.this$0).onExportStart();
        }
        MovieExporter.access$000(this.this$0).onExporting(paramAssetExportSession.getProgress());
      }
      MovieExporter.access$102(this.this$0, true);
      return;
    case 2: 
      Logger.i("MovieExporter", "export progress finished");
      if (MovieExporter.access$000(this.this$0) != null) {
        MovieExporter.access$000(this.this$0).onExportCompleted(this.val$outputPath);
      }
      MovieExporter.access$102(this.this$0, false);
      return;
    case 3: 
    case 4: 
      Logger.i("MovieExporter", "export error");
      if (MovieExporter.access$000(this.this$0) != null) {
        MovieExporter.access$000(this.this$0).onExportError(paramAssetExportSession);
      }
      MovieExporter.access$102(this.this$0, false);
      return;
    }
    Logger.i("MovieExporter", "export cancel");
    if ((MovieExporter.access$000(this.this$0) != null) && (MovieExporter.access$200(this.this$0)))
    {
      MovieExporter.access$202(this.this$0, false);
      MovieExporter.access$000(this.this$0).onExportCancel();
    }
    MovieExporter.access$102(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.exporter.MovieExporter.1
 * JD-Core Version:    0.7.0.1
 */