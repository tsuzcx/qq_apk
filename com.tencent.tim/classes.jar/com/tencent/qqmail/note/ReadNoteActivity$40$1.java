package com.tencent.qqmail.note;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.compose.NoteCatAdapter;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.qmui.popup.QMUIListPopup;
import java.util.ArrayList;
import java.util.List;

class ReadNoteActivity$40$1
  implements AdapterView.OnItemClickListener
{
  ReadNoteActivity$40$1(ReadNoteActivity.40 param40) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = (QMNNoteCategory)ReadNoteActivity.access$3500(this.this$1.this$0).getItem(paramInt);
    String str = ((QMNNoteCategory)localObject).getCatalogId();
    ReadNoteActivity.access$3500(this.this$1.this$0).setNoteCatId(str);
    this.this$1.val$noteInfo.category.setCatalogId(str);
    this.this$1.val$noteCatalogTextView.setText(((QMNNoteCategory)localObject).getCatalogName());
    localObject = new ArrayList();
    ((List)localObject).add(this.this$1.val$noteInfo.noteId);
    NoteManager.sharedInstance().moveNotesWithNotifications((List)localObject, str);
    ReadNoteActivity.access$3400(this.this$1.this$0).dismiss();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.40.1
 * JD-Core Version:    0.7.0.1
 */