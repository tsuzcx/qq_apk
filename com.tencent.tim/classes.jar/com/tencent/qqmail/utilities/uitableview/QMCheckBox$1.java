package com.tencent.qqmail.utilities.uitableview;

import java.util.List;

class QMCheckBox$1
  implements UITableView.ClickListener
{
  QMCheckBox$1(QMCheckBox paramQMCheckBox) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramInt = ((Integer)paramUITableItemView.getTag()).intValue();
    if (QMCheckBox.access$000(this.this$0) != null) {
      QMCheckBox.access$000(this.this$0).onCheckedChanged(this.this$0, paramInt);
    }
    QMCheckBox.access$102(this.this$0, true);
    if (QMCheckBox.access$200(this.this$0).indexOf(Integer.valueOf(paramInt)) == -1)
    {
      this.this$0.addSelectedItem(paramInt);
      return;
    }
    this.this$0.deleteSelectedItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.QMCheckBox.1
 * JD-Core Version:    0.7.0.1
 */