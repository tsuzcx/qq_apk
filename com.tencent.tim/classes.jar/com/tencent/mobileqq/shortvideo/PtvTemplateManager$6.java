package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import igk;
import igl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jll;

class PtvTemplateManager$6
  implements Runnable
{
  PtvTemplateManager$6(PtvTemplateManager paramPtvTemplateManager, Runnable paramRunnable) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, String.format("双人挂件加载 start, rebuildTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    Object localObject1 = igl.b(106).content;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      return;
      ??? = PtvTemplateManager.a(this.this$0, (String)localObject1);
      if ((??? == null) || (((List)???).isEmpty())) {
        continue;
      }
      localObject1 = new ArrayList();
      int i = jll.mM();
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "cur version:" + i);
      }
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)???).next();
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateManager", 2, String.format("the pandent[%s], platform[%s]", new Object[] { localPtvTemplateInfo.id, Integer.valueOf(localPtvTemplateInfo.platform) }));
        }
        if ((localPtvTemplateInfo.platform == 0) || (i >= localPtvTemplateInfo.platform))
        {
          localPtvTemplateInfo.usable = this.this$0.a(localPtvTemplateInfo);
          ((List)localObject1).add(localPtvTemplateInfo);
        }
        else if (QLog.isDevelopLevel())
        {
          QLog.d("PtvTemplateManager", 4, String.format("双人挂件加载, platform不符合, %s", new Object[] { localPtvTemplateInfo }));
        }
      }
      boolean bool;
      if (QLog.isDevelopLevel())
      {
        i = ((List)localObject1).size();
        if (this.hy == null) {
          break label427;
        }
        bool = true;
        QLog.d("PtvTemplateManager", 2, String.format("双人挂件加载 size[%s], onInitFinishSink[%s], mVersion[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), this.this$0.mVersion }));
      }
      synchronized (this.this$0.Au)
      {
        QLog.w("PtvTemplateManager", 1, "initLocalTemplateConfigInfoWithExtra, isEmpty[" + this.this$0.Au.isEmpty() + "], size[" + ((List)localObject1).size() + "]");
        this.this$0.Au.clear();
        this.this$0.Au.addAll((Collection)localObject1);
        if (this.hy == null) {
          continue;
        }
        this.hy.run();
        return;
        label427:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.6
 * JD-Core Version:    0.7.0.1
 */