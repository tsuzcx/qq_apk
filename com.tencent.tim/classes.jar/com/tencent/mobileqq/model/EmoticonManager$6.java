package com.tencent.mobileqq.model;

import ajdg;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class EmoticonManager$6
  implements Runnable
{
  public EmoticonManager$6(ajdg paramajdg, String paramString1, String paramString2) {}
  
  public void run()
  {
    Emoticon localEmoticon = (Emoticon)this.this$0.em.find(Emoticon.class, "epId=? and eId=?", new String[] { this.aMY, this.bQP });
    if (localEmoticon != null)
    {
      this.this$0.l.put(localEmoticon.getMapKey(), localEmoticon);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "hit db, put into cache");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.6
 * JD-Core Version:    0.7.0.1
 */