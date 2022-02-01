package com.tencent.qqmail.note;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.view.FolderLockDialog;

class ReadNoteActivity$3
  implements View.OnClickListener
{
  ReadNoteActivity$3(ReadNoteActivity paramReadNoteActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.getActivity() != null)
    {
      ReadNoteActivity.access$002(this.this$0, new FolderLockDialog(this.this$0.getActivity(), -4, QMSettingManager.sharedInstance().getDefaultNoteAccountID(), ReadNoteActivity.access$500(this.this$0)));
      ReadNoteActivity.access$000(this.this$0).createDialog(1);
      ReadNoteActivity.access$000(this.this$0).showDialog();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.3
 * JD-Core Version:    0.7.0.1
 */