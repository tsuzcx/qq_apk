package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MailListFragment$37
  implements View.OnClickListener
{
  MailListFragment$37(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if ((MailListFragment.access$9000(this.this$0)) || (!MailListFragment.access$300(this.this$0)) || (MailListFragment.access$2100(this.this$0))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((MailListFragment.access$400(this.this$0) != null) && (!MailListFragment.access$400(this.this$0).isEmpty())) {
        break;
      }
      this.this$0.getTips().showInfo(2131695646);
    }
    Object localObject1 = new HashSet();
    Object localObject2 = MailListFragment.access$400(this.this$0).keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      ((HashSet)localObject1).add(MailListFragment.access$200(this.this$0).getItem(((Integer)localObject3).intValue()).getInformation().getFrom().getName());
    }
    Object localObject3 = ((HashSet)localObject1).iterator();
    int i = 0;
    localObject2 = "";
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = (String)((Iterator)localObject3).next();
      if (i != 0) {}
      for (localObject1 = (String)localObject2 + ", " + (String)localObject1;; localObject1 = (String)localObject2 + (String)localObject1)
      {
        i += 1;
        localObject2 = localObject1;
        break;
      }
    }
    if (MailListFragment.access$2800(this.this$0) == 15)
    {
      localObject1 = String.format(this.this$0.getString(2131695622), new Object[] { localObject2 });
      label284:
      localObject3 = new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity());
      MailListFragment localMailListFragment = this.this$0;
      if (MailListFragment.access$2800(this.this$0) != 15) {
        break label475;
      }
      i = 2131695623;
      label321:
      localObject1 = (QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)localObject3).setTitle(String.format(localMailListFragment.getString(i), new Object[] { localObject2 }))).setMessage((CharSequence)localObject1).addAction(2131691246, new MailListFragment.37.2(this));
      if (MailListFragment.access$2800(this.this$0) != 15) {
        break label481;
      }
    }
    label475:
    label481:
    for (i = 2131691990;; i = 2131691989)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)localObject1).addAction(i, new MailListFragment.37.1(this))).create().show();
      break;
      if (MailListFragment.access$2800(this.this$0) == 8)
      {
        localObject1 = String.format(this.this$0.getString(2131695625), new Object[] { localObject2 });
        break label284;
      }
      localObject1 = String.format(this.this$0.getString(2131695621), new Object[] { MailListFragment.access$9200(this.this$0) });
      break label284;
      i = 2131695628;
      break label321;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.37
 * JD-Core Version:    0.7.0.1
 */