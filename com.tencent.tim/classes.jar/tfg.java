import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListenerAdapter;
import com.tencent.ad.tangram.canvas.download.IAdDownloader.Callback;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class tfg
  implements AdCanvasDownloadListenerAdapter
{
  private List<IAdDownloader.Callback> listeners = new CopyOnWriteArrayList();
  
  public IAdDownloader.Callback getDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if ((this.listeners != null) && (this.listeners.size() > 0))
    {
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext())
      {
        IAdDownloader.Callback localCallback = (IAdDownloader.Callback)localIterator.next();
        if (((localCallback instanceof tff)) && (((tff)localCallback).getDownloadManager() == paramAdAppDownloadManager)) {
          return localCallback;
        }
      }
    }
    return null;
  }
  
  public void removeDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if ((this.listeners == null) || (paramAdAppDownloadManager == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext())
      {
        IAdDownloader.Callback localCallback = (IAdDownloader.Callback)localIterator.next();
        if ((localCallback instanceof tff))
        {
          AdAppDownloadManager localAdAppDownloadManager = ((tff)localCallback).getDownloadManager();
          if ((localAdAppDownloadManager != null) && (localAdAppDownloadManager == paramAdAppDownloadManager)) {
            this.listeners.remove(localCallback);
          }
        }
      }
    }
  }
  
  public void setDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if ((this.listeners != null) && (paramAdAppDownloadManager != null))
    {
      tff localtff = new tff();
      localtff.a(paramAdAppDownloadManager);
      this.listeners.add(localtff);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfg
 * JD-Core Version:    0.7.0.1
 */