package com.tencent.qqmail.activity.setting.tableactivity.model;

public class CheckBoxTableItem
  extends TableItem
{
  private boolean mIsChecked;
  
  public CheckBoxTableItem(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt1, paramInt2);
    this.mIsChecked = paramBoolean;
  }
  
  public boolean isChecked()
  {
    return this.mIsChecked;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.model.CheckBoxTableItem
 * JD-Core Version:    0.7.0.1
 */