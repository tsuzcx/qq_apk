package dov.com.qq.im.aeeditor.module.filter;

import axiy;
import axmr;
import axmu;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class AEEditorFiltersManager$4
  implements Runnable
{
  public AEEditorFiltersManager$4(axmr paramaxmr) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    axiy.i("AEEditorFiltersManager", "preDownloadAllRes---BEGIN");
    axmr.a(this.this$0);
    axiy.i("AEEditorFiltersManager", "preDownloadAllRes---ensureSetupDownloadConfig finish");
    ArrayList localArrayList = new ArrayList();
    Object localObject = axmr.a(this.this$0).values().iterator();
    AEEditorDownloadResBean localAEEditorDownloadResBean;
    while (((Iterator)localObject).hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)((Iterator)localObject).next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!axmr.a(this.this$0, localAEEditorDownloadResBean))) {
        localArrayList.add(localAEEditorDownloadResBean);
      }
    }
    axiy.i("AEEditorFiltersManager", "preDownloadAllRes---needDownloads size=" + localArrayList.size());
    int i = 0;
    for (;;)
    {
      if (i < localArrayList.size())
      {
        int k = Math.min(4, localArrayList.size() - i);
        localObject = new CountDownLatch(k);
        int j = 0;
        while (j < k)
        {
          localAEEditorDownloadResBean = (AEEditorDownloadResBean)localArrayList.get(i);
          axiy.i("AEEditorFiltersManager", "preDownloadAllRes---[begin] " + i + ", id=" + localAEEditorDownloadResBean.getId());
          axmr.a(this.this$0, localAEEditorDownloadResBean, new axmu(this, i, localAEEditorDownloadResBean, (CountDownLatch)localObject));
          j += 1;
          i += 1;
        }
        try
        {
          ((CountDownLatch)localObject).await();
          axiy.i("AEEditorFiltersManager", "preDownloadAllRes--------------------finish a little group---------------------");
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    long l2 = System.currentTimeMillis();
    axiy.i("AEEditorFiltersManager", "preDownloadAllRes---END cost=" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.4
 * JD-Core Version:    0.7.0.1
 */