package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class BottleListFragment$12
  implements View.OnClickListener
{
  BottleListFragment$12(BottleListFragment paramBottleListFragment) {}
  
  public void onClick(View paramView)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(this.this$0.getString(2131690965))).setMessage(2131690964).addAction(2131691246, new BottleListFragment.12.2(this))).addAction(0, 2131690961, 2, new BottleListFragment.12.1(this))).create().show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.12
 * JD-Core Version:    0.7.0.1
 */