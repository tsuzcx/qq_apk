package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachFolderListLockTip;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.PtrListView;
import java.util.List;
import java.util.Set;

class AttachFolderListFragment$15
  implements AdapterView.OnItemClickListener
{
  AttachFolderListFragment$15(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt - AttachFolderListFragment.access$2100(this.this$0).getHeaderViewsCount();
    if (i < 0) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      Object localObject = AttachFolderListFragment.access$2200(this.this$0).getItem(i);
      if (localObject != null) {
        if ((AttachFolderListFragment.access$1300(this.this$0)) || (AttachFolderListFragment.access$1200(this.this$0)))
        {
          if ((localObject instanceof Attach))
          {
            localObject = (Attach)localObject;
            if (!AttachFolderListFragment.access$1000(this.this$0).contains(Long.valueOf(((Attach)localObject).getHashId())))
            {
              AttachFolderListFragment.access$1000(this.this$0).add(Long.valueOf(((Attach)localObject).getHashId()));
              AttachFolderListFragment.access$1100(this.this$0).add(localObject);
              AttachFolderListFragment.access$2100(this.this$0).setItemChecked(paramInt, true);
            }
            for (;;)
            {
              AttachFolderListFragment.access$2300(this.this$0);
              AttachFolderListFragment.access$2400(this.this$0);
              if (!AttachFolderListFragment.access$1200(this.this$0)) {
                AttachFolderListFragment.access$2500(this.this$0, this.this$0.isSelectAll());
              }
              OneStepUtils.drapAttachByOneStep(paramView, (Attach)localObject);
              break;
              AttachFolderListFragment.access$1000(this.this$0).remove(Long.valueOf(((Attach)localObject).getHashId()));
              QMLog.log(3, "AttachFolderListFragment", "before:" + AttachFolderListFragment.access$1100(this.this$0).size());
              AttachFolderListFragment.access$1100(this.this$0).remove(localObject);
              QMLog.log(3, "AttachFolderListFragment", "after:" + AttachFolderListFragment.access$1100(this.this$0).size());
              AttachFolderListFragment.access$2100(this.this$0).setItemChecked(paramInt, false);
            }
          }
          if ((localObject instanceof AttachFolderListLockTip))
          {
            paramView.setSelected(true);
            AttachFolderListFragment.access$2600(this.this$0);
          }
        }
        else
        {
          paramView.setSelected(true);
          if ((localObject instanceof Attach)) {
            AttachFolderListFragment.access$2700(this.this$0, (Attach)localObject);
          } else if ((localObject instanceof AttachFolderListLockTip)) {
            AttachFolderListFragment.access$2600(this.this$0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.15
 * JD-Core Version:    0.7.0.1
 */