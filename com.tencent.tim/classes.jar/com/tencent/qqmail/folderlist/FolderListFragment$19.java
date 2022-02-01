package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.animation.AdvertiseAnimUtil;
import com.tencent.qqmail.utilities.ui.PtrListView.OnRefreshListener;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMAdvertiseView;
import com.tencent.qqmail.view.QMBaseView;

class FolderListFragment$19
  extends PtrListView.OnRefreshListener
{
  FolderListFragment$19(FolderListFragment paramFolderListFragment) {}
  
  public void onPopulate()
  {
    super.onPopulate();
    FolderListFragment.access$3900(this.this$0).getAdvertiseView().setExitListener(new FolderListFragment.19.1(this));
    AdvertiseAnimUtil.showAdvertiseView(this.this$0.getActivity(), FolderListFragment.access$3900(this.this$0).getAdvertiseView(), FolderListFragment.access$000(this.this$0));
    QMUIKit.disableOrientationChange(this.this$0.getActivity());
  }
  
  public void onRefresh()
  {
    FolderListFragment.access$2200(this.this$0).sync(FolderListFragment.access$200(this.this$0));
    DataCollector.logEvent("Event_Pull_To_Refresh_MailBox");
    DataCollector.logPerformanceBegin("Performance_Check_New_Mail_FolderList", FolderListFragment.access$200(this.this$0), "Performance_Check_New_Mail_FolderList_folderlist_" + FolderListFragment.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.19
 * JD-Core Version:    0.7.0.1
 */