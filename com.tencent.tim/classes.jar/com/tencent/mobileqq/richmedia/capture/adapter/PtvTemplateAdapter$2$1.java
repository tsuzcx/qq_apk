package com.tencent.mobileqq.richmedia.capture.adapter;

import alvx;
import alvz;
import alwd;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView.a;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;

public class PtvTemplateAdapter$2$1
  implements Runnable
{
  public PtvTemplateAdapter$2$1(alvz paramalvz, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.a.a.e.getFirstVisiblePosition();
    int k = this.a.a.e.getLastVisiblePosition();
    int i = j;
    Object localObject1;
    Object localObject2;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject1 = (PtvTemplateManager.PtvTemplateInfo)this.a.a.mTemplateList.get(i);
      } while ((localObject1 == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject1).id.equals(this.d.id)));
      ((PtvTemplateManager.PtvTemplateInfo)localObject1).downloading = false;
      ((PtvTemplateManager.PtvTemplateInfo)localObject1).usable = this.val$isSuccess;
      localObject2 = this.a.a.e.getChildAt(i - j);
      if ((localObject2 instanceof PtvTemplateItemView))
      {
        localObject2 = (PtvTemplateItemView)localObject2;
        localPtvTemplateInfo = this.d;
        if (!this.val$isSuccess) {
          break label396;
        }
      }
    }
    label396:
    for (i = 1000;; i = -1)
    {
      ((PtvTemplateItemView)localObject2).c(localPtvTemplateInfo, i);
      alwd.a().F(112, localObject1);
      if ((QLog.isColorLevel()) && (this.a.a.b != null)) {
        QLog.i("CapturePtvTemplateManager", 2, "onDownloadFinish mCurrentPtvTemplateInfo=" + this.a.a.b.id + " info=" + this.d.id);
      }
      if ((this.a.a.b != null) && (this.a.a.b.id.equals(this.d.id)) && (this.d.usable))
      {
        localObject1 = alwd.bt(this.a.a.b.name, this.a.a.b.md5);
        this.a.a.bec = ((String)localObject1);
        alwd.a().c(this.d);
        alwd.a().F(113, null);
        if (alvx.a(this.a.a) != null) {
          alvx.a(this.a.a).a(this.d, this.a.a.bec);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */