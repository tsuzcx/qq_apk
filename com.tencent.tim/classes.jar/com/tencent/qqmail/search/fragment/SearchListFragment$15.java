package com.tencent.qqmail.search.fragment;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.utilities.ui.QMLockTipsView;
import java.util.ArrayList;
import moai.fragment.app.FragmentActivity;

class SearchListFragment$15
  implements View.OnClickListener
{
  SearchListFragment$15(SearchListFragment paramSearchListFragment) {}
  
  private void goToUnlockFolderActivity(SparseArray<LockInfo> paramSparseArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      localArrayList.add(paramSparseArray.valueAt(i));
      i += 1;
    }
    paramSparseArray = UnlockFolderActivity.createIntent(localArrayList);
    this.this$0.startActivity(paramSparseArray);
    this.this$0.getActivity().overridePendingTransition(2130772401, 2130772430);
  }
  
  private boolean isMoreThanOneAccountLocked(SparseArray<LockInfo> paramSparseArray)
  {
    return (paramSparseArray != null) && (paramSparseArray.size() > 1);
  }
  
  public void onClick(View paramView)
  {
    SparseArray localSparseArray = SearchListFragment.access$500(this.this$0);
    if (localSparseArray != null)
    {
      if (!isMoreThanOneAccountLocked(localSparseArray)) {
        break label44;
      }
      goToUnlockFolderActivity(localSparseArray);
    }
    for (;;)
    {
      SearchListFragment.access$3100(this.this$0).setSelected(true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label44:
      if (localSparseArray.size() == 1) {
        SearchListFragment.access$3000(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.15
 * JD-Core Version:    0.7.0.1
 */