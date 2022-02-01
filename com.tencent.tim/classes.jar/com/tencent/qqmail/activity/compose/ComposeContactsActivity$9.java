package com.tencent.qqmail.activity.compose;

import android.widget.ListView;
import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import com.tencent.qqmail.utilities.ui.QMSideIndexer.QMSideIndexerCallback;

class ComposeContactsActivity$9
  implements QMSideIndexer.QMSideIndexerCallback
{
  ComposeContactsActivity$9(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void touchedSideIndexer(QMSideIndexer paramQMSideIndexer, int paramInt, String paramString)
  {
    paramInt = ComposeContactsActivity.access$1400(this.this$0).getPositionForSection(paramInt);
    if ((paramInt < 0) || (paramInt >= ComposeContactsActivity.access$1400(this.this$0).getCount()))
    {
      ComposeContactsActivity.access$1200(this.this$0).setSelection(0);
      return;
    }
    ComposeContactsActivity.access$1200(this.this$0).setSelection(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.9
 * JD-Core Version:    0.7.0.1
 */