package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.Iterator;
import java.util.List;

class DesktopDataManager$25
  implements Runnable
{
  DesktopDataManager$25(DesktopDataManager paramDesktopDataManager, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = DesktopDataManager.access$1600(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)localIterator.next();
      if (((localDesktopItemInfo instanceof DesktopAppInfo)) && (((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo.appId.equals(this.val$appId))) {
        localIterator.remove();
      }
    }
    DesktopDataManager.access$1900(DesktopDataManager.access$1600(this.this$0));
    if (DesktopDataManager.access$1500(this.this$0) != null) {
      DesktopDataManager.access$1500(this.this$0).onDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.25
 * JD-Core Version:    0.7.0.1
 */