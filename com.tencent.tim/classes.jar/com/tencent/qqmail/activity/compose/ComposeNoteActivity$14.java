package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.qmui.popup.QMUIListPopup;

class ComposeNoteActivity$14
  implements AdapterView.OnItemClickListener
{
  ComposeNoteActivity$14(ComposeNoteActivity paramComposeNoteActivity, NoteCatAdapter paramNoteCatAdapter) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QMNNoteCategory localQMNNoteCategory = (QMNNoteCategory)this.val$mNoteCatAdapter.getItem(paramInt);
    ComposeNoteActivity.access$1702(this.this$0, localQMNNoteCategory.getCatalogId());
    ComposeNoteActivity.access$1802(this.this$0, localQMNNoteCategory.getCatalogName());
    this.val$mNoteCatAdapter.setNoteCatId(ComposeNoteActivity.access$1700(this.this$0));
    ComposeNoteActivity.access$1400(this.this$0).setNoteCatalogString(ComposeNoteActivity.access$1800(this.this$0));
    ComposeNoteActivity.access$1500(this.this$0).dismiss();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.14
 * JD-Core Version:    0.7.0.1
 */