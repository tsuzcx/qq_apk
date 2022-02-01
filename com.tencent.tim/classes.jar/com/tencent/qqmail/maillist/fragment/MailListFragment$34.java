package com.tencent.qqmail.maillist.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.search.fragment.UnlockFolderActivity;
import com.tencent.qqmail.utilities.ui.QMLockTipsView;
import com.tencent.qqmail.view.FolderLockDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import moai.fragment.app.FragmentActivity;

class MailListFragment$34
  implements View.OnClickListener
{
  MailListFragment$34(MailListFragment paramMailListFragment) {}
  
  private void showLockDialog()
  {
    if (MailListFragment.access$2500(this.this$0) != null) {
      MailListFragment.access$2500(this.this$0).dismissTips();
    }
    if (this.this$0.getActivity() != null)
    {
      MailListFragment.access$2502(this.this$0, new FolderLockDialog(this.this$0.getActivity(), MailListFragment.access$2400(this.this$0), MailListFragment.access$2200(this.this$0), MailListFragment.access$2600(this.this$0)));
      MailListFragment.access$2500(this.this$0).createDialog(1);
      MailListFragment.access$2500(this.this$0).showDialog();
    }
  }
  
  public void onClick(View paramView)
  {
    if (MailListFragment.access$8400(this.this$0).size() > 1)
    {
      Object localObject = new ArrayList();
      Iterator localIterator = MailListFragment.access$8400(this.this$0).values().iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add((LockInfo)localIterator.next());
      }
      localObject = UnlockFolderActivity.createIntent((ArrayList)localObject);
      this.this$0.startActivityForResult((Intent)localObject, 1);
      this.this$0.getActivity().overridePendingTransition(2130772401, 2130772430);
    }
    for (;;)
    {
      MailListFragment.access$8500(this.this$0).setSelected(true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (MailListFragment.access$8400(this.this$0).size() > 0) {
        showLockDialog();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.34
 * JD-Core Version:    0.7.0.1
 */