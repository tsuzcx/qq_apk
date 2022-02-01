package com.tencent.qqmail.movenote;

import android.content.Intent;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.utilities.ui.QMTips;

class AddNoteCatalogActivity$4$1
  implements Runnable
{
  AddNoteCatalogActivity$4$1(AddNoteCatalogActivity.4 param4, Object paramObject) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    if ((this.val$object1 != null) && ((this.val$object1 instanceof QMNNoteCategory))) {
      localIntent.putExtra("catalogId", ((QMNNoteCategory)this.val$object1).getCatalogId());
    }
    this.this$1.this$0.setResult(-1, localIntent);
    this.this$1.this$0.getTips().setCallback(new AddNoteCatalogActivity.4.1.1(this));
    this.this$1.this$0.getTips().showSuccess(2131696409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.AddNoteCatalogActivity.4.1
 * JD-Core Version:    0.7.0.1
 */