package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashSet;
import java.util.Iterator;

class ConvMailListFragment$21
  implements View.OnClickListener
{
  ConvMailListFragment$21(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ConvMailListFragment.access$900(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ConvMailListFragment.access$2700(this.this$0).length == 0)
      {
        this.this$0.getTips().showSuccess(2131695646, 700L);
      }
      else
      {
        Iterator localIterator = ConvMailListFragment.access$3400(this.this$0).iterator();
        int i = 0;
        String str1 = "";
        if (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          if (i != 0) {}
          for (str1 = str1 + ", " + str2;; str1 = str1 + str2)
          {
            i += 1;
            break;
          }
        }
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setMessage(String.format(this.this$0.getString(2131695621), new Object[] { str1 })).setTitle(String.format(this.this$0.getString(2131695628), new Object[] { str1 }))).addAction(2131691246, new ConvMailListFragment.21.2(this))).addAction(2131691989, new ConvMailListFragment.21.1(this))).create().show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.21
 * JD-Core Version:    0.7.0.1
 */