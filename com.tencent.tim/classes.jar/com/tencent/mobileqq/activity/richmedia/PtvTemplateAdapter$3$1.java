package com.tencent.mobileqq.activity.richmedia;

import aasb;
import aase;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class PtvTemplateAdapter$3$1
  implements Runnable
{
  public PtvTemplateAdapter$3$1(aase paramaase, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = -1;
    int m = this.a.b.mListView.getFirstVisiblePosition();
    int n = this.a.b.mListView.getLastVisiblePosition();
    int i = m;
    int k = j;
    Object localObject;
    if (i <= n)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.a.b.mTemplateList.get(i);
      } while ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.d.id)));
      ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = false;
      ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.val$isSuccess;
      ((PtvTemplateManager.PtvTemplateInfo)localObject).doDownloadDataReport();
      localObject = this.a.b.mListView.getChildAt(i - m);
      if ((localObject instanceof PtvTemplateItemView))
      {
        localObject = (PtvTemplateItemView)localObject;
        if (this.val$isSuccess) {
          j = 1000;
        }
        ((PtvTemplateItemView)localObject).mE(j);
      }
      k = i;
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if ((this.a.b.getCurrentPosition() == k) && (this.val$isSuccess) && (this.a.b.b != null))
    {
      localObject = PtvTemplateManager.bYM + this.d.name;
      this.a.b.bec = ((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "current mCurrentTemplatePath:" + this.a.b.bec);
      }
      if (this.a.b.b != null)
      {
        localPtvTemplateInfo = this.a.b.a();
        if ((localPtvTemplateInfo != null) && ((localPtvTemplateInfo == null) || (localPtvTemplateInfo.category != 0))) {
          break label342;
        }
        this.a.b.b.setVideoFilter((String)localObject);
      }
    }
    label342:
    while (localPtvTemplateInfo == null) {
      return;
    }
    this.a.b.b.setVideoFilter((String)localObject, localPtvTemplateInfo.category, localPtvTemplateInfo.gestureType, localPtvTemplateInfo.gestureWording);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */