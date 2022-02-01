package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;

class MailListFragment$39
  implements View.OnClickListener
{
  MailListFragment$39(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if ((MailListFragment.access$9000(this.this$0)) || (!MailListFragment.access$300(this.this$0)) || (MailListFragment.access$2100(this.this$0))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((MailListFragment.access$400(this.this$0) == null) || (MailListFragment.access$400(this.this$0).isEmpty()))
      {
        this.this$0.getTips().showInfo(2131695646);
      }
      else
      {
        if ((MailListFragment.access$2800(this.this$0) != 5) && (MailListFragment.access$2800(this.this$0) != 6)) {
          break;
        }
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(2131697042)).setMessage(2131697043).addAction(2131691246, new MailListFragment.39.2(this))).addAction(0, 2131691840, 2, new MailListFragment.39.1(this))).create().show();
      }
    }
    boolean bool;
    label223:
    int i;
    label245:
    int j;
    if (MailListFragment.access$2800(this.this$0) == 4)
    {
      if (MailListFragment.access$9400(this.this$0) > 0) {}
      for (bool = true;; bool = false)
      {
        if ((!bool) || (QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()))) {
          break label223;
        }
        MailListFragment.access$3100(this.this$0);
        break;
      }
      if (MailListFragment.access$9400(this.this$0) >= MailListFragment.access$400(this.this$0).size())
      {
        i = 1;
        if (i == 0) {
          break label334;
        }
        j = 2131691551;
        label252:
        if (i == 0) {
          break label340;
        }
        i = 2131691549;
      }
    }
    for (;;)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(j)).setMessage(i).addAction(2131691246, new MailListFragment.39.4(this))).addAction(0, 2131691840, 2, new MailListFragment.39.3(this, bool))).create().show();
      break;
      i = 0;
      break label245;
      label334:
      j = 2131692977;
      break label252;
      label340:
      if (bool)
      {
        i = 2131691545;
        continue;
        MailListFragment.access$9300(this.this$0, MailListFragment.access$2200(this.this$0), MailListFragment.access$9100(this.this$0), false);
        break;
      }
      i = 2131692978;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.39
 * JD-Core Version:    0.7.0.1
 */