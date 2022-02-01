package com.tencent.qqmail.namelist.fragment;

import android.view.View;
import com.tencent.qqmail.namelist.NameListAdapter;
import com.tencent.qqmail.namelist.NameListManager;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.OnRightViewClickListener;

class NameListMainFragment$1OnRightViewClickListener
  implements ItemScrollListView.OnRightViewClickListener
{
  NameListMainFragment$1OnRightViewClickListener(NameListMainFragment paramNameListMainFragment) {}
  
  public void onRightViewClick(View paramView, int paramInt)
  {
    QMLog.log(4, "NameListMainFragment", "onRightViewClick, View id:" + paramView.getId() + ", position:" + paramInt);
    if (paramView.getId() == 2131377335) {
      if (!NameListMainFragment.access$400(this.this$0)) {
        break label100;
      }
    }
    label100:
    for (paramView = NameListMainFragment.access$500(this.this$0).getItem(paramInt);; paramView = NameListMainFragment.access$300(this.this$0).getItem(paramInt))
    {
      NameListManager.sharedInstance().deleteNameList(NameListMainFragment.access$000(this.this$0), NameListMainFragment.access$100(this.this$0), new String[] { paramView.getEmail() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.1OnRightViewClickListener
 * JD-Core Version:    0.7.0.1
 */