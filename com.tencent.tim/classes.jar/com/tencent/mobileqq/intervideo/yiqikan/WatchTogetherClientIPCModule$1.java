package com.tencent.mobileqq.intervideo.yiqikan;

import aihr;
import aihu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class WatchTogetherClientIPCModule$1
  implements Runnable
{
  public WatchTogetherClientIPCModule$1(aihu paramaihu, String paramString, WatchTogetherFloatingData paramWatchTogetherFloatingData) {}
  
  public void run()
  {
    boolean bool = true;
    if ("ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(this.val$action)) {
      if (aihr.a().a(BaseApplicationImpl.getContext(), this.c) == 0) {
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherClientIPCModule", 2, "call TogetherBusinessIPCModule show=" + bool);
        }
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(this.val$action))
      {
        aihr.a().p(this.c.getCurUin(), this.c.getCurType(), true);
        return;
      }
    } while (!"ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(this.val$action));
    aihr.a().dst();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherClientIPCModule.1
 * JD-Core Version:    0.7.0.1
 */