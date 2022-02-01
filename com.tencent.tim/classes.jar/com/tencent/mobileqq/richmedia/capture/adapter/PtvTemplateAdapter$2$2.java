package com.tencent.mobileqq.richmedia.capture.adapter;

import alvx;
import alvz;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;

public class PtvTemplateAdapter$2$2
  implements Runnable
{
  public PtvTemplateAdapter$2$2(alvz paramalvz, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt) {}
  
  public void run()
  {
    int j = this.a.a.e.getFirstVisiblePosition();
    int k = this.a.a.e.getLastVisiblePosition();
    int i = j;
    Object localObject;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.a.a.mTemplateList.get(i);
      } while ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.d.id)));
      if (QLog.isColorLevel()) {
        QLog.i("CapturePtvTemplateManager", 2, "onProgressUpdate index: " + i + " progress: " + this.val$progress);
      }
      ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = true;
      localObject = this.a.a.e.getChildAt(i - j);
      if ((localObject instanceof PtvTemplateItemView))
      {
        localObject = (PtvTemplateItemView)localObject;
        if (this.val$progress != 100) {
          break label193;
        }
      }
    }
    label193:
    for (i = 99;; i = this.val$progress)
    {
      ((PtvTemplateItemView)localObject).c(this.d, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.2.2
 * JD-Core Version:    0.7.0.1
 */