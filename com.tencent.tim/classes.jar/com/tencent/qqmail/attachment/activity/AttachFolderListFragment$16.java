package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.PtrListView;
import java.util.List;
import java.util.Set;

class AttachFolderListFragment$16
  implements AdapterView.OnItemLongClickListener
{
  AttachFolderListFragment$16(AttachFolderListFragment paramAttachFolderListFragment, boolean[] paramArrayOfBoolean) {}
  
  private int getItemIndex(int paramInt)
  {
    if (AttachFolderListFragment.access$2200(this.this$0).hasLockTip()) {}
    for (int i = 1;; i = 0) {
      return paramInt - AttachFolderListFragment.access$2100(this.this$0).getHeaderViewsCount() - i;
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    this.val$hasLongClick[0] = true;
    if ((AttachFolderListFragment.access$1300(this.this$0)) || (AttachFolderListFragment.access$1200(this.this$0)))
    {
      if (OneStepUtils.isOneStepShowing())
      {
        paramInt = getItemIndex(paramInt);
        if ((paramInt >= 0) && (AttachFolderListFragment.access$000(this.this$0) != null)) {
          OneStepUtils.drapAttachByOneStep(paramView, AttachFolderListFragment.access$000(this.this$0).getItem(paramInt));
        }
      }
      bool = false;
    }
    int i;
    do
    {
      return bool;
      i = getItemIndex(paramInt);
    } while (i < 0);
    if (AttachFolderListFragment.access$000(this.this$0) != null)
    {
      paramAdapterView = AttachFolderListFragment.access$000(this.this$0).getItem(i);
      OneStepUtils.drapAttachByOneStep(paramView, paramAdapterView);
      AttachFolderListFragment.access$1000(this.this$0).add(Long.valueOf(paramAdapterView.getHashId()));
      if (AttachFolderListFragment.access$1100(this.this$0).indexOf(paramAdapterView) == -1) {
        AttachFolderListFragment.access$1100(this.this$0).add(paramAdapterView);
      }
      AttachFolderListFragment.access$1800(this.this$0);
      AttachFolderListFragment.access$2100(this.this$0).setItemChecked(paramInt, true);
      return true;
    }
    QMLog.log(6, "AttachFolderListFragment", "attach long click is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.16
 * JD-Core Version:    0.7.0.1
 */