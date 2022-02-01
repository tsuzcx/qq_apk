package com.tencent.mobileqq.emoticon;

import afkb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class EPRecommendTask$1
  implements Runnable
{
  public EPRecommendTask$1(afkb paramafkb) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("EPRecommendTask", 2, "url:" + this.this$0.bDH + ",type:" + this.this$0.bDI);
    }
    try
    {
      Object localObject = (QQAppInterface)this.this$0.K.get();
      if (localObject == null) {
        return;
      }
      localObject = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject, "emoji_app_vip_emoji_aio_android_config.json", true, this.this$0.g);
      this.this$0.bd((JSONObject)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, localException.getMessage());
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label103:
      break label103;
    }
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      QLog.d("EPRecommendTask", 2, "costTime:" + (l2 - l1) + ",type:" + this.this$0.bDI);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EPRecommendTask.1
 * JD-Core Version:    0.7.0.1
 */