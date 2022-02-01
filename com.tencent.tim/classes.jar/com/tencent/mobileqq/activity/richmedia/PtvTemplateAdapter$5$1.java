package com.tencent.mobileqq.activity.richmedia;

import aasb;
import aasg;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class PtvTemplateAdapter$5$1
  implements Runnable
{
  public PtvTemplateAdapter$5$1(aasg paramaasg, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.a.b.mListView.getFirstVisiblePosition();
    int k = this.a.b.mListView.getLastVisiblePosition();
    int i = j;
    for (;;)
    {
      Object localObject;
      if (i <= k)
      {
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.a.b.mTemplateList.get(i);
        if ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.d.id))) {
          break label148;
        }
        ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = false;
        ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.val$isSuccess;
        localObject = this.a.b.mListView.getChildAt(i - j);
        if ((localObject instanceof PtvTemplateItemView))
        {
          localObject = (PtvTemplateItemView)localObject;
          if (!this.val$isSuccess) {
            break label143;
          }
        }
      }
      label143:
      for (i = 1000;; i = -1)
      {
        ((PtvTemplateItemView)localObject).mE(i);
        return;
      }
      label148:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.5.1
 * JD-Core Version:    0.7.0.1
 */