package com.tencent.mobileqq.model;

import ajdg;
import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;

public class EmoticonManager$16
  implements Runnable
{
  public EmoticonManager$16(ajdg paramajdg, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.em.find(EmoticonTab.class, this.aMY);
    if (localEmoticonTab != null)
    {
      if (this.cnA) {
        localEmoticonTab.aioHave = false;
      }
      if (this.cnB) {
        localEmoticonTab.kandianHave = false;
      }
      if ((localEmoticonTab.aioHave) || (localEmoticonTab.kandianHave)) {
        break label112;
      }
      this.this$0.em.remove(localEmoticonTab);
    }
    for (;;)
    {
      this.this$0.Mm(this.aMY);
      aqmj.B(this.this$0.app.getApp(), this.this$0.app.getCurrentUin(), System.currentTimeMillis());
      return;
      label112:
      ajdg.a(this.this$0, localEmoticonTab);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.16
 * JD-Core Version:    0.7.0.1
 */