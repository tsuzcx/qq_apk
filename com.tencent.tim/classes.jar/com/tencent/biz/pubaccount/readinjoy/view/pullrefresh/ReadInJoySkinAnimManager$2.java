package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import java.util.ArrayList;

class ReadInJoySkinAnimManager$2
  implements Runnable
{
  int i = 0;
  
  ReadInJoySkinAnimManager$2(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager) {}
  
  public void run()
  {
    if ((ReadInJoySkinAnimManager.a(this.this$0) != null) && (ReadInJoySkinAnimManager.a(this.this$0).size() > 0))
    {
      if (this.i >= ReadInJoySkinAnimManager.a(this.this$0).size()) {
        this.i = 0;
      }
      ReadInJoySkinAnimManager localReadInJoySkinAnimManager = this.this$0;
      ArrayList localArrayList = ReadInJoySkinAnimManager.a(this.this$0);
      int j = this.i;
      this.i = (j + 1);
      ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager, ((ReadInJoySkinAnimManager.a)localArrayList.get(j)).drawable);
      ((SkinPullRefreshHeader)this.this$0.a).requestLayout();
      ((SkinPullRefreshHeader)this.this$0.a).postDelayed(this, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager.2
 * JD-Core Version:    0.7.0.1
 */