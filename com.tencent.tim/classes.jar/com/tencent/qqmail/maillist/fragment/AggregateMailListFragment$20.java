package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import java.util.HashMap;

class AggregateMailListFragment$20
  extends HashMap<String, String>
{
  AggregateMailListFragment$20(AggregateMailListFragment paramAggregateMailListFragment)
  {
    put("$name$", AccountManager.shareInstance().getAccountList().getDefaultNickName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.20
 * JD-Core Version:    0.7.0.1
 */