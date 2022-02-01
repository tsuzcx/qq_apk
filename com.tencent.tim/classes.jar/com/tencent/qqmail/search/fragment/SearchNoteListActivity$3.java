package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.thread.Threads;

class SearchNoteListActivity$3
  implements ICallBack
{
  SearchNoteListActivity$3(SearchNoteListActivity paramSearchNoteListActivity) {}
  
  public void callback(Object paramObject)
  {
    Threads.runOnMainThread(new SearchNoteListActivity.3.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.3
 * JD-Core Version:    0.7.0.1
 */