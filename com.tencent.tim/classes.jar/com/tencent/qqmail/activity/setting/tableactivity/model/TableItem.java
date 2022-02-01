package com.tencent.qqmail.activity.setting.tableactivity.model;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;

public class TableItem
{
  private int level;
  private int resid = 0;
  private UITableItemView tableItemView;
  private String title;
  
  public TableItem(int paramInt1, int paramInt2)
  {
    this.resid = paramInt1;
    this.level = paramInt2;
  }
  
  public TableItem(String paramString, int paramInt)
  {
    this.title = paramString;
    this.level = paramInt;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public int getResid()
  {
    return this.resid;
  }
  
  public UITableItemView getTableItemView()
  {
    return this.tableItemView;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTableItemView(UITableItemView paramUITableItemView)
  {
    this.tableItemView = paramUITableItemView;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.model.TableItem
 * JD-Core Version:    0.7.0.1
 */