package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import java.util.ArrayList;
import java.util.List;

class DesktopDataManager$16$1
  implements Runnable
{
  DesktopDataManager$16$1(DesktopDataManager.16 param16, List paramList) {}
  
  public void run()
  {
    if ((this.val$itemInfoList.size() > 0) && ((DesktopDataManager.access$1600(this.this$1.this$0) == null) || (DesktopDataManager.access$1600(this.this$1.this$0).size() == 0))) {
      DesktopDataManager.access$1602(this.this$1.this$0, new ArrayList(this.val$itemInfoList));
    }
    if (DesktopDataManager.access$1700(this.this$1.this$0) == null) {
      DesktopDataManager.access$1702(this.this$1.this$0, new ArrayList());
    }
    DesktopDataManager.access$1700(this.this$1.this$0).clear();
    DesktopDataManager.access$1702(this.this$1.this$0, DesktopDataManager.access$2800(this.this$1.this$0));
    if ((DesktopDataManager.access$1600(this.this$1.this$0) != null) && (DesktopDataManager.access$1600(this.this$1.this$0).size() > 0)) {
      MiniAppUtils.updateMiniAppList(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.16.1
 * JD-Core Version:    0.7.0.1
 */