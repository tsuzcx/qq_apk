package com.tencent.qqmail.namelist.fragment;

import com.tencent.qqmail.namelist.NameListAdapter;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import com.tencent.qqmail.utilities.ui.QMSideIndexer.QMSideIndexerCallback;

class NameListMainFragment$5
  implements QMSideIndexer.QMSideIndexerCallback
{
  NameListMainFragment$5(NameListMainFragment paramNameListMainFragment) {}
  
  public void touchedSideIndexer(QMSideIndexer paramQMSideIndexer, int paramInt, String paramString)
  {
    paramInt = NameListMainFragment.access$300(this.this$0).getPositionForSection(paramInt - NameListMainFragment.access$200(this.this$0).getHeaderViewsCount());
    if ((paramInt < 0) || (paramInt >= NameListMainFragment.access$300(this.this$0).getCount()))
    {
      NameListMainFragment.access$200(this.this$0).setSelection(0);
      return;
    }
    NameListMainFragment.access$200(this.this$0).setSelection(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.5
 * JD-Core Version:    0.7.0.1
 */