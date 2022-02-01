package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.model.uidomain.NoteUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.ui.QMTips;

class SearchNoteListActivity$2$1
  implements Runnable
{
  SearchNoteListActivity$2$1(SearchNoteListActivity.2 param2, Object paramObject) {}
  
  public void run()
  {
    SearchNoteListActivity.access$002(this.this$1.this$0, null);
    DataCollector.logException(7, 9, "Event_Error", "searchnotelist.", true);
    this.this$1.this$0.getTips().showError("搜索失败");
    if (((QMNetworkError)this.val$data).code == -1) {
      this.this$1.this$0.getTips().showInfo("已取消搜索");
    }
    SearchNoteListActivity.access$100(this.this$1.this$0).setSeverSearch(false);
    if (SearchNoteListActivity.access$200(this.this$1.this$0).getCount() == 0)
    {
      SearchNoteListActivity.access$300(this.this$1.this$0);
      return;
    }
    SearchNoteListActivity.access$400(this.this$1.this$0);
    SearchNoteListActivity.access$200(this.this$1.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.2.1
 * JD-Core Version:    0.7.0.1
 */