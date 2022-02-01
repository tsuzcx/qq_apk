package com.tencent.qqmail.utilities.uitableview;

class QMRadioGroup$1
  implements UITableView.ClickListener
{
  QMRadioGroup$1(QMRadioGroup paramQMRadioGroup) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramInt = ((Integer)paramUITableItemView.getTag()).intValue();
    if (paramInt != QMRadioGroup.access$000(this.this$0))
    {
      if (QMRadioGroup.access$100(this.this$0) != null) {
        QMRadioGroup.access$100(this.this$0).onCheckedChanged(this.this$0, paramInt);
      }
      QMRadioGroup.access$202(this.this$0, true);
      this.this$0.setSelectedItem(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.QMRadioGroup.1
 * JD-Core Version:    0.7.0.1
 */