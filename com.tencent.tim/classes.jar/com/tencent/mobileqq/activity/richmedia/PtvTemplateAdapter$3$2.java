package com.tencent.mobileqq.activity.richmedia;

import aasb;
import aase;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class PtvTemplateAdapter$3$2
  implements Runnable
{
  public PtvTemplateAdapter$3$2(aase paramaase, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt) {}
  
  public void run()
  {
    int j = this.a.b.mListView.getFirstVisiblePosition();
    int k = this.a.b.mListView.getLastVisiblePosition();
    int i = j;
    Object localObject;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.a.b.mTemplateList.get(i);
      } while ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.d.id)));
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateManager", 2, "onProgressUpdate index: " + i + " progress: " + this.val$progress);
      }
      ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = true;
      localObject = this.a.b.mListView.getChildAt(i - j);
      if ((localObject instanceof PtvTemplateItemView))
      {
        localObject = (PtvTemplateItemView)localObject;
        if (this.val$progress != 100) {
          break label189;
        }
      }
    }
    label189:
    for (i = 99;; i = this.val$progress)
    {
      ((PtvTemplateItemView)localObject).mE(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.3.2
 * JD-Core Version:    0.7.0.1
 */