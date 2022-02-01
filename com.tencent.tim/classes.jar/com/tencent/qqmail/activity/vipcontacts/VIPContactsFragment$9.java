package com.tencent.qqmail.activity.vipcontacts;

import android.widget.ListView;
import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import com.tencent.qqmail.utilities.ui.QMSideIndexer.QMSideIndexerCallback;

class VIPContactsFragment$9
  implements QMSideIndexer.QMSideIndexerCallback
{
  VIPContactsFragment$9(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void touchedSideIndexer(QMSideIndexer paramQMSideIndexer, int paramInt, String paramString)
  {
    if (VIPContactsFragment.access$700(this.this$0) == 0) {}
    for (paramInt = VIPContactsFragment.access$2000(this.this$0).getPositionForSection(paramInt - VIPContactsFragment.access$1800(this.this$0).getHeaderViewsCount()); (paramInt < 0) || (paramInt >= VIPContactsFragment.access$2000(this.this$0).getCount()); paramInt = VIPContactsFragment.access$2000(this.this$0).getPositionForSection(paramInt))
    {
      VIPContactsFragment.access$1800(this.this$0).setSelection(0);
      return;
    }
    VIPContactsFragment.access$1800(this.this$0).setSelection(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.9
 * JD-Core Version:    0.7.0.1
 */