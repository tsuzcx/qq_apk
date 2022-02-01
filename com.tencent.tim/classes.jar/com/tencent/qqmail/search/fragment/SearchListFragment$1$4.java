package com.tencent.qqmail.search.fragment;

import android.util.SparseArray;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.model.LockInfo;

class SearchListFragment$1$4
  implements Runnable
{
  SearchListFragment$1$4(SearchListFragment.1 param1, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.val$accountId);
    if (localAccount != null)
    {
      SparseArray localSparseArray2 = SearchListFragment.access$500(this.this$1.this$0);
      SparseArray localSparseArray1 = localSparseArray2;
      if (localSparseArray2 == null)
      {
        localSparseArray2 = new SparseArray();
        localSparseArray1 = localSparseArray2;
        if (SearchListFragment.access$600(this.this$1.this$0) != null)
        {
          SearchListFragment.access$600(this.this$1.this$0).put(SearchListFragment.access$700(this.this$1.this$0), localSparseArray2);
          localSparseArray1 = localSparseArray2;
        }
      }
      localSparseArray1.put(this.val$accountId, new LockInfo(this.val$accountId, SearchListFragment.access$800(this.this$1.this$0), localAccount.getEmail(), this.val$personalCnt));
    }
    SearchListFragment.access$900(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.1.4
 * JD-Core Version:    0.7.0.1
 */