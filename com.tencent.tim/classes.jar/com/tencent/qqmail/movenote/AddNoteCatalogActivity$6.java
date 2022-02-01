package com.tencent.qqmail.movenote;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.NoteManager;

class AddNoteCatalogActivity$6
  implements View.OnClickListener
{
  AddNoteCatalogActivity$6(AddNoteCatalogActivity paramAddNoteCatalogActivity, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onClick(View paramView)
  {
    NoteManager.sharedInstance().addNoteCatalog(AddNoteCatalogActivity.access$000(this.this$0).getText().toString(), this.val$managerDelegate);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.AddNoteCatalogActivity.6
 * JD-Core Version:    0.7.0.1
 */