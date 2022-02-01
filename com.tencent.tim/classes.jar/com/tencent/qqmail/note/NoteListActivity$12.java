package com.tencent.qqmail.note;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

class NoteListActivity$12
  extends QMListPopupWindow
{
  NoteListActivity$12(NoteListActivity paramNoteListActivity, Context paramContext, View paramView, ListAdapter paramListAdapter, ArrayList paramArrayList)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((TextView)paramView.findViewById(2131373495)).getText().toString();
    if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131695669))) {
      if (!QMNetworkUtils.isNetworkConnected(this.this$0)) {
        Threads.runOnMainThread(NoteListActivity.access$1300(this.this$0));
      }
    }
    while (!StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131695672)))
    {
      return;
      NoteListActivity.access$800(this.this$0).starNotesWithNotification(this.val$idlist, true);
      NoteListActivity.access$1400(this.this$0);
      return;
    }
    if (!QMNetworkUtils.isNetworkConnected(this.this$0))
    {
      Threads.runOnMainThread(NoteListActivity.access$1300(this.this$0));
      return;
    }
    NoteListActivity.access$800(this.this$0).starNotesWithNotification(this.val$idlist, false);
    NoteListActivity.access$1400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.12
 * JD-Core Version:    0.7.0.1
 */