package com.tencent.qqmail.activity.webviewexplorer;

import android.view.View;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class InlineImageSaver$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  InlineImageSaver$1(InlineImageSaver paramInlineImageSaver) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(InlineImageSaver.access$000(this.this$0, 2131718960)))
    {
      InlineImageSaver.access$300(this.this$0, InlineImageSaver.access$100(this.this$0), InlineImageSaver.access$200(this.this$0));
      if (InlineImageSaver.access$400(this.this$0) != null) {
        InlineImageSaver.access$400(this.this$0).onCompleteSaved();
      }
      QMLog.log(4, InlineImageSaver.access$500(this.this$0), "Inline-image-save onclick save");
      paramQMBottomDialog.dismiss();
    }
    do
    {
      return;
      if (paramString.equals(InlineImageSaver.access$000(this.this$0, 2131718921)))
      {
        InlineImageSaver.access$600(this.this$0);
        if (InlineImageSaver.access$400(this.this$0) != null) {
          InlineImageSaver.access$400(this.this$0).onCompleteSaved();
        }
        QMLog.log(4, InlineImageSaver.access$500(this.this$0), "Inline-image-save onclick save-all");
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(InlineImageSaver.access$000(this.this$0, 2131692328)))
      {
        InlineImageSaver.access$800(this.this$0, InlineImageSaver.access$700(this.this$0));
        paramQMBottomDialog.dismiss();
        QMLog.log(4, InlineImageSaver.access$500(this.this$0), "Inline-image-save onclick copy-link");
        return;
      }
    } while (!paramString.equals(InlineImageSaver.access$000(this.this$0, 2131696657)));
    InlineImageSaver.access$900(this.this$0, InlineImageSaver.access$700(this.this$0));
    paramQMBottomDialog.dismiss();
    QMLog.log(4, InlineImageSaver.access$500(this.this$0), "Inline-image-save onclick open-link");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.InlineImageSaver.1
 * JD-Core Version:    0.7.0.1
 */