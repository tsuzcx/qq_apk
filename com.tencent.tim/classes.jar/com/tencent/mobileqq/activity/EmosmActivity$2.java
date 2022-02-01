package com.tencent.mobileqq.activity;

import acbn;
import ajdg;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonTab;
import java.io.File;

class EmosmActivity$2
  implements Runnable
{
  EmosmActivity$2(EmosmActivity paramEmosmActivity, String paramString) {}
  
  public void run()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = ((ajdg)((QQAppInterface)localObject1).getManager(14)).a(this.aMY);
        if ((localObject1 == null) || ((!((EmoticonTab)localObject1).aioHave) && (!((EmoticonTab)localObject1).kandianHave)))
        {
          Object localObject2 = acbn.bmM + this.aMY;
          localObject1 = new File((String)localObject2);
          localObject2 = new File((String)localObject2 + "del");
          if (!((File)localObject1).renameTo((File)localObject2)) {
            break label134;
          }
          aqhq.cn(((File)localObject2).getAbsolutePath());
        }
      }
      return;
      label134:
      aqhq.cn(((File)localObject1).getAbsolutePath());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.2
 * JD-Core Version:    0.7.0.1
 */