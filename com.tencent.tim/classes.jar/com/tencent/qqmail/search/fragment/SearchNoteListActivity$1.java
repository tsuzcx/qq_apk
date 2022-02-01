package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.thread.Threads;

class SearchNoteListActivity$1
  implements ICallBack
{
  SearchNoteListActivity$1(SearchNoteListActivity paramSearchNoteListActivity) {}
  
  public void callback(Object paramObject)
  {
    Threads.runOnMainThread(new SearchNoteListActivity.1.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.1
 * JD-Core Version:    0.7.0.1
 */