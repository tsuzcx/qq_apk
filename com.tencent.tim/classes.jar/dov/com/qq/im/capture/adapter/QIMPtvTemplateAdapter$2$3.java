package dov.com.qq.im.capture.adapter;

import axpa;
import axpc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;

public class QIMPtvTemplateAdapter$2$3
  implements Runnable
{
  public QIMPtvTemplateAdapter$2$3(axpc paramaxpc, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt) {}
  
  public void run()
  {
    int j = this.a.this$0.e.getFirstVisiblePosition();
    int k = this.a.this$0.e.getLastVisiblePosition();
    int i = j;
    Object localObject;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.a.this$0.mTemplateList.get(i);
      } while ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.d.id)));
      if (QLog.isColorLevel()) {
        QLog.i("QIMPtvTemplateManager", 2, "onProgressUpdate index: " + i + " progress: " + this.val$progress);
      }
      ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = true;
      localObject = this.a.this$0.e.getChildAt(i - j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.3
 * JD-Core Version:    0.7.0.1
 */