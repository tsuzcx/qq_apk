package com.tencent.qqmail.search.fragment;

class AttachFolderSearchListAdapter$2
  implements Runnable
{
  AttachFolderSearchListAdapter$2(AttachFolderSearchListAdapter paramAttachFolderSearchListAdapter, Runnable paramRunnable) {}
  
  public void run()
  {
    this.this$0.notifyDataSetChanged();
    if (this.val$afterRefresh != null) {
      this.val$afterRefresh.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.AttachFolderSearchListAdapter.2
 * JD-Core Version:    0.7.0.1
 */