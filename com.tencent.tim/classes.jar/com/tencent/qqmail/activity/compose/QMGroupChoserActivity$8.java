package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.UITableView;

class QMGroupChoserActivity$8
  implements Runnable
{
  QMGroupChoserActivity$8(QMGroupChoserActivity paramQMGroupChoserActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if (QMGroupChoserActivity.access$900(this.this$0) != null)
    {
      if (!this.val$bool) {
        break label58;
      }
      QMGroupChoserActivity.access$900(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      if (QMGroupChoserActivity.access$800(this.this$0) != null)
      {
        if (!this.val$bool) {
          break;
        }
        QMGroupChoserActivity.access$800(this.this$0).setVisibility(8);
      }
      return;
      label58:
      QMGroupChoserActivity.access$900(this.this$0).setVisibility(8);
    }
    QMGroupChoserActivity.access$800(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMGroupChoserActivity.8
 * JD-Core Version:    0.7.0.1
 */