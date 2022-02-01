package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import java.util.List;
import mjp;
import mjs;

public class ReadInJoyDraftboxFragment$1$1$1
  implements Runnable
{
  public ReadInJoyDraftboxFragment$1$1$1(mjs parammjs, List paramList) {}
  
  public void run()
  {
    ReadInJoyDraftboxFragment.a(this.a.a.this$0).clear();
    if (this.val$list != null)
    {
      int i = this.val$list.size() - 1;
      while (i >= 0)
      {
        ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.val$list.get(i);
        if (ReadInJoyDraftboxFragment.b(localReadInJoyDraftboxItem)) {
          ReadInJoyDraftboxFragment.a(this.a.a.this$0).add(localReadInJoyDraftboxItem);
        }
        i -= 1;
      }
    }
    ReadInJoyDraftboxFragment.a(this.a.a.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment.1.1.1
 * JD-Core Version:    0.7.0.1
 */