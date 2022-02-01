package com.tencent.mobileqq.adapter;

import abfd;
import android.view.View;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;

class NewFriendMoreSysMsgAdapter$5$1
  implements Runnable
{
  NewFriendMoreSysMsgAdapter$5$1(NewFriendMoreSysMsgAdapter.5 param5, ArrayList paramArrayList) {}
  
  public void run()
  {
    abfd.a(this.a.this$0, this.sG);
    this.a.this$0.notifyDataSetChanged();
    if (this.a.this$0.getCount() > 0)
    {
      abfd.a(this.a.this$0).setVisibility(0);
      abfd.a(this.a.this$0).setVisibility(8);
      if ((this.a.aVC) && (abfd.a(this.a.this$0) < this.a.this$0.getCount())) {
        abfd.a(this.a.this$0).setSelection(abfd.a(this.a.this$0));
      }
      return;
    }
    abfd.a(this.a.this$0).setVisibility(0);
    abfd.a(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.5.1
 * JD-Core Version:    0.7.0.1
 */