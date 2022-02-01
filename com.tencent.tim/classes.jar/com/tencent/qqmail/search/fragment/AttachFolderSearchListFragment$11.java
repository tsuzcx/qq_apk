package com.tencent.qqmail.search.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.Attach;

class AttachFolderSearchListFragment$11
  implements AdapterView.OnItemClickListener
{
  AttachFolderSearchListFragment$11(AttachFolderSearchListFragment paramAttachFolderSearchListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt - AttachFolderSearchListFragment.access$1100(this.this$0).getHeaderViewsCount();
    if (i < 0) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      Attach localAttach = AttachFolderSearchListFragment.access$1200(this.this$0).getItem(i);
      if (localAttach != null)
      {
        AttachFolderSearchListFragment.access$1300(this.this$0, localAttach);
        paramView.setSelected(true);
        this.this$0.hideKeyBoard();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListFragment.11
 * JD-Core Version:    0.7.0.1
 */