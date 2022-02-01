package com.tencent.mobileqq.activity;

import android.widget.BaseAdapter;
import com.tencent.widget.XListView;
import vya;

public class TroopAssistantActivity$11$1
  implements Runnable
{
  public TroopAssistantActivity$11$1(vya paramvya) {}
  
  public void run()
  {
    if ((this.a.this$0.u.getAdapter() instanceof BaseAdapter)) {
      ((BaseAdapter)this.a.this$0.u.getAdapter()).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.11.1
 * JD-Core Version:    0.7.0.1
 */