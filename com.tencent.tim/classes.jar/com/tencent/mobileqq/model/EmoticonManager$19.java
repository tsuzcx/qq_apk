package com.tencent.mobileqq.model;

import ajdg;
import android.text.TextUtils;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class EmoticonManager$19
  implements Runnable
{
  public EmoticonManager$19(ajdg paramajdg, RecentEmotion paramRecentEmotion) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "addRecentEmotionToCache key = " + this.a);
    }
    String str = this.a.keyword;
    if (TextUtils.isEmpty(str))
    {
      QLog.e("EmoticonManager", 1, "addRecentEmotionToCache keyword empty");
      return;
    }
    RecentEmotion localRecentEmotion = this.a;
    CopyOnWriteArrayList localCopyOnWriteArrayList = ajdg.a(this.this$0, str);
    if (localCopyOnWriteArrayList != null)
    {
      int i = localCopyOnWriteArrayList.indexOf(this.a);
      if (i > -1)
      {
        localRecentEmotion = (RecentEmotion)localCopyOnWriteArrayList.get(i);
        localRecentEmotion.replace(this.a);
      }
    }
    for (;;)
    {
      this.this$0.CU.remove(localRecentEmotion);
      this.this$0.CU.add(0, localRecentEmotion);
      return;
      localCopyOnWriteArrayList.add(this.a);
      continue;
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      localCopyOnWriteArrayList.add(this.a);
      this.this$0.lR.put(str, localCopyOnWriteArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.19
 * JD-Core Version:    0.7.0.1
 */