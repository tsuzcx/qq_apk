package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import java.util.List;

class DesktopDataManager$14
  implements Runnable
{
  DesktopDataManager$14(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null)
    {
      localObject = DesktopDataManager.access$2600(this.this$0, (AppInterface)localObject);
      this.this$0.runOnMainThread(new DesktopDataManager.14.1(this, (List)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.14
 * JD-Core Version:    0.7.0.1
 */