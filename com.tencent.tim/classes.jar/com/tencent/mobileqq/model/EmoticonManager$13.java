package com.tencent.mobileqq.model;

import ajdg;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;

public class EmoticonManager$13
  implements Runnable
{
  public EmoticonManager$13(ajdg paramajdg, String paramString) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.em.find(EmoticonTab.class, this.aMY);
    if (localEmoticonTab != null) {}
    for (localEmoticonTab.kandianHave = true;; localEmoticonTab.kandianHave = true)
    {
      ajdg.a(this.this$0, localEmoticonTab);
      return;
      localEmoticonTab = new EmoticonTab();
      localEmoticonTab.epId = this.aMY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.13
 * JD-Core Version:    0.7.0.1
 */