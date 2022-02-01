package com.tencent.qqmail.ftn.activity;

import android.content.Intent;
import android.view.View;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.model.media.QMAlbumManager;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class FtnListActivity$31
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  FtnListActivity$31(FtnListActivity paramFtnListActivity) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131691239)))
    {
      paramQMBottomDialog.dismiss();
      FtnListActivity.access$5800(this.this$0);
    }
    do
    {
      return;
      if (paramString.equals(this.this$0.getString(2131691491)))
      {
        QMAlbumManager.shareInstance().startAlbum(this.this$0, QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FTN);
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(this.this$0.getString(2131693505)))
      {
        paramQMBottomDialog.dismiss();
        paramQMBottomDialog = new Intent(this.this$0.getActivity(), SdcardFileExplorer.class);
        paramQMBottomDialog.putExtra("intentType", QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FTN.toString());
        paramQMBottomDialog.putExtra("multiChoose", true);
        this.this$0.startActivityForResult(paramQMBottomDialog, 5);
        return;
      }
    } while (!paramString.equals(this.this$0.getString(2131690614)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.31
 * JD-Core Version:    0.7.0.1
 */