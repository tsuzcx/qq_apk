package com.tencent.qqmail.search.fragment;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;

class SearchNoteListActivity$1$1
  implements Runnable
{
  SearchNoteListActivity$1$1(SearchNoteListActivity.1 param1, Object paramObject) {}
  
  public void run()
  {
    SearchNoteListActivity.access$002(this.this$1.this$0, null);
    this.this$1.this$0.getTips().hide();
    String str = (String)((HashMap)this.val$data).get("keyword");
    this.this$1.this$0.getSharedPreferences("user_info", 0).edit().putString("sSearchNoteContent", str).commit();
    QMNotification.postNotification("searchnote_update", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */