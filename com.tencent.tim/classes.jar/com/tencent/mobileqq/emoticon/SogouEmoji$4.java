package com.tencent.mobileqq.emoticon;

import afke;
import aflb;
import ajdg;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SogouEmoji$4
  implements Runnable
{
  public SogouEmoji$4(aflb paramaflb, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func pullMultipleEmojiKey begins, allPackId:" + this.zR);
    }
    if ((this.zR == null) || (this.zR.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func pullMultipleEmojiKey ends, param packid is null.");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func pullMultipleEmojiKey,size:" + this.zR.size());
      }
      Iterator localIterator = this.zR.iterator();
      ArrayList localArrayList = null;
      label360:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.this$0.e.b(str);
        if (localObject == null)
        {
          this.this$0.c.ex(str, afke.cRu);
          if (QLog.isColorLevel()) {
            QLog.d("SogouEmoji", 2, "func pullMultipleEmojiKey, packId=" + str + ",fail to search 【the pack】 from db, try get json from svr.");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("SogouEmoji", 2, "func pullMultipleEmojiKey, packId=" + str + ",type:" + ((EmoticonPackage)localObject).type + ",json exists in local db.");
          }
          localObject = this.this$0.e.e(str, true);
          if ((localObject instanceof ArrayList))
          {
            localArrayList = (ArrayList)localObject;
            localArrayList = this.this$0.af(localArrayList);
          }
          for (;;)
          {
            if (localArrayList == null) {
              break label360;
            }
            if (localArrayList.size() == 0) {
              break;
            }
            this.this$0.v(str, localArrayList);
            if (QLog.isColorLevel()) {
              QLog.d("SogouEmoji", 2, "func pullMultipleEmojiKey ends, packId=" + str + ", try get keys from svr.");
            }
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji.4
 * JD-Core Version:    0.7.0.1
 */