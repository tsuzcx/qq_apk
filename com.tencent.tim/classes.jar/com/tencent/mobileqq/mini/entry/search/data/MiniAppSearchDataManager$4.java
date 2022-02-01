package com.tencent.mobileqq.mini.entry.search.data;

import java.util.List;

class MiniAppSearchDataManager$4
  implements Runnable
{
  MiniAppSearchDataManager$4(MiniAppSearchDataManager paramMiniAppSearchDataManager, List paramList) {}
  
  public void run()
  {
    MiniAppSearchDataManager.access$700(this.this$0).clear();
    MiniAppSearchDataManager.access$700(this.this$0).addAll(this.val$searchInfoList);
    if (MiniAppSearchDataManager.access$800(this.this$0) != null) {
      MiniAppSearchDataManager.access$800(this.this$0).onHotSearchDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.4
 * JD-Core Version:    0.7.0.1
 */