package com.tencent.qqmail.activity.compose;

import android.view.View;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ComposeMailActivity$72
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ComposeMailActivity$72(ComposeMailActivity paramComposeMailActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.val$lowTitle))
    {
      paramQMBottomDialog.dismiss();
      DataCollector.logEvent("Event_Compose_Compress_Img_Low");
      this.this$0.composeMail.setImageScale(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Low);
      this.this$0.compressDone();
    }
    do
    {
      return;
      if (paramString.equals(this.val$middleTitle))
      {
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Compose_Compress_Img_Medium");
        this.this$0.composeMail.setImageScale(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Middle);
        this.this$0.compressDone();
        return;
      }
      if (paramString.equals(this.val$highTitle))
      {
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Compose_Compress_Img_High");
        this.this$0.composeMail.setImageScale(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_High);
        this.this$0.compressDone();
        return;
      }
      if (paramString.equals(this.val$realTitle))
      {
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Compose_Compress_Img_Origin");
        this.this$0.composeMail.setImageScale(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin);
        this.this$0.compressDone();
        return;
      }
    } while (!paramString.equals(this.val$cancelTitle));
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.72
 * JD-Core Version:    0.7.0.1
 */