package com.tencent.mobileqq.model;

import ajdg;
import android.text.TextUtils;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonManager$20
  implements Runnable
{
  public EmoticonManager$20(ajdg paramajdg, List paramList) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    EntityTransaction localEntityTransaction = this.this$0.em.getTransaction();
    for (;;)
    {
      int i;
      try
      {
        localEntityTransaction.begin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveRecentEmotionToDB:");
        i = this.CW.size() - 1;
        if (i >= 0)
        {
          RecentEmotion localRecentEmotion1 = (RecentEmotion)this.CW.get(i);
          if (localRecentEmotion1 == null) {
            break label364;
          }
          String str1 = localRecentEmotion1.epId;
          String str2 = localRecentEmotion1.eId;
          String str3 = localRecentEmotion1.keyword;
          localStringBuilder.append("emotion=").append(localRecentEmotion1);
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
            break label364;
          }
          RecentEmotion localRecentEmotion2 = (RecentEmotion)this.this$0.em.find(RecentEmotion.class, "epId=? and eId=? and keyword=?", new String[] { str1, str2, str3 });
          RecentEmotion localRecentEmotion3 = new RecentEmotion();
          localRecentEmotion3.epId = str1;
          localRecentEmotion3.eId = str2;
          localRecentEmotion3.keyword = str3;
          localRecentEmotion3.exposeNum = localRecentEmotion1.exposeNum;
          localRecentEmotion3.setStatus(1000);
          if (localRecentEmotion2 != null) {
            this.this$0.em.remove(localRecentEmotion2);
          }
          ajdg.a(this.this$0, localRecentEmotion3);
        }
      }
      catch (Exception localException)
      {
        QLog.e("EmoticonManager", 2, "saveRecentEmotionToDB e = " + localException.getMessage());
        localEntityTransaction.end();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, "saveRecentEmotionToDB_Time: " + (System.currentTimeMillis() - l));
        }
        return;
        localEntityTransaction.commit();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, localException.toString());
        }
        localEntityTransaction.end();
        continue;
      }
      finally
      {
        localEntityTransaction.end();
      }
      label364:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.20
 * JD-Core Version:    0.7.0.1
 */