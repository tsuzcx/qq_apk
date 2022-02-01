package com.tencent.qqmail.search.fragment;

import android.util.Log;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.view.FolderLockDialog;

class SearchListFragment$23
  implements QMUnlockFolderPwdWatcher
{
  SearchListFragment$23(SearchListFragment paramSearchListFragment) {}
  
  public void onCancel(int paramInt1, int paramInt2)
  {
    SearchListFragment.access$4500(this.this$0).hideKeyBoard();
  }
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    SearchListFragment.access$4800(this.this$0, new SearchListFragment.23.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    Log.d("SearchListFragment", "QMUnlockFolderPwdWatcher onSuccess " + paramInt1 + "," + paramInt2);
    SearchListFragment.access$4700(this.this$0, new SearchListFragment.23.1(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.23
 * JD-Core Version:    0.7.0.1
 */