package com.tencent.qqmail.ftn.activity;

import android.view.View;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import com.tencent.qqmail.utilities.ui.QMFtnUploadNotification;
import java.util.concurrent.atomic.AtomicBoolean;

class FtnListActivity$29
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  FtnListActivity$29(FtnListActivity paramFtnListActivity, AtomicBoolean paramAtomicBoolean) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    this.val$isClickItem.set(true);
    if (paramString.equals(this.this$0.getString(2131692498)))
    {
      paramView = FtnListActivity.access$900(this.this$0).getCurrentFtnUploadInfo();
      if (paramView != null)
      {
        FtnListActivity.access$900(this.this$0).removeUploadItemData(FtnListActivity.access$900(this.this$0).getUploadItemList(), paramView, false);
        FtnListActivity.access$500(this.this$0).abortAndRemoveRequest(paramView.getFid());
        FtnListActivity.access$3300(this.this$0, paramView);
      }
      paramQMBottomDialog.cancel();
    }
    do
    {
      return;
      View localView;
      if (paramString.equals(this.this$0.getString(2131696736)))
      {
        paramView = FtnListActivity.access$900(this.this$0).getCurrentFtnUploadInfo();
        paramString = paramView.getFid();
        localView = FtnListActivity.access$900(this.this$0).getUploadItemView(paramView);
        if (FtnListActivity.access$2800(this.this$0))
        {
          paramView.setState(3);
          FtnListActivity.access$900(this.this$0).setUploadViewHolderState(localView, 3);
          FtnListActivity.access$900(this.this$0).changeUploadItemViewState(localView, 3);
          FtnListActivity.access$500(this.this$0).abortRequest(paramString);
          this.this$0.updateRealPause(paramString, true);
        }
        for (;;)
        {
          paramQMBottomDialog.cancel();
          return;
          paramView.setState(4);
          FtnListActivity.access$900(this.this$0).setUploadViewHolderState(localView, 4);
          FtnListActivity.access$900(this.this$0).changeUploadItemViewState(localView, 4);
        }
      }
      if (paramString.equals(this.this$0.getString(2131718842)))
      {
        paramView = FtnListActivity.access$900(this.this$0).getCurrentFtnUploadInfo();
        paramString = paramView.getFid();
        localView = FtnListActivity.access$900(this.this$0).getVisibleView(paramView);
        if (FtnListActivity.access$2800(this.this$0))
        {
          paramView.setState(2);
          FtnListActivity.access$900(this.this$0).setUploadViewHolderState(localView, 2);
          FtnListActivity.access$900(this.this$0).changeUploadItemViewState(localView, 2);
          if (FtnListActivity.access$900(this.this$0).isUnFinishUploadFile(paramView)) {
            if ((paramView.getStage() == 0) || (paramView.getStage() == 1))
            {
              paramView.setState(1);
              FtnListActivity.access$500(this.this$0).signFile(paramView);
              FtnListActivity.access$900(this.this$0).changeUploadItemViewState(paramView);
              QMFtnUploadNotification.getInstance().clearErrorNotification();
              this.this$0.updateRealPause(paramString, false);
            }
          }
        }
        for (;;)
        {
          paramQMBottomDialog.cancel();
          return;
          FtnListActivity.access$500(this.this$0).uploadFile(paramView, paramView.getIp(), paramView.getPort(), paramView.getKey(), paramView.getShakey());
          this.this$0.setCreateFileParam(paramView, paramView.getIp(), paramView.getPort(), paramView.getKey(), paramView.getShakey(), true);
          FtnListActivity.access$900(this.this$0).changeUploadItemViewState(paramView);
          break;
          FtnListActivity.access$500(this.this$0).goOnRequest(paramString);
          break;
          paramView.setState(4);
          FtnListActivity.access$900(this.this$0).setUploadViewHolderState(localView, 4);
          FtnListActivity.access$900(this.this$0).changeUploadItemViewState(localView, 4);
        }
      }
    } while (!paramString.equals(this.this$0.getString(2131718843)));
    paramView = FtnListActivity.access$900(this.this$0).getCurrentFtnUploadInfo();
    if (paramView != null)
    {
      if (!FtnListActivity.access$2800(this.this$0)) {
        break label637;
      }
      if (!paramView.isCreateFile()) {
        break label618;
      }
      paramView.setState(2);
      FtnListActivity.access$500(this.this$0).uploadFile(paramView, paramView.getIp(), paramView.getPort(), paramView.getKey(), paramView.getShakey());
      FtnListActivity.access$900(this.this$0).changeUploadItemViewState(paramView);
    }
    for (;;)
    {
      paramQMBottomDialog.cancel();
      return;
      label618:
      paramView.setState(1);
      FtnListActivity.access$500(this.this$0).signFile(paramView);
      break;
      label637:
      paramView.setState(4);
      FtnListActivity.access$900(this.this$0).setUploadViewHolderState(FtnListActivity.access$900(this.this$0).getUploadItemView(paramView), 4);
      FtnListActivity.access$900(this.this$0).changeUploadItemViewState(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.29
 * JD-Core Version:    0.7.0.1
 */