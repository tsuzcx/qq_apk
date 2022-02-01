package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class PtvTemplateManager$16
  implements Runnable
{
  PtvTemplateManager$16(PtvTemplateManager paramPtvTemplateManager, AppInterface paramAppInterface, File paramFile) {}
  
  public void run()
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (this.b != null)
      {
        bool = true;
        QLog.i("PtvTemplateManager", 2, String.format("initBlessSpecialPendantConfigInfo, app[%s], isUpdateedByServer[%s], cur_runnable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.this$0.cFj), Integer.valueOf(hashCode()) }));
      }
    }
    else {
      if (!this.this$0.cFj) {
        break label76;
      }
    }
    label76:
    Object localObject1;
    do
    {
      do
      {
        return;
        bool = false;
        break;
        localObject1 = PtvTemplateManager.p(this.T);
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      localObject1 = PtvTemplateManager.a(this.this$0, (String)localObject1);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    ??? = ((List)localObject1).iterator();
    while (((Iterator)???).hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)???).next();
      if (localPtvTemplateInfo != null)
      {
        localPtvTemplateInfo.usable = this.this$0.a(localPtvTemplateInfo);
        localPtvTemplateInfo.businessID = 1;
      }
    }
    synchronized (this.this$0.Aw)
    {
      if (this.this$0.cFj) {
        return;
      }
    }
    this.this$0.Aw.clear();
    this.this$0.Aw.addAll(localCollection);
    this.this$0.cFk = true;
    PtvTemplateManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.16
 * JD-Core Version:    0.7.0.1
 */