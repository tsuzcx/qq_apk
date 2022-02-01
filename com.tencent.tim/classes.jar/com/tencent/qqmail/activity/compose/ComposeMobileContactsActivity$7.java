package com.tencent.qqmail.activity.compose;

import android.widget.ListView;
import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import com.tencent.qqmail.utilities.ui.QMSideIndexer.QMSideIndexerCallback;

class ComposeMobileContactsActivity$7
  implements QMSideIndexer.QMSideIndexerCallback
{
  ComposeMobileContactsActivity$7(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public void touchedSideIndexer(QMSideIndexer paramQMSideIndexer, int paramInt, String paramString)
  {
    paramInt = ComposeMobileContactsActivity.access$1100(this.this$0).getPositionForSection(paramInt);
    if ((paramInt < 0) || (paramInt >= ComposeMobileContactsActivity.access$1100(this.this$0).getCount()))
    {
      ComposeMobileContactsActivity.access$900(this.this$0).setSelection(0);
      return;
    }
    ComposeMobileContactsActivity.access$900(this.this$0).setSelection(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.7
 * JD-Core Version:    0.7.0.1
 */