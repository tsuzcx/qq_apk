package me.ele.uetool.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.Provider;

class FragmentListTreeDialog$TreeItemVH$1
  implements View.OnClickListener
{
  FragmentListTreeDialog$TreeItemVH$1(FragmentListTreeDialog.TreeItemVH paramTreeItemVH, FragmentListTreeDialog.TreeItem paramTreeItem) {}
  
  public void onClick(View paramView)
  {
    if (FragmentListTreeDialog.TreeItemVH.access$100(this.this$0) != null) {
      FragmentListTreeDialog.TreeItemVH.access$100(this.this$0).onClickTreeItem(this.val$value.rectF);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.dialog.FragmentListTreeDialog.TreeItemVH.1
 * JD-Core Version:    0.7.0.1
 */